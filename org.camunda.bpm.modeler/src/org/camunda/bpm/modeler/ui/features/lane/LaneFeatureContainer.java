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
package org.camunda.bpm.modeler.ui.features.lane;

import org.camunda.bpm.modeler.core.features.container.BaseElementFeatureContainer;
import org.camunda.bpm.modeler.core.features.lane.AddLaneFeature;
import org.camunda.bpm.modeler.core.features.lane.LayoutLaneFeature;
import org.camunda.bpm.modeler.core.features.lane.MoveLaneFeature;
import org.camunda.bpm.modeler.core.features.lane.ResizeLaneFeature;
import org.camunda.bpm.modeler.core.features.lane.UpdateLaneFeature;
import org.eclipse.bpmn2.Lane;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.custom.ICustomFeature;

public class LaneFeatureContainer extends BaseElementFeatureContainer {

	@Override
	public boolean canApplyTo(final Object o) {
		return super.canApplyTo(o) && o instanceof Lane;
	}

	@Override
	public ICreateFeature getCreateFeature(final IFeatureProvider fp) {
		return new CreateLaneFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(final IFeatureProvider fp) {
		return new AddLaneFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(final IFeatureProvider fp) {
		return new UpdateLaneFeature(fp);
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(final IFeatureProvider fp) {
		return null;
	}

	@Override
	public ILayoutFeature getLayoutFeature(final IFeatureProvider fp) {
		return new LayoutLaneFeature(fp);
	}

	@Override
	public IMoveShapeFeature getMoveFeature(final IFeatureProvider fp) {
		return new MoveLaneFeature(fp);
	}

	@Override
	public IResizeShapeFeature getResizeFeature(final IFeatureProvider fp) {
		return new ResizeLaneFeature(fp);
	}

	@Override
	public IDeleteFeature getDeleteFeature(final IFeatureProvider fp) {
		return new DeleteLaneFeature(fp);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(final IFeatureProvider fp) {
		ICustomFeature[] superFeatures = super.getCustomFeatures(fp);
		ICustomFeature[] thisFeatures = new ICustomFeature[1 + superFeatures.length];
		int i;
		for (i=0; i<superFeatures.length; ++i)
			thisFeatures[i] = superFeatures[i];
		thisFeatures[i++] = new RotateLaneFeature(fp);
		return thisFeatures;
	}
}