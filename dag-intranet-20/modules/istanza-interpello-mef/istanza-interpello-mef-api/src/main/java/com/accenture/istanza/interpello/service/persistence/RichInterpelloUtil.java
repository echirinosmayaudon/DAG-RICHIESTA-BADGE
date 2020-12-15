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

package com.accenture.istanza.interpello.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.accenture.istanza.interpello.model.RichInterpello;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the rich interpello service. This utility wraps {@link com.accenture.istanza.interpello.service.persistence.impl.RichInterpelloPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichInterpelloPersistence
 * @see com.accenture.istanza.interpello.service.persistence.impl.RichInterpelloPersistenceImpl
 * @generated
 */
@ProviderType
public class RichInterpelloUtil {
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
	public static void clearCache(RichInterpello richInterpello) {
		getPersistence().clearCache(richInterpello);
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
	public static List<RichInterpello> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichInterpello> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichInterpello> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichInterpello> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichInterpello update(RichInterpello richInterpello) {
		return getPersistence().update(richInterpello);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichInterpello update(RichInterpello richInterpello,
		ServiceContext serviceContext) {
		return getPersistence().update(richInterpello, serviceContext);
	}

	/**
	* Returns all the rich interpellos where screename = &#63;.
	*
	* @param screename the screename
	* @return the matching rich interpellos
	*/
	public static List<RichInterpello> findByscreename(String screename) {
		return getPersistence().findByscreename(screename);
	}

	/**
	* Returns a range of all the rich interpellos where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @return the range of matching rich interpellos
	*/
	public static List<RichInterpello> findByscreename(String screename,
		int start, int end) {
		return getPersistence().findByscreename(screename, start, end);
	}

	/**
	* Returns an ordered range of all the rich interpellos where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rich interpellos
	*/
	public static List<RichInterpello> findByscreename(String screename,
		int start, int end, OrderByComparator<RichInterpello> orderByComparator) {
		return getPersistence()
				   .findByscreename(screename, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the rich interpellos where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rich interpellos
	*/
	public static List<RichInterpello> findByscreename(String screename,
		int start, int end,
		OrderByComparator<RichInterpello> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByscreename(screename, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich interpello
	* @throws NoSuchRichInterpelloException if a matching rich interpello could not be found
	*/
	public static RichInterpello findByscreename_First(String screename,
		OrderByComparator<RichInterpello> orderByComparator)
		throws com.accenture.istanza.interpello.exception.NoSuchRichInterpelloException {
		return getPersistence()
				   .findByscreename_First(screename, orderByComparator);
	}

	/**
	* Returns the first rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich interpello, or <code>null</code> if a matching rich interpello could not be found
	*/
	public static RichInterpello fetchByscreename_First(String screename,
		OrderByComparator<RichInterpello> orderByComparator) {
		return getPersistence()
				   .fetchByscreename_First(screename, orderByComparator);
	}

	/**
	* Returns the last rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich interpello
	* @throws NoSuchRichInterpelloException if a matching rich interpello could not be found
	*/
	public static RichInterpello findByscreename_Last(String screename,
		OrderByComparator<RichInterpello> orderByComparator)
		throws com.accenture.istanza.interpello.exception.NoSuchRichInterpelloException {
		return getPersistence()
				   .findByscreename_Last(screename, orderByComparator);
	}

	/**
	* Returns the last rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich interpello, or <code>null</code> if a matching rich interpello could not be found
	*/
	public static RichInterpello fetchByscreename_Last(String screename,
		OrderByComparator<RichInterpello> orderByComparator) {
		return getPersistence()
				   .fetchByscreename_Last(screename, orderByComparator);
	}

	/**
	* Returns the rich interpellos before and after the current rich interpello in the ordered set where screename = &#63;.
	*
	* @param id the primary key of the current rich interpello
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rich interpello
	* @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	*/
	public static RichInterpello[] findByscreename_PrevAndNext(long id,
		String screename, OrderByComparator<RichInterpello> orderByComparator)
		throws com.accenture.istanza.interpello.exception.NoSuchRichInterpelloException {
		return getPersistence()
				   .findByscreename_PrevAndNext(id, screename, orderByComparator);
	}

	/**
	* Removes all the rich interpellos where screename = &#63; from the database.
	*
	* @param screename the screename
	*/
	public static void removeByscreename(String screename) {
		getPersistence().removeByscreename(screename);
	}

	/**
	* Returns the number of rich interpellos where screename = &#63;.
	*
	* @param screename the screename
	* @return the number of matching rich interpellos
	*/
	public static int countByscreename(String screename) {
		return getPersistence().countByscreename(screename);
	}

	/**
	* Caches the rich interpello in the entity cache if it is enabled.
	*
	* @param richInterpello the rich interpello
	*/
	public static void cacheResult(RichInterpello richInterpello) {
		getPersistence().cacheResult(richInterpello);
	}

	/**
	* Caches the rich interpellos in the entity cache if it is enabled.
	*
	* @param richInterpellos the rich interpellos
	*/
	public static void cacheResult(List<RichInterpello> richInterpellos) {
		getPersistence().cacheResult(richInterpellos);
	}

	/**
	* Creates a new rich interpello with the primary key. Does not add the rich interpello to the database.
	*
	* @param id the primary key for the new rich interpello
	* @return the new rich interpello
	*/
	public static RichInterpello create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the rich interpello with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello that was removed
	* @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	*/
	public static RichInterpello remove(long id)
		throws com.accenture.istanza.interpello.exception.NoSuchRichInterpelloException {
		return getPersistence().remove(id);
	}

	public static RichInterpello updateImpl(RichInterpello richInterpello) {
		return getPersistence().updateImpl(richInterpello);
	}

	/**
	* Returns the rich interpello with the primary key or throws a {@link NoSuchRichInterpelloException} if it could not be found.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello
	* @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	*/
	public static RichInterpello findByPrimaryKey(long id)
		throws com.accenture.istanza.interpello.exception.NoSuchRichInterpelloException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the rich interpello with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello, or <code>null</code> if a rich interpello with the primary key could not be found
	*/
	public static RichInterpello fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, RichInterpello> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the rich interpellos.
	*
	* @return the rich interpellos
	*/
	public static List<RichInterpello> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the rich interpellos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @return the range of rich interpellos
	*/
	public static List<RichInterpello> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rich interpellos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rich interpellos
	*/
	public static List<RichInterpello> findAll(int start, int end,
		OrderByComparator<RichInterpello> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the rich interpellos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of rich interpellos
	*/
	public static List<RichInterpello> findAll(int start, int end,
		OrderByComparator<RichInterpello> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the rich interpellos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rich interpellos.
	*
	* @return the number of rich interpellos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RichInterpelloPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichInterpelloPersistence, RichInterpelloPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RichInterpelloPersistence.class);

		ServiceTracker<RichInterpelloPersistence, RichInterpelloPersistence> serviceTracker =
			new ServiceTracker<RichInterpelloPersistence, RichInterpelloPersistence>(bundle.getBundleContext(),
				RichInterpelloPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}