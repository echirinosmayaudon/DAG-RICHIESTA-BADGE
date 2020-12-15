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

import com.cacheportlet.mef.exception.NoSuchCachePortletException;
import com.cacheportlet.mef.model.CachePortlet;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the cache portlet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.cacheportlet.mef.service.persistence.impl.CachePortletPersistenceImpl
 * @see CachePortletUtil
 * @generated
 */
@ProviderType
public interface CachePortletPersistence extends BasePersistence<CachePortlet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CachePortletUtil} to access the cache portlet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cache portlets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching cache portlets
	*/
	public java.util.List<CachePortlet> findByUuid(java.lang.String uuid);

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
	public java.util.List<CachePortlet> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<CachePortlet> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator);

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
	public java.util.List<CachePortlet> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cache portlet
	* @throws NoSuchCachePortletException if a matching cache portlet could not be found
	*/
	public CachePortlet findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator)
		throws NoSuchCachePortletException;

	/**
	* Returns the first cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cache portlet, or <code>null</code> if a matching cache portlet could not be found
	*/
	public CachePortlet fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator);

	/**
	* Returns the last cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cache portlet
	* @throws NoSuchCachePortletException if a matching cache portlet could not be found
	*/
	public CachePortlet findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator)
		throws NoSuchCachePortletException;

	/**
	* Returns the last cache portlet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cache portlet, or <code>null</code> if a matching cache portlet could not be found
	*/
	public CachePortlet fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator);

	/**
	* Returns the cache portlets before and after the current cache portlet in the ordered set where uuid = &#63;.
	*
	* @param portletId the primary key of the current cache portlet
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cache portlet
	* @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	*/
	public CachePortlet[] findByUuid_PrevAndNext(java.lang.String portletId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator)
		throws NoSuchCachePortletException;

	/**
	* Removes all the cache portlets where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of cache portlets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching cache portlets
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the cache portlet in the entity cache if it is enabled.
	*
	* @param cachePortlet the cache portlet
	*/
	public void cacheResult(CachePortlet cachePortlet);

	/**
	* Caches the cache portlets in the entity cache if it is enabled.
	*
	* @param cachePortlets the cache portlets
	*/
	public void cacheResult(java.util.List<CachePortlet> cachePortlets);

	/**
	* Creates a new cache portlet with the primary key. Does not add the cache portlet to the database.
	*
	* @param portletId the primary key for the new cache portlet
	* @return the new cache portlet
	*/
	public CachePortlet create(java.lang.String portletId);

	/**
	* Removes the cache portlet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletId the primary key of the cache portlet
	* @return the cache portlet that was removed
	* @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	*/
	public CachePortlet remove(java.lang.String portletId)
		throws NoSuchCachePortletException;

	public CachePortlet updateImpl(CachePortlet cachePortlet);

	/**
	* Returns the cache portlet with the primary key or throws a {@link NoSuchCachePortletException} if it could not be found.
	*
	* @param portletId the primary key of the cache portlet
	* @return the cache portlet
	* @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	*/
	public CachePortlet findByPrimaryKey(java.lang.String portletId)
		throws NoSuchCachePortletException;

	/**
	* Returns the cache portlet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portletId the primary key of the cache portlet
	* @return the cache portlet, or <code>null</code> if a cache portlet with the primary key could not be found
	*/
	public CachePortlet fetchByPrimaryKey(java.lang.String portletId);

	@Override
	public java.util.Map<java.io.Serializable, CachePortlet> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the cache portlets.
	*
	* @return the cache portlets
	*/
	public java.util.List<CachePortlet> findAll();

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
	public java.util.List<CachePortlet> findAll(int start, int end);

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
	public java.util.List<CachePortlet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator);

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
	public java.util.List<CachePortlet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CachePortlet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the cache portlets from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of cache portlets.
	*
	* @return the number of cache portlets
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}