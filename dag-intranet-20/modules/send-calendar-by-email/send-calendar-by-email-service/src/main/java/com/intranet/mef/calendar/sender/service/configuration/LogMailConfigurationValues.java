package com.intranet.mef.calendar.sender.service.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

public class LogMailConfigurationValues {

	
	public static final String LOG_MAIL_RESULT_EMAIL_FROM_ADDRESS =
		GetterUtil.getString(
			LogMailConfigurationUtil.get(
				LogMailConfigurationKeys.
					LOG_MAIL_RESULT_EMAIL_FROM_ADDRESS));

	public static final String LOG_MAIL_RESULT_EMAIL_FROM_NAME =
		GetterUtil.getString(
			LogMailConfigurationUtil.get(
				LogMailConfigurationKeys.
					LOG_MAIL_RESULT_EMAIL_FROM_NAME));

	

}
