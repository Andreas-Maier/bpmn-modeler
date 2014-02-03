package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.List;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.ui.property.tabs.binding.BaseElementIdComboBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.change.EAttributeChangeSupport;
import org.camunda.bpm.modeler.ui.property.tabs.binding.change.EObjectChangeSupport.ModelChangedEvent;
import org.camunda.bpm.modeler.ui.property.tabs.util.Events;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ExclusiveGateway;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.InclusiveGateway;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * Decision gateway specific stuff
 * 
 * @author nico.rehwaldt
 */
public class DecisionGatewayPropertiesBuilder extends AbstractPropertiesBuilder<Gateway> {

	private static final EStructuralFeature FLOW_NODE_OUTGOING = Bpmn2Package.eINSTANCE.getFlowNode_Outgoing();
	
	private final EStructuralFeature DEFAULT_FLOW_FEATURE;
	
	public DecisionGatewayPropertiesBuilder(final Composite parent, final GFPropertySection section, final Gateway bo) {
		super(parent, section, bo);
		
		if (bo instanceof ExclusiveGateway) {
			DEFAULT_FLOW_FEATURE = Bpmn2Package.eINSTANCE.getExclusiveGateway_Default();
		} else 
		if (bo instanceof InclusiveGateway) {
			DEFAULT_FLOW_FEATURE = Bpmn2Package.eINSTANCE.getInclusiveGateway_Default();
		} else {
			throw new IllegalArgumentException(Messages.DecisionGatewayPropertiesBuilder_0 + bo);
		}
	}

	@Override
	public void create() {
		final CCombo dropDown = PropertyUtil.createDropDown(section, parent, Messages.DecisionGatewayPropertiesBuilder_1);
		
		// register change support
		EAttributeChangeSupport.ensureAdded(bo, FLOW_NODE_OUTGOING, dropDown);
		
		dropDown.addListener(Events.MODEL_CHANGED, new Listener() {
			
			@Override
			public void handleEvent(final Event e) {
				ModelChangedEvent event = (ModelChangedEvent) e;
				if (FLOW_NODE_OUTGOING.equals(event.getFeature())) {
					updateDropdownLabels(dropDown);
				}
			}
		});
		
		BaseElementIdComboBinding<SequenceFlow> dropDownBinding = new BaseElementIdComboBinding<SequenceFlow>(bo, DEFAULT_FLOW_FEATURE, dropDown) {
			@Override
			protected SequenceFlow getModelById(final String id) {
				return getSequenceFlowById(id);
			}
		};
		
		dropDownBinding.establish();
		
		updateDropdownLabels(dropDown);
		
		if (bo instanceof ExclusiveGateway) {
			PropertyUtil.createCheckbox(section, parent, Messages.DecisionGatewayPropertiesBuilder_2, CasOpenPackage.eINSTANCE.getDocumentRoot_IsUserInteractable(), bo);
		}
	}
	
	/**
	 * Returns the sequence flow with the given id
	 * in the context of this factory
	 * 
	 * @param id
	 * @return
	 */
	private SequenceFlow getSequenceFlowById(final String id) {
		List<SequenceFlow> flows = getSequenceFlows();
		for (SequenceFlow outgoing: flows) {
			String nodeId = outgoing.getId();
			if (nodeId.equals(id)) {
				return outgoing;
			}
		}
		
		return null;
	}

	private List<SequenceFlow> getSequenceFlows() {
		return (List<SequenceFlow>) bo.eGet(FLOW_NODE_OUTGOING);
	}
	
	private void updateDropdownLabels(final CCombo dropDown) {
		
		// We need to avoid that the combo box fires a SWT.Modify event 
		// while updating the drop down labels.
		
		// Doing so, we remove all drop down element one by one
		for (String s: dropDown.getItems()) {
			dropDown.remove(s);
		}
		
		List<SequenceFlow> flows = getSequenceFlows();
		
		EObject defaultFlow = (EObject) bo.eGet(DEFAULT_FLOW_FEATURE);
		
		dropDown.add(""); //$NON-NLS-1$
		
		for (SequenceFlow outgoing: flows) {
			String nodeId = outgoing.getId();
			dropDown.add(nodeId);
			
			if (outgoing.equals(defaultFlow)) {
				dropDown.select(dropDown.indexOf(nodeId));
			}
		}
	}
}
