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

package mef.email.configurator.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import mef.email.configurator.model.AppNames;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the app names service. This utility wraps {@link mef.email.configurator.service.persistence.impl.AppNamesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppNamesPersistence
 * @see mef.email.configurator.service.persistence.impl.AppNamesPersistenceImpl
 * @generated
 */
@ProviderType
public class AppNamesUtil {
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
	public static void clearCache(AppNames appNames) {
		getPersistence().clearCache(appNames);
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
	public static List<AppNames> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppNames> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppNames> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppNames> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppNames update(AppNames appNames) {
		return getPersistence().update(appNames);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppNames update(AppNames appNames,
		ServiceContext serviceContext) {
		return getPersistence().update(appNames, serviceContext);
	}

	/**
	* Returns all the app nameses where appname = &#63;.
	*
	* @param appname the appname
	* @return the matching app nameses
	*/
	public static List<AppNames> findByAppname(java.lang.String appname) {
		return getPersistence().findByAppname(appname);
	}

	/**
	* Returns a range of all the app nameses where appname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appname the appname
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @return the range of matching app nameses
	*/
	public static List<AppNames> findByAppname(java.lang.String appname,
		int start, int end) {
		return getPersistence().findByAppname(appname, start, end);
	}

	/**
	* Returns an ordered range of all the app nameses where appname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appname the appname
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching app nameses
	*/
	public static List<AppNames> findByAppname(java.lang.String appname,
		int start, int end, OrderByComparator<AppNames> orderByComparator) {
		return getPersistence()
				   .findByAppname(appname, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the app nameses where appname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appname the appname
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching app nameses
	*/
	public static List<AppNames> findByAppname(java.lang.String appname,
		int start, int end, OrderByComparator<AppNames> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAppname(appname, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public static AppNames findByAppname_First(java.lang.String appname,
		OrderByComparator<AppNames> orderByComparator)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence().findByAppname_First(appname, orderByComparator);
	}

	/**
	* Returns the first app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public static AppNames fetchByAppname_First(java.lang.String appname,
		OrderByComparator<AppNames> orderByComparator) {
		return getPersistence().fetchByAppname_First(appname, orderByComparator);
	}

	/**
	* Returns the last app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public static AppNames findByAppname_Last(java.lang.String appname,
		OrderByComparator<AppNames> orderByComparator)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence().findByAppname_Last(appname, orderByComparator);
	}

	/**
	* Returns the last app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public static AppNames fetchByAppname_Last(java.lang.String appname,
		OrderByComparator<AppNames> orderByComparator) {
		return getPersistence().fetchByAppname_Last(appname, orderByComparator);
	}

	/**
	* Returns the app nameses before and after the current app names in the ordered set where appname = &#63;.
	*
	* @param id the primary key of the current app names
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app names
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public static AppNames[] findByAppname_PrevAndNext(long id,
		java.lang.String appname, OrderByComparator<AppNames> orderByComparator)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence()
				   .findByAppname_PrevAndNext(id, appname, orderByComparator);
	}

	/**
	* Removes all the app nameses where appname = &#63; from the database.
	*
	* @param appname the appname
	*/
	public static void removeByAppname(java.lang.String appname) {
		getPersistence().removeByAppname(appname);
	}

	/**
	* Returns the number of app nameses where appname = &#63;.
	*
	* @param appname the appname
	* @return the number of matching app nameses
	*/
	public static int countByAppname(java.lang.String appname) {
		return getPersistence().countByAppname(appname);
	}

	/**
	* Returns all the app nameses where appid = &#63;.
	*
	* @param appid the appid
	* @return the matching app nameses
	*/
	public static List<AppNames> findByAppId(long appid) {
		return getPersistence().findByAppId(appid);
	}

	/**
	* Returns a range of all the app nameses where appid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @return the range of matching app nameses
	*/
	public static List<AppNames> findByAppId(long appid, int start, int end) {
		return getPersistence().findByAppId(appid, start, end);
	}

	/**
	* Returns an ordered range of all the app nameses where appid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching app nameses
	*/
	public static List<AppNames> findByAppId(long appid, int start, int end,
		OrderByComparator<AppNames> orderByComparator) {
		return getPersistence().findByAppId(appid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the app nameses where appid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching app nameses
	*/
	public static List<AppNames> findByAppId(long appid, int start, int end,
		OrderByComparator<AppNames> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByAppId(appid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public static AppNames findByAppId_First(long appid,
		OrderByComparator<AppNames> orderByComparator)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence().findByAppId_First(appid, orderByComparator);
	}

	/**
	* Returns the first app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public static AppNames fetchByAppId_First(long appid,
		OrderByComparator<AppNames> orderByComparator) {
		return getPersistence().fetchByAppId_First(appid, orderByComparator);
	}

	/**
	* Returns the last app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public static AppNames findByAppId_Last(long appid,
		OrderByComparator<AppNames> orderByComparator)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence().findByAppId_Last(appid, orderByComparator);
	}

	/**
	* Returns the last app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public static AppNames fetchByAppId_Last(long appid,
		OrderByComparator<AppNames> orderByComparator) {
		return getPersistence().fetchByAppId_Last(appid, orderByComparator);
	}

	/**
	* Returns the app nameses before and after the current app names in the ordered set where appid = &#63;.
	*
	* @param id the primary key of the current app names
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app names
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public static AppNames[] findByAppId_PrevAndNext(long id, long appid,
		OrderByComparator<AppNames> orderByComparator)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence()
				   .findByAppId_PrevAndNext(id, appid, orderByComparator);
	}

	/**
	* Removes all the app nameses where appid = &#63; from the database.
	*
	* @param appid the appid
	*/
	public static void removeByAppId(long appid) {
		getPersistence().removeByAppId(appid);
	}

	/**
	* Returns the number of app nameses where appid = &#63;.
	*
	* @param appid the appid
	* @return the number of matching app nameses
	*/
	public static int countByAppId(long appid) {
		return getPersistence().countByAppId(appid);
	}

	/**
	* Caches the app names in the entity cache if it is enabled.
	*
	* @param appNames the app names
	*/
	public static void cacheResult(AppNames appNames) {
		getPersistence().cacheResult(appNames);
	}

	/**
	* Caches the app nameses in the entity cache if it is enabled.
	*
	* @param appNameses the app nameses
	*/
	public static void cacheResult(List<AppNames> appNameses) {
		getPersistence().cacheResult(appNameses);
	}

	/**
	* Creates a new app names with the primary key. Does not add the app names to the database.
	*
	* @param id the primary key for the new app names
	* @return the new app names
	*/
	public static AppNames create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the app names with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the app names
	* @return the app names that was removed
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public static AppNames remove(long id)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence().remove(id);
	}

	public static AppNames updateImpl(AppNames appNames) {
		return getPersistence().updateImpl(appNames);
	}

	/**
	* Returns the app names with the primary key or throws a {@link NoSuchAppNamesException} if it could not be found.
	*
	* @param id the primary key of the app names
	* @return the app names
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public static AppNames findByPrimaryKey(long id)
		throws mef.email.configurator.exception.NoSuchAppNamesException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the app names with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the app names
	* @return the app names, or <code>null</code> if a app names with the primary key could not be found
	*/
	public static AppNames fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, AppNames> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the app nameses.
	*
	* @return the app nameses
	*/
	public static List<AppNames> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the app nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @return the range of app nameses
	*/
	public static List<AppNames> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the app nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of app nameses
	*/
	public static List<AppNames> findAll(int start, int end,
		OrderByComparator<AppNames> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the app nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of app nameses
	*/
	public static List<AppNames> findAll(int start, int end,
		OrderByComparator<AppNames> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the app nameses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of app nameses.
	*
	* @return the number of app nameses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AppNamesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppNamesPersistence, AppNamesPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AppNamesPersistence.class);
}