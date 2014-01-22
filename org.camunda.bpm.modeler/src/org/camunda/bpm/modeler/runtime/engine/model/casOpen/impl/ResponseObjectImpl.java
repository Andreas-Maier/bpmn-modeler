/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import java.util.Collection;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseObject;
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
 * An implementation of the model object '<em><b>Response Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ResponseObjectImpl#getClazz <em>Clazz</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ResponseObjectImpl#getResponseParameters <em>Response Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponseObjectImpl extends EObjectImpl implements ResponseObject {
	/**
	 * The default value of the '{@link #getClazz() <em>Clazz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClazz()
	 * @generated
	 * @ordered
	 */
	protected static final String CLAZZ_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClazz() <em>Clazz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClazz()
	 * @generated
	 * @ordered
	 */
	protected String clazz = CLAZZ_EDEFAULT;

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
	protected ResponseObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.RESPONSE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClazz() {
		return clazz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClazz(String newClazz) {
		String oldClazz = clazz;
		clazz = newClazz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.RESPONSE_OBJECT__CLAZZ, oldClazz, clazz));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResponseParameter> getResponseParameters() {
		if (responseParameters == null) {
			responseParameters = new EObjectContainmentEList<ResponseParameter>(ResponseParameter.class, this, CasOpenPackage.RESPONSE_OBJECT__RESPONSE_PARAMETERS);
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
			case CasOpenPackage.RESPONSE_OBJECT__RESPONSE_PARAMETERS:
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
			case CasOpenPackage.RESPONSE_OBJECT__CLAZZ:
				return getClazz();
			case CasOpenPackage.RESPONSE_OBJECT__RESPONSE_PARAMETERS:
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
			case CasOpenPackage.RESPONSE_OBJECT__CLAZZ:
				setClazz((String)newValue);
				return;
			case CasOpenPackage.RESPONSE_OBJECT__RESPONSE_PARAMETERS:
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
			case CasOpenPackage.RESPONSE_OBJECT__CLAZZ:
				setClazz(CLAZZ_EDEFAULT);
				return;
			case CasOpenPackage.RESPONSE_OBJECT__RESPONSE_PARAMETERS:
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
			case CasOpenPackage.RESPONSE_OBJECT__CLAZZ:
				return CLAZZ_EDEFAULT == null ? clazz != null : !CLAZZ_EDEFAULT.equals(clazz);
			case CasOpenPackage.RESPONSE_OBJECT__RESPONSE_PARAMETERS:
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
		result.append(" (clazz: ");
		result.append(clazz);
		result.append(')');
		return result.toString();
	}

} //ResponseObjectImpl
