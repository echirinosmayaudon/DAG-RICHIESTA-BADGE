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

import service.intranet.mef.exception.NoSuchLogisticaRichiesteException;
import service.intranet.mef.model.LogisticaRichieste;
import service.intranet.mef.model.impl.LogisticaRichiesteImpl;
import service.intranet.mef.model.impl.LogisticaRichiesteModelImpl;
import service.intranet.mef.service.persistence.LogisticaRichiestePersistence;

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
 * The persistence implementation for the logistica richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichiestePersistence
 * @see service.intranet.mef.service.persistence.LogisticaRichiesteUtil
 * @generated
 */
@ProviderType
public class LogisticaRichiestePersistenceImpl extends BasePersistenceImpl<LogisticaRichieste>
	implements LogisticaRichiestePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogisticaRichiesteUtil} to access the logistica richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogisticaRichiesteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED,
			LogisticaRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED,
			LogisticaRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UTENTE = new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED,
			LogisticaRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUtente",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE =
		new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED,
			LogisticaRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUtente",
			new String[] { String.class.getName() },
			LogisticaRichiesteModelImpl.UTENTE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UTENTE = new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUtente",
			new String[] { String.class.getName() });

	/**
	 * Returns all the logistica richiestes where utente = &#63;.
	 *
	 * @param utente the utente
	 * @return the matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByUtente(String utente) {
		return findByUtente(utente, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the logistica richiestes where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @return the range of matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByUtente(String utente, int start,
		int end) {
		return findByUtente(utente, start, end, null);
	}

	/**
	 * Returns an ordered range of all the logistica richiestes where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByUtente(String utente, int start,
		int end, OrderByComparator<LogisticaRichieste> orderByComparator) {
		return findByUtente(utente, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the logistica richiestes where utente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param utente the utente
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByUtente(String utente, int start,
		int end, OrderByComparator<LogisticaRichieste> orderByComparator,
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

		List<LogisticaRichieste> list = null;

		if (retrieveFromCache) {
			list = (List<LogisticaRichieste>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LogisticaRichieste logisticaRichieste : list) {
					if (!Objects.equals(utente, logisticaRichieste.getUtente())) {
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

			query.append(_SQL_SELECT_LOGISTICARICHIESTE_WHERE);

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
				query.append(LogisticaRichiesteModelImpl.ORDER_BY_JPQL);
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
					list = (List<LogisticaRichieste>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogisticaRichieste>)QueryUtil.list(q,
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
	 * Returns the first logistica richieste in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste findByUtente_First(String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException {
		LogisticaRichieste logisticaRichieste = fetchByUtente_First(utente,
				orderByComparator);

		if (logisticaRichieste != null) {
			return logisticaRichieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("utente=");
		msg.append(utente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogisticaRichiesteException(msg.toString());
	}

	/**
	 * Returns the first logistica richieste in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste fetchByUtente_First(String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		List<LogisticaRichieste> list = findByUtente(utente, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logistica richieste in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste findByUtente_Last(String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException {
		LogisticaRichieste logisticaRichieste = fetchByUtente_Last(utente,
				orderByComparator);

		if (logisticaRichieste != null) {
			return logisticaRichieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("utente=");
		msg.append(utente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogisticaRichiesteException(msg.toString());
	}

	/**
	 * Returns the last logistica richieste in the ordered set where utente = &#63;.
	 *
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste fetchByUtente_Last(String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		int count = countByUtente(utente);

		if (count == 0) {
			return null;
		}

		List<LogisticaRichieste> list = findByUtente(utente, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the logistica richiestes before and after the current logistica richieste in the ordered set where utente = &#63;.
	 *
	 * @param id the primary key of the current logistica richieste
	 * @param utente the utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste[] findByUtente_PrevAndNext(long id,
		String utente, OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException {
		LogisticaRichieste logisticaRichieste = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LogisticaRichieste[] array = new LogisticaRichiesteImpl[3];

			array[0] = getByUtente_PrevAndNext(session, logisticaRichieste,
					utente, orderByComparator, true);

			array[1] = logisticaRichieste;

			array[2] = getByUtente_PrevAndNext(session, logisticaRichieste,
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

	protected LogisticaRichieste getByUtente_PrevAndNext(Session session,
		LogisticaRichieste logisticaRichieste, String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGISTICARICHIESTE_WHERE);

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
			query.append(LogisticaRichiesteModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(logisticaRichieste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogisticaRichieste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the logistica richiestes where utente = &#63; from the database.
	 *
	 * @param utente the utente
	 */
	@Override
	public void removeByUtente(String utente) {
		for (LogisticaRichieste logisticaRichieste : findByUtente(utente,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(logisticaRichieste);
		}
	}

	/**
	 * Returns the number of logistica richiestes where utente = &#63;.
	 *
	 * @param utente the utente
	 * @return the number of matching logistica richiestes
	 */
	@Override
	public int countByUtente(String utente) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UTENTE;

		Object[] finderArgs = new Object[] { utente };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGISTICARICHIESTE_WHERE);

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

	private static final String _FINDER_COLUMN_UTENTE_UTENTE_1 = "logisticaRichieste.utente IS NULL";
	private static final String _FINDER_COLUMN_UTENTE_UTENTE_2 = "logisticaRichieste.utente = ?";
	private static final String _FINDER_COLUMN_UTENTE_UTENTE_3 = "(logisticaRichieste.utente IS NULL OR logisticaRichieste.utente = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTO =
		new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED,
			LogisticaRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDipartimento",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO =
		new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED,
			LogisticaRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDipartimento",
			new String[] { String.class.getName() },
			LogisticaRichiesteModelImpl.DIPARTIMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIPARTIMENTO = new FinderPath(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDipartimento",
			new String[] { String.class.getName() });

	/**
	 * Returns all the logistica richiestes where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @return the matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByDipartimento(String dipartimento) {
		return findByDipartimento(dipartimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the logistica richiestes where dipartimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dipartimento the dipartimento
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @return the range of matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByDipartimento(String dipartimento,
		int start, int end) {
		return findByDipartimento(dipartimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the logistica richiestes where dipartimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dipartimento the dipartimento
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByDipartimento(String dipartimento,
		int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return findByDipartimento(dipartimento, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the logistica richiestes where dipartimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dipartimento the dipartimento
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findByDipartimento(String dipartimento,
		int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO;
			finderArgs = new Object[] { dipartimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTO;
			finderArgs = new Object[] {
					dipartimento,
					
					start, end, orderByComparator
				};
		}

		List<LogisticaRichieste> list = null;

		if (retrieveFromCache) {
			list = (List<LogisticaRichieste>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LogisticaRichieste logisticaRichieste : list) {
					if (!Objects.equals(dipartimento,
								logisticaRichieste.getDipartimento())) {
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

			query.append(_SQL_SELECT_LOGISTICARICHIESTE_WHERE);

			boolean bindDipartimento = false;

			if (dipartimento == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1);
			}
			else if (dipartimento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3);
			}
			else {
				bindDipartimento = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogisticaRichiesteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDipartimento) {
					qPos.add(dipartimento);
				}

				if (!pagination) {
					list = (List<LogisticaRichieste>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogisticaRichieste>)QueryUtil.list(q,
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
	 * Returns the first logistica richieste in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste findByDipartimento_First(String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException {
		LogisticaRichieste logisticaRichieste = fetchByDipartimento_First(dipartimento,
				orderByComparator);

		if (logisticaRichieste != null) {
			return logisticaRichieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dipartimento=");
		msg.append(dipartimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogisticaRichiesteException(msg.toString());
	}

	/**
	 * Returns the first logistica richieste in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste fetchByDipartimento_First(String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		List<LogisticaRichieste> list = findByDipartimento(dipartimento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logistica richieste in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste findByDipartimento_Last(String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException {
		LogisticaRichieste logisticaRichieste = fetchByDipartimento_Last(dipartimento,
				orderByComparator);

		if (logisticaRichieste != null) {
			return logisticaRichieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dipartimento=");
		msg.append(dipartimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogisticaRichiesteException(msg.toString());
	}

	/**
	 * Returns the last logistica richieste in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	 */
	@Override
	public LogisticaRichieste fetchByDipartimento_Last(String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		int count = countByDipartimento(dipartimento);

		if (count == 0) {
			return null;
		}

		List<LogisticaRichieste> list = findByDipartimento(dipartimento,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the logistica richiestes before and after the current logistica richieste in the ordered set where dipartimento = &#63;.
	 *
	 * @param id the primary key of the current logistica richieste
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste[] findByDipartimento_PrevAndNext(long id,
		String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException {
		LogisticaRichieste logisticaRichieste = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LogisticaRichieste[] array = new LogisticaRichiesteImpl[3];

			array[0] = getByDipartimento_PrevAndNext(session,
					logisticaRichieste, dipartimento, orderByComparator, true);

			array[1] = logisticaRichieste;

			array[2] = getByDipartimento_PrevAndNext(session,
					logisticaRichieste, dipartimento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogisticaRichieste getByDipartimento_PrevAndNext(
		Session session, LogisticaRichieste logisticaRichieste,
		String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGISTICARICHIESTE_WHERE);

		boolean bindDipartimento = false;

		if (dipartimento == null) {
			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1);
		}
		else if (dipartimento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3);
		}
		else {
			bindDipartimento = true;

			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2);
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
			query.append(LogisticaRichiesteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDipartimento) {
			qPos.add(dipartimento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logisticaRichieste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogisticaRichieste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the logistica richiestes where dipartimento = &#63; from the database.
	 *
	 * @param dipartimento the dipartimento
	 */
	@Override
	public void removeByDipartimento(String dipartimento) {
		for (LogisticaRichieste logisticaRichieste : findByDipartimento(
				dipartimento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(logisticaRichieste);
		}
	}

	/**
	 * Returns the number of logistica richiestes where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @return the number of matching logistica richiestes
	 */
	@Override
	public int countByDipartimento(String dipartimento) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIPARTIMENTO;

		Object[] finderArgs = new Object[] { dipartimento };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGISTICARICHIESTE_WHERE);

			boolean bindDipartimento = false;

			if (dipartimento == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1);
			}
			else if (dipartimento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3);
			}
			else {
				bindDipartimento = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDipartimento) {
					qPos.add(dipartimento);
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

	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1 = "logisticaRichieste.dipartimento IS NULL";
	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2 = "logisticaRichieste.dipartimento = ?";
	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3 = "(logisticaRichieste.dipartimento IS NULL OR logisticaRichieste.dipartimento = '')";

	public LogisticaRichiestePersistenceImpl() {
		setModelClass(LogisticaRichieste.class);
	}

	/**
	 * Caches the logistica richieste in the entity cache if it is enabled.
	 *
	 * @param logisticaRichieste the logistica richieste
	 */
	@Override
	public void cacheResult(LogisticaRichieste logisticaRichieste) {
		entityCache.putResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteImpl.class, logisticaRichieste.getPrimaryKey(),
			logisticaRichieste);

		logisticaRichieste.resetOriginalValues();
	}

	/**
	 * Caches the logistica richiestes in the entity cache if it is enabled.
	 *
	 * @param logisticaRichiestes the logistica richiestes
	 */
	@Override
	public void cacheResult(List<LogisticaRichieste> logisticaRichiestes) {
		for (LogisticaRichieste logisticaRichieste : logisticaRichiestes) {
			if (entityCache.getResult(
						LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
						LogisticaRichiesteImpl.class,
						logisticaRichieste.getPrimaryKey()) == null) {
				cacheResult(logisticaRichieste);
			}
			else {
				logisticaRichieste.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all logistica richiestes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LogisticaRichiesteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the logistica richieste.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogisticaRichieste logisticaRichieste) {
		entityCache.removeResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteImpl.class, logisticaRichieste.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogisticaRichieste> logisticaRichiestes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogisticaRichieste logisticaRichieste : logisticaRichiestes) {
			entityCache.removeResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
				LogisticaRichiesteImpl.class, logisticaRichieste.getPrimaryKey());
		}
	}

	/**
	 * Creates a new logistica richieste with the primary key. Does not add the logistica richieste to the database.
	 *
	 * @param id the primary key for the new logistica richieste
	 * @return the new logistica richieste
	 */
	@Override
	public LogisticaRichieste create(long id) {
		LogisticaRichieste logisticaRichieste = new LogisticaRichiesteImpl();

		logisticaRichieste.setNew(true);
		logisticaRichieste.setPrimaryKey(id);

		return logisticaRichieste;
	}

	/**
	 * Removes the logistica richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the logistica richieste
	 * @return the logistica richieste that was removed
	 * @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste remove(long id)
		throws NoSuchLogisticaRichiesteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the logistica richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the logistica richieste
	 * @return the logistica richieste that was removed
	 * @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste remove(Serializable primaryKey)
		throws NoSuchLogisticaRichiesteException {
		Session session = null;

		try {
			session = openSession();

			LogisticaRichieste logisticaRichieste = (LogisticaRichieste)session.get(LogisticaRichiesteImpl.class,
					primaryKey);

			if (logisticaRichieste == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogisticaRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logisticaRichieste);
		}
		catch (NoSuchLogisticaRichiesteException nsee) {
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
	protected LogisticaRichieste removeImpl(
		LogisticaRichieste logisticaRichieste) {
		logisticaRichieste = toUnwrappedModel(logisticaRichieste);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logisticaRichieste)) {
				logisticaRichieste = (LogisticaRichieste)session.get(LogisticaRichiesteImpl.class,
						logisticaRichieste.getPrimaryKeyObj());
			}

			if (logisticaRichieste != null) {
				session.delete(logisticaRichieste);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logisticaRichieste != null) {
			clearCache(logisticaRichieste);
		}

		return logisticaRichieste;
	}

	@Override
	public LogisticaRichieste updateImpl(LogisticaRichieste logisticaRichieste) {
		logisticaRichieste = toUnwrappedModel(logisticaRichieste);

		boolean isNew = logisticaRichieste.isNew();

		LogisticaRichiesteModelImpl logisticaRichiesteModelImpl = (LogisticaRichiesteModelImpl)logisticaRichieste;

		Session session = null;

		try {
			session = openSession();

			if (logisticaRichieste.isNew()) {
				session.save(logisticaRichieste);

				logisticaRichieste.setNew(false);
			}
			else {
				logisticaRichieste = (LogisticaRichieste)session.merge(logisticaRichieste);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LogisticaRichiesteModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((logisticaRichiesteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logisticaRichiesteModelImpl.getOriginalUtente()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UTENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE,
					args);

				args = new Object[] { logisticaRichiesteModelImpl.getUtente() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UTENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UTENTE,
					args);
			}

			if ((logisticaRichiesteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logisticaRichiesteModelImpl.getOriginalDipartimento()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO,
					args);

				args = new Object[] {
						logisticaRichiesteModelImpl.getDipartimento()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO,
					args);
			}
		}

		entityCache.putResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaRichiesteImpl.class, logisticaRichieste.getPrimaryKey(),
			logisticaRichieste, false);

		logisticaRichieste.resetOriginalValues();

		return logisticaRichieste;
	}

	protected LogisticaRichieste toUnwrappedModel(
		LogisticaRichieste logisticaRichieste) {
		if (logisticaRichieste instanceof LogisticaRichiesteImpl) {
			return logisticaRichieste;
		}

		LogisticaRichiesteImpl logisticaRichiesteImpl = new LogisticaRichiesteImpl();

		logisticaRichiesteImpl.setNew(logisticaRichieste.isNew());
		logisticaRichiesteImpl.setPrimaryKey(logisticaRichieste.getPrimaryKey());

		logisticaRichiesteImpl.setId(logisticaRichieste.getId());
		logisticaRichiesteImpl.setOggetto(logisticaRichieste.getOggetto());
		logisticaRichiesteImpl.setUtente(logisticaRichieste.getUtente());
		logisticaRichiesteImpl.setDipartimento(logisticaRichieste.getDipartimento());
		logisticaRichiesteImpl.setData_richiesta(logisticaRichieste.getData_richiesta());
		logisticaRichiesteImpl.setDettaglio_richiedente(logisticaRichieste.getDettaglio_richiedente());
		logisticaRichiesteImpl.setDettaglio_richieste(logisticaRichieste.getDettaglio_richieste());
		logisticaRichiesteImpl.setNote_gestore(logisticaRichieste.getNote_gestore());
		logisticaRichiesteImpl.setId_valutazione(logisticaRichieste.getId_valutazione());
		logisticaRichiesteImpl.setId_stato(logisticaRichieste.getId_stato());
		logisticaRichiesteImpl.setNote(logisticaRichieste.getNote());

		return logisticaRichiesteImpl;
	}

	/**
	 * Returns the logistica richieste with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the logistica richieste
	 * @return the logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogisticaRichiesteException {
		LogisticaRichieste logisticaRichieste = fetchByPrimaryKey(primaryKey);

		if (logisticaRichieste == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogisticaRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return logisticaRichieste;
	}

	/**
	 * Returns the logistica richieste with the primary key or throws a {@link NoSuchLogisticaRichiesteException} if it could not be found.
	 *
	 * @param id the primary key of the logistica richieste
	 * @return the logistica richieste
	 * @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste findByPrimaryKey(long id)
		throws NoSuchLogisticaRichiesteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the logistica richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the logistica richieste
	 * @return the logistica richieste, or <code>null</code> if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
				LogisticaRichiesteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LogisticaRichieste logisticaRichieste = (LogisticaRichieste)serializable;

		if (logisticaRichieste == null) {
			Session session = null;

			try {
				session = openSession();

				logisticaRichieste = (LogisticaRichieste)session.get(LogisticaRichiesteImpl.class,
						primaryKey);

				if (logisticaRichieste != null) {
					cacheResult(logisticaRichieste);
				}
				else {
					entityCache.putResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
						LogisticaRichiesteImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaRichiesteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logisticaRichieste;
	}

	/**
	 * Returns the logistica richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the logistica richieste
	 * @return the logistica richieste, or <code>null</code> if a logistica richieste with the primary key could not be found
	 */
	@Override
	public LogisticaRichieste fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, LogisticaRichieste> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LogisticaRichieste> map = new HashMap<Serializable, LogisticaRichieste>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LogisticaRichieste logisticaRichieste = fetchByPrimaryKey(primaryKey);

			if (logisticaRichieste != null) {
				map.put(primaryKey, logisticaRichieste);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaRichiesteImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LogisticaRichieste)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOGISTICARICHIESTE_WHERE_PKS_IN);

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

			for (LogisticaRichieste logisticaRichieste : (List<LogisticaRichieste>)q.list()) {
				map.put(logisticaRichieste.getPrimaryKeyObj(),
					logisticaRichieste);

				cacheResult(logisticaRichieste);

				uncachedPrimaryKeys.remove(logisticaRichieste.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LogisticaRichiesteModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaRichiesteImpl.class, primaryKey, nullModel);
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
	 * Returns all the logistica richiestes.
	 *
	 * @return the logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the logistica richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @return the range of logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the logistica richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findAll(int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the logistica richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica richiestes
	 * @param end the upper bound of the range of logistica richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of logistica richiestes
	 */
	@Override
	public List<LogisticaRichieste> findAll(int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator,
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

		List<LogisticaRichieste> list = null;

		if (retrieveFromCache) {
			list = (List<LogisticaRichieste>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOGISTICARICHIESTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGISTICARICHIESTE;

				if (pagination) {
					sql = sql.concat(LogisticaRichiesteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogisticaRichieste>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogisticaRichieste>)QueryUtil.list(q,
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
	 * Removes all the logistica richiestes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LogisticaRichieste logisticaRichieste : findAll()) {
			remove(logisticaRichieste);
		}
	}

	/**
	 * Returns the number of logistica richiestes.
	 *
	 * @return the number of logistica richiestes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGISTICARICHIESTE);

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
		return LogisticaRichiesteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the logistica richieste persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LogisticaRichiesteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LOGISTICARICHIESTE = "SELECT logisticaRichieste FROM LogisticaRichieste logisticaRichieste";
	private static final String _SQL_SELECT_LOGISTICARICHIESTE_WHERE_PKS_IN = "SELECT logisticaRichieste FROM LogisticaRichieste logisticaRichieste WHERE id_ IN (";
	private static final String _SQL_SELECT_LOGISTICARICHIESTE_WHERE = "SELECT logisticaRichieste FROM LogisticaRichieste logisticaRichieste WHERE ";
	private static final String _SQL_COUNT_LOGISTICARICHIESTE = "SELECT COUNT(logisticaRichieste) FROM LogisticaRichieste logisticaRichieste";
	private static final String _SQL_COUNT_LOGISTICARICHIESTE_WHERE = "SELECT COUNT(logisticaRichieste) FROM LogisticaRichieste logisticaRichieste WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logisticaRichieste.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogisticaRichieste exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LogisticaRichieste exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LogisticaRichiestePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}