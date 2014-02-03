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
package org.camunda.bpm.modeler.ui.features.gateway;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.core.features.api.IDecorateFeature;
import org.camunda.bpm.modeler.core.features.gateway.AbstractCreateGatewayFeature;
import org.camunda.bpm.modeler.core.features.gateway.AddGatewayFeature;
import org.camunda.bpm.modeler.core.features.gateway.GatewayDecorateFeature;
import org.camunda.bpm.modeler.core.utils.BusinessObjectUtil;
import org.camunda.bpm.modeler.core.utils.GraphicsUtil;
import org.camunda.bpm.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ExclusiveGateway;
import org.eclipse.bpmn2.di.BPMNShape;
import org.eclipse.bpmn2.di.BpmnDiPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class ExclusiveGatewayFeatureContainer extends AbstractGatewayFeatureContainer {

	@Override
	public boolean canApplyTo(Object o) {
		return super.canApplyTo(o) && o instanceof ExclusiveGateway;
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddGatewayFeature<ExclusiveGateway>(fp);
	}

	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateExclusiveGatewayFeature(fp);
	}

	@Override
	public IDecorateFeature getDecorateFeature(IFeatureProvider fp) {
		return new GatewayDecorateFeature(fp) {
			@Override
			protected void decorate(Shape shape, Polygon decorateContainer) {
				super.decorate(shape, decorateContainer);
				
				BPMNShape bpmnShape = BusinessObjectUtil.getFirstElementOfType(shape, BPMNShape.class);
				
				// TODO: handle showExclusiveGatewayMarker property change event in BPMN2Editor
				// and override the default gateway UpdateFeature to show/hide the "X" marker.
				
				// make sure we hide the X only if isMarkerVisible="false" is set
				if (!bpmnShape.eIsSet(BpmnDiPackage.eINSTANCE.getBPMNShape_IsMarkerVisible()) || bpmnShape.isIsMarkerVisible()) {
					GraphicsUtil.createGatewayDiagonalCross(decorateContainer);
				}
			}
		};
	}

	public static class CreateExclusiveGatewayFeature extends AbstractCreateGatewayFeature<ExclusiveGateway> {

		public CreateExclusiveGatewayFeature(IFeatureProvider fp) {
			super(fp, Messages.ExclusiveGatewayFeatureContainer_0, Messages.ExclusiveGatewayFeatureContainer_1);
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_EXCLUSIVE_GATEWAY;
		}

		/* (non-Javadoc)
		 * @see org.camunda.bpm.modeler.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getExclusiveGateway();
		}
	}
}