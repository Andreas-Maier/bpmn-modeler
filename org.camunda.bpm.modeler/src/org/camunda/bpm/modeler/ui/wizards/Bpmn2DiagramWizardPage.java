/******************************************************************************* 
 * Copyright (c) 2011 Red Hat, Inc. 
 *  All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 *
 * @author Innar Made
 ******************************************************************************/
package org.camunda.bpm.modeler.ui.wizards;

import org.camunda.bpm.modeler.Messages;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

public class Bpmn2DiagramWizardPage extends WizardPage {
	private Text containerText;

	private Text fileText;

	private ISelection selection;

	private IResource diagramContainer;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public Bpmn2DiagramWizardPage(ISelection selection) {
		super("wizardPage2"); //$NON-NLS-1$
		setTitle(Messages.Bpmn2DiagramWizardPage_1);
		setDescription(Messages.Bpmn2DiagramWizardPage_2);
		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText(Messages.Bpmn2DiagramWizardPage_3);

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText(Messages.Bpmn2DiagramWizardPage_4);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});
		label = new Label(container, SWT.NULL);
		label.setText(Messages.Bpmn2DiagramWizardPage_5);

		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		fileText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false, 2, 1));
		fileText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		updatePageDescription();
		updateFilename();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Tests if the current workbench selection is a suitable diagramContainer to use.
	 */

	private void updatePageDescription() {
		setDescription(Messages.Bpmn2DiagramWizardPage_6);
	}
	
	private void updateFilename() {
		String fileType = Messages.Bpmn2DiagramWizardPage_7;
		String filename = fileType+".bpmn"; //$NON-NLS-1$
		
		IContainer container = getFileContainer();
		if (container!=null) {
			String text = container.getFullPath().toString();
			if (text!=null && !text.equals(containerText.getText()))
				containerText.setText(text);
			for (int i=1; ; ++i) {
				filename = fileType+"_" + i + ".bpmn"; //$NON-NLS-1$ //$NON-NLS-2$
				IResource file = container.findMember(filename);
				if (file==null) {
					break;
				}
			}
		}

		String oldFileText = fileText.getText();
		if (filename!=null && !filename.equals(oldFileText))
			fileText.setText(filename);
	}

	private IContainer getFileContainer() {
		if (selection != null && selection.isEmpty() == false && selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() == 1) {
				Object obj = ssel.getFirstElement();
				if (obj instanceof IAdaptable) {
					Object res = ((IAdaptable)obj).getAdapter(IResource.class);
					if (res!=null)
						obj = res;
				}
				if (obj instanceof Path) {
					obj = ResourcesPlugin.getWorkspace().getRoot().findMember((Path)obj);
				}
				if (obj instanceof IResource) {
					if (obj instanceof IContainer) {
						return (IContainer) obj;
					} else {
						return ((IResource) obj).getParent();
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			updatePageDescription();
			updateFilename();
		}
		super.setVisible(visible);
	}

	/**
	 * Uses the standard diagramContainer selection dialog to choose the new value for the diagramContainer field.
	 */

	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace()
				.getRoot(), false, Messages.Bpmn2DiagramWizardPage_11);
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				selection = new TreeSelection(new TreePath(result));
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		diagramContainer = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getContainerName()));
		String fileName = getFileName();

		if (getContainerName().length() == 0) {
			updateStatus(Messages.Bpmn2DiagramWizardPage_12);
			return;
		}
		if (diagramContainer == null || (diagramContainer.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			updateStatus(Messages.Bpmn2DiagramWizardPage_13);
			return;
		}
		if (!diagramContainer.isAccessible()) {
			updateStatus(Messages.Bpmn2DiagramWizardPage_14);
			return;
		}
		if (fileName.length() == 0) {
			updateStatus(Messages.Bpmn2DiagramWizardPage_15);
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus(Messages.Bpmn2DiagramWizardPage_16);
			return;
		}
		int dotLoc = fileName.lastIndexOf('.');
		if (dotLoc != -1) {
			String ext = fileName.substring(dotLoc + 1);
			if (ext.equalsIgnoreCase("bpmn") == false && ext.equalsIgnoreCase("bpmn2") == false) { //$NON-NLS-1$ //$NON-NLS-2$
				updateStatus(Messages.Bpmn2DiagramWizardPage_19);
				return;
			}
		}
		
		updateStatus(null);
	}

	@Override
	public boolean isPageComplete() {
		IContainer container = getFileContainer();
		if (container!=null) {
			String filename = fileText.getText();
			IResource file = container.findMember(filename);
			if (file==null) {
				return true;
			}
			else
				setErrorMessage(Messages.Bpmn2DiagramWizardPage_20+filename+Messages.Bpmn2DiagramWizardPage_21);
		}
		return false;
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getContainerName() {
		return containerText.getText();
	}

	public String getFileName() {
		return fileText.getText();
	}

	public IResource getDiagramContainer() {
		return diagramContainer;
	}
}