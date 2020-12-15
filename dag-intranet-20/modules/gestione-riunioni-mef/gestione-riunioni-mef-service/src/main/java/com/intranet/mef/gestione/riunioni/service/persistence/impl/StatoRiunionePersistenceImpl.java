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

package com.intranet.mef.gestione.riunioni.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.exception.NoSuchStatoRiunioneException;
import com.intranet.mef.gestione.riunioni.model.StatoRiunione;
import com.intranet.mef.gestione.riunioni.model.impl.StatoRiunioneImpl;
import com.intranet.mef.gestione.riunioni.model.impl.StatoRiunioneModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.StatoRiunionePersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the stato riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.StatoRiunioneUtil
 * @generated
 */
@ProviderType
public class StatoRiunionePersistenceImpl extends BasePersistenceImpl<StatoRiunione>
	implements StatoRiunionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatoRiunioneUtil} to access the stato riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatoRiunioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StatoRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StatoRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATORIUNIONE =
		new FinderPath(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StatoRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatoRiunione",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATORIUNIONE =
		new FinderPath(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StatoRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatoRiunione", new String[] { String.class.getName() },
			StatoRiunioneModelImpl.LABEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATORIUNIONE = new FinderPath(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatoRiunione",
			new String[] { String.class.getName() });

	/**
	 * Returns all the stato riuniones where label = &#63;.
	 *
	 * @param label the label
	 * @return the matching stato riuniones
	 */
	@Override
	public List<StatoRiunione> findByStatoRiunione(String label) {
		return findByStatoRiunione(label, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the stato riuniones where label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label the label
	 * @param start the lower bound of the range of stato riuniones
	 * @param end the upper bound of the range of stato riuniones (not inclusive)
	 * @return the range of matching stato riuniones
	 */
	@Override
	public List<StatoRiunione> findByStatoRiunione(String label, int start,
		int end) {
		return findByStatoRiunione(label, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato riuniones where label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label the label
	 * @param start the lower bound of the range of stato riuniones
	 * @param end the upper bound of the range of stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato riuniones
	 */
	@Override
	public List<StatoRiunione> findByStatoRiunione(String label, int start,
		int end, OrderByComparator<StatoRiunione> orderByComparator) {
		return findByStatoRiunione(label, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato riuniones where label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label the label
	 * @param start the lower bound of the range of stato riuniones
	 * @param end the upper bound of the range of stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato riuniones
	 */
	@Override
	public List<StatoRiunione> findByStatoRiunione(String label, int start,
		int end, OrderByComparator<StatoRiunione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATORIUNIONE;
			finderArgs = new Object[] { label };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATORIUNIONE;
			finderArgs = new Object[] { label, start, end, orderByComparator };
		}

		List<StatoRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<StatoRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatoRiunione statoRiunione : list) {
					if (!Objects.equals(label, statoRiunione.getLabel())) {
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

			query.append(_SQL_SELECT_STATORIUNIONE_WHERE);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatoRiunioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel) {
					qPos.add(label);
				}

				if (!pagination) {
					list = (List<StatoRiunione>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoRiunione>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first stato riunione in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato riunione
	 * @throws NoSuchStatoRiunioneException if a matching stato riunione could not be found
	 */
	@Override
	public StatoRiunione findByStatoRiunione_First(String label,
		OrderByComparator<StatoRiunione> orderByComparator)
		throws NoSuchStatoRiunioneException {
		StatoRiunione statoRiunione = fetchByStatoRiunione_First(label,
				orderByComparator);

		if (statoRiunione != null) {
			return statoRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label=");
		msg.append(label);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatoRiunioneException(msg.toString());
	}

	/**
	 * Returns the first stato riunione in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato riunione, or <code>null</code> if a matching stato riunione could not be found
	 */
	@Override
	public StatoRiunione fetchByStatoRiunione_First(String label,
		OrderByComparator<StatoRiunione> orderByComparator) {
		List<StatoRiunione> list = findByStatoRiunione(label, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato riunione in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato riunione
	 * @throws NoSuchStatoRiunioneException if a matching stato riunione could not be found
	 */
	@Override
	public StatoRiunione findByStatoRiunione_Last(String label,
		OrderByComparator<StatoRiunione> orderByComparator)
		throws NoSuchStatoRiunioneException {
		StatoRiunione statoRiunione = fetchByStatoRiunione_Last(label,
				orderByComparator);

		if (statoRiunione != null) {
			return statoRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label=");
		msg.append(label);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatoRiunioneException(msg.toString());
	}

	/**
	 * Returns the last stato riunione in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato riunione, or <code>null</code> if a matching stato riunione could not be found
	 */
	@Override
	public StatoRiunione fetchByStatoRiunione_Last(String label,
		OrderByComparator<StatoRiunione> orderByComparator) {
		int count = countByStatoRiunione(label);

		if (count == 0) {
			return null;
		}

		List<StatoRiunione> list = findByStatoRiunione(label, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato riuniones before and after the current stato riunione in the ordered set where label = &#63;.
	 *
	 * @param id_stato_riunione the primary key of the current stato riunione
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato riunione
	 * @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	 */
	@Override
	public StatoRiunione[] findByStatoRiunione_PrevAndNext(
		long id_stato_riunione, String label,
		OrderByComparator<StatoRiunione> orderByComparator)
		throws NoSuchStatoRiunioneException {
		StatoRiunione statoRiunione = findByPrimaryKey(id_stato_riunione);

		Session session = null;

		try {
			session = openSession();

			StatoRiunione[] array = new StatoRiunioneImpl[3];

			array[0] = getByStatoRiunione_PrevAndNext(session, statoRiunione,
					label, orderByComparator, true);

			array[1] = statoRiunione;

			array[2] = getByStatoRiunione_PrevAndNext(session, statoRiunione,
					label, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatoRiunione getByStatoRiunione_PrevAndNext(Session session,
		StatoRiunione statoRiunione, String label,
		OrderByComparator<StatoRiunione> orderByComparator, boolean previous) {
		StringBundler query;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATORIUNIONE_WHERE);

		boolean bindLabel = false;

		if (label == null) {
			query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_1);
		}
		else if (label.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_3);
		}
		else {
			bindLabel = true;

			query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_2);
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
			query.append(StatoRiunioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLabel) {
			qPos.add(label);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statoRiunione);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatoRiunione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato riuniones where label = &#63; from the database.
	 *
	 * @param label the label
	 */
	@Override
	public void removeByStatoRiunione(String label) {
		for (StatoRiunione statoRiunione : findByStatoRiunione(label,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statoRiunione);
		}
	}

	/**
	 * Returns the number of stato riuniones where label = &#63;.
	 *
	 * @param label the label
	 * @return the number of matching stato riuniones
	 */
	@Override
	public int countByStatoRiunione(String label) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATORIUNIONE;

		Object[] finderArgs = new Object[] { label };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATORIUNIONE_WHERE);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_STATORIUNIONE_LABEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel) {
					qPos.add(label);
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

	private static final String _FINDER_COLUMN_STATORIUNIONE_LABEL_1 = "statoRiunione.label IS NULL";
	private static final String _FINDER_COLUMN_STATORIUNIONE_LABEL_2 = "statoRiunione.label = ?";
	private static final String _FINDER_COLUMN_STATORIUNIONE_LABEL_3 = "(statoRiunione.label IS NULL OR statoRiunione.label = '')";

	public StatoRiunionePersistenceImpl() {
		setModelClass(StatoRiunione.class);
	}

	/**
	 * Caches the stato riunione in the entity cache if it is enabled.
	 *
	 * @param statoRiunione the stato riunione
	 */
	@Override
	public void cacheResult(StatoRiunione statoRiunione) {
		entityCache.putResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneImpl.class, statoRiunione.getPrimaryKey(),
			statoRiunione);

		statoRiunione.resetOriginalValues();
	}

	/**
	 * Caches the stato riuniones in the entity cache if it is enabled.
	 *
	 * @param statoRiuniones the stato riuniones
	 */
	@Override
	public void cacheResult(List<StatoRiunione> statoRiuniones) {
		for (StatoRiunione statoRiunione : statoRiuniones) {
			if (entityCache.getResult(
						StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						StatoRiunioneImpl.class, statoRiunione.getPrimaryKey()) == null) {
				cacheResult(statoRiunione);
			}
			else {
				statoRiunione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stato riuniones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoRiunioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stato riunione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatoRiunione statoRiunione) {
		entityCache.removeResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneImpl.class, statoRiunione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatoRiunione> statoRiuniones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatoRiunione statoRiunione : statoRiuniones) {
			entityCache.removeResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				StatoRiunioneImpl.class, statoRiunione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stato riunione with the primary key. Does not add the stato riunione to the database.
	 *
	 * @param id_stato_riunione the primary key for the new stato riunione
	 * @return the new stato riunione
	 */
	@Override
	public StatoRiunione create(long id_stato_riunione) {
		StatoRiunione statoRiunione = new StatoRiunioneImpl();

		statoRiunione.setNew(true);
		statoRiunione.setPrimaryKey(id_stato_riunione);

		return statoRiunione;
	}

	/**
	 * Removes the stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_stato_riunione the primary key of the stato riunione
	 * @return the stato riunione that was removed
	 * @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	 */
	@Override
	public StatoRiunione remove(long id_stato_riunione)
		throws NoSuchStatoRiunioneException {
		return remove((Serializable)id_stato_riunione);
	}

	/**
	 * Removes the stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato riunione
	 * @return the stato riunione that was removed
	 * @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	 */
	@Override
	public StatoRiunione remove(Serializable primaryKey)
		throws NoSuchStatoRiunioneException {
		Session session = null;

		try {
			session = openSession();

			StatoRiunione statoRiunione = (StatoRiunione)session.get(StatoRiunioneImpl.class,
					primaryKey);

			if (statoRiunione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statoRiunione);
		}
		catch (NoSuchStatoRiunioneException nsee) {
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
	protected StatoRiunione removeImpl(StatoRiunione statoRiunione) {
		statoRiunione = toUnwrappedModel(statoRiunione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statoRiunione)) {
				statoRiunione = (StatoRiunione)session.get(StatoRiunioneImpl.class,
						statoRiunione.getPrimaryKeyObj());
			}

			if (statoRiunione != null) {
				session.delete(statoRiunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statoRiunione != null) {
			clearCache(statoRiunione);
		}

		return statoRiunione;
	}

	@Override
	public StatoRiunione updateImpl(StatoRiunione statoRiunione) {
		statoRiunione = toUnwrappedModel(statoRiunione);

		boolean isNew = statoRiunione.isNew();

		StatoRiunioneModelImpl statoRiunioneModelImpl = (StatoRiunioneModelImpl)statoRiunione;

		Session session = null;

		try {
			session = openSession();

			if (statoRiunione.isNew()) {
				session.save(statoRiunione);

				statoRiunione.setNew(false);
			}
			else {
				statoRiunione = (StatoRiunione)session.merge(statoRiunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatoRiunioneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statoRiunioneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATORIUNIONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statoRiunioneModelImpl.getOriginalLabel()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATORIUNIONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATORIUNIONE,
					args);

				args = new Object[] { statoRiunioneModelImpl.getLabel() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATORIUNIONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATORIUNIONE,
					args);
			}
		}

		entityCache.putResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StatoRiunioneImpl.class, statoRiunione.getPrimaryKey(),
			statoRiunione, false);

		statoRiunione.resetOriginalValues();

		return statoRiunione;
	}

	protected StatoRiunione toUnwrappedModel(StatoRiunione statoRiunione) {
		if (statoRiunione instanceof StatoRiunioneImpl) {
			return statoRiunione;
		}

		StatoRiunioneImpl statoRiunioneImpl = new StatoRiunioneImpl();

		statoRiunioneImpl.setNew(statoRiunione.isNew());
		statoRiunioneImpl.setPrimaryKey(statoRiunione.getPrimaryKey());

		statoRiunioneImpl.setId_stato_riunione(statoRiunione.getId_stato_riunione());
		statoRiunioneImpl.setLabel(statoRiunione.getLabel());
		statoRiunioneImpl.setNext_stato(statoRiunione.getNext_stato());

		return statoRiunioneImpl;
	}

	/**
	 * Returns the stato riunione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato riunione
	 * @return the stato riunione
	 * @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	 */
	@Override
	public StatoRiunione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoRiunioneException {
		StatoRiunione statoRiunione = fetchByPrimaryKey(primaryKey);

		if (statoRiunione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statoRiunione;
	}

	/**
	 * Returns the stato riunione with the primary key or throws a {@link NoSuchStatoRiunioneException} if it could not be found.
	 *
	 * @param id_stato_riunione the primary key of the stato riunione
	 * @return the stato riunione
	 * @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	 */
	@Override
	public StatoRiunione findByPrimaryKey(long id_stato_riunione)
		throws NoSuchStatoRiunioneException {
		return findByPrimaryKey((Serializable)id_stato_riunione);
	}

	/**
	 * Returns the stato riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato riunione
	 * @return the stato riunione, or <code>null</code> if a stato riunione with the primary key could not be found
	 */
	@Override
	public StatoRiunione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				StatoRiunioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StatoRiunione statoRiunione = (StatoRiunione)serializable;

		if (statoRiunione == null) {
			Session session = null;

			try {
				session = openSession();

				statoRiunione = (StatoRiunione)session.get(StatoRiunioneImpl.class,
						primaryKey);

				if (statoRiunione != null) {
					cacheResult(statoRiunione);
				}
				else {
					entityCache.putResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						StatoRiunioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					StatoRiunioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statoRiunione;
	}

	/**
	 * Returns the stato riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_stato_riunione the primary key of the stato riunione
	 * @return the stato riunione, or <code>null</code> if a stato riunione with the primary key could not be found
	 */
	@Override
	public StatoRiunione fetchByPrimaryKey(long id_stato_riunione) {
		return fetchByPrimaryKey((Serializable)id_stato_riunione);
	}

	@Override
	public Map<Serializable, StatoRiunione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StatoRiunione> map = new HashMap<Serializable, StatoRiunione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StatoRiunione statoRiunione = fetchByPrimaryKey(primaryKey);

			if (statoRiunione != null) {
				map.put(primaryKey, statoRiunione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					StatoRiunioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StatoRiunione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STATORIUNIONE_WHERE_PKS_IN);

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

			for (StatoRiunione statoRiunione : (List<StatoRiunione>)q.list()) {
				map.put(statoRiunione.getPrimaryKeyObj(), statoRiunione);

				cacheResult(statoRiunione);

				uncachedPrimaryKeys.remove(statoRiunione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					StatoRiunioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the stato riuniones.
	 *
	 * @return the stato riuniones
	 */
	@Override
	public List<StatoRiunione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato riuniones
	 * @param end the upper bound of the range of stato riuniones (not inclusive)
	 * @return the range of stato riuniones
	 */
	@Override
	public List<StatoRiunione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato riuniones
	 * @param end the upper bound of the range of stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato riuniones
	 */
	@Override
	public List<StatoRiunione> findAll(int start, int end,
		OrderByComparator<StatoRiunione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato riuniones
	 * @param end the upper bound of the range of stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stato riuniones
	 */
	@Override
	public List<StatoRiunione> findAll(int start, int end,
		OrderByComparator<StatoRiunione> orderByComparator,
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

		List<StatoRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<StatoRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATORIUNIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATORIUNIONE;

				if (pagination) {
					sql = sql.concat(StatoRiunioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatoRiunione>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoRiunione>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the stato riuniones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatoRiunione statoRiunione : findAll()) {
			remove(statoRiunione);
		}
	}

	/**
	 * Returns the number of stato riuniones.
	 *
	 * @return the number of stato riuniones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATORIUNIONE);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return StatoRiunioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato riunione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StatoRiunioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STATORIUNIONE = "SELECT statoRiunione FROM StatoRiunione statoRiunione";
	private static final String _SQL_SELECT_STATORIUNIONE_WHERE_PKS_IN = "SELECT statoRiunione FROM StatoRiunione statoRiunione WHERE id_stato_riunione IN (";
	private static final String _SQL_SELECT_STATORIUNIONE_WHERE = "SELECT statoRiunione FROM StatoRiunione statoRiunione WHERE ";
	private static final String _SQL_COUNT_STATORIUNIONE = "SELECT COUNT(statoRiunione) FROM StatoRiunione statoRiunione";
	private static final String _SQL_COUNT_STATORIUNIONE_WHERE = "SELECT COUNT(statoRiunione) FROM StatoRiunione statoRiunione WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statoRiunione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatoRiunione exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatoRiunione exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StatoRiunionePersistenceImpl.class);
}