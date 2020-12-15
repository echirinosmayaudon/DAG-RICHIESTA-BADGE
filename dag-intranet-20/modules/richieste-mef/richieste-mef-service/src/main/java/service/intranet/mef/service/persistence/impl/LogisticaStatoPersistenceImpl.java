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

import service.intranet.mef.exception.NoSuchLogisticaStatoException;
import service.intranet.mef.model.LogisticaStato;
import service.intranet.mef.model.impl.LogisticaStatoImpl;
import service.intranet.mef.model.impl.LogisticaStatoModelImpl;
import service.intranet.mef.service.persistence.LogisticaStatoPersistence;

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
 * The persistence implementation for the logistica stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaStatoPersistence
 * @see service.intranet.mef.service.persistence.LogisticaStatoUtil
 * @generated
 */
@ProviderType
public class LogisticaStatoPersistenceImpl extends BasePersistenceImpl<LogisticaStato>
	implements LogisticaStatoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogisticaStatoUtil} to access the logistica stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogisticaStatoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoModelImpl.FINDER_CACHE_ENABLED,
			LogisticaStatoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoModelImpl.FINDER_CACHE_ENABLED,
			LogisticaStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UTENTE = new FinderPath(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoModelImpl.FINDER_CACHE_ENABLED,
			LogisticaStatoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtente",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE =
		new FinderPath(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoModelImpl.FINDER_CACHE_ENABLED,
			LogisticaStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUtente",
			new String[] { String.class.getName() },
			LogisticaStatoModelImpl.UTENTE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UTENTE = new FinderPath(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUtente",
			new String[] { String.class.getName() });

	/**
	 * Returns all the logistica statos where utente = &#63;.
	 *
	 * @param utente the utente
	 * @return the matching logistica statos
	 */
	@Override
	public List<LogisticaStato> findByUtente(String utente) {
		return findByUtente(utente, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the logistica statos where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of logistica statos
	 * @param end the upper bound of the range of logistica statos (not inclusive)
	 * @return the range of matching logistica statos
	 */
	@Override
	public List<LogisticaStato> findByUtente(String utente, int start, int end) {
		return findByUtente(utente, start, end, null);
	}

	/**
	 * Returns an ordered range of all the logistica statos where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of logistica statos
	 * @param end the upper bound of the range of logistica statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching logistica statos
	 */
	@Override
	public List<LogisticaStato> findByUtente(String utente, int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator) {
		return findByUtente(utente, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the logistica statos where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of logistica statos
	 * @param end the upper bound of the range of logistica statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching logistica statos
	 */
	@Override
	public List<LogisticaStato> findByUtente(String utente, int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator,
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

		List<LogisticaStato> list = null;

		if (retrieveFromCache) {
			list = (List<LogisticaStato>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LogisticaStato logisticaStato : list) {
					if (!Objects.equals(utente, logisticaStato.getUtente())) {
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

			query.append(_SQL_SELECT_LOGISTICASTATO_WHERE);

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
				query.append(LogisticaStatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<LogisticaStato>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogisticaStato>)QueryUtil.list(q,
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
	 * Returns the first logistica stato in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logistica stato
	 * @throws NoSuchLogisticaStatoException if a matching logistica stato could not be found
	 */
	@Override
	public LogisticaStato findByUtente_First(String utente,
		OrderByComparator<LogisticaStato> orderByComparator)
		throws NoSuchLogisticaStatoException {
		LogisticaStato logisticaStato = fetchByUtente_First(utente,
				orderByComparator);

		if (logisticaStato != null) {
			return logisticaStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("utente=");
		msg.append(utente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogisticaStatoException(msg.toString());
	}

	/**
	 * Returns the first logistica stato in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logistica stato, or <code>null</code> if a matching logistica stato could not be found
	 */
	@Override
	public LogisticaStato fetchByUtente_First(String utente,
		OrderByComparator<LogisticaStato> orderByComparator) {
		List<LogisticaStato> list = findByUtente(utente, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logistica stato in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logistica stato
	 * @throws NoSuchLogisticaStatoException if a matching logistica stato could not be found
	 */
	@Override
	public LogisticaStato findByUtente_Last(String utente,
		OrderByComparator<LogisticaStato> orderByComparator)
		throws NoSuchLogisticaStatoException {
		LogisticaStato logisticaStato = fetchByUtente_Last(utente,
				orderByComparator);

		if (logisticaStato != null) {
			return logisticaStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("utente=");
		msg.append(utente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogisticaStatoException(msg.toString());
	}

	/**
	 * Returns the last logistica stato in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logistica stato, or <code>null</code> if a matching logistica stato could not be found
	 */
	@Override
	public LogisticaStato fetchByUtente_Last(String utente,
		OrderByComparator<LogisticaStato> orderByComparator) {
		int count = countByUtente(utente);

		if (count == 0) {
			return null;
		}

		List<LogisticaStato> list = findByUtente(utente, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the logistica statos before and after the current logistica stato in the ordered set where utente = &#63;.
	 *
	 * @param id the primary key of the current logistica stato
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logistica stato
	 * @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	 */
	@Override
	public LogisticaStato[] findByUtente_PrevAndNext(long id, String utente,
		OrderByComparator<LogisticaStato> orderByComparator)
		throws NoSuchLogisticaStatoException {
		LogisticaStato logisticaStato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LogisticaStato[] array = new LogisticaStatoImpl[3];

			array[0] = getByUtente_PrevAndNext(session, logisticaStato, utente,
					orderByComparator, true);

			array[1] = logisticaStato;

			array[2] = getByUtente_PrevAndNext(session, logisticaStato, utente,
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

	protected LogisticaStato getByUtente_PrevAndNext(Session session,
		LogisticaStato logisticaStato, String utente,
		OrderByComparator<LogisticaStato> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGISTICASTATO_WHERE);

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
			query.append(LogisticaStatoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(logisticaStato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogisticaStato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the logistica statos where utente = &#63; from the database.
	 *
	 * @param utente the utente
	 */
	@Override
	public void removeByUtente(String utente) {
		for (LogisticaStato logisticaStato : findByUtente(utente,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(logisticaStato);
		}
	}

	/**
	 * Returns the number of logistica statos where utente = &#63;.
	 *
	 * @param utente the utente
	 * @return the number of matching logistica statos
	 */
	@Override
	public int countByUtente(String utente) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UTENTE;

		Object[] finderArgs = new Object[] { utente };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGISTICASTATO_WHERE);

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

	private static final String _FINDER_COLUMN_UTENTE_UTENTE_1 = "logisticaStato.utente IS NULL";
	private static final String _FINDER_COLUMN_UTENTE_UTENTE_2 = "logisticaStato.utente = ?";
	private static final String _FINDER_COLUMN_UTENTE_UTENTE_3 = "(logisticaStato.utente IS NULL OR logisticaStato.utente = '')";

	public LogisticaStatoPersistenceImpl() {
		setModelClass(LogisticaStato.class);
	}

	/**
	 * Caches the logistica stato in the entity cache if it is enabled.
	 *
	 * @param logisticaStato the logistica stato
	 */
	@Override
	public void cacheResult(LogisticaStato logisticaStato) {
		entityCache.putResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoImpl.class, logisticaStato.getPrimaryKey(),
			logisticaStato);

		logisticaStato.resetOriginalValues();
	}

	/**
	 * Caches the logistica statos in the entity cache if it is enabled.
	 *
	 * @param logisticaStatos the logistica statos
	 */
	@Override
	public void cacheResult(List<LogisticaStato> logisticaStatos) {
		for (LogisticaStato logisticaStato : logisticaStatos) {
			if (entityCache.getResult(
						LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
						LogisticaStatoImpl.class, logisticaStato.getPrimaryKey()) == null) {
				cacheResult(logisticaStato);
			}
			else {
				logisticaStato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all logistica statos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LogisticaStatoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the logistica stato.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogisticaStato logisticaStato) {
		entityCache.removeResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoImpl.class, logisticaStato.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogisticaStato> logisticaStatos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogisticaStato logisticaStato : logisticaStatos) {
			entityCache.removeResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
				LogisticaStatoImpl.class, logisticaStato.getPrimaryKey());
		}
	}

	/**
	 * Creates a new logistica stato with the primary key. Does not add the logistica stato to the database.
	 *
	 * @param id the primary key for the new logistica stato
	 * @return the new logistica stato
	 */
	@Override
	public LogisticaStato create(long id) {
		LogisticaStato logisticaStato = new LogisticaStatoImpl();

		logisticaStato.setNew(true);
		logisticaStato.setPrimaryKey(id);

		return logisticaStato;
	}

	/**
	 * Removes the logistica stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the logistica stato
	 * @return the logistica stato that was removed
	 * @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	 */
	@Override
	public LogisticaStato remove(long id) throws NoSuchLogisticaStatoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the logistica stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the logistica stato
	 * @return the logistica stato that was removed
	 * @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	 */
	@Override
	public LogisticaStato remove(Serializable primaryKey)
		throws NoSuchLogisticaStatoException {
		Session session = null;

		try {
			session = openSession();

			LogisticaStato logisticaStato = (LogisticaStato)session.get(LogisticaStatoImpl.class,
					primaryKey);

			if (logisticaStato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogisticaStatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logisticaStato);
		}
		catch (NoSuchLogisticaStatoException nsee) {
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
	protected LogisticaStato removeImpl(LogisticaStato logisticaStato) {
		logisticaStato = toUnwrappedModel(logisticaStato);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logisticaStato)) {
				logisticaStato = (LogisticaStato)session.get(LogisticaStatoImpl.class,
						logisticaStato.getPrimaryKeyObj());
			}

			if (logisticaStato != null) {
				session.delete(logisticaStato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logisticaStato != null) {
			clearCache(logisticaStato);
		}

		return logisticaStato;
	}

	@Override
	public LogisticaStato updateImpl(LogisticaStato logisticaStato) {
		logisticaStato = toUnwrappedModel(logisticaStato);

		boolean isNew = logisticaStato.isNew();

		LogisticaStatoModelImpl logisticaStatoModelImpl = (LogisticaStatoModelImpl)logisticaStato;

		Session session = null;

		try {
			session = openSession();

			if (logisticaStato.isNew()) {
				session.save(logisticaStato);

				logisticaStato.setNew(false);
			}
			else {
				logisticaStato = (LogisticaStato)session.merge(logisticaStato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LogisticaStatoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((logisticaStatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logisticaStatoModelImpl.getOriginalUtente()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UTENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE,
					args);

				args = new Object[] { logisticaStatoModelImpl.getUtente() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UTENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE,
					args);
			}
		}

		entityCache.putResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaStatoImpl.class, logisticaStato.getPrimaryKey(),
			logisticaStato, false);

		logisticaStato.resetOriginalValues();

		return logisticaStato;
	}

	protected LogisticaStato toUnwrappedModel(LogisticaStato logisticaStato) {
		if (logisticaStato instanceof LogisticaStatoImpl) {
			return logisticaStato;
		}

		LogisticaStatoImpl logisticaStatoImpl = new LogisticaStatoImpl();

		logisticaStatoImpl.setNew(logisticaStato.isNew());
		logisticaStatoImpl.setPrimaryKey(logisticaStato.getPrimaryKey());

		logisticaStatoImpl.setId(logisticaStato.getId());
		logisticaStatoImpl.setDescrizione(logisticaStato.getDescrizione());
		logisticaStatoImpl.setUtente(logisticaStato.getUtente());

		return logisticaStatoImpl;
	}

	/**
	 * Returns the logistica stato with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the logistica stato
	 * @return the logistica stato
	 * @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	 */
	@Override
	public LogisticaStato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogisticaStatoException {
		LogisticaStato logisticaStato = fetchByPrimaryKey(primaryKey);

		if (logisticaStato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogisticaStatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return logisticaStato;
	}

	/**
	 * Returns the logistica stato with the primary key or throws a {@link NoSuchLogisticaStatoException} if it could not be found.
	 *
	 * @param id the primary key of the logistica stato
	 * @return the logistica stato
	 * @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	 */
	@Override
	public LogisticaStato findByPrimaryKey(long id)
		throws NoSuchLogisticaStatoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the logistica stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the logistica stato
	 * @return the logistica stato, or <code>null</code> if a logistica stato with the primary key could not be found
	 */
	@Override
	public LogisticaStato fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
				LogisticaStatoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LogisticaStato logisticaStato = (LogisticaStato)serializable;

		if (logisticaStato == null) {
			Session session = null;

			try {
				session = openSession();

				logisticaStato = (LogisticaStato)session.get(LogisticaStatoImpl.class,
						primaryKey);

				if (logisticaStato != null) {
					cacheResult(logisticaStato);
				}
				else {
					entityCache.putResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
						LogisticaStatoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaStatoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logisticaStato;
	}

	/**
	 * Returns the logistica stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the logistica stato
	 * @return the logistica stato, or <code>null</code> if a logistica stato with the primary key could not be found
	 */
	@Override
	public LogisticaStato fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, LogisticaStato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LogisticaStato> map = new HashMap<Serializable, LogisticaStato>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LogisticaStato logisticaStato = fetchByPrimaryKey(primaryKey);

			if (logisticaStato != null) {
				map.put(primaryKey, logisticaStato);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaStatoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LogisticaStato)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOGISTICASTATO_WHERE_PKS_IN);

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

			for (LogisticaStato logisticaStato : (List<LogisticaStato>)q.list()) {
				map.put(logisticaStato.getPrimaryKeyObj(), logisticaStato);

				cacheResult(logisticaStato);

				uncachedPrimaryKeys.remove(logisticaStato.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LogisticaStatoModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaStatoImpl.class, primaryKey, nullModel);
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
	 * Returns all the logistica statos.
	 *
	 * @return the logistica statos
	 */
	@Override
	public List<LogisticaStato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the logistica statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica statos
	 * @param end the upper bound of the range of logistica statos (not inclusive)
	 * @return the range of logistica statos
	 */
	@Override
	public List<LogisticaStato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the logistica statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica statos
	 * @param end the upper bound of the range of logistica statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of logistica statos
	 */
	@Override
	public List<LogisticaStato> findAll(int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the logistica statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica statos
	 * @param end the upper bound of the range of logistica statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of logistica statos
	 */
	@Override
	public List<LogisticaStato> findAll(int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator,
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

		List<LogisticaStato> list = null;

		if (retrieveFromCache) {
			list = (List<LogisticaStato>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOGISTICASTATO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGISTICASTATO;

				if (pagination) {
					sql = sql.concat(LogisticaStatoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogisticaStato>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogisticaStato>)QueryUtil.list(q,
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
	 * Removes all the logistica statos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LogisticaStato logisticaStato : findAll()) {
			remove(logisticaStato);
		}
	}

	/**
	 * Returns the number of logistica statos.
	 *
	 * @return the number of logistica statos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGISTICASTATO);

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
		return LogisticaStatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the logistica stato persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LogisticaStatoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LOGISTICASTATO = "SELECT logisticaStato FROM LogisticaStato logisticaStato";
	private static final String _SQL_SELECT_LOGISTICASTATO_WHERE_PKS_IN = "SELECT logisticaStato FROM LogisticaStato logisticaStato WHERE id_ IN (";
	private static final String _SQL_SELECT_LOGISTICASTATO_WHERE = "SELECT logisticaStato FROM LogisticaStato logisticaStato WHERE ";
	private static final String _SQL_COUNT_LOGISTICASTATO = "SELECT COUNT(logisticaStato) FROM LogisticaStato logisticaStato";
	private static final String _SQL_COUNT_LOGISTICASTATO_WHERE = "SELECT COUNT(logisticaStato) FROM LogisticaStato logisticaStato WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logisticaStato.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogisticaStato exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LogisticaStato exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LogisticaStatoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}