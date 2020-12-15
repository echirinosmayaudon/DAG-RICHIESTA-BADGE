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

import com.intranet.mef.gestione.riunioni.model.StatoRiunione;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the stato riunione service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.StatoRiunionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.StatoRiunionePersistenceImpl
 * @generated
 */
@ProviderType
public class StatoRiunioneUtil {
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
	public static void clearCache(StatoRiunione statoRiunione) {
		getPersistence().clearCache(statoRiunione);
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
	public static List<StatoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatoRiunione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatoRiunione update(StatoRiunione statoRiunione) {
		return getPersistence().update(statoRiunione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatoRiunione update(StatoRiunione statoRiunione,
		ServiceContext serviceContext) {
		return getPersistence().update(statoRiunione, serviceContext);
	}

	/**
	* Returns all the stato riuniones where label = &#63;.
	*
	* @param label the label
	* @return the matching stato riuniones
	*/
	public static List<StatoRiunione> findByStatoRiunione(
		java.lang.String label) {
		return getPersistence().findByStatoRiunione(label);
	}

	/**
	* Returns a range of all the stato riuniones where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @return the range of matching stato riuniones
	*/
	public static List<StatoRiunione> findByStatoRiunione(
		java.lang.String label, int start, int end) {
		return getPersistence().findByStatoRiunione(label, start, end);
	}

	/**
	* Returns an ordered range of all the stato riuniones where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stato riuniones
	*/
	public static List<StatoRiunione> findByStatoRiunione(
		java.lang.String label, int start, int end,
		OrderByComparator<StatoRiunione> orderByComparator) {
		return getPersistence()
				   .findByStatoRiunione(label, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato riuniones where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stato riuniones
	*/
	public static List<StatoRiunione> findByStatoRiunione(
		java.lang.String label, int start, int end,
		OrderByComparator<StatoRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatoRiunione(label, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato riunione
	* @throws NoSuchStatoRiunioneException if a matching stato riunione could not be found
	*/
	public static StatoRiunione findByStatoRiunione_First(
		java.lang.String label,
		OrderByComparator<StatoRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStatoRiunioneException {
		return getPersistence()
				   .findByStatoRiunione_First(label, orderByComparator);
	}

	/**
	* Returns the first stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato riunione, or <code>null</code> if a matching stato riunione could not be found
	*/
	public static StatoRiunione fetchByStatoRiunione_First(
		java.lang.String label,
		OrderByComparator<StatoRiunione> orderByComparator) {
		return getPersistence()
				   .fetchByStatoRiunione_First(label, orderByComparator);
	}

	/**
	* Returns the last stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato riunione
	* @throws NoSuchStatoRiunioneException if a matching stato riunione could not be found
	*/
	public static StatoRiunione findByStatoRiunione_Last(
		java.lang.String label,
		OrderByComparator<StatoRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStatoRiunioneException {
		return getPersistence()
				   .findByStatoRiunione_Last(label, orderByComparator);
	}

	/**
	* Returns the last stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato riunione, or <code>null</code> if a matching stato riunione could not be found
	*/
	public static StatoRiunione fetchByStatoRiunione_Last(
		java.lang.String label,
		OrderByComparator<StatoRiunione> orderByComparator) {
		return getPersistence()
				   .fetchByStatoRiunione_Last(label, orderByComparator);
	}

	/**
	* Returns the stato riuniones before and after the current stato riunione in the ordered set where label = &#63;.
	*
	* @param id_stato_riunione the primary key of the current stato riunione
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stato riunione
	* @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	*/
	public static StatoRiunione[] findByStatoRiunione_PrevAndNext(
		long id_stato_riunione, java.lang.String label,
		OrderByComparator<StatoRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStatoRiunioneException {
		return getPersistence()
				   .findByStatoRiunione_PrevAndNext(id_stato_riunione, label,
			orderByComparator);
	}

	/**
	* Removes all the stato riuniones where label = &#63; from the database.
	*
	* @param label the label
	*/
	public static void removeByStatoRiunione(java.lang.String label) {
		getPersistence().removeByStatoRiunione(label);
	}

	/**
	* Returns the number of stato riuniones where label = &#63;.
	*
	* @param label the label
	* @return the number of matching stato riuniones
	*/
	public static int countByStatoRiunione(java.lang.String label) {
		return getPersistence().countByStatoRiunione(label);
	}

	/**
	* Caches the stato riunione in the entity cache if it is enabled.
	*
	* @param statoRiunione the stato riunione
	*/
	public static void cacheResult(StatoRiunione statoRiunione) {
		getPersistence().cacheResult(statoRiunione);
	}

	/**
	* Caches the stato riuniones in the entity cache if it is enabled.
	*
	* @param statoRiuniones the stato riuniones
	*/
	public static void cacheResult(List<StatoRiunione> statoRiuniones) {
		getPersistence().cacheResult(statoRiuniones);
	}

	/**
	* Creates a new stato riunione with the primary key. Does not add the stato riunione to the database.
	*
	* @param id_stato_riunione the primary key for the new stato riunione
	* @return the new stato riunione
	*/
	public static StatoRiunione create(long id_stato_riunione) {
		return getPersistence().create(id_stato_riunione);
	}

	/**
	* Removes the stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_riunione the primary key of the stato riunione
	* @return the stato riunione that was removed
	* @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	*/
	public static StatoRiunione remove(long id_stato_riunione)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStatoRiunioneException {
		return getPersistence().remove(id_stato_riunione);
	}

	public static StatoRiunione updateImpl(StatoRiunione statoRiunione) {
		return getPersistence().updateImpl(statoRiunione);
	}

	/**
	* Returns the stato riunione with the primary key or throws a {@link NoSuchStatoRiunioneException} if it could not be found.
	*
	* @param id_stato_riunione the primary key of the stato riunione
	* @return the stato riunione
	* @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	*/
	public static StatoRiunione findByPrimaryKey(long id_stato_riunione)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStatoRiunioneException {
		return getPersistence().findByPrimaryKey(id_stato_riunione);
	}

	/**
	* Returns the stato riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_stato_riunione the primary key of the stato riunione
	* @return the stato riunione, or <code>null</code> if a stato riunione with the primary key could not be found
	*/
	public static StatoRiunione fetchByPrimaryKey(long id_stato_riunione) {
		return getPersistence().fetchByPrimaryKey(id_stato_riunione);
	}

	public static java.util.Map<java.io.Serializable, StatoRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the stato riuniones.
	*
	* @return the stato riuniones
	*/
	public static List<StatoRiunione> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @return the range of stato riuniones
	*/
	public static List<StatoRiunione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato riuniones
	*/
	public static List<StatoRiunione> findAll(int start, int end,
		OrderByComparator<StatoRiunione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato riuniones
	*/
	public static List<StatoRiunione> findAll(int start, int end,
		OrderByComparator<StatoRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the stato riuniones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stato riuniones.
	*
	* @return the number of stato riuniones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatoRiunionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatoRiunionePersistence, StatoRiunionePersistence> _serviceTracker =
		ServiceTrackerFactory.open(StatoRiunionePersistence.class);
}