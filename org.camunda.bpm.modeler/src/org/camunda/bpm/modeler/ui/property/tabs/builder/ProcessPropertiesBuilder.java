package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.ui.change.filter.FeatureChangeFilter;
import org.camunda.bpm.modeler.ui.change.filter.IsManyAttributeAnyChildChangeFilter;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.ContentProvider;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataObjectReference;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.Property;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;

public class ProcessPropertiesBuilder extends AbstractPropertiesBuilder<Process> {

	private static final EStructuralFeature IS_EXECUTABLE = Bpmn2Package.eINSTANCE.getProcess_IsExecutable();

	private static final EStructuralFeature FLOW_ELEMENTS_FEATURE = Bpmn2Package.eINSTANCE.getProcess_Properties();

	private static final String[] DATA_OBJECT_TABLE_HEADERS = { "Name" }; //$NON-NLS-1$

	private static final EStructuralFeature[] DATA_OBJECT_FEATURES = {
		Bpmn2Package.eINSTANCE.getProperty_Name() };

	public ProcessPropertiesBuilder(final Composite parent, final GFPropertySection section, final Process bo) {
		super(parent, section, bo);
	}

	@Override
	public void create() {
		PropertyUtil.createCheckbox(section, parent, Messages.ProcessPropertiesBuilder_1, IS_EXECUTABLE, bo);
		
		createDataObjectMappingsTable();
	}

	public void createDataObjectMappingsTable() {
		EClass dataObjectECls = Bpmn2Package.eINSTANCE.getProperty();
		createMappingsTable(section, parent, Property.class, Messages.ProcessPropertiesBuilder_2, dataObjectECls, FLOW_ELEMENTS_FEATURE, DATA_OBJECT_FEATURES, DATA_OBJECT_TABLE_HEADERS);
	}

	protected <T extends EObject> void createMappingsTable(
			final GFPropertySection section, final Composite parent,
			final Class<T> typeCls, final String label, final EClass typeECls,
			final EStructuralFeature feature, final EStructuralFeature[] columnFeatures, final String[] columnLabels) {

		// composite for mappings table
		final Composite composite = PropertyUtil.createStandardComposite(section, parent);

//		ElementFactory<T> elementFactory = new ElementFactory<T>() {
//
//			@Override
//			public T create() {
//				T instance = (T) transactionalCreateType(typeECls, feature);
//				return instance;
//			}
//		};

		final ContentProvider<T> contentProvider = new ContentProvider<T>() {

			@Override
			public List<T> getContents() {
				List<Property> properties = ModelUtil.getAllProperties(bo);;
				List<Property> uniqueProperties = new ArrayList<>();
				Set<String> uniquePropertyNames = new HashSet<>();
				for (Property property : properties) {
					if (!uniquePropertyNames.contains(property.getName())) {
						uniquePropertyNames.add(property.getName());
						uniqueProperties.add(property);
					}
				}
				return (List<T>) uniqueProperties;
			}
		};

//		DeleteRowHandler<T> deleteHandler = new DeleteRowHandler<T>() {
//
//			@Override
//			public void rowDeleted(final T element) {
//				transactionalRemoveMapping(element, feature);
//			}
//
//			@Override
//			public boolean canDelete(final T element) {
//				// create dialog with ok and cancel button and warning icon
//				MessageBox dialog = new MessageBox(parent.getShell(), SWT.ICON_WARNING | SWT.OK| SWT.CANCEL);
//				dialog.setMessage(Messages.ProcessPropertiesBuilder_3);
//
//				// open dialog and await user selection
//				int returnCode = dialog.open();
//				if (returnCode == SWT.OK) {
//					return true;
//				}
//
//				return false;
//			}
//		};

		EObjectTableBuilder<T> builder = new EObjectTableBuilder<T>(section, composite, typeCls);

		builder
//			.elementFactory(elementFactory)
			.contentProvider(contentProvider)
			.columnFeatures(columnFeatures)
			.columnLabels(columnLabels)
//			.deleteRowHandler(deleteHandler)
			.model(bo)
			.changeFilter(
				new IsManyAttributeAnyChildChangeFilter(bo, feature)
					.or(new FeatureChangeFilter(bo, feature)));

		final TableViewer viewer = builder.build();

		// table composite ////////////
		final Composite tableComposite = viewer.getTable().getParent();

		// create label
		PropertyUtil.createLabel(section, composite, label, tableComposite);

	}

	protected void transactionalRemoveMapping(final EObject element, final EStructuralFeature feature) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				// get the right container which contains the data object,
				// that must be not the process it can be a sub process too
				EObject container = element.eContainer();
				EList<EObject> list = (EList<EObject>) container.eGet(feature);

				removeDangelingObjectRefs(element);
				
				list.remove(element);
			}
		});
	}

	private EObject transactionalCreateType(final EClass typeCls, final EStructuralFeature feature) {
		final Property instance = (Property) Bpmn2Factory.eINSTANCE.create(typeCls);

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				EList<EObject> list = (EList<EObject>) bo.eGet(feature);
				list.add(instance);

				ModelUtil.setID(instance);
			}
		});

		return instance;
	}

	private void removeDangelingObjectRefs(final EObject element) {
		// get the DiagramEditor to be able to get the feature provider
		DiagramEditor editor = ModelUtil.getEditor(bo);
		IDiagramTypeProvider diagramTypeProvider = editor.getDiagramTypeProvider();
		IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
		Diagram diagram = diagramTypeProvider.getDiagram();
		
		// get all data object references from the current container
		// including the children of the container
		List<DataObjectReference> dataObjectReferences = ModelUtil.getAllReachableObjects(element.eContainer(), DataObjectReference.class);
		
		for (DataObjectReference dataObjectReference : dataObjectReferences) {
			if (element.equals(dataObjectReference.getDataObjectRef())) {
				// if the data object reference references the data object to delete,
				// then create a delete context for the data object reference and delete it
				// via the right delete feature.
				PictogramElement pe = Graphiti.getLinkService().getPictogramElements(diagram, dataObjectReference).get(0);
				IDeleteContext context = new DeleteContext(pe);

				IDeleteFeature deleteFeature = featureProvider.getDeleteFeature(context);
				deleteFeature.delete(context);
			}
		}
	}
}
