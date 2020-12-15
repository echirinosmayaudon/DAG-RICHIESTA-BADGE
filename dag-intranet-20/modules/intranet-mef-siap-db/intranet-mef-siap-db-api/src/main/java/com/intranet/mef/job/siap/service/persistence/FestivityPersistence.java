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

import com.intranet.mef.job.siap.exception.NoSuchFestivityException;
import com.intranet.mef.job.siap.model.Festivity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the festivity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.FestivityPersistenceImpl
 * @see FestivityUtil
 * @generated
 */
@ProviderType
public interface FestivityPersistence extends BasePersistence<Festivity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FestivityUtil} to access the festivity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the festivity in the entity cache if it is enabled.
	*
	* @param festivity the festivity
	*/
	public void cacheResult(Festivity festivity);

	/**
	* Caches the festivities in the entity cache if it is enabled.
	*
	* @param festivities the festivities
	*/
	public void cacheResult(java.util.List<Festivity> festivities);

	/**
	* Creates a new festivity with the primary key. Does not add the festivity to the database.
	*
	* @param personId the primary key for the new festivity
	* @return the new festivity
	*/
	public Festivity create(long personId);

	/**
	* Removes the festivity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the festivity
	* @return the festivity that was removed
	* @throws NoSuchFestivityException if a festivity with the primary key could not be found
	*/
	public Festivity remove(long personId) throws NoSuchFestivityException;

	public Festivity updateImpl(Festivity festivity);

	/**
	* Returns the festivity with the primary key or throws a {@link NoSuchFestivityException} if it could not be found.
	*
	* @param personId the primary key of the festivity
	* @return the festivity
	* @throws NoSuchFestivityException if a festivity with the primary key could not be found
	*/
	public Festivity findByPrimaryKey(long personId)
		throws NoSuchFestivityException;

	/**
	* Returns the festivity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the festivity
	* @return the festivity, or <code>null</code> if a festivity with the primary key could not be found
	*/
	public Festivity fetchByPrimaryKey(long personId);

	@Override
	public java.util.Map<java.io.Serializable, Festivity> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the festivities.
	*
	* @return the festivities
	*/
	public java.util.List<Festivity> findAll();

	/**
	* Returns a range of all the festivities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of festivities
	* @param end the upper bound of the range of festivities (not inclusive)
	* @return the range of festivities
	*/
	public java.util.List<Festivity> findAll(int start, int end);

	/**
	* Returns an ordered range of all the festivities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of festivities
	* @param end the upper bound of the range of festivities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of festivities
	*/
	public java.util.List<Festivity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Festivity> orderByComparator);

	/**
	* Returns an ordered range of all the festivities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of festivities
	* @param end the upper bound of the range of festivities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of festivities
	*/
	public java.util.List<Festivity> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Festivity> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the festivities from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of festivities.
	*
	* @return the number of festivities
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}