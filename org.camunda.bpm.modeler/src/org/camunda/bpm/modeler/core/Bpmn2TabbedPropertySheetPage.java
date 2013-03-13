package org.camunda.bpm.modeler.core;

import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class Bpmn2TabbedPropertySheetPage extends TabbedPropertySheetPage {

	DiagramEditor diagramEditor;
	
	public Bpmn2TabbedPropertySheetPage(
			ITabbedPropertySheetPageContributor tabbedPropertySheetPageContributor) {
		super(tabbedPropertySheetPageContributor);
		diagramEditor = (DiagramEditor)tabbedPropertySheetPageContributor;
	}

	public DiagramEditor getDiagramEditor() {
		return diagramEditor;
	}
	
	@Override
	public void resizeScrolledComposite() {
		// TODO FIX SCROLL SPEED
		super.resizeScrolledComposite();
	}
}
