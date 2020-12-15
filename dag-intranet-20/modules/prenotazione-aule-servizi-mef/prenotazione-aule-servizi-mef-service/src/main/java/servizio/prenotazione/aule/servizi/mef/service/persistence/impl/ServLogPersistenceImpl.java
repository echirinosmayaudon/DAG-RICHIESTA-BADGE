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

package servizio.prenotazione.aule.servizi.mef.service.persistence.impl;

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

import servizio.prenotazione.aule.servizi.mef.exception.NoSuchServLogException;
import servizio.prenotazione.aule.servizi.mef.model.ServLog;
import servizio.prenotazione.aule.servizi.mef.model.impl.ServLogImpl;
import servizio.prenotazione.aule.servizi.mef.model.impl.ServLogModelImpl;
import servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK;
import servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the serv log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServLogPersistence
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogUtil
 * @generated
 */
@ProviderType
public class ServLogPersistenceImpl extends BasePersistenceImpl<ServLog>
	implements ServLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServLogUtil} to access the serv log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServLogModelImpl.ENTITY_CACHE_ENABLED,
			ServLogModelImpl.FINDER_CACHE_ENABLED, ServLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServLogModelImpl.ENTITY_CACHE_ENABLED,
			ServLogModelImpl.FINDER_CACHE_ENABLED, ServLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServLogModelImpl.ENTITY_CACHE_ENABLED,
			ServLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ServLogPersistenceImpl() {
		setModelClass(ServLog.class);
	}

	/**
	 * Caches the serv log in the entity cache if it is enabled.
	 *
	 * @param servLog the serv log
	 */
	@Override
	public void cacheResult(ServLog servLog) {
		entityCache.putResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
			ServLogImpl.class, servLog.getPrimaryKey(), servLog);

		servLog.resetOriginalValues();
	}

	/**
	 * Caches the serv logs in the entity cache if it is enabled.
	 *
	 * @param servLogs the serv logs
	 */
	@Override
	public void cacheResult(List<ServLog> servLogs) {
		for (ServLog servLog : servLogs) {
			if (entityCache.getResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
						ServLogImpl.class, servLog.getPrimaryKey()) == null) {
				cacheResult(servLog);
			}
			else {
				servLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all serv logs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the serv log.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServLog servLog) {
		entityCache.removeResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
			ServLogImpl.class, servLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServLog> servLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServLog servLog : servLogs) {
			entityCache.removeResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
				ServLogImpl.class, servLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new serv log with the primary key. Does not add the serv log to the database.
	 *
	 * @param servLogPK the primary key for the new serv log
	 * @return the new serv log
	 */
	@Override
	public ServLog create(ServLogPK servLogPK) {
		ServLog servLog = new ServLogImpl();

		servLog.setNew(true);
		servLog.setPrimaryKey(servLogPK);

		return servLog;
	}

	/**
	 * Removes the serv log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servLogPK the primary key of the serv log
	 * @return the serv log that was removed
	 * @throws NoSuchServLogException if a serv log with the primary key could not be found
	 */
	@Override
	public ServLog remove(ServLogPK servLogPK) throws NoSuchServLogException {
		return remove((Serializable)servLogPK);
	}

	/**
	 * Removes the serv log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the serv log
	 * @return the serv log that was removed
	 * @throws NoSuchServLogException if a serv log with the primary key could not be found
	 */
	@Override
	public ServLog remove(Serializable primaryKey)
		throws NoSuchServLogException {
		Session session = null;

		try {
			session = openSession();

			ServLog servLog = (ServLog)session.get(ServLogImpl.class, primaryKey);

			if (servLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(servLog);
		}
		catch (NoSuchServLogException nsee) {
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
	protected ServLog removeImpl(ServLog servLog) {
		servLog = toUnwrappedModel(servLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(servLog)) {
				servLog = (ServLog)session.get(ServLogImpl.class,
						servLog.getPrimaryKeyObj());
			}

			if (servLog != null) {
				session.delete(servLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (servLog != null) {
			clearCache(servLog);
		}

		return servLog;
	}

	@Override
	public ServLog updateImpl(ServLog servLog) {
		servLog = toUnwrappedModel(servLog);

		boolean isNew = servLog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (servLog.isNew()) {
				session.save(servLog);

				servLog.setNew(false);
			}
			else {
				servLog = (ServLog)session.merge(servLog);
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

		entityCache.putResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
			ServLogImpl.class, servLog.getPrimaryKey(), servLog, false);

		servLog.resetOriginalValues();

		return servLog;
	}

	protected ServLog toUnwrappedModel(ServLog servLog) {
		if (servLog instanceof ServLogImpl) {
			return servLog;
		}

		ServLogImpl servLogImpl = new ServLogImpl();

		servLogImpl.setNew(servLog.isNew());
		servLogImpl.setPrimaryKey(servLog.getPrimaryKey());

		servLogImpl.setId_serv(servLog.getId_serv());
		servLogImpl.setId_sala(servLog.getId_sala());
		servLogImpl.setEmail_ref(servLog.getEmail_ref());

		return servLogImpl;
	}

	/**
	 * Returns the serv log with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the serv log
	 * @return the serv log
	 * @throws NoSuchServLogException if a serv log with the primary key could not be found
	 */
	@Override
	public ServLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServLogException {
		ServLog servLog = fetchByPrimaryKey(primaryKey);

		if (servLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return servLog;
	}

	/**
	 * Returns the serv log with the primary key or throws a {@link NoSuchServLogException} if it could not be found.
	 *
	 * @param servLogPK the primary key of the serv log
	 * @return the serv log
	 * @throws NoSuchServLogException if a serv log with the primary key could not be found
	 */
	@Override
	public ServLog findByPrimaryKey(ServLogPK servLogPK)
		throws NoSuchServLogException {
		return findByPrimaryKey((Serializable)servLogPK);
	}

	/**
	 * Returns the serv log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the serv log
	 * @return the serv log, or <code>null</code> if a serv log with the primary key could not be found
	 */
	@Override
	public ServLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
				ServLogImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ServLog servLog = (ServLog)serializable;

		if (servLog == null) {
			Session session = null;

			try {
				session = openSession();

				servLog = (ServLog)session.get(ServLogImpl.class, primaryKey);

				if (servLog != null) {
					cacheResult(servLog);
				}
				else {
					entityCache.putResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
						ServLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ServLogModelImpl.ENTITY_CACHE_ENABLED,
					ServLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return servLog;
	}

	/**
	 * Returns the serv log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servLogPK the primary key of the serv log
	 * @return the serv log, or <code>null</code> if a serv log with the primary key could not be found
	 */
	@Override
	public ServLog fetchByPrimaryKey(ServLogPK servLogPK) {
		return fetchByPrimaryKey((Serializable)servLogPK);
	}

	@Override
	public Map<Serializable, ServLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ServLog> map = new HashMap<Serializable, ServLog>();

		for (Serializable primaryKey : primaryKeys) {
			ServLog servLog = fetchByPrimaryKey(primaryKey);

			if (servLog != null) {
				map.put(primaryKey, servLog);
			}
		}

		return map;
	}

	/**
	 * Returns all the serv logs.
	 *
	 * @return the serv logs
	 */
	@Override
	public List<ServLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the serv logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of serv logs
	 * @param end the upper bound of the range of serv logs (not inclusive)
	 * @return the range of serv logs
	 */
	@Override
	public List<ServLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the serv logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of serv logs
	 * @param end the upper bound of the range of serv logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of serv logs
	 */
	@Override
	public List<ServLog> findAll(int start, int end,
		OrderByComparator<ServLog> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the serv logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of serv logs
	 * @param end the upper bound of the range of serv logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of serv logs
	 */
	@Override
	public List<ServLog> findAll(int start, int end,
		OrderByComparator<ServLog> orderByComparator, boolean retrieveFromCache) {
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

		List<ServLog> list = null;

		if (retrieveFromCache) {
			list = (List<ServLog>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SERVLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVLOG;

				if (pagination) {
					sql = sql.concat(ServLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServLog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServLog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the serv logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServLog servLog : findAll()) {
			remove(servLog);
		}
	}

	/**
	 * Returns the number of serv logs.
	 *
	 * @return the number of serv logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVLOG);

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
		return ServLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the serv log persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ServLogImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SERVLOG = "SELECT servLog FROM ServLog servLog";
	private static final String _SQL_COUNT_SERVLOG = "SELECT COUNT(servLog) FROM ServLog servLog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "servLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServLog exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ServLogPersistenceImpl.class);
}