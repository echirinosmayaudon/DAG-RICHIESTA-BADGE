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

import service.intranet.mef.model.TipologiaComputer;

import java.util.List;

/**
 * The persistence utility for the tipologia computer service. This utility wraps {@link service.intranet.mef.service.persistence.impl.TipologiaComputerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComputerPersistence
 * @see service.intranet.mef.service.persistence.impl.TipologiaComputerPersistenceImpl
 * @generated
 */
@ProviderType
public class TipologiaComputerUtil {
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
	public static void clearCache(TipologiaComputer tipologiaComputer) {
		getPersistence().clearCache(tipologiaComputer);
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
	public static List<TipologiaComputer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipologiaComputer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipologiaComputer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipologiaComputer> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipologiaComputer update(TipologiaComputer tipologiaComputer) {
		return getPersistence().update(tipologiaComputer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipologiaComputer update(
		TipologiaComputer tipologiaComputer, ServiceContext serviceContext) {
		return getPersistence().update(tipologiaComputer, serviceContext);
	}

	/**
	* Caches the tipologia computer in the entity cache if it is enabled.
	*
	* @param tipologiaComputer the tipologia computer
	*/
	public static void cacheResult(TipologiaComputer tipologiaComputer) {
		getPersistence().cacheResult(tipologiaComputer);
	}

	/**
	* Caches the tipologia computers in the entity cache if it is enabled.
	*
	* @param tipologiaComputers the tipologia computers
	*/
	public static void cacheResult(List<TipologiaComputer> tipologiaComputers) {
		getPersistence().cacheResult(tipologiaComputers);
	}

	/**
	* Creates a new tipologia computer with the primary key. Does not add the tipologia computer to the database.
	*
	* @param id_tipologia_computer the primary key for the new tipologia computer
	* @return the new tipologia computer
	*/
	public static TipologiaComputer create(long id_tipologia_computer) {
		return getPersistence().create(id_tipologia_computer);
	}

	/**
	* Removes the tipologia computer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer that was removed
	* @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	*/
	public static TipologiaComputer remove(long id_tipologia_computer)
		throws service.intranet.mef.exception.NoSuchTipologiaComputerException {
		return getPersistence().remove(id_tipologia_computer);
	}

	public static TipologiaComputer updateImpl(
		TipologiaComputer tipologiaComputer) {
		return getPersistence().updateImpl(tipologiaComputer);
	}

	/**
	* Returns the tipologia computer with the primary key or throws a {@link NoSuchTipologiaComputerException} if it could not be found.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer
	* @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	*/
	public static TipologiaComputer findByPrimaryKey(long id_tipologia_computer)
		throws service.intranet.mef.exception.NoSuchTipologiaComputerException {
		return getPersistence().findByPrimaryKey(id_tipologia_computer);
	}

	/**
	* Returns the tipologia computer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer, or <code>null</code> if a tipologia computer with the primary key could not be found
	*/
	public static TipologiaComputer fetchByPrimaryKey(
		long id_tipologia_computer) {
		return getPersistence().fetchByPrimaryKey(id_tipologia_computer);
	}

	public static java.util.Map<java.io.Serializable, TipologiaComputer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tipologia computers.
	*
	* @return the tipologia computers
	*/
	public static List<TipologiaComputer> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tipologia computers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia computers
	* @param end the upper bound of the range of tipologia computers (not inclusive)
	* @return the range of tipologia computers
	*/
	public static List<TipologiaComputer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipologia computers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia computers
	* @param end the upper bound of the range of tipologia computers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipologia computers
	*/
	public static List<TipologiaComputer> findAll(int start, int end,
		OrderByComparator<TipologiaComputer> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tipologia computers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia computers
	* @param end the upper bound of the range of tipologia computers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipologia computers
	*/
	public static List<TipologiaComputer> findAll(int start, int end,
		OrderByComparator<TipologiaComputer> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tipologia computers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipologia computers.
	*
	* @return the number of tipologia computers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipologiaComputerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipologiaComputerPersistence, TipologiaComputerPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipologiaComputerPersistence.class);
}