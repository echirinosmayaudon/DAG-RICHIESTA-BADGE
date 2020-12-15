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

import com.intranet.mef.gestione.riunioni.model.Luogo;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the luogo service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.LuogoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LuogoPersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.LuogoPersistenceImpl
 * @generated
 */
@ProviderType
public class LuogoUtil {
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
	public static void clearCache(Luogo luogo) {
		getPersistence().clearCache(luogo);
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
	public static List<Luogo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Luogo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Luogo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Luogo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Luogo update(Luogo luogo) {
		return getPersistence().update(luogo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Luogo update(Luogo luogo, ServiceContext serviceContext) {
		return getPersistence().update(luogo, serviceContext);
	}

	/**
	* Caches the luogo in the entity cache if it is enabled.
	*
	* @param luogo the luogo
	*/
	public static void cacheResult(Luogo luogo) {
		getPersistence().cacheResult(luogo);
	}

	/**
	* Caches the luogos in the entity cache if it is enabled.
	*
	* @param luogos the luogos
	*/
	public static void cacheResult(List<Luogo> luogos) {
		getPersistence().cacheResult(luogos);
	}

	/**
	* Creates a new luogo with the primary key. Does not add the luogo to the database.
	*
	* @param id_luogo the primary key for the new luogo
	* @return the new luogo
	*/
	public static Luogo create(long id_luogo) {
		return getPersistence().create(id_luogo);
	}

	/**
	* Removes the luogo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo that was removed
	* @throws NoSuchLuogoException if a luogo with the primary key could not be found
	*/
	public static Luogo remove(long id_luogo)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchLuogoException {
		return getPersistence().remove(id_luogo);
	}

	public static Luogo updateImpl(Luogo luogo) {
		return getPersistence().updateImpl(luogo);
	}

	/**
	* Returns the luogo with the primary key or throws a {@link NoSuchLuogoException} if it could not be found.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo
	* @throws NoSuchLuogoException if a luogo with the primary key could not be found
	*/
	public static Luogo findByPrimaryKey(long id_luogo)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchLuogoException {
		return getPersistence().findByPrimaryKey(id_luogo);
	}

	/**
	* Returns the luogo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo, or <code>null</code> if a luogo with the primary key could not be found
	*/
	public static Luogo fetchByPrimaryKey(long id_luogo) {
		return getPersistence().fetchByPrimaryKey(id_luogo);
	}

	public static java.util.Map<java.io.Serializable, Luogo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the luogos.
	*
	* @return the luogos
	*/
	public static List<Luogo> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of luogos
	* @param end the upper bound of the range of luogos (not inclusive)
	* @return the range of luogos
	*/
	public static List<Luogo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of luogos
	* @param end the upper bound of the range of luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of luogos
	*/
	public static List<Luogo> findAll(int start, int end,
		OrderByComparator<Luogo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of luogos
	* @param end the upper bound of the range of luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of luogos
	*/
	public static List<Luogo> findAll(int start, int end,
		OrderByComparator<Luogo> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the luogos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of luogos.
	*
	* @return the number of luogos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LuogoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LuogoPersistence, LuogoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LuogoPersistence.class);
}