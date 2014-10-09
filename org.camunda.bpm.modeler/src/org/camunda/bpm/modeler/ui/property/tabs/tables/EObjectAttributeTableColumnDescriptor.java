package org.camunda.bpm.modeler.ui.property.tabs.tables;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

/**
 * A column descriptor which maps to an eAttribute of a eObject.
 * 
 * @author nico.rehwaldt
 *
 * @param <T>
 */
public class EObjectAttributeTableColumnDescriptor<T extends EObject> extends TableColumnDescriptor {

	private final EStructuralFeature feature;

	private EditingSupportProvider editingSupportProvider;
	
	public EObjectAttributeTableColumnDescriptor(final EStructuralFeature feature, final String title, final int weight) {
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
			public String getText(final T element) {
				Object value = element.eGet(feature);
				if (value == null) {
					return "";
				} else {
					return String.valueOf(element.eGet(feature));
				}
			}
		};

		return labelProvider;
	}
	
	@Override
	public EditingSupport getEditingSupport(final TableViewer viewer) {
		if (editingSupportProvider != null) {
			return editingSupportProvider.getEditingSupport(viewer, feature);
		} else {
			return new EObjectAttributeEditingSupport<EObject>(viewer, feature);
//			return null;
		}
	}

	/**
	 * Set a custom editing support provider for this table column descriptor
	 * 
	 * @param editingSupportProvider
	 */
	public void setEditingSupportProvider(final EditingSupportProvider editingSupportProvider) {
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
		public EditingSupport getEditingSupport(TableViewer viewer, EStructuralFeature feature);
	}
}