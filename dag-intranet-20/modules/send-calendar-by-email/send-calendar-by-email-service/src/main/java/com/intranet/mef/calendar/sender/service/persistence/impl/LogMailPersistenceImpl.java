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

package com.intranet.mef.calendar.sender.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.calendar.sender.exception.NoSuchLogMailException;
import com.intranet.mef.calendar.sender.model.LogMail;
import com.intranet.mef.calendar.sender.model.impl.LogMailImpl;
import com.intranet.mef.calendar.sender.model.impl.LogMailModelImpl;
import com.intranet.mef.calendar.sender.service.persistence.LogMailPersistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

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
 * The persistence implementation for the log mail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogMailPersistence
 * @see com.intranet.mef.calendar.sender.service.persistence.LogMailUtil
 * @generated
 */
@ProviderType
public class LogMailPersistenceImpl extends BasePersistenceImpl<LogMail>
	implements LogMailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogMailUtil} to access the log mail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogMailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LogMailModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the log mails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching log mails
	 */
	@Override
	public List<LogMail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log mails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @return the range of matching log mails
	 */
	@Override
	public List<LogMail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the log mails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching log mails
	 */
	@Override
	public List<LogMail> findByUuid(String uuid, int start, int end,
		OrderByComparator<LogMail> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the log mails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching log mails
	 */
	@Override
	public List<LogMail> findByUuid(String uuid, int start, int end,
		OrderByComparator<LogMail> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<LogMail> list = null;

		if (retrieveFromCache) {
			list = (List<LogMail>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (LogMail logMail : list) {
					if (!Objects.equals(uuid, logMail.getUuid())) {
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

			query.append(_SQL_SELECT_LOGMAIL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogMailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<LogMail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogMail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first log mail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log mail
	 * @throws NoSuchLogMailException if a matching log mail could not be found
	 */
	@Override
	public LogMail findByUuid_First(String uuid,
		OrderByComparator<LogMail> orderByComparator)
		throws NoSuchLogMailException {
		LogMail logMail = fetchByUuid_First(uuid, orderByComparator);

		if (logMail != null) {
			return logMail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogMailException(msg.toString());
	}

	/**
	 * Returns the first log mail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log mail, or <code>null</code> if a matching log mail could not be found
	 */
	@Override
	public LogMail fetchByUuid_First(String uuid,
		OrderByComparator<LogMail> orderByComparator) {
		List<LogMail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last log mail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log mail
	 * @throws NoSuchLogMailException if a matching log mail could not be found
	 */
	@Override
	public LogMail findByUuid_Last(String uuid,
		OrderByComparator<LogMail> orderByComparator)
		throws NoSuchLogMailException {
		LogMail logMail = fetchByUuid_Last(uuid, orderByComparator);

		if (logMail != null) {
			return logMail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogMailException(msg.toString());
	}

	/**
	 * Returns the last log mail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log mail, or <code>null</code> if a matching log mail could not be found
	 */
	@Override
	public LogMail fetchByUuid_Last(String uuid,
		OrderByComparator<LogMail> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LogMail> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the log mails before and after the current log mail in the ordered set where uuid = &#63;.
	 *
	 * @param logMailId the primary key of the current log mail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next log mail
	 * @throws NoSuchLogMailException if a log mail with the primary key could not be found
	 */
	@Override
	public LogMail[] findByUuid_PrevAndNext(long logMailId, String uuid,
		OrderByComparator<LogMail> orderByComparator)
		throws NoSuchLogMailException {
		LogMail logMail = findByPrimaryKey(logMailId);

		Session session = null;

		try {
			session = openSession();

			LogMail[] array = new LogMailImpl[3];

			array[0] = getByUuid_PrevAndNext(session, logMail, uuid,
					orderByComparator, true);

			array[1] = logMail;

			array[2] = getByUuid_PrevAndNext(session, logMail, uuid,
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

	protected LogMail getByUuid_PrevAndNext(Session session, LogMail logMail,
		String uuid, OrderByComparator<LogMail> orderByComparator,
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

		query.append(_SQL_SELECT_LOGMAIL_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(LogMailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logMail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogMail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the log mails where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LogMail logMail : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(logMail);
		}
	}

	/**
	 * Returns the number of log mails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching log mails
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGMAIL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "logMail.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "logMail.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(logMail.uuid IS NULL OR logMail.uuid = '')";

	public LogMailPersistenceImpl() {
		setModelClass(LogMail.class);
	}

	/**
	 * Caches the log mail in the entity cache if it is enabled.
	 *
	 * @param logMail the log mail
	 */
	@Override
	public void cacheResult(LogMail logMail) {
		entityCache.putResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailImpl.class, logMail.getPrimaryKey(), logMail);

		logMail.resetOriginalValues();
	}

	/**
	 * Caches the log mails in the entity cache if it is enabled.
	 *
	 * @param logMails the log mails
	 */
	@Override
	public void cacheResult(List<LogMail> logMails) {
		for (LogMail logMail : logMails) {
			if (entityCache.getResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
						LogMailImpl.class, logMail.getPrimaryKey()) == null) {
				cacheResult(logMail);
			}
			else {
				logMail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all log mails.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LogMailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the log mail.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogMail logMail) {
		entityCache.removeResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailImpl.class, logMail.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogMail> logMails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogMail logMail : logMails) {
			entityCache.removeResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
				LogMailImpl.class, logMail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new log mail with the primary key. Does not add the log mail to the database.
	 *
	 * @param logMailId the primary key for the new log mail
	 * @return the new log mail
	 */
	@Override
	public LogMail create(long logMailId) {
		LogMail logMail = new LogMailImpl();

		logMail.setNew(true);
		logMail.setPrimaryKey(logMailId);

		String uuid = PortalUUIDUtil.generate();

		logMail.setUuid(uuid);

		return logMail;
	}

	/**
	 * Removes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logMailId the primary key of the log mail
	 * @return the log mail that was removed
	 * @throws NoSuchLogMailException if a log mail with the primary key could not be found
	 */
	@Override
	public LogMail remove(long logMailId) throws NoSuchLogMailException {
		return remove((Serializable)logMailId);
	}

	/**
	 * Removes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log mail
	 * @return the log mail that was removed
	 * @throws NoSuchLogMailException if a log mail with the primary key could not be found
	 */
	@Override
	public LogMail remove(Serializable primaryKey)
		throws NoSuchLogMailException {
		Session session = null;

		try {
			session = openSession();

			LogMail logMail = (LogMail)session.get(LogMailImpl.class, primaryKey);

			if (logMail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogMailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logMail);
		}
		catch (NoSuchLogMailException nsee) {
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
	protected LogMail removeImpl(LogMail logMail) {
		logMail = toUnwrappedModel(logMail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logMail)) {
				logMail = (LogMail)session.get(LogMailImpl.class,
						logMail.getPrimaryKeyObj());
			}

			if (logMail != null) {
				session.delete(logMail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logMail != null) {
			clearCache(logMail);
		}

		return logMail;
	}

	@Override
	public LogMail updateImpl(LogMail logMail) {
		logMail = toUnwrappedModel(logMail);

		boolean isNew = logMail.isNew();

		LogMailModelImpl logMailModelImpl = (LogMailModelImpl)logMail;

		if (Validator.isNull(logMail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			logMail.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (logMail.isNew()) {
				session.save(logMail);

				logMail.setNew(false);
			}
			else {
				logMail = (LogMail)session.merge(logMail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LogMailModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((logMailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { logMailModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { logMailModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailImpl.class, logMail.getPrimaryKey(), logMail, false);

		logMail.resetOriginalValues();

		return logMail;
	}

	protected LogMail toUnwrappedModel(LogMail logMail) {
		if (logMail instanceof LogMailImpl) {
			return logMail;
		}

		LogMailImpl logMailImpl = new LogMailImpl();

		logMailImpl.setNew(logMail.isNew());
		logMailImpl.setPrimaryKey(logMail.getPrimaryKey());

		logMailImpl.setUuid(logMail.getUuid());
		logMailImpl.setLogMailId(logMail.getLogMailId());
		logMailImpl.setMailTo(logMail.getMailTo());
		logMailImpl.setEventTitle(logMail.getEventTitle());
		logMailImpl.setEventDescription(logMail.getEventDescription());
		logMailImpl.setDateStart(logMail.getDateStart());
		logMailImpl.setDateFinish(logMail.getDateFinish());

		return logMailImpl;
	}

	/**
	 * Returns the log mail with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the log mail
	 * @return the log mail
	 * @throws NoSuchLogMailException if a log mail with the primary key could not be found
	 */
	@Override
	public LogMail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogMailException {
		LogMail logMail = fetchByPrimaryKey(primaryKey);

		if (logMail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogMailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return logMail;
	}

	/**
	 * Returns the log mail with the primary key or throws a {@link NoSuchLogMailException} if it could not be found.
	 *
	 * @param logMailId the primary key of the log mail
	 * @return the log mail
	 * @throws NoSuchLogMailException if a log mail with the primary key could not be found
	 */
	@Override
	public LogMail findByPrimaryKey(long logMailId)
		throws NoSuchLogMailException {
		return findByPrimaryKey((Serializable)logMailId);
	}

	/**
	 * Returns the log mail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log mail
	 * @return the log mail, or <code>null</code> if a log mail with the primary key could not be found
	 */
	@Override
	public LogMail fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
				LogMailImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LogMail logMail = (LogMail)serializable;

		if (logMail == null) {
			Session session = null;

			try {
				session = openSession();

				logMail = (LogMail)session.get(LogMailImpl.class, primaryKey);

				if (logMail != null) {
					cacheResult(logMail);
				}
				else {
					entityCache.putResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
						LogMailImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
					LogMailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logMail;
	}

	/**
	 * Returns the log mail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logMailId the primary key of the log mail
	 * @return the log mail, or <code>null</code> if a log mail with the primary key could not be found
	 */
	@Override
	public LogMail fetchByPrimaryKey(long logMailId) {
		return fetchByPrimaryKey((Serializable)logMailId);
	}

	@Override
	public Map<Serializable, LogMail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LogMail> map = new HashMap<Serializable, LogMail>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LogMail logMail = fetchByPrimaryKey(primaryKey);

			if (logMail != null) {
				map.put(primaryKey, logMail);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
					LogMailImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LogMail)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOGMAIL_WHERE_PKS_IN);

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

			for (LogMail logMail : (List<LogMail>)q.list()) {
				map.put(logMail.getPrimaryKeyObj(), logMail);

				cacheResult(logMail);

				uncachedPrimaryKeys.remove(logMail.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
					LogMailImpl.class, primaryKey, nullModel);
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
	 * Returns all the log mails.
	 *
	 * @return the log mails
	 */
	@Override
	public List<LogMail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @return the range of log mails
	 */
	@Override
	public List<LogMail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the log mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log mails
	 */
	@Override
	public List<LogMail> findAll(int start, int end,
		OrderByComparator<LogMail> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the log mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of log mails
	 */
	@Override
	public List<LogMail> findAll(int start, int end,
		OrderByComparator<LogMail> orderByComparator, boolean retrieveFromCache) {
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

		List<LogMail> list = null;

		if (retrieveFromCache) {
			list = (List<LogMail>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOGMAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGMAIL;

				if (pagination) {
					sql = sql.concat(LogMailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogMail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogMail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the log mails from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LogMail logMail : findAll()) {
			remove(logMail);
		}
	}

	/**
	 * Returns the number of log mails.
	 *
	 * @return the number of log mails
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGMAIL);

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
		return LogMailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the log mail persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LogMailImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LOGMAIL = "SELECT logMail FROM LogMail logMail";
	private static final String _SQL_SELECT_LOGMAIL_WHERE_PKS_IN = "SELECT logMail FROM LogMail logMail WHERE logMailId IN (";
	private static final String _SQL_SELECT_LOGMAIL_WHERE = "SELECT logMail FROM LogMail logMail WHERE ";
	private static final String _SQL_COUNT_LOGMAIL = "SELECT COUNT(logMail) FROM LogMail logMail";
	private static final String _SQL_COUNT_LOGMAIL_WHERE = "SELECT COUNT(logMail) FROM LogMail logMail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logMail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogMail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LogMail exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LogMailPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}