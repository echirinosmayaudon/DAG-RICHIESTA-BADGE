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

import com.intranet.mef.job.siap.model.ManagerOfficesBind;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the manager offices bind service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.ManagerOfficesBindPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ManagerOfficesBindPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.ManagerOfficesBindPersistenceImpl
 * @generated
 */
@ProviderType
public class ManagerOfficesBindUtil {
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
	public static void clearCache(ManagerOfficesBind managerOfficesBind) {
		getPersistence().clearCache(managerOfficesBind);
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
	public static List<ManagerOfficesBind> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ManagerOfficesBind> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ManagerOfficesBind> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ManagerOfficesBind update(
		ManagerOfficesBind managerOfficesBind) {
		return getPersistence().update(managerOfficesBind);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ManagerOfficesBind update(
		ManagerOfficesBind managerOfficesBind, ServiceContext serviceContext) {
		return getPersistence().update(managerOfficesBind, serviceContext);
	}

	/**
	* Returns all the manager offices binds where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @return the matching manager offices binds
	*/
	public static List<ManagerOfficesBind> findByPersonId(long personalId) {
		return getPersistence().findByPersonId(personalId);
	}

	/**
	* Returns a range of all the manager offices binds where personalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personalId the personal ID
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @return the range of matching manager offices binds
	*/
	public static List<ManagerOfficesBind> findByPersonId(long personalId,
		int start, int end) {
		return getPersistence().findByPersonId(personalId, start, end);
	}

	/**
	* Returns an ordered range of all the manager offices binds where personalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personalId the personal ID
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manager offices binds
	*/
	public static List<ManagerOfficesBind> findByPersonId(long personalId,
		int start, int end,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		return getPersistence()
				   .findByPersonId(personalId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the manager offices binds where personalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personalId the personal ID
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching manager offices binds
	*/
	public static List<ManagerOfficesBind> findByPersonId(long personalId,
		int start, int end,
		OrderByComparator<ManagerOfficesBind> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPersonId(personalId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manager offices bind
	* @throws NoSuchManagerOfficesBindException if a matching manager offices bind could not be found
	*/
	public static ManagerOfficesBind findByPersonId_First(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchManagerOfficesBindException {
		return getPersistence()
				   .findByPersonId_First(personalId, orderByComparator);
	}

	/**
	* Returns the first manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manager offices bind, or <code>null</code> if a matching manager offices bind could not be found
	*/
	public static ManagerOfficesBind fetchByPersonId_First(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		return getPersistence()
				   .fetchByPersonId_First(personalId, orderByComparator);
	}

	/**
	* Returns the last manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manager offices bind
	* @throws NoSuchManagerOfficesBindException if a matching manager offices bind could not be found
	*/
	public static ManagerOfficesBind findByPersonId_Last(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchManagerOfficesBindException {
		return getPersistence()
				   .findByPersonId_Last(personalId, orderByComparator);
	}

	/**
	* Returns the last manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manager offices bind, or <code>null</code> if a matching manager offices bind could not be found
	*/
	public static ManagerOfficesBind fetchByPersonId_Last(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		return getPersistence()
				   .fetchByPersonId_Last(personalId, orderByComparator);
	}

	/**
	* Returns the manager offices binds before and after the current manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param managerOfficesBindPK the primary key of the current manager offices bind
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manager offices bind
	* @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	*/
	public static ManagerOfficesBind[] findByPersonId_PrevAndNext(
		ManagerOfficesBindPK managerOfficesBindPK, long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchManagerOfficesBindException {
		return getPersistence()
				   .findByPersonId_PrevAndNext(managerOfficesBindPK,
			personalId, orderByComparator);
	}

	/**
	* Removes all the manager offices binds where personalId = &#63; from the database.
	*
	* @param personalId the personal ID
	*/
	public static void removeByPersonId(long personalId) {
		getPersistence().removeByPersonId(personalId);
	}

	/**
	* Returns the number of manager offices binds where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @return the number of matching manager offices binds
	*/
	public static int countByPersonId(long personalId) {
		return getPersistence().countByPersonId(personalId);
	}

	/**
	* Caches the manager offices bind in the entity cache if it is enabled.
	*
	* @param managerOfficesBind the manager offices bind
	*/
	public static void cacheResult(ManagerOfficesBind managerOfficesBind) {
		getPersistence().cacheResult(managerOfficesBind);
	}

	/**
	* Caches the manager offices binds in the entity cache if it is enabled.
	*
	* @param managerOfficesBinds the manager offices binds
	*/
	public static void cacheResult(List<ManagerOfficesBind> managerOfficesBinds) {
		getPersistence().cacheResult(managerOfficesBinds);
	}

	/**
	* Creates a new manager offices bind with the primary key. Does not add the manager offices bind to the database.
	*
	* @param managerOfficesBindPK the primary key for the new manager offices bind
	* @return the new manager offices bind
	*/
	public static ManagerOfficesBind create(
		ManagerOfficesBindPK managerOfficesBindPK) {
		return getPersistence().create(managerOfficesBindPK);
	}

	/**
	* Removes the manager offices bind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind that was removed
	* @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	*/
	public static ManagerOfficesBind remove(
		ManagerOfficesBindPK managerOfficesBindPK)
		throws com.intranet.mef.job.siap.exception.NoSuchManagerOfficesBindException {
		return getPersistence().remove(managerOfficesBindPK);
	}

	public static ManagerOfficesBind updateImpl(
		ManagerOfficesBind managerOfficesBind) {
		return getPersistence().updateImpl(managerOfficesBind);
	}

	/**
	* Returns the manager offices bind with the primary key or throws a {@link NoSuchManagerOfficesBindException} if it could not be found.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind
	* @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	*/
	public static ManagerOfficesBind findByPrimaryKey(
		ManagerOfficesBindPK managerOfficesBindPK)
		throws com.intranet.mef.job.siap.exception.NoSuchManagerOfficesBindException {
		return getPersistence().findByPrimaryKey(managerOfficesBindPK);
	}

	/**
	* Returns the manager offices bind with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind, or <code>null</code> if a manager offices bind with the primary key could not be found
	*/
	public static ManagerOfficesBind fetchByPrimaryKey(
		ManagerOfficesBindPK managerOfficesBindPK) {
		return getPersistence().fetchByPrimaryKey(managerOfficesBindPK);
	}

	public static java.util.Map<java.io.Serializable, ManagerOfficesBind> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the manager offices binds.
	*
	* @return the manager offices binds
	*/
	public static List<ManagerOfficesBind> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the manager offices binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @return the range of manager offices binds
	*/
	public static List<ManagerOfficesBind> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the manager offices binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of manager offices binds
	*/
	public static List<ManagerOfficesBind> findAll(int start, int end,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the manager offices binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of manager offices binds
	*/
	public static List<ManagerOfficesBind> findAll(int start, int end,
		OrderByComparator<ManagerOfficesBind> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the manager offices binds from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of manager offices binds.
	*
	* @return the number of manager offices binds
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ManagerOfficesBindPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ManagerOfficesBindPersistence, ManagerOfficesBindPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ManagerOfficesBindPersistence.class);
}