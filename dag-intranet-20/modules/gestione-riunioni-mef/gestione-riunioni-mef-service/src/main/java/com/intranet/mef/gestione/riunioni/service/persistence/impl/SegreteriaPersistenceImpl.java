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

import com.intranet.mef.gestione.riunioni.exception.NoSuchSegreteriaException;
import com.intranet.mef.gestione.riunioni.model.Segreteria;
import com.intranet.mef.gestione.riunioni.model.impl.SegreteriaImpl;
import com.intranet.mef.gestione.riunioni.model.impl.SegreteriaModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.SegreteriaPersistence;

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
 * The persistence implementation for the segreteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegreteriaPersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.SegreteriaUtil
 * @generated
 */
@ProviderType
public class SegreteriaPersistenceImpl extends BasePersistenceImpl<Segreteria>
	implements SegreteriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SegreteriaUtil} to access the segreteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SegreteriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
			SegreteriaModelImpl.FINDER_CACHE_ENABLED, SegreteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
			SegreteriaModelImpl.FINDER_CACHE_ENABLED, SegreteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
			SegreteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SegreteriaPersistenceImpl() {
		setModelClass(Segreteria.class);
	}

	/**
	 * Caches the segreteria in the entity cache if it is enabled.
	 *
	 * @param segreteria the segreteria
	 */
	@Override
	public void cacheResult(Segreteria segreteria) {
		entityCache.putResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
			SegreteriaImpl.class, segreteria.getPrimaryKey(), segreteria);

		segreteria.resetOriginalValues();
	}

	/**
	 * Caches the segreterias in the entity cache if it is enabled.
	 *
	 * @param segreterias the segreterias
	 */
	@Override
	public void cacheResult(List<Segreteria> segreterias) {
		for (Segreteria segreteria : segreterias) {
			if (entityCache.getResult(
						SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
						SegreteriaImpl.class, segreteria.getPrimaryKey()) == null) {
				cacheResult(segreteria);
			}
			else {
				segreteria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all segreterias.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SegreteriaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the segreteria.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segreteria segreteria) {
		entityCache.removeResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
			SegreteriaImpl.class, segreteria.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Segreteria> segreterias) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Segreteria segreteria : segreterias) {
			entityCache.removeResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
				SegreteriaImpl.class, segreteria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new segreteria with the primary key. Does not add the segreteria to the database.
	 *
	 * @param id_segreteria the primary key for the new segreteria
	 * @return the new segreteria
	 */
	@Override
	public Segreteria create(long id_segreteria) {
		Segreteria segreteria = new SegreteriaImpl();

		segreteria.setNew(true);
		segreteria.setPrimaryKey(id_segreteria);

		return segreteria;
	}

	/**
	 * Removes the segreteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_segreteria the primary key of the segreteria
	 * @return the segreteria that was removed
	 * @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	 */
	@Override
	public Segreteria remove(long id_segreteria)
		throws NoSuchSegreteriaException {
		return remove((Serializable)id_segreteria);
	}

	/**
	 * Removes the segreteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segreteria
	 * @return the segreteria that was removed
	 * @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	 */
	@Override
	public Segreteria remove(Serializable primaryKey)
		throws NoSuchSegreteriaException {
		Session session = null;

		try {
			session = openSession();

			Segreteria segreteria = (Segreteria)session.get(SegreteriaImpl.class,
					primaryKey);

			if (segreteria == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegreteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(segreteria);
		}
		catch (NoSuchSegreteriaException nsee) {
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
	protected Segreteria removeImpl(Segreteria segreteria) {
		segreteria = toUnwrappedModel(segreteria);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segreteria)) {
				segreteria = (Segreteria)session.get(SegreteriaImpl.class,
						segreteria.getPrimaryKeyObj());
			}

			if (segreteria != null) {
				session.delete(segreteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (segreteria != null) {
			clearCache(segreteria);
		}

		return segreteria;
	}

	@Override
	public Segreteria updateImpl(Segreteria segreteria) {
		segreteria = toUnwrappedModel(segreteria);

		boolean isNew = segreteria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (segreteria.isNew()) {
				session.save(segreteria);

				segreteria.setNew(false);
			}
			else {
				segreteria = (Segreteria)session.merge(segreteria);
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

		entityCache.putResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
			SegreteriaImpl.class, segreteria.getPrimaryKey(), segreteria, false);

		segreteria.resetOriginalValues();

		return segreteria;
	}

	protected Segreteria toUnwrappedModel(Segreteria segreteria) {
		if (segreteria instanceof SegreteriaImpl) {
			return segreteria;
		}

		SegreteriaImpl segreteriaImpl = new SegreteriaImpl();

		segreteriaImpl.setNew(segreteria.isNew());
		segreteriaImpl.setPrimaryKey(segreteria.getPrimaryKey());

		segreteriaImpl.setId_segreteria(segreteria.getId_segreteria());
		segreteriaImpl.setEmail(segreteria.getEmail());
		segreteriaImpl.setDescrizione(segreteria.getDescrizione());
		segreteriaImpl.setAcronimo(segreteria.getAcronimo());
		segreteriaImpl.setLivello_gerarchia(segreteria.getLivello_gerarchia());
		segreteriaImpl.setCod_padre(segreteria.getCod_padre());
		segreteriaImpl.setData_fine_esistenza(segreteria.getData_fine_esistenza());
		segreteriaImpl.setIndirizzo(segreteria.getIndirizzo());
		segreteriaImpl.setCap(segreteria.getCap());
		segreteriaImpl.setCod_istat_citta(segreteria.getCod_istat_citta());

		return segreteriaImpl;
	}

	/**
	 * Returns the segreteria with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the segreteria
	 * @return the segreteria
	 * @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	 */
	@Override
	public Segreteria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegreteriaException {
		Segreteria segreteria = fetchByPrimaryKey(primaryKey);

		if (segreteria == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegreteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return segreteria;
	}

	/**
	 * Returns the segreteria with the primary key or throws a {@link NoSuchSegreteriaException} if it could not be found.
	 *
	 * @param id_segreteria the primary key of the segreteria
	 * @return the segreteria
	 * @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	 */
	@Override
	public Segreteria findByPrimaryKey(long id_segreteria)
		throws NoSuchSegreteriaException {
		return findByPrimaryKey((Serializable)id_segreteria);
	}

	/**
	 * Returns the segreteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segreteria
	 * @return the segreteria, or <code>null</code> if a segreteria with the primary key could not be found
	 */
	@Override
	public Segreteria fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
				SegreteriaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Segreteria segreteria = (Segreteria)serializable;

		if (segreteria == null) {
			Session session = null;

			try {
				session = openSession();

				segreteria = (Segreteria)session.get(SegreteriaImpl.class,
						primaryKey);

				if (segreteria != null) {
					cacheResult(segreteria);
				}
				else {
					entityCache.putResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
						SegreteriaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
					SegreteriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return segreteria;
	}

	/**
	 * Returns the segreteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_segreteria the primary key of the segreteria
	 * @return the segreteria, or <code>null</code> if a segreteria with the primary key could not be found
	 */
	@Override
	public Segreteria fetchByPrimaryKey(long id_segreteria) {
		return fetchByPrimaryKey((Serializable)id_segreteria);
	}

	@Override
	public Map<Serializable, Segreteria> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Segreteria> map = new HashMap<Serializable, Segreteria>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Segreteria segreteria = fetchByPrimaryKey(primaryKey);

			if (segreteria != null) {
				map.put(primaryKey, segreteria);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
					SegreteriaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Segreteria)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SEGRETERIA_WHERE_PKS_IN);

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

			for (Segreteria segreteria : (List<Segreteria>)q.list()) {
				map.put(segreteria.getPrimaryKeyObj(), segreteria);

				cacheResult(segreteria);

				uncachedPrimaryKeys.remove(segreteria.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SegreteriaModelImpl.ENTITY_CACHE_ENABLED,
					SegreteriaImpl.class, primaryKey, nullModel);
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
	 * Returns all the segreterias.
	 *
	 * @return the segreterias
	 */
	@Override
	public List<Segreteria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segreterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segreterias
	 * @param end the upper bound of the range of segreterias (not inclusive)
	 * @return the range of segreterias
	 */
	@Override
	public List<Segreteria> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the segreterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segreterias
	 * @param end the upper bound of the range of segreterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segreterias
	 */
	@Override
	public List<Segreteria> findAll(int start, int end,
		OrderByComparator<Segreteria> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segreterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segreterias
	 * @param end the upper bound of the range of segreterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of segreterias
	 */
	@Override
	public List<Segreteria> findAll(int start, int end,
		OrderByComparator<Segreteria> orderByComparator,
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

		List<Segreteria> list = null;

		if (retrieveFromCache) {
			list = (List<Segreteria>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEGRETERIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEGRETERIA;

				if (pagination) {
					sql = sql.concat(SegreteriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Segreteria>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Segreteria>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the segreterias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Segreteria segreteria : findAll()) {
			remove(segreteria);
		}
	}

	/**
	 * Returns the number of segreterias.
	 *
	 * @return the number of segreterias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEGRETERIA);

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
		return SegreteriaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the segreteria persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SegreteriaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SEGRETERIA = "SELECT segreteria FROM Segreteria segreteria";
	private static final String _SQL_SELECT_SEGRETERIA_WHERE_PKS_IN = "SELECT segreteria FROM Segreteria segreteria WHERE id_segreteria IN (";
	private static final String _SQL_COUNT_SEGRETERIA = "SELECT COUNT(segreteria) FROM Segreteria segreteria";
	private static final String _ORDER_BY_ENTITY_ALIAS = "segreteria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Segreteria exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SegreteriaPersistenceImpl.class);
}