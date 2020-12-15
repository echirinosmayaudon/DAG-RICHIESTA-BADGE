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

import com.intranet.mef.job.siap.model.CurrentBalanceHours;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the current balance hours service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.CurrentBalanceHoursPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrentBalanceHoursPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.CurrentBalanceHoursPersistenceImpl
 * @generated
 */
@ProviderType
public class CurrentBalanceHoursUtil {
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
	public static void clearCache(CurrentBalanceHours currentBalanceHours) {
		getPersistence().clearCache(currentBalanceHours);
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
	public static List<CurrentBalanceHours> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CurrentBalanceHours> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CurrentBalanceHours> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CurrentBalanceHours> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CurrentBalanceHours update(
		CurrentBalanceHours currentBalanceHours) {
		return getPersistence().update(currentBalanceHours);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CurrentBalanceHours update(
		CurrentBalanceHours currentBalanceHours, ServiceContext serviceContext) {
		return getPersistence().update(currentBalanceHours, serviceContext);
	}

	/**
	* Caches the current balance hours in the entity cache if it is enabled.
	*
	* @param currentBalanceHours the current balance hours
	*/
	public static void cacheResult(CurrentBalanceHours currentBalanceHours) {
		getPersistence().cacheResult(currentBalanceHours);
	}

	/**
	* Caches the current balance hourses in the entity cache if it is enabled.
	*
	* @param currentBalanceHourses the current balance hourses
	*/
	public static void cacheResult(
		List<CurrentBalanceHours> currentBalanceHourses) {
		getPersistence().cacheResult(currentBalanceHourses);
	}

	/**
	* Creates a new current balance hours with the primary key. Does not add the current balance hours to the database.
	*
	* @param personId the primary key for the new current balance hours
	* @return the new current balance hours
	*/
	public static CurrentBalanceHours create(long personId) {
		return getPersistence().create(personId);
	}

	/**
	* Removes the current balance hours with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the current balance hours
	* @return the current balance hours that was removed
	* @throws NoSuchCurrentBalanceHoursException if a current balance hours with the primary key could not be found
	*/
	public static CurrentBalanceHours remove(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchCurrentBalanceHoursException {
		return getPersistence().remove(personId);
	}

	public static CurrentBalanceHours updateImpl(
		CurrentBalanceHours currentBalanceHours) {
		return getPersistence().updateImpl(currentBalanceHours);
	}

	/**
	* Returns the current balance hours with the primary key or throws a {@link NoSuchCurrentBalanceHoursException} if it could not be found.
	*
	* @param personId the primary key of the current balance hours
	* @return the current balance hours
	* @throws NoSuchCurrentBalanceHoursException if a current balance hours with the primary key could not be found
	*/
	public static CurrentBalanceHours findByPrimaryKey(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchCurrentBalanceHoursException {
		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	* Returns the current balance hours with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the current balance hours
	* @return the current balance hours, or <code>null</code> if a current balance hours with the primary key could not be found
	*/
	public static CurrentBalanceHours fetchByPrimaryKey(long personId) {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	public static java.util.Map<java.io.Serializable, CurrentBalanceHours> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the current balance hourses.
	*
	* @return the current balance hourses
	*/
	public static List<CurrentBalanceHours> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the current balance hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of current balance hourses
	* @param end the upper bound of the range of current balance hourses (not inclusive)
	* @return the range of current balance hourses
	*/
	public static List<CurrentBalanceHours> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the current balance hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of current balance hourses
	* @param end the upper bound of the range of current balance hourses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of current balance hourses
	*/
	public static List<CurrentBalanceHours> findAll(int start, int end,
		OrderByComparator<CurrentBalanceHours> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the current balance hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of current balance hourses
	* @param end the upper bound of the range of current balance hourses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of current balance hourses
	*/
	public static List<CurrentBalanceHours> findAll(int start, int end,
		OrderByComparator<CurrentBalanceHours> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the current balance hourses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of current balance hourses.
	*
	* @return the number of current balance hourses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CurrentBalanceHoursPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CurrentBalanceHoursPersistence, CurrentBalanceHoursPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CurrentBalanceHoursPersistence.class);
}