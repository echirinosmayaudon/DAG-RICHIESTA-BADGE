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

import service.intranet.mef.exception.NoSuchTipologiaComputerException;
import service.intranet.mef.model.TipologiaComputer;
import service.intranet.mef.model.impl.TipologiaComputerImpl;
import service.intranet.mef.model.impl.TipologiaComputerModelImpl;
import service.intranet.mef.service.persistence.TipologiaComputerPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tipologia computer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComputerPersistence
 * @see service.intranet.mef.service.persistence.TipologiaComputerUtil
 * @generated
 */
@ProviderType
public class TipologiaComputerPersistenceImpl extends BasePersistenceImpl<TipologiaComputer>
	implements TipologiaComputerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipologiaComputerUtil} to access the tipologia computer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipologiaComputerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaComputerModelImpl.FINDER_CACHE_ENABLED,
			TipologiaComputerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaComputerModelImpl.FINDER_CACHE_ENABLED,
			TipologiaComputerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaComputerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TipologiaComputerPersistenceImpl() {
		setModelClass(TipologiaComputer.class);
	}

	/**
	 * Caches the tipologia computer in the entity cache if it is enabled.
	 *
	 * @param tipologiaComputer the tipologia computer
	 */
	@Override
	public void cacheResult(TipologiaComputer tipologiaComputer) {
		entityCache.putResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaComputerImpl.class, tipologiaComputer.getPrimaryKey(),
			tipologiaComputer);

		tipologiaComputer.resetOriginalValues();
	}

	/**
	 * Caches the tipologia computers in the entity cache if it is enabled.
	 *
	 * @param tipologiaComputers the tipologia computers
	 */
	@Override
	public void cacheResult(List<TipologiaComputer> tipologiaComputers) {
		for (TipologiaComputer tipologiaComputer : tipologiaComputers) {
			if (entityCache.getResult(
						TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
						TipologiaComputerImpl.class,
						tipologiaComputer.getPrimaryKey()) == null) {
				cacheResult(tipologiaComputer);
			}
			else {
				tipologiaComputer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipologia computers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipologiaComputerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipologia computer.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipologiaComputer tipologiaComputer) {
		entityCache.removeResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaComputerImpl.class, tipologiaComputer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipologiaComputer> tipologiaComputers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipologiaComputer tipologiaComputer : tipologiaComputers) {
			entityCache.removeResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
				TipologiaComputerImpl.class, tipologiaComputer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipologia computer with the primary key. Does not add the tipologia computer to the database.
	 *
	 * @param id_tipologia_computer the primary key for the new tipologia computer
	 * @return the new tipologia computer
	 */
	@Override
	public TipologiaComputer create(long id_tipologia_computer) {
		TipologiaComputer tipologiaComputer = new TipologiaComputerImpl();

		tipologiaComputer.setNew(true);
		tipologiaComputer.setPrimaryKey(id_tipologia_computer);

		return tipologiaComputer;
	}

	/**
	 * Removes the tipologia computer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_tipologia_computer the primary key of the tipologia computer
	 * @return the tipologia computer that was removed
	 * @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	 */
	@Override
	public TipologiaComputer remove(long id_tipologia_computer)
		throws NoSuchTipologiaComputerException {
		return remove((Serializable)id_tipologia_computer);
	}

	/**
	 * Removes the tipologia computer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipologia computer
	 * @return the tipologia computer that was removed
	 * @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	 */
	@Override
	public TipologiaComputer remove(Serializable primaryKey)
		throws NoSuchTipologiaComputerException {
		Session session = null;

		try {
			session = openSession();

			TipologiaComputer tipologiaComputer = (TipologiaComputer)session.get(TipologiaComputerImpl.class,
					primaryKey);

			if (tipologiaComputer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipologiaComputerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipologiaComputer);
		}
		catch (NoSuchTipologiaComputerException nsee) {
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
	protected TipologiaComputer removeImpl(TipologiaComputer tipologiaComputer) {
		tipologiaComputer = toUnwrappedModel(tipologiaComputer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipologiaComputer)) {
				tipologiaComputer = (TipologiaComputer)session.get(TipologiaComputerImpl.class,
						tipologiaComputer.getPrimaryKeyObj());
			}

			if (tipologiaComputer != null) {
				session.delete(tipologiaComputer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipologiaComputer != null) {
			clearCache(tipologiaComputer);
		}

		return tipologiaComputer;
	}

	@Override
	public TipologiaComputer updateImpl(TipologiaComputer tipologiaComputer) {
		tipologiaComputer = toUnwrappedModel(tipologiaComputer);

		boolean isNew = tipologiaComputer.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipologiaComputer.isNew()) {
				session.save(tipologiaComputer);

				tipologiaComputer.setNew(false);
			}
			else {
				tipologiaComputer = (TipologiaComputer)session.merge(tipologiaComputer);
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

		entityCache.putResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
			TipologiaComputerImpl.class, tipologiaComputer.getPrimaryKey(),
			tipologiaComputer, false);

		tipologiaComputer.resetOriginalValues();

		return tipologiaComputer;
	}

	protected TipologiaComputer toUnwrappedModel(
		TipologiaComputer tipologiaComputer) {
		if (tipologiaComputer instanceof TipologiaComputerImpl) {
			return tipologiaComputer;
		}

		TipologiaComputerImpl tipologiaComputerImpl = new TipologiaComputerImpl();

		tipologiaComputerImpl.setNew(tipologiaComputer.isNew());
		tipologiaComputerImpl.setPrimaryKey(tipologiaComputer.getPrimaryKey());

		tipologiaComputerImpl.setId_tipologia_computer(tipologiaComputer.getId_tipologia_computer());
		tipologiaComputerImpl.setDescrizione(tipologiaComputer.getDescrizione());

		return tipologiaComputerImpl;
	}

	/**
	 * Returns the tipologia computer with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia computer
	 * @return the tipologia computer
	 * @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	 */
	@Override
	public TipologiaComputer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipologiaComputerException {
		TipologiaComputer tipologiaComputer = fetchByPrimaryKey(primaryKey);

		if (tipologiaComputer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipologiaComputerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipologiaComputer;
	}

	/**
	 * Returns the tipologia computer with the primary key or throws a {@link NoSuchTipologiaComputerException} if it could not be found.
	 *
	 * @param id_tipologia_computer the primary key of the tipologia computer
	 * @return the tipologia computer
	 * @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	 */
	@Override
	public TipologiaComputer findByPrimaryKey(long id_tipologia_computer)
		throws NoSuchTipologiaComputerException {
		return findByPrimaryKey((Serializable)id_tipologia_computer);
	}

	/**
	 * Returns the tipologia computer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia computer
	 * @return the tipologia computer, or <code>null</code> if a tipologia computer with the primary key could not be found
	 */
	@Override
	public TipologiaComputer fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
				TipologiaComputerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipologiaComputer tipologiaComputer = (TipologiaComputer)serializable;

		if (tipologiaComputer == null) {
			Session session = null;

			try {
				session = openSession();

				tipologiaComputer = (TipologiaComputer)session.get(TipologiaComputerImpl.class,
						primaryKey);

				if (tipologiaComputer != null) {
					cacheResult(tipologiaComputer);
				}
				else {
					entityCache.putResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
						TipologiaComputerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaComputerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipologiaComputer;
	}

	/**
	 * Returns the tipologia computer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_tipologia_computer the primary key of the tipologia computer
	 * @return the tipologia computer, or <code>null</code> if a tipologia computer with the primary key could not be found
	 */
	@Override
	public TipologiaComputer fetchByPrimaryKey(long id_tipologia_computer) {
		return fetchByPrimaryKey((Serializable)id_tipologia_computer);
	}

	@Override
	public Map<Serializable, TipologiaComputer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipologiaComputer> map = new HashMap<Serializable, TipologiaComputer>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipologiaComputer tipologiaComputer = fetchByPrimaryKey(primaryKey);

			if (tipologiaComputer != null) {
				map.put(primaryKey, tipologiaComputer);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaComputerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipologiaComputer)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPOLOGIACOMPUTER_WHERE_PKS_IN);

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

			for (TipologiaComputer tipologiaComputer : (List<TipologiaComputer>)q.list()) {
				map.put(tipologiaComputer.getPrimaryKeyObj(), tipologiaComputer);

				cacheResult(tipologiaComputer);

				uncachedPrimaryKeys.remove(tipologiaComputer.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipologiaComputerModelImpl.ENTITY_CACHE_ENABLED,
					TipologiaComputerImpl.class, primaryKey, nullModel);
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
	 * Returns all the tipologia computers.
	 *
	 * @return the tipologia computers
	 */
	@Override
	public List<TipologiaComputer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologia computers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia computers
	 * @param end the upper bound of the range of tipologia computers (not inclusive)
	 * @return the range of tipologia computers
	 */
	@Override
	public List<TipologiaComputer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologia computers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia computers
	 * @param end the upper bound of the range of tipologia computers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologia computers
	 */
	@Override
	public List<TipologiaComputer> findAll(int start, int end,
		OrderByComparator<TipologiaComputer> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologia computers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia computers
	 * @param end the upper bound of the range of tipologia computers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tipologia computers
	 */
	@Override
	public List<TipologiaComputer> findAll(int start, int end,
		OrderByComparator<TipologiaComputer> orderByComparator,
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

		List<TipologiaComputer> list = null;

		if (retrieveFromCache) {
			list = (List<TipologiaComputer>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPOLOGIACOMPUTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOLOGIACOMPUTER;

				if (pagination) {
					sql = sql.concat(TipologiaComputerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipologiaComputer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipologiaComputer>)QueryUtil.list(q,
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
	 * Removes all the tipologia computers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipologiaComputer tipologiaComputer : findAll()) {
			remove(tipologiaComputer);
		}
	}

	/**
	 * Returns the number of tipologia computers.
	 *
	 * @return the number of tipologia computers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPOLOGIACOMPUTER);

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
		return TipologiaComputerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipologia computer persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipologiaComputerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPOLOGIACOMPUTER = "SELECT tipologiaComputer FROM TipologiaComputer tipologiaComputer";
	private static final String _SQL_SELECT_TIPOLOGIACOMPUTER_WHERE_PKS_IN = "SELECT tipologiaComputer FROM TipologiaComputer tipologiaComputer WHERE id_tipologia_computer IN (";
	private static final String _SQL_COUNT_TIPOLOGIACOMPUTER = "SELECT COUNT(tipologiaComputer) FROM TipologiaComputer tipologiaComputer";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipologiaComputer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipologiaComputer exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TipologiaComputerPersistenceImpl.class);
}