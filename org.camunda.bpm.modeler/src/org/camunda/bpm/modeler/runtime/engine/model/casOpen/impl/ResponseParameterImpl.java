/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import java.util.Collection;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ResponseParameterImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ResponseParameterImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ResponseParameterImpl#getResponseParameters <em>Response Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponseParameterImpl extends EObjectImpl implements ResponseParameter {
	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected String fieldName = FIELD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected String variableName = VARIABLE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResponseParameters() <em>Response Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ResponseParameter> responseParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponseParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.RESPONSE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldName(String newFieldName) {
		String oldFieldName = fieldName;
		fieldName = newFieldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.RESPONSE_PARAMETER__FIELD_NAME, oldFieldName, fieldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableName() {
		return variableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableName(String newVariableName) {
		String oldVariableName = variableName;
		variableName = newVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.RESPONSE_PARAMETER__VARIABLE_NAME, oldVariableName, variableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResponseParameter> getResponseParameters() {
		if (responseParameters == null) {
			responseParameters = new EObjectContainmentEList<ResponseParameter>(ResponseParameter.class, this, CasOpenPackage.RESPONSE_PARAMETER__RESPONSE_PARAMETERS);
		}
		return responseParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CasOpenPackage.RESPONSE_PARAMETER__RESPONSE_PARAMETERS:
				return ((InternalEList<?>)getResponseParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasOpenPackage.RESPONSE_PARAMETER__FIELD_NAME:
				return getFieldName();
			case CasOpenPackage.RESPONSE_PARAMETER__VARIABLE_NAME:
				return getVariableName();
			case CasOpenPackage.RESPONSE_PARAMETER__RESPONSE_PARAMETERS:
				return getResponseParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CasOpenPackage.RESPONSE_PARAMETER__FIELD_NAME:
				setFieldName((String)newValue);
				return;
			case CasOpenPackage.RESPONSE_PARAMETER__VARIABLE_NAME:
				setVariableName((String)newValue);
				return;
			case CasOpenPackage.RESPONSE_PARAMETER__RESPONSE_PARAMETERS:
				getResponseParameters().clear();
				getResponseParameters().addAll((Collection<? extends ResponseParameter>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CasOpenPackage.RESPONSE_PARAMETER__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
				return;
			case CasOpenPackage.RESPONSE_PARAMETER__VARIABLE_NAME:
				setVariableName(VARIABLE_NAME_EDEFAULT);
				return;
			case CasOpenPackage.RESPONSE_PARAMETER__RESPONSE_PARAMETERS:
				getResponseParameters().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CasOpenPackage.RESPONSE_PARAMETER__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
			case CasOpenPackage.RESPONSE_PARAMETER__VARIABLE_NAME:
				return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
			case CasOpenPackage.RESPONSE_PARAMETER__RESPONSE_PARAMETERS:
				return responseParameters != null && !responseParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fieldName: ");
		result.append(fieldName);
		result.append(", variableName: ");
		result.append(variableName);
		result.append(')');
		return result.toString();
	}

} //ResponseParameterImpl
