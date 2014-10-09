package org.camunda.bpm.modeler.ui.property.tabs.tables;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnLabelProvider;

import com.google.common.base.Throwables;

import de.cas.open.prozesse.modeler.server.exceptions.ServerException;
import de.cas.open.server.api.exceptions.BusinessException;
import de.cas.open.server.api.exceptions.DataLayerException;

/**
 * A typed column label provider
 * 
 * @author nico.rehwaldt
 * 
 * @param <T>
 */
public abstract class TypedColumnLabelProvider<T extends EObject> extends
		ColumnLabelProvider {

	@Override
	public final String getText(Object element) {
		try {
			return getText((T) element);
		} catch (BusinessException | DataLayerException | ServerException e) {
			Throwables.propagate(e);
		}
		return null;
	}

	/**
	 * Returns the string of the column cell for a given object.
	 * 
	 * @param element
	 * @return
	 * @throws ServerException
	 * @throws DataLayerException
	 * @throws BusinessException
	 */
	public abstract String getText(T element) throws BusinessException,
			DataLayerException, ServerException;
}