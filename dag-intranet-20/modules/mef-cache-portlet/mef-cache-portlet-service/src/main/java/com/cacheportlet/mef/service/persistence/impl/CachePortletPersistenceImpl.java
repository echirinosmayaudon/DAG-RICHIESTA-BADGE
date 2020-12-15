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

package com.cacheportlet.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.cacheportlet.mef.exception.NoSuchCachePortletException;
import com.cacheportlet.mef.model.CachePortlet;
import com.cacheportlet.mef.model.impl.CachePortletImpl;
import com.cacheportlet.mef.model.impl.CachePortletModelImpl;
import com.cacheportlet.mef.service.persistence.CachePortletPersistence;

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
 * The persistence implementation for the cache portlet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CachePortletPersistence
 * @see com.cacheportlet.mef.service.persistence.CachePortletUtil
 * @generated
 */
@ProviderType
public class CachePortletPersistenceImpl extends BasePersistenceImpl<CachePortlet>
	implements CachePortletPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CachePortletUtil} to access the cache portlet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CachePortletImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletModelImpl.FINDER_CACHE_ENABLED, CachePortletImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletModelImpl.FINDER_CACHE_ENABLED, CachePortletImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletModelImpl.FINDER_CACHE_ENABLED, CachePortletImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletModelImpl.FINDER_CACHE_ENABLED, CachePortletImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CachePortletModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the cache portlets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cache portlets
	 */
	@Override
	public List<CachePortlet> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CachePortlet> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CachePortlet> findByUuid(String uuid, int start, int end,
		OrderByComparator<CachePortlet> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CachePortlet> findByUuid(String uuid, int start, int end,
		OrderByComparator<CachePortlet> orderByComparator,
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

		List<CachePortlet> list = null;

		if (retrieveFromCache) {
			list = (List<CachePortlet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CachePortlet cachePortlet : list) {
					if (!Objects.equals(uuid, cachePortlet.getUuid())) {
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

			query.append(_SQL_SELECT_CACHEPORTLET_WHERE);

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
				query.append(CachePortletModelImpl.ORDER_BY_JPQL);
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
					list = (List<CachePortlet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CachePortlet>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cache portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache portlet
	 * @throws NoSuchCachePortletException if a matching cache portlet could not be found
	 */
	@Override
	public CachePortlet findByUuid_First(String uuid,
		OrderByComparator<CachePortlet> orderByComparator)
		throws NoSuchCachePortletException {
		CachePortlet cachePortlet = fetchByUuid_First(uuid, orderByComparator);

		if (cachePortlet != null) {
			return cachePortlet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCachePortletException(msg.toString());
	}

	/**
	 * Returns the first cache portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache portlet, or <code>null</code> if a matching cache portlet could not be found
	 */
	@Override
	public CachePortlet fetchByUuid_First(String uuid,
		OrderByComparator<CachePortlet> orderByComparator) {
		List<CachePortlet> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cache portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache portlet
	 * @throws NoSuchCachePortletException if a matching cache portlet could not be found
	 */
	@Override
	public CachePortlet findByUuid_Last(String uuid,
		OrderByComparator<CachePortlet> orderByComparator)
		throws NoSuchCachePortletException {
		CachePortlet cachePortlet = fetchByUuid_Last(uuid, orderByComparator);

		if (cachePortlet != null) {
			return cachePortlet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCachePortletException(msg.toString());
	}

	/**
	 * Returns the last cache portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache portlet, or <code>null</code> if a matching cache portlet could not be found
	 */
	@Override
	public CachePortlet fetchByUuid_Last(String uuid,
		OrderByComparator<CachePortlet> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CachePortlet> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CachePortlet[] findByUuid_PrevAndNext(String portletId, String uuid,
		OrderByComparator<CachePortlet> orderByComparator)
		throws NoSuchCachePortletException {
		CachePortlet cachePortlet = findByPrimaryKey(portletId);

		Session session = null;

		try {
			session = openSession();

			CachePortlet[] array = new CachePortletImpl[3];

			array[0] = getByUuid_PrevAndNext(session, cachePortlet, uuid,
					orderByComparator, true);

			array[1] = cachePortlet;

			array[2] = getByUuid_PrevAndNext(session, cachePortlet, uuid,
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

	protected CachePortlet getByUuid_PrevAndNext(Session session,
		CachePortlet cachePortlet, String uuid,
		OrderByComparator<CachePortlet> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CACHEPORTLET_WHERE);

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
			query.append(CachePortletModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(cachePortlet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CachePortlet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cache portlets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CachePortlet cachePortlet : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cachePortlet);
		}
	}

	/**
	 * Returns the number of cache portlets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cache portlets
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CACHEPORTLET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "cachePortlet.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "cachePortlet.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(cachePortlet.uuid IS NULL OR cachePortlet.uuid = '')";

	public CachePortletPersistenceImpl() {
		setModelClass(CachePortlet.class);
	}

	/**
	 * Caches the cache portlet in the entity cache if it is enabled.
	 *
	 * @param cachePortlet the cache portlet
	 */
	@Override
	public void cacheResult(CachePortlet cachePortlet) {
		entityCache.putResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletImpl.class, cachePortlet.getPrimaryKey(), cachePortlet);

		cachePortlet.resetOriginalValues();
	}

	/**
	 * Caches the cache portlets in the entity cache if it is enabled.
	 *
	 * @param cachePortlets the cache portlets
	 */
	@Override
	public void cacheResult(List<CachePortlet> cachePortlets) {
		for (CachePortlet cachePortlet : cachePortlets) {
			if (entityCache.getResult(
						CachePortletModelImpl.ENTITY_CACHE_ENABLED,
						CachePortletImpl.class, cachePortlet.getPrimaryKey()) == null) {
				cacheResult(cachePortlet);
			}
			else {
				cachePortlet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cache portlets.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CachePortletImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cache portlet.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CachePortlet cachePortlet) {
		entityCache.removeResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletImpl.class, cachePortlet.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CachePortlet> cachePortlets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CachePortlet cachePortlet : cachePortlets) {
			entityCache.removeResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
				CachePortletImpl.class, cachePortlet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cache portlet with the primary key. Does not add the cache portlet to the database.
	 *
	 * @param portletId the primary key for the new cache portlet
	 * @return the new cache portlet
	 */
	@Override
	public CachePortlet create(String portletId) {
		CachePortlet cachePortlet = new CachePortletImpl();

		cachePortlet.setNew(true);
		cachePortlet.setPrimaryKey(portletId);

		String uuid = PortalUUIDUtil.generate();

		cachePortlet.setUuid(uuid);

		return cachePortlet;
	}

	/**
	 * Removes the cache portlet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletId the primary key of the cache portlet
	 * @return the cache portlet that was removed
	 * @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	 */
	@Override
	public CachePortlet remove(String portletId)
		throws NoSuchCachePortletException {
		return remove((Serializable)portletId);
	}

	/**
	 * Removes the cache portlet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cache portlet
	 * @return the cache portlet that was removed
	 * @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	 */
	@Override
	public CachePortlet remove(Serializable primaryKey)
		throws NoSuchCachePortletException {
		Session session = null;

		try {
			session = openSession();

			CachePortlet cachePortlet = (CachePortlet)session.get(CachePortletImpl.class,
					primaryKey);

			if (cachePortlet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCachePortletException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cachePortlet);
		}
		catch (NoSuchCachePortletException nsee) {
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
	protected CachePortlet removeImpl(CachePortlet cachePortlet) {
		cachePortlet = toUnwrappedModel(cachePortlet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cachePortlet)) {
				cachePortlet = (CachePortlet)session.get(CachePortletImpl.class,
						cachePortlet.getPrimaryKeyObj());
			}

			if (cachePortlet != null) {
				session.delete(cachePortlet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cachePortlet != null) {
			clearCache(cachePortlet);
		}

		return cachePortlet;
	}

	@Override
	public CachePortlet updateImpl(CachePortlet cachePortlet) {
		cachePortlet = toUnwrappedModel(cachePortlet);

		boolean isNew = cachePortlet.isNew();

		CachePortletModelImpl cachePortletModelImpl = (CachePortletModelImpl)cachePortlet;

		if (Validator.isNull(cachePortlet.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cachePortlet.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (cachePortlet.isNew()) {
				session.save(cachePortlet);

				cachePortlet.setNew(false);
			}
			else {
				cachePortlet = (CachePortlet)session.merge(cachePortlet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CachePortletModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cachePortletModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cachePortletModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { cachePortletModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
			CachePortletImpl.class, cachePortlet.getPrimaryKey(), cachePortlet,
			false);

		cachePortlet.resetOriginalValues();

		return cachePortlet;
	}

	protected CachePortlet toUnwrappedModel(CachePortlet cachePortlet) {
		if (cachePortlet instanceof CachePortletImpl) {
			return cachePortlet;
		}

		CachePortletImpl cachePortletImpl = new CachePortletImpl();

		cachePortletImpl.setNew(cachePortlet.isNew());
		cachePortletImpl.setPrimaryKey(cachePortlet.getPrimaryKey());

		cachePortletImpl.setUuid(cachePortlet.getUuid());
		cachePortletImpl.setPortletId(cachePortlet.getPortletId());
		cachePortletImpl.setJsonData(cachePortlet.getJsonData());
		cachePortletImpl.setTimestamp(cachePortlet.getTimestamp());

		return cachePortletImpl;
	}

	/**
	 * Returns the cache portlet with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cache portlet
	 * @return the cache portlet
	 * @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	 */
	@Override
	public CachePortlet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCachePortletException {
		CachePortlet cachePortlet = fetchByPrimaryKey(primaryKey);

		if (cachePortlet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCachePortletException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cachePortlet;
	}

	/**
	 * Returns the cache portlet with the primary key or throws a {@link NoSuchCachePortletException} if it could not be found.
	 *
	 * @param portletId the primary key of the cache portlet
	 * @return the cache portlet
	 * @throws NoSuchCachePortletException if a cache portlet with the primary key could not be found
	 */
	@Override
	public CachePortlet findByPrimaryKey(String portletId)
		throws NoSuchCachePortletException {
		return findByPrimaryKey((Serializable)portletId);
	}

	/**
	 * Returns the cache portlet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cache portlet
	 * @return the cache portlet, or <code>null</code> if a cache portlet with the primary key could not be found
	 */
	@Override
	public CachePortlet fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
				CachePortletImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CachePortlet cachePortlet = (CachePortlet)serializable;

		if (cachePortlet == null) {
			Session session = null;

			try {
				session = openSession();

				cachePortlet = (CachePortlet)session.get(CachePortletImpl.class,
						primaryKey);

				if (cachePortlet != null) {
					cacheResult(cachePortlet);
				}
				else {
					entityCache.putResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
						CachePortletImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
					CachePortletImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cachePortlet;
	}

	/**
	 * Returns the cache portlet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portletId the primary key of the cache portlet
	 * @return the cache portlet, or <code>null</code> if a cache portlet with the primary key could not be found
	 */
	@Override
	public CachePortlet fetchByPrimaryKey(String portletId) {
		return fetchByPrimaryKey((Serializable)portletId);
	}

	@Override
	public Map<Serializable, CachePortlet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CachePortlet> map = new HashMap<Serializable, CachePortlet>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CachePortlet cachePortlet = fetchByPrimaryKey(primaryKey);

			if (cachePortlet != null) {
				map.put(primaryKey, cachePortlet);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
					CachePortletImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CachePortlet)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_CACHEPORTLET_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CachePortlet cachePortlet : (List<CachePortlet>)q.list()) {
				map.put(cachePortlet.getPrimaryKeyObj(), cachePortlet);

				cacheResult(cachePortlet);

				uncachedPrimaryKeys.remove(cachePortlet.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CachePortletModelImpl.ENTITY_CACHE_ENABLED,
					CachePortletImpl.class, primaryKey, nullModel);
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
	 * Returns all the cache portlets.
	 *
	 * @return the cache portlets
	 */
	@Override
	public List<CachePortlet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CachePortlet> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CachePortlet> findAll(int start, int end,
		OrderByComparator<CachePortlet> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CachePortlet> findAll(int start, int end,
		OrderByComparator<CachePortlet> orderByComparator,
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

		List<CachePortlet> list = null;

		if (retrieveFromCache) {
			list = (List<CachePortlet>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CACHEPORTLET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CACHEPORTLET;

				if (pagination) {
					sql = sql.concat(CachePortletModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CachePortlet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CachePortlet>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cache portlets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CachePortlet cachePortlet : findAll()) {
			remove(cachePortlet);
		}
	}

	/**
	 * Returns the number of cache portlets.
	 *
	 * @return the number of cache portlets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CACHEPORTLET);

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
		return CachePortletModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cache portlet persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CachePortletImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CACHEPORTLET = "SELECT cachePortlet FROM CachePortlet cachePortlet";
	private static final String _SQL_SELECT_CACHEPORTLET_WHERE_PKS_IN = "SELECT cachePortlet FROM CachePortlet cachePortlet WHERE portletId IN (";
	private static final String _SQL_SELECT_CACHEPORTLET_WHERE = "SELECT cachePortlet FROM CachePortlet cachePortlet WHERE ";
	private static final String _SQL_COUNT_CACHEPORTLET = "SELECT COUNT(cachePortlet) FROM CachePortlet cachePortlet";
	private static final String _SQL_COUNT_CACHEPORTLET_WHERE = "SELECT COUNT(cachePortlet) FROM CachePortlet cachePortlet WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cachePortlet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CachePortlet exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CachePortlet exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CachePortletPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}