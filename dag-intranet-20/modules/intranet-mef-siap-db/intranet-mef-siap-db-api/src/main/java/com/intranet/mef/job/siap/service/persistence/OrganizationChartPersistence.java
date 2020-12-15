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

package com.intranet.mef.job.siap.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.exception.NoSuchOrganizationChartException;
import com.intranet.mef.job.siap.model.OrganizationChart;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the organization chart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.OrganizationChartPersistenceImpl
 * @see OrganizationChartUtil
 * @generated
 */
@ProviderType
public interface OrganizationChartPersistence extends BasePersistence<OrganizationChart> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationChartUtil} to access the organization chart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the organization chart in the entity cache if it is enabled.
	*
	* @param organizationChart the organization chart
	*/
	public void cacheResult(OrganizationChart organizationChart);

	/**
	* Caches the organization charts in the entity cache if it is enabled.
	*
	* @param organizationCharts the organization charts
	*/
	public void cacheResult(
		java.util.List<OrganizationChart> organizationCharts);

	/**
	* Creates a new organization chart with the primary key. Does not add the organization chart to the database.
	*
	* @param idOrgChart the primary key for the new organization chart
	* @return the new organization chart
	*/
	public OrganizationChart create(long idOrgChart);

	/**
	* Removes the organization chart with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart that was removed
	* @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	*/
	public OrganizationChart remove(long idOrgChart)
		throws NoSuchOrganizationChartException;

	public OrganizationChart updateImpl(OrganizationChart organizationChart);

	/**
	* Returns the organization chart with the primary key or throws a {@link NoSuchOrganizationChartException} if it could not be found.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart
	* @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	*/
	public OrganizationChart findByPrimaryKey(long idOrgChart)
		throws NoSuchOrganizationChartException;

	/**
	* Returns the organization chart with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart, or <code>null</code> if a organization chart with the primary key could not be found
	*/
	public OrganizationChart fetchByPrimaryKey(long idOrgChart);

	@Override
	public java.util.Map<java.io.Serializable, OrganizationChart> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the organization charts.
	*
	* @return the organization charts
	*/
	public java.util.List<OrganizationChart> findAll();

	/**
	* Returns a range of all the organization charts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization charts
	* @param end the upper bound of the range of organization charts (not inclusive)
	* @return the range of organization charts
	*/
	public java.util.List<OrganizationChart> findAll(int start, int end);

	/**
	* Returns an ordered range of all the organization charts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization charts
	* @param end the upper bound of the range of organization charts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of organization charts
	*/
	public java.util.List<OrganizationChart> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationChart> orderByComparator);

	/**
	* Returns an ordered range of all the organization charts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization charts
	* @param end the upper bound of the range of organization charts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of organization charts
	*/
	public java.util.List<OrganizationChart> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationChart> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the organization charts from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of organization charts.
	*
	* @return the number of organization charts
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}