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

import com.intranet.mef.gestione.riunioni.exception.NoSuchInvitatiRiunioneException;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the invitati riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.InvitatiRiunionePersistenceImpl
 * @see InvitatiRiunioneUtil
 * @generated
 */
@ProviderType
public interface InvitatiRiunionePersistence extends BasePersistence<InvitatiRiunione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvitatiRiunioneUtil} to access the invitati riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the invitati riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the matching invitati riuniones
	*/
	public java.util.List<InvitatiRiunione> findByRiunione(long id_riunione);

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
	public java.util.List<InvitatiRiunione> findByRiunione(long id_riunione,
		int start, int end);

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
	public java.util.List<InvitatiRiunione> findByRiunione(long id_riunione,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

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
	public java.util.List<InvitatiRiunione> findByRiunione(long id_riunione,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione findByRiunione_First(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Returns the first invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione fetchByRiunione_First(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

	/**
	* Returns the last invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione findByRiunione_Last(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Returns the last invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione fetchByRiunione_Last(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

	/**
	* Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_riunione = &#63;.
	*
	* @param invitatiRiunionePK the primary key of the current invitati riunione
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public InvitatiRiunione[] findByRiunione_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Removes all the invitati riuniones where id_riunione = &#63; from the database.
	*
	* @param id_riunione the id_riunione
	*/
	public void removeByRiunione(long id_riunione);

	/**
	* Returns the number of invitati riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the number of matching invitati riuniones
	*/
	public int countByRiunione(long id_riunione);

	/**
	* Returns all the invitati riuniones where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @return the matching invitati riuniones
	*/
	public java.util.List<InvitatiRiunione> findBySegreteria(long id_segreteria);

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
	public java.util.List<InvitatiRiunione> findBySegreteria(
		long id_segreteria, int start, int end);

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
	public java.util.List<InvitatiRiunione> findBySegreteria(
		long id_segreteria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

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
	public java.util.List<InvitatiRiunione> findBySegreteria(
		long id_segreteria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione findBySegreteria_First(long id_segreteria,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione fetchBySegreteria_First(long id_segreteria,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione findBySegreteria_Last(long id_segreteria,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione fetchBySegreteria_Last(long id_segreteria,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

	/**
	* Returns the invitati riuniones before and after the current invitati riunione in the ordered set where id_segreteria = &#63;.
	*
	* @param invitatiRiunionePK the primary key of the current invitati riunione
	* @param id_segreteria the id_segreteria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public InvitatiRiunione[] findBySegreteria_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_segreteria,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Removes all the invitati riuniones where id_segreteria = &#63; from the database.
	*
	* @param id_segreteria the id_segreteria
	*/
	public void removeBySegreteria(long id_segreteria);

	/**
	* Returns the number of invitati riuniones where id_segreteria = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @return the number of matching invitati riuniones
	*/
	public int countBySegreteria(long id_segreteria);

	/**
	* Returns all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @return the matching invitati riuniones
	*/
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione);

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
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione, int start, int end);

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
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

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
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long id_riunione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione findBySegreteriaRiunione_First(long id_segreteria,
		long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Returns the first invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione fetchBySegreteriaRiunione_First(
		long id_segreteria, long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione findBySegreteriaRiunione_Last(long id_segreteria,
		long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Returns the last invitati riunione in the ordered set where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitati riunione, or <code>null</code> if a matching invitati riunione could not be found
	*/
	public InvitatiRiunione fetchBySegreteriaRiunione_Last(long id_segreteria,
		long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

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
	public InvitatiRiunione[] findBySegreteriaRiunione_PrevAndNext(
		InvitatiRiunionePK invitatiRiunionePK, long id_segreteria,
		long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator)
		throws NoSuchInvitatiRiunioneException;

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
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones);

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
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones, int start, int end);

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
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

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
	public java.util.List<InvitatiRiunione> findBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the invitati riuniones where id_segreteria = &#63; and id_riunione = &#63; from the database.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	*/
	public void removeBySegreteriaRiunione(long id_segreteria, long id_riunione);

	/**
	* Returns the number of invitati riuniones where id_segreteria = &#63; and id_riunione = &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riunione the id_riunione
	* @return the number of matching invitati riuniones
	*/
	public int countBySegreteriaRiunione(long id_segreteria, long id_riunione);

	/**
	* Returns the number of invitati riuniones where id_segreteria = &#63; and id_riunione = any &#63;.
	*
	* @param id_segreteria the id_segreteria
	* @param id_riuniones the id_riuniones
	* @return the number of matching invitati riuniones
	*/
	public int countBySegreteriaRiunione(long id_segreteria, long[] id_riuniones);

	/**
	* Caches the invitati riunione in the entity cache if it is enabled.
	*
	* @param invitatiRiunione the invitati riunione
	*/
	public void cacheResult(InvitatiRiunione invitatiRiunione);

	/**
	* Caches the invitati riuniones in the entity cache if it is enabled.
	*
	* @param invitatiRiuniones the invitati riuniones
	*/
	public void cacheResult(java.util.List<InvitatiRiunione> invitatiRiuniones);

	/**
	* Creates a new invitati riunione with the primary key. Does not add the invitati riunione to the database.
	*
	* @param invitatiRiunionePK the primary key for the new invitati riunione
	* @return the new invitati riunione
	*/
	public InvitatiRiunione create(InvitatiRiunionePK invitatiRiunionePK);

	/**
	* Removes the invitati riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione that was removed
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public InvitatiRiunione remove(InvitatiRiunionePK invitatiRiunionePK)
		throws NoSuchInvitatiRiunioneException;

	public InvitatiRiunione updateImpl(InvitatiRiunione invitatiRiunione);

	/**
	* Returns the invitati riunione with the primary key or throws a {@link NoSuchInvitatiRiunioneException} if it could not be found.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione
	* @throws NoSuchInvitatiRiunioneException if a invitati riunione with the primary key could not be found
	*/
	public InvitatiRiunione findByPrimaryKey(
		InvitatiRiunionePK invitatiRiunionePK)
		throws NoSuchInvitatiRiunioneException;

	/**
	* Returns the invitati riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione, or <code>null</code> if a invitati riunione with the primary key could not be found
	*/
	public InvitatiRiunione fetchByPrimaryKey(
		InvitatiRiunionePK invitatiRiunionePK);

	@Override
	public java.util.Map<java.io.Serializable, InvitatiRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the invitati riuniones.
	*
	* @return the invitati riuniones
	*/
	public java.util.List<InvitatiRiunione> findAll();

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
	public java.util.List<InvitatiRiunione> findAll(int start, int end);

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
	public java.util.List<InvitatiRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator);

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
	public java.util.List<InvitatiRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvitatiRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the invitati riuniones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of invitati riuniones.
	*
	* @return the number of invitati riuniones
	*/
	public int countAll();
}