package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ConditionalEventDefinition;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

public class ConditionalEventDefinitionPropertiesBuilder extends AbstractPropertiesBuilder<ConditionalEventDefinition> {

	public ConditionalEventDefinitionPropertiesBuilder(final Composite parent,
			final GFPropertySection section, final ConditionalEventDefinition bo) {
		super(parent, section, bo);
	}

	@Override
	public void create() {
		PropertyUtil.createText(section, parent, Messages.ConditionalEventDefinitionPropertiesBuilder_0, Bpmn2Package.eINSTANCE.getConditionalEventDefinition_Condition(), bo);
		
	}

}
