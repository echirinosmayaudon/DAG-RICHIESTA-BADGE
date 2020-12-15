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

import com.intranet.mef.assistance.model.Area;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the area service. This utility wraps {@link com.intranet.mef.assistance.service.persistence.impl.AreaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaPersistence
 * @see com.intranet.mef.assistance.service.persistence.impl.AreaPersistenceImpl
 * @generated
 */
@ProviderType
public class AreaUtil {
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
	public static void clearCache(Area area) {
		getPersistence().clearCache(area);
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
	public static List<Area> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Area> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Area> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Area> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Area update(Area area) {
		return getPersistence().update(area);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Area update(Area area, ServiceContext serviceContext) {
		return getPersistence().update(area, serviceContext);
	}

	/**
	* Returns all the areas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching areas
	*/
	public static List<Area> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the areas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @return the range of matching areas
	*/
	public static List<Area> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the areas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching areas
	*/
	public static List<Area> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Area> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the areas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching areas
	*/
	public static List<Area> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Area> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first area in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching area
	* @throws NoSuchAreaException if a matching area could not be found
	*/
	public static Area findByUuid_First(java.lang.String uuid,
		OrderByComparator<Area> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first area in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching area, or <code>null</code> if a matching area could not be found
	*/
	public static Area fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Area> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last area in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching area
	* @throws NoSuchAreaException if a matching area could not be found
	*/
	public static Area findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Area> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last area in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching area, or <code>null</code> if a matching area could not be found
	*/
	public static Area fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Area> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the areas before and after the current area in the ordered set where uuid = &#63;.
	*
	* @param areaId the primary key of the current area
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next area
	* @throws NoSuchAreaException if a area with the primary key could not be found
	*/
	public static Area[] findByUuid_PrevAndNext(java.lang.String areaId,
		java.lang.String uuid, OrderByComparator<Area> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence()
				   .findByUuid_PrevAndNext(areaId, uuid, orderByComparator);
	}

	/**
	* Removes all the areas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of areas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching areas
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the areas where assServiceId = &#63;.
	*
	* @param assServiceId the ass service ID
	* @return the matching areas
	*/
	public static List<Area> findByServicesId(java.lang.String assServiceId) {
		return getPersistence().findByServicesId(assServiceId);
	}

	/**
	* Returns a range of all the areas where assServiceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assServiceId the ass service ID
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @return the range of matching areas
	*/
	public static List<Area> findByServicesId(java.lang.String assServiceId,
		int start, int end) {
		return getPersistence().findByServicesId(assServiceId, start, end);
	}

	/**
	* Returns an ordered range of all the areas where assServiceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assServiceId the ass service ID
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching areas
	*/
	public static List<Area> findByServicesId(java.lang.String assServiceId,
		int start, int end, OrderByComparator<Area> orderByComparator) {
		return getPersistence()
				   .findByServicesId(assServiceId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the areas where assServiceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assServiceId the ass service ID
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching areas
	*/
	public static List<Area> findByServicesId(java.lang.String assServiceId,
		int start, int end, OrderByComparator<Area> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByServicesId(assServiceId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first area in the ordered set where assServiceId = &#63;.
	*
	* @param assServiceId the ass service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching area
	* @throws NoSuchAreaException if a matching area could not be found
	*/
	public static Area findByServicesId_First(java.lang.String assServiceId,
		OrderByComparator<Area> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence()
				   .findByServicesId_First(assServiceId, orderByComparator);
	}

	/**
	* Returns the first area in the ordered set where assServiceId = &#63;.
	*
	* @param assServiceId the ass service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching area, or <code>null</code> if a matching area could not be found
	*/
	public static Area fetchByServicesId_First(java.lang.String assServiceId,
		OrderByComparator<Area> orderByComparator) {
		return getPersistence()
				   .fetchByServicesId_First(assServiceId, orderByComparator);
	}

	/**
	* Returns the last area in the ordered set where assServiceId = &#63;.
	*
	* @param assServiceId the ass service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching area
	* @throws NoSuchAreaException if a matching area could not be found
	*/
	public static Area findByServicesId_Last(java.lang.String assServiceId,
		OrderByComparator<Area> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence()
				   .findByServicesId_Last(assServiceId, orderByComparator);
	}

	/**
	* Returns the last area in the ordered set where assServiceId = &#63;.
	*
	* @param assServiceId the ass service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching area, or <code>null</code> if a matching area could not be found
	*/
	public static Area fetchByServicesId_Last(java.lang.String assServiceId,
		OrderByComparator<Area> orderByComparator) {
		return getPersistence()
				   .fetchByServicesId_Last(assServiceId, orderByComparator);
	}

	/**
	* Returns the areas before and after the current area in the ordered set where assServiceId = &#63;.
	*
	* @param areaId the primary key of the current area
	* @param assServiceId the ass service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next area
	* @throws NoSuchAreaException if a area with the primary key could not be found
	*/
	public static Area[] findByServicesId_PrevAndNext(java.lang.String areaId,
		java.lang.String assServiceId, OrderByComparator<Area> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence()
				   .findByServicesId_PrevAndNext(areaId, assServiceId,
			orderByComparator);
	}

	/**
	* Removes all the areas where assServiceId = &#63; from the database.
	*
	* @param assServiceId the ass service ID
	*/
	public static void removeByServicesId(java.lang.String assServiceId) {
		getPersistence().removeByServicesId(assServiceId);
	}

	/**
	* Returns the number of areas where assServiceId = &#63;.
	*
	* @param assServiceId the ass service ID
	* @return the number of matching areas
	*/
	public static int countByServicesId(java.lang.String assServiceId) {
		return getPersistence().countByServicesId(assServiceId);
	}

	/**
	* Caches the area in the entity cache if it is enabled.
	*
	* @param area the area
	*/
	public static void cacheResult(Area area) {
		getPersistence().cacheResult(area);
	}

	/**
	* Caches the areas in the entity cache if it is enabled.
	*
	* @param areas the areas
	*/
	public static void cacheResult(List<Area> areas) {
		getPersistence().cacheResult(areas);
	}

	/**
	* Creates a new area with the primary key. Does not add the area to the database.
	*
	* @param areaId the primary key for the new area
	* @return the new area
	*/
	public static Area create(java.lang.String areaId) {
		return getPersistence().create(areaId);
	}

	/**
	* Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param areaId the primary key of the area
	* @return the area that was removed
	* @throws NoSuchAreaException if a area with the primary key could not be found
	*/
	public static Area remove(java.lang.String areaId)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence().remove(areaId);
	}

	public static Area updateImpl(Area area) {
		return getPersistence().updateImpl(area);
	}

	/**
	* Returns the area with the primary key or throws a {@link NoSuchAreaException} if it could not be found.
	*
	* @param areaId the primary key of the area
	* @return the area
	* @throws NoSuchAreaException if a area with the primary key could not be found
	*/
	public static Area findByPrimaryKey(java.lang.String areaId)
		throws com.intranet.mef.assistance.exception.NoSuchAreaException {
		return getPersistence().findByPrimaryKey(areaId);
	}

	/**
	* Returns the area with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param areaId the primary key of the area
	* @return the area, or <code>null</code> if a area with the primary key could not be found
	*/
	public static Area fetchByPrimaryKey(java.lang.String areaId) {
		return getPersistence().fetchByPrimaryKey(areaId);
	}

	public static java.util.Map<java.io.Serializable, Area> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the areas.
	*
	* @return the areas
	*/
	public static List<Area> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the areas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @return the range of areas
	*/
	public static List<Area> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the areas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of areas
	*/
	public static List<Area> findAll(int start, int end,
		OrderByComparator<Area> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the areas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of areas
	* @param end the upper bound of the range of areas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of areas
	*/
	public static List<Area> findAll(int start, int end,
		OrderByComparator<Area> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the areas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of areas.
	*
	* @return the number of areas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AreaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AreaPersistence, AreaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AreaPersistence.class);
}