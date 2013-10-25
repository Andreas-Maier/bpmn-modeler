package org.camunda.bpm.modeler.ui.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

public class BPMN2PersistencyBehavior extends DefaultPersistencyBehavior {

	BPMN2Editor editor;
	
	public BPMN2PersistencyBehavior(DiagramBehavior diagramBehavior) {
		super(diagramBehavior);
		editor = (BPMN2Editor)diagramBehavior.getDiagramContainer();
	}
    @Override
    public Diagram loadDiagram(URI modelUri) {
    	Diagram diagram = super.loadDiagram(modelUri);

    	return diagram;
    }
    
    @Override
	protected Map<Resource, Map<?, ?>> createSaveOptions() {
		// Save only resources that have actually changed.
		final Map<Object, Object> saveOption = new HashMap<Object, Object>();
		
		saveOption.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		
		// Use CDATA to escape characters like '<' etc.
		saveOption.put(XMLResource.OPTION_ESCAPE_USING_CDATA, Boolean.TRUE);
		
		EList<Resource> resources = editor.getEditingDomain().getResourceSet().getResources();
		final Map<Resource, Map<?, ?>> saveOptions = new HashMap<Resource, Map<?, ?>>();
		for (Resource resource : resources) {
			saveOptions.put(resource, saveOption);
		}
		return saveOptions;
	}

}
