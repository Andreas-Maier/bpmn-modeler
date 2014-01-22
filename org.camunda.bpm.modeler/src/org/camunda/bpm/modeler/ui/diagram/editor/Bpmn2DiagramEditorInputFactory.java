package org.camunda.bpm.modeler.ui.diagram.editor;

import org.camunda.bpm.modeler.core.utils.ModelUtil.Bpmn2DiagramType;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.ui.wizards.Bpmn2DiagramCreator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.editor.DiagramEditorInputFactory;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

public class Bpmn2DiagramEditorInputFactory extends DiagramEditorInputFactory implements IElementFactory {

	public Bpmn2DiagramEditorInputFactory() {
		super();
	}
	
	@Override
	public IAdaptable createElement(final IMemento memento) {
		// get diagram URI
		final String diagramUriString = memento.getString(DiagramEditorInput.KEY_URI);
		if (diagramUriString == null) {
			return null;
		}
		// get diagram type provider id
		final String providerID = memento.getString(Bpmn2DiagramEditorInput.KEY_PROVIDER_ID);
		URI diagramUri = URI.createURI(diagramUriString);
		
		try {
			return Bpmn2DiagramCreator.createDiagramInput(diagramUri, Bpmn2DiagramType.COLLABORATION, ModelPackage.eNS_URI);
		} catch (CoreException e) {
			return super.createElement(memento);
		}
	}
}
