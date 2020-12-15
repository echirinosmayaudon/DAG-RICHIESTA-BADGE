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

import com.intranet.mef.job.siap.exception.NoSuchOvertimeBalacePrevMonthException;
import com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the overtime balace prev month service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.OvertimeBalacePrevMonthPersistenceImpl
 * @see OvertimeBalacePrevMonthUtil
 * @generated
 */
@ProviderType
public interface OvertimeBalacePrevMonthPersistence extends BasePersistence<OvertimeBalacePrevMonth> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OvertimeBalacePrevMonthUtil} to access the overtime balace prev month persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the overtime balace prev month in the entity cache if it is enabled.
	*
	* @param overtimeBalacePrevMonth the overtime balace prev month
	*/
	public void cacheResult(OvertimeBalacePrevMonth overtimeBalacePrevMonth);

	/**
	* Caches the overtime balace prev months in the entity cache if it is enabled.
	*
	* @param overtimeBalacePrevMonths the overtime balace prev months
	*/
	public void cacheResult(
		java.util.List<OvertimeBalacePrevMonth> overtimeBalacePrevMonths);

	/**
	* Creates a new overtime balace prev month with the primary key. Does not add the overtime balace prev month to the database.
	*
	* @param personId the primary key for the new overtime balace prev month
	* @return the new overtime balace prev month
	*/
	public OvertimeBalacePrevMonth create(long personId);

	/**
	* Removes the overtime balace prev month with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month that was removed
	* @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	*/
	public OvertimeBalacePrevMonth remove(long personId)
		throws NoSuchOvertimeBalacePrevMonthException;

	public OvertimeBalacePrevMonth updateImpl(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth);

	/**
	* Returns the overtime balace prev month with the primary key or throws a {@link NoSuchOvertimeBalacePrevMonthException} if it could not be found.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month
	* @throws NoSuchOvertimeBalacePrevMonthException if a overtime balace prev month with the primary key could not be found
	*/
	public OvertimeBalacePrevMonth findByPrimaryKey(long personId)
		throws NoSuchOvertimeBalacePrevMonthException;

	/**
	* Returns the overtime balace prev month with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the overtime balace prev month
	* @return the overtime balace prev month, or <code>null</code> if a overtime balace prev month with the primary key could not be found
	*/
	public OvertimeBalacePrevMonth fetchByPrimaryKey(long personId);

	@Override
	public java.util.Map<java.io.Serializable, OvertimeBalacePrevMonth> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the overtime balace prev months.
	*
	* @return the overtime balace prev months
	*/
	public java.util.List<OvertimeBalacePrevMonth> findAll();

	/**
	* Returns a range of all the overtime balace prev months.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balace prev months
	* @param end the upper bound of the range of overtime balace prev months (not inclusive)
	* @return the range of overtime balace prev months
	*/
	public java.util.List<OvertimeBalacePrevMonth> findAll(int start, int end);

	/**
	* Returns an ordered range of all the overtime balace prev months.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balace prev months
	* @param end the upper bound of the range of overtime balace prev months (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of overtime balace prev months
	*/
	public java.util.List<OvertimeBalacePrevMonth> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OvertimeBalacePrevMonth> orderByComparator);

	/**
	* Returns an ordered range of all the overtime balace prev months.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalacePrevMonthModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balace prev months
	* @param end the upper bound of the range of overtime balace prev months (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of overtime balace prev months
	*/
	public java.util.List<OvertimeBalacePrevMonth> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OvertimeBalacePrevMonth> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the overtime balace prev months from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of overtime balace prev months.
	*
	* @return the number of overtime balace prev months
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}