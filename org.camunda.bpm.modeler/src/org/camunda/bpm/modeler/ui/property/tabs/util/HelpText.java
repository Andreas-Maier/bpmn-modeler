package org.camunda.bpm.modeler.ui.property.tabs.util;

import org.camunda.bpm.modeler.Messages;


/**
 * Help texts used by the application
 * 
 * @author nico.rehwaldt
 */
public class HelpText {

	public static final String SUPPORTED_VERSION_NOTE = Messages.HelpText_0;

	public static final String TABLE_HELP = Messages.HelpText_1;
	
	public static final String TIME_DATE = Messages.HelpText_2;
	public static final String TIME_DURATION = Messages.HelpText_3;
	public static final String TIME_CYCLE = Messages.HelpText_4;

	public static final String ELEMENT_DEF_TABLE = Messages.HelpText_5;

	private static final String ASYNC_LINK_TO_USER_GUIDE = 
			"http://docs.camunda.org/latest/guides/user-guide/#process-engine-transactions-in-processes-asynchronous-continuations"; //$NON-NLS-1$
	
	private static final String CALL_ACTIVITY_VARIABLES_GUIDE = "http://docs.camunda.org/latest/api-references/bpmn20/#subprocesses-call-activity-passing-variables"; //$NON-NLS-1$
	private static final String CALL_ACTIVITY_BUSINESS_KEY_GUIDE = "http://docs.camunda.org/latest/api-references/bpmn20/#subprocesses-call-activity-passing-business-key"; //$NON-NLS-1$

	private static final String LINK_EVENT_DEFINITION_USER_GUIDE = "http://docs.camunda.org/latest/api-references/bpmn20/#events-link-events"; //$NON-NLS-1$

	private static final String COMPENSATION_THROWING_EVENT_USER_GUIDE = "http://docs.camunda.org/latest/api-references/bpmn20/#events-cancel-and-compensation-events-compensation-intermediate-throwing-event"; //$NON-NLS-1$

	private static final String MULTI_INSTANCE_USER_GUIDE = "http://docs.camunda.org/latest/api-references/bpmn20/#tasks-task-markers-multiple-instance"; //$NON-NLS-1$

	private static final String IS_LOOP_USER_GUIDE = "http://docs.camunda.org/latest/api-references/bpmn20/#tasks-task-markers-loops"; //$NON-NLS-1$

	private static final String SIGNAL_THROW_EVENT_USER_GUIDE = "http://docs.camunda.org/latest/api-references/bpmn20/#events-signal-events-signal-intermediate-throwing-event"; //$NON-NLS-1$

	public static final String ASYNC_FLAG = String.format(
			Messages.HelpText_14, ASYNC_LINK_TO_USER_GUIDE);

	public static final String CALL_ACTIVITY_CALLED_ELEMENT_VERSION = Messages.HelpText_15; 

	public static final String CALL_ACTIVITY_ALL_VARIABLES_IN = String.format(
	    Messages.HelpText_16, CALL_ACTIVITY_VARIABLES_GUIDE);

	public static final String CALL_ACTIVITY_ALL_VARIABLES_OUT = String.format(
	    Messages.HelpText_17, CALL_ACTIVITY_VARIABLES_GUIDE);

	public static final String CALL_ACTIVITY_BUSINESS_KEY = String.format(
        Messages.HelpText_18, CALL_ACTIVITY_BUSINESS_KEY_GUIDE);

	public static final String LINK_EVENT_DEFINITION_NAME = String.format(Messages.HelpText_19, LINK_EVENT_DEFINITION_USER_GUIDE);

	public static final String STANDARD_LOOP_CHARACTERISTICS_NOTE = String.format(Messages.HelpText_20, IS_LOOP_USER_GUIDE);

	public static final String WAIT_FOR_COMPLETION_NOTE = Messages.HelpText_21;

	public static final String COMPENSATION_THROWING_EVENT = String.format(Messages.HelpText_22, COMPENSATION_THROWING_EVENT_USER_GUIDE);

	public static final String MULTI_INSTANCE_CHARACTERISTICS = String.format(Messages.HelpText_23, MULTI_INSTANCE_USER_GUIDE);

	public static final String SIGNAL_THROW_EVENT_ASYNC_FLAG = String.format(Messages.HelpText_24, SIGNAL_THROW_EVENT_USER_GUIDE);

}
