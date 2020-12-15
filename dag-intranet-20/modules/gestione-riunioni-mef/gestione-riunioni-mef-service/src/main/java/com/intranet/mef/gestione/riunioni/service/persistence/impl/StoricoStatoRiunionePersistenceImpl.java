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

import com.intranet.mef.gestione.riunioni.exception.NoSuchStoricoStatoRiunioneException;
import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;
import com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneImpl;
import com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK;
import com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePersistence;

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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the storico stato riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunioneUtil
 * @generated
 */
@ProviderType
public class StoricoStatoRiunionePersistenceImpl extends BasePersistenceImpl<StoricoStatoRiunione>
	implements StoricoStatoRiunionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StoricoStatoRiunioneUtil} to access the storico stato riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StoricoStatoRiunioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StoricoStatoRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StoricoStatoRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STORICORIUNIONE =
		new FinderPath(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StoricoStatoRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStoricoRiunione",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORICORIUNIONE =
		new FinderPath(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneModelImpl.FINDER_CACHE_ENABLED,
			StoricoStatoRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStoricoRiunione",
			new String[] { Long.class.getName() },
			StoricoStatoRiunioneModelImpl.ID_RIUNIONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STORICORIUNIONE = new FinderPath(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStoricoRiunione", new String[] { Long.class.getName() });

	/**
	 * Returns all the storico stato riuniones where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @return the matching storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findByStoricoRiunione(long id_riunione) {
		return findByStoricoRiunione(id_riunione, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the storico stato riuniones where id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of storico stato riuniones
	 * @param end the upper bound of the range of storico stato riuniones (not inclusive)
	 * @return the range of matching storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findByStoricoRiunione(long id_riunione,
		int start, int end) {
		return findByStoricoRiunione(id_riunione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the storico stato riuniones where id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of storico stato riuniones
	 * @param end the upper bound of the range of storico stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findByStoricoRiunione(long id_riunione,
		int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		return findByStoricoRiunione(id_riunione, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the storico stato riuniones where id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of storico stato riuniones
	 * @param end the upper bound of the range of storico stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findByStoricoRiunione(long id_riunione,
		int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORICORIUNIONE;
			finderArgs = new Object[] { id_riunione };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STORICORIUNIONE;
			finderArgs = new Object[] { id_riunione, start, end, orderByComparator };
		}

		List<StoricoStatoRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<StoricoStatoRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StoricoStatoRiunione storicoStatoRiunione : list) {
					if ((id_riunione != storicoStatoRiunione.getId_riunione())) {
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

			query.append(_SQL_SELECT_STORICOSTATORIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_STORICORIUNIONE_ID_RIUNIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StoricoStatoRiunioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_riunione);

				if (!pagination) {
					list = (List<StoricoStatoRiunione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StoricoStatoRiunione>)QueryUtil.list(q,
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
	 * Returns the first storico stato riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico stato riunione
	 * @throws NoSuchStoricoStatoRiunioneException if a matching storico stato riunione could not be found
	 */
	@Override
	public StoricoStatoRiunione findByStoricoRiunione_First(long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws NoSuchStoricoStatoRiunioneException {
		StoricoStatoRiunione storicoStatoRiunione = fetchByStoricoRiunione_First(id_riunione,
				orderByComparator);

		if (storicoStatoRiunione != null) {
			return storicoStatoRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_riunione=");
		msg.append(id_riunione);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStoricoStatoRiunioneException(msg.toString());
	}

	/**
	 * Returns the first storico stato riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico stato riunione, or <code>null</code> if a matching storico stato riunione could not be found
	 */
	@Override
	public StoricoStatoRiunione fetchByStoricoRiunione_First(long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		List<StoricoStatoRiunione> list = findByStoricoRiunione(id_riunione, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last storico stato riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico stato riunione
	 * @throws NoSuchStoricoStatoRiunioneException if a matching storico stato riunione could not be found
	 */
	@Override
	public StoricoStatoRiunione findByStoricoRiunione_Last(long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws NoSuchStoricoStatoRiunioneException {
		StoricoStatoRiunione storicoStatoRiunione = fetchByStoricoRiunione_Last(id_riunione,
				orderByComparator);

		if (storicoStatoRiunione != null) {
			return storicoStatoRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_riunione=");
		msg.append(id_riunione);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStoricoStatoRiunioneException(msg.toString());
	}

	/**
	 * Returns the last storico stato riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico stato riunione, or <code>null</code> if a matching storico stato riunione could not be found
	 */
	@Override
	public StoricoStatoRiunione fetchByStoricoRiunione_Last(long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		int count = countByStoricoRiunione(id_riunione);

		if (count == 0) {
			return null;
		}

		List<StoricoStatoRiunione> list = findByStoricoRiunione(id_riunione,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the storico stato riuniones before and after the current storico stato riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param storicoStatoRiunionePK the primary key of the current storico stato riunione
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next storico stato riunione
	 * @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	 */
	@Override
	public StoricoStatoRiunione[] findByStoricoRiunione_PrevAndNext(
		StoricoStatoRiunionePK storicoStatoRiunionePK, long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws NoSuchStoricoStatoRiunioneException {
		StoricoStatoRiunione storicoStatoRiunione = findByPrimaryKey(storicoStatoRiunionePK);

		Session session = null;

		try {
			session = openSession();

			StoricoStatoRiunione[] array = new StoricoStatoRiunioneImpl[3];

			array[0] = getByStoricoRiunione_PrevAndNext(session,
					storicoStatoRiunione, id_riunione, orderByComparator, true);

			array[1] = storicoStatoRiunione;

			array[2] = getByStoricoRiunione_PrevAndNext(session,
					storicoStatoRiunione, id_riunione, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StoricoStatoRiunione getByStoricoRiunione_PrevAndNext(
		Session session, StoricoStatoRiunione storicoStatoRiunione,
		long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STORICOSTATORIUNIONE_WHERE);

		query.append(_FINDER_COLUMN_STORICORIUNIONE_ID_RIUNIONE_2);

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
			query.append(StoricoStatoRiunioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_riunione);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(storicoStatoRiunione);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StoricoStatoRiunione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the storico stato riuniones where id_riunione = &#63; from the database.
	 *
	 * @param id_riunione the id_riunione
	 */
	@Override
	public void removeByStoricoRiunione(long id_riunione) {
		for (StoricoStatoRiunione storicoStatoRiunione : findByStoricoRiunione(
				id_riunione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(storicoStatoRiunione);
		}
	}

	/**
	 * Returns the number of storico stato riuniones where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @return the number of matching storico stato riuniones
	 */
	@Override
	public int countByStoricoRiunione(long id_riunione) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STORICORIUNIONE;

		Object[] finderArgs = new Object[] { id_riunione };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STORICOSTATORIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_STORICORIUNIONE_ID_RIUNIONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_riunione);

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

	private static final String _FINDER_COLUMN_STORICORIUNIONE_ID_RIUNIONE_2 = "storicoStatoRiunione.id.id_riunione = ?";

	public StoricoStatoRiunionePersistenceImpl() {
		setModelClass(StoricoStatoRiunione.class);
	}

	/**
	 * Caches the storico stato riunione in the entity cache if it is enabled.
	 *
	 * @param storicoStatoRiunione the storico stato riunione
	 */
	@Override
	public void cacheResult(StoricoStatoRiunione storicoStatoRiunione) {
		entityCache.putResult(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneImpl.class,
			storicoStatoRiunione.getPrimaryKey(), storicoStatoRiunione);

		storicoStatoRiunione.resetOriginalValues();
	}

	/**
	 * Caches the storico stato riuniones in the entity cache if it is enabled.
	 *
	 * @param storicoStatoRiuniones the storico stato riuniones
	 */
	@Override
	public void cacheResult(List<StoricoStatoRiunione> storicoStatoRiuniones) {
		for (StoricoStatoRiunione storicoStatoRiunione : storicoStatoRiuniones) {
			if (entityCache.getResult(
						StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						StoricoStatoRiunioneImpl.class,
						storicoStatoRiunione.getPrimaryKey()) == null) {
				cacheResult(storicoStatoRiunione);
			}
			else {
				storicoStatoRiunione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all storico stato riuniones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StoricoStatoRiunioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the storico stato riunione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StoricoStatoRiunione storicoStatoRiunione) {
		entityCache.removeResult(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneImpl.class, storicoStatoRiunione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StoricoStatoRiunione> storicoStatoRiuniones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StoricoStatoRiunione storicoStatoRiunione : storicoStatoRiuniones) {
			entityCache.removeResult(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				StoricoStatoRiunioneImpl.class,
				storicoStatoRiunione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new storico stato riunione with the primary key. Does not add the storico stato riunione to the database.
	 *
	 * @param storicoStatoRiunionePK the primary key for the new storico stato riunione
	 * @return the new storico stato riunione
	 */
	@Override
	public StoricoStatoRiunione create(
		StoricoStatoRiunionePK storicoStatoRiunionePK) {
		StoricoStatoRiunione storicoStatoRiunione = new StoricoStatoRiunioneImpl();

		storicoStatoRiunione.setNew(true);
		storicoStatoRiunione.setPrimaryKey(storicoStatoRiunionePK);

		return storicoStatoRiunione;
	}

	/**
	 * Removes the storico stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param storicoStatoRiunionePK the primary key of the storico stato riunione
	 * @return the storico stato riunione that was removed
	 * @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	 */
	@Override
	public StoricoStatoRiunione remove(
		StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws NoSuchStoricoStatoRiunioneException {
		return remove((Serializable)storicoStatoRiunionePK);
	}

	/**
	 * Removes the storico stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the storico stato riunione
	 * @return the storico stato riunione that was removed
	 * @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	 */
	@Override
	public StoricoStatoRiunione remove(Serializable primaryKey)
		throws NoSuchStoricoStatoRiunioneException {
		Session session = null;

		try {
			session = openSession();

			StoricoStatoRiunione storicoStatoRiunione = (StoricoStatoRiunione)session.get(StoricoStatoRiunioneImpl.class,
					primaryKey);

			if (storicoStatoRiunione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStoricoStatoRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(storicoStatoRiunione);
		}
		catch (NoSuchStoricoStatoRiunioneException nsee) {
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
	protected StoricoStatoRiunione removeImpl(
		StoricoStatoRiunione storicoStatoRiunione) {
		storicoStatoRiunione = toUnwrappedModel(storicoStatoRiunione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(storicoStatoRiunione)) {
				storicoStatoRiunione = (StoricoStatoRiunione)session.get(StoricoStatoRiunioneImpl.class,
						storicoStatoRiunione.getPrimaryKeyObj());
			}

			if (storicoStatoRiunione != null) {
				session.delete(storicoStatoRiunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (storicoStatoRiunione != null) {
			clearCache(storicoStatoRiunione);
		}

		return storicoStatoRiunione;
	}

	@Override
	public StoricoStatoRiunione updateImpl(
		StoricoStatoRiunione storicoStatoRiunione) {
		storicoStatoRiunione = toUnwrappedModel(storicoStatoRiunione);

		boolean isNew = storicoStatoRiunione.isNew();

		StoricoStatoRiunioneModelImpl storicoStatoRiunioneModelImpl = (StoricoStatoRiunioneModelImpl)storicoStatoRiunione;

		Session session = null;

		try {
			session = openSession();

			if (storicoStatoRiunione.isNew()) {
				session.save(storicoStatoRiunione);

				storicoStatoRiunione.setNew(false);
			}
			else {
				storicoStatoRiunione = (StoricoStatoRiunione)session.merge(storicoStatoRiunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StoricoStatoRiunioneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((storicoStatoRiunioneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORICORIUNIONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						storicoStatoRiunioneModelImpl.getOriginalId_riunione()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STORICORIUNIONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORICORIUNIONE,
					args);

				args = new Object[] {
						storicoStatoRiunioneModelImpl.getId_riunione()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STORICORIUNIONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORICORIUNIONE,
					args);
			}
		}

		entityCache.putResult(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			StoricoStatoRiunioneImpl.class,
			storicoStatoRiunione.getPrimaryKey(), storicoStatoRiunione, false);

		storicoStatoRiunione.resetOriginalValues();

		return storicoStatoRiunione;
	}

	protected StoricoStatoRiunione toUnwrappedModel(
		StoricoStatoRiunione storicoStatoRiunione) {
		if (storicoStatoRiunione instanceof StoricoStatoRiunioneImpl) {
			return storicoStatoRiunione;
		}

		StoricoStatoRiunioneImpl storicoStatoRiunioneImpl = new StoricoStatoRiunioneImpl();

		storicoStatoRiunioneImpl.setNew(storicoStatoRiunione.isNew());
		storicoStatoRiunioneImpl.setPrimaryKey(storicoStatoRiunione.getPrimaryKey());

		storicoStatoRiunioneImpl.setId_riunione(storicoStatoRiunione.getId_riunione());
		storicoStatoRiunioneImpl.setId_storico(storicoStatoRiunione.getId_storico());
		storicoStatoRiunioneImpl.setData(storicoStatoRiunione.getData());
		storicoStatoRiunioneImpl.setId_stato_riunione(storicoStatoRiunione.getId_stato_riunione());

		return storicoStatoRiunioneImpl;
	}

	/**
	 * Returns the storico stato riunione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the storico stato riunione
	 * @return the storico stato riunione
	 * @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	 */
	@Override
	public StoricoStatoRiunione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStoricoStatoRiunioneException {
		StoricoStatoRiunione storicoStatoRiunione = fetchByPrimaryKey(primaryKey);

		if (storicoStatoRiunione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStoricoStatoRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return storicoStatoRiunione;
	}

	/**
	 * Returns the storico stato riunione with the primary key or throws a {@link NoSuchStoricoStatoRiunioneException} if it could not be found.
	 *
	 * @param storicoStatoRiunionePK the primary key of the storico stato riunione
	 * @return the storico stato riunione
	 * @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	 */
	@Override
	public StoricoStatoRiunione findByPrimaryKey(
		StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws NoSuchStoricoStatoRiunioneException {
		return findByPrimaryKey((Serializable)storicoStatoRiunionePK);
	}

	/**
	 * Returns the storico stato riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the storico stato riunione
	 * @return the storico stato riunione, or <code>null</code> if a storico stato riunione with the primary key could not be found
	 */
	@Override
	public StoricoStatoRiunione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				StoricoStatoRiunioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StoricoStatoRiunione storicoStatoRiunione = (StoricoStatoRiunione)serializable;

		if (storicoStatoRiunione == null) {
			Session session = null;

			try {
				session = openSession();

				storicoStatoRiunione = (StoricoStatoRiunione)session.get(StoricoStatoRiunioneImpl.class,
						primaryKey);

				if (storicoStatoRiunione != null) {
					cacheResult(storicoStatoRiunione);
				}
				else {
					entityCache.putResult(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						StoricoStatoRiunioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StoricoStatoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					StoricoStatoRiunioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return storicoStatoRiunione;
	}

	/**
	 * Returns the storico stato riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param storicoStatoRiunionePK the primary key of the storico stato riunione
	 * @return the storico stato riunione, or <code>null</code> if a storico stato riunione with the primary key could not be found
	 */
	@Override
	public StoricoStatoRiunione fetchByPrimaryKey(
		StoricoStatoRiunionePK storicoStatoRiunionePK) {
		return fetchByPrimaryKey((Serializable)storicoStatoRiunionePK);
	}

	@Override
	public Map<Serializable, StoricoStatoRiunione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StoricoStatoRiunione> map = new HashMap<Serializable, StoricoStatoRiunione>();

		for (Serializable primaryKey : primaryKeys) {
			StoricoStatoRiunione storicoStatoRiunione = fetchByPrimaryKey(primaryKey);

			if (storicoStatoRiunione != null) {
				map.put(primaryKey, storicoStatoRiunione);
			}
		}

		return map;
	}

	/**
	 * Returns all the storico stato riuniones.
	 *
	 * @return the storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the storico stato riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storico stato riuniones
	 * @param end the upper bound of the range of storico stato riuniones (not inclusive)
	 * @return the range of storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the storico stato riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storico stato riuniones
	 * @param end the upper bound of the range of storico stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findAll(int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the storico stato riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storico stato riuniones
	 * @param end the upper bound of the range of storico stato riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of storico stato riuniones
	 */
	@Override
	public List<StoricoStatoRiunione> findAll(int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator,
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

		List<StoricoStatoRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<StoricoStatoRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STORICOSTATORIUNIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STORICOSTATORIUNIONE;

				if (pagination) {
					sql = sql.concat(StoricoStatoRiunioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StoricoStatoRiunione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StoricoStatoRiunione>)QueryUtil.list(q,
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
	 * Removes all the storico stato riuniones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StoricoStatoRiunione storicoStatoRiunione : findAll()) {
			remove(storicoStatoRiunione);
		}
	}

	/**
	 * Returns the number of storico stato riuniones.
	 *
	 * @return the number of storico stato riuniones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STORICOSTATORIUNIONE);

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
		return StoricoStatoRiunioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the storico stato riunione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StoricoStatoRiunioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STORICOSTATORIUNIONE = "SELECT storicoStatoRiunione FROM StoricoStatoRiunione storicoStatoRiunione";
	private static final String _SQL_SELECT_STORICOSTATORIUNIONE_WHERE = "SELECT storicoStatoRiunione FROM StoricoStatoRiunione storicoStatoRiunione WHERE ";
	private static final String _SQL_COUNT_STORICOSTATORIUNIONE = "SELECT COUNT(storicoStatoRiunione) FROM StoricoStatoRiunione storicoStatoRiunione";
	private static final String _SQL_COUNT_STORICOSTATORIUNIONE_WHERE = "SELECT COUNT(storicoStatoRiunione) FROM StoricoStatoRiunione storicoStatoRiunione WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "storicoStatoRiunione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StoricoStatoRiunione exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StoricoStatoRiunione exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StoricoStatoRiunionePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"data"
			});
}