package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.List;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.camunda.bpm.modeler.ui.wizards.IOperationWizard;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.ExclusiveGateway;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.InclusiveGateway;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.cas.open.commons.util.GenericTupel;

/**
 * Decision gateway specific stuff
 * 
 * @author nico.rehwaldt
 */
public class DecisionGatewayPropertiesBuilder extends
		AbstractExtensionAwarePropertiesBuilder {

	Button checkbox;
	Boolean isUserInteractible;

	Text assigneeText;
	CLabel assigneeLabel;
	Button assigneeButton;
	Text candidateUsersText;
	CLabel candidateUsersLabel;
	Button candidateUsersButton;
	Text candidateGroupsText;
	CLabel candidateGroupsLabel;
	Button candidateGroupsButton;

	private static final EStructuralFeature FLOW_NODE_OUTGOING = Bpmn2Package.eINSTANCE
			.getFlowNode_Outgoing();

	private final EStructuralFeature DEFAULT_FLOW_FEATURE;

	public DecisionGatewayPropertiesBuilder(final Composite parent,
			final GFPropertySection section, final Gateway bo) {
		super(parent, section, bo);

		if (bo instanceof ExclusiveGateway) {
			DEFAULT_FLOW_FEATURE = Bpmn2Package.eINSTANCE
					.getExclusiveGateway_Default();
		} else if (bo instanceof InclusiveGateway) {
			DEFAULT_FLOW_FEATURE = Bpmn2Package.eINSTANCE
					.getInclusiveGateway_Default();
		} else {
			throw new IllegalArgumentException(
					Messages.DecisionGatewayPropertiesBuilder_0 + bo);
		}
	}

	@Override
	public void create() {
		if (bo instanceof ExclusiveGateway) {
			checkbox = PropertyUtil.createCheckbox(section, parent,
					Messages.DecisionGatewayPropertiesBuilder_2,
					CasOpenPackage.eINSTANCE
							.getDocumentRoot_IsUserInteractable(), bo);

			isUserInteractible = (Boolean) bo.eGet(CasOpenPackage.eINSTANCE
					.getDocumentRoot_IsUserInteractable());

			final GenericTupel<Text, CLabel> assignee = PropertyUtil
					.createTextAndLabel(section, parent, "Assignee",
							ModelPackage.eINSTANCE.getDocumentRoot_Assignee(),
							bo);
			assigneeText = assignee.getObjectOne();
			assigneeText.setEnabled(false);
			assigneeLabel = assignee.getObjectTwo();
			String type = "Assignee";
			IOperationWizard initWizard = initWizard(bo, type);
			assigneeButton = addConfigureOperationButton(assigneeText,
					Messages.Assignee, type, initWizard);
			assigneeButton.addSelectionListener(new WizardSelectionAdapter(
					initWizard, bo, assigneeText));

			final GenericTupel<Text, CLabel> candidateUsers = PropertyUtil
					.createTextAndLabel(section, parent, "Candidate Users",
							ModelPackage.eINSTANCE
									.getDocumentRoot_CandidateUsers(), bo);
			candidateUsersText = candidateUsers.getObjectOne();
			candidateUsersText.setEnabled(false);
			candidateUsersLabel = candidateUsers.getObjectTwo();
			type = "CandidateUsers";
			initWizard = initWizard(bo, type);
			candidateUsersButton = addConfigureOperationButton(
					candidateUsersText, Messages.CandidateUsers, type,
					initWizard);
			candidateUsersButton
					.addSelectionListener(new WizardSelectionAdapter(
							initWizard, bo, candidateUsersText));

			final GenericTupel<Text, CLabel> candidateGroups = PropertyUtil
					.createTextAndLabel(section, parent, "Candidate Groups",
							ModelPackage.eINSTANCE
									.getDocumentRoot_CandidateGroups(), bo);
			candidateGroupsText = candidateGroups.getObjectOne();
			candidateGroupsText.setEnabled(false);
			candidateGroupsLabel = candidateGroups.getObjectTwo();
			type = "CandidateGroups";
			initWizard = initWizard(bo, type);
			candidateGroupsButton = addConfigureOperationButton(
					candidateGroupsText, Messages.CandidateGroups, type,
					initWizard);
			candidateGroupsButton
					.addSelectionListener(new WizardSelectionAdapter(
							initWizard, bo, candidateGroupsText));
			candidateGroupsText.setEnabled(false);

			Definitions defs = ModelUtil.getDefinitions(bo);
			for (final RootElement root : defs.getRootElements()) {
				if (root instanceof Process) {
					Process process = (Process) root;
					Boolean responsibilities = (Boolean) process
							.eGet(CasOpenPackage.eINSTANCE
									.getDocumentRoot_ContainsResponsibilities());
					if (responsibilities && isUserInteractible) {
						setTextLabelAndButtonVisible(true);
					} else {
						setTextLabelAndButtonVisible(false);
					}
				}
			}

			checkbox.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(final SelectionEvent e) {
					isUserInteractible = (Boolean) bo
							.eGet(CasOpenPackage.eINSTANCE
									.getDocumentRoot_IsUserInteractable());
					Definitions defs = ModelUtil.getDefinitions(bo);
					for (final RootElement root : defs.getRootElements()) {
						if (root instanceof Process) {
							Process process = (Process) root;
							Boolean responsibilities = (Boolean) process.eGet(CasOpenPackage.eINSTANCE
									.getDocumentRoot_ContainsResponsibilities());
							if (responsibilities && isUserInteractible) {
								setTextLabelAndButtonVisible(true);
							} else {
								setTextLabelAndButtonVisible(false);
							}
						}
					}
				}

				@Override
				public void widgetDefaultSelected(final SelectionEvent e) {
				}
			});

			// if (isUserInteractible) {
			// Definitions defs = ModelUtil.getDefinitions(bo);
			// for (final RootElement root : defs.getRootElements()) {
			// if (root instanceof Process) {
			// Process process = (Process) root;
			// Boolean responsibilities = (Boolean) process
			// .eGet(CasOpenPackage.eINSTANCE
			// .getDocumentRoot_ContainsResponsibilities());
			// if (responsibilities) {
			// PropertyUtil.createText(section, parent,
			// "Assignee", ModelPackage.eINSTANCE
			// .getDocumentRoot_Assignee(), bo);
			// PropertyUtil.createText(section, parent,
			// "Candidate Users", ModelPackage.eINSTANCE
			// .getDocumentRoot_CandidateUsers(),
			// bo);
			// PropertyUtil.createText(section, parent,
			// "Candidate Groups", ModelPackage.eINSTANCE
			// .getDocumentRoot_CandidateGroups(),
			// bo);
			// }
			// }
			// }
			// }
		}

		// final CCombo dropDown = PropertyUtil.createDropDown(section, parent,
		// Messages.DecisionGatewayPropertiesBuilder_1);
		//
		// // register change support
		// EAttributeChangeSupport.ensureAdded(bo, FLOW_NODE_OUTGOING,
		// dropDown);
		//
		// dropDown.addListener(Events.MODEL_CHANGED, new Listener() {
		//
		// @Override
		// public void handleEvent(final Event e) {
		// ModelChangedEvent event = (ModelChangedEvent) e;
		// if (FLOW_NODE_OUTGOING.equals(event.getFeature())) {
		// updateDropdownLabels(dropDown);
		// }
		// }
		// });
		//
		// BaseElementIdComboBinding<SequenceFlow> dropDownBinding = new
		// BaseElementIdComboBinding<SequenceFlow>(bo, DEFAULT_FLOW_FEATURE,
		// dropDown) {
		// @Override
		// protected SequenceFlow getModelById(final String id) {
		// return getSequenceFlowById(id);
		// }
		// };
		//
		// dropDownBinding.establish();
		//
		// updateDropdownLabels(dropDown);
	}

	private void setTextLabelAndButtonVisible(boolean b) {
		assigneeText.setVisible(b);
		assigneeLabel.setVisible(b);
		assigneeButton.setVisible(b);
		candidateUsersText.setVisible(b);
		candidateUsersLabel.setVisible(b);
		candidateUsersButton.setVisible(b);
		candidateGroupsText.setVisible(b);
		candidateGroupsLabel.setVisible(b);
		candidateGroupsButton.setVisible(b);
	}

	/**
	 * Returns the sequence flow with the given id in the context of this
	 * factory
	 * 
	 * @param id
	 * @return
	 */
	private SequenceFlow getSequenceFlowById(final String id) {
		List<SequenceFlow> flows = getSequenceFlows();
		for (SequenceFlow outgoing : flows) {
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
		for (String s : dropDown.getItems()) {
			dropDown.remove(s);
		}

		List<SequenceFlow> flows = getSequenceFlows();

		EObject defaultFlow = (EObject) bo.eGet(DEFAULT_FLOW_FEATURE);

		dropDown.add(""); //$NON-NLS-1$

		for (SequenceFlow outgoing : flows) {
			String nodeId = outgoing.getId();
			dropDown.add(nodeId);

			if (outgoing.equals(defaultFlow)) {
				dropDown.select(dropDown.indexOf(nodeId));
			}
		}
	}
}
