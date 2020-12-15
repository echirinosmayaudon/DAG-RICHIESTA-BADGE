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
 * Provides a wrapper for {@link OvertimePrevMonthPayOffLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OvertimePrevMonthPayOffLocalService
 * @generated
 */
@ProviderType
public class OvertimePrevMonthPayOffLocalServiceWrapper
	implements OvertimePrevMonthPayOffLocalService,
		ServiceWrapper<OvertimePrevMonthPayOffLocalService> {
	public OvertimePrevMonthPayOffLocalServiceWrapper(
		OvertimePrevMonthPayOffLocalService overtimePrevMonthPayOffLocalService) {
		_overtimePrevMonthPayOffLocalService = overtimePrevMonthPayOffLocalService;
	}

	/**
	* Adds the overtime prev month pay off to the database. Also notifies the appropriate model listeners.
	*
	* @param overtimePrevMonthPayOff the overtime prev month pay off
	* @return the overtime prev month pay off that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff addOvertimePrevMonthPayOff(
		com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		return _overtimePrevMonthPayOffLocalService.addOvertimePrevMonthPayOff(overtimePrevMonthPayOff);
	}

	/**
	* Creates a new overtime prev month pay off with the primary key. Does not add the overtime prev month pay off to the database.
	*
	* @param personId the primary key for the new overtime prev month pay off
	* @return the new overtime prev month pay off
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff createOvertimePrevMonthPayOff(
		long personId) {
		return _overtimePrevMonthPayOffLocalService.createOvertimePrevMonthPayOff(personId);
	}

	/**
	* Deletes the overtime prev month pay off from the database. Also notifies the appropriate model listeners.
	*
	* @param overtimePrevMonthPayOff the overtime prev month pay off
	* @return the overtime prev month pay off that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff deleteOvertimePrevMonthPayOff(
		com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		return _overtimePrevMonthPayOffLocalService.deleteOvertimePrevMonthPayOff(overtimePrevMonthPayOff);
	}

	/**
	* Deletes the overtime prev month pay off with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime prev month pay off
	* @return the overtime prev month pay off that was removed
	* @throws PortalException if a overtime prev month pay off with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff deleteOvertimePrevMonthPayOff(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimePrevMonthPayOffLocalService.deleteOvertimePrevMonthPayOff(personId);
	}

	@Override
	public com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff fetchOvertimePrevMonthPayOff(
		long personId) {
		return _overtimePrevMonthPayOffLocalService.fetchOvertimePrevMonthPayOff(personId);
	}

	/**
	* Returns the overtime prev month pay off with the primary key.
	*
	* @param personId the primary key of the overtime prev month pay off
	* @return the overtime prev month pay off
	* @throws PortalException if a overtime prev month pay off with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff getOvertimePrevMonthPayOff(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimePrevMonthPayOffLocalService.getOvertimePrevMonthPayOff(personId);
	}

	/**
	* Updates the overtime prev month pay off in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param overtimePrevMonthPayOff the overtime prev month pay off
	* @return the overtime prev month pay off that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff updateOvertimePrevMonthPayOff(
		com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		return _overtimePrevMonthPayOffLocalService.updateOvertimePrevMonthPayOff(overtimePrevMonthPayOff);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _overtimePrevMonthPayOffLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _overtimePrevMonthPayOffLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _overtimePrevMonthPayOffLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimePrevMonthPayOffLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimePrevMonthPayOffLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of overtime prev month pay offs.
	*
	* @return the number of overtime prev month pay offs
	*/
	@Override
	public int getOvertimePrevMonthPayOffsCount() {
		return _overtimePrevMonthPayOffLocalService.getOvertimePrevMonthPayOffsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _overtimePrevMonthPayOffLocalService.getOSGiServiceIdentifier();
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
		return _overtimePrevMonthPayOffLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _overtimePrevMonthPayOffLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _overtimePrevMonthPayOffLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the overtime prev month pay offs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime prev month pay offs
	* @param end the upper bound of the range of overtime prev month pay offs (not inclusive)
	* @return the range of overtime prev month pay offs
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff> getOvertimePrevMonthPayOffs(
		int start, int end) {
		return _overtimePrevMonthPayOffLocalService.getOvertimePrevMonthPayOffs(start,
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
		return _overtimePrevMonthPayOffLocalService.dynamicQueryCount(dynamicQuery);
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
		return _overtimePrevMonthPayOffLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public OvertimePrevMonthPayOffLocalService getWrappedService() {
		return _overtimePrevMonthPayOffLocalService;
	}

	@Override
	public void setWrappedService(
		OvertimePrevMonthPayOffLocalService overtimePrevMonthPayOffLocalService) {
		_overtimePrevMonthPayOffLocalService = overtimePrevMonthPayOffLocalService;
	}

	private OvertimePrevMonthPayOffLocalService _overtimePrevMonthPayOffLocalService;
}