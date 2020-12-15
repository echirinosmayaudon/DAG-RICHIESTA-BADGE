package com.intranet.mef.importusers.service.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Domenico Costa
 */
public class ImportUsersConfigurationValues {

	public static final boolean ADD_MEMBERSHIP_ENABLE =
		GetterUtil.getBoolean(
			ImportUsersConfigurationUtil.get(
				ImportUsersConfigurationKeys.
					ADD_MEMBERSHIP_ENABLE));

	public static final String[] ADD_MEMBERSHIP_IN_INSTANCE_SC =
		ImportUsersConfigurationUtil.getArray(
			ImportUsersConfigurationKeys.ADD_MEMBERSHIP_IN_INSTANCE_SC);

	public static final String[] ADD_MEMBERSHIP_AND_CONTRIBUTOR_ROLE_IN_INSTANCE_SC =
		ImportUsersConfigurationUtil.getArray(
			ImportUsersConfigurationKeys.ADD_MEMBERSHIP_AND_CONTRIBUTOR_ROLE_IN_INSTANCE_SC);

	public static final String IMPORT_USERS_RESULT_EMAIL_FROM_ADDRESS =
		GetterUtil.getString(
			ImportUsersConfigurationUtil.get(
				ImportUsersConfigurationKeys.
					IMPORT_USERS_RESULT_EMAIL_FROM_ADDRESS));

	public static final String IMPORT_USERS_RESULT_EMAIL_FROM_NAME =
		GetterUtil.getString(
			ImportUsersConfigurationUtil.get(
				ImportUsersConfigurationKeys.
					IMPORT_USERS_RESULT_EMAIL_FROM_NAME));

	public static final String[] IMPORT_USERS_RESULT_EMAIL_TO_ADDRESSES =
		ImportUsersConfigurationUtil.getArray(
			ImportUsersConfigurationKeys.IMPORT_USERS_RESULT_EMAIL_TO_ADDRESSES);

	public static final boolean REPLICA_ONLY_USERS_FRONTIERS =
		GetterUtil.getBoolean(
			ImportUsersConfigurationUtil.get(
				ImportUsersConfigurationKeys.
					REPLICA_ONLY_USERS_FRONTIERS));

	public static final boolean REPLICA_USERS_UPDATE_SITE_TARGET =
		GetterUtil.getBoolean(
			ImportUsersConfigurationUtil.get(
				ImportUsersConfigurationKeys.
					REPLICA_USERS_UPDATE_SITE_TARGET));

	public static final boolean START_IMPORT_LISTENER =
		GetterUtil.getBoolean(
			ImportUsersConfigurationUtil.get(
				ImportUsersConfigurationKeys.START_IMPORT_LISTENER));

	public static final boolean START_REPLICA_LISTENER =
		GetterUtil.getBoolean(
			ImportUsersConfigurationUtil.get(
				ImportUsersConfigurationKeys.START_REPLICA_LISTENER));
	
	public static final String LOCAL_ADDRESS =
			GetterUtil.getString(
				ImportUsersConfigurationUtil.get(
					ImportUsersConfigurationKeys.
					LOCAL_ADDRESS));

}
