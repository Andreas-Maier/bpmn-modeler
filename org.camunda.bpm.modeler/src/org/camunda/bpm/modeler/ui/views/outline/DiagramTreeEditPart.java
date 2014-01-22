package org.camunda.bpm.modeler.ui.views.outline;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.di.BPMNDiagram;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class DiagramTreeEditPart extends AbstractGraphicsTreeEditPart {

	List<Diagram> diagrams;
	int id;
	
	public DiagramTreeEditPart(final int id, final Diagram diagram) {
		super(null, diagram);
		setDiagramEditPart(this);
		this.id = id;
	}

	public Diagram getDiagram() {
		return (Diagram) getBpmnModel();
	}

	public List<Diagram> getAllDiagrams() {
		if (diagrams==null)
			diagrams = new ArrayList<Diagram>();
		return diagrams;
	}
	
	// ======================= overwriteable behaviour ========================

	@Override
	protected void createEditPolicies() {
	}

	/**
	 * Returns the children of this EditPart.
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	protected List<Object> getModelChildren() {
		List<Object> retList = new ArrayList<Object>();
		Diagram diagram = getDiagram();
		BPMNDiagram bpmnDiagram = getLinkedBPMNDiagram(diagram);
		if (bpmnDiagram!=null) {
			Definitions definitions = (Definitions)bpmnDiagram.eContainer();
			// build a list of all Graphiti Diagrams - these will be needed by other
			// TreeEditParts to map the business objects to PictogramElements
//			ResourceSet resourceSet = diagram.eResource().getResourceSet();
//			for (BPMNDiagram bd : definitions.getDiagrams()) {
//				getAllDiagrams().add( DIUtils.findDiagram(resourceSet, bd) );
//			}
		}		
		return retList;
	}

	private BPMNDiagram getLinkedBPMNDiagram(final Diagram diagram) {
		return BusinessObjectUtil.getFirstElementOfType(getDiagram(), BPMNDiagram.class);
	}

	@Override
	protected String getText() {
		BPMNDiagram bpmnDiagram = getLinkedBPMNDiagram(getDiagram());
		
		if (bpmnDiagram!=null && bpmnDiagram.getName()!=null)
			return bpmnDiagram.getName();
		return "";
		
	}
}