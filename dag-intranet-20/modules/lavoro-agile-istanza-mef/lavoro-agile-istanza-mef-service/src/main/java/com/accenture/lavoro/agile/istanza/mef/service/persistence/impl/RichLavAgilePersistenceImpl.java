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

package com.accenture.lavoro.agile.istanza.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.exception.NoSuchRichLavAgileException;
import com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile;
import com.accenture.lavoro.agile.istanza.mef.model.impl.RichLavAgileImpl;
import com.accenture.lavoro.agile.istanza.mef.model.impl.RichLavAgileModelImpl;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.RichLavAgilePersistence;

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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the rich lav agile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichLavAgilePersistence
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.RichLavAgileUtil
 * @generated
 */
@ProviderType
public class RichLavAgilePersistenceImpl extends BasePersistenceImpl<RichLavAgile>
	implements RichLavAgilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichLavAgileUtil} to access the rich lav agile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichLavAgileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileModelImpl.FINDER_CACHE_ENABLED, RichLavAgileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileModelImpl.FINDER_CACHE_ENABLED, RichLavAgileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCREENAME =
		new FinderPath(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileModelImpl.FINDER_CACHE_ENABLED, RichLavAgileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByscreename",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME =
		new FinderPath(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileModelImpl.FINDER_CACHE_ENABLED, RichLavAgileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByscreename",
			new String[] { String.class.getName() },
			RichLavAgileModelImpl.SCREENAME_COLUMN_BITMASK |
			RichLavAgileModelImpl.DATA_RICHIESTA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCREENAME = new FinderPath(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByscreename",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rich lav agiles where screename = &#63;.
	 *
	 * @param screename the screename
	 * @return the matching rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findByscreename(String screename) {
		return findByscreename(screename, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rich lav agiles where screename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename the screename
	 * @param start the lower bound of the range of rich lav agiles
	 * @param end the upper bound of the range of rich lav agiles (not inclusive)
	 * @return the range of matching rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findByscreename(String screename, int start,
		int end) {
		return findByscreename(screename, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rich lav agiles where screename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename the screename
	 * @param start the lower bound of the range of rich lav agiles
	 * @param end the upper bound of the range of rich lav agiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findByscreename(String screename, int start,
		int end, OrderByComparator<RichLavAgile> orderByComparator) {
		return findByscreename(screename, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rich lav agiles where screename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename the screename
	 * @param start the lower bound of the range of rich lav agiles
	 * @param end the upper bound of the range of rich lav agiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findByscreename(String screename, int start,
		int end, OrderByComparator<RichLavAgile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME;
			finderArgs = new Object[] { screename };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCREENAME;
			finderArgs = new Object[] { screename, start, end, orderByComparator };
		}

		List<RichLavAgile> list = null;

		if (retrieveFromCache) {
			list = (List<RichLavAgile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichLavAgile richLavAgile : list) {
					if (!Objects.equals(screename, richLavAgile.getScreename())) {
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

			query.append(_SQL_SELECT_RICHLAVAGILE_WHERE);

			boolean bindScreename = false;

			if (screename == null) {
				query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_1);
			}
			else if (screename.equals("")) {
				query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_3);
			}
			else {
				bindScreename = true;

				query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichLavAgileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreename) {
					qPos.add(screename);
				}

				if (!pagination) {
					list = (List<RichLavAgile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichLavAgile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rich lav agile in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rich lav agile
	 * @throws NoSuchRichLavAgileException if a matching rich lav agile could not be found
	 */
	@Override
	public RichLavAgile findByscreename_First(String screename,
		OrderByComparator<RichLavAgile> orderByComparator)
		throws NoSuchRichLavAgileException {
		RichLavAgile richLavAgile = fetchByscreename_First(screename,
				orderByComparator);

		if (richLavAgile != null) {
			return richLavAgile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screename=");
		msg.append(screename);

		msg.append("}");

		throw new NoSuchRichLavAgileException(msg.toString());
	}

	/**
	 * Returns the first rich lav agile in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rich lav agile, or <code>null</code> if a matching rich lav agile could not be found
	 */
	@Override
	public RichLavAgile fetchByscreename_First(String screename,
		OrderByComparator<RichLavAgile> orderByComparator) {
		List<RichLavAgile> list = findByscreename(screename, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rich lav agile in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rich lav agile
	 * @throws NoSuchRichLavAgileException if a matching rich lav agile could not be found
	 */
	@Override
	public RichLavAgile findByscreename_Last(String screename,
		OrderByComparator<RichLavAgile> orderByComparator)
		throws NoSuchRichLavAgileException {
		RichLavAgile richLavAgile = fetchByscreename_Last(screename,
				orderByComparator);

		if (richLavAgile != null) {
			return richLavAgile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screename=");
		msg.append(screename);

		msg.append("}");

		throw new NoSuchRichLavAgileException(msg.toString());
	}

	/**
	 * Returns the last rich lav agile in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rich lav agile, or <code>null</code> if a matching rich lav agile could not be found
	 */
	@Override
	public RichLavAgile fetchByscreename_Last(String screename,
		OrderByComparator<RichLavAgile> orderByComparator) {
		int count = countByscreename(screename);

		if (count == 0) {
			return null;
		}

		List<RichLavAgile> list = findByscreename(screename, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rich lav agiles before and after the current rich lav agile in the ordered set where screename = &#63;.
	 *
	 * @param id the primary key of the current rich lav agile
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rich lav agile
	 * @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	 */
	@Override
	public RichLavAgile[] findByscreename_PrevAndNext(long id,
		String screename, OrderByComparator<RichLavAgile> orderByComparator)
		throws NoSuchRichLavAgileException {
		RichLavAgile richLavAgile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RichLavAgile[] array = new RichLavAgileImpl[3];

			array[0] = getByscreename_PrevAndNext(session, richLavAgile,
					screename, orderByComparator, true);

			array[1] = richLavAgile;

			array[2] = getByscreename_PrevAndNext(session, richLavAgile,
					screename, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichLavAgile getByscreename_PrevAndNext(Session session,
		RichLavAgile richLavAgile, String screename,
		OrderByComparator<RichLavAgile> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RICHLAVAGILE_WHERE);

		boolean bindScreename = false;

		if (screename == null) {
			query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_1);
		}
		else if (screename.equals("")) {
			query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_3);
		}
		else {
			bindScreename = true;

			query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_2);
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
			query.append(RichLavAgileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScreename) {
			qPos.add(screename);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richLavAgile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichLavAgile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rich lav agiles where screename = &#63; from the database.
	 *
	 * @param screename the screename
	 */
	@Override
	public void removeByscreename(String screename) {
		for (RichLavAgile richLavAgile : findByscreename(screename,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(richLavAgile);
		}
	}

	/**
	 * Returns the number of rich lav agiles where screename = &#63;.
	 *
	 * @param screename the screename
	 * @return the number of matching rich lav agiles
	 */
	@Override
	public int countByscreename(String screename) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCREENAME;

		Object[] finderArgs = new Object[] { screename };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RICHLAVAGILE_WHERE);

			boolean bindScreename = false;

			if (screename == null) {
				query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_1);
			}
			else if (screename.equals("")) {
				query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_3);
			}
			else {
				bindScreename = true;

				query.append(_FINDER_COLUMN_SCREENAME_SCREENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreename) {
					qPos.add(screename);
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

	private static final String _FINDER_COLUMN_SCREENAME_SCREENAME_1 = "richLavAgile.screename IS NULL";
	private static final String _FINDER_COLUMN_SCREENAME_SCREENAME_2 = "richLavAgile.screename = ?";
	private static final String _FINDER_COLUMN_SCREENAME_SCREENAME_3 = "(richLavAgile.screename IS NULL OR richLavAgile.screename = '')";

	public RichLavAgilePersistenceImpl() {
		setModelClass(RichLavAgile.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the rich lav agile in the entity cache if it is enabled.
	 *
	 * @param richLavAgile the rich lav agile
	 */
	@Override
	public void cacheResult(RichLavAgile richLavAgile) {
		entityCache.putResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileImpl.class, richLavAgile.getPrimaryKey(), richLavAgile);

		richLavAgile.resetOriginalValues();
	}

	/**
	 * Caches the rich lav agiles in the entity cache if it is enabled.
	 *
	 * @param richLavAgiles the rich lav agiles
	 */
	@Override
	public void cacheResult(List<RichLavAgile> richLavAgiles) {
		for (RichLavAgile richLavAgile : richLavAgiles) {
			if (entityCache.getResult(
						RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
						RichLavAgileImpl.class, richLavAgile.getPrimaryKey()) == null) {
				cacheResult(richLavAgile);
			}
			else {
				richLavAgile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rich lav agiles.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichLavAgileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rich lav agile.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichLavAgile richLavAgile) {
		entityCache.removeResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileImpl.class, richLavAgile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichLavAgile> richLavAgiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichLavAgile richLavAgile : richLavAgiles) {
			entityCache.removeResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
				RichLavAgileImpl.class, richLavAgile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rich lav agile with the primary key. Does not add the rich lav agile to the database.
	 *
	 * @param id the primary key for the new rich lav agile
	 * @return the new rich lav agile
	 */
	@Override
	public RichLavAgile create(long id) {
		RichLavAgile richLavAgile = new RichLavAgileImpl();

		richLavAgile.setNew(true);
		richLavAgile.setPrimaryKey(id);

		return richLavAgile;
	}

	/**
	 * Removes the rich lav agile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the rich lav agile
	 * @return the rich lav agile that was removed
	 * @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	 */
	@Override
	public RichLavAgile remove(long id) throws NoSuchRichLavAgileException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the rich lav agile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rich lav agile
	 * @return the rich lav agile that was removed
	 * @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	 */
	@Override
	public RichLavAgile remove(Serializable primaryKey)
		throws NoSuchRichLavAgileException {
		Session session = null;

		try {
			session = openSession();

			RichLavAgile richLavAgile = (RichLavAgile)session.get(RichLavAgileImpl.class,
					primaryKey);

			if (richLavAgile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichLavAgileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richLavAgile);
		}
		catch (NoSuchRichLavAgileException nsee) {
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
	protected RichLavAgile removeImpl(RichLavAgile richLavAgile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richLavAgile)) {
				richLavAgile = (RichLavAgile)session.get(RichLavAgileImpl.class,
						richLavAgile.getPrimaryKeyObj());
			}

			if (richLavAgile != null) {
				session.delete(richLavAgile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richLavAgile != null) {
			clearCache(richLavAgile);
		}

		return richLavAgile;
	}

	@Override
	public RichLavAgile updateImpl(RichLavAgile richLavAgile) {
		boolean isNew = richLavAgile.isNew();

		if (!(richLavAgile instanceof RichLavAgileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(richLavAgile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(richLavAgile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in richLavAgile proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RichLavAgile implementation " +
				richLavAgile.getClass());
		}

		RichLavAgileModelImpl richLavAgileModelImpl = (RichLavAgileModelImpl)richLavAgile;

		Session session = null;

		try {
			session = openSession();

			if (richLavAgile.isNew()) {
				session.save(richLavAgile);

				richLavAgile.setNew(false);
			}
			else {
				richLavAgile = (RichLavAgile)session.merge(richLavAgile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RichLavAgileModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { richLavAgileModelImpl.getScreename() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((richLavAgileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richLavAgileModelImpl.getOriginalScreename()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME,
					args);

				args = new Object[] { richLavAgileModelImpl.getScreename() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME,
					args);
			}
		}

		entityCache.putResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
			RichLavAgileImpl.class, richLavAgile.getPrimaryKey(), richLavAgile,
			false);

		richLavAgile.resetOriginalValues();

		return richLavAgile;
	}

	/**
	 * Returns the rich lav agile with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rich lav agile
	 * @return the rich lav agile
	 * @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	 */
	@Override
	public RichLavAgile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichLavAgileException {
		RichLavAgile richLavAgile = fetchByPrimaryKey(primaryKey);

		if (richLavAgile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichLavAgileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richLavAgile;
	}

	/**
	 * Returns the rich lav agile with the primary key or throws a {@link NoSuchRichLavAgileException} if it could not be found.
	 *
	 * @param id the primary key of the rich lav agile
	 * @return the rich lav agile
	 * @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	 */
	@Override
	public RichLavAgile findByPrimaryKey(long id)
		throws NoSuchRichLavAgileException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the rich lav agile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rich lav agile
	 * @return the rich lav agile, or <code>null</code> if a rich lav agile with the primary key could not be found
	 */
	@Override
	public RichLavAgile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
				RichLavAgileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichLavAgile richLavAgile = (RichLavAgile)serializable;

		if (richLavAgile == null) {
			Session session = null;

			try {
				session = openSession();

				richLavAgile = (RichLavAgile)session.get(RichLavAgileImpl.class,
						primaryKey);

				if (richLavAgile != null) {
					cacheResult(richLavAgile);
				}
				else {
					entityCache.putResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
						RichLavAgileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
					RichLavAgileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richLavAgile;
	}

	/**
	 * Returns the rich lav agile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the rich lav agile
	 * @return the rich lav agile, or <code>null</code> if a rich lav agile with the primary key could not be found
	 */
	@Override
	public RichLavAgile fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, RichLavAgile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichLavAgile> map = new HashMap<Serializable, RichLavAgile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichLavAgile richLavAgile = fetchByPrimaryKey(primaryKey);

			if (richLavAgile != null) {
				map.put(primaryKey, richLavAgile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
					RichLavAgileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichLavAgile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHLAVAGILE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (RichLavAgile richLavAgile : (List<RichLavAgile>)q.list()) {
				map.put(richLavAgile.getPrimaryKeyObj(), richLavAgile);

				cacheResult(richLavAgile);

				uncachedPrimaryKeys.remove(richLavAgile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichLavAgileModelImpl.ENTITY_CACHE_ENABLED,
					RichLavAgileImpl.class, primaryKey, nullModel);
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
	 * Returns all the rich lav agiles.
	 *
	 * @return the rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rich lav agiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rich lav agiles
	 * @param end the upper bound of the range of rich lav agiles (not inclusive)
	 * @return the range of rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rich lav agiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rich lav agiles
	 * @param end the upper bound of the range of rich lav agiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findAll(int start, int end,
		OrderByComparator<RichLavAgile> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rich lav agiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rich lav agiles
	 * @param end the upper bound of the range of rich lav agiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rich lav agiles
	 */
	@Override
	public List<RichLavAgile> findAll(int start, int end,
		OrderByComparator<RichLavAgile> orderByComparator,
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

		List<RichLavAgile> list = null;

		if (retrieveFromCache) {
			list = (List<RichLavAgile>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHLAVAGILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHLAVAGILE;

				if (pagination) {
					sql = sql.concat(RichLavAgileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichLavAgile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichLavAgile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rich lav agiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichLavAgile richLavAgile : findAll()) {
			remove(richLavAgile);
		}
	}

	/**
	 * Returns the number of rich lav agiles.
	 *
	 * @return the number of rich lav agiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHLAVAGILE);

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
		return RichLavAgileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rich lav agile persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichLavAgileImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHLAVAGILE = "SELECT richLavAgile FROM RichLavAgile richLavAgile";
	private static final String _SQL_SELECT_RICHLAVAGILE_WHERE_PKS_IN = "SELECT richLavAgile FROM RichLavAgile richLavAgile WHERE id_ IN (";
	private static final String _SQL_SELECT_RICHLAVAGILE_WHERE = "SELECT richLavAgile FROM RichLavAgile richLavAgile WHERE ";
	private static final String _SQL_COUNT_RICHLAVAGILE = "SELECT COUNT(richLavAgile) FROM RichLavAgile richLavAgile";
	private static final String _SQL_COUNT_RICHLAVAGILE_WHERE = "SELECT COUNT(richLavAgile) FROM RichLavAgile richLavAgile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richLavAgile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichLavAgile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RichLavAgile exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RichLavAgilePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}