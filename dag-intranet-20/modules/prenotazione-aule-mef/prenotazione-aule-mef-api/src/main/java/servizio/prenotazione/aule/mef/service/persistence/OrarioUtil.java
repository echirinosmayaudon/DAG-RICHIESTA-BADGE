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

import servizio.prenotazione.aule.mef.model.Orario;

import java.util.List;

/**
 * The persistence utility for the orario service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.OrarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrarioPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.OrarioPersistenceImpl
 * @generated
 */
@ProviderType
public class OrarioUtil {
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
	public static void clearCache(Orario orario) {
		getPersistence().clearCache(orario);
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
	public static List<Orario> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Orario> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Orario> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Orario> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Orario update(Orario orario) {
		return getPersistence().update(orario);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Orario update(Orario orario, ServiceContext serviceContext) {
		return getPersistence().update(orario, serviceContext);
	}

	/**
	* Caches the orario in the entity cache if it is enabled.
	*
	* @param orario the orario
	*/
	public static void cacheResult(Orario orario) {
		getPersistence().cacheResult(orario);
	}

	/**
	* Caches the orarios in the entity cache if it is enabled.
	*
	* @param orarios the orarios
	*/
	public static void cacheResult(List<Orario> orarios) {
		getPersistence().cacheResult(orarios);
	}

	/**
	* Creates a new orario with the primary key. Does not add the orario to the database.
	*
	* @param id_ora the primary key for the new orario
	* @return the new orario
	*/
	public static Orario create(long id_ora) {
		return getPersistence().create(id_ora);
	}

	/**
	* Removes the orario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ora the primary key of the orario
	* @return the orario that was removed
	* @throws NoSuchOrarioException if a orario with the primary key could not be found
	*/
	public static Orario remove(long id_ora)
		throws servizio.prenotazione.aule.mef.exception.NoSuchOrarioException {
		return getPersistence().remove(id_ora);
	}

	public static Orario updateImpl(Orario orario) {
		return getPersistence().updateImpl(orario);
	}

	/**
	* Returns the orario with the primary key or throws a {@link NoSuchOrarioException} if it could not be found.
	*
	* @param id_ora the primary key of the orario
	* @return the orario
	* @throws NoSuchOrarioException if a orario with the primary key could not be found
	*/
	public static Orario findByPrimaryKey(long id_ora)
		throws servizio.prenotazione.aule.mef.exception.NoSuchOrarioException {
		return getPersistence().findByPrimaryKey(id_ora);
	}

	/**
	* Returns the orario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_ora the primary key of the orario
	* @return the orario, or <code>null</code> if a orario with the primary key could not be found
	*/
	public static Orario fetchByPrimaryKey(long id_ora) {
		return getPersistence().fetchByPrimaryKey(id_ora);
	}

	public static java.util.Map<java.io.Serializable, Orario> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the orarios.
	*
	* @return the orarios
	*/
	public static List<Orario> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the orarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orarios
	* @param end the upper bound of the range of orarios (not inclusive)
	* @return the range of orarios
	*/
	public static List<Orario> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the orarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orarios
	* @param end the upper bound of the range of orarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of orarios
	*/
	public static List<Orario> findAll(int start, int end,
		OrderByComparator<Orario> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the orarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orarios
	* @param end the upper bound of the range of orarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of orarios
	*/
	public static List<Orario> findAll(int start, int end,
		OrderByComparator<Orario> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the orarios from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of orarios.
	*
	* @return the number of orarios
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrarioPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OrarioPersistence, OrarioPersistence> _serviceTracker =
		ServiceTrackerFactory.open(OrarioPersistence.class);
}