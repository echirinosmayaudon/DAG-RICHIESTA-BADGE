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

import com.intranet.mef.job.siap.exception.NoSuchFestivityException;
import com.intranet.mef.job.siap.model.Festivity;
import com.intranet.mef.job.siap.model.impl.FestivityImpl;
import com.intranet.mef.job.siap.model.impl.FestivityModelImpl;
import com.intranet.mef.job.siap.service.persistence.FestivityPersistence;

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
 * The persistence implementation for the festivity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FestivityPersistence
 * @see com.intranet.mef.job.siap.service.persistence.FestivityUtil
 * @generated
 */
@ProviderType
public class FestivityPersistenceImpl extends BasePersistenceImpl<Festivity>
	implements FestivityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FestivityUtil} to access the festivity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FestivityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FestivityModelImpl.ENTITY_CACHE_ENABLED,
			FestivityModelImpl.FINDER_CACHE_ENABLED, FestivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FestivityModelImpl.ENTITY_CACHE_ENABLED,
			FestivityModelImpl.FINDER_CACHE_ENABLED, FestivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FestivityModelImpl.ENTITY_CACHE_ENABLED,
			FestivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FestivityPersistenceImpl() {
		setModelClass(Festivity.class);
	}

	/**
	 * Caches the festivity in the entity cache if it is enabled.
	 *
	 * @param festivity the festivity
	 */
	@Override
	public void cacheResult(Festivity festivity) {
		entityCache.putResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
			FestivityImpl.class, festivity.getPrimaryKey(), festivity);

		festivity.resetOriginalValues();
	}

	/**
	 * Caches the festivities in the entity cache if it is enabled.
	 *
	 * @param festivities the festivities
	 */
	@Override
	public void cacheResult(List<Festivity> festivities) {
		for (Festivity festivity : festivities) {
			if (entityCache.getResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
						FestivityImpl.class, festivity.getPrimaryKey()) == null) {
				cacheResult(festivity);
			}
			else {
				festivity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all festivities.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FestivityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the festivity.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Festivity festivity) {
		entityCache.removeResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
			FestivityImpl.class, festivity.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Festivity> festivities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Festivity festivity : festivities) {
			entityCache.removeResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
				FestivityImpl.class, festivity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new festivity with the primary key. Does not add the festivity to the database.
	 *
	 * @param personId the primary key for the new festivity
	 * @return the new festivity
	 */
	@Override
	public Festivity create(long personId) {
		Festivity festivity = new FestivityImpl();

		festivity.setNew(true);
		festivity.setPrimaryKey(personId);

		return festivity;
	}

	/**
	 * Removes the festivity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personId the primary key of the festivity
	 * @return the festivity that was removed
	 * @throws NoSuchFestivityException if a festivity with the primary key could not be found
	 */
	@Override
	public Festivity remove(long personId) throws NoSuchFestivityException {
		return remove((Serializable)personId);
	}

	/**
	 * Removes the festivity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the festivity
	 * @return the festivity that was removed
	 * @throws NoSuchFestivityException if a festivity with the primary key could not be found
	 */
	@Override
	public Festivity remove(Serializable primaryKey)
		throws NoSuchFestivityException {
		Session session = null;

		try {
			session = openSession();

			Festivity festivity = (Festivity)session.get(FestivityImpl.class,
					primaryKey);

			if (festivity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFestivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(festivity);
		}
		catch (NoSuchFestivityException nsee) {
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
	protected Festivity removeImpl(Festivity festivity) {
		festivity = toUnwrappedModel(festivity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(festivity)) {
				festivity = (Festivity)session.get(FestivityImpl.class,
						festivity.getPrimaryKeyObj());
			}

			if (festivity != null) {
				session.delete(festivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (festivity != null) {
			clearCache(festivity);
		}

		return festivity;
	}

	@Override
	public Festivity updateImpl(Festivity festivity) {
		festivity = toUnwrappedModel(festivity);

		boolean isNew = festivity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (festivity.isNew()) {
				session.save(festivity);

				festivity.setNew(false);
			}
			else {
				festivity = (Festivity)session.merge(festivity);
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

		entityCache.putResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
			FestivityImpl.class, festivity.getPrimaryKey(), festivity, false);

		festivity.resetOriginalValues();

		return festivity;
	}

	protected Festivity toUnwrappedModel(Festivity festivity) {
		if (festivity instanceof FestivityImpl) {
			return festivity;
		}

		FestivityImpl festivityImpl = new FestivityImpl();

		festivityImpl.setNew(festivity.isNew());
		festivityImpl.setPrimaryKey(festivity.getPrimaryKey());

		festivityImpl.setPersonId(festivity.getPersonId());
		festivityImpl.setFestivityDueCurrYear(festivity.getFestivityDueCurrYear());
		festivityImpl.setFestivitySpentCurrYear(festivity.getFestivitySpentCurrYear());
		festivityImpl.setFestivityRemainCurrYear(festivity.getFestivityRemainCurrYear());

		return festivityImpl;
	}

	/**
	 * Returns the festivity with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the festivity
	 * @return the festivity
	 * @throws NoSuchFestivityException if a festivity with the primary key could not be found
	 */
	@Override
	public Festivity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFestivityException {
		Festivity festivity = fetchByPrimaryKey(primaryKey);

		if (festivity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFestivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return festivity;
	}

	/**
	 * Returns the festivity with the primary key or throws a {@link NoSuchFestivityException} if it could not be found.
	 *
	 * @param personId the primary key of the festivity
	 * @return the festivity
	 * @throws NoSuchFestivityException if a festivity with the primary key could not be found
	 */
	@Override
	public Festivity findByPrimaryKey(long personId)
		throws NoSuchFestivityException {
		return findByPrimaryKey((Serializable)personId);
	}

	/**
	 * Returns the festivity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the festivity
	 * @return the festivity, or <code>null</code> if a festivity with the primary key could not be found
	 */
	@Override
	public Festivity fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
				FestivityImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Festivity festivity = (Festivity)serializable;

		if (festivity == null) {
			Session session = null;

			try {
				session = openSession();

				festivity = (Festivity)session.get(FestivityImpl.class,
						primaryKey);

				if (festivity != null) {
					cacheResult(festivity);
				}
				else {
					entityCache.putResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
						FestivityImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
					FestivityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return festivity;
	}

	/**
	 * Returns the festivity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personId the primary key of the festivity
	 * @return the festivity, or <code>null</code> if a festivity with the primary key could not be found
	 */
	@Override
	public Festivity fetchByPrimaryKey(long personId) {
		return fetchByPrimaryKey((Serializable)personId);
	}

	@Override
	public Map<Serializable, Festivity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Festivity> map = new HashMap<Serializable, Festivity>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Festivity festivity = fetchByPrimaryKey(primaryKey);

			if (festivity != null) {
				map.put(primaryKey, festivity);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
					FestivityImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Festivity)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FESTIVITY_WHERE_PKS_IN);

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

			for (Festivity festivity : (List<Festivity>)q.list()) {
				map.put(festivity.getPrimaryKeyObj(), festivity);

				cacheResult(festivity);

				uncachedPrimaryKeys.remove(festivity.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FestivityModelImpl.ENTITY_CACHE_ENABLED,
					FestivityImpl.class, primaryKey, nullModel);
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
	 * Returns all the festivities.
	 *
	 * @return the festivities
	 */
	@Override
	public List<Festivity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the festivities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of festivities
	 * @param end the upper bound of the range of festivities (not inclusive)
	 * @return the range of festivities
	 */
	@Override
	public List<Festivity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the festivities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of festivities
	 * @param end the upper bound of the range of festivities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of festivities
	 */
	@Override
	public List<Festivity> findAll(int start, int end,
		OrderByComparator<Festivity> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the festivities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of festivities
	 * @param end the upper bound of the range of festivities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of festivities
	 */
	@Override
	public List<Festivity> findAll(int start, int end,
		OrderByComparator<Festivity> orderByComparator,
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

		List<Festivity> list = null;

		if (retrieveFromCache) {
			list = (List<Festivity>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FESTIVITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FESTIVITY;

				if (pagination) {
					sql = sql.concat(FestivityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Festivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Festivity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the festivities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Festivity festivity : findAll()) {
			remove(festivity);
		}
	}

	/**
	 * Returns the number of festivities.
	 *
	 * @return the number of festivities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FESTIVITY);

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
		return FestivityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the festivity persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FestivityImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FESTIVITY = "SELECT festivity FROM Festivity festivity";
	private static final String _SQL_SELECT_FESTIVITY_WHERE_PKS_IN = "SELECT festivity FROM Festivity festivity WHERE PERSON_ID IN (";
	private static final String _SQL_COUNT_FESTIVITY = "SELECT COUNT(festivity) FROM Festivity festivity";
	private static final String _ORDER_BY_ENTITY_ALIAS = "festivity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Festivity exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(FestivityPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personId", "festivityDueCurrYear", "festivitySpentCurrYear",
				"festivityRemainCurrYear"
			});
}