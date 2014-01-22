package org.camunda.bpm.modeler.ui.features.label;

import org.camunda.bpm.modeler.core.di.DIUtils;
import org.camunda.bpm.modeler.core.features.DefaultBpmn2ResizeShapeFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class ResizeConnectionLabelFeature extends DefaultBpmn2ResizeShapeFeature {

	public ResizeConnectionLabelFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void updateDi(final Shape shape) {
		DIUtils.updateDILabel(shape, DIUtils.getShape(shape));
	}
	
}
