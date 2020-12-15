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

import servizio.beni.facile.consumo.model.Stato;

import java.util.List;

/**
 * The persistence utility for the stato service. This utility wraps {@link servizio.beni.facile.consumo.service.persistence.impl.StatoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoPersistence
 * @see servizio.beni.facile.consumo.service.persistence.impl.StatoPersistenceImpl
 * @generated
 */
@ProviderType
public class StatoUtil {
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
	public static void clearCache(Stato stato) {
		getPersistence().clearCache(stato);
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
	public static List<Stato> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Stato> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Stato> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Stato> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Stato update(Stato stato) {
		return getPersistence().update(stato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Stato update(Stato stato, ServiceContext serviceContext) {
		return getPersistence().update(stato, serviceContext);
	}

	/**
	* Caches the stato in the entity cache if it is enabled.
	*
	* @param stato the stato
	*/
	public static void cacheResult(Stato stato) {
		getPersistence().cacheResult(stato);
	}

	/**
	* Caches the statos in the entity cache if it is enabled.
	*
	* @param statos the statos
	*/
	public static void cacheResult(List<Stato> statos) {
		getPersistence().cacheResult(statos);
	}

	/**
	* Creates a new stato with the primary key. Does not add the stato to the database.
	*
	* @param id the primary key for the new stato
	* @return the new stato
	*/
	public static Stato create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the stato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stato
	* @return the stato that was removed
	* @throws NoSuchStatoException if a stato with the primary key could not be found
	*/
	public static Stato remove(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchStatoException {
		return getPersistence().remove(id);
	}

	public static Stato updateImpl(Stato stato) {
		return getPersistence().updateImpl(stato);
	}

	/**
	* Returns the stato with the primary key or throws a {@link NoSuchStatoException} if it could not be found.
	*
	* @param id the primary key of the stato
	* @return the stato
	* @throws NoSuchStatoException if a stato with the primary key could not be found
	*/
	public static Stato findByPrimaryKey(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchStatoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the stato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stato
	* @return the stato, or <code>null</code> if a stato with the primary key could not be found
	*/
	public static Stato fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Stato> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the statos.
	*
	* @return the statos
	*/
	public static List<Stato> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statos
	* @param end the upper bound of the range of statos (not inclusive)
	* @return the range of statos
	*/
	public static List<Stato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statos
	* @param end the upper bound of the range of statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of statos
	*/
	public static List<Stato> findAll(int start, int end,
		OrderByComparator<Stato> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statos
	* @param end the upper bound of the range of statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of statos
	*/
	public static List<Stato> findAll(int start, int end,
		OrderByComparator<Stato> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the statos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of statos.
	*
	* @return the number of statos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static StatoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatoPersistence, StatoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StatoPersistence.class);
}