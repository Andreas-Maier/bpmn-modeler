package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Task;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class AdvancedServiceTaskPropertiesBuilder extends AbstractExtensionAwarePropertiesBuilder {

	public AdvancedServiceTaskPropertiesBuilder(final Composite parent, final GFPropertySection section, final Task bo) {
		super(parent, section, bo);
	}
	
	@Override
	public void create() {
		final Text text = PropertyUtil.createUnboundText(section, parent, "Service Operation");
		
		addConfigureOperationButton(text, "Configure Service Operation");
		text.setEnabled(false);
	}
}
