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

import com.intranet.mef.job.siap.exception.NoSuchVacationException;
import com.intranet.mef.job.siap.model.Vacation;
import com.intranet.mef.job.siap.model.impl.VacationImpl;
import com.intranet.mef.job.siap.model.impl.VacationModelImpl;
import com.intranet.mef.job.siap.service.persistence.VacationPersistence;

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
 * The persistence implementation for the vacation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VacationPersistence
 * @see com.intranet.mef.job.siap.service.persistence.VacationUtil
 * @generated
 */
@ProviderType
public class VacationPersistenceImpl extends BasePersistenceImpl<Vacation>
	implements VacationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VacationUtil} to access the vacation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VacationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VacationModelImpl.ENTITY_CACHE_ENABLED,
			VacationModelImpl.FINDER_CACHE_ENABLED, VacationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VacationModelImpl.ENTITY_CACHE_ENABLED,
			VacationModelImpl.FINDER_CACHE_ENABLED, VacationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VacationModelImpl.ENTITY_CACHE_ENABLED,
			VacationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VacationPersistenceImpl() {
		setModelClass(Vacation.class);
	}

	/**
	 * Caches the vacation in the entity cache if it is enabled.
	 *
	 * @param vacation the vacation
	 */
	@Override
	public void cacheResult(Vacation vacation) {
		entityCache.putResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
			VacationImpl.class, vacation.getPrimaryKey(), vacation);

		vacation.resetOriginalValues();
	}

	/**
	 * Caches the vacations in the entity cache if it is enabled.
	 *
	 * @param vacations the vacations
	 */
	@Override
	public void cacheResult(List<Vacation> vacations) {
		for (Vacation vacation : vacations) {
			if (entityCache.getResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
						VacationImpl.class, vacation.getPrimaryKey()) == null) {
				cacheResult(vacation);
			}
			else {
				vacation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vacations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VacationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vacation.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vacation vacation) {
		entityCache.removeResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
			VacationImpl.class, vacation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Vacation> vacations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Vacation vacation : vacations) {
			entityCache.removeResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
				VacationImpl.class, vacation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vacation with the primary key. Does not add the vacation to the database.
	 *
	 * @param personId the primary key for the new vacation
	 * @return the new vacation
	 */
	@Override
	public Vacation create(long personId) {
		Vacation vacation = new VacationImpl();

		vacation.setNew(true);
		vacation.setPrimaryKey(personId);

		return vacation;
	}

	/**
	 * Removes the vacation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personId the primary key of the vacation
	 * @return the vacation that was removed
	 * @throws NoSuchVacationException if a vacation with the primary key could not be found
	 */
	@Override
	public Vacation remove(long personId) throws NoSuchVacationException {
		return remove((Serializable)personId);
	}

	/**
	 * Removes the vacation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vacation
	 * @return the vacation that was removed
	 * @throws NoSuchVacationException if a vacation with the primary key could not be found
	 */
	@Override
	public Vacation remove(Serializable primaryKey)
		throws NoSuchVacationException {
		Session session = null;

		try {
			session = openSession();

			Vacation vacation = (Vacation)session.get(VacationImpl.class,
					primaryKey);

			if (vacation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVacationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vacation);
		}
		catch (NoSuchVacationException nsee) {
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
	protected Vacation removeImpl(Vacation vacation) {
		vacation = toUnwrappedModel(vacation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vacation)) {
				vacation = (Vacation)session.get(VacationImpl.class,
						vacation.getPrimaryKeyObj());
			}

			if (vacation != null) {
				session.delete(vacation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vacation != null) {
			clearCache(vacation);
		}

		return vacation;
	}

	@Override
	public Vacation updateImpl(Vacation vacation) {
		vacation = toUnwrappedModel(vacation);

		boolean isNew = vacation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vacation.isNew()) {
				session.save(vacation);

				vacation.setNew(false);
			}
			else {
				vacation = (Vacation)session.merge(vacation);
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

		entityCache.putResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
			VacationImpl.class, vacation.getPrimaryKey(), vacation, false);

		vacation.resetOriginalValues();

		return vacation;
	}

	protected Vacation toUnwrappedModel(Vacation vacation) {
		if (vacation instanceof VacationImpl) {
			return vacation;
		}

		VacationImpl vacationImpl = new VacationImpl();

		vacationImpl.setNew(vacation.isNew());
		vacationImpl.setPrimaryKey(vacation.getPrimaryKey());

		vacationImpl.setPersonId(vacation.getPersonId());
		vacationImpl.setVacationCurrYear(vacation.getVacationCurrYear());
		vacationImpl.setVacationPrevYear(vacation.getVacationPrevYear());
		vacationImpl.setVacationSpent(vacation.getVacationSpent());
		vacationImpl.setVacationRemaining(vacation.getVacationRemaining());

		return vacationImpl;
	}

	/**
	 * Returns the vacation with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacation
	 * @return the vacation
	 * @throws NoSuchVacationException if a vacation with the primary key could not be found
	 */
	@Override
	public Vacation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVacationException {
		Vacation vacation = fetchByPrimaryKey(primaryKey);

		if (vacation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVacationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vacation;
	}

	/**
	 * Returns the vacation with the primary key or throws a {@link NoSuchVacationException} if it could not be found.
	 *
	 * @param personId the primary key of the vacation
	 * @return the vacation
	 * @throws NoSuchVacationException if a vacation with the primary key could not be found
	 */
	@Override
	public Vacation findByPrimaryKey(long personId)
		throws NoSuchVacationException {
		return findByPrimaryKey((Serializable)personId);
	}

	/**
	 * Returns the vacation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacation
	 * @return the vacation, or <code>null</code> if a vacation with the primary key could not be found
	 */
	@Override
	public Vacation fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
				VacationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Vacation vacation = (Vacation)serializable;

		if (vacation == null) {
			Session session = null;

			try {
				session = openSession();

				vacation = (Vacation)session.get(VacationImpl.class, primaryKey);

				if (vacation != null) {
					cacheResult(vacation);
				}
				else {
					entityCache.putResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
						VacationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
					VacationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vacation;
	}

	/**
	 * Returns the vacation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personId the primary key of the vacation
	 * @return the vacation, or <code>null</code> if a vacation with the primary key could not be found
	 */
	@Override
	public Vacation fetchByPrimaryKey(long personId) {
		return fetchByPrimaryKey((Serializable)personId);
	}

	@Override
	public Map<Serializable, Vacation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Vacation> map = new HashMap<Serializable, Vacation>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Vacation vacation = fetchByPrimaryKey(primaryKey);

			if (vacation != null) {
				map.put(primaryKey, vacation);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
					VacationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Vacation)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VACATION_WHERE_PKS_IN);

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

			for (Vacation vacation : (List<Vacation>)q.list()) {
				map.put(vacation.getPrimaryKeyObj(), vacation);

				cacheResult(vacation);

				uncachedPrimaryKeys.remove(vacation.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VacationModelImpl.ENTITY_CACHE_ENABLED,
					VacationImpl.class, primaryKey, nullModel);
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
	 * Returns all the vacations.
	 *
	 * @return the vacations
	 */
	@Override
	public List<Vacation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VacationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacations
	 * @param end the upper bound of the range of vacations (not inclusive)
	 * @return the range of vacations
	 */
	@Override
	public List<Vacation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VacationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacations
	 * @param end the upper bound of the range of vacations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vacations
	 */
	@Override
	public List<Vacation> findAll(int start, int end,
		OrderByComparator<Vacation> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vacations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VacationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacations
	 * @param end the upper bound of the range of vacations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vacations
	 */
	@Override
	public List<Vacation> findAll(int start, int end,
		OrderByComparator<Vacation> orderByComparator, boolean retrieveFromCache) {
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

		List<Vacation> list = null;

		if (retrieveFromCache) {
			list = (List<Vacation>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VACATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VACATION;

				if (pagination) {
					sql = sql.concat(VacationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Vacation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vacation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vacations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Vacation vacation : findAll()) {
			remove(vacation);
		}
	}

	/**
	 * Returns the number of vacations.
	 *
	 * @return the number of vacations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VACATION);

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
		return VacationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vacation persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VacationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VACATION = "SELECT vacation FROM Vacation vacation";
	private static final String _SQL_SELECT_VACATION_WHERE_PKS_IN = "SELECT vacation FROM Vacation vacation WHERE PERSON_ID IN (";
	private static final String _SQL_COUNT_VACATION = "SELECT COUNT(vacation) FROM Vacation vacation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vacation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Vacation exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(VacationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personId", "vacationCurrYear", "vacationPrevYear",
				"vacationSpent", "vacationRemaining"
			});
}