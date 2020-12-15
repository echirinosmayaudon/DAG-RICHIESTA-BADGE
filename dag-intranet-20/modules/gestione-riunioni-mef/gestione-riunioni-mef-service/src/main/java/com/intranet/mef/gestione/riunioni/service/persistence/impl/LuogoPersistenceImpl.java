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

import com.intranet.mef.gestione.riunioni.exception.NoSuchLuogoException;
import com.intranet.mef.gestione.riunioni.model.Luogo;
import com.intranet.mef.gestione.riunioni.model.impl.LuogoImpl;
import com.intranet.mef.gestione.riunioni.model.impl.LuogoModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.LuogoPersistence;

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
 * The persistence implementation for the luogo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LuogoPersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.LuogoUtil
 * @generated
 */
@ProviderType
public class LuogoPersistenceImpl extends BasePersistenceImpl<Luogo>
	implements LuogoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LuogoUtil} to access the luogo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LuogoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LuogoModelImpl.ENTITY_CACHE_ENABLED,
			LuogoModelImpl.FINDER_CACHE_ENABLED, LuogoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LuogoModelImpl.ENTITY_CACHE_ENABLED,
			LuogoModelImpl.FINDER_CACHE_ENABLED, LuogoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LuogoModelImpl.ENTITY_CACHE_ENABLED,
			LuogoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LuogoPersistenceImpl() {
		setModelClass(Luogo.class);
	}

	/**
	 * Caches the luogo in the entity cache if it is enabled.
	 *
	 * @param luogo the luogo
	 */
	@Override
	public void cacheResult(Luogo luogo) {
		entityCache.putResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
			LuogoImpl.class, luogo.getPrimaryKey(), luogo);

		luogo.resetOriginalValues();
	}

	/**
	 * Caches the luogos in the entity cache if it is enabled.
	 *
	 * @param luogos the luogos
	 */
	@Override
	public void cacheResult(List<Luogo> luogos) {
		for (Luogo luogo : luogos) {
			if (entityCache.getResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
						LuogoImpl.class, luogo.getPrimaryKey()) == null) {
				cacheResult(luogo);
			}
			else {
				luogo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all luogos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LuogoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the luogo.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Luogo luogo) {
		entityCache.removeResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
			LuogoImpl.class, luogo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Luogo> luogos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Luogo luogo : luogos) {
			entityCache.removeResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
				LuogoImpl.class, luogo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new luogo with the primary key. Does not add the luogo to the database.
	 *
	 * @param id_luogo the primary key for the new luogo
	 * @return the new luogo
	 */
	@Override
	public Luogo create(long id_luogo) {
		Luogo luogo = new LuogoImpl();

		luogo.setNew(true);
		luogo.setPrimaryKey(id_luogo);

		return luogo;
	}

	/**
	 * Removes the luogo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_luogo the primary key of the luogo
	 * @return the luogo that was removed
	 * @throws NoSuchLuogoException if a luogo with the primary key could not be found
	 */
	@Override
	public Luogo remove(long id_luogo) throws NoSuchLuogoException {
		return remove((Serializable)id_luogo);
	}

	/**
	 * Removes the luogo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the luogo
	 * @return the luogo that was removed
	 * @throws NoSuchLuogoException if a luogo with the primary key could not be found
	 */
	@Override
	public Luogo remove(Serializable primaryKey) throws NoSuchLuogoException {
		Session session = null;

		try {
			session = openSession();

			Luogo luogo = (Luogo)session.get(LuogoImpl.class, primaryKey);

			if (luogo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLuogoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(luogo);
		}
		catch (NoSuchLuogoException nsee) {
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
	protected Luogo removeImpl(Luogo luogo) {
		luogo = toUnwrappedModel(luogo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(luogo)) {
				luogo = (Luogo)session.get(LuogoImpl.class,
						luogo.getPrimaryKeyObj());
			}

			if (luogo != null) {
				session.delete(luogo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (luogo != null) {
			clearCache(luogo);
		}

		return luogo;
	}

	@Override
	public Luogo updateImpl(Luogo luogo) {
		luogo = toUnwrappedModel(luogo);

		boolean isNew = luogo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (luogo.isNew()) {
				session.save(luogo);

				luogo.setNew(false);
			}
			else {
				luogo = (Luogo)session.merge(luogo);
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

		entityCache.putResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
			LuogoImpl.class, luogo.getPrimaryKey(), luogo, false);

		luogo.resetOriginalValues();

		return luogo;
	}

	protected Luogo toUnwrappedModel(Luogo luogo) {
		if (luogo instanceof LuogoImpl) {
			return luogo;
		}

		LuogoImpl luogoImpl = new LuogoImpl();

		luogoImpl.setNew(luogo.isNew());
		luogoImpl.setPrimaryKey(luogo.getPrimaryKey());

		luogoImpl.setId_luogo(luogo.getId_luogo());
		luogoImpl.setNome(luogo.getNome());

		return luogoImpl;
	}

	/**
	 * Returns the luogo with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the luogo
	 * @return the luogo
	 * @throws NoSuchLuogoException if a luogo with the primary key could not be found
	 */
	@Override
	public Luogo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLuogoException {
		Luogo luogo = fetchByPrimaryKey(primaryKey);

		if (luogo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLuogoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return luogo;
	}

	/**
	 * Returns the luogo with the primary key or throws a {@link NoSuchLuogoException} if it could not be found.
	 *
	 * @param id_luogo the primary key of the luogo
	 * @return the luogo
	 * @throws NoSuchLuogoException if a luogo with the primary key could not be found
	 */
	@Override
	public Luogo findByPrimaryKey(long id_luogo) throws NoSuchLuogoException {
		return findByPrimaryKey((Serializable)id_luogo);
	}

	/**
	 * Returns the luogo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the luogo
	 * @return the luogo, or <code>null</code> if a luogo with the primary key could not be found
	 */
	@Override
	public Luogo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
				LuogoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Luogo luogo = (Luogo)serializable;

		if (luogo == null) {
			Session session = null;

			try {
				session = openSession();

				luogo = (Luogo)session.get(LuogoImpl.class, primaryKey);

				if (luogo != null) {
					cacheResult(luogo);
				}
				else {
					entityCache.putResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
						LuogoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
					LuogoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return luogo;
	}

	/**
	 * Returns the luogo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_luogo the primary key of the luogo
	 * @return the luogo, or <code>null</code> if a luogo with the primary key could not be found
	 */
	@Override
	public Luogo fetchByPrimaryKey(long id_luogo) {
		return fetchByPrimaryKey((Serializable)id_luogo);
	}

	@Override
	public Map<Serializable, Luogo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Luogo> map = new HashMap<Serializable, Luogo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Luogo luogo = fetchByPrimaryKey(primaryKey);

			if (luogo != null) {
				map.put(primaryKey, luogo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
					LuogoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Luogo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LUOGO_WHERE_PKS_IN);

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

			for (Luogo luogo : (List<Luogo>)q.list()) {
				map.put(luogo.getPrimaryKeyObj(), luogo);

				cacheResult(luogo);

				uncachedPrimaryKeys.remove(luogo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LuogoModelImpl.ENTITY_CACHE_ENABLED,
					LuogoImpl.class, primaryKey, nullModel);
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
	 * Returns all the luogos.
	 *
	 * @return the luogos
	 */
	@Override
	public List<Luogo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the luogos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of luogos
	 * @param end the upper bound of the range of luogos (not inclusive)
	 * @return the range of luogos
	 */
	@Override
	public List<Luogo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the luogos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of luogos
	 * @param end the upper bound of the range of luogos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of luogos
	 */
	@Override
	public List<Luogo> findAll(int start, int end,
		OrderByComparator<Luogo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the luogos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of luogos
	 * @param end the upper bound of the range of luogos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of luogos
	 */
	@Override
	public List<Luogo> findAll(int start, int end,
		OrderByComparator<Luogo> orderByComparator, boolean retrieveFromCache) {
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

		List<Luogo> list = null;

		if (retrieveFromCache) {
			list = (List<Luogo>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LUOGO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LUOGO;

				if (pagination) {
					sql = sql.concat(LuogoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Luogo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Luogo>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the luogos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Luogo luogo : findAll()) {
			remove(luogo);
		}
	}

	/**
	 * Returns the number of luogos.
	 *
	 * @return the number of luogos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LUOGO);

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
		return LuogoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the luogo persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LuogoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LUOGO = "SELECT luogo FROM Luogo luogo";
	private static final String _SQL_SELECT_LUOGO_WHERE_PKS_IN = "SELECT luogo FROM Luogo luogo WHERE id_luogo IN (";
	private static final String _SQL_COUNT_LUOGO = "SELECT COUNT(luogo) FROM Luogo luogo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "luogo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Luogo exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(LuogoPersistenceImpl.class);
}