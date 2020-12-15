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

package servizio.prenotazione.aule.servizi.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.servizi.mef.model.StrumTec;

import java.util.List;

/**
 * The persistence utility for the strum tec service. This utility wraps {@link servizio.prenotazione.aule.servizi.mef.service.persistence.impl.StrumTecPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumTecPersistence
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.impl.StrumTecPersistenceImpl
 * @generated
 */
@ProviderType
public class StrumTecUtil {
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
	public static void clearCache(StrumTec strumTec) {
		getPersistence().clearCache(strumTec);
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
	public static List<StrumTec> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StrumTec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StrumTec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StrumTec> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StrumTec update(StrumTec strumTec) {
		return getPersistence().update(strumTec);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StrumTec update(StrumTec strumTec,
		ServiceContext serviceContext) {
		return getPersistence().update(strumTec, serviceContext);
	}

	/**
	* Caches the strum tec in the entity cache if it is enabled.
	*
	* @param strumTec the strum tec
	*/
	public static void cacheResult(StrumTec strumTec) {
		getPersistence().cacheResult(strumTec);
	}

	/**
	* Caches the strum tecs in the entity cache if it is enabled.
	*
	* @param strumTecs the strum tecs
	*/
	public static void cacheResult(List<StrumTec> strumTecs) {
		getPersistence().cacheResult(strumTecs);
	}

	/**
	* Creates a new strum tec with the primary key. Does not add the strum tec to the database.
	*
	* @param strumTecPK the primary key for the new strum tec
	* @return the new strum tec
	*/
	public static StrumTec create(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK) {
		return getPersistence().create(strumTecPK);
	}

	/**
	* Removes the strum tec with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param strumTecPK the primary key of the strum tec
	* @return the strum tec that was removed
	* @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	*/
	public static StrumTec remove(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK)
		throws servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumTecException {
		return getPersistence().remove(strumTecPK);
	}

	public static StrumTec updateImpl(StrumTec strumTec) {
		return getPersistence().updateImpl(strumTec);
	}

	/**
	* Returns the strum tec with the primary key or throws a {@link NoSuchStrumTecException} if it could not be found.
	*
	* @param strumTecPK the primary key of the strum tec
	* @return the strum tec
	* @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	*/
	public static StrumTec findByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK)
		throws servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumTecException {
		return getPersistence().findByPrimaryKey(strumTecPK);
	}

	/**
	* Returns the strum tec with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param strumTecPK the primary key of the strum tec
	* @return the strum tec, or <code>null</code> if a strum tec with the primary key could not be found
	*/
	public static StrumTec fetchByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK) {
		return getPersistence().fetchByPrimaryKey(strumTecPK);
	}

	public static java.util.Map<java.io.Serializable, StrumTec> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the strum tecs.
	*
	* @return the strum tecs
	*/
	public static List<StrumTec> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the strum tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum tecs
	* @param end the upper bound of the range of strum tecs (not inclusive)
	* @return the range of strum tecs
	*/
	public static List<StrumTec> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the strum tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum tecs
	* @param end the upper bound of the range of strum tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strum tecs
	*/
	public static List<StrumTec> findAll(int start, int end,
		OrderByComparator<StrumTec> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the strum tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum tecs
	* @param end the upper bound of the range of strum tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strum tecs
	*/
	public static List<StrumTec> findAll(int start, int end,
		OrderByComparator<StrumTec> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the strum tecs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of strum tecs.
	*
	* @return the number of strum tecs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StrumTecPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StrumTecPersistence, StrumTecPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StrumTecPersistence.class);
}