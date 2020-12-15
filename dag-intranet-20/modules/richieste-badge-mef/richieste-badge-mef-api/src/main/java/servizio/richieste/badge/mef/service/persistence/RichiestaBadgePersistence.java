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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException;
import servizio.richieste.badge.mef.model.RichiestaBadge;

/**
 * The persistence interface for the richiesta badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.persistence.impl.RichiestaBadgePersistenceImpl
 * @see RichiestaBadgeUtil
 * @generated
 */
@ProviderType
public interface RichiestaBadgePersistence extends BasePersistence<RichiestaBadge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaBadgeUtil} to access the richiesta badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the richiesta badges where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching richiesta badges
	*/
	public java.util.List<RichiestaBadge> findByIdRichiesta(long id_richiesta);

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
	public java.util.List<RichiestaBadge> findByIdRichiesta(long id_richiesta,
		int start, int end);

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
	public java.util.List<RichiestaBadge> findByIdRichiesta(long id_richiesta,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public java.util.List<RichiestaBadge> findByIdRichiesta(long id_richiesta,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public RichiestaBadge findByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Returns the first richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public RichiestaBadge fetchByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

	/**
	* Returns the last richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public RichiestaBadge findByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Returns the last richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public RichiestaBadge fetchByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

	/**
	* Returns the richiesta badges before and after the current richiesta badge in the ordered set where id_richiesta = &#63;.
	*
	* @param id_pk the primary key of the current richiesta badge
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta badge
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public RichiestaBadge[] findByIdRichiesta_PrevAndNext(long id_pk,
		long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Removes all the richiesta badges where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public void removeByIdRichiesta(long id_richiesta);

	/**
	* Returns the number of richiesta badges where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching richiesta badges
	*/
	public int countByIdRichiesta(long id_richiesta);

	/**
	* Returns all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @return the matching richiesta badges
	*/
	public java.util.List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last);

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
	public java.util.List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last, int start,
		int end);

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
	public java.util.List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public java.util.List<RichiestaBadge> findByRichiedente(
		java.lang.String screename_richiedente, boolean is_last, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public RichiestaBadge findByRichiedente_First(
		java.lang.String screename_richiedente, boolean is_last,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Returns the first richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public RichiestaBadge fetchByRichiedente_First(
		java.lang.String screename_richiedente, boolean is_last,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

	/**
	* Returns the last richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge
	* @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	*/
	public RichiestaBadge findByRichiedente_Last(
		java.lang.String screename_richiedente, boolean is_last,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Returns the last richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public RichiestaBadge fetchByRichiedente_Last(
		java.lang.String screename_richiedente, boolean is_last,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public RichiestaBadge[] findByRichiedente_PrevAndNext(long id_pk,
		java.lang.String screename_richiedente, boolean is_last,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Removes all the richiesta badges where screename_richiedente = &#63; and is_last = &#63; from the database.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	*/
	public void removeByRichiedente(java.lang.String screename_richiedente,
		boolean is_last);

	/**
	* Returns the number of richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	*
	* @param screename_richiedente the screename_richiedente
	* @param is_last the is_last
	* @return the number of matching richiesta badges
	*/
	public int countByRichiedente(java.lang.String screename_richiedente,
		boolean is_last);

	/**
	* Returns all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @return the matching richiesta badges
	*/
	public java.util.List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato);

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
	public java.util.List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end);

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
	public java.util.List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public java.util.List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache);

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
	public RichiestaBadge findByRuolo_First(boolean is_last,
		boolean is_internal, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public RichiestaBadge fetchByRuolo_First(boolean is_last,
		boolean is_internal, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public RichiestaBadge findByRuolo_Last(boolean is_last,
		boolean is_internal, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	*/
	public RichiestaBadge fetchByRuolo_Last(boolean is_last,
		boolean is_internal, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public RichiestaBadge[] findByRuolo_PrevAndNext(long id_pk,
		boolean is_last, boolean is_internal, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Removes all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; from the database.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	*/
	public void removeByRuolo(boolean is_last, boolean is_internal,
		long id_stato);

	/**
	* Returns the number of richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @return the number of matching richiesta badges
	*/
	public int countByRuolo(boolean is_last, boolean is_internal, long id_stato);

	/**
	* Returns all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @return the matching richiesta badges
	*/
	public java.util.List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap);

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
	public java.util.List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start, int end);

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
	public java.util.List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public java.util.List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache);

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
	public RichiestaBadge findByRuoloSede_First(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

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
	public RichiestaBadge fetchByRuoloSede_First(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public RichiestaBadge findByRuoloSede_Last(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

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
	public RichiestaBadge fetchByRuoloSede_Last(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public RichiestaBadge[] findByRuoloSede_PrevAndNext(long id_pk,
		boolean is_last, boolean is_internal, long id_stato, long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException;

	/**
	* Removes all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63; from the database.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	*/
	public void removeByRuoloSede(boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap);

	/**
	* Returns the number of richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	*
	* @param is_last the is_last
	* @param is_internal the is_internal
	* @param id_stato the id_stato
	* @param id_sedesiap the id_sedesiap
	* @return the number of matching richiesta badges
	*/
	public int countByRuoloSede(boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap);

	/**
	* Caches the richiesta badge in the entity cache if it is enabled.
	*
	* @param richiestaBadge the richiesta badge
	*/
	public void cacheResult(RichiestaBadge richiestaBadge);

	/**
	* Caches the richiesta badges in the entity cache if it is enabled.
	*
	* @param richiestaBadges the richiesta badges
	*/
	public void cacheResult(java.util.List<RichiestaBadge> richiestaBadges);

	/**
	* Creates a new richiesta badge with the primary key. Does not add the richiesta badge to the database.
	*
	* @param id_pk the primary key for the new richiesta badge
	* @return the new richiesta badge
	*/
	public RichiestaBadge create(long id_pk);

	/**
	* Removes the richiesta badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge that was removed
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public RichiestaBadge remove(long id_pk)
		throws NoSuchRichiestaBadgeException;

	public RichiestaBadge updateImpl(RichiestaBadge richiestaBadge);

	/**
	* Returns the richiesta badge with the primary key or throws a {@link NoSuchRichiestaBadgeException} if it could not be found.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge
	* @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	*/
	public RichiestaBadge findByPrimaryKey(long id_pk)
		throws NoSuchRichiestaBadgeException;

	/**
	* Returns the richiesta badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge, or <code>null</code> if a richiesta badge with the primary key could not be found
	*/
	public RichiestaBadge fetchByPrimaryKey(long id_pk);

	@Override
	public java.util.Map<java.io.Serializable, RichiestaBadge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richiesta badges.
	*
	* @return the richiesta badges
	*/
	public java.util.List<RichiestaBadge> findAll();

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
	public java.util.List<RichiestaBadge> findAll(int start, int end);

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
	public java.util.List<RichiestaBadge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator);

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
	public java.util.List<RichiestaBadge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richiesta badges from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richiesta badges.
	*
	* @return the number of richiesta badges
	*/
	public int countAll();
}