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

import com.intranet.mef.job.siap.model.Vacation;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the vacation service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.VacationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VacationPersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.VacationPersistenceImpl
 * @generated
 */
@ProviderType
public class VacationUtil {
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
	public static void clearCache(Vacation vacation) {
		getPersistence().clearCache(vacation);
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
	public static List<Vacation> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vacation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vacation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Vacation> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Vacation update(Vacation vacation) {
		return getPersistence().update(vacation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Vacation update(Vacation vacation,
		ServiceContext serviceContext) {
		return getPersistence().update(vacation, serviceContext);
	}

	/**
	* Caches the vacation in the entity cache if it is enabled.
	*
	* @param vacation the vacation
	*/
	public static void cacheResult(Vacation vacation) {
		getPersistence().cacheResult(vacation);
	}

	/**
	* Caches the vacations in the entity cache if it is enabled.
	*
	* @param vacations the vacations
	*/
	public static void cacheResult(List<Vacation> vacations) {
		getPersistence().cacheResult(vacations);
	}

	/**
	* Creates a new vacation with the primary key. Does not add the vacation to the database.
	*
	* @param personId the primary key for the new vacation
	* @return the new vacation
	*/
	public static Vacation create(long personId) {
		return getPersistence().create(personId);
	}

	/**
	* Removes the vacation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the vacation
	* @return the vacation that was removed
	* @throws NoSuchVacationException if a vacation with the primary key could not be found
	*/
	public static Vacation remove(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchVacationException {
		return getPersistence().remove(personId);
	}

	public static Vacation updateImpl(Vacation vacation) {
		return getPersistence().updateImpl(vacation);
	}

	/**
	* Returns the vacation with the primary key or throws a {@link NoSuchVacationException} if it could not be found.
	*
	* @param personId the primary key of the vacation
	* @return the vacation
	* @throws NoSuchVacationException if a vacation with the primary key could not be found
	*/
	public static Vacation findByPrimaryKey(long personId)
		throws com.intranet.mef.job.siap.exception.NoSuchVacationException {
		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	* Returns the vacation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the vacation
	* @return the vacation, or <code>null</code> if a vacation with the primary key could not be found
	*/
	public static Vacation fetchByPrimaryKey(long personId) {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	public static java.util.Map<java.io.Serializable, Vacation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the vacations.
	*
	* @return the vacations
	*/
	public static List<Vacation> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Vacation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Vacation> findAll(int start, int end,
		OrderByComparator<Vacation> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Vacation> findAll(int start, int end,
		OrderByComparator<Vacation> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the vacations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vacations.
	*
	* @return the number of vacations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static VacationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VacationPersistence, VacationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(VacationPersistence.class);
}