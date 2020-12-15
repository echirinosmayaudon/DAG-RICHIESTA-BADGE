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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import mef.webcontent.config.exception.NoSuchWebContentConfigException;
import mef.webcontent.config.model.WebContentConfig;

/**
 * The persistence interface for the web content config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see mef.webcontent.config.service.persistence.impl.WebContentConfigPersistenceImpl
 * @see WebContentConfigUtil
 * @generated
 */
@ProviderType
public interface WebContentConfigPersistence extends BasePersistence<WebContentConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WebContentConfigUtil} to access the web content config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the web content config in the entity cache if it is enabled.
	*
	* @param webContentConfig the web content config
	*/
	public void cacheResult(WebContentConfig webContentConfig);

	/**
	* Caches the web content configs in the entity cache if it is enabled.
	*
	* @param webContentConfigs the web content configs
	*/
	public void cacheResult(java.util.List<WebContentConfig> webContentConfigs);

	/**
	* Creates a new web content config with the primary key. Does not add the web content config to the database.
	*
	* @param contentid the primary key for the new web content config
	* @return the new web content config
	*/
	public WebContentConfig create(long contentid);

	/**
	* Removes the web content config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentid the primary key of the web content config
	* @return the web content config that was removed
	* @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	*/
	public WebContentConfig remove(long contentid)
		throws NoSuchWebContentConfigException;

	public WebContentConfig updateImpl(WebContentConfig webContentConfig);

	/**
	* Returns the web content config with the primary key or throws a {@link NoSuchWebContentConfigException} if it could not be found.
	*
	* @param contentid the primary key of the web content config
	* @return the web content config
	* @throws NoSuchWebContentConfigException if a web content config with the primary key could not be found
	*/
	public WebContentConfig findByPrimaryKey(long contentid)
		throws NoSuchWebContentConfigException;

	/**
	* Returns the web content config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contentid the primary key of the web content config
	* @return the web content config, or <code>null</code> if a web content config with the primary key could not be found
	*/
	public WebContentConfig fetchByPrimaryKey(long contentid);

	@Override
	public java.util.Map<java.io.Serializable, WebContentConfig> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the web content configs.
	*
	* @return the web content configs
	*/
	public java.util.List<WebContentConfig> findAll();

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
	public java.util.List<WebContentConfig> findAll(int start, int end);

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
	public java.util.List<WebContentConfig> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WebContentConfig> orderByComparator);

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
	public java.util.List<WebContentConfig> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WebContentConfig> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the web content configs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of web content configs.
	*
	* @return the number of web content configs
	*/
	public int countAll();
}