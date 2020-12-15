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

package com.accenture.istanza.interpello.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.istanza.interpello.exception.NoSuchRichInterpelloException;
import com.accenture.istanza.interpello.model.RichInterpello;
import com.accenture.istanza.interpello.model.impl.RichInterpelloImpl;
import com.accenture.istanza.interpello.model.impl.RichInterpelloModelImpl;
import com.accenture.istanza.interpello.service.persistence.RichInterpelloPersistence;

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
 * The persistence implementation for the rich interpello service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichInterpelloPersistence
 * @see com.accenture.istanza.interpello.service.persistence.RichInterpelloUtil
 * @generated
 */
@ProviderType
public class RichInterpelloPersistenceImpl extends BasePersistenceImpl<RichInterpello>
	implements RichInterpelloPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichInterpelloUtil} to access the rich interpello persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichInterpelloImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloModelImpl.FINDER_CACHE_ENABLED,
			RichInterpelloImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloModelImpl.FINDER_CACHE_ENABLED,
			RichInterpelloImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCREENAME =
		new FinderPath(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloModelImpl.FINDER_CACHE_ENABLED,
			RichInterpelloImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByscreename",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME =
		new FinderPath(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloModelImpl.FINDER_CACHE_ENABLED,
			RichInterpelloImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByscreename",
			new String[] { String.class.getName() },
			RichInterpelloModelImpl.SCREENAME_COLUMN_BITMASK |
			RichInterpelloModelImpl.DATA_RICHIESTA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCREENAME = new FinderPath(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByscreename",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rich interpellos where screename = &#63;.
	 *
	 * @param screename the screename
	 * @return the matching rich interpellos
	 */
	@Override
	public List<RichInterpello> findByscreename(String screename) {
		return findByscreename(screename, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rich interpellos where screename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename the screename
	 * @param start the lower bound of the range of rich interpellos
	 * @param end the upper bound of the range of rich interpellos (not inclusive)
	 * @return the range of matching rich interpellos
	 */
	@Override
	public List<RichInterpello> findByscreename(String screename, int start,
		int end) {
		return findByscreename(screename, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rich interpellos where screename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename the screename
	 * @param start the lower bound of the range of rich interpellos
	 * @param end the upper bound of the range of rich interpellos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rich interpellos
	 */
	@Override
	public List<RichInterpello> findByscreename(String screename, int start,
		int end, OrderByComparator<RichInterpello> orderByComparator) {
		return findByscreename(screename, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rich interpellos where screename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename the screename
	 * @param start the lower bound of the range of rich interpellos
	 * @param end the upper bound of the range of rich interpellos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rich interpellos
	 */
	@Override
	public List<RichInterpello> findByscreename(String screename, int start,
		int end, OrderByComparator<RichInterpello> orderByComparator,
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

		List<RichInterpello> list = null;

		if (retrieveFromCache) {
			list = (List<RichInterpello>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichInterpello richInterpello : list) {
					if (!Objects.equals(screename, richInterpello.getScreename())) {
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

			query.append(_SQL_SELECT_RICHINTERPELLO_WHERE);

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
				query.append(RichInterpelloModelImpl.ORDER_BY_JPQL);
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
					list = (List<RichInterpello>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichInterpello>)QueryUtil.list(q,
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
	 * Returns the first rich interpello in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rich interpello
	 * @throws NoSuchRichInterpelloException if a matching rich interpello could not be found
	 */
	@Override
	public RichInterpello findByscreename_First(String screename,
		OrderByComparator<RichInterpello> orderByComparator)
		throws NoSuchRichInterpelloException {
		RichInterpello richInterpello = fetchByscreename_First(screename,
				orderByComparator);

		if (richInterpello != null) {
			return richInterpello;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screename=");
		msg.append(screename);

		msg.append("}");

		throw new NoSuchRichInterpelloException(msg.toString());
	}

	/**
	 * Returns the first rich interpello in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rich interpello, or <code>null</code> if a matching rich interpello could not be found
	 */
	@Override
	public RichInterpello fetchByscreename_First(String screename,
		OrderByComparator<RichInterpello> orderByComparator) {
		List<RichInterpello> list = findByscreename(screename, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rich interpello in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rich interpello
	 * @throws NoSuchRichInterpelloException if a matching rich interpello could not be found
	 */
	@Override
	public RichInterpello findByscreename_Last(String screename,
		OrderByComparator<RichInterpello> orderByComparator)
		throws NoSuchRichInterpelloException {
		RichInterpello richInterpello = fetchByscreename_Last(screename,
				orderByComparator);

		if (richInterpello != null) {
			return richInterpello;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screename=");
		msg.append(screename);

		msg.append("}");

		throw new NoSuchRichInterpelloException(msg.toString());
	}

	/**
	 * Returns the last rich interpello in the ordered set where screename = &#63;.
	 *
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rich interpello, or <code>null</code> if a matching rich interpello could not be found
	 */
	@Override
	public RichInterpello fetchByscreename_Last(String screename,
		OrderByComparator<RichInterpello> orderByComparator) {
		int count = countByscreename(screename);

		if (count == 0) {
			return null;
		}

		List<RichInterpello> list = findByscreename(screename, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rich interpellos before and after the current rich interpello in the ordered set where screename = &#63;.
	 *
	 * @param id the primary key of the current rich interpello
	 * @param screename the screename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rich interpello
	 * @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	 */
	@Override
	public RichInterpello[] findByscreename_PrevAndNext(long id,
		String screename, OrderByComparator<RichInterpello> orderByComparator)
		throws NoSuchRichInterpelloException {
		RichInterpello richInterpello = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RichInterpello[] array = new RichInterpelloImpl[3];

			array[0] = getByscreename_PrevAndNext(session, richInterpello,
					screename, orderByComparator, true);

			array[1] = richInterpello;

			array[2] = getByscreename_PrevAndNext(session, richInterpello,
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

	protected RichInterpello getByscreename_PrevAndNext(Session session,
		RichInterpello richInterpello, String screename,
		OrderByComparator<RichInterpello> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RICHINTERPELLO_WHERE);

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
			query.append(RichInterpelloModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(richInterpello);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichInterpello> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rich interpellos where screename = &#63; from the database.
	 *
	 * @param screename the screename
	 */
	@Override
	public void removeByscreename(String screename) {
		for (RichInterpello richInterpello : findByscreename(screename,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(richInterpello);
		}
	}

	/**
	 * Returns the number of rich interpellos where screename = &#63;.
	 *
	 * @param screename the screename
	 * @return the number of matching rich interpellos
	 */
	@Override
	public int countByscreename(String screename) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCREENAME;

		Object[] finderArgs = new Object[] { screename };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RICHINTERPELLO_WHERE);

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

	private static final String _FINDER_COLUMN_SCREENAME_SCREENAME_1 = "richInterpello.screename IS NULL";
	private static final String _FINDER_COLUMN_SCREENAME_SCREENAME_2 = "richInterpello.screename = ?";
	private static final String _FINDER_COLUMN_SCREENAME_SCREENAME_3 = "(richInterpello.screename IS NULL OR richInterpello.screename = '')";

	public RichInterpelloPersistenceImpl() {
		setModelClass(RichInterpello.class);

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
	 * Caches the rich interpello in the entity cache if it is enabled.
	 *
	 * @param richInterpello the rich interpello
	 */
	@Override
	public void cacheResult(RichInterpello richInterpello) {
		entityCache.putResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloImpl.class, richInterpello.getPrimaryKey(),
			richInterpello);

		richInterpello.resetOriginalValues();
	}

	/**
	 * Caches the rich interpellos in the entity cache if it is enabled.
	 *
	 * @param richInterpellos the rich interpellos
	 */
	@Override
	public void cacheResult(List<RichInterpello> richInterpellos) {
		for (RichInterpello richInterpello : richInterpellos) {
			if (entityCache.getResult(
						RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
						RichInterpelloImpl.class, richInterpello.getPrimaryKey()) == null) {
				cacheResult(richInterpello);
			}
			else {
				richInterpello.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rich interpellos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichInterpelloImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rich interpello.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichInterpello richInterpello) {
		entityCache.removeResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloImpl.class, richInterpello.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichInterpello> richInterpellos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichInterpello richInterpello : richInterpellos) {
			entityCache.removeResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
				RichInterpelloImpl.class, richInterpello.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rich interpello with the primary key. Does not add the rich interpello to the database.
	 *
	 * @param id the primary key for the new rich interpello
	 * @return the new rich interpello
	 */
	@Override
	public RichInterpello create(long id) {
		RichInterpello richInterpello = new RichInterpelloImpl();

		richInterpello.setNew(true);
		richInterpello.setPrimaryKey(id);

		return richInterpello;
	}

	/**
	 * Removes the rich interpello with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the rich interpello
	 * @return the rich interpello that was removed
	 * @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	 */
	@Override
	public RichInterpello remove(long id) throws NoSuchRichInterpelloException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the rich interpello with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rich interpello
	 * @return the rich interpello that was removed
	 * @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	 */
	@Override
	public RichInterpello remove(Serializable primaryKey)
		throws NoSuchRichInterpelloException {
		Session session = null;

		try {
			session = openSession();

			RichInterpello richInterpello = (RichInterpello)session.get(RichInterpelloImpl.class,
					primaryKey);

			if (richInterpello == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichInterpelloException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richInterpello);
		}
		catch (NoSuchRichInterpelloException nsee) {
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
	protected RichInterpello removeImpl(RichInterpello richInterpello) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richInterpello)) {
				richInterpello = (RichInterpello)session.get(RichInterpelloImpl.class,
						richInterpello.getPrimaryKeyObj());
			}

			if (richInterpello != null) {
				session.delete(richInterpello);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richInterpello != null) {
			clearCache(richInterpello);
		}

		return richInterpello;
	}

	@Override
	public RichInterpello updateImpl(RichInterpello richInterpello) {
		boolean isNew = richInterpello.isNew();

		if (!(richInterpello instanceof RichInterpelloModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(richInterpello.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(richInterpello);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in richInterpello proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RichInterpello implementation " +
				richInterpello.getClass());
		}

		RichInterpelloModelImpl richInterpelloModelImpl = (RichInterpelloModelImpl)richInterpello;

		Session session = null;

		try {
			session = openSession();

			if (richInterpello.isNew()) {
				session.save(richInterpello);

				richInterpello.setNew(false);
			}
			else {
				richInterpello = (RichInterpello)session.merge(richInterpello);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RichInterpelloModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { richInterpelloModelImpl.getScreename() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((richInterpelloModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richInterpelloModelImpl.getOriginalScreename()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME,
					args);

				args = new Object[] { richInterpelloModelImpl.getScreename() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENAME,
					args);
			}
		}

		entityCache.putResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
			RichInterpelloImpl.class, richInterpello.getPrimaryKey(),
			richInterpello, false);

		richInterpello.resetOriginalValues();

		return richInterpello;
	}

	/**
	 * Returns the rich interpello with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rich interpello
	 * @return the rich interpello
	 * @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	 */
	@Override
	public RichInterpello findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichInterpelloException {
		RichInterpello richInterpello = fetchByPrimaryKey(primaryKey);

		if (richInterpello == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichInterpelloException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richInterpello;
	}

	/**
	 * Returns the rich interpello with the primary key or throws a {@link NoSuchRichInterpelloException} if it could not be found.
	 *
	 * @param id the primary key of the rich interpello
	 * @return the rich interpello
	 * @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	 */
	@Override
	public RichInterpello findByPrimaryKey(long id)
		throws NoSuchRichInterpelloException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the rich interpello with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rich interpello
	 * @return the rich interpello, or <code>null</code> if a rich interpello with the primary key could not be found
	 */
	@Override
	public RichInterpello fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
				RichInterpelloImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichInterpello richInterpello = (RichInterpello)serializable;

		if (richInterpello == null) {
			Session session = null;

			try {
				session = openSession();

				richInterpello = (RichInterpello)session.get(RichInterpelloImpl.class,
						primaryKey);

				if (richInterpello != null) {
					cacheResult(richInterpello);
				}
				else {
					entityCache.putResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
						RichInterpelloImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
					RichInterpelloImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richInterpello;
	}

	/**
	 * Returns the rich interpello with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the rich interpello
	 * @return the rich interpello, or <code>null</code> if a rich interpello with the primary key could not be found
	 */
	@Override
	public RichInterpello fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, RichInterpello> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichInterpello> map = new HashMap<Serializable, RichInterpello>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichInterpello richInterpello = fetchByPrimaryKey(primaryKey);

			if (richInterpello != null) {
				map.put(primaryKey, richInterpello);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
					RichInterpelloImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichInterpello)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHINTERPELLO_WHERE_PKS_IN);

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

			for (RichInterpello richInterpello : (List<RichInterpello>)q.list()) {
				map.put(richInterpello.getPrimaryKeyObj(), richInterpello);

				cacheResult(richInterpello);

				uncachedPrimaryKeys.remove(richInterpello.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichInterpelloModelImpl.ENTITY_CACHE_ENABLED,
					RichInterpelloImpl.class, primaryKey, nullModel);
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
	 * Returns all the rich interpellos.
	 *
	 * @return the rich interpellos
	 */
	@Override
	public List<RichInterpello> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rich interpellos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rich interpellos
	 * @param end the upper bound of the range of rich interpellos (not inclusive)
	 * @return the range of rich interpellos
	 */
	@Override
	public List<RichInterpello> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rich interpellos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rich interpellos
	 * @param end the upper bound of the range of rich interpellos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rich interpellos
	 */
	@Override
	public List<RichInterpello> findAll(int start, int end,
		OrderByComparator<RichInterpello> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rich interpellos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rich interpellos
	 * @param end the upper bound of the range of rich interpellos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rich interpellos
	 */
	@Override
	public List<RichInterpello> findAll(int start, int end,
		OrderByComparator<RichInterpello> orderByComparator,
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

		List<RichInterpello> list = null;

		if (retrieveFromCache) {
			list = (List<RichInterpello>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHINTERPELLO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHINTERPELLO;

				if (pagination) {
					sql = sql.concat(RichInterpelloModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichInterpello>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichInterpello>)QueryUtil.list(q,
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
	 * Removes all the rich interpellos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichInterpello richInterpello : findAll()) {
			remove(richInterpello);
		}
	}

	/**
	 * Returns the number of rich interpellos.
	 *
	 * @return the number of rich interpellos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHINTERPELLO);

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
		return RichInterpelloModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rich interpello persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichInterpelloImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHINTERPELLO = "SELECT richInterpello FROM RichInterpello richInterpello";
	private static final String _SQL_SELECT_RICHINTERPELLO_WHERE_PKS_IN = "SELECT richInterpello FROM RichInterpello richInterpello WHERE id_ IN (";
	private static final String _SQL_SELECT_RICHINTERPELLO_WHERE = "SELECT richInterpello FROM RichInterpello richInterpello WHERE ";
	private static final String _SQL_COUNT_RICHINTERPELLO = "SELECT COUNT(richInterpello) FROM RichInterpello richInterpello";
	private static final String _SQL_COUNT_RICHINTERPELLO_WHERE = "SELECT COUNT(richInterpello) FROM RichInterpello richInterpello WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richInterpello.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichInterpello exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RichInterpello exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RichInterpelloPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}