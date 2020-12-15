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

import com.intranet.mef.job.siap.model.Festivity;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the festivity service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.FestivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FestivityPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.FestivityPersistenceImpl
 * @generated
 */
@ProviderType
public class FestivityUtil {
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
	public static void clearCache(Festivity festivity) {
		getPersistence().clearCache(festivity);
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
	public static List<Festivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Festivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Festivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Festivity> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Festivity update(Festivity festivity) {
		return getPersistence().update(festivity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Festivity update(Festivity festivity,
		ServiceContext serviceContext) {
		return getPersistence().update(festivity, serviceContext);
	}

	/**
	* Caches the festivity in the entity cache if it is enabled.
	*
	* @param festivity the festivity
	*/
	public static void cacheResult(Festivity festivity) {
		getPersistence().cacheResult(festivity);
	}

	/**
	* Caches the festivities in the entity cache if it is enabled.
	*
	* @param festivities the festivities
	*/
	public static void cacheResult(List<Festivity> festivities) {
		getPersistence().cacheResult(festivities);
	}

	/**
	* Creates a new festivity with the primary key. Does not add the festivity to the database.
	*
	* @param personId the primary key for the new festivity
	* @return the new festivity
	*/
	public static Festivity create(long personId) {
		return getPersistence().create(personId);
	}

	/**
	* Removes the festivity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the festivity
	* @return the festivity that was removed
	* @throws NoSuchFestivityException if a festivity with the primary key could not be found
	*/
	public static Festivity remove(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchFestivityException {
		return getPersistence().remove(personId);
	}

	public static Festivity updateImpl(Festivity festivity) {
		return getPersistence().updateImpl(festivity);
	}

	/**
	* Returns the festivity with the primary key or throws a {@link NoSuchFestivityException} if it could not be found.
	*
	* @param personId the primary key of the festivity
	* @return the festivity
	* @throws NoSuchFestivityException if a festivity with the primary key could not be found
	*/
	public static Festivity findByPrimaryKey(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchFestivityException {
		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	* Returns the festivity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the festivity
	* @return the festivity, or <code>null</code> if a festivity with the primary key could not be found
	*/
	public static Festivity fetchByPrimaryKey(long personId) {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	public static java.util.Map<java.io.Serializable, Festivity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the festivities.
	*
	* @return the festivities
	*/
	public static List<Festivity> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the festivities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of festivities
	* @param end the upper bound of the range of festivities (not inclusive)
	* @return the range of festivities
	*/
	public static List<Festivity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the festivities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of festivities
	* @param end the upper bound of the range of festivities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of festivities
	*/
	public static List<Festivity> findAll(int start, int end,
		OrderByComparator<Festivity> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the festivities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of festivities
	* @param end the upper bound of the range of festivities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of festivities
	*/
	public static List<Festivity> findAll(int start, int end,
		OrderByComparator<Festivity> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the festivities from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of festivities.
	*
	* @return the number of festivities
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FestivityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FestivityPersistence, FestivityPersistence> _serviceTracker =
		ServiceTrackerFactory.open(FestivityPersistence.class);
}