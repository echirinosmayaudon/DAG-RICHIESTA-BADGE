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

import com.intranet.mef.assistance.model.Ambito;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ambito service. This utility wraps {@link com.intranet.mef.assistance.service.persistence.impl.AmbitoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmbitoPersistence
 * @see com.intranet.mef.assistance.service.persistence.impl.AmbitoPersistenceImpl
 * @generated
 */
@ProviderType
public class AmbitoUtil {
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
	public static void clearCache(Ambito ambito) {
		getPersistence().clearCache(ambito);
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
	public static List<Ambito> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ambito> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ambito> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Ambito> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ambito update(Ambito ambito) {
		return getPersistence().update(ambito);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ambito update(Ambito ambito, ServiceContext serviceContext) {
		return getPersistence().update(ambito, serviceContext);
	}

	/**
	* Returns all the ambitos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching ambitos
	*/
	public static List<Ambito> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the ambitos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @return the range of matching ambitos
	*/
	public static List<Ambito> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the ambitos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ambitos
	*/
	public static List<Ambito> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Ambito> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ambitos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ambitos
	*/
	public static List<Ambito> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Ambito> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ambito
	* @throws NoSuchAmbitoException if a matching ambito could not be found
	*/
	public static Ambito findByUuid_First(java.lang.String uuid,
		OrderByComparator<Ambito> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAmbitoException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ambito, or <code>null</code> if a matching ambito could not be found
	*/
	public static Ambito fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Ambito> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ambito
	* @throws NoSuchAmbitoException if a matching ambito could not be found
	*/
	public static Ambito findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Ambito> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAmbitoException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ambito, or <code>null</code> if a matching ambito could not be found
	*/
	public static Ambito fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Ambito> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the ambitos before and after the current ambito in the ordered set where uuid = &#63;.
	*
	* @param assScopeId the primary key of the current ambito
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ambito
	* @throws NoSuchAmbitoException if a ambito with the primary key could not be found
	*/
	public static Ambito[] findByUuid_PrevAndNext(java.lang.String assScopeId,
		java.lang.String uuid, OrderByComparator<Ambito> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchAmbitoException {
		return getPersistence()
				   .findByUuid_PrevAndNext(assScopeId, uuid, orderByComparator);
	}

	/**
	* Removes all the ambitos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of ambitos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching ambitos
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the ambito in the entity cache if it is enabled.
	*
	* @param ambito the ambito
	*/
	public static void cacheResult(Ambito ambito) {
		getPersistence().cacheResult(ambito);
	}

	/**
	* Caches the ambitos in the entity cache if it is enabled.
	*
	* @param ambitos the ambitos
	*/
	public static void cacheResult(List<Ambito> ambitos) {
		getPersistence().cacheResult(ambitos);
	}

	/**
	* Creates a new ambito with the primary key. Does not add the ambito to the database.
	*
	* @param assScopeId the primary key for the new ambito
	* @return the new ambito
	*/
	public static Ambito create(java.lang.String assScopeId) {
		return getPersistence().create(assScopeId);
	}

	/**
	* Removes the ambito with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assScopeId the primary key of the ambito
	* @return the ambito that was removed
	* @throws NoSuchAmbitoException if a ambito with the primary key could not be found
	*/
	public static Ambito remove(java.lang.String assScopeId)
		throws com.intranet.mef.assistance.exception.NoSuchAmbitoException {
		return getPersistence().remove(assScopeId);
	}

	public static Ambito updateImpl(Ambito ambito) {
		return getPersistence().updateImpl(ambito);
	}

	/**
	* Returns the ambito with the primary key or throws a {@link NoSuchAmbitoException} if it could not be found.
	*
	* @param assScopeId the primary key of the ambito
	* @return the ambito
	* @throws NoSuchAmbitoException if a ambito with the primary key could not be found
	*/
	public static Ambito findByPrimaryKey(java.lang.String assScopeId)
		throws com.intranet.mef.assistance.exception.NoSuchAmbitoException {
		return getPersistence().findByPrimaryKey(assScopeId);
	}

	/**
	* Returns the ambito with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assScopeId the primary key of the ambito
	* @return the ambito, or <code>null</code> if a ambito with the primary key could not be found
	*/
	public static Ambito fetchByPrimaryKey(java.lang.String assScopeId) {
		return getPersistence().fetchByPrimaryKey(assScopeId);
	}

	public static java.util.Map<java.io.Serializable, Ambito> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ambitos.
	*
	* @return the ambitos
	*/
	public static List<Ambito> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ambitos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @return the range of ambitos
	*/
	public static List<Ambito> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ambitos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ambitos
	*/
	public static List<Ambito> findAll(int start, int end,
		OrderByComparator<Ambito> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ambitos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ambitos
	*/
	public static List<Ambito> findAll(int start, int end,
		OrderByComparator<Ambito> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ambitos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ambitos.
	*
	* @return the number of ambitos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AmbitoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmbitoPersistence, AmbitoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AmbitoPersistence.class);
}