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

package servizio.beni.facile.consumo.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

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

import servizio.beni.facile.consumo.exception.NoSuchStatoException;
import servizio.beni.facile.consumo.model.Stato;
import servizio.beni.facile.consumo.model.impl.StatoImpl;
import servizio.beni.facile.consumo.model.impl.StatoModelImpl;
import servizio.beni.facile.consumo.service.persistence.StatoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoPersistence
 * @see servizio.beni.facile.consumo.service.persistence.StatoUtil
 * @generated
 */
@ProviderType
public class StatoPersistenceImpl extends BasePersistenceImpl<Stato>
	implements StatoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatoUtil} to access the stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoModelImpl.FINDER_CACHE_ENABLED, StatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoModelImpl.FINDER_CACHE_ENABLED, StatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StatoPersistenceImpl() {
		setModelClass(Stato.class);
	}

	/**
	 * Caches the stato in the entity cache if it is enabled.
	 *
	 * @param stato the stato
	 */
	@Override
	public void cacheResult(Stato stato) {
		entityCache.putResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoImpl.class, stato.getPrimaryKey(), stato);

		stato.resetOriginalValues();
	}

	/**
	 * Caches the statos in the entity cache if it is enabled.
	 *
	 * @param statos the statos
	 */
	@Override
	public void cacheResult(List<Stato> statos) {
		for (Stato stato : statos) {
			if (entityCache.getResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
						StatoImpl.class, stato.getPrimaryKey()) == null) {
				cacheResult(stato);
			}
			else {
				stato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all statos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stato.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Stato stato) {
		entityCache.removeResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoImpl.class, stato.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Stato> statos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Stato stato : statos) {
			entityCache.removeResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
				StatoImpl.class, stato.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stato with the primary key. Does not add the stato to the database.
	 *
	 * @param id the primary key for the new stato
	 * @return the new stato
	 */
	@Override
	public Stato create(long id) {
		Stato stato = new StatoImpl();

		stato.setNew(true);
		stato.setPrimaryKey(id);

		return stato;
	}

	/**
	 * Removes the stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stato
	 * @return the stato that was removed
	 * @throws NoSuchStatoException if a stato with the primary key could not be found
	 */
	@Override
	public Stato remove(long id) throws NoSuchStatoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato
	 * @return the stato that was removed
	 * @throws NoSuchStatoException if a stato with the primary key could not be found
	 */
	@Override
	public Stato remove(Serializable primaryKey) throws NoSuchStatoException {
		Session session = null;

		try {
			session = openSession();

			Stato stato = (Stato)session.get(StatoImpl.class, primaryKey);

			if (stato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(stato);
		}
		catch (NoSuchStatoException nsee) {
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
	protected Stato removeImpl(Stato stato) {
		stato = toUnwrappedModel(stato);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stato)) {
				stato = (Stato)session.get(StatoImpl.class,
						stato.getPrimaryKeyObj());
			}

			if (stato != null) {
				session.delete(stato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (stato != null) {
			clearCache(stato);
		}

		return stato;
	}

	@Override
	public Stato updateImpl(Stato stato) {
		stato = toUnwrappedModel(stato);

		boolean isNew = stato.isNew();

		Session session = null;

		try {
			session = openSession();

			if (stato.isNew()) {
				session.save(stato);

				stato.setNew(false);
			}
			else {
				stato = (Stato)session.merge(stato);
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

		entityCache.putResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoImpl.class, stato.getPrimaryKey(), stato, false);

		stato.resetOriginalValues();

		return stato;
	}

	protected Stato toUnwrappedModel(Stato stato) {
		if (stato instanceof StatoImpl) {
			return stato;
		}

		StatoImpl statoImpl = new StatoImpl();

		statoImpl.setNew(stato.isNew());
		statoImpl.setPrimaryKey(stato.getPrimaryKey());

		statoImpl.setId(stato.getId());
		statoImpl.setDescrizione(stato.getDescrizione());

		return statoImpl;
	}

	/**
	 * Returns the stato with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato
	 * @return the stato
	 * @throws NoSuchStatoException if a stato with the primary key could not be found
	 */
	@Override
	public Stato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoException {
		Stato stato = fetchByPrimaryKey(primaryKey);

		if (stato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return stato;
	}

	/**
	 * Returns the stato with the primary key or throws a {@link NoSuchStatoException} if it could not be found.
	 *
	 * @param id the primary key of the stato
	 * @return the stato
	 * @throws NoSuchStatoException if a stato with the primary key could not be found
	 */
	@Override
	public Stato findByPrimaryKey(long id) throws NoSuchStatoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato
	 * @return the stato, or <code>null</code> if a stato with the primary key could not be found
	 */
	@Override
	public Stato fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
				StatoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Stato stato = (Stato)serializable;

		if (stato == null) {
			Session session = null;

			try {
				session = openSession();

				stato = (Stato)session.get(StatoImpl.class, primaryKey);

				if (stato != null) {
					cacheResult(stato);
				}
				else {
					entityCache.putResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
						StatoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
					StatoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return stato;
	}

	/**
	 * Returns the stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stato
	 * @return the stato, or <code>null</code> if a stato with the primary key could not be found
	 */
	@Override
	public Stato fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Stato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Stato> map = new HashMap<Serializable, Stato>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Stato stato = fetchByPrimaryKey(primaryKey);

			if (stato != null) {
				map.put(primaryKey, stato);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
					StatoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Stato)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STATO_WHERE_PKS_IN);

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

			for (Stato stato : (List<Stato>)q.list()) {
				map.put(stato.getPrimaryKeyObj(), stato);

				cacheResult(stato);

				uncachedPrimaryKeys.remove(stato.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StatoModelImpl.ENTITY_CACHE_ENABLED,
					StatoImpl.class, primaryKey, nullModel);
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
	 * Returns all the statos.
	 *
	 * @return the statos
	 */
	@Override
	public List<Stato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statos
	 * @param end the upper bound of the range of statos (not inclusive)
	 * @return the range of statos
	 */
	@Override
	public List<Stato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statos
	 * @param end the upper bound of the range of statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of statos
	 */
	@Override
	public List<Stato> findAll(int start, int end,
		OrderByComparator<Stato> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statos
	 * @param end the upper bound of the range of statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of statos
	 */
	@Override
	public List<Stato> findAll(int start, int end,
		OrderByComparator<Stato> orderByComparator, boolean retrieveFromCache) {
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

		List<Stato> list = null;

		if (retrieveFromCache) {
			list = (List<Stato>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATO;

				if (pagination) {
					sql = sql.concat(StatoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Stato>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Stato>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the statos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Stato stato : findAll()) {
			remove(stato);
		}
	}

	/**
	 * Returns the number of statos.
	 *
	 * @return the number of statos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATO);

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
		return StatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StatoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STATO = "SELECT stato FROM Stato stato";
	private static final String _SQL_SELECT_STATO_WHERE_PKS_IN = "SELECT stato FROM Stato stato WHERE id_ IN (";
	private static final String _SQL_COUNT_STATO = "SELECT COUNT(stato) FROM Stato stato";
	private static final String _ORDER_BY_ENTITY_ALIAS = "stato.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Stato exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(StatoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}