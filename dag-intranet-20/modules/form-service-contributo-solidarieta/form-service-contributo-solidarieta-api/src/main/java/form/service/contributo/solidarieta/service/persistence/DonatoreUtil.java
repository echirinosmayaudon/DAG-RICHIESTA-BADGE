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

package form.service.contributo.solidarieta.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import form.service.contributo.solidarieta.model.Donatore;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the donatore service. This utility wraps <code>form.service.contributo.solidarieta.service.persistence.impl.DonatorePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonatorePersistence
 * @generated
 */
public class DonatoreUtil {

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
	public static void clearCache(Donatore donatore) {
		getPersistence().clearCache(donatore);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Donatore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Donatore> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Donatore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Donatore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Donatore> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Donatore update(Donatore donatore) {
		return getPersistence().update(donatore);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Donatore update(
		Donatore donatore, ServiceContext serviceContext) {

		return getPersistence().update(donatore, serviceContext);
	}

	/**
	 * Caches the donatore in the entity cache if it is enabled.
	 *
	 * @param donatore the donatore
	 */
	public static void cacheResult(Donatore donatore) {
		getPersistence().cacheResult(donatore);
	}

	/**
	 * Caches the donatores in the entity cache if it is enabled.
	 *
	 * @param donatores the donatores
	 */
	public static void cacheResult(List<Donatore> donatores) {
		getPersistence().cacheResult(donatores);
	}

	/**
	 * Creates a new donatore with the primary key. Does not add the donatore to the database.
	 *
	 * @param id the primary key for the new donatore
	 * @return the new donatore
	 */
	public static Donatore create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the donatore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore that was removed
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	public static Donatore remove(long id)
		throws form.service.contributo.solidarieta.exception.
			NoSuchDonatoreException {

		return getPersistence().remove(id);
	}

	public static Donatore updateImpl(Donatore donatore) {
		return getPersistence().updateImpl(donatore);
	}

	/**
	 * Returns the donatore with the primary key or throws a <code>NoSuchDonatoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	public static Donatore findByPrimaryKey(long id)
		throws form.service.contributo.solidarieta.exception.
			NoSuchDonatoreException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the donatore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore, or <code>null</code> if a donatore with the primary key could not be found
	 */
	public static Donatore fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the donatores.
	 *
	 * @return the donatores
	 */
	public static List<Donatore> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @return the range of donatores
	 */
	public static List<Donatore> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of donatores
	 */
	public static List<Donatore> findAll(
		int start, int end, OrderByComparator<Donatore> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of donatores
	 */
	public static List<Donatore> findAll(
		int start, int end, OrderByComparator<Donatore> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the donatores from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of donatores.
	 *
	 * @return the number of donatores
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DonatorePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DonatorePersistence, DonatorePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DonatorePersistence.class);

		ServiceTracker<DonatorePersistence, DonatorePersistence>
			serviceTracker =
				new ServiceTracker<DonatorePersistence, DonatorePersistence>(
					bundle.getBundleContext(), DonatorePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}