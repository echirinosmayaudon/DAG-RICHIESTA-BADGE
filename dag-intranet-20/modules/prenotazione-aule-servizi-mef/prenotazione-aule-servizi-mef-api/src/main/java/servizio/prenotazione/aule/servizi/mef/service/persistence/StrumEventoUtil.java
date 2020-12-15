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

package servizio.prenotazione.aule.servizi.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.servizi.mef.model.StrumEvento;

import java.util.List;

/**
 * The persistence utility for the strum evento service. This utility wraps {@link servizio.prenotazione.aule.servizi.mef.service.persistence.impl.StrumEventoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumEventoPersistence
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.impl.StrumEventoPersistenceImpl
 * @generated
 */
@ProviderType
public class StrumEventoUtil {
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
	public static void clearCache(StrumEvento strumEvento) {
		getPersistence().clearCache(strumEvento);
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
	public static List<StrumEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StrumEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StrumEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StrumEvento> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StrumEvento update(StrumEvento strumEvento) {
		return getPersistence().update(strumEvento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StrumEvento update(StrumEvento strumEvento,
		ServiceContext serviceContext) {
		return getPersistence().update(strumEvento, serviceContext);
	}

	/**
	* Caches the strum evento in the entity cache if it is enabled.
	*
	* @param strumEvento the strum evento
	*/
	public static void cacheResult(StrumEvento strumEvento) {
		getPersistence().cacheResult(strumEvento);
	}

	/**
	* Caches the strum eventos in the entity cache if it is enabled.
	*
	* @param strumEventos the strum eventos
	*/
	public static void cacheResult(List<StrumEvento> strumEventos) {
		getPersistence().cacheResult(strumEventos);
	}

	/**
	* Creates a new strum evento with the primary key. Does not add the strum evento to the database.
	*
	* @param strumEventoPK the primary key for the new strum evento
	* @return the new strum evento
	*/
	public static StrumEvento create(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK) {
		return getPersistence().create(strumEventoPK);
	}

	/**
	* Removes the strum evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento that was removed
	* @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	*/
	public static StrumEvento remove(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK)
		throws servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumEventoException {
		return getPersistence().remove(strumEventoPK);
	}

	public static StrumEvento updateImpl(StrumEvento strumEvento) {
		return getPersistence().updateImpl(strumEvento);
	}

	/**
	* Returns the strum evento with the primary key or throws a {@link NoSuchStrumEventoException} if it could not be found.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento
	* @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	*/
	public static StrumEvento findByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK)
		throws servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumEventoException {
		return getPersistence().findByPrimaryKey(strumEventoPK);
	}

	/**
	* Returns the strum evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento, or <code>null</code> if a strum evento with the primary key could not be found
	*/
	public static StrumEvento fetchByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK) {
		return getPersistence().fetchByPrimaryKey(strumEventoPK);
	}

	public static java.util.Map<java.io.Serializable, StrumEvento> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the strum eventos.
	*
	* @return the strum eventos
	*/
	public static List<StrumEvento> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the strum eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum eventos
	* @param end the upper bound of the range of strum eventos (not inclusive)
	* @return the range of strum eventos
	*/
	public static List<StrumEvento> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the strum eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum eventos
	* @param end the upper bound of the range of strum eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strum eventos
	*/
	public static List<StrumEvento> findAll(int start, int end,
		OrderByComparator<StrumEvento> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the strum eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum eventos
	* @param end the upper bound of the range of strum eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strum eventos
	*/
	public static List<StrumEvento> findAll(int start, int end,
		OrderByComparator<StrumEvento> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the strum eventos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of strum eventos.
	*
	* @return the number of strum eventos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StrumEventoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StrumEventoPersistence, StrumEventoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StrumEventoPersistence.class);
}