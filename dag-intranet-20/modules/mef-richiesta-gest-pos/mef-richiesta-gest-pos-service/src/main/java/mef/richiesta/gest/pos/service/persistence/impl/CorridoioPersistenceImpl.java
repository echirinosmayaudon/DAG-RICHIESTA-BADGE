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

import mef.richiesta.gest.pos.exception.NoSuchCorridoioException;
import mef.richiesta.gest.pos.model.Corridoio;
import mef.richiesta.gest.pos.model.impl.CorridoioImpl;
import mef.richiesta.gest.pos.model.impl.CorridoioModelImpl;
import mef.richiesta.gest.pos.service.persistence.CorridoioPersistence;

/**
 * The persistence implementation for the corridoio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CorridoioPersistenceImpl
	extends BasePersistenceImpl<Corridoio> implements CorridoioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CorridoioUtil</code> to access the corridoio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CorridoioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CorridoioPersistenceImpl() {
		setModelClass(Corridoio.class);

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
	 * Caches the corridoio in the entity cache if it is enabled.
	 *
	 * @param corridoio the corridoio
	 */
	@Override
	public void cacheResult(Corridoio corridoio) {
		entityCache.putResult(
			CorridoioModelImpl.ENTITY_CACHE_ENABLED, CorridoioImpl.class,
			corridoio.getPrimaryKey(), corridoio);

		corridoio.resetOriginalValues();
	}

	/**
	 * Caches the corridoios in the entity cache if it is enabled.
	 *
	 * @param corridoios the corridoios
	 */
	@Override
	public void cacheResult(List<Corridoio> corridoios) {
		for (Corridoio corridoio : corridoios) {
			if (entityCache.getResult(
					CorridoioModelImpl.ENTITY_CACHE_ENABLED,
					CorridoioImpl.class, corridoio.getPrimaryKey()) == null) {

				cacheResult(corridoio);
			}
			else {
				corridoio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all corridoios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CorridoioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the corridoio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Corridoio corridoio) {
		entityCache.removeResult(
			CorridoioModelImpl.ENTITY_CACHE_ENABLED, CorridoioImpl.class,
			corridoio.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Corridoio> corridoios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Corridoio corridoio : corridoios) {
			entityCache.removeResult(
				CorridoioModelImpl.ENTITY_CACHE_ENABLED, CorridoioImpl.class,
				corridoio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new corridoio with the primary key. Does not add the corridoio to the database.
	 *
	 * @param id_pk_corridoio the primary key for the new corridoio
	 * @return the new corridoio
	 */
	@Override
	public Corridoio create(long id_pk_corridoio) {
		Corridoio corridoio = new CorridoioImpl();

		corridoio.setNew(true);
		corridoio.setPrimaryKey(id_pk_corridoio);

		return corridoio;
	}

	/**
	 * Removes the corridoio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio that was removed
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	@Override
	public Corridoio remove(long id_pk_corridoio)
		throws NoSuchCorridoioException {

		return remove((Serializable)id_pk_corridoio);
	}

	/**
	 * Removes the corridoio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the corridoio
	 * @return the corridoio that was removed
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	@Override
	public Corridoio remove(Serializable primaryKey)
		throws NoSuchCorridoioException {

		Session session = null;

		try {
			session = openSession();

			Corridoio corridoio = (Corridoio)session.get(
				CorridoioImpl.class, primaryKey);

			if (corridoio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCorridoioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(corridoio);
		}
		catch (NoSuchCorridoioException nsee) {
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
	protected Corridoio removeImpl(Corridoio corridoio) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(corridoio)) {
				corridoio = (Corridoio)session.get(
					CorridoioImpl.class, corridoio.getPrimaryKeyObj());
			}

			if (corridoio != null) {
				session.delete(corridoio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (corridoio != null) {
			clearCache(corridoio);
		}

		return corridoio;
	}

	@Override
	public Corridoio updateImpl(Corridoio corridoio) {
		boolean isNew = corridoio.isNew();

		Session session = null;

		try {
			session = openSession();

			if (corridoio.isNew()) {
				session.save(corridoio);

				corridoio.setNew(false);
			}
			else {
				corridoio = (Corridoio)session.merge(corridoio);
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
			CorridoioModelImpl.ENTITY_CACHE_ENABLED, CorridoioImpl.class,
			corridoio.getPrimaryKey(), corridoio, false);

		corridoio.resetOriginalValues();

		return corridoio;
	}

	/**
	 * Returns the corridoio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the corridoio
	 * @return the corridoio
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	@Override
	public Corridoio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCorridoioException {

		Corridoio corridoio = fetchByPrimaryKey(primaryKey);

		if (corridoio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCorridoioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return corridoio;
	}

	/**
	 * Returns the corridoio with the primary key or throws a <code>NoSuchCorridoioException</code> if it could not be found.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	@Override
	public Corridoio findByPrimaryKey(long id_pk_corridoio)
		throws NoSuchCorridoioException {

		return findByPrimaryKey((Serializable)id_pk_corridoio);
	}

	/**
	 * Returns the corridoio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the corridoio
	 * @return the corridoio, or <code>null</code> if a corridoio with the primary key could not be found
	 */
	@Override
	public Corridoio fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CorridoioModelImpl.ENTITY_CACHE_ENABLED, CorridoioImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Corridoio corridoio = (Corridoio)serializable;

		if (corridoio == null) {
			Session session = null;

			try {
				session = openSession();

				corridoio = (Corridoio)session.get(
					CorridoioImpl.class, primaryKey);

				if (corridoio != null) {
					cacheResult(corridoio);
				}
				else {
					entityCache.putResult(
						CorridoioModelImpl.ENTITY_CACHE_ENABLED,
						CorridoioImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CorridoioModelImpl.ENTITY_CACHE_ENABLED,
					CorridoioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return corridoio;
	}

	/**
	 * Returns the corridoio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio, or <code>null</code> if a corridoio with the primary key could not be found
	 */
	@Override
	public Corridoio fetchByPrimaryKey(long id_pk_corridoio) {
		return fetchByPrimaryKey((Serializable)id_pk_corridoio);
	}

	@Override
	public Map<Serializable, Corridoio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Corridoio> map =
			new HashMap<Serializable, Corridoio>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Corridoio corridoio = fetchByPrimaryKey(primaryKey);

			if (corridoio != null) {
				map.put(primaryKey, corridoio);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CorridoioModelImpl.ENTITY_CACHE_ENABLED, CorridoioImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Corridoio)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_CORRIDOIO_WHERE_PKS_IN);

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

			for (Corridoio corridoio : (List<Corridoio>)q.list()) {
				map.put(corridoio.getPrimaryKeyObj(), corridoio);

				cacheResult(corridoio);

				uncachedPrimaryKeys.remove(corridoio.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CorridoioModelImpl.ENTITY_CACHE_ENABLED,
					CorridoioImpl.class, primaryKey, nullModel);
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
	 * Returns all the corridoios.
	 *
	 * @return the corridoios
	 */
	@Override
	public List<Corridoio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @return the range of corridoios
	 */
	@Override
	public List<Corridoio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of corridoios
	 */
	@Override
	public List<Corridoio> findAll(
		int start, int end, OrderByComparator<Corridoio> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of corridoios
	 */
	@Override
	public List<Corridoio> findAll(
		int start, int end, OrderByComparator<Corridoio> orderByComparator,
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

		List<Corridoio> list = null;

		if (retrieveFromCache) {
			list = (List<Corridoio>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CORRIDOIO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CORRIDOIO;

				if (pagination) {
					sql = sql.concat(CorridoioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Corridoio>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Corridoio>)QueryUtil.list(
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
	 * Removes all the corridoios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Corridoio corridoio : findAll()) {
			remove(corridoio);
		}
	}

	/**
	 * Returns the number of corridoios.
	 *
	 * @return the number of corridoios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CORRIDOIO);

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
		return CorridoioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the corridoio persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CorridoioModelImpl.ENTITY_CACHE_ENABLED,
			CorridoioModelImpl.FINDER_CACHE_ENABLED, CorridoioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CorridoioModelImpl.ENTITY_CACHE_ENABLED,
			CorridoioModelImpl.FINDER_CACHE_ENABLED, CorridoioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CorridoioModelImpl.ENTITY_CACHE_ENABLED,
			CorridoioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(CorridoioImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CORRIDOIO =
		"SELECT corridoio FROM Corridoio corridoio";

	private static final String _SQL_SELECT_CORRIDOIO_WHERE_PKS_IN =
		"SELECT corridoio FROM Corridoio corridoio WHERE id_pk_corridoio IN (";

	private static final String _SQL_COUNT_CORRIDOIO =
		"SELECT COUNT(corridoio) FROM Corridoio corridoio";

	private static final String _ORDER_BY_ENTITY_ALIAS = "corridoio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Corridoio exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CorridoioPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"desc"});

}