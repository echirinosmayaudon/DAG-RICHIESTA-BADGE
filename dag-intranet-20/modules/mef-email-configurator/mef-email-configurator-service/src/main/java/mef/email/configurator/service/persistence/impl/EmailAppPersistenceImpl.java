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

package mef.email.configurator.service.persistence.impl;

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

import mef.email.configurator.exception.NoSuchEmailAppException;
import mef.email.configurator.model.EmailApp;
import mef.email.configurator.model.impl.EmailAppImpl;
import mef.email.configurator.model.impl.EmailAppModelImpl;
import mef.email.configurator.service.persistence.EmailAppPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the email app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailAppPersistence
 * @see mef.email.configurator.service.persistence.EmailAppUtil
 * @generated
 */
@ProviderType
public class EmailAppPersistenceImpl extends BasePersistenceImpl<EmailApp>
	implements EmailAppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmailAppUtil} to access the email app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmailAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppModelImpl.FINDER_CACHE_ENABLED, EmailAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppModelImpl.FINDER_CACHE_ENABLED, EmailAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICAZIONE_STRUTTURA =
		new FinderPath(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppModelImpl.FINDER_CACHE_ENABLED, EmailAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApplicazione_Struttura",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICAZIONE_STRUTTURA =
		new FinderPath(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppModelImpl.FINDER_CACHE_ENABLED, EmailAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicazione_Struttura",
			new String[] { Long.class.getName(), Long.class.getName() },
			EmailAppModelImpl.APPID_COLUMN_BITMASK |
			EmailAppModelImpl.STRUTTURA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICAZIONE_STRUTTURA = new FinderPath(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicazione_Struttura",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the email apps where appid = &#63; and struttura = &#63;.
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @return the matching email apps
	 */
	@Override
	public List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura) {
		return findByApplicazione_Struttura(appid, struttura,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email apps where appid = &#63; and struttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param start the lower bound of the range of email apps
	 * @param end the upper bound of the range of email apps (not inclusive)
	 * @return the range of matching email apps
	 */
	@Override
	public List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end) {
		return findByApplicazione_Struttura(appid, struttura, start, end, null);
	}

	/**
	 * Returns an ordered range of all the email apps where appid = &#63; and struttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param start the lower bound of the range of email apps
	 * @param end the upper bound of the range of email apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email apps
	 */
	@Override
	public List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end,
		OrderByComparator<EmailApp> orderByComparator) {
		return findByApplicazione_Struttura(appid, struttura, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email apps where appid = &#63; and struttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param start the lower bound of the range of email apps
	 * @param end the upper bound of the range of email apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching email apps
	 */
	@Override
	public List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end,
		OrderByComparator<EmailApp> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICAZIONE_STRUTTURA;
			finderArgs = new Object[] { appid, struttura };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICAZIONE_STRUTTURA;
			finderArgs = new Object[] {
					appid, struttura,
					
					start, end, orderByComparator
				};
		}

		List<EmailApp> list = null;

		if (retrieveFromCache) {
			list = (List<EmailApp>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmailApp emailApp : list) {
					if ((appid != emailApp.getAppid()) ||
							(struttura != emailApp.getStruttura())) {
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

			query.append(_SQL_SELECT_EMAILAPP_WHERE);

			query.append(_FINDER_COLUMN_APPLICAZIONE_STRUTTURA_APPID_2);

			query.append(_FINDER_COLUMN_APPLICAZIONE_STRUTTURA_STRUTTURA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmailAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appid);

				qPos.add(struttura);

				if (!pagination) {
					list = (List<EmailApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmailApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first email app in the ordered set where appid = &#63; and struttura = &#63;.
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email app
	 * @throws NoSuchEmailAppException if a matching email app could not be found
	 */
	@Override
	public EmailApp findByApplicazione_Struttura_First(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator)
		throws NoSuchEmailAppException {
		EmailApp emailApp = fetchByApplicazione_Struttura_First(appid,
				struttura, orderByComparator);

		if (emailApp != null) {
			return emailApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appid=");
		msg.append(appid);

		msg.append(", struttura=");
		msg.append(struttura);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailAppException(msg.toString());
	}

	/**
	 * Returns the first email app in the ordered set where appid = &#63; and struttura = &#63;.
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email app, or <code>null</code> if a matching email app could not be found
	 */
	@Override
	public EmailApp fetchByApplicazione_Struttura_First(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator) {
		List<EmailApp> list = findByApplicazione_Struttura(appid, struttura, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email app in the ordered set where appid = &#63; and struttura = &#63;.
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email app
	 * @throws NoSuchEmailAppException if a matching email app could not be found
	 */
	@Override
	public EmailApp findByApplicazione_Struttura_Last(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator)
		throws NoSuchEmailAppException {
		EmailApp emailApp = fetchByApplicazione_Struttura_Last(appid,
				struttura, orderByComparator);

		if (emailApp != null) {
			return emailApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appid=");
		msg.append(appid);

		msg.append(", struttura=");
		msg.append(struttura);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailAppException(msg.toString());
	}

	/**
	 * Returns the last email app in the ordered set where appid = &#63; and struttura = &#63;.
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email app, or <code>null</code> if a matching email app could not be found
	 */
	@Override
	public EmailApp fetchByApplicazione_Struttura_Last(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator) {
		int count = countByApplicazione_Struttura(appid, struttura);

		if (count == 0) {
			return null;
		}

		List<EmailApp> list = findByApplicazione_Struttura(appid, struttura,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the email apps before and after the current email app in the ordered set where appid = &#63; and struttura = &#63;.
	 *
	 * @param id the primary key of the current email app
	 * @param appid the appid
	 * @param struttura the struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email app
	 * @throws NoSuchEmailAppException if a email app with the primary key could not be found
	 */
	@Override
	public EmailApp[] findByApplicazione_Struttura_PrevAndNext(long id,
		long appid, long struttura,
		OrderByComparator<EmailApp> orderByComparator)
		throws NoSuchEmailAppException {
		EmailApp emailApp = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EmailApp[] array = new EmailAppImpl[3];

			array[0] = getByApplicazione_Struttura_PrevAndNext(session,
					emailApp, appid, struttura, orderByComparator, true);

			array[1] = emailApp;

			array[2] = getByApplicazione_Struttura_PrevAndNext(session,
					emailApp, appid, struttura, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmailApp getByApplicazione_Struttura_PrevAndNext(
		Session session, EmailApp emailApp, long appid, long struttura,
		OrderByComparator<EmailApp> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EMAILAPP_WHERE);

		query.append(_FINDER_COLUMN_APPLICAZIONE_STRUTTURA_APPID_2);

		query.append(_FINDER_COLUMN_APPLICAZIONE_STRUTTURA_STRUTTURA_2);

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
			query.append(EmailAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(appid);

		qPos.add(struttura);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(emailApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmailApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email apps where appid = &#63; and struttura = &#63; from the database.
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 */
	@Override
	public void removeByApplicazione_Struttura(long appid, long struttura) {
		for (EmailApp emailApp : findByApplicazione_Struttura(appid, struttura,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(emailApp);
		}
	}

	/**
	 * Returns the number of email apps where appid = &#63; and struttura = &#63;.
	 *
	 * @param appid the appid
	 * @param struttura the struttura
	 * @return the number of matching email apps
	 */
	@Override
	public int countByApplicazione_Struttura(long appid, long struttura) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICAZIONE_STRUTTURA;

		Object[] finderArgs = new Object[] { appid, struttura };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMAILAPP_WHERE);

			query.append(_FINDER_COLUMN_APPLICAZIONE_STRUTTURA_APPID_2);

			query.append(_FINDER_COLUMN_APPLICAZIONE_STRUTTURA_STRUTTURA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appid);

				qPos.add(struttura);

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

	private static final String _FINDER_COLUMN_APPLICAZIONE_STRUTTURA_APPID_2 = "emailApp.appid = ? AND ";
	private static final String _FINDER_COLUMN_APPLICAZIONE_STRUTTURA_STRUTTURA_2 =
		"emailApp.struttura = ?";

	public EmailAppPersistenceImpl() {
		setModelClass(EmailApp.class);
	}

	/**
	 * Caches the email app in the entity cache if it is enabled.
	 *
	 * @param emailApp the email app
	 */
	@Override
	public void cacheResult(EmailApp emailApp) {
		entityCache.putResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppImpl.class, emailApp.getPrimaryKey(), emailApp);

		emailApp.resetOriginalValues();
	}

	/**
	 * Caches the email apps in the entity cache if it is enabled.
	 *
	 * @param emailApps the email apps
	 */
	@Override
	public void cacheResult(List<EmailApp> emailApps) {
		for (EmailApp emailApp : emailApps) {
			if (entityCache.getResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
						EmailAppImpl.class, emailApp.getPrimaryKey()) == null) {
				cacheResult(emailApp);
			}
			else {
				emailApp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all email apps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmailAppImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email app.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmailApp emailApp) {
		entityCache.removeResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppImpl.class, emailApp.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmailApp> emailApps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmailApp emailApp : emailApps) {
			entityCache.removeResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
				EmailAppImpl.class, emailApp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new email app with the primary key. Does not add the email app to the database.
	 *
	 * @param id the primary key for the new email app
	 * @return the new email app
	 */
	@Override
	public EmailApp create(long id) {
		EmailApp emailApp = new EmailAppImpl();

		emailApp.setNew(true);
		emailApp.setPrimaryKey(id);

		return emailApp;
	}

	/**
	 * Removes the email app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email app
	 * @return the email app that was removed
	 * @throws NoSuchEmailAppException if a email app with the primary key could not be found
	 */
	@Override
	public EmailApp remove(long id) throws NoSuchEmailAppException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the email app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email app
	 * @return the email app that was removed
	 * @throws NoSuchEmailAppException if a email app with the primary key could not be found
	 */
	@Override
	public EmailApp remove(Serializable primaryKey)
		throws NoSuchEmailAppException {
		Session session = null;

		try {
			session = openSession();

			EmailApp emailApp = (EmailApp)session.get(EmailAppImpl.class,
					primaryKey);

			if (emailApp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emailApp);
		}
		catch (NoSuchEmailAppException nsee) {
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
	protected EmailApp removeImpl(EmailApp emailApp) {
		emailApp = toUnwrappedModel(emailApp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailApp)) {
				emailApp = (EmailApp)session.get(EmailAppImpl.class,
						emailApp.getPrimaryKeyObj());
			}

			if (emailApp != null) {
				session.delete(emailApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (emailApp != null) {
			clearCache(emailApp);
		}

		return emailApp;
	}

	@Override
	public EmailApp updateImpl(EmailApp emailApp) {
		emailApp = toUnwrappedModel(emailApp);

		boolean isNew = emailApp.isNew();

		EmailAppModelImpl emailAppModelImpl = (EmailAppModelImpl)emailApp;

		Session session = null;

		try {
			session = openSession();

			if (emailApp.isNew()) {
				session.save(emailApp);

				emailApp.setNew(false);
			}
			else {
				emailApp = (EmailApp)session.merge(emailApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmailAppModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((emailAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICAZIONE_STRUTTURA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailAppModelImpl.getOriginalAppid(),
						emailAppModelImpl.getOriginalStruttura()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICAZIONE_STRUTTURA,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICAZIONE_STRUTTURA,
					args);

				args = new Object[] {
						emailAppModelImpl.getAppid(),
						emailAppModelImpl.getStruttura()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICAZIONE_STRUTTURA,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICAZIONE_STRUTTURA,
					args);
			}
		}

		entityCache.putResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
			EmailAppImpl.class, emailApp.getPrimaryKey(), emailApp, false);

		emailApp.resetOriginalValues();

		return emailApp;
	}

	protected EmailApp toUnwrappedModel(EmailApp emailApp) {
		if (emailApp instanceof EmailAppImpl) {
			return emailApp;
		}

		EmailAppImpl emailAppImpl = new EmailAppImpl();

		emailAppImpl.setNew(emailApp.isNew());
		emailAppImpl.setPrimaryKey(emailApp.getPrimaryKey());

		emailAppImpl.setId(emailApp.getId());
		emailAppImpl.setAppid(emailApp.getAppid());
		emailAppImpl.setStruttura(emailApp.getStruttura());
		emailAppImpl.setEmail(emailApp.getEmail());

		return emailAppImpl;
	}

	/**
	 * Returns the email app with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the email app
	 * @return the email app
	 * @throws NoSuchEmailAppException if a email app with the primary key could not be found
	 */
	@Override
	public EmailApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailAppException {
		EmailApp emailApp = fetchByPrimaryKey(primaryKey);

		if (emailApp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return emailApp;
	}

	/**
	 * Returns the email app with the primary key or throws a {@link NoSuchEmailAppException} if it could not be found.
	 *
	 * @param id the primary key of the email app
	 * @return the email app
	 * @throws NoSuchEmailAppException if a email app with the primary key could not be found
	 */
	@Override
	public EmailApp findByPrimaryKey(long id) throws NoSuchEmailAppException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the email app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email app
	 * @return the email app, or <code>null</code> if a email app with the primary key could not be found
	 */
	@Override
	public EmailApp fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
				EmailAppImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EmailApp emailApp = (EmailApp)serializable;

		if (emailApp == null) {
			Session session = null;

			try {
				session = openSession();

				emailApp = (EmailApp)session.get(EmailAppImpl.class, primaryKey);

				if (emailApp != null) {
					cacheResult(emailApp);
				}
				else {
					entityCache.putResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
						EmailAppImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
					EmailAppImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return emailApp;
	}

	/**
	 * Returns the email app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email app
	 * @return the email app, or <code>null</code> if a email app with the primary key could not be found
	 */
	@Override
	public EmailApp fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, EmailApp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EmailApp> map = new HashMap<Serializable, EmailApp>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EmailApp emailApp = fetchByPrimaryKey(primaryKey);

			if (emailApp != null) {
				map.put(primaryKey, emailApp);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
					EmailAppImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EmailApp)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMAILAPP_WHERE_PKS_IN);

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

			for (EmailApp emailApp : (List<EmailApp>)q.list()) {
				map.put(emailApp.getPrimaryKeyObj(), emailApp);

				cacheResult(emailApp);

				uncachedPrimaryKeys.remove(emailApp.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmailAppModelImpl.ENTITY_CACHE_ENABLED,
					EmailAppImpl.class, primaryKey, nullModel);
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
	 * Returns all the email apps.
	 *
	 * @return the email apps
	 */
	@Override
	public List<EmailApp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email apps
	 * @param end the upper bound of the range of email apps (not inclusive)
	 * @return the range of email apps
	 */
	@Override
	public List<EmailApp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the email apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email apps
	 * @param end the upper bound of the range of email apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email apps
	 */
	@Override
	public List<EmailApp> findAll(int start, int end,
		OrderByComparator<EmailApp> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email apps
	 * @param end the upper bound of the range of email apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of email apps
	 */
	@Override
	public List<EmailApp> findAll(int start, int end,
		OrderByComparator<EmailApp> orderByComparator, boolean retrieveFromCache) {
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

		List<EmailApp> list = null;

		if (retrieveFromCache) {
			list = (List<EmailApp>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMAILAPP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILAPP;

				if (pagination) {
					sql = sql.concat(EmailAppModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmailApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmailApp>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the email apps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmailApp emailApp : findAll()) {
			remove(emailApp);
		}
	}

	/**
	 * Returns the number of email apps.
	 *
	 * @return the number of email apps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMAILAPP);

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
		return EmailAppModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email app persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmailAppImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMAILAPP = "SELECT emailApp FROM EmailApp emailApp";
	private static final String _SQL_SELECT_EMAILAPP_WHERE_PKS_IN = "SELECT emailApp FROM EmailApp emailApp WHERE id_ IN (";
	private static final String _SQL_SELECT_EMAILAPP_WHERE = "SELECT emailApp FROM EmailApp emailApp WHERE ";
	private static final String _SQL_COUNT_EMAILAPP = "SELECT COUNT(emailApp) FROM EmailApp emailApp";
	private static final String _SQL_COUNT_EMAILAPP_WHERE = "SELECT COUNT(emailApp) FROM EmailApp emailApp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emailApp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmailApp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmailApp exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EmailAppPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}