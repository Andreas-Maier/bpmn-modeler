/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Request Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter#getValue <em>Value</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter#getValueReference <em>Value Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getRequestParameter()
 * @model
 * @generated
 */
public interface RequestParameter extends EObject {
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
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getRequestParameter_FieldName()
	 * @model extendedMetaData="kind='attribute' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getRequestParameter_Expression()
	 * @model extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getRequestParameter_Value()
	 * @model extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Value Reference</b></em>' containment reference list.
	 * The list contents are of type {@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Reference</em>' containment reference list.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getRequestParameter_ValueReference()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' namespace='http://www.cas.de/open'"
	 * @generated
	 */
	EList<RequestParameter> getValueReference();

} // RequestParameter
