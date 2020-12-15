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

import com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneImpl;
import com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePersistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the invitati riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunioneUtil
 * @generated
 */
@ProviderType
public class InvitatiRiunionePersistenceImpl extends BasePersistenceImpl<InvitatiRiunione>
	implements InvitatiRiunionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InvitatiRiunioneUtil} to access the invitati riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InvitatiRiunioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RIUNIONE = new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRiunione",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RIUNIONE =
		new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRiunione",
			new String[] { Long.class.getName() },
			InvitatiRiunioneModelImpl.ID_RIUNIONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RIUNIONE = new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRiunione",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invitati riuniones where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @return the matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findByRiunione(long id_riunione) {
		return findByRiunione(id_riunione, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitati riuniones where id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @return the range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findByRiunione(long id_riunione, int start,
		int end) {
		return findByRiunione(id_riunione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findByRiunione(long id_riunione, int start,
		int end, OrderByComparator<InvitatiRiunione> orderByComparator) {
		return findByRiunione(id_riunione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findByRiunione(long id_riunione, int start,
		int end, OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RIUNIONE;
			finderArgs = new Object[] { id_riunione };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RIUNIONE;
			finderArgs = new Object[] { id_riunione, start, end, orderByComparator };
		}

		List<InvitatiRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<InvitatiRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InvitatiRiunione invitatiRiunione : list) {
					if ((id_riunione != invitatiRiunione.getId_riunione())) {
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

			query.append(_SQL_SELECT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_RIUNIONE_ID_RIUNIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_riunione);

				if (!pagination) {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
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
	 * Returns the first invitati riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione findByRiunione_First(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = fetchByRiunione_First(id_riunione,
				orderByComparator);

		if (invitatiRiunione != null) {
			return invitatiRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_riunione=");
		msg.append(id_riunione);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitatiRiunioneException(msg.toString());
	}

	/**
	 * Returns the first invitati riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione fetchByRiunione_First(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		List<InvitatiRiunione> list = findByRiunione(id_riunione, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invitati riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione findByRiunione_Last(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = fetchByRiunione_Last(id_riunione,
				orderByComparator);

		if (invitatiRiunione != null) {
			return invitatiRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_riunione=");
		msg.append(id_riunione);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitatiRiunioneException(msg.toString());
	}

	/**
	 * Returns the last invitati riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione fetchByRiunione_Last(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		int count = countByRiunione(id_riunione);

		if (count == 0) {
			return null;
		}

		List<InvitatiRiunione> list = findByRiunione(id_riunione, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_riunione = &#63;.
	 *
	 * @param invitatiRiunionePK the primary key of the current invitati riunione
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione[] findByRiunione_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = findByPrimaryKey(invitatiRiunionePK);

		Session session = null;

		try {
			session = openSession();

			InvitatiRiunione[] array = new InvitatiRiunioneImpl[3];

			array[0] = getByRiunione_PrevAndNext(session, invitatiRiunione,
					id_riunione, orderByComparator, true);

			array[1] = invitatiRiunione;

			array[2] = getByRiunione_PrevAndNext(session, invitatiRiunione,
					id_riunione, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InvitatiRiunione getByRiunione_PrevAndNext(Session session,
		InvitatiRiunione invitatiRiunione, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVITATIRIUNIONE_WHERE);

		query.append(_FINDER_COLUMN_RIUNIONE_ID_RIUNIONE_2);

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
			query.append(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_riunione);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invitatiRiunione);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InvitatiRiunione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invitati riuniones where id_riunione = &#63; from the database.
	 *
	 * @param id_riunione the id_riunione
	 */
	@Override
	public void removeByRiunione(long id_riunione) {
		for (InvitatiRiunione invitatiRiunione : findByRiunione(id_riunione,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(invitatiRiunione);
		}
	}

	/**
	 * Returns the number of invitati riuniones where id_riunione = &#63;.
	 *
	 * @param id_riunione the id_riunione
	 * @return the number of matching invitati riuniones
	 */
	@Override
	public int countByRiunione(long id_riunione) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RIUNIONE;

		Object[] finderArgs = new Object[] { id_riunione };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_RIUNIONE_ID_RIUNIONE_2);

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

	private static final String _FINDER_COLUMN_RIUNIONE_ID_RIUNIONE_2 = "invitatiRiunione.id.id_riunione = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGRETERIA =
		new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySegreteria",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIA =
		new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySegreteria",
			new String[] { Long.class.getName() },
			InvitatiRiunioneModelImpl.ID_SEGRETERIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEGRETERIA = new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySegreteria",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invitati riuniones where id_segreteria = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @return the matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteria(long id_segreteria) {
		return findBySegreteria(id_segreteria, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitati riuniones where id_segreteria = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @return the range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteria(long id_segreteria,
		int start, int end) {
		return findBySegreteria(id_segreteria, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_segreteria = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteria(long id_segreteria,
		int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return findBySegreteria(id_segreteria, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_segreteria = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteria(long id_segreteria,
		int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIA;
			finderArgs = new Object[] { id_segreteria };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGRETERIA;
			finderArgs = new Object[] {
					id_segreteria,
					
					start, end, orderByComparator
				};
		}

		List<InvitatiRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<InvitatiRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InvitatiRiunione invitatiRiunione : list) {
					if ((id_segreteria != invitatiRiunione.getId_segreteria())) {
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

			query.append(_SQL_SELECT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_SEGRETERIA_ID_SEGRETERIA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_segreteria);

				if (!pagination) {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
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
	 * Returns the first invitati riunione in the ordered set where id_segreteria = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione findBySegreteria_First(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = fetchBySegreteria_First(id_segreteria,
				orderByComparator);

		if (invitatiRiunione != null) {
			return invitatiRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_segreteria=");
		msg.append(id_segreteria);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitatiRiunioneException(msg.toString());
	}

	/**
	 * Returns the first invitati riunione in the ordered set where id_segreteria = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione fetchBySegreteria_First(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		List<InvitatiRiunione> list = findBySegreteria(id_segreteria, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invitati riunione in the ordered set where id_segreteria = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione findBySegreteria_Last(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = fetchBySegreteria_Last(id_segreteria,
				orderByComparator);

		if (invitatiRiunione != null) {
			return invitatiRiunione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_segreteria=");
		msg.append(id_segreteria);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitatiRiunioneException(msg.toString());
	}

	/**
	 * Returns the last invitati riunione in the ordered set where id_segreteria = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione fetchBySegreteria_Last(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		int count = countBySegreteria(id_segreteria);

		if (count == 0) {
			return null;
		}

		List<InvitatiRiunione> list = findBySegreteria(id_segreteria,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_segreteria = &#63;.
	 *
	 * @param invitatiRiunionePK the primary key of the current invitati riunione
	 * @param id_segreteria the id_segreteria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione[] findBySegreteria_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = findByPrimaryKey(invitatiRiunionePK);

		Session session = null;

		try {
			session = openSession();

			InvitatiRiunione[] array = new InvitatiRiunioneImpl[3];

			array[0] = getBySegreteria_PrevAndNext(session, invitatiRiunione,
					id_segreteria, orderByComparator, true);

			array[1] = invitatiRiunione;

			array[2] = getBySegreteria_PrevAndNext(session, invitatiRiunione,
					id_segreteria, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InvitatiRiunione getBySegreteria_PrevAndNext(Session session,
		InvitatiRiunione invitatiRiunione, long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVITATIRIUNIONE_WHERE);

		query.append(_FINDER_COLUMN_SEGRETERIA_ID_SEGRETERIA_2);

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
			query.append(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_segreteria);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invitatiRiunione);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InvitatiRiunione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invitati riuniones where id_segreteria = &#63; from the database.
	 *
	 * @param id_segreteria the id_segreteria
	 */
	@Override
	public void removeBySegreteria(long id_segreteria) {
		for (InvitatiRiunione invitatiRiunione : findBySegreteria(
				id_segreteria, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(invitatiRiunione);
		}
	}

	/**
	 * Returns the number of invitati riuniones where id_segreteria = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @return the number of matching invitati riuniones
	 */
	@Override
	public int countBySegreteria(long id_segreteria) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEGRETERIA;

		Object[] finderArgs = new Object[] { id_segreteria };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_SEGRETERIA_ID_SEGRETERIA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_segreteria);

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

	private static final String _FINDER_COLUMN_SEGRETERIA_ID_SEGRETERIA_2 = "invitatiRiunione.id.id_segreteria = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGRETERIARIUNIONE =
		new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySegreteriaRiunione",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIARIUNIONE =
		new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED,
			InvitatiRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySegreteriaRiunione",
			new String[] { Long.class.getName(), Long.class.getName() },
			InvitatiRiunioneModelImpl.ID_SEGRETERIA_COLUMN_BITMASK |
			InvitatiRiunioneModelImpl.ID_RIUNIONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEGRETERIARIUNIONE = new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySegreteriaRiunione",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEGRETERIARIUNIONE =
		new FinderPath(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBySegreteriaRiunione",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @return the matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long id_riunione) {
		return findBySegreteriaRiunione(id_segreteria, id_riunione,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @return the range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long id_riunione, int start, int end) {
		return findBySegreteriaRiunione(id_segreteria, id_riunione, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long id_riunione, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return findBySegreteriaRiunione(id_segreteria, id_riunione, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long id_riunione, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIARIUNIONE;
			finderArgs = new Object[] { id_segreteria, id_riunione };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGRETERIARIUNIONE;
			finderArgs = new Object[] {
					id_segreteria, id_riunione,
					
					start, end, orderByComparator
				};
		}

		List<InvitatiRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<InvitatiRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InvitatiRiunione invitatiRiunione : list) {
					if ((id_segreteria != invitatiRiunione.getId_segreteria()) ||
							(id_riunione != invitatiRiunione.getId_riunione())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_SEGRETERIA_2);

			query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_RIUNIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_segreteria);

				qPos.add(id_riunione);

				if (!pagination) {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
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
	 * Returns the first invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione findBySegreteriaRiunione_First(long id_segreteria,
		long id_riunione, OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = fetchBySegreteriaRiunione_First(id_segreteria,
				id_riunione, orderByComparator);

		if (invitatiRiunione != null) {
			return invitatiRiunione;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_segreteria=");
		msg.append(id_segreteria);

		msg.append(", id_riunione=");
		msg.append(id_riunione);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitatiRiunioneException(msg.toString());
	}

	/**
	 * Returns the first invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione fetchBySegreteriaRiunione_First(
		long id_segreteria, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		List<InvitatiRiunione> list = findBySegreteriaRiunione(id_segreteria,
				id_riunione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione findBySegreteriaRiunione_Last(long id_segreteria,
		long id_riunione, OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = fetchBySegreteriaRiunione_Last(id_segreteria,
				id_riunione, orderByComparator);

		if (invitatiRiunione != null) {
			return invitatiRiunione;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_segreteria=");
		msg.append(id_segreteria);

		msg.append(", id_riunione=");
		msg.append(id_riunione);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitatiRiunioneException(msg.toString());
	}

	/**
	 * Returns the last invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	 */
	@Override
	public InvitatiRiunione fetchBySegreteriaRiunione_Last(long id_segreteria,
		long id_riunione, OrderByComparator<InvitatiRiunione> orderByComparator) {
		int count = countBySegreteriaRiunione(id_segreteria, id_riunione);

		if (count == 0) {
			return null;
		}

		List<InvitatiRiunione> list = findBySegreteriaRiunione(id_segreteria,
				id_riunione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * @param invitatiRiunionePK the primary key of the current invitati riunione
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione[] findBySegreteriaRiunione_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_segreteria,
		long id_riunione, OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = findByPrimaryKey(invitatiRiunionePK);

		Session session = null;

		try {
			session = openSession();

			InvitatiRiunione[] array = new InvitatiRiunioneImpl[3];

			array[0] = getBySegreteriaRiunione_PrevAndNext(session,
					invitatiRiunione, id_segreteria, id_riunione,
					orderByComparator, true);

			array[1] = invitatiRiunione;

			array[2] = getBySegreteriaRiunione_PrevAndNext(session,
					invitatiRiunione, id_segreteria, id_riunione,
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

	protected InvitatiRiunione getBySegreteriaRiunione_PrevAndNext(
		Session session, InvitatiRiunione invitatiRiunione, long id_segreteria,
		long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_INVITATIRIUNIONE_WHERE);

		query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_SEGRETERIA_2);

		query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_RIUNIONE_2);

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
			query.append(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_segreteria);

		qPos.add(id_riunione);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invitatiRiunione);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InvitatiRiunione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riuniones the id_riuniones
	 * @return the matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long[] id_riuniones) {
		return findBySegreteriaRiunione(id_segreteria, id_riuniones,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riuniones the id_riuniones
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @return the range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long[] id_riuniones, int start, int end) {
		return findBySegreteriaRiunione(id_segreteria, id_riuniones, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riuniones the id_riuniones
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long[] id_riuniones, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return findBySegreteriaRiunione(id_segreteria, id_riuniones, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findBySegreteriaRiunione(long id_segreteria,
		long[] id_riuniones, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		if (id_riuniones == null) {
			id_riuniones = new long[0];
		}
		else if (id_riuniones.length > 1) {
			id_riuniones = ArrayUtil.unique(id_riuniones);

			Arrays.sort(id_riuniones);
		}

		if (id_riuniones.length == 1) {
			return findBySegreteriaRiunione(id_segreteria, id_riuniones[0],
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					id_segreteria, StringUtil.merge(id_riuniones)
				};
		}
		else {
			finderArgs = new Object[] {
					id_segreteria, StringUtil.merge(id_riuniones),
					
					start, end, orderByComparator
				};
		}

		List<InvitatiRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<InvitatiRiunione>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGRETERIARIUNIONE,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InvitatiRiunione invitatiRiunione : list) {
					if ((id_segreteria != invitatiRiunione.getId_segreteria()) ||
							!ArrayUtil.contains(id_riuniones,
								invitatiRiunione.getId_riunione())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_SEGRETERIA_2);

			if (id_riuniones.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_RIUNIONE_7);

				query.append(StringUtil.merge(id_riuniones));

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_segreteria);

				if (!pagination) {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGRETERIARIUNIONE,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGRETERIARIUNIONE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63; from the database.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 */
	@Override
	public void removeBySegreteriaRiunione(long id_segreteria, long id_riunione) {
		for (InvitatiRiunione invitatiRiunione : findBySegreteriaRiunione(
				id_segreteria, id_riunione, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(invitatiRiunione);
		}
	}

	/**
	 * Returns the number of invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riunione the id_riunione
	 * @return the number of matching invitati riuniones
	 */
	@Override
	public int countBySegreteriaRiunione(long id_segreteria, long id_riunione) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEGRETERIARIUNIONE;

		Object[] finderArgs = new Object[] { id_segreteria, id_riunione };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_SEGRETERIA_2);

			query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_RIUNIONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_segreteria);

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

	/**
	 * Returns the number of invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	 *
	 * @param id_segreteria the id_segreteria
	 * @param id_riuniones the id_riuniones
	 * @return the number of matching invitati riuniones
	 */
	@Override
	public int countBySegreteriaRiunione(long id_segreteria, long[] id_riuniones) {
		if (id_riuniones == null) {
			id_riuniones = new long[0];
		}
		else if (id_riuniones.length > 1) {
			id_riuniones = ArrayUtil.unique(id_riuniones);

			Arrays.sort(id_riuniones);
		}

		Object[] finderArgs = new Object[] {
				id_segreteria, StringUtil.merge(id_riuniones)
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEGRETERIARIUNIONE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_INVITATIRIUNIONE_WHERE);

			query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_SEGRETERIA_2);

			if (id_riuniones.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				query.append(_FINDER_COLUMN_SEGRETERIARIUNIONE_ID_RIUNIONE_7);

				query.append(StringUtil.merge(id_riuniones));

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_segreteria);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEGRETERIARIUNIONE,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEGRETERIARIUNIONE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SEGRETERIARIUNIONE_ID_SEGRETERIA_2 =
		"invitatiRiunione.id.id_segreteria = ? AND ";
	private static final String _FINDER_COLUMN_SEGRETERIARIUNIONE_ID_RIUNIONE_2 = "invitatiRiunione.id.id_riunione = ?";
	private static final String _FINDER_COLUMN_SEGRETERIARIUNIONE_ID_RIUNIONE_7 = "invitatiRiunione.id.id_riunione IN (";

	public InvitatiRiunionePersistenceImpl() {
		setModelClass(InvitatiRiunione.class);
	}

	/**
	 * Caches the invitati riunione in the entity cache if it is enabled.
	 *
	 * @param invitatiRiunione the invitati riunione
	 */
	@Override
	public void cacheResult(InvitatiRiunione invitatiRiunione) {
		entityCache.putResult(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneImpl.class, invitatiRiunione.getPrimaryKey(),
			invitatiRiunione);

		invitatiRiunione.resetOriginalValues();
	}

	/**
	 * Caches the invitati riuniones in the entity cache if it is enabled.
	 *
	 * @param invitatiRiuniones the invitati riuniones
	 */
	@Override
	public void cacheResult(List<InvitatiRiunione> invitatiRiuniones) {
		for (InvitatiRiunione invitatiRiunione : invitatiRiuniones) {
			if (entityCache.getResult(
						InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						InvitatiRiunioneImpl.class,
						invitatiRiunione.getPrimaryKey()) == null) {
				cacheResult(invitatiRiunione);
			}
			else {
				invitatiRiunione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invitati riuniones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InvitatiRiunioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invitati riunione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InvitatiRiunione invitatiRiunione) {
		entityCache.removeResult(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneImpl.class, invitatiRiunione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InvitatiRiunione> invitatiRiuniones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InvitatiRiunione invitatiRiunione : invitatiRiuniones) {
			entityCache.removeResult(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				InvitatiRiunioneImpl.class, invitatiRiunione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new invitati riunione with the primary key. Does not add the invitati riunione to the database.
	 *
	 * @param invitatiRiunionePK the primary key for the new invitati riunione
	 * @return the new invitati riunione
	 */
	@Override
	public InvitatiRiunione create(InvitatiRiunionePK invitatiRiunionePK) {
		InvitatiRiunione invitatiRiunione = new InvitatiRiunioneImpl();

		invitatiRiunione.setNew(true);
		invitatiRiunione.setPrimaryKey(invitatiRiunionePK);

		return invitatiRiunione;
	}

	/**
	 * Removes the invitati riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitatiRiunionePK the primary key of the invitati riunione
	 * @return the invitati riunione that was removed
	 * @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione remove(InvitatiRiunionePK invitatiRiunionePK)
		throws NoSuchInvitatiRiunioneException {
		return remove((Serializable)invitatiRiunionePK);
	}

	/**
	 * Removes the invitati riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invitati riunione
	 * @return the invitati riunione that was removed
	 * @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione remove(Serializable primaryKey)
		throws NoSuchInvitatiRiunioneException {
		Session session = null;

		try {
			session = openSession();

			InvitatiRiunione invitatiRiunione = (InvitatiRiunione)session.get(InvitatiRiunioneImpl.class,
					primaryKey);

			if (invitatiRiunione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvitatiRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(invitatiRiunione);
		}
		catch (NoSuchInvitatiRiunioneException nsee) {
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
	protected InvitatiRiunione removeImpl(InvitatiRiunione invitatiRiunione) {
		invitatiRiunione = toUnwrappedModel(invitatiRiunione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invitatiRiunione)) {
				invitatiRiunione = (InvitatiRiunione)session.get(InvitatiRiunioneImpl.class,
						invitatiRiunione.getPrimaryKeyObj());
			}

			if (invitatiRiunione != null) {
				session.delete(invitatiRiunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (invitatiRiunione != null) {
			clearCache(invitatiRiunione);
		}

		return invitatiRiunione;
	}

	@Override
	public InvitatiRiunione updateImpl(InvitatiRiunione invitatiRiunione) {
		invitatiRiunione = toUnwrappedModel(invitatiRiunione);

		boolean isNew = invitatiRiunione.isNew();

		InvitatiRiunioneModelImpl invitatiRiunioneModelImpl = (InvitatiRiunioneModelImpl)invitatiRiunione;

		Session session = null;

		try {
			session = openSession();

			if (invitatiRiunione.isNew()) {
				session.save(invitatiRiunione);

				invitatiRiunione.setNew(false);
			}
			else {
				invitatiRiunione = (InvitatiRiunione)session.merge(invitatiRiunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InvitatiRiunioneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((invitatiRiunioneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RIUNIONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitatiRiunioneModelImpl.getOriginalId_riunione()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RIUNIONE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RIUNIONE,
					args);

				args = new Object[] { invitatiRiunioneModelImpl.getId_riunione() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RIUNIONE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RIUNIONE,
					args);
			}

			if ((invitatiRiunioneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitatiRiunioneModelImpl.getOriginalId_segreteria()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEGRETERIA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIA,
					args);

				args = new Object[] { invitatiRiunioneModelImpl.getId_segreteria() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEGRETERIA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIA,
					args);
			}

			if ((invitatiRiunioneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIARIUNIONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitatiRiunioneModelImpl.getOriginalId_segreteria(),
						invitatiRiunioneModelImpl.getOriginalId_riunione()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEGRETERIARIUNIONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIARIUNIONE,
					args);

				args = new Object[] {
						invitatiRiunioneModelImpl.getId_segreteria(),
						invitatiRiunioneModelImpl.getId_riunione()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEGRETERIARIUNIONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGRETERIARIUNIONE,
					args);
			}
		}

		entityCache.putResult(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			InvitatiRiunioneImpl.class, invitatiRiunione.getPrimaryKey(),
			invitatiRiunione, false);

		invitatiRiunione.resetOriginalValues();

		return invitatiRiunione;
	}

	protected InvitatiRiunione toUnwrappedModel(
		InvitatiRiunione invitatiRiunione) {
		if (invitatiRiunione instanceof InvitatiRiunioneImpl) {
			return invitatiRiunione;
		}

		InvitatiRiunioneImpl invitatiRiunioneImpl = new InvitatiRiunioneImpl();

		invitatiRiunioneImpl.setNew(invitatiRiunione.isNew());
		invitatiRiunioneImpl.setPrimaryKey(invitatiRiunione.getPrimaryKey());

		invitatiRiunioneImpl.setId_segreteria(invitatiRiunione.getId_segreteria());
		invitatiRiunioneImpl.setNote(invitatiRiunione.getNote());
		invitatiRiunioneImpl.setPartecipanti(invitatiRiunione.getPartecipanti());
		invitatiRiunioneImpl.setId_stato_invitato(invitatiRiunione.getId_stato_invitato());
		invitatiRiunioneImpl.setId_riunione(invitatiRiunione.getId_riunione());

		return invitatiRiunioneImpl;
	}

	/**
	 * Returns the invitati riunione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitati riunione
	 * @return the invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvitatiRiunioneException {
		InvitatiRiunione invitatiRiunione = fetchByPrimaryKey(primaryKey);

		if (invitatiRiunione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvitatiRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return invitatiRiunione;
	}

	/**
	 * Returns the invitati riunione with the primary key or throws a {@link NoSuchInvitatiRiunioneException} if it could not be found.
	 *
	 * @param invitatiRiunionePK the primary key of the invitati riunione
	 * @return the invitati riunione
	 * @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione findByPrimaryKey(
		InvitatiRiunionePK invitatiRiunionePK)
		throws NoSuchInvitatiRiunioneException {
		return findByPrimaryKey((Serializable)invitatiRiunionePK);
	}

	/**
	 * Returns the invitati riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitati riunione
	 * @return the invitati riunione, or <code>null</code> if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				InvitatiRiunioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		InvitatiRiunione invitatiRiunione = (InvitatiRiunione)serializable;

		if (invitatiRiunione == null) {
			Session session = null;

			try {
				session = openSession();

				invitatiRiunione = (InvitatiRiunione)session.get(InvitatiRiunioneImpl.class,
						primaryKey);

				if (invitatiRiunione != null) {
					cacheResult(invitatiRiunione);
				}
				else {
					entityCache.putResult(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						InvitatiRiunioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(InvitatiRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					InvitatiRiunioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return invitatiRiunione;
	}

	/**
	 * Returns the invitati riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invitatiRiunionePK the primary key of the invitati riunione
	 * @return the invitati riunione, or <code>null</code> if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione fetchByPrimaryKey(
		InvitatiRiunionePK invitatiRiunionePK) {
		return fetchByPrimaryKey((Serializable)invitatiRiunionePK);
	}

	@Override
	public Map<Serializable, InvitatiRiunione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, InvitatiRiunione> map = new HashMap<Serializable, InvitatiRiunione>();

		for (Serializable primaryKey : primaryKeys) {
			InvitatiRiunione invitatiRiunione = fetchByPrimaryKey(primaryKey);

			if (invitatiRiunione != null) {
				map.put(primaryKey, invitatiRiunione);
			}
		}

		return map;
	}

	/**
	 * Returns all the invitati riuniones.
	 *
	 * @return the invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitati riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @return the range of invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findAll(int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invitati riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> findAll(int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
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

		List<InvitatiRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<InvitatiRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_INVITATIRIUNIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVITATIRIUNIONE;

				if (pagination) {
					sql = sql.concat(InvitatiRiunioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InvitatiRiunione>)QueryUtil.list(q,
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
	 * Removes all the invitati riuniones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InvitatiRiunione invitatiRiunione : findAll()) {
			remove(invitatiRiunione);
		}
	}

	/**
	 * Returns the number of invitati riuniones.
	 *
	 * @return the number of invitati riuniones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INVITATIRIUNIONE);

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
		return InvitatiRiunioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the invitati riunione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(InvitatiRiunioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_INVITATIRIUNIONE = "SELECT invitatiRiunione FROM InvitatiRiunione invitatiRiunione";
	private static final String _SQL_SELECT_INVITATIRIUNIONE_WHERE = "SELECT invitatiRiunione FROM InvitatiRiunione invitatiRiunione WHERE ";
	private static final String _SQL_COUNT_INVITATIRIUNIONE = "SELECT COUNT(invitatiRiunione) FROM InvitatiRiunione invitatiRiunione";
	private static final String _SQL_COUNT_INVITATIRIUNIONE_WHERE = "SELECT COUNT(invitatiRiunione) FROM InvitatiRiunione invitatiRiunione WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "invitatiRiunione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InvitatiRiunione exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No InvitatiRiunione exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(InvitatiRiunionePersistenceImpl.class);
}