package com.mef.intranet.rubrica.configuration;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;


public class MefIntranetEndpointConfigurationUtil {

	public static String get(String key) {
		return _configuration.get(key);
	}
	
	private static final Configuration _configuration =
			ConfigurationFactoryUtil.getConfiguration(
					MefIntranetEndpointConfigurationUtil.class.getClassLoader(), "portlet");
}
