package com.intranet.mef.importusers.messaging;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Domenico Costa
 */
@ExtendedObjectClassDefinition(category="Intranet MEF")
@Meta.OCD(
	id = ImportUsersCheckerMessageListenerConfiguration.PID,
	localization = "content/Language",
	name = "ImportUsersCheckerMessageListenerConfiguration"
)
public interface ImportUsersCheckerMessageListenerConfiguration {

	@Meta.AD(
		deflt = "0 0 2 1/1 * ? *",
		description = "Setting Cron Expression for ImportUsersCheckerMessageListenerConfiguration (in cron unix pattern)",
		required = false
	)
	public String getCronExpression();
	
	public final static String PID =
		"com.intranet.mef.importusers.messaging.ImportUsersCheckerMessageListenerConfiguration";

}