package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.FormDataType;
import org.camunda.bpm.modeler.runtime.engine.model.FormFieldType;
import org.camunda.bpm.modeler.runtime.engine.model.ModelFactory;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.ui.change.filter.AnyNestedChangeFilter;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.AbstractDeleteRowHandler;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.ContentProvider;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.DeleteRowHandler;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.EditRowHandler;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EditableEObjectTableBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.dialog.FormFieldDetailsDialog;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor.ElementFactory;
import org.camunda.bpm.modeler.ui.property.tabs.util.HelpText;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * Builder for form fields
 * 
 * @author kristin.polenz
 *
 */
public class FormFieldsPropertiesBuilder extends AbstractPropertiesBuilder<BaseElement> {

	public FormFieldsPropertiesBuilder(Composite parent, GFPropertySection section, BaseElement bo) {
		super(parent, section, bo);
	}
	
	private static final EStructuralFeature FORM_DATA_FEATURE = ModelPackage.eINSTANCE.getDocumentRoot_FormData();

	private static final String[] TABLE_HEADERS = { "id", "label"};
	
	private static final EStructuralFeature[] FORM_FIELDS_FEATURES = { 
		ModelPackage.eINSTANCE.getFormFieldType_Id(),
		ModelPackage.eINSTANCE.getFormFieldType_Label() };

	private TableViewer viewer;
	
	@Override
	public void create() {
		PropertyUtil.createNoteWithLink(section, parent, HelpText.SUPPORTED_VERSION_NOTE);
		EClass formFieldCls = ModelPackage.eINSTANCE.getFormFieldType();
		createMappingTable(section, parent, FormFieldType.class, "Form Fields", formFieldCls, FORM_DATA_FEATURE, FORM_FIELDS_FEATURES, TABLE_HEADERS);
	}

	protected <T extends EObject> void createMappingTable(
			final GFPropertySection section, final Composite parent, 
			final Class<T> typeCls, String label, final EClass typeECls, 
			final EStructuralFeature feature, EStructuralFeature[] columnFeatures, String[] columnLabels) {

		// composite for mappings table
		final Composite composite = PropertyUtil.createStandardComposite(section, parent);
		
		final ElementFactory<T> elementFactory = new ElementFactory<T>() {
			
			@Override
			public T create() {
				FormFieldType newFormField = transactionalCreateType();
				
				// create dialog with ok and cancel button and warning icon
				FormFieldDetailsDialog formFieldsDialog = new FormFieldDetailsDialog(section, composite.getShell(), newFormField);
				// open dialog and await user selection
				formFieldsDialog.open();

				return (T) newFormField;
			}
		};
		
		ContentProvider<T> contentProvider = new ContentProvider<T>() {

			@Override
			public List<T> getContents() {
				List<T> contents = new ArrayList<T>();
				
				List<FormDataType> formDataList = ExtensionUtil.getExtensions(bo, FormDataType.class);
				// formData exists only once in the extension value
				if(formDataList != null && !formDataList.isEmpty()) {
					FormDataType formData = formDataList.get(0);
					contents.addAll((List<T>) formData.getFormField());
				}
				return contents;
			}
		};
		
		DeleteRowHandler<T> deleteHandler = new AbstractDeleteRowHandler<T>() {
			@Override
			public void rowDeleted(T element) {
				transactionalRemoveMapping(element);
			}
		};
		
		EditRowHandler<T> editRowHandler = new EditRowHandler<T>() {

			@Override
			public void rowEdit(T element) {
				// create dialog with ok and cancel button and warning icon
				FormFieldDetailsDialog formFieldsDialog = new FormFieldDetailsDialog(section, composite.getShell(), (FormFieldType) element);
				// open dialog and await user selection
				formFieldsDialog.open();
			}

			@Override
			public boolean canEdit(T element) {
				return true;
			}
		};
		
		EditableEObjectTableBuilder<T> builder = new EditableEObjectTableBuilder<T>(section, composite, typeCls);
		
		builder
			.doubleClickEditRowHandler(editRowHandler)
			.elementFactory(elementFactory)
			.contentProvider(contentProvider)
			.columnFeatures(columnFeatures)
			.columnLabels(columnLabels)
			.deleteRowHandler(deleteHandler)
			.model(bo)
			.changeFilter(new AnyNestedChangeFilter(bo, feature));
		
		viewer = builder.build(false);
			
		// table composite ////////////
		final Composite tableComposite = viewer.getTable().getParent();

		// create label
		PropertyUtil.createLabel(section, composite, label, tableComposite);
	}
	
	protected void transactionalRemoveMapping(final EObject element) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
				// check whether form data exists
				FormDataType formData = null;
				List<FormDataType> formDataTypes = ExtensionUtil.getExtensions(bo, FormDataType.class);
				if(formDataTypes.isEmpty()) {
					ExtensionUtil.removeExtensionByFeature(bo, FORM_DATA_FEATURE);
				} else {
					// formData exists only once
					formData = formDataTypes.get(0);
					formData.getFormField().remove(element);
					// update model
					if (formData.getFormField().isEmpty()) {
						ExtensionUtil.removeExtensionByFeature(bo, FORM_DATA_FEATURE);
					} else {
						ExtensionUtil.updateExtension(bo, FORM_DATA_FEATURE, formData);
					}
				}
			}
		});
	}
	
	private FormFieldType transactionalCreateType() {

		final FormFieldType newFormField = ModelFactory.eINSTANCE.createFormFieldType();

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {

				// check whether form data already exists
				FormDataType formData = null;
				List<FormDataType> formDataTypes = ExtensionUtil.getExtensions(bo, FormDataType.class);
				if(formDataTypes.isEmpty()) {
					formData = ModelFactory.eINSTANCE.createFormDataType();
					ExtensionUtil.addExtension(bo, FORM_DATA_FEATURE, formData);
				} else {
					formData = formDataTypes.get(0);
				}

				// create new field
				formData.getFormField().add(newFormField);
			}
		});
		
		return newFormField;
	}

}
