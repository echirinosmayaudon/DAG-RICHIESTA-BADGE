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

package com.intranet.mef.gestione.riunioni.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the invitati riunione service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.InvitatiRiunionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunionePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.InvitatiRiunionePersistenceImpl
 * @generated
 */
@ProviderType
public class InvitatiRiunioneUtil {
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
	public static void clearCache(InvitatiRiunione invitatiRiunione) {
		getPersistence().clearCache(invitatiRiunione);
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
	public static List<InvitatiRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InvitatiRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InvitatiRiunione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InvitatiRiunione update(InvitatiRiunione invitatiRiunione) {
		return getPersistence().update(invitatiRiunione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InvitatiRiunione update(InvitatiRiunione invitatiRiunione,
		ServiceContext serviceContext) {
		return getPersistence().update(invitatiRiunione, serviceContext);
	}

	/**
	* Returns all the invitati riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findByRiunione(long id_riunione) {
		return getPersistence().findByRiunione(id_riunione);
	}

	/**
	* Returns a range of all the invitati riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @return the range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findByRiunione(long id_riunione,
		int start, int end) {
		return getPersistence().findByRiunione(id_riunione, start, end);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findByRiunione(long id_riunione,
		int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .findByRiunione(id_riunione, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findByRiunione(long id_riunione,
		int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRiunione(id_riunione, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione findByRiunione_First(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findByRiunione_First(id_riunione, orderByComparator);
	}

	/**
	* Returns the first invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione fetchByRiunione_First(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .fetchByRiunione_First(id_riunione, orderByComparator);
	}

	/**
	* Returns the last invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione findByRiunione_Last(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findByRiunione_Last(id_riunione, orderByComparator);
	}

	/**
	* Returns the last invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione fetchByRiunione_Last(long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .fetchByRiunione_Last(id_riunione, orderByComparator);
	}

	/**
	* Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param invitatiRiunionePK the primary key of the current invitati riunione
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public static InvitatiRiunione[] findByRiunione_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findByRiunione_PrevAndNext(invitatiRiunionePK, id_riunione,
			orderByComparator);
	}

	/**
	* Removes all the invitati riuniones where id_riunione = &#63; from the database.
	*
	* @param id_riunione the id_riunione
	*/
	public static void removeByRiunione(long id_riunione) {
		getPersistence().removeByRiunione(id_riunione);
	}

	/**
	* Returns the number of invitati riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the number of matching invitati riuniones
	*/
	public static int countByRiunione(long id_riunione) {
		return getPersistence().countByRiunione(id_riunione);
	}

	/**
	* Returns all the invitati riuniones where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @return the matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteria(long id_segreteria) {
		return getPersistence().findBySegreteria(id_segreteria);
	}

	/**
	* Returns a range of all the invitati riuniones where id_segreteria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @return the range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteria(long id_segreteria,
		int start, int end) {
		return getPersistence().findBySegreteria(id_segreteria, start, end);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_segreteria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteria(long id_segreteria,
		int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .findBySegreteria(id_segreteria, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_segreteria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteria(long id_segreteria,
		int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySegreteria(id_segreteria, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione findBySegreteria_First(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findBySegreteria_First(id_segreteria, orderByComparator);
	}

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione fetchBySegreteria_First(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .fetchBySegreteria_First(id_segreteria, orderByComparator);
	}

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione findBySegreteria_Last(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findBySegreteria_Last(id_segreteria, orderByComparator);
	}

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione fetchBySegreteria_Last(long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .fetchBySegreteria_Last(id_segreteria, orderByComparator);
	}

	/**
	* Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param invitatiRiunionePK the primary key of the current invitati riunione
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public static InvitatiRiunione[] findBySegreteria_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_segreteria,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findBySegreteria_PrevAndNext(invitatiRiunionePK,
			id_segreteria, orderByComparator);
	}

	/**
	* Removes all the invitati riuniones where id_segreteria = &#63; from the database.
	*
	* @param id_segreteria the id_segreteria
	*/
	public static void removeBySegreteria(long id_segreteria) {
		getPersistence().removeBySegreteria(id_segreteria);
	}

	/**
	* Returns the number of invitati riuniones where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @return the number of matching invitati riuniones
	*/
	public static int countBySegreteria(long id_segreteria) {
		return getPersistence().countBySegreteria(id_segreteria);
	}

	/**
	* Returns all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @return the matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riunione);
	}

	/**
	* Returns a range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @return the range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione, int start, int end) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riunione, start,
			end);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riunione, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riunione, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione findBySegreteriaRiunione_First(
		long id_segreteria, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findBySegreteriaRiunione_First(id_segreteria, id_riunione,
			orderByComparator);
	}

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione fetchBySegreteriaRiunione_First(
		long id_segreteria, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .fetchBySegreteriaRiunione_First(id_segreteria, id_riunione,
			orderByComparator);
	}

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione findBySegreteriaRiunione_Last(
		long id_segreteria, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findBySegreteriaRiunione_Last(id_segreteria, id_riunione,
			orderByComparator);
	}

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public static InvitatiRiunione fetchBySegreteriaRiunione_Last(
		long id_segreteria, long id_riunione,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .fetchBySegreteriaRiunione_Last(id_segreteria, id_riunione,
			orderByComparator);
	}

	/**
	* Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param invitatiRiunionePK the primary key of the current invitati riunione
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public static InvitatiRiunione[] findBySegreteriaRiunione_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_segreteria,
		long id_riunione, OrderByComparator<InvitatiRiunione> orderByComparator)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence()
				   .findBySegreteriaRiunione_PrevAndNext(invitatiRiunionePK,
			id_segreteria, id_riunione, orderByComparator);
	}

	/**
	* Returns all the invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param id_riuniones the id_riuniones
	* @return the matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riuniones);
	}

	/**
	* Returns a range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param id_riuniones the id_riuniones
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @return the range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones, int start, int end) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riuniones,
			start, end);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param id_riuniones the id_riuniones
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riuniones,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invitati riuniones
	*/
	public static List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones, int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySegreteriaRiunione(id_segreteria, id_riuniones,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63; from the database.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	*/
	public static void removeBySegreteriaRiunione(long id_segreteria,
		long id_riunione) {
		getPersistence().removeBySegreteriaRiunione(id_segreteria, id_riunione);
	}

	/**
	* Returns the number of invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @return the number of matching invitati riuniones
	*/
	public static int countBySegreteriaRiunione(long id_segreteria,
		long id_riunione) {
		return getPersistence()
				   .countBySegreteriaRiunione(id_segreteria, id_riunione);
	}

	/**
	* Returns the number of invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riuniones the id_riuniones
	* @return the number of matching invitati riuniones
	*/
	public static int countBySegreteriaRiunione(long id_segreteria,
		long[] id_riuniones) {
		return getPersistence()
				   .countBySegreteriaRiunione(id_segreteria, id_riuniones);
	}

	/**
	* Caches the invitati riunione in the entity cache if it is enabled.
	*
	* @param invitatiRiunione the invitati riunione
	*/
	public static void cacheResult(InvitatiRiunione invitatiRiunione) {
		getPersistence().cacheResult(invitatiRiunione);
	}

	/**
	* Caches the invitati riuniones in the entity cache if it is enabled.
	*
	* @param invitatiRiuniones the invitati riuniones
	*/
	public static void cacheResult(List<InvitatiRiunione> invitatiRiuniones) {
		getPersistence().cacheResult(invitatiRiuniones);
	}

	/**
	* Creates a new invitati riunione with the primary key. Does not add the invitati riunione to the database.
	*
	* @param invitatiRiunionePK the primary key for the new invitati riunione
	* @return the new invitati riunione
	*/
	public static InvitatiRiunione create(InvitatiRiunionePK invitatiRiunionePK) {
		return getPersistence().create(invitatiRiunionePK);
	}

	/**
	* Removes the invitati riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione that was removed
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public static InvitatiRiunione remove(InvitatiRiunionePK invitatiRiunionePK)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence().remove(invitatiRiunionePK);
	}

	public static InvitatiRiunione updateImpl(InvitatiRiunione invitatiRiunione) {
		return getPersistence().updateImpl(invitatiRiunione);
	}

	/**
	* Returns the invitati riunione with the primary key or throws a {@link NoSuchInvitatiRiunioneException} if it could not be found.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public static InvitatiRiunione findByPrimaryKey(
		InvitatiRiunionePK invitatiRiunionePK)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException {
		return getPersistence().findByPrimaryKey(invitatiRiunionePK);
	}

	/**
	* Returns the invitati riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione, or <code>null</code> if a invitati riunione with the primary key could not be found
	*/
	public static InvitatiRiunione fetchByPrimaryKey(
		InvitatiRiunionePK invitatiRiunionePK) {
		return getPersistence().fetchByPrimaryKey(invitatiRiunionePK);
	}

	public static java.util.Map<java.io.Serializable, InvitatiRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the invitati riuniones.
	*
	* @return the invitati riuniones
	*/
	public static List<InvitatiRiunione> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the invitati riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @return the range of invitati riuniones
	*/
	public static List<InvitatiRiunione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the invitati riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of invitati riuniones
	*/
	public static List<InvitatiRiunione> findAll(int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invitati riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of invitati riuniones
	*/
	public static List<InvitatiRiunione> findAll(int start, int end,
		OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the invitati riuniones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of invitati riuniones.
	*
	* @return the number of invitati riuniones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InvitatiRiunionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InvitatiRiunionePersistence, InvitatiRiunionePersistence> _serviceTracker =
		ServiceTrackerFactory.open(InvitatiRiunionePersistence.class);
}