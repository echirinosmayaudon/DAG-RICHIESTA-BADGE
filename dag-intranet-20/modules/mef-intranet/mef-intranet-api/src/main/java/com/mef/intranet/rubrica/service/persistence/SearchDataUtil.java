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

package com.mef.intranet.rubrica.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mef.intranet.rubrica.model.SearchData;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the search data service. This utility wraps {@link com.mef.intranet.rubrica.service.persistence.impl.SearchDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataPersistence
 * @see com.mef.intranet.rubrica.service.persistence.impl.SearchDataPersistenceImpl
 * @generated
 */
@ProviderType
public class SearchDataUtil {
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
	public static void clearCache(SearchData searchData) {
		getPersistence().clearCache(searchData);
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
	public static List<SearchData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SearchData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SearchData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SearchData> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SearchData update(SearchData searchData) {
		return getPersistence().update(searchData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SearchData update(SearchData searchData,
		ServiceContext serviceContext) {
		return getPersistence().update(searchData, serviceContext);
	}

	/**
	* Returns all the search datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching search datas
	*/
	public static List<SearchData> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the search datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of search datas
	* @param end the upper bound of the range of search datas (not inclusive)
	* @return the range of matching search datas
	*/
	public static List<SearchData> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the search datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of search datas
	* @param end the upper bound of the range of search datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search datas
	*/
	public static List<SearchData> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<SearchData> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the search datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of search datas
	* @param end the upper bound of the range of search datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching search datas
	*/
	public static List<SearchData> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<SearchData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search data
	* @throws NoSuchSearchDataException if a matching search data could not be found
	*/
	public static SearchData findByUuid_First(java.lang.String uuid,
		OrderByComparator<SearchData> orderByComparator)
		throws com.mef.intranet.rubrica.exception.NoSuchSearchDataException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search data, or <code>null</code> if a matching search data could not be found
	*/
	public static SearchData fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<SearchData> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search data
	* @throws NoSuchSearchDataException if a matching search data could not be found
	*/
	public static SearchData findByUuid_Last(java.lang.String uuid,
		OrderByComparator<SearchData> orderByComparator)
		throws com.mef.intranet.rubrica.exception.NoSuchSearchDataException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search data, or <code>null</code> if a matching search data could not be found
	*/
	public static SearchData fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<SearchData> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the search datas before and after the current search data in the ordered set where uuid = &#63;.
	*
	* @param searchId the primary key of the current search data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search data
	* @throws NoSuchSearchDataException if a search data with the primary key could not be found
	*/
	public static SearchData[] findByUuid_PrevAndNext(long searchId,
		java.lang.String uuid, OrderByComparator<SearchData> orderByComparator)
		throws com.mef.intranet.rubrica.exception.NoSuchSearchDataException {
		return getPersistence()
				   .findByUuid_PrevAndNext(searchId, uuid, orderByComparator);
	}

	/**
	* Removes all the search datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of search datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching search datas
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the search data in the entity cache if it is enabled.
	*
	* @param searchData the search data
	*/
	public static void cacheResult(SearchData searchData) {
		getPersistence().cacheResult(searchData);
	}

	/**
	* Caches the search datas in the entity cache if it is enabled.
	*
	* @param searchDatas the search datas
	*/
	public static void cacheResult(List<SearchData> searchDatas) {
		getPersistence().cacheResult(searchDatas);
	}

	/**
	* Creates a new search data with the primary key. Does not add the search data to the database.
	*
	* @param searchId the primary key for the new search data
	* @return the new search data
	*/
	public static SearchData create(long searchId) {
		return getPersistence().create(searchId);
	}

	/**
	* Removes the search data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchId the primary key of the search data
	* @return the search data that was removed
	* @throws NoSuchSearchDataException if a search data with the primary key could not be found
	*/
	public static SearchData remove(long searchId)
		throws com.mef.intranet.rubrica.exception.NoSuchSearchDataException {
		return getPersistence().remove(searchId);
	}

	public static SearchData updateImpl(SearchData searchData) {
		return getPersistence().updateImpl(searchData);
	}

	/**
	* Returns the search data with the primary key or throws a {@link NoSuchSearchDataException} if it could not be found.
	*
	* @param searchId the primary key of the search data
	* @return the search data
	* @throws NoSuchSearchDataException if a search data with the primary key could not be found
	*/
	public static SearchData findByPrimaryKey(long searchId)
		throws com.mef.intranet.rubrica.exception.NoSuchSearchDataException {
		return getPersistence().findByPrimaryKey(searchId);
	}

	/**
	* Returns the search data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param searchId the primary key of the search data
	* @return the search data, or <code>null</code> if a search data with the primary key could not be found
	*/
	public static SearchData fetchByPrimaryKey(long searchId) {
		return getPersistence().fetchByPrimaryKey(searchId);
	}

	public static java.util.Map<java.io.Serializable, SearchData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the search datas.
	*
	* @return the search datas
	*/
	public static List<SearchData> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the search datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search datas
	* @param end the upper bound of the range of search datas (not inclusive)
	* @return the range of search datas
	*/
	public static List<SearchData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the search datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search datas
	* @param end the upper bound of the range of search datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of search datas
	*/
	public static List<SearchData> findAll(int start, int end,
		OrderByComparator<SearchData> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the search datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search datas
	* @param end the upper bound of the range of search datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of search datas
	*/
	public static List<SearchData> findAll(int start, int end,
		OrderByComparator<SearchData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the search datas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of search datas.
	*
	* @return the number of search datas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SearchDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SearchDataPersistence, SearchDataPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SearchDataPersistence.class);
}