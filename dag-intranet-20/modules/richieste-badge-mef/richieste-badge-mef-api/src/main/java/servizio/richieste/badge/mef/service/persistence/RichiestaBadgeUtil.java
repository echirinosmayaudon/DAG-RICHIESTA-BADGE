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

import servizio.richieste.badge.mef.model.RichiestaBadge;

import java.util.List;

/**
 * The persistence utility for the richiesta badge service. This utility wraps {@link servizio.richieste.badge.mef.service.persistence.impl.RichiestaBadgePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgePersistence
 * @see servizio.richieste.badge.mef.service.persistence.impl.RichiestaBadgePersistenceImpl
 * @generated
 */
@ProviderType
public class RichiestaBadgeUtil {
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
	public static void clearCache(RichiestaBadge richiestaBadge) {
		getPersistence().clearCache(richiestaBadge);
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
	public static List<RichiestaBadge> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiestaBadge> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiestaBadge> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiestaBadge update(RichiestaBadge richiestaBadge) {
		return getPersistence().update(richiestaBadge);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiestaBadge update(RichiestaBadge richiestaBadge,
		ServiceContext serviceContext) {
		return getPersistence().update(richiestaBadge, serviceContext);
	}

	/**
	* Returns all the richiesta badges where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching richiesta badges
	*/
	public static List<RichiestaBadge> findByIdRichiesta(long id_richiesta) {
		return getPersistence().findByIdRichiesta(id_richiesta);
	}

	/**
	* Returns a range of all the richiesta badges where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @return the range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByIdRichiesta(long id_richiesta,
		int start, int end) {
		return getPersistence().findByIdRichiesta(id_richiesta, start, end);
	}

	/**
	* Returns an ordered range of all the richiesta badges where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByIdRichiesta(long id_richiesta,
		int start, int end, OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta badges where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByIdRichiesta(long id_richiesta,
		int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByIdRichiesta_First(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the first richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByIdRichiesta_First(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the richiesta badges before and after the current richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_pk the primary key of the current richiesta badge
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta badge
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public static RichiestaBadge[] findByIdRichiesta_PrevAndNext(long id_pk,
		long id_richiesta, OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByIdRichiesta_PrevAndNext(id_pk, id_richiesta,
			orderByComparator);
	}

	/**
	* Removes all the richiesta badges where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public static void removeByIdRichiesta(long id_richiesta) {
		getPersistence().removeByIdRichiesta(id_richiesta);
	}

	/**
	* Returns the number of richiesta badges where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching richiesta badges
	*/
	public static int countByIdRichiesta(long id_richiesta) {
		return getPersistence().countByIdRichiesta(id_richiesta);
	}

	/**
	* Returns all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @return the matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last) {
		return getPersistence().findByRichiedente(screename_richiedente, is_last);
	}

	/**
	* Returns a range of all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @return the range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last, int start,
		int end) {
		return getPersistence()
				   .findByRichiedente(screename_richiedente, is_last, start, end);
	}

	/**
	* Returns an ordered range of all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .findByRichiedente(screename_richiedente, is_last, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRichiedente(screename_richiedente, is_last, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByRichiedente_First(
		java.lang.String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRichiedente_First(screename_richiedente, is_last,
			orderByComparator);
	}

	/**
	* Returns the first richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByRichiedente_First(
		java.lang.String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByRichiedente_First(screename_richiedente, is_last,
			orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByRichiedente_Last(
		java.lang.String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRichiedente_Last(screename_richiedente, is_last,
			orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByRichiedente_Last(
		java.lang.String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByRichiedente_Last(screename_richiedente, is_last,
			orderByComparator);
	}

	/**
	* Returns the richiesta badges before and after the current richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param id_pk the primary key of the current richiesta badge
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta badge
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public static RichiestaBadge[] findByRichiedente_PrevAndNext(long id_pk,
		java.lang.String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRichiedente_PrevAndNext(id_pk, screename_richiedente,
			is_last, orderByComparator);
	}

	/**
	* Removes all the richiesta badges where screename_richiedente = &#63; and is_last = &#63; from the database.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	*/
	public static void removeByRichiedente(
		java.lang.String screename_richiedente, boolean is_last) {
		getPersistence().removeByRichiedente(screename_richiedente, is_last);
	}

	/**
	* Returns the number of richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @return the number of matching richiesta badges
	*/
	public static int countByRichiedente(
		java.lang.String screename_richiedente, boolean is_last) {
		return getPersistence()
				   .countByRichiedente(screename_richiedente, is_last);
	}

	/**
	* Returns all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @return the matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato) {
		return getPersistence().findByRuolo(is_last, is_internal, id_stato);
	}

	/**
	* Returns a range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @return the range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end) {
		return getPersistence()
				   .findByRuolo(is_last, is_internal, id_stato, start, end);
	}

	/**
	* Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .findByRuolo(is_last, is_internal, id_stato, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRuolo(is_last, is_internal, id_stato, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByRuolo_First(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRuolo_First(is_last, is_internal, id_stato,
			orderByComparator);
	}

	/**
	* Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByRuolo_First(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByRuolo_First(is_last, is_internal, id_stato,
			orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByRuolo_Last(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRuolo_Last(is_last, is_internal, id_stato,
			orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByRuolo_Last(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByRuolo_Last(is_last, is_internal, id_stato,
			orderByComparator);
	}

	/**
	* Returns the richiesta badges before and after the current richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param id_pk the primary key of the current richiesta badge
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta badge
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public static RichiestaBadge[] findByRuolo_PrevAndNext(long id_pk,
		boolean is_last, boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRuolo_PrevAndNext(id_pk, is_last, is_internal,
			id_stato, orderByComparator);
	}

	/**
	* Removes all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; from the database.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	*/
	public static void removeByRuolo(boolean is_last, boolean is_internal,
		long id_stato) {
		getPersistence().removeByRuolo(is_last, is_internal, id_stato);
	}

	/**
	* Returns the number of richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @return the number of matching richiesta badges
	*/
	public static int countByRuolo(boolean is_last, boolean is_internal,
		long id_stato) {
		return getPersistence().countByRuolo(is_last, is_internal, id_stato);
	}

	/**
	* Returns all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @return the matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap) {
		return getPersistence()
				   .findByRuoloSede(is_last, is_internal, id_stato, id_sedesiap);
	}

	/**
	* Returns a range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @return the range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start, int end) {
		return getPersistence()
				   .findByRuoloSede(is_last, is_internal, id_stato,
			id_sedesiap, start, end);
	}

	/**
	* Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .findByRuoloSede(is_last, is_internal, id_stato,
			id_sedesiap, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiesta badges
	*/
	public static List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRuoloSede(is_last, is_internal, id_stato,
			id_sedesiap, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByRuoloSede_First(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRuoloSede_First(is_last, is_internal, id_stato,
			id_sedesiap, orderByComparator);
	}

	/**
	* Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByRuoloSede_First(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByRuoloSede_First(is_last, is_internal, id_stato,
			id_sedesiap, orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge findByRuoloSede_Last(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRuoloSede_Last(is_last, is_internal, id_stato,
			id_sedesiap, orderByComparator);
	}

	/**
	* Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public static RichiestaBadge fetchByRuoloSede_Last(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence()
				   .fetchByRuoloSede_Last(is_last, is_internal, id_stato,
			id_sedesiap, orderByComparator);
	}

	/**
	* Returns the richiesta badges before and after the current richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param id_pk the primary key of the current richiesta badge
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta badge
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public static RichiestaBadge[] findByRuoloSede_PrevAndNext(long id_pk,
		boolean is_last, boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence()
				   .findByRuoloSede_PrevAndNext(id_pk, is_last, is_internal,
			id_stato, id_sedesiap, orderByComparator);
	}

	/**
	* Removes all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63; from the database.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	*/
	public static void removeByRuoloSede(boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap) {
		getPersistence()
			.removeByRuoloSede(is_last, is_internal, id_stato, id_sedesiap);
	}

	/**
	* Returns the number of richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @return the number of matching richiesta badges
	*/
	public static int countByRuoloSede(boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap) {
		return getPersistence()
				   .countByRuoloSede(is_last, is_internal, id_stato, id_sedesiap);
	}

	/**
	* Caches the richiesta badge in the entity cache if it is enabled.
	*
	* @param richiestaBadge the richiesta badge
	*/
	public static void cacheResult(RichiestaBadge richiestaBadge) {
		getPersistence().cacheResult(richiestaBadge);
	}

	/**
	* Caches the richiesta badges in the entity cache if it is enabled.
	*
	* @param richiestaBadges the richiesta badges
	*/
	public static void cacheResult(List<RichiestaBadge> richiestaBadges) {
		getPersistence().cacheResult(richiestaBadges);
	}

	/**
	* Creates a new richiesta badge with the primary key. Does not add the richiesta badge to the database.
	*
	* @param id_pk the primary key for the new richiesta badge
	* @return the new richiesta badge
	*/
	public static RichiestaBadge create(long id_pk) {
		return getPersistence().create(id_pk);
	}

	/**
	* Removes the richiesta badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge that was removed
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public static RichiestaBadge remove(long id_pk)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence().remove(id_pk);
	}

	public static RichiestaBadge updateImpl(RichiestaBadge richiestaBadge) {
		return getPersistence().updateImpl(richiestaBadge);
	}

	/**
	* Returns the richiesta badge with the primary key or throws a {@link NoSuchRichiestaBadgeException} if it could not be found.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public static RichiestaBadge findByPrimaryKey(long id_pk)
		throws servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException {
		return getPersistence().findByPrimaryKey(id_pk);
	}

	/**
	* Returns the richiesta badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge, or <code>null</code> if a richiesta badge with the primary key could not be found
	*/
	public static RichiestaBadge fetchByPrimaryKey(long id_pk) {
		return getPersistence().fetchByPrimaryKey(id_pk);
	}

	public static java.util.Map<java.io.Serializable, RichiestaBadge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richiesta badges.
	*
	* @return the richiesta badges
	*/
	public static List<RichiestaBadge> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richiesta badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @return the range of richiesta badges
	*/
	public static List<RichiestaBadge> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richiesta badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richiesta badges
	*/
	public static List<RichiestaBadge> findAll(int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiesta badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richiesta badges
	*/
	public static List<RichiestaBadge> findAll(int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richiesta badges from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richiesta badges.
	*
	* @return the number of richiesta badges
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RichiestaBadgePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaBadgePersistence, RichiestaBadgePersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaBadgePersistence.class);
}