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

package autorizzazione.dir.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.exception.NoSuchScrivaniaException;
import autorizzazione.dir.mef.model.Scrivania;
import autorizzazione.dir.mef.model.impl.ScrivaniaImpl;
import autorizzazione.dir.mef.model.impl.ScrivaniaModelImpl;
import autorizzazione.dir.mef.service.persistence.ScrivaniaPK;
import autorizzazione.dir.mef.service.persistence.ScrivaniaPersistence;

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
 * The persistence implementation for the scrivania service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaPersistence
 * @see autorizzazione.dir.mef.service.persistence.ScrivaniaUtil
 * @generated
 */
@ProviderType
public class ScrivaniaPersistenceImpl extends BasePersistenceImpl<Scrivania>
	implements ScrivaniaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScrivaniaUtil} to access the scrivania persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScrivaniaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_H",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_H",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ScrivaniaModelImpl.USERID_COLUMN_BITMASK |
			ScrivaniaModelImpl.HOMEFLAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_H = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_H",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the scrivanias where userId = &#63; and homeFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @return the matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H(long userId, boolean homeFlag) {
		return findByU_H(userId, homeFlag, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scrivanias where userId = &#63; and homeFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @return the range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H(long userId, boolean homeFlag, int start,
		int end) {
		return findByU_H(userId, homeFlag, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H(long userId, boolean homeFlag, int start,
		int end, OrderByComparator<Scrivania> orderByComparator) {
		return findByU_H(userId, homeFlag, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H(long userId, boolean homeFlag, int start,
		int end, OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H;
			finderArgs = new Object[] { userId, homeFlag };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H;
			finderArgs = new Object[] {
					userId, homeFlag,
					
					start, end, orderByComparator
				};
		}

		List<Scrivania> list = null;

		if (retrieveFromCache) {
			list = (List<Scrivania>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Scrivania scrivania : list) {
					if ((userId != scrivania.getUserId()) ||
							(homeFlag != scrivania.getHomeFlag())) {
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

			query.append(_SQL_SELECT_SCRIVANIA_WHERE);

			query.append(_FINDER_COLUMN_U_H_USERID_2);

			query.append(_FINDER_COLUMN_U_H_HOMEFLAG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScrivaniaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(homeFlag);

				if (!pagination) {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scrivania
	 * @throws NoSuchScrivaniaException if a matching scrivania could not be found
	 */
	@Override
	public Scrivania findByU_H_First(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = fetchByU_H_First(userId, homeFlag,
				orderByComparator);

		if (scrivania != null) {
			return scrivania;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", homeFlag=");
		msg.append(homeFlag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScrivaniaException(msg.toString());
	}

	/**
	 * Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	 */
	@Override
	public Scrivania fetchByU_H_First(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		List<Scrivania> list = findByU_H(userId, homeFlag, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scrivania
	 * @throws NoSuchScrivaniaException if a matching scrivania could not be found
	 */
	@Override
	public Scrivania findByU_H_Last(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = fetchByU_H_Last(userId, homeFlag,
				orderByComparator);

		if (scrivania != null) {
			return scrivania;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", homeFlag=");
		msg.append(homeFlag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScrivaniaException(msg.toString());
	}

	/**
	 * Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	 */
	@Override
	public Scrivania fetchByU_H_Last(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		int count = countByU_H(userId, homeFlag);

		if (count == 0) {
			return null;
		}

		List<Scrivania> list = findByU_H(userId, homeFlag, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scrivanias before and after the current scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	 *
	 * @param scrivaniaPK the primary key of the current scrivania
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scrivania
	 * @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania[] findByU_H_PrevAndNext(ScrivaniaPK scrivaniaPK,
		long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = findByPrimaryKey(scrivaniaPK);

		Session session = null;

		try {
			session = openSession();

			Scrivania[] array = new ScrivaniaImpl[3];

			array[0] = getByU_H_PrevAndNext(session, scrivania, userId,
					homeFlag, orderByComparator, true);

			array[1] = scrivania;

			array[2] = getByU_H_PrevAndNext(session, scrivania, userId,
					homeFlag, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Scrivania getByU_H_PrevAndNext(Session session,
		Scrivania scrivania, long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SCRIVANIA_WHERE);

		query.append(_FINDER_COLUMN_U_H_USERID_2);

		query.append(_FINDER_COLUMN_U_H_HOMEFLAG_2);

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
			query.append(ScrivaniaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(homeFlag);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scrivania);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Scrivania> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scrivanias where userId = &#63; and homeFlag = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 */
	@Override
	public void removeByU_H(long userId, boolean homeFlag) {
		for (Scrivania scrivania : findByU_H(userId, homeFlag,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scrivania);
		}
	}

	/**
	 * Returns the number of scrivanias where userId = &#63; and homeFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @return the number of matching scrivanias
	 */
	@Override
	public int countByU_H(long userId, boolean homeFlag) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_H;

		Object[] finderArgs = new Object[] { userId, homeFlag };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCRIVANIA_WHERE);

			query.append(_FINDER_COLUMN_U_H_USERID_2);

			query.append(_FINDER_COLUMN_U_H_HOMEFLAG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(homeFlag);

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

	private static final String _FINDER_COLUMN_U_H_USERID_2 = "scrivania.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_H_HOMEFLAG_2 = "scrivania.homeFlag = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_P",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ScrivaniaModelImpl.USERID_COLUMN_BITMASK |
			ScrivaniaModelImpl.PROFILEFLAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_P = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_P",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the scrivanias where userId = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @return the matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_P(long userId, boolean profileFlag) {
		return findByU_P(userId, profileFlag, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scrivanias where userId = &#63; and profileFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @return the range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_P(long userId, boolean profileFlag,
		int start, int end) {
		return findByU_P(userId, profileFlag, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scrivanias where userId = &#63; and profileFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_P(long userId, boolean profileFlag,
		int start, int end, OrderByComparator<Scrivania> orderByComparator) {
		return findByU_P(userId, profileFlag, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the scrivanias where userId = &#63; and profileFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_P(long userId, boolean profileFlag,
		int start, int end, OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P;
			finderArgs = new Object[] { userId, profileFlag };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P;
			finderArgs = new Object[] {
					userId, profileFlag,
					
					start, end, orderByComparator
				};
		}

		List<Scrivania> list = null;

		if (retrieveFromCache) {
			list = (List<Scrivania>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Scrivania scrivania : list) {
					if ((userId != scrivania.getUserId()) ||
							(profileFlag != scrivania.getProfileFlag())) {
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

			query.append(_SQL_SELECT_SCRIVANIA_WHERE);

			query.append(_FINDER_COLUMN_U_P_USERID_2);

			query.append(_FINDER_COLUMN_U_P_PROFILEFLAG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScrivaniaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(profileFlag);

				if (!pagination) {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scrivania
	 * @throws NoSuchScrivaniaException if a matching scrivania could not be found
	 */
	@Override
	public Scrivania findByU_P_First(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = fetchByU_P_First(userId, profileFlag,
				orderByComparator);

		if (scrivania != null) {
			return scrivania;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", profileFlag=");
		msg.append(profileFlag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScrivaniaException(msg.toString());
	}

	/**
	 * Returns the first scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	 */
	@Override
	public Scrivania fetchByU_P_First(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		List<Scrivania> list = findByU_P(userId, profileFlag, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scrivania
	 * @throws NoSuchScrivaniaException if a matching scrivania could not be found
	 */
	@Override
	public Scrivania findByU_P_Last(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = fetchByU_P_Last(userId, profileFlag,
				orderByComparator);

		if (scrivania != null) {
			return scrivania;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", profileFlag=");
		msg.append(profileFlag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScrivaniaException(msg.toString());
	}

	/**
	 * Returns the last scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	 */
	@Override
	public Scrivania fetchByU_P_Last(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		int count = countByU_P(userId, profileFlag);

		if (count == 0) {
			return null;
		}

		List<Scrivania> list = findByU_P(userId, profileFlag, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scrivanias before and after the current scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	 *
	 * @param scrivaniaPK the primary key of the current scrivania
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scrivania
	 * @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania[] findByU_P_PrevAndNext(ScrivaniaPK scrivaniaPK,
		long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = findByPrimaryKey(scrivaniaPK);

		Session session = null;

		try {
			session = openSession();

			Scrivania[] array = new ScrivaniaImpl[3];

			array[0] = getByU_P_PrevAndNext(session, scrivania, userId,
					profileFlag, orderByComparator, true);

			array[1] = scrivania;

			array[2] = getByU_P_PrevAndNext(session, scrivania, userId,
					profileFlag, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Scrivania getByU_P_PrevAndNext(Session session,
		Scrivania scrivania, long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SCRIVANIA_WHERE);

		query.append(_FINDER_COLUMN_U_P_USERID_2);

		query.append(_FINDER_COLUMN_U_P_PROFILEFLAG_2);

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
			query.append(ScrivaniaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(profileFlag);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scrivania);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Scrivania> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scrivanias where userId = &#63; and profileFlag = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 */
	@Override
	public void removeByU_P(long userId, boolean profileFlag) {
		for (Scrivania scrivania : findByU_P(userId, profileFlag,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scrivania);
		}
	}

	/**
	 * Returns the number of scrivanias where userId = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param profileFlag the profile flag
	 * @return the number of matching scrivanias
	 */
	@Override
	public int countByU_P(long userId, boolean profileFlag) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_P;

		Object[] finderArgs = new Object[] { userId, profileFlag };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCRIVANIA_WHERE);

			query.append(_FINDER_COLUMN_U_P_USERID_2);

			query.append(_FINDER_COLUMN_U_P_PROFILEFLAG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(profileFlag);

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

	private static final String _FINDER_COLUMN_U_P_USERID_2 = "scrivania.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_P_PROFILEFLAG_2 = "scrivania.profileFlag = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H_P = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_H_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_P = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, ScrivaniaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_H_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			ScrivaniaModelImpl.USERID_COLUMN_BITMASK |
			ScrivaniaModelImpl.HOMEFLAG_COLUMN_BITMASK |
			ScrivaniaModelImpl.PROFILEFLAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_H_P = new FinderPath(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_H_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @return the matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag) {
		return findByU_H_P(userId, homeFlag, profileFlag, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @return the range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end) {
		return findByU_H_P(userId, homeFlag, profileFlag, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end,
		OrderByComparator<Scrivania> orderByComparator) {
		return findByU_H_P(userId, homeFlag, profileFlag, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching scrivanias
	 */
	@Override
	public List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end,
		OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_P;
			finderArgs = new Object[] { userId, homeFlag, profileFlag };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H_P;
			finderArgs = new Object[] {
					userId, homeFlag, profileFlag,
					
					start, end, orderByComparator
				};
		}

		List<Scrivania> list = null;

		if (retrieveFromCache) {
			list = (List<Scrivania>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Scrivania scrivania : list) {
					if ((userId != scrivania.getUserId()) ||
							(homeFlag != scrivania.getHomeFlag()) ||
							(profileFlag != scrivania.getProfileFlag())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SCRIVANIA_WHERE);

			query.append(_FINDER_COLUMN_U_H_P_USERID_2);

			query.append(_FINDER_COLUMN_U_H_P_HOMEFLAG_2);

			query.append(_FINDER_COLUMN_U_H_P_PROFILEFLAG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScrivaniaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(homeFlag);

				qPos.add(profileFlag);

				if (!pagination) {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scrivania
	 * @throws NoSuchScrivaniaException if a matching scrivania could not be found
	 */
	@Override
	public Scrivania findByU_H_P_First(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = fetchByU_H_P_First(userId, homeFlag, profileFlag,
				orderByComparator);

		if (scrivania != null) {
			return scrivania;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", homeFlag=");
		msg.append(homeFlag);

		msg.append(", profileFlag=");
		msg.append(profileFlag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScrivaniaException(msg.toString());
	}

	/**
	 * Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	 */
	@Override
	public Scrivania fetchByU_H_P_First(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator) {
		List<Scrivania> list = findByU_H_P(userId, homeFlag, profileFlag, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scrivania
	 * @throws NoSuchScrivaniaException if a matching scrivania could not be found
	 */
	@Override
	public Scrivania findByU_H_P_Last(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = fetchByU_H_P_Last(userId, homeFlag, profileFlag,
				orderByComparator);

		if (scrivania != null) {
			return scrivania;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", homeFlag=");
		msg.append(homeFlag);

		msg.append(", profileFlag=");
		msg.append(profileFlag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScrivaniaException(msg.toString());
	}

	/**
	 * Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	 */
	@Override
	public Scrivania fetchByU_H_P_Last(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator) {
		int count = countByU_H_P(userId, homeFlag, profileFlag);

		if (count == 0) {
			return null;
		}

		List<Scrivania> list = findByU_H_P(userId, homeFlag, profileFlag,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scrivanias before and after the current scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * @param scrivaniaPK the primary key of the current scrivania
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scrivania
	 * @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania[] findByU_H_P_PrevAndNext(ScrivaniaPK scrivaniaPK,
		long userId, boolean homeFlag, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = findByPrimaryKey(scrivaniaPK);

		Session session = null;

		try {
			session = openSession();

			Scrivania[] array = new ScrivaniaImpl[3];

			array[0] = getByU_H_P_PrevAndNext(session, scrivania, userId,
					homeFlag, profileFlag, orderByComparator, true);

			array[1] = scrivania;

			array[2] = getByU_H_P_PrevAndNext(session, scrivania, userId,
					homeFlag, profileFlag, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Scrivania getByU_H_P_PrevAndNext(Session session,
		Scrivania scrivania, long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SCRIVANIA_WHERE);

		query.append(_FINDER_COLUMN_U_H_P_USERID_2);

		query.append(_FINDER_COLUMN_U_H_P_HOMEFLAG_2);

		query.append(_FINDER_COLUMN_U_H_P_PROFILEFLAG_2);

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
			query.append(ScrivaniaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(homeFlag);

		qPos.add(profileFlag);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scrivania);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Scrivania> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 */
	@Override
	public void removeByU_H_P(long userId, boolean homeFlag, boolean profileFlag) {
		for (Scrivania scrivania : findByU_H_P(userId, homeFlag, profileFlag,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scrivania);
		}
	}

	/**
	 * Returns the number of scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	 *
	 * @param userId the user ID
	 * @param homeFlag the home flag
	 * @param profileFlag the profile flag
	 * @return the number of matching scrivanias
	 */
	@Override
	public int countByU_H_P(long userId, boolean homeFlag, boolean profileFlag) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_H_P;

		Object[] finderArgs = new Object[] { userId, homeFlag, profileFlag };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCRIVANIA_WHERE);

			query.append(_FINDER_COLUMN_U_H_P_USERID_2);

			query.append(_FINDER_COLUMN_U_H_P_HOMEFLAG_2);

			query.append(_FINDER_COLUMN_U_H_P_PROFILEFLAG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(homeFlag);

				qPos.add(profileFlag);

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

	private static final String _FINDER_COLUMN_U_H_P_USERID_2 = "scrivania.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_H_P_HOMEFLAG_2 = "scrivania.homeFlag = ? AND ";
	private static final String _FINDER_COLUMN_U_H_P_PROFILEFLAG_2 = "scrivania.profileFlag = ?";

	public ScrivaniaPersistenceImpl() {
		setModelClass(Scrivania.class);
	}

	/**
	 * Caches the scrivania in the entity cache if it is enabled.
	 *
	 * @param scrivania the scrivania
	 */
	@Override
	public void cacheResult(Scrivania scrivania) {
		entityCache.putResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaImpl.class, scrivania.getPrimaryKey(), scrivania);

		scrivania.resetOriginalValues();
	}

	/**
	 * Caches the scrivanias in the entity cache if it is enabled.
	 *
	 * @param scrivanias the scrivanias
	 */
	@Override
	public void cacheResult(List<Scrivania> scrivanias) {
		for (Scrivania scrivania : scrivanias) {
			if (entityCache.getResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
						ScrivaniaImpl.class, scrivania.getPrimaryKey()) == null) {
				cacheResult(scrivania);
			}
			else {
				scrivania.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all scrivanias.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ScrivaniaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the scrivania.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Scrivania scrivania) {
		entityCache.removeResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaImpl.class, scrivania.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Scrivania> scrivanias) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Scrivania scrivania : scrivanias) {
			entityCache.removeResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
				ScrivaniaImpl.class, scrivania.getPrimaryKey());
		}
	}

	/**
	 * Creates a new scrivania with the primary key. Does not add the scrivania to the database.
	 *
	 * @param scrivaniaPK the primary key for the new scrivania
	 * @return the new scrivania
	 */
	@Override
	public Scrivania create(ScrivaniaPK scrivaniaPK) {
		Scrivania scrivania = new ScrivaniaImpl();

		scrivania.setNew(true);
		scrivania.setPrimaryKey(scrivaniaPK);

		return scrivania;
	}

	/**
	 * Removes the scrivania with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scrivaniaPK the primary key of the scrivania
	 * @return the scrivania that was removed
	 * @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania remove(ScrivaniaPK scrivaniaPK)
		throws NoSuchScrivaniaException {
		return remove((Serializable)scrivaniaPK);
	}

	/**
	 * Removes the scrivania with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the scrivania
	 * @return the scrivania that was removed
	 * @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania remove(Serializable primaryKey)
		throws NoSuchScrivaniaException {
		Session session = null;

		try {
			session = openSession();

			Scrivania scrivania = (Scrivania)session.get(ScrivaniaImpl.class,
					primaryKey);

			if (scrivania == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScrivaniaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scrivania);
		}
		catch (NoSuchScrivaniaException nsee) {
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
	protected Scrivania removeImpl(Scrivania scrivania) {
		scrivania = toUnwrappedModel(scrivania);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scrivania)) {
				scrivania = (Scrivania)session.get(ScrivaniaImpl.class,
						scrivania.getPrimaryKeyObj());
			}

			if (scrivania != null) {
				session.delete(scrivania);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scrivania != null) {
			clearCache(scrivania);
		}

		return scrivania;
	}

	@Override
	public Scrivania updateImpl(Scrivania scrivania) {
		scrivania = toUnwrappedModel(scrivania);

		boolean isNew = scrivania.isNew();

		ScrivaniaModelImpl scrivaniaModelImpl = (ScrivaniaModelImpl)scrivania;

		Session session = null;

		try {
			session = openSession();

			if (scrivania.isNew()) {
				session.save(scrivania);

				scrivania.setNew(false);
			}
			else {
				scrivania = (Scrivania)session.merge(scrivania);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScrivaniaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scrivaniaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scrivaniaModelImpl.getOriginalUserId(),
						scrivaniaModelImpl.getOriginalHomeFlag()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H,
					args);

				args = new Object[] {
						scrivaniaModelImpl.getUserId(),
						scrivaniaModelImpl.getHomeFlag()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H,
					args);
			}

			if ((scrivaniaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scrivaniaModelImpl.getOriginalUserId(),
						scrivaniaModelImpl.getOriginalProfileFlag()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P,
					args);

				args = new Object[] {
						scrivaniaModelImpl.getUserId(),
						scrivaniaModelImpl.getProfileFlag()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P,
					args);
			}

			if ((scrivaniaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scrivaniaModelImpl.getOriginalUserId(),
						scrivaniaModelImpl.getOriginalHomeFlag(),
						scrivaniaModelImpl.getOriginalProfileFlag()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_P,
					args);

				args = new Object[] {
						scrivaniaModelImpl.getUserId(),
						scrivaniaModelImpl.getHomeFlag(),
						scrivaniaModelImpl.getProfileFlag()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_P,
					args);
			}
		}

		entityCache.putResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
			ScrivaniaImpl.class, scrivania.getPrimaryKey(), scrivania, false);

		scrivania.resetOriginalValues();

		return scrivania;
	}

	protected Scrivania toUnwrappedModel(Scrivania scrivania) {
		if (scrivania instanceof ScrivaniaImpl) {
			return scrivania;
		}

		ScrivaniaImpl scrivaniaImpl = new ScrivaniaImpl();

		scrivaniaImpl.setNew(scrivania.isNew());
		scrivaniaImpl.setPrimaryKey(scrivania.getPrimaryKey());

		scrivaniaImpl.setRowId(scrivania.getRowId());
		scrivaniaImpl.setCreateDate(scrivania.getCreateDate());
		scrivaniaImpl.setUserId(scrivania.getUserId());
		scrivaniaImpl.setApplicationId(scrivania.getApplicationId());
		scrivaniaImpl.setHomeFlag(scrivania.isHomeFlag());
		scrivaniaImpl.setProfileFlag(scrivania.isProfileFlag());

		return scrivaniaImpl;
	}

	/**
	 * Returns the scrivania with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the scrivania
	 * @return the scrivania
	 * @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScrivaniaException {
		Scrivania scrivania = fetchByPrimaryKey(primaryKey);

		if (scrivania == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScrivaniaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scrivania;
	}

	/**
	 * Returns the scrivania with the primary key or throws a {@link NoSuchScrivaniaException} if it could not be found.
	 *
	 * @param scrivaniaPK the primary key of the scrivania
	 * @return the scrivania
	 * @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania findByPrimaryKey(ScrivaniaPK scrivaniaPK)
		throws NoSuchScrivaniaException {
		return findByPrimaryKey((Serializable)scrivaniaPK);
	}

	/**
	 * Returns the scrivania with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the scrivania
	 * @return the scrivania, or <code>null</code> if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
				ScrivaniaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Scrivania scrivania = (Scrivania)serializable;

		if (scrivania == null) {
			Session session = null;

			try {
				session = openSession();

				scrivania = (Scrivania)session.get(ScrivaniaImpl.class,
						primaryKey);

				if (scrivania != null) {
					cacheResult(scrivania);
				}
				else {
					entityCache.putResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
						ScrivaniaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ScrivaniaModelImpl.ENTITY_CACHE_ENABLED,
					ScrivaniaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scrivania;
	}

	/**
	 * Returns the scrivania with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scrivaniaPK the primary key of the scrivania
	 * @return the scrivania, or <code>null</code> if a scrivania with the primary key could not be found
	 */
	@Override
	public Scrivania fetchByPrimaryKey(ScrivaniaPK scrivaniaPK) {
		return fetchByPrimaryKey((Serializable)scrivaniaPK);
	}

	@Override
	public Map<Serializable, Scrivania> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Scrivania> map = new HashMap<Serializable, Scrivania>();

		for (Serializable primaryKey : primaryKeys) {
			Scrivania scrivania = fetchByPrimaryKey(primaryKey);

			if (scrivania != null) {
				map.put(primaryKey, scrivania);
			}
		}

		return map;
	}

	/**
	 * Returns all the scrivanias.
	 *
	 * @return the scrivanias
	 */
	@Override
	public List<Scrivania> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scrivanias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @return the range of scrivanias
	 */
	@Override
	public List<Scrivania> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the scrivanias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of scrivanias
	 */
	@Override
	public List<Scrivania> findAll(int start, int end,
		OrderByComparator<Scrivania> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the scrivanias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scrivanias
	 * @param end the upper bound of the range of scrivanias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of scrivanias
	 */
	@Override
	public List<Scrivania> findAll(int start, int end,
		OrderByComparator<Scrivania> orderByComparator,
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

		List<Scrivania> list = null;

		if (retrieveFromCache) {
			list = (List<Scrivania>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SCRIVANIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCRIVANIA;

				if (pagination) {
					sql = sql.concat(ScrivaniaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Scrivania>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the scrivanias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Scrivania scrivania : findAll()) {
			remove(scrivania);
		}
	}

	/**
	 * Returns the number of scrivanias.
	 *
	 * @return the number of scrivanias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCRIVANIA);

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
		return ScrivaniaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the scrivania persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ScrivaniaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SCRIVANIA = "SELECT scrivania FROM Scrivania scrivania";
	private static final String _SQL_SELECT_SCRIVANIA_WHERE = "SELECT scrivania FROM Scrivania scrivania WHERE ";
	private static final String _SQL_COUNT_SCRIVANIA = "SELECT COUNT(scrivania) FROM Scrivania scrivania";
	private static final String _SQL_COUNT_SCRIVANIA_WHERE = "SELECT COUNT(scrivania) FROM Scrivania scrivania WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scrivania.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Scrivania exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Scrivania exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ScrivaniaPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"rowId"
			});
}