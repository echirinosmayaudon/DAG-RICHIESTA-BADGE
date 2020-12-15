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

import com.intranet.mef.job.siap.model.OvertimePrevMonthPayOff;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the overtime prev month pay off service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.OvertimePrevMonthPayOffPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimePrevMonthPayOffPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.OvertimePrevMonthPayOffPersistenceImpl
 * @generated
 */
@ProviderType
public class OvertimePrevMonthPayOffUtil {
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
	public static void clearCache(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		getPersistence().clearCache(overtimePrevMonthPayOff);
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
	public static List<OvertimePrevMonthPayOff> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OvertimePrevMonthPayOff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OvertimePrevMonthPayOff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OvertimePrevMonthPayOff> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OvertimePrevMonthPayOff update(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		return getPersistence().update(overtimePrevMonthPayOff);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OvertimePrevMonthPayOff update(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff,
		ServiceContext serviceContext) {
		return getPersistence().update(overtimePrevMonthPayOff, serviceContext);
	}

	/**
	* Caches the overtime prev month pay off in the entity cache if it is enabled.
	*
	* @param overtimePrevMonthPayOff the overtime prev month pay off
	*/
	public static void cacheResult(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		getPersistence().cacheResult(overtimePrevMonthPayOff);
	}

	/**
	* Caches the overtime prev month pay offs in the entity cache if it is enabled.
	*
	* @param overtimePrevMonthPayOffs the overtime prev month pay offs
	*/
	public static void cacheResult(
		List<OvertimePrevMonthPayOff> overtimePrevMonthPayOffs) {
		getPersistence().cacheResult(overtimePrevMonthPayOffs);
	}

	/**
	* Creates a new overtime prev month pay off with the primary key. Does not add the overtime prev month pay off to the database.
	*
	* @param personId the primary key for the new overtime prev month pay off
	* @return the new overtime prev month pay off
	*/
	public static OvertimePrevMonthPayOff create(long personId) {
		return getPersistence().create(personId);
	}

	/**
	* Removes the overtime prev month pay off with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the overtime prev month pay off
	* @return the overtime prev month pay off that was removed
	* @throws NoSuchOvertimePrevMonthPayOffException if a overtime prev month pay off with the primary key could not be found
	*/
	public static OvertimePrevMonthPayOff remove(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchOvertimePrevMonthPayOffException {
		return getPersistence().remove(personId);
	}

	public static OvertimePrevMonthPayOff updateImpl(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		return getPersistence().updateImpl(overtimePrevMonthPayOff);
	}

	/**
	* Returns the overtime prev month pay off with the primary key or throws a {@link NoSuchOvertimePrevMonthPayOffException} if it could not be found.
	*
	* @param personId the primary key of the overtime prev month pay off
	* @return the overtime prev month pay off
	* @throws NoSuchOvertimePrevMonthPayOffException if a overtime prev month pay off with the primary key could not be found
	*/
	public static OvertimePrevMonthPayOff findByPrimaryKey(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchOvertimePrevMonthPayOffException {
		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	* Returns the overtime prev month pay off with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the overtime prev month pay off
	* @return the overtime prev month pay off, or <code>null</code> if a overtime prev month pay off with the primary key could not be found
	*/
	public static OvertimePrevMonthPayOff fetchByPrimaryKey(long personId) {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	public static java.util.Map<java.io.Serializable, OvertimePrevMonthPayOff> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the overtime prev month pay offs.
	*
	* @return the overtime prev month pay offs
	*/
	public static List<OvertimePrevMonthPayOff> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the overtime prev month pay offs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime prev month pay offs
	* @param end the upper bound of the range of overtime prev month pay offs (not inclusive)
	* @return the range of overtime prev month pay offs
	*/
	public static List<OvertimePrevMonthPayOff> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the overtime prev month pay offs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime prev month pay offs
	* @param end the upper bound of the range of overtime prev month pay offs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of overtime prev month pay offs
	*/
	public static List<OvertimePrevMonthPayOff> findAll(int start, int end,
		OrderByComparator<OvertimePrevMonthPayOff> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the overtime prev month pay offs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OvertimePrevMonthPayOffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of overtime prev month pay offs
	* @param end the upper bound of the range of overtime prev month pay offs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of overtime prev month pay offs
	*/
	public static List<OvertimePrevMonthPayOff> findAll(int start, int end,
		OrderByComparator<OvertimePrevMonthPayOff> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the overtime prev month pay offs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of overtime prev month pay offs.
	*
	* @return the number of overtime prev month pay offs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static OvertimePrevMonthPayOffPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OvertimePrevMonthPayOffPersistence, OvertimePrevMonthPayOffPersistence> _serviceTracker =
		ServiceTrackerFactory.open(OvertimePrevMonthPayOffPersistence.class);
}