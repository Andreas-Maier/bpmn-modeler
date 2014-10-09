package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.wizards.IOperationWizard;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Strings;

public class WizardSelectionAdapter extends SelectionAdapter {

	IOperationWizard wizard;
	BaseElement element;
	Text operationText;

	public WizardSelectionAdapter(IOperationWizard wizard, BaseElement element,
			Text operationText) {
		this.wizard = wizard;
		this.element = element;
		this.operationText = operationText;
	}

	@Override
	public void widgetSelected(final SelectionEvent evt) {
		Shell shell = operationText.getShell();
		wizard.setModelElement(element);
		WizardDialog dialog = new WizardDialog(shell, (IWizard) wizard);
		dialog.setPageSize(750, 320);
		dialog.setBlockOnOpen(true);
		// interrupting operation
		int exitCode = dialog.open();

		if (exitCode == Window.OK) {
			// Update label
			operationText.setText(Strings.nullToEmpty(wizard.getTextToShow()));
			operationText.redraw();
		} else {

		}
	}
}
