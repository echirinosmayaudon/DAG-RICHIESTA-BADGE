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

import com.intranet.mef.job.siap.exception.NoSuchOvertimeBalacePrevMonthException;
import com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth;
import com.intranet.mef.job.siap.model.impl.OvertimeBalacePrevMonthImpl;
import com.intranet.mef.job.siap.model.impl.OvertimeBalacePrevMonthModelImpl;
import com.intranet.mef.job.siap.service.persistence.OvertimeBalacePrevMonthPersistence;

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
 * The persistence implementation for the overtime balace prev month service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalacePrevMonthPersistence
 * @see com.intranet.mef.job.siap.service.persistence.OvertimeBalacePrevMonthUtil
 * @generated
 */
@ProviderType
public class OvertimeBalacePrevMonthPersistenceImpl extends BasePersistenceImpl<OvertimeBalacePrevMonth>
	implements OvertimeBalacePrevMonthPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OvertimeBalacePrevMonthUtil} to access the overtime balace prev month persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OvertimeBalacePrevMonthImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalacePrevMonthModelImpl.FINDER_CACHE_ENABLED,
			OvertimeBalacePrevMonthImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalacePrevMonthModelImpl.FINDER_CACHE_ENABLED,
			OvertimeBalacePrevMonthImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalacePrevMonthModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OvertimeBalacePrevMonthPersistenceImpl() {
		setModelClass(OvertimeBalacePrevMonth.class);
	}

	/**
	 * Caches the overtime balace prev month in the entity cache if it is enabled.
	 *
	 * @param overtimeBalacePrevMonth the overtime balace prev month
	 */
	@Override
	public void cacheResult(OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		entityCache.putResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalacePrevMonthImpl.class,
			overtimeBalacePrevMonth.getPrimaryKey(), overtimeBalacePrevMonth);

		overtimeBalacePrevMonth.resetOriginalValues();
	}

	/**
	 * Caches the overtime balace prev months in the entity cache if it is enabled.
	 *
	 * @param overtimeBalacePrevMonths the overtime balace prev months
	 */
	@Override
	public void cacheResult(
		List<OvertimeBalacePrevMonth> overtimeBalacePrevMonths) {
		for (OvertimeBalacePrevMonth overtimeBalacePrevMonth : overtimeBalacePrevMonths) {
			if (entityCache.getResult(
						OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
						OvertimeBalacePrevMonthImpl.class,
						overtimeBalacePrevMonth.getPrimaryKey()) == null) {
				cacheResult(overtimeBalacePrevMonth);
			}
			else {
				overtimeBalacePrevMonth.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all overtime balace prev months.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OvertimeBalacePrevMonthImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the overtime balace prev month.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		entityCache.removeResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalacePrevMonthImpl.class,
			overtimeBalacePrevMonth.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<OvertimeBalacePrevMonth> overtimeBalacePrevMonths) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OvertimeBalacePrevMonth overtimeBalacePrevMonth : overtimeBalacePrevMonths) {
			entityCache.removeResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
				OvertimeBalacePrevMonthImpl.class,
				overtimeBalacePrevMonth.getPrimaryKey());
		}
	}

	/**
	 * Creates a new overtime balace prev month with the primary key. Does not add the overtime balace prev month to the database.
	 *
	 * @param personId the primary key for the new overtime balace prev month
	 * @return the new overtime balace prev month
	 */
	@Override
	public OvertimeBalacePrevMonth create(long personId) {
		OvertimeBalacePrevMonth overtimeBalacePrevMonth = new OvertimeBalacePrevMonthImpl();

		overtimeBalacePrevMonth.setNew(true);
		overtimeBalacePrevMonth.setPrimaryKey(personId);

		return overtimeBalacePrevMonth;
	}

	/**
	 * Removes the overtime balace prev month with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personId the primary key of the overtime balace prev month
	 * @return the overtime balace prev month that was removed
	 * @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	 */
	@Override
	public OvertimeBalacePrevMonth remove(long personId)
		throws NoSuchOvertimeBalacePrevMonthException {
		return remove((Serializable)personId);
	}

	/**
	 * Removes the overtime balace prev month with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the overtime balace prev month
	 * @return the overtime balace prev month that was removed
	 * @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	 */
	@Override
	public OvertimeBalacePrevMonth remove(Serializable primaryKey)
		throws NoSuchOvertimeBalacePrevMonthException {
		Session session = null;

		try {
			session = openSession();

			OvertimeBalacePrevMonth overtimeBalacePrevMonth = (OvertimeBalacePrevMonth)session.get(OvertimeBalacePrevMonthImpl.class,
					primaryKey);

			if (overtimeBalacePrevMonth == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOvertimeBalacePrevMonthException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(overtimeBalacePrevMonth);
		}
		catch (NoSuchOvertimeBalacePrevMonthException nsee) {
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
	protected OvertimeBalacePrevMonth removeImpl(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		overtimeBalacePrevMonth = toUnwrappedModel(overtimeBalacePrevMonth);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(overtimeBalacePrevMonth)) {
				overtimeBalacePrevMonth = (OvertimeBalacePrevMonth)session.get(OvertimeBalacePrevMonthImpl.class,
						overtimeBalacePrevMonth.getPrimaryKeyObj());
			}

			if (overtimeBalacePrevMonth != null) {
				session.delete(overtimeBalacePrevMonth);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (overtimeBalacePrevMonth != null) {
			clearCache(overtimeBalacePrevMonth);
		}

		return overtimeBalacePrevMonth;
	}

	@Override
	public OvertimeBalacePrevMonth updateImpl(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		overtimeBalacePrevMonth = toUnwrappedModel(overtimeBalacePrevMonth);

		boolean isNew = overtimeBalacePrevMonth.isNew();

		Session session = null;

		try {
			session = openSession();

			if (overtimeBalacePrevMonth.isNew()) {
				session.save(overtimeBalacePrevMonth);

				overtimeBalacePrevMonth.setNew(false);
			}
			else {
				overtimeBalacePrevMonth = (OvertimeBalacePrevMonth)session.merge(overtimeBalacePrevMonth);
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

		entityCache.putResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalacePrevMonthImpl.class,
			overtimeBalacePrevMonth.getPrimaryKey(), overtimeBalacePrevMonth,
			false);

		overtimeBalacePrevMonth.resetOriginalValues();

		return overtimeBalacePrevMonth;
	}

	protected OvertimeBalacePrevMonth toUnwrappedModel(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		if (overtimeBalacePrevMonth instanceof OvertimeBalacePrevMonthImpl) {
			return overtimeBalacePrevMonth;
		}

		OvertimeBalacePrevMonthImpl overtimeBalacePrevMonthImpl = new OvertimeBalacePrevMonthImpl();

		overtimeBalacePrevMonthImpl.setNew(overtimeBalacePrevMonth.isNew());
		overtimeBalacePrevMonthImpl.setPrimaryKey(overtimeBalacePrevMonth.getPrimaryKey());

		overtimeBalacePrevMonthImpl.setPersonId(overtimeBalacePrevMonth.getPersonId());
		overtimeBalacePrevMonthImpl.setOvertimeDueCurrMonth(overtimeBalacePrevMonth.getOvertimeDueCurrMonth());
		overtimeBalacePrevMonthImpl.setOvertimeMonthPrevRif(overtimeBalacePrevMonth.getOvertimeMonthPrevRif());

		return overtimeBalacePrevMonthImpl;
	}

	/**
	 * Returns the overtime balace prev month with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the overtime balace prev month
	 * @return the overtime balace prev month
	 * @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	 */
	@Override
	public OvertimeBalacePrevMonth findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOvertimeBalacePrevMonthException {
		OvertimeBalacePrevMonth overtimeBalacePrevMonth = fetchByPrimaryKey(primaryKey);

		if (overtimeBalacePrevMonth == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOvertimeBalacePrevMonthException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return overtimeBalacePrevMonth;
	}

	/**
	 * Returns the overtime balace prev month with the primary key or throws a {@link NoSuchOvertimeBalacePrevMonthException} if it could not be found.
	 *
	 * @param personId the primary key of the overtime balace prev month
	 * @return the overtime balace prev month
	 * @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	 */
	@Override
	public OvertimeBalacePrevMonth findByPrimaryKey(long personId)
		throws NoSuchOvertimeBalacePrevMonthException {
		return findByPrimaryKey((Serializable)personId);
	}

	/**
	 * Returns the overtime balace prev month with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the overtime balace prev month
	 * @return the overtime balace prev month, or <code>null</code> if a overtime balace prev month with the primary key could not be found
	 */
	@Override
	public OvertimeBalacePrevMonth fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
				OvertimeBalacePrevMonthImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		OvertimeBalacePrevMonth overtimeBalacePrevMonth = (OvertimeBalacePrevMonth)serializable;

		if (overtimeBalacePrevMonth == null) {
			Session session = null;

			try {
				session = openSession();

				overtimeBalacePrevMonth = (OvertimeBalacePrevMonth)session.get(OvertimeBalacePrevMonthImpl.class,
						primaryKey);

				if (overtimeBalacePrevMonth != null) {
					cacheResult(overtimeBalacePrevMonth);
				}
				else {
					entityCache.putResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
						OvertimeBalacePrevMonthImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
					OvertimeBalacePrevMonthImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return overtimeBalacePrevMonth;
	}

	/**
	 * Returns the overtime balace prev month with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personId the primary key of the overtime balace prev month
	 * @return the overtime balace prev month, or <code>null</code> if a overtime balace prev month with the primary key could not be found
	 */
	@Override
	public OvertimeBalacePrevMonth fetchByPrimaryKey(long personId) {
		return fetchByPrimaryKey((Serializable)personId);
	}

	@Override
	public Map<Serializable, OvertimeBalacePrevMonth> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, OvertimeBalacePrevMonth> map = new HashMap<Serializable, OvertimeBalacePrevMonth>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			OvertimeBalacePrevMonth overtimeBalacePrevMonth = fetchByPrimaryKey(primaryKey);

			if (overtimeBalacePrevMonth != null) {
				map.put(primaryKey, overtimeBalacePrevMonth);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
					OvertimeBalacePrevMonthImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (OvertimeBalacePrevMonth)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OVERTIMEBALACEPREVMONTH_WHERE_PKS_IN);

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

			for (OvertimeBalacePrevMonth overtimeBalacePrevMonth : (List<OvertimeBalacePrevMonth>)q.list()) {
				map.put(overtimeBalacePrevMonth.getPrimaryKeyObj(),
					overtimeBalacePrevMonth);

				cacheResult(overtimeBalacePrevMonth);

				uncachedPrimaryKeys.remove(overtimeBalacePrevMonth.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OvertimeBalacePrevMonthModelImpl.ENTITY_CACHE_ENABLED,
					OvertimeBalacePrevMonthImpl.class, primaryKey, nullModel);
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
	 * Returns all the overtime balace prev months.
	 *
	 * @return the overtime balace prev months
	 */
	@Override
	public List<OvertimeBalacePrevMonth> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the overtime balace prev months.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime balace prev months
	 * @param end the upper bound of the range of overtime balace prev months (not inclusive)
	 * @return the range of overtime balace prev months
	 */
	@Override
	public List<OvertimeBalacePrevMonth> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the overtime balace prev months.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime balace prev months
	 * @param end the upper bound of the range of overtime balace prev months (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of overtime balace prev months
	 */
	@Override
	public List<OvertimeBalacePrevMonth> findAll(int start, int end,
		OrderByComparator<OvertimeBalacePrevMonth> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the overtime balace prev months.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime balace prev months
	 * @param end the upper bound of the range of overtime balace prev months (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of overtime balace prev months
	 */
	@Override
	public List<OvertimeBalacePrevMonth> findAll(int start, int end,
		OrderByComparator<OvertimeBalacePrevMonth> orderByComparator,
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

		List<OvertimeBalacePrevMonth> list = null;

		if (retrieveFromCache) {
			list = (List<OvertimeBalacePrevMonth>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OVERTIMEBALACEPREVMONTH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OVERTIMEBALACEPREVMONTH;

				if (pagination) {
					sql = sql.concat(OvertimeBalacePrevMonthModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OvertimeBalacePrevMonth>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OvertimeBalacePrevMonth>)QueryUtil.list(q,
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
	 * Removes all the overtime balace prev months from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OvertimeBalacePrevMonth overtimeBalacePrevMonth : findAll()) {
			remove(overtimeBalacePrevMonth);
		}
	}

	/**
	 * Returns the number of overtime balace prev months.
	 *
	 * @return the number of overtime balace prev months
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OVERTIMEBALACEPREVMONTH);

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
		return OvertimeBalacePrevMonthModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the overtime balace prev month persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OvertimeBalacePrevMonthImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_OVERTIMEBALACEPREVMONTH = "SELECT overtimeBalacePrevMonth FROM OvertimeBalacePrevMonth overtimeBalacePrevMonth";
	private static final String _SQL_SELECT_OVERTIMEBALACEPREVMONTH_WHERE_PKS_IN =
		"SELECT overtimeBalacePrevMonth FROM OvertimeBalacePrevMonth overtimeBalacePrevMonth WHERE PERSON_ID IN (";
	private static final String _SQL_COUNT_OVERTIMEBALACEPREVMONTH = "SELECT COUNT(overtimeBalacePrevMonth) FROM OvertimeBalacePrevMonth overtimeBalacePrevMonth";
	private static final String _ORDER_BY_ENTITY_ALIAS = "overtimeBalacePrevMonth.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OvertimeBalacePrevMonth exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(OvertimeBalacePrevMonthPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personId", "overtimeDueCurrMonth", "overtimeMonthPrevRif"
			});
}