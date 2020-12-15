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

import com.intranet.mef.job.siap.model.OvertimeBalance;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the overtime balance service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.OvertimeBalancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalancePersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.OvertimeBalancePersistenceImpl
 * @generated
 */
@ProviderType
public class OvertimeBalanceUtil {
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
	public static void clearCache(OvertimeBalance overtimeBalance) {
		getPersistence().clearCache(overtimeBalance);
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
	public static List<OvertimeBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OvertimeBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OvertimeBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OvertimeBalance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OvertimeBalance update(OvertimeBalance overtimeBalance) {
		return getPersistence().update(overtimeBalance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OvertimeBalance update(OvertimeBalance overtimeBalance,
		ServiceContext serviceContext) {
		return getPersistence().update(overtimeBalance, serviceContext);
	}

	/**
	* Caches the overtime balance in the entity cache if it is enabled.
	*
	* @param overtimeBalance the overtime balance
	*/
	public static void cacheResult(OvertimeBalance overtimeBalance) {
		getPersistence().cacheResult(overtimeBalance);
	}

	/**
	* Caches the overtime balances in the entity cache if it is enabled.
	*
	* @param overtimeBalances the overtime balances
	*/
	public static void cacheResult(List<OvertimeBalance> overtimeBalances) {
		getPersistence().cacheResult(overtimeBalances);
	}

	/**
	* Creates a new overtime balance with the primary key. Does not add the overtime balance to the database.
	*
	* @param personId the primary key for the new overtime balance
	* @return the new overtime balance
	*/
	public static OvertimeBalance create(long personId) {
		return getPersistence().create(personId);
	}

	/**
	* Removes the overtime balance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance that was removed
	* @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	*/
	public static OvertimeBalance remove(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchOvertimeBalanceException {
		return getPersistence().remove(personId);
	}

	public static OvertimeBalance updateImpl(OvertimeBalance overtimeBalance) {
		return getPersistence().updateImpl(overtimeBalance);
	}

	/**
	* Returns the overtime balance with the primary key or throws a {@link NoSuchOvertimeBalanceException} if it could not be found.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance
	* @throws NoSuchOvertimeBalanceException if a overtime balance with the primary key could not be found
	*/
	public static OvertimeBalance findByPrimaryKey(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchOvertimeBalanceException {
		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	* Returns the overtime balance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the overtime balance
	* @return the overtime balance, or <code>null</code> if a overtime balance with the primary key could not be found
	*/
	public static OvertimeBalance fetchByPrimaryKey(long personId) {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	public static java.util.Map<java.io.Serializable, OvertimeBalance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the overtime balances.
	*
	* @return the overtime balances
	*/
	public static List<OvertimeBalance> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<OvertimeBalance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<OvertimeBalance> findAll(int start, int end,
		OrderByComparator<OvertimeBalance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<OvertimeBalance> findAll(int start, int end,
		OrderByComparator<OvertimeBalance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the overtime balances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of overtime balances.
	*
	* @return the number of overtime balances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static OvertimeBalancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OvertimeBalancePersistence, OvertimeBalancePersistence> _serviceTracker =
		ServiceTrackerFactory.open(OvertimeBalancePersistence.class);
}