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

package mef.richiesta.gest.pos.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import mef.richiesta.gest.pos.model.Corridoio;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the corridoio service. This utility wraps <code>mef.richiesta.gest.pos.service.persistence.impl.CorridoioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CorridoioPersistence
 * @generated
 */
@ProviderType
public class CorridoioUtil {

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
	public static void clearCache(Corridoio corridoio) {
		getPersistence().clearCache(corridoio);
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
	public static Map<Serializable, Corridoio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Corridoio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Corridoio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Corridoio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Corridoio> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Corridoio update(Corridoio corridoio) {
		return getPersistence().update(corridoio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Corridoio update(
		Corridoio corridoio, ServiceContext serviceContext) {

		return getPersistence().update(corridoio, serviceContext);
	}

	/**
	 * Caches the corridoio in the entity cache if it is enabled.
	 *
	 * @param corridoio the corridoio
	 */
	public static void cacheResult(Corridoio corridoio) {
		getPersistence().cacheResult(corridoio);
	}

	/**
	 * Caches the corridoios in the entity cache if it is enabled.
	 *
	 * @param corridoios the corridoios
	 */
	public static void cacheResult(List<Corridoio> corridoios) {
		getPersistence().cacheResult(corridoios);
	}

	/**
	 * Creates a new corridoio with the primary key. Does not add the corridoio to the database.
	 *
	 * @param id_pk_corridoio the primary key for the new corridoio
	 * @return the new corridoio
	 */
	public static Corridoio create(long id_pk_corridoio) {
		return getPersistence().create(id_pk_corridoio);
	}

	/**
	 * Removes the corridoio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio that was removed
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	public static Corridoio remove(long id_pk_corridoio)
		throws mef.richiesta.gest.pos.exception.NoSuchCorridoioException {

		return getPersistence().remove(id_pk_corridoio);
	}

	public static Corridoio updateImpl(Corridoio corridoio) {
		return getPersistence().updateImpl(corridoio);
	}

	/**
	 * Returns the corridoio with the primary key or throws a <code>NoSuchCorridoioException</code> if it could not be found.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	public static Corridoio findByPrimaryKey(long id_pk_corridoio)
		throws mef.richiesta.gest.pos.exception.NoSuchCorridoioException {

		return getPersistence().findByPrimaryKey(id_pk_corridoio);
	}

	/**
	 * Returns the corridoio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio, or <code>null</code> if a corridoio with the primary key could not be found
	 */
	public static Corridoio fetchByPrimaryKey(long id_pk_corridoio) {
		return getPersistence().fetchByPrimaryKey(id_pk_corridoio);
	}

	/**
	 * Returns all the corridoios.
	 *
	 * @return the corridoios
	 */
	public static List<Corridoio> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @return the range of corridoios
	 */
	public static List<Corridoio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of corridoios
	 */
	public static List<Corridoio> findAll(
		int start, int end, OrderByComparator<Corridoio> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of corridoios
	 */
	public static List<Corridoio> findAll(
		int start, int end, OrderByComparator<Corridoio> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the corridoios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of corridoios.
	 *
	 * @return the number of corridoios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CorridoioPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CorridoioPersistence, CorridoioPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CorridoioPersistence.class);

		ServiceTracker<CorridoioPersistence, CorridoioPersistence>
			serviceTracker =
				new ServiceTracker<CorridoioPersistence, CorridoioPersistence>(
					bundle.getBundleContext(), CorridoioPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}