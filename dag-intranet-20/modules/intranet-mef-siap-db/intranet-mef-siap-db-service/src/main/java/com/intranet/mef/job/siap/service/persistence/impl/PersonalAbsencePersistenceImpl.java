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

import com.intranet.mef.job.siap.exception.NoSuchPersonalAbsenceException;
import com.intranet.mef.job.siap.model.PersonalAbsence;
import com.intranet.mef.job.siap.model.impl.PersonalAbsenceImpl;
import com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl;
import com.intranet.mef.job.siap.service.persistence.PersonalAbsencePersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the personal absence service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsencePersistence
 * @see com.intranet.mef.job.siap.service.persistence.PersonalAbsenceUtil
 * @generated
 */
@ProviderType
public class PersonalAbsencePersistenceImpl extends BasePersistenceImpl<PersonalAbsence>
	implements PersonalAbsencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PersonalAbsenceUtil} to access the personal absence persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PersonalAbsenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceModelImpl.FINDER_CACHE_ENABLED,
			PersonalAbsenceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceModelImpl.FINDER_CACHE_ENABLED,
			PersonalAbsenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONIDANDREFMONTH =
		new FinderPath(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceModelImpl.FINDER_CACHE_ENABLED,
			PersonalAbsenceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersonIdAndRefMonth",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONIDANDREFMONTH =
		new FinderPath(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceModelImpl.FINDER_CACHE_ENABLED,
			PersonalAbsenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersonIdAndRefMonth",
			new String[] { Long.class.getName(), String.class.getName() },
			PersonalAbsenceModelImpl.PERSONID_COLUMN_BITMASK |
			PersonalAbsenceModelImpl.REFMONTH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSONIDANDREFMONTH = new FinderPath(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersonIdAndRefMonth",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the personal absences where personId = &#63; and refMonth = &#63;.
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @return the matching personal absences
	 */
	@Override
	public List<PersonalAbsence> findByPersonIdAndRefMonth(long personId,
		String refMonth) {
		return findByPersonIdAndRefMonth(personId, refMonth, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personal absences where personId = &#63; and refMonth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param start the lower bound of the range of personal absences
	 * @param end the upper bound of the range of personal absences (not inclusive)
	 * @return the range of matching personal absences
	 */
	@Override
	public List<PersonalAbsence> findByPersonIdAndRefMonth(long personId,
		String refMonth, int start, int end) {
		return findByPersonIdAndRefMonth(personId, refMonth, start, end, null);
	}

	/**
	 * Returns an ordered range of all the personal absences where personId = &#63; and refMonth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param start the lower bound of the range of personal absences
	 * @param end the upper bound of the range of personal absences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personal absences
	 */
	@Override
	public List<PersonalAbsence> findByPersonIdAndRefMonth(long personId,
		String refMonth, int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator) {
		return findByPersonIdAndRefMonth(personId, refMonth, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personal absences where personId = &#63; and refMonth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param start the lower bound of the range of personal absences
	 * @param end the upper bound of the range of personal absences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching personal absences
	 */
	@Override
	public List<PersonalAbsence> findByPersonIdAndRefMonth(long personId,
		String refMonth, int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONIDANDREFMONTH;
			finderArgs = new Object[] { personId, refMonth };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONIDANDREFMONTH;
			finderArgs = new Object[] {
					personId, refMonth,
					
					start, end, orderByComparator
				};
		}

		List<PersonalAbsence> list = null;

		if (retrieveFromCache) {
			list = (List<PersonalAbsence>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersonalAbsence personalAbsence : list) {
					if ((personId != personalAbsence.getPersonId()) ||
							!Objects.equals(refMonth,
								personalAbsence.getRefMonth())) {
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

			query.append(_SQL_SELECT_PERSONALABSENCE_WHERE);

			query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_PERSONID_2);

			boolean bindRefMonth = false;

			if (refMonth == null) {
				query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_1);
			}
			else if (refMonth.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_3);
			}
			else {
				bindRefMonth = true;

				query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PersonalAbsenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personId);

				if (bindRefMonth) {
					qPos.add(refMonth);
				}

				if (!pagination) {
					list = (List<PersonalAbsence>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersonalAbsence>)QueryUtil.list(q,
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
	 * Returns the first personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal absence
	 * @throws NoSuchPersonalAbsenceException if a matching personal absence could not be found
	 */
	@Override
	public PersonalAbsence findByPersonIdAndRefMonth_First(long personId,
		String refMonth, OrderByComparator<PersonalAbsence> orderByComparator)
		throws NoSuchPersonalAbsenceException {
		PersonalAbsence personalAbsence = fetchByPersonIdAndRefMonth_First(personId,
				refMonth, orderByComparator);

		if (personalAbsence != null) {
			return personalAbsence;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personId=");
		msg.append(personId);

		msg.append(", refMonth=");
		msg.append(refMonth);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonalAbsenceException(msg.toString());
	}

	/**
	 * Returns the first personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal absence, or <code>null</code> if a matching personal absence could not be found
	 */
	@Override
	public PersonalAbsence fetchByPersonIdAndRefMonth_First(long personId,
		String refMonth, OrderByComparator<PersonalAbsence> orderByComparator) {
		List<PersonalAbsence> list = findByPersonIdAndRefMonth(personId,
				refMonth, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal absence
	 * @throws NoSuchPersonalAbsenceException if a matching personal absence could not be found
	 */
	@Override
	public PersonalAbsence findByPersonIdAndRefMonth_Last(long personId,
		String refMonth, OrderByComparator<PersonalAbsence> orderByComparator)
		throws NoSuchPersonalAbsenceException {
		PersonalAbsence personalAbsence = fetchByPersonIdAndRefMonth_Last(personId,
				refMonth, orderByComparator);

		if (personalAbsence != null) {
			return personalAbsence;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personId=");
		msg.append(personId);

		msg.append(", refMonth=");
		msg.append(refMonth);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonalAbsenceException(msg.toString());
	}

	/**
	 * Returns the last personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal absence, or <code>null</code> if a matching personal absence could not be found
	 */
	@Override
	public PersonalAbsence fetchByPersonIdAndRefMonth_Last(long personId,
		String refMonth, OrderByComparator<PersonalAbsence> orderByComparator) {
		int count = countByPersonIdAndRefMonth(personId, refMonth);

		if (count == 0) {
			return null;
		}

		List<PersonalAbsence> list = findByPersonIdAndRefMonth(personId,
				refMonth, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the personal absences before and after the current personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	 *
	 * @param custom_key the primary key of the current personal absence
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next personal absence
	 * @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	 */
	@Override
	public PersonalAbsence[] findByPersonIdAndRefMonth_PrevAndNext(
		String custom_key, long personId, String refMonth,
		OrderByComparator<PersonalAbsence> orderByComparator)
		throws NoSuchPersonalAbsenceException {
		PersonalAbsence personalAbsence = findByPrimaryKey(custom_key);

		Session session = null;

		try {
			session = openSession();

			PersonalAbsence[] array = new PersonalAbsenceImpl[3];

			array[0] = getByPersonIdAndRefMonth_PrevAndNext(session,
					personalAbsence, personId, refMonth, orderByComparator, true);

			array[1] = personalAbsence;

			array[2] = getByPersonIdAndRefMonth_PrevAndNext(session,
					personalAbsence, personId, refMonth, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersonalAbsence getByPersonIdAndRefMonth_PrevAndNext(
		Session session, PersonalAbsence personalAbsence, long personId,
		String refMonth, OrderByComparator<PersonalAbsence> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PERSONALABSENCE_WHERE);

		query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_PERSONID_2);

		boolean bindRefMonth = false;

		if (refMonth == null) {
			query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_1);
		}
		else if (refMonth.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_3);
		}
		else {
			bindRefMonth = true;

			query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_2);
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
			query.append(PersonalAbsenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(personId);

		if (bindRefMonth) {
			qPos.add(refMonth);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(personalAbsence);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PersonalAbsence> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personal absences where personId = &#63; and refMonth = &#63; from the database.
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 */
	@Override
	public void removeByPersonIdAndRefMonth(long personId, String refMonth) {
		for (PersonalAbsence personalAbsence : findByPersonIdAndRefMonth(
				personId, refMonth, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(personalAbsence);
		}
	}

	/**
	 * Returns the number of personal absences where personId = &#63; and refMonth = &#63;.
	 *
	 * @param personId the person ID
	 * @param refMonth the ref month
	 * @return the number of matching personal absences
	 */
	@Override
	public int countByPersonIdAndRefMonth(long personId, String refMonth) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSONIDANDREFMONTH;

		Object[] finderArgs = new Object[] { personId, refMonth };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSONALABSENCE_WHERE);

			query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_PERSONID_2);

			boolean bindRefMonth = false;

			if (refMonth == null) {
				query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_1);
			}
			else if (refMonth.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_3);
			}
			else {
				bindRefMonth = true;

				query.append(_FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personId);

				if (bindRefMonth) {
					qPos.add(refMonth);
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

	private static final String _FINDER_COLUMN_PERSONIDANDREFMONTH_PERSONID_2 = "personalAbsence.personId = ? AND ";
	private static final String _FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_1 = "personalAbsence.refMonth IS NULL";
	private static final String _FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_2 = "personalAbsence.refMonth = ?";
	private static final String _FINDER_COLUMN_PERSONIDANDREFMONTH_REFMONTH_3 = "(personalAbsence.refMonth IS NULL OR personalAbsence.refMonth = '')";

	public PersonalAbsencePersistenceImpl() {
		setModelClass(PersonalAbsence.class);
	}

	/**
	 * Caches the personal absence in the entity cache if it is enabled.
	 *
	 * @param personalAbsence the personal absence
	 */
	@Override
	public void cacheResult(PersonalAbsence personalAbsence) {
		entityCache.putResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceImpl.class, personalAbsence.getPrimaryKey(),
			personalAbsence);

		personalAbsence.resetOriginalValues();
	}

	/**
	 * Caches the personal absences in the entity cache if it is enabled.
	 *
	 * @param personalAbsences the personal absences
	 */
	@Override
	public void cacheResult(List<PersonalAbsence> personalAbsences) {
		for (PersonalAbsence personalAbsence : personalAbsences) {
			if (entityCache.getResult(
						PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
						PersonalAbsenceImpl.class,
						personalAbsence.getPrimaryKey()) == null) {
				cacheResult(personalAbsence);
			}
			else {
				personalAbsence.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all personal absences.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersonalAbsenceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the personal absence.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersonalAbsence personalAbsence) {
		entityCache.removeResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceImpl.class, personalAbsence.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PersonalAbsence> personalAbsences) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersonalAbsence personalAbsence : personalAbsences) {
			entityCache.removeResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
				PersonalAbsenceImpl.class, personalAbsence.getPrimaryKey());
		}
	}

	/**
	 * Creates a new personal absence with the primary key. Does not add the personal absence to the database.
	 *
	 * @param custom_key the primary key for the new personal absence
	 * @return the new personal absence
	 */
	@Override
	public PersonalAbsence create(String custom_key) {
		PersonalAbsence personalAbsence = new PersonalAbsenceImpl();

		personalAbsence.setNew(true);
		personalAbsence.setPrimaryKey(custom_key);

		return personalAbsence;
	}

	/**
	 * Removes the personal absence with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param custom_key the primary key of the personal absence
	 * @return the personal absence that was removed
	 * @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	 */
	@Override
	public PersonalAbsence remove(String custom_key)
		throws NoSuchPersonalAbsenceException {
		return remove((Serializable)custom_key);
	}

	/**
	 * Removes the personal absence with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the personal absence
	 * @return the personal absence that was removed
	 * @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	 */
	@Override
	public PersonalAbsence remove(Serializable primaryKey)
		throws NoSuchPersonalAbsenceException {
		Session session = null;

		try {
			session = openSession();

			PersonalAbsence personalAbsence = (PersonalAbsence)session.get(PersonalAbsenceImpl.class,
					primaryKey);

			if (personalAbsence == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonalAbsenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(personalAbsence);
		}
		catch (NoSuchPersonalAbsenceException nsee) {
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
	protected PersonalAbsence removeImpl(PersonalAbsence personalAbsence) {
		personalAbsence = toUnwrappedModel(personalAbsence);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(personalAbsence)) {
				personalAbsence = (PersonalAbsence)session.get(PersonalAbsenceImpl.class,
						personalAbsence.getPrimaryKeyObj());
			}

			if (personalAbsence != null) {
				session.delete(personalAbsence);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (personalAbsence != null) {
			clearCache(personalAbsence);
		}

		return personalAbsence;
	}

	@Override
	public PersonalAbsence updateImpl(PersonalAbsence personalAbsence) {
		personalAbsence = toUnwrappedModel(personalAbsence);

		boolean isNew = personalAbsence.isNew();

		PersonalAbsenceModelImpl personalAbsenceModelImpl = (PersonalAbsenceModelImpl)personalAbsence;

		Session session = null;

		try {
			session = openSession();

			if (personalAbsence.isNew()) {
				session.save(personalAbsence);

				personalAbsence.setNew(false);
			}
			else {
				personalAbsence = (PersonalAbsence)session.merge(personalAbsence);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PersonalAbsenceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((personalAbsenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONIDANDREFMONTH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						personalAbsenceModelImpl.getOriginalPersonId(),
						personalAbsenceModelImpl.getOriginalRefMonth()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONIDANDREFMONTH,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONIDANDREFMONTH,
					args);

				args = new Object[] {
						personalAbsenceModelImpl.getPersonId(),
						personalAbsenceModelImpl.getRefMonth()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONIDANDREFMONTH,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONIDANDREFMONTH,
					args);
			}
		}

		entityCache.putResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
			PersonalAbsenceImpl.class, personalAbsence.getPrimaryKey(),
			personalAbsence, false);

		personalAbsence.resetOriginalValues();

		return personalAbsence;
	}

	protected PersonalAbsence toUnwrappedModel(PersonalAbsence personalAbsence) {
		if (personalAbsence instanceof PersonalAbsenceImpl) {
			return personalAbsence;
		}

		PersonalAbsenceImpl personalAbsenceImpl = new PersonalAbsenceImpl();

		personalAbsenceImpl.setNew(personalAbsence.isNew());
		personalAbsenceImpl.setPrimaryKey(personalAbsence.getPrimaryKey());

		personalAbsenceImpl.setCustom_key(personalAbsence.getCustom_key());
		personalAbsenceImpl.setPersonId(personalAbsence.getPersonId());
		personalAbsenceImpl.setAbsenceDate(personalAbsence.getAbsenceDate());
		personalAbsenceImpl.setRefMonth(personalAbsence.getRefMonth());
		personalAbsenceImpl.setAbsenceCode(personalAbsence.getAbsenceCode());
		personalAbsenceImpl.setCompleteDay(personalAbsence.getCompleteDay());
		personalAbsenceImpl.setFrom(personalAbsence.getFrom());
		personalAbsenceImpl.setTo(personalAbsence.getTo());
		personalAbsenceImpl.setHours(personalAbsence.getHours());
		personalAbsenceImpl.setDescription(personalAbsence.getDescription());

		return personalAbsenceImpl;
	}

	/**
	 * Returns the personal absence with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the personal absence
	 * @return the personal absence
	 * @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	 */
	@Override
	public PersonalAbsence findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonalAbsenceException {
		PersonalAbsence personalAbsence = fetchByPrimaryKey(primaryKey);

		if (personalAbsence == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonalAbsenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return personalAbsence;
	}

	/**
	 * Returns the personal absence with the primary key or throws a {@link NoSuchPersonalAbsenceException} if it could not be found.
	 *
	 * @param custom_key the primary key of the personal absence
	 * @return the personal absence
	 * @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	 */
	@Override
	public PersonalAbsence findByPrimaryKey(String custom_key)
		throws NoSuchPersonalAbsenceException {
		return findByPrimaryKey((Serializable)custom_key);
	}

	/**
	 * Returns the personal absence with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the personal absence
	 * @return the personal absence, or <code>null</code> if a personal absence with the primary key could not be found
	 */
	@Override
	public PersonalAbsence fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
				PersonalAbsenceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PersonalAbsence personalAbsence = (PersonalAbsence)serializable;

		if (personalAbsence == null) {
			Session session = null;

			try {
				session = openSession();

				personalAbsence = (PersonalAbsence)session.get(PersonalAbsenceImpl.class,
						primaryKey);

				if (personalAbsence != null) {
					cacheResult(personalAbsence);
				}
				else {
					entityCache.putResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
						PersonalAbsenceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
					PersonalAbsenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return personalAbsence;
	}

	/**
	 * Returns the personal absence with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param custom_key the primary key of the personal absence
	 * @return the personal absence, or <code>null</code> if a personal absence with the primary key could not be found
	 */
	@Override
	public PersonalAbsence fetchByPrimaryKey(String custom_key) {
		return fetchByPrimaryKey((Serializable)custom_key);
	}

	@Override
	public Map<Serializable, PersonalAbsence> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PersonalAbsence> map = new HashMap<Serializable, PersonalAbsence>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PersonalAbsence personalAbsence = fetchByPrimaryKey(primaryKey);

			if (personalAbsence != null) {
				map.put(primaryKey, personalAbsence);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
					PersonalAbsenceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PersonalAbsence)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_PERSONALABSENCE_WHERE_PKS_IN);

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

			for (PersonalAbsence personalAbsence : (List<PersonalAbsence>)q.list()) {
				map.put(personalAbsence.getPrimaryKeyObj(), personalAbsence);

				cacheResult(personalAbsence);

				uncachedPrimaryKeys.remove(personalAbsence.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PersonalAbsenceModelImpl.ENTITY_CACHE_ENABLED,
					PersonalAbsenceImpl.class, primaryKey, nullModel);
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
	 * Returns all the personal absences.
	 *
	 * @return the personal absences
	 */
	@Override
	public List<PersonalAbsence> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personal absences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal absences
	 * @param end the upper bound of the range of personal absences (not inclusive)
	 * @return the range of personal absences
	 */
	@Override
	public List<PersonalAbsence> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the personal absences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal absences
	 * @param end the upper bound of the range of personal absences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal absences
	 */
	@Override
	public List<PersonalAbsence> findAll(int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personal absences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal absences
	 * @param end the upper bound of the range of personal absences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of personal absences
	 */
	@Override
	public List<PersonalAbsence> findAll(int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator,
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

		List<PersonalAbsence> list = null;

		if (retrieveFromCache) {
			list = (List<PersonalAbsence>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERSONALABSENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONALABSENCE;

				if (pagination) {
					sql = sql.concat(PersonalAbsenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PersonalAbsence>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersonalAbsence>)QueryUtil.list(q,
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
	 * Removes all the personal absences from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersonalAbsence personalAbsence : findAll()) {
			remove(personalAbsence);
		}
	}

	/**
	 * Returns the number of personal absences.
	 *
	 * @return the number of personal absences
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERSONALABSENCE);

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
		return PersonalAbsenceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the personal absence persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PersonalAbsenceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PERSONALABSENCE = "SELECT personalAbsence FROM PersonalAbsence personalAbsence";
	private static final String _SQL_SELECT_PERSONALABSENCE_WHERE_PKS_IN = "SELECT personalAbsence FROM PersonalAbsence personalAbsence WHERE CUSTOM_KEY IN (";
	private static final String _SQL_SELECT_PERSONALABSENCE_WHERE = "SELECT personalAbsence FROM PersonalAbsence personalAbsence WHERE ";
	private static final String _SQL_COUNT_PERSONALABSENCE = "SELECT COUNT(personalAbsence) FROM PersonalAbsence personalAbsence";
	private static final String _SQL_COUNT_PERSONALABSENCE_WHERE = "SELECT COUNT(personalAbsence) FROM PersonalAbsence personalAbsence WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "personalAbsence.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PersonalAbsence exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PersonalAbsence exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PersonalAbsencePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"custom_key", "personId", "absenceDate", "refMonth",
				"absenceCode", "completeDay", "from", "to", "hours",
				"description"
			});
}