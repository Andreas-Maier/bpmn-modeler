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
package org.camunda.bpm.modeler.ui.diagram.editor;

import org.camunda.bpm.modeler.core.utils.ModelUtil.Bpmn2DiagramType;
import org.eclipse.bpmn2.di.BPMNDiagram;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.part.FileEditorInput;

public final class Bpmn2DiagramEditorInput extends DiagramEditorInput {

	private final TransactionalEditingDomain domain;
	private Bpmn2DiagramType initialDiagramType = Bpmn2DiagramType.NONE;
	private String targetNamespace;
	private BPMNDiagram bpmnDiagram;
	private URI modelUri;
	
	public Bpmn2DiagramEditorInput(final URI modelUri, final URI diagramUri, final TransactionalEditingDomain domain, final String providerId) {
		// means : DiagramEditorInput.uri = diagramUri
		super(diagramUri, providerId);
		this.domain = domain;
		this.modelUri = modelUri;
	}
	
	public Bpmn2DiagramType getInitialDiagramType() {
		return initialDiagramType;
	}

	public void setInitialDiagramType(final Bpmn2DiagramType initialDiagramType) {
		this.initialDiagramType = initialDiagramType;
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(final String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public URI  getModelUri() {
		return modelUri;
	}
	
	/**
	 * We are using the original URI field to store the graphiti diagram uri
	 * @return
	 */
	public URI  getDiagramUri() {
		return getUri();
	}
	
	@Override
	public String getToolTipText() {
		return modelUri.toPlatformString(true);
	}
	
	@Override
	public String getName() {
		return URI.decode(modelUri.trimFileExtension().lastSegment());
	}
	
	@Override
	public void updateUri(final URI diagramFileUri) {
		if (diagramFileUri.isPlatformResource()) {
			modelUri = diagramFileUri;
		}
		else
			super.updateUri(diagramFileUri);
	}
	
	@Override
	public boolean equals(final Object obj) {
		boolean superEquals = super.equals(obj);
		if (superEquals) {
			return true;
		}

		// Eclipse makes FileEditorInputs for files to be opened. Here we check if the file is actually the same
		// as the DiagramEditorInput uses. This is for preventing opening new editors for the same file.
		if (obj instanceof FileEditorInput) {

			String path = ((FileEditorInput) obj).getFile().getFullPath().toString();
			URI platformUri = URI.createPlatformResourceURI(path, true);

			for (Resource resource : domain.getResourceSet().getResources()) {
				if (resource.getURI().equals(platformUri)) {
					return true;
				}
			}

		}
		
		if (obj instanceof Bpmn2DiagramEditorInput) {
			return ((Bpmn2DiagramEditorInput) obj).getDiagramUri().equals(getDiagramUri());
		}
		
		return false;
	}

	public BPMNDiagram getBpmnDiagram() {
		return bpmnDiagram;
	}

	public void setBpmnDiagram(final BPMNDiagram bpmnDiagram) {
		this.bpmnDiagram = bpmnDiagram;
	}
	
	@Override
	public String getFactoryId() {
		return Bpmn2DiagramEditorInputFactory.class.getName();
		
	}
	
	@Override
	public void saveState(final IMemento memento) {
		super.saveState(memento);
		/**
		 * We are storing the modelUri in the uri field of the DiagramEditorInput
		 */
		memento.putString(KEY_URI, this.modelUri.toString());
	}
}