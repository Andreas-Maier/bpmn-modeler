package org.camunda.bpm.modeler.test.util.operations;

import org.camunda.bpm.modeler.ui.features.event.AbstractMorphEventFeature;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public abstract class AbstractMorphEventOperation<T, V extends AbstractMorphEventOperation<T, V>> extends AbstractMorphFlowNodeOperation<AbstractMorphEventFeature, V> {

	public AbstractMorphEventOperation(IDiagramTypeProvider diagramTypeProvider, PictogramElement element, Class<V> cls) {
		super(diagramTypeProvider, element, cls);
	}

}
