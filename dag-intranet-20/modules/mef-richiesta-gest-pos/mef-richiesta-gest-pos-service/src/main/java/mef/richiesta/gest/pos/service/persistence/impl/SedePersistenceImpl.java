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

import mef.richiesta.gest.pos.exception.NoSuchSedeException;
import mef.richiesta.gest.pos.model.Sede;
import mef.richiesta.gest.pos.model.impl.SedeImpl;
import mef.richiesta.gest.pos.model.impl.SedeModelImpl;
import mef.richiesta.gest.pos.service.persistence.SedePersistence;

/**
 * The persistence implementation for the sede service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SedePersistenceImpl
	extends BasePersistenceImpl<Sede> implements SedePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SedeUtil</code> to access the sede persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SedeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SedePersistenceImpl() {
		setModelClass(Sede.class);

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
	 * Caches the sede in the entity cache if it is enabled.
	 *
	 * @param sede the sede
	 */
	@Override
	public void cacheResult(Sede sede) {
		entityCache.putResult(
			SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
			sede.getPrimaryKey(), sede);

		sede.resetOriginalValues();
	}

	/**
	 * Caches the sedes in the entity cache if it is enabled.
	 *
	 * @param sedes the sedes
	 */
	@Override
	public void cacheResult(List<Sede> sedes) {
		for (Sede sede : sedes) {
			if (entityCache.getResult(
					SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
					sede.getPrimaryKey()) == null) {

				cacheResult(sede);
			}
			else {
				sede.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sedes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SedeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sede.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sede sede) {
		entityCache.removeResult(
			SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
			sede.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sede> sedes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sede sede : sedes) {
			entityCache.removeResult(
				SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
				sede.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sede with the primary key. Does not add the sede to the database.
	 *
	 * @param id_pk_sede the primary key for the new sede
	 * @return the new sede
	 */
	@Override
	public Sede create(long id_pk_sede) {
		Sede sede = new SedeImpl();

		sede.setNew(true);
		sede.setPrimaryKey(id_pk_sede);

		return sede;
	}

	/**
	 * Removes the sede with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_sede the primary key of the sede
	 * @return the sede that was removed
	 * @throws NoSuchSedeException if a sede with the primary key could not be found
	 */
	@Override
	public Sede remove(long id_pk_sede) throws NoSuchSedeException {
		return remove((Serializable)id_pk_sede);
	}

	/**
	 * Removes the sede with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sede
	 * @return the sede that was removed
	 * @throws NoSuchSedeException if a sede with the primary key could not be found
	 */
	@Override
	public Sede remove(Serializable primaryKey) throws NoSuchSedeException {
		Session session = null;

		try {
			session = openSession();

			Sede sede = (Sede)session.get(SedeImpl.class, primaryKey);

			if (sede == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSedeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sede);
		}
		catch (NoSuchSedeException nsee) {
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
	protected Sede removeImpl(Sede sede) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sede)) {
				sede = (Sede)session.get(
					SedeImpl.class, sede.getPrimaryKeyObj());
			}

			if (sede != null) {
				session.delete(sede);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sede != null) {
			clearCache(sede);
		}

		return sede;
	}

	@Override
	public Sede updateImpl(Sede sede) {
		boolean isNew = sede.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sede.isNew()) {
				session.save(sede);

				sede.setNew(false);
			}
			else {
				sede = (Sede)session.merge(sede);
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
			SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
			sede.getPrimaryKey(), sede, false);

		sede.resetOriginalValues();

		return sede;
	}

	/**
	 * Returns the sede with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sede
	 * @return the sede
	 * @throws NoSuchSedeException if a sede with the primary key could not be found
	 */
	@Override
	public Sede findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSedeException {

		Sede sede = fetchByPrimaryKey(primaryKey);

		if (sede == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSedeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sede;
	}

	/**
	 * Returns the sede with the primary key or throws a <code>NoSuchSedeException</code> if it could not be found.
	 *
	 * @param id_pk_sede the primary key of the sede
	 * @return the sede
	 * @throws NoSuchSedeException if a sede with the primary key could not be found
	 */
	@Override
	public Sede findByPrimaryKey(long id_pk_sede) throws NoSuchSedeException {
		return findByPrimaryKey((Serializable)id_pk_sede);
	}

	/**
	 * Returns the sede with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sede
	 * @return the sede, or <code>null</code> if a sede with the primary key could not be found
	 */
	@Override
	public Sede fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Sede sede = (Sede)serializable;

		if (sede == null) {
			Session session = null;

			try {
				session = openSession();

				sede = (Sede)session.get(SedeImpl.class, primaryKey);

				if (sede != null) {
					cacheResult(sede);
				}
				else {
					entityCache.putResult(
						SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sede;
	}

	/**
	 * Returns the sede with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk_sede the primary key of the sede
	 * @return the sede, or <code>null</code> if a sede with the primary key could not be found
	 */
	@Override
	public Sede fetchByPrimaryKey(long id_pk_sede) {
		return fetchByPrimaryKey((Serializable)id_pk_sede);
	}

	@Override
	public Map<Serializable, Sede> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Sede> map = new HashMap<Serializable, Sede>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Sede sede = fetchByPrimaryKey(primaryKey);

			if (sede != null) {
				map.put(primaryKey, sede);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Sede)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_SEDE_WHERE_PKS_IN);

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

			for (Sede sede : (List<Sede>)q.list()) {
				map.put(sede.getPrimaryKeyObj(), sede);

				cacheResult(sede);

				uncachedPrimaryKeys.remove(sede.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					SedeModelImpl.ENTITY_CACHE_ENABLED, SedeImpl.class,
					primaryKey, nullModel);
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
	 * Returns all the sedes.
	 *
	 * @return the sedes
	 */
	@Override
	public List<Sede> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sedes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedes
	 * @param end the upper bound of the range of sedes (not inclusive)
	 * @return the range of sedes
	 */
	@Override
	public List<Sede> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sedes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedes
	 * @param end the upper bound of the range of sedes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sedes
	 */
	@Override
	public List<Sede> findAll(
		int start, int end, OrderByComparator<Sede> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sedes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedes
	 * @param end the upper bound of the range of sedes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sedes
	 */
	@Override
	public List<Sede> findAll(
		int start, int end, OrderByComparator<Sede> orderByComparator,
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

		List<Sede> list = null;

		if (retrieveFromCache) {
			list = (List<Sede>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEDE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEDE;

				if (pagination) {
					sql = sql.concat(SedeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sede>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Sede>)QueryUtil.list(
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
	 * Removes all the sedes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Sede sede : findAll()) {
			remove(sede);
		}
	}

	/**
	 * Returns the number of sedes.
	 *
	 * @return the number of sedes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEDE);

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
		return SedeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sede persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SedeModelImpl.ENTITY_CACHE_ENABLED,
			SedeModelImpl.FINDER_CACHE_ENABLED, SedeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SedeModelImpl.ENTITY_CACHE_ENABLED,
			SedeModelImpl.FINDER_CACHE_ENABLED, SedeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			SedeModelImpl.ENTITY_CACHE_ENABLED,
			SedeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(SedeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SEDE = "SELECT sede FROM Sede sede";

	private static final String _SQL_SELECT_SEDE_WHERE_PKS_IN =
		"SELECT sede FROM Sede sede WHERE id_pk_sede IN (";

	private static final String _SQL_COUNT_SEDE =
		"SELECT COUNT(sede) FROM Sede sede";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sede.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Sede exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SedePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"desc"});

}