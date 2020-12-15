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

import autorizzazione.dir.mef.exception.NoSuchUtilizzoApplicazioniException;
import autorizzazione.dir.mef.model.UtilizzoApplicazioni;
import autorizzazione.dir.mef.model.impl.UtilizzoApplicazioniImpl;
import autorizzazione.dir.mef.model.impl.UtilizzoApplicazioniModelImpl;
import autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK;
import autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPersistence;

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
 * The persistence implementation for the utilizzo applicazioni service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioniPersistence
 * @see autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniUtil
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniPersistenceImpl extends BasePersistenceImpl<UtilizzoApplicazioni>
	implements UtilizzoApplicazioniPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UtilizzoApplicazioniUtil} to access the utilizzo applicazioni persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UtilizzoApplicazioniImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniModelImpl.FINDER_CACHE_ENABLED,
			UtilizzoApplicazioniImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniModelImpl.FINDER_CACHE_ENABLED,
			UtilizzoApplicazioniImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniModelImpl.FINDER_CACHE_ENABLED,
			UtilizzoApplicazioniImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniModelImpl.FINDER_CACHE_ENABLED,
			UtilizzoApplicazioniImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			UtilizzoApplicazioniModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the utilizzo applicazionis where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utilizzo applicazionis where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of utilizzo applicazionis
	 * @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	 * @return the range of matching utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findByUserId(long userId, int start,
		int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utilizzo applicazionis where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of utilizzo applicazionis
	 * @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findByUserId(long userId, int start,
		int end, OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utilizzo applicazionis where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of utilizzo applicazionis
	 * @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findByUserId(long userId, int start,
		int end, OrderByComparator<UtilizzoApplicazioni> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<UtilizzoApplicazioni> list = null;

		if (retrieveFromCache) {
			list = (List<UtilizzoApplicazioni>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UtilizzoApplicazioni utilizzoApplicazioni : list) {
					if ((userId != utilizzoApplicazioni.getUserId())) {
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

			query.append(_SQL_SELECT_UTILIZZOAPPLICAZIONI_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UtilizzoApplicazioniModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UtilizzoApplicazioni>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UtilizzoApplicazioni>)QueryUtil.list(q,
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
	 * Returns the first utilizzo applicazioni in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utilizzo applicazioni
	 * @throws NoSuchUtilizzoApplicazioniException if a matching utilizzo applicazioni could not be found
	 */
	@Override
	public UtilizzoApplicazioni findByUserId_First(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws NoSuchUtilizzoApplicazioniException {
		UtilizzoApplicazioni utilizzoApplicazioni = fetchByUserId_First(userId,
				orderByComparator);

		if (utilizzoApplicazioni != null) {
			return utilizzoApplicazioni;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUtilizzoApplicazioniException(msg.toString());
	}

	/**
	 * Returns the first utilizzo applicazioni in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utilizzo applicazioni, or <code>null</code> if a matching utilizzo applicazioni could not be found
	 */
	@Override
	public UtilizzoApplicazioni fetchByUserId_First(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		List<UtilizzoApplicazioni> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utilizzo applicazioni in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utilizzo applicazioni
	 * @throws NoSuchUtilizzoApplicazioniException if a matching utilizzo applicazioni could not be found
	 */
	@Override
	public UtilizzoApplicazioni findByUserId_Last(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws NoSuchUtilizzoApplicazioniException {
		UtilizzoApplicazioni utilizzoApplicazioni = fetchByUserId_Last(userId,
				orderByComparator);

		if (utilizzoApplicazioni != null) {
			return utilizzoApplicazioni;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUtilizzoApplicazioniException(msg.toString());
	}

	/**
	 * Returns the last utilizzo applicazioni in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utilizzo applicazioni, or <code>null</code> if a matching utilizzo applicazioni could not be found
	 */
	@Override
	public UtilizzoApplicazioni fetchByUserId_Last(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<UtilizzoApplicazioni> list = findByUserId(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utilizzo applicazionis before and after the current utilizzo applicazioni in the ordered set where userId = &#63;.
	 *
	 * @param utilizzoApplicazioniPK the primary key of the current utilizzo applicazioni
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utilizzo applicazioni
	 * @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	 */
	@Override
	public UtilizzoApplicazioni[] findByUserId_PrevAndNext(
		UtilizzoApplicazioniPK utilizzoApplicazioniPK, long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws NoSuchUtilizzoApplicazioniException {
		UtilizzoApplicazioni utilizzoApplicazioni = findByPrimaryKey(utilizzoApplicazioniPK);

		Session session = null;

		try {
			session = openSession();

			UtilizzoApplicazioni[] array = new UtilizzoApplicazioniImpl[3];

			array[0] = getByUserId_PrevAndNext(session, utilizzoApplicazioni,
					userId, orderByComparator, true);

			array[1] = utilizzoApplicazioni;

			array[2] = getByUserId_PrevAndNext(session, utilizzoApplicazioni,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UtilizzoApplicazioni getByUserId_PrevAndNext(Session session,
		UtilizzoApplicazioni utilizzoApplicazioni, long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator,
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

		query.append(_SQL_SELECT_UTILIZZOAPPLICAZIONI_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(UtilizzoApplicazioniModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(utilizzoApplicazioni);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UtilizzoApplicazioni> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utilizzo applicazionis where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (UtilizzoApplicazioni utilizzoApplicazioni : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(utilizzoApplicazioni);
		}
	}

	/**
	 * Returns the number of utilizzo applicazionis where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching utilizzo applicazionis
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UTILIZZOAPPLICAZIONI_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "utilizzoApplicazioni.id.userId = ?";

	public UtilizzoApplicazioniPersistenceImpl() {
		setModelClass(UtilizzoApplicazioni.class);
	}

	/**
	 * Caches the utilizzo applicazioni in the entity cache if it is enabled.
	 *
	 * @param utilizzoApplicazioni the utilizzo applicazioni
	 */
	@Override
	public void cacheResult(UtilizzoApplicazioni utilizzoApplicazioni) {
		entityCache.putResult(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniImpl.class,
			utilizzoApplicazioni.getPrimaryKey(), utilizzoApplicazioni);

		utilizzoApplicazioni.resetOriginalValues();
	}

	/**
	 * Caches the utilizzo applicazionis in the entity cache if it is enabled.
	 *
	 * @param utilizzoApplicazionis the utilizzo applicazionis
	 */
	@Override
	public void cacheResult(List<UtilizzoApplicazioni> utilizzoApplicazionis) {
		for (UtilizzoApplicazioni utilizzoApplicazioni : utilizzoApplicazionis) {
			if (entityCache.getResult(
						UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
						UtilizzoApplicazioniImpl.class,
						utilizzoApplicazioni.getPrimaryKey()) == null) {
				cacheResult(utilizzoApplicazioni);
			}
			else {
				utilizzoApplicazioni.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all utilizzo applicazionis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UtilizzoApplicazioniImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the utilizzo applicazioni.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UtilizzoApplicazioni utilizzoApplicazioni) {
		entityCache.removeResult(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniImpl.class, utilizzoApplicazioni.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UtilizzoApplicazioni> utilizzoApplicazionis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UtilizzoApplicazioni utilizzoApplicazioni : utilizzoApplicazionis) {
			entityCache.removeResult(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
				UtilizzoApplicazioniImpl.class,
				utilizzoApplicazioni.getPrimaryKey());
		}
	}

	/**
	 * Creates a new utilizzo applicazioni with the primary key. Does not add the utilizzo applicazioni to the database.
	 *
	 * @param utilizzoApplicazioniPK the primary key for the new utilizzo applicazioni
	 * @return the new utilizzo applicazioni
	 */
	@Override
	public UtilizzoApplicazioni create(
		UtilizzoApplicazioniPK utilizzoApplicazioniPK) {
		UtilizzoApplicazioni utilizzoApplicazioni = new UtilizzoApplicazioniImpl();

		utilizzoApplicazioni.setNew(true);
		utilizzoApplicazioni.setPrimaryKey(utilizzoApplicazioniPK);

		return utilizzoApplicazioni;
	}

	/**
	 * Removes the utilizzo applicazioni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	 * @return the utilizzo applicazioni that was removed
	 * @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	 */
	@Override
	public UtilizzoApplicazioni remove(
		UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws NoSuchUtilizzoApplicazioniException {
		return remove((Serializable)utilizzoApplicazioniPK);
	}

	/**
	 * Removes the utilizzo applicazioni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the utilizzo applicazioni
	 * @return the utilizzo applicazioni that was removed
	 * @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	 */
	@Override
	public UtilizzoApplicazioni remove(Serializable primaryKey)
		throws NoSuchUtilizzoApplicazioniException {
		Session session = null;

		try {
			session = openSession();

			UtilizzoApplicazioni utilizzoApplicazioni = (UtilizzoApplicazioni)session.get(UtilizzoApplicazioniImpl.class,
					primaryKey);

			if (utilizzoApplicazioni == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUtilizzoApplicazioniException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(utilizzoApplicazioni);
		}
		catch (NoSuchUtilizzoApplicazioniException nsee) {
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
	protected UtilizzoApplicazioni removeImpl(
		UtilizzoApplicazioni utilizzoApplicazioni) {
		utilizzoApplicazioni = toUnwrappedModel(utilizzoApplicazioni);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(utilizzoApplicazioni)) {
				utilizzoApplicazioni = (UtilizzoApplicazioni)session.get(UtilizzoApplicazioniImpl.class,
						utilizzoApplicazioni.getPrimaryKeyObj());
			}

			if (utilizzoApplicazioni != null) {
				session.delete(utilizzoApplicazioni);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (utilizzoApplicazioni != null) {
			clearCache(utilizzoApplicazioni);
		}

		return utilizzoApplicazioni;
	}

	@Override
	public UtilizzoApplicazioni updateImpl(
		UtilizzoApplicazioni utilizzoApplicazioni) {
		utilizzoApplicazioni = toUnwrappedModel(utilizzoApplicazioni);

		boolean isNew = utilizzoApplicazioni.isNew();

		UtilizzoApplicazioniModelImpl utilizzoApplicazioniModelImpl = (UtilizzoApplicazioniModelImpl)utilizzoApplicazioni;

		Session session = null;

		try {
			session = openSession();

			if (utilizzoApplicazioni.isNew()) {
				session.save(utilizzoApplicazioni);

				utilizzoApplicazioni.setNew(false);
			}
			else {
				utilizzoApplicazioni = (UtilizzoApplicazioni)session.merge(utilizzoApplicazioni);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UtilizzoApplicazioniModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((utilizzoApplicazioniModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						utilizzoApplicazioniModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { utilizzoApplicazioniModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		entityCache.putResult(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
			UtilizzoApplicazioniImpl.class,
			utilizzoApplicazioni.getPrimaryKey(), utilizzoApplicazioni, false);

		utilizzoApplicazioni.resetOriginalValues();

		return utilizzoApplicazioni;
	}

	protected UtilizzoApplicazioni toUnwrappedModel(
		UtilizzoApplicazioni utilizzoApplicazioni) {
		if (utilizzoApplicazioni instanceof UtilizzoApplicazioniImpl) {
			return utilizzoApplicazioni;
		}

		UtilizzoApplicazioniImpl utilizzoApplicazioniImpl = new UtilizzoApplicazioniImpl();

		utilizzoApplicazioniImpl.setNew(utilizzoApplicazioni.isNew());
		utilizzoApplicazioniImpl.setPrimaryKey(utilizzoApplicazioni.getPrimaryKey());

		utilizzoApplicazioniImpl.setRowId(utilizzoApplicazioni.getRowId());
		utilizzoApplicazioniImpl.setCreateDate(utilizzoApplicazioni.getCreateDate());
		utilizzoApplicazioniImpl.setUserId(utilizzoApplicazioni.getUserId());
		utilizzoApplicazioniImpl.setApplicationId(utilizzoApplicazioni.getApplicationId());
		utilizzoApplicazioniImpl.setLastUseDate(utilizzoApplicazioni.getLastUseDate());
		utilizzoApplicazioniImpl.setHitsCount(utilizzoApplicazioni.getHitsCount());

		return utilizzoApplicazioniImpl;
	}

	/**
	 * Returns the utilizzo applicazioni with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the utilizzo applicazioni
	 * @return the utilizzo applicazioni
	 * @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	 */
	@Override
	public UtilizzoApplicazioni findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUtilizzoApplicazioniException {
		UtilizzoApplicazioni utilizzoApplicazioni = fetchByPrimaryKey(primaryKey);

		if (utilizzoApplicazioni == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUtilizzoApplicazioniException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return utilizzoApplicazioni;
	}

	/**
	 * Returns the utilizzo applicazioni with the primary key or throws a {@link NoSuchUtilizzoApplicazioniException} if it could not be found.
	 *
	 * @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	 * @return the utilizzo applicazioni
	 * @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	 */
	@Override
	public UtilizzoApplicazioni findByPrimaryKey(
		UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws NoSuchUtilizzoApplicazioniException {
		return findByPrimaryKey((Serializable)utilizzoApplicazioniPK);
	}

	/**
	 * Returns the utilizzo applicazioni with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the utilizzo applicazioni
	 * @return the utilizzo applicazioni, or <code>null</code> if a utilizzo applicazioni with the primary key could not be found
	 */
	@Override
	public UtilizzoApplicazioni fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
				UtilizzoApplicazioniImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UtilizzoApplicazioni utilizzoApplicazioni = (UtilizzoApplicazioni)serializable;

		if (utilizzoApplicazioni == null) {
			Session session = null;

			try {
				session = openSession();

				utilizzoApplicazioni = (UtilizzoApplicazioni)session.get(UtilizzoApplicazioniImpl.class,
						primaryKey);

				if (utilizzoApplicazioni != null) {
					cacheResult(utilizzoApplicazioni);
				}
				else {
					entityCache.putResult(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
						UtilizzoApplicazioniImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UtilizzoApplicazioniModelImpl.ENTITY_CACHE_ENABLED,
					UtilizzoApplicazioniImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return utilizzoApplicazioni;
	}

	/**
	 * Returns the utilizzo applicazioni with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	 * @return the utilizzo applicazioni, or <code>null</code> if a utilizzo applicazioni with the primary key could not be found
	 */
	@Override
	public UtilizzoApplicazioni fetchByPrimaryKey(
		UtilizzoApplicazioniPK utilizzoApplicazioniPK) {
		return fetchByPrimaryKey((Serializable)utilizzoApplicazioniPK);
	}

	@Override
	public Map<Serializable, UtilizzoApplicazioni> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UtilizzoApplicazioni> map = new HashMap<Serializable, UtilizzoApplicazioni>();

		for (Serializable primaryKey : primaryKeys) {
			UtilizzoApplicazioni utilizzoApplicazioni = fetchByPrimaryKey(primaryKey);

			if (utilizzoApplicazioni != null) {
				map.put(primaryKey, utilizzoApplicazioni);
			}
		}

		return map;
	}

	/**
	 * Returns all the utilizzo applicazionis.
	 *
	 * @return the utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utilizzo applicazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utilizzo applicazionis
	 * @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	 * @return the range of utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the utilizzo applicazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utilizzo applicazionis
	 * @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findAll(int start, int end,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utilizzo applicazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utilizzo applicazionis
	 * @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of utilizzo applicazionis
	 */
	@Override
	public List<UtilizzoApplicazioni> findAll(int start, int end,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator,
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

		List<UtilizzoApplicazioni> list = null;

		if (retrieveFromCache) {
			list = (List<UtilizzoApplicazioni>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_UTILIZZOAPPLICAZIONI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UTILIZZOAPPLICAZIONI;

				if (pagination) {
					sql = sql.concat(UtilizzoApplicazioniModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UtilizzoApplicazioni>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UtilizzoApplicazioni>)QueryUtil.list(q,
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
	 * Removes all the utilizzo applicazionis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UtilizzoApplicazioni utilizzoApplicazioni : findAll()) {
			remove(utilizzoApplicazioni);
		}
	}

	/**
	 * Returns the number of utilizzo applicazionis.
	 *
	 * @return the number of utilizzo applicazionis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UTILIZZOAPPLICAZIONI);

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
		return UtilizzoApplicazioniModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the utilizzo applicazioni persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UtilizzoApplicazioniImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_UTILIZZOAPPLICAZIONI = "SELECT utilizzoApplicazioni FROM UtilizzoApplicazioni utilizzoApplicazioni";
	private static final String _SQL_SELECT_UTILIZZOAPPLICAZIONI_WHERE = "SELECT utilizzoApplicazioni FROM UtilizzoApplicazioni utilizzoApplicazioni WHERE ";
	private static final String _SQL_COUNT_UTILIZZOAPPLICAZIONI = "SELECT COUNT(utilizzoApplicazioni) FROM UtilizzoApplicazioni utilizzoApplicazioni";
	private static final String _SQL_COUNT_UTILIZZOAPPLICAZIONI_WHERE = "SELECT COUNT(utilizzoApplicazioni) FROM UtilizzoApplicazioni utilizzoApplicazioni WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "utilizzoApplicazioni.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UtilizzoApplicazioni exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UtilizzoApplicazioni exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UtilizzoApplicazioniPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"rowId"
			});
}