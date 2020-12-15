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

package com.intranet.mef.central.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CentralInvokerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvokerLocalService
 * @generated
 */
@ProviderType
public class CentralInvokerLocalServiceWrapper
	implements CentralInvokerLocalService,
		ServiceWrapper<CentralInvokerLocalService> {
	public CentralInvokerLocalServiceWrapper(
		CentralInvokerLocalService centralInvokerLocalService) {
		_centralInvokerLocalService = centralInvokerLocalService;
	}

	/**
	* Return all roles id of type Architettural
	*
	* @param companyId
	* @return List<Role>
	*/
	@Override
	public boolean isTeamArchitettural(java.lang.Long teamId) {
		return _centralInvokerLocalService.isTeamArchitettural(teamId);
	}

	/**
	* Adds the central invoker to the database. Also notifies the appropriate model listeners.
	*
	* @param centralInvoker the central invoker
	* @return the central invoker that was added
	*/
	@Override
	public com.intranet.mef.central.model.CentralInvoker addCentralInvoker(
		com.intranet.mef.central.model.CentralInvoker centralInvoker) {
		return _centralInvokerLocalService.addCentralInvoker(centralInvoker);
	}

	/**
	* Creates a new central invoker with the primary key. Does not add the central invoker to the database.
	*
	* @param idRecord the primary key for the new central invoker
	* @return the new central invoker
	*/
	@Override
	public com.intranet.mef.central.model.CentralInvoker createCentralInvoker(
		long idRecord) {
		return _centralInvokerLocalService.createCentralInvoker(idRecord);
	}

	/**
	* Deletes the central invoker from the database. Also notifies the appropriate model listeners.
	*
	* @param centralInvoker the central invoker
	* @return the central invoker that was removed
	*/
	@Override
	public com.intranet.mef.central.model.CentralInvoker deleteCentralInvoker(
		com.intranet.mef.central.model.CentralInvoker centralInvoker) {
		return _centralInvokerLocalService.deleteCentralInvoker(centralInvoker);
	}

	/**
	* Deletes the central invoker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker that was removed
	* @throws PortalException if a central invoker with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.central.model.CentralInvoker deleteCentralInvoker(
		long idRecord)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _centralInvokerLocalService.deleteCentralInvoker(idRecord);
	}

	@Override
	public com.intranet.mef.central.model.CentralInvoker fetchCentralInvoker(
		long idRecord) {
		return _centralInvokerLocalService.fetchCentralInvoker(idRecord);
	}

	/**
	* Returns the central invoker with the primary key.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker
	* @throws PortalException if a central invoker with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.central.model.CentralInvoker getCentralInvoker(
		long idRecord)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _centralInvokerLocalService.getCentralInvoker(idRecord);
	}

	/**
	* Updates the central invoker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param centralInvoker the central invoker
	* @return the central invoker that was updated
	*/
	@Override
	public com.intranet.mef.central.model.CentralInvoker updateCentralInvoker(
		com.intranet.mef.central.model.CentralInvoker centralInvoker) {
		return _centralInvokerLocalService.updateCentralInvoker(centralInvoker);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _centralInvokerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _centralInvokerLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _centralInvokerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _centralInvokerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _centralInvokerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of central invokers.
	*
	* @return the number of central invokers
	*/
	@Override
	public int getCentralInvokersCount() {
		return _centralInvokerLocalService.getCentralInvokersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _centralInvokerLocalService.getOSGiServiceIdentifier();
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
		return _centralInvokerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.central.model.impl.CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _centralInvokerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.central.model.impl.CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _centralInvokerLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.job.siap.model.Location> findLocationById(
		long id) {
		return _centralInvokerLocalService.findLocationById(id);
	}

	/**
	* Returns a range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.central.model.impl.CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @return the range of central invokers
	*/
	@Override
	public java.util.List<com.intranet.mef.central.model.CentralInvoker> getCentralInvokers(
		int start, int end) {
		return _centralInvokerLocalService.getCentralInvokers(start, end);
	}

	/**
	* Return all roles id of type Architettural
	*
	* @param companyId
	* @return List<Role>
	*/
	@Override
	public java.util.List<java.lang.Long> getRolesIsArchitettural(
		java.lang.Long companyId) {
		return _centralInvokerLocalService.getRolesIsArchitettural(companyId);
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
		return _centralInvokerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _centralInvokerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public CentralInvokerLocalService getWrappedService() {
		return _centralInvokerLocalService;
	}

	@Override
	public void setWrappedService(
		CentralInvokerLocalService centralInvokerLocalService) {
		_centralInvokerLocalService = centralInvokerLocalService;
	}

	private CentralInvokerLocalService _centralInvokerLocalService;
}