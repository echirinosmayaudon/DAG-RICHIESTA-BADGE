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

import service.intranet.mef.model.RichiestaBeneInv;

import java.util.List;

/**
 * The persistence utility for the richiesta bene inv service. This utility wraps {@link service.intranet.mef.service.persistence.impl.RichiestaBeneInvPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvPersistence
 * @see service.intranet.mef.service.persistence.impl.RichiestaBeneInvPersistenceImpl
 * @generated
 */
@ProviderType
public class RichiestaBeneInvUtil {
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
	public static void clearCache(RichiestaBeneInv richiestaBeneInv) {
		getPersistence().clearCache(richiestaBeneInv);
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
	public static List<RichiestaBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiestaBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiestaBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiestaBeneInv update(RichiestaBeneInv richiestaBeneInv) {
		return getPersistence().update(richiestaBeneInv);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiestaBeneInv update(RichiestaBeneInv richiestaBeneInv,
		ServiceContext serviceContext) {
		return getPersistence().update(richiestaBeneInv, serviceContext);
	}

	/**
	* Returns all the richiesta bene invs where utente = &#63;.
	*
	* @param utente the utente
	* @return the matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByUtente(java.lang.String utente) {
		return getPersistence().findByUtente(utente);
	}

	/**
	* Returns a range of all the richiesta bene invs where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @return the range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByUtente(java.lang.String utente,
		int start, int end) {
		return getPersistence().findByUtente(utente, start, end);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByUtente(java.lang.String utente,
		int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .findByUtente(utente, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByUtente(java.lang.String utente,
		int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUtente(utente, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv findByUtente_First(java.lang.String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence().findByUtente_First(utente, orderByComparator);
	}

	/**
	* Returns the first richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv fetchByUtente_First(
		java.lang.String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence().fetchByUtente_First(utente, orderByComparator);
	}

	/**
	* Returns the last richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv findByUtente_Last(java.lang.String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence().findByUtente_Last(utente, orderByComparator);
	}

	/**
	* Returns the last richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv fetchByUtente_Last(java.lang.String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence().fetchByUtente_Last(utente, orderByComparator);
	}

	/**
	* Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param id_richiesta the primary key of the current richiesta bene inv
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public static RichiestaBeneInv[] findByUtente_PrevAndNext(
		long id_richiesta, java.lang.String utente,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence()
				   .findByUtente_PrevAndNext(id_richiesta, utente,
			orderByComparator);
	}

	/**
	* Removes all the richiesta bene invs where utente = &#63; from the database.
	*
	* @param utente the utente
	*/
	public static void removeByUtente(java.lang.String utente) {
		getPersistence().removeByUtente(utente);
	}

	/**
	* Returns the number of richiesta bene invs where utente = &#63;.
	*
	* @param utente the utente
	* @return the number of matching richiesta bene invs
	*/
	public static int countByUtente(java.lang.String utente) {
		return getPersistence().countByUtente(utente);
	}

	/**
	* Returns all the richiesta bene invs where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @return the matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir) {
		return getPersistence().findByDipartimento(dip_dir);
	}

	/**
	* Returns a range of all the richiesta bene invs where dip_dir = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dip_dir the dip_dir
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @return the range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir, int start, int end) {
		return getPersistence().findByDipartimento(dip_dir, start, end);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs where dip_dir = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dip_dir the dip_dir
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir, int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .findByDipartimento(dip_dir, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs where dip_dir = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dip_dir the dip_dir
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir, int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDipartimento(dip_dir, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv findByDipartimento_First(
		java.lang.String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence()
				   .findByDipartimento_First(dip_dir, orderByComparator);
	}

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv fetchByDipartimento_First(
		java.lang.String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_First(dip_dir, orderByComparator);
	}

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv findByDipartimento_Last(
		java.lang.String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence()
				   .findByDipartimento_Last(dip_dir, orderByComparator);
	}

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv fetchByDipartimento_Last(
		java.lang.String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_Last(dip_dir, orderByComparator);
	}

	/**
	* Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param id_richiesta the primary key of the current richiesta bene inv
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public static RichiestaBeneInv[] findByDipartimento_PrevAndNext(
		long id_richiesta, java.lang.String dip_dir,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence()
				   .findByDipartimento_PrevAndNext(id_richiesta, dip_dir,
			orderByComparator);
	}

	/**
	* Removes all the richiesta bene invs where dip_dir = &#63; from the database.
	*
	* @param dip_dir the dip_dir
	*/
	public static void removeByDipartimento(java.lang.String dip_dir) {
		getPersistence().removeByDipartimento(dip_dir);
	}

	/**
	* Returns the number of richiesta bene invs where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @return the number of matching richiesta bene invs
	*/
	public static int countByDipartimento(java.lang.String dip_dir) {
		return getPersistence().countByDipartimento(dip_dir);
	}

	/**
	* Returns all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @return the matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato) {
		return getPersistence().findByDipartimentoStato(dip_dir, id_stato);
	}

	/**
	* Returns a range of all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @return the range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato, int start, int end) {
		return getPersistence()
				   .findByDipartimentoStato(dip_dir, id_stato, start, end);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato, int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .findByDipartimentoStato(dip_dir, id_stato, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato, int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDipartimentoStato(dip_dir, id_stato, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv findByDipartimentoStato_First(
		java.lang.String dip_dir, long id_stato,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence()
				   .findByDipartimentoStato_First(dip_dir, id_stato,
			orderByComparator);
	}

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv fetchByDipartimentoStato_First(
		java.lang.String dip_dir, long id_stato,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimentoStato_First(dip_dir, id_stato,
			orderByComparator);
	}

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv findByDipartimentoStato_Last(
		java.lang.String dip_dir, long id_stato,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence()
				   .findByDipartimentoStato_Last(dip_dir, id_stato,
			orderByComparator);
	}

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public static RichiestaBeneInv fetchByDipartimentoStato_Last(
		java.lang.String dip_dir, long id_stato,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimentoStato_Last(dip_dir, id_stato,
			orderByComparator);
	}

	/**
	* Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param id_richiesta the primary key of the current richiesta bene inv
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public static RichiestaBeneInv[] findByDipartimentoStato_PrevAndNext(
		long id_richiesta, java.lang.String dip_dir, long id_stato,
		OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence()
				   .findByDipartimentoStato_PrevAndNext(id_richiesta, dip_dir,
			id_stato, orderByComparator);
	}

	/**
	* Removes all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63; from the database.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	*/
	public static void removeByDipartimentoStato(java.lang.String dip_dir,
		long id_stato) {
		getPersistence().removeByDipartimentoStato(dip_dir, id_stato);
	}

	/**
	* Returns the number of richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @return the number of matching richiesta bene invs
	*/
	public static int countByDipartimentoStato(java.lang.String dip_dir,
		long id_stato) {
		return getPersistence().countByDipartimentoStato(dip_dir, id_stato);
	}

	/**
	* Caches the richiesta bene inv in the entity cache if it is enabled.
	*
	* @param richiestaBeneInv the richiesta bene inv
	*/
	public static void cacheResult(RichiestaBeneInv richiestaBeneInv) {
		getPersistence().cacheResult(richiestaBeneInv);
	}

	/**
	* Caches the richiesta bene invs in the entity cache if it is enabled.
	*
	* @param richiestaBeneInvs the richiesta bene invs
	*/
	public static void cacheResult(List<RichiestaBeneInv> richiestaBeneInvs) {
		getPersistence().cacheResult(richiestaBeneInvs);
	}

	/**
	* Creates a new richiesta bene inv with the primary key. Does not add the richiesta bene inv to the database.
	*
	* @param id_richiesta the primary key for the new richiesta bene inv
	* @return the new richiesta bene inv
	*/
	public static RichiestaBeneInv create(long id_richiesta) {
		return getPersistence().create(id_richiesta);
	}

	/**
	* Removes the richiesta bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv that was removed
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public static RichiestaBeneInv remove(long id_richiesta)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence().remove(id_richiesta);
	}

	public static RichiestaBeneInv updateImpl(RichiestaBeneInv richiestaBeneInv) {
		return getPersistence().updateImpl(richiestaBeneInv);
	}

	/**
	* Returns the richiesta bene inv with the primary key or throws a {@link NoSuchRichiestaBeneInvException} if it could not be found.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public static RichiestaBeneInv findByPrimaryKey(long id_richiesta)
		throws service.intranet.mef.exception.NoSuchRichiestaBeneInvException {
		return getPersistence().findByPrimaryKey(id_richiesta);
	}

	/**
	* Returns the richiesta bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv, or <code>null</code> if a richiesta bene inv with the primary key could not be found
	*/
	public static RichiestaBeneInv fetchByPrimaryKey(long id_richiesta) {
		return getPersistence().fetchByPrimaryKey(id_richiesta);
	}

	public static java.util.Map<java.io.Serializable, RichiestaBeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richiesta bene invs.
	*
	* @return the richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richiesta bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @return the range of richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findAll(int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richiesta bene invs
	*/
	public static List<RichiestaBeneInv> findAll(int start, int end,
		OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richiesta bene invs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richiesta bene invs.
	*
	* @return the number of richiesta bene invs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RichiestaBeneInvPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaBeneInvPersistence, RichiestaBeneInvPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaBeneInvPersistence.class);
}