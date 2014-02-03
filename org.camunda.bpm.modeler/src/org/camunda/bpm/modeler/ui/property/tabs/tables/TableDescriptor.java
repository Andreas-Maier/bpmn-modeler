package org.camunda.bpm.modeler.ui.property.tabs.tables;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.layout.fix.TableColumnLayout2;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public abstract class TableDescriptor<T> {
	
	private List<TableColumnDescriptor> columns;
	
	/**
	 * Sets the table column descriptors
	 * 
	 * @param columns
	 */
	public void setColumns(final TableColumnDescriptor ... columns) {
		this.columns = Arrays.asList(columns);
	}
	
	/**
	 * Sets the table column descriptors
	 * 
	 * @param columns
	 */
	public void setColumns(final List<TableColumnDescriptor> columns) { 
		this.columns = columns;
	}
	
	/**
	 * Returns the table column descriptors for the table
	 * 
	 * @param columns
	 */
	public List<TableColumnDescriptor> getColumns() {
		return columns;
	}
	
	/**
	 * Returns the content provider for the table.
	 * 
	 * @return
	 */
	public IStructuredContentProvider getContentProvider() {
		return ArrayContentProvider.getInstance();
	}
	
	public void configure(final Table table) {
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}
	
	public void configureViewer(final TableViewer viewer) {
		viewer.setContentProvider(getContentProvider());
		configure(viewer.getTable());
	}
	
	/**
	 * Creates a new table viewer from the given descriptor
	 * 
	 * @return
	 */
	public TableViewer createTableViewer(final Composite parent) {
		return createTableViewer(parent, this);
	}

	/**
	 * Creates a table viewer on the specified parent, defined by the 
	 * passed table descriptor.
	 * 
	 * @param parent
	 * @param tableDescriptor
	 * @return
	 */
	private TableViewer createTableViewer(final Composite parent, final TableDescriptor<?> tableDescriptor) {
		
		TableColumnLayout2 tableColumnLayout = new TableColumnLayout2();
		
		parent.setLayout(tableColumnLayout);
		
		TableViewer viewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER);
		
		tableDescriptor.configureViewer(viewer);
		
		createColumns(viewer, tableColumnLayout, tableDescriptor.getColumns());
		
		return viewer;
	}

	/**
	 * Create columns for the table
	 * 
	 * @param viewer
	 * @param layout 
	 * @param tableColumnDescriptors
	 */
	private void createColumns(final TableViewer viewer,
			final TableColumnLayout2 layout, final List<TableColumnDescriptor> tableColumnDescriptors) {

		for (TableColumnDescriptor descriptor : tableColumnDescriptors) {
			createColumn(viewer, layout, descriptor);
		}
	}

	/**
	 * Create a single column for the viewer embedded in the given layout
	 * 
	 * @param viewer
	 * @param layout
	 * @param descriptor
	 */
	protected TableViewerColumn createColumn(final TableViewer viewer, final TableColumnLayout2 layout, final TableColumnDescriptor descriptor) {
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		
		descriptor.configureViewer(viewer, viewerColumn, layout);
		
		return viewerColumn;
	}
}