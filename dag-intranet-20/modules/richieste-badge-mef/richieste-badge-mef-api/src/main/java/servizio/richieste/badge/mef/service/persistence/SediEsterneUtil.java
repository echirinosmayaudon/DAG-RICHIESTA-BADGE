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

package servizio.richieste.badge.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.richieste.badge.mef.model.SediEsterne;

import java.util.List;

/**
 * The persistence utility for the sedi esterne service. This utility wraps {@link servizio.richieste.badge.mef.service.persistence.impl.SediEsternePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediEsternePersistence
 * @see servizio.richieste.badge.mef.service.persistence.impl.SediEsternePersistenceImpl
 * @generated
 */
@ProviderType
public class SediEsterneUtil {
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
	public static void clearCache(SediEsterne sediEsterne) {
		getPersistence().clearCache(sediEsterne);
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
	public static List<SediEsterne> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SediEsterne> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SediEsterne> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SediEsterne update(SediEsterne sediEsterne) {
		return getPersistence().update(sediEsterne);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SediEsterne update(SediEsterne sediEsterne,
		ServiceContext serviceContext) {
		return getPersistence().update(sediEsterne, serviceContext);
	}

	/**
	* Returns all the sedi esternes where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @return the matching sedi esternes
	*/
	public static List<SediEsterne> findByIdSedeSiap(long id_sedesiap) {
		return getPersistence().findByIdSedeSiap(id_sedesiap);
	}

	/**
	* Returns a range of all the sedi esternes where id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @return the range of matching sedi esternes
	*/
	public static List<SediEsterne> findByIdSedeSiap(long id_sedesiap,
		int start, int end) {
		return getPersistence().findByIdSedeSiap(id_sedesiap, start, end);
	}

	/**
	* Returns an ordered range of all the sedi esternes where id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi esternes
	*/
	public static List<SediEsterne> findByIdSedeSiap(long id_sedesiap,
		int start, int end, OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence()
				   .findByIdSedeSiap(id_sedesiap, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sedi esternes where id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi esternes
	*/
	public static List<SediEsterne> findByIdSedeSiap(long id_sedesiap,
		int start, int end, OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdSedeSiap(id_sedesiap, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public static SediEsterne findByIdSedeSiap_First(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence()
				   .findByIdSedeSiap_First(id_sedesiap, orderByComparator);
	}

	/**
	* Returns the first sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public static SediEsterne fetchByIdSedeSiap_First(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence()
				   .fetchByIdSedeSiap_First(id_sedesiap, orderByComparator);
	}

	/**
	* Returns the last sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public static SediEsterne findByIdSedeSiap_Last(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence()
				   .findByIdSedeSiap_Last(id_sedesiap, orderByComparator);
	}

	/**
	* Returns the last sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public static SediEsterne fetchByIdSedeSiap_Last(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence()
				   .fetchByIdSedeSiap_Last(id_sedesiap, orderByComparator);
	}

	/**
	* Returns the sedi esternes before and after the current sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sede_esterna the primary key of the current sedi esterne
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi esterne
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public static SediEsterne[] findByIdSedeSiap_PrevAndNext(
		long id_sede_esterna, long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence()
				   .findByIdSedeSiap_PrevAndNext(id_sede_esterna, id_sedesiap,
			orderByComparator);
	}

	/**
	* Removes all the sedi esternes where id_sedesiap = &#63; from the database.
	*
	* @param id_sedesiap the id_sedesiap
	*/
	public static void removeByIdSedeSiap(long id_sedesiap) {
		getPersistence().removeByIdSedeSiap(id_sedesiap);
	}

	/**
	* Returns the number of sedi esternes where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @return the number of matching sedi esternes
	*/
	public static int countByIdSedeSiap(long id_sedesiap) {
		return getPersistence().countByIdSedeSiap(id_sedesiap);
	}

	/**
	* Returns all the sedi esternes where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @return the matching sedi esternes
	*/
	public static List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede) {
		return getPersistence().findByAcronimoSede(acronimo_sede);
	}

	/**
	* Returns a range of all the sedi esternes where acronimo_sede = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param acronimo_sede the acronimo_sede
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @return the range of matching sedi esternes
	*/
	public static List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede, int start, int end) {
		return getPersistence().findByAcronimoSede(acronimo_sede, start, end);
	}

	/**
	* Returns an ordered range of all the sedi esternes where acronimo_sede = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param acronimo_sede the acronimo_sede
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi esternes
	*/
	public static List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede, int start, int end,
		OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence()
				   .findByAcronimoSede(acronimo_sede, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the sedi esternes where acronimo_sede = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param acronimo_sede the acronimo_sede
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi esternes
	*/
	public static List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede, int start, int end,
		OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAcronimoSede(acronimo_sede, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public static SediEsterne findByAcronimoSede_First(
		java.lang.String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence()
				   .findByAcronimoSede_First(acronimo_sede, orderByComparator);
	}

	/**
	* Returns the first sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public static SediEsterne fetchByAcronimoSede_First(
		java.lang.String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence()
				   .fetchByAcronimoSede_First(acronimo_sede, orderByComparator);
	}

	/**
	* Returns the last sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public static SediEsterne findByAcronimoSede_Last(
		java.lang.String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence()
				   .findByAcronimoSede_Last(acronimo_sede, orderByComparator);
	}

	/**
	* Returns the last sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public static SediEsterne fetchByAcronimoSede_Last(
		java.lang.String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence()
				   .fetchByAcronimoSede_Last(acronimo_sede, orderByComparator);
	}

	/**
	* Returns the sedi esternes before and after the current sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param id_sede_esterna the primary key of the current sedi esterne
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi esterne
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public static SediEsterne[] findByAcronimoSede_PrevAndNext(
		long id_sede_esterna, java.lang.String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence()
				   .findByAcronimoSede_PrevAndNext(id_sede_esterna,
			acronimo_sede, orderByComparator);
	}

	/**
	* Removes all the sedi esternes where acronimo_sede = &#63; from the database.
	*
	* @param acronimo_sede the acronimo_sede
	*/
	public static void removeByAcronimoSede(java.lang.String acronimo_sede) {
		getPersistence().removeByAcronimoSede(acronimo_sede);
	}

	/**
	* Returns the number of sedi esternes where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @return the number of matching sedi esternes
	*/
	public static int countByAcronimoSede(java.lang.String acronimo_sede) {
		return getPersistence().countByAcronimoSede(acronimo_sede);
	}

	/**
	* Caches the sedi esterne in the entity cache if it is enabled.
	*
	* @param sediEsterne the sedi esterne
	*/
	public static void cacheResult(SediEsterne sediEsterne) {
		getPersistence().cacheResult(sediEsterne);
	}

	/**
	* Caches the sedi esternes in the entity cache if it is enabled.
	*
	* @param sediEsternes the sedi esternes
	*/
	public static void cacheResult(List<SediEsterne> sediEsternes) {
		getPersistence().cacheResult(sediEsternes);
	}

	/**
	* Creates a new sedi esterne with the primary key. Does not add the sedi esterne to the database.
	*
	* @param id_sede_esterna the primary key for the new sedi esterne
	* @return the new sedi esterne
	*/
	public static SediEsterne create(long id_sede_esterna) {
		return getPersistence().create(id_sede_esterna);
	}

	/**
	* Removes the sedi esterne with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne that was removed
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public static SediEsterne remove(long id_sede_esterna)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence().remove(id_sede_esterna);
	}

	public static SediEsterne updateImpl(SediEsterne sediEsterne) {
		return getPersistence().updateImpl(sediEsterne);
	}

	/**
	* Returns the sedi esterne with the primary key or throws a {@link NoSuchSediEsterneException} if it could not be found.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public static SediEsterne findByPrimaryKey(long id_sede_esterna)
		throws servizio.richieste.badge.mef.exception.NoSuchSediEsterneException {
		return getPersistence().findByPrimaryKey(id_sede_esterna);
	}

	/**
	* Returns the sedi esterne with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne, or <code>null</code> if a sedi esterne with the primary key could not be found
	*/
	public static SediEsterne fetchByPrimaryKey(long id_sede_esterna) {
		return getPersistence().fetchByPrimaryKey(id_sede_esterna);
	}

	public static java.util.Map<java.io.Serializable, SediEsterne> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the sedi esternes.
	*
	* @return the sedi esternes
	*/
	public static List<SediEsterne> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sedi esternes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @return the range of sedi esternes
	*/
	public static List<SediEsterne> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sedi esternes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sedi esternes
	*/
	public static List<SediEsterne> findAll(int start, int end,
		OrderByComparator<SediEsterne> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sedi esternes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sedi esternes
	*/
	public static List<SediEsterne> findAll(int start, int end,
		OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the sedi esternes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sedi esternes.
	*
	* @return the number of sedi esternes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SediEsternePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SediEsternePersistence, SediEsternePersistence> _serviceTracker =
		ServiceTrackerFactory.open(SediEsternePersistence.class);
}