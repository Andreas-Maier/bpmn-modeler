/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentRoot;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ServiceOperation;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.DocumentRootImpl#isIsUserInteractable <em>Is User Interactable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends org.camunda.bpm.modeler.runtime.engine.model.impl.DocumentRootImpl implements DocumentRoot {
	/**
	 * The default value of the '{@link #isIsUserInteractable() <em>Is User Interactable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUserInteractable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_USER_INTERACTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUserInteractable() <em>Is User Interactable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUserInteractable()
	 * @generated
	 * @ordered
	 */
	protected boolean isUserInteractable = IS_USER_INTERACTABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUserInteractable() {
		return isUserInteractable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUserInteractable(boolean newIsUserInteractable) {
		boolean oldIsUserInteractable = isUserInteractable;
		isUserInteractable = newIsUserInteractable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.DOCUMENT_ROOT__IS_USER_INTERACTABLE, oldIsUserInteractable, isUserInteractable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasOpenPackage.DOCUMENT_ROOT__IS_USER_INTERACTABLE:
				return isIsUserInteractable();
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
			case CasOpenPackage.DOCUMENT_ROOT__IS_USER_INTERACTABLE:
				setIsUserInteractable((Boolean)newValue);
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
			case CasOpenPackage.DOCUMENT_ROOT__IS_USER_INTERACTABLE:
				setIsUserInteractable(IS_USER_INTERACTABLE_EDEFAULT);
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
			case CasOpenPackage.DOCUMENT_ROOT__IS_USER_INTERACTABLE:
				return isUserInteractable != IS_USER_INTERACTABLE_EDEFAULT;
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
		result.append(" (isUserInteractable: ");
		result.append(isUserInteractable);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
