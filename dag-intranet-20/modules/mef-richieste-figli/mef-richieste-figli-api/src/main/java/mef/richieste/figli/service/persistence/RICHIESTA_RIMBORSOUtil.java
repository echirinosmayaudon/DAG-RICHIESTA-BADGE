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

package mef.richieste.figli.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import mef.richieste.figli.model.RICHIESTA_RIMBORSO;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the richiesta_rimborso service. This utility wraps <code>mef.richieste.figli.service.persistence.impl.RICHIESTA_RIMBORSOPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RICHIESTA_RIMBORSOPersistence
 * @generated
 */
@ProviderType
public class RICHIESTA_RIMBORSOUtil {

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
	public static void clearCache(RICHIESTA_RIMBORSO richiesta_rimborso) {
		getPersistence().clearCache(richiesta_rimborso);
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
	public static Map<Serializable, RICHIESTA_RIMBORSO> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RICHIESTA_RIMBORSO> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RICHIESTA_RIMBORSO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RICHIESTA_RIMBORSO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RICHIESTA_RIMBORSO> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RICHIESTA_RIMBORSO update(
		RICHIESTA_RIMBORSO richiesta_rimborso) {

		return getPersistence().update(richiesta_rimborso);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RICHIESTA_RIMBORSO update(
		RICHIESTA_RIMBORSO richiesta_rimborso, ServiceContext serviceContext) {

		return getPersistence().update(richiesta_rimborso, serviceContext);
	}

	/**
	 * Caches the richiesta_rimborso in the entity cache if it is enabled.
	 *
	 * @param richiesta_rimborso the richiesta_rimborso
	 */
	public static void cacheResult(RICHIESTA_RIMBORSO richiesta_rimborso) {
		getPersistence().cacheResult(richiesta_rimborso);
	}

	/**
	 * Caches the richiesta_rimborsos in the entity cache if it is enabled.
	 *
	 * @param richiesta_rimborsos the richiesta_rimborsos
	 */
	public static void cacheResult(
		List<RICHIESTA_RIMBORSO> richiesta_rimborsos) {

		getPersistence().cacheResult(richiesta_rimborsos);
	}

	/**
	 * Creates a new richiesta_rimborso with the primary key. Does not add the richiesta_rimborso to the database.
	 *
	 * @param Id the primary key for the new richiesta_rimborso
	 * @return the new richiesta_rimborso
	 */
	public static RICHIESTA_RIMBORSO create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the richiesta_rimborso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso that was removed
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	public static RICHIESTA_RIMBORSO remove(long Id)
		throws mef.richieste.figli.exception.NoSuchRICHIESTA_RIMBORSOException {

		return getPersistence().remove(Id);
	}

	public static RICHIESTA_RIMBORSO updateImpl(
		RICHIESTA_RIMBORSO richiesta_rimborso) {

		return getPersistence().updateImpl(richiesta_rimborso);
	}

	/**
	 * Returns the richiesta_rimborso with the primary key or throws a <code>NoSuchRICHIESTA_RIMBORSOException</code> if it could not be found.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	public static RICHIESTA_RIMBORSO findByPrimaryKey(long Id)
		throws mef.richieste.figli.exception.NoSuchRICHIESTA_RIMBORSOException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the richiesta_rimborso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso, or <code>null</code> if a richiesta_rimborso with the primary key could not be found
	 */
	public static RICHIESTA_RIMBORSO fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the richiesta_rimborsos.
	 *
	 * @return the richiesta_rimborsos
	 */
	public static List<RICHIESTA_RIMBORSO> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @return the range of richiesta_rimborsos
	 */
	public static List<RICHIESTA_RIMBORSO> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta_rimborsos
	 */
	public static List<RICHIESTA_RIMBORSO> findAll(
		int start, int end,
		OrderByComparator<RICHIESTA_RIMBORSO> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiesta_rimborsos
	 */
	public static List<RICHIESTA_RIMBORSO> findAll(
		int start, int end,
		OrderByComparator<RICHIESTA_RIMBORSO> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the richiesta_rimborsos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of richiesta_rimborsos.
	 *
	 * @return the number of richiesta_rimborsos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RICHIESTA_RIMBORSOPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RICHIESTA_RIMBORSOPersistence, RICHIESTA_RIMBORSOPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RICHIESTA_RIMBORSOPersistence.class);

		ServiceTracker
			<RICHIESTA_RIMBORSOPersistence, RICHIESTA_RIMBORSOPersistence>
				serviceTracker =
					new ServiceTracker
						<RICHIESTA_RIMBORSOPersistence,
						 RICHIESTA_RIMBORSOPersistence>(
							 bundle.getBundleContext(),
							 RICHIESTA_RIMBORSOPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}