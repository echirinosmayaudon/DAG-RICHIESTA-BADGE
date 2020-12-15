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

import service.intranet.mef.exception.NoSuchTipologiaStampantiException;
import service.intranet.mef.model.TipologiaStampanti;
import service.intranet.mef.model.impl.TipologiaStampantiImpl;
import service.intranet.mef.model.impl.TipologiaStampantiModelImpl;
import service.intranet.mef.service.persistence.TipologiaStampantiPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tipologia stampanti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaStampantiPersistence
 * @see service.intranet.mef.service.persistence.TipologiaStampantiUtil
 * @generated
 */
@ProviderType
public class TipologiaStampantiPersistenceImpl extends BasePersistenceImpl<TipologiaStampanti>
	implements TipologiaStampantiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipologiaStampantiUtil} to access the tipologia stampanti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipologiaStampantiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaStampantiModelImpl.FINDER_CACHE_ENABLED,
			TipologiaStampantiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaStampantiModelImpl.FINDER_CACHE_ENABLED,
			TipologiaStampantiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaStampantiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TipologiaStampantiPersistenceImpl() {
		setModelClass(TipologiaStampanti.class);
	}

	/**
	 * Caches the tipologia stampanti in the entity cache if it is enabled.
	 *
	 * @param tipologiaStampanti the tipologia stampanti
	 */
	@Override
	public void cacheResult(TipologiaStampanti tipologiaStampanti) {
		entityCache.putResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaStampantiImpl.class, tipologiaStampanti.getPrimaryKey(),
			tipologiaStampanti);

		tipologiaStampanti.resetOriginalValues();
	}

	/**
	 * Caches the tipologia stampantis in the entity cache if it is enabled.
	 *
	 * @param tipologiaStampantis the tipologia stampantis
	 */
	@Override
	public void cacheResult(List<TipologiaStampanti> tipologiaStampantis) {
		for (TipologiaStampanti tipologiaStampanti : tipologiaStampantis) {
			if (entityCache.getResult(
						TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
						TipologiaStampantiImpl.class,
						tipologiaStampanti.getPrimaryKey()) == null) {
				cacheResult(tipologiaStampanti);
			}
			else {
				tipologiaStampanti.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipologia stampantis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipologiaStampantiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipologia stampanti.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipologiaStampanti tipologiaStampanti) {
		entityCache.removeResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaStampantiImpl.class, tipologiaStampanti.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipologiaStampanti> tipologiaStampantis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipologiaStampanti tipologiaStampanti : tipologiaStampantis) {
			entityCache.removeResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
				TipologiaStampantiImpl.class, tipologiaStampanti.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipologia stampanti with the primary key. Does not add the tipologia stampanti to the database.
	 *
	 * @param id_tipologia_stampanti the primary key for the new tipologia stampanti
	 * @return the new tipologia stampanti
	 */
	@Override
	public TipologiaStampanti create(long id_tipologia_stampanti) {
		TipologiaStampanti tipologiaStampanti = new TipologiaStampantiImpl();

		tipologiaStampanti.setNew(true);
		tipologiaStampanti.setPrimaryKey(id_tipologia_stampanti);

		return tipologiaStampanti;
	}

	/**
	 * Removes the tipologia stampanti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_tipologia_stampanti the primary key of the tipologia stampanti
	 * @return the tipologia stampanti that was removed
	 * @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	 */
	@Override
	public TipologiaStampanti remove(long id_tipologia_stampanti)
		throws NoSuchTipologiaStampantiException {
		return remove((Serializable)id_tipologia_stampanti);
	}

	/**
	 * Removes the tipologia stampanti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipologia stampanti
	 * @return the tipologia stampanti that was removed
	 * @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	 */
	@Override
	public TipologiaStampanti remove(Serializable primaryKey)
		throws NoSuchTipologiaStampantiException {
		Session session = null;

		try {
			session = openSession();

			TipologiaStampanti tipologiaStampanti = (TipologiaStampanti)session.get(TipologiaStampantiImpl.class,
					primaryKey);

			if (tipologiaStampanti == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipologiaStampantiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipologiaStampanti);
		}
		catch (NoSuchTipologiaStampantiException nsee) {
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
	protected TipologiaStampanti removeImpl(
		TipologiaStampanti tipologiaStampanti) {
		tipologiaStampanti = toUnwrappedModel(tipologiaStampanti);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipologiaStampanti)) {
				tipologiaStampanti = (TipologiaStampanti)session.get(TipologiaStampantiImpl.class,
						tipologiaStampanti.getPrimaryKeyObj());
			}

			if (tipologiaStampanti != null) {
				session.delete(tipologiaStampanti);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipologiaStampanti != null) {
			clearCache(tipologiaStampanti);
		}

		return tipologiaStampanti;
	}

	@Override
	public TipologiaStampanti updateImpl(TipologiaStampanti tipologiaStampanti) {
		tipologiaStampanti = toUnwrappedModel(tipologiaStampanti);

		boolean isNew = tipologiaStampanti.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipologiaStampanti.isNew()) {
				session.save(tipologiaStampanti);

				tipologiaStampanti.setNew(false);
			}
			else {
				tipologiaStampanti = (TipologiaStampanti)session.merge(tipologiaStampanti);
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

		entityCache.putResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaStampantiImpl.class, tipologiaStampanti.getPrimaryKey(),
			tipologiaStampanti, false);

		tipologiaStampanti.resetOriginalValues();

		return tipologiaStampanti;
	}

	protected TipologiaStampanti toUnwrappedModel(
		TipologiaStampanti tipologiaStampanti) {
		if (tipologiaStampanti instanceof TipologiaStampantiImpl) {
			return tipologiaStampanti;
		}

		TipologiaStampantiImpl tipologiaStampantiImpl = new TipologiaStampantiImpl();

		tipologiaStampantiImpl.setNew(tipologiaStampanti.isNew());
		tipologiaStampantiImpl.setPrimaryKey(tipologiaStampanti.getPrimaryKey());

		tipologiaStampantiImpl.setId_tipologia_stampanti(tipologiaStampanti.getId_tipologia_stampanti());
		tipologiaStampantiImpl.setDescrizione(tipologiaStampanti.getDescrizione());

		return tipologiaStampantiImpl;
	}

	/**
	 * Returns the tipologia stampanti with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia stampanti
	 * @return the tipologia stampanti
	 * @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	 */
	@Override
	public TipologiaStampanti findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipologiaStampantiException {
		TipologiaStampanti tipologiaStampanti = fetchByPrimaryKey(primaryKey);

		if (tipologiaStampanti == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipologiaStampantiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipologiaStampanti;
	}

	/**
	 * Returns the tipologia stampanti with the primary key or throws a {@link NoSuchTipologiaStampantiException} if it could not be found.
	 *
	 * @param id_tipologia_stampanti the primary key of the tipologia stampanti
	 * @return the tipologia stampanti
	 * @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	 */
	@Override
	public TipologiaStampanti findByPrimaryKey(long id_tipologia_stampanti)
		throws NoSuchTipologiaStampantiException {
		return findByPrimaryKey((Serializable)id_tipologia_stampanti);
	}

	/**
	 * Returns the tipologia stampanti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia stampanti
	 * @return the tipologia stampanti, or <code>null</code> if a tipologia stampanti with the primary key could not be found
	 */
	@Override
	public TipologiaStampanti fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
				TipologiaStampantiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipologiaStampanti tipologiaStampanti = (TipologiaStampanti)serializable;

		if (tipologiaStampanti == null) {
			Session session = null;

			try {
				session = openSession();

				tipologiaStampanti = (TipologiaStampanti)session.get(TipologiaStampantiImpl.class,
						primaryKey);

				if (tipologiaStampanti != null) {
					cacheResult(tipologiaStampanti);
				}
				else {
					entityCache.putResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
						TipologiaStampantiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaStampantiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipologiaStampanti;
	}

	/**
	 * Returns the tipologia stampanti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_tipologia_stampanti the primary key of the tipologia stampanti
	 * @return the tipologia stampanti, or <code>null</code> if a tipologia stampanti with the primary key could not be found
	 */
	@Override
	public TipologiaStampanti fetchByPrimaryKey(long id_tipologia_stampanti) {
		return fetchByPrimaryKey((Serializable)id_tipologia_stampanti);
	}

	@Override
	public Map<Serializable, TipologiaStampanti> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipologiaStampanti> map = new HashMap<Serializable, TipologiaStampanti>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipologiaStampanti tipologiaStampanti = fetchByPrimaryKey(primaryKey);

			if (tipologiaStampanti != null) {
				map.put(primaryKey, tipologiaStampanti);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaStampantiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipologiaStampanti)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPOLOGIASTAMPANTI_WHERE_PKS_IN);

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

			for (TipologiaStampanti tipologiaStampanti : (List<TipologiaStampanti>)q.list()) {
				map.put(tipologiaStampanti.getPrimaryKeyObj(),
					tipologiaStampanti);

				cacheResult(tipologiaStampanti);

				uncachedPrimaryKeys.remove(tipologiaStampanti.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipologiaStampantiModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaStampantiImpl.class, primaryKey, nullModel);
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
	 * Returns all the tipologia stampantis.
	 *
	 * @return the tipologia stampantis
	 */
	@Override
	public List<TipologiaStampanti> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologia stampantis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia stampantis
	 * @param end the upper bound of the range of tipologia stampantis (not inclusive)
	 * @return the range of tipologia stampantis
	 */
	@Override
	public List<TipologiaStampanti> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologia stampantis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia stampantis
	 * @param end the upper bound of the range of tipologia stampantis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologia stampantis
	 */
	@Override
	public List<TipologiaStampanti> findAll(int start, int end,
		OrderByComparator<TipologiaStampanti> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologia stampantis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia stampantis
	 * @param end the upper bound of the range of tipologia stampantis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tipologia stampantis
	 */
	@Override
	public List<TipologiaStampanti> findAll(int start, int end,
		OrderByComparator<TipologiaStampanti> orderByComparator,
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

		List<TipologiaStampanti> list = null;

		if (retrieveFromCache) {
			list = (List<TipologiaStampanti>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPOLOGIASTAMPANTI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOLOGIASTAMPANTI;

				if (pagination) {
					sql = sql.concat(TipologiaStampantiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipologiaStampanti>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipologiaStampanti>)QueryUtil.list(q,
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
	 * Removes all the tipologia stampantis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipologiaStampanti tipologiaStampanti : findAll()) {
			remove(tipologiaStampanti);
		}
	}

	/**
	 * Returns the number of tipologia stampantis.
	 *
	 * @return the number of tipologia stampantis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPOLOGIASTAMPANTI);

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
		return TipologiaStampantiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipologia stampanti persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipologiaStampantiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPOLOGIASTAMPANTI = "SELECT tipologiaStampanti FROM TipologiaStampanti tipologiaStampanti";
	private static final String _SQL_SELECT_TIPOLOGIASTAMPANTI_WHERE_PKS_IN = "SELECT tipologiaStampanti FROM TipologiaStampanti tipologiaStampanti WHERE id_tipologia_stampanti IN (";
	private static final String _SQL_COUNT_TIPOLOGIASTAMPANTI = "SELECT COUNT(tipologiaStampanti) FROM TipologiaStampanti tipologiaStampanti";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipologiaStampanti.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipologiaStampanti exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TipologiaStampantiPersistenceImpl.class);
}