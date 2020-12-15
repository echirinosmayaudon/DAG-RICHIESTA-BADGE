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

import com.intranet.mef.job.siap.exception.NoSuchOvertimeBalanceException;
import com.intranet.mef.job.siap.model.OvertimeBalance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the overtime balance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.OvertimeBalancePersistenceImpl
 * @see OvertimeBalanceUtil
 * @generated
 */
@ProviderType
public interface OvertimeBalancePersistence extends BasePersistence<OvertimeBalance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OvertimeBalanceUtil} to access the overtime balance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the overtime balance in the entity cache if it is enabled.
	*
	* @param overtimeBalance the overtime balance
	*/
	public void cacheResult(OvertimeBalance overtimeBalance);

	/**
	* Caches the overtime balances in the entity cache if it is enabled.
	*
	* @param overtimeBalances the overtime balances
	*/
	public void cacheResult(java.util.List<OvertimeBalance> overtimeBalances);

	/**
	* Creates a new overtime balance with the primary key. Does not add the overtime balance to the database.
	*
	* @param personId the primary key for the new overtime balance
	* @return the new overtime balance
	*/
	public OvertimeBalance create(long personId);

	/**
	* Removes the overtime balance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance that was removed
	* @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	*/
	public OvertimeBalance remove(long personId)
		throws NoSuchOvertimeBalanceException;

	public OvertimeBalance updateImpl(OvertimeBalance overtimeBalance);

	/**
	* Returns the overtime balance with the primary key or throws a {@link NoSuchOvertimeBalanceException} if it could not be found.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance
	* @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	*/
	public OvertimeBalance findByPrimaryKey(long personId)
		throws NoSuchOvertimeBalanceException;

	/**
	* Returns the overtime balance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance, or <code>null</code> if a overtime balance with the primary key could not be found
	*/
	public OvertimeBalance fetchByPrimaryKey(long personId);

	@Override
	public java.util.Map<java.io.Serializable, OvertimeBalance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the overtime balances.
	*
	* @return the overtime balances
	*/
	public java.util.List<OvertimeBalance> findAll();

	/**
	* Returns a range of all the overtime balances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balances
	* @param end the upper bound of the range of overtime balances (not inclusive)
	* @return the range of overtime balances
	*/
	public java.util.List<OvertimeBalance> findAll(int start, int end);

	/**
	* Returns an ordered range of all the overtime balances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balances
	* @param end the upper bound of the range of overtime balances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of overtime balances
	*/
	public java.util.List<OvertimeBalance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OvertimeBalance> orderByComparator);

	/**
	* Returns an ordered range of all the overtime balances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimeBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime balances
	* @param end the upper bound of the range of overtime balances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of overtime balances
	*/
	public java.util.List<OvertimeBalance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OvertimeBalance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the overtime balances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of overtime balances.
	*
	* @return the number of overtime balances
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}