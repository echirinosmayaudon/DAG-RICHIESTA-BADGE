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

import service.intranet.mef.exception.NoSuchTipologiaDispositiviException;
import service.intranet.mef.model.TipologiaDispositivi;
import service.intranet.mef.model.impl.TipologiaDispositiviImpl;
import service.intranet.mef.model.impl.TipologiaDispositiviModelImpl;
import service.intranet.mef.service.persistence.TipologiaDispositiviPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tipologia dispositivi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaDispositiviPersistence
 * @see service.intranet.mef.service.persistence.TipologiaDispositiviUtil
 * @generated
 */
@ProviderType
public class TipologiaDispositiviPersistenceImpl extends BasePersistenceImpl<TipologiaDispositivi>
	implements TipologiaDispositiviPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipologiaDispositiviUtil} to access the tipologia dispositivi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipologiaDispositiviImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaDispositiviModelImpl.FINDER_CACHE_ENABLED,
			TipologiaDispositiviImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaDispositiviModelImpl.FINDER_CACHE_ENABLED,
			TipologiaDispositiviImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaDispositiviModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TipologiaDispositiviPersistenceImpl() {
		setModelClass(TipologiaDispositivi.class);
	}

	/**
	 * Caches the tipologia dispositivi in the entity cache if it is enabled.
	 *
	 * @param tipologiaDispositivi the tipologia dispositivi
	 */
	@Override
	public void cacheResult(TipologiaDispositivi tipologiaDispositivi) {
		entityCache.putResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaDispositiviImpl.class,
			tipologiaDispositivi.getPrimaryKey(), tipologiaDispositivi);

		tipologiaDispositivi.resetOriginalValues();
	}

	/**
	 * Caches the tipologia dispositivis in the entity cache if it is enabled.
	 *
	 * @param tipologiaDispositivis the tipologia dispositivis
	 */
	@Override
	public void cacheResult(List<TipologiaDispositivi> tipologiaDispositivis) {
		for (TipologiaDispositivi tipologiaDispositivi : tipologiaDispositivis) {
			if (entityCache.getResult(
						TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
						TipologiaDispositiviImpl.class,
						tipologiaDispositivi.getPrimaryKey()) == null) {
				cacheResult(tipologiaDispositivi);
			}
			else {
				tipologiaDispositivi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipologia dispositivis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipologiaDispositiviImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipologia dispositivi.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipologiaDispositivi tipologiaDispositivi) {
		entityCache.removeResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaDispositiviImpl.class, tipologiaDispositivi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipologiaDispositivi> tipologiaDispositivis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipologiaDispositivi tipologiaDispositivi : tipologiaDispositivis) {
			entityCache.removeResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
				TipologiaDispositiviImpl.class,
				tipologiaDispositivi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipologia dispositivi with the primary key. Does not add the tipologia dispositivi to the database.
	 *
	 * @param id_tipologia_dispositivi the primary key for the new tipologia dispositivi
	 * @return the new tipologia dispositivi
	 */
	@Override
	public TipologiaDispositivi create(long id_tipologia_dispositivi) {
		TipologiaDispositivi tipologiaDispositivi = new TipologiaDispositiviImpl();

		tipologiaDispositivi.setNew(true);
		tipologiaDispositivi.setPrimaryKey(id_tipologia_dispositivi);

		return tipologiaDispositivi;
	}

	/**
	 * Removes the tipologia dispositivi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_tipologia_dispositivi the primary key of the tipologia dispositivi
	 * @return the tipologia dispositivi that was removed
	 * @throws NoSuchTipologiaDispositiviException if a tipologia dispositivi with the primary key could not be found
	 */
	@Override
	public TipologiaDispositivi remove(long id_tipologia_dispositivi)
		throws NoSuchTipologiaDispositiviException {
		return remove((Serializable)id_tipologia_dispositivi);
	}

	/**
	 * Removes the tipologia dispositivi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipologia dispositivi
	 * @return the tipologia dispositivi that was removed
	 * @throws NoSuchTipologiaDispositiviException if a tipologia dispositivi with the primary key could not be found
	 */
	@Override
	public TipologiaDispositivi remove(Serializable primaryKey)
		throws NoSuchTipologiaDispositiviException {
		Session session = null;

		try {
			session = openSession();

			TipologiaDispositivi tipologiaDispositivi = (TipologiaDispositivi)session.get(TipologiaDispositiviImpl.class,
					primaryKey);

			if (tipologiaDispositivi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipologiaDispositiviException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipologiaDispositivi);
		}
		catch (NoSuchTipologiaDispositiviException nsee) {
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
	protected TipologiaDispositivi removeImpl(
		TipologiaDispositivi tipologiaDispositivi) {
		tipologiaDispositivi = toUnwrappedModel(tipologiaDispositivi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipologiaDispositivi)) {
				tipologiaDispositivi = (TipologiaDispositivi)session.get(TipologiaDispositiviImpl.class,
						tipologiaDispositivi.getPrimaryKeyObj());
			}

			if (tipologiaDispositivi != null) {
				session.delete(tipologiaDispositivi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipologiaDispositivi != null) {
			clearCache(tipologiaDispositivi);
		}

		return tipologiaDispositivi;
	}

	@Override
	public TipologiaDispositivi updateImpl(
		TipologiaDispositivi tipologiaDispositivi) {
		tipologiaDispositivi = toUnwrappedModel(tipologiaDispositivi);

		boolean isNew = tipologiaDispositivi.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipologiaDispositivi.isNew()) {
				session.save(tipologiaDispositivi);

				tipologiaDispositivi.setNew(false);
			}
			else {
				tipologiaDispositivi = (TipologiaDispositivi)session.merge(tipologiaDispositivi);
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

		entityCache.putResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaDispositiviImpl.class,
			tipologiaDispositivi.getPrimaryKey(), tipologiaDispositivi, false);

		tipologiaDispositivi.resetOriginalValues();

		return tipologiaDispositivi;
	}

	protected TipologiaDispositivi toUnwrappedModel(
		TipologiaDispositivi tipologiaDispositivi) {
		if (tipologiaDispositivi instanceof TipologiaDispositiviImpl) {
			return tipologiaDispositivi;
		}

		TipologiaDispositiviImpl tipologiaDispositiviImpl = new TipologiaDispositiviImpl();

		tipologiaDispositiviImpl.setNew(tipologiaDispositivi.isNew());
		tipologiaDispositiviImpl.setPrimaryKey(tipologiaDispositivi.getPrimaryKey());

		tipologiaDispositiviImpl.setId_tipologia_dispositivi(tipologiaDispositivi.getId_tipologia_dispositivi());
		tipologiaDispositiviImpl.setDescrizione(tipologiaDispositivi.getDescrizione());

		return tipologiaDispositiviImpl;
	}

	/**
	 * Returns the tipologia dispositivi with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia dispositivi
	 * @return the tipologia dispositivi
	 * @throws NoSuchTipologiaDispositiviException if a tipologia dispositivi with the primary key could not be found
	 */
	@Override
	public TipologiaDispositivi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipologiaDispositiviException {
		TipologiaDispositivi tipologiaDispositivi = fetchByPrimaryKey(primaryKey);

		if (tipologiaDispositivi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipologiaDispositiviException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipologiaDispositivi;
	}

	/**
	 * Returns the tipologia dispositivi with the primary key or throws a {@link NoSuchTipologiaDispositiviException} if it could not be found.
	 *
	 * @param id_tipologia_dispositivi the primary key of the tipologia dispositivi
	 * @return the tipologia dispositivi
	 * @throws NoSuchTipologiaDispositiviException if a tipologia dispositivi with the primary key could not be found
	 */
	@Override
	public TipologiaDispositivi findByPrimaryKey(long id_tipologia_dispositivi)
		throws NoSuchTipologiaDispositiviException {
		return findByPrimaryKey((Serializable)id_tipologia_dispositivi);
	}

	/**
	 * Returns the tipologia dispositivi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia dispositivi
	 * @return the tipologia dispositivi, or <code>null</code> if a tipologia dispositivi with the primary key could not be found
	 */
	@Override
	public TipologiaDispositivi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
				TipologiaDispositiviImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipologiaDispositivi tipologiaDispositivi = (TipologiaDispositivi)serializable;

		if (tipologiaDispositivi == null) {
			Session session = null;

			try {
				session = openSession();

				tipologiaDispositivi = (TipologiaDispositivi)session.get(TipologiaDispositiviImpl.class,
						primaryKey);

				if (tipologiaDispositivi != null) {
					cacheResult(tipologiaDispositivi);
				}
				else {
					entityCache.putResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
						TipologiaDispositiviImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaDispositiviImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipologiaDispositivi;
	}

	/**
	 * Returns the tipologia dispositivi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_tipologia_dispositivi the primary key of the tipologia dispositivi
	 * @return the tipologia dispositivi, or <code>null</code> if a tipologia dispositivi with the primary key could not be found
	 */
	@Override
	public TipologiaDispositivi fetchByPrimaryKey(long id_tipologia_dispositivi) {
		return fetchByPrimaryKey((Serializable)id_tipologia_dispositivi);
	}

	@Override
	public Map<Serializable, TipologiaDispositivi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipologiaDispositivi> map = new HashMap<Serializable, TipologiaDispositivi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipologiaDispositivi tipologiaDispositivi = fetchByPrimaryKey(primaryKey);

			if (tipologiaDispositivi != null) {
				map.put(primaryKey, tipologiaDispositivi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaDispositiviImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipologiaDispositivi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPOLOGIADISPOSITIVI_WHERE_PKS_IN);

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

			for (TipologiaDispositivi tipologiaDispositivi : (List<TipologiaDispositivi>)q.list()) {
				map.put(tipologiaDispositivi.getPrimaryKeyObj(),
					tipologiaDispositivi);

				cacheResult(tipologiaDispositivi);

				uncachedPrimaryKeys.remove(tipologiaDispositivi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipologiaDispositiviModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaDispositiviImpl.class, primaryKey, nullModel);
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
	 * Returns all the tipologia dispositivis.
	 *
	 * @return the tipologia dispositivis
	 */
	@Override
	public List<TipologiaDispositivi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologia dispositivis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaDispositiviModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia dispositivis
	 * @param end the upper bound of the range of tipologia dispositivis (not inclusive)
	 * @return the range of tipologia dispositivis
	 */
	@Override
	public List<TipologiaDispositivi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologia dispositivis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaDispositiviModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia dispositivis
	 * @param end the upper bound of the range of tipologia dispositivis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologia dispositivis
	 */
	@Override
	public List<TipologiaDispositivi> findAll(int start, int end,
		OrderByComparator<TipologiaDispositivi> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologia dispositivis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaDispositiviModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia dispositivis
	 * @param end the upper bound of the range of tipologia dispositivis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tipologia dispositivis
	 */
	@Override
	public List<TipologiaDispositivi> findAll(int start, int end,
		OrderByComparator<TipologiaDispositivi> orderByComparator,
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

		List<TipologiaDispositivi> list = null;

		if (retrieveFromCache) {
			list = (List<TipologiaDispositivi>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPOLOGIADISPOSITIVI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOLOGIADISPOSITIVI;

				if (pagination) {
					sql = sql.concat(TipologiaDispositiviModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipologiaDispositivi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipologiaDispositivi>)QueryUtil.list(q,
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
	 * Removes all the tipologia dispositivis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipologiaDispositivi tipologiaDispositivi : findAll()) {
			remove(tipologiaDispositivi);
		}
	}

	/**
	 * Returns the number of tipologia dispositivis.
	 *
	 * @return the number of tipologia dispositivis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPOLOGIADISPOSITIVI);

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
		return TipologiaDispositiviModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipologia dispositivi persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipologiaDispositiviImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPOLOGIADISPOSITIVI = "SELECT tipologiaDispositivi FROM TipologiaDispositivi tipologiaDispositivi";
	private static final String _SQL_SELECT_TIPOLOGIADISPOSITIVI_WHERE_PKS_IN = "SELECT tipologiaDispositivi FROM TipologiaDispositivi tipologiaDispositivi WHERE id_tipologia_dispositivi IN (";
	private static final String _SQL_COUNT_TIPOLOGIADISPOSITIVI = "SELECT COUNT(tipologiaDispositivi) FROM TipologiaDispositivi tipologiaDispositivi";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipologiaDispositivi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipologiaDispositivi exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TipologiaDispositiviPersistenceImpl.class);
}