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

import com.intranet.mef.job.siap.exception.NoSuchOvertimeBalanceException;
import com.intranet.mef.job.siap.model.OvertimeBalance;
import com.intranet.mef.job.siap.model.impl.OvertimeBalanceImpl;
import com.intranet.mef.job.siap.model.impl.OvertimeBalanceModelImpl;
import com.intranet.mef.job.siap.service.persistence.OvertimeBalancePersistence;

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
 * The persistence implementation for the overtime balance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalancePersistence
 * @see com.intranet.mef.job.siap.service.persistence.OvertimeBalanceUtil
 * @generated
 */
@ProviderType
public class OvertimeBalancePersistenceImpl extends BasePersistenceImpl<OvertimeBalance>
	implements OvertimeBalancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OvertimeBalanceUtil} to access the overtime balance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OvertimeBalanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalanceModelImpl.FINDER_CACHE_ENABLED,
			OvertimeBalanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalanceModelImpl.FINDER_CACHE_ENABLED,
			OvertimeBalanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OvertimeBalancePersistenceImpl() {
		setModelClass(OvertimeBalance.class);
	}

	/**
	 * Caches the overtime balance in the entity cache if it is enabled.
	 *
	 * @param overtimeBalance the overtime balance
	 */
	@Override
	public void cacheResult(OvertimeBalance overtimeBalance) {
		entityCache.putResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalanceImpl.class, overtimeBalance.getPrimaryKey(),
			overtimeBalance);

		overtimeBalance.resetOriginalValues();
	}

	/**
	 * Caches the overtime balances in the entity cache if it is enabled.
	 *
	 * @param overtimeBalances the overtime balances
	 */
	@Override
	public void cacheResult(List<OvertimeBalance> overtimeBalances) {
		for (OvertimeBalance overtimeBalance : overtimeBalances) {
			if (entityCache.getResult(
						OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
						OvertimeBalanceImpl.class,
						overtimeBalance.getPrimaryKey()) == null) {
				cacheResult(overtimeBalance);
			}
			else {
				overtimeBalance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all overtime balances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OvertimeBalanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the overtime balance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OvertimeBalance overtimeBalance) {
		entityCache.removeResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalanceImpl.class, overtimeBalance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OvertimeBalance> overtimeBalances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OvertimeBalance overtimeBalance : overtimeBalances) {
			entityCache.removeResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
				OvertimeBalanceImpl.class, overtimeBalance.getPrimaryKey());
		}
	}

	/**
	 * Creates a new overtime balance with the primary key. Does not add the overtime balance to the database.
	 *
	 * @param personId the primary key for the new overtime balance
	 * @return the new overtime balance
	 */
	@Override
	public OvertimeBalance create(long personId) {
		OvertimeBalance overtimeBalance = new OvertimeBalanceImpl();

		overtimeBalance.setNew(true);
		overtimeBalance.setPrimaryKey(personId);

		return overtimeBalance;
	}

	/**
	 * Removes the overtime balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personId the primary key of the overtime balance
	 * @return the overtime balance that was removed
	 * @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	 */
	@Override
	public OvertimeBalance remove(long personId)
		throws NoSuchOvertimeBalanceException {
		return remove((Serializable)personId);
	}

	/**
	 * Removes the overtime balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the overtime balance
	 * @return the overtime balance that was removed
	 * @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	 */
	@Override
	public OvertimeBalance remove(Serializable primaryKey)
		throws NoSuchOvertimeBalanceException {
		Session session = null;

		try {
			session = openSession();

			OvertimeBalance overtimeBalance = (OvertimeBalance)session.get(OvertimeBalanceImpl.class,
					primaryKey);

			if (overtimeBalance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOvertimeBalanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(overtimeBalance);
		}
		catch (NoSuchOvertimeBalanceException nsee) {
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
	protected OvertimeBalance removeImpl(OvertimeBalance overtimeBalance) {
		overtimeBalance = toUnwrappedModel(overtimeBalance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(overtimeBalance)) {
				overtimeBalance = (OvertimeBalance)session.get(OvertimeBalanceImpl.class,
						overtimeBalance.getPrimaryKeyObj());
			}

			if (overtimeBalance != null) {
				session.delete(overtimeBalance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (overtimeBalance != null) {
			clearCache(overtimeBalance);
		}

		return overtimeBalance;
	}

	@Override
	public OvertimeBalance updateImpl(OvertimeBalance overtimeBalance) {
		overtimeBalance = toUnwrappedModel(overtimeBalance);

		boolean isNew = overtimeBalance.isNew();

		Session session = null;

		try {
			session = openSession();

			if (overtimeBalance.isNew()) {
				session.save(overtimeBalance);

				overtimeBalance.setNew(false);
			}
			else {
				overtimeBalance = (OvertimeBalance)session.merge(overtimeBalance);
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

		entityCache.putResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
			OvertimeBalanceImpl.class, overtimeBalance.getPrimaryKey(),
			overtimeBalance, false);

		overtimeBalance.resetOriginalValues();

		return overtimeBalance;
	}

	protected OvertimeBalance toUnwrappedModel(OvertimeBalance overtimeBalance) {
		if (overtimeBalance instanceof OvertimeBalanceImpl) {
			return overtimeBalance;
		}

		OvertimeBalanceImpl overtimeBalanceImpl = new OvertimeBalanceImpl();

		overtimeBalanceImpl.setNew(overtimeBalance.isNew());
		overtimeBalanceImpl.setPrimaryKey(overtimeBalance.getPrimaryKey());

		overtimeBalanceImpl.setOvertimeMonthCurrRif(overtimeBalance.getOvertimeMonthCurrRif());
		overtimeBalanceImpl.setPersonId(overtimeBalance.getPersonId());
		overtimeBalanceImpl.setOvertimeBalHourCurMonth(overtimeBalance.getOvertimeBalHourCurMonth());
		overtimeBalanceImpl.setOvertimeBalacePrevMonth(overtimeBalance.getOvertimeBalacePrevMonth());

		return overtimeBalanceImpl;
	}

	/**
	 * Returns the overtime balance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the overtime balance
	 * @return the overtime balance
	 * @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	 */
	@Override
	public OvertimeBalance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOvertimeBalanceException {
		OvertimeBalance overtimeBalance = fetchByPrimaryKey(primaryKey);

		if (overtimeBalance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOvertimeBalanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return overtimeBalance;
	}

	/**
	 * Returns the overtime balance with the primary key or throws a {@link NoSuchOvertimeBalanceException} if it could not be found.
	 *
	 * @param personId the primary key of the overtime balance
	 * @return the overtime balance
	 * @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	 */
	@Override
	public OvertimeBalance findByPrimaryKey(long personId)
		throws NoSuchOvertimeBalanceException {
		return findByPrimaryKey((Serializable)personId);
	}

	/**
	 * Returns the overtime balance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the overtime balance
	 * @return the overtime balance, or <code>null</code> if a overtime balance with the primary key could not be found
	 */
	@Override
	public OvertimeBalance fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
				OvertimeBalanceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		OvertimeBalance overtimeBalance = (OvertimeBalance)serializable;

		if (overtimeBalance == null) {
			Session session = null;

			try {
				session = openSession();

				overtimeBalance = (OvertimeBalance)session.get(OvertimeBalanceImpl.class,
						primaryKey);

				if (overtimeBalance != null) {
					cacheResult(overtimeBalance);
				}
				else {
					entityCache.putResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
						OvertimeBalanceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
					OvertimeBalanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return overtimeBalance;
	}

	/**
	 * Returns the overtime balance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personId the primary key of the overtime balance
	 * @return the overtime balance, or <code>null</code> if a overtime balance with the primary key could not be found
	 */
	@Override
	public OvertimeBalance fetchByPrimaryKey(long personId) {
		return fetchByPrimaryKey((Serializable)personId);
	}

	@Override
	public Map<Serializable, OvertimeBalance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, OvertimeBalance> map = new HashMap<Serializable, OvertimeBalance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			OvertimeBalance overtimeBalance = fetchByPrimaryKey(primaryKey);

			if (overtimeBalance != null) {
				map.put(primaryKey, overtimeBalance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
					OvertimeBalanceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (OvertimeBalance)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OVERTIMEBALANCE_WHERE_PKS_IN);

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

			for (OvertimeBalance overtimeBalance : (List<OvertimeBalance>)q.list()) {
				map.put(overtimeBalance.getPrimaryKeyObj(), overtimeBalance);

				cacheResult(overtimeBalance);

				uncachedPrimaryKeys.remove(overtimeBalance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OvertimeBalanceModelImpl.ENTITY_CACHE_ENABLED,
					OvertimeBalanceImpl.class, primaryKey, nullModel);
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
	 * Returns all the overtime balances.
	 *
	 * @return the overtime balances
	 */
	@Override
	public List<OvertimeBalance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the overtime balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime balances
	 * @param end the upper bound of the range of overtime balances (not inclusive)
	 * @return the range of overtime balances
	 */
	@Override
	public List<OvertimeBalance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the overtime balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime balances
	 * @param end the upper bound of the range of overtime balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of overtime balances
	 */
	@Override
	public List<OvertimeBalance> findAll(int start, int end,
		OrderByComparator<OvertimeBalance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the overtime balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime balances
	 * @param end the upper bound of the range of overtime balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of overtime balances
	 */
	@Override
	public List<OvertimeBalance> findAll(int start, int end,
		OrderByComparator<OvertimeBalance> orderByComparator,
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

		List<OvertimeBalance> list = null;

		if (retrieveFromCache) {
			list = (List<OvertimeBalance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OVERTIMEBALANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OVERTIMEBALANCE;

				if (pagination) {
					sql = sql.concat(OvertimeBalanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OvertimeBalance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OvertimeBalance>)QueryUtil.list(q,
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
	 * Removes all the overtime balances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OvertimeBalance overtimeBalance : findAll()) {
			remove(overtimeBalance);
		}
	}

	/**
	 * Returns the number of overtime balances.
	 *
	 * @return the number of overtime balances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OVERTIMEBALANCE);

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
		return OvertimeBalanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the overtime balance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OvertimeBalanceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_OVERTIMEBALANCE = "SELECT overtimeBalance FROM OvertimeBalance overtimeBalance";
	private static final String _SQL_SELECT_OVERTIMEBALANCE_WHERE_PKS_IN = "SELECT overtimeBalance FROM OvertimeBalance overtimeBalance WHERE PERSON_ID IN (";
	private static final String _SQL_COUNT_OVERTIMEBALANCE = "SELECT COUNT(overtimeBalance) FROM OvertimeBalance overtimeBalance";
	private static final String _ORDER_BY_ENTITY_ALIAS = "overtimeBalance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OvertimeBalance exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(OvertimeBalancePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"overtimeMonthCurrRif", "personId", "overtimeBalHourCurMonth",
				"overtimeBalacePrevMonth"
			});
}