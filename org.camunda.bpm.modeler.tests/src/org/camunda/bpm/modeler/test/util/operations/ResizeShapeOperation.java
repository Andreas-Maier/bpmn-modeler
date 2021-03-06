package org.camunda.bpm.modeler.test.util.operations;

import org.camunda.bpm.modeler.core.layout.util.LayoutUtil;
import org.camunda.bpm.modeler.core.layout.util.LayoutUtil.Sector;
import org.camunda.bpm.modeler.core.layout.util.RectangleUtil;
import org.eclipse.graphiti.datatypes.IRectangle;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IResizeFeature;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Operation for resizing shapes.
 * 
 * @author nico.rehwaldt
 */
public class ResizeShapeOperation extends Operation<ResizeShapeContext, IResizeFeature> {

	public ResizeShapeOperation(Shape shape, IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
		
		this.context = createContext(shape);
	}

	public ResizeShapeOperation to(IRectangle bounds, int direction) {

		context.setLocation(bounds.getX(), bounds.getY());
		context.setSize(bounds.getWidth(), bounds.getHeight());
		context.setDirection(direction);
		
		return this;
	}

	public Operation<ResizeShapeContext, IResizeFeature> by(Point resizeDelta, Sector resizeDirection) {

		IRectangle shapeBounds = LayoutUtil.getRelativeBounds(context.getShape());
		IRectangle postResizeRectangle = RectangleUtil.resize(shapeBounds, resizeDelta, resizeDirection);
		
		return to(postResizeRectangle, resizeDirection.toResizeDirection());
	}
	
	public Operation<ResizeShapeContext, IResizeFeature> fromTopLeftBy(Point amount) {
		return by(amount, Sector.TOP_LEFT);
	}

	public Operation<ResizeShapeContext, IResizeFeature> fromTopRightBy(Point amount) {
		return by(amount, Sector.TOP_RIGHT);
	}
	
	public Operation<ResizeShapeContext, IResizeFeature> fromBottomRightBy(Point amount) {
		return by(amount, Sector.BOTTOM_RIGHT);
	}

	public Operation<ResizeShapeContext, IResizeFeature> fromBottomLeftBy(Point amount) {
		return by(amount, Sector.BOTTOM_LEFT);
	}
	
	protected ResizeShapeContext createContext(Shape shape) {
		return new ResizeShapeContext(shape);
	}

	@Override
	protected ResizeShapeContext createContext() {
		throw new UnsupportedOperationException("Use #createContext(Shape)");
	}

	@Override
	protected IResizeFeature createFeature(ResizeShapeContext context) {
		return diagramTypeProvider.getFeatureProvider().getResizeShapeFeature(context);
	}
	
	///// static helpers ////////////////////////////////////
	
	public static ResizeShapeOperation resize(Shape shape, IDiagramTypeProvider diagramTypeProvider) {
		return new ResizeShapeOperation(shape, diagramTypeProvider);
	}
}
