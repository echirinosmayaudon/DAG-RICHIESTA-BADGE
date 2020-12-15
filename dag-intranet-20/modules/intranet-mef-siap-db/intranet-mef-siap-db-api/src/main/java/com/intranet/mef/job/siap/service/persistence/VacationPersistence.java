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

import com.intranet.mef.job.siap.exception.NoSuchVacationException;
import com.intranet.mef.job.siap.model.Vacation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the vacation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.VacationPersistenceImpl
 * @see VacationUtil
 * @generated
 */
@ProviderType
public interface VacationPersistence extends BasePersistence<Vacation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VacationUtil} to access the vacation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vacation in the entity cache if it is enabled.
	*
	* @param vacation the vacation
	*/
	public void cacheResult(Vacation vacation);

	/**
	* Caches the vacations in the entity cache if it is enabled.
	*
	* @param vacations the vacations
	*/
	public void cacheResult(java.util.List<Vacation> vacations);

	/**
	* Creates a new vacation with the primary key. Does not add the vacation to the database.
	*
	* @param personId the primary key for the new vacation
	* @return the new vacation
	*/
	public Vacation create(long personId);

	/**
	* Removes the vacation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the vacation
	* @return the vacation that was removed
	* @throws NoSuchVacationException if a vacation with the primary key could not be found
	*/
	public Vacation remove(long personId) throws NoSuchVacationException;

	public Vacation updateImpl(Vacation vacation);

	/**
	* Returns the vacation with the primary key or throws a {@link NoSuchVacationException} if it could not be found.
	*
	* @param personId the primary key of the vacation
	* @return the vacation
	* @throws NoSuchVacationException if a vacation with the primary key could not be found
	*/
	public Vacation findByPrimaryKey(long personId)
		throws NoSuchVacationException;

	/**
	* Returns the vacation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the vacation
	* @return the vacation, or <code>null</code> if a vacation with the primary key could not be found
	*/
	public Vacation fetchByPrimaryKey(long personId);

	@Override
	public java.util.Map<java.io.Serializable, Vacation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the vacations.
	*
	* @return the vacations
	*/
	public java.util.List<Vacation> findAll();

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
	public java.util.List<Vacation> findAll(int start, int end);

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
	public java.util.List<Vacation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vacation> orderByComparator);

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
	public java.util.List<Vacation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vacation> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the vacations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of vacations.
	*
	* @return the number of vacations
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}