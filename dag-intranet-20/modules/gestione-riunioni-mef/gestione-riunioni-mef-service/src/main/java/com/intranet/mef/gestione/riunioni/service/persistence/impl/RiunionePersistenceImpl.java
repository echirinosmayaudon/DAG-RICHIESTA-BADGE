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

import com.intranet.mef.gestione.riunioni.exception.NoSuchRiunioneException;
import com.intranet.mef.gestione.riunioni.model.Riunione;
import com.intranet.mef.gestione.riunioni.model.impl.RiunioneImpl;
import com.intranet.mef.gestione.riunioni.model.impl.RiunioneModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.RiunionePersistence;

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
 * The persistence implementation for the riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.RiunioneUtil
 * @generated
 */
@ProviderType
public class RiunionePersistenceImpl extends BasePersistenceImpl<Riunione>
	implements RiunionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RiunioneUtil} to access the riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RiunioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
			RiunioneModelImpl.FINDER_CACHE_ENABLED, RiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
			RiunioneModelImpl.FINDER_CACHE_ENABLED, RiunioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
			RiunioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RiunionePersistenceImpl() {
		setModelClass(Riunione.class);
	}

	/**
	 * Caches the riunione in the entity cache if it is enabled.
	 *
	 * @param riunione the riunione
	 */
	@Override
	public void cacheResult(Riunione riunione) {
		entityCache.putResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
			RiunioneImpl.class, riunione.getPrimaryKey(), riunione);

		riunione.resetOriginalValues();
	}

	/**
	 * Caches the riuniones in the entity cache if it is enabled.
	 *
	 * @param riuniones the riuniones
	 */
	@Override
	public void cacheResult(List<Riunione> riuniones) {
		for (Riunione riunione : riuniones) {
			if (entityCache.getResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
						RiunioneImpl.class, riunione.getPrimaryKey()) == null) {
				cacheResult(riunione);
			}
			else {
				riunione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all riuniones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RiunioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the riunione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Riunione riunione) {
		entityCache.removeResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
			RiunioneImpl.class, riunione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Riunione> riuniones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Riunione riunione : riuniones) {
			entityCache.removeResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
				RiunioneImpl.class, riunione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new riunione with the primary key. Does not add the riunione to the database.
	 *
	 * @param id_riunione the primary key for the new riunione
	 * @return the new riunione
	 */
	@Override
	public Riunione create(long id_riunione) {
		Riunione riunione = new RiunioneImpl();

		riunione.setNew(true);
		riunione.setPrimaryKey(id_riunione);

		return riunione;
	}

	/**
	 * Removes the riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_riunione the primary key of the riunione
	 * @return the riunione that was removed
	 * @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	 */
	@Override
	public Riunione remove(long id_riunione) throws NoSuchRiunioneException {
		return remove((Serializable)id_riunione);
	}

	/**
	 * Removes the riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the riunione
	 * @return the riunione that was removed
	 * @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	 */
	@Override
	public Riunione remove(Serializable primaryKey)
		throws NoSuchRiunioneException {
		Session session = null;

		try {
			session = openSession();

			Riunione riunione = (Riunione)session.get(RiunioneImpl.class,
					primaryKey);

			if (riunione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(riunione);
		}
		catch (NoSuchRiunioneException nsee) {
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
	protected Riunione removeImpl(Riunione riunione) {
		riunione = toUnwrappedModel(riunione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(riunione)) {
				riunione = (Riunione)session.get(RiunioneImpl.class,
						riunione.getPrimaryKeyObj());
			}

			if (riunione != null) {
				session.delete(riunione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (riunione != null) {
			clearCache(riunione);
		}

		return riunione;
	}

	@Override
	public Riunione updateImpl(Riunione riunione) {
		riunione = toUnwrappedModel(riunione);

		boolean isNew = riunione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (riunione.isNew()) {
				session.save(riunione);

				riunione.setNew(false);
			}
			else {
				riunione = (Riunione)session.merge(riunione);
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

		entityCache.putResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
			RiunioneImpl.class, riunione.getPrimaryKey(), riunione, false);

		riunione.resetOriginalValues();

		return riunione;
	}

	protected Riunione toUnwrappedModel(Riunione riunione) {
		if (riunione instanceof RiunioneImpl) {
			return riunione;
		}

		RiunioneImpl riunioneImpl = new RiunioneImpl();

		riunioneImpl.setNew(riunione.isNew());
		riunioneImpl.setPrimaryKey(riunione.getPrimaryKey());

		riunioneImpl.setId_riunione(riunione.getId_riunione());
		riunioneImpl.setOggetto(riunione.getOggetto());
		riunioneImpl.setData_inizio(riunione.getData_inizio());
		riunioneImpl.setData_fine(riunione.getData_fine());
		riunioneImpl.setNote(riunione.getNote());
		riunioneImpl.setData_modifica(riunione.getData_modifica());
		riunioneImpl.setData_creazione(riunione.getData_creazione());
		riunioneImpl.setProtocollo(riunione.getProtocollo());
		riunioneImpl.setId_stato_riunione(riunione.getId_stato_riunione());
		riunioneImpl.setId_tipo(riunione.getId_tipo());
		riunioneImpl.setId_luogo(riunione.getId_luogo());
		riunioneImpl.setId_amministrazione_convocante(riunione.getId_amministrazione_convocante());
		riunioneImpl.setData_ultimo_sollecito(riunione.getData_ultimo_sollecito());

		return riunioneImpl;
	}

	/**
	 * Returns the riunione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the riunione
	 * @return the riunione
	 * @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	 */
	@Override
	public Riunione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRiunioneException {
		Riunione riunione = fetchByPrimaryKey(primaryKey);

		if (riunione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRiunioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return riunione;
	}

	/**
	 * Returns the riunione with the primary key or throws a {@link NoSuchRiunioneException} if it could not be found.
	 *
	 * @param id_riunione the primary key of the riunione
	 * @return the riunione
	 * @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	 */
	@Override
	public Riunione findByPrimaryKey(long id_riunione)
		throws NoSuchRiunioneException {
		return findByPrimaryKey((Serializable)id_riunione);
	}

	/**
	 * Returns the riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the riunione
	 * @return the riunione, or <code>null</code> if a riunione with the primary key could not be found
	 */
	@Override
	public Riunione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
				RiunioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Riunione riunione = (Riunione)serializable;

		if (riunione == null) {
			Session session = null;

			try {
				session = openSession();

				riunione = (Riunione)session.get(RiunioneImpl.class, primaryKey);

				if (riunione != null) {
					cacheResult(riunione);
				}
				else {
					entityCache.putResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
						RiunioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
					RiunioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return riunione;
	}

	/**
	 * Returns the riunione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_riunione the primary key of the riunione
	 * @return the riunione, or <code>null</code> if a riunione with the primary key could not be found
	 */
	@Override
	public Riunione fetchByPrimaryKey(long id_riunione) {
		return fetchByPrimaryKey((Serializable)id_riunione);
	}

	@Override
	public Map<Serializable, Riunione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Riunione> map = new HashMap<Serializable, Riunione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Riunione riunione = fetchByPrimaryKey(primaryKey);

			if (riunione != null) {
				map.put(primaryKey, riunione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
					RiunioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Riunione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RIUNIONE_WHERE_PKS_IN);

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

			for (Riunione riunione : (List<Riunione>)q.list()) {
				map.put(riunione.getPrimaryKeyObj(), riunione);

				cacheResult(riunione);

				uncachedPrimaryKeys.remove(riunione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RiunioneModelImpl.ENTITY_CACHE_ENABLED,
					RiunioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the riuniones.
	 *
	 * @return the riuniones
	 */
	@Override
	public List<Riunione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of riuniones
	 * @param end the upper bound of the range of riuniones (not inclusive)
	 * @return the range of riuniones
	 */
	@Override
	public List<Riunione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of riuniones
	 * @param end the upper bound of the range of riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of riuniones
	 */
	@Override
	public List<Riunione> findAll(int start, int end,
		OrderByComparator<Riunione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of riuniones
	 * @param end the upper bound of the range of riuniones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of riuniones
	 */
	@Override
	public List<Riunione> findAll(int start, int end,
		OrderByComparator<Riunione> orderByComparator, boolean retrieveFromCache) {
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

		List<Riunione> list = null;

		if (retrieveFromCache) {
			list = (List<Riunione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RIUNIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RIUNIONE;

				if (pagination) {
					sql = sql.concat(RiunioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Riunione>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Riunione>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the riuniones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Riunione riunione : findAll()) {
			remove(riunione);
		}
	}

	/**
	 * Returns the number of riuniones.
	 *
	 * @return the number of riuniones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RIUNIONE);

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
		return RiunioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the riunione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RiunioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RIUNIONE = "SELECT riunione FROM Riunione riunione";
	private static final String _SQL_SELECT_RIUNIONE_WHERE_PKS_IN = "SELECT riunione FROM Riunione riunione WHERE id_riunione IN (";
	private static final String _SQL_COUNT_RIUNIONE = "SELECT COUNT(riunione) FROM Riunione riunione";
	private static final String _ORDER_BY_ENTITY_ALIAS = "riunione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Riunione exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RiunionePersistenceImpl.class);
}