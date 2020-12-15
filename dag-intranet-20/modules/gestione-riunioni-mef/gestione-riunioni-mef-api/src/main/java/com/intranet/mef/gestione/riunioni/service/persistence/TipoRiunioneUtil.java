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

import com.intranet.mef.gestione.riunioni.model.TipoRiunione;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tipo riunione service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.TipoRiunionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.TipoRiunionePersistenceImpl
 * @generated
 */
@ProviderType
public class TipoRiunioneUtil {
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
	public static void clearCache(TipoRiunione tipoRiunione) {
		getPersistence().clearCache(tipoRiunione);
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
	public static List<TipoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipoRiunione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipoRiunione update(TipoRiunione tipoRiunione) {
		return getPersistence().update(tipoRiunione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipoRiunione update(TipoRiunione tipoRiunione,
		ServiceContext serviceContext) {
		return getPersistence().update(tipoRiunione, serviceContext);
	}

	/**
	* Caches the tipo riunione in the entity cache if it is enabled.
	*
	* @param tipoRiunione the tipo riunione
	*/
	public static void cacheResult(TipoRiunione tipoRiunione) {
		getPersistence().cacheResult(tipoRiunione);
	}

	/**
	* Caches the tipo riuniones in the entity cache if it is enabled.
	*
	* @param tipoRiuniones the tipo riuniones
	*/
	public static void cacheResult(List<TipoRiunione> tipoRiuniones) {
		getPersistence().cacheResult(tipoRiuniones);
	}

	/**
	* Creates a new tipo riunione with the primary key. Does not add the tipo riunione to the database.
	*
	* @param id_tipo the primary key for the new tipo riunione
	* @return the new tipo riunione
	*/
	public static TipoRiunione create(long id_tipo) {
		return getPersistence().create(id_tipo);
	}

	/**
	* Removes the tipo riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione that was removed
	* @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	*/
	public static TipoRiunione remove(long id_tipo)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchTipoRiunioneException {
		return getPersistence().remove(id_tipo);
	}

	public static TipoRiunione updateImpl(TipoRiunione tipoRiunione) {
		return getPersistence().updateImpl(tipoRiunione);
	}

	/**
	* Returns the tipo riunione with the primary key or throws a {@link NoSuchTipoRiunioneException} if it could not be found.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione
	* @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	*/
	public static TipoRiunione findByPrimaryKey(long id_tipo)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchTipoRiunioneException {
		return getPersistence().findByPrimaryKey(id_tipo);
	}

	/**
	* Returns the tipo riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione, or <code>null</code> if a tipo riunione with the primary key could not be found
	*/
	public static TipoRiunione fetchByPrimaryKey(long id_tipo) {
		return getPersistence().fetchByPrimaryKey(id_tipo);
	}

	public static java.util.Map<java.io.Serializable, TipoRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tipo riuniones.
	*
	* @return the tipo riuniones
	*/
	public static List<TipoRiunione> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tipo riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo riuniones
	* @param end the upper bound of the range of tipo riuniones (not inclusive)
	* @return the range of tipo riuniones
	*/
	public static List<TipoRiunione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipo riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo riuniones
	* @param end the upper bound of the range of tipo riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo riuniones
	*/
	public static List<TipoRiunione> findAll(int start, int end,
		OrderByComparator<TipoRiunione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tipo riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo riuniones
	* @param end the upper bound of the range of tipo riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipo riuniones
	*/
	public static List<TipoRiunione> findAll(int start, int end,
		OrderByComparator<TipoRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tipo riuniones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipo riuniones.
	*
	* @return the number of tipo riuniones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipoRiunionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipoRiunionePersistence, TipoRiunionePersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipoRiunionePersistence.class);
}