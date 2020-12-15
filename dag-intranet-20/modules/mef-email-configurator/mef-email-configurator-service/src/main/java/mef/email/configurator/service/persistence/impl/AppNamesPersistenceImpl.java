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

import mef.email.configurator.exception.NoSuchAppNamesException;
import mef.email.configurator.model.AppNames;
import mef.email.configurator.model.impl.AppNamesImpl;
import mef.email.configurator.model.impl.AppNamesModelImpl;
import mef.email.configurator.service.persistence.AppNamesPersistence;

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
 * The persistence implementation for the app names service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppNamesPersistence
 * @see mef.email.configurator.service.persistence.AppNamesUtil
 * @generated
 */
@ProviderType
public class AppNamesPersistenceImpl extends BasePersistenceImpl<AppNames>
	implements AppNamesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppNamesUtil} to access the app names persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppNamesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, AppNamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, AppNamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPNAME = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, AppNamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppname",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPNAME =
		new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, AppNamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppname",
			new String[] { String.class.getName() },
			AppNamesModelImpl.APPNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPNAME = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppname",
			new String[] { String.class.getName() });

	/**
	 * Returns all the app nameses where appname = &#63;.
	 *
	 * @param appname the appname
	 * @return the matching app nameses
	 */
	@Override
	public List<AppNames> findByAppname(String appname) {
		return findByAppname(appname, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app nameses where appname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appname the appname
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @return the range of matching app nameses
	 */
	@Override
	public List<AppNames> findByAppname(String appname, int start, int end) {
		return findByAppname(appname, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app nameses where appname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appname the appname
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app nameses
	 */
	@Override
	public List<AppNames> findByAppname(String appname, int start, int end,
		OrderByComparator<AppNames> orderByComparator) {
		return findByAppname(appname, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app nameses where appname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appname the appname
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching app nameses
	 */
	@Override
	public List<AppNames> findByAppname(String appname, int start, int end,
		OrderByComparator<AppNames> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPNAME;
			finderArgs = new Object[] { appname };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPNAME;
			finderArgs = new Object[] { appname, start, end, orderByComparator };
		}

		List<AppNames> list = null;

		if (retrieveFromCache) {
			list = (List<AppNames>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppNames appNames : list) {
					if (!Objects.equals(appname, appNames.getAppname())) {
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

			query.append(_SQL_SELECT_APPNAMES_WHERE);

			boolean bindAppname = false;

			if (appname == null) {
				query.append(_FINDER_COLUMN_APPNAME_APPNAME_1);
			}
			else if (appname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPNAME_APPNAME_3);
			}
			else {
				bindAppname = true;

				query.append(_FINDER_COLUMN_APPNAME_APPNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppNamesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppname) {
					qPos.add(appname);
				}

				if (!pagination) {
					list = (List<AppNames>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppNames>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first app names in the ordered set where appname = &#63;.
	 *
	 * @param appname the appname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app names
	 * @throws NoSuchAppNamesException if a matching app names could not be found
	 */
	@Override
	public AppNames findByAppname_First(String appname,
		OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException {
		AppNames appNames = fetchByAppname_First(appname, orderByComparator);

		if (appNames != null) {
			return appNames;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appname=");
		msg.append(appname);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppNamesException(msg.toString());
	}

	/**
	 * Returns the first app names in the ordered set where appname = &#63;.
	 *
	 * @param appname the appname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app names, or <code>null</code> if a matching app names could not be found
	 */
	@Override
	public AppNames fetchByAppname_First(String appname,
		OrderByComparator<AppNames> orderByComparator) {
		List<AppNames> list = findByAppname(appname, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app names in the ordered set where appname = &#63;.
	 *
	 * @param appname the appname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app names
	 * @throws NoSuchAppNamesException if a matching app names could not be found
	 */
	@Override
	public AppNames findByAppname_Last(String appname,
		OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException {
		AppNames appNames = fetchByAppname_Last(appname, orderByComparator);

		if (appNames != null) {
			return appNames;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appname=");
		msg.append(appname);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppNamesException(msg.toString());
	}

	/**
	 * Returns the last app names in the ordered set where appname = &#63;.
	 *
	 * @param appname the appname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app names, or <code>null</code> if a matching app names could not be found
	 */
	@Override
	public AppNames fetchByAppname_Last(String appname,
		OrderByComparator<AppNames> orderByComparator) {
		int count = countByAppname(appname);

		if (count == 0) {
			return null;
		}

		List<AppNames> list = findByAppname(appname, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app nameses before and after the current app names in the ordered set where appname = &#63;.
	 *
	 * @param id the primary key of the current app names
	 * @param appname the appname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app names
	 * @throws NoSuchAppNamesException if a app names with the primary key could not be found
	 */
	@Override
	public AppNames[] findByAppname_PrevAndNext(long id, String appname,
		OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException {
		AppNames appNames = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AppNames[] array = new AppNamesImpl[3];

			array[0] = getByAppname_PrevAndNext(session, appNames, appname,
					orderByComparator, true);

			array[1] = appNames;

			array[2] = getByAppname_PrevAndNext(session, appNames, appname,
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

	protected AppNames getByAppname_PrevAndNext(Session session,
		AppNames appNames, String appname,
		OrderByComparator<AppNames> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPNAMES_WHERE);

		boolean bindAppname = false;

		if (appname == null) {
			query.append(_FINDER_COLUMN_APPNAME_APPNAME_1);
		}
		else if (appname.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPNAME_APPNAME_3);
		}
		else {
			bindAppname = true;

			query.append(_FINDER_COLUMN_APPNAME_APPNAME_2);
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
			query.append(AppNamesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAppname) {
			qPos.add(appname);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appNames);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AppNames> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app nameses where appname = &#63; from the database.
	 *
	 * @param appname the appname
	 */
	@Override
	public void removeByAppname(String appname) {
		for (AppNames appNames : findByAppname(appname, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(appNames);
		}
	}

	/**
	 * Returns the number of app nameses where appname = &#63;.
	 *
	 * @param appname the appname
	 * @return the number of matching app nameses
	 */
	@Override
	public int countByAppname(String appname) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPNAME;

		Object[] finderArgs = new Object[] { appname };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPNAMES_WHERE);

			boolean bindAppname = false;

			if (appname == null) {
				query.append(_FINDER_COLUMN_APPNAME_APPNAME_1);
			}
			else if (appname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPNAME_APPNAME_3);
			}
			else {
				bindAppname = true;

				query.append(_FINDER_COLUMN_APPNAME_APPNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppname) {
					qPos.add(appname);
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

	private static final String _FINDER_COLUMN_APPNAME_APPNAME_1 = "appNames.appname IS NULL";
	private static final String _FINDER_COLUMN_APPNAME_APPNAME_2 = "appNames.appname = ?";
	private static final String _FINDER_COLUMN_APPNAME_APPNAME_3 = "(appNames.appname IS NULL OR appNames.appname = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPID = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, AppNamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, AppNamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppId",
			new String[] { Long.class.getName() },
			AppNamesModelImpl.APPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPID = new FinderPath(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the app nameses where appid = &#63;.
	 *
	 * @param appid the appid
	 * @return the matching app nameses
	 */
	@Override
	public List<AppNames> findByAppId(long appid) {
		return findByAppId(appid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app nameses where appid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appid the appid
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @return the range of matching app nameses
	 */
	@Override
	public List<AppNames> findByAppId(long appid, int start, int end) {
		return findByAppId(appid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app nameses where appid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appid the appid
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app nameses
	 */
	@Override
	public List<AppNames> findByAppId(long appid, int start, int end,
		OrderByComparator<AppNames> orderByComparator) {
		return findByAppId(appid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app nameses where appid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appid the appid
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching app nameses
	 */
	@Override
	public List<AppNames> findByAppId(long appid, int start, int end,
		OrderByComparator<AppNames> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID;
			finderArgs = new Object[] { appid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPID;
			finderArgs = new Object[] { appid, start, end, orderByComparator };
		}

		List<AppNames> list = null;

		if (retrieveFromCache) {
			list = (List<AppNames>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppNames appNames : list) {
					if ((appid != appNames.getAppid())) {
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

			query.append(_SQL_SELECT_APPNAMES_WHERE);

			query.append(_FINDER_COLUMN_APPID_APPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppNamesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appid);

				if (!pagination) {
					list = (List<AppNames>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppNames>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first app names in the ordered set where appid = &#63;.
	 *
	 * @param appid the appid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app names
	 * @throws NoSuchAppNamesException if a matching app names could not be found
	 */
	@Override
	public AppNames findByAppId_First(long appid,
		OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException {
		AppNames appNames = fetchByAppId_First(appid, orderByComparator);

		if (appNames != null) {
			return appNames;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appid=");
		msg.append(appid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppNamesException(msg.toString());
	}

	/**
	 * Returns the first app names in the ordered set where appid = &#63;.
	 *
	 * @param appid the appid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app names, or <code>null</code> if a matching app names could not be found
	 */
	@Override
	public AppNames fetchByAppId_First(long appid,
		OrderByComparator<AppNames> orderByComparator) {
		List<AppNames> list = findByAppId(appid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app names in the ordered set where appid = &#63;.
	 *
	 * @param appid the appid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app names
	 * @throws NoSuchAppNamesException if a matching app names could not be found
	 */
	@Override
	public AppNames findByAppId_Last(long appid,
		OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException {
		AppNames appNames = fetchByAppId_Last(appid, orderByComparator);

		if (appNames != null) {
			return appNames;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appid=");
		msg.append(appid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppNamesException(msg.toString());
	}

	/**
	 * Returns the last app names in the ordered set where appid = &#63;.
	 *
	 * @param appid the appid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app names, or <code>null</code> if a matching app names could not be found
	 */
	@Override
	public AppNames fetchByAppId_Last(long appid,
		OrderByComparator<AppNames> orderByComparator) {
		int count = countByAppId(appid);

		if (count == 0) {
			return null;
		}

		List<AppNames> list = findByAppId(appid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app nameses before and after the current app names in the ordered set where appid = &#63;.
	 *
	 * @param id the primary key of the current app names
	 * @param appid the appid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app names
	 * @throws NoSuchAppNamesException if a app names with the primary key could not be found
	 */
	@Override
	public AppNames[] findByAppId_PrevAndNext(long id, long appid,
		OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException {
		AppNames appNames = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AppNames[] array = new AppNamesImpl[3];

			array[0] = getByAppId_PrevAndNext(session, appNames, appid,
					orderByComparator, true);

			array[1] = appNames;

			array[2] = getByAppId_PrevAndNext(session, appNames, appid,
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

	protected AppNames getByAppId_PrevAndNext(Session session,
		AppNames appNames, long appid,
		OrderByComparator<AppNames> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPNAMES_WHERE);

		query.append(_FINDER_COLUMN_APPID_APPID_2);

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
			query.append(AppNamesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(appid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appNames);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AppNames> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app nameses where appid = &#63; from the database.
	 *
	 * @param appid the appid
	 */
	@Override
	public void removeByAppId(long appid) {
		for (AppNames appNames : findByAppId(appid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(appNames);
		}
	}

	/**
	 * Returns the number of app nameses where appid = &#63;.
	 *
	 * @param appid the appid
	 * @return the number of matching app nameses
	 */
	@Override
	public int countByAppId(long appid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPID;

		Object[] finderArgs = new Object[] { appid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPNAMES_WHERE);

			query.append(_FINDER_COLUMN_APPID_APPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appid);

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

	private static final String _FINDER_COLUMN_APPID_APPID_2 = "appNames.appid = ?";

	public AppNamesPersistenceImpl() {
		setModelClass(AppNames.class);
	}

	/**
	 * Caches the app names in the entity cache if it is enabled.
	 *
	 * @param appNames the app names
	 */
	@Override
	public void cacheResult(AppNames appNames) {
		entityCache.putResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesImpl.class, appNames.getPrimaryKey(), appNames);

		appNames.resetOriginalValues();
	}

	/**
	 * Caches the app nameses in the entity cache if it is enabled.
	 *
	 * @param appNameses the app nameses
	 */
	@Override
	public void cacheResult(List<AppNames> appNameses) {
		for (AppNames appNames : appNameses) {
			if (entityCache.getResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
						AppNamesImpl.class, appNames.getPrimaryKey()) == null) {
				cacheResult(appNames);
			}
			else {
				appNames.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all app nameses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppNamesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the app names.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppNames appNames) {
		entityCache.removeResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesImpl.class, appNames.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AppNames> appNameses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppNames appNames : appNameses) {
			entityCache.removeResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
				AppNamesImpl.class, appNames.getPrimaryKey());
		}
	}

	/**
	 * Creates a new app names with the primary key. Does not add the app names to the database.
	 *
	 * @param id the primary key for the new app names
	 * @return the new app names
	 */
	@Override
	public AppNames create(long id) {
		AppNames appNames = new AppNamesImpl();

		appNames.setNew(true);
		appNames.setPrimaryKey(id);

		return appNames;
	}

	/**
	 * Removes the app names with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the app names
	 * @return the app names that was removed
	 * @throws NoSuchAppNamesException if a app names with the primary key could not be found
	 */
	@Override
	public AppNames remove(long id) throws NoSuchAppNamesException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the app names with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app names
	 * @return the app names that was removed
	 * @throws NoSuchAppNamesException if a app names with the primary key could not be found
	 */
	@Override
	public AppNames remove(Serializable primaryKey)
		throws NoSuchAppNamesException {
		Session session = null;

		try {
			session = openSession();

			AppNames appNames = (AppNames)session.get(AppNamesImpl.class,
					primaryKey);

			if (appNames == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppNamesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appNames);
		}
		catch (NoSuchAppNamesException nsee) {
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
	protected AppNames removeImpl(AppNames appNames) {
		appNames = toUnwrappedModel(appNames);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appNames)) {
				appNames = (AppNames)session.get(AppNamesImpl.class,
						appNames.getPrimaryKeyObj());
			}

			if (appNames != null) {
				session.delete(appNames);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appNames != null) {
			clearCache(appNames);
		}

		return appNames;
	}

	@Override
	public AppNames updateImpl(AppNames appNames) {
		appNames = toUnwrappedModel(appNames);

		boolean isNew = appNames.isNew();

		AppNamesModelImpl appNamesModelImpl = (AppNamesModelImpl)appNames;

		Session session = null;

		try {
			session = openSession();

			if (appNames.isNew()) {
				session.save(appNames);

				appNames.setNew(false);
			}
			else {
				appNames = (AppNames)session.merge(appNames);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AppNamesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((appNamesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appNamesModelImpl.getOriginalAppname()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPNAME,
					args);

				args = new Object[] { appNamesModelImpl.getAppname() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPNAME,
					args);
			}

			if ((appNamesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appNamesModelImpl.getOriginalAppid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
					args);

				args = new Object[] { appNamesModelImpl.getAppid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
					args);
			}
		}

		entityCache.putResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
			AppNamesImpl.class, appNames.getPrimaryKey(), appNames, false);

		appNames.resetOriginalValues();

		return appNames;
	}

	protected AppNames toUnwrappedModel(AppNames appNames) {
		if (appNames instanceof AppNamesImpl) {
			return appNames;
		}

		AppNamesImpl appNamesImpl = new AppNamesImpl();

		appNamesImpl.setNew(appNames.isNew());
		appNamesImpl.setPrimaryKey(appNames.getPrimaryKey());

		appNamesImpl.setId(appNames.getId());
		appNamesImpl.setAppname(appNames.getAppname());
		appNamesImpl.setAppid(appNames.getAppid());

		return appNamesImpl;
	}

	/**
	 * Returns the app names with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the app names
	 * @return the app names
	 * @throws NoSuchAppNamesException if a app names with the primary key could not be found
	 */
	@Override
	public AppNames findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppNamesException {
		AppNames appNames = fetchByPrimaryKey(primaryKey);

		if (appNames == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppNamesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appNames;
	}

	/**
	 * Returns the app names with the primary key or throws a {@link NoSuchAppNamesException} if it could not be found.
	 *
	 * @param id the primary key of the app names
	 * @return the app names
	 * @throws NoSuchAppNamesException if a app names with the primary key could not be found
	 */
	@Override
	public AppNames findByPrimaryKey(long id) throws NoSuchAppNamesException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the app names with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app names
	 * @return the app names, or <code>null</code> if a app names with the primary key could not be found
	 */
	@Override
	public AppNames fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
				AppNamesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AppNames appNames = (AppNames)serializable;

		if (appNames == null) {
			Session session = null;

			try {
				session = openSession();

				appNames = (AppNames)session.get(AppNamesImpl.class, primaryKey);

				if (appNames != null) {
					cacheResult(appNames);
				}
				else {
					entityCache.putResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
						AppNamesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
					AppNamesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appNames;
	}

	/**
	 * Returns the app names with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the app names
	 * @return the app names, or <code>null</code> if a app names with the primary key could not be found
	 */
	@Override
	public AppNames fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, AppNames> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AppNames> map = new HashMap<Serializable, AppNames>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AppNames appNames = fetchByPrimaryKey(primaryKey);

			if (appNames != null) {
				map.put(primaryKey, appNames);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
					AppNamesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AppNames)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPNAMES_WHERE_PKS_IN);

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

			for (AppNames appNames : (List<AppNames>)q.list()) {
				map.put(appNames.getPrimaryKeyObj(), appNames);

				cacheResult(appNames);

				uncachedPrimaryKeys.remove(appNames.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppNamesModelImpl.ENTITY_CACHE_ENABLED,
					AppNamesImpl.class, primaryKey, nullModel);
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
	 * Returns all the app nameses.
	 *
	 * @return the app nameses
	 */
	@Override
	public List<AppNames> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app nameses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @return the range of app nameses
	 */
	@Override
	public List<AppNames> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the app nameses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app nameses
	 */
	@Override
	public List<AppNames> findAll(int start, int end,
		OrderByComparator<AppNames> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app nameses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of app nameses
	 * @param end the upper bound of the range of app nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of app nameses
	 */
	@Override
	public List<AppNames> findAll(int start, int end,
		OrderByComparator<AppNames> orderByComparator, boolean retrieveFromCache) {
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

		List<AppNames> list = null;

		if (retrieveFromCache) {
			list = (List<AppNames>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPNAMES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPNAMES;

				if (pagination) {
					sql = sql.concat(AppNamesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AppNames>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppNames>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the app nameses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppNames appNames : findAll()) {
			remove(appNames);
		}
	}

	/**
	 * Returns the number of app nameses.
	 *
	 * @return the number of app nameses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPNAMES);

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
		return AppNamesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the app names persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppNamesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_APPNAMES = "SELECT appNames FROM AppNames appNames";
	private static final String _SQL_SELECT_APPNAMES_WHERE_PKS_IN = "SELECT appNames FROM AppNames appNames WHERE id_ IN (";
	private static final String _SQL_SELECT_APPNAMES_WHERE = "SELECT appNames FROM AppNames appNames WHERE ";
	private static final String _SQL_COUNT_APPNAMES = "SELECT COUNT(appNames) FROM AppNames appNames";
	private static final String _SQL_COUNT_APPNAMES_WHERE = "SELECT COUNT(appNames) FROM AppNames appNames WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appNames.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppNames exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppNames exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppNamesPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}