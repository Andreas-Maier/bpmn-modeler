package org.camunda.bpm.modeler.ui.property.tabs;

import org.eclipse.bpmn2.Definitions;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Definitions tab composite factory
 * 
 * @author nico.rehwaldt
 */
public class DefinitionsTabCompositeFactory extends AbstractTabCompositeFactory<Definitions> {
	
	public DefinitionsTabCompositeFactory(final GFPropertySection section, final Composite parent) {
		super(section, parent);
	}
	
	@Override
	public Composite createCompositeForBusinessObject(final Definitions definitions) {
//		new DefinitionsPropertiesBuilder(parent, section, definitions).create();

		return parent;
	}
}
