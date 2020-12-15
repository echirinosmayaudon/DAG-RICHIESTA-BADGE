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

package com.mef.intranet.rubrica.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.mef.intranet.rubrica.exception.NoSuchSearchDataException;
import com.mef.intranet.rubrica.model.SearchData;
import com.mef.intranet.rubrica.model.impl.SearchDataImpl;
import com.mef.intranet.rubrica.model.impl.SearchDataModelImpl;
import com.mef.intranet.rubrica.service.persistence.SearchDataPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the search data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataPersistence
 * @see com.mef.intranet.rubrica.service.persistence.SearchDataUtil
 * @generated
 */
@ProviderType
public class SearchDataPersistenceImpl extends BasePersistenceImpl<SearchData>
	implements SearchDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SearchDataUtil} to access the search data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SearchDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataModelImpl.FINDER_CACHE_ENABLED, SearchDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataModelImpl.FINDER_CACHE_ENABLED, SearchDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataModelImpl.FINDER_CACHE_ENABLED, SearchDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataModelImpl.FINDER_CACHE_ENABLED, SearchDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SearchDataModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the search datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching search datas
	 */
	@Override
	public List<SearchData> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchData> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<SearchData> findByUuid(String uuid, int start, int end,
		OrderByComparator<SearchData> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<SearchData> findByUuid(String uuid, int start, int end,
		OrderByComparator<SearchData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<SearchData> list = null;

		if (retrieveFromCache) {
			list = (List<SearchData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SearchData searchData : list) {
					if (!Objects.equals(uuid, searchData.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SEARCHDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<SearchData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SearchData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first search data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search data
	 * @throws NoSuchSearchDataException if a matching search data could not be found
	 */
	@Override
	public SearchData findByUuid_First(String uuid,
		OrderByComparator<SearchData> orderByComparator)
		throws NoSuchSearchDataException {
		SearchData searchData = fetchByUuid_First(uuid, orderByComparator);

		if (searchData != null) {
			return searchData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchDataException(msg.toString());
	}

	/**
	 * Returns the first search data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search data, or <code>null</code> if a matching search data could not be found
	 */
	@Override
	public SearchData fetchByUuid_First(String uuid,
		OrderByComparator<SearchData> orderByComparator) {
		List<SearchData> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search data
	 * @throws NoSuchSearchDataException if a matching search data could not be found
	 */
	@Override
	public SearchData findByUuid_Last(String uuid,
		OrderByComparator<SearchData> orderByComparator)
		throws NoSuchSearchDataException {
		SearchData searchData = fetchByUuid_Last(uuid, orderByComparator);

		if (searchData != null) {
			return searchData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchDataException(msg.toString());
	}

	/**
	 * Returns the last search data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search data, or <code>null</code> if a matching search data could not be found
	 */
	@Override
	public SearchData fetchByUuid_Last(String uuid,
		OrderByComparator<SearchData> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SearchData> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchData[] findByUuid_PrevAndNext(long searchId, String uuid,
		OrderByComparator<SearchData> orderByComparator)
		throws NoSuchSearchDataException {
		SearchData searchData = findByPrimaryKey(searchId);

		Session session = null;

		try {
			session = openSession();

			SearchData[] array = new SearchDataImpl[3];

			array[0] = getByUuid_PrevAndNext(session, searchData, uuid,
					orderByComparator, true);

			array[1] = searchData;

			array[2] = getByUuid_PrevAndNext(session, searchData, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchData getByUuid_PrevAndNext(Session session,
		SearchData searchData, String uuid,
		OrderByComparator<SearchData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHDATA_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SearchDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SearchData searchData : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(searchData);
		}
	}

	/**
	 * Returns the number of search datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching search datas
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "searchData.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "searchData.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(searchData.uuid IS NULL OR searchData.uuid = '')";

	public SearchDataPersistenceImpl() {
		setModelClass(SearchData.class);
	}

	/**
	 * Caches the search data in the entity cache if it is enabled.
	 *
	 * @param searchData the search data
	 */
	@Override
	public void cacheResult(SearchData searchData) {
		entityCache.putResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataImpl.class, searchData.getPrimaryKey(), searchData);

		searchData.resetOriginalValues();
	}

	/**
	 * Caches the search datas in the entity cache if it is enabled.
	 *
	 * @param searchDatas the search datas
	 */
	@Override
	public void cacheResult(List<SearchData> searchDatas) {
		for (SearchData searchData : searchDatas) {
			if (entityCache.getResult(
						SearchDataModelImpl.ENTITY_CACHE_ENABLED,
						SearchDataImpl.class, searchData.getPrimaryKey()) == null) {
				cacheResult(searchData);
			}
			else {
				searchData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all search datas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SearchDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the search data.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SearchData searchData) {
		entityCache.removeResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataImpl.class, searchData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SearchData> searchDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SearchData searchData : searchDatas) {
			entityCache.removeResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
				SearchDataImpl.class, searchData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new search data with the primary key. Does not add the search data to the database.
	 *
	 * @param searchId the primary key for the new search data
	 * @return the new search data
	 */
	@Override
	public SearchData create(long searchId) {
		SearchData searchData = new SearchDataImpl();

		searchData.setNew(true);
		searchData.setPrimaryKey(searchId);

		String uuid = PortalUUIDUtil.generate();

		searchData.setUuid(uuid);

		return searchData;
	}

	/**
	 * Removes the search data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchId the primary key of the search data
	 * @return the search data that was removed
	 * @throws NoSuchSearchDataException if a search data with the primary key could not be found
	 */
	@Override
	public SearchData remove(long searchId) throws NoSuchSearchDataException {
		return remove((Serializable)searchId);
	}

	/**
	 * Removes the search data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the search data
	 * @return the search data that was removed
	 * @throws NoSuchSearchDataException if a search data with the primary key could not be found
	 */
	@Override
	public SearchData remove(Serializable primaryKey)
		throws NoSuchSearchDataException {
		Session session = null;

		try {
			session = openSession();

			SearchData searchData = (SearchData)session.get(SearchDataImpl.class,
					primaryKey);

			if (searchData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSearchDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(searchData);
		}
		catch (NoSuchSearchDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SearchData removeImpl(SearchData searchData) {
		searchData = toUnwrappedModel(searchData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(searchData)) {
				searchData = (SearchData)session.get(SearchDataImpl.class,
						searchData.getPrimaryKeyObj());
			}

			if (searchData != null) {
				session.delete(searchData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (searchData != null) {
			clearCache(searchData);
		}

		return searchData;
	}

	@Override
	public SearchData updateImpl(SearchData searchData) {
		searchData = toUnwrappedModel(searchData);

		boolean isNew = searchData.isNew();

		SearchDataModelImpl searchDataModelImpl = (SearchDataModelImpl)searchData;

		if (Validator.isNull(searchData.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			searchData.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (searchData.isNew()) {
				session.save(searchData);

				searchData.setNew(false);
			}
			else {
				searchData = (SearchData)session.merge(searchData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SearchDataModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((searchDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchDataModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { searchDataModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
			SearchDataImpl.class, searchData.getPrimaryKey(), searchData, false);

		searchData.resetOriginalValues();

		return searchData;
	}

	protected SearchData toUnwrappedModel(SearchData searchData) {
		if (searchData instanceof SearchDataImpl) {
			return searchData;
		}

		SearchDataImpl searchDataImpl = new SearchDataImpl();

		searchDataImpl.setNew(searchData.isNew());
		searchDataImpl.setPrimaryKey(searchData.getPrimaryKey());

		searchDataImpl.setUuid(searchData.getUuid());
		searchDataImpl.setSearchId(searchData.getSearchId());
		searchDataImpl.setSearchData(searchData.getSearchData());
		searchDataImpl.setCreateDate(searchData.getCreateDate());

		return searchDataImpl;
	}

	/**
	 * Returns the search data with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the search data
	 * @return the search data
	 * @throws NoSuchSearchDataException if a search data with the primary key could not be found
	 */
	@Override
	public SearchData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSearchDataException {
		SearchData searchData = fetchByPrimaryKey(primaryKey);

		if (searchData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSearchDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return searchData;
	}

	/**
	 * Returns the search data with the primary key or throws a {@link NoSuchSearchDataException} if it could not be found.
	 *
	 * @param searchId the primary key of the search data
	 * @return the search data
	 * @throws NoSuchSearchDataException if a search data with the primary key could not be found
	 */
	@Override
	public SearchData findByPrimaryKey(long searchId)
		throws NoSuchSearchDataException {
		return findByPrimaryKey((Serializable)searchId);
	}

	/**
	 * Returns the search data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the search data
	 * @return the search data, or <code>null</code> if a search data with the primary key could not be found
	 */
	@Override
	public SearchData fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
				SearchDataImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SearchData searchData = (SearchData)serializable;

		if (searchData == null) {
			Session session = null;

			try {
				session = openSession();

				searchData = (SearchData)session.get(SearchDataImpl.class,
						primaryKey);

				if (searchData != null) {
					cacheResult(searchData);
				}
				else {
					entityCache.putResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
						SearchDataImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
					SearchDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return searchData;
	}

	/**
	 * Returns the search data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchId the primary key of the search data
	 * @return the search data, or <code>null</code> if a search data with the primary key could not be found
	 */
	@Override
	public SearchData fetchByPrimaryKey(long searchId) {
		return fetchByPrimaryKey((Serializable)searchId);
	}

	@Override
	public Map<Serializable, SearchData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SearchData> map = new HashMap<Serializable, SearchData>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SearchData searchData = fetchByPrimaryKey(primaryKey);

			if (searchData != null) {
				map.put(primaryKey, searchData);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
					SearchDataImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SearchData)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SEARCHDATA_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (SearchData searchData : (List<SearchData>)q.list()) {
				map.put(searchData.getPrimaryKeyObj(), searchData);

				cacheResult(searchData);

				uncachedPrimaryKeys.remove(searchData.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SearchDataModelImpl.ENTITY_CACHE_ENABLED,
					SearchDataImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the search datas.
	 *
	 * @return the search datas
	 */
	@Override
	public List<SearchData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchData> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SearchData> findAll(int start, int end,
		OrderByComparator<SearchData> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SearchData> findAll(int start, int end,
		OrderByComparator<SearchData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SearchData> list = null;

		if (retrieveFromCache) {
			list = (List<SearchData>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEARCHDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEARCHDATA;

				if (pagination) {
					sql = sql.concat(SearchDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SearchData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SearchData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the search datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SearchData searchData : findAll()) {
			remove(searchData);
		}
	}

	/**
	 * Returns the number of search datas.
	 *
	 * @return the number of search datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEARCHDATA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SearchDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the search data persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SearchDataImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SEARCHDATA = "SELECT searchData FROM SearchData searchData";
	private static final String _SQL_SELECT_SEARCHDATA_WHERE_PKS_IN = "SELECT searchData FROM SearchData searchData WHERE searchId IN (";
	private static final String _SQL_SELECT_SEARCHDATA_WHERE = "SELECT searchData FROM SearchData searchData WHERE ";
	private static final String _SQL_COUNT_SEARCHDATA = "SELECT COUNT(searchData) FROM SearchData searchData";
	private static final String _SQL_COUNT_SEARCHDATA_WHERE = "SELECT COUNT(searchData) FROM SearchData searchData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "searchData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SearchData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SearchData exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SearchDataPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}