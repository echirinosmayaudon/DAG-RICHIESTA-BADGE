/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.intranet.mef.importusers.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.intranet.mef.central.util.UserAddressUtil;
import com.intranet.mef.importusers.service.base.ImportUsersHelperLocalServiceBaseImpl;
import com.intranet.mef.importusers.service.base.ReplicaUsersHelperLocalServiceBaseImpl;
import com.intranet.mef.importusers.service.configuration.ImportUsersConfigurationValues;
import com.liferay.announcements.kernel.model.AnnouncementsDelivery;
import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import it.smc.osportal.sc.commons.constants.SCConstants;
import it.smc.osportal.sc.commons.service.SCHelperLocalServiceUtil;
import it.smc.osportal.sc.dashboard.model.UserQuota;
import it.smc.osportal.sc.dashboard.service.UserQuotaLocalServiceUtil;
import it.smc.osportal.sc.users.extent.service.UserHelperLocalServiceUtil;

/**
 * The implementation of the import users helper local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.importusers.service.ImportUsersHelperLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Domenico Costa
 * @see ImportUsersHelperLocalServiceBaseImpl
 * @see com.intranet.mef.importusers.service.ImportUsersHelperLocalServiceUtil
 */
@ProviderType
public class ReplicaUsersHelperLocalServiceImpl
	extends ReplicaUsersHelperLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.importusers.service.ImportUsersHelperLocalServiceUtil} to access the import users helper local service.
	 */
	
	public User addTargetUser(User masterUser, long targetCompanyId)
		throws PortalException{

		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();

		birthdayCal.setTime(masterUser.getBirthday());

		ServiceContext serviceContext = new ServiceContext();

		List<Address> addresses = _factoryAddress(targetCompanyId,
			masterUser.getAddresses());
		List<EmailAddress> emailAddresses = new ArrayList<>();
		List<Phone> phones = _factoryPhone(targetCompanyId,
			masterUser.getPhones());
		List<Website> websites = new ArrayList<>();
		List<AnnouncementsDelivery> announcementsDeliveries = new ArrayList<>();

		long[] groupIds = new long[]{};
		long[] organizationIds = new long[]{};
		long[] roleIds = new long[]{};
		long[] userGroupIds = new long[]{};

		List<UserGroup> userGroups =
			SCHelperLocalServiceUtil.getServiceUserGroups(targetCompanyId);

		for (UserGroup userGroup : userGroups) {
			//check user was serviceUserGroup
			userGroupIds = ArrayUtil.append(
				userGroupIds, userGroup.getUserGroupId());

			// aggiungo tutti i ruoli dello UserGroup
			// Come ruoli regolari all'utente

			roleIds = ArrayUtil.append(
				roleIds,
				SCHelperLocalServiceUtil.getUserGroupRoleIds(targetCompanyId,
					userGroup.getUserGroupId()));
		
		}

		
		long internalRoleId = 0L;
		//add standard role 
		try {

			Role role = RoleServiceUtil.getRole(
					targetCompanyId, SCConstants.ROLE_USER_INTERNAL);

			internalRoleId = role.getRoleId();
		} catch (PortalException e) {
			_log.error("Error get internal role");
			_log.error(e);
			internalRoleId = -1;
		}
		
		if(internalRoleId >0){
			roleIds = ArrayUtil.append(roleIds, internalRoleId);
		}
		
		
		User targetUser = UserHelperLocalServiceUtil.addUser(
			targetCompanyId, true, masterUser.getPassword(),
			masterUser.getPassword(), false, masterUser.getScreenName(),
			masterUser.getEmailAddress(), masterUser.getFacebookId(),
			masterUser.getOpenId(), masterUser.getLanguageId(),
			masterUser.getFirstName(), masterUser.getMiddleName(),
			masterUser.getLastName(), 1, 1, masterUser.getMale(),
			birthdayCal.get(Calendar.MONTH), birthdayCal.get(Calendar.DATE),
			birthdayCal.get(Calendar.YEAR), masterUser.getJobTitle(),
			groupIds, organizationIds, roleIds, userGroupIds,
			addresses, emailAddresses, phones, websites,
			announcementsDeliveries, false, false, serviceContext);

		int quotaDefault = PrefsPropsUtil.getInteger(
			targetCompanyId, SCConstants.PREF_COMPANY_SPACE_QUOTA,
			SCConstants.DEFAULT_USER_QUOTA);

		UserQuota userQuota = UserQuotaLocalServiceUtil.fetchUserUserQuota(
			targetUser.getUserId());

		long quotaId = BeanPropertiesUtil.getLong(userQuota, "quotaId", 0L);

		_updateUserQuota(targetUser, quotaId, quotaDefault);

		userLocalService.updatePasswordManually(
			targetUser.getUserId(), masterUser.getPassword(),
			masterUser.getPasswordEncrypted(), false,
			masterUser.getPasswordModifiedDate());

		if (Validator.isNull(targetUser.getLastLoginDate())){
			userLocalService.updateLastLogin(
				targetUser.getUserId(), ImportUsersConfigurationValues.LOCAL_ADDRESS);
		}

		return targetUser;
	}

	public User updateTargetUser(User masterUser, User targetUser2) 
		throws PortalException {

		
		
		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();

		birthdayCal.setTime(masterUser.getBirthday());

		ServiceContext serviceContext = new ServiceContext();

		List<Address> addresses = _factoryAddress(targetUser2.getCompanyId(),
			masterUser.getAddresses());
		List<EmailAddress> emailAddresses = targetUser2.getEmailAddresses();
		List<Phone> phones =  _factoryPhone(targetUser2.getCompanyId(),
			masterUser.getPhones());
		List<Website> websites = targetUser2.getWebsites();
		List<AnnouncementsDelivery> announcementsDeliveries =
			announcementsDeliveryLocalService.getUserDeliveries(
				targetUser2.getUserId());

		long[] groupIds = targetUser2.getGroupIds();
		long[] organizationIds = targetUser2.getOrganizationIds();
		long[] roleIds = targetUser2.getRoleIds();
		long[] userGroupIds = targetUser2.getUserGroupIds();

		List<UserGroupRole> userGroupRoles =
			userGroupRoleLocalService.getUserGroupRoles(
				targetUser2.getUserId());

		List<UserGroup> userGroups =
			SCHelperLocalServiceUtil.getServiceUserGroups(
				targetUser2.getCompanyId());

		for (long roleId : SCHelperLocalServiceUtil.getFeatureRoleIds(
			targetUser2.getCompanyId())) {

			roleIds = ArrayUtil.remove(roleIds, roleId);
		}

		for (UserGroup userGroup : userGroups) {
			//check user was serviceUserGroup

			userGroupIds = ArrayUtil.append(
				userGroupIds, userGroup.getUserGroupId());

			// aggiungo tutti i ruoli dello UserGroup
			// Come ruoli regolari all'utente

			roleIds = ArrayUtil.append(
				roleIds,
				SCHelperLocalServiceUtil.getUserGroupRoleIds(targetUser2.getCompanyId(),
					userGroup.getUserGroupId()));

		}
		

		boolean deleteLogo = true;//gestione Immagine portrait

		byte[] portraitBytes = null;

		long portraitId = masterUser.getPortraitId();

		if (portraitId > 0) {
			Image image = ImageLocalServiceUtil.getImage(portraitId);

			portraitBytes = image.getTextObj();
		}

		UserQuota userQuota = UserQuotaLocalServiceUtil.fetchUserUserQuota(
			targetUser2.getUserId());

		String smsSn = masterUser.getContact().getSmsSn(); 
		String facebookSn = masterUser.getContact().getFacebookSn();
		String jabberSn = masterUser.getContact().getJabberSn();
		String skypeSn = masterUser.getContact().getSkypeSn();
		String twitterSn = masterUser.getContact().getTwitterSn();

		User targetUser = UserHelperLocalServiceUtil.updateUser(
			targetUser2.getUserId(), StringPool.BLANK,
			StringPool.BLANK, StringPool.BLANK, false,
			masterUser.getReminderQueryQuestion(),
			masterUser.getReminderQueryAnswer(), masterUser.getScreenName(),
			masterUser.getEmailAddress(), masterUser.getFacebookId(),
			masterUser.getOpenId(), deleteLogo, portraitBytes,
			masterUser.getLanguageId(), masterUser.getTimeZoneId(),
			masterUser.getGreeting(), masterUser.getComments(),
			masterUser.getFirstName(), masterUser.getMiddleName(),
			masterUser.getLastName(), 1L, 1L, masterUser.getMale(),
			birthdayCal.get(Calendar.MONTH), birthdayCal.get(Calendar.DATE),
			birthdayCal.get(Calendar.YEAR), smsSn, facebookSn, jabberSn,
			skypeSn, twitterSn, masterUser.getJobTitle(), groupIds,
			organizationIds, roleIds, userGroupRoles, userGroupIds,
			addresses, emailAddresses, phones, websites,
			announcementsDeliveries, userQuota.getQuota(), serviceContext);

		userLocalService.updatePasswordManually(
			targetUser.getUserId(), masterUser.getPassword(),
			masterUser.getPasswordEncrypted(), false,
			masterUser.getPasswordModifiedDate());

		if (Validator.isNull(targetUser.getLastLoginDate())){
			userLocalService.updateLastLogin(
				targetUser.getUserId(), ImportUsersConfigurationValues.LOCAL_ADDRESS);
		}

		return targetUser;

	}

	private List<Address> _factoryAddress(long companyId,
		List<Address> addressesMaster) {

		List<Address> addresses= new ArrayList<>();

		long addressId=0;
		
		for (Address address : addressesMaster) {
			boolean primary = false;
			if (address.getTypeId() == UserAddressUtil.
					getAddressTypeIdByName(UserAddressUtil.BUSINESS)){

				primary = true;
			}

			Address addressTarget = AddressLocalServiceUtil.
					createAddress(addressId);
			addressTarget.setStreet1(address.getStreet1());
			addressTarget.setStreet2(address.getStreet2());
			addressTarget.setStreet3(address.getStreet3());
			addressTarget.setZip(address.getZip());
			addressTarget.setCity(address.getCity());
			addressTarget.setTypeId(address.getTypeId());
			addressTarget.setMailing(primary);
			addressTarget.setPrimary(primary);
			addressTarget.setCompanyId(companyId);

			addresses.add(addressTarget);
		}

		return addresses;
	}
	
	private List<Phone> _factoryPhone(long companyId, List<Phone> phonesMaster) {
		List<Phone> phones= new ArrayList<>();

		long phoneId=0;
		
		for (Phone phone : phonesMaster) {
			Phone phoneTarget = PhoneLocalServiceUtil.createPhone(phoneId);
			phoneTarget.setNumber(phone.getNumber());
			phoneTarget.setTypeId(phone.getTypeId());
			phoneTarget.setCompanyId(companyId);

			phones.add(phoneTarget);
		}

		return phones;
	}

	private void _updateUserQuota(User user, long quotaId, int quota)
		throws PortalException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(user.getCompanyId());

		if (_log.isDebugEnabled()) {
			_log.debug(
				"updateUserQuota: user = " + user + ", quotaId = " +
					quotaId + ", quota = " + quota);
		}

		if (quotaId == 0) {
			UserQuotaLocalServiceUtil.addUserQuota(
				user.getUserId(), quota, serviceContext);
		}
		else {
			UserQuotaLocalServiceUtil.updateUserQuota(
				quotaId, quota, serviceContext);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ReplicaUsersHelperLocalServiceImpl.class);
}