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

package com.intranet.mef.daily.punching.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.daily.punching.exception.NoSuchDailyPunchingException;
import com.intranet.mef.daily.punching.model.DailyPunching;
import com.intranet.mef.daily.punching.model.impl.DailyPunchingImpl;
import com.intranet.mef.daily.punching.model.impl.DailyPunchingModelImpl;
import com.intranet.mef.daily.punching.service.persistence.DailyPunchingPersistence;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the daily punching service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DailyPunchingPersistence
 * @see com.intranet.mef.daily.punching.service.persistence.DailyPunchingUtil
 * @generated
 */
@ProviderType
public class DailyPunchingPersistenceImpl extends BasePersistenceImpl<DailyPunching>
	implements DailyPunchingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DailyPunchingUtil} to access the daily punching persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DailyPunchingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingModelImpl.FINDER_CACHE_ENABLED,
			DailyPunchingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingModelImpl.FINDER_CACHE_ENABLED,
			DailyPunchingImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID = new FinderPath(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingModelImpl.FINDER_CACHE_ENABLED,
			DailyPunchingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersonId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID =
		new FinderPath(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingModelImpl.FINDER_CACHE_ENABLED,
			DailyPunchingImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersonId", new String[] { Long.class.getName() },
			DailyPunchingModelImpl.PERSONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSONID = new FinderPath(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the daily punchings where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @return the matching daily punchings
	 */
	@Override
	public List<DailyPunching> findByPersonId(long personId) {
		return findByPersonId(personId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the daily punchings where personId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param start the lower bound of the range of daily punchings
	 * @param end the upper bound of the range of daily punchings (not inclusive)
	 * @return the range of matching daily punchings
	 */
	@Override
	public List<DailyPunching> findByPersonId(long personId, int start, int end) {
		return findByPersonId(personId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the daily punchings where personId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param start the lower bound of the range of daily punchings
	 * @param end the upper bound of the range of daily punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching daily punchings
	 */
	@Override
	public List<DailyPunching> findByPersonId(long personId, int start,
		int end, OrderByComparator<DailyPunching> orderByComparator) {
		return findByPersonId(personId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the daily punchings where personId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param start the lower bound of the range of daily punchings
	 * @param end the upper bound of the range of daily punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching daily punchings
	 */
	@Override
	public List<DailyPunching> findByPersonId(long personId, int start,
		int end, OrderByComparator<DailyPunching> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personId, start, end, orderByComparator };
		}

		List<DailyPunching> list = null;

		if (retrieveFromCache) {
			list = (List<DailyPunching>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DailyPunching dailyPunching : list) {
					if ((personId != dailyPunching.getPersonId())) {
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

			query.append(_SQL_SELECT_DAILYPUNCHING_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DailyPunchingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personId);

				if (!pagination) {
					list = (List<DailyPunching>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DailyPunching>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first daily punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching daily punching
	 * @throws NoSuchDailyPunchingException if a matching daily punching could not be found
	 */
	@Override
	public DailyPunching findByPersonId_First(long personId,
		OrderByComparator<DailyPunching> orderByComparator)
		throws NoSuchDailyPunchingException {
		DailyPunching dailyPunching = fetchByPersonId_First(personId,
				orderByComparator);

		if (dailyPunching != null) {
			return dailyPunching;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personId=");
		msg.append(personId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDailyPunchingException(msg.toString());
	}

	/**
	 * Returns the first daily punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching daily punching, or <code>null</code> if a matching daily punching could not be found
	 */
	@Override
	public DailyPunching fetchByPersonId_First(long personId,
		OrderByComparator<DailyPunching> orderByComparator) {
		List<DailyPunching> list = findByPersonId(personId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last daily punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching daily punching
	 * @throws NoSuchDailyPunchingException if a matching daily punching could not be found
	 */
	@Override
	public DailyPunching findByPersonId_Last(long personId,
		OrderByComparator<DailyPunching> orderByComparator)
		throws NoSuchDailyPunchingException {
		DailyPunching dailyPunching = fetchByPersonId_Last(personId,
				orderByComparator);

		if (dailyPunching != null) {
			return dailyPunching;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personId=");
		msg.append(personId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDailyPunchingException(msg.toString());
	}

	/**
	 * Returns the last daily punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching daily punching, or <code>null</code> if a matching daily punching could not be found
	 */
	@Override
	public DailyPunching fetchByPersonId_Last(long personId,
		OrderByComparator<DailyPunching> orderByComparator) {
		int count = countByPersonId(personId);

		if (count == 0) {
			return null;
		}

		List<DailyPunching> list = findByPersonId(personId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the daily punchings before and after the current daily punching in the ordered set where personId = &#63;.
	 *
	 * @param custom_key the primary key of the current daily punching
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next daily punching
	 * @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	 */
	@Override
	public DailyPunching[] findByPersonId_PrevAndNext(String custom_key,
		long personId, OrderByComparator<DailyPunching> orderByComparator)
		throws NoSuchDailyPunchingException {
		DailyPunching dailyPunching = findByPrimaryKey(custom_key);

		Session session = null;

		try {
			session = openSession();

			DailyPunching[] array = new DailyPunchingImpl[3];

			array[0] = getByPersonId_PrevAndNext(session, dailyPunching,
					personId, orderByComparator, true);

			array[1] = dailyPunching;

			array[2] = getByPersonId_PrevAndNext(session, dailyPunching,
					personId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DailyPunching getByPersonId_PrevAndNext(Session session,
		DailyPunching dailyPunching, long personId,
		OrderByComparator<DailyPunching> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAILYPUNCHING_WHERE);

		query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

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
			query.append(DailyPunchingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(personId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dailyPunching);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DailyPunching> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the daily punchings where personId = &#63; from the database.
	 *
	 * @param personId the person ID
	 */
	@Override
	public void removeByPersonId(long personId) {
		for (DailyPunching dailyPunching : findByPersonId(personId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dailyPunching);
		}
	}

	/**
	 * Returns the number of daily punchings where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @return the number of matching daily punchings
	 */
	@Override
	public int countByPersonId(long personId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSONID;

		Object[] finderArgs = new Object[] { personId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAILYPUNCHING_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personId);

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

	private static final String _FINDER_COLUMN_PERSONID_PERSONID_2 = "dailyPunching.personId = ?";

	public DailyPunchingPersistenceImpl() {
		setModelClass(DailyPunching.class);
	}

	/**
	 * Caches the daily punching in the entity cache if it is enabled.
	 *
	 * @param dailyPunching the daily punching
	 */
	@Override
	public void cacheResult(DailyPunching dailyPunching) {
		entityCache.putResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingImpl.class, dailyPunching.getPrimaryKey(),
			dailyPunching);

		dailyPunching.resetOriginalValues();
	}

	/**
	 * Caches the daily punchings in the entity cache if it is enabled.
	 *
	 * @param dailyPunchings the daily punchings
	 */
	@Override
	public void cacheResult(List<DailyPunching> dailyPunchings) {
		for (DailyPunching dailyPunching : dailyPunchings) {
			if (entityCache.getResult(
						DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
						DailyPunchingImpl.class, dailyPunching.getPrimaryKey()) == null) {
				cacheResult(dailyPunching);
			}
			else {
				dailyPunching.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all daily punchings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DailyPunchingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the daily punching.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DailyPunching dailyPunching) {
		entityCache.removeResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingImpl.class, dailyPunching.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DailyPunching> dailyPunchings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DailyPunching dailyPunching : dailyPunchings) {
			entityCache.removeResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
				DailyPunchingImpl.class, dailyPunching.getPrimaryKey());
		}
	}

	/**
	 * Creates a new daily punching with the primary key. Does not add the daily punching to the database.
	 *
	 * @param custom_key the primary key for the new daily punching
	 * @return the new daily punching
	 */
	@Override
	public DailyPunching create(String custom_key) {
		DailyPunching dailyPunching = new DailyPunchingImpl();

		dailyPunching.setNew(true);
		dailyPunching.setPrimaryKey(custom_key);

		return dailyPunching;
	}

	/**
	 * Removes the daily punching with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param custom_key the primary key of the daily punching
	 * @return the daily punching that was removed
	 * @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	 */
	@Override
	public DailyPunching remove(String custom_key)
		throws NoSuchDailyPunchingException {
		return remove((Serializable)custom_key);
	}

	/**
	 * Removes the daily punching with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the daily punching
	 * @return the daily punching that was removed
	 * @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	 */
	@Override
	public DailyPunching remove(Serializable primaryKey)
		throws NoSuchDailyPunchingException {
		Session session = null;

		try {
			session = openSession();

			DailyPunching dailyPunching = (DailyPunching)session.get(DailyPunchingImpl.class,
					primaryKey);

			if (dailyPunching == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDailyPunchingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dailyPunching);
		}
		catch (NoSuchDailyPunchingException nsee) {
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
	protected DailyPunching removeImpl(DailyPunching dailyPunching) {
		dailyPunching = toUnwrappedModel(dailyPunching);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dailyPunching)) {
				dailyPunching = (DailyPunching)session.get(DailyPunchingImpl.class,
						dailyPunching.getPrimaryKeyObj());
			}

			if (dailyPunching != null) {
				session.delete(dailyPunching);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dailyPunching != null) {
			clearCache(dailyPunching);
		}

		return dailyPunching;
	}

	@Override
	public DailyPunching updateImpl(DailyPunching dailyPunching) {
		dailyPunching = toUnwrappedModel(dailyPunching);

		boolean isNew = dailyPunching.isNew();

		DailyPunchingModelImpl dailyPunchingModelImpl = (DailyPunchingModelImpl)dailyPunching;

		Session session = null;

		try {
			session = openSession();

			if (dailyPunching.isNew()) {
				session.save(dailyPunching);

				dailyPunching.setNew(false);
			}
			else {
				dailyPunching = (DailyPunching)session.merge(dailyPunching);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DailyPunchingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dailyPunchingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dailyPunchingModelImpl.getOriginalPersonId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);

				args = new Object[] { dailyPunchingModelImpl.getPersonId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);
			}
		}

		entityCache.putResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
			DailyPunchingImpl.class, dailyPunching.getPrimaryKey(),
			dailyPunching, false);

		dailyPunching.resetOriginalValues();

		return dailyPunching;
	}

	protected DailyPunching toUnwrappedModel(DailyPunching dailyPunching) {
		if (dailyPunching instanceof DailyPunchingImpl) {
			return dailyPunching;
		}

		DailyPunchingImpl dailyPunchingImpl = new DailyPunchingImpl();

		dailyPunchingImpl.setNew(dailyPunching.isNew());
		dailyPunchingImpl.setPrimaryKey(dailyPunching.getPrimaryKey());

		dailyPunchingImpl.setCustom_key(dailyPunching.getCustom_key());
		dailyPunchingImpl.setPersonId(dailyPunching.getPersonId());
		dailyPunchingImpl.setPunchingId(dailyPunching.getPunchingId());
		dailyPunchingImpl.setDirection(dailyPunching.getDirection());
		dailyPunchingImpl.setVoucher(dailyPunching.getVoucher());
		dailyPunchingImpl.setTerminal(dailyPunching.getTerminal());
		dailyPunchingImpl.setHours(dailyPunching.getHours());
		dailyPunchingImpl.setMinute(dailyPunching.getMinute());

		return dailyPunchingImpl;
	}

	/**
	 * Returns the daily punching with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the daily punching
	 * @return the daily punching
	 * @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	 */
	@Override
	public DailyPunching findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDailyPunchingException {
		DailyPunching dailyPunching = fetchByPrimaryKey(primaryKey);

		if (dailyPunching == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDailyPunchingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dailyPunching;
	}

	/**
	 * Returns the daily punching with the primary key or throws a {@link NoSuchDailyPunchingException} if it could not be found.
	 *
	 * @param custom_key the primary key of the daily punching
	 * @return the daily punching
	 * @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	 */
	@Override
	public DailyPunching findByPrimaryKey(String custom_key)
		throws NoSuchDailyPunchingException {
		return findByPrimaryKey((Serializable)custom_key);
	}

	/**
	 * Returns the daily punching with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the daily punching
	 * @return the daily punching, or <code>null</code> if a daily punching with the primary key could not be found
	 */
	@Override
	public DailyPunching fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
				DailyPunchingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DailyPunching dailyPunching = (DailyPunching)serializable;

		if (dailyPunching == null) {
			Session session = null;

			try {
				session = openSession();

				dailyPunching = (DailyPunching)session.get(DailyPunchingImpl.class,
						primaryKey);

				if (dailyPunching != null) {
					cacheResult(dailyPunching);
				}
				else {
					entityCache.putResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
						DailyPunchingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
					DailyPunchingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dailyPunching;
	}

	/**
	 * Returns the daily punching with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param custom_key the primary key of the daily punching
	 * @return the daily punching, or <code>null</code> if a daily punching with the primary key could not be found
	 */
	@Override
	public DailyPunching fetchByPrimaryKey(String custom_key) {
		return fetchByPrimaryKey((Serializable)custom_key);
	}

	@Override
	public Map<Serializable, DailyPunching> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DailyPunching> map = new HashMap<Serializable, DailyPunching>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DailyPunching dailyPunching = fetchByPrimaryKey(primaryKey);

			if (dailyPunching != null) {
				map.put(primaryKey, dailyPunching);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
					DailyPunchingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DailyPunching)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_DAILYPUNCHING_WHERE_PKS_IN);

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

			for (DailyPunching dailyPunching : (List<DailyPunching>)q.list()) {
				map.put(dailyPunching.getPrimaryKeyObj(), dailyPunching);

				cacheResult(dailyPunching);

				uncachedPrimaryKeys.remove(dailyPunching.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DailyPunchingModelImpl.ENTITY_CACHE_ENABLED,
					DailyPunchingImpl.class, primaryKey, nullModel);
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
	 * Returns all the daily punchings.
	 *
	 * @return the daily punchings
	 */
	@Override
	public List<DailyPunching> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the daily punchings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of daily punchings
	 * @param end the upper bound of the range of daily punchings (not inclusive)
	 * @return the range of daily punchings
	 */
	@Override
	public List<DailyPunching> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the daily punchings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of daily punchings
	 * @param end the upper bound of the range of daily punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of daily punchings
	 */
	@Override
	public List<DailyPunching> findAll(int start, int end,
		OrderByComparator<DailyPunching> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the daily punchings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of daily punchings
	 * @param end the upper bound of the range of daily punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of daily punchings
	 */
	@Override
	public List<DailyPunching> findAll(int start, int end,
		OrderByComparator<DailyPunching> orderByComparator,
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

		List<DailyPunching> list = null;

		if (retrieveFromCache) {
			list = (List<DailyPunching>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DAILYPUNCHING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DAILYPUNCHING;

				if (pagination) {
					sql = sql.concat(DailyPunchingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DailyPunching>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DailyPunching>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the daily punchings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DailyPunching dailyPunching : findAll()) {
			remove(dailyPunching);
		}
	}

	/**
	 * Returns the number of daily punchings.
	 *
	 * @return the number of daily punchings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DAILYPUNCHING);

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
		return DailyPunchingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the daily punching persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DailyPunchingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DAILYPUNCHING = "SELECT dailyPunching FROM DailyPunching dailyPunching";
	private static final String _SQL_SELECT_DAILYPUNCHING_WHERE_PKS_IN = "SELECT dailyPunching FROM DailyPunching dailyPunching WHERE CUSTOM_KEY IN (";
	private static final String _SQL_SELECT_DAILYPUNCHING_WHERE = "SELECT dailyPunching FROM DailyPunching dailyPunching WHERE ";
	private static final String _SQL_COUNT_DAILYPUNCHING = "SELECT COUNT(dailyPunching) FROM DailyPunching dailyPunching";
	private static final String _SQL_COUNT_DAILYPUNCHING_WHERE = "SELECT COUNT(dailyPunching) FROM DailyPunching dailyPunching WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dailyPunching.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DailyPunching exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DailyPunching exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DailyPunchingPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"custom_key", "personId", "punchingId", "direction", "voucher",
				"terminal", "hours", "minute"
			});
}