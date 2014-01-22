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
 * @author Ivar Meikas
 ******************************************************************************/
package org.camunda.bpm.modeler.core.features.data;

import org.camunda.bpm.modeler.core.features.AbstractBpmn2CreateFeature;
import org.camunda.bpm.modeler.core.utils.BusinessObjectUtil;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

public abstract class AbstractCreateRootElementFeature<T extends RootElement> extends AbstractBpmn2CreateFeature<T> {

	public AbstractCreateRootElementFeature(final IFeatureProvider fp, final String name, final String description) {
	    super(fp, name, description);
    }

	@Override
    public boolean canCreate(final ICreateContext context) {
	    return true;
    }

	@Override
    public Object[] create(final ICreateContext context) {
		RootElement element = createBusinessObject(context);
		// Fix for message(root element) handling. Those had not been added to
		// the process and therefore no resource attached.
		Definitions defs = ModelUtil.getDefinitions(BusinessObjectUtil
				.getBusinessObjectForPictogramElement(context
						.getTargetContainer()));
		defs.getRootElements().add(element);
		addGraphicalRepresentation(context, element);
		return new Object[] { element };
    }
	
	protected abstract String getStencilImageId();
	
	@Override
	public String getCreateImageId() {
	    return getStencilImageId();
	}
	
	@Override
	public String getCreateLargeImageId() {
	    return getStencilImageId();
	}
}
