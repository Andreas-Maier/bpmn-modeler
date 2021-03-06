package org.camunda.bpm.modeler.ui.property.tabs;

import java.util.List;

import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.ui.property.tabs.builder.BoundaryEventDefinitionComposite;
import org.camunda.bpm.modeler.ui.property.tabs.builder.CompensateEventDefinitionPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ConditionalEventDefinitionPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ErrorDefinitionPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.IdPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.MessageDefinitionPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.NamePropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.SignalDefinitionPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.TimerEventDefinitionPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.util.HelpText;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.CompensateEventDefinition;
import org.eclipse.bpmn2.ConditionalEventDefinition;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.Event;
import org.eclipse.bpmn2.EventDefinition;
import org.eclipse.bpmn2.IntermediateThrowEvent;
import org.eclipse.bpmn2.LinkEventDefinition;
import org.eclipse.bpmn2.MessageEventDefinition;
import org.eclipse.bpmn2.SignalEventDefinition;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.TimerEventDefinition;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Event tab composite factory
 * 
 * @author nico.rehwaldt
 */
public class EventTabCompositeFactory extends AbstractTabCompositeFactory<Event> {
	
	public EventTabCompositeFactory(final GFPropertySection section, final Composite parent) {
		super(section, parent);
	}
	
	@Override
	public Composite createCompositeForBusinessObject(final Event event) {
		
		List<EventDefinition> eventDefinitions = ModelUtil.getEventDefinitions(event);

		ErrorEventDefinition errorDef = getEventDefinition(ErrorEventDefinition.class, eventDefinitions);
		MessageEventDefinition messageDef = getEventDefinition(MessageEventDefinition.class, eventDefinitions);
		TimerEventDefinition timerDef = getEventDefinition(TimerEventDefinition.class, eventDefinitions);
		SignalEventDefinition signalDef = getEventDefinition(SignalEventDefinition.class, eventDefinitions);
		LinkEventDefinition linkDef = getEventDefinition(LinkEventDefinition.class, eventDefinitions);
		CompensateEventDefinition compensateDef = getEventDefinition(CompensateEventDefinition.class, eventDefinitions);
		ConditionalEventDefinition conditionalDef = getEventDefinition(ConditionalEventDefinition.class, eventDefinitions);
		
		if (errorDef == null && event instanceof StartEvent) {
			PropertyUtil.createText(section, parent, "Initiator", ModelPackage.eINSTANCE.getDocumentRoot_Initiator(), event);
		}
		
		if (timerDef != null) {
			createTimerDefinitionComposite(timerDef);
		}
		
		if (messageDef != null) {
			createMessageDefinitionComposite(messageDef);
		}

		if (errorDef != null) {
			createErrorDefinitionComposite(errorDef);
		}
		
		if (signalDef != null) {
			createSignalDefinitionComposite(signalDef);
		}

		if (linkDef != null) {
			createLinkDefinitionComposite(linkDef);
		}

		if (compensateDef != null && (event instanceof IntermediateThrowEvent)) {
			createCompensateDefinitionComposite(compensateDef);
		}
		
		if (conditionalDef != null) {
			createConditionalDefinitionComposite(conditionalDef);
		}

		if (event instanceof BoundaryEvent) {
			createBoundaryEventComposite((BoundaryEvent) event);
		}
		return parent;
	}

	private void createBoundaryEventComposite(final BoundaryEvent event) {
		new BoundaryEventDefinitionComposite(parent, section, event).create();
	}

	private <T extends EventDefinition> T getEventDefinition(final Class<T> cls, final List<EventDefinition> eventDefinitions) {
		for (EventDefinition eventDefinition : eventDefinitions) {
			if (cls.isInstance(eventDefinition)) {
				return cls.cast(eventDefinition);
			}
		}
		
		return null;
	}

	private void createSignalDefinitionComposite(final SignalEventDefinition signalDef) {
		new SignalDefinitionPropertyBuilder(parent, section, signalDef).create();
	}
	
	private void createErrorDefinitionComposite(final ErrorEventDefinition errorDef) {
		new ErrorDefinitionPropertyBuilder(parent, section, errorDef).create();
	}
	
	private void createTimerDefinitionComposite(final TimerEventDefinition eventDefinition) {
		new TimerEventDefinitionPropertiesBuilder(parent, section, eventDefinition).create();
	}
	
	private void createMessageDefinitionComposite(final MessageEventDefinition messageDef) {
		new MessageDefinitionPropertyBuilder(parent, section, messageDef).create();
	}

	private void createLinkDefinitionComposite(final LinkEventDefinition linkDef) {
		new IdPropertyBuilder(parent, section, linkDef, "Link Id").create();
		new NamePropertyBuilder(parent, section, linkDef, "Link Name", HelpText.LINK_EVENT_DEFINITION_NAME).create();
	}

	private void createCompensateDefinitionComposite(final CompensateEventDefinition compensateDef) {
		new IdPropertyBuilder(parent, section, compensateDef).create();
		new CompensateEventDefinitionPropertiesBuilder(parent, section, compensateDef).create();
	}
	
	private void createConditionalDefinitionComposite(final ConditionalEventDefinition conditionalDef) {
		new ConditionalEventDefinitionPropertiesBuilder(parent, section, conditionalDef).create();
	}
}
