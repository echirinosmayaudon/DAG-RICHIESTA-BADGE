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

package com.cacheportlet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.cacheportlet.mef.model.CachePortlet;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the cache portlet service. This utility wraps {@link com.cacheportlet.mef.service.persistence.impl.CachePortletPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CachePortletPersistence
 * @see com.cacheportlet.mef.service.persistence.impl.CachePortletPersistenceImpl
 * @generated
 */
@ProviderType
public class CachePortletUtil {
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
	public static void clearCache(CachePortlet cachePortlet) {
		getPersistence().clearCache(cachePortlet);
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
	public static List<CachePortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CachePortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CachePortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CachePortlet> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CachePortlet update(CachePortlet cachePortlet) {
		return getPersistence().update(cachePortlet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CachePortlet update(CachePortlet cachePortlet,
		ServiceContext serviceContext) {
		return getPersistence().update(cachePortlet, serviceContext);
	}

	/**
	* Returns all the cache portlets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching cache portlets
	*/
	public static List<CachePortlet> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the cache portlets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CachePortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cache portlets
	* @param end the upper bound of the range of cache portlets (not inclusive)
	* @return the range of matching cache portlets
	*/
	public static List<CachePortlet> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the cache portlets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CachePortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cache portlets
	* @param end the upper bound of the range of cache portlets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cache portlets
	*/
	public static List<CachePortlet> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<CachePortlet> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cache portlets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CachePortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cache portlets
	* @param end the upper bound of the range of cache portlets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cache portlets
	*/
	public static List<CachePortlet> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<CachePortlet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cache portlet
	* @throws NoSuchCachePortletException if a matching cache portlet could not be found
	*/
	public static CachePortlet findByUuid_First(java.lang.String uuid,
		OrderByComparator<CachePortlet> orderByComparator)
		throws com.cacheportlet.mef.exception.NoSuchCachePortletException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cache portlet, or <code>null</code> if a matching cache portlet could not be found
	*/
	public static CachePortlet fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<CachePortlet> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cache portlet
	* @throws NoSuchCachePortletException if a matching cache portlet could not be found
	*/
	public static CachePortlet findByUuid_Last(java.lang.String uuid,
		OrderByComparator<CachePortlet> orderByComparator)
		throws com.cacheportlet.mef.exception.NoSuchCachePortletException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cache portlet, or <code>null</code> if a matching cache portlet could not be found
	*/
	public static CachePortlet fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<CachePortlet> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the cache portlets before and after the current cache portlet in the ordered set where uuid = &#63;.
	*
	* @param portletId the primary key of the current cache portlet
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cache portlet
	* @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	*/
	public static CachePortlet[] findByUuid_PrevAndNext(
		java.lang.String portletId, java.lang.String uuid,
		OrderByComparator<CachePortlet> orderByComparator)
		throws com.cacheportlet.mef.exception.NoSuchCachePortletException {
		return getPersistence()
				   .findByUuid_PrevAndNext(portletId, uuid, orderByComparator);
	}

	/**
	* Removes all the cache portlets where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of cache portlets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching cache portlets
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the cache portlet in the entity cache if it is enabled.
	*
	* @param cachePortlet the cache portlet
	*/
	public static void cacheResult(CachePortlet cachePortlet) {
		getPersistence().cacheResult(cachePortlet);
	}

	/**
	* Caches the cache portlets in the entity cache if it is enabled.
	*
	* @param cachePortlets the cache portlets
	*/
	public static void cacheResult(List<CachePortlet> cachePortlets) {
		getPersistence().cacheResult(cachePortlets);
	}

	/**
	* Creates a new cache portlet with the primary key. Does not add the cache portlet to the database.
	*
	* @param portletId the primary key for the new cache portlet
	* @return the new cache portlet
	*/
	public static CachePortlet create(java.lang.String portletId) {
		return getPersistence().create(portletId);
	}

	/**
	* Removes the cache portlet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletId the primary key of the cache portlet
	* @return the cache portlet that was removed
	* @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	*/
	public static CachePortlet remove(java.lang.String portletId)
		throws com.cacheportlet.mef.exception.NoSuchCachePortletException {
		return getPersistence().remove(portletId);
	}

	public static CachePortlet updateImpl(CachePortlet cachePortlet) {
		return getPersistence().updateImpl(cachePortlet);
	}

	/**
	* Returns the cache portlet with the primary key or throws a {@link NoSuchCachePortletException} if it could not be found.
	*
	* @param portletId the primary key of the cache portlet
	* @return the cache portlet
	* @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	*/
	public static CachePortlet findByPrimaryKey(java.lang.String portletId)
		throws com.cacheportlet.mef.exception.NoSuchCachePortletException {
		return getPersistence().findByPrimaryKey(portletId);
	}

	/**
	* Returns the cache portlet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portletId the primary key of the cache portlet
	* @return the cache portlet, or <code>null</code> if a cache portlet with the primary key could not be found
	*/
	public static CachePortlet fetchByPrimaryKey(java.lang.String portletId) {
		return getPersistence().fetchByPrimaryKey(portletId);
	}

	public static java.util.Map<java.io.Serializable, CachePortlet> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the cache portlets.
	*
	* @return the cache portlets
	*/
	public static List<CachePortlet> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cache portlets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CachePortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cache portlets
	* @param end the upper bound of the range of cache portlets (not inclusive)
	* @return the range of cache portlets
	*/
	public static List<CachePortlet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cache portlets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CachePortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cache portlets
	* @param end the upper bound of the range of cache portlets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cache portlets
	*/
	public static List<CachePortlet> findAll(int start, int end,
		OrderByComparator<CachePortlet> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cache portlets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CachePortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cache portlets
	* @param end the upper bound of the range of cache portlets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cache portlets
	*/
	public static List<CachePortlet> findAll(int start, int end,
		OrderByComparator<CachePortlet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the cache portlets from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cache portlets.
	*
	* @return the number of cache portlets
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CachePortletPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CachePortletPersistence, CachePortletPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CachePortletPersistence.class);
}