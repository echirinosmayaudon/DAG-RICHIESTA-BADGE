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
 * Provides a wrapper for {@link OrganizationChartLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChartLocalService
 * @generated
 */
@ProviderType
public class OrganizationChartLocalServiceWrapper
	implements OrganizationChartLocalService,
		ServiceWrapper<OrganizationChartLocalService> {
	public OrganizationChartLocalServiceWrapper(
		OrganizationChartLocalService organizationChartLocalService) {
		_organizationChartLocalService = organizationChartLocalService;
	}

	/**
	* Adds the organization chart to the database. Also notifies the appropriate model listeners.
	*
	* @param organizationChart the organization chart
	* @return the organization chart that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.OrganizationChart addOrganizationChart(
		com.intranet.mef.job.siap.model.OrganizationChart organizationChart) {
		return _organizationChartLocalService.addOrganizationChart(organizationChart);
	}

	/**
	* Creates a new organization chart with the primary key. Does not add the organization chart to the database.
	*
	* @param idOrgChart the primary key for the new organization chart
	* @return the new organization chart
	*/
	@Override
	public com.intranet.mef.job.siap.model.OrganizationChart createOrganizationChart(
		long idOrgChart) {
		return _organizationChartLocalService.createOrganizationChart(idOrgChart);
	}

	/**
	* Deletes the organization chart from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationChart the organization chart
	* @return the organization chart that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.OrganizationChart deleteOrganizationChart(
		com.intranet.mef.job.siap.model.OrganizationChart organizationChart) {
		return _organizationChartLocalService.deleteOrganizationChart(organizationChart);
	}

	/**
	* Deletes the organization chart with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart that was removed
	* @throws PortalException if a organization chart with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OrganizationChart deleteOrganizationChart(
		long idOrgChart)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _organizationChartLocalService.deleteOrganizationChart(idOrgChart);
	}

	@Override
	public com.intranet.mef.job.siap.model.OrganizationChart fetchOrganizationChart(
		long idOrgChart) {
		return _organizationChartLocalService.fetchOrganizationChart(idOrgChart);
	}

	/**
	* Returns the organization chart with the primary key.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart
	* @throws PortalException if a organization chart with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.OrganizationChart getOrganizationChart(
		long idOrgChart)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _organizationChartLocalService.getOrganizationChart(idOrgChart);
	}

	/**
	* Updates the organization chart in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organizationChart the organization chart
	* @return the organization chart that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.OrganizationChart updateOrganizationChart(
		com.intranet.mef.job.siap.model.OrganizationChart organizationChart) {
		return _organizationChartLocalService.updateOrganizationChart(organizationChart);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _organizationChartLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationChartLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _organizationChartLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _organizationChartLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _organizationChartLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of organization charts.
	*
	* @return the number of organization charts
	*/
	@Override
	public int getOrganizationChartsCount() {
		return _organizationChartLocalService.getOrganizationChartsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _organizationChartLocalService.getOSGiServiceIdentifier();
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
		return _organizationChartLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationChartLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationChartLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.job.siap.model.OrganizationChart> getChildrenByLevelAndIdOrgChart(
		int level, long idOrgChart) {
		return _organizationChartLocalService.getChildrenByLevelAndIdOrgChart(level,
			idOrgChart);
	}

	/**
	* Returns a range of all the organization charts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization charts
	* @param end the upper bound of the range of organization charts (not inclusive)
	* @return the range of organization charts
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.OrganizationChart> getOrganizationCharts(
		int start, int end) {
		return _organizationChartLocalService.getOrganizationCharts(start, end);
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
		return _organizationChartLocalService.dynamicQueryCount(dynamicQuery);
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
		return _organizationChartLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public OrganizationChartLocalService getWrappedService() {
		return _organizationChartLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationChartLocalService organizationChartLocalService) {
		_organizationChartLocalService = organizationChartLocalService;
	}

	private OrganizationChartLocalService _organizationChartLocalService;
}