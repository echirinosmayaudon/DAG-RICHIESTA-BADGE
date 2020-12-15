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

package com.intranet.mef.daily.punching.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DailyPunchingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DailyPunchingLocalService
 * @generated
 */
@ProviderType
public class DailyPunchingLocalServiceWrapper
	implements DailyPunchingLocalService,
		ServiceWrapper<DailyPunchingLocalService> {
	public DailyPunchingLocalServiceWrapper(
		DailyPunchingLocalService dailyPunchingLocalService) {
		_dailyPunchingLocalService = dailyPunchingLocalService;
	}

	/**
	* Adds the daily punching to the database. Also notifies the appropriate model listeners.
	*
	* @param dailyPunching the daily punching
	* @return the daily punching that was added
	*/
	@Override
	public com.intranet.mef.daily.punching.model.DailyPunching addDailyPunching(
		com.intranet.mef.daily.punching.model.DailyPunching dailyPunching) {
		return _dailyPunchingLocalService.addDailyPunching(dailyPunching);
	}

	/**
	* Creates a new daily punching with the primary key. Does not add the daily punching to the database.
	*
	* @param custom_key the primary key for the new daily punching
	* @return the new daily punching
	*/
	@Override
	public com.intranet.mef.daily.punching.model.DailyPunching createDailyPunching(
		java.lang.String custom_key) {
		return _dailyPunchingLocalService.createDailyPunching(custom_key);
	}

	/**
	* Deletes the daily punching from the database. Also notifies the appropriate model listeners.
	*
	* @param dailyPunching the daily punching
	* @return the daily punching that was removed
	*/
	@Override
	public com.intranet.mef.daily.punching.model.DailyPunching deleteDailyPunching(
		com.intranet.mef.daily.punching.model.DailyPunching dailyPunching) {
		return _dailyPunchingLocalService.deleteDailyPunching(dailyPunching);
	}

	/**
	* Deletes the daily punching with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching that was removed
	* @throws PortalException if a daily punching with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.daily.punching.model.DailyPunching deleteDailyPunching(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dailyPunchingLocalService.deleteDailyPunching(custom_key);
	}

	@Override
	public com.intranet.mef.daily.punching.model.DailyPunching fetchDailyPunching(
		java.lang.String custom_key) {
		return _dailyPunchingLocalService.fetchDailyPunching(custom_key);
	}

	/**
	* Returns the daily punching with the primary key.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching
	* @throws PortalException if a daily punching with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.daily.punching.model.DailyPunching getDailyPunching(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dailyPunchingLocalService.getDailyPunching(custom_key);
	}

	/**
	* Updates the daily punching in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dailyPunching the daily punching
	* @return the daily punching that was updated
	*/
	@Override
	public com.intranet.mef.daily.punching.model.DailyPunching updateDailyPunching(
		com.intranet.mef.daily.punching.model.DailyPunching dailyPunching) {
		return _dailyPunchingLocalService.updateDailyPunching(dailyPunching);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dailyPunchingLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dailyPunchingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dailyPunchingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of daily punchings.
	*
	* @return the number of daily punchings
	*/
	@Override
	public int getDailyPunchingsCount() {
		return _dailyPunchingLocalService.getDailyPunchingsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dailyPunchingLocalService.getOSGiServiceIdentifier();
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
		return _dailyPunchingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.daily.punching.model.impl.DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dailyPunchingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.daily.punching.model.impl.DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dailyPunchingLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the daily punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.daily.punching.model.impl.DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @return the range of daily punchings
	*/
	@Override
	public java.util.List<com.intranet.mef.daily.punching.model.DailyPunching> getDailyPunchings(
		int start, int end) {
		return _dailyPunchingLocalService.getDailyPunchings(start, end);
	}

	@Override
	public java.util.List<com.intranet.mef.daily.punching.model.DailyPunching> getDailyPunchingsByPersonId(
		long personId) {
		return _dailyPunchingLocalService.getDailyPunchingsByPersonId(personId);
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
		return _dailyPunchingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dailyPunchingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public DailyPunchingLocalService getWrappedService() {
		return _dailyPunchingLocalService;
	}

	@Override
	public void setWrappedService(
		DailyPunchingLocalService dailyPunchingLocalService) {
		_dailyPunchingLocalService = dailyPunchingLocalService;
	}

	private DailyPunchingLocalService _dailyPunchingLocalService;
}