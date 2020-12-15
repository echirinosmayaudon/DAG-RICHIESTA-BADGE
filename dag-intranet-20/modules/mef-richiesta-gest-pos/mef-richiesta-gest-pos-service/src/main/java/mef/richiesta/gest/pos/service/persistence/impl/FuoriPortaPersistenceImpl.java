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

package mef.richiesta.gest.pos.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mef.richiesta.gest.pos.exception.NoSuchFuoriPortaException;
import mef.richiesta.gest.pos.model.FuoriPorta;
import mef.richiesta.gest.pos.model.impl.FuoriPortaImpl;
import mef.richiesta.gest.pos.model.impl.FuoriPortaModelImpl;
import mef.richiesta.gest.pos.service.persistence.FuoriPortaPersistence;

/**
 * The persistence implementation for the fuori porta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FuoriPortaPersistenceImpl
	extends BasePersistenceImpl<FuoriPorta> implements FuoriPortaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FuoriPortaUtil</code> to access the fuori porta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FuoriPortaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FuoriPortaPersistenceImpl() {
		setModelClass(FuoriPorta.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("desc", "desc_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the fuori porta in the entity cache if it is enabled.
	 *
	 * @param fuoriPorta the fuori porta
	 */
	@Override
	public void cacheResult(FuoriPorta fuoriPorta) {
		entityCache.putResult(
			FuoriPortaModelImpl.ENTITY_CACHE_ENABLED, FuoriPortaImpl.class,
			fuoriPorta.getPrimaryKey(), fuoriPorta);

		fuoriPorta.resetOriginalValues();
	}

	/**
	 * Caches the fuori portas in the entity cache if it is enabled.
	 *
	 * @param fuoriPortas the fuori portas
	 */
	@Override
	public void cacheResult(List<FuoriPorta> fuoriPortas) {
		for (FuoriPorta fuoriPorta : fuoriPortas) {
			if (entityCache.getResult(
					FuoriPortaModelImpl.ENTITY_CACHE_ENABLED,
					FuoriPortaImpl.class, fuoriPorta.getPrimaryKey()) == null) {

				cacheResult(fuoriPorta);
			}
			else {
				fuoriPorta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fuori portas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FuoriPortaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fuori porta.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FuoriPorta fuoriPorta) {
		entityCache.removeResult(
			FuoriPortaModelImpl.ENTITY_CACHE_ENABLED, FuoriPortaImpl.class,
			fuoriPorta.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FuoriPorta> fuoriPortas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FuoriPorta fuoriPorta : fuoriPortas) {
			entityCache.removeResult(
				FuoriPortaModelImpl.ENTITY_CACHE_ENABLED, FuoriPortaImpl.class,
				fuoriPorta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fuori porta with the primary key. Does not add the fuori porta to the database.
	 *
	 * @param id_pk_fuoriPorta the primary key for the new fuori porta
	 * @return the new fuori porta
	 */
	@Override
	public FuoriPorta create(long id_pk_fuoriPorta) {
		FuoriPorta fuoriPorta = new FuoriPortaImpl();

		fuoriPorta.setNew(true);
		fuoriPorta.setPrimaryKey(id_pk_fuoriPorta);

		return fuoriPorta;
	}

	/**
	 * Removes the fuori porta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta that was removed
	 * @throws NoSuchFuoriPortaException if a fuori porta with the primary key could not be found
	 */
	@Override
	public FuoriPorta remove(long id_pk_fuoriPorta)
		throws NoSuchFuoriPortaException {

		return remove((Serializable)id_pk_fuoriPorta);
	}

	/**
	 * Removes the fuori porta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fuori porta
	 * @return the fuori porta that was removed
	 * @throws NoSuchFuoriPortaException if a fuori porta with the primary key could not be found
	 */
	@Override
	public FuoriPorta remove(Serializable primaryKey)
		throws NoSuchFuoriPortaException {

		Session session = null;

		try {
			session = openSession();

			FuoriPorta fuoriPorta = (FuoriPorta)session.get(
				FuoriPortaImpl.class, primaryKey);

			if (fuoriPorta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFuoriPortaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fuoriPorta);
		}
		catch (NoSuchFuoriPortaException nsee) {
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
	protected FuoriPorta removeImpl(FuoriPorta fuoriPorta) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fuoriPorta)) {
				fuoriPorta = (FuoriPorta)session.get(
					FuoriPortaImpl.class, fuoriPorta.getPrimaryKeyObj());
			}

			if (fuoriPorta != null) {
				session.delete(fuoriPorta);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fuoriPorta != null) {
			clearCache(fuoriPorta);
		}

		return fuoriPorta;
	}

	@Override
	public FuoriPorta updateImpl(FuoriPorta fuoriPorta) {
		boolean isNew = fuoriPorta.isNew();

		Session session = null;

		try {
			session = openSession();

			if (fuoriPorta.isNew()) {
				session.save(fuoriPorta);

				fuoriPorta.setNew(false);
			}
			else {
				fuoriPorta = (FuoriPorta)session.merge(fuoriPorta);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			FuoriPortaModelImpl.ENTITY_CACHE_ENABLED, FuoriPortaImpl.class,
			fuoriPorta.getPrimaryKey(), fuoriPorta, false);

		fuoriPorta.resetOriginalValues();

		return fuoriPorta;
	}

	/**
	 * Returns the fuori porta with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fuori porta
	 * @return the fuori porta
	 * @throws NoSuchFuoriPortaException if a fuori porta with the primary key could not be found
	 */
	@Override
	public FuoriPorta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFuoriPortaException {

		FuoriPorta fuoriPorta = fetchByPrimaryKey(primaryKey);

		if (fuoriPorta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFuoriPortaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fuoriPorta;
	}

	/**
	 * Returns the fuori porta with the primary key or throws a <code>NoSuchFuoriPortaException</code> if it could not be found.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta
	 * @throws NoSuchFuoriPortaException if a fuori porta with the primary key could not be found
	 */
	@Override
	public FuoriPorta findByPrimaryKey(long id_pk_fuoriPorta)
		throws NoSuchFuoriPortaException {

		return findByPrimaryKey((Serializable)id_pk_fuoriPorta);
	}

	/**
	 * Returns the fuori porta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fuori porta
	 * @return the fuori porta, or <code>null</code> if a fuori porta with the primary key could not be found
	 */
	@Override
	public FuoriPorta fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			FuoriPortaModelImpl.ENTITY_CACHE_ENABLED, FuoriPortaImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FuoriPorta fuoriPorta = (FuoriPorta)serializable;

		if (fuoriPorta == null) {
			Session session = null;

			try {
				session = openSession();

				fuoriPorta = (FuoriPorta)session.get(
					FuoriPortaImpl.class, primaryKey);

				if (fuoriPorta != null) {
					cacheResult(fuoriPorta);
				}
				else {
					entityCache.putResult(
						FuoriPortaModelImpl.ENTITY_CACHE_ENABLED,
						FuoriPortaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					FuoriPortaModelImpl.ENTITY_CACHE_ENABLED,
					FuoriPortaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fuoriPorta;
	}

	/**
	 * Returns the fuori porta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta, or <code>null</code> if a fuori porta with the primary key could not be found
	 */
	@Override
	public FuoriPorta fetchByPrimaryKey(long id_pk_fuoriPorta) {
		return fetchByPrimaryKey((Serializable)id_pk_fuoriPorta);
	}

	@Override
	public Map<Serializable, FuoriPorta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FuoriPorta> map =
			new HashMap<Serializable, FuoriPorta>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FuoriPorta fuoriPorta = fetchByPrimaryKey(primaryKey);

			if (fuoriPorta != null) {
				map.put(primaryKey, fuoriPorta);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				FuoriPortaModelImpl.ENTITY_CACHE_ENABLED, FuoriPortaImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FuoriPorta)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_FUORIPORTA_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (FuoriPorta fuoriPorta : (List<FuoriPorta>)q.list()) {
				map.put(fuoriPorta.getPrimaryKeyObj(), fuoriPorta);

				cacheResult(fuoriPorta);

				uncachedPrimaryKeys.remove(fuoriPorta.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					FuoriPortaModelImpl.ENTITY_CACHE_ENABLED,
					FuoriPortaImpl.class, primaryKey, nullModel);
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
	 * Returns all the fuori portas.
	 *
	 * @return the fuori portas
	 */
	@Override
	public List<FuoriPorta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fuori portas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fuori portas
	 * @param end the upper bound of the range of fuori portas (not inclusive)
	 * @return the range of fuori portas
	 */
	@Override
	public List<FuoriPorta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fuori portas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fuori portas
	 * @param end the upper bound of the range of fuori portas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fuori portas
	 */
	@Override
	public List<FuoriPorta> findAll(
		int start, int end, OrderByComparator<FuoriPorta> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fuori portas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fuori portas
	 * @param end the upper bound of the range of fuori portas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fuori portas
	 */
	@Override
	public List<FuoriPorta> findAll(
		int start, int end, OrderByComparator<FuoriPorta> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<FuoriPorta> list = null;

		if (retrieveFromCache) {
			list = (List<FuoriPorta>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FUORIPORTA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUORIPORTA;

				if (pagination) {
					sql = sql.concat(FuoriPortaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FuoriPorta>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FuoriPorta>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Removes all the fuori portas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FuoriPorta fuoriPorta : findAll()) {
			remove(fuoriPorta);
		}
	}

	/**
	 * Returns the number of fuori portas.
	 *
	 * @return the number of fuori portas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FUORIPORTA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FuoriPortaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fuori porta persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			FuoriPortaModelImpl.ENTITY_CACHE_ENABLED,
			FuoriPortaModelImpl.FINDER_CACHE_ENABLED, FuoriPortaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FuoriPortaModelImpl.ENTITY_CACHE_ENABLED,
			FuoriPortaModelImpl.FINDER_CACHE_ENABLED, FuoriPortaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			FuoriPortaModelImpl.ENTITY_CACHE_ENABLED,
			FuoriPortaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(FuoriPortaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FUORIPORTA =
		"SELECT fuoriPorta FROM FuoriPorta fuoriPorta";

	private static final String _SQL_SELECT_FUORIPORTA_WHERE_PKS_IN =
		"SELECT fuoriPorta FROM FuoriPorta fuoriPorta WHERE id_pk_fuoriPorta IN (";

	private static final String _SQL_COUNT_FUORIPORTA =
		"SELECT COUNT(fuoriPorta) FROM FuoriPorta fuoriPorta";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fuoriPorta.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FuoriPorta exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FuoriPortaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"desc"});

}