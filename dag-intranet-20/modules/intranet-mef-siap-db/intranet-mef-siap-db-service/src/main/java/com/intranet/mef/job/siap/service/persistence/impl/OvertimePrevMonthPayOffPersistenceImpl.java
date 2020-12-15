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

import com.intranet.mef.job.siap.exception.NoSuchOvertimePrevMonthPayOffException;
import com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff;
import com.intranet.mef.job.siap.model.impl.OvertimePrevMonthPayOffImpl;
import com.intranet.mef.job.siap.model.impl.OvertimePrevMonthPayOffModelImpl;
import com.intranet.mef.job.siap.service.persistence.OvertimePrevMonthPayOffPersistence;

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
 * The persistence implementation for the overtime prev month pay off service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimePrevMonthPayOffPersistence
 * @see com.intranet.mef.job.siap.service.persistence.OvertimePrevMonthPayOffUtil
 * @generated
 */
@ProviderType
public class OvertimePrevMonthPayOffPersistenceImpl extends BasePersistenceImpl<OvertimePrevMonthPayOff>
	implements OvertimePrevMonthPayOffPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OvertimePrevMonthPayOffUtil} to access the overtime prev month pay off persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OvertimePrevMonthPayOffImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
			OvertimePrevMonthPayOffModelImpl.FINDER_CACHE_ENABLED,
			OvertimePrevMonthPayOffImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
			OvertimePrevMonthPayOffModelImpl.FINDER_CACHE_ENABLED,
			OvertimePrevMonthPayOffImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
			OvertimePrevMonthPayOffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OvertimePrevMonthPayOffPersistenceImpl() {
		setModelClass(OvertimePrevMonthPayOff.class);
	}

	/**
	 * Caches the overtime prev month pay off in the entity cache if it is enabled.
	 *
	 * @param overtimePrevMonthPayOff the overtime prev month pay off
	 */
	@Override
	public void cacheResult(OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		entityCache.putResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
			OvertimePrevMonthPayOffImpl.class,
			overtimePrevMonthPayOff.getPrimaryKey(), overtimePrevMonthPayOff);

		overtimePrevMonthPayOff.resetOriginalValues();
	}

	/**
	 * Caches the overtime prev month pay offs in the entity cache if it is enabled.
	 *
	 * @param overtimePrevMonthPayOffs the overtime prev month pay offs
	 */
	@Override
	public void cacheResult(
		List<OvertimePrevMonthPayOff> overtimePrevMonthPayOffs) {
		for (OvertimePrevMonthPayOff overtimePrevMonthPayOff : overtimePrevMonthPayOffs) {
			if (entityCache.getResult(
						OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
						OvertimePrevMonthPayOffImpl.class,
						overtimePrevMonthPayOff.getPrimaryKey()) == null) {
				cacheResult(overtimePrevMonthPayOff);
			}
			else {
				overtimePrevMonthPayOff.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all overtime prev month pay offs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OvertimePrevMonthPayOffImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the overtime prev month pay off.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		entityCache.removeResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
			OvertimePrevMonthPayOffImpl.class,
			overtimePrevMonthPayOff.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<OvertimePrevMonthPayOff> overtimePrevMonthPayOffs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OvertimePrevMonthPayOff overtimePrevMonthPayOff : overtimePrevMonthPayOffs) {
			entityCache.removeResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
				OvertimePrevMonthPayOffImpl.class,
				overtimePrevMonthPayOff.getPrimaryKey());
		}
	}

	/**
	 * Creates a new overtime prev month pay off with the primary key. Does not add the overtime prev month pay off to the database.
	 *
	 * @param personId the primary key for the new overtime prev month pay off
	 * @return the new overtime prev month pay off
	 */
	@Override
	public OvertimePrevMonthPayOff create(long personId) {
		OvertimePrevMonthPayOff overtimePrevMonthPayOff = new OvertimePrevMonthPayOffImpl();

		overtimePrevMonthPayOff.setNew(true);
		overtimePrevMonthPayOff.setPrimaryKey(personId);

		return overtimePrevMonthPayOff;
	}

	/**
	 * Removes the overtime prev month pay off with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personId the primary key of the overtime prev month pay off
	 * @return the overtime prev month pay off that was removed
	 * @throws NoSuchOvertimePrevMonthPayOffException if a overtime prev month pay off with the primary key could not be found
	 */
	@Override
	public OvertimePrevMonthPayOff remove(long personId)
		throws NoSuchOvertimePrevMonthPayOffException {
		return remove((Serializable)personId);
	}

	/**
	 * Removes the overtime prev month pay off with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the overtime prev month pay off
	 * @return the overtime prev month pay off that was removed
	 * @throws NoSuchOvertimePrevMonthPayOffException if a overtime prev month pay off with the primary key could not be found
	 */
	@Override
	public OvertimePrevMonthPayOff remove(Serializable primaryKey)
		throws NoSuchOvertimePrevMonthPayOffException {
		Session session = null;

		try {
			session = openSession();

			OvertimePrevMonthPayOff overtimePrevMonthPayOff = (OvertimePrevMonthPayOff)session.get(OvertimePrevMonthPayOffImpl.class,
					primaryKey);

			if (overtimePrevMonthPayOff == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOvertimePrevMonthPayOffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(overtimePrevMonthPayOff);
		}
		catch (NoSuchOvertimePrevMonthPayOffException nsee) {
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
	protected OvertimePrevMonthPayOff removeImpl(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		overtimePrevMonthPayOff = toUnwrappedModel(overtimePrevMonthPayOff);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(overtimePrevMonthPayOff)) {
				overtimePrevMonthPayOff = (OvertimePrevMonthPayOff)session.get(OvertimePrevMonthPayOffImpl.class,
						overtimePrevMonthPayOff.getPrimaryKeyObj());
			}

			if (overtimePrevMonthPayOff != null) {
				session.delete(overtimePrevMonthPayOff);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (overtimePrevMonthPayOff != null) {
			clearCache(overtimePrevMonthPayOff);
		}

		return overtimePrevMonthPayOff;
	}

	@Override
	public OvertimePrevMonthPayOff updateImpl(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		overtimePrevMonthPayOff = toUnwrappedModel(overtimePrevMonthPayOff);

		boolean isNew = overtimePrevMonthPayOff.isNew();

		Session session = null;

		try {
			session = openSession();

			if (overtimePrevMonthPayOff.isNew()) {
				session.save(overtimePrevMonthPayOff);

				overtimePrevMonthPayOff.setNew(false);
			}
			else {
				overtimePrevMonthPayOff = (OvertimePrevMonthPayOff)session.merge(overtimePrevMonthPayOff);
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

		entityCache.putResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
			OvertimePrevMonthPayOffImpl.class,
			overtimePrevMonthPayOff.getPrimaryKey(), overtimePrevMonthPayOff,
			false);

		overtimePrevMonthPayOff.resetOriginalValues();

		return overtimePrevMonthPayOff;
	}

	protected OvertimePrevMonthPayOff toUnwrappedModel(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		if (overtimePrevMonthPayOff instanceof OvertimePrevMonthPayOffImpl) {
			return overtimePrevMonthPayOff;
		}

		OvertimePrevMonthPayOffImpl overtimePrevMonthPayOffImpl = new OvertimePrevMonthPayOffImpl();

		overtimePrevMonthPayOffImpl.setNew(overtimePrevMonthPayOff.isNew());
		overtimePrevMonthPayOffImpl.setPrimaryKey(overtimePrevMonthPayOff.getPrimaryKey());

		overtimePrevMonthPayOffImpl.setPersonId(overtimePrevMonthPayOff.getPersonId());
		overtimePrevMonthPayOffImpl.setOvertimeHoursCurrPayOff(overtimePrevMonthPayOff.getOvertimeHoursCurrPayOff());

		return overtimePrevMonthPayOffImpl;
	}

	/**
	 * Returns the overtime prev month pay off with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the overtime prev month pay off
	 * @return the overtime prev month pay off
	 * @throws NoSuchOvertimePrevMonthPayOffException if a overtime prev month pay off with the primary key could not be found
	 */
	@Override
	public OvertimePrevMonthPayOff findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOvertimePrevMonthPayOffException {
		OvertimePrevMonthPayOff overtimePrevMonthPayOff = fetchByPrimaryKey(primaryKey);

		if (overtimePrevMonthPayOff == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOvertimePrevMonthPayOffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return overtimePrevMonthPayOff;
	}

	/**
	 * Returns the overtime prev month pay off with the primary key or throws a {@link NoSuchOvertimePrevMonthPayOffException} if it could not be found.
	 *
	 * @param personId the primary key of the overtime prev month pay off
	 * @return the overtime prev month pay off
	 * @throws NoSuchOvertimePrevMonthPayOffException if a overtime prev month pay off with the primary key could not be found
	 */
	@Override
	public OvertimePrevMonthPayOff findByPrimaryKey(long personId)
		throws NoSuchOvertimePrevMonthPayOffException {
		return findByPrimaryKey((Serializable)personId);
	}

	/**
	 * Returns the overtime prev month pay off with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the overtime prev month pay off
	 * @return the overtime prev month pay off, or <code>null</code> if a overtime prev month pay off with the primary key could not be found
	 */
	@Override
	public OvertimePrevMonthPayOff fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
				OvertimePrevMonthPayOffImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		OvertimePrevMonthPayOff overtimePrevMonthPayOff = (OvertimePrevMonthPayOff)serializable;

		if (overtimePrevMonthPayOff == null) {
			Session session = null;

			try {
				session = openSession();

				overtimePrevMonthPayOff = (OvertimePrevMonthPayOff)session.get(OvertimePrevMonthPayOffImpl.class,
						primaryKey);

				if (overtimePrevMonthPayOff != null) {
					cacheResult(overtimePrevMonthPayOff);
				}
				else {
					entityCache.putResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
						OvertimePrevMonthPayOffImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
					OvertimePrevMonthPayOffImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return overtimePrevMonthPayOff;
	}

	/**
	 * Returns the overtime prev month pay off with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personId the primary key of the overtime prev month pay off
	 * @return the overtime prev month pay off, or <code>null</code> if a overtime prev month pay off with the primary key could not be found
	 */
	@Override
	public OvertimePrevMonthPayOff fetchByPrimaryKey(long personId) {
		return fetchByPrimaryKey((Serializable)personId);
	}

	@Override
	public Map<Serializable, OvertimePrevMonthPayOff> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, OvertimePrevMonthPayOff> map = new HashMap<Serializable, OvertimePrevMonthPayOff>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			OvertimePrevMonthPayOff overtimePrevMonthPayOff = fetchByPrimaryKey(primaryKey);

			if (overtimePrevMonthPayOff != null) {
				map.put(primaryKey, overtimePrevMonthPayOff);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
					OvertimePrevMonthPayOffImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (OvertimePrevMonthPayOff)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OVERTIMEPREVMONTHPAYOFF_WHERE_PKS_IN);

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

			for (OvertimePrevMonthPayOff overtimePrevMonthPayOff : (List<OvertimePrevMonthPayOff>)q.list()) {
				map.put(overtimePrevMonthPayOff.getPrimaryKeyObj(),
					overtimePrevMonthPayOff);

				cacheResult(overtimePrevMonthPayOff);

				uncachedPrimaryKeys.remove(overtimePrevMonthPayOff.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OvertimePrevMonthPayOffModelImpl.ENTITY_CACHE_ENABLED,
					OvertimePrevMonthPayOffImpl.class, primaryKey, nullModel);
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
	 * Returns all the overtime prev month pay offs.
	 *
	 * @return the overtime prev month pay offs
	 */
	@Override
	public List<OvertimePrevMonthPayOff> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the overtime prev month pay offs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime prev month pay offs
	 * @param end the upper bound of the range of overtime prev month pay offs (not inclusive)
	 * @return the range of overtime prev month pay offs
	 */
	@Override
	public List<OvertimePrevMonthPayOff> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the overtime prev month pay offs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime prev month pay offs
	 * @param end the upper bound of the range of overtime prev month pay offs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of overtime prev month pay offs
	 */
	@Override
	public List<OvertimePrevMonthPayOff> findAll(int start, int end,
		OrderByComparator<OvertimePrevMonthPayOff> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the overtime prev month pay offs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of overtime prev month pay offs
	 * @param end the upper bound of the range of overtime prev month pay offs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of overtime prev month pay offs
	 */
	@Override
	public List<OvertimePrevMonthPayOff> findAll(int start, int end,
		OrderByComparator<OvertimePrevMonthPayOff> orderByComparator,
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

		List<OvertimePrevMonthPayOff> list = null;

		if (retrieveFromCache) {
			list = (List<OvertimePrevMonthPayOff>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OVERTIMEPREVMONTHPAYOFF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OVERTIMEPREVMONTHPAYOFF;

				if (pagination) {
					sql = sql.concat(OvertimePrevMonthPayOffModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OvertimePrevMonthPayOff>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OvertimePrevMonthPayOff>)QueryUtil.list(q,
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
	 * Removes all the overtime prev month pay offs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OvertimePrevMonthPayOff overtimePrevMonthPayOff : findAll()) {
			remove(overtimePrevMonthPayOff);
		}
	}

	/**
	 * Returns the number of overtime prev month pay offs.
	 *
	 * @return the number of overtime prev month pay offs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OVERTIMEPREVMONTHPAYOFF);

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
		return OvertimePrevMonthPayOffModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the overtime prev month pay off persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OvertimePrevMonthPayOffImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_OVERTIMEPREVMONTHPAYOFF = "SELECT overtimePrevMonthPayOff FROM OvertimePrevMonthPayOff overtimePrevMonthPayOff";
	private static final String _SQL_SELECT_OVERTIMEPREVMONTHPAYOFF_WHERE_PKS_IN =
		"SELECT overtimePrevMonthPayOff FROM OvertimePrevMonthPayOff overtimePrevMonthPayOff WHERE PERSON_ID IN (";
	private static final String _SQL_COUNT_OVERTIMEPREVMONTHPAYOFF = "SELECT COUNT(overtimePrevMonthPayOff) FROM OvertimePrevMonthPayOff overtimePrevMonthPayOff";
	private static final String _ORDER_BY_ENTITY_ALIAS = "overtimePrevMonthPayOff.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OvertimePrevMonthPayOff exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(OvertimePrevMonthPayOffPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personId", "overtimeHoursCurrPayOff"
			});
}