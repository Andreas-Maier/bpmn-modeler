/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentRoot;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.DocumentRootImpl#isIsUserInteractable <em>Is User Interactable</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.DocumentRootImpl#isContainsResponsibilities <em>Contains Responsibilities</em>}</li>
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
	protected static final boolean IS_USER_INTERACTABLE_EDEFAULT = true;

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
	 * The default value of the '{@link #isContainsResponsibilities() <em>Contains Responsibilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainsResponsibilities()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINS_RESPONSIBILITIES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainsResponsibilities() <em>Contains Responsibilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainsResponsibilities()
	 * @generated
	 * @ordered
	 */
	protected boolean containsResponsibilities = CONTAINS_RESPONSIBILITIES_EDEFAULT;

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
	@Override
	public boolean isIsUserInteractable() {
		return isUserInteractable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public boolean isContainsResponsibilities() {
		return containsResponsibilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainsResponsibilities(boolean newContainsResponsibilities) {
		boolean oldContainsResponsibilities = containsResponsibilities;
		containsResponsibilities = newContainsResponsibilities;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.DOCUMENT_ROOT__CONTAINS_RESPONSIBILITIES, oldContainsResponsibilities, containsResponsibilities));
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
			case CasOpenPackage.DOCUMENT_ROOT__CONTAINS_RESPONSIBILITIES:
				return isContainsResponsibilities();
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
			case CasOpenPackage.DOCUMENT_ROOT__CONTAINS_RESPONSIBILITIES:
				setContainsResponsibilities((Boolean)newValue);
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
			case CasOpenPackage.DOCUMENT_ROOT__CONTAINS_RESPONSIBILITIES:
				setContainsResponsibilities(CONTAINS_RESPONSIBILITIES_EDEFAULT);
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
			case CasOpenPackage.DOCUMENT_ROOT__CONTAINS_RESPONSIBILITIES:
				return containsResponsibilities != CONTAINS_RESPONSIBILITIES_EDEFAULT;
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
		result.append(", containsResponsibilities: ");
		result.append(containsResponsibilities);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
