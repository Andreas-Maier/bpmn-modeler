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
 * @author Bob Brodt
 ******************************************************************************/

package org.camunda.bpm.modeler.core.validation;

import java.util.List;

import org.camunda.bpm.modeler.Messages;
import org.camunda.bpm.modeler.core.Activator;
import org.camunda.bpm.modeler.core.utils.ErrorUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;

/**
 * @author Bob Brodt
 * 
 */
public class ProblemsReporter implements IValidationListener {
	public void validationOccurred(ValidationEvent event) {
		ErrorUtils.showErrorMessage(""); //$NON-NLS-1$
		// only report Live validation events here
		// Batch validation is done by the WST project validator during building.
		if (event.getEvaluationMode() == EvaluationMode.LIVE) {
			if (event.matches(IStatus.WARNING | IStatus.ERROR | IStatus.CANCEL)) {
				// fabricate a multi-errorList for the MarkerUtil to consume
				List<IConstraintStatus> results = event.getValidationResults();
				MultiStatus multi = new MultiStatus(Activator.PLUGIN_ID, 1,
						(IStatus[]) results.toArray(new IStatus[results.size()]), Messages.ProblemsReporter_1, null);

				for (IStatus s : results) {
					ErrorUtils.showErrorMessage(s.getMessage());
				}
			}
		}
	}
}