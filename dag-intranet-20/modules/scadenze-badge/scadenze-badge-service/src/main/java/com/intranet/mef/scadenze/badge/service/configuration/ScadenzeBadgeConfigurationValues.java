package com.intranet.mef.scadenze.badge.service.configuration;


import com.liferay.portal.kernel.util.GetterUtil;

public class ScadenzeBadgeConfigurationValues {
	
		
		public static final String SCADENZE_BADGE_RESULT_EMAIL_FROM_ADDRESS =
			GetterUtil.getString(
					ScadenzeBadgeConfigurationUtil.get(
							ScadenzeBadgeConfigurationKeys.
							SCADENZE_BADGE_RESULT_EMAIL_FROM_ADDRESS));

		public static final String SCADENZE_BADGE_RESULT_EMAIL_FROM_NAME =
			GetterUtil.getString(
					ScadenzeBadgeConfigurationUtil.get(
							ScadenzeBadgeConfigurationKeys.
							SCADENZE_BADGE_RESULT_EMAIL_FROM_NAME));

		public static final String[] SCADENZE_BADGE_RESULT_EMAIL_TO_ADDRESSES =
				ScadenzeBadgeConfigurationUtil.getArray(
						ScadenzeBadgeConfigurationKeys.SCADENZE_BADGE_RESULT_EMAIL_TO_ADDRESSES);

		
		
		
}
