/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentRoot#isIsUserInteractable <em>Is User Interactable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface DocumentRoot extends org.camunda.bpm.modeler.runtime.engine.model.DocumentRoot {
	/**
	 * Returns the value of the '<em><b>Is User Interactable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is User Interactable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is User Interactable</em>' attribute.
	 * @see #setIsUserInteractable(boolean)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getDocumentRoot_IsUserInteractable()
	 * @model default="true"
	 *        extendedMetaData="kind='attribute' name='isUserInteractable' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	boolean isIsUserInteractable();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentRoot#isIsUserInteractable <em>Is User Interactable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is User Interactable</em>' attribute.
	 * @see #isIsUserInteractable()
	 * @generated
	 */
	void setIsUserInteractable(boolean value);

} // DocumentRoot
