/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.impl;

import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenFactory;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ClientOperation;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ConditionComparators;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentRoot;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.OperationParameter;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestObject;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseObject;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.ServiceOperation;
import org.camunda.bpm.modeler.runtime.engine.model.fox.FoxPackage;
import org.camunda.bpm.modeler.runtime.engine.model.fox.impl.FoxPackageImpl;
import org.camunda.bpm.modeler.runtime.engine.model.impl.ModelPackageImpl;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.di.BpmnDiPackage;
import org.eclipse.dd.dc.DcPackage;
import org.eclipse.dd.di.DiPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CasOpenPackageImpl extends EPackageImpl implements CasOpenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clientOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responseObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responseParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum conditionComparatorsEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CasOpenPackageImpl() {
		super(eNS_URI, CasOpenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CasOpenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CasOpenPackage init() {
		if (isInited) return (CasOpenPackage)EPackage.Registry.INSTANCE.getEPackage(CasOpenPackage.eNS_URI);

		// Obtain or create and register package
		CasOpenPackageImpl theCasOpenPackage = (CasOpenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CasOpenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CasOpenPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Bpmn2Package.eINSTANCE.eClass();
		BpmnDiPackage.eINSTANCE.eClass();
		DiPackage.eINSTANCE.eClass();
		DcPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		FoxPackageImpl theFoxPackage = (FoxPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FoxPackage.eNS_URI) instanceof FoxPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FoxPackage.eNS_URI) : FoxPackage.eINSTANCE);

		// Create package meta-data objects
		theCasOpenPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theFoxPackage.createPackageContents();

		// Initialize created meta-data
		theCasOpenPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theFoxPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCasOpenPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CasOpenPackage.eNS_URI, theCasOpenPackage);
		return theCasOpenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClientOperation() {
		return clientOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getClientOperation_Action() {
		return (EAttribute)clientOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClientOperation_Parameter() {
		return (EReference)clientOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClientOperation_Result() {
		return (EReference)clientOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getClientOperation_OperationType() {
		return (EAttribute)clientOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationParameter() {
		return operationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationParameter_ParameterType() {
		return (EAttribute)operationParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationParameter_Name() {
		return (EAttribute)operationParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationParameter_Value() {
		return (EAttribute)operationParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResult() {
		return resultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResult_ResultVariableName() {
		return (EAttribute)resultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResult_ResultType() {
		return (EAttribute)resultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentRoot_IsUserInteractable() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDocumentMetaData() {
		return documentMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentMetaData_DocumentVersion() {
		return (EAttribute)documentMetaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentMetaData_DocumentGuid() {
		return (EAttribute)documentMetaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_DefiningElement() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_PropertyType() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceOperation() {
		return serviceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceOperation_Action() {
		return (EAttribute)serviceOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceOperation_Parameter() {
		return (EReference)serviceOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceOperation_OperationType() {
		return (EAttribute)serviceOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequestObject() {
		return requestObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestObject_Clazz() {
		return (EAttribute)requestObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequestObject_Parameters() {
		return (EReference)requestObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequestParameter() {
		return requestParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestParameter_FieldName() {
		return (EAttribute)requestParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestParameter_Expression() {
		return (EAttribute)requestParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestParameter_Value() {
		return (EAttribute)requestParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequestParameter_ValueReference() {
		return (EReference)requestParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponseObject() {
		return responseObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseObject_Clazz() {
		return (EAttribute)responseObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponseObject_ResponseParameters() {
		return (EReference)responseObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponseParameter() {
		return responseParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseParameter_FieldName() {
		return (EAttribute)responseParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseParameter_VariableName() {
		return (EAttribute)responseParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponseParameter_ResponseParameters() {
		return (EReference)responseParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConditionComparators() {
		return conditionComparatorsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CasOpenFactory getCasOpenFactory() {
		return (CasOpenFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		clientOperationEClass = createEClass(CLIENT_OPERATION);
		createEAttribute(clientOperationEClass, CLIENT_OPERATION__ACTION);
		createEReference(clientOperationEClass, CLIENT_OPERATION__PARAMETER);
		createEReference(clientOperationEClass, CLIENT_OPERATION__RESULT);
		createEAttribute(clientOperationEClass, CLIENT_OPERATION__OPERATION_TYPE);

		operationParameterEClass = createEClass(OPERATION_PARAMETER);
		createEAttribute(operationParameterEClass, OPERATION_PARAMETER__PARAMETER_TYPE);
		createEAttribute(operationParameterEClass, OPERATION_PARAMETER__NAME);
		createEAttribute(operationParameterEClass, OPERATION_PARAMETER__VALUE);

		resultEClass = createEClass(RESULT);
		createEAttribute(resultEClass, RESULT__RESULT_VARIABLE_NAME);
		createEAttribute(resultEClass, RESULT__RESULT_TYPE);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__IS_USER_INTERACTABLE);

		documentMetaDataEClass = createEClass(DOCUMENT_META_DATA);
		createEAttribute(documentMetaDataEClass, DOCUMENT_META_DATA__DOCUMENT_VERSION);
		createEAttribute(documentMetaDataEClass, DOCUMENT_META_DATA__DOCUMENT_GUID);

		propertyEClass = createEClass(PROPERTY);
		createEReference(propertyEClass, PROPERTY__DEFINING_ELEMENT);
		createEAttribute(propertyEClass, PROPERTY__PROPERTY_TYPE);

		serviceOperationEClass = createEClass(SERVICE_OPERATION);
		createEAttribute(serviceOperationEClass, SERVICE_OPERATION__ACTION);
		createEReference(serviceOperationEClass, SERVICE_OPERATION__PARAMETER);
		createEAttribute(serviceOperationEClass, SERVICE_OPERATION__OPERATION_TYPE);

		requestObjectEClass = createEClass(REQUEST_OBJECT);
		createEAttribute(requestObjectEClass, REQUEST_OBJECT__CLAZZ);
		createEReference(requestObjectEClass, REQUEST_OBJECT__PARAMETERS);

		requestParameterEClass = createEClass(REQUEST_PARAMETER);
		createEAttribute(requestParameterEClass, REQUEST_PARAMETER__FIELD_NAME);
		createEAttribute(requestParameterEClass, REQUEST_PARAMETER__EXPRESSION);
		createEAttribute(requestParameterEClass, REQUEST_PARAMETER__VALUE);
		createEReference(requestParameterEClass, REQUEST_PARAMETER__VALUE_REFERENCE);

		responseObjectEClass = createEClass(RESPONSE_OBJECT);
		createEAttribute(responseObjectEClass, RESPONSE_OBJECT__CLAZZ);
		createEReference(responseObjectEClass, RESPONSE_OBJECT__RESPONSE_PARAMETERS);

		responseParameterEClass = createEClass(RESPONSE_PARAMETER);
		createEAttribute(responseParameterEClass, RESPONSE_PARAMETER__FIELD_NAME);
		createEAttribute(responseParameterEClass, RESPONSE_PARAMETER__VARIABLE_NAME);
		createEReference(responseParameterEClass, RESPONSE_PARAMETER__RESPONSE_PARAMETERS);

		// Create enums
		conditionComparatorsEEnum = createEEnum(CONDITION_COMPARATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		Bpmn2Package theBpmn2Package = (Bpmn2Package)EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		documentRootEClass.getESuperTypes().add(theModelPackage.getDocumentRoot());
		propertyEClass.getESuperTypes().add(theBpmn2Package.getProperty());

		// Initialize classes and features; add operations and parameters
		initEClass(clientOperationEClass, ClientOperation.class, "ClientOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClientOperation_Action(), ecorePackage.getEString(), "action", null, 1, 1, ClientOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClientOperation_Parameter(), this.getOperationParameter(), null, "parameter", null, 0, -1, ClientOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClientOperation_Result(), this.getResult(), null, "result", null, 0, 1, ClientOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClientOperation_OperationType(), ecorePackage.getEString(), "operationType", null, 0, 1, ClientOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationParameterEClass, OperationParameter.class, "OperationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationParameter_ParameterType(), ecorePackage.getEString(), "parameterType", null, 1, 1, OperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, OperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, OperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resultEClass, Result.class, "Result", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResult_ResultVariableName(), ecorePackage.getEString(), "resultVariableName", null, 0, 1, Result.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResult_ResultType(), ecorePackage.getEString(), "resultType", null, 0, 1, Result.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_IsUserInteractable(), ecorePackage.getEBoolean(), "isUserInteractable", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentMetaDataEClass, DocumentMetaData.class, "DocumentMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentMetaData_DocumentVersion(), ecorePackage.getEIntegerObject(), "documentVersion", null, 1, 1, DocumentMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentMetaData_DocumentGuid(), ecorePackage.getEString(), "documentGuid", null, 1, 1, DocumentMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProperty_DefiningElement(), theBpmn2Package.getTask(), null, "definingElement", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_PropertyType(), ecorePackage.getEString(), "propertyType", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceOperationEClass, ServiceOperation.class, "ServiceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceOperation_Action(), ecorePackage.getEString(), "action", null, 1, 1, ServiceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceOperation_Parameter(), this.getOperationParameter(), null, "parameter", null, 0, -1, ServiceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceOperation_OperationType(), ecorePackage.getEString(), "operationType", null, 0, 1, ServiceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestObjectEClass, RequestObject.class, "RequestObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequestObject_Clazz(), ecorePackage.getEString(), "clazz", null, 0, 1, RequestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequestObject_Parameters(), this.getRequestParameter(), null, "parameters", null, 0, -1, RequestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestParameterEClass, RequestParameter.class, "RequestParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequestParameter_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, RequestParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestParameter_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, RequestParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, RequestParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequestParameter_ValueReference(), this.getRequestParameter(), null, "valueReference", null, 0, -1, RequestParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responseObjectEClass, ResponseObject.class, "ResponseObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResponseObject_Clazz(), ecorePackage.getEString(), "clazz", null, 0, 1, ResponseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponseObject_ResponseParameters(), this.getResponseParameter(), null, "responseParameters", null, 0, -1, ResponseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responseParameterEClass, ResponseParameter.class, "ResponseParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResponseParameter_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, ResponseParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponseParameter_VariableName(), ecorePackage.getEString(), "variableName", null, 0, 1, ResponseParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponseParameter_ResponseParameters(), this.getResponseParameter(), null, "responseParameters", null, 0, -1, ResponseParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(conditionComparatorsEEnum, ConditionComparators.class, "ConditionComparators");
		addEEnumLiteral(conditionComparatorsEEnum, ConditionComparators.EQUAL);
		addEEnumLiteral(conditionComparatorsEEnum, ConditionComparators.NOT_EQUAL);
		addEEnumLiteral(conditionComparatorsEEnum, ConditionComparators.GREATER_EQUAL);
		addEEnumLiteral(conditionComparatorsEEnum, ConditionComparators.GREATER);
		addEEnumLiteral(conditionComparatorsEEnum, ConditionComparators.LOWER_EQUAL);
		addEEnumLiteral(conditionComparatorsEEnum, ConditionComparators.LOWER);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (clientOperationEClass, 
		   source, 
		   new String[] {
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getClientOperation_Action(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getClientOperation_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getClientOperation_Result(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getClientOperation_OperationType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationType",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (operationParameterEClass, 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getOperationParameter_ParameterType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parameterType",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getOperationParameter_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getOperationParameter_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (resultEClass, 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getResult_ResultVariableName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "resultVariableName",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getResult_ResultType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "resultType",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_IsUserInteractable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isUserInteractable",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (documentMetaDataEClass, 
		   source, 
		   new String[] {
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getDocumentMetaData_DocumentVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getDocumentMetaData_DocumentGuid(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (propertyEClass, 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getProperty_DefiningElement(), 
		   source, 
		   new String[] {
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getProperty_PropertyType(), 
		   source, 
		   new String[] {
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (serviceOperationEClass, 
		   source, 
		   new String[] {
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getServiceOperation_Action(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getServiceOperation_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getServiceOperation_OperationType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationType",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getRequestObject_Clazz(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getRequestObject_Parameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getRequestParameter_FieldName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getRequestParameter_Expression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getRequestParameter_Value(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getRequestParameter_ValueReference(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getResponseObject_Clazz(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getResponseObject_ResponseParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getResponseParameter_FieldName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getResponseParameter_VariableName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "http://www.cas.de/open"
		   });		
		addAnnotation
		  (getResponseParameter_ResponseParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "http://www.cas.de/open"
		   });
	}

} //CasOpenPackageImpl
