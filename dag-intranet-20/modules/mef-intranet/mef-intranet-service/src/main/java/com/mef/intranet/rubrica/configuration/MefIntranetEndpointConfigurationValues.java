package com.mef.intranet.rubrica.configuration;

import com.liferay.portal.kernel.util.GetterUtil;


public class MefIntranetEndpointConfigurationValues {

	public static final String WSDL_LOCATION_RUBRICA =
			GetterUtil.getString(
					MefIntranetEndpointConfigurationUtil.get(
							MefIntranetEndpointConfigurationKeys.WSDL_LOCATION_RUBRICA));
}
