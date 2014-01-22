/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter#getResponseParameters <em>Response Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResponseParameter()
 * @model
 * @generated
 */
public interface ResponseParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Name</em>' attribute.
	 * @see #setFieldName(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResponseParameter_FieldName()
	 * @model extendedMetaData="kind='attribute' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' attribute.
	 * @see #setVariableName(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResponseParameter_VariableName()
	 * @model extendedMetaData="kind='attribute' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getVariableName();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter#getVariableName <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' attribute.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Response Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Parameters</em>' containment reference list.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResponseParameter_ResponseParameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	EList<ResponseParameter> getResponseParameters();

} // ResponseParameter
