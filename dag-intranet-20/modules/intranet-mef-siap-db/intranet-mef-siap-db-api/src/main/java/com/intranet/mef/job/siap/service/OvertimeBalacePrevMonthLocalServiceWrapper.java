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
 * Provides a wrapper for {@link OvertimeBalacePrevMonthLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalacePrevMonthLocalService
 * @generated
 */
@ProviderType
public class OvertimeBalacePrevMonthLocalServiceWrapper
	implements OvertimeBalacePrevMonthLocalService,
		ServiceWrapper<OvertimeBalacePrevMonthLocalService> {
	public OvertimeBalacePrevMonthLocalServiceWrapper(
		OvertimeBalacePrevMonthLocalService overtimeBalacePrevMonthLocalService) {
		_overtimeBalacePrevMonthLocalService = overtimeBalacePrevMonthLocalService;
	}

	/**
	* Adds the overtime balace prev month to the database. Also notifies the appropriate model listeners.
	*
	* @param overtimeBalacePrevMonth the overtime balace prev month
	* @return the overtime balace prev month that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth addOvertimeBalacePrevMonth(
		com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		return _overtimeBalacePrevMonthLocalService.addOvertimeBalacePrevMonth(overtimeBalacePrevMonth);
	}

	/**
	* Creates a new overtime balace prev month with the primary key. Does not add the overtime balace prev month to the database.
	*
	* @param personId the primary key for the new overtime balace prev month
	* @return the new overtime balace prev month
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth createOvertimeBalacePrevMonth(
		long personId) {
		return _overtimeBalacePrevMonthLocalService.createOvertimeBalacePrevMonth(personId);
	}

	/**
	* Deletes the overtime balace prev month from the database. Also notifies the appropriate model listeners.
	*
	* @param overtimeBalacePrevMonth the overtime balace prev month
	* @return the overtime balace prev month that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth deleteOvertimeBalacePrevMonth(
		com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		return _overtimeBalacePrevMonthLocalService.deleteOvertimeBalacePrevMonth(overtimeBalacePrevMonth);
	}

	/**
	* Deletes the overtime balace prev month with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month that was removed
	* @throws PortalException if a overtime balace prev month with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth deleteOvertimeBalacePrevMonth(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalacePrevMonthLocalService.deleteOvertimeBalacePrevMonth(personId);
	}

	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth fetchOvertimeBalacePrevMonth(
		long personId) {
		return _overtimeBalacePrevMonthLocalService.fetchOvertimeBalacePrevMonth(personId);
	}

	/**
	* Returns the overtime balace prev month with the primary key.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month
	* @throws PortalException if a overtime balace prev month with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth getOvertimeBalacePrevMonth(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalacePrevMonthLocalService.getOvertimeBalacePrevMonth(personId);
	}

	/**
	* Updates the overtime balace prev month in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param overtimeBalacePrevMonth the overtime balace prev month
	* @return the overtime balace prev month that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth updateOvertimeBalacePrevMonth(
		com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		return _overtimeBalacePrevMonthLocalService.updateOvertimeBalacePrevMonth(overtimeBalacePrevMonth);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _overtimeBalacePrevMonthLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _overtimeBalacePrevMonthLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _overtimeBalacePrevMonthLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalacePrevMonthLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalacePrevMonthLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of overtime balace prev months.
	*
	* @return the number of overtime balace prev months
	*/
	@Override
	public int getOvertimeBalacePrevMonthsCount() {
		return _overtimeBalacePrevMonthLocalService.getOvertimeBalacePrevMonthsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _overtimeBalacePrevMonthLocalService.getOSGiServiceIdentifier();
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
		return _overtimeBalacePrevMonthLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _overtimeBalacePrevMonthLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _overtimeBalacePrevMonthLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the overtime balace prev months.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balace prev months
	* @param end the upper bound of the range of overtime balace prev months (not inclusive)
	* @return the range of overtime balace prev months
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth> getOvertimeBalacePrevMonths(
		int start, int end) {
		return _overtimeBalacePrevMonthLocalService.getOvertimeBalacePrevMonths(start,
			end);
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
		return _overtimeBalacePrevMonthLocalService.dynamicQueryCount(dynamicQuery);
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
		return _overtimeBalacePrevMonthLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public OvertimeBalacePrevMonthLocalService getWrappedService() {
		return _overtimeBalacePrevMonthLocalService;
	}

	@Override
	public void setWrappedService(
		OvertimeBalacePrevMonthLocalService overtimeBalacePrevMonthLocalService) {
		_overtimeBalacePrevMonthLocalService = overtimeBalacePrevMonthLocalService;
	}

	private OvertimeBalacePrevMonthLocalService _overtimeBalacePrevMonthLocalService;
}