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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import service.intranet.mef.exception.NoSuchBeneInvRichiestoException;
import service.intranet.mef.model.BeneInvRichiesto;
import service.intranet.mef.model.impl.BeneInvRichiestoImpl;
import service.intranet.mef.model.impl.BeneInvRichiestoModelImpl;
import service.intranet.mef.service.persistence.BeneInvRichiestoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the bene inv richiesto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvRichiestoPersistence
 * @see service.intranet.mef.service.persistence.BeneInvRichiestoUtil
 * @generated
 */
@ProviderType
public class BeneInvRichiestoPersistenceImpl extends BasePersistenceImpl<BeneInvRichiesto>
	implements BeneInvRichiestoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BeneInvRichiestoUtil} to access the bene inv richiesto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BeneInvRichiestoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoModelImpl.FINDER_CACHE_ENABLED,
			BeneInvRichiestoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoModelImpl.FINDER_CACHE_ENABLED,
			BeneInvRichiestoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BENIINVRICHIESTILIST =
		new FinderPath(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoModelImpl.FINDER_CACHE_ENABLED,
			BeneInvRichiestoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBeniInvRichiestiList",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIINVRICHIESTILIST =
		new FinderPath(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoModelImpl.FINDER_CACHE_ENABLED,
			BeneInvRichiestoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBeniInvRichiestiList",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			BeneInvRichiestoModelImpl.ID_RICHIESTA_COLUMN_BITMASK |
			BeneInvRichiestoModelImpl.IN_ELENCO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BENIINVRICHIESTILIST = new FinderPath(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBeniInvRichiestiList",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @return the matching bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco) {
		return findByBeniInvRichiestiList(id_richiesta, in_elenco,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param start the lower bound of the range of bene inv richiestos
	 * @param end the upper bound of the range of bene inv richiestos (not inclusive)
	 * @return the range of matching bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco, int start, int end) {
		return findByBeniInvRichiestiList(id_richiesta, in_elenco, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param start the lower bound of the range of bene inv richiestos
	 * @param end the upper bound of the range of bene inv richiestos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco, int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		return findByBeniInvRichiestiList(id_richiesta, in_elenco, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param start the lower bound of the range of bene inv richiestos
	 * @param end the upper bound of the range of bene inv richiestos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco, int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIINVRICHIESTILIST;
			finderArgs = new Object[] { id_richiesta, in_elenco };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BENIINVRICHIESTILIST;
			finderArgs = new Object[] {
					id_richiesta, in_elenco,
					
					start, end, orderByComparator
				};
		}

		List<BeneInvRichiesto> list = null;

		if (retrieveFromCache) {
			list = (List<BeneInvRichiesto>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BeneInvRichiesto beneInvRichiesto : list) {
					if ((id_richiesta != beneInvRichiesto.getId_richiesta()) ||
							(in_elenco != beneInvRichiesto.getIn_elenco())) {
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

			query.append(_SQL_SELECT_BENEINVRICHIESTO_WHERE);

			query.append(_FINDER_COLUMN_BENIINVRICHIESTILIST_ID_RICHIESTA_2);

			query.append(_FINDER_COLUMN_BENIINVRICHIESTILIST_IN_ELENCO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BeneInvRichiestoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_richiesta);

				qPos.add(in_elenco);

				if (!pagination) {
					list = (List<BeneInvRichiesto>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BeneInvRichiesto>)QueryUtil.list(q,
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
	 * Returns the first bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bene inv richiesto
	 * @throws NoSuchBeneInvRichiestoException if a matching bene inv richiesto could not be found
	 */
	@Override
	public BeneInvRichiesto findByBeniInvRichiestiList_First(
		long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator)
		throws NoSuchBeneInvRichiestoException {
		BeneInvRichiesto beneInvRichiesto = fetchByBeniInvRichiestiList_First(id_richiesta,
				in_elenco, orderByComparator);

		if (beneInvRichiesto != null) {
			return beneInvRichiesto;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(", in_elenco=");
		msg.append(in_elenco);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBeneInvRichiestoException(msg.toString());
	}

	/**
	 * Returns the first bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bene inv richiesto, or <code>null</code> if a matching bene inv richiesto could not be found
	 */
	@Override
	public BeneInvRichiesto fetchByBeniInvRichiestiList_First(
		long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		List<BeneInvRichiesto> list = findByBeniInvRichiestiList(id_richiesta,
				in_elenco, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bene inv richiesto
	 * @throws NoSuchBeneInvRichiestoException if a matching bene inv richiesto could not be found
	 */
	@Override
	public BeneInvRichiesto findByBeniInvRichiestiList_Last(long id_richiesta,
		boolean in_elenco, OrderByComparator<BeneInvRichiesto> orderByComparator)
		throws NoSuchBeneInvRichiestoException {
		BeneInvRichiesto beneInvRichiesto = fetchByBeniInvRichiestiList_Last(id_richiesta,
				in_elenco, orderByComparator);

		if (beneInvRichiesto != null) {
			return beneInvRichiesto;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(", in_elenco=");
		msg.append(in_elenco);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBeneInvRichiestoException(msg.toString());
	}

	/**
	 * Returns the last bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bene inv richiesto, or <code>null</code> if a matching bene inv richiesto could not be found
	 */
	@Override
	public BeneInvRichiesto fetchByBeniInvRichiestiList_Last(
		long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		int count = countByBeniInvRichiestiList(id_richiesta, in_elenco);

		if (count == 0) {
			return null;
		}

		List<BeneInvRichiesto> list = findByBeniInvRichiestiList(id_richiesta,
				in_elenco, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bene inv richiestos before and after the current bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * @param id_bene_rich the primary key of the current bene inv richiesto
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bene inv richiesto
	 * @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	 */
	@Override
	public BeneInvRichiesto[] findByBeniInvRichiestiList_PrevAndNext(
		long id_bene_rich, long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator)
		throws NoSuchBeneInvRichiestoException {
		BeneInvRichiesto beneInvRichiesto = findByPrimaryKey(id_bene_rich);

		Session session = null;

		try {
			session = openSession();

			BeneInvRichiesto[] array = new BeneInvRichiestoImpl[3];

			array[0] = getByBeniInvRichiestiList_PrevAndNext(session,
					beneInvRichiesto, id_richiesta, in_elenco,
					orderByComparator, true);

			array[1] = beneInvRichiesto;

			array[2] = getByBeniInvRichiestiList_PrevAndNext(session,
					beneInvRichiesto, id_richiesta, in_elenco,
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

	protected BeneInvRichiesto getByBeniInvRichiestiList_PrevAndNext(
		Session session, BeneInvRichiesto beneInvRichiesto, long id_richiesta,
		boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_BENEINVRICHIESTO_WHERE);

		query.append(_FINDER_COLUMN_BENIINVRICHIESTILIST_ID_RICHIESTA_2);

		query.append(_FINDER_COLUMN_BENIINVRICHIESTILIST_IN_ELENCO_2);

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
			query.append(BeneInvRichiestoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_richiesta);

		qPos.add(in_elenco);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(beneInvRichiesto);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BeneInvRichiesto> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63; from the database.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 */
	@Override
	public void removeByBeniInvRichiestiList(long id_richiesta,
		boolean in_elenco) {
		for (BeneInvRichiesto beneInvRichiesto : findByBeniInvRichiestiList(
				id_richiesta, in_elenco, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(beneInvRichiesto);
		}
	}

	/**
	 * Returns the number of bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param in_elenco the in_elenco
	 * @return the number of matching bene inv richiestos
	 */
	@Override
	public int countByBeniInvRichiestiList(long id_richiesta, boolean in_elenco) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BENIINVRICHIESTILIST;

		Object[] finderArgs = new Object[] { id_richiesta, in_elenco };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BENEINVRICHIESTO_WHERE);

			query.append(_FINDER_COLUMN_BENIINVRICHIESTILIST_ID_RICHIESTA_2);

			query.append(_FINDER_COLUMN_BENIINVRICHIESTILIST_IN_ELENCO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_richiesta);

				qPos.add(in_elenco);

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

	private static final String _FINDER_COLUMN_BENIINVRICHIESTILIST_ID_RICHIESTA_2 =
		"beneInvRichiesto.id_richiesta = ? AND ";
	private static final String _FINDER_COLUMN_BENIINVRICHIESTILIST_IN_ELENCO_2 = "beneInvRichiesto.in_elenco = ?";

	public BeneInvRichiestoPersistenceImpl() {
		setModelClass(BeneInvRichiesto.class);
	}

	/**
	 * Caches the bene inv richiesto in the entity cache if it is enabled.
	 *
	 * @param beneInvRichiesto the bene inv richiesto
	 */
	@Override
	public void cacheResult(BeneInvRichiesto beneInvRichiesto) {
		entityCache.putResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoImpl.class, beneInvRichiesto.getPrimaryKey(),
			beneInvRichiesto);

		beneInvRichiesto.resetOriginalValues();
	}

	/**
	 * Caches the bene inv richiestos in the entity cache if it is enabled.
	 *
	 * @param beneInvRichiestos the bene inv richiestos
	 */
	@Override
	public void cacheResult(List<BeneInvRichiesto> beneInvRichiestos) {
		for (BeneInvRichiesto beneInvRichiesto : beneInvRichiestos) {
			if (entityCache.getResult(
						BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
						BeneInvRichiestoImpl.class,
						beneInvRichiesto.getPrimaryKey()) == null) {
				cacheResult(beneInvRichiesto);
			}
			else {
				beneInvRichiesto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bene inv richiestos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BeneInvRichiestoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bene inv richiesto.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BeneInvRichiesto beneInvRichiesto) {
		entityCache.removeResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoImpl.class, beneInvRichiesto.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BeneInvRichiesto> beneInvRichiestos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BeneInvRichiesto beneInvRichiesto : beneInvRichiestos) {
			entityCache.removeResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
				BeneInvRichiestoImpl.class, beneInvRichiesto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bene inv richiesto with the primary key. Does not add the bene inv richiesto to the database.
	 *
	 * @param id_bene_rich the primary key for the new bene inv richiesto
	 * @return the new bene inv richiesto
	 */
	@Override
	public BeneInvRichiesto create(long id_bene_rich) {
		BeneInvRichiesto beneInvRichiesto = new BeneInvRichiestoImpl();

		beneInvRichiesto.setNew(true);
		beneInvRichiesto.setPrimaryKey(id_bene_rich);

		return beneInvRichiesto;
	}

	/**
	 * Removes the bene inv richiesto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_bene_rich the primary key of the bene inv richiesto
	 * @return the bene inv richiesto that was removed
	 * @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	 */
	@Override
	public BeneInvRichiesto remove(long id_bene_rich)
		throws NoSuchBeneInvRichiestoException {
		return remove((Serializable)id_bene_rich);
	}

	/**
	 * Removes the bene inv richiesto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bene inv richiesto
	 * @return the bene inv richiesto that was removed
	 * @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	 */
	@Override
	public BeneInvRichiesto remove(Serializable primaryKey)
		throws NoSuchBeneInvRichiestoException {
		Session session = null;

		try {
			session = openSession();

			BeneInvRichiesto beneInvRichiesto = (BeneInvRichiesto)session.get(BeneInvRichiestoImpl.class,
					primaryKey);

			if (beneInvRichiesto == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBeneInvRichiestoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(beneInvRichiesto);
		}
		catch (NoSuchBeneInvRichiestoException nsee) {
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
	protected BeneInvRichiesto removeImpl(BeneInvRichiesto beneInvRichiesto) {
		beneInvRichiesto = toUnwrappedModel(beneInvRichiesto);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(beneInvRichiesto)) {
				beneInvRichiesto = (BeneInvRichiesto)session.get(BeneInvRichiestoImpl.class,
						beneInvRichiesto.getPrimaryKeyObj());
			}

			if (beneInvRichiesto != null) {
				session.delete(beneInvRichiesto);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (beneInvRichiesto != null) {
			clearCache(beneInvRichiesto);
		}

		return beneInvRichiesto;
	}

	@Override
	public BeneInvRichiesto updateImpl(BeneInvRichiesto beneInvRichiesto) {
		beneInvRichiesto = toUnwrappedModel(beneInvRichiesto);

		boolean isNew = beneInvRichiesto.isNew();

		BeneInvRichiestoModelImpl beneInvRichiestoModelImpl = (BeneInvRichiestoModelImpl)beneInvRichiesto;

		Session session = null;

		try {
			session = openSession();

			if (beneInvRichiesto.isNew()) {
				session.save(beneInvRichiesto);

				beneInvRichiesto.setNew(false);
			}
			else {
				beneInvRichiesto = (BeneInvRichiesto)session.merge(beneInvRichiesto);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BeneInvRichiestoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((beneInvRichiestoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIINVRICHIESTILIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						beneInvRichiestoModelImpl.getOriginalId_richiesta(),
						beneInvRichiestoModelImpl.getOriginalIn_elenco()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIINVRICHIESTILIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIINVRICHIESTILIST,
					args);

				args = new Object[] {
						beneInvRichiestoModelImpl.getId_richiesta(),
						beneInvRichiestoModelImpl.getIn_elenco()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIINVRICHIESTILIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIINVRICHIESTILIST,
					args);
			}
		}

		entityCache.putResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvRichiestoImpl.class, beneInvRichiesto.getPrimaryKey(),
			beneInvRichiesto, false);

		beneInvRichiesto.resetOriginalValues();

		return beneInvRichiesto;
	}

	protected BeneInvRichiesto toUnwrappedModel(
		BeneInvRichiesto beneInvRichiesto) {
		if (beneInvRichiesto instanceof BeneInvRichiestoImpl) {
			return beneInvRichiesto;
		}

		BeneInvRichiestoImpl beneInvRichiestoImpl = new BeneInvRichiestoImpl();

		beneInvRichiestoImpl.setNew(beneInvRichiesto.isNew());
		beneInvRichiestoImpl.setPrimaryKey(beneInvRichiesto.getPrimaryKey());

		beneInvRichiestoImpl.setId_bene_rich(beneInvRichiesto.getId_bene_rich());
		beneInvRichiestoImpl.setTipologia(beneInvRichiesto.getTipologia());
		beneInvRichiestoImpl.setDescrizione(beneInvRichiesto.getDescrizione());
		beneInvRichiestoImpl.setQuantita(beneInvRichiesto.getQuantita());
		beneInvRichiestoImpl.setDettagli(beneInvRichiesto.getDettagli());
		beneInvRichiestoImpl.setIn_elenco(beneInvRichiesto.isIn_elenco());
		beneInvRichiestoImpl.setId_richiesta(beneInvRichiesto.getId_richiesta());

		return beneInvRichiestoImpl;
	}

	/**
	 * Returns the bene inv richiesto with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bene inv richiesto
	 * @return the bene inv richiesto
	 * @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	 */
	@Override
	public BeneInvRichiesto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBeneInvRichiestoException {
		BeneInvRichiesto beneInvRichiesto = fetchByPrimaryKey(primaryKey);

		if (beneInvRichiesto == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBeneInvRichiestoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return beneInvRichiesto;
	}

	/**
	 * Returns the bene inv richiesto with the primary key or throws a {@link NoSuchBeneInvRichiestoException} if it could not be found.
	 *
	 * @param id_bene_rich the primary key of the bene inv richiesto
	 * @return the bene inv richiesto
	 * @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	 */
	@Override
	public BeneInvRichiesto findByPrimaryKey(long id_bene_rich)
		throws NoSuchBeneInvRichiestoException {
		return findByPrimaryKey((Serializable)id_bene_rich);
	}

	/**
	 * Returns the bene inv richiesto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bene inv richiesto
	 * @return the bene inv richiesto, or <code>null</code> if a bene inv richiesto with the primary key could not be found
	 */
	@Override
	public BeneInvRichiesto fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
				BeneInvRichiestoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BeneInvRichiesto beneInvRichiesto = (BeneInvRichiesto)serializable;

		if (beneInvRichiesto == null) {
			Session session = null;

			try {
				session = openSession();

				beneInvRichiesto = (BeneInvRichiesto)session.get(BeneInvRichiestoImpl.class,
						primaryKey);

				if (beneInvRichiesto != null) {
					cacheResult(beneInvRichiesto);
				}
				else {
					entityCache.putResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
						BeneInvRichiestoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
					BeneInvRichiestoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return beneInvRichiesto;
	}

	/**
	 * Returns the bene inv richiesto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_bene_rich the primary key of the bene inv richiesto
	 * @return the bene inv richiesto, or <code>null</code> if a bene inv richiesto with the primary key could not be found
	 */
	@Override
	public BeneInvRichiesto fetchByPrimaryKey(long id_bene_rich) {
		return fetchByPrimaryKey((Serializable)id_bene_rich);
	}

	@Override
	public Map<Serializable, BeneInvRichiesto> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BeneInvRichiesto> map = new HashMap<Serializable, BeneInvRichiesto>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BeneInvRichiesto beneInvRichiesto = fetchByPrimaryKey(primaryKey);

			if (beneInvRichiesto != null) {
				map.put(primaryKey, beneInvRichiesto);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
					BeneInvRichiestoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BeneInvRichiesto)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BENEINVRICHIESTO_WHERE_PKS_IN);

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

			for (BeneInvRichiesto beneInvRichiesto : (List<BeneInvRichiesto>)q.list()) {
				map.put(beneInvRichiesto.getPrimaryKeyObj(), beneInvRichiesto);

				cacheResult(beneInvRichiesto);

				uncachedPrimaryKeys.remove(beneInvRichiesto.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BeneInvRichiestoModelImpl.ENTITY_CACHE_ENABLED,
					BeneInvRichiestoImpl.class, primaryKey, nullModel);
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
	 * Returns all the bene inv richiestos.
	 *
	 * @return the bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bene inv richiestos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bene inv richiestos
	 * @param end the upper bound of the range of bene inv richiestos (not inclusive)
	 * @return the range of bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bene inv richiestos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bene inv richiestos
	 * @param end the upper bound of the range of bene inv richiestos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findAll(int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bene inv richiestos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bene inv richiestos
	 * @param end the upper bound of the range of bene inv richiestos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bene inv richiestos
	 */
	@Override
	public List<BeneInvRichiesto> findAll(int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator,
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

		List<BeneInvRichiesto> list = null;

		if (retrieveFromCache) {
			list = (List<BeneInvRichiesto>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BENEINVRICHIESTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BENEINVRICHIESTO;

				if (pagination) {
					sql = sql.concat(BeneInvRichiestoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BeneInvRichiesto>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BeneInvRichiesto>)QueryUtil.list(q,
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
	 * Removes all the bene inv richiestos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BeneInvRichiesto beneInvRichiesto : findAll()) {
			remove(beneInvRichiesto);
		}
	}

	/**
	 * Returns the number of bene inv richiestos.
	 *
	 * @return the number of bene inv richiestos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BENEINVRICHIESTO);

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
		return BeneInvRichiestoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bene inv richiesto persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BeneInvRichiestoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BENEINVRICHIESTO = "SELECT beneInvRichiesto FROM BeneInvRichiesto beneInvRichiesto";
	private static final String _SQL_SELECT_BENEINVRICHIESTO_WHERE_PKS_IN = "SELECT beneInvRichiesto FROM BeneInvRichiesto beneInvRichiesto WHERE id_bene_rich IN (";
	private static final String _SQL_SELECT_BENEINVRICHIESTO_WHERE = "SELECT beneInvRichiesto FROM BeneInvRichiesto beneInvRichiesto WHERE ";
	private static final String _SQL_COUNT_BENEINVRICHIESTO = "SELECT COUNT(beneInvRichiesto) FROM BeneInvRichiesto beneInvRichiesto";
	private static final String _SQL_COUNT_BENEINVRICHIESTO_WHERE = "SELECT COUNT(beneInvRichiesto) FROM BeneInvRichiesto beneInvRichiesto WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "beneInvRichiesto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BeneInvRichiesto exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BeneInvRichiesto exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BeneInvRichiestoPersistenceImpl.class);
}