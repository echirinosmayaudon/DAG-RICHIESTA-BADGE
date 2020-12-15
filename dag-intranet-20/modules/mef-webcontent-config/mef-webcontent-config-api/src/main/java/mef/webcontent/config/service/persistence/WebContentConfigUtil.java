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

package mef.webcontent.config.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import mef.webcontent.config.model.WebContentConfig;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the web content config service. This utility wraps {@link mef.webcontent.config.service.persistence.impl.WebContentConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebContentConfigPersistence
 * @see mef.webcontent.config.service.persistence.impl.WebContentConfigPersistenceImpl
 * @generated
 */
@ProviderType
public class WebContentConfigUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(WebContentConfig webContentConfig) {
		getPersistence().clearCache(webContentConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WebContentConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WebContentConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WebContentConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WebContentConfig> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WebContentConfig update(WebContentConfig webContentConfig) {
		return getPersistence().update(webContentConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WebContentConfig update(WebContentConfig webContentConfig,
		ServiceContext serviceContext) {
		return getPersistence().update(webContentConfig, serviceContext);
	}

	/**
	* Caches the web content config in the entity cache if it is enabled.
	*
	* @param webContentConfig the web content config
	*/
	public static void cacheResult(WebContentConfig webContentConfig) {
		getPersistence().cacheResult(webContentConfig);
	}

	/**
	* Caches the web content configs in the entity cache if it is enabled.
	*
	* @param webContentConfigs the web content configs
	*/
	public static void cacheResult(List<WebContentConfig> webContentConfigs) {
		getPersistence().cacheResult(webContentConfigs);
	}

	/**
	* Creates a new web content config with the primary key. Does not add the web content config to the database.
	*
	* @param contentid the primary key for the new web content config
	* @return the new web content config
	*/
	public static WebContentConfig create(long contentid) {
		return getPersistence().create(contentid);
	}

	/**
	* Removes the web content config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentid the primary key of the web content config
	* @return the web content config that was removed
	* @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	*/
	public static WebContentConfig remove(long contentid)
		throws mef.webcontent.config.exception.NoSuchWebContentConfigException {
		return getPersistence().remove(contentid);
	}

	public static WebContentConfig updateImpl(WebContentConfig webContentConfig) {
		return getPersistence().updateImpl(webContentConfig);
	}

	/**
	* Returns the web content config with the primary key or throws a {@link NoSuchWebContentConfigException} if it could not be found.
	*
	* @param contentid the primary key of the web content config
	* @return the web content config
	* @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	*/
	public static WebContentConfig findByPrimaryKey(long contentid)
		throws mef.webcontent.config.exception.NoSuchWebContentConfigException {
		return getPersistence().findByPrimaryKey(contentid);
	}

	/**
	* Returns the web content config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contentid the primary key of the web content config
	* @return the web content config, or <code>null</code> if a web content config with the primary key could not be found
	*/
	public static WebContentConfig fetchByPrimaryKey(long contentid) {
		return getPersistence().fetchByPrimaryKey(contentid);
	}

	public static java.util.Map<java.io.Serializable, WebContentConfig> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the web content configs.
	*
	* @return the web content configs
	*/
	public static List<WebContentConfig> findAll() {
		return getPersistence().findAll();
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
	public static List<WebContentConfig> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<WebContentConfig> findAll(int start, int end,
		OrderByComparator<WebContentConfig> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<WebContentConfig> findAll(int start, int end,
		OrderByComparator<WebContentConfig> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the web content configs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of web content configs.
	*
	* @return the number of web content configs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WebContentConfigPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WebContentConfigPersistence, WebContentConfigPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WebContentConfigPersistence.class);
}