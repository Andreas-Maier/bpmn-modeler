/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage
 * @generated
 */
public interface CasOpenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CasOpenFactory eINSTANCE = org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.CasOpenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Client Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Client Operation</em>'.
	 * @generated
	 */
	ClientOperation createClientOperation();

	/**
	 * Returns a new object of class '<em>Operation Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Parameter</em>'.
	 * @generated
	 */
	OperationParameter createOperationParameter();

	/**
	 * Returns a new object of class '<em>Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result</em>'.
	 * @generated
	 */
	Result createResult();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Document Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Meta Data</em>'.
	 * @generated
	 */
	DocumentMetaData createDocumentMetaData();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Service Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Operation</em>'.
	 * @generated
	 */
	ServiceOperation createServiceOperation();

	/**
	 * Returns a new object of class '<em>Request Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Object</em>'.
	 * @generated
	 */
	RequestObject createRequestObject();

	/**
	 * Returns a new object of class '<em>Request Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Parameter</em>'.
	 * @generated
	 */
	RequestParameter createRequestParameter();

	/**
	 * Returns a new object of class '<em>Response Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Response Object</em>'.
	 * @generated
	 */
	ResponseObject createResponseObject();

	/**
	 * Returns a new object of class '<em>Response Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Response Parameter</em>'.
	 * @generated
	 */
	ResponseParameter createResponseParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CasOpenPackage getCasOpenPackage();

} //CasOpenFactory
