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

import com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the overtime balace prev month service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.OvertimeBalacePrevMonthPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalacePrevMonthPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.OvertimeBalacePrevMonthPersistenceImpl
 * @generated
 */
@ProviderType
public class OvertimeBalacePrevMonthUtil {
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
	public static void clearCache(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		getPersistence().clearCache(overtimeBalacePrevMonth);
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
	public static List<OvertimeBalacePrevMonth> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OvertimeBalacePrevMonth> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OvertimeBalacePrevMonth> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OvertimeBalacePrevMonth> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OvertimeBalacePrevMonth update(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		return getPersistence().update(overtimeBalacePrevMonth);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OvertimeBalacePrevMonth update(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth,
		ServiceContext serviceContext) {
		return getPersistence().update(overtimeBalacePrevMonth, serviceContext);
	}

	/**
	* Caches the overtime balace prev month in the entity cache if it is enabled.
	*
	* @param overtimeBalacePrevMonth the overtime balace prev month
	*/
	public static void cacheResult(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		getPersistence().cacheResult(overtimeBalacePrevMonth);
	}

	/**
	* Caches the overtime balace prev months in the entity cache if it is enabled.
	*
	* @param overtimeBalacePrevMonths the overtime balace prev months
	*/
	public static void cacheResult(
		List<OvertimeBalacePrevMonth> overtimeBalacePrevMonths) {
		getPersistence().cacheResult(overtimeBalacePrevMonths);
	}

	/**
	* Creates a new overtime balace prev month with the primary key. Does not add the overtime balace prev month to the database.
	*
	* @param personId the primary key for the new overtime balace prev month
	* @return the new overtime balace prev month
	*/
	public static OvertimeBalacePrevMonth create(long personId) {
		return getPersistence().create(personId);
	}

	/**
	* Removes the overtime balace prev month with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month that was removed
	* @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	*/
	public static OvertimeBalacePrevMonth remove(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchOvertimeBalacePrevMonthException {
		return getPersistence().remove(personId);
	}

	public static OvertimeBalacePrevMonth updateImpl(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		return getPersistence().updateImpl(overtimeBalacePrevMonth);
	}

	/**
	* Returns the overtime balace prev month with the primary key or throws a {@link NoSuchOvertimeBalacePrevMonthException} if it could not be found.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month
	* @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	*/
	public static OvertimeBalacePrevMonth findByPrimaryKey(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchOvertimeBalacePrevMonthException {
		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	* Returns the overtime balace prev month with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month, or <code>null</code> if a overtime balace prev month with the primary key could not be found
	*/
	public static OvertimeBalacePrevMonth fetchByPrimaryKey(long personId) {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	public static java.util.Map<java.io.Serializable, OvertimeBalacePrevMonth> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the overtime balace prev months.
	*
	* @return the overtime balace prev months
	*/
	public static List<OvertimeBalacePrevMonth> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the overtime balace prev months.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balace prev months
	* @param end the upper bound of the range of overtime balace prev months (not inclusive)
	* @return the range of overtime balace prev months
	*/
	public static List<OvertimeBalacePrevMonth> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the overtime balace prev months.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balace prev months
	* @param end the upper bound of the range of overtime balace prev months (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of overtime balace prev months
	*/
	public static List<OvertimeBalacePrevMonth> findAll(int start, int end,
		OrderByComparator<OvertimeBalacePrevMonth> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the overtime balace prev months.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balace prev months
	* @param end the upper bound of the range of overtime balace prev months (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of overtime balace prev months
	*/
	public static List<OvertimeBalacePrevMonth> findAll(int start, int end,
		OrderByComparator<OvertimeBalacePrevMonth> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the overtime balace prev months from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of overtime balace prev months.
	*
	* @return the number of overtime balace prev months
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static OvertimeBalacePrevMonthPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OvertimeBalacePrevMonthPersistence, OvertimeBalacePrevMonthPersistence> _serviceTracker =
		ServiceTrackerFactory.open(OvertimeBalacePrevMonthPersistence.class);
}