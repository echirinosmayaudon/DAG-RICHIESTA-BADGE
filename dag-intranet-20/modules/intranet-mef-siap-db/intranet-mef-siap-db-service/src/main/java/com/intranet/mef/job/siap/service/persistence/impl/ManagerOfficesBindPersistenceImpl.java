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

package com.intranet.mef.job.siap.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.exception.NoSuchManagerOfficesBindException;
import com.intranet.mef.job.siap.model.ManagerOfficesBind;
import com.intranet.mef.job.siap.model.impl.ManagerOfficesBindImpl;
import com.intranet.mef.job.siap.model.impl.ManagerOfficesBindModelImpl;
import com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK;
import com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPersistence;

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

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the manager offices bind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ManagerOfficesBindPersistence
 * @see com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindUtil
 * @generated
 */
@ProviderType
public class ManagerOfficesBindPersistenceImpl extends BasePersistenceImpl<ManagerOfficesBind>
	implements ManagerOfficesBindPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ManagerOfficesBindUtil} to access the manager offices bind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ManagerOfficesBindImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindModelImpl.FINDER_CACHE_ENABLED,
			ManagerOfficesBindImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindModelImpl.FINDER_CACHE_ENABLED,
			ManagerOfficesBindImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID = new FinderPath(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindModelImpl.FINDER_CACHE_ENABLED,
			ManagerOfficesBindImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersonId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID =
		new FinderPath(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindModelImpl.FINDER_CACHE_ENABLED,
			ManagerOfficesBindImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPersonId",
			new String[] { Long.class.getName() },
			ManagerOfficesBindModelImpl.PERSONALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSONID = new FinderPath(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the manager offices binds where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @return the matching manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findByPersonId(long personalId) {
		return findByPersonId(personalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the manager offices binds where personalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personalId the personal ID
	 * @param start the lower bound of the range of manager offices binds
	 * @param end the upper bound of the range of manager offices binds (not inclusive)
	 * @return the range of matching manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findByPersonId(long personalId, int start,
		int end) {
		return findByPersonId(personalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manager offices binds where personalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personalId the personal ID
	 * @param start the lower bound of the range of manager offices binds
	 * @param end the upper bound of the range of manager offices binds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findByPersonId(long personalId, int start,
		int end, OrderByComparator<ManagerOfficesBind> orderByComparator) {
		return findByPersonId(personalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manager offices binds where personalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personalId the personal ID
	 * @param start the lower bound of the range of manager offices binds
	 * @param end the upper bound of the range of manager offices binds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findByPersonId(long personalId, int start,
		int end, OrderByComparator<ManagerOfficesBind> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personalId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personalId, start, end, orderByComparator };
		}

		List<ManagerOfficesBind> list = null;

		if (retrieveFromCache) {
			list = (List<ManagerOfficesBind>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ManagerOfficesBind managerOfficesBind : list) {
					if ((personalId != managerOfficesBind.getPersonalId())) {
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

			query.append(_SQL_SELECT_MANAGEROFFICESBIND_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ManagerOfficesBindModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personalId);

				if (!pagination) {
					list = (List<ManagerOfficesBind>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ManagerOfficesBind>)QueryUtil.list(q,
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
	 * Returns the first manager offices bind in the ordered set where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manager offices bind
	 * @throws NoSuchManagerOfficesBindException if a matching manager offices bind could not be found
	 */
	@Override
	public ManagerOfficesBind findByPersonId_First(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws NoSuchManagerOfficesBindException {
		ManagerOfficesBind managerOfficesBind = fetchByPersonId_First(personalId,
				orderByComparator);

		if (managerOfficesBind != null) {
			return managerOfficesBind;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personalId=");
		msg.append(personalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerOfficesBindException(msg.toString());
	}

	/**
	 * Returns the first manager offices bind in the ordered set where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manager offices bind, or <code>null</code> if a matching manager offices bind could not be found
	 */
	@Override
	public ManagerOfficesBind fetchByPersonId_First(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		List<ManagerOfficesBind> list = findByPersonId(personalId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manager offices bind in the ordered set where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manager offices bind
	 * @throws NoSuchManagerOfficesBindException if a matching manager offices bind could not be found
	 */
	@Override
	public ManagerOfficesBind findByPersonId_Last(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws NoSuchManagerOfficesBindException {
		ManagerOfficesBind managerOfficesBind = fetchByPersonId_Last(personalId,
				orderByComparator);

		if (managerOfficesBind != null) {
			return managerOfficesBind;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personalId=");
		msg.append(personalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerOfficesBindException(msg.toString());
	}

	/**
	 * Returns the last manager offices bind in the ordered set where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manager offices bind, or <code>null</code> if a matching manager offices bind could not be found
	 */
	@Override
	public ManagerOfficesBind fetchByPersonId_Last(long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		int count = countByPersonId(personalId);

		if (count == 0) {
			return null;
		}

		List<ManagerOfficesBind> list = findByPersonId(personalId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manager offices binds before and after the current manager offices bind in the ordered set where personalId = &#63;.
	 *
	 * @param managerOfficesBindPK the primary key of the current manager offices bind
	 * @param personalId the personal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manager offices bind
	 * @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	 */
	@Override
	public ManagerOfficesBind[] findByPersonId_PrevAndNext(
		ManagerOfficesBindPK managerOfficesBindPK, long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws NoSuchManagerOfficesBindException {
		ManagerOfficesBind managerOfficesBind = findByPrimaryKey(managerOfficesBindPK);

		Session session = null;

		try {
			session = openSession();

			ManagerOfficesBind[] array = new ManagerOfficesBindImpl[3];

			array[0] = getByPersonId_PrevAndNext(session, managerOfficesBind,
					personalId, orderByComparator, true);

			array[1] = managerOfficesBind;

			array[2] = getByPersonId_PrevAndNext(session, managerOfficesBind,
					personalId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ManagerOfficesBind getByPersonId_PrevAndNext(Session session,
		ManagerOfficesBind managerOfficesBind, long personalId,
		OrderByComparator<ManagerOfficesBind> orderByComparator,
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

		query.append(_SQL_SELECT_MANAGEROFFICESBIND_WHERE);

		query.append(_FINDER_COLUMN_PERSONID_PERSONALID_2);

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
			query.append(ManagerOfficesBindModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(personalId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(managerOfficesBind);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ManagerOfficesBind> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manager offices binds where personalId = &#63; from the database.
	 *
	 * @param personalId the personal ID
	 */
	@Override
	public void removeByPersonId(long personalId) {
		for (ManagerOfficesBind managerOfficesBind : findByPersonId(
				personalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(managerOfficesBind);
		}
	}

	/**
	 * Returns the number of manager offices binds where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @return the number of matching manager offices binds
	 */
	@Override
	public int countByPersonId(long personalId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSONID;

		Object[] finderArgs = new Object[] { personalId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MANAGEROFFICESBIND_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personalId);

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

	private static final String _FINDER_COLUMN_PERSONID_PERSONALID_2 = "managerOfficesBind.id.personalId = ?";

	public ManagerOfficesBindPersistenceImpl() {
		setModelClass(ManagerOfficesBind.class);
	}

	/**
	 * Caches the manager offices bind in the entity cache if it is enabled.
	 *
	 * @param managerOfficesBind the manager offices bind
	 */
	@Override
	public void cacheResult(ManagerOfficesBind managerOfficesBind) {
		entityCache.putResult(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindImpl.class, managerOfficesBind.getPrimaryKey(),
			managerOfficesBind);

		managerOfficesBind.resetOriginalValues();
	}

	/**
	 * Caches the manager offices binds in the entity cache if it is enabled.
	 *
	 * @param managerOfficesBinds the manager offices binds
	 */
	@Override
	public void cacheResult(List<ManagerOfficesBind> managerOfficesBinds) {
		for (ManagerOfficesBind managerOfficesBind : managerOfficesBinds) {
			if (entityCache.getResult(
						ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
						ManagerOfficesBindImpl.class,
						managerOfficesBind.getPrimaryKey()) == null) {
				cacheResult(managerOfficesBind);
			}
			else {
				managerOfficesBind.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all manager offices binds.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ManagerOfficesBindImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the manager offices bind.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ManagerOfficesBind managerOfficesBind) {
		entityCache.removeResult(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindImpl.class, managerOfficesBind.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ManagerOfficesBind> managerOfficesBinds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ManagerOfficesBind managerOfficesBind : managerOfficesBinds) {
			entityCache.removeResult(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
				ManagerOfficesBindImpl.class, managerOfficesBind.getPrimaryKey());
		}
	}

	/**
	 * Creates a new manager offices bind with the primary key. Does not add the manager offices bind to the database.
	 *
	 * @param managerOfficesBindPK the primary key for the new manager offices bind
	 * @return the new manager offices bind
	 */
	@Override
	public ManagerOfficesBind create(ManagerOfficesBindPK managerOfficesBindPK) {
		ManagerOfficesBind managerOfficesBind = new ManagerOfficesBindImpl();

		managerOfficesBind.setNew(true);
		managerOfficesBind.setPrimaryKey(managerOfficesBindPK);

		return managerOfficesBind;
	}

	/**
	 * Removes the manager offices bind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param managerOfficesBindPK the primary key of the manager offices bind
	 * @return the manager offices bind that was removed
	 * @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	 */
	@Override
	public ManagerOfficesBind remove(ManagerOfficesBindPK managerOfficesBindPK)
		throws NoSuchManagerOfficesBindException {
		return remove((Serializable)managerOfficesBindPK);
	}

	/**
	 * Removes the manager offices bind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the manager offices bind
	 * @return the manager offices bind that was removed
	 * @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	 */
	@Override
	public ManagerOfficesBind remove(Serializable primaryKey)
		throws NoSuchManagerOfficesBindException {
		Session session = null;

		try {
			session = openSession();

			ManagerOfficesBind managerOfficesBind = (ManagerOfficesBind)session.get(ManagerOfficesBindImpl.class,
					primaryKey);

			if (managerOfficesBind == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchManagerOfficesBindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(managerOfficesBind);
		}
		catch (NoSuchManagerOfficesBindException nsee) {
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
	protected ManagerOfficesBind removeImpl(
		ManagerOfficesBind managerOfficesBind) {
		managerOfficesBind = toUnwrappedModel(managerOfficesBind);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(managerOfficesBind)) {
				managerOfficesBind = (ManagerOfficesBind)session.get(ManagerOfficesBindImpl.class,
						managerOfficesBind.getPrimaryKeyObj());
			}

			if (managerOfficesBind != null) {
				session.delete(managerOfficesBind);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (managerOfficesBind != null) {
			clearCache(managerOfficesBind);
		}

		return managerOfficesBind;
	}

	@Override
	public ManagerOfficesBind updateImpl(ManagerOfficesBind managerOfficesBind) {
		managerOfficesBind = toUnwrappedModel(managerOfficesBind);

		boolean isNew = managerOfficesBind.isNew();

		ManagerOfficesBindModelImpl managerOfficesBindModelImpl = (ManagerOfficesBindModelImpl)managerOfficesBind;

		Session session = null;

		try {
			session = openSession();

			if (managerOfficesBind.isNew()) {
				session.save(managerOfficesBind);

				managerOfficesBind.setNew(false);
			}
			else {
				managerOfficesBind = (ManagerOfficesBind)session.merge(managerOfficesBind);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ManagerOfficesBindModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((managerOfficesBindModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						managerOfficesBindModelImpl.getOriginalPersonalId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);

				args = new Object[] { managerOfficesBindModelImpl.getPersonalId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);
			}
		}

		entityCache.putResult(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
			ManagerOfficesBindImpl.class, managerOfficesBind.getPrimaryKey(),
			managerOfficesBind, false);

		managerOfficesBind.resetOriginalValues();

		return managerOfficesBind;
	}

	protected ManagerOfficesBind toUnwrappedModel(
		ManagerOfficesBind managerOfficesBind) {
		if (managerOfficesBind instanceof ManagerOfficesBindImpl) {
			return managerOfficesBind;
		}

		ManagerOfficesBindImpl managerOfficesBindImpl = new ManagerOfficesBindImpl();

		managerOfficesBindImpl.setNew(managerOfficesBind.isNew());
		managerOfficesBindImpl.setPrimaryKey(managerOfficesBind.getPrimaryKey());

		managerOfficesBindImpl.setPersonalId(managerOfficesBind.getPersonalId());
		managerOfficesBindImpl.setIdOrgChart(managerOfficesBind.getIdOrgChart());
		managerOfficesBindImpl.setPrimary(managerOfficesBind.getPrimary());
		managerOfficesBindImpl.setRegency(managerOfficesBind.getRegency());

		return managerOfficesBindImpl;
	}

	/**
	 * Returns the manager offices bind with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the manager offices bind
	 * @return the manager offices bind
	 * @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	 */
	@Override
	public ManagerOfficesBind findByPrimaryKey(Serializable primaryKey)
		throws NoSuchManagerOfficesBindException {
		ManagerOfficesBind managerOfficesBind = fetchByPrimaryKey(primaryKey);

		if (managerOfficesBind == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchManagerOfficesBindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return managerOfficesBind;
	}

	/**
	 * Returns the manager offices bind with the primary key or throws a {@link NoSuchManagerOfficesBindException} if it could not be found.
	 *
	 * @param managerOfficesBindPK the primary key of the manager offices bind
	 * @return the manager offices bind
	 * @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	 */
	@Override
	public ManagerOfficesBind findByPrimaryKey(
		ManagerOfficesBindPK managerOfficesBindPK)
		throws NoSuchManagerOfficesBindException {
		return findByPrimaryKey((Serializable)managerOfficesBindPK);
	}

	/**
	 * Returns the manager offices bind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the manager offices bind
	 * @return the manager offices bind, or <code>null</code> if a manager offices bind with the primary key could not be found
	 */
	@Override
	public ManagerOfficesBind fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
				ManagerOfficesBindImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ManagerOfficesBind managerOfficesBind = (ManagerOfficesBind)serializable;

		if (managerOfficesBind == null) {
			Session session = null;

			try {
				session = openSession();

				managerOfficesBind = (ManagerOfficesBind)session.get(ManagerOfficesBindImpl.class,
						primaryKey);

				if (managerOfficesBind != null) {
					cacheResult(managerOfficesBind);
				}
				else {
					entityCache.putResult(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
						ManagerOfficesBindImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ManagerOfficesBindModelImpl.ENTITY_CACHE_ENABLED,
					ManagerOfficesBindImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return managerOfficesBind;
	}

	/**
	 * Returns the manager offices bind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param managerOfficesBindPK the primary key of the manager offices bind
	 * @return the manager offices bind, or <code>null</code> if a manager offices bind with the primary key could not be found
	 */
	@Override
	public ManagerOfficesBind fetchByPrimaryKey(
		ManagerOfficesBindPK managerOfficesBindPK) {
		return fetchByPrimaryKey((Serializable)managerOfficesBindPK);
	}

	@Override
	public Map<Serializable, ManagerOfficesBind> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ManagerOfficesBind> map = new HashMap<Serializable, ManagerOfficesBind>();

		for (Serializable primaryKey : primaryKeys) {
			ManagerOfficesBind managerOfficesBind = fetchByPrimaryKey(primaryKey);

			if (managerOfficesBind != null) {
				map.put(primaryKey, managerOfficesBind);
			}
		}

		return map;
	}

	/**
	 * Returns all the manager offices binds.
	 *
	 * @return the manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manager offices binds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of manager offices binds
	 * @param end the upper bound of the range of manager offices binds (not inclusive)
	 * @return the range of manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the manager offices binds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of manager offices binds
	 * @param end the upper bound of the range of manager offices binds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findAll(int start, int end,
		OrderByComparator<ManagerOfficesBind> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manager offices binds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of manager offices binds
	 * @param end the upper bound of the range of manager offices binds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of manager offices binds
	 */
	@Override
	public List<ManagerOfficesBind> findAll(int start, int end,
		OrderByComparator<ManagerOfficesBind> orderByComparator,
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

		List<ManagerOfficesBind> list = null;

		if (retrieveFromCache) {
			list = (List<ManagerOfficesBind>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MANAGEROFFICESBIND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MANAGEROFFICESBIND;

				if (pagination) {
					sql = sql.concat(ManagerOfficesBindModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ManagerOfficesBind>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ManagerOfficesBind>)QueryUtil.list(q,
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
	 * Removes all the manager offices binds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ManagerOfficesBind managerOfficesBind : findAll()) {
			remove(managerOfficesBind);
		}
	}

	/**
	 * Returns the number of manager offices binds.
	 *
	 * @return the number of manager offices binds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MANAGEROFFICESBIND);

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
		return ManagerOfficesBindModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the manager offices bind persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ManagerOfficesBindImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MANAGEROFFICESBIND = "SELECT managerOfficesBind FROM ManagerOfficesBind managerOfficesBind";
	private static final String _SQL_SELECT_MANAGEROFFICESBIND_WHERE = "SELECT managerOfficesBind FROM ManagerOfficesBind managerOfficesBind WHERE ";
	private static final String _SQL_COUNT_MANAGEROFFICESBIND = "SELECT COUNT(managerOfficesBind) FROM ManagerOfficesBind managerOfficesBind";
	private static final String _SQL_COUNT_MANAGEROFFICESBIND_WHERE = "SELECT COUNT(managerOfficesBind) FROM ManagerOfficesBind managerOfficesBind WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "managerOfficesBind.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ManagerOfficesBind exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ManagerOfficesBind exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ManagerOfficesBindPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personalId", "idOrgChart", "primary", "regency"
			});
}