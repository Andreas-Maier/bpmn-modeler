package org.camunda.bpm.modeler.ui.views.outline;
/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *
 * </copyright>
 *
 *******************************************************************************/

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.SelectionSynchronizer;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.fixed.FixedScrollableThumbnail;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.part.PageBook;

/**
 * An outline page for the graphical modeling editor. It displays the contents
 * of the editor either as a hierarchical Outline or as a graphical Thumbnail.
 * There are buttons to switch between those displays. Subclasses should
 * overwrite this outline page (and dependent classes), to change the
 * default-behaviour.
 */
// The generic outline uses internal functionality of Graphiti. For concrete
// tool implementations this should not be necessary
@SuppressWarnings("restriction")
public class Bpmn2EditorOutlinePage extends ContentOutlinePage implements IPropertyListener {

	// The IDs to identify the outline and the thunbnail
	public static final int ID_THUMBNAIL = 2;

	// Common instances of different Editors/Views, to synchronize their
	// behaviour
	private final GraphicalViewer graphicalViewer;

	private final EditDomain editDomain;

	private final KeyHandler keyHandler;


	private final SelectionSynchronizer selectionSynchronizer;

	private final DiagramEditor diagramEditor;
	
	// The thumbnail to display
	private FixedScrollableThumbnail thumbnail;

	// The pagebook, which displays either the outline or the overview
	private PageBook pageBook;

	private Canvas overview;

	/**
	 * Creates a new BPMN2EditorOutlinePage. It is important, that this
	 * outline page uses the same handlers (ActionRegistry, KeyHandler,
	 * ZoomManagerAdapter, ...) as the main editor, so that the behaviour is
	 * synchronized between them.
	 * 
	 * @param diagramEditor
	 *            the attached diagram editor
	 * @since 0.9
	 */
	public Bpmn2EditorOutlinePage(final DiagramEditor diagramEditor) {
		super(new TreeViewer());
		graphicalViewer = diagramEditor.getGraphicalViewer();
		editDomain = diagramEditor.getEditDomain();
		keyHandler = (KeyHandler) diagramEditor.getAdapter(KeyHandler.class);
		selectionSynchronizer = (SelectionSynchronizer) diagramEditor.getAdapter(SelectionSynchronizer.class);
		this.diagramEditor = diagramEditor;
	}

	// ========================= standard behavior ===========================

	
	/**
	 * Creates the Control of this outline page. By default this is a PageBook,
	 * which can toggle between a hierarchical Outline and a graphical
	 * Thumbnail.
	 * 
	 * @param parent
	 *            the parent
	 * 
	 * @see org.eclipse.gef.ui.parts.ContentOutlinePage#createControl(Composite)
	 */
	@Override
	public void createControl(final Composite parent) {
		pageBook = new PageBook(parent, SWT.NONE);
		overview = new Canvas(pageBook, SWT.NONE);
		createOutlineViewer();

		// register listeners
		selectionSynchronizer.addViewer(getViewer());
		diagramEditor.addPropertyListener(this);
	}

	/**
	 * Deregisters all 'listeners' of the main-editor.
	 */
	@Override
	public void dispose() {
		// deregister listeners
		selectionSynchronizer.removeViewer(getViewer());
		diagramEditor.removePropertyListener(this);

		if (thumbnail != null)
			thumbnail.deactivate();

		super.dispose();
	}

	/**
	 * Returns the Control of this outline page, which was created in
	 * createControl().
	 * 
	 * @return the control
	 * 
	 * @see org.eclipse.gef.ui.parts.ContentOutlinePage#getControl()
	 */
	@Override
	public Control getControl() {
		return pageBook;
	}

	/**
	 * Refreshes the outline on any change of the diagram editor. Most
	 * importantly, there is a property change event editor-dirty.
	 */
	@Override
	public void propertyChanged(final Object source, final int propId) {
		refresh();
	}

	/**
	 * Toggles the page to display between hierarchical Outline and graphical
	 * Thumbnail.
	 * 
	 * @param id
	 *            The ID of the page to display. It must be either ID_BUSINESS_MODEL_OUTLINE or
	 *            ID_THUMBNAIL.
	 */
	protected void showPage(final int id) {
		if (thumbnail == null)
			createThumbnailViewer();
		pageBook.showPage(overview);
	}

	/**
	 * Creates the hierarchical Outline viewer.
	 */
	protected void createOutlineViewer() {
		// set the standard handlers
		getViewer().setEditDomain(editDomain);
		getViewer().setKeyHandler(keyHandler);

		// add a context-menu
		ContextMenuProvider contextMenuProvider = createContextMenuProvider();
		if (contextMenuProvider != null)
			getViewer().setContextMenu(contextMenuProvider);

		// by default show the outline-page
		showPage(ID_THUMBNAIL);
	}

	/**
	 * Returns a new ContextMenuProvider. Can be null, if no context-menu shall
	 * be displayed.
	 * 
	 * @return A new ContextMenuProvider.
	 */
	protected ContextMenuProvider createContextMenuProvider() {
		return null;
	}

	/**
	 * Creates the graphical Thumbnail viewer.
	 */
	protected void createThumbnailViewer() {
		LightweightSystem lws = new LightweightSystem(overview);
		ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) graphicalViewer.getRootEditPart();
		thumbnail = new FixedScrollableThumbnail((Viewport) rootEditPart.getFigure());
		thumbnail.setBorder(new MarginBorder(3));
		thumbnail.setSource(rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS));
		lws.setContents(thumbnail);
	}


	/**
	 * Refresh.
	 */
	void refresh() {
		final EditPartViewer viewer = getViewer();
		final EditPart contents = viewer.getContents();
		if (contents != null) {
			contents.refresh();
		}
	}
}