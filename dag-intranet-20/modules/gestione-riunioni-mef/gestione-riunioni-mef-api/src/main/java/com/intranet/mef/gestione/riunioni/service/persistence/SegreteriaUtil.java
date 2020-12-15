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

import com.intranet.mef.gestione.riunioni.model.Segreteria;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the segreteria service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.SegreteriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegreteriaPersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.SegreteriaPersistenceImpl
 * @generated
 */
@ProviderType
public class SegreteriaUtil {
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
	public static void clearCache(Segreteria segreteria) {
		getPersistence().clearCache(segreteria);
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
	public static List<Segreteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Segreteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Segreteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Segreteria> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Segreteria update(Segreteria segreteria) {
		return getPersistence().update(segreteria);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Segreteria update(Segreteria segreteria,
		ServiceContext serviceContext) {
		return getPersistence().update(segreteria, serviceContext);
	}

	/**
	* Caches the segreteria in the entity cache if it is enabled.
	*
	* @param segreteria the segreteria
	*/
	public static void cacheResult(Segreteria segreteria) {
		getPersistence().cacheResult(segreteria);
	}

	/**
	* Caches the segreterias in the entity cache if it is enabled.
	*
	* @param segreterias the segreterias
	*/
	public static void cacheResult(List<Segreteria> segreterias) {
		getPersistence().cacheResult(segreterias);
	}

	/**
	* Creates a new segreteria with the primary key. Does not add the segreteria to the database.
	*
	* @param id_segreteria the primary key for the new segreteria
	* @return the new segreteria
	*/
	public static Segreteria create(long id_segreteria) {
		return getPersistence().create(id_segreteria);
	}

	/**
	* Removes the segreteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria that was removed
	* @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	*/
	public static Segreteria remove(long id_segreteria)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchSegreteriaException {
		return getPersistence().remove(id_segreteria);
	}

	public static Segreteria updateImpl(Segreteria segreteria) {
		return getPersistence().updateImpl(segreteria);
	}

	/**
	* Returns the segreteria with the primary key or throws a {@link NoSuchSegreteriaException} if it could not be found.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria
	* @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	*/
	public static Segreteria findByPrimaryKey(long id_segreteria)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchSegreteriaException {
		return getPersistence().findByPrimaryKey(id_segreteria);
	}

	/**
	* Returns the segreteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria, or <code>null</code> if a segreteria with the primary key could not be found
	*/
	public static Segreteria fetchByPrimaryKey(long id_segreteria) {
		return getPersistence().fetchByPrimaryKey(id_segreteria);
	}

	public static java.util.Map<java.io.Serializable, Segreteria> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the segreterias.
	*
	* @return the segreterias
	*/
	public static List<Segreteria> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the segreterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segreterias
	* @param end the upper bound of the range of segreterias (not inclusive)
	* @return the range of segreterias
	*/
	public static List<Segreteria> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the segreterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segreterias
	* @param end the upper bound of the range of segreterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of segreterias
	*/
	public static List<Segreteria> findAll(int start, int end,
		OrderByComparator<Segreteria> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the segreterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segreterias
	* @param end the upper bound of the range of segreterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of segreterias
	*/
	public static List<Segreteria> findAll(int start, int end,
		OrderByComparator<Segreteria> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the segreterias from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of segreterias.
	*
	* @return the number of segreterias
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SegreteriaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SegreteriaPersistence, SegreteriaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SegreteriaPersistence.class);
}