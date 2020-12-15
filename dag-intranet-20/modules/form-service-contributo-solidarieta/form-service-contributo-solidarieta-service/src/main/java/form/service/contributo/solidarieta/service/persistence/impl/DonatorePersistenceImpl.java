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

package form.service.contributo.solidarieta.service.persistence.impl;

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

import form.service.contributo.solidarieta.exception.NoSuchDonatoreException;
import form.service.contributo.solidarieta.model.Donatore;
import form.service.contributo.solidarieta.model.impl.DonatoreImpl;
import form.service.contributo.solidarieta.model.impl.DonatoreModelImpl;
import form.service.contributo.solidarieta.service.persistence.DonatorePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the donatore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DonatorePersistenceImpl
	extends BasePersistenceImpl<Donatore> implements DonatorePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DonatoreUtil</code> to access the donatore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DonatoreImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DonatorePersistenceImpl() {
		setModelClass(Donatore.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}
	}

	/**
	 * Caches the donatore in the entity cache if it is enabled.
	 *
	 * @param donatore the donatore
	 */
	@Override
	public void cacheResult(Donatore donatore) {
		entityCache.putResult(
			DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
			donatore.getPrimaryKey(), donatore);

		donatore.resetOriginalValues();
	}

	/**
	 * Caches the donatores in the entity cache if it is enabled.
	 *
	 * @param donatores the donatores
	 */
	@Override
	public void cacheResult(List<Donatore> donatores) {
		for (Donatore donatore : donatores) {
			if (entityCache.getResult(
					DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
					donatore.getPrimaryKey()) == null) {

				cacheResult(donatore);
			}
			else {
				donatore.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all donatores.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DonatoreImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the donatore.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Donatore donatore) {
		entityCache.removeResult(
			DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
			donatore.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Donatore> donatores) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Donatore donatore : donatores) {
			entityCache.removeResult(
				DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
				donatore.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new donatore with the primary key. Does not add the donatore to the database.
	 *
	 * @param id the primary key for the new donatore
	 * @return the new donatore
	 */
	@Override
	public Donatore create(long id) {
		Donatore donatore = new DonatoreImpl();

		donatore.setNew(true);
		donatore.setPrimaryKey(id);

		return donatore;
	}

	/**
	 * Removes the donatore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore that was removed
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	@Override
	public Donatore remove(long id) throws NoSuchDonatoreException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the donatore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the donatore
	 * @return the donatore that was removed
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	@Override
	public Donatore remove(Serializable primaryKey)
		throws NoSuchDonatoreException {

		Session session = null;

		try {
			session = openSession();

			Donatore donatore = (Donatore)session.get(
				DonatoreImpl.class, primaryKey);

			if (donatore == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDonatoreException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(donatore);
		}
		catch (NoSuchDonatoreException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Donatore removeImpl(Donatore donatore) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(donatore)) {
				donatore = (Donatore)session.get(
					DonatoreImpl.class, donatore.getPrimaryKeyObj());
			}

			if (donatore != null) {
				session.delete(donatore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (donatore != null) {
			clearCache(donatore);
		}

		return donatore;
	}

	@Override
	public Donatore updateImpl(Donatore donatore) {
		boolean isNew = donatore.isNew();

		Session session = null;

		try {
			session = openSession();

			if (donatore.isNew()) {
				session.save(donatore);

				donatore.setNew(false);
			}
			else {
				donatore = (Donatore)session.merge(donatore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
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
			DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
			donatore.getPrimaryKey(), donatore, false);

		donatore.resetOriginalValues();

		return donatore;
	}

	/**
	 * Returns the donatore with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the donatore
	 * @return the donatore
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	@Override
	public Donatore findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDonatoreException {

		Donatore donatore = fetchByPrimaryKey(primaryKey);

		if (donatore == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDonatoreException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return donatore;
	}

	/**
	 * Returns the donatore with the primary key or throws a <code>NoSuchDonatoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	@Override
	public Donatore findByPrimaryKey(long id) throws NoSuchDonatoreException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the donatore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the donatore
	 * @return the donatore, or <code>null</code> if a donatore with the primary key could not be found
	 */
	@Override
	public Donatore fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Donatore donatore = (Donatore)serializable;

		if (donatore == null) {
			Session session = null;

			try {
				session = openSession();

				donatore = (Donatore)session.get(
					DonatoreImpl.class, primaryKey);

				if (donatore != null) {
					cacheResult(donatore);
				}
				else {
					entityCache.putResult(
						DonatoreModelImpl.ENTITY_CACHE_ENABLED,
						DonatoreImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return donatore;
	}

	/**
	 * Returns the donatore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore, or <code>null</code> if a donatore with the primary key could not be found
	 */
	@Override
	public Donatore fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Donatore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Donatore> map = new HashMap<Serializable, Donatore>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Donatore donatore = fetchByPrimaryKey(primaryKey);

			if (donatore != null) {
				map.put(primaryKey, donatore);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Donatore)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_DONATORE_WHERE_PKS_IN);

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

			for (Donatore donatore : (List<Donatore>)q.list()) {
				map.put(donatore.getPrimaryKeyObj(), donatore);

				cacheResult(donatore);

				uncachedPrimaryKeys.remove(donatore.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					DonatoreModelImpl.ENTITY_CACHE_ENABLED, DonatoreImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the donatores.
	 *
	 * @return the donatores
	 */
	@Override
	public List<Donatore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @return the range of donatores
	 */
	@Override
	public List<Donatore> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of donatores
	 */
	@Override
	public List<Donatore> findAll(
		int start, int end, OrderByComparator<Donatore> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of donatores
	 */
	@Override
	public List<Donatore> findAll(
		int start, int end, OrderByComparator<Donatore> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Donatore> list = null;

		if (useFinderCache) {
			list = (List<Donatore>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DONATORE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DONATORE;

				sql = sql.concat(DonatoreModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Donatore>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the donatores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Donatore donatore : findAll()) {
			remove(donatore);
		}
	}

	/**
	 * Returns the number of donatores.
	 *
	 * @return the number of donatores
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DONATORE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
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
		return DonatoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the donatore persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DonatoreModelImpl.ENTITY_CACHE_ENABLED,
			DonatoreModelImpl.FINDER_CACHE_ENABLED, DonatoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DonatoreModelImpl.ENTITY_CACHE_ENABLED,
			DonatoreModelImpl.FINDER_CACHE_ENABLED, DonatoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			DonatoreModelImpl.ENTITY_CACHE_ENABLED,
			DonatoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(DonatoreImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DONATORE =
		"SELECT donatore FROM Donatore donatore";

	private static final String _SQL_SELECT_DONATORE_WHERE_PKS_IN =
		"SELECT donatore FROM Donatore donatore WHERE id_ IN (";

	private static final String _SQL_COUNT_DONATORE =
		"SELECT COUNT(donatore) FROM Donatore donatore";

	private static final String _ORDER_BY_ENTITY_ALIAS = "donatore.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Donatore exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DonatorePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}