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

import com.intranet.mef.job.siap.model.OrganizationChart;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the organization chart service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.OrganizationChartPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChartPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.OrganizationChartPersistenceImpl
 * @generated
 */
@ProviderType
public class OrganizationChartUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(OrganizationChart organizationChart) {
		getPersistence().clearCache(organizationChart);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationChart> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationChart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationChart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrganizationChart> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrganizationChart update(OrganizationChart organizationChart) {
		return getPersistence().update(organizationChart);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrganizationChart update(
		OrganizationChart organizationChart, ServiceContext serviceContext) {
		return getPersistence().update(organizationChart, serviceContext);
	}

	/**
	* Caches the organization chart in the entity cache if it is enabled.
	*
	* @param organizationChart the organization chart
	*/
	public static void cacheResult(OrganizationChart organizationChart) {
		getPersistence().cacheResult(organizationChart);
	}

	/**
	* Caches the organization charts in the entity cache if it is enabled.
	*
	* @param organizationCharts the organization charts
	*/
	public static void cacheResult(List<OrganizationChart> organizationCharts) {
		getPersistence().cacheResult(organizationCharts);
	}

	/**
	* Creates a new organization chart with the primary key. Does not add the organization chart to the database.
	*
	* @param idOrgChart the primary key for the new organization chart
	* @return the new organization chart
	*/
	public static OrganizationChart create(long idOrgChart) {
		return getPersistence().create(idOrgChart);
	}

	/**
	* Removes the organization chart with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart that was removed
	* @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	*/
	public static OrganizationChart remove(long idOrgChart)
		throws com.intranet.mef.job.siap.exception.NoSuchOrganizationChartException {
		return getPersistence().remove(idOrgChart);
	}

	public static OrganizationChart updateImpl(
		OrganizationChart organizationChart) {
		return getPersistence().updateImpl(organizationChart);
	}

	/**
	* Returns the organization chart with the primary key or throws a {@link NoSuchOrganizationChartException} if it could not be found.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart
	* @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	*/
	public static OrganizationChart findByPrimaryKey(long idOrgChart)
		throws com.intranet.mef.job.siap.exception.NoSuchOrganizationChartException {
		return getPersistence().findByPrimaryKey(idOrgChart);
	}

	/**
	* Returns the organization chart with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idOrgChart the primary key of the organization chart
	* @return the organization chart, or <code>null</code> if a organization chart with the primary key could not be found
	*/
	public static OrganizationChart fetchByPrimaryKey(long idOrgChart) {
		return getPersistence().fetchByPrimaryKey(idOrgChart);
	}

	public static java.util.Map<java.io.Serializable, OrganizationChart> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the organization charts.
	*
	* @return the organization charts
	*/
	public static List<OrganizationChart> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<OrganizationChart> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<OrganizationChart> findAll(int start, int end,
		OrderByComparator<OrganizationChart> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<OrganizationChart> findAll(int start, int end,
		OrderByComparator<OrganizationChart> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the organization charts from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of organization charts.
	*
	* @return the number of organization charts
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static OrganizationChartPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OrganizationChartPersistence, OrganizationChartPersistence> _serviceTracker =
		ServiceTrackerFactory.open(OrganizationChartPersistence.class);
}