package com.cacheportlet.mef.messaging;



import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Roberto Sangiovanni
 */
@ExtendedObjectClassDefinition(category="Intranet MEF")
@Meta.OCD(
		id = WeatherMessageListenerConfigurator.PID,
		localization = "content/Language",
		name = "WeatherChronConfiguration"
		)
public interface WeatherMessageListenerConfigurator {

	@Meta.AD(
			deflt = "0 0 * ? * * *",
			description = "Setting Cron Expression for Weather (in cron unix pattern)",
			required = false
			)
	public String getCronExpression();


	@Meta.AD(
			deflt = "",
			description = "Darksky API KEY",
			required = true
			)
	public String getAPIKey();
	
	@Meta.AD(
			deflt = "",
			description = "Latitude",
			required = true
			)
	public String getLatitude();
	
	@Meta.AD(
			deflt = "",
			description = "Longitude",
			required = true
			)
	public String getLongitude();

	

	public final static String PID =
			"com.cacheportlet.mef.messaging.WeatherMessageListenerConfigurator";

}