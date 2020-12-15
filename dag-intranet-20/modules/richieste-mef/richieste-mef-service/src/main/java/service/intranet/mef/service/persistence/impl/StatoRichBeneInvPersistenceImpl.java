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

package service.intranet.mef.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import service.intranet.mef.exception.NoSuchStatoRichBeneInvException;
import service.intranet.mef.model.StatoRichBeneInv;
import service.intranet.mef.model.impl.StatoRichBeneInvImpl;
import service.intranet.mef.model.impl.StatoRichBeneInvModelImpl;
import service.intranet.mef.service.persistence.StatoRichBeneInvPersistence;

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
 * The persistence implementation for the stato rich bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichBeneInvPersistence
 * @see service.intranet.mef.service.persistence.StatoRichBeneInvUtil
 * @generated
 */
@ProviderType
public class StatoRichBeneInvPersistenceImpl extends BasePersistenceImpl<StatoRichBeneInv>
	implements StatoRichBeneInvPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatoRichBeneInvUtil} to access the stato rich bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatoRichBeneInvImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvModelImpl.FINDER_CACHE_ENABLED,
			StatoRichBeneInvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvModelImpl.FINDER_CACHE_ENABLED,
			StatoRichBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOMESTATO =
		new FinderPath(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvModelImpl.FINDER_CACHE_ENABLED,
			StatoRichBeneInvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNomeStato",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOMESTATO =
		new FinderPath(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvModelImpl.FINDER_CACHE_ENABLED,
			StatoRichBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeStato",
			new String[] { String.class.getName() },
			StatoRichBeneInvModelImpl.STATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOMESTATO = new FinderPath(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeStato",
			new String[] { String.class.getName() });

	/**
	 * Returns all the stato rich bene invs where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findByNomeStato(String stato) {
		return findByNomeStato(stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato rich bene invs where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of stato rich bene invs
	 * @param end the upper bound of the range of stato rich bene invs (not inclusive)
	 * @return the range of matching stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findByNomeStato(String stato, int start,
		int end) {
		return findByNomeStato(stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato rich bene invs where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of stato rich bene invs
	 * @param end the upper bound of the range of stato rich bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findByNomeStato(String stato, int start,
		int end, OrderByComparator<StatoRichBeneInv> orderByComparator) {
		return findByNomeStato(stato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato rich bene invs where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of stato rich bene invs
	 * @param end the upper bound of the range of stato rich bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findByNomeStato(String stato, int start,
		int end, OrderByComparator<StatoRichBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOMESTATO;
			finderArgs = new Object[] { stato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOMESTATO;
			finderArgs = new Object[] { stato, start, end, orderByComparator };
		}

		List<StatoRichBeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<StatoRichBeneInv>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatoRichBeneInv statoRichBeneInv : list) {
					if (!Objects.equals(stato, statoRichBeneInv.getStato())) {
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

			query.append(_SQL_SELECT_STATORICHBENEINV_WHERE);

			boolean bindStato = false;

			if (stato == null) {
				query.append(_FINDER_COLUMN_NOMESTATO_STATO_1);
			}
			else if (stato.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOMESTATO_STATO_3);
			}
			else {
				bindStato = true;

				query.append(_FINDER_COLUMN_NOMESTATO_STATO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatoRichBeneInvModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStato) {
					qPos.add(stato);
				}

				if (!pagination) {
					list = (List<StatoRichBeneInv>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoRichBeneInv>)QueryUtil.list(q,
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
	 * Returns the first stato rich bene inv in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato rich bene inv
	 * @throws NoSuchStatoRichBeneInvException if a matching stato rich bene inv could not be found
	 */
	@Override
	public StatoRichBeneInv findByNomeStato_First(String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws NoSuchStatoRichBeneInvException {
		StatoRichBeneInv statoRichBeneInv = fetchByNomeStato_First(stato,
				orderByComparator);

		if (statoRichBeneInv != null) {
			return statoRichBeneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stato=");
		msg.append(stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatoRichBeneInvException(msg.toString());
	}

	/**
	 * Returns the first stato rich bene inv in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato rich bene inv, or <code>null</code> if a matching stato rich bene inv could not be found
	 */
	@Override
	public StatoRichBeneInv fetchByNomeStato_First(String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		List<StatoRichBeneInv> list = findByNomeStato(stato, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato rich bene inv in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato rich bene inv
	 * @throws NoSuchStatoRichBeneInvException if a matching stato rich bene inv could not be found
	 */
	@Override
	public StatoRichBeneInv findByNomeStato_Last(String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws NoSuchStatoRichBeneInvException {
		StatoRichBeneInv statoRichBeneInv = fetchByNomeStato_Last(stato,
				orderByComparator);

		if (statoRichBeneInv != null) {
			return statoRichBeneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stato=");
		msg.append(stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatoRichBeneInvException(msg.toString());
	}

	/**
	 * Returns the last stato rich bene inv in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato rich bene inv, or <code>null</code> if a matching stato rich bene inv could not be found
	 */
	@Override
	public StatoRichBeneInv fetchByNomeStato_Last(String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		int count = countByNomeStato(stato);

		if (count == 0) {
			return null;
		}

		List<StatoRichBeneInv> list = findByNomeStato(stato, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato rich bene invs before and after the current stato rich bene inv in the ordered set where stato = &#63;.
	 *
	 * @param id the primary key of the current stato rich bene inv
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato rich bene inv
	 * @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	 */
	@Override
	public StatoRichBeneInv[] findByNomeStato_PrevAndNext(long id,
		String stato, OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws NoSuchStatoRichBeneInvException {
		StatoRichBeneInv statoRichBeneInv = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatoRichBeneInv[] array = new StatoRichBeneInvImpl[3];

			array[0] = getByNomeStato_PrevAndNext(session, statoRichBeneInv,
					stato, orderByComparator, true);

			array[1] = statoRichBeneInv;

			array[2] = getByNomeStato_PrevAndNext(session, statoRichBeneInv,
					stato, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatoRichBeneInv getByNomeStato_PrevAndNext(Session session,
		StatoRichBeneInv statoRichBeneInv, String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATORICHBENEINV_WHERE);

		boolean bindStato = false;

		if (stato == null) {
			query.append(_FINDER_COLUMN_NOMESTATO_STATO_1);
		}
		else if (stato.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOMESTATO_STATO_3);
		}
		else {
			bindStato = true;

			query.append(_FINDER_COLUMN_NOMESTATO_STATO_2);
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
			query.append(StatoRichBeneInvModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStato) {
			qPos.add(stato);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statoRichBeneInv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatoRichBeneInv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato rich bene invs where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	@Override
	public void removeByNomeStato(String stato) {
		for (StatoRichBeneInv statoRichBeneInv : findByNomeStato(stato,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statoRichBeneInv);
		}
	}

	/**
	 * Returns the number of stato rich bene invs where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching stato rich bene invs
	 */
	@Override
	public int countByNomeStato(String stato) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOMESTATO;

		Object[] finderArgs = new Object[] { stato };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATORICHBENEINV_WHERE);

			boolean bindStato = false;

			if (stato == null) {
				query.append(_FINDER_COLUMN_NOMESTATO_STATO_1);
			}
			else if (stato.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOMESTATO_STATO_3);
			}
			else {
				bindStato = true;

				query.append(_FINDER_COLUMN_NOMESTATO_STATO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStato) {
					qPos.add(stato);
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

	private static final String _FINDER_COLUMN_NOMESTATO_STATO_1 = "statoRichBeneInv.stato IS NULL";
	private static final String _FINDER_COLUMN_NOMESTATO_STATO_2 = "statoRichBeneInv.stato = ?";
	private static final String _FINDER_COLUMN_NOMESTATO_STATO_3 = "(statoRichBeneInv.stato IS NULL OR statoRichBeneInv.stato = '')";

	public StatoRichBeneInvPersistenceImpl() {
		setModelClass(StatoRichBeneInv.class);
	}

	/**
	 * Caches the stato rich bene inv in the entity cache if it is enabled.
	 *
	 * @param statoRichBeneInv the stato rich bene inv
	 */
	@Override
	public void cacheResult(StatoRichBeneInv statoRichBeneInv) {
		entityCache.putResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvImpl.class, statoRichBeneInv.getPrimaryKey(),
			statoRichBeneInv);

		statoRichBeneInv.resetOriginalValues();
	}

	/**
	 * Caches the stato rich bene invs in the entity cache if it is enabled.
	 *
	 * @param statoRichBeneInvs the stato rich bene invs
	 */
	@Override
	public void cacheResult(List<StatoRichBeneInv> statoRichBeneInvs) {
		for (StatoRichBeneInv statoRichBeneInv : statoRichBeneInvs) {
			if (entityCache.getResult(
						StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
						StatoRichBeneInvImpl.class,
						statoRichBeneInv.getPrimaryKey()) == null) {
				cacheResult(statoRichBeneInv);
			}
			else {
				statoRichBeneInv.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stato rich bene invs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoRichBeneInvImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stato rich bene inv.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatoRichBeneInv statoRichBeneInv) {
		entityCache.removeResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvImpl.class, statoRichBeneInv.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatoRichBeneInv> statoRichBeneInvs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatoRichBeneInv statoRichBeneInv : statoRichBeneInvs) {
			entityCache.removeResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
				StatoRichBeneInvImpl.class, statoRichBeneInv.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stato rich bene inv with the primary key. Does not add the stato rich bene inv to the database.
	 *
	 * @param id the primary key for the new stato rich bene inv
	 * @return the new stato rich bene inv
	 */
	@Override
	public StatoRichBeneInv create(long id) {
		StatoRichBeneInv statoRichBeneInv = new StatoRichBeneInvImpl();

		statoRichBeneInv.setNew(true);
		statoRichBeneInv.setPrimaryKey(id);

		return statoRichBeneInv;
	}

	/**
	 * Removes the stato rich bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stato rich bene inv
	 * @return the stato rich bene inv that was removed
	 * @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	 */
	@Override
	public StatoRichBeneInv remove(long id)
		throws NoSuchStatoRichBeneInvException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stato rich bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato rich bene inv
	 * @return the stato rich bene inv that was removed
	 * @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	 */
	@Override
	public StatoRichBeneInv remove(Serializable primaryKey)
		throws NoSuchStatoRichBeneInvException {
		Session session = null;

		try {
			session = openSession();

			StatoRichBeneInv statoRichBeneInv = (StatoRichBeneInv)session.get(StatoRichBeneInvImpl.class,
					primaryKey);

			if (statoRichBeneInv == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoRichBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statoRichBeneInv);
		}
		catch (NoSuchStatoRichBeneInvException nsee) {
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
	protected StatoRichBeneInv removeImpl(StatoRichBeneInv statoRichBeneInv) {
		statoRichBeneInv = toUnwrappedModel(statoRichBeneInv);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statoRichBeneInv)) {
				statoRichBeneInv = (StatoRichBeneInv)session.get(StatoRichBeneInvImpl.class,
						statoRichBeneInv.getPrimaryKeyObj());
			}

			if (statoRichBeneInv != null) {
				session.delete(statoRichBeneInv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statoRichBeneInv != null) {
			clearCache(statoRichBeneInv);
		}

		return statoRichBeneInv;
	}

	@Override
	public StatoRichBeneInv updateImpl(StatoRichBeneInv statoRichBeneInv) {
		statoRichBeneInv = toUnwrappedModel(statoRichBeneInv);

		boolean isNew = statoRichBeneInv.isNew();

		StatoRichBeneInvModelImpl statoRichBeneInvModelImpl = (StatoRichBeneInvModelImpl)statoRichBeneInv;

		Session session = null;

		try {
			session = openSession();

			if (statoRichBeneInv.isNew()) {
				session.save(statoRichBeneInv);

				statoRichBeneInv.setNew(false);
			}
			else {
				statoRichBeneInv = (StatoRichBeneInv)session.merge(statoRichBeneInv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatoRichBeneInvModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statoRichBeneInvModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOMESTATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statoRichBeneInvModelImpl.getOriginalStato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NOMESTATO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOMESTATO,
					args);

				args = new Object[] { statoRichBeneInvModelImpl.getStato() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NOMESTATO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOMESTATO,
					args);
			}
		}

		entityCache.putResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			StatoRichBeneInvImpl.class, statoRichBeneInv.getPrimaryKey(),
			statoRichBeneInv, false);

		statoRichBeneInv.resetOriginalValues();

		return statoRichBeneInv;
	}

	protected StatoRichBeneInv toUnwrappedModel(
		StatoRichBeneInv statoRichBeneInv) {
		if (statoRichBeneInv instanceof StatoRichBeneInvImpl) {
			return statoRichBeneInv;
		}

		StatoRichBeneInvImpl statoRichBeneInvImpl = new StatoRichBeneInvImpl();

		statoRichBeneInvImpl.setNew(statoRichBeneInv.isNew());
		statoRichBeneInvImpl.setPrimaryKey(statoRichBeneInv.getPrimaryKey());

		statoRichBeneInvImpl.setId(statoRichBeneInv.getId());
		statoRichBeneInvImpl.setStato(statoRichBeneInv.getStato());

		return statoRichBeneInvImpl;
	}

	/**
	 * Returns the stato rich bene inv with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato rich bene inv
	 * @return the stato rich bene inv
	 * @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	 */
	@Override
	public StatoRichBeneInv findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoRichBeneInvException {
		StatoRichBeneInv statoRichBeneInv = fetchByPrimaryKey(primaryKey);

		if (statoRichBeneInv == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoRichBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statoRichBeneInv;
	}

	/**
	 * Returns the stato rich bene inv with the primary key or throws a {@link NoSuchStatoRichBeneInvException} if it could not be found.
	 *
	 * @param id the primary key of the stato rich bene inv
	 * @return the stato rich bene inv
	 * @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	 */
	@Override
	public StatoRichBeneInv findByPrimaryKey(long id)
		throws NoSuchStatoRichBeneInvException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stato rich bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato rich bene inv
	 * @return the stato rich bene inv, or <code>null</code> if a stato rich bene inv with the primary key could not be found
	 */
	@Override
	public StatoRichBeneInv fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
				StatoRichBeneInvImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StatoRichBeneInv statoRichBeneInv = (StatoRichBeneInv)serializable;

		if (statoRichBeneInv == null) {
			Session session = null;

			try {
				session = openSession();

				statoRichBeneInv = (StatoRichBeneInv)session.get(StatoRichBeneInvImpl.class,
						primaryKey);

				if (statoRichBeneInv != null) {
					cacheResult(statoRichBeneInv);
				}
				else {
					entityCache.putResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
						StatoRichBeneInvImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					StatoRichBeneInvImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statoRichBeneInv;
	}

	/**
	 * Returns the stato rich bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stato rich bene inv
	 * @return the stato rich bene inv, or <code>null</code> if a stato rich bene inv with the primary key could not be found
	 */
	@Override
	public StatoRichBeneInv fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, StatoRichBeneInv> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StatoRichBeneInv> map = new HashMap<Serializable, StatoRichBeneInv>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StatoRichBeneInv statoRichBeneInv = fetchByPrimaryKey(primaryKey);

			if (statoRichBeneInv != null) {
				map.put(primaryKey, statoRichBeneInv);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					StatoRichBeneInvImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StatoRichBeneInv)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STATORICHBENEINV_WHERE_PKS_IN);

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

			for (StatoRichBeneInv statoRichBeneInv : (List<StatoRichBeneInv>)q.list()) {
				map.put(statoRichBeneInv.getPrimaryKeyObj(), statoRichBeneInv);

				cacheResult(statoRichBeneInv);

				uncachedPrimaryKeys.remove(statoRichBeneInv.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StatoRichBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					StatoRichBeneInvImpl.class, primaryKey, nullModel);
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
	 * Returns all the stato rich bene invs.
	 *
	 * @return the stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato rich bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato rich bene invs
	 * @param end the upper bound of the range of stato rich bene invs (not inclusive)
	 * @return the range of stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato rich bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato rich bene invs
	 * @param end the upper bound of the range of stato rich bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findAll(int start, int end,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato rich bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato rich bene invs
	 * @param end the upper bound of the range of stato rich bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stato rich bene invs
	 */
	@Override
	public List<StatoRichBeneInv> findAll(int start, int end,
		OrderByComparator<StatoRichBeneInv> orderByComparator,
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

		List<StatoRichBeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<StatoRichBeneInv>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATORICHBENEINV);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATORICHBENEINV;

				if (pagination) {
					sql = sql.concat(StatoRichBeneInvModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatoRichBeneInv>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoRichBeneInv>)QueryUtil.list(q,
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
	 * Removes all the stato rich bene invs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatoRichBeneInv statoRichBeneInv : findAll()) {
			remove(statoRichBeneInv);
		}
	}

	/**
	 * Returns the number of stato rich bene invs.
	 *
	 * @return the number of stato rich bene invs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATORICHBENEINV);

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
		return StatoRichBeneInvModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato rich bene inv persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StatoRichBeneInvImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STATORICHBENEINV = "SELECT statoRichBeneInv FROM StatoRichBeneInv statoRichBeneInv";
	private static final String _SQL_SELECT_STATORICHBENEINV_WHERE_PKS_IN = "SELECT statoRichBeneInv FROM StatoRichBeneInv statoRichBeneInv WHERE id_ IN (";
	private static final String _SQL_SELECT_STATORICHBENEINV_WHERE = "SELECT statoRichBeneInv FROM StatoRichBeneInv statoRichBeneInv WHERE ";
	private static final String _SQL_COUNT_STATORICHBENEINV = "SELECT COUNT(statoRichBeneInv) FROM StatoRichBeneInv statoRichBeneInv";
	private static final String _SQL_COUNT_STATORICHBENEINV_WHERE = "SELECT COUNT(statoRichBeneInv) FROM StatoRichBeneInv statoRichBeneInv WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statoRichBeneInv.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatoRichBeneInv exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatoRichBeneInv exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StatoRichBeneInvPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}