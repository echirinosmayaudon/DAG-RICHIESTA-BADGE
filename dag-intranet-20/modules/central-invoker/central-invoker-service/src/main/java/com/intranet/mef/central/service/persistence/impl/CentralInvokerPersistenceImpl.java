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

package com.intranet.mef.central.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.central.exception.NoSuchCentralInvokerException;
import com.intranet.mef.central.model.CentralInvoker;
import com.intranet.mef.central.model.impl.CentralInvokerImpl;
import com.intranet.mef.central.model.impl.CentralInvokerModelImpl;
import com.intranet.mef.central.service.persistence.CentralInvokerPersistence;

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
 * The persistence implementation for the central invoker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvokerPersistence
 * @see com.intranet.mef.central.service.persistence.CentralInvokerUtil
 * @generated
 */
@ProviderType
public class CentralInvokerPersistenceImpl extends BasePersistenceImpl<CentralInvoker>
	implements CentralInvokerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CentralInvokerUtil} to access the central invoker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CentralInvokerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerModelImpl.FINDER_CACHE_ENABLED,
			CentralInvokerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerModelImpl.FINDER_CACHE_ENABLED,
			CentralInvokerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerModelImpl.FINDER_CACHE_ENABLED,
			CentralInvokerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerModelImpl.FINDER_CACHE_ENABLED,
			CentralInvokerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CentralInvokerModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the central invokers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching central invokers
	 */
	@Override
	public List<CentralInvoker> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the central invokers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of central invokers
	 * @param end the upper bound of the range of central invokers (not inclusive)
	 * @return the range of matching central invokers
	 */
	@Override
	public List<CentralInvoker> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the central invokers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of central invokers
	 * @param end the upper bound of the range of central invokers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching central invokers
	 */
	@Override
	public List<CentralInvoker> findByUuid(String uuid, int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the central invokers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of central invokers
	 * @param end the upper bound of the range of central invokers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching central invokers
	 */
	@Override
	public List<CentralInvoker> findByUuid(String uuid, int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator,
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

		List<CentralInvoker> list = null;

		if (retrieveFromCache) {
			list = (List<CentralInvoker>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CentralInvoker centralInvoker : list) {
					if (!Objects.equals(uuid, centralInvoker.getUuid())) {
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

			query.append(_SQL_SELECT_CENTRALINVOKER_WHERE);

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
				query.append(CentralInvokerModelImpl.ORDER_BY_JPQL);
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
					list = (List<CentralInvoker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CentralInvoker>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first central invoker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching central invoker
	 * @throws NoSuchCentralInvokerException if a matching central invoker could not be found
	 */
	@Override
	public CentralInvoker findByUuid_First(String uuid,
		OrderByComparator<CentralInvoker> orderByComparator)
		throws NoSuchCentralInvokerException {
		CentralInvoker centralInvoker = fetchByUuid_First(uuid,
				orderByComparator);

		if (centralInvoker != null) {
			return centralInvoker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCentralInvokerException(msg.toString());
	}

	/**
	 * Returns the first central invoker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching central invoker, or <code>null</code> if a matching central invoker could not be found
	 */
	@Override
	public CentralInvoker fetchByUuid_First(String uuid,
		OrderByComparator<CentralInvoker> orderByComparator) {
		List<CentralInvoker> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last central invoker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching central invoker
	 * @throws NoSuchCentralInvokerException if a matching central invoker could not be found
	 */
	@Override
	public CentralInvoker findByUuid_Last(String uuid,
		OrderByComparator<CentralInvoker> orderByComparator)
		throws NoSuchCentralInvokerException {
		CentralInvoker centralInvoker = fetchByUuid_Last(uuid, orderByComparator);

		if (centralInvoker != null) {
			return centralInvoker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCentralInvokerException(msg.toString());
	}

	/**
	 * Returns the last central invoker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching central invoker, or <code>null</code> if a matching central invoker could not be found
	 */
	@Override
	public CentralInvoker fetchByUuid_Last(String uuid,
		OrderByComparator<CentralInvoker> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CentralInvoker> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the central invokers before and after the current central invoker in the ordered set where uuid = &#63;.
	 *
	 * @param idRecord the primary key of the current central invoker
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next central invoker
	 * @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	 */
	@Override
	public CentralInvoker[] findByUuid_PrevAndNext(long idRecord, String uuid,
		OrderByComparator<CentralInvoker> orderByComparator)
		throws NoSuchCentralInvokerException {
		CentralInvoker centralInvoker = findByPrimaryKey(idRecord);

		Session session = null;

		try {
			session = openSession();

			CentralInvoker[] array = new CentralInvokerImpl[3];

			array[0] = getByUuid_PrevAndNext(session, centralInvoker, uuid,
					orderByComparator, true);

			array[1] = centralInvoker;

			array[2] = getByUuid_PrevAndNext(session, centralInvoker, uuid,
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

	protected CentralInvoker getByUuid_PrevAndNext(Session session,
		CentralInvoker centralInvoker, String uuid,
		OrderByComparator<CentralInvoker> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CENTRALINVOKER_WHERE);

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
			query.append(CentralInvokerModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(centralInvoker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CentralInvoker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the central invokers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CentralInvoker centralInvoker : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(centralInvoker);
		}
	}

	/**
	 * Returns the number of central invokers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching central invokers
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CENTRALINVOKER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "centralInvoker.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "centralInvoker.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(centralInvoker.uuid IS NULL OR centralInvoker.uuid = '')";

	public CentralInvokerPersistenceImpl() {
		setModelClass(CentralInvoker.class);
	}

	/**
	 * Caches the central invoker in the entity cache if it is enabled.
	 *
	 * @param centralInvoker the central invoker
	 */
	@Override
	public void cacheResult(CentralInvoker centralInvoker) {
		entityCache.putResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerImpl.class, centralInvoker.getPrimaryKey(),
			centralInvoker);

		centralInvoker.resetOriginalValues();
	}

	/**
	 * Caches the central invokers in the entity cache if it is enabled.
	 *
	 * @param centralInvokers the central invokers
	 */
	@Override
	public void cacheResult(List<CentralInvoker> centralInvokers) {
		for (CentralInvoker centralInvoker : centralInvokers) {
			if (entityCache.getResult(
						CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
						CentralInvokerImpl.class, centralInvoker.getPrimaryKey()) == null) {
				cacheResult(centralInvoker);
			}
			else {
				centralInvoker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all central invokers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CentralInvokerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the central invoker.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CentralInvoker centralInvoker) {
		entityCache.removeResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerImpl.class, centralInvoker.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CentralInvoker> centralInvokers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CentralInvoker centralInvoker : centralInvokers) {
			entityCache.removeResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
				CentralInvokerImpl.class, centralInvoker.getPrimaryKey());
		}
	}

	/**
	 * Creates a new central invoker with the primary key. Does not add the central invoker to the database.
	 *
	 * @param idRecord the primary key for the new central invoker
	 * @return the new central invoker
	 */
	@Override
	public CentralInvoker create(long idRecord) {
		CentralInvoker centralInvoker = new CentralInvokerImpl();

		centralInvoker.setNew(true);
		centralInvoker.setPrimaryKey(idRecord);

		String uuid = PortalUUIDUtil.generate();

		centralInvoker.setUuid(uuid);

		return centralInvoker;
	}

	/**
	 * Removes the central invoker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idRecord the primary key of the central invoker
	 * @return the central invoker that was removed
	 * @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	 */
	@Override
	public CentralInvoker remove(long idRecord)
		throws NoSuchCentralInvokerException {
		return remove((Serializable)idRecord);
	}

	/**
	 * Removes the central invoker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the central invoker
	 * @return the central invoker that was removed
	 * @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	 */
	@Override
	public CentralInvoker remove(Serializable primaryKey)
		throws NoSuchCentralInvokerException {
		Session session = null;

		try {
			session = openSession();

			CentralInvoker centralInvoker = (CentralInvoker)session.get(CentralInvokerImpl.class,
					primaryKey);

			if (centralInvoker == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCentralInvokerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(centralInvoker);
		}
		catch (NoSuchCentralInvokerException nsee) {
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
	protected CentralInvoker removeImpl(CentralInvoker centralInvoker) {
		centralInvoker = toUnwrappedModel(centralInvoker);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(centralInvoker)) {
				centralInvoker = (CentralInvoker)session.get(CentralInvokerImpl.class,
						centralInvoker.getPrimaryKeyObj());
			}

			if (centralInvoker != null) {
				session.delete(centralInvoker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (centralInvoker != null) {
			clearCache(centralInvoker);
		}

		return centralInvoker;
	}

	@Override
	public CentralInvoker updateImpl(CentralInvoker centralInvoker) {
		centralInvoker = toUnwrappedModel(centralInvoker);

		boolean isNew = centralInvoker.isNew();

		CentralInvokerModelImpl centralInvokerModelImpl = (CentralInvokerModelImpl)centralInvoker;

		if (Validator.isNull(centralInvoker.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			centralInvoker.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (centralInvoker.isNew()) {
				session.save(centralInvoker);

				centralInvoker.setNew(false);
			}
			else {
				centralInvoker = (CentralInvoker)session.merge(centralInvoker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CentralInvokerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((centralInvokerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						centralInvokerModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { centralInvokerModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
			CentralInvokerImpl.class, centralInvoker.getPrimaryKey(),
			centralInvoker, false);

		centralInvoker.resetOriginalValues();

		return centralInvoker;
	}

	protected CentralInvoker toUnwrappedModel(CentralInvoker centralInvoker) {
		if (centralInvoker instanceof CentralInvokerImpl) {
			return centralInvoker;
		}

		CentralInvokerImpl centralInvokerImpl = new CentralInvokerImpl();

		centralInvokerImpl.setNew(centralInvoker.isNew());
		centralInvokerImpl.setPrimaryKey(centralInvoker.getPrimaryKey());

		centralInvokerImpl.setUuid(centralInvoker.getUuid());
		centralInvokerImpl.setIdRecord(centralInvoker.getIdRecord());
		centralInvokerImpl.setSecretaryId(centralInvoker.getSecretaryId());

		return centralInvokerImpl;
	}

	/**
	 * Returns the central invoker with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the central invoker
	 * @return the central invoker
	 * @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	 */
	@Override
	public CentralInvoker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCentralInvokerException {
		CentralInvoker centralInvoker = fetchByPrimaryKey(primaryKey);

		if (centralInvoker == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCentralInvokerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return centralInvoker;
	}

	/**
	 * Returns the central invoker with the primary key or throws a {@link NoSuchCentralInvokerException} if it could not be found.
	 *
	 * @param idRecord the primary key of the central invoker
	 * @return the central invoker
	 * @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	 */
	@Override
	public CentralInvoker findByPrimaryKey(long idRecord)
		throws NoSuchCentralInvokerException {
		return findByPrimaryKey((Serializable)idRecord);
	}

	/**
	 * Returns the central invoker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the central invoker
	 * @return the central invoker, or <code>null</code> if a central invoker with the primary key could not be found
	 */
	@Override
	public CentralInvoker fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
				CentralInvokerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CentralInvoker centralInvoker = (CentralInvoker)serializable;

		if (centralInvoker == null) {
			Session session = null;

			try {
				session = openSession();

				centralInvoker = (CentralInvoker)session.get(CentralInvokerImpl.class,
						primaryKey);

				if (centralInvoker != null) {
					cacheResult(centralInvoker);
				}
				else {
					entityCache.putResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
						CentralInvokerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
					CentralInvokerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return centralInvoker;
	}

	/**
	 * Returns the central invoker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idRecord the primary key of the central invoker
	 * @return the central invoker, or <code>null</code> if a central invoker with the primary key could not be found
	 */
	@Override
	public CentralInvoker fetchByPrimaryKey(long idRecord) {
		return fetchByPrimaryKey((Serializable)idRecord);
	}

	@Override
	public Map<Serializable, CentralInvoker> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CentralInvoker> map = new HashMap<Serializable, CentralInvoker>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CentralInvoker centralInvoker = fetchByPrimaryKey(primaryKey);

			if (centralInvoker != null) {
				map.put(primaryKey, centralInvoker);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
					CentralInvokerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CentralInvoker)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CENTRALINVOKER_WHERE_PKS_IN);

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

			for (CentralInvoker centralInvoker : (List<CentralInvoker>)q.list()) {
				map.put(centralInvoker.getPrimaryKeyObj(), centralInvoker);

				cacheResult(centralInvoker);

				uncachedPrimaryKeys.remove(centralInvoker.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CentralInvokerModelImpl.ENTITY_CACHE_ENABLED,
					CentralInvokerImpl.class, primaryKey, nullModel);
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
	 * Returns all the central invokers.
	 *
	 * @return the central invokers
	 */
	@Override
	public List<CentralInvoker> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the central invokers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of central invokers
	 * @param end the upper bound of the range of central invokers (not inclusive)
	 * @return the range of central invokers
	 */
	@Override
	public List<CentralInvoker> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the central invokers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of central invokers
	 * @param end the upper bound of the range of central invokers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of central invokers
	 */
	@Override
	public List<CentralInvoker> findAll(int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the central invokers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of central invokers
	 * @param end the upper bound of the range of central invokers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of central invokers
	 */
	@Override
	public List<CentralInvoker> findAll(int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator,
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

		List<CentralInvoker> list = null;

		if (retrieveFromCache) {
			list = (List<CentralInvoker>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CENTRALINVOKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CENTRALINVOKER;

				if (pagination) {
					sql = sql.concat(CentralInvokerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CentralInvoker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CentralInvoker>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the central invokers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CentralInvoker centralInvoker : findAll()) {
			remove(centralInvoker);
		}
	}

	/**
	 * Returns the number of central invokers.
	 *
	 * @return the number of central invokers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CENTRALINVOKER);

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
		return CentralInvokerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the central invoker persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CentralInvokerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CENTRALINVOKER = "SELECT centralInvoker FROM CentralInvoker centralInvoker";
	private static final String _SQL_SELECT_CENTRALINVOKER_WHERE_PKS_IN = "SELECT centralInvoker FROM CentralInvoker centralInvoker WHERE idRecord IN (";
	private static final String _SQL_SELECT_CENTRALINVOKER_WHERE = "SELECT centralInvoker FROM CentralInvoker centralInvoker WHERE ";
	private static final String _SQL_COUNT_CENTRALINVOKER = "SELECT COUNT(centralInvoker) FROM CentralInvoker centralInvoker";
	private static final String _SQL_COUNT_CENTRALINVOKER_WHERE = "SELECT COUNT(centralInvoker) FROM CentralInvoker centralInvoker WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "centralInvoker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CentralInvoker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CentralInvoker exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CentralInvokerPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}