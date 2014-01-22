/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Meta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData#getDocumentVersion <em>Document Version</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData#getDocumentGuid <em>Document Guid</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getDocumentMetaData()
 * @model extendedMetaData="namespace='http://www.cas.de/open'"
 * @generated
 */
public interface DocumentMetaData extends EObject {
	/**
	 * Returns the value of the '<em><b>Document Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Version</em>' attribute.
	 * @see #setDocumentVersion(Integer)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getDocumentMetaData_DocumentVersion()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	Integer getDocumentVersion();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData#getDocumentVersion <em>Document Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Version</em>' attribute.
	 * @see #getDocumentVersion()
	 * @generated
	 */
	void setDocumentVersion(Integer value);

	/**
	 * Returns the value of the '<em><b>Document Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Guid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Guid</em>' attribute.
	 * @see #setDocumentGuid(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getDocumentMetaData_DocumentGuid()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getDocumentGuid();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData#getDocumentGuid <em>Document Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Guid</em>' attribute.
	 * @see #getDocumentGuid()
	 * @generated
	 */
	void setDocumentGuid(String value);

} // DocumentMetaData
