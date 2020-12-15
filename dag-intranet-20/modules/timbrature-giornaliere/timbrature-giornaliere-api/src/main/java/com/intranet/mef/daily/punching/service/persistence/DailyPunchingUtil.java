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

package com.intranet.mef.daily.punching.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.daily.punching.model.DailyPunching;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the daily punching service. This utility wraps {@link com.intranet.mef.daily.punching.service.persistence.impl.DailyPunchingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DailyPunchingPersistence
 * @see com.intranet.mef.daily.punching.service.persistence.impl.DailyPunchingPersistenceImpl
 * @generated
 */
@ProviderType
public class DailyPunchingUtil {
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
	public static void clearCache(DailyPunching dailyPunching) {
		getPersistence().clearCache(dailyPunching);
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
	public static List<DailyPunching> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DailyPunching> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DailyPunching> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DailyPunching> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DailyPunching update(DailyPunching dailyPunching) {
		return getPersistence().update(dailyPunching);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DailyPunching update(DailyPunching dailyPunching,
		ServiceContext serviceContext) {
		return getPersistence().update(dailyPunching, serviceContext);
	}

	/**
	* Returns all the daily punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the matching daily punchings
	*/
	public static List<DailyPunching> findByPersonId(long personId) {
		return getPersistence().findByPersonId(personId);
	}

	/**
	* Returns a range of all the daily punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @return the range of matching daily punchings
	*/
	public static List<DailyPunching> findByPersonId(long personId, int start,
		int end) {
		return getPersistence().findByPersonId(personId, start, end);
	}

	/**
	* Returns an ordered range of all the daily punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching daily punchings
	*/
	public static List<DailyPunching> findByPersonId(long personId, int start,
		int end, OrderByComparator<DailyPunching> orderByComparator) {
		return getPersistence()
				   .findByPersonId(personId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the daily punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching daily punchings
	*/
	public static List<DailyPunching> findByPersonId(long personId, int start,
		int end, OrderByComparator<DailyPunching> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPersonId(personId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching daily punching
	* @throws NoSuchDailyPunchingException if a matching daily punching could not be found
	*/
	public static DailyPunching findByPersonId_First(long personId,
		OrderByComparator<DailyPunching> orderByComparator)
		throws com.intranet.mef.daily.punching.exception.NoSuchDailyPunchingException {
		return getPersistence().findByPersonId_First(personId, orderByComparator);
	}

	/**
	* Returns the first daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching daily punching, or <code>null</code> if a matching daily punching could not be found
	*/
	public static DailyPunching fetchByPersonId_First(long personId,
		OrderByComparator<DailyPunching> orderByComparator) {
		return getPersistence()
				   .fetchByPersonId_First(personId, orderByComparator);
	}

	/**
	* Returns the last daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching daily punching
	* @throws NoSuchDailyPunchingException if a matching daily punching could not be found
	*/
	public static DailyPunching findByPersonId_Last(long personId,
		OrderByComparator<DailyPunching> orderByComparator)
		throws com.intranet.mef.daily.punching.exception.NoSuchDailyPunchingException {
		return getPersistence().findByPersonId_Last(personId, orderByComparator);
	}

	/**
	* Returns the last daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching daily punching, or <code>null</code> if a matching daily punching could not be found
	*/
	public static DailyPunching fetchByPersonId_Last(long personId,
		OrderByComparator<DailyPunching> orderByComparator) {
		return getPersistence().fetchByPersonId_Last(personId, orderByComparator);
	}

	/**
	* Returns the daily punchings before and after the current daily punching in the ordered set where personId = &#63;.
	*
	* @param custom_key the primary key of the current daily punching
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next daily punching
	* @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	*/
	public static DailyPunching[] findByPersonId_PrevAndNext(
		java.lang.String custom_key, long personId,
		OrderByComparator<DailyPunching> orderByComparator)
		throws com.intranet.mef.daily.punching.exception.NoSuchDailyPunchingException {
		return getPersistence()
				   .findByPersonId_PrevAndNext(custom_key, personId,
			orderByComparator);
	}

	/**
	* Removes all the daily punchings where personId = &#63; from the database.
	*
	* @param personId the person ID
	*/
	public static void removeByPersonId(long personId) {
		getPersistence().removeByPersonId(personId);
	}

	/**
	* Returns the number of daily punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the number of matching daily punchings
	*/
	public static int countByPersonId(long personId) {
		return getPersistence().countByPersonId(personId);
	}

	/**
	* Caches the daily punching in the entity cache if it is enabled.
	*
	* @param dailyPunching the daily punching
	*/
	public static void cacheResult(DailyPunching dailyPunching) {
		getPersistence().cacheResult(dailyPunching);
	}

	/**
	* Caches the daily punchings in the entity cache if it is enabled.
	*
	* @param dailyPunchings the daily punchings
	*/
	public static void cacheResult(List<DailyPunching> dailyPunchings) {
		getPersistence().cacheResult(dailyPunchings);
	}

	/**
	* Creates a new daily punching with the primary key. Does not add the daily punching to the database.
	*
	* @param custom_key the primary key for the new daily punching
	* @return the new daily punching
	*/
	public static DailyPunching create(java.lang.String custom_key) {
		return getPersistence().create(custom_key);
	}

	/**
	* Removes the daily punching with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching that was removed
	* @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	*/
	public static DailyPunching remove(java.lang.String custom_key)
		throws com.intranet.mef.daily.punching.exception.NoSuchDailyPunchingException {
		return getPersistence().remove(custom_key);
	}

	public static DailyPunching updateImpl(DailyPunching dailyPunching) {
		return getPersistence().updateImpl(dailyPunching);
	}

	/**
	* Returns the daily punching with the primary key or throws a {@link NoSuchDailyPunchingException} if it could not be found.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching
	* @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	*/
	public static DailyPunching findByPrimaryKey(java.lang.String custom_key)
		throws com.intranet.mef.daily.punching.exception.NoSuchDailyPunchingException {
		return getPersistence().findByPrimaryKey(custom_key);
	}

	/**
	* Returns the daily punching with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching, or <code>null</code> if a daily punching with the primary key could not be found
	*/
	public static DailyPunching fetchByPrimaryKey(java.lang.String custom_key) {
		return getPersistence().fetchByPrimaryKey(custom_key);
	}

	public static java.util.Map<java.io.Serializable, DailyPunching> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the daily punchings.
	*
	* @return the daily punchings
	*/
	public static List<DailyPunching> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the daily punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @return the range of daily punchings
	*/
	public static List<DailyPunching> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the daily punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of daily punchings
	*/
	public static List<DailyPunching> findAll(int start, int end,
		OrderByComparator<DailyPunching> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the daily punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of daily punchings
	*/
	public static List<DailyPunching> findAll(int start, int end,
		OrderByComparator<DailyPunching> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the daily punchings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of daily punchings.
	*
	* @return the number of daily punchings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DailyPunchingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DailyPunchingPersistence, DailyPunchingPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DailyPunchingPersistence.class);
}