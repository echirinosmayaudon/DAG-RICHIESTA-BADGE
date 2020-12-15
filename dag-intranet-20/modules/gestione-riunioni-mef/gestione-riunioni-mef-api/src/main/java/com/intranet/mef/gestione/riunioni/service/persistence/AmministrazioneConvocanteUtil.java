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

import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the amministrazione convocante service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.AmministrazioneConvocantePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmministrazioneConvocantePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.AmministrazioneConvocantePersistenceImpl
 * @generated
 */
@ProviderType
public class AmministrazioneConvocanteUtil {
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
		AmministrazioneConvocante amministrazioneConvocante) {
		getPersistence().clearCache(amministrazioneConvocante);
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
	public static List<AmministrazioneConvocante> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AmministrazioneConvocante> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AmministrazioneConvocante> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AmministrazioneConvocante> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AmministrazioneConvocante update(
		AmministrazioneConvocante amministrazioneConvocante) {
		return getPersistence().update(amministrazioneConvocante);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AmministrazioneConvocante update(
		AmministrazioneConvocante amministrazioneConvocante,
		ServiceContext serviceContext) {
		return getPersistence().update(amministrazioneConvocante, serviceContext);
	}

	/**
	* Caches the amministrazione convocante in the entity cache if it is enabled.
	*
	* @param amministrazioneConvocante the amministrazione convocante
	*/
	public static void cacheResult(
		AmministrazioneConvocante amministrazioneConvocante) {
		getPersistence().cacheResult(amministrazioneConvocante);
	}

	/**
	* Caches the amministrazione convocantes in the entity cache if it is enabled.
	*
	* @param amministrazioneConvocantes the amministrazione convocantes
	*/
	public static void cacheResult(
		List<AmministrazioneConvocante> amministrazioneConvocantes) {
		getPersistence().cacheResult(amministrazioneConvocantes);
	}

	/**
	* Creates a new amministrazione convocante with the primary key. Does not add the amministrazione convocante to the database.
	*
	* @param id_amministrazione_convocante the primary key for the new amministrazione convocante
	* @return the new amministrazione convocante
	*/
	public static AmministrazioneConvocante create(
		long id_amministrazione_convocante) {
		return getPersistence().create(id_amministrazione_convocante);
	}

	/**
	* Removes the amministrazione convocante with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante that was removed
	* @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	*/
	public static AmministrazioneConvocante remove(
		long id_amministrazione_convocante)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchAmministrazioneConvocanteException {
		return getPersistence().remove(id_amministrazione_convocante);
	}

	public static AmministrazioneConvocante updateImpl(
		AmministrazioneConvocante amministrazioneConvocante) {
		return getPersistence().updateImpl(amministrazioneConvocante);
	}

	/**
	* Returns the amministrazione convocante with the primary key or throws a {@link NoSuchAmministrazioneConvocanteException} if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante
	* @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	*/
	public static AmministrazioneConvocante findByPrimaryKey(
		long id_amministrazione_convocante)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchAmministrazioneConvocanteException {
		return getPersistence().findByPrimaryKey(id_amministrazione_convocante);
	}

	/**
	* Returns the amministrazione convocante with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante, or <code>null</code> if a amministrazione convocante with the primary key could not be found
	*/
	public static AmministrazioneConvocante fetchByPrimaryKey(
		long id_amministrazione_convocante) {
		return getPersistence().fetchByPrimaryKey(id_amministrazione_convocante);
	}

	public static java.util.Map<java.io.Serializable, AmministrazioneConvocante> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the amministrazione convocantes.
	*
	* @return the amministrazione convocantes
	*/
	public static List<AmministrazioneConvocante> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the amministrazione convocantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amministrazione convocantes
	* @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	* @return the range of amministrazione convocantes
	*/
	public static List<AmministrazioneConvocante> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the amministrazione convocantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amministrazione convocantes
	* @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of amministrazione convocantes
	*/
	public static List<AmministrazioneConvocante> findAll(int start, int end,
		OrderByComparator<AmministrazioneConvocante> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amministrazione convocantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amministrazione convocantes
	* @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of amministrazione convocantes
	*/
	public static List<AmministrazioneConvocante> findAll(int start, int end,
		OrderByComparator<AmministrazioneConvocante> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the amministrazione convocantes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of amministrazione convocantes.
	*
	* @return the number of amministrazione convocantes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmministrazioneConvocantePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmministrazioneConvocantePersistence, AmministrazioneConvocantePersistence> _serviceTracker =
		ServiceTrackerFactory.open(AmministrazioneConvocantePersistence.class);
}