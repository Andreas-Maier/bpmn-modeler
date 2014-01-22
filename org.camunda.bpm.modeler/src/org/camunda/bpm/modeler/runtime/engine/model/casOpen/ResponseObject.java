/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseObject#getClazz <em>Clazz</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseObject#getResponseParameters <em>Response Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResponseObject()
 * @model
 * @generated
 */
public interface ResponseObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Clazz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clazz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clazz</em>' attribute.
	 * @see #setClazz(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResponseObject_Clazz()
	 * @model extendedMetaData="kind='attribute' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getClazz();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseObject#getClazz <em>Clazz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clazz</em>' attribute.
	 * @see #getClazz()
	 * @generated
	 */
	void setClazz(String value);

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
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResponseObject_ResponseParameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	EList<ResponseParameter> getResponseParameters();

} // ResponseObject
