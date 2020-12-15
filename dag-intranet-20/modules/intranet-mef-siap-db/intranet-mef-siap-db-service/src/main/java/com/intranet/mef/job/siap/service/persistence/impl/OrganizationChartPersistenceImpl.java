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

import com.intranet.mef.job.siap.exception.NoSuchOrganizationChartException;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.model.impl.OrganizationChartImpl;
import com.intranet.mef.job.siap.model.impl.OrganizationChartModelImpl;
import com.intranet.mef.job.siap.service.persistence.OrganizationChartPersistence;

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
 * The persistence implementation for the organization chart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChartPersistence
 * @see com.intranet.mef.job.siap.service.persistence.OrganizationChartUtil
 * @generated
 */
@ProviderType
public class OrganizationChartPersistenceImpl extends BasePersistenceImpl<OrganizationChart>
	implements OrganizationChartPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationChartUtil} to access the organization chart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationChartImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationChartModelImpl.FINDER_CACHE_ENABLED,
			OrganizationChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationChartModelImpl.FINDER_CACHE_ENABLED,
			OrganizationChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationChartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OrganizationChartPersistenceImpl() {
		setModelClass(OrganizationChart.class);
	}

	/**
	 * Caches the organization chart in the entity cache if it is enabled.
	 *
	 * @param organizationChart the organization chart
	 */
	@Override
	public void cacheResult(OrganizationChart organizationChart) {
		entityCache.putResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationChartImpl.class, organizationChart.getPrimaryKey(),
			organizationChart);

		organizationChart.resetOriginalValues();
	}

	/**
	 * Caches the organization charts in the entity cache if it is enabled.
	 *
	 * @param organizationCharts the organization charts
	 */
	@Override
	public void cacheResult(List<OrganizationChart> organizationCharts) {
		for (OrganizationChart organizationChart : organizationCharts) {
			if (entityCache.getResult(
						OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationChartImpl.class,
						organizationChart.getPrimaryKey()) == null) {
				cacheResult(organizationChart);
			}
			else {
				organizationChart.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organization charts.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrganizationChartImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization chart.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationChart organizationChart) {
		entityCache.removeResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationChartImpl.class, organizationChart.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrganizationChart> organizationCharts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrganizationChart organizationChart : organizationCharts) {
			entityCache.removeResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationChartImpl.class, organizationChart.getPrimaryKey());
		}
	}

	/**
	 * Creates a new organization chart with the primary key. Does not add the organization chart to the database.
	 *
	 * @param idOrgChart the primary key for the new organization chart
	 * @return the new organization chart
	 */
	@Override
	public OrganizationChart create(long idOrgChart) {
		OrganizationChart organizationChart = new OrganizationChartImpl();

		organizationChart.setNew(true);
		organizationChart.setPrimaryKey(idOrgChart);

		return organizationChart;
	}

	/**
	 * Removes the organization chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idOrgChart the primary key of the organization chart
	 * @return the organization chart that was removed
	 * @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	 */
	@Override
	public OrganizationChart remove(long idOrgChart)
		throws NoSuchOrganizationChartException {
		return remove((Serializable)idOrgChart);
	}

	/**
	 * Removes the organization chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization chart
	 * @return the organization chart that was removed
	 * @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	 */
	@Override
	public OrganizationChart remove(Serializable primaryKey)
		throws NoSuchOrganizationChartException {
		Session session = null;

		try {
			session = openSession();

			OrganizationChart organizationChart = (OrganizationChart)session.get(OrganizationChartImpl.class,
					primaryKey);

			if (organizationChart == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationChartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organizationChart);
		}
		catch (NoSuchOrganizationChartException nsee) {
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
	protected OrganizationChart removeImpl(OrganizationChart organizationChart) {
		organizationChart = toUnwrappedModel(organizationChart);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationChart)) {
				organizationChart = (OrganizationChart)session.get(OrganizationChartImpl.class,
						organizationChart.getPrimaryKeyObj());
			}

			if (organizationChart != null) {
				session.delete(organizationChart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organizationChart != null) {
			clearCache(organizationChart);
		}

		return organizationChart;
	}

	@Override
	public OrganizationChart updateImpl(OrganizationChart organizationChart) {
		organizationChart = toUnwrappedModel(organizationChart);

		boolean isNew = organizationChart.isNew();

		Session session = null;

		try {
			session = openSession();

			if (organizationChart.isNew()) {
				session.save(organizationChart);

				organizationChart.setNew(false);
			}
			else {
				organizationChart = (OrganizationChart)session.merge(organizationChart);
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

		entityCache.putResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationChartImpl.class, organizationChart.getPrimaryKey(),
			organizationChart, false);

		organizationChart.resetOriginalValues();

		return organizationChart;
	}

	protected OrganizationChart toUnwrappedModel(
		OrganizationChart organizationChart) {
		if (organizationChart instanceof OrganizationChartImpl) {
			return organizationChart;
		}

		OrganizationChartImpl organizationChartImpl = new OrganizationChartImpl();

		organizationChartImpl.setNew(organizationChart.isNew());
		organizationChartImpl.setPrimaryKey(organizationChart.getPrimaryKey());

		organizationChartImpl.setIdOrgChart(organizationChart.getIdOrgChart());
		organizationChartImpl.setName(organizationChart.getName());
		organizationChartImpl.setLevel(organizationChart.getLevel());
		organizationChartImpl.setIdParent(organizationChart.getIdParent());
		organizationChartImpl.setType(organizationChart.getType());
		organizationChartImpl.setLocationId(organizationChart.getLocationId());
		organizationChartImpl.setEmailOffice(organizationChart.getEmailOffice());
		organizationChartImpl.setFaxOffice(organizationChart.getFaxOffice());
		organizationChartImpl.setLevel1(organizationChart.getLevel1());
		organizationChartImpl.setLevel2(organizationChart.getLevel2());
		organizationChartImpl.setLevel3(organizationChart.getLevel3());
		organizationChartImpl.setLevel4(organizationChart.getLevel4());
		organizationChartImpl.setLevel5(organizationChart.getLevel5());
		organizationChartImpl.setAcronimo(organizationChart.getAcronimo());

		return organizationChartImpl;
	}

	/**
	 * Returns the organization chart with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization chart
	 * @return the organization chart
	 * @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	 */
	@Override
	public OrganizationChart findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationChartException {
		OrganizationChart organizationChart = fetchByPrimaryKey(primaryKey);

		if (organizationChart == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationChartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organizationChart;
	}

	/**
	 * Returns the organization chart with the primary key or throws a {@link NoSuchOrganizationChartException} if it could not be found.
	 *
	 * @param idOrgChart the primary key of the organization chart
	 * @return the organization chart
	 * @throws NoSuchOrganizationChartException if a organization chart with the primary key could not be found
	 */
	@Override
	public OrganizationChart findByPrimaryKey(long idOrgChart)
		throws NoSuchOrganizationChartException {
		return findByPrimaryKey((Serializable)idOrgChart);
	}

	/**
	 * Returns the organization chart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization chart
	 * @return the organization chart, or <code>null</code> if a organization chart with the primary key could not be found
	 */
	@Override
	public OrganizationChart fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationChartImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		OrganizationChart organizationChart = (OrganizationChart)serializable;

		if (organizationChart == null) {
			Session session = null;

			try {
				session = openSession();

				organizationChart = (OrganizationChart)session.get(OrganizationChartImpl.class,
						primaryKey);

				if (organizationChart != null) {
					cacheResult(organizationChart);
				}
				else {
					entityCache.putResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationChartImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationChartImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organizationChart;
	}

	/**
	 * Returns the organization chart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idOrgChart the primary key of the organization chart
	 * @return the organization chart, or <code>null</code> if a organization chart with the primary key could not be found
	 */
	@Override
	public OrganizationChart fetchByPrimaryKey(long idOrgChart) {
		return fetchByPrimaryKey((Serializable)idOrgChart);
	}

	@Override
	public Map<Serializable, OrganizationChart> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, OrganizationChart> map = new HashMap<Serializable, OrganizationChart>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			OrganizationChart organizationChart = fetchByPrimaryKey(primaryKey);

			if (organizationChart != null) {
				map.put(primaryKey, organizationChart);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationChartImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (OrganizationChart)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ORGANIZATIONCHART_WHERE_PKS_IN);

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

			for (OrganizationChart organizationChart : (List<OrganizationChart>)q.list()) {
				map.put(organizationChart.getPrimaryKeyObj(), organizationChart);

				cacheResult(organizationChart);

				uncachedPrimaryKeys.remove(organizationChart.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OrganizationChartModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationChartImpl.class, primaryKey, nullModel);
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
	 * Returns all the organization charts.
	 *
	 * @return the organization charts
	 */
	@Override
	public List<OrganizationChart> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization charts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization charts
	 * @param end the upper bound of the range of organization charts (not inclusive)
	 * @return the range of organization charts
	 */
	@Override
	public List<OrganizationChart> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization charts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization charts
	 * @param end the upper bound of the range of organization charts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization charts
	 */
	@Override
	public List<OrganizationChart> findAll(int start, int end,
		OrderByComparator<OrganizationChart> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization charts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrganizationChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization charts
	 * @param end the upper bound of the range of organization charts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of organization charts
	 */
	@Override
	public List<OrganizationChart> findAll(int start, int end,
		OrderByComparator<OrganizationChart> orderByComparator,
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

		List<OrganizationChart> list = null;

		if (retrieveFromCache) {
			list = (List<OrganizationChart>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ORGANIZATIONCHART);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONCHART;

				if (pagination) {
					sql = sql.concat(OrganizationChartModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrganizationChart>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OrganizationChart>)QueryUtil.list(q,
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
	 * Removes all the organization charts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrganizationChart organizationChart : findAll()) {
			remove(organizationChart);
		}
	}

	/**
	 * Returns the number of organization charts.
	 *
	 * @return the number of organization charts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATIONCHART);

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
		return OrganizationChartModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the organization chart persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OrganizationChartImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ORGANIZATIONCHART = "SELECT organizationChart FROM OrganizationChart organizationChart";
	private static final String _SQL_SELECT_ORGANIZATIONCHART_WHERE_PKS_IN = "SELECT organizationChart FROM OrganizationChart organizationChart WHERE ID_ORGANIGRAMMA IN (";
	private static final String _SQL_COUNT_ORGANIZATIONCHART = "SELECT COUNT(organizationChart) FROM OrganizationChart organizationChart";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationChart.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrganizationChart exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(OrganizationChartPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"idOrgChart", "name", "level", "idParent", "type", "locationId",
				"emailOffice", "faxOffice", "level1", "level2", "level3",
				"level4", "level5", "acronimo"
			});
}