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

package com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelAmmConvException;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;
import com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvImpl;
import com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl;
import com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.CancelAmmConvPersistence;

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
import java.util.Set;

/**
 * The persistence implementation for the cancel amm conv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConvPersistence
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.CancelAmmConvUtil
 * @generated
 */
@ProviderType
public class CancelAmmConvPersistenceImpl extends BasePersistenceImpl<CancelAmmConv>
	implements CancelAmmConvPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CancelAmmConvUtil} to access the cancel amm conv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CancelAmmConvImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvModelImpl.FINDER_CACHE_ENABLED,
			CancelAmmConvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvModelImpl.FINDER_CACHE_ENABLED,
			CancelAmmConvImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AMMCONVLIST =
		new FinderPath(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvModelImpl.FINDER_CACHE_ENABLED,
			CancelAmmConvImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAmmConvList",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AMMCONVLIST =
		new FinderPath(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvModelImpl.FINDER_CACHE_ENABLED,
			CancelAmmConvImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAmmConvList", new String[] { Boolean.class.getName() },
			CancelAmmConvModelImpl.CANCELLATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AMMCONVLIST = new FinderPath(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAmmConvList",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the cancel amm convs where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @return the matching cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findByAmmConvList(boolean cancellato) {
		return findByAmmConvList(cancellato, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cancel amm convs where cancellato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cancellato the cancellato
	 * @param start the lower bound of the range of cancel amm convs
	 * @param end the upper bound of the range of cancel amm convs (not inclusive)
	 * @return the range of matching cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findByAmmConvList(boolean cancellato, int start,
		int end) {
		return findByAmmConvList(cancellato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cancel amm convs where cancellato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cancellato the cancellato
	 * @param start the lower bound of the range of cancel amm convs
	 * @param end the upper bound of the range of cancel amm convs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findByAmmConvList(boolean cancellato, int start,
		int end, OrderByComparator<CancelAmmConv> orderByComparator) {
		return findByAmmConvList(cancellato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cancel amm convs where cancellato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cancellato the cancellato
	 * @param start the lower bound of the range of cancel amm convs
	 * @param end the upper bound of the range of cancel amm convs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findByAmmConvList(boolean cancellato, int start,
		int end, OrderByComparator<CancelAmmConv> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AMMCONVLIST;
			finderArgs = new Object[] { cancellato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AMMCONVLIST;
			finderArgs = new Object[] { cancellato, start, end, orderByComparator };
		}

		List<CancelAmmConv> list = null;

		if (retrieveFromCache) {
			list = (List<CancelAmmConv>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CancelAmmConv cancelAmmConv : list) {
					if ((cancellato != cancelAmmConv.getCancellato())) {
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

			query.append(_SQL_SELECT_CANCELAMMCONV_WHERE);

			query.append(_FINDER_COLUMN_AMMCONVLIST_CANCELLATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CancelAmmConvModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cancellato);

				if (!pagination) {
					list = (List<CancelAmmConv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CancelAmmConv>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cancel amm conv in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cancel amm conv
	 * @throws NoSuchCancelAmmConvException if a matching cancel amm conv could not be found
	 */
	@Override
	public CancelAmmConv findByAmmConvList_First(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator)
		throws NoSuchCancelAmmConvException {
		CancelAmmConv cancelAmmConv = fetchByAmmConvList_First(cancellato,
				orderByComparator);

		if (cancelAmmConv != null) {
			return cancelAmmConv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cancellato=");
		msg.append(cancellato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCancelAmmConvException(msg.toString());
	}

	/**
	 * Returns the first cancel amm conv in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cancel amm conv, or <code>null</code> if a matching cancel amm conv could not be found
	 */
	@Override
	public CancelAmmConv fetchByAmmConvList_First(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator) {
		List<CancelAmmConv> list = findByAmmConvList(cancellato, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cancel amm conv in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cancel amm conv
	 * @throws NoSuchCancelAmmConvException if a matching cancel amm conv could not be found
	 */
	@Override
	public CancelAmmConv findByAmmConvList_Last(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator)
		throws NoSuchCancelAmmConvException {
		CancelAmmConv cancelAmmConv = fetchByAmmConvList_Last(cancellato,
				orderByComparator);

		if (cancelAmmConv != null) {
			return cancelAmmConv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cancellato=");
		msg.append(cancellato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCancelAmmConvException(msg.toString());
	}

	/**
	 * Returns the last cancel amm conv in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cancel amm conv, or <code>null</code> if a matching cancel amm conv could not be found
	 */
	@Override
	public CancelAmmConv fetchByAmmConvList_Last(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator) {
		int count = countByAmmConvList(cancellato);

		if (count == 0) {
			return null;
		}

		List<CancelAmmConv> list = findByAmmConvList(cancellato, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cancel amm convs before and after the current cancel amm conv in the ordered set where cancellato = &#63;.
	 *
	 * @param id_amministrazione_convocante the primary key of the current cancel amm conv
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cancel amm conv
	 * @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	 */
	@Override
	public CancelAmmConv[] findByAmmConvList_PrevAndNext(
		long id_amministrazione_convocante, boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator)
		throws NoSuchCancelAmmConvException {
		CancelAmmConv cancelAmmConv = findByPrimaryKey(id_amministrazione_convocante);

		Session session = null;

		try {
			session = openSession();

			CancelAmmConv[] array = new CancelAmmConvImpl[3];

			array[0] = getByAmmConvList_PrevAndNext(session, cancelAmmConv,
					cancellato, orderByComparator, true);

			array[1] = cancelAmmConv;

			array[2] = getByAmmConvList_PrevAndNext(session, cancelAmmConv,
					cancellato, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CancelAmmConv getByAmmConvList_PrevAndNext(Session session,
		CancelAmmConv cancelAmmConv, boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANCELAMMCONV_WHERE);

		query.append(_FINDER_COLUMN_AMMCONVLIST_CANCELLATO_2);

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
			query.append(CancelAmmConvModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cancellato);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cancelAmmConv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CancelAmmConv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cancel amm convs where cancellato = &#63; from the database.
	 *
	 * @param cancellato the cancellato
	 */
	@Override
	public void removeByAmmConvList(boolean cancellato) {
		for (CancelAmmConv cancelAmmConv : findByAmmConvList(cancellato,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cancelAmmConv);
		}
	}

	/**
	 * Returns the number of cancel amm convs where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @return the number of matching cancel amm convs
	 */
	@Override
	public int countByAmmConvList(boolean cancellato) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AMMCONVLIST;

		Object[] finderArgs = new Object[] { cancellato };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANCELAMMCONV_WHERE);

			query.append(_FINDER_COLUMN_AMMCONVLIST_CANCELLATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cancellato);

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

	private static final String _FINDER_COLUMN_AMMCONVLIST_CANCELLATO_2 = "cancelAmmConv.cancellato = ?";

	public CancelAmmConvPersistenceImpl() {
		setModelClass(CancelAmmConv.class);
	}

	/**
	 * Caches the cancel amm conv in the entity cache if it is enabled.
	 *
	 * @param cancelAmmConv the cancel amm conv
	 */
	@Override
	public void cacheResult(CancelAmmConv cancelAmmConv) {
		entityCache.putResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvImpl.class, cancelAmmConv.getPrimaryKey(),
			cancelAmmConv);

		cancelAmmConv.resetOriginalValues();
	}

	/**
	 * Caches the cancel amm convs in the entity cache if it is enabled.
	 *
	 * @param cancelAmmConvs the cancel amm convs
	 */
	@Override
	public void cacheResult(List<CancelAmmConv> cancelAmmConvs) {
		for (CancelAmmConv cancelAmmConv : cancelAmmConvs) {
			if (entityCache.getResult(
						CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
						CancelAmmConvImpl.class, cancelAmmConv.getPrimaryKey()) == null) {
				cacheResult(cancelAmmConv);
			}
			else {
				cancelAmmConv.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cancel amm convs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CancelAmmConvImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cancel amm conv.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CancelAmmConv cancelAmmConv) {
		entityCache.removeResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvImpl.class, cancelAmmConv.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CancelAmmConv> cancelAmmConvs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CancelAmmConv cancelAmmConv : cancelAmmConvs) {
			entityCache.removeResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
				CancelAmmConvImpl.class, cancelAmmConv.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cancel amm conv with the primary key. Does not add the cancel amm conv to the database.
	 *
	 * @param id_amministrazione_convocante the primary key for the new cancel amm conv
	 * @return the new cancel amm conv
	 */
	@Override
	public CancelAmmConv create(long id_amministrazione_convocante) {
		CancelAmmConv cancelAmmConv = new CancelAmmConvImpl();

		cancelAmmConv.setNew(true);
		cancelAmmConv.setPrimaryKey(id_amministrazione_convocante);

		return cancelAmmConv;
	}

	/**
	 * Removes the cancel amm conv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_amministrazione_convocante the primary key of the cancel amm conv
	 * @return the cancel amm conv that was removed
	 * @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	 */
	@Override
	public CancelAmmConv remove(long id_amministrazione_convocante)
		throws NoSuchCancelAmmConvException {
		return remove((Serializable)id_amministrazione_convocante);
	}

	/**
	 * Removes the cancel amm conv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cancel amm conv
	 * @return the cancel amm conv that was removed
	 * @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	 */
	@Override
	public CancelAmmConv remove(Serializable primaryKey)
		throws NoSuchCancelAmmConvException {
		Session session = null;

		try {
			session = openSession();

			CancelAmmConv cancelAmmConv = (CancelAmmConv)session.get(CancelAmmConvImpl.class,
					primaryKey);

			if (cancelAmmConv == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCancelAmmConvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cancelAmmConv);
		}
		catch (NoSuchCancelAmmConvException nsee) {
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
	protected CancelAmmConv removeImpl(CancelAmmConv cancelAmmConv) {
		cancelAmmConv = toUnwrappedModel(cancelAmmConv);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cancelAmmConv)) {
				cancelAmmConv = (CancelAmmConv)session.get(CancelAmmConvImpl.class,
						cancelAmmConv.getPrimaryKeyObj());
			}

			if (cancelAmmConv != null) {
				session.delete(cancelAmmConv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cancelAmmConv != null) {
			clearCache(cancelAmmConv);
		}

		return cancelAmmConv;
	}

	@Override
	public CancelAmmConv updateImpl(CancelAmmConv cancelAmmConv) {
		cancelAmmConv = toUnwrappedModel(cancelAmmConv);

		boolean isNew = cancelAmmConv.isNew();

		CancelAmmConvModelImpl cancelAmmConvModelImpl = (CancelAmmConvModelImpl)cancelAmmConv;

		Session session = null;

		try {
			session = openSession();

			if (cancelAmmConv.isNew()) {
				session.save(cancelAmmConv);

				cancelAmmConv.setNew(false);
			}
			else {
				cancelAmmConv = (CancelAmmConv)session.merge(cancelAmmConv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CancelAmmConvModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cancelAmmConvModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AMMCONVLIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cancelAmmConvModelImpl.getOriginalCancellato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AMMCONVLIST, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AMMCONVLIST,
					args);

				args = new Object[] { cancelAmmConvModelImpl.getCancellato() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AMMCONVLIST, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AMMCONVLIST,
					args);
			}
		}

		entityCache.putResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
			CancelAmmConvImpl.class, cancelAmmConv.getPrimaryKey(),
			cancelAmmConv, false);

		cancelAmmConv.resetOriginalValues();

		return cancelAmmConv;
	}

	protected CancelAmmConv toUnwrappedModel(CancelAmmConv cancelAmmConv) {
		if (cancelAmmConv instanceof CancelAmmConvImpl) {
			return cancelAmmConv;
		}

		CancelAmmConvImpl cancelAmmConvImpl = new CancelAmmConvImpl();

		cancelAmmConvImpl.setNew(cancelAmmConv.isNew());
		cancelAmmConvImpl.setPrimaryKey(cancelAmmConv.getPrimaryKey());

		cancelAmmConvImpl.setId_amministrazione_convocante(cancelAmmConv.getId_amministrazione_convocante());
		cancelAmmConvImpl.setCancellato(cancelAmmConv.isCancellato());

		return cancelAmmConvImpl;
	}

	/**
	 * Returns the cancel amm conv with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cancel amm conv
	 * @return the cancel amm conv
	 * @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	 */
	@Override
	public CancelAmmConv findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCancelAmmConvException {
		CancelAmmConv cancelAmmConv = fetchByPrimaryKey(primaryKey);

		if (cancelAmmConv == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCancelAmmConvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cancelAmmConv;
	}

	/**
	 * Returns the cancel amm conv with the primary key or throws a {@link NoSuchCancelAmmConvException} if it could not be found.
	 *
	 * @param id_amministrazione_convocante the primary key of the cancel amm conv
	 * @return the cancel amm conv
	 * @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	 */
	@Override
	public CancelAmmConv findByPrimaryKey(long id_amministrazione_convocante)
		throws NoSuchCancelAmmConvException {
		return findByPrimaryKey((Serializable)id_amministrazione_convocante);
	}

	/**
	 * Returns the cancel amm conv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cancel amm conv
	 * @return the cancel amm conv, or <code>null</code> if a cancel amm conv with the primary key could not be found
	 */
	@Override
	public CancelAmmConv fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
				CancelAmmConvImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CancelAmmConv cancelAmmConv = (CancelAmmConv)serializable;

		if (cancelAmmConv == null) {
			Session session = null;

			try {
				session = openSession();

				cancelAmmConv = (CancelAmmConv)session.get(CancelAmmConvImpl.class,
						primaryKey);

				if (cancelAmmConv != null) {
					cacheResult(cancelAmmConv);
				}
				else {
					entityCache.putResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
						CancelAmmConvImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
					CancelAmmConvImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cancelAmmConv;
	}

	/**
	 * Returns the cancel amm conv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_amministrazione_convocante the primary key of the cancel amm conv
	 * @return the cancel amm conv, or <code>null</code> if a cancel amm conv with the primary key could not be found
	 */
	@Override
	public CancelAmmConv fetchByPrimaryKey(long id_amministrazione_convocante) {
		return fetchByPrimaryKey((Serializable)id_amministrazione_convocante);
	}

	@Override
	public Map<Serializable, CancelAmmConv> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CancelAmmConv> map = new HashMap<Serializable, CancelAmmConv>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CancelAmmConv cancelAmmConv = fetchByPrimaryKey(primaryKey);

			if (cancelAmmConv != null) {
				map.put(primaryKey, cancelAmmConv);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
					CancelAmmConvImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CancelAmmConv)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANCELAMMCONV_WHERE_PKS_IN);

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

			for (CancelAmmConv cancelAmmConv : (List<CancelAmmConv>)q.list()) {
				map.put(cancelAmmConv.getPrimaryKeyObj(), cancelAmmConv);

				cacheResult(cancelAmmConv);

				uncachedPrimaryKeys.remove(cancelAmmConv.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CancelAmmConvModelImpl.ENTITY_CACHE_ENABLED,
					CancelAmmConvImpl.class, primaryKey, nullModel);
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
	 * Returns all the cancel amm convs.
	 *
	 * @return the cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cancel amm convs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cancel amm convs
	 * @param end the upper bound of the range of cancel amm convs (not inclusive)
	 * @return the range of cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cancel amm convs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cancel amm convs
	 * @param end the upper bound of the range of cancel amm convs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findAll(int start, int end,
		OrderByComparator<CancelAmmConv> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cancel amm convs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cancel amm convs
	 * @param end the upper bound of the range of cancel amm convs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cancel amm convs
	 */
	@Override
	public List<CancelAmmConv> findAll(int start, int end,
		OrderByComparator<CancelAmmConv> orderByComparator,
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

		List<CancelAmmConv> list = null;

		if (retrieveFromCache) {
			list = (List<CancelAmmConv>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANCELAMMCONV);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANCELAMMCONV;

				if (pagination) {
					sql = sql.concat(CancelAmmConvModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CancelAmmConv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CancelAmmConv>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cancel amm convs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CancelAmmConv cancelAmmConv : findAll()) {
			remove(cancelAmmConv);
		}
	}

	/**
	 * Returns the number of cancel amm convs.
	 *
	 * @return the number of cancel amm convs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANCELAMMCONV);

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
		return CancelAmmConvModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cancel amm conv persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CancelAmmConvImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANCELAMMCONV = "SELECT cancelAmmConv FROM CancelAmmConv cancelAmmConv";
	private static final String _SQL_SELECT_CANCELAMMCONV_WHERE_PKS_IN = "SELECT cancelAmmConv FROM CancelAmmConv cancelAmmConv WHERE id_amministrazione_convocante IN (";
	private static final String _SQL_SELECT_CANCELAMMCONV_WHERE = "SELECT cancelAmmConv FROM CancelAmmConv cancelAmmConv WHERE ";
	private static final String _SQL_COUNT_CANCELAMMCONV = "SELECT COUNT(cancelAmmConv) FROM CancelAmmConv cancelAmmConv";
	private static final String _SQL_COUNT_CANCELAMMCONV_WHERE = "SELECT COUNT(cancelAmmConv) FROM CancelAmmConv cancelAmmConv WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cancelAmmConv.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CancelAmmConv exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CancelAmmConv exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CancelAmmConvPersistenceImpl.class);
}