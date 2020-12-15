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

package com.intranet.mef.job.siap.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProfilePictureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfilePictureLocalService
 * @generated
 */
@ProviderType
public class ProfilePictureLocalServiceWrapper
	implements ProfilePictureLocalService,
		ServiceWrapper<ProfilePictureLocalService> {
	public ProfilePictureLocalServiceWrapper(
		ProfilePictureLocalService profilePictureLocalService) {
		_profilePictureLocalService = profilePictureLocalService;
	}

	/**
	* Adds the profile picture to the database. Also notifies the appropriate model listeners.
	*
	* @param profilePicture the profile picture
	* @return the profile picture that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.ProfilePicture addProfilePicture(
		com.intranet.mef.job.siap.model.ProfilePicture profilePicture) {
		return _profilePictureLocalService.addProfilePicture(profilePicture);
	}

	/**
	* Creates a new profile picture with the primary key. Does not add the profile picture to the database.
	*
	* @param personID the primary key for the new profile picture
	* @return the new profile picture
	*/
	@Override
	public com.intranet.mef.job.siap.model.ProfilePicture createProfilePicture(
		long personID) {
		return _profilePictureLocalService.createProfilePicture(personID);
	}

	/**
	* Deletes the profile picture from the database. Also notifies the appropriate model listeners.
	*
	* @param profilePicture the profile picture
	* @return the profile picture that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.ProfilePicture deleteProfilePicture(
		com.intranet.mef.job.siap.model.ProfilePicture profilePicture) {
		return _profilePictureLocalService.deleteProfilePicture(profilePicture);
	}

	/**
	* Deletes the profile picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture that was removed
	* @throws PortalException if a profile picture with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.ProfilePicture deleteProfilePicture(
		long personID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _profilePictureLocalService.deleteProfilePicture(personID);
	}

	@Override
	public com.intranet.mef.job.siap.model.ProfilePicture fetchProfilePicture(
		long personID) {
		return _profilePictureLocalService.fetchProfilePicture(personID);
	}

	/**
	* Returns the profile picture with the primary key.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture
	* @throws PortalException if a profile picture with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.ProfilePicture getProfilePicture(
		long personID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _profilePictureLocalService.getProfilePicture(personID);
	}

	/**
	* Updates the profile picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param profilePicture the profile picture
	* @return the profile picture that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.ProfilePicture updateProfilePicture(
		com.intranet.mef.job.siap.model.ProfilePicture profilePicture) {
		return _profilePictureLocalService.updateProfilePicture(profilePicture);
	}

	@Override
	public com.intranet.mef.job.siap.model.ProfilePictureFileBlobModel getFileBlobModel(
		java.io.Serializable primaryKey) {
		return _profilePictureLocalService.getFileBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _profilePictureLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profilePictureLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _profilePictureLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _profilePictureLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _profilePictureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of profile pictures.
	*
	* @return the number of profile pictures
	*/
	@Override
	public int getProfilePicturesCount() {
		return _profilePictureLocalService.getProfilePicturesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _profilePictureLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _profilePictureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _profilePictureLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _profilePictureLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the profile pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile pictures
	* @param end the upper bound of the range of profile pictures (not inclusive)
	* @return the range of profile pictures
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.ProfilePicture> getProfilePictures(
		int start, int end) {
		return _profilePictureLocalService.getProfilePictures(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _profilePictureLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _profilePictureLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ProfilePictureLocalService getWrappedService() {
		return _profilePictureLocalService;
	}

	@Override
	public void setWrappedService(
		ProfilePictureLocalService profilePictureLocalService) {
		_profilePictureLocalService = profilePictureLocalService;
	}

	private ProfilePictureLocalService _profilePictureLocalService;
}