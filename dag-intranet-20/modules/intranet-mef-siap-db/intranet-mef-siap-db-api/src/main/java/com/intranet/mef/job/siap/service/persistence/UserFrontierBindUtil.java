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

import com.intranet.mef.job.siap.model.UserFrontierBind;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user frontier bind service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.UserFrontierBindPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFrontierBindPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.UserFrontierBindPersistenceImpl
 * @generated
 */
@ProviderType
public class UserFrontierBindUtil {
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
	public static void clearCache(UserFrontierBind userFrontierBind) {
		getPersistence().clearCache(userFrontierBind);
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
	public static List<UserFrontierBind> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserFrontierBind> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserFrontierBind> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserFrontierBind> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserFrontierBind update(UserFrontierBind userFrontierBind) {
		return getPersistence().update(userFrontierBind);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserFrontierBind update(UserFrontierBind userFrontierBind,
		ServiceContext serviceContext) {
		return getPersistence().update(userFrontierBind, serviceContext);
	}

	/**
	* Caches the user frontier bind in the entity cache if it is enabled.
	*
	* @param userFrontierBind the user frontier bind
	*/
	public static void cacheResult(UserFrontierBind userFrontierBind) {
		getPersistence().cacheResult(userFrontierBind);
	}

	/**
	* Caches the user frontier binds in the entity cache if it is enabled.
	*
	* @param userFrontierBinds the user frontier binds
	*/
	public static void cacheResult(List<UserFrontierBind> userFrontierBinds) {
		getPersistence().cacheResult(userFrontierBinds);
	}

	/**
	* Creates a new user frontier bind with the primary key. Does not add the user frontier bind to the database.
	*
	* @param userFrontierBindPK the primary key for the new user frontier bind
	* @return the new user frontier bind
	*/
	public static UserFrontierBind create(UserFrontierBindPK userFrontierBindPK) {
		return getPersistence().create(userFrontierBindPK);
	}

	/**
	* Removes the user frontier bind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userFrontierBindPK the primary key of the user frontier bind
	* @return the user frontier bind that was removed
	* @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	*/
	public static UserFrontierBind remove(UserFrontierBindPK userFrontierBindPK)
		throws com.intranet.mef.job.siap.exception.NoSuchUserFrontierBindException {
		return getPersistence().remove(userFrontierBindPK);
	}

	public static UserFrontierBind updateImpl(UserFrontierBind userFrontierBind) {
		return getPersistence().updateImpl(userFrontierBind);
	}

	/**
	* Returns the user frontier bind with the primary key or throws a {@link NoSuchUserFrontierBindException} if it could not be found.
	*
	* @param userFrontierBindPK the primary key of the user frontier bind
	* @return the user frontier bind
	* @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	*/
	public static UserFrontierBind findByPrimaryKey(
		UserFrontierBindPK userFrontierBindPK)
		throws com.intranet.mef.job.siap.exception.NoSuchUserFrontierBindException {
		return getPersistence().findByPrimaryKey(userFrontierBindPK);
	}

	/**
	* Returns the user frontier bind with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userFrontierBindPK the primary key of the user frontier bind
	* @return the user frontier bind, or <code>null</code> if a user frontier bind with the primary key could not be found
	*/
	public static UserFrontierBind fetchByPrimaryKey(
		UserFrontierBindPK userFrontierBindPK) {
		return getPersistence().fetchByPrimaryKey(userFrontierBindPK);
	}

	public static java.util.Map<java.io.Serializable, UserFrontierBind> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user frontier binds.
	*
	* @return the user frontier binds
	*/
	public static List<UserFrontierBind> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user frontier binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user frontier binds
	* @param end the upper bound of the range of user frontier binds (not inclusive)
	* @return the range of user frontier binds
	*/
	public static List<UserFrontierBind> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user frontier binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user frontier binds
	* @param end the upper bound of the range of user frontier binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user frontier binds
	*/
	public static List<UserFrontierBind> findAll(int start, int end,
		OrderByComparator<UserFrontierBind> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user frontier binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user frontier binds
	* @param end the upper bound of the range of user frontier binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user frontier binds
	*/
	public static List<UserFrontierBind> findAll(int start, int end,
		OrderByComparator<UserFrontierBind> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user frontier binds from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user frontier binds.
	*
	* @return the number of user frontier binds
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserFrontierBindPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserFrontierBindPersistence, UserFrontierBindPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserFrontierBindPersistence.class);
}