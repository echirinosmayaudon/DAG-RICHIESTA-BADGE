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

package servizio.prenotazione.aule.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.mef.model.Approvatore;

import java.util.List;

/**
 * The persistence utility for the approvatore service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.ApprovatorePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApprovatorePersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.ApprovatorePersistenceImpl
 * @generated
 */
@ProviderType
public class ApprovatoreUtil {
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
	public static void clearCache(Approvatore approvatore) {
		getPersistence().clearCache(approvatore);
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
	public static List<Approvatore> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Approvatore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Approvatore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Approvatore> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Approvatore update(Approvatore approvatore) {
		return getPersistence().update(approvatore);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Approvatore update(Approvatore approvatore,
		ServiceContext serviceContext) {
		return getPersistence().update(approvatore, serviceContext);
	}

	/**
	* Returns all the approvatores where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @return the matching approvatores
	*/
	public static List<Approvatore> findByIdSala(long id_sala) {
		return getPersistence().findByIdSala(id_sala);
	}

	/**
	* Returns a range of all the approvatores where id_sala = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sala the id_sala
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @return the range of matching approvatores
	*/
	public static List<Approvatore> findByIdSala(long id_sala, int start,
		int end) {
		return getPersistence().findByIdSala(id_sala, start, end);
	}

	/**
	* Returns an ordered range of all the approvatores where id_sala = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sala the id_sala
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approvatores
	*/
	public static List<Approvatore> findByIdSala(long id_sala, int start,
		int end, OrderByComparator<Approvatore> orderByComparator) {
		return getPersistence()
				   .findByIdSala(id_sala, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the approvatores where id_sala = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sala the id_sala
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching approvatores
	*/
	public static List<Approvatore> findByIdSala(long id_sala, int start,
		int end, OrderByComparator<Approvatore> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdSala(id_sala, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approvatore
	* @throws NoSuchApprovatoreException if a matching approvatore could not be found
	*/
	public static Approvatore findByIdSala_First(long id_sala,
		OrderByComparator<Approvatore> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchApprovatoreException {
		return getPersistence().findByIdSala_First(id_sala, orderByComparator);
	}

	/**
	* Returns the first approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approvatore, or <code>null</code> if a matching approvatore could not be found
	*/
	public static Approvatore fetchByIdSala_First(long id_sala,
		OrderByComparator<Approvatore> orderByComparator) {
		return getPersistence().fetchByIdSala_First(id_sala, orderByComparator);
	}

	/**
	* Returns the last approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approvatore
	* @throws NoSuchApprovatoreException if a matching approvatore could not be found
	*/
	public static Approvatore findByIdSala_Last(long id_sala,
		OrderByComparator<Approvatore> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchApprovatoreException {
		return getPersistence().findByIdSala_Last(id_sala, orderByComparator);
	}

	/**
	* Returns the last approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approvatore, or <code>null</code> if a matching approvatore could not be found
	*/
	public static Approvatore fetchByIdSala_Last(long id_sala,
		OrderByComparator<Approvatore> orderByComparator) {
		return getPersistence().fetchByIdSala_Last(id_sala, orderByComparator);
	}

	/**
	* Returns the approvatores before and after the current approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_approvatore the primary key of the current approvatore
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approvatore
	* @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	*/
	public static Approvatore[] findByIdSala_PrevAndNext(long id_approvatore,
		long id_sala, OrderByComparator<Approvatore> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchApprovatoreException {
		return getPersistence()
				   .findByIdSala_PrevAndNext(id_approvatore, id_sala,
			orderByComparator);
	}

	/**
	* Removes all the approvatores where id_sala = &#63; from the database.
	*
	* @param id_sala the id_sala
	*/
	public static void removeByIdSala(long id_sala) {
		getPersistence().removeByIdSala(id_sala);
	}

	/**
	* Returns the number of approvatores where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @return the number of matching approvatores
	*/
	public static int countByIdSala(long id_sala) {
		return getPersistence().countByIdSala(id_sala);
	}

	/**
	* Caches the approvatore in the entity cache if it is enabled.
	*
	* @param approvatore the approvatore
	*/
	public static void cacheResult(Approvatore approvatore) {
		getPersistence().cacheResult(approvatore);
	}

	/**
	* Caches the approvatores in the entity cache if it is enabled.
	*
	* @param approvatores the approvatores
	*/
	public static void cacheResult(List<Approvatore> approvatores) {
		getPersistence().cacheResult(approvatores);
	}

	/**
	* Creates a new approvatore with the primary key. Does not add the approvatore to the database.
	*
	* @param id_approvatore the primary key for the new approvatore
	* @return the new approvatore
	*/
	public static Approvatore create(long id_approvatore) {
		return getPersistence().create(id_approvatore);
	}

	/**
	* Removes the approvatore with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore that was removed
	* @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	*/
	public static Approvatore remove(long id_approvatore)
		throws servizio.prenotazione.aule.mef.exception.NoSuchApprovatoreException {
		return getPersistence().remove(id_approvatore);
	}

	public static Approvatore updateImpl(Approvatore approvatore) {
		return getPersistence().updateImpl(approvatore);
	}

	/**
	* Returns the approvatore with the primary key or throws a {@link NoSuchApprovatoreException} if it could not be found.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore
	* @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	*/
	public static Approvatore findByPrimaryKey(long id_approvatore)
		throws servizio.prenotazione.aule.mef.exception.NoSuchApprovatoreException {
		return getPersistence().findByPrimaryKey(id_approvatore);
	}

	/**
	* Returns the approvatore with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore, or <code>null</code> if a approvatore with the primary key could not be found
	*/
	public static Approvatore fetchByPrimaryKey(long id_approvatore) {
		return getPersistence().fetchByPrimaryKey(id_approvatore);
	}

	public static java.util.Map<java.io.Serializable, Approvatore> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the approvatores.
	*
	* @return the approvatores
	*/
	public static List<Approvatore> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the approvatores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @return the range of approvatores
	*/
	public static List<Approvatore> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the approvatores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of approvatores
	*/
	public static List<Approvatore> findAll(int start, int end,
		OrderByComparator<Approvatore> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the approvatores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of approvatores
	*/
	public static List<Approvatore> findAll(int start, int end,
		OrderByComparator<Approvatore> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the approvatores from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of approvatores.
	*
	* @return the number of approvatores
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApprovatorePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ApprovatorePersistence, ApprovatorePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ApprovatorePersistence.class);
}