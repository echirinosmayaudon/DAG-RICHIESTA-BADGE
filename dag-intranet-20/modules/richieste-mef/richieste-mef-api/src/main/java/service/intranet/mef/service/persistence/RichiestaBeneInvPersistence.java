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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import service.intranet.mef.exception.NoSuchRichiestaBeneInvException;
import service.intranet.mef.model.RichiestaBeneInv;

/**
 * The persistence interface for the richiesta bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.RichiestaBeneInvPersistenceImpl
 * @see RichiestaBeneInvUtil
 * @generated
 */
@ProviderType
public interface RichiestaBeneInvPersistence extends BasePersistence<RichiestaBeneInv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaBeneInvUtil} to access the richiesta bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the richiesta bene invs where utente = &#63;.
	*
	* @param utente the utente
	* @return the matching richiesta bene invs
	*/
	public java.util.List<RichiestaBeneInv> findByUtente(
		java.lang.String utente);

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
	public java.util.List<RichiestaBeneInv> findByUtente(
		java.lang.String utente, int start, int end);

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
	public java.util.List<RichiestaBeneInv> findByUtente(
		java.lang.String utente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

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
	public java.util.List<RichiestaBeneInv> findByUtente(
		java.lang.String utente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv findByUtente_First(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Returns the first richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv fetchByUtente_First(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

	/**
	* Returns the last richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv findByUtente_Last(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Returns the last richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv fetchByUtente_Last(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

	/**
	* Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where utente = &#63;.
	*
	* @param id_richiesta the primary key of the current richiesta bene inv
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public RichiestaBeneInv[] findByUtente_PrevAndNext(long id_richiesta,
		java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Removes all the richiesta bene invs where utente = &#63; from the database.
	*
	* @param utente the utente
	*/
	public void removeByUtente(java.lang.String utente);

	/**
	* Returns the number of richiesta bene invs where utente = &#63;.
	*
	* @param utente the utente
	* @return the number of matching richiesta bene invs
	*/
	public int countByUtente(java.lang.String utente);

	/**
	* Returns all the richiesta bene invs where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @return the matching richiesta bene invs
	*/
	public java.util.List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir);

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
	public java.util.List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir, int start, int end);

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
	public java.util.List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

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
	public java.util.List<RichiestaBeneInv> findByDipartimento(
		java.lang.String dip_dir, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv findByDipartimento_First(java.lang.String dip_dir,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv fetchByDipartimento_First(
		java.lang.String dip_dir,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv findByDipartimento_Last(java.lang.String dip_dir,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv fetchByDipartimento_Last(java.lang.String dip_dir,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

	/**
	* Returns the richiesta bene invs before and after the current richiesta bene inv in the ordered set where dip_dir = &#63;.
	*
	* @param id_richiesta the primary key of the current richiesta bene inv
	* @param dip_dir the dip_dir
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public RichiestaBeneInv[] findByDipartimento_PrevAndNext(
		long id_richiesta, java.lang.String dip_dir,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Removes all the richiesta bene invs where dip_dir = &#63; from the database.
	*
	* @param dip_dir the dip_dir
	*/
	public void removeByDipartimento(java.lang.String dip_dir);

	/**
	* Returns the number of richiesta bene invs where dip_dir = &#63;.
	*
	* @param dip_dir the dip_dir
	* @return the number of matching richiesta bene invs
	*/
	public int countByDipartimento(java.lang.String dip_dir);

	/**
	* Returns all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @return the matching richiesta bene invs
	*/
	public java.util.List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato);

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
	public java.util.List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato, int start, int end);

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
	public java.util.List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

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
	public java.util.List<RichiestaBeneInv> findByDipartimentoStato(
		java.lang.String dip_dir, long id_stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv findByDipartimentoStato_First(
		java.lang.String dip_dir, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Returns the first richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv fetchByDipartimentoStato_First(
		java.lang.String dip_dir, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv findByDipartimentoStato_Last(
		java.lang.String dip_dir, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Returns the last richiesta bene inv in the ordered set where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richiesta bene inv, or <code>null</code> if a matching richiesta bene inv could not be found
	*/
	public RichiestaBeneInv fetchByDipartimentoStato_Last(
		java.lang.String dip_dir, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

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
	public RichiestaBeneInv[] findByDipartimentoStato_PrevAndNext(
		long id_richiesta, java.lang.String dip_dir, long id_stato,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Removes all the richiesta bene invs where dip_dir = &#63; and id_stato = &#63; from the database.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	*/
	public void removeByDipartimentoStato(java.lang.String dip_dir,
		long id_stato);

	/**
	* Returns the number of richiesta bene invs where dip_dir = &#63; and id_stato = &#63;.
	*
	* @param dip_dir the dip_dir
	* @param id_stato the id_stato
	* @return the number of matching richiesta bene invs
	*/
	public int countByDipartimentoStato(java.lang.String dip_dir, long id_stato);

	/**
	* Caches the richiesta bene inv in the entity cache if it is enabled.
	*
	* @param richiestaBeneInv the richiesta bene inv
	*/
	public void cacheResult(RichiestaBeneInv richiestaBeneInv);

	/**
	* Caches the richiesta bene invs in the entity cache if it is enabled.
	*
	* @param richiestaBeneInvs the richiesta bene invs
	*/
	public void cacheResult(java.util.List<RichiestaBeneInv> richiestaBeneInvs);

	/**
	* Creates a new richiesta bene inv with the primary key. Does not add the richiesta bene inv to the database.
	*
	* @param id_richiesta the primary key for the new richiesta bene inv
	* @return the new richiesta bene inv
	*/
	public RichiestaBeneInv create(long id_richiesta);

	/**
	* Removes the richiesta bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv that was removed
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public RichiestaBeneInv remove(long id_richiesta)
		throws NoSuchRichiestaBeneInvException;

	public RichiestaBeneInv updateImpl(RichiestaBeneInv richiestaBeneInv);

	/**
	* Returns the richiesta bene inv with the primary key or throws a {@link NoSuchRichiestaBeneInvException} if it could not be found.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv
	* @throws NoSuchRichiestaBeneInvException if a richiesta bene inv with the primary key could not be found
	*/
	public RichiestaBeneInv findByPrimaryKey(long id_richiesta)
		throws NoSuchRichiestaBeneInvException;

	/**
	* Returns the richiesta bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv, or <code>null</code> if a richiesta bene inv with the primary key could not be found
	*/
	public RichiestaBeneInv fetchByPrimaryKey(long id_richiesta);

	@Override
	public java.util.Map<java.io.Serializable, RichiestaBeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richiesta bene invs.
	*
	* @return the richiesta bene invs
	*/
	public java.util.List<RichiestaBeneInv> findAll();

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
	public java.util.List<RichiestaBeneInv> findAll(int start, int end);

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
	public java.util.List<RichiestaBeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator);

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
	public java.util.List<RichiestaBeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaBeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richiesta bene invs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richiesta bene invs.
	*
	* @return the number of richiesta bene invs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}