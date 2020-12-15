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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mef.intranet.rubrica.exception.NoSuchSearchDataException;
import com.mef.intranet.rubrica.model.SearchData;

/**
 * The persistence interface for the search data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.mef.intranet.rubrica.service.persistence.impl.SearchDataPersistenceImpl
 * @see SearchDataUtil
 * @generated
 */
@ProviderType
public interface SearchDataPersistence extends BasePersistence<SearchData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SearchDataUtil} to access the search data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the search datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching search datas
	*/
	public java.util.List<SearchData> findByUuid(java.lang.String uuid);

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
	public java.util.List<SearchData> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<SearchData> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator);

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
	public java.util.List<SearchData> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search data
	* @throws NoSuchSearchDataException if a matching search data could not be found
	*/
	public SearchData findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator)
		throws NoSuchSearchDataException;

	/**
	* Returns the first search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search data, or <code>null</code> if a matching search data could not be found
	*/
	public SearchData fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator);

	/**
	* Returns the last search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search data
	* @throws NoSuchSearchDataException if a matching search data could not be found
	*/
	public SearchData findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator)
		throws NoSuchSearchDataException;

	/**
	* Returns the last search data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search data, or <code>null</code> if a matching search data could not be found
	*/
	public SearchData fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator);

	/**
	* Returns the search datas before and after the current search data in the ordered set where uuid = &#63;.
	*
	* @param searchId the primary key of the current search data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search data
	* @throws NoSuchSearchDataException if a search data with the primary key could not be found
	*/
	public SearchData[] findByUuid_PrevAndNext(long searchId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator)
		throws NoSuchSearchDataException;

	/**
	* Removes all the search datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of search datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching search datas
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the search data in the entity cache if it is enabled.
	*
	* @param searchData the search data
	*/
	public void cacheResult(SearchData searchData);

	/**
	* Caches the search datas in the entity cache if it is enabled.
	*
	* @param searchDatas the search datas
	*/
	public void cacheResult(java.util.List<SearchData> searchDatas);

	/**
	* Creates a new search data with the primary key. Does not add the search data to the database.
	*
	* @param searchId the primary key for the new search data
	* @return the new search data
	*/
	public SearchData create(long searchId);

	/**
	* Removes the search data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchId the primary key of the search data
	* @return the search data that was removed
	* @throws NoSuchSearchDataException if a search data with the primary key could not be found
	*/
	public SearchData remove(long searchId) throws NoSuchSearchDataException;

	public SearchData updateImpl(SearchData searchData);

	/**
	* Returns the search data with the primary key or throws a {@link NoSuchSearchDataException} if it could not be found.
	*
	* @param searchId the primary key of the search data
	* @return the search data
	* @throws NoSuchSearchDataException if a search data with the primary key could not be found
	*/
	public SearchData findByPrimaryKey(long searchId)
		throws NoSuchSearchDataException;

	/**
	* Returns the search data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param searchId the primary key of the search data
	* @return the search data, or <code>null</code> if a search data with the primary key could not be found
	*/
	public SearchData fetchByPrimaryKey(long searchId);

	@Override
	public java.util.Map<java.io.Serializable, SearchData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the search datas.
	*
	* @return the search datas
	*/
	public java.util.List<SearchData> findAll();

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
	public java.util.List<SearchData> findAll(int start, int end);

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
	public java.util.List<SearchData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator);

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
	public java.util.List<SearchData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SearchData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the search datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of search datas.
	*
	* @return the number of search datas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}