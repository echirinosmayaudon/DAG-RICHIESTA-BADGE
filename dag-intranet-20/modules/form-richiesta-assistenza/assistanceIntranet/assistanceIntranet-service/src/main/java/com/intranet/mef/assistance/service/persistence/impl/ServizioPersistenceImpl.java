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

package com.intranet.mef.assistance.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.exception.NoSuchServizioException;
import com.intranet.mef.assistance.model.Servizio;
import com.intranet.mef.assistance.model.impl.ServizioImpl;
import com.intranet.mef.assistance.model.impl.ServizioModelImpl;
import com.intranet.mef.assistance.service.persistence.ServizioPersistence;

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
 * The persistence implementation for the servizio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioPersistence
 * @see com.intranet.mef.assistance.service.persistence.ServizioUtil
 * @generated
 */
@ProviderType
public class ServizioPersistenceImpl extends BasePersistenceImpl<Servizio>
	implements ServizioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServizioUtil} to access the servizio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServizioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, ServizioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, ServizioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, ServizioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, ServizioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ServizioModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(String uuid, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(String uuid, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean retrieveFromCache) {
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

		List<Servizio> list = null;

		if (retrieveFromCache) {
			list = (List<Servizio>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Servizio servizio : list) {
					if (!Objects.equals(uuid, servizio.getUuid())) {
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

			query.append(_SQL_SELECT_SERVIZIO_WHERE);

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
				query.append(ServizioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Servizio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Servizio>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByUuid_First(String uuid,
		OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {
		Servizio servizio = fetchByUuid_First(uuid, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioException(msg.toString());
	}

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUuid_First(String uuid,
		OrderByComparator<Servizio> orderByComparator) {
		List<Servizio> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByUuid_Last(String uuid,
		OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {
		Servizio servizio = fetchByUuid_Last(uuid, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioException(msg.toString());
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUuid_Last(String uuid,
		OrderByComparator<Servizio> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Servizio> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where uuid = &#63;.
	 *
	 * @param assServiceId the primary key of the current servizio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio[] findByUuid_PrevAndNext(String assServiceId, String uuid,
		OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {
		Servizio servizio = findByPrimaryKey(assServiceId);

		Session session = null;

		try {
			session = openSession();

			Servizio[] array = new ServizioImpl[3];

			array[0] = getByUuid_PrevAndNext(session, servizio, uuid,
					orderByComparator, true);

			array[1] = servizio;

			array[2] = getByUuid_PrevAndNext(session, servizio, uuid,
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

	protected Servizio getByUuid_PrevAndNext(Session session,
		Servizio servizio, String uuid,
		OrderByComparator<Servizio> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVIZIO_WHERE);

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
			query.append(ServizioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(servizio);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Servizio> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Servizio servizio : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(servizio);
		}
	}

	/**
	 * Returns the number of servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servizios
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVIZIO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "servizio.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "servizio.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(servizio.uuid IS NULL OR servizio.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCOPESID = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, ServizioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByScopesId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPESID =
		new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, ServizioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByScopesId",
			new String[] { String.class.getName() },
			ServizioModelImpl.ASSSCOPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCOPESID = new FinderPath(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByScopesId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the servizios where assScopeId = &#63;.
	 *
	 * @param assScopeId the ass scope ID
	 * @return the matching servizios
	 */
	@Override
	public List<Servizio> findByScopesId(String assScopeId) {
		return findByScopesId(assScopeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the servizios where assScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assScopeId the ass scope ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	@Override
	public List<Servizio> findByScopesId(String assScopeId, int start, int end) {
		return findByScopesId(assScopeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizios where assScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assScopeId the ass scope ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByScopesId(String assScopeId, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {
		return findByScopesId(assScopeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizios where assScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assScopeId the ass scope ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByScopesId(String assScopeId, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPESID;
			finderArgs = new Object[] { assScopeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCOPESID;
			finderArgs = new Object[] { assScopeId, start, end, orderByComparator };
		}

		List<Servizio> list = null;

		if (retrieveFromCache) {
			list = (List<Servizio>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Servizio servizio : list) {
					if (!Objects.equals(assScopeId, servizio.getAssScopeId())) {
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

			query.append(_SQL_SELECT_SERVIZIO_WHERE);

			boolean bindAssScopeId = false;

			if (assScopeId == null) {
				query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_1);
			}
			else if (assScopeId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_3);
			}
			else {
				bindAssScopeId = true;

				query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServizioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssScopeId) {
					qPos.add(assScopeId);
				}

				if (!pagination) {
					list = (List<Servizio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Servizio>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first servizio in the ordered set where assScopeId = &#63;.
	 *
	 * @param assScopeId the ass scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByScopesId_First(String assScopeId,
		OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {
		Servizio servizio = fetchByScopesId_First(assScopeId, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assScopeId=");
		msg.append(assScopeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioException(msg.toString());
	}

	/**
	 * Returns the first servizio in the ordered set where assScopeId = &#63;.
	 *
	 * @param assScopeId the ass scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByScopesId_First(String assScopeId,
		OrderByComparator<Servizio> orderByComparator) {
		List<Servizio> list = findByScopesId(assScopeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio in the ordered set where assScopeId = &#63;.
	 *
	 * @param assScopeId the ass scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByScopesId_Last(String assScopeId,
		OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {
		Servizio servizio = fetchByScopesId_Last(assScopeId, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assScopeId=");
		msg.append(assScopeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioException(msg.toString());
	}

	/**
	 * Returns the last servizio in the ordered set where assScopeId = &#63;.
	 *
	 * @param assScopeId the ass scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByScopesId_Last(String assScopeId,
		OrderByComparator<Servizio> orderByComparator) {
		int count = countByScopesId(assScopeId);

		if (count == 0) {
			return null;
		}

		List<Servizio> list = findByScopesId(assScopeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where assScopeId = &#63;.
	 *
	 * @param assServiceId the primary key of the current servizio
	 * @param assScopeId the ass scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio[] findByScopesId_PrevAndNext(String assServiceId,
		String assScopeId, OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {
		Servizio servizio = findByPrimaryKey(assServiceId);

		Session session = null;

		try {
			session = openSession();

			Servizio[] array = new ServizioImpl[3];

			array[0] = getByScopesId_PrevAndNext(session, servizio, assScopeId,
					orderByComparator, true);

			array[1] = servizio;

			array[2] = getByScopesId_PrevAndNext(session, servizio, assScopeId,
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

	protected Servizio getByScopesId_PrevAndNext(Session session,
		Servizio servizio, String assScopeId,
		OrderByComparator<Servizio> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVIZIO_WHERE);

		boolean bindAssScopeId = false;

		if (assScopeId == null) {
			query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_1);
		}
		else if (assScopeId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_3);
		}
		else {
			bindAssScopeId = true;

			query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_2);
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
			query.append(ServizioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAssScopeId) {
			qPos.add(assScopeId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(servizio);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Servizio> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizios where assScopeId = &#63; from the database.
	 *
	 * @param assScopeId the ass scope ID
	 */
	@Override
	public void removeByScopesId(String assScopeId) {
		for (Servizio servizio : findByScopesId(assScopeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(servizio);
		}
	}

	/**
	 * Returns the number of servizios where assScopeId = &#63;.
	 *
	 * @param assScopeId the ass scope ID
	 * @return the number of matching servizios
	 */
	@Override
	public int countByScopesId(String assScopeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCOPESID;

		Object[] finderArgs = new Object[] { assScopeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVIZIO_WHERE);

			boolean bindAssScopeId = false;

			if (assScopeId == null) {
				query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_1);
			}
			else if (assScopeId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_3);
			}
			else {
				bindAssScopeId = true;

				query.append(_FINDER_COLUMN_SCOPESID_ASSSCOPEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssScopeId) {
					qPos.add(assScopeId);
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

	private static final String _FINDER_COLUMN_SCOPESID_ASSSCOPEID_1 = "servizio.assScopeId IS NULL";
	private static final String _FINDER_COLUMN_SCOPESID_ASSSCOPEID_2 = "servizio.assScopeId = ?";
	private static final String _FINDER_COLUMN_SCOPESID_ASSSCOPEID_3 = "(servizio.assScopeId IS NULL OR servizio.assScopeId = '')";

	public ServizioPersistenceImpl() {
		setModelClass(Servizio.class);
	}

	/**
	 * Caches the servizio in the entity cache if it is enabled.
	 *
	 * @param servizio the servizio
	 */
	@Override
	public void cacheResult(Servizio servizio) {
		entityCache.putResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioImpl.class, servizio.getPrimaryKey(), servizio);

		servizio.resetOriginalValues();
	}

	/**
	 * Caches the servizios in the entity cache if it is enabled.
	 *
	 * @param servizios the servizios
	 */
	@Override
	public void cacheResult(List<Servizio> servizios) {
		for (Servizio servizio : servizios) {
			if (entityCache.getResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
						ServizioImpl.class, servizio.getPrimaryKey()) == null) {
				cacheResult(servizio);
			}
			else {
				servizio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all servizios.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServizioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the servizio.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Servizio servizio) {
		entityCache.removeResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioImpl.class, servizio.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Servizio> servizios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Servizio servizio : servizios) {
			entityCache.removeResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
				ServizioImpl.class, servizio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param assServiceId the primary key for the new servizio
	 * @return the new servizio
	 */
	@Override
	public Servizio create(String assServiceId) {
		Servizio servizio = new ServizioImpl();

		servizio.setNew(true);
		servizio.setPrimaryKey(assServiceId);

		String uuid = PortalUUIDUtil.generate();

		servizio.setUuid(uuid);

		return servizio;
	}

	/**
	 * Removes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assServiceId the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio remove(String assServiceId) throws NoSuchServizioException {
		return remove((Serializable)assServiceId);
	}

	/**
	 * Removes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio remove(Serializable primaryKey)
		throws NoSuchServizioException {
		Session session = null;

		try {
			session = openSession();

			Servizio servizio = (Servizio)session.get(ServizioImpl.class,
					primaryKey);

			if (servizio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServizioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(servizio);
		}
		catch (NoSuchServizioException nsee) {
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
	protected Servizio removeImpl(Servizio servizio) {
		servizio = toUnwrappedModel(servizio);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(servizio)) {
				servizio = (Servizio)session.get(ServizioImpl.class,
						servizio.getPrimaryKeyObj());
			}

			if (servizio != null) {
				session.delete(servizio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (servizio != null) {
			clearCache(servizio);
		}

		return servizio;
	}

	@Override
	public Servizio updateImpl(Servizio servizio) {
		servizio = toUnwrappedModel(servizio);

		boolean isNew = servizio.isNew();

		ServizioModelImpl servizioModelImpl = (ServizioModelImpl)servizio;

		if (Validator.isNull(servizio.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			servizio.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (servizio.isNew()) {
				session.save(servizio);

				servizio.setNew(false);
			}
			else {
				servizio = (Servizio)session.merge(servizio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServizioModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((servizioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { servizioModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { servizioModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((servizioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						servizioModelImpl.getOriginalAssScopeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCOPESID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPESID,
					args);

				args = new Object[] { servizioModelImpl.getAssScopeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCOPESID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPESID,
					args);
			}
		}

		entityCache.putResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
			ServizioImpl.class, servizio.getPrimaryKey(), servizio, false);

		servizio.resetOriginalValues();

		return servizio;
	}

	protected Servizio toUnwrappedModel(Servizio servizio) {
		if (servizio instanceof ServizioImpl) {
			return servizio;
		}

		ServizioImpl servizioImpl = new ServizioImpl();

		servizioImpl.setNew(servizio.isNew());
		servizioImpl.setPrimaryKey(servizio.getPrimaryKey());

		servizioImpl.setUuid(servizio.getUuid());
		servizioImpl.setAssServiceId(servizio.getAssServiceId());
		servizioImpl.setServiceName(servizio.getServiceName());
		servizioImpl.setAssScopeId(servizio.getAssScopeId());
		servizioImpl.setLevelAssistance(servizio.getLevelAssistance());

		return servizioImpl;
	}

	/**
	 * Returns the servizio with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio
	 * @return the servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServizioException {
		Servizio servizio = fetchByPrimaryKey(primaryKey);

		if (servizio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServizioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return servizio;
	}

	/**
	 * Returns the servizio with the primary key or throws a {@link NoSuchServizioException} if it could not be found.
	 *
	 * @param assServiceId the primary key of the servizio
	 * @return the servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio findByPrimaryKey(String assServiceId)
		throws NoSuchServizioException {
		return findByPrimaryKey((Serializable)assServiceId);
	}

	/**
	 * Returns the servizio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio
	 * @return the servizio, or <code>null</code> if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
				ServizioImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Servizio servizio = (Servizio)serializable;

		if (servizio == null) {
			Session session = null;

			try {
				session = openSession();

				servizio = (Servizio)session.get(ServizioImpl.class, primaryKey);

				if (servizio != null) {
					cacheResult(servizio);
				}
				else {
					entityCache.putResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
						ServizioImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
					ServizioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return servizio;
	}

	/**
	 * Returns the servizio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assServiceId the primary key of the servizio
	 * @return the servizio, or <code>null</code> if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio fetchByPrimaryKey(String assServiceId) {
		return fetchByPrimaryKey((Serializable)assServiceId);
	}

	@Override
	public Map<Serializable, Servizio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Servizio> map = new HashMap<Serializable, Servizio>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Servizio servizio = fetchByPrimaryKey(primaryKey);

			if (servizio != null) {
				map.put(primaryKey, servizio);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
					ServizioImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Servizio)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_SERVIZIO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Servizio servizio : (List<Servizio>)q.list()) {
				map.put(servizio.getPrimaryKeyObj(), servizio);

				cacheResult(servizio);

				uncachedPrimaryKeys.remove(servizio.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ServizioModelImpl.ENTITY_CACHE_ENABLED,
					ServizioImpl.class, primaryKey, nullModel);
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
	 * Returns all the servizios.
	 *
	 * @return the servizios
	 */
	@Override
	public List<Servizio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of servizios
	 */
	@Override
	public List<Servizio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizios
	 */
	@Override
	public List<Servizio> findAll(int start, int end,
		OrderByComparator<Servizio> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of servizios
	 */
	@Override
	public List<Servizio> findAll(int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean retrieveFromCache) {
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

		List<Servizio> list = null;

		if (retrieveFromCache) {
			list = (List<Servizio>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SERVIZIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVIZIO;

				if (pagination) {
					sql = sql.concat(ServizioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Servizio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Servizio>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the servizios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Servizio servizio : findAll()) {
			remove(servizio);
		}
	}

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVIZIO);

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
		return ServizioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the servizio persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ServizioImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SERVIZIO = "SELECT servizio FROM Servizio servizio";
	private static final String _SQL_SELECT_SERVIZIO_WHERE_PKS_IN = "SELECT servizio FROM Servizio servizio WHERE assServiceId IN (";
	private static final String _SQL_SELECT_SERVIZIO_WHERE = "SELECT servizio FROM Servizio servizio WHERE ";
	private static final String _SQL_COUNT_SERVIZIO = "SELECT COUNT(servizio) FROM Servizio servizio";
	private static final String _SQL_COUNT_SERVIZIO_WHERE = "SELECT COUNT(servizio) FROM Servizio servizio WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "servizio.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Servizio exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Servizio exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ServizioPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}