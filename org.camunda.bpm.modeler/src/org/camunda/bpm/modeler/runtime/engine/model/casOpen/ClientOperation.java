/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation#getAction <em>Action</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation#getResult <em>Result</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation#getOperationType <em>Operation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getClientOperation()
 * @model extendedMetaData="namespace='http://www.cas.de/open'"
 * @generated
 */
public interface ClientOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getClientOperation_Action()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.OperationParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getClientOperation_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	EList<OperationParameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(Result)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getClientOperation_Result()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	Result getResult();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Result value);

	/**
	 * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Type</em>' attribute.
	 * @see #setOperationType(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getClientOperation_OperationType()
	 * @model extendedMetaData="kind='attribute' name='operationType' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getOperationType();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Type</em>' attribute.
	 * @see #getOperationType()
	 * @generated
	 */
	void setOperationType(String value);

} // ClientOperation
