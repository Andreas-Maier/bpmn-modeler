package org.camunda.bpm.modeler.ui.features.label;

import org.camunda.bpm.modeler.core.utils.ConnectionLabelUtil;
import org.camunda.bpm.modeler.core.utils.LabelUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

/**
 * Special add feature for connection labels
 * 
 * @author nico.rehwaldt
 */
public class AddConnectionLabelFeature extends AbstractAddLabelFeature {

	public AddConnectionLabelFeature(final IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	protected void postAddHook(final IAddContext context, final ContainerShape newLabelShape) {
		super.postAddHook(context, newLabelShape);

		Connection connection = (Connection) LabelUtil.getNonLabelPictogramElement(newLabelShape, getDiagram());
		
		// update connection label references
		ConnectionLabelUtil.updateLabelRefAfterAdd(connection);
	}
}
