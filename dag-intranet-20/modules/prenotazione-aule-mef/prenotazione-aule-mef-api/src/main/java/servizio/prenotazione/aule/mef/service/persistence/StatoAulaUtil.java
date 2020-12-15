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

import servizio.prenotazione.aule.mef.model.StatoAula;

import java.util.List;

/**
 * The persistence utility for the stato aula service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.StatoAulaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoAulaPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.StatoAulaPersistenceImpl
 * @generated
 */
@ProviderType
public class StatoAulaUtil {
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
	public static void clearCache(StatoAula statoAula) {
		getPersistence().clearCache(statoAula);
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
	public static List<StatoAula> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatoAula> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatoAula> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatoAula> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatoAula update(StatoAula statoAula) {
		return getPersistence().update(statoAula);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatoAula update(StatoAula statoAula,
		ServiceContext serviceContext) {
		return getPersistence().update(statoAula, serviceContext);
	}

	/**
	* Caches the stato aula in the entity cache if it is enabled.
	*
	* @param statoAula the stato aula
	*/
	public static void cacheResult(StatoAula statoAula) {
		getPersistence().cacheResult(statoAula);
	}

	/**
	* Caches the stato aulas in the entity cache if it is enabled.
	*
	* @param statoAulas the stato aulas
	*/
	public static void cacheResult(List<StatoAula> statoAulas) {
		getPersistence().cacheResult(statoAulas);
	}

	/**
	* Creates a new stato aula with the primary key. Does not add the stato aula to the database.
	*
	* @param id_stato_aula the primary key for the new stato aula
	* @return the new stato aula
	*/
	public static StatoAula create(long id_stato_aula) {
		return getPersistence().create(id_stato_aula);
	}

	/**
	* Removes the stato aula with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula that was removed
	* @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	*/
	public static StatoAula remove(long id_stato_aula)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStatoAulaException {
		return getPersistence().remove(id_stato_aula);
	}

	public static StatoAula updateImpl(StatoAula statoAula) {
		return getPersistence().updateImpl(statoAula);
	}

	/**
	* Returns the stato aula with the primary key or throws a {@link NoSuchStatoAulaException} if it could not be found.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula
	* @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	*/
	public static StatoAula findByPrimaryKey(long id_stato_aula)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStatoAulaException {
		return getPersistence().findByPrimaryKey(id_stato_aula);
	}

	/**
	* Returns the stato aula with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula, or <code>null</code> if a stato aula with the primary key could not be found
	*/
	public static StatoAula fetchByPrimaryKey(long id_stato_aula) {
		return getPersistence().fetchByPrimaryKey(id_stato_aula);
	}

	public static java.util.Map<java.io.Serializable, StatoAula> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the stato aulas.
	*
	* @return the stato aulas
	*/
	public static List<StatoAula> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stato aulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato aulas
	* @param end the upper bound of the range of stato aulas (not inclusive)
	* @return the range of stato aulas
	*/
	public static List<StatoAula> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stato aulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato aulas
	* @param end the upper bound of the range of stato aulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato aulas
	*/
	public static List<StatoAula> findAll(int start, int end,
		OrderByComparator<StatoAula> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato aulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato aulas
	* @param end the upper bound of the range of stato aulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato aulas
	*/
	public static List<StatoAula> findAll(int start, int end,
		OrderByComparator<StatoAula> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the stato aulas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stato aulas.
	*
	* @return the number of stato aulas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatoAulaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatoAulaPersistence, StatoAulaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StatoAulaPersistence.class);
}