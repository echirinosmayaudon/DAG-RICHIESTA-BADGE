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
 * Provides a wrapper for {@link ManagerOfficesBindLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ManagerOfficesBindLocalService
 * @generated
 */
@ProviderType
public class ManagerOfficesBindLocalServiceWrapper
	implements ManagerOfficesBindLocalService,
		ServiceWrapper<ManagerOfficesBindLocalService> {
	public ManagerOfficesBindLocalServiceWrapper(
		ManagerOfficesBindLocalService managerOfficesBindLocalService) {
		_managerOfficesBindLocalService = managerOfficesBindLocalService;
	}

	/**
	* Adds the manager offices bind to the database. Also notifies the appropriate model listeners.
	*
	* @param managerOfficesBind the manager offices bind
	* @return the manager offices bind that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind addManagerOfficesBind(
		com.intranet.mef.job.siap.model.ManagerOfficesBind managerOfficesBind) {
		return _managerOfficesBindLocalService.addManagerOfficesBind(managerOfficesBind);
	}

	/**
	* Creates a new manager offices bind with the primary key. Does not add the manager offices bind to the database.
	*
	* @param managerOfficesBindPK the primary key for the new manager offices bind
	* @return the new manager offices bind
	*/
	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind createManagerOfficesBind(
		com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK managerOfficesBindPK) {
		return _managerOfficesBindLocalService.createManagerOfficesBind(managerOfficesBindPK);
	}

	/**
	* Deletes the manager offices bind from the database. Also notifies the appropriate model listeners.
	*
	* @param managerOfficesBind the manager offices bind
	* @return the manager offices bind that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind deleteManagerOfficesBind(
		com.intranet.mef.job.siap.model.ManagerOfficesBind managerOfficesBind) {
		return _managerOfficesBindLocalService.deleteManagerOfficesBind(managerOfficesBind);
	}

	/**
	* Deletes the manager offices bind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind that was removed
	* @throws PortalException if a manager offices bind with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind deleteManagerOfficesBind(
		com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK managerOfficesBindPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _managerOfficesBindLocalService.deleteManagerOfficesBind(managerOfficesBindPK);
	}

	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind fetchManagerOfficesBind(
		com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK managerOfficesBindPK) {
		return _managerOfficesBindLocalService.fetchManagerOfficesBind(managerOfficesBindPK);
	}

	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind fetchManagerOfficesBindByP_I(
		long personId, long idOrgChart) {
		return _managerOfficesBindLocalService.fetchManagerOfficesBindByP_I(personId,
			idOrgChart);
	}

	/**
	* Returns the manager offices bind with the primary key.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind
	* @throws PortalException if a manager offices bind with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind getManagerOfficesBind(
		com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK managerOfficesBindPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _managerOfficesBindLocalService.getManagerOfficesBind(managerOfficesBindPK);
	}

	/**
	* Updates the manager offices bind in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param managerOfficesBind the manager offices bind
	* @return the manager offices bind that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.ManagerOfficesBind updateManagerOfficesBind(
		com.intranet.mef.job.siap.model.ManagerOfficesBind managerOfficesBind) {
		return _managerOfficesBindLocalService.updateManagerOfficesBind(managerOfficesBind);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _managerOfficesBindLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _managerOfficesBindLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _managerOfficesBindLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _managerOfficesBindLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _managerOfficesBindLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of manager offices binds.
	*
	* @return the number of manager offices binds
	*/
	@Override
	public int getManagerOfficesBindsCount() {
		return _managerOfficesBindLocalService.getManagerOfficesBindsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _managerOfficesBindLocalService.getOSGiServiceIdentifier();
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
		return _managerOfficesBindLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _managerOfficesBindLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _managerOfficesBindLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.job.siap.model.ManagerOfficesBind> getManagerOfficesBindByPersonId(
		long personId) {
		return _managerOfficesBindLocalService.getManagerOfficesBindByPersonId(personId);
	}

	/**
	* Returns a range of all the manager offices binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @return the range of manager offices binds
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.ManagerOfficesBind> getManagerOfficesBinds(
		int start, int end) {
		return _managerOfficesBindLocalService.getManagerOfficesBinds(start, end);
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
		return _managerOfficesBindLocalService.dynamicQueryCount(dynamicQuery);
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
		return _managerOfficesBindLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ManagerOfficesBindLocalService getWrappedService() {
		return _managerOfficesBindLocalService;
	}

	@Override
	public void setWrappedService(
		ManagerOfficesBindLocalService managerOfficesBindLocalService) {
		_managerOfficesBindLocalService = managerOfficesBindLocalService;
	}

	private ManagerOfficesBindLocalService _managerOfficesBindLocalService;
}