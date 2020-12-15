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

import com.intranet.mef.assistance.exception.NoSuchProblemException;
import com.intranet.mef.assistance.model.Problem;
import com.intranet.mef.assistance.model.impl.ProblemImpl;
import com.intranet.mef.assistance.model.impl.ProblemModelImpl;
import com.intranet.mef.assistance.service.persistence.ProblemPersistence;

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
 * The persistence implementation for the problem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProblemPersistence
 * @see com.intranet.mef.assistance.service.persistence.ProblemUtil
 * @generated
 */
@ProviderType
public class ProblemPersistenceImpl extends BasePersistenceImpl<Problem>
	implements ProblemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProblemUtil} to access the problem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProblemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, ProblemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, ProblemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, ProblemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, ProblemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProblemModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the problems where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching problems
	 */
	@Override
	public List<Problem> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the problems where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @return the range of matching problems
	 */
	@Override
	public List<Problem> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the problems where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching problems
	 */
	@Override
	public List<Problem> findByUuid(String uuid, int start, int end,
		OrderByComparator<Problem> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the problems where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching problems
	 */
	@Override
	public List<Problem> findByUuid(String uuid, int start, int end,
		OrderByComparator<Problem> orderByComparator, boolean retrieveFromCache) {
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

		List<Problem> list = null;

		if (retrieveFromCache) {
			list = (List<Problem>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Problem problem : list) {
					if (!Objects.equals(uuid, problem.getUuid())) {
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

			query.append(_SQL_SELECT_PROBLEM_WHERE);

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
				query.append(ProblemModelImpl.ORDER_BY_JPQL);
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
					list = (List<Problem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Problem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first problem in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching problem
	 * @throws NoSuchProblemException if a matching problem could not be found
	 */
	@Override
	public Problem findByUuid_First(String uuid,
		OrderByComparator<Problem> orderByComparator)
		throws NoSuchProblemException {
		Problem problem = fetchByUuid_First(uuid, orderByComparator);

		if (problem != null) {
			return problem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProblemException(msg.toString());
	}

	/**
	 * Returns the first problem in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching problem, or <code>null</code> if a matching problem could not be found
	 */
	@Override
	public Problem fetchByUuid_First(String uuid,
		OrderByComparator<Problem> orderByComparator) {
		List<Problem> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last problem in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching problem
	 * @throws NoSuchProblemException if a matching problem could not be found
	 */
	@Override
	public Problem findByUuid_Last(String uuid,
		OrderByComparator<Problem> orderByComparator)
		throws NoSuchProblemException {
		Problem problem = fetchByUuid_Last(uuid, orderByComparator);

		if (problem != null) {
			return problem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProblemException(msg.toString());
	}

	/**
	 * Returns the last problem in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching problem, or <code>null</code> if a matching problem could not be found
	 */
	@Override
	public Problem fetchByUuid_Last(String uuid,
		OrderByComparator<Problem> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Problem> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the problems before and after the current problem in the ordered set where uuid = &#63;.
	 *
	 * @param problemId the primary key of the current problem
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next problem
	 * @throws NoSuchProblemException if a problem with the primary key could not be found
	 */
	@Override
	public Problem[] findByUuid_PrevAndNext(String problemId, String uuid,
		OrderByComparator<Problem> orderByComparator)
		throws NoSuchProblemException {
		Problem problem = findByPrimaryKey(problemId);

		Session session = null;

		try {
			session = openSession();

			Problem[] array = new ProblemImpl[3];

			array[0] = getByUuid_PrevAndNext(session, problem, uuid,
					orderByComparator, true);

			array[1] = problem;

			array[2] = getByUuid_PrevAndNext(session, problem, uuid,
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

	protected Problem getByUuid_PrevAndNext(Session session, Problem problem,
		String uuid, OrderByComparator<Problem> orderByComparator,
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

		query.append(_SQL_SELECT_PROBLEM_WHERE);

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
			query.append(ProblemModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(problem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Problem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the problems where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Problem problem : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(problem);
		}
	}

	/**
	 * Returns the number of problems where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching problems
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROBLEM_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "problem.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "problem.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(problem.uuid IS NULL OR problem.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICSID = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, ProblemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTopicsId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICSID =
		new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, ProblemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTopicsId",
			new String[] { String.class.getName() },
			ProblemModelImpl.TOPICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOPICSID = new FinderPath(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTopicsId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the problems where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @return the matching problems
	 */
	@Override
	public List<Problem> findByTopicsId(String topicId) {
		return findByTopicsId(topicId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the problems where topicId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param topicId the topic ID
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @return the range of matching problems
	 */
	@Override
	public List<Problem> findByTopicsId(String topicId, int start, int end) {
		return findByTopicsId(topicId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the problems where topicId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param topicId the topic ID
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching problems
	 */
	@Override
	public List<Problem> findByTopicsId(String topicId, int start, int end,
		OrderByComparator<Problem> orderByComparator) {
		return findByTopicsId(topicId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the problems where topicId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param topicId the topic ID
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching problems
	 */
	@Override
	public List<Problem> findByTopicsId(String topicId, int start, int end,
		OrderByComparator<Problem> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICSID;
			finderArgs = new Object[] { topicId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICSID;
			finderArgs = new Object[] { topicId, start, end, orderByComparator };
		}

		List<Problem> list = null;

		if (retrieveFromCache) {
			list = (List<Problem>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Problem problem : list) {
					if (!Objects.equals(topicId, problem.getTopicId())) {
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

			query.append(_SQL_SELECT_PROBLEM_WHERE);

			boolean bindTopicId = false;

			if (topicId == null) {
				query.append(_FINDER_COLUMN_TOPICSID_TOPICID_1);
			}
			else if (topicId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TOPICSID_TOPICID_3);
			}
			else {
				bindTopicId = true;

				query.append(_FINDER_COLUMN_TOPICSID_TOPICID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProblemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTopicId) {
					qPos.add(topicId);
				}

				if (!pagination) {
					list = (List<Problem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Problem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first problem in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching problem
	 * @throws NoSuchProblemException if a matching problem could not be found
	 */
	@Override
	public Problem findByTopicsId_First(String topicId,
		OrderByComparator<Problem> orderByComparator)
		throws NoSuchProblemException {
		Problem problem = fetchByTopicsId_First(topicId, orderByComparator);

		if (problem != null) {
			return problem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProblemException(msg.toString());
	}

	/**
	 * Returns the first problem in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching problem, or <code>null</code> if a matching problem could not be found
	 */
	@Override
	public Problem fetchByTopicsId_First(String topicId,
		OrderByComparator<Problem> orderByComparator) {
		List<Problem> list = findByTopicsId(topicId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last problem in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching problem
	 * @throws NoSuchProblemException if a matching problem could not be found
	 */
	@Override
	public Problem findByTopicsId_Last(String topicId,
		OrderByComparator<Problem> orderByComparator)
		throws NoSuchProblemException {
		Problem problem = fetchByTopicsId_Last(topicId, orderByComparator);

		if (problem != null) {
			return problem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProblemException(msg.toString());
	}

	/**
	 * Returns the last problem in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching problem, or <code>null</code> if a matching problem could not be found
	 */
	@Override
	public Problem fetchByTopicsId_Last(String topicId,
		OrderByComparator<Problem> orderByComparator) {
		int count = countByTopicsId(topicId);

		if (count == 0) {
			return null;
		}

		List<Problem> list = findByTopicsId(topicId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the problems before and after the current problem in the ordered set where topicId = &#63;.
	 *
	 * @param problemId the primary key of the current problem
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next problem
	 * @throws NoSuchProblemException if a problem with the primary key could not be found
	 */
	@Override
	public Problem[] findByTopicsId_PrevAndNext(String problemId,
		String topicId, OrderByComparator<Problem> orderByComparator)
		throws NoSuchProblemException {
		Problem problem = findByPrimaryKey(problemId);

		Session session = null;

		try {
			session = openSession();

			Problem[] array = new ProblemImpl[3];

			array[0] = getByTopicsId_PrevAndNext(session, problem, topicId,
					orderByComparator, true);

			array[1] = problem;

			array[2] = getByTopicsId_PrevAndNext(session, problem, topicId,
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

	protected Problem getByTopicsId_PrevAndNext(Session session,
		Problem problem, String topicId,
		OrderByComparator<Problem> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROBLEM_WHERE);

		boolean bindTopicId = false;

		if (topicId == null) {
			query.append(_FINDER_COLUMN_TOPICSID_TOPICID_1);
		}
		else if (topicId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TOPICSID_TOPICID_3);
		}
		else {
			bindTopicId = true;

			query.append(_FINDER_COLUMN_TOPICSID_TOPICID_2);
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
			query.append(ProblemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTopicId) {
			qPos.add(topicId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(problem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Problem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the problems where topicId = &#63; from the database.
	 *
	 * @param topicId the topic ID
	 */
	@Override
	public void removeByTopicsId(String topicId) {
		for (Problem problem : findByTopicsId(topicId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(problem);
		}
	}

	/**
	 * Returns the number of problems where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @return the number of matching problems
	 */
	@Override
	public int countByTopicsId(String topicId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOPICSID;

		Object[] finderArgs = new Object[] { topicId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROBLEM_WHERE);

			boolean bindTopicId = false;

			if (topicId == null) {
				query.append(_FINDER_COLUMN_TOPICSID_TOPICID_1);
			}
			else if (topicId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TOPICSID_TOPICID_3);
			}
			else {
				bindTopicId = true;

				query.append(_FINDER_COLUMN_TOPICSID_TOPICID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTopicId) {
					qPos.add(topicId);
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

	private static final String _FINDER_COLUMN_TOPICSID_TOPICID_1 = "problem.topicId IS NULL";
	private static final String _FINDER_COLUMN_TOPICSID_TOPICID_2 = "problem.topicId = ?";
	private static final String _FINDER_COLUMN_TOPICSID_TOPICID_3 = "(problem.topicId IS NULL OR problem.topicId = '')";

	public ProblemPersistenceImpl() {
		setModelClass(Problem.class);
	}

	/**
	 * Caches the problem in the entity cache if it is enabled.
	 *
	 * @param problem the problem
	 */
	@Override
	public void cacheResult(Problem problem) {
		entityCache.putResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemImpl.class, problem.getPrimaryKey(), problem);

		problem.resetOriginalValues();
	}

	/**
	 * Caches the problems in the entity cache if it is enabled.
	 *
	 * @param problems the problems
	 */
	@Override
	public void cacheResult(List<Problem> problems) {
		for (Problem problem : problems) {
			if (entityCache.getResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
						ProblemImpl.class, problem.getPrimaryKey()) == null) {
				cacheResult(problem);
			}
			else {
				problem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all problems.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProblemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the problem.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Problem problem) {
		entityCache.removeResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemImpl.class, problem.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Problem> problems) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Problem problem : problems) {
			entityCache.removeResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
				ProblemImpl.class, problem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new problem with the primary key. Does not add the problem to the database.
	 *
	 * @param problemId the primary key for the new problem
	 * @return the new problem
	 */
	@Override
	public Problem create(String problemId) {
		Problem problem = new ProblemImpl();

		problem.setNew(true);
		problem.setPrimaryKey(problemId);

		String uuid = PortalUUIDUtil.generate();

		problem.setUuid(uuid);

		return problem;
	}

	/**
	 * Removes the problem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param problemId the primary key of the problem
	 * @return the problem that was removed
	 * @throws NoSuchProblemException if a problem with the primary key could not be found
	 */
	@Override
	public Problem remove(String problemId) throws NoSuchProblemException {
		return remove((Serializable)problemId);
	}

	/**
	 * Removes the problem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the problem
	 * @return the problem that was removed
	 * @throws NoSuchProblemException if a problem with the primary key could not be found
	 */
	@Override
	public Problem remove(Serializable primaryKey)
		throws NoSuchProblemException {
		Session session = null;

		try {
			session = openSession();

			Problem problem = (Problem)session.get(ProblemImpl.class, primaryKey);

			if (problem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProblemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(problem);
		}
		catch (NoSuchProblemException nsee) {
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
	protected Problem removeImpl(Problem problem) {
		problem = toUnwrappedModel(problem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(problem)) {
				problem = (Problem)session.get(ProblemImpl.class,
						problem.getPrimaryKeyObj());
			}

			if (problem != null) {
				session.delete(problem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (problem != null) {
			clearCache(problem);
		}

		return problem;
	}

	@Override
	public Problem updateImpl(Problem problem) {
		problem = toUnwrappedModel(problem);

		boolean isNew = problem.isNew();

		ProblemModelImpl problemModelImpl = (ProblemModelImpl)problem;

		if (Validator.isNull(problem.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			problem.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (problem.isNew()) {
				session.save(problem);

				problem.setNew(false);
			}
			else {
				problem = (Problem)session.merge(problem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProblemModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((problemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { problemModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { problemModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((problemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						problemModelImpl.getOriginalTopicId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICSID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICSID,
					args);

				args = new Object[] { problemModelImpl.getTopicId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICSID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICSID,
					args);
			}
		}

		entityCache.putResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
			ProblemImpl.class, problem.getPrimaryKey(), problem, false);

		problem.resetOriginalValues();

		return problem;
	}

	protected Problem toUnwrappedModel(Problem problem) {
		if (problem instanceof ProblemImpl) {
			return problem;
		}

		ProblemImpl problemImpl = new ProblemImpl();

		problemImpl.setNew(problem.isNew());
		problemImpl.setPrimaryKey(problem.getPrimaryKey());

		problemImpl.setUuid(problem.getUuid());
		problemImpl.setProblemId(problem.getProblemId());
		problemImpl.setProblemName(problem.getProblemName());
		problemImpl.setTopicId(problem.getTopicId());

		return problemImpl;
	}

	/**
	 * Returns the problem with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the problem
	 * @return the problem
	 * @throws NoSuchProblemException if a problem with the primary key could not be found
	 */
	@Override
	public Problem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProblemException {
		Problem problem = fetchByPrimaryKey(primaryKey);

		if (problem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProblemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return problem;
	}

	/**
	 * Returns the problem with the primary key or throws a {@link NoSuchProblemException} if it could not be found.
	 *
	 * @param problemId the primary key of the problem
	 * @return the problem
	 * @throws NoSuchProblemException if a problem with the primary key could not be found
	 */
	@Override
	public Problem findByPrimaryKey(String problemId)
		throws NoSuchProblemException {
		return findByPrimaryKey((Serializable)problemId);
	}

	/**
	 * Returns the problem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the problem
	 * @return the problem, or <code>null</code> if a problem with the primary key could not be found
	 */
	@Override
	public Problem fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
				ProblemImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Problem problem = (Problem)serializable;

		if (problem == null) {
			Session session = null;

			try {
				session = openSession();

				problem = (Problem)session.get(ProblemImpl.class, primaryKey);

				if (problem != null) {
					cacheResult(problem);
				}
				else {
					entityCache.putResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
						ProblemImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
					ProblemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return problem;
	}

	/**
	 * Returns the problem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param problemId the primary key of the problem
	 * @return the problem, or <code>null</code> if a problem with the primary key could not be found
	 */
	@Override
	public Problem fetchByPrimaryKey(String problemId) {
		return fetchByPrimaryKey((Serializable)problemId);
	}

	@Override
	public Map<Serializable, Problem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Problem> map = new HashMap<Serializable, Problem>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Problem problem = fetchByPrimaryKey(primaryKey);

			if (problem != null) {
				map.put(primaryKey, problem);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
					ProblemImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Problem)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_PROBLEM_WHERE_PKS_IN);

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

			for (Problem problem : (List<Problem>)q.list()) {
				map.put(problem.getPrimaryKeyObj(), problem);

				cacheResult(problem);

				uncachedPrimaryKeys.remove(problem.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProblemModelImpl.ENTITY_CACHE_ENABLED,
					ProblemImpl.class, primaryKey, nullModel);
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
	 * Returns all the problems.
	 *
	 * @return the problems
	 */
	@Override
	public List<Problem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the problems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @return the range of problems
	 */
	@Override
	public List<Problem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the problems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of problems
	 */
	@Override
	public List<Problem> findAll(int start, int end,
		OrderByComparator<Problem> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the problems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of problems
	 * @param end the upper bound of the range of problems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of problems
	 */
	@Override
	public List<Problem> findAll(int start, int end,
		OrderByComparator<Problem> orderByComparator, boolean retrieveFromCache) {
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

		List<Problem> list = null;

		if (retrieveFromCache) {
			list = (List<Problem>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROBLEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROBLEM;

				if (pagination) {
					sql = sql.concat(ProblemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Problem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Problem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the problems from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Problem problem : findAll()) {
			remove(problem);
		}
	}

	/**
	 * Returns the number of problems.
	 *
	 * @return the number of problems
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROBLEM);

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
		return ProblemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the problem persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProblemImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROBLEM = "SELECT problem FROM Problem problem";
	private static final String _SQL_SELECT_PROBLEM_WHERE_PKS_IN = "SELECT problem FROM Problem problem WHERE problemId IN (";
	private static final String _SQL_SELECT_PROBLEM_WHERE = "SELECT problem FROM Problem problem WHERE ";
	private static final String _SQL_COUNT_PROBLEM = "SELECT COUNT(problem) FROM Problem problem";
	private static final String _SQL_COUNT_PROBLEM_WHERE = "SELECT COUNT(problem) FROM Problem problem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "problem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Problem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Problem exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProblemPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}