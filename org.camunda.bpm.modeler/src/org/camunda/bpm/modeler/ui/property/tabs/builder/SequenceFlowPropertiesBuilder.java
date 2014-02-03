package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.ui.property.tabs.radio.Radio.RadioGroup;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class SequenceFlowPropertiesBuilder extends
		AbstractExtensionAwarePropertiesBuilder {

	private static final String[] TYPE_NAMES = new String[] {
			Messages.SequenceFlowPropertiesBuilder_0, Messages.SequenceFlowPropertiesBuilder_1 };

	private static final EStructuralFeature CONDITION_EXPRESSION_FEATURE = Bpmn2Package.eINSTANCE
			.getSequenceFlow_ConditionExpression();

	private final RadioGroup<EStructuralFeature> radioGroup;
	
	private Button userRadio;
	private Text userControl;
	private Button serviceRadio;
	private Text serviceControl;
	private Button serviceConfigurationButton;

	public SequenceFlowPropertiesBuilder(final Composite parent,
			final GFPropertySection section, final SequenceFlow bo) {
		super(parent, section, bo);

		this.radioGroup = new RadioGroup<EStructuralFeature>();
	}

	@Override
	public void create() {

		userControl = PropertyUtil.createRadioText(section, parent, TYPE_NAMES[0], CONDITION_EXPRESSION_FEATURE, radioGroup, bo);
		PropertyUtil.createToolTipFor(userControl, Messages.SequenceFlowPropertiesBuilder_2);
		userControl.setEnabled(false);
		for (Control control : userControl.getParent().getChildren()) {
			if (control instanceof Button) {
				userRadio = (Button) control;
				userRadio.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(final SelectionEvent e) {
						userControl.setEnabled(userRadio.getSelection());
						serviceConfigurationButton.setEnabled(!userRadio.getSelection());
						serviceRadio.setSelection(!userRadio.getSelection());
					}
					
					@Override
					public void widgetDefaultSelected(final SelectionEvent e) {
					}
				});
			}
		}
		
		serviceControl = PropertyUtil.createUnboundRadioText(section, parent, TYPE_NAMES[1], CONDITION_EXPRESSION_FEATURE, radioGroup);
		serviceControl.setEnabled(false);
		PropertyUtil.createToolTipFor(serviceControl, Messages.SequenceFlowPropertiesBuilder_3);
		for (Control control : serviceControl.getParent().getChildren()) {
			if (control instanceof Button) {
				serviceRadio = (Button) control;
				serviceRadio.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(final SelectionEvent e) {
						serviceConfigurationButton.setEnabled(serviceRadio.getSelection());
						userControl.setEnabled(!serviceRadio.getSelection());
						userRadio.setSelection(!serviceRadio.getSelection());
					}
					
					@Override
					public void widgetDefaultSelected(final SelectionEvent e) {
					}
				});
			}
		}
		serviceConfigurationButton = addConfigureOperationButton(serviceControl, Messages.SequenceFlowPropertiesBuilder_4);
		serviceConfigurationButton.setEnabled(false);
		final FormData layoutData = new FormData();
		layoutData.left = new FormAttachment(serviceControl, 122, SWT.BOTTOM);
		serviceConfigurationButton.setLayoutData(layoutData);
		serviceConfigurationButton.setToolTipText(Messages.SequenceFlowPropertiesBuilder_5);
	}

}
