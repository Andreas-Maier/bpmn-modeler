package org.camunda.bpm.modeler.ui.property.tabs.tables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage;
import org.camunda.bpm.modeler.ui.property.tabs.builder.DefaultEditingSupportProvider.DropDownListCellEditor;
import org.camunda.bpm.modeler.ui.property.tabs.util.Events;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;

import com.google.common.base.Throwables;
import com.google.common.collect.BiMap;

import de.cas.open.prozesse.modeler.server.eimInterface.EIMInterfaceHolder;
import de.cas.open.prozesse.modeler.server.exceptions.ServerException;
import de.cas.open.server.api.exceptions.BusinessException;
import de.cas.open.server.api.exceptions.DataLayerException;

/**
 * Simple editing support for eobjects
 * 
 * @author nico.rehwaldt
 */
public class EObjectAttributeEditingSupport<T extends EObject> extends
		EditingSupport {

	private final TableViewer viewer;
	private final EStructuralFeature feature;

	public EObjectAttributeEditingSupport(final TableViewer viewer,
			final EStructuralFeature feature) {
		super(viewer);

		this.viewer = viewer;
		this.feature = feature;
	}

	@Override
	protected CellEditor getCellEditor(final Object element) {
		String featureName = this.feature.getName();

		if (featureName.equals("propertyType")) {
			List<String> values = new ArrayList<String>();
			try {
				BiMap<String, String> availableObjectTypesAndDisplayValues = EIMInterfaceHolder
						.getAvailableObjectTypesAndDisplayValues();
				for (BiMap.Entry<String, String> entry : availableObjectTypesAndDisplayValues
						.entrySet()) {
					values.add(entry.getValue());
				}
			} catch (BusinessException | DataLayerException | ServerException e) {
				Throwables.propagate(e);
			}
			Collections.sort(values);
			return new DropDownListCellEditor<String>(viewer.getTable(), values);
		} else {
			return new TextCellEditor(viewer.getTable());
		}
	}

	@Override
	protected boolean canEdit(final Object element) {
		return true;
	}

	protected String getValue(final T element) {
		Object value = getEValue(element);

		if (value == null) {
			return "";
		} else {
			return String.valueOf(value);
		}
	}

	protected Object getEValue(final T element) {
		return element.eGet(feature);
	}

	protected void setValue(final T element, final Object value) throws BusinessException,
			DataLayerException, ServerException {
		Object val = toEValue(value);
		Object oldVal = getEValue(element);

		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(element);

		final T elementRef = element;

		if (val == null) {
			editingDomain.getCommandStack().execute(
					new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							elementRef.eUnset(feature);
						}
					});
		} else if ((val != oldVal) || !val.equals(oldVal)) {
			if (CasOpenPackage.eINSTANCE.getInputProperty_PropertyType()
					.equals(this.feature)
					|| CasOpenPackage.eINSTANCE
							.getOutputProperty_PropertyType().equals(
									this.feature)) {
				val = EIMInterfaceHolder
						.getAvailableObjectTypesAndDisplayValues().inverse()
						.get(val);
			}
			ModelUtil.setValue(editingDomain, element, feature, val);
		}

		viewer.update(element, null);
	}
	protected Object toEValue(final Object value) {
		if (value instanceof String) {
			String str = (String) value;

			if (str.trim().isEmpty()) {
				return null;
			} else {
				return str;
			}
		}

		return value;
	}

	/**
	 * Provides update events for cell value
	 */
	@Override
	protected void saveCellEditorValue(final CellEditor cellEditor, final ViewerCell cell) {
		if (!cellEditor.isDirty()) {
			return;
		}

		T element = (T) cell.getElement();
		Object oldValue = getEValue(element);

		super.saveCellEditorValue(cellEditor, cell);

		Object newValue = getEValue(element);

		viewer.getTable().notifyListeners(
				Events.CELL_VALUE_CHANGED,
				new Events.CellValueChanged<T>(cell, element, newValue,
						oldValue));
	}

	@Override
	protected final void setValue(final Object element, final Object value) {
		try {
			setValue((T) element, value);
		} catch (BusinessException | DataLayerException | ServerException e) {
			Throwables.propagate(e);
		}
	}

	@Override
	protected final Object getValue(final Object element) {
		return getValue((T) element);
	}

}