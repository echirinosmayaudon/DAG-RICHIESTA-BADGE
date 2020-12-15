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
 * Provides a wrapper for {@link OvertimeBalanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalanceLocalService
 * @generated
 */
@ProviderType
public class OvertimeBalanceLocalServiceWrapper
	implements OvertimeBalanceLocalService,
		ServiceWrapper<OvertimeBalanceLocalService> {
	public OvertimeBalanceLocalServiceWrapper(
		OvertimeBalanceLocalService overtimeBalanceLocalService) {
		_overtimeBalanceLocalService = overtimeBalanceLocalService;
	}

	/**
	* Adds the overtime balance to the database. Also notifies the appropriate model listeners.
	*
	* @param overtimeBalance the overtime balance
	* @return the overtime balance that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalance addOvertimeBalance(
		com.intranet.mef.job.siap.model.OvertimeBalance overtimeBalance) {
		return _overtimeBalanceLocalService.addOvertimeBalance(overtimeBalance);
	}

	/**
	* Creates a new overtime balance with the primary key. Does not add the overtime balance to the database.
	*
	* @param personId the primary key for the new overtime balance
	* @return the new overtime balance
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalance createOvertimeBalance(
		long personId) {
		return _overtimeBalanceLocalService.createOvertimeBalance(personId);
	}

	/**
	* Deletes the overtime balance from the database. Also notifies the appropriate model listeners.
	*
	* @param overtimeBalance the overtime balance
	* @return the overtime balance that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalance deleteOvertimeBalance(
		com.intranet.mef.job.siap.model.OvertimeBalance overtimeBalance) {
		return _overtimeBalanceLocalService.deleteOvertimeBalance(overtimeBalance);
	}

	/**
	* Deletes the overtime balance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance that was removed
	* @throws PortalException if a overtime balance with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalance deleteOvertimeBalance(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalanceLocalService.deleteOvertimeBalance(personId);
	}

	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalance fetchOvertimeBalance(
		long personId) {
		return _overtimeBalanceLocalService.fetchOvertimeBalance(personId);
	}

	/**
	* Returns the overtime balance with the primary key.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance
	* @throws PortalException if a overtime balance with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalance getOvertimeBalance(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalanceLocalService.getOvertimeBalance(personId);
	}

	/**
	* Updates the overtime balance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param overtimeBalance the overtime balance
	* @return the overtime balance that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.OvertimeBalance updateOvertimeBalance(
		com.intranet.mef.job.siap.model.OvertimeBalance overtimeBalance) {
		return _overtimeBalanceLocalService.updateOvertimeBalance(overtimeBalance);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _overtimeBalanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _overtimeBalanceLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _overtimeBalanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _overtimeBalanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of overtime balances.
	*
	* @return the number of overtime balances
	*/
	@Override
	public int getOvertimeBalancesCount() {
		return _overtimeBalanceLocalService.getOvertimeBalancesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _overtimeBalanceLocalService.getOSGiServiceIdentifier();
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
		return _overtimeBalanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _overtimeBalanceLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _overtimeBalanceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the overtime balances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balances
	* @param end the upper bound of the range of overtime balances (not inclusive)
	* @return the range of overtime balances
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.OvertimeBalance> getOvertimeBalances(
		int start, int end) {
		return _overtimeBalanceLocalService.getOvertimeBalances(start, end);
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
		return _overtimeBalanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _overtimeBalanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public OvertimeBalanceLocalService getWrappedService() {
		return _overtimeBalanceLocalService;
	}

	@Override
	public void setWrappedService(
		OvertimeBalanceLocalService overtimeBalanceLocalService) {
		_overtimeBalanceLocalService = overtimeBalanceLocalService;
	}

	private OvertimeBalanceLocalService _overtimeBalanceLocalService;
}