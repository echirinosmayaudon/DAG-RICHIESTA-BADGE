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

import service.intranet.mef.exception.NoSuchPeriodicitaRichPubblicException;
import service.intranet.mef.model.PeriodicitaRichPubblic;
import service.intranet.mef.model.impl.PeriodicitaRichPubblicImpl;
import service.intranet.mef.model.impl.PeriodicitaRichPubblicModelImpl;
import service.intranet.mef.service.persistence.PeriodicitaRichPubblicPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the periodicita rich pubblic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PeriodicitaRichPubblicPersistence
 * @see service.intranet.mef.service.persistence.PeriodicitaRichPubblicUtil
 * @generated
 */
@ProviderType
public class PeriodicitaRichPubblicPersistenceImpl extends BasePersistenceImpl<PeriodicitaRichPubblic>
	implements PeriodicitaRichPubblicPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PeriodicitaRichPubblicUtil} to access the periodicita rich pubblic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PeriodicitaRichPubblicImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaRichPubblicModelImpl.FINDER_CACHE_ENABLED,
			PeriodicitaRichPubblicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaRichPubblicModelImpl.FINDER_CACHE_ENABLED,
			PeriodicitaRichPubblicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaRichPubblicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PeriodicitaRichPubblicPersistenceImpl() {
		setModelClass(PeriodicitaRichPubblic.class);
	}

	/**
	 * Caches the periodicita rich pubblic in the entity cache if it is enabled.
	 *
	 * @param periodicitaRichPubblic the periodicita rich pubblic
	 */
	@Override
	public void cacheResult(PeriodicitaRichPubblic periodicitaRichPubblic) {
		entityCache.putResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaRichPubblicImpl.class,
			periodicitaRichPubblic.getPrimaryKey(), periodicitaRichPubblic);

		periodicitaRichPubblic.resetOriginalValues();
	}

	/**
	 * Caches the periodicita rich pubblics in the entity cache if it is enabled.
	 *
	 * @param periodicitaRichPubblics the periodicita rich pubblics
	 */
	@Override
	public void cacheResult(
		List<PeriodicitaRichPubblic> periodicitaRichPubblics) {
		for (PeriodicitaRichPubblic periodicitaRichPubblic : periodicitaRichPubblics) {
			if (entityCache.getResult(
						PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
						PeriodicitaRichPubblicImpl.class,
						periodicitaRichPubblic.getPrimaryKey()) == null) {
				cacheResult(periodicitaRichPubblic);
			}
			else {
				periodicitaRichPubblic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all periodicita rich pubblics.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PeriodicitaRichPubblicImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the periodicita rich pubblic.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PeriodicitaRichPubblic periodicitaRichPubblic) {
		entityCache.removeResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaRichPubblicImpl.class,
			periodicitaRichPubblic.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PeriodicitaRichPubblic> periodicitaRichPubblics) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PeriodicitaRichPubblic periodicitaRichPubblic : periodicitaRichPubblics) {
			entityCache.removeResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
				PeriodicitaRichPubblicImpl.class,
				periodicitaRichPubblic.getPrimaryKey());
		}
	}

	/**
	 * Creates a new periodicita rich pubblic with the primary key. Does not add the periodicita rich pubblic to the database.
	 *
	 * @param id the primary key for the new periodicita rich pubblic
	 * @return the new periodicita rich pubblic
	 */
	@Override
	public PeriodicitaRichPubblic create(long id) {
		PeriodicitaRichPubblic periodicitaRichPubblic = new PeriodicitaRichPubblicImpl();

		periodicitaRichPubblic.setNew(true);
		periodicitaRichPubblic.setPrimaryKey(id);

		return periodicitaRichPubblic;
	}

	/**
	 * Removes the periodicita rich pubblic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the periodicita rich pubblic
	 * @return the periodicita rich pubblic that was removed
	 * @throws NoSuchPeriodicitaRichPubblicException if a periodicita rich pubblic with the primary key could not be found
	 */
	@Override
	public PeriodicitaRichPubblic remove(long id)
		throws NoSuchPeriodicitaRichPubblicException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the periodicita rich pubblic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the periodicita rich pubblic
	 * @return the periodicita rich pubblic that was removed
	 * @throws NoSuchPeriodicitaRichPubblicException if a periodicita rich pubblic with the primary key could not be found
	 */
	@Override
	public PeriodicitaRichPubblic remove(Serializable primaryKey)
		throws NoSuchPeriodicitaRichPubblicException {
		Session session = null;

		try {
			session = openSession();

			PeriodicitaRichPubblic periodicitaRichPubblic = (PeriodicitaRichPubblic)session.get(PeriodicitaRichPubblicImpl.class,
					primaryKey);

			if (periodicitaRichPubblic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPeriodicitaRichPubblicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(periodicitaRichPubblic);
		}
		catch (NoSuchPeriodicitaRichPubblicException nsee) {
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
	protected PeriodicitaRichPubblic removeImpl(
		PeriodicitaRichPubblic periodicitaRichPubblic) {
		periodicitaRichPubblic = toUnwrappedModel(periodicitaRichPubblic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(periodicitaRichPubblic)) {
				periodicitaRichPubblic = (PeriodicitaRichPubblic)session.get(PeriodicitaRichPubblicImpl.class,
						periodicitaRichPubblic.getPrimaryKeyObj());
			}

			if (periodicitaRichPubblic != null) {
				session.delete(periodicitaRichPubblic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (periodicitaRichPubblic != null) {
			clearCache(periodicitaRichPubblic);
		}

		return periodicitaRichPubblic;
	}

	@Override
	public PeriodicitaRichPubblic updateImpl(
		PeriodicitaRichPubblic periodicitaRichPubblic) {
		periodicitaRichPubblic = toUnwrappedModel(periodicitaRichPubblic);

		boolean isNew = periodicitaRichPubblic.isNew();

		Session session = null;

		try {
			session = openSession();

			if (periodicitaRichPubblic.isNew()) {
				session.save(periodicitaRichPubblic);

				periodicitaRichPubblic.setNew(false);
			}
			else {
				periodicitaRichPubblic = (PeriodicitaRichPubblic)session.merge(periodicitaRichPubblic);
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

		entityCache.putResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
			PeriodicitaRichPubblicImpl.class,
			periodicitaRichPubblic.getPrimaryKey(), periodicitaRichPubblic,
			false);

		periodicitaRichPubblic.resetOriginalValues();

		return periodicitaRichPubblic;
	}

	protected PeriodicitaRichPubblic toUnwrappedModel(
		PeriodicitaRichPubblic periodicitaRichPubblic) {
		if (periodicitaRichPubblic instanceof PeriodicitaRichPubblicImpl) {
			return periodicitaRichPubblic;
		}

		PeriodicitaRichPubblicImpl periodicitaRichPubblicImpl = new PeriodicitaRichPubblicImpl();

		periodicitaRichPubblicImpl.setNew(periodicitaRichPubblic.isNew());
		periodicitaRichPubblicImpl.setPrimaryKey(periodicitaRichPubblic.getPrimaryKey());

		periodicitaRichPubblicImpl.setId(periodicitaRichPubblic.getId());
		periodicitaRichPubblicImpl.setPeriodicita(periodicitaRichPubblic.getPeriodicita());

		return periodicitaRichPubblicImpl;
	}

	/**
	 * Returns the periodicita rich pubblic with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the periodicita rich pubblic
	 * @return the periodicita rich pubblic
	 * @throws NoSuchPeriodicitaRichPubblicException if a periodicita rich pubblic with the primary key could not be found
	 */
	@Override
	public PeriodicitaRichPubblic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPeriodicitaRichPubblicException {
		PeriodicitaRichPubblic periodicitaRichPubblic = fetchByPrimaryKey(primaryKey);

		if (periodicitaRichPubblic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPeriodicitaRichPubblicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return periodicitaRichPubblic;
	}

	/**
	 * Returns the periodicita rich pubblic with the primary key or throws a {@link NoSuchPeriodicitaRichPubblicException} if it could not be found.
	 *
	 * @param id the primary key of the periodicita rich pubblic
	 * @return the periodicita rich pubblic
	 * @throws NoSuchPeriodicitaRichPubblicException if a periodicita rich pubblic with the primary key could not be found
	 */
	@Override
	public PeriodicitaRichPubblic findByPrimaryKey(long id)
		throws NoSuchPeriodicitaRichPubblicException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the periodicita rich pubblic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the periodicita rich pubblic
	 * @return the periodicita rich pubblic, or <code>null</code> if a periodicita rich pubblic with the primary key could not be found
	 */
	@Override
	public PeriodicitaRichPubblic fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
				PeriodicitaRichPubblicImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PeriodicitaRichPubblic periodicitaRichPubblic = (PeriodicitaRichPubblic)serializable;

		if (periodicitaRichPubblic == null) {
			Session session = null;

			try {
				session = openSession();

				periodicitaRichPubblic = (PeriodicitaRichPubblic)session.get(PeriodicitaRichPubblicImpl.class,
						primaryKey);

				if (periodicitaRichPubblic != null) {
					cacheResult(periodicitaRichPubblic);
				}
				else {
					entityCache.putResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
						PeriodicitaRichPubblicImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
					PeriodicitaRichPubblicImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return periodicitaRichPubblic;
	}

	/**
	 * Returns the periodicita rich pubblic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the periodicita rich pubblic
	 * @return the periodicita rich pubblic, or <code>null</code> if a periodicita rich pubblic with the primary key could not be found
	 */
	@Override
	public PeriodicitaRichPubblic fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, PeriodicitaRichPubblic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PeriodicitaRichPubblic> map = new HashMap<Serializable, PeriodicitaRichPubblic>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PeriodicitaRichPubblic periodicitaRichPubblic = fetchByPrimaryKey(primaryKey);

			if (periodicitaRichPubblic != null) {
				map.put(primaryKey, periodicitaRichPubblic);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
					PeriodicitaRichPubblicImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PeriodicitaRichPubblic)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PERIODICITARICHPUBBLIC_WHERE_PKS_IN);

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

			for (PeriodicitaRichPubblic periodicitaRichPubblic : (List<PeriodicitaRichPubblic>)q.list()) {
				map.put(periodicitaRichPubblic.getPrimaryKeyObj(),
					periodicitaRichPubblic);

				cacheResult(periodicitaRichPubblic);

				uncachedPrimaryKeys.remove(periodicitaRichPubblic.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PeriodicitaRichPubblicModelImpl.ENTITY_CACHE_ENABLED,
					PeriodicitaRichPubblicImpl.class, primaryKey, nullModel);
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
	 * Returns all the periodicita rich pubblics.
	 *
	 * @return the periodicita rich pubblics
	 */
	@Override
	public List<PeriodicitaRichPubblic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the periodicita rich pubblics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of periodicita rich pubblics
	 * @param end the upper bound of the range of periodicita rich pubblics (not inclusive)
	 * @return the range of periodicita rich pubblics
	 */
	@Override
	public List<PeriodicitaRichPubblic> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the periodicita rich pubblics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of periodicita rich pubblics
	 * @param end the upper bound of the range of periodicita rich pubblics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of periodicita rich pubblics
	 */
	@Override
	public List<PeriodicitaRichPubblic> findAll(int start, int end,
		OrderByComparator<PeriodicitaRichPubblic> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the periodicita rich pubblics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of periodicita rich pubblics
	 * @param end the upper bound of the range of periodicita rich pubblics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of periodicita rich pubblics
	 */
	@Override
	public List<PeriodicitaRichPubblic> findAll(int start, int end,
		OrderByComparator<PeriodicitaRichPubblic> orderByComparator,
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

		List<PeriodicitaRichPubblic> list = null;

		if (retrieveFromCache) {
			list = (List<PeriodicitaRichPubblic>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERIODICITARICHPUBBLIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERIODICITARICHPUBBLIC;

				if (pagination) {
					sql = sql.concat(PeriodicitaRichPubblicModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PeriodicitaRichPubblic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PeriodicitaRichPubblic>)QueryUtil.list(q,
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
	 * Removes all the periodicita rich pubblics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PeriodicitaRichPubblic periodicitaRichPubblic : findAll()) {
			remove(periodicitaRichPubblic);
		}
	}

	/**
	 * Returns the number of periodicita rich pubblics.
	 *
	 * @return the number of periodicita rich pubblics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERIODICITARICHPUBBLIC);

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
		return PeriodicitaRichPubblicModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the periodicita rich pubblic persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PeriodicitaRichPubblicImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PERIODICITARICHPUBBLIC = "SELECT periodicitaRichPubblic FROM PeriodicitaRichPubblic periodicitaRichPubblic";
	private static final String _SQL_SELECT_PERIODICITARICHPUBBLIC_WHERE_PKS_IN = "SELECT periodicitaRichPubblic FROM PeriodicitaRichPubblic periodicitaRichPubblic WHERE id_ IN (";
	private static final String _SQL_COUNT_PERIODICITARICHPUBBLIC = "SELECT COUNT(periodicitaRichPubblic) FROM PeriodicitaRichPubblic periodicitaRichPubblic";
	private static final String _ORDER_BY_ENTITY_ALIAS = "periodicitaRichPubblic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PeriodicitaRichPubblic exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PeriodicitaRichPubblicPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}