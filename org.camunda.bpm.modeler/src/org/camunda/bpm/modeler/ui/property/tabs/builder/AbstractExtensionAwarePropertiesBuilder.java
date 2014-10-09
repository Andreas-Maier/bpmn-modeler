package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.camunda.bpm.modeler.ui.wizards.IOperationWizard;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Strings;

public abstract class AbstractExtensionAwarePropertiesBuilder extends
		AbstractPropertiesBuilder<BaseElement> {

	private static final String CLIENT_WIZARD_EXTENSION_POINT_ID = "de.cas.open.prozesse.modeler.wizard";

	// private IOperationWizard wizard;

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
	}

	protected IOperationWizard initWizard(final BaseElement bo, String type) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(CLIENT_WIZARD_EXTENSION_POINT_ID);
		try {
			for (IConfigurationElement element : elements) {
				IOperationWizard wizard = (IOperationWizard) element
						.createExecutableExtension("class");
				if (wizard.isResponsibleForElement(bo)) {
					if (type == null) {
						wizard.setModelElement(bo);
						return wizard;
					} else if (element.getAttribute("wizardType") != null
							&& element.getAttribute("wizardType").equals(type)) {
						wizard.setModelElement(bo);
						return wizard;
					}
				}
			}
		} catch (CoreException e) {
			throw new IllegalArgumentException(
					"Element does not specify a valid \"class\" property.");
		}
		throw new IllegalArgumentException(
				"No Wizard-Extension found for element " + bo.eClass());
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
	protected Button addConfigureOperationButton(final Text operationText,
			final String buttonText, final String buttonData, IOperationWizard wizard) {
		// monkey patching for the win!
		Composite comp = PropertyUtil.createStandardComposite(section, parent);

		final Button btnClassSelect = new Button(comp, SWT.NONE);
		btnClassSelect.setData("type", buttonData);
		btnClassSelect.setText(buttonText);

		operationText.setText(Strings.nullToEmpty(wizard.getTextToShow()));

		// customize layout data for text field
		FormData textFormData = (FormData) operationText.getLayoutData();
		// make space for button

		FormData btnSelectLayoutData = new FormData();
		btnSelectLayoutData.left = new FormAttachment(operationText, 0);
		btnSelectLayoutData.top = new FormAttachment(operationText, 0,
				SWT.CENTER);

		operationText.setLayoutData(textFormData);
		btnClassSelect.setLayoutData(btnSelectLayoutData);

		return btnClassSelect;
	}
}
