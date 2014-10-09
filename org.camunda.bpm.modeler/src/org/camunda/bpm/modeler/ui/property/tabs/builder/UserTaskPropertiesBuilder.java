package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.camunda.bpm.modeler.ui.wizards.IOperationWizard;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class UserTaskPropertiesBuilder extends
		AbstractExtensionAwarePropertiesBuilder {

	public UserTaskPropertiesBuilder(final Composite parent,
			final GFPropertySection section, final UserTask bo) {
		super(parent, section, bo);
	}

	@Override
	public void create() {
		Definitions defs = ModelUtil.getDefinitions(bo);
		for (final RootElement root : defs.getRootElements()) {
			if (root instanceof Process) {
				Process process = (Process) root;
				Boolean responsibilities = (Boolean) process
						.eGet(CasOpenPackage.eINSTANCE
								.getDocumentRoot_ContainsResponsibilities());
				if (responsibilities) {
					final Text assignee = PropertyUtil.createUnboundText(
							section, parent, "Assignee");
					assignee.setEnabled(false);
					IOperationWizard wizard = initWizard(bo, "Assignee");
					Button assigneeButton = addConfigureOperationButton(
							assignee, Messages.Assignee, "Assignee", wizard);
					assigneeButton
							.addSelectionListener(new WizardSelectionAdapter(
									wizard, bo, assignee));
					final Text candidateUsers = PropertyUtil.createUnboundText(
							section, parent, "Candidate Users");
					wizard = initWizard(bo, "CandidateUsers");
					Button candidateUsersButton = addConfigureOperationButton(
							candidateUsers, Messages.CandidateUsers,
							"CandidateUsers", wizard);
					candidateUsersButton
							.addSelectionListener(new WizardSelectionAdapter(
									wizard, bo, candidateUsers));
					candidateUsers.setEnabled(false);
					 final Text candidateGroups =
					 PropertyUtil.createUnboundText(
					 section, parent, "Candidate Groups");
					 wizard = initWizard(bo, "CandidateGroups");
					 Button candidateGroupsButton =
					 addConfigureOperationButton(
					 candidateGroups, Messages.CandidateGroups,
					 "CandidateGroups", wizard);
					 candidateGroupsButton.addSelectionListener(new
					 WizardSelectionAdapter(wizard, bo, candidateGroups));
					 candidateGroups.setEnabled(false);
				}
			}
		}

		// PropertyUtil.createText(section, parent, "Form Key",
		// ModelPackage.eINSTANCE.getDocumentRoot_FormKey(), bo);
		//
		// Text dueDateField = PropertyUtil.createText(section, parent,
		// "Due Date", ModelPackage.eINSTANCE.getDocumentRoot_DueDate(), bo);
		// PropertyUtil.createToolTipFor(dueDateField,
		// "The due date as an EL expression (e.g. ${someDate}) or a ISO date (e.g. 2012-03-01T15:30:23)");
		//
		// PropertyUtil.createText(section, parent, "Priority",
		// ModelPackage.eINSTANCE.getDocumentRoot_Priority(), bo);

		final Text text = PropertyUtil.createUnboundText(section, parent,
				Messages.UserTaskPropertiesBuilder_0);
		text.setEnabled(false);
		IOperationWizard initWizard = initWizard(bo, null);
		Button btn = addConfigureOperationButton(text,
				Messages.UserTaskPropertiesBuilder_1, null, initWizard);
		btn.addSelectionListener(new WizardSelectionAdapter(initWizard, bo,
				text));
	}
}
