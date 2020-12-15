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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import service.intranet.mef.exception.NoSuchLogisticaValutazioneException;
import service.intranet.mef.model.LogisticaValutazione;
import service.intranet.mef.model.impl.LogisticaValutazioneImpl;
import service.intranet.mef.model.impl.LogisticaValutazioneModelImpl;
import service.intranet.mef.service.persistence.LogisticaValutazionePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the logistica valutazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaValutazionePersistence
 * @see service.intranet.mef.service.persistence.LogisticaValutazioneUtil
 * @generated
 */
@ProviderType
public class LogisticaValutazionePersistenceImpl extends BasePersistenceImpl<LogisticaValutazione>
	implements LogisticaValutazionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogisticaValutazioneUtil} to access the logistica valutazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogisticaValutazioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaValutazioneModelImpl.FINDER_CACHE_ENABLED,
			LogisticaValutazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaValutazioneModelImpl.FINDER_CACHE_ENABLED,
			LogisticaValutazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaValutazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LogisticaValutazionePersistenceImpl() {
		setModelClass(LogisticaValutazione.class);
	}

	/**
	 * Caches the logistica valutazione in the entity cache if it is enabled.
	 *
	 * @param logisticaValutazione the logistica valutazione
	 */
	@Override
	public void cacheResult(LogisticaValutazione logisticaValutazione) {
		entityCache.putResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaValutazioneImpl.class,
			logisticaValutazione.getPrimaryKey(), logisticaValutazione);

		logisticaValutazione.resetOriginalValues();
	}

	/**
	 * Caches the logistica valutaziones in the entity cache if it is enabled.
	 *
	 * @param logisticaValutaziones the logistica valutaziones
	 */
	@Override
	public void cacheResult(List<LogisticaValutazione> logisticaValutaziones) {
		for (LogisticaValutazione logisticaValutazione : logisticaValutaziones) {
			if (entityCache.getResult(
						LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
						LogisticaValutazioneImpl.class,
						logisticaValutazione.getPrimaryKey()) == null) {
				cacheResult(logisticaValutazione);
			}
			else {
				logisticaValutazione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all logistica valutaziones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LogisticaValutazioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the logistica valutazione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogisticaValutazione logisticaValutazione) {
		entityCache.removeResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaValutazioneImpl.class, logisticaValutazione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogisticaValutazione> logisticaValutaziones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogisticaValutazione logisticaValutazione : logisticaValutaziones) {
			entityCache.removeResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
				LogisticaValutazioneImpl.class,
				logisticaValutazione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new logistica valutazione with the primary key. Does not add the logistica valutazione to the database.
	 *
	 * @param id the primary key for the new logistica valutazione
	 * @return the new logistica valutazione
	 */
	@Override
	public LogisticaValutazione create(long id) {
		LogisticaValutazione logisticaValutazione = new LogisticaValutazioneImpl();

		logisticaValutazione.setNew(true);
		logisticaValutazione.setPrimaryKey(id);

		return logisticaValutazione;
	}

	/**
	 * Removes the logistica valutazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the logistica valutazione
	 * @return the logistica valutazione that was removed
	 * @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	 */
	@Override
	public LogisticaValutazione remove(long id)
		throws NoSuchLogisticaValutazioneException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the logistica valutazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the logistica valutazione
	 * @return the logistica valutazione that was removed
	 * @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	 */
	@Override
	public LogisticaValutazione remove(Serializable primaryKey)
		throws NoSuchLogisticaValutazioneException {
		Session session = null;

		try {
			session = openSession();

			LogisticaValutazione logisticaValutazione = (LogisticaValutazione)session.get(LogisticaValutazioneImpl.class,
					primaryKey);

			if (logisticaValutazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogisticaValutazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logisticaValutazione);
		}
		catch (NoSuchLogisticaValutazioneException nsee) {
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
	protected LogisticaValutazione removeImpl(
		LogisticaValutazione logisticaValutazione) {
		logisticaValutazione = toUnwrappedModel(logisticaValutazione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logisticaValutazione)) {
				logisticaValutazione = (LogisticaValutazione)session.get(LogisticaValutazioneImpl.class,
						logisticaValutazione.getPrimaryKeyObj());
			}

			if (logisticaValutazione != null) {
				session.delete(logisticaValutazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logisticaValutazione != null) {
			clearCache(logisticaValutazione);
		}

		return logisticaValutazione;
	}

	@Override
	public LogisticaValutazione updateImpl(
		LogisticaValutazione logisticaValutazione) {
		logisticaValutazione = toUnwrappedModel(logisticaValutazione);

		boolean isNew = logisticaValutazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (logisticaValutazione.isNew()) {
				session.save(logisticaValutazione);

				logisticaValutazione.setNew(false);
			}
			else {
				logisticaValutazione = (LogisticaValutazione)session.merge(logisticaValutazione);
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

		entityCache.putResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
			LogisticaValutazioneImpl.class,
			logisticaValutazione.getPrimaryKey(), logisticaValutazione, false);

		logisticaValutazione.resetOriginalValues();

		return logisticaValutazione;
	}

	protected LogisticaValutazione toUnwrappedModel(
		LogisticaValutazione logisticaValutazione) {
		if (logisticaValutazione instanceof LogisticaValutazioneImpl) {
			return logisticaValutazione;
		}

		LogisticaValutazioneImpl logisticaValutazioneImpl = new LogisticaValutazioneImpl();

		logisticaValutazioneImpl.setNew(logisticaValutazione.isNew());
		logisticaValutazioneImpl.setPrimaryKey(logisticaValutazione.getPrimaryKey());

		logisticaValutazioneImpl.setId(logisticaValutazione.getId());
		logisticaValutazioneImpl.setDescrizione(logisticaValutazione.getDescrizione());

		return logisticaValutazioneImpl;
	}

	/**
	 * Returns the logistica valutazione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the logistica valutazione
	 * @return the logistica valutazione
	 * @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	 */
	@Override
	public LogisticaValutazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogisticaValutazioneException {
		LogisticaValutazione logisticaValutazione = fetchByPrimaryKey(primaryKey);

		if (logisticaValutazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogisticaValutazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return logisticaValutazione;
	}

	/**
	 * Returns the logistica valutazione with the primary key or throws a {@link NoSuchLogisticaValutazioneException} if it could not be found.
	 *
	 * @param id the primary key of the logistica valutazione
	 * @return the logistica valutazione
	 * @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	 */
	@Override
	public LogisticaValutazione findByPrimaryKey(long id)
		throws NoSuchLogisticaValutazioneException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the logistica valutazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the logistica valutazione
	 * @return the logistica valutazione, or <code>null</code> if a logistica valutazione with the primary key could not be found
	 */
	@Override
	public LogisticaValutazione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
				LogisticaValutazioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LogisticaValutazione logisticaValutazione = (LogisticaValutazione)serializable;

		if (logisticaValutazione == null) {
			Session session = null;

			try {
				session = openSession();

				logisticaValutazione = (LogisticaValutazione)session.get(LogisticaValutazioneImpl.class,
						primaryKey);

				if (logisticaValutazione != null) {
					cacheResult(logisticaValutazione);
				}
				else {
					entityCache.putResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
						LogisticaValutazioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaValutazioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logisticaValutazione;
	}

	/**
	 * Returns the logistica valutazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the logistica valutazione
	 * @return the logistica valutazione, or <code>null</code> if a logistica valutazione with the primary key could not be found
	 */
	@Override
	public LogisticaValutazione fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, LogisticaValutazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LogisticaValutazione> map = new HashMap<Serializable, LogisticaValutazione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LogisticaValutazione logisticaValutazione = fetchByPrimaryKey(primaryKey);

			if (logisticaValutazione != null) {
				map.put(primaryKey, logisticaValutazione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaValutazioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LogisticaValutazione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOGISTICAVALUTAZIONE_WHERE_PKS_IN);

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

			for (LogisticaValutazione logisticaValutazione : (List<LogisticaValutazione>)q.list()) {
				map.put(logisticaValutazione.getPrimaryKeyObj(),
					logisticaValutazione);

				cacheResult(logisticaValutazione);

				uncachedPrimaryKeys.remove(logisticaValutazione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LogisticaValutazioneModelImpl.ENTITY_CACHE_ENABLED,
					LogisticaValutazioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the logistica valutaziones.
	 *
	 * @return the logistica valutaziones
	 */
	@Override
	public List<LogisticaValutazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the logistica valutaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica valutaziones
	 * @param end the upper bound of the range of logistica valutaziones (not inclusive)
	 * @return the range of logistica valutaziones
	 */
	@Override
	public List<LogisticaValutazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the logistica valutaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica valutaziones
	 * @param end the upper bound of the range of logistica valutaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of logistica valutaziones
	 */
	@Override
	public List<LogisticaValutazione> findAll(int start, int end,
		OrderByComparator<LogisticaValutazione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the logistica valutaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logistica valutaziones
	 * @param end the upper bound of the range of logistica valutaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of logistica valutaziones
	 */
	@Override
	public List<LogisticaValutazione> findAll(int start, int end,
		OrderByComparator<LogisticaValutazione> orderByComparator,
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

		List<LogisticaValutazione> list = null;

		if (retrieveFromCache) {
			list = (List<LogisticaValutazione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOGISTICAVALUTAZIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGISTICAVALUTAZIONE;

				if (pagination) {
					sql = sql.concat(LogisticaValutazioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogisticaValutazione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogisticaValutazione>)QueryUtil.list(q,
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
	 * Removes all the logistica valutaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LogisticaValutazione logisticaValutazione : findAll()) {
			remove(logisticaValutazione);
		}
	}

	/**
	 * Returns the number of logistica valutaziones.
	 *
	 * @return the number of logistica valutaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGISTICAVALUTAZIONE);

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
		return LogisticaValutazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the logistica valutazione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LogisticaValutazioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LOGISTICAVALUTAZIONE = "SELECT logisticaValutazione FROM LogisticaValutazione logisticaValutazione";
	private static final String _SQL_SELECT_LOGISTICAVALUTAZIONE_WHERE_PKS_IN = "SELECT logisticaValutazione FROM LogisticaValutazione logisticaValutazione WHERE id_ IN (";
	private static final String _SQL_COUNT_LOGISTICAVALUTAZIONE = "SELECT COUNT(logisticaValutazione) FROM LogisticaValutazione logisticaValutazione";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logisticaValutazione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogisticaValutazione exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(LogisticaValutazionePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}