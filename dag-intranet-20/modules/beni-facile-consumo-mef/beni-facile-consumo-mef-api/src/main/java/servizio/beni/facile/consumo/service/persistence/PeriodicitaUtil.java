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

package servizio.beni.facile.consumo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.beni.facile.consumo.model.Periodicita;

import java.util.List;

/**
 * The persistence utility for the periodicita service. This utility wraps {@link servizio.beni.facile.consumo.service.persistence.impl.PeriodicitaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PeriodicitaPersistence
 * @see servizio.beni.facile.consumo.service.persistence.impl.PeriodicitaPersistenceImpl
 * @generated
 */
@ProviderType
public class PeriodicitaUtil {
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
	public static void clearCache(Periodicita periodicita) {
		getPersistence().clearCache(periodicita);
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
	public static List<Periodicita> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Periodicita> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Periodicita> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Periodicita> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Periodicita update(Periodicita periodicita) {
		return getPersistence().update(periodicita);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Periodicita update(Periodicita periodicita,
		ServiceContext serviceContext) {
		return getPersistence().update(periodicita, serviceContext);
	}

	/**
	* Caches the periodicita in the entity cache if it is enabled.
	*
	* @param periodicita the periodicita
	*/
	public static void cacheResult(Periodicita periodicita) {
		getPersistence().cacheResult(periodicita);
	}

	/**
	* Caches the periodicitas in the entity cache if it is enabled.
	*
	* @param periodicitas the periodicitas
	*/
	public static void cacheResult(List<Periodicita> periodicitas) {
		getPersistence().cacheResult(periodicitas);
	}

	/**
	* Creates a new periodicita with the primary key. Does not add the periodicita to the database.
	*
	* @param id the primary key for the new periodicita
	* @return the new periodicita
	*/
	public static Periodicita create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the periodicita with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita that was removed
	* @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	*/
	public static Periodicita remove(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchPeriodicitaException {
		return getPersistence().remove(id);
	}

	public static Periodicita updateImpl(Periodicita periodicita) {
		return getPersistence().updateImpl(periodicita);
	}

	/**
	* Returns the periodicita with the primary key or throws a {@link NoSuchPeriodicitaException} if it could not be found.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita
	* @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	*/
	public static Periodicita findByPrimaryKey(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchPeriodicitaException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the periodicita with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita, or <code>null</code> if a periodicita with the primary key could not be found
	*/
	public static Periodicita fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Periodicita> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the periodicitas.
	*
	* @return the periodicitas
	*/
	public static List<Periodicita> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the periodicitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periodicitas
	* @param end the upper bound of the range of periodicitas (not inclusive)
	* @return the range of periodicitas
	*/
	public static List<Periodicita> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the periodicitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periodicitas
	* @param end the upper bound of the range of periodicitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of periodicitas
	*/
	public static List<Periodicita> findAll(int start, int end,
		OrderByComparator<Periodicita> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the periodicitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periodicitas
	* @param end the upper bound of the range of periodicitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of periodicitas
	*/
	public static List<Periodicita> findAll(int start, int end,
		OrderByComparator<Periodicita> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the periodicitas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of periodicitas.
	*
	* @return the number of periodicitas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PeriodicitaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PeriodicitaPersistence, PeriodicitaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PeriodicitaPersistence.class);
}