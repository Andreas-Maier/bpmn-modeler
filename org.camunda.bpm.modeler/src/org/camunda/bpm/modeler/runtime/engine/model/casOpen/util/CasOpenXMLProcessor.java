/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.util;

import java.util.Map;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CasOpenXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasOpenXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		CasOpenPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the CasOpenResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new CasOpenResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new CasOpenResourceFactoryImpl());
		}
		return registrations;
	}

} //CasOpenXMLProcessor
