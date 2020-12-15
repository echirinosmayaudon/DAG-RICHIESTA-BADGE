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

package com.intranet.mef.central.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.central.model.CentralInvoker;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the central invoker service. This utility wraps {@link com.intranet.mef.central.service.persistence.impl.CentralInvokerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvokerPersistence
 * @see com.intranet.mef.central.service.persistence.impl.CentralInvokerPersistenceImpl
 * @generated
 */
@ProviderType
public class CentralInvokerUtil {
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
	public static void clearCache(CentralInvoker centralInvoker) {
		getPersistence().clearCache(centralInvoker);
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
	public static List<CentralInvoker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CentralInvoker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CentralInvoker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CentralInvoker update(CentralInvoker centralInvoker) {
		return getPersistence().update(centralInvoker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CentralInvoker update(CentralInvoker centralInvoker,
		ServiceContext serviceContext) {
		return getPersistence().update(centralInvoker, serviceContext);
	}

	/**
	* Returns all the central invokers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching central invokers
	*/
	public static List<CentralInvoker> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the central invokers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @return the range of matching central invokers
	*/
	public static List<CentralInvoker> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the central invokers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching central invokers
	*/
	public static List<CentralInvoker> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<CentralInvoker> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the central invokers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching central invokers
	*/
	public static List<CentralInvoker> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching central invoker
	* @throws NoSuchCentralInvokerException if a matching central invoker could not be found
	*/
	public static CentralInvoker findByUuid_First(java.lang.String uuid,
		OrderByComparator<CentralInvoker> orderByComparator)
		throws com.intranet.mef.central.exception.NoSuchCentralInvokerException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching central invoker, or <code>null</code> if a matching central invoker could not be found
	*/
	public static CentralInvoker fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<CentralInvoker> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching central invoker
	* @throws NoSuchCentralInvokerException if a matching central invoker could not be found
	*/
	public static CentralInvoker findByUuid_Last(java.lang.String uuid,
		OrderByComparator<CentralInvoker> orderByComparator)
		throws com.intranet.mef.central.exception.NoSuchCentralInvokerException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching central invoker, or <code>null</code> if a matching central invoker could not be found
	*/
	public static CentralInvoker fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<CentralInvoker> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the central invokers before and after the current central invoker in the ordered set where uuid = &#63;.
	*
	* @param idRecord the primary key of the current central invoker
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next central invoker
	* @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	*/
	public static CentralInvoker[] findByUuid_PrevAndNext(long idRecord,
		java.lang.String uuid,
		OrderByComparator<CentralInvoker> orderByComparator)
		throws com.intranet.mef.central.exception.NoSuchCentralInvokerException {
		return getPersistence()
				   .findByUuid_PrevAndNext(idRecord, uuid, orderByComparator);
	}

	/**
	* Removes all the central invokers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of central invokers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching central invokers
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the central invoker in the entity cache if it is enabled.
	*
	* @param centralInvoker the central invoker
	*/
	public static void cacheResult(CentralInvoker centralInvoker) {
		getPersistence().cacheResult(centralInvoker);
	}

	/**
	* Caches the central invokers in the entity cache if it is enabled.
	*
	* @param centralInvokers the central invokers
	*/
	public static void cacheResult(List<CentralInvoker> centralInvokers) {
		getPersistence().cacheResult(centralInvokers);
	}

	/**
	* Creates a new central invoker with the primary key. Does not add the central invoker to the database.
	*
	* @param idRecord the primary key for the new central invoker
	* @return the new central invoker
	*/
	public static CentralInvoker create(long idRecord) {
		return getPersistence().create(idRecord);
	}

	/**
	* Removes the central invoker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker that was removed
	* @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	*/
	public static CentralInvoker remove(long idRecord)
		throws com.intranet.mef.central.exception.NoSuchCentralInvokerException {
		return getPersistence().remove(idRecord);
	}

	public static CentralInvoker updateImpl(CentralInvoker centralInvoker) {
		return getPersistence().updateImpl(centralInvoker);
	}

	/**
	* Returns the central invoker with the primary key or throws a {@link NoSuchCentralInvokerException} if it could not be found.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker
	* @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	*/
	public static CentralInvoker findByPrimaryKey(long idRecord)
		throws com.intranet.mef.central.exception.NoSuchCentralInvokerException {
		return getPersistence().findByPrimaryKey(idRecord);
	}

	/**
	* Returns the central invoker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker, or <code>null</code> if a central invoker with the primary key could not be found
	*/
	public static CentralInvoker fetchByPrimaryKey(long idRecord) {
		return getPersistence().fetchByPrimaryKey(idRecord);
	}

	public static java.util.Map<java.io.Serializable, CentralInvoker> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the central invokers.
	*
	* @return the central invokers
	*/
	public static List<CentralInvoker> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @return the range of central invokers
	*/
	public static List<CentralInvoker> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of central invokers
	*/
	public static List<CentralInvoker> findAll(int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of central invokers
	*/
	public static List<CentralInvoker> findAll(int start, int end,
		OrderByComparator<CentralInvoker> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the central invokers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of central invokers.
	*
	* @return the number of central invokers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CentralInvokerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CentralInvokerPersistence, CentralInvokerPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CentralInvokerPersistence.class);
}