/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result#getResultVariableName <em>Result Variable Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result#getResultType <em>Result Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResult()
 * @model extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
 * @generated
 */
public interface Result extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Variable Name</em>' attribute.
	 * @see #setResultVariableName(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResult_ResultVariableName()
	 * @model extendedMetaData="kind='attribute' name='resultVariableName' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getResultVariableName();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result#getResultVariableName <em>Result Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Variable Name</em>' attribute.
	 * @see #getResultVariableName()
	 * @generated
	 */
	void setResultVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' attribute.
	 * @see #setResultType(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getResult_ResultType()
	 * @model extendedMetaData="kind='attribute' name='resultType' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getResultType();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result#getResultType <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' attribute.
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(String value);

} // Result
