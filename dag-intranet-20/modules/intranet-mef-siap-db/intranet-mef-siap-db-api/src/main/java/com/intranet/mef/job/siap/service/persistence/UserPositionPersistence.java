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

import com.intranet.mef.job.siap.exception.NoSuchUserPositionException;
import com.intranet.mef.job.siap.model.UserPosition;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.UserPositionPersistenceImpl
 * @see UserPositionUtil
 * @generated
 */
@ProviderType
public interface UserPositionPersistence extends BasePersistence<UserPosition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPositionUtil} to access the user position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user position in the entity cache if it is enabled.
	*
	* @param userPosition the user position
	*/
	public void cacheResult(UserPosition userPosition);

	/**
	* Caches the user positions in the entity cache if it is enabled.
	*
	* @param userPositions the user positions
	*/
	public void cacheResult(java.util.List<UserPosition> userPositions);

	/**
	* Creates a new user position with the primary key. Does not add the user position to the database.
	*
	* @param pos the primary key for the new user position
	* @return the new user position
	*/
	public UserPosition create(java.lang.String pos);

	/**
	* Removes the user position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pos the primary key of the user position
	* @return the user position that was removed
	* @throws NoSuchUserPositionException if a user position with the primary key could not be found
	*/
	public UserPosition remove(java.lang.String pos)
		throws NoSuchUserPositionException;

	public UserPosition updateImpl(UserPosition userPosition);

	/**
	* Returns the user position with the primary key or throws a {@link NoSuchUserPositionException} if it could not be found.
	*
	* @param pos the primary key of the user position
	* @return the user position
	* @throws NoSuchUserPositionException if a user position with the primary key could not be found
	*/
	public UserPosition findByPrimaryKey(java.lang.String pos)
		throws NoSuchUserPositionException;

	/**
	* Returns the user position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pos the primary key of the user position
	* @return the user position, or <code>null</code> if a user position with the primary key could not be found
	*/
	public UserPosition fetchByPrimaryKey(java.lang.String pos);

	@Override
	public java.util.Map<java.io.Serializable, UserPosition> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user positions.
	*
	* @return the user positions
	*/
	public java.util.List<UserPosition> findAll();

	/**
	* Returns a range of all the user positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user positions
	* @param end the upper bound of the range of user positions (not inclusive)
	* @return the range of user positions
	*/
	public java.util.List<UserPosition> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user positions
	* @param end the upper bound of the range of user positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user positions
	*/
	public java.util.List<UserPosition> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPosition> orderByComparator);

	/**
	* Returns an ordered range of all the user positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user positions
	* @param end the upper bound of the range of user positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user positions
	*/
	public java.util.List<UserPosition> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPosition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user positions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user positions.
	*
	* @return the number of user positions
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}