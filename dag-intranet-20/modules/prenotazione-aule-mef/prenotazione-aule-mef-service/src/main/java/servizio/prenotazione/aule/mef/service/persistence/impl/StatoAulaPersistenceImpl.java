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

import servizio.prenotazione.aule.mef.exception.NoSuchStatoAulaException;
import servizio.prenotazione.aule.mef.model.StatoAula;
import servizio.prenotazione.aule.mef.model.impl.StatoAulaImpl;
import servizio.prenotazione.aule.mef.model.impl.StatoAulaModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.StatoAulaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the stato aula service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoAulaPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.StatoAulaUtil
 * @generated
 */
@ProviderType
public class StatoAulaPersistenceImpl extends BasePersistenceImpl<StatoAula>
	implements StatoAulaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatoAulaUtil} to access the stato aula persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatoAulaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
			StatoAulaModelImpl.FINDER_CACHE_ENABLED, StatoAulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
			StatoAulaModelImpl.FINDER_CACHE_ENABLED, StatoAulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
			StatoAulaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StatoAulaPersistenceImpl() {
		setModelClass(StatoAula.class);
	}

	/**
	 * Caches the stato aula in the entity cache if it is enabled.
	 *
	 * @param statoAula the stato aula
	 */
	@Override
	public void cacheResult(StatoAula statoAula) {
		entityCache.putResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
			StatoAulaImpl.class, statoAula.getPrimaryKey(), statoAula);

		statoAula.resetOriginalValues();
	}

	/**
	 * Caches the stato aulas in the entity cache if it is enabled.
	 *
	 * @param statoAulas the stato aulas
	 */
	@Override
	public void cacheResult(List<StatoAula> statoAulas) {
		for (StatoAula statoAula : statoAulas) {
			if (entityCache.getResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
						StatoAulaImpl.class, statoAula.getPrimaryKey()) == null) {
				cacheResult(statoAula);
			}
			else {
				statoAula.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stato aulas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoAulaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stato aula.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatoAula statoAula) {
		entityCache.removeResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
			StatoAulaImpl.class, statoAula.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatoAula> statoAulas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatoAula statoAula : statoAulas) {
			entityCache.removeResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
				StatoAulaImpl.class, statoAula.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stato aula with the primary key. Does not add the stato aula to the database.
	 *
	 * @param id_stato_aula the primary key for the new stato aula
	 * @return the new stato aula
	 */
	@Override
	public StatoAula create(long id_stato_aula) {
		StatoAula statoAula = new StatoAulaImpl();

		statoAula.setNew(true);
		statoAula.setPrimaryKey(id_stato_aula);

		return statoAula;
	}

	/**
	 * Removes the stato aula with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_stato_aula the primary key of the stato aula
	 * @return the stato aula that was removed
	 * @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	 */
	@Override
	public StatoAula remove(long id_stato_aula) throws NoSuchStatoAulaException {
		return remove((Serializable)id_stato_aula);
	}

	/**
	 * Removes the stato aula with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato aula
	 * @return the stato aula that was removed
	 * @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	 */
	@Override
	public StatoAula remove(Serializable primaryKey)
		throws NoSuchStatoAulaException {
		Session session = null;

		try {
			session = openSession();

			StatoAula statoAula = (StatoAula)session.get(StatoAulaImpl.class,
					primaryKey);

			if (statoAula == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoAulaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statoAula);
		}
		catch (NoSuchStatoAulaException nsee) {
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
	protected StatoAula removeImpl(StatoAula statoAula) {
		statoAula = toUnwrappedModel(statoAula);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statoAula)) {
				statoAula = (StatoAula)session.get(StatoAulaImpl.class,
						statoAula.getPrimaryKeyObj());
			}

			if (statoAula != null) {
				session.delete(statoAula);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statoAula != null) {
			clearCache(statoAula);
		}

		return statoAula;
	}

	@Override
	public StatoAula updateImpl(StatoAula statoAula) {
		statoAula = toUnwrappedModel(statoAula);

		boolean isNew = statoAula.isNew();

		Session session = null;

		try {
			session = openSession();

			if (statoAula.isNew()) {
				session.save(statoAula);

				statoAula.setNew(false);
			}
			else {
				statoAula = (StatoAula)session.merge(statoAula);
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

		entityCache.putResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
			StatoAulaImpl.class, statoAula.getPrimaryKey(), statoAula, false);

		statoAula.resetOriginalValues();

		return statoAula;
	}

	protected StatoAula toUnwrappedModel(StatoAula statoAula) {
		if (statoAula instanceof StatoAulaImpl) {
			return statoAula;
		}

		StatoAulaImpl statoAulaImpl = new StatoAulaImpl();

		statoAulaImpl.setNew(statoAula.isNew());
		statoAulaImpl.setPrimaryKey(statoAula.getPrimaryKey());

		statoAulaImpl.setId_stato_aula(statoAula.getId_stato_aula());
		statoAulaImpl.setDesc_stato(statoAula.getDesc_stato());

		return statoAulaImpl;
	}

	/**
	 * Returns the stato aula with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato aula
	 * @return the stato aula
	 * @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	 */
	@Override
	public StatoAula findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoAulaException {
		StatoAula statoAula = fetchByPrimaryKey(primaryKey);

		if (statoAula == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoAulaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statoAula;
	}

	/**
	 * Returns the stato aula with the primary key or throws a {@link NoSuchStatoAulaException} if it could not be found.
	 *
	 * @param id_stato_aula the primary key of the stato aula
	 * @return the stato aula
	 * @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	 */
	@Override
	public StatoAula findByPrimaryKey(long id_stato_aula)
		throws NoSuchStatoAulaException {
		return findByPrimaryKey((Serializable)id_stato_aula);
	}

	/**
	 * Returns the stato aula with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato aula
	 * @return the stato aula, or <code>null</code> if a stato aula with the primary key could not be found
	 */
	@Override
	public StatoAula fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
				StatoAulaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StatoAula statoAula = (StatoAula)serializable;

		if (statoAula == null) {
			Session session = null;

			try {
				session = openSession();

				statoAula = (StatoAula)session.get(StatoAulaImpl.class,
						primaryKey);

				if (statoAula != null) {
					cacheResult(statoAula);
				}
				else {
					entityCache.putResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
						StatoAulaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
					StatoAulaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statoAula;
	}

	/**
	 * Returns the stato aula with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_stato_aula the primary key of the stato aula
	 * @return the stato aula, or <code>null</code> if a stato aula with the primary key could not be found
	 */
	@Override
	public StatoAula fetchByPrimaryKey(long id_stato_aula) {
		return fetchByPrimaryKey((Serializable)id_stato_aula);
	}

	@Override
	public Map<Serializable, StatoAula> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StatoAula> map = new HashMap<Serializable, StatoAula>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StatoAula statoAula = fetchByPrimaryKey(primaryKey);

			if (statoAula != null) {
				map.put(primaryKey, statoAula);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
					StatoAulaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StatoAula)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STATOAULA_WHERE_PKS_IN);

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

			for (StatoAula statoAula : (List<StatoAula>)q.list()) {
				map.put(statoAula.getPrimaryKeyObj(), statoAula);

				cacheResult(statoAula);

				uncachedPrimaryKeys.remove(statoAula.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StatoAulaModelImpl.ENTITY_CACHE_ENABLED,
					StatoAulaImpl.class, primaryKey, nullModel);
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
	 * Returns all the stato aulas.
	 *
	 * @return the stato aulas
	 */
	@Override
	public List<StatoAula> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato aulas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato aulas
	 * @param end the upper bound of the range of stato aulas (not inclusive)
	 * @return the range of stato aulas
	 */
	@Override
	public List<StatoAula> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato aulas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato aulas
	 * @param end the upper bound of the range of stato aulas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato aulas
	 */
	@Override
	public List<StatoAula> findAll(int start, int end,
		OrderByComparator<StatoAula> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato aulas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato aulas
	 * @param end the upper bound of the range of stato aulas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stato aulas
	 */
	@Override
	public List<StatoAula> findAll(int start, int end,
		OrderByComparator<StatoAula> orderByComparator,
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

		List<StatoAula> list = null;

		if (retrieveFromCache) {
			list = (List<StatoAula>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATOAULA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATOAULA;

				if (pagination) {
					sql = sql.concat(StatoAulaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatoAula>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoAula>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the stato aulas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatoAula statoAula : findAll()) {
			remove(statoAula);
		}
	}

	/**
	 * Returns the number of stato aulas.
	 *
	 * @return the number of stato aulas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATOAULA);

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
		return StatoAulaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato aula persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StatoAulaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STATOAULA = "SELECT statoAula FROM StatoAula statoAula";
	private static final String _SQL_SELECT_STATOAULA_WHERE_PKS_IN = "SELECT statoAula FROM StatoAula statoAula WHERE id_stato_aula IN (";
	private static final String _SQL_COUNT_STATOAULA = "SELECT COUNT(statoAula) FROM StatoAula statoAula";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statoAula.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatoAula exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(StatoAulaPersistenceImpl.class);
}