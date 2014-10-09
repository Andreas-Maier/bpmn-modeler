package org.camunda.bpm.modeler.ui.property.tabs.tables;

import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

import de.cas.open.prozesse.modeler.server.eimInterface.EIMInterfaceHolder;
import de.cas.open.prozesse.modeler.server.exceptions.ServerException;
import de.cas.open.server.api.exceptions.BusinessException;
import de.cas.open.server.api.exceptions.DataLayerException;

/**
 * A column descriptor which maps to an eAttribute of a eObject.
 * 
 * @author nico.rehwaldt
 * 
 * @param <T>
 */
public class EObjectAttributeTableColumnDescriptor<T extends EObject> extends
		TableColumnDescriptor {

	private final EStructuralFeature feature;

	private EditingSupportProvider editingSupportProvider;

	public EObjectAttributeTableColumnDescriptor(
			final EStructuralFeature feature, final String title,
			final int weight) {
		super(title, weight);

		this.feature = feature;
	}

	/**
	 * Returns the string value of an object
	 * 
	 * @return
	 */
	@Override
	public ColumnLabelProvider getColumnLabelProvider() {
		ColumnLabelProvider labelProvider = new TypedColumnLabelProvider<T>() {

			@Override
			public String getText(final T element) throws BusinessException,
					DataLayerException, ServerException {
				Object value = element.eGet(feature);
				if (value == null) {
					return "";
				} else {
					if (CasOpenPackage.eINSTANCE
							.getInputProperty_PropertyType().equals(feature)
							|| CasOpenPackage.eINSTANCE
									.getOutputProperty_PropertyType().equals(
											feature)) {
						return EIMInterfaceHolder
								.getAvailableObjectTypesAndDisplayValues().get(
										String.valueOf(element.eGet(feature)));
					} else {
						return String.valueOf(element.eGet(feature));
					}
				}
			}
		};

		return labelProvider;
	}

	@Override
	public EditingSupport getEditingSupport(final TableViewer viewer,
			final boolean editable) {
		if (editingSupportProvider != null) {
			return editingSupportProvider.getEditingSupport(viewer, feature);
		} else if (!editable) {
			return null;
		} else {
			return new EObjectAttributeEditingSupport<EObject>(viewer, feature);
		}
	}

	/**
	 * Set a custom editing support provider for this table column descriptor
	 * 
	 * @param editingSupportProvider
	 */
	public void setEditingSupportProvider(
			final EditingSupportProvider editingSupportProvider) {
		this.editingSupportProvider = editingSupportProvider;
	}

	/**
	 * Provider of custom editing support for an EObject attribute
	 * 
	 * @author nico.rehwaldt
	 */
	public static interface EditingSupportProvider {

		/**
		 * Provides editing support for the table
		 * 
		 * @param viewer
		 * @param feature
		 * @return
		 */
		public EditingSupport getEditingSupport(TableViewer viewer,
				EStructuralFeature feature);
	}
}