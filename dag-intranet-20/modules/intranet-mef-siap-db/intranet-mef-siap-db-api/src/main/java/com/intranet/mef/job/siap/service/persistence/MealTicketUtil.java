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

import com.intranet.mef.job.siap.model.MealTicket;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the meal ticket service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.MealTicketPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MealTicketPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.MealTicketPersistenceImpl
 * @generated
 */
@ProviderType
public class MealTicketUtil {
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
	public static void clearCache(MealTicket mealTicket) {
		getPersistence().clearCache(mealTicket);
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
	public static List<MealTicket> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MealTicket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MealTicket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MealTicket> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MealTicket update(MealTicket mealTicket) {
		return getPersistence().update(mealTicket);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MealTicket update(MealTicket mealTicket,
		ServiceContext serviceContext) {
		return getPersistence().update(mealTicket, serviceContext);
	}

	/**
	* Returns all the meal tickets where personID = &#63;.
	*
	* @param personID the person i d
	* @return the matching meal tickets
	*/
	public static List<MealTicket> findByPersonId(long personID) {
		return getPersistence().findByPersonId(personID);
	}

	/**
	* Returns a range of all the meal tickets where personID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @return the range of matching meal tickets
	*/
	public static List<MealTicket> findByPersonId(long personID, int start,
		int end) {
		return getPersistence().findByPersonId(personID, start, end);
	}

	/**
	* Returns an ordered range of all the meal tickets where personID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching meal tickets
	*/
	public static List<MealTicket> findByPersonId(long personID, int start,
		int end, OrderByComparator<MealTicket> orderByComparator) {
		return getPersistence()
				   .findByPersonId(personID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the meal tickets where personID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching meal tickets
	*/
	public static List<MealTicket> findByPersonId(long personID, int start,
		int end, OrderByComparator<MealTicket> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPersonId(personID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching meal ticket
	* @throws NoSuchMealTicketException if a matching meal ticket could not be found
	*/
	public static MealTicket findByPersonId_First(long personID,
		OrderByComparator<MealTicket> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchMealTicketException {
		return getPersistence().findByPersonId_First(personID, orderByComparator);
	}

	/**
	* Returns the first meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching meal ticket, or <code>null</code> if a matching meal ticket could not be found
	*/
	public static MealTicket fetchByPersonId_First(long personID,
		OrderByComparator<MealTicket> orderByComparator) {
		return getPersistence()
				   .fetchByPersonId_First(personID, orderByComparator);
	}

	/**
	* Returns the last meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching meal ticket
	* @throws NoSuchMealTicketException if a matching meal ticket could not be found
	*/
	public static MealTicket findByPersonId_Last(long personID,
		OrderByComparator<MealTicket> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchMealTicketException {
		return getPersistence().findByPersonId_Last(personID, orderByComparator);
	}

	/**
	* Returns the last meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching meal ticket, or <code>null</code> if a matching meal ticket could not be found
	*/
	public static MealTicket fetchByPersonId_Last(long personID,
		OrderByComparator<MealTicket> orderByComparator) {
		return getPersistence().fetchByPersonId_Last(personID, orderByComparator);
	}

	/**
	* Returns the meal tickets before and after the current meal ticket in the ordered set where personID = &#63;.
	*
	* @param custom_key the primary key of the current meal ticket
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next meal ticket
	* @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	*/
	public static MealTicket[] findByPersonId_PrevAndNext(
		java.lang.String custom_key, long personID,
		OrderByComparator<MealTicket> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchMealTicketException {
		return getPersistence()
				   .findByPersonId_PrevAndNext(custom_key, personID,
			orderByComparator);
	}

	/**
	* Removes all the meal tickets where personID = &#63; from the database.
	*
	* @param personID the person i d
	*/
	public static void removeByPersonId(long personID) {
		getPersistence().removeByPersonId(personID);
	}

	/**
	* Returns the number of meal tickets where personID = &#63;.
	*
	* @param personID the person i d
	* @return the number of matching meal tickets
	*/
	public static int countByPersonId(long personID) {
		return getPersistence().countByPersonId(personID);
	}

	/**
	* Caches the meal ticket in the entity cache if it is enabled.
	*
	* @param mealTicket the meal ticket
	*/
	public static void cacheResult(MealTicket mealTicket) {
		getPersistence().cacheResult(mealTicket);
	}

	/**
	* Caches the meal tickets in the entity cache if it is enabled.
	*
	* @param mealTickets the meal tickets
	*/
	public static void cacheResult(List<MealTicket> mealTickets) {
		getPersistence().cacheResult(mealTickets);
	}

	/**
	* Creates a new meal ticket with the primary key. Does not add the meal ticket to the database.
	*
	* @param custom_key the primary key for the new meal ticket
	* @return the new meal ticket
	*/
	public static MealTicket create(java.lang.String custom_key) {
		return getPersistence().create(custom_key);
	}

	/**
	* Removes the meal ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket that was removed
	* @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	*/
	public static MealTicket remove(java.lang.String custom_key)
		throws com.intranet.mef.job.siap.exception.NoSuchMealTicketException {
		return getPersistence().remove(custom_key);
	}

	public static MealTicket updateImpl(MealTicket mealTicket) {
		return getPersistence().updateImpl(mealTicket);
	}

	/**
	* Returns the meal ticket with the primary key or throws a {@link NoSuchMealTicketException} if it could not be found.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket
	* @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	*/
	public static MealTicket findByPrimaryKey(java.lang.String custom_key)
		throws com.intranet.mef.job.siap.exception.NoSuchMealTicketException {
		return getPersistence().findByPrimaryKey(custom_key);
	}

	/**
	* Returns the meal ticket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket, or <code>null</code> if a meal ticket with the primary key could not be found
	*/
	public static MealTicket fetchByPrimaryKey(java.lang.String custom_key) {
		return getPersistence().fetchByPrimaryKey(custom_key);
	}

	public static java.util.Map<java.io.Serializable, MealTicket> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the meal tickets.
	*
	* @return the meal tickets
	*/
	public static List<MealTicket> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the meal tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @return the range of meal tickets
	*/
	public static List<MealTicket> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the meal tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of meal tickets
	*/
	public static List<MealTicket> findAll(int start, int end,
		OrderByComparator<MealTicket> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the meal tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of meal tickets
	*/
	public static List<MealTicket> findAll(int start, int end,
		OrderByComparator<MealTicket> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the meal tickets from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of meal tickets.
	*
	* @return the number of meal tickets
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MealTicketPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MealTicketPersistence, MealTicketPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MealTicketPersistence.class);
}