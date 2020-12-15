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

package bookmarks.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import bookmarks.exception.NoSuchFavouritesException;

import bookmarks.model.Favourites;

import bookmarks.model.impl.FavouritesImpl;
import bookmarks.model.impl.FavouritesModelImpl;

import bookmarks.service.persistence.FavouritesPersistence;

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
 * The persistence implementation for the favourites service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesPersistence
 * @see bookmarks.service.persistence.FavouritesUtil
 * @generated
 */
@ProviderType
public class FavouritesPersistenceImpl extends BasePersistenceImpl<Favourites>
	implements FavouritesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FavouritesUtil} to access the favourites persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FavouritesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesModelImpl.FINDER_CACHE_ENABLED, FavouritesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesModelImpl.FINDER_CACHE_ENABLED, FavouritesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FAVOURITES =
		new FinderPath(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesModelImpl.FINDER_CACHE_ENABLED, FavouritesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFavourites",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAVOURITES =
		new FinderPath(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesModelImpl.FINDER_CACHE_ENABLED, FavouritesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFavourites",
			new String[] { Long.class.getName() },
			FavouritesModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FAVOURITES = new FinderPath(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFavourites",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the favouriteses where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the matching favouriteses
	 */
	@Override
	public List<Favourites> findByFavourites(long user_id) {
		return findByFavourites(user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the favouriteses where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of favouriteses
	 * @param end the upper bound of the range of favouriteses (not inclusive)
	 * @return the range of matching favouriteses
	 */
	@Override
	public List<Favourites> findByFavourites(long user_id, int start, int end) {
		return findByFavourites(user_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the favouriteses where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of favouriteses
	 * @param end the upper bound of the range of favouriteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favouriteses
	 */
	@Override
	public List<Favourites> findByFavourites(long user_id, int start, int end,
		OrderByComparator<Favourites> orderByComparator) {
		return findByFavourites(user_id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the favouriteses where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of favouriteses
	 * @param end the upper bound of the range of favouriteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching favouriteses
	 */
	@Override
	public List<Favourites> findByFavourites(long user_id, int start, int end,
		OrderByComparator<Favourites> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAVOURITES;
			finderArgs = new Object[] { user_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FAVOURITES;
			finderArgs = new Object[] { user_id, start, end, orderByComparator };
		}

		List<Favourites> list = null;

		if (retrieveFromCache) {
			list = (List<Favourites>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Favourites favourites : list) {
					if ((user_id != favourites.getUser_id())) {
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

			query.append(_SQL_SELECT_FAVOURITES_WHERE);

			query.append(_FINDER_COLUMN_FAVOURITES_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FavouritesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				if (!pagination) {
					list = (List<Favourites>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Favourites>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first favourites in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favourites
	 * @throws NoSuchFavouritesException if a matching favourites could not be found
	 */
	@Override
	public Favourites findByFavourites_First(long user_id,
		OrderByComparator<Favourites> orderByComparator)
		throws NoSuchFavouritesException {
		Favourites favourites = fetchByFavourites_First(user_id,
				orderByComparator);

		if (favourites != null) {
			return favourites;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFavouritesException(msg.toString());
	}

	/**
	 * Returns the first favourites in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favourites, or <code>null</code> if a matching favourites could not be found
	 */
	@Override
	public Favourites fetchByFavourites_First(long user_id,
		OrderByComparator<Favourites> orderByComparator) {
		List<Favourites> list = findByFavourites(user_id, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last favourites in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favourites
	 * @throws NoSuchFavouritesException if a matching favourites could not be found
	 */
	@Override
	public Favourites findByFavourites_Last(long user_id,
		OrderByComparator<Favourites> orderByComparator)
		throws NoSuchFavouritesException {
		Favourites favourites = fetchByFavourites_Last(user_id,
				orderByComparator);

		if (favourites != null) {
			return favourites;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFavouritesException(msg.toString());
	}

	/**
	 * Returns the last favourites in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favourites, or <code>null</code> if a matching favourites could not be found
	 */
	@Override
	public Favourites fetchByFavourites_Last(long user_id,
		OrderByComparator<Favourites> orderByComparator) {
		int count = countByFavourites(user_id);

		if (count == 0) {
			return null;
		}

		List<Favourites> list = findByFavourites(user_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the favouriteses before and after the current favourites in the ordered set where user_id = &#63;.
	 *
	 * @param favourite_id the primary key of the current favourites
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favourites
	 * @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	 */
	@Override
	public Favourites[] findByFavourites_PrevAndNext(long favourite_id,
		long user_id, OrderByComparator<Favourites> orderByComparator)
		throws NoSuchFavouritesException {
		Favourites favourites = findByPrimaryKey(favourite_id);

		Session session = null;

		try {
			session = openSession();

			Favourites[] array = new FavouritesImpl[3];

			array[0] = getByFavourites_PrevAndNext(session, favourites,
					user_id, orderByComparator, true);

			array[1] = favourites;

			array[2] = getByFavourites_PrevAndNext(session, favourites,
					user_id, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Favourites getByFavourites_PrevAndNext(Session session,
		Favourites favourites, long user_id,
		OrderByComparator<Favourites> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAVOURITES_WHERE);

		query.append(_FINDER_COLUMN_FAVOURITES_USER_ID_2);

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
			query.append(FavouritesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(favourites);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Favourites> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the favouriteses where user_id = &#63; from the database.
	 *
	 * @param user_id the user_id
	 */
	@Override
	public void removeByFavourites(long user_id) {
		for (Favourites favourites : findByFavourites(user_id,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(favourites);
		}
	}

	/**
	 * Returns the number of favouriteses where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the number of matching favouriteses
	 */
	@Override
	public int countByFavourites(long user_id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FAVOURITES;

		Object[] finderArgs = new Object[] { user_id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAVOURITES_WHERE);

			query.append(_FINDER_COLUMN_FAVOURITES_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

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

	private static final String _FINDER_COLUMN_FAVOURITES_USER_ID_2 = "favourites.user_id = ?";

	public FavouritesPersistenceImpl() {
		setModelClass(Favourites.class);
	}

	/**
	 * Caches the favourites in the entity cache if it is enabled.
	 *
	 * @param favourites the favourites
	 */
	@Override
	public void cacheResult(Favourites favourites) {
		entityCache.putResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesImpl.class, favourites.getPrimaryKey(), favourites);

		favourites.resetOriginalValues();
	}

	/**
	 * Caches the favouriteses in the entity cache if it is enabled.
	 *
	 * @param favouriteses the favouriteses
	 */
	@Override
	public void cacheResult(List<Favourites> favouriteses) {
		for (Favourites favourites : favouriteses) {
			if (entityCache.getResult(
						FavouritesModelImpl.ENTITY_CACHE_ENABLED,
						FavouritesImpl.class, favourites.getPrimaryKey()) == null) {
				cacheResult(favourites);
			}
			else {
				favourites.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all favouriteses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FavouritesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the favourites.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Favourites favourites) {
		entityCache.removeResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesImpl.class, favourites.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Favourites> favouriteses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Favourites favourites : favouriteses) {
			entityCache.removeResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
				FavouritesImpl.class, favourites.getPrimaryKey());
		}
	}

	/**
	 * Creates a new favourites with the primary key. Does not add the favourites to the database.
	 *
	 * @param favourite_id the primary key for the new favourites
	 * @return the new favourites
	 */
	@Override
	public Favourites create(long favourite_id) {
		Favourites favourites = new FavouritesImpl();

		favourites.setNew(true);
		favourites.setPrimaryKey(favourite_id);

		return favourites;
	}

	/**
	 * Removes the favourites with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param favourite_id the primary key of the favourites
	 * @return the favourites that was removed
	 * @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	 */
	@Override
	public Favourites remove(long favourite_id)
		throws NoSuchFavouritesException {
		return remove((Serializable)favourite_id);
	}

	/**
	 * Removes the favourites with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the favourites
	 * @return the favourites that was removed
	 * @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	 */
	@Override
	public Favourites remove(Serializable primaryKey)
		throws NoSuchFavouritesException {
		Session session = null;

		try {
			session = openSession();

			Favourites favourites = (Favourites)session.get(FavouritesImpl.class,
					primaryKey);

			if (favourites == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFavouritesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(favourites);
		}
		catch (NoSuchFavouritesException nsee) {
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
	protected Favourites removeImpl(Favourites favourites) {
		favourites = toUnwrappedModel(favourites);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(favourites)) {
				favourites = (Favourites)session.get(FavouritesImpl.class,
						favourites.getPrimaryKeyObj());
			}

			if (favourites != null) {
				session.delete(favourites);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (favourites != null) {
			clearCache(favourites);
		}

		return favourites;
	}

	@Override
	public Favourites updateImpl(Favourites favourites) {
		favourites = toUnwrappedModel(favourites);

		boolean isNew = favourites.isNew();

		FavouritesModelImpl favouritesModelImpl = (FavouritesModelImpl)favourites;

		Session session = null;

		try {
			session = openSession();

			if (favourites.isNew()) {
				session.save(favourites);

				favourites.setNew(false);
			}
			else {
				favourites = (Favourites)session.merge(favourites);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FavouritesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((favouritesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAVOURITES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						favouritesModelImpl.getOriginalUser_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FAVOURITES, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAVOURITES,
					args);

				args = new Object[] { favouritesModelImpl.getUser_id() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FAVOURITES, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAVOURITES,
					args);
			}
		}

		entityCache.putResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
			FavouritesImpl.class, favourites.getPrimaryKey(), favourites, false);

		favourites.resetOriginalValues();

		return favourites;
	}

	protected Favourites toUnwrappedModel(Favourites favourites) {
		if (favourites instanceof FavouritesImpl) {
			return favourites;
		}

		FavouritesImpl favouritesImpl = new FavouritesImpl();

		favouritesImpl.setNew(favourites.isNew());
		favouritesImpl.setPrimaryKey(favourites.getPrimaryKey());

		favouritesImpl.setFavourite_id(favourites.getFavourite_id());
		favouritesImpl.setUser_id(favourites.getUser_id());
		favouritesImpl.setTitle_favourite(favourites.getTitle_favourite());
		favouritesImpl.setDescription_favourite(favourites.getDescription_favourite());
		favouritesImpl.setTag_favourite(favourites.getTag_favourite());
		favouritesImpl.setUrl_favourite(favourites.getUrl_favourite());
		favouritesImpl.setSave_date(favourites.getSave_date());

		return favouritesImpl;
	}

	/**
	 * Returns the favourites with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the favourites
	 * @return the favourites
	 * @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	 */
	@Override
	public Favourites findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFavouritesException {
		Favourites favourites = fetchByPrimaryKey(primaryKey);

		if (favourites == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFavouritesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return favourites;
	}

	/**
	 * Returns the favourites with the primary key or throws a {@link NoSuchFavouritesException} if it could not be found.
	 *
	 * @param favourite_id the primary key of the favourites
	 * @return the favourites
	 * @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	 */
	@Override
	public Favourites findByPrimaryKey(long favourite_id)
		throws NoSuchFavouritesException {
		return findByPrimaryKey((Serializable)favourite_id);
	}

	/**
	 * Returns the favourites with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the favourites
	 * @return the favourites, or <code>null</code> if a favourites with the primary key could not be found
	 */
	@Override
	public Favourites fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
				FavouritesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Favourites favourites = (Favourites)serializable;

		if (favourites == null) {
			Session session = null;

			try {
				session = openSession();

				favourites = (Favourites)session.get(FavouritesImpl.class,
						primaryKey);

				if (favourites != null) {
					cacheResult(favourites);
				}
				else {
					entityCache.putResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
						FavouritesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
					FavouritesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return favourites;
	}

	/**
	 * Returns the favourites with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param favourite_id the primary key of the favourites
	 * @return the favourites, or <code>null</code> if a favourites with the primary key could not be found
	 */
	@Override
	public Favourites fetchByPrimaryKey(long favourite_id) {
		return fetchByPrimaryKey((Serializable)favourite_id);
	}

	@Override
	public Map<Serializable, Favourites> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Favourites> map = new HashMap<Serializable, Favourites>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Favourites favourites = fetchByPrimaryKey(primaryKey);

			if (favourites != null) {
				map.put(primaryKey, favourites);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
					FavouritesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Favourites)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FAVOURITES_WHERE_PKS_IN);

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

			for (Favourites favourites : (List<Favourites>)q.list()) {
				map.put(favourites.getPrimaryKeyObj(), favourites);

				cacheResult(favourites);

				uncachedPrimaryKeys.remove(favourites.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FavouritesModelImpl.ENTITY_CACHE_ENABLED,
					FavouritesImpl.class, primaryKey, nullModel);
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
	 * Returns all the favouriteses.
	 *
	 * @return the favouriteses
	 */
	@Override
	public List<Favourites> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the favouriteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of favouriteses
	 * @param end the upper bound of the range of favouriteses (not inclusive)
	 * @return the range of favouriteses
	 */
	@Override
	public List<Favourites> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the favouriteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of favouriteses
	 * @param end the upper bound of the range of favouriteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of favouriteses
	 */
	@Override
	public List<Favourites> findAll(int start, int end,
		OrderByComparator<Favourites> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the favouriteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of favouriteses
	 * @param end the upper bound of the range of favouriteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of favouriteses
	 */
	@Override
	public List<Favourites> findAll(int start, int end,
		OrderByComparator<Favourites> orderByComparator,
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

		List<Favourites> list = null;

		if (retrieveFromCache) {
			list = (List<Favourites>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FAVOURITES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAVOURITES;

				if (pagination) {
					sql = sql.concat(FavouritesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Favourites>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Favourites>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the favouriteses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Favourites favourites : findAll()) {
			remove(favourites);
		}
	}

	/**
	 * Returns the number of favouriteses.
	 *
	 * @return the number of favouriteses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAVOURITES);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return FavouritesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the favourites persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FavouritesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FAVOURITES = "SELECT favourites FROM Favourites favourites";
	private static final String _SQL_SELECT_FAVOURITES_WHERE_PKS_IN = "SELECT favourites FROM Favourites favourites WHERE favourite_id IN (";
	private static final String _SQL_SELECT_FAVOURITES_WHERE = "SELECT favourites FROM Favourites favourites WHERE ";
	private static final String _SQL_COUNT_FAVOURITES = "SELECT COUNT(favourites) FROM Favourites favourites";
	private static final String _SQL_COUNT_FAVOURITES_WHERE = "SELECT COUNT(favourites) FROM Favourites favourites WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "favourites.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Favourites exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Favourites exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FavouritesPersistenceImpl.class);
}