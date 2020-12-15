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

package servizio.beni.facile.consumo.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.beni.facile.consumo.exception.NoSuchPeriodicitaException;
import servizio.beni.facile.consumo.model.Periodicita;
import servizio.beni.facile.consumo.model.impl.PeriodicitaImpl;
import servizio.beni.facile.consumo.model.impl.PeriodicitaModelImpl;
import servizio.beni.facile.consumo.service.persistence.PeriodicitaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the periodicita service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PeriodicitaPersistence
 * @see servizio.beni.facile.consumo.service.persistence.PeriodicitaUtil
 * @generated
 */
@ProviderType
public class PeriodicitaPersistenceImpl extends BasePersistenceImpl<Periodicita>
	implements PeriodicitaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PeriodicitaUtil} to access the periodicita persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PeriodicitaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaModelImpl.FINDER_CACHE_ENABLED, PeriodicitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaModelImpl.FINDER_CACHE_ENABLED, PeriodicitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PeriodicitaPersistenceImpl() {
		setModelClass(Periodicita.class);
	}

	/**
	 * Caches the periodicita in the entity cache if it is enabled.
	 *
	 * @param periodicita the periodicita
	 */
	@Override
	public void cacheResult(Periodicita periodicita) {
		entityCache.putResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaImpl.class, periodicita.getPrimaryKey(), periodicita);

		periodicita.resetOriginalValues();
	}

	/**
	 * Caches the periodicitas in the entity cache if it is enabled.
	 *
	 * @param periodicitas the periodicitas
	 */
	@Override
	public void cacheResult(List<Periodicita> periodicitas) {
		for (Periodicita periodicita : periodicitas) {
			if (entityCache.getResult(
						PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
						PeriodicitaImpl.class, periodicita.getPrimaryKey()) == null) {
				cacheResult(periodicita);
			}
			else {
				periodicita.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all periodicitas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PeriodicitaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the periodicita.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Periodicita periodicita) {
		entityCache.removeResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaImpl.class, periodicita.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Periodicita> periodicitas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Periodicita periodicita : periodicitas) {
			entityCache.removeResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
				PeriodicitaImpl.class, periodicita.getPrimaryKey());
		}
	}

	/**
	 * Creates a new periodicita with the primary key. Does not add the periodicita to the database.
	 *
	 * @param id the primary key for the new periodicita
	 * @return the new periodicita
	 */
	@Override
	public Periodicita create(long id) {
		Periodicita periodicita = new PeriodicitaImpl();

		periodicita.setNew(true);
		periodicita.setPrimaryKey(id);

		return periodicita;
	}

	/**
	 * Removes the periodicita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the periodicita
	 * @return the periodicita that was removed
	 * @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	 */
	@Override
	public Periodicita remove(long id) throws NoSuchPeriodicitaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the periodicita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the periodicita
	 * @return the periodicita that was removed
	 * @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	 */
	@Override
	public Periodicita remove(Serializable primaryKey)
		throws NoSuchPeriodicitaException {
		Session session = null;

		try {
			session = openSession();

			Periodicita periodicita = (Periodicita)session.get(PeriodicitaImpl.class,
					primaryKey);

			if (periodicita == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPeriodicitaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(periodicita);
		}
		catch (NoSuchPeriodicitaException nsee) {
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
	protected Periodicita removeImpl(Periodicita periodicita) {
		periodicita = toUnwrappedModel(periodicita);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(periodicita)) {
				periodicita = (Periodicita)session.get(PeriodicitaImpl.class,
						periodicita.getPrimaryKeyObj());
			}

			if (periodicita != null) {
				session.delete(periodicita);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (periodicita != null) {
			clearCache(periodicita);
		}

		return periodicita;
	}

	@Override
	public Periodicita updateImpl(Periodicita periodicita) {
		periodicita = toUnwrappedModel(periodicita);

		boolean isNew = periodicita.isNew();

		Session session = null;

		try {
			session = openSession();

			if (periodicita.isNew()) {
				session.save(periodicita);

				periodicita.setNew(false);
			}
			else {
				periodicita = (Periodicita)session.merge(periodicita);
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

		entityCache.putResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaImpl.class, periodicita.getPrimaryKey(), periodicita,
			false);

		periodicita.resetOriginalValues();

		return periodicita;
	}

	protected Periodicita toUnwrappedModel(Periodicita periodicita) {
		if (periodicita instanceof PeriodicitaImpl) {
			return periodicita;
		}

		PeriodicitaImpl periodicitaImpl = new PeriodicitaImpl();

		periodicitaImpl.setNew(periodicita.isNew());
		periodicitaImpl.setPrimaryKey(periodicita.getPrimaryKey());

		periodicitaImpl.setId(periodicita.getId());
		periodicitaImpl.setDescrizione(periodicita.getDescrizione());

		return periodicitaImpl;
	}

	/**
	 * Returns the periodicita with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the periodicita
	 * @return the periodicita
	 * @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	 */
	@Override
	public Periodicita findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPeriodicitaException {
		Periodicita periodicita = fetchByPrimaryKey(primaryKey);

		if (periodicita == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPeriodicitaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return periodicita;
	}

	/**
	 * Returns the periodicita with the primary key or throws a {@link NoSuchPeriodicitaException} if it could not be found.
	 *
	 * @param id the primary key of the periodicita
	 * @return the periodicita
	 * @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	 */
	@Override
	public Periodicita findByPrimaryKey(long id)
		throws NoSuchPeriodicitaException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the periodicita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the periodicita
	 * @return the periodicita, or <code>null</code> if a periodicita with the primary key could not be found
	 */
	@Override
	public Periodicita fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
				PeriodicitaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Periodicita periodicita = (Periodicita)serializable;

		if (periodicita == null) {
			Session session = null;

			try {
				session = openSession();

				periodicita = (Periodicita)session.get(PeriodicitaImpl.class,
						primaryKey);

				if (periodicita != null) {
					cacheResult(periodicita);
				}
				else {
					entityCache.putResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
						PeriodicitaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
					PeriodicitaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return periodicita;
	}

	/**
	 * Returns the periodicita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the periodicita
	 * @return the periodicita, or <code>null</code> if a periodicita with the primary key could not be found
	 */
	@Override
	public Periodicita fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Periodicita> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Periodicita> map = new HashMap<Serializable, Periodicita>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Periodicita periodicita = fetchByPrimaryKey(primaryKey);

			if (periodicita != null) {
				map.put(primaryKey, periodicita);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
					PeriodicitaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Periodicita)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PERIODICITA_WHERE_PKS_IN);

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

			for (Periodicita periodicita : (List<Periodicita>)q.list()) {
				map.put(periodicita.getPrimaryKeyObj(), periodicita);

				cacheResult(periodicita);

				uncachedPrimaryKeys.remove(periodicita.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PeriodicitaModelImpl.ENTITY_CACHE_ENABLED,
					PeriodicitaImpl.class, primaryKey, nullModel);
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
	 * Returns all the periodicitas.
	 *
	 * @return the periodicitas
	 */
	@Override
	public List<Periodicita> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the periodicitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of periodicitas
	 * @param end the upper bound of the range of periodicitas (not inclusive)
	 * @return the range of periodicitas
	 */
	@Override
	public List<Periodicita> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the periodicitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of periodicitas
	 * @param end the upper bound of the range of periodicitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of periodicitas
	 */
	@Override
	public List<Periodicita> findAll(int start, int end,
		OrderByComparator<Periodicita> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the periodicitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of periodicitas
	 * @param end the upper bound of the range of periodicitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of periodicitas
	 */
	@Override
	public List<Periodicita> findAll(int start, int end,
		OrderByComparator<Periodicita> orderByComparator,
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

		List<Periodicita> list = null;

		if (retrieveFromCache) {
			list = (List<Periodicita>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERIODICITA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERIODICITA;

				if (pagination) {
					sql = sql.concat(PeriodicitaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Periodicita>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Periodicita>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the periodicitas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Periodicita periodicita : findAll()) {
			remove(periodicita);
		}
	}

	/**
	 * Returns the number of periodicitas.
	 *
	 * @return the number of periodicitas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERIODICITA);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PeriodicitaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the periodicita persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PeriodicitaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PERIODICITA = "SELECT periodicita FROM Periodicita periodicita";
	private static final String _SQL_SELECT_PERIODICITA_WHERE_PKS_IN = "SELECT periodicita FROM Periodicita periodicita WHERE id_ IN (";
	private static final String _SQL_COUNT_PERIODICITA = "SELECT COUNT(periodicita) FROM Periodicita periodicita";
	private static final String _ORDER_BY_ENTITY_ALIAS = "periodicita.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Periodicita exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PeriodicitaPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}