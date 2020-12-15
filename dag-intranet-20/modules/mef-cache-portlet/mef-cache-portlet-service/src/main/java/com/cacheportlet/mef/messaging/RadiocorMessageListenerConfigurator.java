package com.cacheportlet.mef.messaging;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Roberto Sangiovanni
 */
@ExtendedObjectClassDefinition(category="Intranet MEF")
@Meta.OCD(
	id = RadiocorMessageListenerConfigurator.PID,
	localization = "content/Language",
	name = "RadiocorChronConfiguration"
)
public interface RadiocorMessageListenerConfigurator {

	@Meta.AD(
//		deflt = "0 5,35 7-21 ? * MON,TUE,WED,THU,FRI,SAT *",
		deflt = "0 15,45 7-21 ? * MON,TUE,WED,THU,FRI,SAT *",
		description = "Setting Cron Expression for Radiocor (in cron unix pattern)",
		required = false
	)
	public String getCronExpression();
	

	@Meta.AD(
		deflt = "10",
		description = "Number of news that job must return",
		required = false
	)
	public int getFilesNumber();
	
	public final static String PID =
		"com.cacheportlet.mef.messaging.RadiocorMessageListenerConfigurator";

}