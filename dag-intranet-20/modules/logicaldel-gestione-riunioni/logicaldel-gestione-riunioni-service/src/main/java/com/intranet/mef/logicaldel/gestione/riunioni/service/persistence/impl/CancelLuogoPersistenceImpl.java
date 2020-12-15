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

import com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelLuogoException;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelLuogo;
import com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelLuogoImpl;
import com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelLuogoModelImpl;
import com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.CancelLuogoPersistence;

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
 * The persistence implementation for the cancel luogo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CancelLuogoPersistence
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.CancelLuogoUtil
 * @generated
 */
@ProviderType
public class CancelLuogoPersistenceImpl extends BasePersistenceImpl<CancelLuogo>
	implements CancelLuogoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CancelLuogoUtil} to access the cancel luogo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CancelLuogoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoModelImpl.FINDER_CACHE_ENABLED, CancelLuogoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoModelImpl.FINDER_CACHE_ENABLED, CancelLuogoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LUOGHILIST =
		new FinderPath(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoModelImpl.FINDER_CACHE_ENABLED, CancelLuogoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLuoghiList",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LUOGHILIST =
		new FinderPath(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoModelImpl.FINDER_CACHE_ENABLED, CancelLuogoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLuoghiList",
			new String[] { Boolean.class.getName() },
			CancelLuogoModelImpl.CANCELLATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LUOGHILIST = new FinderPath(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLuoghiList",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the cancel luogos where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @return the matching cancel luogos
	 */
	@Override
	public List<CancelLuogo> findByLuoghiList(boolean cancellato) {
		return findByLuoghiList(cancellato, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cancel luogos where cancellato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cancellato the cancellato
	 * @param start the lower bound of the range of cancel luogos
	 * @param end the upper bound of the range of cancel luogos (not inclusive)
	 * @return the range of matching cancel luogos
	 */
	@Override
	public List<CancelLuogo> findByLuoghiList(boolean cancellato, int start,
		int end) {
		return findByLuoghiList(cancellato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cancel luogos where cancellato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cancellato the cancellato
	 * @param start the lower bound of the range of cancel luogos
	 * @param end the upper bound of the range of cancel luogos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cancel luogos
	 */
	@Override
	public List<CancelLuogo> findByLuoghiList(boolean cancellato, int start,
		int end, OrderByComparator<CancelLuogo> orderByComparator) {
		return findByLuoghiList(cancellato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cancel luogos where cancellato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cancellato the cancellato
	 * @param start the lower bound of the range of cancel luogos
	 * @param end the upper bound of the range of cancel luogos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cancel luogos
	 */
	@Override
	public List<CancelLuogo> findByLuoghiList(boolean cancellato, int start,
		int end, OrderByComparator<CancelLuogo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LUOGHILIST;
			finderArgs = new Object[] { cancellato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LUOGHILIST;
			finderArgs = new Object[] { cancellato, start, end, orderByComparator };
		}

		List<CancelLuogo> list = null;

		if (retrieveFromCache) {
			list = (List<CancelLuogo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CancelLuogo cancelLuogo : list) {
					if ((cancellato != cancelLuogo.getCancellato())) {
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

			query.append(_SQL_SELECT_CANCELLUOGO_WHERE);

			query.append(_FINDER_COLUMN_LUOGHILIST_CANCELLATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CancelLuogoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cancellato);

				if (!pagination) {
					list = (List<CancelLuogo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CancelLuogo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cancel luogo in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cancel luogo
	 * @throws NoSuchCancelLuogoException if a matching cancel luogo could not be found
	 */
	@Override
	public CancelLuogo findByLuoghiList_First(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator)
		throws NoSuchCancelLuogoException {
		CancelLuogo cancelLuogo = fetchByLuoghiList_First(cancellato,
				orderByComparator);

		if (cancelLuogo != null) {
			return cancelLuogo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cancellato=");
		msg.append(cancellato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCancelLuogoException(msg.toString());
	}

	/**
	 * Returns the first cancel luogo in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cancel luogo, or <code>null</code> if a matching cancel luogo could not be found
	 */
	@Override
	public CancelLuogo fetchByLuoghiList_First(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator) {
		List<CancelLuogo> list = findByLuoghiList(cancellato, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cancel luogo in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cancel luogo
	 * @throws NoSuchCancelLuogoException if a matching cancel luogo could not be found
	 */
	@Override
	public CancelLuogo findByLuoghiList_Last(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator)
		throws NoSuchCancelLuogoException {
		CancelLuogo cancelLuogo = fetchByLuoghiList_Last(cancellato,
				orderByComparator);

		if (cancelLuogo != null) {
			return cancelLuogo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cancellato=");
		msg.append(cancellato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCancelLuogoException(msg.toString());
	}

	/**
	 * Returns the last cancel luogo in the ordered set where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cancel luogo, or <code>null</code> if a matching cancel luogo could not be found
	 */
	@Override
	public CancelLuogo fetchByLuoghiList_Last(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator) {
		int count = countByLuoghiList(cancellato);

		if (count == 0) {
			return null;
		}

		List<CancelLuogo> list = findByLuoghiList(cancellato, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cancel luogos before and after the current cancel luogo in the ordered set where cancellato = &#63;.
	 *
	 * @param id_luogo the primary key of the current cancel luogo
	 * @param cancellato the cancellato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cancel luogo
	 * @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	 */
	@Override
	public CancelLuogo[] findByLuoghiList_PrevAndNext(long id_luogo,
		boolean cancellato, OrderByComparator<CancelLuogo> orderByComparator)
		throws NoSuchCancelLuogoException {
		CancelLuogo cancelLuogo = findByPrimaryKey(id_luogo);

		Session session = null;

		try {
			session = openSession();

			CancelLuogo[] array = new CancelLuogoImpl[3];

			array[0] = getByLuoghiList_PrevAndNext(session, cancelLuogo,
					cancellato, orderByComparator, true);

			array[1] = cancelLuogo;

			array[2] = getByLuoghiList_PrevAndNext(session, cancelLuogo,
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

	protected CancelLuogo getByLuoghiList_PrevAndNext(Session session,
		CancelLuogo cancelLuogo, boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANCELLUOGO_WHERE);

		query.append(_FINDER_COLUMN_LUOGHILIST_CANCELLATO_2);

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
			query.append(CancelLuogoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cancellato);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cancelLuogo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CancelLuogo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cancel luogos where cancellato = &#63; from the database.
	 *
	 * @param cancellato the cancellato
	 */
	@Override
	public void removeByLuoghiList(boolean cancellato) {
		for (CancelLuogo cancelLuogo : findByLuoghiList(cancellato,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cancelLuogo);
		}
	}

	/**
	 * Returns the number of cancel luogos where cancellato = &#63;.
	 *
	 * @param cancellato the cancellato
	 * @return the number of matching cancel luogos
	 */
	@Override
	public int countByLuoghiList(boolean cancellato) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LUOGHILIST;

		Object[] finderArgs = new Object[] { cancellato };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANCELLUOGO_WHERE);

			query.append(_FINDER_COLUMN_LUOGHILIST_CANCELLATO_2);

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

	private static final String _FINDER_COLUMN_LUOGHILIST_CANCELLATO_2 = "cancelLuogo.cancellato = ?";

	public CancelLuogoPersistenceImpl() {
		setModelClass(CancelLuogo.class);
	}

	/**
	 * Caches the cancel luogo in the entity cache if it is enabled.
	 *
	 * @param cancelLuogo the cancel luogo
	 */
	@Override
	public void cacheResult(CancelLuogo cancelLuogo) {
		entityCache.putResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoImpl.class, cancelLuogo.getPrimaryKey(), cancelLuogo);

		cancelLuogo.resetOriginalValues();
	}

	/**
	 * Caches the cancel luogos in the entity cache if it is enabled.
	 *
	 * @param cancelLuogos the cancel luogos
	 */
	@Override
	public void cacheResult(List<CancelLuogo> cancelLuogos) {
		for (CancelLuogo cancelLuogo : cancelLuogos) {
			if (entityCache.getResult(
						CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
						CancelLuogoImpl.class, cancelLuogo.getPrimaryKey()) == null) {
				cacheResult(cancelLuogo);
			}
			else {
				cancelLuogo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cancel luogos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CancelLuogoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cancel luogo.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CancelLuogo cancelLuogo) {
		entityCache.removeResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoImpl.class, cancelLuogo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CancelLuogo> cancelLuogos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CancelLuogo cancelLuogo : cancelLuogos) {
			entityCache.removeResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
				CancelLuogoImpl.class, cancelLuogo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cancel luogo with the primary key. Does not add the cancel luogo to the database.
	 *
	 * @param id_luogo the primary key for the new cancel luogo
	 * @return the new cancel luogo
	 */
	@Override
	public CancelLuogo create(long id_luogo) {
		CancelLuogo cancelLuogo = new CancelLuogoImpl();

		cancelLuogo.setNew(true);
		cancelLuogo.setPrimaryKey(id_luogo);

		return cancelLuogo;
	}

	/**
	 * Removes the cancel luogo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_luogo the primary key of the cancel luogo
	 * @return the cancel luogo that was removed
	 * @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	 */
	@Override
	public CancelLuogo remove(long id_luogo) throws NoSuchCancelLuogoException {
		return remove((Serializable)id_luogo);
	}

	/**
	 * Removes the cancel luogo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cancel luogo
	 * @return the cancel luogo that was removed
	 * @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	 */
	@Override
	public CancelLuogo remove(Serializable primaryKey)
		throws NoSuchCancelLuogoException {
		Session session = null;

		try {
			session = openSession();

			CancelLuogo cancelLuogo = (CancelLuogo)session.get(CancelLuogoImpl.class,
					primaryKey);

			if (cancelLuogo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCancelLuogoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cancelLuogo);
		}
		catch (NoSuchCancelLuogoException nsee) {
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
	protected CancelLuogo removeImpl(CancelLuogo cancelLuogo) {
		cancelLuogo = toUnwrappedModel(cancelLuogo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cancelLuogo)) {
				cancelLuogo = (CancelLuogo)session.get(CancelLuogoImpl.class,
						cancelLuogo.getPrimaryKeyObj());
			}

			if (cancelLuogo != null) {
				session.delete(cancelLuogo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cancelLuogo != null) {
			clearCache(cancelLuogo);
		}

		return cancelLuogo;
	}

	@Override
	public CancelLuogo updateImpl(CancelLuogo cancelLuogo) {
		cancelLuogo = toUnwrappedModel(cancelLuogo);

		boolean isNew = cancelLuogo.isNew();

		CancelLuogoModelImpl cancelLuogoModelImpl = (CancelLuogoModelImpl)cancelLuogo;

		Session session = null;

		try {
			session = openSession();

			if (cancelLuogo.isNew()) {
				session.save(cancelLuogo);

				cancelLuogo.setNew(false);
			}
			else {
				cancelLuogo = (CancelLuogo)session.merge(cancelLuogo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CancelLuogoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cancelLuogoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LUOGHILIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cancelLuogoModelImpl.getOriginalCancellato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LUOGHILIST, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LUOGHILIST,
					args);

				args = new Object[] { cancelLuogoModelImpl.getCancellato() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LUOGHILIST, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LUOGHILIST,
					args);
			}
		}

		entityCache.putResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
			CancelLuogoImpl.class, cancelLuogo.getPrimaryKey(), cancelLuogo,
			false);

		cancelLuogo.resetOriginalValues();

		return cancelLuogo;
	}

	protected CancelLuogo toUnwrappedModel(CancelLuogo cancelLuogo) {
		if (cancelLuogo instanceof CancelLuogoImpl) {
			return cancelLuogo;
		}

		CancelLuogoImpl cancelLuogoImpl = new CancelLuogoImpl();

		cancelLuogoImpl.setNew(cancelLuogo.isNew());
		cancelLuogoImpl.setPrimaryKey(cancelLuogo.getPrimaryKey());

		cancelLuogoImpl.setId_luogo(cancelLuogo.getId_luogo());
		cancelLuogoImpl.setCancellato(cancelLuogo.isCancellato());

		return cancelLuogoImpl;
	}

	/**
	 * Returns the cancel luogo with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cancel luogo
	 * @return the cancel luogo
	 * @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	 */
	@Override
	public CancelLuogo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCancelLuogoException {
		CancelLuogo cancelLuogo = fetchByPrimaryKey(primaryKey);

		if (cancelLuogo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCancelLuogoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cancelLuogo;
	}

	/**
	 * Returns the cancel luogo with the primary key or throws a {@link NoSuchCancelLuogoException} if it could not be found.
	 *
	 * @param id_luogo the primary key of the cancel luogo
	 * @return the cancel luogo
	 * @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	 */
	@Override
	public CancelLuogo findByPrimaryKey(long id_luogo)
		throws NoSuchCancelLuogoException {
		return findByPrimaryKey((Serializable)id_luogo);
	}

	/**
	 * Returns the cancel luogo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cancel luogo
	 * @return the cancel luogo, or <code>null</code> if a cancel luogo with the primary key could not be found
	 */
	@Override
	public CancelLuogo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
				CancelLuogoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CancelLuogo cancelLuogo = (CancelLuogo)serializable;

		if (cancelLuogo == null) {
			Session session = null;

			try {
				session = openSession();

				cancelLuogo = (CancelLuogo)session.get(CancelLuogoImpl.class,
						primaryKey);

				if (cancelLuogo != null) {
					cacheResult(cancelLuogo);
				}
				else {
					entityCache.putResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
						CancelLuogoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
					CancelLuogoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cancelLuogo;
	}

	/**
	 * Returns the cancel luogo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_luogo the primary key of the cancel luogo
	 * @return the cancel luogo, or <code>null</code> if a cancel luogo with the primary key could not be found
	 */
	@Override
	public CancelLuogo fetchByPrimaryKey(long id_luogo) {
		return fetchByPrimaryKey((Serializable)id_luogo);
	}

	@Override
	public Map<Serializable, CancelLuogo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CancelLuogo> map = new HashMap<Serializable, CancelLuogo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CancelLuogo cancelLuogo = fetchByPrimaryKey(primaryKey);

			if (cancelLuogo != null) {
				map.put(primaryKey, cancelLuogo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
					CancelLuogoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CancelLuogo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANCELLUOGO_WHERE_PKS_IN);

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

			for (CancelLuogo cancelLuogo : (List<CancelLuogo>)q.list()) {
				map.put(cancelLuogo.getPrimaryKeyObj(), cancelLuogo);

				cacheResult(cancelLuogo);

				uncachedPrimaryKeys.remove(cancelLuogo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CancelLuogoModelImpl.ENTITY_CACHE_ENABLED,
					CancelLuogoImpl.class, primaryKey, nullModel);
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
	 * Returns all the cancel luogos.
	 *
	 * @return the cancel luogos
	 */
	@Override
	public List<CancelLuogo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cancel luogos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cancel luogos
	 * @param end the upper bound of the range of cancel luogos (not inclusive)
	 * @return the range of cancel luogos
	 */
	@Override
	public List<CancelLuogo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cancel luogos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cancel luogos
	 * @param end the upper bound of the range of cancel luogos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cancel luogos
	 */
	@Override
	public List<CancelLuogo> findAll(int start, int end,
		OrderByComparator<CancelLuogo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cancel luogos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cancel luogos
	 * @param end the upper bound of the range of cancel luogos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cancel luogos
	 */
	@Override
	public List<CancelLuogo> findAll(int start, int end,
		OrderByComparator<CancelLuogo> orderByComparator,
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

		List<CancelLuogo> list = null;

		if (retrieveFromCache) {
			list = (List<CancelLuogo>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANCELLUOGO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANCELLUOGO;

				if (pagination) {
					sql = sql.concat(CancelLuogoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CancelLuogo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CancelLuogo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cancel luogos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CancelLuogo cancelLuogo : findAll()) {
			remove(cancelLuogo);
		}
	}

	/**
	 * Returns the number of cancel luogos.
	 *
	 * @return the number of cancel luogos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANCELLUOGO);

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
		return CancelLuogoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cancel luogo persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CancelLuogoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANCELLUOGO = "SELECT cancelLuogo FROM CancelLuogo cancelLuogo";
	private static final String _SQL_SELECT_CANCELLUOGO_WHERE_PKS_IN = "SELECT cancelLuogo FROM CancelLuogo cancelLuogo WHERE id_luogo IN (";
	private static final String _SQL_SELECT_CANCELLUOGO_WHERE = "SELECT cancelLuogo FROM CancelLuogo cancelLuogo WHERE ";
	private static final String _SQL_COUNT_CANCELLUOGO = "SELECT COUNT(cancelLuogo) FROM CancelLuogo cancelLuogo";
	private static final String _SQL_COUNT_CANCELLUOGO_WHERE = "SELECT COUNT(cancelLuogo) FROM CancelLuogo cancelLuogo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cancelLuogo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CancelLuogo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CancelLuogo exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CancelLuogoPersistenceImpl.class);
}