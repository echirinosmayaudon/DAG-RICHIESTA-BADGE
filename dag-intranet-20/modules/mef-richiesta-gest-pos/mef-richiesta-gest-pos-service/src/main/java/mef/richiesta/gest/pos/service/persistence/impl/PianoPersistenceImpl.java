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

import mef.richiesta.gest.pos.exception.NoSuchPianoException;
import mef.richiesta.gest.pos.model.Piano;
import mef.richiesta.gest.pos.model.impl.PianoImpl;
import mef.richiesta.gest.pos.model.impl.PianoModelImpl;
import mef.richiesta.gest.pos.service.persistence.PianoPersistence;

/**
 * The persistence implementation for the piano service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PianoPersistenceImpl
	extends BasePersistenceImpl<Piano> implements PianoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PianoUtil</code> to access the piano persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PianoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PianoPersistenceImpl() {
		setModelClass(Piano.class);

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
	 * Caches the piano in the entity cache if it is enabled.
	 *
	 * @param piano the piano
	 */
	@Override
	public void cacheResult(Piano piano) {
		entityCache.putResult(
			PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
			piano.getPrimaryKey(), piano);

		piano.resetOriginalValues();
	}

	/**
	 * Caches the pianos in the entity cache if it is enabled.
	 *
	 * @param pianos the pianos
	 */
	@Override
	public void cacheResult(List<Piano> pianos) {
		for (Piano piano : pianos) {
			if (entityCache.getResult(
					PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
					piano.getPrimaryKey()) == null) {

				cacheResult(piano);
			}
			else {
				piano.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pianos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PianoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the piano.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Piano piano) {
		entityCache.removeResult(
			PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
			piano.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Piano> pianos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Piano piano : pianos) {
			entityCache.removeResult(
				PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
				piano.getPrimaryKey());
		}
	}

	/**
	 * Creates a new piano with the primary key. Does not add the piano to the database.
	 *
	 * @param id_pk_piano the primary key for the new piano
	 * @return the new piano
	 */
	@Override
	public Piano create(long id_pk_piano) {
		Piano piano = new PianoImpl();

		piano.setNew(true);
		piano.setPrimaryKey(id_pk_piano);

		return piano;
	}

	/**
	 * Removes the piano with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_piano the primary key of the piano
	 * @return the piano that was removed
	 * @throws NoSuchPianoException if a piano with the primary key could not be found
	 */
	@Override
	public Piano remove(long id_pk_piano) throws NoSuchPianoException {
		return remove((Serializable)id_pk_piano);
	}

	/**
	 * Removes the piano with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the piano
	 * @return the piano that was removed
	 * @throws NoSuchPianoException if a piano with the primary key could not be found
	 */
	@Override
	public Piano remove(Serializable primaryKey) throws NoSuchPianoException {
		Session session = null;

		try {
			session = openSession();

			Piano piano = (Piano)session.get(PianoImpl.class, primaryKey);

			if (piano == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPianoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(piano);
		}
		catch (NoSuchPianoException nsee) {
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
	protected Piano removeImpl(Piano piano) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(piano)) {
				piano = (Piano)session.get(
					PianoImpl.class, piano.getPrimaryKeyObj());
			}

			if (piano != null) {
				session.delete(piano);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (piano != null) {
			clearCache(piano);
		}

		return piano;
	}

	@Override
	public Piano updateImpl(Piano piano) {
		boolean isNew = piano.isNew();

		Session session = null;

		try {
			session = openSession();

			if (piano.isNew()) {
				session.save(piano);

				piano.setNew(false);
			}
			else {
				piano = (Piano)session.merge(piano);
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
			PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
			piano.getPrimaryKey(), piano, false);

		piano.resetOriginalValues();

		return piano;
	}

	/**
	 * Returns the piano with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the piano
	 * @return the piano
	 * @throws NoSuchPianoException if a piano with the primary key could not be found
	 */
	@Override
	public Piano findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPianoException {

		Piano piano = fetchByPrimaryKey(primaryKey);

		if (piano == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPianoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return piano;
	}

	/**
	 * Returns the piano with the primary key or throws a <code>NoSuchPianoException</code> if it could not be found.
	 *
	 * @param id_pk_piano the primary key of the piano
	 * @return the piano
	 * @throws NoSuchPianoException if a piano with the primary key could not be found
	 */
	@Override
	public Piano findByPrimaryKey(long id_pk_piano)
		throws NoSuchPianoException {

		return findByPrimaryKey((Serializable)id_pk_piano);
	}

	/**
	 * Returns the piano with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the piano
	 * @return the piano, or <code>null</code> if a piano with the primary key could not be found
	 */
	@Override
	public Piano fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Piano piano = (Piano)serializable;

		if (piano == null) {
			Session session = null;

			try {
				session = openSession();

				piano = (Piano)session.get(PianoImpl.class, primaryKey);

				if (piano != null) {
					cacheResult(piano);
				}
				else {
					entityCache.putResult(
						PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return piano;
	}

	/**
	 * Returns the piano with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk_piano the primary key of the piano
	 * @return the piano, or <code>null</code> if a piano with the primary key could not be found
	 */
	@Override
	public Piano fetchByPrimaryKey(long id_pk_piano) {
		return fetchByPrimaryKey((Serializable)id_pk_piano);
	}

	@Override
	public Map<Serializable, Piano> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Piano> map = new HashMap<Serializable, Piano>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Piano piano = fetchByPrimaryKey(primaryKey);

			if (piano != null) {
				map.put(primaryKey, piano);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Piano)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PIANO_WHERE_PKS_IN);

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

			for (Piano piano : (List<Piano>)q.list()) {
				map.put(piano.getPrimaryKeyObj(), piano);

				cacheResult(piano);

				uncachedPrimaryKeys.remove(piano.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					PianoModelImpl.ENTITY_CACHE_ENABLED, PianoImpl.class,
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
	 * Returns all the pianos.
	 *
	 * @return the pianos
	 */
	@Override
	public List<Piano> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pianos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PianoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pianos
	 * @param end the upper bound of the range of pianos (not inclusive)
	 * @return the range of pianos
	 */
	@Override
	public List<Piano> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pianos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PianoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pianos
	 * @param end the upper bound of the range of pianos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pianos
	 */
	@Override
	public List<Piano> findAll(
		int start, int end, OrderByComparator<Piano> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pianos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PianoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pianos
	 * @param end the upper bound of the range of pianos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pianos
	 */
	@Override
	public List<Piano> findAll(
		int start, int end, OrderByComparator<Piano> orderByComparator,
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

		List<Piano> list = null;

		if (retrieveFromCache) {
			list = (List<Piano>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PIANO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PIANO;

				if (pagination) {
					sql = sql.concat(PianoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Piano>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Piano>)QueryUtil.list(
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
	 * Removes all the pianos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Piano piano : findAll()) {
			remove(piano);
		}
	}

	/**
	 * Returns the number of pianos.
	 *
	 * @return the number of pianos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PIANO);

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
		return PianoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the piano persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			PianoModelImpl.ENTITY_CACHE_ENABLED,
			PianoModelImpl.FINDER_CACHE_ENABLED, PianoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			PianoModelImpl.ENTITY_CACHE_ENABLED,
			PianoModelImpl.FINDER_CACHE_ENABLED, PianoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			PianoModelImpl.ENTITY_CACHE_ENABLED,
			PianoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(PianoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PIANO =
		"SELECT piano FROM Piano piano";

	private static final String _SQL_SELECT_PIANO_WHERE_PKS_IN =
		"SELECT piano FROM Piano piano WHERE id_pk_piano IN (";

	private static final String _SQL_COUNT_PIANO =
		"SELECT COUNT(piano) FROM Piano piano";

	private static final String _ORDER_BY_ENTITY_ALIAS = "piano.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Piano exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PianoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"desc"});

}