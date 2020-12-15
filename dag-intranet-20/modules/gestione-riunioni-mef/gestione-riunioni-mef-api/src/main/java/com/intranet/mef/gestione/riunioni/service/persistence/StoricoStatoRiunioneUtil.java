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

import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the storico stato riunione service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.StoricoStatoRiunionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.StoricoStatoRiunionePersistenceImpl
 * @generated
 */
@ProviderType
public class StoricoStatoRiunioneUtil {
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
	public static void clearCache(StoricoStatoRiunione storicoStatoRiunione) {
		getPersistence().clearCache(storicoStatoRiunione);
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
	public static List<StoricoStatoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StoricoStatoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StoricoStatoRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StoricoStatoRiunione update(
		StoricoStatoRiunione storicoStatoRiunione) {
		return getPersistence().update(storicoStatoRiunione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StoricoStatoRiunione update(
		StoricoStatoRiunione storicoStatoRiunione, ServiceContext serviceContext) {
		return getPersistence().update(storicoStatoRiunione, serviceContext);
	}

	/**
	* Returns all the storico stato riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the matching storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione) {
		return getPersistence().findByStoricoRiunione(id_riunione);
	}

	/**
	* Returns a range of all the storico stato riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @return the range of matching storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione, int start, int end) {
		return getPersistence().findByStoricoRiunione(id_riunione, start, end);
	}

	/**
	* Returns an ordered range of all the storico stato riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione, int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		return getPersistence()
				   .findByStoricoRiunione(id_riunione, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the storico stato riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione, int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStoricoRiunione(id_riunione, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a matching storico stato riunione could not be found
	*/
	public static StoricoStatoRiunione findByStoricoRiunione_First(
		long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStoricoStatoRiunioneException {
		return getPersistence()
				   .findByStoricoRiunione_First(id_riunione, orderByComparator);
	}

	/**
	* Returns the first storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching storico stato riunione, or <code>null</code> if a matching storico stato riunione could not be found
	*/
	public static StoricoStatoRiunione fetchByStoricoRiunione_First(
		long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		return getPersistence()
				   .fetchByStoricoRiunione_First(id_riunione, orderByComparator);
	}

	/**
	* Returns the last storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a matching storico stato riunione could not be found
	*/
	public static StoricoStatoRiunione findByStoricoRiunione_Last(
		long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStoricoStatoRiunioneException {
		return getPersistence()
				   .findByStoricoRiunione_Last(id_riunione, orderByComparator);
	}

	/**
	* Returns the last storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching storico stato riunione, or <code>null</code> if a matching storico stato riunione could not be found
	*/
	public static StoricoStatoRiunione fetchByStoricoRiunione_Last(
		long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		return getPersistence()
				   .fetchByStoricoRiunione_Last(id_riunione, orderByComparator);
	}

	/**
	* Returns the storico stato riuniones before and after the current storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param storicoStatoRiunionePK the primary key of the current storico stato riunione
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	*/
	public static StoricoStatoRiunione[] findByStoricoRiunione_PrevAndNext(
		StoricoStatoRiunionePK storicoStatoRiunionePK, long id_riunione,
		OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStoricoStatoRiunioneException {
		return getPersistence()
				   .findByStoricoRiunione_PrevAndNext(storicoStatoRiunionePK,
			id_riunione, orderByComparator);
	}

	/**
	* Removes all the storico stato riuniones where id_riunione = &#63; from the database.
	*
	* @param id_riunione the id_riunione
	*/
	public static void removeByStoricoRiunione(long id_riunione) {
		getPersistence().removeByStoricoRiunione(id_riunione);
	}

	/**
	* Returns the number of storico stato riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the number of matching storico stato riuniones
	*/
	public static int countByStoricoRiunione(long id_riunione) {
		return getPersistence().countByStoricoRiunione(id_riunione);
	}

	/**
	* Caches the storico stato riunione in the entity cache if it is enabled.
	*
	* @param storicoStatoRiunione the storico stato riunione
	*/
	public static void cacheResult(StoricoStatoRiunione storicoStatoRiunione) {
		getPersistence().cacheResult(storicoStatoRiunione);
	}

	/**
	* Caches the storico stato riuniones in the entity cache if it is enabled.
	*
	* @param storicoStatoRiuniones the storico stato riuniones
	*/
	public static void cacheResult(
		List<StoricoStatoRiunione> storicoStatoRiuniones) {
		getPersistence().cacheResult(storicoStatoRiuniones);
	}

	/**
	* Creates a new storico stato riunione with the primary key. Does not add the storico stato riunione to the database.
	*
	* @param storicoStatoRiunionePK the primary key for the new storico stato riunione
	* @return the new storico stato riunione
	*/
	public static StoricoStatoRiunione create(
		StoricoStatoRiunionePK storicoStatoRiunionePK) {
		return getPersistence().create(storicoStatoRiunionePK);
	}

	/**
	* Removes the storico stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione that was removed
	* @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	*/
	public static StoricoStatoRiunione remove(
		StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStoricoStatoRiunioneException {
		return getPersistence().remove(storicoStatoRiunionePK);
	}

	public static StoricoStatoRiunione updateImpl(
		StoricoStatoRiunione storicoStatoRiunione) {
		return getPersistence().updateImpl(storicoStatoRiunione);
	}

	/**
	* Returns the storico stato riunione with the primary key or throws a {@link NoSuchStoricoStatoRiunioneException} if it could not be found.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	*/
	public static StoricoStatoRiunione findByPrimaryKey(
		StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStoricoStatoRiunioneException {
		return getPersistence().findByPrimaryKey(storicoStatoRiunionePK);
	}

	/**
	* Returns the storico stato riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione, or <code>null</code> if a storico stato riunione with the primary key could not be found
	*/
	public static StoricoStatoRiunione fetchByPrimaryKey(
		StoricoStatoRiunionePK storicoStatoRiunionePK) {
		return getPersistence().fetchByPrimaryKey(storicoStatoRiunionePK);
	}

	public static java.util.Map<java.io.Serializable, StoricoStatoRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the storico stato riuniones.
	*
	* @return the storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the storico stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @return the range of storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the storico stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findAll(int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the storico stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of storico stato riuniones
	*/
	public static List<StoricoStatoRiunione> findAll(int start, int end,
		OrderByComparator<StoricoStatoRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the storico stato riuniones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of storico stato riuniones.
	*
	* @return the number of storico stato riuniones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static StoricoStatoRiunionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StoricoStatoRiunionePersistence, StoricoStatoRiunionePersistence> _serviceTracker =
		ServiceTrackerFactory.open(StoricoStatoRiunionePersistence.class);
}