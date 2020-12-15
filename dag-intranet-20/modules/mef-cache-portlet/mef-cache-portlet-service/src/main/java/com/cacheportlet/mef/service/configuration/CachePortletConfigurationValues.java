package com.cacheportlet.mef.service.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Domenico Costa
 */
public class CachePortletConfigurationValues {

	public static final String SFTP_RADIOCOR_PWD =
		GetterUtil.getString(
			CachePortletConfigurationUtil.get(
				CachePortletConfigurationKeys.
				SFTP_RADIOCOR_PWD));

	public static final String SFTP_RADIOCOR_USER =
		GetterUtil.getString(
			CachePortletConfigurationUtil.get(
				CachePortletConfigurationKeys.
				SFTP_RADIOCOR_USER));
	
	public static final String SFTP_RADIOCOR_HOST =
			GetterUtil.getString(
				CachePortletConfigurationUtil.get(
					CachePortletConfigurationKeys.
					SFTP_RADIOCOR_HOST));
	
	public static final String SFTP_RADIOCOR_DIR =
			GetterUtil.getString(
				CachePortletConfigurationUtil.get(
					CachePortletConfigurationKeys.
					SFTP_RADIOCOR_DIR));
	
	public static final int SFTP_RADIOCOR_PORT =
			GetterUtil.getInteger(
				CachePortletConfigurationUtil.get(
					CachePortletConfigurationKeys.
					SFTP_RADIOCOR_PORT));
	
	public static final String FILE_CREATION_TEMP_PATH =
			GetterUtil.getString(
				CachePortletConfigurationUtil.get(
					CachePortletConfigurationKeys.
					FILE_CREATION_TEMP_PATH));
	
}
