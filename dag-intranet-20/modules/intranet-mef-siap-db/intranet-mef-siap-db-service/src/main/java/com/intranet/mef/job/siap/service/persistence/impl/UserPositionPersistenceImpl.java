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

import com.intranet.mef.job.siap.exception.NoSuchUserPositionException;
import com.intranet.mef.job.siap.model.UserPosition;
import com.intranet.mef.job.siap.model.impl.UserPositionImpl;
import com.intranet.mef.job.siap.model.impl.UserPositionModelImpl;
import com.intranet.mef.job.siap.service.persistence.UserPositionPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the user position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPositionPersistence
 * @see com.intranet.mef.job.siap.service.persistence.UserPositionUtil
 * @generated
 */
@ProviderType
public class UserPositionPersistenceImpl extends BasePersistenceImpl<UserPosition>
	implements UserPositionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserPositionUtil} to access the user position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserPositionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
			UserPositionModelImpl.FINDER_CACHE_ENABLED, UserPositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
			UserPositionModelImpl.FINDER_CACHE_ENABLED, UserPositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
			UserPositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UserPositionPersistenceImpl() {
		setModelClass(UserPosition.class);
	}

	/**
	 * Caches the user position in the entity cache if it is enabled.
	 *
	 * @param userPosition the user position
	 */
	@Override
	public void cacheResult(UserPosition userPosition) {
		entityCache.putResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
			UserPositionImpl.class, userPosition.getPrimaryKey(), userPosition);

		userPosition.resetOriginalValues();
	}

	/**
	 * Caches the user positions in the entity cache if it is enabled.
	 *
	 * @param userPositions the user positions
	 */
	@Override
	public void cacheResult(List<UserPosition> userPositions) {
		for (UserPosition userPosition : userPositions) {
			if (entityCache.getResult(
						UserPositionModelImpl.ENTITY_CACHE_ENABLED,
						UserPositionImpl.class, userPosition.getPrimaryKey()) == null) {
				cacheResult(userPosition);
			}
			else {
				userPosition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user positions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserPositionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user position.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserPosition userPosition) {
		entityCache.removeResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
			UserPositionImpl.class, userPosition.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserPosition> userPositions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserPosition userPosition : userPositions) {
			entityCache.removeResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
				UserPositionImpl.class, userPosition.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user position with the primary key. Does not add the user position to the database.
	 *
	 * @param pos the primary key for the new user position
	 * @return the new user position
	 */
	@Override
	public UserPosition create(String pos) {
		UserPosition userPosition = new UserPositionImpl();

		userPosition.setNew(true);
		userPosition.setPrimaryKey(pos);

		return userPosition;
	}

	/**
	 * Removes the user position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pos the primary key of the user position
	 * @return the user position that was removed
	 * @throws NoSuchUserPositionException if a user position with the primary key could not be found
	 */
	@Override
	public UserPosition remove(String pos) throws NoSuchUserPositionException {
		return remove((Serializable)pos);
	}

	/**
	 * Removes the user position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user position
	 * @return the user position that was removed
	 * @throws NoSuchUserPositionException if a user position with the primary key could not be found
	 */
	@Override
	public UserPosition remove(Serializable primaryKey)
		throws NoSuchUserPositionException {
		Session session = null;

		try {
			session = openSession();

			UserPosition userPosition = (UserPosition)session.get(UserPositionImpl.class,
					primaryKey);

			if (userPosition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserPositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userPosition);
		}
		catch (NoSuchUserPositionException nsee) {
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
	protected UserPosition removeImpl(UserPosition userPosition) {
		userPosition = toUnwrappedModel(userPosition);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userPosition)) {
				userPosition = (UserPosition)session.get(UserPositionImpl.class,
						userPosition.getPrimaryKeyObj());
			}

			if (userPosition != null) {
				session.delete(userPosition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userPosition != null) {
			clearCache(userPosition);
		}

		return userPosition;
	}

	@Override
	public UserPosition updateImpl(UserPosition userPosition) {
		userPosition = toUnwrappedModel(userPosition);

		boolean isNew = userPosition.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userPosition.isNew()) {
				session.save(userPosition);

				userPosition.setNew(false);
			}
			else {
				userPosition = (UserPosition)session.merge(userPosition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
			UserPositionImpl.class, userPosition.getPrimaryKey(), userPosition,
			false);

		userPosition.resetOriginalValues();

		return userPosition;
	}

	protected UserPosition toUnwrappedModel(UserPosition userPosition) {
		if (userPosition instanceof UserPositionImpl) {
			return userPosition;
		}

		UserPositionImpl userPositionImpl = new UserPositionImpl();

		userPositionImpl.setNew(userPosition.isNew());
		userPositionImpl.setPrimaryKey(userPosition.getPrimaryKey());

		userPositionImpl.setPos(userPosition.getPos());
		userPositionImpl.setRuoloGiuridico(userPosition.getRuoloGiuridico());
		userPositionImpl.setRuoloEconomico(userPosition.getRuoloEconomico());

		return userPositionImpl;
	}

	/**
	 * Returns the user position with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user position
	 * @return the user position
	 * @throws NoSuchUserPositionException if a user position with the primary key could not be found
	 */
	@Override
	public UserPosition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserPositionException {
		UserPosition userPosition = fetchByPrimaryKey(primaryKey);

		if (userPosition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserPositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userPosition;
	}

	/**
	 * Returns the user position with the primary key or throws a {@link NoSuchUserPositionException} if it could not be found.
	 *
	 * @param pos the primary key of the user position
	 * @return the user position
	 * @throws NoSuchUserPositionException if a user position with the primary key could not be found
	 */
	@Override
	public UserPosition findByPrimaryKey(String pos)
		throws NoSuchUserPositionException {
		return findByPrimaryKey((Serializable)pos);
	}

	/**
	 * Returns the user position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user position
	 * @return the user position, or <code>null</code> if a user position with the primary key could not be found
	 */
	@Override
	public UserPosition fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
				UserPositionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserPosition userPosition = (UserPosition)serializable;

		if (userPosition == null) {
			Session session = null;

			try {
				session = openSession();

				userPosition = (UserPosition)session.get(UserPositionImpl.class,
						primaryKey);

				if (userPosition != null) {
					cacheResult(userPosition);
				}
				else {
					entityCache.putResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
						UserPositionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
					UserPositionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userPosition;
	}

	/**
	 * Returns the user position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pos the primary key of the user position
	 * @return the user position, or <code>null</code> if a user position with the primary key could not be found
	 */
	@Override
	public UserPosition fetchByPrimaryKey(String pos) {
		return fetchByPrimaryKey((Serializable)pos);
	}

	@Override
	public Map<Serializable, UserPosition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserPosition> map = new HashMap<Serializable, UserPosition>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserPosition userPosition = fetchByPrimaryKey(primaryKey);

			if (userPosition != null) {
				map.put(primaryKey, userPosition);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
					UserPositionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserPosition)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_USERPOSITION_WHERE_PKS_IN);

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

			for (UserPosition userPosition : (List<UserPosition>)q.list()) {
				map.put(userPosition.getPrimaryKeyObj(), userPosition);

				cacheResult(userPosition);

				uncachedPrimaryKeys.remove(userPosition.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserPositionModelImpl.ENTITY_CACHE_ENABLED,
					UserPositionImpl.class, primaryKey, nullModel);
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
	 * Returns all the user positions.
	 *
	 * @return the user positions
	 */
	@Override
	public List<UserPosition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user positions
	 * @param end the upper bound of the range of user positions (not inclusive)
	 * @return the range of user positions
	 */
	@Override
	public List<UserPosition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user positions
	 * @param end the upper bound of the range of user positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user positions
	 */
	@Override
	public List<UserPosition> findAll(int start, int end,
		OrderByComparator<UserPosition> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user positions
	 * @param end the upper bound of the range of user positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user positions
	 */
	@Override
	public List<UserPosition> findAll(int start, int end,
		OrderByComparator<UserPosition> orderByComparator,
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

		List<UserPosition> list = null;

		if (retrieveFromCache) {
			list = (List<UserPosition>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPOSITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPOSITION;

				if (pagination) {
					sql = sql.concat(UserPositionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserPosition>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPosition>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user positions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserPosition userPosition : findAll()) {
			remove(userPosition);
		}
	}

	/**
	 * Returns the number of user positions.
	 *
	 * @return the number of user positions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPOSITION);

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
		return UserPositionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user position persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserPositionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERPOSITION = "SELECT userPosition FROM UserPosition userPosition";
	private static final String _SQL_SELECT_USERPOSITION_WHERE_PKS_IN = "SELECT userPosition FROM UserPosition userPosition WHERE INQUADRAMENTO IN (";
	private static final String _SQL_COUNT_USERPOSITION = "SELECT COUNT(userPosition) FROM UserPosition userPosition";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userPosition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserPosition exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(UserPositionPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"pos", "ruoloGiuridico", "ruoloEconomico"
			});
}