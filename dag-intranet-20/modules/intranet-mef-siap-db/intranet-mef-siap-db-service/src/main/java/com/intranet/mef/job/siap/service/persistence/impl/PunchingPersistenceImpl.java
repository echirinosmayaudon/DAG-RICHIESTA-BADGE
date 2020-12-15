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

import com.intranet.mef.job.siap.exception.NoSuchPunchingException;
import com.intranet.mef.job.siap.model.Punching;
import com.intranet.mef.job.siap.model.impl.PunchingImpl;
import com.intranet.mef.job.siap.model.impl.PunchingModelImpl;
import com.intranet.mef.job.siap.service.persistence.PunchingPersistence;

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the punching service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PunchingPersistence
 * @see com.intranet.mef.job.siap.service.persistence.PunchingUtil
 * @generated
 */
@ProviderType
public class PunchingPersistenceImpl extends BasePersistenceImpl<Punching>
	implements PunchingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PunchingUtil} to access the punching persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PunchingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingModelImpl.FINDER_CACHE_ENABLED, PunchingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingModelImpl.FINDER_CACHE_ENABLED, PunchingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID = new FinderPath(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingModelImpl.FINDER_CACHE_ENABLED, PunchingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersonId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID =
		new FinderPath(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingModelImpl.FINDER_CACHE_ENABLED, PunchingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPersonId",
			new String[] { Long.class.getName() },
			PunchingModelImpl.PERSONID_COLUMN_BITMASK |
			PunchingModelImpl.PUNCHINGDATE_COLUMN_BITMASK |
			PunchingModelImpl.PUNCHINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSONID = new FinderPath(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the punchings where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @return the matching punchings
	 */
	@Override
	public List<Punching> findByPersonId(long personId) {
		return findByPersonId(personId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the punchings where personId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param start the lower bound of the range of punchings
	 * @param end the upper bound of the range of punchings (not inclusive)
	 * @return the range of matching punchings
	 */
	@Override
	public List<Punching> findByPersonId(long personId, int start, int end) {
		return findByPersonId(personId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the punchings where personId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param start the lower bound of the range of punchings
	 * @param end the upper bound of the range of punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching punchings
	 */
	@Override
	public List<Punching> findByPersonId(long personId, int start, int end,
		OrderByComparator<Punching> orderByComparator) {
		return findByPersonId(personId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the punchings where personId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param start the lower bound of the range of punchings
	 * @param end the upper bound of the range of punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching punchings
	 */
	@Override
	public List<Punching> findByPersonId(long personId, int start, int end,
		OrderByComparator<Punching> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personId, start, end, orderByComparator };
		}

		List<Punching> list = null;

		if (retrieveFromCache) {
			list = (List<Punching>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Punching punching : list) {
					if ((personId != punching.getPersonId())) {
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

			query.append(_SQL_SELECT_PUNCHING_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PunchingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personId);

				if (!pagination) {
					list = (List<Punching>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Punching>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching punching
	 * @throws NoSuchPunchingException if a matching punching could not be found
	 */
	@Override
	public Punching findByPersonId_First(long personId,
		OrderByComparator<Punching> orderByComparator)
		throws NoSuchPunchingException {
		Punching punching = fetchByPersonId_First(personId, orderByComparator);

		if (punching != null) {
			return punching;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personId=");
		msg.append(personId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPunchingException(msg.toString());
	}

	/**
	 * Returns the first punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching punching, or <code>null</code> if a matching punching could not be found
	 */
	@Override
	public Punching fetchByPersonId_First(long personId,
		OrderByComparator<Punching> orderByComparator) {
		List<Punching> list = findByPersonId(personId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching punching
	 * @throws NoSuchPunchingException if a matching punching could not be found
	 */
	@Override
	public Punching findByPersonId_Last(long personId,
		OrderByComparator<Punching> orderByComparator)
		throws NoSuchPunchingException {
		Punching punching = fetchByPersonId_Last(personId, orderByComparator);

		if (punching != null) {
			return punching;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personId=");
		msg.append(personId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPunchingException(msg.toString());
	}

	/**
	 * Returns the last punching in the ordered set where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching punching, or <code>null</code> if a matching punching could not be found
	 */
	@Override
	public Punching fetchByPersonId_Last(long personId,
		OrderByComparator<Punching> orderByComparator) {
		int count = countByPersonId(personId);

		if (count == 0) {
			return null;
		}

		List<Punching> list = findByPersonId(personId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the punchings before and after the current punching in the ordered set where personId = &#63;.
	 *
	 * @param custom_key the primary key of the current punching
	 * @param personId the person ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next punching
	 * @throws NoSuchPunchingException if a punching with the primary key could not be found
	 */
	@Override
	public Punching[] findByPersonId_PrevAndNext(String custom_key,
		long personId, OrderByComparator<Punching> orderByComparator)
		throws NoSuchPunchingException {
		Punching punching = findByPrimaryKey(custom_key);

		Session session = null;

		try {
			session = openSession();

			Punching[] array = new PunchingImpl[3];

			array[0] = getByPersonId_PrevAndNext(session, punching, personId,
					orderByComparator, true);

			array[1] = punching;

			array[2] = getByPersonId_PrevAndNext(session, punching, personId,
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

	protected Punching getByPersonId_PrevAndNext(Session session,
		Punching punching, long personId,
		OrderByComparator<Punching> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUNCHING_WHERE);

		query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

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
			query.append(PunchingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(personId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(punching);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Punching> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the punchings where personId = &#63; from the database.
	 *
	 * @param personId the person ID
	 */
	@Override
	public void removeByPersonId(long personId) {
		for (Punching punching : findByPersonId(personId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(punching);
		}
	}

	/**
	 * Returns the number of punchings where personId = &#63;.
	 *
	 * @param personId the person ID
	 * @return the number of matching punchings
	 */
	@Override
	public int countByPersonId(long personId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSONID;

		Object[] finderArgs = new Object[] { personId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUNCHING_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personId);

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

	private static final String _FINDER_COLUMN_PERSONID_PERSONID_2 = "punching.personId = ?";

	public PunchingPersistenceImpl() {
		setModelClass(Punching.class);
	}

	/**
	 * Caches the punching in the entity cache if it is enabled.
	 *
	 * @param punching the punching
	 */
	@Override
	public void cacheResult(Punching punching) {
		entityCache.putResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingImpl.class, punching.getPrimaryKey(), punching);

		punching.resetOriginalValues();
	}

	/**
	 * Caches the punchings in the entity cache if it is enabled.
	 *
	 * @param punchings the punchings
	 */
	@Override
	public void cacheResult(List<Punching> punchings) {
		for (Punching punching : punchings) {
			if (entityCache.getResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
						PunchingImpl.class, punching.getPrimaryKey()) == null) {
				cacheResult(punching);
			}
			else {
				punching.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all punchings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PunchingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the punching.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Punching punching) {
		entityCache.removeResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingImpl.class, punching.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Punching> punchings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Punching punching : punchings) {
			entityCache.removeResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
				PunchingImpl.class, punching.getPrimaryKey());
		}
	}

	/**
	 * Creates a new punching with the primary key. Does not add the punching to the database.
	 *
	 * @param custom_key the primary key for the new punching
	 * @return the new punching
	 */
	@Override
	public Punching create(String custom_key) {
		Punching punching = new PunchingImpl();

		punching.setNew(true);
		punching.setPrimaryKey(custom_key);

		return punching;
	}

	/**
	 * Removes the punching with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param custom_key the primary key of the punching
	 * @return the punching that was removed
	 * @throws NoSuchPunchingException if a punching with the primary key could not be found
	 */
	@Override
	public Punching remove(String custom_key) throws NoSuchPunchingException {
		return remove((Serializable)custom_key);
	}

	/**
	 * Removes the punching with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the punching
	 * @return the punching that was removed
	 * @throws NoSuchPunchingException if a punching with the primary key could not be found
	 */
	@Override
	public Punching remove(Serializable primaryKey)
		throws NoSuchPunchingException {
		Session session = null;

		try {
			session = openSession();

			Punching punching = (Punching)session.get(PunchingImpl.class,
					primaryKey);

			if (punching == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPunchingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(punching);
		}
		catch (NoSuchPunchingException nsee) {
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
	protected Punching removeImpl(Punching punching) {
		punching = toUnwrappedModel(punching);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(punching)) {
				punching = (Punching)session.get(PunchingImpl.class,
						punching.getPrimaryKeyObj());
			}

			if (punching != null) {
				session.delete(punching);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (punching != null) {
			clearCache(punching);
		}

		return punching;
	}

	@Override
	public Punching updateImpl(Punching punching) {
		punching = toUnwrappedModel(punching);

		boolean isNew = punching.isNew();

		PunchingModelImpl punchingModelImpl = (PunchingModelImpl)punching;

		Session session = null;

		try {
			session = openSession();

			if (punching.isNew()) {
				session.save(punching);

				punching.setNew(false);
			}
			else {
				punching = (Punching)session.merge(punching);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PunchingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((punchingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						punchingModelImpl.getOriginalPersonId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);

				args = new Object[] { punchingModelImpl.getPersonId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);
			}
		}

		entityCache.putResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
			PunchingImpl.class, punching.getPrimaryKey(), punching, false);

		punching.resetOriginalValues();

		return punching;
	}

	protected Punching toUnwrappedModel(Punching punching) {
		if (punching instanceof PunchingImpl) {
			return punching;
		}

		PunchingImpl punchingImpl = new PunchingImpl();

		punchingImpl.setNew(punching.isNew());
		punchingImpl.setPrimaryKey(punching.getPrimaryKey());

		punchingImpl.setCustom_key(punching.getCustom_key());
		punchingImpl.setPersonId(punching.getPersonId());
		punchingImpl.setPunchingId(punching.getPunchingId());
		punchingImpl.setDirection(punching.getDirection());
		punchingImpl.setHours(punching.getHours());
		punchingImpl.setMinute(punching.getMinute());
		punchingImpl.setVoucher(punching.getVoucher());
		punchingImpl.setTerminal(punching.getTerminal());
		punchingImpl.setAccountingDate(punching.getAccountingDate());
		punchingImpl.setPunchingDate(punching.getPunchingDate());

		return punchingImpl;
	}

	/**
	 * Returns the punching with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the punching
	 * @return the punching
	 * @throws NoSuchPunchingException if a punching with the primary key could not be found
	 */
	@Override
	public Punching findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPunchingException {
		Punching punching = fetchByPrimaryKey(primaryKey);

		if (punching == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPunchingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return punching;
	}

	/**
	 * Returns the punching with the primary key or throws a {@link NoSuchPunchingException} if it could not be found.
	 *
	 * @param custom_key the primary key of the punching
	 * @return the punching
	 * @throws NoSuchPunchingException if a punching with the primary key could not be found
	 */
	@Override
	public Punching findByPrimaryKey(String custom_key)
		throws NoSuchPunchingException {
		return findByPrimaryKey((Serializable)custom_key);
	}

	/**
	 * Returns the punching with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the punching
	 * @return the punching, or <code>null</code> if a punching with the primary key could not be found
	 */
	@Override
	public Punching fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
				PunchingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Punching punching = (Punching)serializable;

		if (punching == null) {
			Session session = null;

			try {
				session = openSession();

				punching = (Punching)session.get(PunchingImpl.class, primaryKey);

				if (punching != null) {
					cacheResult(punching);
				}
				else {
					entityCache.putResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
						PunchingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
					PunchingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return punching;
	}

	/**
	 * Returns the punching with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param custom_key the primary key of the punching
	 * @return the punching, or <code>null</code> if a punching with the primary key could not be found
	 */
	@Override
	public Punching fetchByPrimaryKey(String custom_key) {
		return fetchByPrimaryKey((Serializable)custom_key);
	}

	@Override
	public Map<Serializable, Punching> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Punching> map = new HashMap<Serializable, Punching>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Punching punching = fetchByPrimaryKey(primaryKey);

			if (punching != null) {
				map.put(primaryKey, punching);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
					PunchingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Punching)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_PUNCHING_WHERE_PKS_IN);

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

			for (Punching punching : (List<Punching>)q.list()) {
				map.put(punching.getPrimaryKeyObj(), punching);

				cacheResult(punching);

				uncachedPrimaryKeys.remove(punching.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PunchingModelImpl.ENTITY_CACHE_ENABLED,
					PunchingImpl.class, primaryKey, nullModel);
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
	 * Returns all the punchings.
	 *
	 * @return the punchings
	 */
	@Override
	public List<Punching> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the punchings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of punchings
	 * @param end the upper bound of the range of punchings (not inclusive)
	 * @return the range of punchings
	 */
	@Override
	public List<Punching> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the punchings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of punchings
	 * @param end the upper bound of the range of punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of punchings
	 */
	@Override
	public List<Punching> findAll(int start, int end,
		OrderByComparator<Punching> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the punchings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of punchings
	 * @param end the upper bound of the range of punchings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of punchings
	 */
	@Override
	public List<Punching> findAll(int start, int end,
		OrderByComparator<Punching> orderByComparator, boolean retrieveFromCache) {
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

		List<Punching> list = null;

		if (retrieveFromCache) {
			list = (List<Punching>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PUNCHING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUNCHING;

				if (pagination) {
					sql = sql.concat(PunchingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Punching>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Punching>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the punchings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Punching punching : findAll()) {
			remove(punching);
		}
	}

	/**
	 * Returns the number of punchings.
	 *
	 * @return the number of punchings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PUNCHING);

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
		return PunchingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the punching persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PunchingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PUNCHING = "SELECT punching FROM Punching punching";
	private static final String _SQL_SELECT_PUNCHING_WHERE_PKS_IN = "SELECT punching FROM Punching punching WHERE CUSTOM_KEY IN (";
	private static final String _SQL_SELECT_PUNCHING_WHERE = "SELECT punching FROM Punching punching WHERE ";
	private static final String _SQL_COUNT_PUNCHING = "SELECT COUNT(punching) FROM Punching punching";
	private static final String _SQL_COUNT_PUNCHING_WHERE = "SELECT COUNT(punching) FROM Punching punching WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "punching.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Punching exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Punching exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PunchingPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"custom_key", "personId", "punchingId", "direction", "hours",
				"minute", "voucher", "terminal", "accountingDate",
				"punchingDate"
			});
}