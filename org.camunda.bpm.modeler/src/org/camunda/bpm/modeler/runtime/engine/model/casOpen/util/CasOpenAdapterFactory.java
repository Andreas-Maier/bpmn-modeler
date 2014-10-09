/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen.util;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.*;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.CallableElement;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.FlowElementsContainer;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage
 * @generated
 */
public class CasOpenAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CasOpenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasOpenAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CasOpenPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CasOpenSwitch<Adapter> modelSwitch =
		new CasOpenSwitch<Adapter>() {
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseOperationParameter(OperationParameter object) {
				return createOperationParameterAdapter();
			}
			@Override
			public Adapter caseResult(Result object) {
				return createResultAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseDocumentMetaData(DocumentMetaData object) {
				return createDocumentMetaDataAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseRequestObject(RequestObject object) {
				return createRequestObjectAdapter();
			}
			@Override
			public Adapter caseRequestParameter(RequestParameter object) {
				return createRequestParameterAdapter();
			}
			@Override
			public Adapter caseResponseObject(ResponseObject object) {
				return createResponseObjectAdapter();
			}
			@Override
			public Adapter caseResponseParameter(ResponseParameter object) {
				return createResponseParameterAdapter();
			}
			@Override
			public Adapter caseInputProperty(InputProperty object) {
				return createInputPropertyAdapter();
			}
			@Override
			public Adapter caseOutputProperty(OutputProperty object) {
				return createOutputPropertyAdapter();
			}
			@Override
			public Adapter caseBpmn2_DocumentRoot(org.eclipse.bpmn2.DocumentRoot object) {
				return createBpmn2_DocumentRootAdapter();
			}
			@Override
			public Adapter caseModel_DocumentRoot(org.camunda.bpm.modeler.runtime.engine.model.DocumentRoot object) {
				return createModel_DocumentRootAdapter();
			}
			@Override
			public Adapter caseBaseElement(BaseElement object) {
				return createBaseElementAdapter();
			}
			@Override
			public Adapter caseItemAwareElement(ItemAwareElement object) {
				return createItemAwareElementAdapter();
			}
			@Override
			public Adapter caseBpmn2_Property(org.eclipse.bpmn2.Property object) {
				return createBpmn2_PropertyAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.OperationParameter <em>Operation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.OperationParameter
	 * @generated
	 */
	public Adapter createOperationParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.Result
	 * @generated
	 */
	public Adapter createResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData <em>Document Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.DocumentMetaData
	 * @generated
	 */
	public Adapter createDocumentMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestObject <em>Request Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestObject
	 * @generated
	 */
	public Adapter createRequestObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter <em>Request Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.RequestParameter
	 * @generated
	 */
	public Adapter createRequestParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseObject <em>Response Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseObject
	 * @generated
	 */
	public Adapter createResponseObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter <em>Response Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.ResponseParameter
	 * @generated
	 */
	public Adapter createResponseParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.InputProperty <em>Input Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.InputProperty
	 * @generated
	 */
	public Adapter createInputPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.casOpen.OutputProperty <em>Output Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.OutputProperty
	 * @generated
	 */
	public Adapter createOutputPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpmn2.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpmn2.DocumentRoot
	 * @generated
	 */
	public Adapter createBpmn2_DocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.camunda.bpm.modeler.runtime.engine.model.DocumentRoot
	 * @generated
	 */
	public Adapter createModel_DocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpmn2.BaseElement <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpmn2.BaseElement
	 * @generated
	 */
	public Adapter createBaseElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpmn2.ItemAwareElement <em>Item Aware Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpmn2.ItemAwareElement
	 * @generated
	 */
	public Adapter createItemAwareElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpmn2.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpmn2.Property
	 * @generated
	 */
	public Adapter createBpmn2_PropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CasOpenAdapterFactory
