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

package servizio.prenotazione.aule.mef.service.persistence.impl;

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

import servizio.prenotazione.aule.mef.exception.NoSuchServizioLogException;
import servizio.prenotazione.aule.mef.model.ServizioLog;
import servizio.prenotazione.aule.mef.model.impl.ServizioLogImpl;
import servizio.prenotazione.aule.mef.model.impl.ServizioLogModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.ServizioLogPersistence;

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
 * The persistence implementation for the servizio log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLogPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.ServizioLogUtil
 * @generated
 */
@ProviderType
public class ServizioLogPersistenceImpl extends BasePersistenceImpl<ServizioLog>
	implements ServizioLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServizioLogUtil} to access the servizio log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServizioLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogModelImpl.FINDER_CACHE_ENABLED, ServizioLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogModelImpl.FINDER_CACHE_ENABLED, ServizioLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCSERVIZIO =
		new FinderPath(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogModelImpl.FINDER_CACHE_ENABLED, ServizioLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDescServizio",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSERVIZIO =
		new FinderPath(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogModelImpl.FINDER_CACHE_ENABLED, ServizioLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDescServizio",
			new String[] { String.class.getName() },
			ServizioLogModelImpl.DESC_SERVIZIO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCSERVIZIO = new FinderPath(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescServizio",
			new String[] { String.class.getName() });

	/**
	 * Returns all the servizio logs where desc_servizio = &#63;.
	 *
	 * @param desc_servizio the desc_servizio
	 * @return the matching servizio logs
	 */
	@Override
	public List<ServizioLog> findByDescServizio(String desc_servizio) {
		return findByDescServizio(desc_servizio, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio logs where desc_servizio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_servizio the desc_servizio
	 * @param start the lower bound of the range of servizio logs
	 * @param end the upper bound of the range of servizio logs (not inclusive)
	 * @return the range of matching servizio logs
	 */
	@Override
	public List<ServizioLog> findByDescServizio(String desc_servizio,
		int start, int end) {
		return findByDescServizio(desc_servizio, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio logs where desc_servizio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_servizio the desc_servizio
	 * @param start the lower bound of the range of servizio logs
	 * @param end the upper bound of the range of servizio logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio logs
	 */
	@Override
	public List<ServizioLog> findByDescServizio(String desc_servizio,
		int start, int end, OrderByComparator<ServizioLog> orderByComparator) {
		return findByDescServizio(desc_servizio, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the servizio logs where desc_servizio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_servizio the desc_servizio
	 * @param start the lower bound of the range of servizio logs
	 * @param end the upper bound of the range of servizio logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching servizio logs
	 */
	@Override
	public List<ServizioLog> findByDescServizio(String desc_servizio,
		int start, int end, OrderByComparator<ServizioLog> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSERVIZIO;
			finderArgs = new Object[] { desc_servizio };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCSERVIZIO;
			finderArgs = new Object[] {
					desc_servizio,
					
					start, end, orderByComparator
				};
		}

		List<ServizioLog> list = null;

		if (retrieveFromCache) {
			list = (List<ServizioLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServizioLog servizioLog : list) {
					if (!Objects.equals(desc_servizio,
								servizioLog.getDesc_servizio())) {
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

			query.append(_SQL_SELECT_SERVIZIOLOG_WHERE);

			boolean bindDesc_servizio = false;

			if (desc_servizio == null) {
				query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_1);
			}
			else if (desc_servizio.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_3);
			}
			else {
				bindDesc_servizio = true;

				query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServizioLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesc_servizio) {
					qPos.add(desc_servizio);
				}

				if (!pagination) {
					list = (List<ServizioLog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServizioLog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first servizio log in the ordered set where desc_servizio = &#63;.
	 *
	 * @param desc_servizio the desc_servizio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio log
	 * @throws NoSuchServizioLogException if a matching servizio log could not be found
	 */
	@Override
	public ServizioLog findByDescServizio_First(String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator)
		throws NoSuchServizioLogException {
		ServizioLog servizioLog = fetchByDescServizio_First(desc_servizio,
				orderByComparator);

		if (servizioLog != null) {
			return servizioLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("desc_servizio=");
		msg.append(desc_servizio);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioLogException(msg.toString());
	}

	/**
	 * Returns the first servizio log in the ordered set where desc_servizio = &#63;.
	 *
	 * @param desc_servizio the desc_servizio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio log, or <code>null</code> if a matching servizio log could not be found
	 */
	@Override
	public ServizioLog fetchByDescServizio_First(String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator) {
		List<ServizioLog> list = findByDescServizio(desc_servizio, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio log in the ordered set where desc_servizio = &#63;.
	 *
	 * @param desc_servizio the desc_servizio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio log
	 * @throws NoSuchServizioLogException if a matching servizio log could not be found
	 */
	@Override
	public ServizioLog findByDescServizio_Last(String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator)
		throws NoSuchServizioLogException {
		ServizioLog servizioLog = fetchByDescServizio_Last(desc_servizio,
				orderByComparator);

		if (servizioLog != null) {
			return servizioLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("desc_servizio=");
		msg.append(desc_servizio);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioLogException(msg.toString());
	}

	/**
	 * Returns the last servizio log in the ordered set where desc_servizio = &#63;.
	 *
	 * @param desc_servizio the desc_servizio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio log, or <code>null</code> if a matching servizio log could not be found
	 */
	@Override
	public ServizioLog fetchByDescServizio_Last(String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator) {
		int count = countByDescServizio(desc_servizio);

		if (count == 0) {
			return null;
		}

		List<ServizioLog> list = findByDescServizio(desc_servizio, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizio logs before and after the current servizio log in the ordered set where desc_servizio = &#63;.
	 *
	 * @param id_servizio the primary key of the current servizio log
	 * @param desc_servizio the desc_servizio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio log
	 * @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	 */
	@Override
	public ServizioLog[] findByDescServizio_PrevAndNext(long id_servizio,
		String desc_servizio, OrderByComparator<ServizioLog> orderByComparator)
		throws NoSuchServizioLogException {
		ServizioLog servizioLog = findByPrimaryKey(id_servizio);

		Session session = null;

		try {
			session = openSession();

			ServizioLog[] array = new ServizioLogImpl[3];

			array[0] = getByDescServizio_PrevAndNext(session, servizioLog,
					desc_servizio, orderByComparator, true);

			array[1] = servizioLog;

			array[2] = getByDescServizio_PrevAndNext(session, servizioLog,
					desc_servizio, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServizioLog getByDescServizio_PrevAndNext(Session session,
		ServizioLog servizioLog, String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVIZIOLOG_WHERE);

		boolean bindDesc_servizio = false;

		if (desc_servizio == null) {
			query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_1);
		}
		else if (desc_servizio.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_3);
		}
		else {
			bindDesc_servizio = true;

			query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_2);
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
			query.append(ServizioLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDesc_servizio) {
			qPos.add(desc_servizio);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(servizioLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServizioLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizio logs where desc_servizio = &#63; from the database.
	 *
	 * @param desc_servizio the desc_servizio
	 */
	@Override
	public void removeByDescServizio(String desc_servizio) {
		for (ServizioLog servizioLog : findByDescServizio(desc_servizio,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(servizioLog);
		}
	}

	/**
	 * Returns the number of servizio logs where desc_servizio = &#63;.
	 *
	 * @param desc_servizio the desc_servizio
	 * @return the number of matching servizio logs
	 */
	@Override
	public int countByDescServizio(String desc_servizio) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCSERVIZIO;

		Object[] finderArgs = new Object[] { desc_servizio };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVIZIOLOG_WHERE);

			boolean bindDesc_servizio = false;

			if (desc_servizio == null) {
				query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_1);
			}
			else if (desc_servizio.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_3);
			}
			else {
				bindDesc_servizio = true;

				query.append(_FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesc_servizio) {
					qPos.add(desc_servizio);
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

	private static final String _FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_1 = "servizioLog.desc_servizio IS NULL";
	private static final String _FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_2 = "servizioLog.desc_servizio = ?";
	private static final String _FINDER_COLUMN_DESCSERVIZIO_DESC_SERVIZIO_3 = "(servizioLog.desc_servizio IS NULL OR servizioLog.desc_servizio = '')";

	public ServizioLogPersistenceImpl() {
		setModelClass(ServizioLog.class);
	}

	/**
	 * Caches the servizio log in the entity cache if it is enabled.
	 *
	 * @param servizioLog the servizio log
	 */
	@Override
	public void cacheResult(ServizioLog servizioLog) {
		entityCache.putResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogImpl.class, servizioLog.getPrimaryKey(), servizioLog);

		servizioLog.resetOriginalValues();
	}

	/**
	 * Caches the servizio logs in the entity cache if it is enabled.
	 *
	 * @param servizioLogs the servizio logs
	 */
	@Override
	public void cacheResult(List<ServizioLog> servizioLogs) {
		for (ServizioLog servizioLog : servizioLogs) {
			if (entityCache.getResult(
						ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
						ServizioLogImpl.class, servizioLog.getPrimaryKey()) == null) {
				cacheResult(servizioLog);
			}
			else {
				servizioLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all servizio logs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServizioLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the servizio log.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServizioLog servizioLog) {
		entityCache.removeResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogImpl.class, servizioLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServizioLog> servizioLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServizioLog servizioLog : servizioLogs) {
			entityCache.removeResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
				ServizioLogImpl.class, servizioLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new servizio log with the primary key. Does not add the servizio log to the database.
	 *
	 * @param id_servizio the primary key for the new servizio log
	 * @return the new servizio log
	 */
	@Override
	public ServizioLog create(long id_servizio) {
		ServizioLog servizioLog = new ServizioLogImpl();

		servizioLog.setNew(true);
		servizioLog.setPrimaryKey(id_servizio);

		return servizioLog;
	}

	/**
	 * Removes the servizio log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_servizio the primary key of the servizio log
	 * @return the servizio log that was removed
	 * @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	 */
	@Override
	public ServizioLog remove(long id_servizio)
		throws NoSuchServizioLogException {
		return remove((Serializable)id_servizio);
	}

	/**
	 * Removes the servizio log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the servizio log
	 * @return the servizio log that was removed
	 * @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	 */
	@Override
	public ServizioLog remove(Serializable primaryKey)
		throws NoSuchServizioLogException {
		Session session = null;

		try {
			session = openSession();

			ServizioLog servizioLog = (ServizioLog)session.get(ServizioLogImpl.class,
					primaryKey);

			if (servizioLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServizioLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(servizioLog);
		}
		catch (NoSuchServizioLogException nsee) {
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
	protected ServizioLog removeImpl(ServizioLog servizioLog) {
		servizioLog = toUnwrappedModel(servizioLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(servizioLog)) {
				servizioLog = (ServizioLog)session.get(ServizioLogImpl.class,
						servizioLog.getPrimaryKeyObj());
			}

			if (servizioLog != null) {
				session.delete(servizioLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (servizioLog != null) {
			clearCache(servizioLog);
		}

		return servizioLog;
	}

	@Override
	public ServizioLog updateImpl(ServizioLog servizioLog) {
		servizioLog = toUnwrappedModel(servizioLog);

		boolean isNew = servizioLog.isNew();

		ServizioLogModelImpl servizioLogModelImpl = (ServizioLogModelImpl)servizioLog;

		Session session = null;

		try {
			session = openSession();

			if (servizioLog.isNew()) {
				session.save(servizioLog);

				servizioLog.setNew(false);
			}
			else {
				servizioLog = (ServizioLog)session.merge(servizioLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServizioLogModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((servizioLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSERVIZIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						servizioLogModelImpl.getOriginalDesc_servizio()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCSERVIZIO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSERVIZIO,
					args);

				args = new Object[] { servizioLogModelImpl.getDesc_servizio() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCSERVIZIO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSERVIZIO,
					args);
			}
		}

		entityCache.putResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
			ServizioLogImpl.class, servizioLog.getPrimaryKey(), servizioLog,
			false);

		servizioLog.resetOriginalValues();

		return servizioLog;
	}

	protected ServizioLog toUnwrappedModel(ServizioLog servizioLog) {
		if (servizioLog instanceof ServizioLogImpl) {
			return servizioLog;
		}

		ServizioLogImpl servizioLogImpl = new ServizioLogImpl();

		servizioLogImpl.setNew(servizioLog.isNew());
		servizioLogImpl.setPrimaryKey(servizioLog.getPrimaryKey());

		servizioLogImpl.setId_servizio(servizioLog.getId_servizio());
		servizioLogImpl.setDesc_servizio(servizioLog.getDesc_servizio());
		servizioLogImpl.setEmail_ref(servizioLog.getEmail_ref());

		return servizioLogImpl;
	}

	/**
	 * Returns the servizio log with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio log
	 * @return the servizio log
	 * @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	 */
	@Override
	public ServizioLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServizioLogException {
		ServizioLog servizioLog = fetchByPrimaryKey(primaryKey);

		if (servizioLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServizioLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return servizioLog;
	}

	/**
	 * Returns the servizio log with the primary key or throws a {@link NoSuchServizioLogException} if it could not be found.
	 *
	 * @param id_servizio the primary key of the servizio log
	 * @return the servizio log
	 * @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	 */
	@Override
	public ServizioLog findByPrimaryKey(long id_servizio)
		throws NoSuchServizioLogException {
		return findByPrimaryKey((Serializable)id_servizio);
	}

	/**
	 * Returns the servizio log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio log
	 * @return the servizio log, or <code>null</code> if a servizio log with the primary key could not be found
	 */
	@Override
	public ServizioLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
				ServizioLogImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ServizioLog servizioLog = (ServizioLog)serializable;

		if (servizioLog == null) {
			Session session = null;

			try {
				session = openSession();

				servizioLog = (ServizioLog)session.get(ServizioLogImpl.class,
						primaryKey);

				if (servizioLog != null) {
					cacheResult(servizioLog);
				}
				else {
					entityCache.putResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
						ServizioLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
					ServizioLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return servizioLog;
	}

	/**
	 * Returns the servizio log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_servizio the primary key of the servizio log
	 * @return the servizio log, or <code>null</code> if a servizio log with the primary key could not be found
	 */
	@Override
	public ServizioLog fetchByPrimaryKey(long id_servizio) {
		return fetchByPrimaryKey((Serializable)id_servizio);
	}

	@Override
	public Map<Serializable, ServizioLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ServizioLog> map = new HashMap<Serializable, ServizioLog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ServizioLog servizioLog = fetchByPrimaryKey(primaryKey);

			if (servizioLog != null) {
				map.put(primaryKey, servizioLog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
					ServizioLogImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ServizioLog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SERVIZIOLOG_WHERE_PKS_IN);

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

			for (ServizioLog servizioLog : (List<ServizioLog>)q.list()) {
				map.put(servizioLog.getPrimaryKeyObj(), servizioLog);

				cacheResult(servizioLog);

				uncachedPrimaryKeys.remove(servizioLog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ServizioLogModelImpl.ENTITY_CACHE_ENABLED,
					ServizioLogImpl.class, primaryKey, nullModel);
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
	 * Returns all the servizio logs.
	 *
	 * @return the servizio logs
	 */
	@Override
	public List<ServizioLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio logs
	 * @param end the upper bound of the range of servizio logs (not inclusive)
	 * @return the range of servizio logs
	 */
	@Override
	public List<ServizioLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio logs
	 * @param end the upper bound of the range of servizio logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizio logs
	 */
	@Override
	public List<ServizioLog> findAll(int start, int end,
		OrderByComparator<ServizioLog> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio logs
	 * @param end the upper bound of the range of servizio logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of servizio logs
	 */
	@Override
	public List<ServizioLog> findAll(int start, int end,
		OrderByComparator<ServizioLog> orderByComparator,
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

		List<ServizioLog> list = null;

		if (retrieveFromCache) {
			list = (List<ServizioLog>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SERVIZIOLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVIZIOLOG;

				if (pagination) {
					sql = sql.concat(ServizioLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServizioLog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServizioLog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the servizio logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServizioLog servizioLog : findAll()) {
			remove(servizioLog);
		}
	}

	/**
	 * Returns the number of servizio logs.
	 *
	 * @return the number of servizio logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVIZIOLOG);

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
		return ServizioLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the servizio log persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ServizioLogImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SERVIZIOLOG = "SELECT servizioLog FROM ServizioLog servizioLog";
	private static final String _SQL_SELECT_SERVIZIOLOG_WHERE_PKS_IN = "SELECT servizioLog FROM ServizioLog servizioLog WHERE id_servizio IN (";
	private static final String _SQL_SELECT_SERVIZIOLOG_WHERE = "SELECT servizioLog FROM ServizioLog servizioLog WHERE ";
	private static final String _SQL_COUNT_SERVIZIOLOG = "SELECT COUNT(servizioLog) FROM ServizioLog servizioLog";
	private static final String _SQL_COUNT_SERVIZIOLOG_WHERE = "SELECT COUNT(servizioLog) FROM ServizioLog servizioLog WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "servizioLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServizioLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServizioLog exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ServizioLogPersistenceImpl.class);
}