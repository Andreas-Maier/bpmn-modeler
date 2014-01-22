/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.bpmn2.Task;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property#getDefiningElement <em>Defining Element</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property#getPropertyType <em>Property Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getProperty()
 * @model extendedMetaData="namespace='##targetNamespace'"
 * @generated
 */
public interface Property extends org.eclipse.bpmn2.Property {
	/**
	 * Returns the value of the '<em><b>Defining Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defining Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defining Element</em>' reference.
	 * @see #setDefiningElement(Task)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getProperty_DefiningElement()
	 * @model extendedMetaData="namespace='http://www.cas.de/open'"
	 * @generated
	 */
	Task getDefiningElement();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property#getDefiningElement <em>Defining Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defining Element</em>' reference.
	 * @see #getDefiningElement()
	 * @generated
	 */
	void setDefiningElement(Task value);

	/**
	 * Returns the value of the '<em><b>Property Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Type</em>' attribute.
	 * @see #setPropertyType(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getProperty_PropertyType()
	 * @model extendedMetaData="namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getPropertyType();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property#getPropertyType <em>Property Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Type</em>' attribute.
	 * @see #getPropertyType()
	 * @generated
	 */
	void setPropertyType(String value);

} // Property
