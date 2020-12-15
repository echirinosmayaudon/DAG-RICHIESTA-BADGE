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

package com.intranet.mef.job.siap.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.exception.NoSuchCurrentBalanceHoursException;
import com.intranet.mef.job.siap.model.CurrentBalanceHours;
import com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursImpl;
import com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursModelImpl;
import com.intranet.mef.job.siap.service.persistence.CurrentBalanceHoursPersistence;

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

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the current balance hours service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrentBalanceHoursPersistence
 * @see com.intranet.mef.job.siap.service.persistence.CurrentBalanceHoursUtil
 * @generated
 */
@ProviderType
public class CurrentBalanceHoursPersistenceImpl extends BasePersistenceImpl<CurrentBalanceHours>
	implements CurrentBalanceHoursPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CurrentBalanceHoursUtil} to access the current balance hours persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CurrentBalanceHoursImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
			CurrentBalanceHoursModelImpl.FINDER_CACHE_ENABLED,
			CurrentBalanceHoursImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
			CurrentBalanceHoursModelImpl.FINDER_CACHE_ENABLED,
			CurrentBalanceHoursImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
			CurrentBalanceHoursModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CurrentBalanceHoursPersistenceImpl() {
		setModelClass(CurrentBalanceHours.class);
	}

	/**
	 * Caches the current balance hours in the entity cache if it is enabled.
	 *
	 * @param currentBalanceHours the current balance hours
	 */
	@Override
	public void cacheResult(CurrentBalanceHours currentBalanceHours) {
		entityCache.putResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
			CurrentBalanceHoursImpl.class, currentBalanceHours.getPrimaryKey(),
			currentBalanceHours);

		currentBalanceHours.resetOriginalValues();
	}

	/**
	 * Caches the current balance hourses in the entity cache if it is enabled.
	 *
	 * @param currentBalanceHourses the current balance hourses
	 */
	@Override
	public void cacheResult(List<CurrentBalanceHours> currentBalanceHourses) {
		for (CurrentBalanceHours currentBalanceHours : currentBalanceHourses) {
			if (entityCache.getResult(
						CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
						CurrentBalanceHoursImpl.class,
						currentBalanceHours.getPrimaryKey()) == null) {
				cacheResult(currentBalanceHours);
			}
			else {
				currentBalanceHours.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all current balance hourses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CurrentBalanceHoursImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the current balance hours.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CurrentBalanceHours currentBalanceHours) {
		entityCache.removeResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
			CurrentBalanceHoursImpl.class, currentBalanceHours.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CurrentBalanceHours> currentBalanceHourses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CurrentBalanceHours currentBalanceHours : currentBalanceHourses) {
			entityCache.removeResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
				CurrentBalanceHoursImpl.class,
				currentBalanceHours.getPrimaryKey());
		}
	}

	/**
	 * Creates a new current balance hours with the primary key. Does not add the current balance hours to the database.
	 *
	 * @param personId the primary key for the new current balance hours
	 * @return the new current balance hours
	 */
	@Override
	public CurrentBalanceHours create(long personId) {
		CurrentBalanceHours currentBalanceHours = new CurrentBalanceHoursImpl();

		currentBalanceHours.setNew(true);
		currentBalanceHours.setPrimaryKey(personId);

		return currentBalanceHours;
	}

	/**
	 * Removes the current balance hours with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personId the primary key of the current balance hours
	 * @return the current balance hours that was removed
	 * @throws NoSuchCurrentBalanceHoursException if a current balance hours with the primary key could not be found
	 */
	@Override
	public CurrentBalanceHours remove(long personId)
		throws NoSuchCurrentBalanceHoursException {
		return remove((Serializable)personId);
	}

	/**
	 * Removes the current balance hours with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the current balance hours
	 * @return the current balance hours that was removed
	 * @throws NoSuchCurrentBalanceHoursException if a current balance hours with the primary key could not be found
	 */
	@Override
	public CurrentBalanceHours remove(Serializable primaryKey)
		throws NoSuchCurrentBalanceHoursException {
		Session session = null;

		try {
			session = openSession();

			CurrentBalanceHours currentBalanceHours = (CurrentBalanceHours)session.get(CurrentBalanceHoursImpl.class,
					primaryKey);

			if (currentBalanceHours == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCurrentBalanceHoursException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(currentBalanceHours);
		}
		catch (NoSuchCurrentBalanceHoursException nsee) {
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
	protected CurrentBalanceHours removeImpl(
		CurrentBalanceHours currentBalanceHours) {
		currentBalanceHours = toUnwrappedModel(currentBalanceHours);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(currentBalanceHours)) {
				currentBalanceHours = (CurrentBalanceHours)session.get(CurrentBalanceHoursImpl.class,
						currentBalanceHours.getPrimaryKeyObj());
			}

			if (currentBalanceHours != null) {
				session.delete(currentBalanceHours);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (currentBalanceHours != null) {
			clearCache(currentBalanceHours);
		}

		return currentBalanceHours;
	}

	@Override
	public CurrentBalanceHours updateImpl(
		CurrentBalanceHours currentBalanceHours) {
		currentBalanceHours = toUnwrappedModel(currentBalanceHours);

		boolean isNew = currentBalanceHours.isNew();

		Session session = null;

		try {
			session = openSession();

			if (currentBalanceHours.isNew()) {
				session.save(currentBalanceHours);

				currentBalanceHours.setNew(false);
			}
			else {
				currentBalanceHours = (CurrentBalanceHours)session.merge(currentBalanceHours);
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

		entityCache.putResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
			CurrentBalanceHoursImpl.class, currentBalanceHours.getPrimaryKey(),
			currentBalanceHours, false);

		currentBalanceHours.resetOriginalValues();

		return currentBalanceHours;
	}

	protected CurrentBalanceHours toUnwrappedModel(
		CurrentBalanceHours currentBalanceHours) {
		if (currentBalanceHours instanceof CurrentBalanceHoursImpl) {
			return currentBalanceHours;
		}

		CurrentBalanceHoursImpl currentBalanceHoursImpl = new CurrentBalanceHoursImpl();

		currentBalanceHoursImpl.setNew(currentBalanceHours.isNew());
		currentBalanceHoursImpl.setPrimaryKey(currentBalanceHours.getPrimaryKey());

		currentBalanceHoursImpl.setPersonId(currentBalanceHours.getPersonId());
		currentBalanceHoursImpl.setBalanceHoursCurDate(currentBalanceHours.getBalanceHoursCurDate());
		currentBalanceHoursImpl.setBalanceHours(currentBalanceHours.getBalanceHours());

		return currentBalanceHoursImpl;
	}

	/**
	 * Returns the current balance hours with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the current balance hours
	 * @return the current balance hours
	 * @throws NoSuchCurrentBalanceHoursException if a current balance hours with the primary key could not be found
	 */
	@Override
	public CurrentBalanceHours findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCurrentBalanceHoursException {
		CurrentBalanceHours currentBalanceHours = fetchByPrimaryKey(primaryKey);

		if (currentBalanceHours == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCurrentBalanceHoursException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return currentBalanceHours;
	}

	/**
	 * Returns the current balance hours with the primary key or throws a {@link NoSuchCurrentBalanceHoursException} if it could not be found.
	 *
	 * @param personId the primary key of the current balance hours
	 * @return the current balance hours
	 * @throws NoSuchCurrentBalanceHoursException if a current balance hours with the primary key could not be found
	 */
	@Override
	public CurrentBalanceHours findByPrimaryKey(long personId)
		throws NoSuchCurrentBalanceHoursException {
		return findByPrimaryKey((Serializable)personId);
	}

	/**
	 * Returns the current balance hours with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the current balance hours
	 * @return the current balance hours, or <code>null</code> if a current balance hours with the primary key could not be found
	 */
	@Override
	public CurrentBalanceHours fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
				CurrentBalanceHoursImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CurrentBalanceHours currentBalanceHours = (CurrentBalanceHours)serializable;

		if (currentBalanceHours == null) {
			Session session = null;

			try {
				session = openSession();

				currentBalanceHours = (CurrentBalanceHours)session.get(CurrentBalanceHoursImpl.class,
						primaryKey);

				if (currentBalanceHours != null) {
					cacheResult(currentBalanceHours);
				}
				else {
					entityCache.putResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
						CurrentBalanceHoursImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
					CurrentBalanceHoursImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return currentBalanceHours;
	}

	/**
	 * Returns the current balance hours with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personId the primary key of the current balance hours
	 * @return the current balance hours, or <code>null</code> if a current balance hours with the primary key could not be found
	 */
	@Override
	public CurrentBalanceHours fetchByPrimaryKey(long personId) {
		return fetchByPrimaryKey((Serializable)personId);
	}

	@Override
	public Map<Serializable, CurrentBalanceHours> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CurrentBalanceHours> map = new HashMap<Serializable, CurrentBalanceHours>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CurrentBalanceHours currentBalanceHours = fetchByPrimaryKey(primaryKey);

			if (currentBalanceHours != null) {
				map.put(primaryKey, currentBalanceHours);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
					CurrentBalanceHoursImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CurrentBalanceHours)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CURRENTBALANCEHOURS_WHERE_PKS_IN);

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

			for (CurrentBalanceHours currentBalanceHours : (List<CurrentBalanceHours>)q.list()) {
				map.put(currentBalanceHours.getPrimaryKeyObj(),
					currentBalanceHours);

				cacheResult(currentBalanceHours);

				uncachedPrimaryKeys.remove(currentBalanceHours.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CurrentBalanceHoursModelImpl.ENTITY_CACHE_ENABLED,
					CurrentBalanceHoursImpl.class, primaryKey, nullModel);
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
	 * Returns all the current balance hourses.
	 *
	 * @return the current balance hourses
	 */
	@Override
	public List<CurrentBalanceHours> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the current balance hourses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of current balance hourses
	 * @param end the upper bound of the range of current balance hourses (not inclusive)
	 * @return the range of current balance hourses
	 */
	@Override
	public List<CurrentBalanceHours> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the current balance hourses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of current balance hourses
	 * @param end the upper bound of the range of current balance hourses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of current balance hourses
	 */
	@Override
	public List<CurrentBalanceHours> findAll(int start, int end,
		OrderByComparator<CurrentBalanceHours> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the current balance hourses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of current balance hourses
	 * @param end the upper bound of the range of current balance hourses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of current balance hourses
	 */
	@Override
	public List<CurrentBalanceHours> findAll(int start, int end,
		OrderByComparator<CurrentBalanceHours> orderByComparator,
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

		List<CurrentBalanceHours> list = null;

		if (retrieveFromCache) {
			list = (List<CurrentBalanceHours>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CURRENTBALANCEHOURS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURRENTBALANCEHOURS;

				if (pagination) {
					sql = sql.concat(CurrentBalanceHoursModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CurrentBalanceHours>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CurrentBalanceHours>)QueryUtil.list(q,
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
	 * Removes all the current balance hourses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CurrentBalanceHours currentBalanceHours : findAll()) {
			remove(currentBalanceHours);
		}
	}

	/**
	 * Returns the number of current balance hourses.
	 *
	 * @return the number of current balance hourses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CURRENTBALANCEHOURS);

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
		return CurrentBalanceHoursModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the current balance hours persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CurrentBalanceHoursImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CURRENTBALANCEHOURS = "SELECT currentBalanceHours FROM CurrentBalanceHours currentBalanceHours";
	private static final String _SQL_SELECT_CURRENTBALANCEHOURS_WHERE_PKS_IN = "SELECT currentBalanceHours FROM CurrentBalanceHours currentBalanceHours WHERE PERSON_ID IN (";
	private static final String _SQL_COUNT_CURRENTBALANCEHOURS = "SELECT COUNT(currentBalanceHours) FROM CurrentBalanceHours currentBalanceHours";
	private static final String _ORDER_BY_ENTITY_ALIAS = "currentBalanceHours.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CurrentBalanceHours exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CurrentBalanceHoursPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personId", "balanceHoursCurDate", "balanceHours"
			});
}