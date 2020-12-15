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

package com.intranet.mef.assistance.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Servizio;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the servizio service. This utility wraps {@link com.intranet.mef.assistance.service.persistence.impl.ServizioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioPersistence
 * @see com.intranet.mef.assistance.service.persistence.impl.ServizioPersistenceImpl
 * @generated
 */
@ProviderType
public class ServizioUtil {
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
	public static void clearCache(Servizio servizio) {
		getPersistence().clearCache(servizio);
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
	public static List<Servizio> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Servizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Servizio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Servizio update(Servizio servizio) {
		return getPersistence().update(servizio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Servizio update(Servizio servizio,
		ServiceContext serviceContext) {
		return getPersistence().update(servizio, serviceContext);
	}

	/**
	* Returns all the servizios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching servizios
	*/
	public static List<Servizio> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the servizios where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @return the range of matching servizios
	*/
	public static List<Servizio> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the servizios where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servizios
	*/
	public static List<Servizio> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Servizio> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servizios where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servizios
	*/
	public static List<Servizio> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Servizio> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first servizio in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio
	* @throws NoSuchServizioException if a matching servizio could not be found
	*/
	public static Servizio findByUuid_First(java.lang.String uuid,
		OrderByComparator<Servizio> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first servizio in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	*/
	public static Servizio fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Servizio> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last servizio in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio
	* @throws NoSuchServizioException if a matching servizio could not be found
	*/
	public static Servizio findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Servizio> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last servizio in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	*/
	public static Servizio fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Servizio> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the servizios before and after the current servizio in the ordered set where uuid = &#63;.
	*
	* @param assServiceId the primary key of the current servizio
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next servizio
	* @throws NoSuchServizioException if a servizio with the primary key could not be found
	*/
	public static Servizio[] findByUuid_PrevAndNext(
		java.lang.String assServiceId, java.lang.String uuid,
		OrderByComparator<Servizio> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence()
				   .findByUuid_PrevAndNext(assServiceId, uuid, orderByComparator);
	}

	/**
	* Removes all the servizios where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of servizios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching servizios
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the servizios where assScopeId = &#63;.
	*
	* @param assScopeId the ass scope ID
	* @return the matching servizios
	*/
	public static List<Servizio> findByScopesId(java.lang.String assScopeId) {
		return getPersistence().findByScopesId(assScopeId);
	}

	/**
	* Returns a range of all the servizios where assScopeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assScopeId the ass scope ID
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @return the range of matching servizios
	*/
	public static List<Servizio> findByScopesId(java.lang.String assScopeId,
		int start, int end) {
		return getPersistence().findByScopesId(assScopeId, start, end);
	}

	/**
	* Returns an ordered range of all the servizios where assScopeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assScopeId the ass scope ID
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servizios
	*/
	public static List<Servizio> findByScopesId(java.lang.String assScopeId,
		int start, int end, OrderByComparator<Servizio> orderByComparator) {
		return getPersistence()
				   .findByScopesId(assScopeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servizios where assScopeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assScopeId the ass scope ID
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servizios
	*/
	public static List<Servizio> findByScopesId(java.lang.String assScopeId,
		int start, int end, OrderByComparator<Servizio> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByScopesId(assScopeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first servizio in the ordered set where assScopeId = &#63;.
	*
	* @param assScopeId the ass scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio
	* @throws NoSuchServizioException if a matching servizio could not be found
	*/
	public static Servizio findByScopesId_First(java.lang.String assScopeId,
		OrderByComparator<Servizio> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence()
				   .findByScopesId_First(assScopeId, orderByComparator);
	}

	/**
	* Returns the first servizio in the ordered set where assScopeId = &#63;.
	*
	* @param assScopeId the ass scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	*/
	public static Servizio fetchByScopesId_First(java.lang.String assScopeId,
		OrderByComparator<Servizio> orderByComparator) {
		return getPersistence()
				   .fetchByScopesId_First(assScopeId, orderByComparator);
	}

	/**
	* Returns the last servizio in the ordered set where assScopeId = &#63;.
	*
	* @param assScopeId the ass scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio
	* @throws NoSuchServizioException if a matching servizio could not be found
	*/
	public static Servizio findByScopesId_Last(java.lang.String assScopeId,
		OrderByComparator<Servizio> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence()
				   .findByScopesId_Last(assScopeId, orderByComparator);
	}

	/**
	* Returns the last servizio in the ordered set where assScopeId = &#63;.
	*
	* @param assScopeId the ass scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	*/
	public static Servizio fetchByScopesId_Last(java.lang.String assScopeId,
		OrderByComparator<Servizio> orderByComparator) {
		return getPersistence()
				   .fetchByScopesId_Last(assScopeId, orderByComparator);
	}

	/**
	* Returns the servizios before and after the current servizio in the ordered set where assScopeId = &#63;.
	*
	* @param assServiceId the primary key of the current servizio
	* @param assScopeId the ass scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next servizio
	* @throws NoSuchServizioException if a servizio with the primary key could not be found
	*/
	public static Servizio[] findByScopesId_PrevAndNext(
		java.lang.String assServiceId, java.lang.String assScopeId,
		OrderByComparator<Servizio> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence()
				   .findByScopesId_PrevAndNext(assServiceId, assScopeId,
			orderByComparator);
	}

	/**
	* Removes all the servizios where assScopeId = &#63; from the database.
	*
	* @param assScopeId the ass scope ID
	*/
	public static void removeByScopesId(java.lang.String assScopeId) {
		getPersistence().removeByScopesId(assScopeId);
	}

	/**
	* Returns the number of servizios where assScopeId = &#63;.
	*
	* @param assScopeId the ass scope ID
	* @return the number of matching servizios
	*/
	public static int countByScopesId(java.lang.String assScopeId) {
		return getPersistence().countByScopesId(assScopeId);
	}

	/**
	* Caches the servizio in the entity cache if it is enabled.
	*
	* @param servizio the servizio
	*/
	public static void cacheResult(Servizio servizio) {
		getPersistence().cacheResult(servizio);
	}

	/**
	* Caches the servizios in the entity cache if it is enabled.
	*
	* @param servizios the servizios
	*/
	public static void cacheResult(List<Servizio> servizios) {
		getPersistence().cacheResult(servizios);
	}

	/**
	* Creates a new servizio with the primary key. Does not add the servizio to the database.
	*
	* @param assServiceId the primary key for the new servizio
	* @return the new servizio
	*/
	public static Servizio create(java.lang.String assServiceId) {
		return getPersistence().create(assServiceId);
	}

	/**
	* Removes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assServiceId the primary key of the servizio
	* @return the servizio that was removed
	* @throws NoSuchServizioException if a servizio with the primary key could not be found
	*/
	public static Servizio remove(java.lang.String assServiceId)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence().remove(assServiceId);
	}

	public static Servizio updateImpl(Servizio servizio) {
		return getPersistence().updateImpl(servizio);
	}

	/**
	* Returns the servizio with the primary key or throws a {@link NoSuchServizioException} if it could not be found.
	*
	* @param assServiceId the primary key of the servizio
	* @return the servizio
	* @throws NoSuchServizioException if a servizio with the primary key could not be found
	*/
	public static Servizio findByPrimaryKey(java.lang.String assServiceId)
		throws com.intranet.mef.assistance.exception.NoSuchServizioException {
		return getPersistence().findByPrimaryKey(assServiceId);
	}

	/**
	* Returns the servizio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assServiceId the primary key of the servizio
	* @return the servizio, or <code>null</code> if a servizio with the primary key could not be found
	*/
	public static Servizio fetchByPrimaryKey(java.lang.String assServiceId) {
		return getPersistence().fetchByPrimaryKey(assServiceId);
	}

	public static java.util.Map<java.io.Serializable, Servizio> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the servizios.
	*
	* @return the servizios
	*/
	public static List<Servizio> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @return the range of servizios
	*/
	public static List<Servizio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of servizios
	*/
	public static List<Servizio> findAll(int start, int end,
		OrderByComparator<Servizio> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of servizios
	*/
	public static List<Servizio> findAll(int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the servizios from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of servizios.
	*
	* @return the number of servizios
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ServizioPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServizioPersistence, ServizioPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ServizioPersistence.class);
}