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

import com.intranet.mef.job.siap.exception.NoSuchMealTicketException;
import com.intranet.mef.job.siap.model.MealTicket;
import com.intranet.mef.job.siap.model.impl.MealTicketImpl;
import com.intranet.mef.job.siap.model.impl.MealTicketModelImpl;
import com.intranet.mef.job.siap.service.persistence.MealTicketPersistence;

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
 * The persistence implementation for the meal ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MealTicketPersistence
 * @see com.intranet.mef.job.siap.service.persistence.MealTicketUtil
 * @generated
 */
@ProviderType
public class MealTicketPersistenceImpl extends BasePersistenceImpl<MealTicket>
	implements MealTicketPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MealTicketUtil} to access the meal ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MealTicketImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketModelImpl.FINDER_CACHE_ENABLED, MealTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketModelImpl.FINDER_CACHE_ENABLED, MealTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID = new FinderPath(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketModelImpl.FINDER_CACHE_ENABLED, MealTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersonId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID =
		new FinderPath(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketModelImpl.FINDER_CACHE_ENABLED, MealTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPersonId",
			new String[] { Long.class.getName() },
			MealTicketModelImpl.PERSONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSONID = new FinderPath(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the meal tickets where personID = &#63;.
	 *
	 * @param personID the person i d
	 * @return the matching meal tickets
	 */
	@Override
	public List<MealTicket> findByPersonId(long personID) {
		return findByPersonId(personID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the meal tickets where personID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personID the person i d
	 * @param start the lower bound of the range of meal tickets
	 * @param end the upper bound of the range of meal tickets (not inclusive)
	 * @return the range of matching meal tickets
	 */
	@Override
	public List<MealTicket> findByPersonId(long personID, int start, int end) {
		return findByPersonId(personID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the meal tickets where personID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personID the person i d
	 * @param start the lower bound of the range of meal tickets
	 * @param end the upper bound of the range of meal tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meal tickets
	 */
	@Override
	public List<MealTicket> findByPersonId(long personID, int start, int end,
		OrderByComparator<MealTicket> orderByComparator) {
		return findByPersonId(personID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the meal tickets where personID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personID the person i d
	 * @param start the lower bound of the range of meal tickets
	 * @param end the upper bound of the range of meal tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meal tickets
	 */
	@Override
	public List<MealTicket> findByPersonId(long personID, int start, int end,
		OrderByComparator<MealTicket> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { personID, start, end, orderByComparator };
		}

		List<MealTicket> list = null;

		if (retrieveFromCache) {
			list = (List<MealTicket>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MealTicket mealTicket : list) {
					if ((personID != mealTicket.getPersonID())) {
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

			query.append(_SQL_SELECT_MEALTICKET_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MealTicketModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personID);

				if (!pagination) {
					list = (List<MealTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MealTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first meal ticket in the ordered set where personID = &#63;.
	 *
	 * @param personID the person i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meal ticket
	 * @throws NoSuchMealTicketException if a matching meal ticket could not be found
	 */
	@Override
	public MealTicket findByPersonId_First(long personID,
		OrderByComparator<MealTicket> orderByComparator)
		throws NoSuchMealTicketException {
		MealTicket mealTicket = fetchByPersonId_First(personID,
				orderByComparator);

		if (mealTicket != null) {
			return mealTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personID=");
		msg.append(personID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMealTicketException(msg.toString());
	}

	/**
	 * Returns the first meal ticket in the ordered set where personID = &#63;.
	 *
	 * @param personID the person i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meal ticket, or <code>null</code> if a matching meal ticket could not be found
	 */
	@Override
	public MealTicket fetchByPersonId_First(long personID,
		OrderByComparator<MealTicket> orderByComparator) {
		List<MealTicket> list = findByPersonId(personID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last meal ticket in the ordered set where personID = &#63;.
	 *
	 * @param personID the person i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meal ticket
	 * @throws NoSuchMealTicketException if a matching meal ticket could not be found
	 */
	@Override
	public MealTicket findByPersonId_Last(long personID,
		OrderByComparator<MealTicket> orderByComparator)
		throws NoSuchMealTicketException {
		MealTicket mealTicket = fetchByPersonId_Last(personID, orderByComparator);

		if (mealTicket != null) {
			return mealTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personID=");
		msg.append(personID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMealTicketException(msg.toString());
	}

	/**
	 * Returns the last meal ticket in the ordered set where personID = &#63;.
	 *
	 * @param personID the person i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meal ticket, or <code>null</code> if a matching meal ticket could not be found
	 */
	@Override
	public MealTicket fetchByPersonId_Last(long personID,
		OrderByComparator<MealTicket> orderByComparator) {
		int count = countByPersonId(personID);

		if (count == 0) {
			return null;
		}

		List<MealTicket> list = findByPersonId(personID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the meal tickets before and after the current meal ticket in the ordered set where personID = &#63;.
	 *
	 * @param custom_key the primary key of the current meal ticket
	 * @param personID the person i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meal ticket
	 * @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	 */
	@Override
	public MealTicket[] findByPersonId_PrevAndNext(String custom_key,
		long personID, OrderByComparator<MealTicket> orderByComparator)
		throws NoSuchMealTicketException {
		MealTicket mealTicket = findByPrimaryKey(custom_key);

		Session session = null;

		try {
			session = openSession();

			MealTicket[] array = new MealTicketImpl[3];

			array[0] = getByPersonId_PrevAndNext(session, mealTicket, personID,
					orderByComparator, true);

			array[1] = mealTicket;

			array[2] = getByPersonId_PrevAndNext(session, mealTicket, personID,
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

	protected MealTicket getByPersonId_PrevAndNext(Session session,
		MealTicket mealTicket, long personID,
		OrderByComparator<MealTicket> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEALTICKET_WHERE);

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
			query.append(MealTicketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(personID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(mealTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MealTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the meal tickets where personID = &#63; from the database.
	 *
	 * @param personID the person i d
	 */
	@Override
	public void removeByPersonId(long personID) {
		for (MealTicket mealTicket : findByPersonId(personID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(mealTicket);
		}
	}

	/**
	 * Returns the number of meal tickets where personID = &#63;.
	 *
	 * @param personID the person i d
	 * @return the number of matching meal tickets
	 */
	@Override
	public int countByPersonId(long personID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSONID;

		Object[] finderArgs = new Object[] { personID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEALTICKET_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personID);

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

	private static final String _FINDER_COLUMN_PERSONID_PERSONID_2 = "mealTicket.personID = ?";

	public MealTicketPersistenceImpl() {
		setModelClass(MealTicket.class);
	}

	/**
	 * Caches the meal ticket in the entity cache if it is enabled.
	 *
	 * @param mealTicket the meal ticket
	 */
	@Override
	public void cacheResult(MealTicket mealTicket) {
		entityCache.putResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketImpl.class, mealTicket.getPrimaryKey(), mealTicket);

		mealTicket.resetOriginalValues();
	}

	/**
	 * Caches the meal tickets in the entity cache if it is enabled.
	 *
	 * @param mealTickets the meal tickets
	 */
	@Override
	public void cacheResult(List<MealTicket> mealTickets) {
		for (MealTicket mealTicket : mealTickets) {
			if (entityCache.getResult(
						MealTicketModelImpl.ENTITY_CACHE_ENABLED,
						MealTicketImpl.class, mealTicket.getPrimaryKey()) == null) {
				cacheResult(mealTicket);
			}
			else {
				mealTicket.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all meal tickets.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MealTicketImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the meal ticket.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MealTicket mealTicket) {
		entityCache.removeResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketImpl.class, mealTicket.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MealTicket> mealTickets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MealTicket mealTicket : mealTickets) {
			entityCache.removeResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
				MealTicketImpl.class, mealTicket.getPrimaryKey());
		}
	}

	/**
	 * Creates a new meal ticket with the primary key. Does not add the meal ticket to the database.
	 *
	 * @param custom_key the primary key for the new meal ticket
	 * @return the new meal ticket
	 */
	@Override
	public MealTicket create(String custom_key) {
		MealTicket mealTicket = new MealTicketImpl();

		mealTicket.setNew(true);
		mealTicket.setPrimaryKey(custom_key);

		return mealTicket;
	}

	/**
	 * Removes the meal ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param custom_key the primary key of the meal ticket
	 * @return the meal ticket that was removed
	 * @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	 */
	@Override
	public MealTicket remove(String custom_key)
		throws NoSuchMealTicketException {
		return remove((Serializable)custom_key);
	}

	/**
	 * Removes the meal ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the meal ticket
	 * @return the meal ticket that was removed
	 * @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	 */
	@Override
	public MealTicket remove(Serializable primaryKey)
		throws NoSuchMealTicketException {
		Session session = null;

		try {
			session = openSession();

			MealTicket mealTicket = (MealTicket)session.get(MealTicketImpl.class,
					primaryKey);

			if (mealTicket == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMealTicketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(mealTicket);
		}
		catch (NoSuchMealTicketException nsee) {
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
	protected MealTicket removeImpl(MealTicket mealTicket) {
		mealTicket = toUnwrappedModel(mealTicket);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mealTicket)) {
				mealTicket = (MealTicket)session.get(MealTicketImpl.class,
						mealTicket.getPrimaryKeyObj());
			}

			if (mealTicket != null) {
				session.delete(mealTicket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (mealTicket != null) {
			clearCache(mealTicket);
		}

		return mealTicket;
	}

	@Override
	public MealTicket updateImpl(MealTicket mealTicket) {
		mealTicket = toUnwrappedModel(mealTicket);

		boolean isNew = mealTicket.isNew();

		MealTicketModelImpl mealTicketModelImpl = (MealTicketModelImpl)mealTicket;

		Session session = null;

		try {
			session = openSession();

			if (mealTicket.isNew()) {
				session.save(mealTicket);

				mealTicket.setNew(false);
			}
			else {
				mealTicket = (MealTicket)session.merge(mealTicket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MealTicketModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((mealTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						mealTicketModelImpl.getOriginalPersonID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);

				args = new Object[] { mealTicketModelImpl.getPersonID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);
			}
		}

		entityCache.putResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
			MealTicketImpl.class, mealTicket.getPrimaryKey(), mealTicket, false);

		mealTicket.resetOriginalValues();

		return mealTicket;
	}

	protected MealTicket toUnwrappedModel(MealTicket mealTicket) {
		if (mealTicket instanceof MealTicketImpl) {
			return mealTicket;
		}

		MealTicketImpl mealTicketImpl = new MealTicketImpl();

		mealTicketImpl.setNew(mealTicket.isNew());
		mealTicketImpl.setPrimaryKey(mealTicket.getPrimaryKey());

		mealTicketImpl.setCustom_key(mealTicket.getCustom_key());
		mealTicketImpl.setPersonID(mealTicket.getPersonID());
		mealTicketImpl.setMonth(mealTicket.getMonth());
		mealTicketImpl.setDueMeal(mealTicket.getDueMeal());

		return mealTicketImpl;
	}

	/**
	 * Returns the meal ticket with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the meal ticket
	 * @return the meal ticket
	 * @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	 */
	@Override
	public MealTicket findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMealTicketException {
		MealTicket mealTicket = fetchByPrimaryKey(primaryKey);

		if (mealTicket == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMealTicketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return mealTicket;
	}

	/**
	 * Returns the meal ticket with the primary key or throws a {@link NoSuchMealTicketException} if it could not be found.
	 *
	 * @param custom_key the primary key of the meal ticket
	 * @return the meal ticket
	 * @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	 */
	@Override
	public MealTicket findByPrimaryKey(String custom_key)
		throws NoSuchMealTicketException {
		return findByPrimaryKey((Serializable)custom_key);
	}

	/**
	 * Returns the meal ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the meal ticket
	 * @return the meal ticket, or <code>null</code> if a meal ticket with the primary key could not be found
	 */
	@Override
	public MealTicket fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
				MealTicketImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MealTicket mealTicket = (MealTicket)serializable;

		if (mealTicket == null) {
			Session session = null;

			try {
				session = openSession();

				mealTicket = (MealTicket)session.get(MealTicketImpl.class,
						primaryKey);

				if (mealTicket != null) {
					cacheResult(mealTicket);
				}
				else {
					entityCache.putResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
						MealTicketImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
					MealTicketImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return mealTicket;
	}

	/**
	 * Returns the meal ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param custom_key the primary key of the meal ticket
	 * @return the meal ticket, or <code>null</code> if a meal ticket with the primary key could not be found
	 */
	@Override
	public MealTicket fetchByPrimaryKey(String custom_key) {
		return fetchByPrimaryKey((Serializable)custom_key);
	}

	@Override
	public Map<Serializable, MealTicket> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MealTicket> map = new HashMap<Serializable, MealTicket>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MealTicket mealTicket = fetchByPrimaryKey(primaryKey);

			if (mealTicket != null) {
				map.put(primaryKey, mealTicket);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
					MealTicketImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MealTicket)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_MEALTICKET_WHERE_PKS_IN);

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

			for (MealTicket mealTicket : (List<MealTicket>)q.list()) {
				map.put(mealTicket.getPrimaryKeyObj(), mealTicket);

				cacheResult(mealTicket);

				uncachedPrimaryKeys.remove(mealTicket.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MealTicketModelImpl.ENTITY_CACHE_ENABLED,
					MealTicketImpl.class, primaryKey, nullModel);
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
	 * Returns all the meal tickets.
	 *
	 * @return the meal tickets
	 */
	@Override
	public List<MealTicket> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the meal tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meal tickets
	 * @param end the upper bound of the range of meal tickets (not inclusive)
	 * @return the range of meal tickets
	 */
	@Override
	public List<MealTicket> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the meal tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meal tickets
	 * @param end the upper bound of the range of meal tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of meal tickets
	 */
	@Override
	public List<MealTicket> findAll(int start, int end,
		OrderByComparator<MealTicket> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the meal tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meal tickets
	 * @param end the upper bound of the range of meal tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of meal tickets
	 */
	@Override
	public List<MealTicket> findAll(int start, int end,
		OrderByComparator<MealTicket> orderByComparator,
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

		List<MealTicket> list = null;

		if (retrieveFromCache) {
			list = (List<MealTicket>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MEALTICKET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEALTICKET;

				if (pagination) {
					sql = sql.concat(MealTicketModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MealTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MealTicket>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the meal tickets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MealTicket mealTicket : findAll()) {
			remove(mealTicket);
		}
	}

	/**
	 * Returns the number of meal tickets.
	 *
	 * @return the number of meal tickets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MEALTICKET);

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
		return MealTicketModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the meal ticket persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MealTicketImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MEALTICKET = "SELECT mealTicket FROM MealTicket mealTicket";
	private static final String _SQL_SELECT_MEALTICKET_WHERE_PKS_IN = "SELECT mealTicket FROM MealTicket mealTicket WHERE CUSTOM_KEY IN (";
	private static final String _SQL_SELECT_MEALTICKET_WHERE = "SELECT mealTicket FROM MealTicket mealTicket WHERE ";
	private static final String _SQL_COUNT_MEALTICKET = "SELECT COUNT(mealTicket) FROM MealTicket mealTicket";
	private static final String _SQL_COUNT_MEALTICKET_WHERE = "SELECT COUNT(mealTicket) FROM MealTicket mealTicket WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mealTicket.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MealTicket exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MealTicket exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MealTicketPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"custom_key", "personID", "month", "dueMeal"
			});
}