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

import com.intranet.mef.job.siap.model.UserPosition;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user position service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.UserPositionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPositionPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.UserPositionPersistenceImpl
 * @generated
 */
@ProviderType
public class UserPositionUtil {
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
	public static void clearCache(UserPosition userPosition) {
		getPersistence().clearCache(userPosition);
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
	public static List<UserPosition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserPosition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserPosition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserPosition> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserPosition update(UserPosition userPosition) {
		return getPersistence().update(userPosition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserPosition update(UserPosition userPosition,
		ServiceContext serviceContext) {
		return getPersistence().update(userPosition, serviceContext);
	}

	/**
	* Caches the user position in the entity cache if it is enabled.
	*
	* @param userPosition the user position
	*/
	public static void cacheResult(UserPosition userPosition) {
		getPersistence().cacheResult(userPosition);
	}

	/**
	* Caches the user positions in the entity cache if it is enabled.
	*
	* @param userPositions the user positions
	*/
	public static void cacheResult(List<UserPosition> userPositions) {
		getPersistence().cacheResult(userPositions);
	}

	/**
	* Creates a new user position with the primary key. Does not add the user position to the database.
	*
	* @param pos the primary key for the new user position
	* @return the new user position
	*/
	public static UserPosition create(java.lang.String pos) {
		return getPersistence().create(pos);
	}

	/**
	* Removes the user position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pos the primary key of the user position
	* @return the user position that was removed
	* @throws NoSuchUserPositionException if a user position with the primary key could not be found
	*/
	public static UserPosition remove(java.lang.String pos)
		throws com.intranet.mef.job.siap.exception.NoSuchUserPositionException {
		return getPersistence().remove(pos);
	}

	public static UserPosition updateImpl(UserPosition userPosition) {
		return getPersistence().updateImpl(userPosition);
	}

	/**
	* Returns the user position with the primary key or throws a {@link NoSuchUserPositionException} if it could not be found.
	*
	* @param pos the primary key of the user position
	* @return the user position
	* @throws NoSuchUserPositionException if a user position with the primary key could not be found
	*/
	public static UserPosition findByPrimaryKey(java.lang.String pos)
		throws com.intranet.mef.job.siap.exception.NoSuchUserPositionException {
		return getPersistence().findByPrimaryKey(pos);
	}

	/**
	* Returns the user position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pos the primary key of the user position
	* @return the user position, or <code>null</code> if a user position with the primary key could not be found
	*/
	public static UserPosition fetchByPrimaryKey(java.lang.String pos) {
		return getPersistence().fetchByPrimaryKey(pos);
	}

	public static java.util.Map<java.io.Serializable, UserPosition> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user positions.
	*
	* @return the user positions
	*/
	public static List<UserPosition> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user positions
	* @param end the upper bound of the range of user positions (not inclusive)
	* @return the range of user positions
	*/
	public static List<UserPosition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user positions
	* @param end the upper bound of the range of user positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user positions
	*/
	public static List<UserPosition> findAll(int start, int end,
		OrderByComparator<UserPosition> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user positions
	* @param end the upper bound of the range of user positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user positions
	*/
	public static List<UserPosition> findAll(int start, int end,
		OrderByComparator<UserPosition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user positions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user positions.
	*
	* @return the number of user positions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserPositionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserPositionPersistence, UserPositionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserPositionPersistence.class);
}