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

package mef.webcontent.config.service.persistence.impl;

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

import mef.webcontent.config.exception.NoSuchWebContentConfigException;
import mef.webcontent.config.model.WebContentConfig;
import mef.webcontent.config.model.impl.WebContentConfigImpl;
import mef.webcontent.config.model.impl.WebContentConfigModelImpl;
import mef.webcontent.config.service.persistence.WebContentConfigPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the web content config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebContentConfigPersistence
 * @see mef.webcontent.config.service.persistence.WebContentConfigUtil
 * @generated
 */
@ProviderType
public class WebContentConfigPersistenceImpl extends BasePersistenceImpl<WebContentConfig>
	implements WebContentConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WebContentConfigUtil} to access the web content config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WebContentConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
			WebContentConfigModelImpl.FINDER_CACHE_ENABLED,
			WebContentConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
			WebContentConfigModelImpl.FINDER_CACHE_ENABLED,
			WebContentConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
			WebContentConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WebContentConfigPersistenceImpl() {
		setModelClass(WebContentConfig.class);
	}

	/**
	 * Caches the web content config in the entity cache if it is enabled.
	 *
	 * @param webContentConfig the web content config
	 */
	@Override
	public void cacheResult(WebContentConfig webContentConfig) {
		entityCache.putResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
			WebContentConfigImpl.class, webContentConfig.getPrimaryKey(),
			webContentConfig);

		webContentConfig.resetOriginalValues();
	}

	/**
	 * Caches the web content configs in the entity cache if it is enabled.
	 *
	 * @param webContentConfigs the web content configs
	 */
	@Override
	public void cacheResult(List<WebContentConfig> webContentConfigs) {
		for (WebContentConfig webContentConfig : webContentConfigs) {
			if (entityCache.getResult(
						WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
						WebContentConfigImpl.class,
						webContentConfig.getPrimaryKey()) == null) {
				cacheResult(webContentConfig);
			}
			else {
				webContentConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all web content configs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WebContentConfigImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the web content config.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WebContentConfig webContentConfig) {
		entityCache.removeResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
			WebContentConfigImpl.class, webContentConfig.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WebContentConfig> webContentConfigs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WebContentConfig webContentConfig : webContentConfigs) {
			entityCache.removeResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
				WebContentConfigImpl.class, webContentConfig.getPrimaryKey());
		}
	}

	/**
	 * Creates a new web content config with the primary key. Does not add the web content config to the database.
	 *
	 * @param contentid the primary key for the new web content config
	 * @return the new web content config
	 */
	@Override
	public WebContentConfig create(long contentid) {
		WebContentConfig webContentConfig = new WebContentConfigImpl();

		webContentConfig.setNew(true);
		webContentConfig.setPrimaryKey(contentid);

		return webContentConfig;
	}

	/**
	 * Removes the web content config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentid the primary key of the web content config
	 * @return the web content config that was removed
	 * @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	 */
	@Override
	public WebContentConfig remove(long contentid)
		throws NoSuchWebContentConfigException {
		return remove((Serializable)contentid);
	}

	/**
	 * Removes the web content config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the web content config
	 * @return the web content config that was removed
	 * @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	 */
	@Override
	public WebContentConfig remove(Serializable primaryKey)
		throws NoSuchWebContentConfigException {
		Session session = null;

		try {
			session = openSession();

			WebContentConfig webContentConfig = (WebContentConfig)session.get(WebContentConfigImpl.class,
					primaryKey);

			if (webContentConfig == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWebContentConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(webContentConfig);
		}
		catch (NoSuchWebContentConfigException nsee) {
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
	protected WebContentConfig removeImpl(WebContentConfig webContentConfig) {
		webContentConfig = toUnwrappedModel(webContentConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(webContentConfig)) {
				webContentConfig = (WebContentConfig)session.get(WebContentConfigImpl.class,
						webContentConfig.getPrimaryKeyObj());
			}

			if (webContentConfig != null) {
				session.delete(webContentConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (webContentConfig != null) {
			clearCache(webContentConfig);
		}

		return webContentConfig;
	}

	@Override
	public WebContentConfig updateImpl(WebContentConfig webContentConfig) {
		webContentConfig = toUnwrappedModel(webContentConfig);

		boolean isNew = webContentConfig.isNew();

		Session session = null;

		try {
			session = openSession();

			if (webContentConfig.isNew()) {
				session.save(webContentConfig);

				webContentConfig.setNew(false);
			}
			else {
				webContentConfig = (WebContentConfig)session.merge(webContentConfig);
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

		entityCache.putResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
			WebContentConfigImpl.class, webContentConfig.getPrimaryKey(),
			webContentConfig, false);

		webContentConfig.resetOriginalValues();

		return webContentConfig;
	}

	protected WebContentConfig toUnwrappedModel(
		WebContentConfig webContentConfig) {
		if (webContentConfig instanceof WebContentConfigImpl) {
			return webContentConfig;
		}

		WebContentConfigImpl webContentConfigImpl = new WebContentConfigImpl();

		webContentConfigImpl.setNew(webContentConfig.isNew());
		webContentConfigImpl.setPrimaryKey(webContentConfig.getPrimaryKey());

		webContentConfigImpl.setContentid(webContentConfig.getContentid());
		webContentConfigImpl.setHtml(webContentConfig.getHtml());

		return webContentConfigImpl;
	}

	/**
	 * Returns the web content config with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the web content config
	 * @return the web content config
	 * @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	 */
	@Override
	public WebContentConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWebContentConfigException {
		WebContentConfig webContentConfig = fetchByPrimaryKey(primaryKey);

		if (webContentConfig == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWebContentConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return webContentConfig;
	}

	/**
	 * Returns the web content config with the primary key or throws a {@link NoSuchWebContentConfigException} if it could not be found.
	 *
	 * @param contentid the primary key of the web content config
	 * @return the web content config
	 * @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	 */
	@Override
	public WebContentConfig findByPrimaryKey(long contentid)
		throws NoSuchWebContentConfigException {
		return findByPrimaryKey((Serializable)contentid);
	}

	/**
	 * Returns the web content config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the web content config
	 * @return the web content config, or <code>null</code> if a web content config with the primary key could not be found
	 */
	@Override
	public WebContentConfig fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
				WebContentConfigImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WebContentConfig webContentConfig = (WebContentConfig)serializable;

		if (webContentConfig == null) {
			Session session = null;

			try {
				session = openSession();

				webContentConfig = (WebContentConfig)session.get(WebContentConfigImpl.class,
						primaryKey);

				if (webContentConfig != null) {
					cacheResult(webContentConfig);
				}
				else {
					entityCache.putResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
						WebContentConfigImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
					WebContentConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return webContentConfig;
	}

	/**
	 * Returns the web content config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentid the primary key of the web content config
	 * @return the web content config, or <code>null</code> if a web content config with the primary key could not be found
	 */
	@Override
	public WebContentConfig fetchByPrimaryKey(long contentid) {
		return fetchByPrimaryKey((Serializable)contentid);
	}

	@Override
	public Map<Serializable, WebContentConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WebContentConfig> map = new HashMap<Serializable, WebContentConfig>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WebContentConfig webContentConfig = fetchByPrimaryKey(primaryKey);

			if (webContentConfig != null) {
				map.put(primaryKey, webContentConfig);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
					WebContentConfigImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WebContentConfig)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WEBCONTENTCONFIG_WHERE_PKS_IN);

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

			for (WebContentConfig webContentConfig : (List<WebContentConfig>)q.list()) {
				map.put(webContentConfig.getPrimaryKeyObj(), webContentConfig);

				cacheResult(webContentConfig);

				uncachedPrimaryKeys.remove(webContentConfig.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WebContentConfigModelImpl.ENTITY_CACHE_ENABLED,
					WebContentConfigImpl.class, primaryKey, nullModel);
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
	 * Returns all the web content configs.
	 *
	 * @return the web content configs
	 */
	@Override
	public List<WebContentConfig> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the web content configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WebContentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of web content configs
	 * @param end the upper bound of the range of web content configs (not inclusive)
	 * @return the range of web content configs
	 */
	@Override
	public List<WebContentConfig> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the web content configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WebContentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of web content configs
	 * @param end the upper bound of the range of web content configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of web content configs
	 */
	@Override
	public List<WebContentConfig> findAll(int start, int end,
		OrderByComparator<WebContentConfig> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the web content configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WebContentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of web content configs
	 * @param end the upper bound of the range of web content configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of web content configs
	 */
	@Override
	public List<WebContentConfig> findAll(int start, int end,
		OrderByComparator<WebContentConfig> orderByComparator,
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

		List<WebContentConfig> list = null;

		if (retrieveFromCache) {
			list = (List<WebContentConfig>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WEBCONTENTCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEBCONTENTCONFIG;

				if (pagination) {
					sql = sql.concat(WebContentConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WebContentConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WebContentConfig>)QueryUtil.list(q,
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
	 * Removes all the web content configs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WebContentConfig webContentConfig : findAll()) {
			remove(webContentConfig);
		}
	}

	/**
	 * Returns the number of web content configs.
	 *
	 * @return the number of web content configs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WEBCONTENTCONFIG);

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
		return WebContentConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the web content config persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WebContentConfigImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WEBCONTENTCONFIG = "SELECT webContentConfig FROM WebContentConfig webContentConfig";
	private static final String _SQL_SELECT_WEBCONTENTCONFIG_WHERE_PKS_IN = "SELECT webContentConfig FROM WebContentConfig webContentConfig WHERE contentid IN (";
	private static final String _SQL_COUNT_WEBCONTENTCONFIG = "SELECT COUNT(webContentConfig) FROM WebContentConfig webContentConfig";
	private static final String _ORDER_BY_ENTITY_ALIAS = "webContentConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WebContentConfig exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WebContentConfigPersistenceImpl.class);
}