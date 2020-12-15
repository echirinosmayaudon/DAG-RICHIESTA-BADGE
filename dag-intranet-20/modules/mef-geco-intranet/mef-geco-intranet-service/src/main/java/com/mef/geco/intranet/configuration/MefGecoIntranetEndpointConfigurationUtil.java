package com.mef.geco.intranet.configuration;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

public class MefGecoIntranetEndpointConfigurationUtil {
	
	public static String get(String key) {
		return _configuration.get(key);
	}
	
	private static final Configuration _configuration =
			ConfigurationFactoryUtil.getConfiguration(
					MefGecoIntranetEndpointConfigurationUtil.class.getClassLoader(), "portlet");
}
