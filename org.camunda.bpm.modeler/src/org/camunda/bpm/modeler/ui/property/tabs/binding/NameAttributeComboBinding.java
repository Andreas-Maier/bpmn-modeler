package org.camunda.bpm.modeler.ui.property.tabs.binding;

import org.eclipse.bpmn2.FlowNode;
import org.eclipse.bpmn2.Lane;
import org.eclipse.bpmn2.Participant;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.custom.CCombo;

public class NameAttributeComboBinding extends ModelAttributeComboBinding<String> {

	public NameAttributeComboBinding(final EObject model, final EStructuralFeature feature,
			final CCombo control) {
		super(model, feature, control);
	}

	@Override
	public void setModelValue(final String value) {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(model);
		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						model.eSet(feature, value);
					}
				});
	}
	
	@Override
	public String getModelValue() {
		if (model instanceof Lane) {
			return ((Lane)model).getName();
		} else if (model instanceof Participant) {
			return ((Participant)model).getName();
		} 
		return ((FlowNode)model).getName();
	}
	
	@Override
	protected String toString(final String value) {
		return value;
	}
	
	@Override
	protected String fromString(final String string) {
		return string;
	}
	
}
