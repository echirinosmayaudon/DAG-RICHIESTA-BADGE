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

package servizio.richieste.badge.mef.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.richieste.badge.mef.exception.NoSuchStatoRichiestaException;
import servizio.richieste.badge.mef.model.StatoRichiesta;
import servizio.richieste.badge.mef.model.impl.StatoRichiestaImpl;
import servizio.richieste.badge.mef.model.impl.StatoRichiestaModelImpl;
import servizio.richieste.badge.mef.service.persistence.StatoRichiestaPersistence;

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
 * The persistence implementation for the stato richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichiestaPersistence
 * @see servizio.richieste.badge.mef.service.persistence.StatoRichiestaUtil
 * @generated
 */
@ProviderType
public class StatoRichiestaPersistenceImpl extends BasePersistenceImpl<StatoRichiesta>
	implements StatoRichiestaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatoRichiestaUtil} to access the stato richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatoRichiestaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaModelImpl.FINDER_CACHE_ENABLED,
			StatoRichiestaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaModelImpl.FINDER_CACHE_ENABLED,
			StatoRichiestaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIZIONE =
		new FinderPath(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaModelImpl.FINDER_CACHE_ENABLED,
			StatoRichiestaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydescrizione",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIZIONE =
		new FinderPath(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaModelImpl.FINDER_CACHE_ENABLED,
			StatoRichiestaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydescrizione",
			new String[] { String.class.getName() },
			StatoRichiestaModelImpl.DESCRIZIONE_STATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIZIONE = new FinderPath(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydescrizione",
			new String[] { String.class.getName() });

	/**
	 * Returns all the stato richiestas where descrizione_stato = &#63;.
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @return the matching stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findBydescrizione(String descrizione_stato) {
		return findBydescrizione(descrizione_stato, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato richiestas where descrizione_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @param start the lower bound of the range of stato richiestas
	 * @param end the upper bound of the range of stato richiestas (not inclusive)
	 * @return the range of matching stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findBydescrizione(String descrizione_stato,
		int start, int end) {
		return findBydescrizione(descrizione_stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato richiestas where descrizione_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @param start the lower bound of the range of stato richiestas
	 * @param end the upper bound of the range of stato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findBydescrizione(String descrizione_stato,
		int start, int end, OrderByComparator<StatoRichiesta> orderByComparator) {
		return findBydescrizione(descrizione_stato, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato richiestas where descrizione_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @param start the lower bound of the range of stato richiestas
	 * @param end the upper bound of the range of stato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findBydescrizione(String descrizione_stato,
		int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIZIONE;
			finderArgs = new Object[] { descrizione_stato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIZIONE;
			finderArgs = new Object[] {
					descrizione_stato,
					
					start, end, orderByComparator
				};
		}

		List<StatoRichiesta> list = null;

		if (retrieveFromCache) {
			list = (List<StatoRichiesta>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatoRichiesta statoRichiesta : list) {
					if (!Objects.equals(descrizione_stato,
								statoRichiesta.getDescrizione_stato())) {
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

			query.append(_SQL_SELECT_STATORICHIESTA_WHERE);

			boolean bindDescrizione_stato = false;

			if (descrizione_stato == null) {
				query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_1);
			}
			else if (descrizione_stato.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_3);
			}
			else {
				bindDescrizione_stato = true;

				query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescrizione_stato) {
					qPos.add(descrizione_stato);
				}

				if (!pagination) {
					list = (List<StatoRichiesta>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoRichiesta>)QueryUtil.list(q,
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
	 * Returns the first stato richiesta in the ordered set where descrizione_stato = &#63;.
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato richiesta
	 * @throws NoSuchStatoRichiestaException if a matching stato richiesta could not be found
	 */
	@Override
	public StatoRichiesta findBydescrizione_First(String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator)
		throws NoSuchStatoRichiestaException {
		StatoRichiesta statoRichiesta = fetchBydescrizione_First(descrizione_stato,
				orderByComparator);

		if (statoRichiesta != null) {
			return statoRichiesta;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("descrizione_stato=");
		msg.append(descrizione_stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatoRichiestaException(msg.toString());
	}

	/**
	 * Returns the first stato richiesta in the ordered set where descrizione_stato = &#63;.
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato richiesta, or <code>null</code> if a matching stato richiesta could not be found
	 */
	@Override
	public StatoRichiesta fetchBydescrizione_First(String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		List<StatoRichiesta> list = findBydescrizione(descrizione_stato, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato richiesta in the ordered set where descrizione_stato = &#63;.
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato richiesta
	 * @throws NoSuchStatoRichiestaException if a matching stato richiesta could not be found
	 */
	@Override
	public StatoRichiesta findBydescrizione_Last(String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator)
		throws NoSuchStatoRichiestaException {
		StatoRichiesta statoRichiesta = fetchBydescrizione_Last(descrizione_stato,
				orderByComparator);

		if (statoRichiesta != null) {
			return statoRichiesta;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("descrizione_stato=");
		msg.append(descrizione_stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatoRichiestaException(msg.toString());
	}

	/**
	 * Returns the last stato richiesta in the ordered set where descrizione_stato = &#63;.
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato richiesta, or <code>null</code> if a matching stato richiesta could not be found
	 */
	@Override
	public StatoRichiesta fetchBydescrizione_Last(String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		int count = countBydescrizione(descrizione_stato);

		if (count == 0) {
			return null;
		}

		List<StatoRichiesta> list = findBydescrizione(descrizione_stato,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato richiestas before and after the current stato richiesta in the ordered set where descrizione_stato = &#63;.
	 *
	 * @param id_stato the primary key of the current stato richiesta
	 * @param descrizione_stato the descrizione_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato richiesta
	 * @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	 */
	@Override
	public StatoRichiesta[] findBydescrizione_PrevAndNext(long id_stato,
		String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator)
		throws NoSuchStatoRichiestaException {
		StatoRichiesta statoRichiesta = findByPrimaryKey(id_stato);

		Session session = null;

		try {
			session = openSession();

			StatoRichiesta[] array = new StatoRichiestaImpl[3];

			array[0] = getBydescrizione_PrevAndNext(session, statoRichiesta,
					descrizione_stato, orderByComparator, true);

			array[1] = statoRichiesta;

			array[2] = getBydescrizione_PrevAndNext(session, statoRichiesta,
					descrizione_stato, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatoRichiesta getBydescrizione_PrevAndNext(Session session,
		StatoRichiesta statoRichiesta, String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATORICHIESTA_WHERE);

		boolean bindDescrizione_stato = false;

		if (descrizione_stato == null) {
			query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_1);
		}
		else if (descrizione_stato.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_3);
		}
		else {
			bindDescrizione_stato = true;

			query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_2);
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
			query.append(StatoRichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDescrizione_stato) {
			qPos.add(descrizione_stato);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statoRichiesta);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatoRichiesta> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato richiestas where descrizione_stato = &#63; from the database.
	 *
	 * @param descrizione_stato the descrizione_stato
	 */
	@Override
	public void removeBydescrizione(String descrizione_stato) {
		for (StatoRichiesta statoRichiesta : findBydescrizione(
				descrizione_stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statoRichiesta);
		}
	}

	/**
	 * Returns the number of stato richiestas where descrizione_stato = &#63;.
	 *
	 * @param descrizione_stato the descrizione_stato
	 * @return the number of matching stato richiestas
	 */
	@Override
	public int countBydescrizione(String descrizione_stato) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCRIZIONE;

		Object[] finderArgs = new Object[] { descrizione_stato };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATORICHIESTA_WHERE);

			boolean bindDescrizione_stato = false;

			if (descrizione_stato == null) {
				query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_1);
			}
			else if (descrizione_stato.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_3);
			}
			else {
				bindDescrizione_stato = true;

				query.append(_FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescrizione_stato) {
					qPos.add(descrizione_stato);
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

	private static final String _FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_1 = "statoRichiesta.descrizione_stato IS NULL";
	private static final String _FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_2 = "statoRichiesta.descrizione_stato = ?";
	private static final String _FINDER_COLUMN_DESCRIZIONE_DESCRIZIONE_STATO_3 = "(statoRichiesta.descrizione_stato IS NULL OR statoRichiesta.descrizione_stato = '')";

	public StatoRichiestaPersistenceImpl() {
		setModelClass(StatoRichiesta.class);
	}

	/**
	 * Caches the stato richiesta in the entity cache if it is enabled.
	 *
	 * @param statoRichiesta the stato richiesta
	 */
	@Override
	public void cacheResult(StatoRichiesta statoRichiesta) {
		entityCache.putResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaImpl.class, statoRichiesta.getPrimaryKey(),
			statoRichiesta);

		statoRichiesta.resetOriginalValues();
	}

	/**
	 * Caches the stato richiestas in the entity cache if it is enabled.
	 *
	 * @param statoRichiestas the stato richiestas
	 */
	@Override
	public void cacheResult(List<StatoRichiesta> statoRichiestas) {
		for (StatoRichiesta statoRichiesta : statoRichiestas) {
			if (entityCache.getResult(
						StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
						StatoRichiestaImpl.class, statoRichiesta.getPrimaryKey()) == null) {
				cacheResult(statoRichiesta);
			}
			else {
				statoRichiesta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stato richiestas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoRichiestaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stato richiesta.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatoRichiesta statoRichiesta) {
		entityCache.removeResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaImpl.class, statoRichiesta.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatoRichiesta> statoRichiestas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatoRichiesta statoRichiesta : statoRichiestas) {
			entityCache.removeResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
				StatoRichiestaImpl.class, statoRichiesta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stato richiesta with the primary key. Does not add the stato richiesta to the database.
	 *
	 * @param id_stato the primary key for the new stato richiesta
	 * @return the new stato richiesta
	 */
	@Override
	public StatoRichiesta create(long id_stato) {
		StatoRichiesta statoRichiesta = new StatoRichiestaImpl();

		statoRichiesta.setNew(true);
		statoRichiesta.setPrimaryKey(id_stato);

		return statoRichiesta;
	}

	/**
	 * Removes the stato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_stato the primary key of the stato richiesta
	 * @return the stato richiesta that was removed
	 * @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	 */
	@Override
	public StatoRichiesta remove(long id_stato)
		throws NoSuchStatoRichiestaException {
		return remove((Serializable)id_stato);
	}

	/**
	 * Removes the stato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato richiesta
	 * @return the stato richiesta that was removed
	 * @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	 */
	@Override
	public StatoRichiesta remove(Serializable primaryKey)
		throws NoSuchStatoRichiestaException {
		Session session = null;

		try {
			session = openSession();

			StatoRichiesta statoRichiesta = (StatoRichiesta)session.get(StatoRichiestaImpl.class,
					primaryKey);

			if (statoRichiesta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoRichiestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statoRichiesta);
		}
		catch (NoSuchStatoRichiestaException nsee) {
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
	protected StatoRichiesta removeImpl(StatoRichiesta statoRichiesta) {
		statoRichiesta = toUnwrappedModel(statoRichiesta);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statoRichiesta)) {
				statoRichiesta = (StatoRichiesta)session.get(StatoRichiestaImpl.class,
						statoRichiesta.getPrimaryKeyObj());
			}

			if (statoRichiesta != null) {
				session.delete(statoRichiesta);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statoRichiesta != null) {
			clearCache(statoRichiesta);
		}

		return statoRichiesta;
	}

	@Override
	public StatoRichiesta updateImpl(StatoRichiesta statoRichiesta) {
		statoRichiesta = toUnwrappedModel(statoRichiesta);

		boolean isNew = statoRichiesta.isNew();

		StatoRichiestaModelImpl statoRichiestaModelImpl = (StatoRichiestaModelImpl)statoRichiesta;

		Session session = null;

		try {
			session = openSession();

			if (statoRichiesta.isNew()) {
				session.save(statoRichiesta);

				statoRichiesta.setNew(false);
			}
			else {
				statoRichiesta = (StatoRichiesta)session.merge(statoRichiesta);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatoRichiestaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statoRichiestaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIZIONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statoRichiestaModelImpl.getOriginalDescrizione_stato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIZIONE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIZIONE,
					args);

				args = new Object[] {
						statoRichiestaModelImpl.getDescrizione_stato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIZIONE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIZIONE,
					args);
			}
		}

		entityCache.putResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichiestaImpl.class, statoRichiesta.getPrimaryKey(),
			statoRichiesta, false);

		statoRichiesta.resetOriginalValues();

		return statoRichiesta;
	}

	protected StatoRichiesta toUnwrappedModel(StatoRichiesta statoRichiesta) {
		if (statoRichiesta instanceof StatoRichiestaImpl) {
			return statoRichiesta;
		}

		StatoRichiestaImpl statoRichiestaImpl = new StatoRichiestaImpl();

		statoRichiestaImpl.setNew(statoRichiesta.isNew());
		statoRichiestaImpl.setPrimaryKey(statoRichiesta.getPrimaryKey());

		statoRichiestaImpl.setId_stato(statoRichiesta.getId_stato());
		statoRichiestaImpl.setDescrizione_stato(statoRichiesta.getDescrizione_stato());

		return statoRichiestaImpl;
	}

	/**
	 * Returns the stato richiesta with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato richiesta
	 * @return the stato richiesta
	 * @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	 */
	@Override
	public StatoRichiesta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoRichiestaException {
		StatoRichiesta statoRichiesta = fetchByPrimaryKey(primaryKey);

		if (statoRichiesta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoRichiestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statoRichiesta;
	}

	/**
	 * Returns the stato richiesta with the primary key or throws a {@link NoSuchStatoRichiestaException} if it could not be found.
	 *
	 * @param id_stato the primary key of the stato richiesta
	 * @return the stato richiesta
	 * @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	 */
	@Override
	public StatoRichiesta findByPrimaryKey(long id_stato)
		throws NoSuchStatoRichiestaException {
		return findByPrimaryKey((Serializable)id_stato);
	}

	/**
	 * Returns the stato richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato richiesta
	 * @return the stato richiesta, or <code>null</code> if a stato richiesta with the primary key could not be found
	 */
	@Override
	public StatoRichiesta fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
				StatoRichiestaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StatoRichiesta statoRichiesta = (StatoRichiesta)serializable;

		if (statoRichiesta == null) {
			Session session = null;

			try {
				session = openSession();

				statoRichiesta = (StatoRichiesta)session.get(StatoRichiestaImpl.class,
						primaryKey);

				if (statoRichiesta != null) {
					cacheResult(statoRichiesta);
				}
				else {
					entityCache.putResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
						StatoRichiestaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
					StatoRichiestaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statoRichiesta;
	}

	/**
	 * Returns the stato richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_stato the primary key of the stato richiesta
	 * @return the stato richiesta, or <code>null</code> if a stato richiesta with the primary key could not be found
	 */
	@Override
	public StatoRichiesta fetchByPrimaryKey(long id_stato) {
		return fetchByPrimaryKey((Serializable)id_stato);
	}

	@Override
	public Map<Serializable, StatoRichiesta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StatoRichiesta> map = new HashMap<Serializable, StatoRichiesta>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StatoRichiesta statoRichiesta = fetchByPrimaryKey(primaryKey);

			if (statoRichiesta != null) {
				map.put(primaryKey, statoRichiesta);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
					StatoRichiestaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StatoRichiesta)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STATORICHIESTA_WHERE_PKS_IN);

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

			for (StatoRichiesta statoRichiesta : (List<StatoRichiesta>)q.list()) {
				map.put(statoRichiesta.getPrimaryKeyObj(), statoRichiesta);

				cacheResult(statoRichiesta);

				uncachedPrimaryKeys.remove(statoRichiesta.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StatoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
					StatoRichiestaImpl.class, primaryKey, nullModel);
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
	 * Returns all the stato richiestas.
	 *
	 * @return the stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato richiestas
	 * @param end the upper bound of the range of stato richiestas (not inclusive)
	 * @return the range of stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato richiestas
	 * @param end the upper bound of the range of stato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findAll(int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato richiestas
	 * @param end the upper bound of the range of stato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stato richiestas
	 */
	@Override
	public List<StatoRichiesta> findAll(int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator,
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

		List<StatoRichiesta> list = null;

		if (retrieveFromCache) {
			list = (List<StatoRichiesta>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATORICHIESTA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATORICHIESTA;

				if (pagination) {
					sql = sql.concat(StatoRichiestaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatoRichiesta>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoRichiesta>)QueryUtil.list(q,
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
	 * Removes all the stato richiestas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatoRichiesta statoRichiesta : findAll()) {
			remove(statoRichiesta);
		}
	}

	/**
	 * Returns the number of stato richiestas.
	 *
	 * @return the number of stato richiestas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATORICHIESTA);

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
		return StatoRichiestaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato richiesta persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StatoRichiestaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STATORICHIESTA = "SELECT statoRichiesta FROM StatoRichiesta statoRichiesta";
	private static final String _SQL_SELECT_STATORICHIESTA_WHERE_PKS_IN = "SELECT statoRichiesta FROM StatoRichiesta statoRichiesta WHERE id_stato IN (";
	private static final String _SQL_SELECT_STATORICHIESTA_WHERE = "SELECT statoRichiesta FROM StatoRichiesta statoRichiesta WHERE ";
	private static final String _SQL_COUNT_STATORICHIESTA = "SELECT COUNT(statoRichiesta) FROM StatoRichiesta statoRichiesta";
	private static final String _SQL_COUNT_STATORICHIESTA_WHERE = "SELECT COUNT(statoRichiesta) FROM StatoRichiesta statoRichiesta WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statoRichiesta.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatoRichiesta exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatoRichiesta exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StatoRichiestaPersistenceImpl.class);
}