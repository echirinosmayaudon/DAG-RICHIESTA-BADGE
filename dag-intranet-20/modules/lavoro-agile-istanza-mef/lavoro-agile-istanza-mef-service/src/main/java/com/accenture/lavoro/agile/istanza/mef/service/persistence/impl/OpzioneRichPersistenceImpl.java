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

package com.accenture.lavoro.agile.istanza.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.exception.NoSuchOpzioneRichException;
import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;
import com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichImpl;
import com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichModelImpl;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.OpzioneRichPersistence;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

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
 * The persistence implementation for the opzione rich service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRichPersistence
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.OpzioneRichUtil
 * @generated
 */
@ProviderType
public class OpzioneRichPersistenceImpl extends BasePersistenceImpl<OpzioneRich>
	implements OpzioneRichPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OpzioneRichUtil} to access the opzione rich persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OpzioneRichImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichModelImpl.FINDER_CACHE_ENABLED, OpzioneRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichModelImpl.FINDER_CACHE_ENABLED, OpzioneRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LABEL_OPT =
		new FinderPath(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichModelImpl.FINDER_CACHE_ENABLED, OpzioneRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylabel_opt",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_OPT =
		new FinderPath(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichModelImpl.FINDER_CACHE_ENABLED, OpzioneRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylabel_opt",
			new String[] { String.class.getName() },
			OpzioneRichModelImpl.LABEL_OPT_COLUMN_BITMASK |
			OpzioneRichModelImpl.DATA_IN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LABEL_OPT = new FinderPath(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylabel_opt",
			new String[] { String.class.getName() });

	/**
	 * Returns all the opzione richs where label_opt = &#63;.
	 *
	 * @param label_opt the label_opt
	 * @return the matching opzione richs
	 */
	@Override
	public List<OpzioneRich> findBylabel_opt(String label_opt) {
		return findBylabel_opt(label_opt, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the opzione richs where label_opt = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label_opt the label_opt
	 * @param start the lower bound of the range of opzione richs
	 * @param end the upper bound of the range of opzione richs (not inclusive)
	 * @return the range of matching opzione richs
	 */
	@Override
	public List<OpzioneRich> findBylabel_opt(String label_opt, int start,
		int end) {
		return findBylabel_opt(label_opt, start, end, null);
	}

	/**
	 * Returns an ordered range of all the opzione richs where label_opt = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label_opt the label_opt
	 * @param start the lower bound of the range of opzione richs
	 * @param end the upper bound of the range of opzione richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching opzione richs
	 */
	@Override
	public List<OpzioneRich> findBylabel_opt(String label_opt, int start,
		int end, OrderByComparator<OpzioneRich> orderByComparator) {
		return findBylabel_opt(label_opt, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the opzione richs where label_opt = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label_opt the label_opt
	 * @param start the lower bound of the range of opzione richs
	 * @param end the upper bound of the range of opzione richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching opzione richs
	 */
	@Override
	public List<OpzioneRich> findBylabel_opt(String label_opt, int start,
		int end, OrderByComparator<OpzioneRich> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_OPT;
			finderArgs = new Object[] { label_opt };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LABEL_OPT;
			finderArgs = new Object[] { label_opt, start, end, orderByComparator };
		}

		List<OpzioneRich> list = null;

		if (retrieveFromCache) {
			list = (List<OpzioneRich>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OpzioneRich opzioneRich : list) {
					if (!Objects.equals(label_opt, opzioneRich.getLabel_opt())) {
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

			query.append(_SQL_SELECT_OPZIONERICH_WHERE);

			boolean bindLabel_opt = false;

			if (label_opt == null) {
				query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_1);
			}
			else if (label_opt.equals("")) {
				query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_3);
			}
			else {
				bindLabel_opt = true;

				query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OpzioneRichModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel_opt) {
					qPos.add(label_opt);
				}

				if (!pagination) {
					list = (List<OpzioneRich>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OpzioneRich>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first opzione rich in the ordered set where label_opt = &#63;.
	 *
	 * @param label_opt the label_opt
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching opzione rich
	 * @throws NoSuchOpzioneRichException if a matching opzione rich could not be found
	 */
	@Override
	public OpzioneRich findBylabel_opt_First(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator)
		throws NoSuchOpzioneRichException {
		OpzioneRich opzioneRich = fetchBylabel_opt_First(label_opt,
				orderByComparator);

		if (opzioneRich != null) {
			return opzioneRich;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label_opt=");
		msg.append(label_opt);

		msg.append("}");

		throw new NoSuchOpzioneRichException(msg.toString());
	}

	/**
	 * Returns the first opzione rich in the ordered set where label_opt = &#63;.
	 *
	 * @param label_opt the label_opt
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching opzione rich, or <code>null</code> if a matching opzione rich could not be found
	 */
	@Override
	public OpzioneRich fetchBylabel_opt_First(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator) {
		List<OpzioneRich> list = findBylabel_opt(label_opt, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last opzione rich in the ordered set where label_opt = &#63;.
	 *
	 * @param label_opt the label_opt
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching opzione rich
	 * @throws NoSuchOpzioneRichException if a matching opzione rich could not be found
	 */
	@Override
	public OpzioneRich findBylabel_opt_Last(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator)
		throws NoSuchOpzioneRichException {
		OpzioneRich opzioneRich = fetchBylabel_opt_Last(label_opt,
				orderByComparator);

		if (opzioneRich != null) {
			return opzioneRich;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label_opt=");
		msg.append(label_opt);

		msg.append("}");

		throw new NoSuchOpzioneRichException(msg.toString());
	}

	/**
	 * Returns the last opzione rich in the ordered set where label_opt = &#63;.
	 *
	 * @param label_opt the label_opt
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching opzione rich, or <code>null</code> if a matching opzione rich could not be found
	 */
	@Override
	public OpzioneRich fetchBylabel_opt_Last(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator) {
		int count = countBylabel_opt(label_opt);

		if (count == 0) {
			return null;
		}

		List<OpzioneRich> list = findBylabel_opt(label_opt, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the opzione richs before and after the current opzione rich in the ordered set where label_opt = &#63;.
	 *
	 * @param id_opt the primary key of the current opzione rich
	 * @param label_opt the label_opt
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next opzione rich
	 * @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	 */
	@Override
	public OpzioneRich[] findBylabel_opt_PrevAndNext(long id_opt,
		String label_opt, OrderByComparator<OpzioneRich> orderByComparator)
		throws NoSuchOpzioneRichException {
		OpzioneRich opzioneRich = findByPrimaryKey(id_opt);

		Session session = null;

		try {
			session = openSession();

			OpzioneRich[] array = new OpzioneRichImpl[3];

			array[0] = getBylabel_opt_PrevAndNext(session, opzioneRich,
					label_opt, orderByComparator, true);

			array[1] = opzioneRich;

			array[2] = getBylabel_opt_PrevAndNext(session, opzioneRich,
					label_opt, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OpzioneRich getBylabel_opt_PrevAndNext(Session session,
		OpzioneRich opzioneRich, String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OPZIONERICH_WHERE);

		boolean bindLabel_opt = false;

		if (label_opt == null) {
			query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_1);
		}
		else if (label_opt.equals("")) {
			query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_3);
		}
		else {
			bindLabel_opt = true;

			query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_2);
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
			query.append(OpzioneRichModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLabel_opt) {
			qPos.add(label_opt);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(opzioneRich);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OpzioneRich> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the opzione richs where label_opt = &#63; from the database.
	 *
	 * @param label_opt the label_opt
	 */
	@Override
	public void removeBylabel_opt(String label_opt) {
		for (OpzioneRich opzioneRich : findBylabel_opt(label_opt,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(opzioneRich);
		}
	}

	/**
	 * Returns the number of opzione richs where label_opt = &#63;.
	 *
	 * @param label_opt the label_opt
	 * @return the number of matching opzione richs
	 */
	@Override
	public int countBylabel_opt(String label_opt) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LABEL_OPT;

		Object[] finderArgs = new Object[] { label_opt };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OPZIONERICH_WHERE);

			boolean bindLabel_opt = false;

			if (label_opt == null) {
				query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_1);
			}
			else if (label_opt.equals("")) {
				query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_3);
			}
			else {
				bindLabel_opt = true;

				query.append(_FINDER_COLUMN_LABEL_OPT_LABEL_OPT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel_opt) {
					qPos.add(label_opt);
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

	private static final String _FINDER_COLUMN_LABEL_OPT_LABEL_OPT_1 = "opzioneRich.label_opt IS NULL";
	private static final String _FINDER_COLUMN_LABEL_OPT_LABEL_OPT_2 = "opzioneRich.label_opt = ?";
	private static final String _FINDER_COLUMN_LABEL_OPT_LABEL_OPT_3 = "(opzioneRich.label_opt IS NULL OR opzioneRich.label_opt = '')";

	public OpzioneRichPersistenceImpl() {
		setModelClass(OpzioneRich.class);
	}

	/**
	 * Caches the opzione rich in the entity cache if it is enabled.
	 *
	 * @param opzioneRich the opzione rich
	 */
	@Override
	public void cacheResult(OpzioneRich opzioneRich) {
		entityCache.putResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichImpl.class, opzioneRich.getPrimaryKey(), opzioneRich);

		opzioneRich.resetOriginalValues();
	}

	/**
	 * Caches the opzione richs in the entity cache if it is enabled.
	 *
	 * @param opzioneRichs the opzione richs
	 */
	@Override
	public void cacheResult(List<OpzioneRich> opzioneRichs) {
		for (OpzioneRich opzioneRich : opzioneRichs) {
			if (entityCache.getResult(
						OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
						OpzioneRichImpl.class, opzioneRich.getPrimaryKey()) == null) {
				cacheResult(opzioneRich);
			}
			else {
				opzioneRich.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all opzione richs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OpzioneRichImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the opzione rich.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OpzioneRich opzioneRich) {
		entityCache.removeResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichImpl.class, opzioneRich.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OpzioneRich> opzioneRichs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OpzioneRich opzioneRich : opzioneRichs) {
			entityCache.removeResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
				OpzioneRichImpl.class, opzioneRich.getPrimaryKey());
		}
	}

	/**
	 * Creates a new opzione rich with the primary key. Does not add the opzione rich to the database.
	 *
	 * @param id_opt the primary key for the new opzione rich
	 * @return the new opzione rich
	 */
	@Override
	public OpzioneRich create(long id_opt) {
		OpzioneRich opzioneRich = new OpzioneRichImpl();

		opzioneRich.setNew(true);
		opzioneRich.setPrimaryKey(id_opt);

		return opzioneRich;
	}

	/**
	 * Removes the opzione rich with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_opt the primary key of the opzione rich
	 * @return the opzione rich that was removed
	 * @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	 */
	@Override
	public OpzioneRich remove(long id_opt) throws NoSuchOpzioneRichException {
		return remove((Serializable)id_opt);
	}

	/**
	 * Removes the opzione rich with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the opzione rich
	 * @return the opzione rich that was removed
	 * @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	 */
	@Override
	public OpzioneRich remove(Serializable primaryKey)
		throws NoSuchOpzioneRichException {
		Session session = null;

		try {
			session = openSession();

			OpzioneRich opzioneRich = (OpzioneRich)session.get(OpzioneRichImpl.class,
					primaryKey);

			if (opzioneRich == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOpzioneRichException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(opzioneRich);
		}
		catch (NoSuchOpzioneRichException nsee) {
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
	protected OpzioneRich removeImpl(OpzioneRich opzioneRich) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(opzioneRich)) {
				opzioneRich = (OpzioneRich)session.get(OpzioneRichImpl.class,
						opzioneRich.getPrimaryKeyObj());
			}

			if (opzioneRich != null) {
				session.delete(opzioneRich);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (opzioneRich != null) {
			clearCache(opzioneRich);
		}

		return opzioneRich;
	}

	@Override
	public OpzioneRich updateImpl(OpzioneRich opzioneRich) {
		boolean isNew = opzioneRich.isNew();

		if (!(opzioneRich instanceof OpzioneRichModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(opzioneRich.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(opzioneRich);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in opzioneRich proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OpzioneRich implementation " +
				opzioneRich.getClass());
		}

		OpzioneRichModelImpl opzioneRichModelImpl = (OpzioneRichModelImpl)opzioneRich;

		Session session = null;

		try {
			session = openSession();

			if (opzioneRich.isNew()) {
				session.save(opzioneRich);

				opzioneRich.setNew(false);
			}
			else {
				opzioneRich = (OpzioneRich)session.merge(opzioneRich);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!OpzioneRichModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { opzioneRichModelImpl.getLabel_opt() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LABEL_OPT, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_OPT,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((opzioneRichModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_OPT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						opzioneRichModelImpl.getOriginalLabel_opt()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABEL_OPT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_OPT,
					args);

				args = new Object[] { opzioneRichModelImpl.getLabel_opt() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABEL_OPT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_OPT,
					args);
			}
		}

		entityCache.putResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
			OpzioneRichImpl.class, opzioneRich.getPrimaryKey(), opzioneRich,
			false);

		opzioneRich.resetOriginalValues();

		return opzioneRich;
	}

	/**
	 * Returns the opzione rich with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the opzione rich
	 * @return the opzione rich
	 * @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	 */
	@Override
	public OpzioneRich findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOpzioneRichException {
		OpzioneRich opzioneRich = fetchByPrimaryKey(primaryKey);

		if (opzioneRich == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOpzioneRichException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return opzioneRich;
	}

	/**
	 * Returns the opzione rich with the primary key or throws a {@link NoSuchOpzioneRichException} if it could not be found.
	 *
	 * @param id_opt the primary key of the opzione rich
	 * @return the opzione rich
	 * @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	 */
	@Override
	public OpzioneRich findByPrimaryKey(long id_opt)
		throws NoSuchOpzioneRichException {
		return findByPrimaryKey((Serializable)id_opt);
	}

	/**
	 * Returns the opzione rich with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the opzione rich
	 * @return the opzione rich, or <code>null</code> if a opzione rich with the primary key could not be found
	 */
	@Override
	public OpzioneRich fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
				OpzioneRichImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		OpzioneRich opzioneRich = (OpzioneRich)serializable;

		if (opzioneRich == null) {
			Session session = null;

			try {
				session = openSession();

				opzioneRich = (OpzioneRich)session.get(OpzioneRichImpl.class,
						primaryKey);

				if (opzioneRich != null) {
					cacheResult(opzioneRich);
				}
				else {
					entityCache.putResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
						OpzioneRichImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
					OpzioneRichImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return opzioneRich;
	}

	/**
	 * Returns the opzione rich with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_opt the primary key of the opzione rich
	 * @return the opzione rich, or <code>null</code> if a opzione rich with the primary key could not be found
	 */
	@Override
	public OpzioneRich fetchByPrimaryKey(long id_opt) {
		return fetchByPrimaryKey((Serializable)id_opt);
	}

	@Override
	public Map<Serializable, OpzioneRich> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, OpzioneRich> map = new HashMap<Serializable, OpzioneRich>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			OpzioneRich opzioneRich = fetchByPrimaryKey(primaryKey);

			if (opzioneRich != null) {
				map.put(primaryKey, opzioneRich);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
					OpzioneRichImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (OpzioneRich)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OPZIONERICH_WHERE_PKS_IN);

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

			for (OpzioneRich opzioneRich : (List<OpzioneRich>)q.list()) {
				map.put(opzioneRich.getPrimaryKeyObj(), opzioneRich);

				cacheResult(opzioneRich);

				uncachedPrimaryKeys.remove(opzioneRich.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OpzioneRichModelImpl.ENTITY_CACHE_ENABLED,
					OpzioneRichImpl.class, primaryKey, nullModel);
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
	 * Returns all the opzione richs.
	 *
	 * @return the opzione richs
	 */
	@Override
	public List<OpzioneRich> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the opzione richs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of opzione richs
	 * @param end the upper bound of the range of opzione richs (not inclusive)
	 * @return the range of opzione richs
	 */
	@Override
	public List<OpzioneRich> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the opzione richs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of opzione richs
	 * @param end the upper bound of the range of opzione richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of opzione richs
	 */
	@Override
	public List<OpzioneRich> findAll(int start, int end,
		OrderByComparator<OpzioneRich> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the opzione richs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of opzione richs
	 * @param end the upper bound of the range of opzione richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of opzione richs
	 */
	@Override
	public List<OpzioneRich> findAll(int start, int end,
		OrderByComparator<OpzioneRich> orderByComparator,
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

		List<OpzioneRich> list = null;

		if (retrieveFromCache) {
			list = (List<OpzioneRich>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OPZIONERICH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OPZIONERICH;

				if (pagination) {
					sql = sql.concat(OpzioneRichModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OpzioneRich>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OpzioneRich>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the opzione richs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OpzioneRich opzioneRich : findAll()) {
			remove(opzioneRich);
		}
	}

	/**
	 * Returns the number of opzione richs.
	 *
	 * @return the number of opzione richs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OPZIONERICH);

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
		return OpzioneRichModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the opzione rich persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OpzioneRichImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_OPZIONERICH = "SELECT opzioneRich FROM OpzioneRich opzioneRich";
	private static final String _SQL_SELECT_OPZIONERICH_WHERE_PKS_IN = "SELECT opzioneRich FROM OpzioneRich opzioneRich WHERE id_opt IN (";
	private static final String _SQL_SELECT_OPZIONERICH_WHERE = "SELECT opzioneRich FROM OpzioneRich opzioneRich WHERE ";
	private static final String _SQL_COUNT_OPZIONERICH = "SELECT COUNT(opzioneRich) FROM OpzioneRich opzioneRich";
	private static final String _SQL_COUNT_OPZIONERICH_WHERE = "SELECT COUNT(opzioneRich) FROM OpzioneRich opzioneRich WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "opzioneRich.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OpzioneRich exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OpzioneRich exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(OpzioneRichPersistenceImpl.class);
}