/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ResultImpl#getResultVariableName <em>Result Variable Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ResultImpl#getResultType <em>Result Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultImpl extends EObjectImpl implements Result {
	/**
	 * The default value of the '{@link #getResultVariableName() <em>Result Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultVariableName() <em>Result Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariableName()
	 * @generated
	 * @ordered
	 */
	protected String resultVariableName = RESULT_VARIABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected String resultType = RESULT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultVariableName() {
		return resultVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultVariableName(String newResultVariableName) {
		String oldResultVariableName = resultVariableName;
		resultVariableName = newResultVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.RESULT__RESULT_VARIABLE_NAME, oldResultVariableName, resultVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(String newResultType) {
		String oldResultType = resultType;
		resultType = newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.RESULT__RESULT_TYPE, oldResultType, resultType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasOpenPackage.RESULT__RESULT_VARIABLE_NAME:
				return getResultVariableName();
			case CasOpenPackage.RESULT__RESULT_TYPE:
				return getResultType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CasOpenPackage.RESULT__RESULT_VARIABLE_NAME:
				setResultVariableName((String)newValue);
				return;
			case CasOpenPackage.RESULT__RESULT_TYPE:
				setResultType((String)newValue);
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
			case CasOpenPackage.RESULT__RESULT_VARIABLE_NAME:
				setResultVariableName(RESULT_VARIABLE_NAME_EDEFAULT);
				return;
			case CasOpenPackage.RESULT__RESULT_TYPE:
				setResultType(RESULT_TYPE_EDEFAULT);
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
			case CasOpenPackage.RESULT__RESULT_VARIABLE_NAME:
				return RESULT_VARIABLE_NAME_EDEFAULT == null ? resultVariableName != null : !RESULT_VARIABLE_NAME_EDEFAULT.equals(resultVariableName);
			case CasOpenPackage.RESULT__RESULT_TYPE:
				return RESULT_TYPE_EDEFAULT == null ? resultType != null : !RESULT_TYPE_EDEFAULT.equals(resultType);
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
		result.append(" (resultVariableName: ");
		result.append(resultVariableName);
		result.append(", resultType: ");
		result.append(resultType);
		result.append(')');
		return result.toString();
	}

} //ResultImpl
