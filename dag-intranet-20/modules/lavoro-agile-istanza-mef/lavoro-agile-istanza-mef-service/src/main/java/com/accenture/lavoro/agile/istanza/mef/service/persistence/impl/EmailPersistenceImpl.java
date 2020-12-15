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

import com.accenture.lavoro.agile.istanza.mef.exception.NoSuchEmailException;
import com.accenture.lavoro.agile.istanza.mef.model.Email;
import com.accenture.lavoro.agile.istanza.mef.model.impl.EmailImpl;
import com.accenture.lavoro.agile.istanza.mef.model.impl.EmailModelImpl;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.EmailPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailPersistence
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.EmailUtil
 * @generated
 */
@ProviderType
public class EmailPersistenceImpl extends BasePersistenceImpl<Email>
	implements EmailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmailUtil} to access the email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSTRUTTURA =
		new FinderPath(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdStruttura",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA =
		new FinderPath(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdStruttura",
			new String[] { Long.class.getName() },
			EmailModelImpl.IDSTRUTTURA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDSTRUTTURA = new FinderPath(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdStruttura",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emails where idStruttura = &#63;.
	 *
	 * @param idStruttura the id struttura
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByIdStruttura(long idStruttura) {
		return findByIdStruttura(idStruttura, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where idStruttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idStruttura the id struttura
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByIdStruttura(long idStruttura, int start, int end) {
		return findByIdStruttura(idStruttura, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where idStruttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idStruttura the id struttura
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByIdStruttura(long idStruttura, int start, int end,
		OrderByComparator<Email> orderByComparator) {
		return findByIdStruttura(idStruttura, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the emails where idStruttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idStruttura the id struttura
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByIdStruttura(long idStruttura, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA;
			finderArgs = new Object[] { idStruttura };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSTRUTTURA;
			finderArgs = new Object[] { idStruttura, start, end, orderByComparator };
		}

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if ((idStruttura != email.getIdStruttura())) {
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

			query.append(_SQL_SELECT_EMAIL_WHERE);

			query.append(_FINDER_COLUMN_IDSTRUTTURA_IDSTRUTTURA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idStruttura);

				if (!pagination) {
					list = (List<Email>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first email in the ordered set where idStruttura = &#63;.
	 *
	 * @param idStruttura the id struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByIdStruttura_First(long idStruttura,
		OrderByComparator<Email> orderByComparator) throws NoSuchEmailException {
		Email email = fetchByIdStruttura_First(idStruttura, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idStruttura=");
		msg.append(idStruttura);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the first email in the ordered set where idStruttura = &#63;.
	 *
	 * @param idStruttura the id struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByIdStruttura_First(long idStruttura,
		OrderByComparator<Email> orderByComparator) {
		List<Email> list = findByIdStruttura(idStruttura, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where idStruttura = &#63;.
	 *
	 * @param idStruttura the id struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByIdStruttura_Last(long idStruttura,
		OrderByComparator<Email> orderByComparator) throws NoSuchEmailException {
		Email email = fetchByIdStruttura_Last(idStruttura, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idStruttura=");
		msg.append(idStruttura);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the last email in the ordered set where idStruttura = &#63;.
	 *
	 * @param idStruttura the id struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByIdStruttura_Last(long idStruttura,
		OrderByComparator<Email> orderByComparator) {
		int count = countByIdStruttura(idStruttura);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByIdStruttura(idStruttura, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where idStruttura = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param idStruttura the id struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByIdStruttura_PrevAndNext(long id, long idStruttura,
		OrderByComparator<Email> orderByComparator) throws NoSuchEmailException {
		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByIdStruttura_PrevAndNext(session, email,
					idStruttura, orderByComparator, true);

			array[1] = email;

			array[2] = getByIdStruttura_PrevAndNext(session, email,
					idStruttura, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByIdStruttura_PrevAndNext(Session session, Email email,
		long idStruttura, OrderByComparator<Email> orderByComparator,
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

		query.append(_SQL_SELECT_EMAIL_WHERE);

		query.append(_FINDER_COLUMN_IDSTRUTTURA_IDSTRUTTURA_2);

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
			query.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idStruttura);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(email);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Email> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where idStruttura = &#63; from the database.
	 *
	 * @param idStruttura the id struttura
	 */
	@Override
	public void removeByIdStruttura(long idStruttura) {
		for (Email email : findByIdStruttura(idStruttura, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(email);
		}
	}

	/**
	 * Returns the number of emails where idStruttura = &#63;.
	 *
	 * @param idStruttura the id struttura
	 * @return the number of matching emails
	 */
	@Override
	public int countByIdStruttura(long idStruttura) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDSTRUTTURA;

		Object[] finderArgs = new Object[] { idStruttura };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAIL_WHERE);

			query.append(_FINDER_COLUMN_IDSTRUTTURA_IDSTRUTTURA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idStruttura);

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

	private static final String _FINDER_COLUMN_IDSTRUTTURA_IDSTRUTTURA_2 = "email.idStruttura = ?";

	public EmailPersistenceImpl() {
		setModelClass(Email.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the email in the entity cache if it is enabled.
	 *
	 * @param email the email
	 */
	@Override
	public void cacheResult(Email email) {
		entityCache.putResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailImpl.class, email.getPrimaryKey(), email);

		email.resetOriginalValues();
	}

	/**
	 * Caches the emails in the entity cache if it is enabled.
	 *
	 * @param emails the emails
	 */
	@Override
	public void cacheResult(List<Email> emails) {
		for (Email email : emails) {
			if (entityCache.getResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
						EmailImpl.class, email.getPrimaryKey()) == null) {
				cacheResult(email);
			}
			else {
				email.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emails.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Email email) {
		entityCache.removeResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailImpl.class, email.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Email> emails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Email email : emails) {
			entityCache.removeResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
				EmailImpl.class, email.getPrimaryKey());
		}
	}

	/**
	 * Creates a new email with the primary key. Does not add the email to the database.
	 *
	 * @param id the primary key for the new email
	 * @return the new email
	 */
	@Override
	public Email create(long id) {
		Email email = new EmailImpl();

		email.setNew(true);
		email.setPrimaryKey(id);

		return email;
	}

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email remove(long id) throws NoSuchEmailException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email remove(Serializable primaryKey) throws NoSuchEmailException {
		Session session = null;

		try {
			session = openSession();

			Email email = (Email)session.get(EmailImpl.class, primaryKey);

			if (email == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(email);
		}
		catch (NoSuchEmailException nsee) {
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
	protected Email removeImpl(Email email) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(email)) {
				email = (Email)session.get(EmailImpl.class,
						email.getPrimaryKeyObj());
			}

			if (email != null) {
				session.delete(email);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (email != null) {
			clearCache(email);
		}

		return email;
	}

	@Override
	public Email updateImpl(Email email) {
		boolean isNew = email.isNew();

		if (!(email instanceof EmailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(email.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(email);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in email proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Email implementation " +
				email.getClass());
		}

		EmailModelImpl emailModelImpl = (EmailModelImpl)email;

		Session session = null;

		try {
			session = openSession();

			if (email.isNew()) {
				session.save(email);

				email.setNew(false);
			}
			else {
				email = (Email)session.merge(email);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EmailModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { emailModelImpl.getIdStruttura() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSTRUTTURA, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((emailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailModelImpl.getOriginalIdStruttura()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSTRUTTURA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA,
					args);

				args = new Object[] { emailModelImpl.getIdStruttura() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSTRUTTURA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA,
					args);
			}
		}

		entityCache.putResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailImpl.class, email.getPrimaryKey(), email, false);

		email.resetOriginalValues();

		return email;
	}

	/**
	 * Returns the email with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailException {
		Email email = fetchByPrimaryKey(primaryKey);

		if (email == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return email;
	}

	/**
	 * Returns the email with the primary key or throws a {@link NoSuchEmailException} if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email findByPrimaryKey(long id) throws NoSuchEmailException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email, or <code>null</code> if a email with the primary key could not be found
	 */
	@Override
	public Email fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
				EmailImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Email email = (Email)serializable;

		if (email == null) {
			Session session = null;

			try {
				session = openSession();

				email = (Email)session.get(EmailImpl.class, primaryKey);

				if (email != null) {
					cacheResult(email);
				}
				else {
					entityCache.putResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
						EmailImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
					EmailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return email;
	}

	/**
	 * Returns the email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email, or <code>null</code> if a email with the primary key could not be found
	 */
	@Override
	public Email fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Email> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Email> map = new HashMap<Serializable, Email>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Email email = fetchByPrimaryKey(primaryKey);

			if (email != null) {
				map.put(primaryKey, email);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
					EmailImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Email)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMAIL_WHERE_PKS_IN);

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

			for (Email email : (List<Email>)q.list()) {
				map.put(email.getPrimaryKeyObj(), email);

				cacheResult(email);

				uncachedPrimaryKeys.remove(email.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmailModelImpl.ENTITY_CACHE_ENABLED,
					EmailImpl.class, primaryKey, nullModel);
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
	 * Returns all the emails.
	 *
	 * @return the emails
	 */
	@Override
	public List<Email> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of emails
	 */
	@Override
	public List<Email> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emails
	 */
	@Override
	public List<Email> findAll(int start, int end,
		OrderByComparator<Email> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of emails
	 */
	@Override
	public List<Email> findAll(int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {
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

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAIL;

				if (pagination) {
					sql = sql.concat(EmailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Email>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the emails from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Email email : findAll()) {
			remove(email);
		}
	}

	/**
	 * Returns the number of emails.
	 *
	 * @return the number of emails
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMAIL);

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
		return EmailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmailImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMAIL = "SELECT email FROM Email email";
	private static final String _SQL_SELECT_EMAIL_WHERE_PKS_IN = "SELECT email FROM Email email WHERE id_ IN (";
	private static final String _SQL_SELECT_EMAIL_WHERE = "SELECT email FROM Email email WHERE ";
	private static final String _SQL_COUNT_EMAIL = "SELECT COUNT(email) FROM Email email";
	private static final String _SQL_COUNT_EMAIL_WHERE = "SELECT COUNT(email) FROM Email email WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "email.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Email exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Email exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EmailPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}