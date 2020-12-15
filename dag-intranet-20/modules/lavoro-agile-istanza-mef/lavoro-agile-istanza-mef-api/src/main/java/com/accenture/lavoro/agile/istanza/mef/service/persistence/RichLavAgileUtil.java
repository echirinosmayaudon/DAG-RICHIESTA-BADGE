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

package com.accenture.lavoro.agile.istanza.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the rich lav agile service. This utility wraps {@link com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.RichLavAgilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichLavAgilePersistence
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.RichLavAgilePersistenceImpl
 * @generated
 */
@ProviderType
public class RichLavAgileUtil {
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
	public static void clearCache(RichLavAgile richLavAgile) {
		getPersistence().clearCache(richLavAgile);
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
	public static List<RichLavAgile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichLavAgile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichLavAgile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichLavAgile> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichLavAgile update(RichLavAgile richLavAgile) {
		return getPersistence().update(richLavAgile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichLavAgile update(RichLavAgile richLavAgile,
		ServiceContext serviceContext) {
		return getPersistence().update(richLavAgile, serviceContext);
	}

	/**
	* Returns all the rich lav agiles where screename = &#63;.
	*
	* @param screename the screename
	* @return the matching rich lav agiles
	*/
	public static List<RichLavAgile> findByscreename(String screename) {
		return getPersistence().findByscreename(screename);
	}

	/**
	* Returns a range of all the rich lav agiles where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @return the range of matching rich lav agiles
	*/
	public static List<RichLavAgile> findByscreename(String screename,
		int start, int end) {
		return getPersistence().findByscreename(screename, start, end);
	}

	/**
	* Returns an ordered range of all the rich lav agiles where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rich lav agiles
	*/
	public static List<RichLavAgile> findByscreename(String screename,
		int start, int end, OrderByComparator<RichLavAgile> orderByComparator) {
		return getPersistence()
				   .findByscreename(screename, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the rich lav agiles where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rich lav agiles
	*/
	public static List<RichLavAgile> findByscreename(String screename,
		int start, int end, OrderByComparator<RichLavAgile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByscreename(screename, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich lav agile
	* @throws NoSuchRichLavAgileException if a matching rich lav agile could not be found
	*/
	public static RichLavAgile findByscreename_First(String screename,
		OrderByComparator<RichLavAgile> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchRichLavAgileException {
		return getPersistence()
				   .findByscreename_First(screename, orderByComparator);
	}

	/**
	* Returns the first rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich lav agile, or <code>null</code> if a matching rich lav agile could not be found
	*/
	public static RichLavAgile fetchByscreename_First(String screename,
		OrderByComparator<RichLavAgile> orderByComparator) {
		return getPersistence()
				   .fetchByscreename_First(screename, orderByComparator);
	}

	/**
	* Returns the last rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich lav agile
	* @throws NoSuchRichLavAgileException if a matching rich lav agile could not be found
	*/
	public static RichLavAgile findByscreename_Last(String screename,
		OrderByComparator<RichLavAgile> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchRichLavAgileException {
		return getPersistence()
				   .findByscreename_Last(screename, orderByComparator);
	}

	/**
	* Returns the last rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich lav agile, or <code>null</code> if a matching rich lav agile could not be found
	*/
	public static RichLavAgile fetchByscreename_Last(String screename,
		OrderByComparator<RichLavAgile> orderByComparator) {
		return getPersistence()
				   .fetchByscreename_Last(screename, orderByComparator);
	}

	/**
	* Returns the rich lav agiles before and after the current rich lav agile in the ordered set where screename = &#63;.
	*
	* @param id the primary key of the current rich lav agile
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rich lav agile
	* @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	*/
	public static RichLavAgile[] findByscreename_PrevAndNext(long id,
		String screename, OrderByComparator<RichLavAgile> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchRichLavAgileException {
		return getPersistence()
				   .findByscreename_PrevAndNext(id, screename, orderByComparator);
	}

	/**
	* Removes all the rich lav agiles where screename = &#63; from the database.
	*
	* @param screename the screename
	*/
	public static void removeByscreename(String screename) {
		getPersistence().removeByscreename(screename);
	}

	/**
	* Returns the number of rich lav agiles where screename = &#63;.
	*
	* @param screename the screename
	* @return the number of matching rich lav agiles
	*/
	public static int countByscreename(String screename) {
		return getPersistence().countByscreename(screename);
	}

	/**
	* Caches the rich lav agile in the entity cache if it is enabled.
	*
	* @param richLavAgile the rich lav agile
	*/
	public static void cacheResult(RichLavAgile richLavAgile) {
		getPersistence().cacheResult(richLavAgile);
	}

	/**
	* Caches the rich lav agiles in the entity cache if it is enabled.
	*
	* @param richLavAgiles the rich lav agiles
	*/
	public static void cacheResult(List<RichLavAgile> richLavAgiles) {
		getPersistence().cacheResult(richLavAgiles);
	}

	/**
	* Creates a new rich lav agile with the primary key. Does not add the rich lav agile to the database.
	*
	* @param id the primary key for the new rich lav agile
	* @return the new rich lav agile
	*/
	public static RichLavAgile create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the rich lav agile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile that was removed
	* @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	*/
	public static RichLavAgile remove(long id)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchRichLavAgileException {
		return getPersistence().remove(id);
	}

	public static RichLavAgile updateImpl(RichLavAgile richLavAgile) {
		return getPersistence().updateImpl(richLavAgile);
	}

	/**
	* Returns the rich lav agile with the primary key or throws a {@link NoSuchRichLavAgileException} if it could not be found.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile
	* @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	*/
	public static RichLavAgile findByPrimaryKey(long id)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchRichLavAgileException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the rich lav agile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile, or <code>null</code> if a rich lav agile with the primary key could not be found
	*/
	public static RichLavAgile fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, RichLavAgile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the rich lav agiles.
	*
	* @return the rich lav agiles
	*/
	public static List<RichLavAgile> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the rich lav agiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @return the range of rich lav agiles
	*/
	public static List<RichLavAgile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rich lav agiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rich lav agiles
	*/
	public static List<RichLavAgile> findAll(int start, int end,
		OrderByComparator<RichLavAgile> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the rich lav agiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of rich lav agiles
	*/
	public static List<RichLavAgile> findAll(int start, int end,
		OrderByComparator<RichLavAgile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the rich lav agiles from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rich lav agiles.
	*
	* @return the number of rich lav agiles
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RichLavAgilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichLavAgilePersistence, RichLavAgilePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RichLavAgilePersistence.class);

		ServiceTracker<RichLavAgilePersistence, RichLavAgilePersistence> serviceTracker =
			new ServiceTracker<RichLavAgilePersistence, RichLavAgilePersistence>(bundle.getBundleContext(),
				RichLavAgilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}