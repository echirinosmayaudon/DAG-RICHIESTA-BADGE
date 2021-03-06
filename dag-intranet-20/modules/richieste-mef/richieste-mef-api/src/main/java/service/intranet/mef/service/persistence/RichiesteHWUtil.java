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

import service.intranet.mef.model.RichiesteHW;

import java.util.List;

/**
 * The persistence utility for the richieste h w service. This utility wraps {@link service.intranet.mef.service.persistence.impl.RichiesteHWPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteHWPersistence
 * @see service.intranet.mef.service.persistence.impl.RichiesteHWPersistenceImpl
 * @generated
 */
@ProviderType
public class RichiesteHWUtil {
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
	public static void clearCache(RichiesteHW richiesteHW) {
		getPersistence().clearCache(richiesteHW);
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
	public static List<RichiesteHW> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiesteHW> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiesteHW> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiesteHW> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiesteHW update(RichiesteHW richiesteHW) {
		return getPersistence().update(richiesteHW);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiesteHW update(RichiesteHW richiesteHW,
		ServiceContext serviceContext) {
		return getPersistence().update(richiesteHW, serviceContext);
	}

	/**
	* Caches the richieste h w in the entity cache if it is enabled.
	*
	* @param richiesteHW the richieste h w
	*/
	public static void cacheResult(RichiesteHW richiesteHW) {
		getPersistence().cacheResult(richiesteHW);
	}

	/**
	* Caches the richieste h ws in the entity cache if it is enabled.
	*
	* @param richiesteHWs the richieste h ws
	*/
	public static void cacheResult(List<RichiesteHW> richiesteHWs) {
		getPersistence().cacheResult(richiesteHWs);
	}

	/**
	* Creates a new richieste h w with the primary key. Does not add the richieste h w to the database.
	*
	* @param id_richieste_hw the primary key for the new richieste h w
	* @return the new richieste h w
	*/
	public static RichiesteHW create(long id_richieste_hw) {
		return getPersistence().create(id_richieste_hw);
	}

	/**
	* Removes the richieste h w with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w that was removed
	* @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	*/
	public static RichiesteHW remove(long id_richieste_hw)
		throws service.intranet.mef.exception.NoSuchRichiesteHWException {
		return getPersistence().remove(id_richieste_hw);
	}

	public static RichiesteHW updateImpl(RichiesteHW richiesteHW) {
		return getPersistence().updateImpl(richiesteHW);
	}

	/**
	* Returns the richieste h w with the primary key or throws a {@link NoSuchRichiesteHWException} if it could not be found.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w
	* @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	*/
	public static RichiesteHW findByPrimaryKey(long id_richieste_hw)
		throws service.intranet.mef.exception.NoSuchRichiesteHWException {
		return getPersistence().findByPrimaryKey(id_richieste_hw);
	}

	/**
	* Returns the richieste h w with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w, or <code>null</code> if a richieste h w with the primary key could not be found
	*/
	public static RichiesteHW fetchByPrimaryKey(long id_richieste_hw) {
		return getPersistence().fetchByPrimaryKey(id_richieste_hw);
	}

	public static java.util.Map<java.io.Serializable, RichiesteHW> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richieste h ws.
	*
	* @return the richieste h ws
	*/
	public static List<RichiesteHW> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richieste h ws.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste h ws
	* @param end the upper bound of the range of richieste h ws (not inclusive)
	* @return the range of richieste h ws
	*/
	public static List<RichiesteHW> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richieste h ws.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste h ws
	* @param end the upper bound of the range of richieste h ws (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste h ws
	*/
	public static List<RichiesteHW> findAll(int start, int end,
		OrderByComparator<RichiesteHW> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richieste h ws.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste h ws
	* @param end the upper bound of the range of richieste h ws (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste h ws
	*/
	public static List<RichiesteHW> findAll(int start, int end,
		OrderByComparator<RichiesteHW> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richieste h ws from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richieste h ws.
	*
	* @return the number of richieste h ws
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RichiesteHWPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiesteHWPersistence, RichiesteHWPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiesteHWPersistence.class);
}