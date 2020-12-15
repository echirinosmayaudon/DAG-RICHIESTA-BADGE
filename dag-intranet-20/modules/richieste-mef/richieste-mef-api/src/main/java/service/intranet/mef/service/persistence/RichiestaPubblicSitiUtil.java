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

import service.intranet.mef.model.RichiestaPubblicSiti;

import java.util.List;

/**
 * The persistence utility for the richiesta pubblic siti service. This utility wraps {@link service.intranet.mef.service.persistence.impl.RichiestaPubblicSitiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPubblicSitiPersistence
 * @see service.intranet.mef.service.persistence.impl.RichiestaPubblicSitiPersistenceImpl
 * @generated
 */
@ProviderType
public class RichiestaPubblicSitiUtil {
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
	public static void clearCache(RichiestaPubblicSiti richiestaPubblicSiti) {
		getPersistence().clearCache(richiestaPubblicSiti);
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
	public static List<RichiestaPubblicSiti> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiestaPubblicSiti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiestaPubblicSiti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiestaPubblicSiti> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiestaPubblicSiti update(
		RichiestaPubblicSiti richiestaPubblicSiti) {
		return getPersistence().update(richiestaPubblicSiti);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiestaPubblicSiti update(
		RichiestaPubblicSiti richiestaPubblicSiti, ServiceContext serviceContext) {
		return getPersistence().update(richiestaPubblicSiti, serviceContext);
	}

	/**
	* Caches the richiesta pubblic siti in the entity cache if it is enabled.
	*
	* @param richiestaPubblicSiti the richiesta pubblic siti
	*/
	public static void cacheResult(RichiestaPubblicSiti richiestaPubblicSiti) {
		getPersistence().cacheResult(richiestaPubblicSiti);
	}

	/**
	* Caches the richiesta pubblic sitis in the entity cache if it is enabled.
	*
	* @param richiestaPubblicSitis the richiesta pubblic sitis
	*/
	public static void cacheResult(
		List<RichiestaPubblicSiti> richiestaPubblicSitis) {
		getPersistence().cacheResult(richiestaPubblicSitis);
	}

	/**
	* Creates a new richiesta pubblic siti with the primary key. Does not add the richiesta pubblic siti to the database.
	*
	* @param id_rich_pubblic the primary key for the new richiesta pubblic siti
	* @return the new richiesta pubblic siti
	*/
	public static RichiestaPubblicSiti create(long id_rich_pubblic) {
		return getPersistence().create(id_rich_pubblic);
	}

	/**
	* Removes the richiesta pubblic siti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti that was removed
	* @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	*/
	public static RichiestaPubblicSiti remove(long id_rich_pubblic)
		throws service.intranet.mef.exception.NoSuchRichiestaPubblicSitiException {
		return getPersistence().remove(id_rich_pubblic);
	}

	public static RichiestaPubblicSiti updateImpl(
		RichiestaPubblicSiti richiestaPubblicSiti) {
		return getPersistence().updateImpl(richiestaPubblicSiti);
	}

	/**
	* Returns the richiesta pubblic siti with the primary key or throws a {@link NoSuchRichiestaPubblicSitiException} if it could not be found.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti
	* @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	*/
	public static RichiestaPubblicSiti findByPrimaryKey(long id_rich_pubblic)
		throws service.intranet.mef.exception.NoSuchRichiestaPubblicSitiException {
		return getPersistence().findByPrimaryKey(id_rich_pubblic);
	}

	/**
	* Returns the richiesta pubblic siti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti, or <code>null</code> if a richiesta pubblic siti with the primary key could not be found
	*/
	public static RichiestaPubblicSiti fetchByPrimaryKey(long id_rich_pubblic) {
		return getPersistence().fetchByPrimaryKey(id_rich_pubblic);
	}

	public static java.util.Map<java.io.Serializable, RichiestaPubblicSiti> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richiesta pubblic sitis.
	*
	* @return the richiesta pubblic sitis
	*/
	public static List<RichiestaPubblicSiti> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richiesta pubblic sitis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta pubblic sitis
	* @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	* @return the range of richiesta pubblic sitis
	*/
	public static List<RichiestaPubblicSiti> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richiesta pubblic sitis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta pubblic sitis
	* @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richiesta pubblic sitis
	*/
	public static List<RichiestaPubblicSiti> findAll(int start, int end,
		OrderByComparator<RichiestaPubblicSiti> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta pubblic sitis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta pubblic sitis
	* @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richiesta pubblic sitis
	*/
	public static List<RichiestaPubblicSiti> findAll(int start, int end,
		OrderByComparator<RichiestaPubblicSiti> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richiesta pubblic sitis from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richiesta pubblic sitis.
	*
	* @return the number of richiesta pubblic sitis
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RichiestaPubblicSitiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaPubblicSitiPersistence, RichiestaPubblicSitiPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaPubblicSitiPersistence.class);
}