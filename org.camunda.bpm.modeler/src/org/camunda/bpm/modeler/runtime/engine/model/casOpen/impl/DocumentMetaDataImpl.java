/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.DocumentMetaDataImpl#getDocumentVersion <em>Document Version</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl.DocumentMetaDataImpl#getDocumentGuid <em>Document Guid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentMetaDataImpl extends EObjectImpl implements DocumentMetaData {
	/**
	 * The default value of the '{@link #getDocumentVersion() <em>Document Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentVersion()
	 * @generated
	 * @ordered
	 */
	protected static final Integer DOCUMENT_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentVersion() <em>Document Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentVersion()
	 * @generated
	 * @ordered
	 */
	protected Integer documentVersion = DOCUMENT_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDocumentGuid() <em>Document Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentGuid()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENT_GUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentGuid() <em>Document Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentGuid()
	 * @generated
	 * @ordered
	 */
	protected String documentGuid = DOCUMENT_GUID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentMetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasOpenPackage.Literals.DOCUMENT_META_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getDocumentVersion() {
		return documentVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentVersion(Integer newDocumentVersion) {
		Integer oldDocumentVersion = documentVersion;
		documentVersion = newDocumentVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_VERSION, oldDocumentVersion, documentVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentGuid() {
		return documentGuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentGuid(String newDocumentGuid) {
		String oldDocumentGuid = documentGuid;
		documentGuid = newDocumentGuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_GUID, oldDocumentGuid, documentGuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_VERSION:
				return getDocumentVersion();
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_GUID:
				return getDocumentGuid();
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
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_VERSION:
				setDocumentVersion((Integer)newValue);
				return;
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_GUID:
				setDocumentGuid((String)newValue);
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
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_VERSION:
				setDocumentVersion(DOCUMENT_VERSION_EDEFAULT);
				return;
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_GUID:
				setDocumentGuid(DOCUMENT_GUID_EDEFAULT);
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
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_VERSION:
				return DOCUMENT_VERSION_EDEFAULT == null ? documentVersion != null : !DOCUMENT_VERSION_EDEFAULT.equals(documentVersion);
			case CasOpenPackage.DOCUMENT_META_DATA__DOCUMENT_GUID:
				return DOCUMENT_GUID_EDEFAULT == null ? documentGuid != null : !DOCUMENT_GUID_EDEFAULT.equals(documentGuid);
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
		result.append(" (documentVersion: ");
		result.append(documentVersion);
		result.append(", documentGuid: ");
		result.append(documentGuid);
		result.append(')');
		return result.toString();
	}

} //DocumentMetaDataImpl
