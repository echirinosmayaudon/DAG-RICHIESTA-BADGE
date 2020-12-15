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

import servizio.prenotazione.aule.mef.exception.NoSuchOrarioException;
import servizio.prenotazione.aule.mef.model.Orario;
import servizio.prenotazione.aule.mef.model.impl.OrarioImpl;
import servizio.prenotazione.aule.mef.model.impl.OrarioModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.OrarioPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the orario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrarioPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.OrarioUtil
 * @generated
 */
@ProviderType
public class OrarioPersistenceImpl extends BasePersistenceImpl<Orario>
	implements OrarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrarioUtil} to access the orario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrarioModelImpl.ENTITY_CACHE_ENABLED,
			OrarioModelImpl.FINDER_CACHE_ENABLED, OrarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrarioModelImpl.ENTITY_CACHE_ENABLED,
			OrarioModelImpl.FINDER_CACHE_ENABLED, OrarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrarioModelImpl.ENTITY_CACHE_ENABLED,
			OrarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OrarioPersistenceImpl() {
		setModelClass(Orario.class);
	}

	/**
	 * Caches the orario in the entity cache if it is enabled.
	 *
	 * @param orario the orario
	 */
	@Override
	public void cacheResult(Orario orario) {
		entityCache.putResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
			OrarioImpl.class, orario.getPrimaryKey(), orario);

		orario.resetOriginalValues();
	}

	/**
	 * Caches the orarios in the entity cache if it is enabled.
	 *
	 * @param orarios the orarios
	 */
	@Override
	public void cacheResult(List<Orario> orarios) {
		for (Orario orario : orarios) {
			if (entityCache.getResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
						OrarioImpl.class, orario.getPrimaryKey()) == null) {
				cacheResult(orario);
			}
			else {
				orario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all orarios.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrarioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the orario.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Orario orario) {
		entityCache.removeResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
			OrarioImpl.class, orario.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Orario> orarios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Orario orario : orarios) {
			entityCache.removeResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
				OrarioImpl.class, orario.getPrimaryKey());
		}
	}

	/**
	 * Creates a new orario with the primary key. Does not add the orario to the database.
	 *
	 * @param id_ora the primary key for the new orario
	 * @return the new orario
	 */
	@Override
	public Orario create(long id_ora) {
		Orario orario = new OrarioImpl();

		orario.setNew(true);
		orario.setPrimaryKey(id_ora);

		return orario;
	}

	/**
	 * Removes the orario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ora the primary key of the orario
	 * @return the orario that was removed
	 * @throws NoSuchOrarioException if a orario with the primary key could not be found
	 */
	@Override
	public Orario remove(long id_ora) throws NoSuchOrarioException {
		return remove((Serializable)id_ora);
	}

	/**
	 * Removes the orario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the orario
	 * @return the orario that was removed
	 * @throws NoSuchOrarioException if a orario with the primary key could not be found
	 */
	@Override
	public Orario remove(Serializable primaryKey) throws NoSuchOrarioException {
		Session session = null;

		try {
			session = openSession();

			Orario orario = (Orario)session.get(OrarioImpl.class, primaryKey);

			if (orario == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orario);
		}
		catch (NoSuchOrarioException nsee) {
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
	protected Orario removeImpl(Orario orario) {
		orario = toUnwrappedModel(orario);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orario)) {
				orario = (Orario)session.get(OrarioImpl.class,
						orario.getPrimaryKeyObj());
			}

			if (orario != null) {
				session.delete(orario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (orario != null) {
			clearCache(orario);
		}

		return orario;
	}

	@Override
	public Orario updateImpl(Orario orario) {
		orario = toUnwrappedModel(orario);

		boolean isNew = orario.isNew();

		Session session = null;

		try {
			session = openSession();

			if (orario.isNew()) {
				session.save(orario);

				orario.setNew(false);
			}
			else {
				orario = (Orario)session.merge(orario);
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

		entityCache.putResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
			OrarioImpl.class, orario.getPrimaryKey(), orario, false);

		orario.resetOriginalValues();

		return orario;
	}

	protected Orario toUnwrappedModel(Orario orario) {
		if (orario instanceof OrarioImpl) {
			return orario;
		}

		OrarioImpl orarioImpl = new OrarioImpl();

		orarioImpl.setNew(orario.isNew());
		orarioImpl.setPrimaryKey(orario.getPrimaryKey());

		orarioImpl.setId_ora(orario.getId_ora());
		orarioImpl.setOre(orario.getOre());

		return orarioImpl;
	}

	/**
	 * Returns the orario with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the orario
	 * @return the orario
	 * @throws NoSuchOrarioException if a orario with the primary key could not be found
	 */
	@Override
	public Orario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrarioException {
		Orario orario = fetchByPrimaryKey(primaryKey);

		if (orario == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return orario;
	}

	/**
	 * Returns the orario with the primary key or throws a {@link NoSuchOrarioException} if it could not be found.
	 *
	 * @param id_ora the primary key of the orario
	 * @return the orario
	 * @throws NoSuchOrarioException if a orario with the primary key could not be found
	 */
	@Override
	public Orario findByPrimaryKey(long id_ora) throws NoSuchOrarioException {
		return findByPrimaryKey((Serializable)id_ora);
	}

	/**
	 * Returns the orario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the orario
	 * @return the orario, or <code>null</code> if a orario with the primary key could not be found
	 */
	@Override
	public Orario fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
				OrarioImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Orario orario = (Orario)serializable;

		if (orario == null) {
			Session session = null;

			try {
				session = openSession();

				orario = (Orario)session.get(OrarioImpl.class, primaryKey);

				if (orario != null) {
					cacheResult(orario);
				}
				else {
					entityCache.putResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
						OrarioImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
					OrarioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return orario;
	}

	/**
	 * Returns the orario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ora the primary key of the orario
	 * @return the orario, or <code>null</code> if a orario with the primary key could not be found
	 */
	@Override
	public Orario fetchByPrimaryKey(long id_ora) {
		return fetchByPrimaryKey((Serializable)id_ora);
	}

	@Override
	public Map<Serializable, Orario> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Orario> map = new HashMap<Serializable, Orario>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Orario orario = fetchByPrimaryKey(primaryKey);

			if (orario != null) {
				map.put(primaryKey, orario);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
					OrarioImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Orario)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ORARIO_WHERE_PKS_IN);

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

			for (Orario orario : (List<Orario>)q.list()) {
				map.put(orario.getPrimaryKeyObj(), orario);

				cacheResult(orario);

				uncachedPrimaryKeys.remove(orario.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OrarioModelImpl.ENTITY_CACHE_ENABLED,
					OrarioImpl.class, primaryKey, nullModel);
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
	 * Returns all the orarios.
	 *
	 * @return the orarios
	 */
	@Override
	public List<Orario> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the orarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orarios
	 * @param end the upper bound of the range of orarios (not inclusive)
	 * @return the range of orarios
	 */
	@Override
	public List<Orario> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the orarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orarios
	 * @param end the upper bound of the range of orarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orarios
	 */
	@Override
	public List<Orario> findAll(int start, int end,
		OrderByComparator<Orario> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the orarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orarios
	 * @param end the upper bound of the range of orarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of orarios
	 */
	@Override
	public List<Orario> findAll(int start, int end,
		OrderByComparator<Orario> orderByComparator, boolean retrieveFromCache) {
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

		List<Orario> list = null;

		if (retrieveFromCache) {
			list = (List<Orario>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ORARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORARIO;

				if (pagination) {
					sql = sql.concat(OrarioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Orario>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Orario>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the orarios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Orario orario : findAll()) {
			remove(orario);
		}
	}

	/**
	 * Returns the number of orarios.
	 *
	 * @return the number of orarios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORARIO);

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
		return OrarioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the orario persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OrarioImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ORARIO = "SELECT orario FROM Orario orario";
	private static final String _SQL_SELECT_ORARIO_WHERE_PKS_IN = "SELECT orario FROM Orario orario WHERE id_ora IN (";
	private static final String _SQL_COUNT_ORARIO = "SELECT COUNT(orario) FROM Orario orario";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Orario exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(OrarioPersistenceImpl.class);
}