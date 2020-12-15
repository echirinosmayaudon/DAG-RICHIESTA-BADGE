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

package servizio.prenotazione.aule.mef.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.prenotazione.aule.mef.exception.NoSuchSalaException;
import servizio.prenotazione.aule.mef.model.Sala;
import servizio.prenotazione.aule.mef.model.impl.SalaImpl;
import servizio.prenotazione.aule.mef.model.impl.SalaModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.SalaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the sala service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.SalaUtil
 * @generated
 */
@ProviderType
public class SalaPersistenceImpl extends BasePersistenceImpl<Sala>
	implements SalaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SalaUtil} to access the sala persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SalaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SalaModelImpl.ENTITY_CACHE_ENABLED,
			SalaModelImpl.FINDER_CACHE_ENABLED, SalaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SalaModelImpl.ENTITY_CACHE_ENABLED,
			SalaModelImpl.FINDER_CACHE_ENABLED, SalaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SalaModelImpl.ENTITY_CACHE_ENABLED,
			SalaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SalaPersistenceImpl() {
		setModelClass(Sala.class);
	}

	/**
	 * Caches the sala in the entity cache if it is enabled.
	 *
	 * @param sala the sala
	 */
	@Override
	public void cacheResult(Sala sala) {
		entityCache.putResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
			SalaImpl.class, sala.getPrimaryKey(), sala);

		sala.resetOriginalValues();
	}

	/**
	 * Caches the salas in the entity cache if it is enabled.
	 *
	 * @param salas the salas
	 */
	@Override
	public void cacheResult(List<Sala> salas) {
		for (Sala sala : salas) {
			if (entityCache.getResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
						SalaImpl.class, sala.getPrimaryKey()) == null) {
				cacheResult(sala);
			}
			else {
				sala.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all salas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sala.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sala sala) {
		entityCache.removeResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
			SalaImpl.class, sala.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sala> salas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sala sala : salas) {
			entityCache.removeResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
				SalaImpl.class, sala.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sala with the primary key. Does not add the sala to the database.
	 *
	 * @param id_sala the primary key for the new sala
	 * @return the new sala
	 */
	@Override
	public Sala create(long id_sala) {
		Sala sala = new SalaImpl();

		sala.setNew(true);
		sala.setPrimaryKey(id_sala);

		return sala;
	}

	/**
	 * Removes the sala with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_sala the primary key of the sala
	 * @return the sala that was removed
	 * @throws NoSuchSalaException if a sala with the primary key could not be found
	 */
	@Override
	public Sala remove(long id_sala) throws NoSuchSalaException {
		return remove((Serializable)id_sala);
	}

	/**
	 * Removes the sala with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sala
	 * @return the sala that was removed
	 * @throws NoSuchSalaException if a sala with the primary key could not be found
	 */
	@Override
	public Sala remove(Serializable primaryKey) throws NoSuchSalaException {
		Session session = null;

		try {
			session = openSession();

			Sala sala = (Sala)session.get(SalaImpl.class, primaryKey);

			if (sala == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sala);
		}
		catch (NoSuchSalaException nsee) {
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
	protected Sala removeImpl(Sala sala) {
		sala = toUnwrappedModel(sala);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sala)) {
				sala = (Sala)session.get(SalaImpl.class, sala.getPrimaryKeyObj());
			}

			if (sala != null) {
				session.delete(sala);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sala != null) {
			clearCache(sala);
		}

		return sala;
	}

	@Override
	public Sala updateImpl(Sala sala) {
		sala = toUnwrappedModel(sala);

		boolean isNew = sala.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sala.isNew()) {
				session.save(sala);

				sala.setNew(false);
			}
			else {
				sala = (Sala)session.merge(sala);
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

		entityCache.putResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
			SalaImpl.class, sala.getPrimaryKey(), sala, false);

		sala.resetOriginalValues();

		return sala;
	}

	protected Sala toUnwrappedModel(Sala sala) {
		if (sala instanceof SalaImpl) {
			return sala;
		}

		SalaImpl salaImpl = new SalaImpl();

		salaImpl.setNew(sala.isNew());
		salaImpl.setPrimaryKey(sala.getPrimaryKey());

		salaImpl.setId_sala(sala.getId_sala());
		salaImpl.setDesc_sala(sala.getDesc_sala());
		salaImpl.setIndirizzo(sala.getIndirizzo());
		salaImpl.setCitta(sala.getCitta());
		salaImpl.setCap(sala.getCap());
		salaImpl.setCod_prov(sala.getCod_prov());
		salaImpl.setPiano(sala.getPiano());
		salaImpl.setStanza(sala.getStanza());
		salaImpl.setPosti(sala.getPosti());
		salaImpl.setVideo_conferenza(sala.isVideo_conferenza());
		salaImpl.setProiettore(sala.isProiettore());
		salaImpl.setPostazione_rete(sala.isPostazione_rete());
		salaImpl.setAutorizzazione(sala.isAutorizzazione());
		salaImpl.setEmail_ref(sala.getEmail_ref());

		return salaImpl;
	}

	/**
	 * Returns the sala with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sala
	 * @return the sala
	 * @throws NoSuchSalaException if a sala with the primary key could not be found
	 */
	@Override
	public Sala findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalaException {
		Sala sala = fetchByPrimaryKey(primaryKey);

		if (sala == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sala;
	}

	/**
	 * Returns the sala with the primary key or throws a {@link NoSuchSalaException} if it could not be found.
	 *
	 * @param id_sala the primary key of the sala
	 * @return the sala
	 * @throws NoSuchSalaException if a sala with the primary key could not be found
	 */
	@Override
	public Sala findByPrimaryKey(long id_sala) throws NoSuchSalaException {
		return findByPrimaryKey((Serializable)id_sala);
	}

	/**
	 * Returns the sala with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sala
	 * @return the sala, or <code>null</code> if a sala with the primary key could not be found
	 */
	@Override
	public Sala fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
				SalaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Sala sala = (Sala)serializable;

		if (sala == null) {
			Session session = null;

			try {
				session = openSession();

				sala = (Sala)session.get(SalaImpl.class, primaryKey);

				if (sala != null) {
					cacheResult(sala);
				}
				else {
					entityCache.putResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
						SalaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
					SalaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sala;
	}

	/**
	 * Returns the sala with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_sala the primary key of the sala
	 * @return the sala, or <code>null</code> if a sala with the primary key could not be found
	 */
	@Override
	public Sala fetchByPrimaryKey(long id_sala) {
		return fetchByPrimaryKey((Serializable)id_sala);
	}

	@Override
	public Map<Serializable, Sala> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Sala> map = new HashMap<Serializable, Sala>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Sala sala = fetchByPrimaryKey(primaryKey);

			if (sala != null) {
				map.put(primaryKey, sala);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
					SalaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Sala)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SALA_WHERE_PKS_IN);

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

			for (Sala sala : (List<Sala>)q.list()) {
				map.put(sala.getPrimaryKeyObj(), sala);

				cacheResult(sala);

				uncachedPrimaryKeys.remove(sala.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SalaModelImpl.ENTITY_CACHE_ENABLED,
					SalaImpl.class, primaryKey, nullModel);
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
	 * Returns all the salas.
	 *
	 * @return the salas
	 */
	@Override
	public List<Sala> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the salas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of salas
	 * @param end the upper bound of the range of salas (not inclusive)
	 * @return the range of salas
	 */
	@Override
	public List<Sala> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the salas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of salas
	 * @param end the upper bound of the range of salas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of salas
	 */
	@Override
	public List<Sala> findAll(int start, int end,
		OrderByComparator<Sala> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the salas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of salas
	 * @param end the upper bound of the range of salas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of salas
	 */
	@Override
	public List<Sala> findAll(int start, int end,
		OrderByComparator<Sala> orderByComparator, boolean retrieveFromCache) {
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

		List<Sala> list = null;

		if (retrieveFromCache) {
			list = (List<Sala>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SALA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SALA;

				if (pagination) {
					sql = sql.concat(SalaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sala>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Sala>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the salas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Sala sala : findAll()) {
			remove(sala);
		}
	}

	/**
	 * Returns the number of salas.
	 *
	 * @return the number of salas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SALA);

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
		return SalaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sala persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SalaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SALA = "SELECT sala FROM Sala sala";
	private static final String _SQL_SELECT_SALA_WHERE_PKS_IN = "SELECT sala FROM Sala sala WHERE id_sala IN (";
	private static final String _SQL_COUNT_SALA = "SELECT COUNT(sala) FROM Sala sala";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sala.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sala exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SalaPersistenceImpl.class);
}