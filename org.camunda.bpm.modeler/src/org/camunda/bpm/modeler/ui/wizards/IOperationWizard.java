package org.camunda.bpm.modeler.ui.wizards;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.jface.wizard.IWizard;

/**
 * Interface for {@link IWizard}'s that handle the configuration of operations
 * in the ProcessEngine.
 * 
 * @author Andreas.Maier
 * 
 */
public interface IOperationWizard {

	/**
	 * Sets the {@link BaseElement} for the wizard where the operation should be
	 * attached.
	 * 
	 * @param element
	 *            the element to work on.
	 */
	void setModelElement(BaseElement element);

	BaseElement getModelElement();
	
	/**
	 * Retrieves if the implementing {@link IOperationWizard} is responsible for
	 * {@link BaseElement} of the current passed instance.
	 * 
	 * @param element
	 *            the element instance to work on in future.
	 * @return true if the {@link IOperationWizard} can handle the
	 *         {@link BaseElement} instance, false otherwise.
	 */
	boolean isResponsibleForElement(BaseElement element);

	/**
	 * Returns the Text to show in possible labels or text fields.
	 * 
	 * @return a string representing the operation. May NOT return null.
	 */
	String getTextToShow();
}
