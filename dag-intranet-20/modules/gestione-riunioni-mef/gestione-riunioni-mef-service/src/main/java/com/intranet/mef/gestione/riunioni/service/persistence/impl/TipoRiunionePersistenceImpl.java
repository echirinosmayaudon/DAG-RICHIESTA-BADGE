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

package com.intranet.mef.gestione.riunioni.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.exception.NoSuchTipoRiunioneException;
import com.intranet.mef.gestione.riunioni.model.TipoRiunione;
import com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneImpl;
import com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.TipoRiunionePersistence;

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
 * The persistence implementation for the tipo riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.TipoRiunioneUtil
 * @generated
 */
@ProviderType
public class TipoRiunionePersistenceImpl extends BasePersistenceImpl<TipoRiunione>
	implements TipoRiunionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipoRiunioneUtil} to access the tipo riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipoRiunioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			TipoRiunioneModelImpl.FINDER_CACHE_ENABLED, TipoRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			TipoRiunioneModelImpl.FINDER_CACHE_ENABLED, TipoRiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			TipoRiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TipoRiunionePersistenceImpl() {
		setModelClass(TipoRiunione.class);
	}

	/**
	 * Caches the tipo riunione in the entity cache if it is enabled.
	 *
	 * @param tipoRiunione the tipo riunione
	 */
	@Override
	public void cacheResult(TipoRiunione tipoRiunione) {
		entityCache.putResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			TipoRiunioneImpl.class, tipoRiunione.getPrimaryKey(), tipoRiunione);

		tipoRiunione.resetOriginalValues();
	}

	/**
	 * Caches the tipo riuniones in the entity cache if it is enabled.
	 *
	 * @param tipoRiuniones the tipo riuniones
	 */
	@Override
	public void cacheResult(List<TipoRiunione> tipoRiuniones) {
		for (TipoRiunione tipoRiunione : tipoRiuniones) {
			if (entityCache.getResult(
						TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						TipoRiunioneImpl.class, tipoRiunione.getPrimaryKey()) == null) {
				cacheResult(tipoRiunione);
			}
			else {
				tipoRiunione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipo riuniones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipoRiunioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipo riunione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipoRiunione tipoRiunione) {
		entityCache.removeResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			TipoRiunioneImpl.class, tipoRiunione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipoRiunione> tipoRiuniones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipoRiunione tipoRiunione : tipoRiuniones) {
			entityCache.removeResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				TipoRiunioneImpl.class, tipoRiunione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipo riunione with the primary key. Does not add the tipo riunione to the database.
	 *
	 * @param id_tipo the primary key for the new tipo riunione
	 * @return the new tipo riunione
	 */
	@Override
	public TipoRiunione create(long id_tipo) {
		TipoRiunione tipoRiunione = new TipoRiunioneImpl();

		tipoRiunione.setNew(true);
		tipoRiunione.setPrimaryKey(id_tipo);

		return tipoRiunione;
	}

	/**
	 * Removes the tipo riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_tipo the primary key of the tipo riunione
	 * @return the tipo riunione that was removed
	 * @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	 */
	@Override
	public TipoRiunione remove(long id_tipo) throws NoSuchTipoRiunioneException {
		return remove((Serializable)id_tipo);
	}

	/**
	 * Removes the tipo riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo riunione
	 * @return the tipo riunione that was removed
	 * @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	 */
	@Override
	public TipoRiunione remove(Serializable primaryKey)
		throws NoSuchTipoRiunioneException {
		Session session = null;

		try {
			session = openSession();

			TipoRiunione tipoRiunione = (TipoRiunione)session.get(TipoRiunioneImpl.class,
					primaryKey);

			if (tipoRiunione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipoRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipoRiunione);
		}
		catch (NoSuchTipoRiunioneException nsee) {
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
	protected TipoRiunione removeImpl(TipoRiunione tipoRiunione) {
		tipoRiunione = toUnwrappedModel(tipoRiunione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipoRiunione)) {
				tipoRiunione = (TipoRiunione)session.get(TipoRiunioneImpl.class,
						tipoRiunione.getPrimaryKeyObj());
			}

			if (tipoRiunione != null) {
				session.delete(tipoRiunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipoRiunione != null) {
			clearCache(tipoRiunione);
		}

		return tipoRiunione;
	}

	@Override
	public TipoRiunione updateImpl(TipoRiunione tipoRiunione) {
		tipoRiunione = toUnwrappedModel(tipoRiunione);

		boolean isNew = tipoRiunione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipoRiunione.isNew()) {
				session.save(tipoRiunione);

				tipoRiunione.setNew(false);
			}
			else {
				tipoRiunione = (TipoRiunione)session.merge(tipoRiunione);
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

		entityCache.putResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
			TipoRiunioneImpl.class, tipoRiunione.getPrimaryKey(), tipoRiunione,
			false);

		tipoRiunione.resetOriginalValues();

		return tipoRiunione;
	}

	protected TipoRiunione toUnwrappedModel(TipoRiunione tipoRiunione) {
		if (tipoRiunione instanceof TipoRiunioneImpl) {
			return tipoRiunione;
		}

		TipoRiunioneImpl tipoRiunioneImpl = new TipoRiunioneImpl();

		tipoRiunioneImpl.setNew(tipoRiunione.isNew());
		tipoRiunioneImpl.setPrimaryKey(tipoRiunione.getPrimaryKey());

		tipoRiunioneImpl.setId_tipo(tipoRiunione.getId_tipo());
		tipoRiunioneImpl.setDescrizione(tipoRiunione.getDescrizione());

		return tipoRiunioneImpl;
	}

	/**
	 * Returns the tipo riunione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo riunione
	 * @return the tipo riunione
	 * @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	 */
	@Override
	public TipoRiunione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipoRiunioneException {
		TipoRiunione tipoRiunione = fetchByPrimaryKey(primaryKey);

		if (tipoRiunione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipoRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipoRiunione;
	}

	/**
	 * Returns the tipo riunione with the primary key or throws a {@link NoSuchTipoRiunioneException} if it could not be found.
	 *
	 * @param id_tipo the primary key of the tipo riunione
	 * @return the tipo riunione
	 * @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	 */
	@Override
	public TipoRiunione findByPrimaryKey(long id_tipo)
		throws NoSuchTipoRiunioneException {
		return findByPrimaryKey((Serializable)id_tipo);
	}

	/**
	 * Returns the tipo riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo riunione
	 * @return the tipo riunione, or <code>null</code> if a tipo riunione with the primary key could not be found
	 */
	@Override
	public TipoRiunione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
				TipoRiunioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipoRiunione tipoRiunione = (TipoRiunione)serializable;

		if (tipoRiunione == null) {
			Session session = null;

			try {
				session = openSession();

				tipoRiunione = (TipoRiunione)session.get(TipoRiunioneImpl.class,
						primaryKey);

				if (tipoRiunione != null) {
					cacheResult(tipoRiunione);
				}
				else {
					entityCache.putResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
						TipoRiunioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					TipoRiunioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipoRiunione;
	}

	/**
	 * Returns the tipo riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_tipo the primary key of the tipo riunione
	 * @return the tipo riunione, or <code>null</code> if a tipo riunione with the primary key could not be found
	 */
	@Override
	public TipoRiunione fetchByPrimaryKey(long id_tipo) {
		return fetchByPrimaryKey((Serializable)id_tipo);
	}

	@Override
	public Map<Serializable, TipoRiunione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipoRiunione> map = new HashMap<Serializable, TipoRiunione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipoRiunione tipoRiunione = fetchByPrimaryKey(primaryKey);

			if (tipoRiunione != null) {
				map.put(primaryKey, tipoRiunione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					TipoRiunioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipoRiunione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPORIUNIONE_WHERE_PKS_IN);

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

			for (TipoRiunione tipoRiunione : (List<TipoRiunione>)q.list()) {
				map.put(tipoRiunione.getPrimaryKeyObj(), tipoRiunione);

				cacheResult(tipoRiunione);

				uncachedPrimaryKeys.remove(tipoRiunione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipoRiunioneModelImpl.ENTITY_CACHE_ENABLED,
					TipoRiunioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the tipo riuniones.
	 *
	 * @return the tipo riuniones
	 */
	@Override
	public List<TipoRiunione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo riuniones
	 * @param end the upper bound of the range of tipo riuniones (not inclusive)
	 * @return the range of tipo riuniones
	 */
	@Override
	public List<TipoRiunione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo riuniones
	 * @param end the upper bound of the range of tipo riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo riuniones
	 */
	@Override
	public List<TipoRiunione> findAll(int start, int end,
		OrderByComparator<TipoRiunione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo riuniones
	 * @param end the upper bound of the range of tipo riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tipo riuniones
	 */
	@Override
	public List<TipoRiunione> findAll(int start, int end,
		OrderByComparator<TipoRiunione> orderByComparator,
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

		List<TipoRiunione> list = null;

		if (retrieveFromCache) {
			list = (List<TipoRiunione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPORIUNIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPORIUNIONE;

				if (pagination) {
					sql = sql.concat(TipoRiunioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipoRiunione>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipoRiunione>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tipo riuniones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipoRiunione tipoRiunione : findAll()) {
			remove(tipoRiunione);
		}
	}

	/**
	 * Returns the number of tipo riuniones.
	 *
	 * @return the number of tipo riuniones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPORIUNIONE);

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
		return TipoRiunioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipo riunione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipoRiunioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPORIUNIONE = "SELECT tipoRiunione FROM TipoRiunione tipoRiunione";
	private static final String _SQL_SELECT_TIPORIUNIONE_WHERE_PKS_IN = "SELECT tipoRiunione FROM TipoRiunione tipoRiunione WHERE id_tipo IN (";
	private static final String _SQL_COUNT_TIPORIUNIONE = "SELECT COUNT(tipoRiunione) FROM TipoRiunione tipoRiunione";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipoRiunione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipoRiunione exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TipoRiunionePersistenceImpl.class);
}