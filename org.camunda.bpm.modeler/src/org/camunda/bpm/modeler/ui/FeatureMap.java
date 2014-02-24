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
package org.camunda.bpm.modeler.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.emf.ecore.EClass;

public class FeatureMap {
	
	public static final List<EClass> CONNECTORS;
	public static final List<EClass> EVENT_DEFINITIONS;
	public static final List<EClass> EVENTS;
	public static final List<EClass> GATEWAYS;
	public static final List<EClass> TASKS;
	public static final List<EClass> DATA;
	public static final List<EClass> OTHER;
	
	public static final List<EClass> EXCLUDE_CONNECTORS;
	public static final List<EClass> EXCLUDE_EVENT_DEFINITIONS;
	public static final List<EClass> EXCLUDE_EVENTS;
	public static final List<EClass> EXCLUDE_GATEWAYS;
	public static final List<EClass> EXCLUDE_TASKS;
	public static final List<EClass> EXCLUDE_DATA;
	public static final List<EClass> EXCLUDE_OTHER;
	
	static {
		
		ArrayList<EClass> features = new ArrayList<EClass>();
		features.add(Bpmn2Package.eINSTANCE.getSequenceFlow());
//		features.add(Bpmn2Package.eINSTANCE.getMessageFlow());
		features.add(Bpmn2Package.eINSTANCE.getAssociation());
//		features.add(Bpmn2Package.eINSTANCE.getDataAssociation());
		CONNECTORS = Collections.unmodifiableList(features);

		features = new ArrayList<EClass>();
		features.add(Bpmn2Package.eINSTANCE.getConditionalEventDefinition());
		features.add(Bpmn2Package.eINSTANCE.getTimerEventDefinition());
//		features.add(Bpmn2Package.eINSTANCE.getSignalEventDefinition());
//		features.add(Bpmn2Package.eINSTANCE.getMessageEventDefinition());
//		features.add(Bpmn2Package.eINSTANCE.getEscalationEventDefinition());
//		features.add(Bpmn2Package.eINSTANCE.getCompensateEventDefinition());
//		features.add(Bpmn2Package.eINSTANCE.getLinkEventDefinition());
//		features.add(Bpmn2Package.eINSTANCE.getErrorEventDefinition());
//		features.add(Bpmn2Package.eINSTANCE.getCancelEventDefinition());
		features.add(Bpmn2Package.eINSTANCE.getTerminateEventDefinition());
		EVENT_DEFINITIONS = Collections.unmodifiableList(features);

		features = new ArrayList<EClass>();
		features.add(Bpmn2Package.eINSTANCE.getStartEvent());
		features.add(Bpmn2Package.eINSTANCE.getEndEvent());
//		features.add(Bpmn2Package.eINSTANCE.getImplicitThrowEvent());
//		features.add(Bpmn2Package.eINSTANCE.getIntermediateThrowEvent());
//		features.add(Bpmn2Package.eINSTANCE.getIntermediateCatchEvent());
//		features.add(Bpmn2Package.eINSTANCE.getBoundaryEvent());
		EVENTS = Collections.unmodifiableList(features);

		features = new ArrayList<EClass>();
//		features.add(Bpmn2Package.eINSTANCE.getInclusiveGateway());
		features.add(Bpmn2Package.eINSTANCE.getExclusiveGateway());
		features.add(Bpmn2Package.eINSTANCE.getParallelGateway());
//		features.add(Bpmn2Package.eINSTANCE.getEventBasedGateway());
//		features.add(Bpmn2Package.eINSTANCE.getComplexGateway());

		GATEWAYS = Collections.unmodifiableList(features);

		features = new ArrayList<EClass>();
//		features.add(Bpmn2Package.eINSTANCE.getTask());
		features.add(Bpmn2Package.eINSTANCE.getManualTask());
		features.add(Bpmn2Package.eINSTANCE.getUserTask());
//		features.add(Bpmn2Package.eINSTANCE.getScriptTask());
//		features.add(Bpmn2Package.eINSTANCE.getBusinessRuleTask());
		features.add(Bpmn2Package.eINSTANCE.getServiceTask());
//		features.add(Bpmn2Package.eINSTANCE.getSendTask());
//		features.add(Bpmn2Package.eINSTANCE.getReceiveTask());
//		features.add(Bpmn2Package.eINSTANCE.getChoreographyTask());
		TASKS = Collections.unmodifiableList(features);

		features = new ArrayList<EClass>();
//		features.add(Bpmn2Package.eINSTANCE.getDataObjectReference());
//		features.add(Bpmn2Package.eINSTANCE.getDataStoreReference());
//		features.add(Bpmn2Package.eINSTANCE.getDataInput());
//		features.add(Bpmn2Package.eINSTANCE.getDataOutput());
		DATA = Collections.unmodifiableList(features);

		features = new ArrayList<EClass>();
		features.add(Bpmn2Package.eINSTANCE.getLane());
		features.add(Bpmn2Package.eINSTANCE.getParticipant());
		features.add(Bpmn2Package.eINSTANCE.getTextAnnotation());
//		features.add(Bpmn2Package.eINSTANCE.getSubProcess());
//		features.add(Bpmn2Package.eINSTANCE.getTransaction());
		features.add(Bpmn2Package.eINSTANCE.getGroup());
//		features.add(Bpmn2Package.eINSTANCE.getAdHocSubProcess());
//		features.add(Bpmn2Package.eINSTANCE.getCallActivity());
//		features.add(Bpmn2Package.eINSTANCE.getMessage());
//		features.add(Bpmn2Package.eINSTANCE.getConversation());
//		features.add(Bpmn2Package.eINSTANCE.getSubChoreography());
//		features.add(Bpmn2Package.eINSTANCE.getCallChoreography());
		OTHER = Collections.unmodifiableList(features);

		
		ArrayList<EClass> excludeFeatures = new ArrayList<EClass>();
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getSequenceFlow());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getMessageFlow());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getAssociation());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getDataAssociation());
		EXCLUDE_CONNECTORS = Collections.unmodifiableList(excludeFeatures);

		excludeFeatures = new ArrayList<EClass>();
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getConditionalEventDefinition());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getTimerEventDefinition());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getSignalEventDefinition());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getMessageEventDefinition());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getEscalationEventDefinition());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getCompensateEventDefinition());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getLinkEventDefinition());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getErrorEventDefinition());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getCancelEventDefinition());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getTerminateEventDefinition());
		EXCLUDE_EVENT_DEFINITIONS = Collections.unmodifiableList(excludeFeatures);

		excludeFeatures = new ArrayList<EClass>();
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getStartEvent());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getEndEvent());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getImplicitThrowEvent());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getIntermediateThrowEvent());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getIntermediateCatchEvent());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getBoundaryEvent());
		EXCLUDE_EVENTS = Collections.unmodifiableList(excludeFeatures);

		excludeFeatures = new ArrayList<EClass>();
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getInclusiveGateway());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getExclusiveGateway());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getParallelGateway());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getEventBasedGateway());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getComplexGateway());

		EXCLUDE_GATEWAYS = Collections.unmodifiableList(excludeFeatures);

		excludeFeatures = new ArrayList<EClass>();
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getTask());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getManualTask());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getUserTask());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getScriptTask());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getBusinessRuleTask());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getServiceTask());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getSendTask());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getReceiveTask());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getChoreographyTask());
		EXCLUDE_TASKS = Collections.unmodifiableList(excludeFeatures);

		excludeFeatures = new ArrayList<EClass>();
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getDataObjectReference());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getDataStoreReference());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getDataInput());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getDataOutput());
		EXCLUDE_DATA = Collections.unmodifiableList(excludeFeatures);

		excludeFeatures = new ArrayList<EClass>();
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getLane());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getParticipant());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getTextAnnotation());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getSubProcess());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getTransaction());
//		excludeFeatures.add(Bpmn2Package.eINSTANCE.getGroup());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getAdHocSubProcess());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getCallActivity());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getMessage());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getConversation());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getSubChoreography());
		excludeFeatures.add(Bpmn2Package.eINSTANCE.getCallChoreography());
		EXCLUDE_OTHER = Collections.unmodifiableList(excludeFeatures);

	}
}
