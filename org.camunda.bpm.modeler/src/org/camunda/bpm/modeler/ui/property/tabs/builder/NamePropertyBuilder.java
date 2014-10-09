package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.ui.property.tabs.binding.NameAttributeComboBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.StringTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.CallableElement;
import org.eclipse.bpmn2.Collaboration;
import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.Lane;
import org.eclipse.bpmn2.LinkEventDefinition;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.MessageFlow;
import org.eclipse.bpmn2.Participant;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import de.cas.open.prozesse.modeler.server.eimInterface.EIMInterfaceHolder;
import de.cas.open.prozesse.modeler.server.exceptions.ServerException;
import de.cas.open.server.api.exceptions.BusinessException;
import de.cas.open.server.api.exceptions.DataLayerException;

/**
 * Builder for the name property
 * 
 * @author nico.rehwaldt
 */
public class NamePropertyBuilder extends AbstractPropertiesBuilder<BaseElement> {

	private static final int BOX_HEIGHT = 16;

	private EStructuralFeature NAME_FEATURE;
	
	private final String label;
	private String helpText;

	public NamePropertyBuilder(final Composite parent, final GFPropertySection section, final BaseElement bo, final String label, final String helpText) {
		this(parent, section, bo, label);

		this.helpText = helpText;
	}

	public NamePropertyBuilder(final Composite parent, final GFPropertySection section, final BaseElement bo, final String label) {
		super(parent, section, bo);
		
		this.label = label;

		if (bo instanceof FlowElement) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getFlowElement_Name();
		} else 
		if (bo instanceof Collaboration) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getCollaboration_Name();
		} else
		if (bo instanceof CallableElement) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getCallableElement_Name();
		} else
		if (bo instanceof Participant) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getParticipant_Name();
		} else 
		if (bo instanceof Lane) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getLane_Name();
		} else
		if (bo instanceof MessageFlow) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getMessageFlow_Name();
		} else
		if (bo instanceof LinkEventDefinition) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getLinkEventDefinition_Name();
		} else
		if (bo instanceof Message) {
			NAME_FEATURE = Bpmn2Package.eINSTANCE.getMessage_Name();
		} else {
			// Unsupported base element: Do nothing
		}
	}
	
	public NamePropertyBuilder(final Composite parent, final GFPropertySection section, final BaseElement bo) {
		this(parent, section, bo, "Name");
	}
	
	@Override
	public void create() {
		if (bo instanceof Lane) {
			createLaneNameCombo();
		} else if (bo instanceof Participant) {
			createParticipantNameCombo();
		} else if (bo instanceof Gateway) {
			createAutoResizingMultiText(section, parent, "Frage", NAME_FEATURE, bo);
		} else if (bo instanceof org.eclipse.bpmn2.Process) {
			Text text = PropertyUtil.createText(section, parent, label, NAME_FEATURE, bo);
			text.setEditable(false);
			text.setEnabled(false);
			String processName = bo.eResource().getURI().lastSegment();
			processName = processName.replace("." + bo.eResource().getURI().fileExtension(), "");
			text.setText(processName);
		} else if (NAME_FEATURE != null) {
			final Text multiText = createAutoResizingMultiText(section, parent, label, NAME_FEATURE, bo);
			if (helpText != null) {
				PropertyUtil.attachNoteWithLink(section, multiText, helpText);
			}
		}
	}

	private void createParticipantNameCombo() {
		CCombo participantNameCombo = PropertyUtil.createDropDown(section, parent, Messages.NamePropertyBuilder_1);
		// Add elements
		List<String> participantNames = new LinkedList<>();
		try {
			participantNames = EIMInterfaceHolder.getAllClients();
		} catch (DataLayerException | BusinessException | ServerException e) {
			MessageDialog.openError(parent.getShell(), Messages.NamePropertyBuilder_2, Messages.NamePropertyBuilder_3);
			return;
		}
		for (String userGroupName : participantNames) {
			if (!Strings.isNullOrEmpty(userGroupName)) {
				participantNameCombo.add(userGroupName);
			}
		}
		// Add binding
		NameAttributeComboBinding binding = new NameAttributeComboBinding(bo, NAME_FEATURE, participantNameCombo);

		binding.establish();
	}
	
	private void createLaneNameCombo() {
		CCombo laneNameCombo = PropertyUtil.createDropDown(section, parent, "Name");
		// Add elements
		BiMap<Integer,String> userGroups = HashBiMap.create();
		try {
			userGroups = EIMInterfaceHolder.getAllUserGroups();
		} catch (DataLayerException | BusinessException | ServerException e) {
			MessageDialog.openError(parent.getShell(), Messages.NamePropertyBuilder_5, Messages.NamePropertyBuilder_6);
			return;
		}
		Set<String> userGroupNames = userGroups.values();
		for (String userGroupName : userGroupNames) {
			if (!Strings.isNullOrEmpty(userGroupName)) {
				laneNameCombo.add(userGroupName);
			}
		}
		// Add binding
		NameAttributeComboBinding binding = new NameAttributeComboBinding(bo, NAME_FEATURE, laneNameCombo);

		binding.establish();
	}

	private Text createAutoResizingMultiText(final GFPropertySection section, final Composite parent, final String label,
			final EStructuralFeature feature, final BaseElement bo) {
		
		Composite composite = PropertyUtil.createStandardComposite(section, parent);
		TabbedPropertySheetWidgetFactory factory = section.getWidgetFactory();
		
		final Text multiText = factory.createText(composite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL); //$NON-NLS-1$

		final FormData data = PropertyUtil.getStandardLayout();

		data.height = BOX_HEIGHT;
		multiText.setLayoutData(data);

		PropertyUtil.createLabel(section, composite, label, multiText);
		
		ISWTObservableValue multiTextObservable = SWTObservables.observeText(multiText, SWT.Modify);
		multiTextObservable.addValueChangeListener(new IValueChangeListener() {
			
			@Override
			public void handleValueChange(final ValueChangeEvent event) {
				
				String text = (String) event.diff.getNewValue();
				int crCount = crCount(text);
				
				int newHeight = BOX_HEIGHT * (crCount + 1);
				if (newHeight != data.height) {
					data.height = newHeight;
					
					relayout();
				}
			}
		});

		StringTextBinding stringTextBinding = new StringTextBinding(bo, feature, multiText);
		stringTextBinding.establish();
		
		return multiText;
	}
	
	public int crCount(final String s) {
		int i = -1;
		int c = 0;
		
		do {
			i = s.indexOf(SWT.CR, i + 1);
			if (i != -1) {
				c++;
			}
			
		} while (i != -1);
		
		return c;
	}
}
