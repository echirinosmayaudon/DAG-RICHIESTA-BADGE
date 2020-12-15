package com.intranet.mef.scadenze.badge.messaging;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category="Intranet MEF")
@Meta.OCD(
	id = ScadenzeBadgeCheckerMessageListenerConfiguration.PID,
	localization = "content/Language",
	name = "ScadenzeBadgeCheckerMessageListenerConfiguration"
)
public interface ScadenzeBadgeCheckerMessageListenerConfiguration {
	@Meta.AD(
			deflt = "0 0 2 1/1 * ? *",
			description = "Setting Cron Expression for ScadenzeBadgeCheckerMessageListenerConfiguration (in cron unix pattern)",
			required = false
		)
		public String getCronExpression();
	
	public final static String PID =
			"com.intranet.mef.scadenze.badge.messaging.ScadenzeBadgeCheckerMessageListenerConfiguration";
	
	
	
	
}
