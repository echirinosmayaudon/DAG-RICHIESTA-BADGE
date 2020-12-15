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

package service.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import service.intranet.mef.model.RichiesteUtenza;

import java.util.List;

/**
 * The persistence utility for the richieste utenza service. This utility wraps {@link service.intranet.mef.service.persistence.impl.RichiesteUtenzaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteUtenzaPersistence
 * @see service.intranet.mef.service.persistence.impl.RichiesteUtenzaPersistenceImpl
 * @generated
 */
@ProviderType
public class RichiesteUtenzaUtil {
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
	public static void clearCache(RichiesteUtenza richiesteUtenza) {
		getPersistence().clearCache(richiesteUtenza);
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
	public static List<RichiesteUtenza> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiesteUtenza> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiesteUtenza> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiesteUtenza> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiesteUtenza update(RichiesteUtenza richiesteUtenza) {
		return getPersistence().update(richiesteUtenza);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiesteUtenza update(RichiesteUtenza richiesteUtenza,
		ServiceContext serviceContext) {
		return getPersistence().update(richiesteUtenza, serviceContext);
	}

	/**
	* Caches the richieste utenza in the entity cache if it is enabled.
	*
	* @param richiesteUtenza the richieste utenza
	*/
	public static void cacheResult(RichiesteUtenza richiesteUtenza) {
		getPersistence().cacheResult(richiesteUtenza);
	}

	/**
	* Caches the richieste utenzas in the entity cache if it is enabled.
	*
	* @param richiesteUtenzas the richieste utenzas
	*/
	public static void cacheResult(List<RichiesteUtenza> richiesteUtenzas) {
		getPersistence().cacheResult(richiesteUtenzas);
	}

	/**
	* Creates a new richieste utenza with the primary key. Does not add the richieste utenza to the database.
	*
	* @param id_richieste_utenza the primary key for the new richieste utenza
	* @return the new richieste utenza
	*/
	public static RichiesteUtenza create(long id_richieste_utenza) {
		return getPersistence().create(id_richieste_utenza);
	}

	/**
	* Removes the richieste utenza with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richieste_utenza the primary key of the richieste utenza
	* @return the richieste utenza that was removed
	* @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	*/
	public static RichiesteUtenza remove(long id_richieste_utenza)
		throws service.intranet.mef.exception.NoSuchRichiesteUtenzaException {
		return getPersistence().remove(id_richieste_utenza);
	}

	public static RichiesteUtenza updateImpl(RichiesteUtenza richiesteUtenza) {
		return getPersistence().updateImpl(richiesteUtenza);
	}

	/**
	* Returns the richieste utenza with the primary key or throws a {@link NoSuchRichiesteUtenzaException} if it could not be found.
	*
	* @param id_richieste_utenza the primary key of the richieste utenza
	* @return the richieste utenza
	* @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	*/
	public static RichiesteUtenza findByPrimaryKey(long id_richieste_utenza)
		throws service.intranet.mef.exception.NoSuchRichiesteUtenzaException {
		return getPersistence().findByPrimaryKey(id_richieste_utenza);
	}

	/**
	* Returns the richieste utenza with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_richieste_utenza the primary key of the richieste utenza
	* @return the richieste utenza, or <code>null</code> if a richieste utenza with the primary key could not be found
	*/
	public static RichiesteUtenza fetchByPrimaryKey(long id_richieste_utenza) {
		return getPersistence().fetchByPrimaryKey(id_richieste_utenza);
	}

	public static java.util.Map<java.io.Serializable, RichiesteUtenza> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richieste utenzas.
	*
	* @return the richieste utenzas
	*/
	public static List<RichiesteUtenza> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richieste utenzas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste utenzas
	* @param end the upper bound of the range of richieste utenzas (not inclusive)
	* @return the range of richieste utenzas
	*/
	public static List<RichiesteUtenza> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richieste utenzas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste utenzas
	* @param end the upper bound of the range of richieste utenzas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste utenzas
	*/
	public static List<RichiesteUtenza> findAll(int start, int end,
		OrderByComparator<RichiesteUtenza> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richieste utenzas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste utenzas
	* @param end the upper bound of the range of richieste utenzas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste utenzas
	*/
	public static List<RichiesteUtenza> findAll(int start, int end,
		OrderByComparator<RichiesteUtenza> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richieste utenzas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richieste utenzas.
	*
	* @return the number of richieste utenzas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RichiesteUtenzaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiesteUtenzaPersistence, RichiesteUtenzaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiesteUtenzaPersistence.class);
}