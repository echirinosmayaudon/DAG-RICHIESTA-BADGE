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

package service.intranet.mef.service.persistence.impl;

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

import service.intranet.mef.exception.NoSuchRichiesteUtenzaException;
import service.intranet.mef.model.RichiesteUtenza;
import service.intranet.mef.model.impl.RichiesteUtenzaImpl;
import service.intranet.mef.model.impl.RichiesteUtenzaModelImpl;
import service.intranet.mef.service.persistence.RichiesteUtenzaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the richieste utenza service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteUtenzaPersistence
 * @see service.intranet.mef.service.persistence.RichiesteUtenzaUtil
 * @generated
 */
@ProviderType
public class RichiesteUtenzaPersistenceImpl extends BasePersistenceImpl<RichiesteUtenza>
	implements RichiesteUtenzaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiesteUtenzaUtil} to access the richieste utenza persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiesteUtenzaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteUtenzaModelImpl.FINDER_CACHE_ENABLED,
			RichiesteUtenzaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteUtenzaModelImpl.FINDER_CACHE_ENABLED,
			RichiesteUtenzaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteUtenzaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RichiesteUtenzaPersistenceImpl() {
		setModelClass(RichiesteUtenza.class);
	}

	/**
	 * Caches the richieste utenza in the entity cache if it is enabled.
	 *
	 * @param richiesteUtenza the richieste utenza
	 */
	@Override
	public void cacheResult(RichiesteUtenza richiesteUtenza) {
		entityCache.putResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteUtenzaImpl.class, richiesteUtenza.getPrimaryKey(),
			richiesteUtenza);

		richiesteUtenza.resetOriginalValues();
	}

	/**
	 * Caches the richieste utenzas in the entity cache if it is enabled.
	 *
	 * @param richiesteUtenzas the richieste utenzas
	 */
	@Override
	public void cacheResult(List<RichiesteUtenza> richiesteUtenzas) {
		for (RichiesteUtenza richiesteUtenza : richiesteUtenzas) {
			if (entityCache.getResult(
						RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteUtenzaImpl.class,
						richiesteUtenza.getPrimaryKey()) == null) {
				cacheResult(richiesteUtenza);
			}
			else {
				richiesteUtenza.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richieste utenzas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiesteUtenzaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richieste utenza.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiesteUtenza richiesteUtenza) {
		entityCache.removeResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteUtenzaImpl.class, richiesteUtenza.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichiesteUtenza> richiesteUtenzas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichiesteUtenza richiesteUtenza : richiesteUtenzas) {
			entityCache.removeResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteUtenzaImpl.class, richiesteUtenza.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richieste utenza with the primary key. Does not add the richieste utenza to the database.
	 *
	 * @param id_richieste_utenza the primary key for the new richieste utenza
	 * @return the new richieste utenza
	 */
	@Override
	public RichiesteUtenza create(long id_richieste_utenza) {
		RichiesteUtenza richiesteUtenza = new RichiesteUtenzaImpl();

		richiesteUtenza.setNew(true);
		richiesteUtenza.setPrimaryKey(id_richieste_utenza);

		return richiesteUtenza;
	}

	/**
	 * Removes the richieste utenza with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_richieste_utenza the primary key of the richieste utenza
	 * @return the richieste utenza that was removed
	 * @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	 */
	@Override
	public RichiesteUtenza remove(long id_richieste_utenza)
		throws NoSuchRichiesteUtenzaException {
		return remove((Serializable)id_richieste_utenza);
	}

	/**
	 * Removes the richieste utenza with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richieste utenza
	 * @return the richieste utenza that was removed
	 * @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	 */
	@Override
	public RichiesteUtenza remove(Serializable primaryKey)
		throws NoSuchRichiesteUtenzaException {
		Session session = null;

		try {
			session = openSession();

			RichiesteUtenza richiesteUtenza = (RichiesteUtenza)session.get(RichiesteUtenzaImpl.class,
					primaryKey);

			if (richiesteUtenza == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiesteUtenzaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richiesteUtenza);
		}
		catch (NoSuchRichiesteUtenzaException nsee) {
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
	protected RichiesteUtenza removeImpl(RichiesteUtenza richiesteUtenza) {
		richiesteUtenza = toUnwrappedModel(richiesteUtenza);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiesteUtenza)) {
				richiesteUtenza = (RichiesteUtenza)session.get(RichiesteUtenzaImpl.class,
						richiesteUtenza.getPrimaryKeyObj());
			}

			if (richiesteUtenza != null) {
				session.delete(richiesteUtenza);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiesteUtenza != null) {
			clearCache(richiesteUtenza);
		}

		return richiesteUtenza;
	}

	@Override
	public RichiesteUtenza updateImpl(RichiesteUtenza richiesteUtenza) {
		richiesteUtenza = toUnwrappedModel(richiesteUtenza);

		boolean isNew = richiesteUtenza.isNew();

		Session session = null;

		try {
			session = openSession();

			if (richiesteUtenza.isNew()) {
				session.save(richiesteUtenza);

				richiesteUtenza.setNew(false);
			}
			else {
				richiesteUtenza = (RichiesteUtenza)session.merge(richiesteUtenza);
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

		entityCache.putResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteUtenzaImpl.class, richiesteUtenza.getPrimaryKey(),
			richiesteUtenza, false);

		richiesteUtenza.resetOriginalValues();

		return richiesteUtenza;
	}

	protected RichiesteUtenza toUnwrappedModel(RichiesteUtenza richiesteUtenza) {
		if (richiesteUtenza instanceof RichiesteUtenzaImpl) {
			return richiesteUtenza;
		}

		RichiesteUtenzaImpl richiesteUtenzaImpl = new RichiesteUtenzaImpl();

		richiesteUtenzaImpl.setNew(richiesteUtenza.isNew());
		richiesteUtenzaImpl.setPrimaryKey(richiesteUtenza.getPrimaryKey());

		richiesteUtenzaImpl.setId_richieste_utenza(richiesteUtenza.getId_richieste_utenza());
		richiesteUtenzaImpl.setUtente(richiesteUtenza.getUtente());
		richiesteUtenzaImpl.setDestinatario(richiesteUtenza.getDestinatario());
		richiesteUtenzaImpl.setDettaglio(richiesteUtenza.getDettaglio());
		richiesteUtenzaImpl.setData_richiesta(richiesteUtenza.getData_richiesta());

		return richiesteUtenzaImpl;
	}

	/**
	 * Returns the richieste utenza with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste utenza
	 * @return the richieste utenza
	 * @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	 */
	@Override
	public RichiesteUtenza findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiesteUtenzaException {
		RichiesteUtenza richiesteUtenza = fetchByPrimaryKey(primaryKey);

		if (richiesteUtenza == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiesteUtenzaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richiesteUtenza;
	}

	/**
	 * Returns the richieste utenza with the primary key or throws a {@link NoSuchRichiesteUtenzaException} if it could not be found.
	 *
	 * @param id_richieste_utenza the primary key of the richieste utenza
	 * @return the richieste utenza
	 * @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	 */
	@Override
	public RichiesteUtenza findByPrimaryKey(long id_richieste_utenza)
		throws NoSuchRichiesteUtenzaException {
		return findByPrimaryKey((Serializable)id_richieste_utenza);
	}

	/**
	 * Returns the richieste utenza with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste utenza
	 * @return the richieste utenza, or <code>null</code> if a richieste utenza with the primary key could not be found
	 */
	@Override
	public RichiesteUtenza fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteUtenzaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichiesteUtenza richiesteUtenza = (RichiesteUtenza)serializable;

		if (richiesteUtenza == null) {
			Session session = null;

			try {
				session = openSession();

				richiesteUtenza = (RichiesteUtenza)session.get(RichiesteUtenzaImpl.class,
						primaryKey);

				if (richiesteUtenza != null) {
					cacheResult(richiesteUtenza);
				}
				else {
					entityCache.putResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteUtenzaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteUtenzaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiesteUtenza;
	}

	/**
	 * Returns the richieste utenza with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_richieste_utenza the primary key of the richieste utenza
	 * @return the richieste utenza, or <code>null</code> if a richieste utenza with the primary key could not be found
	 */
	@Override
	public RichiesteUtenza fetchByPrimaryKey(long id_richieste_utenza) {
		return fetchByPrimaryKey((Serializable)id_richieste_utenza);
	}

	@Override
	public Map<Serializable, RichiesteUtenza> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichiesteUtenza> map = new HashMap<Serializable, RichiesteUtenza>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichiesteUtenza richiesteUtenza = fetchByPrimaryKey(primaryKey);

			if (richiesteUtenza != null) {
				map.put(primaryKey, richiesteUtenza);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteUtenzaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichiesteUtenza)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTEUTENZA_WHERE_PKS_IN);

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

			for (RichiesteUtenza richiesteUtenza : (List<RichiesteUtenza>)q.list()) {
				map.put(richiesteUtenza.getPrimaryKeyObj(), richiesteUtenza);

				cacheResult(richiesteUtenza);

				uncachedPrimaryKeys.remove(richiesteUtenza.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiesteUtenzaModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteUtenzaImpl.class, primaryKey, nullModel);
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
	 * Returns all the richieste utenzas.
	 *
	 * @return the richieste utenzas
	 */
	@Override
	public List<RichiesteUtenza> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richieste utenzas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste utenzas
	 * @param end the upper bound of the range of richieste utenzas (not inclusive)
	 * @return the range of richieste utenzas
	 */
	@Override
	public List<RichiesteUtenza> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richieste utenzas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste utenzas
	 * @param end the upper bound of the range of richieste utenzas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richieste utenzas
	 */
	@Override
	public List<RichiesteUtenza> findAll(int start, int end,
		OrderByComparator<RichiesteUtenza> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richieste utenzas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste utenzas
	 * @param end the upper bound of the range of richieste utenzas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richieste utenzas
	 */
	@Override
	public List<RichiesteUtenza> findAll(int start, int end,
		OrderByComparator<RichiesteUtenza> orderByComparator,
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

		List<RichiesteUtenza> list = null;

		if (retrieveFromCache) {
			list = (List<RichiesteUtenza>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTEUTENZA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTEUTENZA;

				if (pagination) {
					sql = sql.concat(RichiesteUtenzaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichiesteUtenza>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiesteUtenza>)QueryUtil.list(q,
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
	 * Removes all the richieste utenzas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiesteUtenza richiesteUtenza : findAll()) {
			remove(richiesteUtenza);
		}
	}

	/**
	 * Returns the number of richieste utenzas.
	 *
	 * @return the number of richieste utenzas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTEUTENZA);

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
		return RichiesteUtenzaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richieste utenza persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiesteUtenzaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTEUTENZA = "SELECT richiesteUtenza FROM RichiesteUtenza richiesteUtenza";
	private static final String _SQL_SELECT_RICHIESTEUTENZA_WHERE_PKS_IN = "SELECT richiesteUtenza FROM RichiesteUtenza richiesteUtenza WHERE id_richieste_utenza IN (";
	private static final String _SQL_COUNT_RICHIESTEUTENZA = "SELECT COUNT(richiesteUtenza) FROM RichiesteUtenza richiesteUtenza";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richiesteUtenza.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichiesteUtenza exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RichiesteUtenzaPersistenceImpl.class);
}