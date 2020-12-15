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

import com.intranet.mef.job.siap.model.Punching;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the punching service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.PunchingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PunchingPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.PunchingPersistenceImpl
 * @generated
 */
@ProviderType
public class PunchingUtil {
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
	public static void clearCache(Punching punching) {
		getPersistence().clearCache(punching);
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
	public static List<Punching> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Punching> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Punching> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Punching> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Punching update(Punching punching) {
		return getPersistence().update(punching);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Punching update(Punching punching,
		ServiceContext serviceContext) {
		return getPersistence().update(punching, serviceContext);
	}

	/**
	* Returns all the punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the matching punchings
	*/
	public static List<Punching> findByPersonId(long personId) {
		return getPersistence().findByPersonId(personId);
	}

	/**
	* Returns a range of all the punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @return the range of matching punchings
	*/
	public static List<Punching> findByPersonId(long personId, int start,
		int end) {
		return getPersistence().findByPersonId(personId, start, end);
	}

	/**
	* Returns an ordered range of all the punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching punchings
	*/
	public static List<Punching> findByPersonId(long personId, int start,
		int end, OrderByComparator<Punching> orderByComparator) {
		return getPersistence()
				   .findByPersonId(personId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching punchings
	*/
	public static List<Punching> findByPersonId(long personId, int start,
		int end, OrderByComparator<Punching> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPersonId(personId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching punching
	* @throws NoSuchPunchingException if a matching punching could not be found
	*/
	public static Punching findByPersonId_First(long personId,
		OrderByComparator<Punching> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchPunchingException {
		return getPersistence().findByPersonId_First(personId, orderByComparator);
	}

	/**
	* Returns the first punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching punching, or <code>null</code> if a matching punching could not be found
	*/
	public static Punching fetchByPersonId_First(long personId,
		OrderByComparator<Punching> orderByComparator) {
		return getPersistence()
				   .fetchByPersonId_First(personId, orderByComparator);
	}

	/**
	* Returns the last punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching punching
	* @throws NoSuchPunchingException if a matching punching could not be found
	*/
	public static Punching findByPersonId_Last(long personId,
		OrderByComparator<Punching> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchPunchingException {
		return getPersistence().findByPersonId_Last(personId, orderByComparator);
	}

	/**
	* Returns the last punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching punching, or <code>null</code> if a matching punching could not be found
	*/
	public static Punching fetchByPersonId_Last(long personId,
		OrderByComparator<Punching> orderByComparator) {
		return getPersistence().fetchByPersonId_Last(personId, orderByComparator);
	}

	/**
	* Returns the punchings before and after the current punching in the ordered set where personId = &#63;.
	*
	* @param custom_key the primary key of the current punching
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next punching
	* @throws NoSuchPunchingException if a punching with the primary key could not be found
	*/
	public static Punching[] findByPersonId_PrevAndNext(
		java.lang.String custom_key, long personId,
		OrderByComparator<Punching> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchPunchingException {
		return getPersistence()
				   .findByPersonId_PrevAndNext(custom_key, personId,
			orderByComparator);
	}

	/**
	* Removes all the punchings where personId = &#63; from the database.
	*
	* @param personId the person ID
	*/
	public static void removeByPersonId(long personId) {
		getPersistence().removeByPersonId(personId);
	}

	/**
	* Returns the number of punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the number of matching punchings
	*/
	public static int countByPersonId(long personId) {
		return getPersistence().countByPersonId(personId);
	}

	/**
	* Caches the punching in the entity cache if it is enabled.
	*
	* @param punching the punching
	*/
	public static void cacheResult(Punching punching) {
		getPersistence().cacheResult(punching);
	}

	/**
	* Caches the punchings in the entity cache if it is enabled.
	*
	* @param punchings the punchings
	*/
	public static void cacheResult(List<Punching> punchings) {
		getPersistence().cacheResult(punchings);
	}

	/**
	* Creates a new punching with the primary key. Does not add the punching to the database.
	*
	* @param custom_key the primary key for the new punching
	* @return the new punching
	*/
	public static Punching create(java.lang.String custom_key) {
		return getPersistence().create(custom_key);
	}

	/**
	* Removes the punching with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the punching
	* @return the punching that was removed
	* @throws NoSuchPunchingException if a punching with the primary key could not be found
	*/
	public static Punching remove(java.lang.String custom_key)
		throws com.intranet.mef.job.siap.exception.NoSuchPunchingException {
		return getPersistence().remove(custom_key);
	}

	public static Punching updateImpl(Punching punching) {
		return getPersistence().updateImpl(punching);
	}

	/**
	* Returns the punching with the primary key or throws a {@link NoSuchPunchingException} if it could not be found.
	*
	* @param custom_key the primary key of the punching
	* @return the punching
	* @throws NoSuchPunchingException if a punching with the primary key could not be found
	*/
	public static Punching findByPrimaryKey(java.lang.String custom_key)
		throws com.intranet.mef.job.siap.exception.NoSuchPunchingException {
		return getPersistence().findByPrimaryKey(custom_key);
	}

	/**
	* Returns the punching with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the punching
	* @return the punching, or <code>null</code> if a punching with the primary key could not be found
	*/
	public static Punching fetchByPrimaryKey(java.lang.String custom_key) {
		return getPersistence().fetchByPrimaryKey(custom_key);
	}

	public static java.util.Map<java.io.Serializable, Punching> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the punchings.
	*
	* @return the punchings
	*/
	public static List<Punching> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @return the range of punchings
	*/
	public static List<Punching> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of punchings
	*/
	public static List<Punching> findAll(int start, int end,
		OrderByComparator<Punching> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of punchings
	*/
	public static List<Punching> findAll(int start, int end,
		OrderByComparator<Punching> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the punchings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of punchings.
	*
	* @return the number of punchings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PunchingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PunchingPersistence, PunchingPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PunchingPersistence.class);
}