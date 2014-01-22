package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.camunda.bpm.modeler.ui.wizards.IOperationWizard;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public abstract class AbstractExtensionAwarePropertiesBuilder extends
		AbstractPropertiesBuilder<BaseElement> {

	private static final String CLIENT_WIZARD_EXTENSION_POINT_ID = "de.cas.open.prozesse.modeler.wizard";

	private IOperationWizard wizard;

	/**
	 * Checks the {@link IExtensionRegistry} for {@link IOperationWizard}'s for
	 * the passed {@link BaseElement}.
	 * 
	 * 
	 * {@inheritDoc}
	 */
	public AbstractExtensionAwarePropertiesBuilder(final Composite parent,
			final GFPropertySection section, final BaseElement bo) {
		super(parent, section, bo);

		initWizard(bo);
	}

	private void initWizard(final BaseElement bo) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(CLIENT_WIZARD_EXTENSION_POINT_ID);
		try {
			for (IConfigurationElement element : elements) {
				wizard = (IOperationWizard) element
						.createExecutableExtension("class");
				if (wizard.isResponsibleForElement(bo)) {
					wizard.setModelElement(bo);
					break;
				}
			}
		} catch (CoreException e) {
			throw new IllegalArgumentException(
					"Element does not specify a valid \"class\" property.");
		}
		if (wizard == null) {
			throw new IllegalArgumentException(
					"No Wizard-Extension found for element " + bo.eClass());
		}
	}

	/**
	 * Adds a {@link Button} next to the {@link Text} passed as argument. The
	 * {@link Button} causes the identified {@link IOperationWizard}, registered
	 * in the {@link IExtensionRegistry}, to show up. When the
	 * {@link IOperationWizard} is finished the getTextToShow() method is called
	 * and the {@link Text} Element next to the {@link Button} will be filled.
	 * 
	 * @param operationText
	 *            the {@link Text} field that will be the sibling of the
	 *            {@link Button} that will show the {@link IOperationWizard}.
	 */
	protected Button addConfigureOperationButton(final Text operationText, final String buttonText) {

		operationText.setText(wizard.getTextToShow());

		// monkey patching for the win!
		Composite comp = PropertyUtil.createStandardComposite(section, parent);
		
		final Button btnClassSelect = new Button(comp, SWT.NONE);
		btnClassSelect.setText(buttonText);

		// customize layout data for text field
		FormData textFormData = (FormData) operationText.getLayoutData();
		// make space for button
		
		FormData btnSelectLayoutData = new FormData();
		btnSelectLayoutData.left = new FormAttachment(operationText, 0);
		btnSelectLayoutData.top = new FormAttachment(operationText, 0,
				SWT.CENTER);

		operationText.setLayoutData(textFormData);
		btnClassSelect.setLayoutData(btnSelectLayoutData);

		btnClassSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent evt) {
				Shell shell = operationText.getShell();
				initWizard(bo);
				wizard.setModelElement(bo);
				WizardDialog dialog = new WizardDialog(shell, (IWizard) wizard);
				dialog.setPageSize(750, 320);
				dialog.setBlockOnOpen(true);
				// interrupting operation
				int exitCode = dialog.open();

				if (exitCode == Window.OK) {
					// Update label
					operationText.setText(wizard.getTextToShow());
					operationText.redraw();
				} else {
					
				}
			}
		});
		return btnClassSelect;
	}
}
