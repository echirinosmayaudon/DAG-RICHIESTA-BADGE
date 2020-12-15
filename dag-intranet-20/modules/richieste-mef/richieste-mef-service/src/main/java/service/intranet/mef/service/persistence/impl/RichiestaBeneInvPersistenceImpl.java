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

import service.intranet.mef.exception.NoSuchRichiestaBeneInvException;
import service.intranet.mef.model.RichiestaBeneInv;
import service.intranet.mef.model.impl.RichiestaBeneInvImpl;
import service.intranet.mef.model.impl.RichiestaBeneInvModelImpl;
import service.intranet.mef.service.persistence.RichiestaBeneInvPersistence;

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
 * The persistence implementation for the richiesta bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvPersistence
 * @see service.intranet.mef.service.persistence.RichiestaBeneInvUtil
 * @generated
 */
@ProviderType
public class RichiestaBeneInvPersistenceImpl extends BasePersistenceImpl<RichiestaBeneInv>
	implements RichiestaBeneInvPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiestaBeneInvUtil} to access the richiesta bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiestaBeneInvImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UTENTE = new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtente",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE =
		new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUtente",
			new String[] { String.class.getName() },
			RichiestaBeneInvModelImpl.UTENTE_COLUMN_BITMASK |
			RichiestaBeneInvModelImpl.DATA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UTENTE = new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUtente",
			new String[] { String.class.getName() });

	/**
	 * Returns all the richiesta bene invs where utente = &#63;.
	 *
	 * @param utente the utente
	 * @return the matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByUtente(String utente) {
		return findByUtente(utente, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta bene invs where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @return the range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByUtente(String utente, int start, int end) {
		return findByUtente(utente, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByUtente(String utente, int start,
		int end, OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return findByUtente(utente, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByUtente(String utente, int start,
		int end, OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE;
			finderArgs = new Object[] { utente };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UTENTE;
			finderArgs = new Object[] { utente, start, end, orderByComparator };
		}

		List<RichiestaBeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBeneInv>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaBeneInv richiestaBeneInv : list) {
					if (!Objects.equals(utente, richiestaBeneInv.getUtente())) {
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

			query.append(_SQL_SELECT_RICHIESTABENEINV_WHERE);

			boolean bindUtente = false;

			if (utente == null) {
				query.append(_FINDER_COLUMN_UTENTE_UTENTE_1);
			}
			else if (utente.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UTENTE_UTENTE_3);
			}
			else {
				bindUtente = true;

				query.append(_FINDER_COLUMN_UTENTE_UTENTE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichiestaBeneInvModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUtente) {
					qPos.add(utente);
				}

				if (!pagination) {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
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
	 * Returns the first richiesta bene inv in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv findByUtente_First(String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = fetchByUtente_First(utente,
				orderByComparator);

		if (richiestaBeneInv != null) {
			return richiestaBeneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("utente=");
		msg.append(utente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBeneInvException(msg.toString());
	}

	/**
	 * Returns the first richiesta bene inv in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByUtente_First(String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		List<RichiestaBeneInv> list = findByUtente(utente, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta bene inv in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv findByUtente_Last(String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = fetchByUtente_Last(utente,
				orderByComparator);

		if (richiestaBeneInv != null) {
			return richiestaBeneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("utente=");
		msg.append(utente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBeneInvException(msg.toString());
	}

	/**
	 * Returns the last richiesta bene inv in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByUtente_Last(String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		int count = countByUtente(utente);

		if (count == 0) {
			return null;
		}

		List<RichiestaBeneInv> list = findByUtente(utente, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where utente = &#63;.
	 *
	 * @param id_richiesta the primary key of the current richiesta bene inv
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv[] findByUtente_PrevAndNext(long id_richiesta,
		String utente, OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = findByPrimaryKey(id_richiesta);

		Session session = null;

		try {
			session = openSession();

			RichiestaBeneInv[] array = new RichiestaBeneInvImpl[3];

			array[0] = getByUtente_PrevAndNext(session, richiestaBeneInv,
					utente, orderByComparator, true);

			array[1] = richiestaBeneInv;

			array[2] = getByUtente_PrevAndNext(session, richiestaBeneInv,
					utente, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaBeneInv getByUtente_PrevAndNext(Session session,
		RichiestaBeneInv richiestaBeneInv, String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RICHIESTABENEINV_WHERE);

		boolean bindUtente = false;

		if (utente == null) {
			query.append(_FINDER_COLUMN_UTENTE_UTENTE_1);
		}
		else if (utente.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UTENTE_UTENTE_3);
		}
		else {
			bindUtente = true;

			query.append(_FINDER_COLUMN_UTENTE_UTENTE_2);
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
			query.append(RichiestaBeneInvModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUtente) {
			qPos.add(utente);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richiestaBeneInv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichiestaBeneInv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta bene invs where utente = &#63; from the database.
	 *
	 * @param utente the utente
	 */
	@Override
	public void removeByUtente(String utente) {
		for (RichiestaBeneInv richiestaBeneInv : findByUtente(utente,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(richiestaBeneInv);
		}
	}

	/**
	 * Returns the number of richiesta bene invs where utente = &#63;.
	 *
	 * @param utente the utente
	 * @return the number of matching richiesta bene invs
	 */
	@Override
	public int countByUtente(String utente) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UTENTE;

		Object[] finderArgs = new Object[] { utente };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RICHIESTABENEINV_WHERE);

			boolean bindUtente = false;

			if (utente == null) {
				query.append(_FINDER_COLUMN_UTENTE_UTENTE_1);
			}
			else if (utente.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UTENTE_UTENTE_3);
			}
			else {
				bindUtente = true;

				query.append(_FINDER_COLUMN_UTENTE_UTENTE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUtente) {
					qPos.add(utente);
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

	private static final String _FINDER_COLUMN_UTENTE_UTENTE_1 = "richiestaBeneInv.utente IS NULL";
	private static final String _FINDER_COLUMN_UTENTE_UTENTE_2 = "richiestaBeneInv.utente = ?";
	private static final String _FINDER_COLUMN_UTENTE_UTENTE_3 = "(richiestaBeneInv.utente IS NULL OR richiestaBeneInv.utente = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTO =
		new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDipartimento",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO =
		new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDipartimento",
			new String[] { String.class.getName() },
			RichiestaBeneInvModelImpl.DIP_DIR_COLUMN_BITMASK |
			RichiestaBeneInvModelImpl.DATA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIPARTIMENTO = new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDipartimento",
			new String[] { String.class.getName() });

	/**
	 * Returns all the richiesta bene invs where dip_dir = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @return the matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimento(String dip_dir) {
		return findByDipartimento(dip_dir, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta bene invs where dip_dir = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dip_dir the dip_dir
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @return the range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimento(String dip_dir, int start,
		int end) {
		return findByDipartimento(dip_dir, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs where dip_dir = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dip_dir the dip_dir
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimento(String dip_dir, int start,
		int end, OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return findByDipartimento(dip_dir, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs where dip_dir = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dip_dir the dip_dir
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimento(String dip_dir, int start,
		int end, OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO;
			finderArgs = new Object[] { dip_dir };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTO;
			finderArgs = new Object[] { dip_dir, start, end, orderByComparator };
		}

		List<RichiestaBeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBeneInv>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaBeneInv richiestaBeneInv : list) {
					if (!Objects.equals(dip_dir, richiestaBeneInv.getDip_dir())) {
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

			query.append(_SQL_SELECT_RICHIESTABENEINV_WHERE);

			boolean bindDip_dir = false;

			if (dip_dir == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_1);
			}
			else if (dip_dir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_3);
			}
			else {
				bindDip_dir = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichiestaBeneInvModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDip_dir) {
					qPos.add(dip_dir);
				}

				if (!pagination) {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
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
	 * Returns the first richiesta bene inv in the ordered set where dip_dir = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv findByDipartimento_First(String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = fetchByDipartimento_First(dip_dir,
				orderByComparator);

		if (richiestaBeneInv != null) {
			return richiestaBeneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dip_dir=");
		msg.append(dip_dir);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBeneInvException(msg.toString());
	}

	/**
	 * Returns the first richiesta bene inv in the ordered set where dip_dir = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByDipartimento_First(String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		List<RichiestaBeneInv> list = findByDipartimento(dip_dir, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta bene inv in the ordered set where dip_dir = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv findByDipartimento_Last(String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = fetchByDipartimento_Last(dip_dir,
				orderByComparator);

		if (richiestaBeneInv != null) {
			return richiestaBeneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dip_dir=");
		msg.append(dip_dir);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBeneInvException(msg.toString());
	}

	/**
	 * Returns the last richiesta bene inv in the ordered set where dip_dir = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByDipartimento_Last(String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		int count = countByDipartimento(dip_dir);

		if (count == 0) {
			return null;
		}

		List<RichiestaBeneInv> list = findByDipartimento(dip_dir, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where dip_dir = &#63;.
	 *
	 * @param id_richiesta the primary key of the current richiesta bene inv
	 * @param dip_dir the dip_dir
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv[] findByDipartimento_PrevAndNext(
		long id_richiesta, String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = findByPrimaryKey(id_richiesta);

		Session session = null;

		try {
			session = openSession();

			RichiestaBeneInv[] array = new RichiestaBeneInvImpl[3];

			array[0] = getByDipartimento_PrevAndNext(session, richiestaBeneInv,
					dip_dir, orderByComparator, true);

			array[1] = richiestaBeneInv;

			array[2] = getByDipartimento_PrevAndNext(session, richiestaBeneInv,
					dip_dir, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaBeneInv getByDipartimento_PrevAndNext(Session session,
		RichiestaBeneInv richiestaBeneInv, String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RICHIESTABENEINV_WHERE);

		boolean bindDip_dir = false;

		if (dip_dir == null) {
			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_1);
		}
		else if (dip_dir.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_3);
		}
		else {
			bindDip_dir = true;

			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_2);
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
			query.append(RichiestaBeneInvModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDip_dir) {
			qPos.add(dip_dir);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richiestaBeneInv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichiestaBeneInv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta bene invs where dip_dir = &#63; from the database.
	 *
	 * @param dip_dir the dip_dir
	 */
	@Override
	public void removeByDipartimento(String dip_dir) {
		for (RichiestaBeneInv richiestaBeneInv : findByDipartimento(dip_dir,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(richiestaBeneInv);
		}
	}

	/**
	 * Returns the number of richiesta bene invs where dip_dir = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @return the number of matching richiesta bene invs
	 */
	@Override
	public int countByDipartimento(String dip_dir) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIPARTIMENTO;

		Object[] finderArgs = new Object[] { dip_dir };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RICHIESTABENEINV_WHERE);

			boolean bindDip_dir = false;

			if (dip_dir == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_1);
			}
			else if (dip_dir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_3);
			}
			else {
				bindDip_dir = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDip_dir) {
					qPos.add(dip_dir);
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

	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_1 = "richiestaBeneInv.dip_dir IS NULL";
	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_2 = "richiestaBeneInv.dip_dir = ?";
	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIP_DIR_3 = "(richiestaBeneInv.dip_dir IS NULL OR richiestaBeneInv.dip_dir = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTOSTATO =
		new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDipartimentoStato",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTOSTATO =
		new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDipartimentoStato",
			new String[] { String.class.getName(), Long.class.getName() },
			RichiestaBeneInvModelImpl.DIP_DIR_COLUMN_BITMASK |
			RichiestaBeneInvModelImpl.ID_STATO_COLUMN_BITMASK |
			RichiestaBeneInvModelImpl.DATA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIPARTIMENTOSTATO = new FinderPath(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDipartimentoStato",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @return the matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimentoStato(String dip_dir,
		long id_stato) {
		return findByDipartimentoStato(dip_dir, id_stato, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @return the range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimentoStato(String dip_dir,
		long id_stato, int start, int end) {
		return findByDipartimentoStato(dip_dir, id_stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimentoStato(String dip_dir,
		long id_stato, int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return findByDipartimentoStato(dip_dir, id_stato, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findByDipartimentoStato(String dip_dir,
		long id_stato, int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTOSTATO;
			finderArgs = new Object[] { dip_dir, id_stato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTOSTATO;
			finderArgs = new Object[] {
					dip_dir, id_stato,
					
					start, end, orderByComparator
				};
		}

		List<RichiestaBeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBeneInv>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaBeneInv richiestaBeneInv : list) {
					if (!Objects.equals(dip_dir, richiestaBeneInv.getDip_dir()) ||
							(id_stato != richiestaBeneInv.getId_stato())) {
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

			query.append(_SQL_SELECT_RICHIESTABENEINV_WHERE);

			boolean bindDip_dir = false;

			if (dip_dir == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_1);
			}
			else if (dip_dir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_3);
			}
			else {
				bindDip_dir = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_2);
			}

			query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_ID_STATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichiestaBeneInvModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDip_dir) {
					qPos.add(dip_dir);
				}

				qPos.add(id_stato);

				if (!pagination) {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
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
	 * Returns the first richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv findByDipartimentoStato_First(String dip_dir,
		long id_stato, OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = fetchByDipartimentoStato_First(dip_dir,
				id_stato, orderByComparator);

		if (richiestaBeneInv != null) {
			return richiestaBeneInv;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dip_dir=");
		msg.append(dip_dir);

		msg.append(", id_stato=");
		msg.append(id_stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBeneInvException(msg.toString());
	}

	/**
	 * Returns the first richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByDipartimentoStato_First(String dip_dir,
		long id_stato, OrderByComparator<RichiestaBeneInv> orderByComparator) {
		List<RichiestaBeneInv> list = findByDipartimentoStato(dip_dir,
				id_stato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv findByDipartimentoStato_Last(String dip_dir,
		long id_stato, OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = fetchByDipartimentoStato_Last(dip_dir,
				id_stato, orderByComparator);

		if (richiestaBeneInv != null) {
			return richiestaBeneInv;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dip_dir=");
		msg.append(dip_dir);

		msg.append(", id_stato=");
		msg.append(id_stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBeneInvException(msg.toString());
	}

	/**
	 * Returns the last richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByDipartimentoStato_Last(String dip_dir,
		long id_stato, OrderByComparator<RichiestaBeneInv> orderByComparator) {
		int count = countByDipartimentoStato(dip_dir, id_stato);

		if (count == 0) {
			return null;
		}

		List<RichiestaBeneInv> list = findByDipartimentoStato(dip_dir,
				id_stato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * @param id_richiesta the primary key of the current richiesta bene inv
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv[] findByDipartimentoStato_PrevAndNext(
		long id_richiesta, String dip_dir, long id_stato,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = findByPrimaryKey(id_richiesta);

		Session session = null;

		try {
			session = openSession();

			RichiestaBeneInv[] array = new RichiestaBeneInvImpl[3];

			array[0] = getByDipartimentoStato_PrevAndNext(session,
					richiestaBeneInv, dip_dir, id_stato, orderByComparator, true);

			array[1] = richiestaBeneInv;

			array[2] = getByDipartimentoStato_PrevAndNext(session,
					richiestaBeneInv, dip_dir, id_stato, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaBeneInv getByDipartimentoStato_PrevAndNext(
		Session session, RichiestaBeneInv richiestaBeneInv, String dip_dir,
		long id_stato, OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RICHIESTABENEINV_WHERE);

		boolean bindDip_dir = false;

		if (dip_dir == null) {
			query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_1);
		}
		else if (dip_dir.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_3);
		}
		else {
			bindDip_dir = true;

			query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_2);
		}

		query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_ID_STATO_2);

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
			query.append(RichiestaBeneInvModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDip_dir) {
			qPos.add(dip_dir);
		}

		qPos.add(id_stato);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richiestaBeneInv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichiestaBeneInv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63; from the database.
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 */
	@Override
	public void removeByDipartimentoStato(String dip_dir, long id_stato) {
		for (RichiestaBeneInv richiestaBeneInv : findByDipartimentoStato(
				dip_dir, id_stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(richiestaBeneInv);
		}
	}

	/**
	 * Returns the number of richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	 *
	 * @param dip_dir the dip_dir
	 * @param id_stato the id_stato
	 * @return the number of matching richiesta bene invs
	 */
	@Override
	public int countByDipartimentoStato(String dip_dir, long id_stato) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIPARTIMENTOSTATO;

		Object[] finderArgs = new Object[] { dip_dir, id_stato };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RICHIESTABENEINV_WHERE);

			boolean bindDip_dir = false;

			if (dip_dir == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_1);
			}
			else if (dip_dir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_3);
			}
			else {
				bindDip_dir = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_2);
			}

			query.append(_FINDER_COLUMN_DIPARTIMENTOSTATO_ID_STATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDip_dir) {
					qPos.add(dip_dir);
				}

				qPos.add(id_stato);

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

	private static final String _FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_1 = "richiestaBeneInv.dip_dir IS NULL AND ";
	private static final String _FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_2 = "richiestaBeneInv.dip_dir = ? AND ";
	private static final String _FINDER_COLUMN_DIPARTIMENTOSTATO_DIP_DIR_3 = "(richiestaBeneInv.dip_dir IS NULL OR richiestaBeneInv.dip_dir = '') AND ";
	private static final String _FINDER_COLUMN_DIPARTIMENTOSTATO_ID_STATO_2 = "richiestaBeneInv.id_stato = ?";

	public RichiestaBeneInvPersistenceImpl() {
		setModelClass(RichiestaBeneInv.class);
	}

	/**
	 * Caches the richiesta bene inv in the entity cache if it is enabled.
	 *
	 * @param richiestaBeneInv the richiesta bene inv
	 */
	@Override
	public void cacheResult(RichiestaBeneInv richiestaBeneInv) {
		entityCache.putResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvImpl.class, richiestaBeneInv.getPrimaryKey(),
			richiestaBeneInv);

		richiestaBeneInv.resetOriginalValues();
	}

	/**
	 * Caches the richiesta bene invs in the entity cache if it is enabled.
	 *
	 * @param richiestaBeneInvs the richiesta bene invs
	 */
	@Override
	public void cacheResult(List<RichiestaBeneInv> richiestaBeneInvs) {
		for (RichiestaBeneInv richiestaBeneInv : richiestaBeneInvs) {
			if (entityCache.getResult(
						RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaBeneInvImpl.class,
						richiestaBeneInv.getPrimaryKey()) == null) {
				cacheResult(richiestaBeneInv);
			}
			else {
				richiestaBeneInv.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richiesta bene invs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiestaBeneInvImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richiesta bene inv.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiestaBeneInv richiestaBeneInv) {
		entityCache.removeResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvImpl.class, richiestaBeneInv.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichiestaBeneInv> richiestaBeneInvs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichiestaBeneInv richiestaBeneInv : richiestaBeneInvs) {
			entityCache.removeResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaBeneInvImpl.class, richiestaBeneInv.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richiesta bene inv with the primary key. Does not add the richiesta bene inv to the database.
	 *
	 * @param id_richiesta the primary key for the new richiesta bene inv
	 * @return the new richiesta bene inv
	 */
	@Override
	public RichiestaBeneInv create(long id_richiesta) {
		RichiestaBeneInv richiestaBeneInv = new RichiestaBeneInvImpl();

		richiestaBeneInv.setNew(true);
		richiestaBeneInv.setPrimaryKey(id_richiesta);

		return richiestaBeneInv;
	}

	/**
	 * Removes the richiesta bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_richiesta the primary key of the richiesta bene inv
	 * @return the richiesta bene inv that was removed
	 * @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv remove(long id_richiesta)
		throws NoSuchRichiestaBeneInvException {
		return remove((Serializable)id_richiesta);
	}

	/**
	 * Removes the richiesta bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richiesta bene inv
	 * @return the richiesta bene inv that was removed
	 * @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv remove(Serializable primaryKey)
		throws NoSuchRichiestaBeneInvException {
		Session session = null;

		try {
			session = openSession();

			RichiestaBeneInv richiestaBeneInv = (RichiestaBeneInv)session.get(RichiestaBeneInvImpl.class,
					primaryKey);

			if (richiestaBeneInv == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiestaBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richiestaBeneInv);
		}
		catch (NoSuchRichiestaBeneInvException nsee) {
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
	protected RichiestaBeneInv removeImpl(RichiestaBeneInv richiestaBeneInv) {
		richiestaBeneInv = toUnwrappedModel(richiestaBeneInv);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiestaBeneInv)) {
				richiestaBeneInv = (RichiestaBeneInv)session.get(RichiestaBeneInvImpl.class,
						richiestaBeneInv.getPrimaryKeyObj());
			}

			if (richiestaBeneInv != null) {
				session.delete(richiestaBeneInv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiestaBeneInv != null) {
			clearCache(richiestaBeneInv);
		}

		return richiestaBeneInv;
	}

	@Override
	public RichiestaBeneInv updateImpl(RichiestaBeneInv richiestaBeneInv) {
		richiestaBeneInv = toUnwrappedModel(richiestaBeneInv);

		boolean isNew = richiestaBeneInv.isNew();

		RichiestaBeneInvModelImpl richiestaBeneInvModelImpl = (RichiestaBeneInvModelImpl)richiestaBeneInv;

		Session session = null;

		try {
			session = openSession();

			if (richiestaBeneInv.isNew()) {
				session.save(richiestaBeneInv);

				richiestaBeneInv.setNew(false);
			}
			else {
				richiestaBeneInv = (RichiestaBeneInv)session.merge(richiestaBeneInv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RichiestaBeneInvModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((richiestaBeneInvModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiestaBeneInvModelImpl.getOriginalUtente()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UTENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE,
					args);

				args = new Object[] { richiestaBeneInvModelImpl.getUtente() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UTENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE,
					args);
			}

			if ((richiestaBeneInvModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiestaBeneInvModelImpl.getOriginalDip_dir()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO,
					args);

				args = new Object[] { richiestaBeneInvModelImpl.getDip_dir() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO,
					args);
			}

			if ((richiestaBeneInvModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTOSTATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiestaBeneInvModelImpl.getOriginalDip_dir(),
						richiestaBeneInvModelImpl.getOriginalId_stato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTOSTATO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTOSTATO,
					args);

				args = new Object[] {
						richiestaBeneInvModelImpl.getDip_dir(),
						richiestaBeneInvModelImpl.getId_stato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTOSTATO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTOSTATO,
					args);
			}
		}

		entityCache.putResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBeneInvImpl.class, richiestaBeneInv.getPrimaryKey(),
			richiestaBeneInv, false);

		richiestaBeneInv.resetOriginalValues();

		return richiestaBeneInv;
	}

	protected RichiestaBeneInv toUnwrappedModel(
		RichiestaBeneInv richiestaBeneInv) {
		if (richiestaBeneInv instanceof RichiestaBeneInvImpl) {
			return richiestaBeneInv;
		}

		RichiestaBeneInvImpl richiestaBeneInvImpl = new RichiestaBeneInvImpl();

		richiestaBeneInvImpl.setNew(richiestaBeneInv.isNew());
		richiestaBeneInvImpl.setPrimaryKey(richiestaBeneInv.getPrimaryKey());

		richiestaBeneInvImpl.setId_richiesta(richiestaBeneInv.getId_richiesta());
		richiestaBeneInvImpl.setUtente(richiestaBeneInv.getUtente());
		richiestaBeneInvImpl.setNome_rich(richiestaBeneInv.getNome_rich());
		richiestaBeneInvImpl.setCogn_rich(richiestaBeneInv.getCogn_rich());
		richiestaBeneInvImpl.setDip_dir(richiestaBeneInv.getDip_dir());
		richiestaBeneInvImpl.setDati_rich(richiestaBeneInv.getDati_rich());
		richiestaBeneInvImpl.setOggetto(richiestaBeneInv.getOggetto());
		richiestaBeneInvImpl.setData(richiestaBeneInv.getData());
		richiestaBeneInvImpl.setBeneficiario(richiestaBeneInv.getBeneficiario());
		richiestaBeneInvImpl.setDestinazione(richiestaBeneInv.getDestinazione());
		richiestaBeneInvImpl.setId_stato(richiestaBeneInv.getId_stato());
		richiestaBeneInvImpl.setNote_consegn(richiestaBeneInv.getNote_consegn());

		return richiestaBeneInvImpl;
	}

	/**
	 * Returns the richiesta bene inv with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta bene inv
	 * @return the richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiestaBeneInvException {
		RichiestaBeneInv richiestaBeneInv = fetchByPrimaryKey(primaryKey);

		if (richiestaBeneInv == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiestaBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richiestaBeneInv;
	}

	/**
	 * Returns the richiesta bene inv with the primary key or throws a {@link NoSuchRichiestaBeneInvException} if it could not be found.
	 *
	 * @param id_richiesta the primary key of the richiesta bene inv
	 * @return the richiesta bene inv
	 * @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv findByPrimaryKey(long id_richiesta)
		throws NoSuchRichiestaBeneInvException {
		return findByPrimaryKey((Serializable)id_richiesta);
	}

	/**
	 * Returns the richiesta bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta bene inv
	 * @return the richiesta bene inv, or <code>null</code> if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaBeneInvImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichiestaBeneInv richiestaBeneInv = (RichiestaBeneInv)serializable;

		if (richiestaBeneInv == null) {
			Session session = null;

			try {
				session = openSession();

				richiestaBeneInv = (RichiestaBeneInv)session.get(RichiestaBeneInvImpl.class,
						primaryKey);

				if (richiestaBeneInv != null) {
					cacheResult(richiestaBeneInv);
				}
				else {
					entityCache.putResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaBeneInvImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaBeneInvImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiestaBeneInv;
	}

	/**
	 * Returns the richiesta bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_richiesta the primary key of the richiesta bene inv
	 * @return the richiesta bene inv, or <code>null</code> if a richiesta bene inv with the primary key could not be found
	 */
	@Override
	public RichiestaBeneInv fetchByPrimaryKey(long id_richiesta) {
		return fetchByPrimaryKey((Serializable)id_richiesta);
	}

	@Override
	public Map<Serializable, RichiestaBeneInv> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichiestaBeneInv> map = new HashMap<Serializable, RichiestaBeneInv>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichiestaBeneInv richiestaBeneInv = fetchByPrimaryKey(primaryKey);

			if (richiestaBeneInv != null) {
				map.put(primaryKey, richiestaBeneInv);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaBeneInvImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichiestaBeneInv)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTABENEINV_WHERE_PKS_IN);

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

			for (RichiestaBeneInv richiestaBeneInv : (List<RichiestaBeneInv>)q.list()) {
				map.put(richiestaBeneInv.getPrimaryKeyObj(), richiestaBeneInv);

				cacheResult(richiestaBeneInv);

				uncachedPrimaryKeys.remove(richiestaBeneInv.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiestaBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaBeneInvImpl.class, primaryKey, nullModel);
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
	 * Returns all the richiesta bene invs.
	 *
	 * @return the richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @return the range of richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findAll(int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta bene invs
	 * @param end the upper bound of the range of richiesta bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiesta bene invs
	 */
	@Override
	public List<RichiestaBeneInv> findAll(int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator,
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

		List<RichiestaBeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBeneInv>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTABENEINV);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTABENEINV;

				if (pagination) {
					sql = sql.concat(RichiestaBeneInvModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBeneInv>)QueryUtil.list(q,
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
	 * Removes all the richiesta bene invs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiestaBeneInv richiestaBeneInv : findAll()) {
			remove(richiestaBeneInv);
		}
	}

	/**
	 * Returns the number of richiesta bene invs.
	 *
	 * @return the number of richiesta bene invs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTABENEINV);

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
		return RichiestaBeneInvModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richiesta bene inv persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiestaBeneInvImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTABENEINV = "SELECT richiestaBeneInv FROM RichiestaBeneInv richiestaBeneInv";
	private static final String _SQL_SELECT_RICHIESTABENEINV_WHERE_PKS_IN = "SELECT richiestaBeneInv FROM RichiestaBeneInv richiestaBeneInv WHERE id_richiesta IN (";
	private static final String _SQL_SELECT_RICHIESTABENEINV_WHERE = "SELECT richiestaBeneInv FROM RichiestaBeneInv richiestaBeneInv WHERE ";
	private static final String _SQL_COUNT_RICHIESTABENEINV = "SELECT COUNT(richiestaBeneInv) FROM RichiestaBeneInv richiestaBeneInv";
	private static final String _SQL_COUNT_RICHIESTABENEINV_WHERE = "SELECT COUNT(richiestaBeneInv) FROM RichiestaBeneInv richiestaBeneInv WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richiestaBeneInv.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichiestaBeneInv exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RichiestaBeneInv exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RichiestaBeneInvPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"data"
			});
}