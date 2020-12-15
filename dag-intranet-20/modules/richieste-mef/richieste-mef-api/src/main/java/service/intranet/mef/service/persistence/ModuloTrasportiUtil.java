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

package service.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import service.intranet.mef.model.ModuloTrasporti;

import java.util.List;

/**
 * The persistence utility for the modulo trasporti service. This utility wraps {@link service.intranet.mef.service.persistence.impl.ModuloTrasportiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModuloTrasportiPersistence
 * @see service.intranet.mef.service.persistence.impl.ModuloTrasportiPersistenceImpl
 * @generated
 */
@ProviderType
public class ModuloTrasportiUtil {
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
	public static void clearCache(ModuloTrasporti moduloTrasporti) {
		getPersistence().clearCache(moduloTrasporti);
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
	public static List<ModuloTrasporti> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ModuloTrasporti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ModuloTrasporti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ModuloTrasporti> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ModuloTrasporti update(ModuloTrasporti moduloTrasporti) {
		return getPersistence().update(moduloTrasporti);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ModuloTrasporti update(ModuloTrasporti moduloTrasporti,
		ServiceContext serviceContext) {
		return getPersistence().update(moduloTrasporti, serviceContext);
	}

	/**
	* Caches the modulo trasporti in the entity cache if it is enabled.
	*
	* @param moduloTrasporti the modulo trasporti
	*/
	public static void cacheResult(ModuloTrasporti moduloTrasporti) {
		getPersistence().cacheResult(moduloTrasporti);
	}

	/**
	* Caches the modulo trasportis in the entity cache if it is enabled.
	*
	* @param moduloTrasportis the modulo trasportis
	*/
	public static void cacheResult(List<ModuloTrasporti> moduloTrasportis) {
		getPersistence().cacheResult(moduloTrasportis);
	}

	/**
	* Creates a new modulo trasporti with the primary key. Does not add the modulo trasporti to the database.
	*
	* @param id_modulo_trasporti the primary key for the new modulo trasporti
	* @return the new modulo trasporti
	*/
	public static ModuloTrasporti create(long id_modulo_trasporti) {
		return getPersistence().create(id_modulo_trasporti);
	}

	/**
	* Removes the modulo trasporti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_modulo_trasporti the primary key of the modulo trasporti
	* @return the modulo trasporti that was removed
	* @throws NoSuchModuloTrasportiException if a modulo trasporti with the primary key could not be found
	*/
	public static ModuloTrasporti remove(long id_modulo_trasporti)
		throws service.intranet.mef.exception.NoSuchModuloTrasportiException {
		return getPersistence().remove(id_modulo_trasporti);
	}

	public static ModuloTrasporti updateImpl(ModuloTrasporti moduloTrasporti) {
		return getPersistence().updateImpl(moduloTrasporti);
	}

	/**
	* Returns the modulo trasporti with the primary key or throws a {@link NoSuchModuloTrasportiException} if it could not be found.
	*
	* @param id_modulo_trasporti the primary key of the modulo trasporti
	* @return the modulo trasporti
	* @throws NoSuchModuloTrasportiException if a modulo trasporti with the primary key could not be found
	*/
	public static ModuloTrasporti findByPrimaryKey(long id_modulo_trasporti)
		throws service.intranet.mef.exception.NoSuchModuloTrasportiException {
		return getPersistence().findByPrimaryKey(id_modulo_trasporti);
	}

	/**
	* Returns the modulo trasporti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_modulo_trasporti the primary key of the modulo trasporti
	* @return the modulo trasporti, or <code>null</code> if a modulo trasporti with the primary key could not be found
	*/
	public static ModuloTrasporti fetchByPrimaryKey(long id_modulo_trasporti) {
		return getPersistence().fetchByPrimaryKey(id_modulo_trasporti);
	}

	public static java.util.Map<java.io.Serializable, ModuloTrasporti> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the modulo trasportis.
	*
	* @return the modulo trasportis
	*/
	public static List<ModuloTrasporti> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the modulo trasportis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of modulo trasportis
	* @param end the upper bound of the range of modulo trasportis (not inclusive)
	* @return the range of modulo trasportis
	*/
	public static List<ModuloTrasporti> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the modulo trasportis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of modulo trasportis
	* @param end the upper bound of the range of modulo trasportis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of modulo trasportis
	*/
	public static List<ModuloTrasporti> findAll(int start, int end,
		OrderByComparator<ModuloTrasporti> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the modulo trasportis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of modulo trasportis
	* @param end the upper bound of the range of modulo trasportis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of modulo trasportis
	*/
	public static List<ModuloTrasporti> findAll(int start, int end,
		OrderByComparator<ModuloTrasporti> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the modulo trasportis from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of modulo trasportis.
	*
	* @return the number of modulo trasportis
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ModuloTrasportiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ModuloTrasportiPersistence, ModuloTrasportiPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ModuloTrasportiPersistence.class);
}