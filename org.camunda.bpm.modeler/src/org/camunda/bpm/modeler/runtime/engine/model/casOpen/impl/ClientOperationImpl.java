/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import java.util.Collection;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.OperationParameter;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result;
import org.eclipse.bpmn2.impl.ExtensionAttributeValueImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Client Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ClientOperationImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ClientOperationImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ClientOperationImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.ClientOperationImpl#getOperationType <em>Operation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClientOperationImpl extends EObjectImpl implements ClientOperation {
	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected String action = ACTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationParameter> parameter;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Result result;

	/**
	 * The default value of the '{@link #getOperationType() <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationType()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationType() <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationType()
	 * @generated
	 * @ordered
	 */
	protected String operationType = OPERATION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClientOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.CLIENT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.CLIENT_OPERATION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationParameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<OperationParameter>(OperationParameter.class, this, CasOpenPackage.CLIENT_OPERATION__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Result getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(Result newResult, NotificationChain msgs) {
		Result oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CasOpenPackage.CLIENT_OPERATION__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(Result newResult) {
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CasOpenPackage.CLIENT_OPERATION__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CasOpenPackage.CLIENT_OPERATION__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.CLIENT_OPERATION__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationType() {
		return operationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationType(String newOperationType) {
		String oldOperationType = operationType;
		operationType = newOperationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.CLIENT_OPERATION__OPERATION_TYPE, oldOperationType, operationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CasOpenPackage.CLIENT_OPERATION__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case CasOpenPackage.CLIENT_OPERATION__RESULT:
				return basicSetResult(null, msgs);
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
			case CasOpenPackage.CLIENT_OPERATION__ACTION:
				return getAction();
			case CasOpenPackage.CLIENT_OPERATION__PARAMETER:
				return getParameter();
			case CasOpenPackage.CLIENT_OPERATION__RESULT:
				return getResult();
			case CasOpenPackage.CLIENT_OPERATION__OPERATION_TYPE:
				return getOperationType();
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
			case CasOpenPackage.CLIENT_OPERATION__ACTION:
				setAction((String)newValue);
				return;
			case CasOpenPackage.CLIENT_OPERATION__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends OperationParameter>)newValue);
				return;
			case CasOpenPackage.CLIENT_OPERATION__RESULT:
				setResult((Result)newValue);
				return;
			case CasOpenPackage.CLIENT_OPERATION__OPERATION_TYPE:
				setOperationType((String)newValue);
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
			case CasOpenPackage.CLIENT_OPERATION__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case CasOpenPackage.CLIENT_OPERATION__PARAMETER:
				getParameter().clear();
				return;
			case CasOpenPackage.CLIENT_OPERATION__RESULT:
				setResult((Result)null);
				return;
			case CasOpenPackage.CLIENT_OPERATION__OPERATION_TYPE:
				setOperationType(OPERATION_TYPE_EDEFAULT);
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
			case CasOpenPackage.CLIENT_OPERATION__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
			case CasOpenPackage.CLIENT_OPERATION__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case CasOpenPackage.CLIENT_OPERATION__RESULT:
				return result != null;
			case CasOpenPackage.CLIENT_OPERATION__OPERATION_TYPE:
				return OPERATION_TYPE_EDEFAULT == null ? operationType != null : !OPERATION_TYPE_EDEFAULT.equals(operationType);
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
		result.append(" (action: ");
		result.append(action);
		result.append(", operationType: ");
		result.append(operationType);
		result.append(')');
		return result.toString();
	}

} //ClientOperationImpl
