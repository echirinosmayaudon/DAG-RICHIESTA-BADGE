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

package autorizzazione.dir.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.exception.NoSuchAutorizzazioneDirException;
import autorizzazione.dir.mef.model.AutorizzazioneDir;
import autorizzazione.dir.mef.model.impl.AutorizzazioneDirImpl;
import autorizzazione.dir.mef.model.impl.AutorizzazioneDirModelImpl;
import autorizzazione.dir.mef.service.persistence.AutorizzazioneDirPersistence;

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
 * The persistence implementation for the autorizzazione dir service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutorizzazioneDirPersistence
 * @see autorizzazione.dir.mef.service.persistence.AutorizzazioneDirUtil
 * @generated
 */
@ProviderType
public class AutorizzazioneDirPersistenceImpl extends BasePersistenceImpl<AutorizzazioneDir>
	implements AutorizzazioneDirPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AutorizzazioneDirUtil} to access the autorizzazione dir persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AutorizzazioneDirImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
			AutorizzazioneDirModelImpl.FINDER_CACHE_ENABLED,
			AutorizzazioneDirImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
			AutorizzazioneDirModelImpl.FINDER_CACHE_ENABLED,
			AutorizzazioneDirImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
			AutorizzazioneDirModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AutorizzazioneDirPersistenceImpl() {
		setModelClass(AutorizzazioneDir.class);
	}

	/**
	 * Caches the autorizzazione dir in the entity cache if it is enabled.
	 *
	 * @param autorizzazioneDir the autorizzazione dir
	 */
	@Override
	public void cacheResult(AutorizzazioneDir autorizzazioneDir) {
		entityCache.putResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
			AutorizzazioneDirImpl.class, autorizzazioneDir.getPrimaryKey(),
			autorizzazioneDir);

		autorizzazioneDir.resetOriginalValues();
	}

	/**
	 * Caches the autorizzazione dirs in the entity cache if it is enabled.
	 *
	 * @param autorizzazioneDirs the autorizzazione dirs
	 */
	@Override
	public void cacheResult(List<AutorizzazioneDir> autorizzazioneDirs) {
		for (AutorizzazioneDir autorizzazioneDir : autorizzazioneDirs) {
			if (entityCache.getResult(
						AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
						AutorizzazioneDirImpl.class,
						autorizzazioneDir.getPrimaryKey()) == null) {
				cacheResult(autorizzazioneDir);
			}
			else {
				autorizzazioneDir.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all autorizzazione dirs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AutorizzazioneDirImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the autorizzazione dir.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AutorizzazioneDir autorizzazioneDir) {
		entityCache.removeResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
			AutorizzazioneDirImpl.class, autorizzazioneDir.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AutorizzazioneDir> autorizzazioneDirs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AutorizzazioneDir autorizzazioneDir : autorizzazioneDirs) {
			entityCache.removeResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
				AutorizzazioneDirImpl.class, autorizzazioneDir.getPrimaryKey());
		}
	}

	/**
	 * Creates a new autorizzazione dir with the primary key. Does not add the autorizzazione dir to the database.
	 *
	 * @param id_autorizzazione the primary key for the new autorizzazione dir
	 * @return the new autorizzazione dir
	 */
	@Override
	public AutorizzazioneDir create(long id_autorizzazione) {
		AutorizzazioneDir autorizzazioneDir = new AutorizzazioneDirImpl();

		autorizzazioneDir.setNew(true);
		autorizzazioneDir.setPrimaryKey(id_autorizzazione);

		return autorizzazioneDir;
	}

	/**
	 * Removes the autorizzazione dir with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_autorizzazione the primary key of the autorizzazione dir
	 * @return the autorizzazione dir that was removed
	 * @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	 */
	@Override
	public AutorizzazioneDir remove(long id_autorizzazione)
		throws NoSuchAutorizzazioneDirException {
		return remove((Serializable)id_autorizzazione);
	}

	/**
	 * Removes the autorizzazione dir with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the autorizzazione dir
	 * @return the autorizzazione dir that was removed
	 * @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	 */
	@Override
	public AutorizzazioneDir remove(Serializable primaryKey)
		throws NoSuchAutorizzazioneDirException {
		Session session = null;

		try {
			session = openSession();

			AutorizzazioneDir autorizzazioneDir = (AutorizzazioneDir)session.get(AutorizzazioneDirImpl.class,
					primaryKey);

			if (autorizzazioneDir == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAutorizzazioneDirException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(autorizzazioneDir);
		}
		catch (NoSuchAutorizzazioneDirException nsee) {
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
	protected AutorizzazioneDir removeImpl(AutorizzazioneDir autorizzazioneDir) {
		autorizzazioneDir = toUnwrappedModel(autorizzazioneDir);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(autorizzazioneDir)) {
				autorizzazioneDir = (AutorizzazioneDir)session.get(AutorizzazioneDirImpl.class,
						autorizzazioneDir.getPrimaryKeyObj());
			}

			if (autorizzazioneDir != null) {
				session.delete(autorizzazioneDir);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (autorizzazioneDir != null) {
			clearCache(autorizzazioneDir);
		}

		return autorizzazioneDir;
	}

	@Override
	public AutorizzazioneDir updateImpl(AutorizzazioneDir autorizzazioneDir) {
		autorizzazioneDir = toUnwrappedModel(autorizzazioneDir);

		boolean isNew = autorizzazioneDir.isNew();

		Session session = null;

		try {
			session = openSession();

			if (autorizzazioneDir.isNew()) {
				session.save(autorizzazioneDir);

				autorizzazioneDir.setNew(false);
			}
			else {
				autorizzazioneDir = (AutorizzazioneDir)session.merge(autorizzazioneDir);
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

		entityCache.putResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
			AutorizzazioneDirImpl.class, autorizzazioneDir.getPrimaryKey(),
			autorizzazioneDir, false);

		autorizzazioneDir.resetOriginalValues();

		return autorizzazioneDir;
	}

	protected AutorizzazioneDir toUnwrappedModel(
		AutorizzazioneDir autorizzazioneDir) {
		if (autorizzazioneDir instanceof AutorizzazioneDirImpl) {
			return autorizzazioneDir;
		}

		AutorizzazioneDirImpl autorizzazioneDirImpl = new AutorizzazioneDirImpl();

		autorizzazioneDirImpl.setNew(autorizzazioneDir.isNew());
		autorizzazioneDirImpl.setPrimaryKey(autorizzazioneDir.getPrimaryKey());

		autorizzazioneDirImpl.setId_autorizzazione(autorizzazioneDir.getId_autorizzazione());
		autorizzazioneDirImpl.setId_applicazione(autorizzazioneDir.getId_applicazione());
		autorizzazioneDirImpl.setMef(autorizzazioneDir.getMef());
		autorizzazioneDirImpl.setDipartimento(autorizzazioneDir.getDipartimento());
		autorizzazioneDirImpl.setDirezione(autorizzazioneDir.getDirezione());
		autorizzazioneDirImpl.setUfficio(autorizzazioneDir.getUfficio());
		autorizzazioneDirImpl.setCodice_fiscale(autorizzazioneDir.getCodice_fiscale());
		autorizzazioneDirImpl.setNega(autorizzazioneDir.isNega());
		autorizzazioneDirImpl.setTag(autorizzazioneDir.getTag());

		return autorizzazioneDirImpl;
	}

	/**
	 * Returns the autorizzazione dir with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the autorizzazione dir
	 * @return the autorizzazione dir
	 * @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	 */
	@Override
	public AutorizzazioneDir findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAutorizzazioneDirException {
		AutorizzazioneDir autorizzazioneDir = fetchByPrimaryKey(primaryKey);

		if (autorizzazioneDir == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAutorizzazioneDirException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return autorizzazioneDir;
	}

	/**
	 * Returns the autorizzazione dir with the primary key or throws a {@link NoSuchAutorizzazioneDirException} if it could not be found.
	 *
	 * @param id_autorizzazione the primary key of the autorizzazione dir
	 * @return the autorizzazione dir
	 * @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	 */
	@Override
	public AutorizzazioneDir findByPrimaryKey(long id_autorizzazione)
		throws NoSuchAutorizzazioneDirException {
		return findByPrimaryKey((Serializable)id_autorizzazione);
	}

	/**
	 * Returns the autorizzazione dir with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the autorizzazione dir
	 * @return the autorizzazione dir, or <code>null</code> if a autorizzazione dir with the primary key could not be found
	 */
	@Override
	public AutorizzazioneDir fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
				AutorizzazioneDirImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AutorizzazioneDir autorizzazioneDir = (AutorizzazioneDir)serializable;

		if (autorizzazioneDir == null) {
			Session session = null;

			try {
				session = openSession();

				autorizzazioneDir = (AutorizzazioneDir)session.get(AutorizzazioneDirImpl.class,
						primaryKey);

				if (autorizzazioneDir != null) {
					cacheResult(autorizzazioneDir);
				}
				else {
					entityCache.putResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
						AutorizzazioneDirImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
					AutorizzazioneDirImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return autorizzazioneDir;
	}

	/**
	 * Returns the autorizzazione dir with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_autorizzazione the primary key of the autorizzazione dir
	 * @return the autorizzazione dir, or <code>null</code> if a autorizzazione dir with the primary key could not be found
	 */
	@Override
	public AutorizzazioneDir fetchByPrimaryKey(long id_autorizzazione) {
		return fetchByPrimaryKey((Serializable)id_autorizzazione);
	}

	@Override
	public Map<Serializable, AutorizzazioneDir> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AutorizzazioneDir> map = new HashMap<Serializable, AutorizzazioneDir>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AutorizzazioneDir autorizzazioneDir = fetchByPrimaryKey(primaryKey);

			if (autorizzazioneDir != null) {
				map.put(primaryKey, autorizzazioneDir);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
					AutorizzazioneDirImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AutorizzazioneDir)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AUTORIZZAZIONEDIR_WHERE_PKS_IN);

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

			for (AutorizzazioneDir autorizzazioneDir : (List<AutorizzazioneDir>)q.list()) {
				map.put(autorizzazioneDir.getPrimaryKeyObj(), autorizzazioneDir);

				cacheResult(autorizzazioneDir);

				uncachedPrimaryKeys.remove(autorizzazioneDir.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AutorizzazioneDirModelImpl.ENTITY_CACHE_ENABLED,
					AutorizzazioneDirImpl.class, primaryKey, nullModel);
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
	 * Returns all the autorizzazione dirs.
	 *
	 * @return the autorizzazione dirs
	 */
	@Override
	public List<AutorizzazioneDir> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the autorizzazione dirs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of autorizzazione dirs
	 * @param end the upper bound of the range of autorizzazione dirs (not inclusive)
	 * @return the range of autorizzazione dirs
	 */
	@Override
	public List<AutorizzazioneDir> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the autorizzazione dirs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of autorizzazione dirs
	 * @param end the upper bound of the range of autorizzazione dirs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of autorizzazione dirs
	 */
	@Override
	public List<AutorizzazioneDir> findAll(int start, int end,
		OrderByComparator<AutorizzazioneDir> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the autorizzazione dirs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of autorizzazione dirs
	 * @param end the upper bound of the range of autorizzazione dirs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of autorizzazione dirs
	 */
	@Override
	public List<AutorizzazioneDir> findAll(int start, int end,
		OrderByComparator<AutorizzazioneDir> orderByComparator,
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

		List<AutorizzazioneDir> list = null;

		if (retrieveFromCache) {
			list = (List<AutorizzazioneDir>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AUTORIZZAZIONEDIR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTORIZZAZIONEDIR;

				if (pagination) {
					sql = sql.concat(AutorizzazioneDirModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AutorizzazioneDir>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AutorizzazioneDir>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the autorizzazione dirs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AutorizzazioneDir autorizzazioneDir : findAll()) {
			remove(autorizzazioneDir);
		}
	}

	/**
	 * Returns the number of autorizzazione dirs.
	 *
	 * @return the number of autorizzazione dirs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUTORIZZAZIONEDIR);

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
		return AutorizzazioneDirModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the autorizzazione dir persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AutorizzazioneDirImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AUTORIZZAZIONEDIR = "SELECT autorizzazioneDir FROM AutorizzazioneDir autorizzazioneDir";
	private static final String _SQL_SELECT_AUTORIZZAZIONEDIR_WHERE_PKS_IN = "SELECT autorizzazioneDir FROM AutorizzazioneDir autorizzazioneDir WHERE id_autorizzazione IN (";
	private static final String _SQL_COUNT_AUTORIZZAZIONEDIR = "SELECT COUNT(autorizzazioneDir) FROM AutorizzazioneDir autorizzazioneDir";
	private static final String _ORDER_BY_ENTITY_ALIAS = "autorizzazioneDir.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AutorizzazioneDir exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(AutorizzazioneDirPersistenceImpl.class);
}