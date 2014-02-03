package org.camunda.bpm.modeler.core;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Implementation of {@link IPerspectiveFactory} that creates the BPMN-Perspective and creates the layout of the views.
 * 
 * @author Andreas.Maier
 *
 */
public class PerspectiveFactory implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(final IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		// Nav is left of editor
		layout.addView("de.cas.open.prozesse.modeler.client.navigator.ProcessNavigator", IPageLayout.LEFT, 0.25f, editorArea);
		// Outline is under Nav
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.BOTTOM, 0.6f, "de.cas.open.prozesse.modeler.client.navigator.ProcessNavigator");
		// Prop and Problem View is under the editor in a folder layout.
		IFolderLayout bottomFolder = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.6f, editorArea);
		bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
		bottomFolder.addView(IPageLayout.ID_PROBLEM_VIEW);
	}
}
