package com.cacheportlet.mef.messaging;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Roberto Sangiovanni
 */
@ExtendedObjectClassDefinition(category="Intranet MEF")
@Meta.OCD(
		id = TwitterMessageListenerConfigurator.PID,
		localization = "content/Language",
		name = "TwitterChronConfiguration"
		)
public interface TwitterMessageListenerConfigurator {

	@Meta.AD(
			deflt = "0 0,30 * ? * * *",
			description = "Setting Cron Expression for Twitter (in cron unix pattern)",
			required = false
			)
	public String getCronExpression();


	@Meta.AD(
			deflt = "http://www.mef.gov.it/modules/links/tweets.json",
			description = "Twitter endpoint url",
			required = true
			)
	public String getUrlTwitter();

	public final static String PID =
			"com.cacheportlet.mef.messaging.TwitterMessageListenerConfigurator";

}