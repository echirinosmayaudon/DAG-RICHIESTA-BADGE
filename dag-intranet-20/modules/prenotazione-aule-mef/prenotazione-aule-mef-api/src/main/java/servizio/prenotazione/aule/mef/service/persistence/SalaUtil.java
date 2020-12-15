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

package servizio.prenotazione.aule.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.mef.model.Sala;

import java.util.List;

/**
 * The persistence utility for the sala service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.SalaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.SalaPersistenceImpl
 * @generated
 */
@ProviderType
public class SalaUtil {
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
	public static void clearCache(Sala sala) {
		getPersistence().clearCache(sala);
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
	public static List<Sala> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sala> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sala> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Sala> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Sala update(Sala sala) {
		return getPersistence().update(sala);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Sala update(Sala sala, ServiceContext serviceContext) {
		return getPersistence().update(sala, serviceContext);
	}

	/**
	* Caches the sala in the entity cache if it is enabled.
	*
	* @param sala the sala
	*/
	public static void cacheResult(Sala sala) {
		getPersistence().cacheResult(sala);
	}

	/**
	* Caches the salas in the entity cache if it is enabled.
	*
	* @param salas the salas
	*/
	public static void cacheResult(List<Sala> salas) {
		getPersistence().cacheResult(salas);
	}

	/**
	* Creates a new sala with the primary key. Does not add the sala to the database.
	*
	* @param id_sala the primary key for the new sala
	* @return the new sala
	*/
	public static Sala create(long id_sala) {
		return getPersistence().create(id_sala);
	}

	/**
	* Removes the sala with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_sala the primary key of the sala
	* @return the sala that was removed
	* @throws NoSuchSalaException if a sala with the primary key could not be found
	*/
	public static Sala remove(long id_sala)
		throws servizio.prenotazione.aule.mef.exception.NoSuchSalaException {
		return getPersistence().remove(id_sala);
	}

	public static Sala updateImpl(Sala sala) {
		return getPersistence().updateImpl(sala);
	}

	/**
	* Returns the sala with the primary key or throws a {@link NoSuchSalaException} if it could not be found.
	*
	* @param id_sala the primary key of the sala
	* @return the sala
	* @throws NoSuchSalaException if a sala with the primary key could not be found
	*/
	public static Sala findByPrimaryKey(long id_sala)
		throws servizio.prenotazione.aule.mef.exception.NoSuchSalaException {
		return getPersistence().findByPrimaryKey(id_sala);
	}

	/**
	* Returns the sala with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_sala the primary key of the sala
	* @return the sala, or <code>null</code> if a sala with the primary key could not be found
	*/
	public static Sala fetchByPrimaryKey(long id_sala) {
		return getPersistence().fetchByPrimaryKey(id_sala);
	}

	public static java.util.Map<java.io.Serializable, Sala> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the salas.
	*
	* @return the salas
	*/
	public static List<Sala> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the salas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salas
	* @param end the upper bound of the range of salas (not inclusive)
	* @return the range of salas
	*/
	public static List<Sala> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the salas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salas
	* @param end the upper bound of the range of salas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of salas
	*/
	public static List<Sala> findAll(int start, int end,
		OrderByComparator<Sala> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the salas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salas
	* @param end the upper bound of the range of salas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of salas
	*/
	public static List<Sala> findAll(int start, int end,
		OrderByComparator<Sala> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the salas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of salas.
	*
	* @return the number of salas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SalaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalaPersistence, SalaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SalaPersistence.class);
}