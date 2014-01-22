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

import java.io.IOException;

import org.camunda.bpm.modeler.core.utils.ModelUtil.Bpmn2DiagramType;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.ui.diagram.editor.Bpmn2DiagramEditorInput;
import org.camunda.bpm.modeler.ui.diagram.editor.Bpmn2Editor;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.util.Bpmn2Resource;
import org.eclipse.bpmn2.util.Bpmn2ResourceFactoryImpl;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;

public class Bpmn2DiagramCreator {
	
	public static Bpmn2Resource createBpmn2Resource(final URI uri) {
		Definitions definitions = createDefinitions(uri);
		
		try {
			definitions.eResource().save(null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return (Bpmn2Resource) definitions.eResource();
	}
	
	public static Definitions createDefinitions(final URI uri) {
		// set targetNamespace because it is a mandatory field
		// the process engine can not deploy the process model without targetNamespace 
		Definitions definitions = new Bpmn2ResourceFactoryImpl().createAndInitResource(uri);
		definitions.setTargetNamespace(ModelPackage.eNS_URI);
		return definitions;
	}
	
	public static Bpmn2DiagramEditorInput createDiagramInput(final URI uri, final Bpmn2DiagramType diagramType, final String targetNamespace) throws CoreException {
		return createDiagramInput(uri, diagramType, targetNamespace, null);
	}

	public static Bpmn2DiagramEditorInput createDiagramInput(final URI modelUri, final Bpmn2DiagramType diagramType, final String targetNamespace, final Bpmn2Editor diagramEditor) throws CoreException {

		if (modelUri == null) {
			throw new RuntimeException("Unresolvable model uri; Please clean workspace");
		}
		
		String modelName = modelUri.trimFragment().trimFileExtension().lastSegment();
		final Diagram diagram = Graphiti.getPeCreateService().createDiagram("BPMN2", modelName, true);

		String diagramName = FileService.createTempName(modelName);
		URI diagramUri = URI.createFileURI(diagramName);
		TransactionalEditingDomain domain = FileService.createEmfFileForDiagram(diagramUri, diagram, diagramEditor);

		String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		final Bpmn2DiagramEditorInput editorInput = new Bpmn2DiagramEditorInput(modelUri, diagramUri, domain, providerId);
		editorInput.setInitialDiagramType(diagramType);
		editorInput.setTargetNamespace(targetNamespace);

		return editorInput;
	}
}
