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

package mef.richieste.figli.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mef.richieste.figli.exception.NoSuchRICHIESTA_RIMBORSOException;
import mef.richieste.figli.model.RICHIESTA_RIMBORSO;
import mef.richieste.figli.model.impl.RICHIESTA_RIMBORSOImpl;
import mef.richieste.figli.model.impl.RICHIESTA_RIMBORSOModelImpl;
import mef.richieste.figli.service.persistence.RICHIESTA_RIMBORSOPersistence;

/**
 * The persistence implementation for the richiesta_rimborso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RICHIESTA_RIMBORSOPersistenceImpl
	extends BasePersistenceImpl<RICHIESTA_RIMBORSO>
	implements RICHIESTA_RIMBORSOPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RICHIESTA_RIMBORSOUtil</code> to access the richiesta_rimborso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RICHIESTA_RIMBORSOImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RICHIESTA_RIMBORSOPersistenceImpl() {
		setModelClass(RICHIESTA_RIMBORSO.class);
	}

	/**
	 * Caches the richiesta_rimborso in the entity cache if it is enabled.
	 *
	 * @param richiesta_rimborso the richiesta_rimborso
	 */
	@Override
	public void cacheResult(RICHIESTA_RIMBORSO richiesta_rimborso) {
		entityCache.putResult(
			RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
			RICHIESTA_RIMBORSOImpl.class, richiesta_rimborso.getPrimaryKey(),
			richiesta_rimborso);

		richiesta_rimborso.resetOriginalValues();
	}

	/**
	 * Caches the richiesta_rimborsos in the entity cache if it is enabled.
	 *
	 * @param richiesta_rimborsos the richiesta_rimborsos
	 */
	@Override
	public void cacheResult(List<RICHIESTA_RIMBORSO> richiesta_rimborsos) {
		for (RICHIESTA_RIMBORSO richiesta_rimborso : richiesta_rimborsos) {
			if (entityCache.getResult(
					RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
					RICHIESTA_RIMBORSOImpl.class,
					richiesta_rimborso.getPrimaryKey()) == null) {

				cacheResult(richiesta_rimborso);
			}
			else {
				richiesta_rimborso.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richiesta_rimborsos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RICHIESTA_RIMBORSOImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richiesta_rimborso.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RICHIESTA_RIMBORSO richiesta_rimborso) {
		entityCache.removeResult(
			RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
			RICHIESTA_RIMBORSOImpl.class, richiesta_rimborso.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RICHIESTA_RIMBORSO> richiesta_rimborsos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RICHIESTA_RIMBORSO richiesta_rimborso : richiesta_rimborsos) {
			entityCache.removeResult(
				RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
				RICHIESTA_RIMBORSOImpl.class,
				richiesta_rimborso.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richiesta_rimborso with the primary key. Does not add the richiesta_rimborso to the database.
	 *
	 * @param Id the primary key for the new richiesta_rimborso
	 * @return the new richiesta_rimborso
	 */
	@Override
	public RICHIESTA_RIMBORSO create(long Id) {
		RICHIESTA_RIMBORSO richiesta_rimborso = new RICHIESTA_RIMBORSOImpl();

		richiesta_rimborso.setNew(true);
		richiesta_rimborso.setPrimaryKey(Id);

		return richiesta_rimborso;
	}

	/**
	 * Removes the richiesta_rimborso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso that was removed
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	@Override
	public RICHIESTA_RIMBORSO remove(long Id)
		throws NoSuchRICHIESTA_RIMBORSOException {

		return remove((Serializable)Id);
	}

	/**
	 * Removes the richiesta_rimborso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso that was removed
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	@Override
	public RICHIESTA_RIMBORSO remove(Serializable primaryKey)
		throws NoSuchRICHIESTA_RIMBORSOException {

		Session session = null;

		try {
			session = openSession();

			RICHIESTA_RIMBORSO richiesta_rimborso =
				(RICHIESTA_RIMBORSO)session.get(
					RICHIESTA_RIMBORSOImpl.class, primaryKey);

			if (richiesta_rimborso == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRICHIESTA_RIMBORSOException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(richiesta_rimborso);
		}
		catch (NoSuchRICHIESTA_RIMBORSOException nsee) {
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
	protected RICHIESTA_RIMBORSO removeImpl(
		RICHIESTA_RIMBORSO richiesta_rimborso) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiesta_rimborso)) {
				richiesta_rimborso = (RICHIESTA_RIMBORSO)session.get(
					RICHIESTA_RIMBORSOImpl.class,
					richiesta_rimborso.getPrimaryKeyObj());
			}

			if (richiesta_rimborso != null) {
				session.delete(richiesta_rimborso);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiesta_rimborso != null) {
			clearCache(richiesta_rimborso);
		}

		return richiesta_rimborso;
	}

	@Override
	public RICHIESTA_RIMBORSO updateImpl(
		RICHIESTA_RIMBORSO richiesta_rimborso) {

		boolean isNew = richiesta_rimborso.isNew();

		Session session = null;

		try {
			session = openSession();

			if (richiesta_rimborso.isNew()) {
				session.save(richiesta_rimborso);

				richiesta_rimborso.setNew(false);
			}
			else {
				richiesta_rimborso = (RICHIESTA_RIMBORSO)session.merge(
					richiesta_rimborso);
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
			RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
			RICHIESTA_RIMBORSOImpl.class, richiesta_rimborso.getPrimaryKey(),
			richiesta_rimborso, false);

		richiesta_rimborso.resetOriginalValues();

		return richiesta_rimborso;
	}

	/**
	 * Returns the richiesta_rimborso with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	@Override
	public RICHIESTA_RIMBORSO findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRICHIESTA_RIMBORSOException {

		RICHIESTA_RIMBORSO richiesta_rimborso = fetchByPrimaryKey(primaryKey);

		if (richiesta_rimborso == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRICHIESTA_RIMBORSOException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return richiesta_rimborso;
	}

	/**
	 * Returns the richiesta_rimborso with the primary key or throws a <code>NoSuchRICHIESTA_RIMBORSOException</code> if it could not be found.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	@Override
	public RICHIESTA_RIMBORSO findByPrimaryKey(long Id)
		throws NoSuchRICHIESTA_RIMBORSOException {

		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the richiesta_rimborso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso, or <code>null</code> if a richiesta_rimborso with the primary key could not be found
	 */
	@Override
	public RICHIESTA_RIMBORSO fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
			RICHIESTA_RIMBORSOImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RICHIESTA_RIMBORSO richiesta_rimborso =
			(RICHIESTA_RIMBORSO)serializable;

		if (richiesta_rimborso == null) {
			Session session = null;

			try {
				session = openSession();

				richiesta_rimborso = (RICHIESTA_RIMBORSO)session.get(
					RICHIESTA_RIMBORSOImpl.class, primaryKey);

				if (richiesta_rimborso != null) {
					cacheResult(richiesta_rimborso);
				}
				else {
					entityCache.putResult(
						RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
						RICHIESTA_RIMBORSOImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
					RICHIESTA_RIMBORSOImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiesta_rimborso;
	}

	/**
	 * Returns the richiesta_rimborso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso, or <code>null</code> if a richiesta_rimborso with the primary key could not be found
	 */
	@Override
	public RICHIESTA_RIMBORSO fetchByPrimaryKey(long Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	@Override
	public Map<Serializable, RICHIESTA_RIMBORSO> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RICHIESTA_RIMBORSO> map =
			new HashMap<Serializable, RICHIESTA_RIMBORSO>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RICHIESTA_RIMBORSO richiesta_rimborso = fetchByPrimaryKey(
				primaryKey);

			if (richiesta_rimborso != null) {
				map.put(primaryKey, richiesta_rimborso);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
				RICHIESTA_RIMBORSOImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RICHIESTA_RIMBORSO)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RICHIESTA_RIMBORSO_WHERE_PKS_IN);

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

			for (RICHIESTA_RIMBORSO richiesta_rimborso :
					(List<RICHIESTA_RIMBORSO>)q.list()) {

				map.put(
					richiesta_rimborso.getPrimaryKeyObj(), richiesta_rimborso);

				cacheResult(richiesta_rimborso);

				uncachedPrimaryKeys.remove(
					richiesta_rimborso.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
					RICHIESTA_RIMBORSOImpl.class, primaryKey, nullModel);
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
	 * Returns all the richiesta_rimborsos.
	 *
	 * @return the richiesta_rimborsos
	 */
	@Override
	public List<RICHIESTA_RIMBORSO> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @return the range of richiesta_rimborsos
	 */
	@Override
	public List<RICHIESTA_RIMBORSO> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta_rimborsos
	 */
	@Override
	public List<RICHIESTA_RIMBORSO> findAll(
		int start, int end,
		OrderByComparator<RICHIESTA_RIMBORSO> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiesta_rimborsos
	 */
	@Override
	public List<RICHIESTA_RIMBORSO> findAll(
		int start, int end,
		OrderByComparator<RICHIESTA_RIMBORSO> orderByComparator,
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

		List<RICHIESTA_RIMBORSO> list = null;

		if (retrieveFromCache) {
			list = (List<RICHIESTA_RIMBORSO>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTA_RIMBORSO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTA_RIMBORSO;

				if (pagination) {
					sql = sql.concat(RICHIESTA_RIMBORSOModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RICHIESTA_RIMBORSO>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RICHIESTA_RIMBORSO>)QueryUtil.list(
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
	 * Removes all the richiesta_rimborsos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RICHIESTA_RIMBORSO richiesta_rimborso : findAll()) {
			remove(richiesta_rimborso);
		}
	}

	/**
	 * Returns the number of richiesta_rimborsos.
	 *
	 * @return the number of richiesta_rimborsos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTA_RIMBORSO);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return RICHIESTA_RIMBORSOModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richiesta_rimborso persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
			RICHIESTA_RIMBORSOModelImpl.FINDER_CACHE_ENABLED,
			RICHIESTA_RIMBORSOImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
			RICHIESTA_RIMBORSOModelImpl.FINDER_CACHE_ENABLED,
			RICHIESTA_RIMBORSOImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RICHIESTA_RIMBORSOModelImpl.ENTITY_CACHE_ENABLED,
			RICHIESTA_RIMBORSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(RICHIESTA_RIMBORSOImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RICHIESTA_RIMBORSO =
		"SELECT richiesta_rimborso FROM RICHIESTA_RIMBORSO richiesta_rimborso";

	private static final String _SQL_SELECT_RICHIESTA_RIMBORSO_WHERE_PKS_IN =
		"SELECT richiesta_rimborso FROM RICHIESTA_RIMBORSO richiesta_rimborso WHERE Id IN (";

	private static final String _SQL_COUNT_RICHIESTA_RIMBORSO =
		"SELECT COUNT(richiesta_rimborso) FROM RICHIESTA_RIMBORSO richiesta_rimborso";

	private static final String _ORDER_BY_ENTITY_ALIAS = "richiesta_rimborso.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RICHIESTA_RIMBORSO exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RICHIESTA_RIMBORSOPersistenceImpl.class);

}