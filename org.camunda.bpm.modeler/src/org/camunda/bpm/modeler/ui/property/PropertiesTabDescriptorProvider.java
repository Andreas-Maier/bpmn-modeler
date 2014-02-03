/*******************************************************************************
 * Copyright (c) 2011 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/
package org.camunda.bpm.modeler.ui.property;

import static org.camunda.bpm.modeler.core.utils.SelectionUtil.getSelectedBusinessObject;
import static org.camunda.bpm.modeler.core.utils.SelectionUtil.getSelectedModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.core.Activator;
import org.camunda.bpm.modeler.core.property.AbstractTabSection;
import org.camunda.bpm.modeler.core.property.SectionDescriptor;
import org.camunda.bpm.modeler.core.property.TabDescriptor;
import org.camunda.bpm.modeler.plugin.ICustomTaskProvider;
import org.camunda.bpm.modeler.ui.property.tabs.DefinitionsTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.DocumentTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.EventTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.FormFieldsTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.GeneralTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.ListenerTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.MultiInstanceTabSection;
import org.eclipse.bpmn2.Event;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;

public class PropertiesTabDescriptorProvider implements ITabDescriptorProvider {

	@Override
	public ITabDescriptor[] getTabDescriptors(final IWorkbenchPart part, final ISelection selection) {
		List<ITabDescriptor> tabs = new ArrayList<ITabDescriptor>();
		
		Object model = getSelectedModel(selection);
		EObject businessObject = getSelectedBusinessObject(model);
		
		if (businessObject != null) {
			tabs.add(createGeneralTabDescriptor());
			
			if (businessObject instanceof Event) {
				tabs.add(createEventTabDescriptor());
			}
			
			// add definitions tab for errors, messages and signals
//			if (model instanceof Diagram) {
//				tabs.add(createDefinitionsTabDescriptor());
//				tabs.add(createDocumentTabDescriptor());
//			}
			
			// add multi instance tabs to activities
//			if (businessObject instanceof Activity) {
//				tabs.add(createMultiInstanceTabDescriptor());
//			}
			
			// add execution listener tabs
//			if (businessObject instanceof Activity ||
//				businessObject instanceof Gateway ||
//				businessObject instanceof SequenceFlow || 
//				businessObject instanceof Event || 
//				businessObject instanceof Process) {
//				
//				tabs.add(createListenerTabDescriptor());
//			}
			
			// for participant, too
//			if (businessObject instanceof Participant) {
//				Participant participant = (Participant) businessObject;
//				
//				if (participant.getProcessRef() != null) {
//					tabs.add(createListenerTabDescriptor());
//				}
//			}

			// TODO: uncomment when camunda engine release exists to support this feature
//			if (businessObject instanceof UserTask ||
//			    businessObject instanceof StartEvent) {
//				tabs.add(createFormTabDescriptor());
//			}
			
			addCustomTabs(businessObject, tabs);
		}
		
		return tabs.toArray(new ITabDescriptor[]{});
	}

	private void addCustomTabs(final EObject businessObject, final List<ITabDescriptor> tabs) {
		
		for (ICustomTaskProvider provider: Activator.getExtensions().getCustomTaskProviders()) {
			if (provider.appliesTo(businessObject)) {
				ITabDescriptor tabDescriptor = provider.getTabDescriptor();
				if (tabDescriptor != null) {
					tabs.add(tabDescriptor);
				}
			}
		}
	}

	private ITabDescriptor createMultiInstanceTabDescriptor() {
		return createTabDescriptor("multiInstanceTab", Messages.PropertiesTabDescriptorProvider_1, new MultiInstanceTabSection()); //$NON-NLS-1$
	}

	private ITabDescriptor createEventTabDescriptor() {
		return createTabDescriptor("eventTab", Messages.PropertiesTabDescriptorProvider_3, new EventTabSection()); //$NON-NLS-1$
	}
	
	private ITabDescriptor createListenerTabDescriptor() {
		return createTabDescriptor("listenerTab", Messages.PropertiesTabDescriptorProvider_5, new ListenerTabSection()); //$NON-NLS-1$
	}

	private ITabDescriptor createGeneralTabDescriptor() {
		return createTabDescriptor("generalTab", Messages.PropertiesTabDescriptorProvider_7, new GeneralTabSection()); //$NON-NLS-1$
	}

	private ITabDescriptor createDefinitionsTabDescriptor() {
		return createTabDescriptor("definitionsTab", Messages.PropertiesTabDescriptorProvider_9, new DefinitionsTabSection()); //$NON-NLS-1$
	}

	private ITabDescriptor createDocumentTabDescriptor() {
		return createTabDescriptor("documentTab", Messages.PropertiesTabDescriptorProvider_11, new DocumentTabSection()); //$NON-NLS-1$
	}

	private ITabDescriptor createFormTabDescriptor() {
		return createTabDescriptor("formFieldsTab", Messages.PropertiesTabDescriptorProvider_13, new FormFieldsTabSection()); //$NON-NLS-1$
	}
	
	/**
	 * Create a new tab descriptor with the given id, label and holding 
	 * the specified tab section.
	 * 
	 * @param id
	 * @param name
	 * @param tabSection
	 * @return
	 */
	public static ITabDescriptor createTabDescriptor(final String id, final String name, final AbstractTabSection tabSection) {

		TabDescriptor tabDescriptor = new TabDescriptor(id, name, name);
		ISectionDescriptor sectionDescriptor = new SectionDescriptor(id + ".section", tabSection); //$NON-NLS-1$
		tabDescriptor.setSectionDescriptors(Arrays.asList(new ISectionDescriptor[] { sectionDescriptor }));
		
		return tabDescriptor;
	}
}
