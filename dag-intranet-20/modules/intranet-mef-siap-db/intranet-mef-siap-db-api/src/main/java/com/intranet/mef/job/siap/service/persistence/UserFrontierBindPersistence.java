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

package com.intranet.mef.job.siap.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.exception.NoSuchUserFrontierBindException;
import com.intranet.mef.job.siap.model.UserFrontierBind;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user frontier bind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.UserFrontierBindPersistenceImpl
 * @see UserFrontierBindUtil
 * @generated
 */
@ProviderType
public interface UserFrontierBindPersistence extends BasePersistence<UserFrontierBind> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserFrontierBindUtil} to access the user frontier bind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user frontier bind in the entity cache if it is enabled.
	*
	* @param userFrontierBind the user frontier bind
	*/
	public void cacheResult(UserFrontierBind userFrontierBind);

	/**
	* Caches the user frontier binds in the entity cache if it is enabled.
	*
	* @param userFrontierBinds the user frontier binds
	*/
	public void cacheResult(java.util.List<UserFrontierBind> userFrontierBinds);

	/**
	* Creates a new user frontier bind with the primary key. Does not add the user frontier bind to the database.
	*
	* @param userFrontierBindPK the primary key for the new user frontier bind
	* @return the new user frontier bind
	*/
	public UserFrontierBind create(UserFrontierBindPK userFrontierBindPK);

	/**
	* Removes the user frontier bind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userFrontierBindPK the primary key of the user frontier bind
	* @return the user frontier bind that was removed
	* @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	*/
	public UserFrontierBind remove(UserFrontierBindPK userFrontierBindPK)
		throws NoSuchUserFrontierBindException;

	public UserFrontierBind updateImpl(UserFrontierBind userFrontierBind);

	/**
	* Returns the user frontier bind with the primary key or throws a {@link NoSuchUserFrontierBindException} if it could not be found.
	*
	* @param userFrontierBindPK the primary key of the user frontier bind
	* @return the user frontier bind
	* @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	*/
	public UserFrontierBind findByPrimaryKey(
		UserFrontierBindPK userFrontierBindPK)
		throws NoSuchUserFrontierBindException;

	/**
	* Returns the user frontier bind with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userFrontierBindPK the primary key of the user frontier bind
	* @return the user frontier bind, or <code>null</code> if a user frontier bind with the primary key could not be found
	*/
	public UserFrontierBind fetchByPrimaryKey(
		UserFrontierBindPK userFrontierBindPK);

	@Override
	public java.util.Map<java.io.Serializable, UserFrontierBind> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user frontier binds.
	*
	* @return the user frontier binds
	*/
	public java.util.List<UserFrontierBind> findAll();

	/**
	* Returns a range of all the user frontier binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user frontier binds
	* @param end the upper bound of the range of user frontier binds (not inclusive)
	* @return the range of user frontier binds
	*/
	public java.util.List<UserFrontierBind> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user frontier binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user frontier binds
	* @param end the upper bound of the range of user frontier binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user frontier binds
	*/
	public java.util.List<UserFrontierBind> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFrontierBind> orderByComparator);

	/**
	* Returns an ordered range of all the user frontier binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user frontier binds
	* @param end the upper bound of the range of user frontier binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user frontier binds
	*/
	public java.util.List<UserFrontierBind> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFrontierBind> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user frontier binds from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user frontier binds.
	*
	* @return the number of user frontier binds
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}