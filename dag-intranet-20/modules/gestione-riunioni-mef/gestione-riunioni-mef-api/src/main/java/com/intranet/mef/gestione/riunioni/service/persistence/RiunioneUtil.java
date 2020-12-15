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

package com.intranet.mef.gestione.riunioni.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.Riunione;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the riunione service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.RiunionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.RiunionePersistenceImpl
 * @generated
 */
@ProviderType
public class RiunioneUtil {
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
	public static void clearCache(Riunione riunione) {
		getPersistence().clearCache(riunione);
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
	public static List<Riunione> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Riunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Riunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Riunione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Riunione update(Riunione riunione) {
		return getPersistence().update(riunione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Riunione update(Riunione riunione,
		ServiceContext serviceContext) {
		return getPersistence().update(riunione, serviceContext);
	}

	/**
	* Caches the riunione in the entity cache if it is enabled.
	*
	* @param riunione the riunione
	*/
	public static void cacheResult(Riunione riunione) {
		getPersistence().cacheResult(riunione);
	}

	/**
	* Caches the riuniones in the entity cache if it is enabled.
	*
	* @param riuniones the riuniones
	*/
	public static void cacheResult(List<Riunione> riuniones) {
		getPersistence().cacheResult(riuniones);
	}

	/**
	* Creates a new riunione with the primary key. Does not add the riunione to the database.
	*
	* @param id_riunione the primary key for the new riunione
	* @return the new riunione
	*/
	public static Riunione create(long id_riunione) {
		return getPersistence().create(id_riunione);
	}

	/**
	* Removes the riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione that was removed
	* @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	*/
	public static Riunione remove(long id_riunione)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchRiunioneException {
		return getPersistence().remove(id_riunione);
	}

	public static Riunione updateImpl(Riunione riunione) {
		return getPersistence().updateImpl(riunione);
	}

	/**
	* Returns the riunione with the primary key or throws a {@link NoSuchRiunioneException} if it could not be found.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione
	* @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	*/
	public static Riunione findByPrimaryKey(long id_riunione)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchRiunioneException {
		return getPersistence().findByPrimaryKey(id_riunione);
	}

	/**
	* Returns the riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione, or <code>null</code> if a riunione with the primary key could not be found
	*/
	public static Riunione fetchByPrimaryKey(long id_riunione) {
		return getPersistence().fetchByPrimaryKey(id_riunione);
	}

	public static java.util.Map<java.io.Serializable, Riunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the riuniones.
	*
	* @return the riuniones
	*/
	public static List<Riunione> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @return the range of riuniones
	*/
	public static List<Riunione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of riuniones
	*/
	public static List<Riunione> findAll(int start, int end,
		OrderByComparator<Riunione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of riuniones
	*/
	public static List<Riunione> findAll(int start, int end,
		OrderByComparator<Riunione> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the riuniones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of riuniones.
	*
	* @return the number of riuniones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RiunionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RiunionePersistence, RiunionePersistence> _serviceTracker =
		ServiceTrackerFactory.open(RiunionePersistence.class);
}