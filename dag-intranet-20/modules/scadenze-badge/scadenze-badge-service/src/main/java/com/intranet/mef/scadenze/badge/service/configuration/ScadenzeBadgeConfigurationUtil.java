package com.intranet.mef.scadenze.badge.service.configuration;


import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

public class ScadenzeBadgeConfigurationUtil {
	public static String get(String key) {
		return _configuration.get(key);
	}

	public static String[] getArray(String key) {
		return _configuration.getArray(key);
	}

	private static final Configuration _configuration =
		ConfigurationFactoryUtil.getConfiguration(
				ScadenzeBadgeConfigurationUtil.class.getClassLoader(), "portlet");
}
