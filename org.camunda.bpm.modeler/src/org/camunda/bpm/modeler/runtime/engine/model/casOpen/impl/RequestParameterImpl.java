/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import java.util.Collection;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter;

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
 * An implementation of the model object '<em><b>Request Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.RequestParameterImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.RequestParameterImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.RequestParameterImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.RequestParameterImpl#getValueReference <em>Value Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequestParameterImpl extends EObjectImpl implements RequestParameter {
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
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValueReference() <em>Value Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueReference()
	 * @generated
	 * @ordered
	 */
	protected EList<RequestParameter> valueReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequestParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.REQUEST_PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.REQUEST_PARAMETER__FIELD_NAME, oldFieldName, fieldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.REQUEST_PARAMETER__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.REQUEST_PARAMETER__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequestParameter> getValueReference() {
		if (valueReference == null) {
			valueReference = new EObjectContainmentEList<RequestParameter>(RequestParameter.class, this, CasOpenPackage.REQUEST_PARAMETER__VALUE_REFERENCE);
		}
		return valueReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CasOpenPackage.REQUEST_PARAMETER__VALUE_REFERENCE:
				return ((InternalEList<?>)getValueReference()).basicRemove(otherEnd, msgs);
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
			case CasOpenPackage.REQUEST_PARAMETER__FIELD_NAME:
				return getFieldName();
			case CasOpenPackage.REQUEST_PARAMETER__EXPRESSION:
				return getExpression();
			case CasOpenPackage.REQUEST_PARAMETER__VALUE:
				return getValue();
			case CasOpenPackage.REQUEST_PARAMETER__VALUE_REFERENCE:
				return getValueReference();
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
			case CasOpenPackage.REQUEST_PARAMETER__FIELD_NAME:
				setFieldName((String)newValue);
				return;
			case CasOpenPackage.REQUEST_PARAMETER__EXPRESSION:
				setExpression((String)newValue);
				return;
			case CasOpenPackage.REQUEST_PARAMETER__VALUE:
				setValue((String)newValue);
				return;
			case CasOpenPackage.REQUEST_PARAMETER__VALUE_REFERENCE:
				getValueReference().clear();
				getValueReference().addAll((Collection<? extends RequestParameter>)newValue);
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
			case CasOpenPackage.REQUEST_PARAMETER__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
				return;
			case CasOpenPackage.REQUEST_PARAMETER__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case CasOpenPackage.REQUEST_PARAMETER__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case CasOpenPackage.REQUEST_PARAMETER__VALUE_REFERENCE:
				getValueReference().clear();
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
			case CasOpenPackage.REQUEST_PARAMETER__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
			case CasOpenPackage.REQUEST_PARAMETER__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case CasOpenPackage.REQUEST_PARAMETER__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case CasOpenPackage.REQUEST_PARAMETER__VALUE_REFERENCE:
				return valueReference != null && !valueReference.isEmpty();
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
		result.append(", expression: ");
		result.append(expression);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //RequestParameterImpl
