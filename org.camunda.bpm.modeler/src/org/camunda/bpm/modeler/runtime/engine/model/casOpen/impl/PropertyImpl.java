/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property;

import org.eclipse.bpmn2.Task;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.PropertyImpl#getDefiningElement <em>Defining Element</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.PropertyImpl#getPropertyType <em>Property Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl extends org.eclipse.bpmn2.impl.PropertyImpl implements Property {
	/**
	 * The cached value of the '{@link #getDefiningElement() <em>Defining Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefiningElement()
	 * @generated
	 * @ordered
	 */
	protected Task definingElement;

	/**
	 * The default value of the '{@link #getPropertyType() <em>Property Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyType()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPropertyType() <em>Property Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyType()
	 * @generated
	 * @ordered
	 */
	protected String propertyType = PROPERTY_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getDefiningElement() {
		if (definingElement != null && definingElement.eIsProxy()) {
			InternalEObject oldDefiningElement = (InternalEObject)definingElement;
			definingElement = (Task)eResolveProxy(oldDefiningElement);
			if (definingElement != oldDefiningElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CasOpenPackage.PROPERTY__DEFINING_ELEMENT, oldDefiningElement, definingElement));
			}
		}
		return definingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetDefiningElement() {
		return definingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefiningElement(Task newDefiningElement) {
		Task oldDefiningElement = definingElement;
		definingElement = newDefiningElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.PROPERTY__DEFINING_ELEMENT, oldDefiningElement, definingElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyType() {
		return propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyType(String newPropertyType) {
		String oldPropertyType = propertyType;
		propertyType = newPropertyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.PROPERTY__PROPERTY_TYPE, oldPropertyType, propertyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasOpenPackage.PROPERTY__DEFINING_ELEMENT:
				if (resolve) return getDefiningElement();
				return basicGetDefiningElement();
			case CasOpenPackage.PROPERTY__PROPERTY_TYPE:
				return getPropertyType();
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
			case CasOpenPackage.PROPERTY__DEFINING_ELEMENT:
				setDefiningElement((Task)newValue);
				return;
			case CasOpenPackage.PROPERTY__PROPERTY_TYPE:
				setPropertyType((String)newValue);
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
			case CasOpenPackage.PROPERTY__DEFINING_ELEMENT:
				setDefiningElement((Task)null);
				return;
			case CasOpenPackage.PROPERTY__PROPERTY_TYPE:
				setPropertyType(PROPERTY_TYPE_EDEFAULT);
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
			case CasOpenPackage.PROPERTY__DEFINING_ELEMENT:
				return definingElement != null;
			case CasOpenPackage.PROPERTY__PROPERTY_TYPE:
				return PROPERTY_TYPE_EDEFAULT == null ? propertyType != null : !PROPERTY_TYPE_EDEFAULT.equals(propertyType);
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
		result.append(" (propertyType: ");
		result.append(propertyType);
		result.append(')');
		return result.toString();
	}

} //PropertyImpl
