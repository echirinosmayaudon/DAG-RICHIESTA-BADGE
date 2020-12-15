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

package servizio.beni.facile.consumo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.beni.facile.consumo.model.GestioneUtenti;

import java.util.List;

/**
 * The persistence utility for the gestione utenti service. This utility wraps {@link servizio.beni.facile.consumo.service.persistence.impl.GestioneUtentiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtentiPersistence
 * @see servizio.beni.facile.consumo.service.persistence.impl.GestioneUtentiPersistenceImpl
 * @generated
 */
@ProviderType
public class GestioneUtentiUtil {
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
	public static void clearCache(GestioneUtenti gestioneUtenti) {
		getPersistence().clearCache(gestioneUtenti);
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
	public static List<GestioneUtenti> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GestioneUtenti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GestioneUtenti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GestioneUtenti> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GestioneUtenti update(GestioneUtenti gestioneUtenti) {
		return getPersistence().update(gestioneUtenti);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GestioneUtenti update(GestioneUtenti gestioneUtenti,
		ServiceContext serviceContext) {
		return getPersistence().update(gestioneUtenti, serviceContext);
	}

	/**
	* Caches the gestione utenti in the entity cache if it is enabled.
	*
	* @param gestioneUtenti the gestione utenti
	*/
	public static void cacheResult(GestioneUtenti gestioneUtenti) {
		getPersistence().cacheResult(gestioneUtenti);
	}

	/**
	* Caches the gestione utentis in the entity cache if it is enabled.
	*
	* @param gestioneUtentis the gestione utentis
	*/
	public static void cacheResult(List<GestioneUtenti> gestioneUtentis) {
		getPersistence().cacheResult(gestioneUtentis);
	}

	/**
	* Creates a new gestione utenti with the primary key. Does not add the gestione utenti to the database.
	*
	* @param id the primary key for the new gestione utenti
	* @return the new gestione utenti
	*/
	public static GestioneUtenti create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the gestione utenti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the gestione utenti
	* @return the gestione utenti that was removed
	* @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	*/
	public static GestioneUtenti remove(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchGestioneUtentiException {
		return getPersistence().remove(id);
	}

	public static GestioneUtenti updateImpl(GestioneUtenti gestioneUtenti) {
		return getPersistence().updateImpl(gestioneUtenti);
	}

	/**
	* Returns the gestione utenti with the primary key or throws a {@link NoSuchGestioneUtentiException} if it could not be found.
	*
	* @param id the primary key of the gestione utenti
	* @return the gestione utenti
	* @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	*/
	public static GestioneUtenti findByPrimaryKey(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchGestioneUtentiException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the gestione utenti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the gestione utenti
	* @return the gestione utenti, or <code>null</code> if a gestione utenti with the primary key could not be found
	*/
	public static GestioneUtenti fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, GestioneUtenti> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the gestione utentis.
	*
	* @return the gestione utentis
	*/
	public static List<GestioneUtenti> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the gestione utentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gestione utentis
	* @param end the upper bound of the range of gestione utentis (not inclusive)
	* @return the range of gestione utentis
	*/
	public static List<GestioneUtenti> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the gestione utentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gestione utentis
	* @param end the upper bound of the range of gestione utentis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gestione utentis
	*/
	public static List<GestioneUtenti> findAll(int start, int end,
		OrderByComparator<GestioneUtenti> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the gestione utentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gestione utentis
	* @param end the upper bound of the range of gestione utentis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of gestione utentis
	*/
	public static List<GestioneUtenti> findAll(int start, int end,
		OrderByComparator<GestioneUtenti> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the gestione utentis from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of gestione utentis.
	*
	* @return the number of gestione utentis
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static GestioneUtentiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GestioneUtentiPersistence, GestioneUtentiPersistence> _serviceTracker =
		ServiceTrackerFactory.open(GestioneUtentiPersistence.class);
}