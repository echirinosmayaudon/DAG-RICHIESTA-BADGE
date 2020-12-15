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

package servizio.beni.facile.consumo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException;
import servizio.beni.facile.consumo.model.RigheRichiestaBFC;

/**
 * The persistence interface for the righe richiesta b f c service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.persistence.impl.RigheRichiestaBFCPersistenceImpl
 * @see RigheRichiestaBFCUtil
 * @generated
 */
@ProviderType
public interface RigheRichiestaBFCPersistence extends BasePersistence<RigheRichiestaBFC> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RigheRichiestaBFCUtil} to access the righe richiesta b f c persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento);

	/**
	* Returns a range of all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento, int start, int end);

	/**
	* Returns an ordered range of all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator);

	/**
	* Returns an ordered range of all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC findByDipartimento_First(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws NoSuchRigheRichiestaBFCException;

	/**
	* Returns the first righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC fetchByDipartimento_First(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator);

	/**
	* Returns the last righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC findByDipartimento_Last(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws NoSuchRigheRichiestaBFCException;

	/**
	* Returns the last righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC fetchByDipartimento_Last(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator);

	/**
	* Returns the righe richiesta b f cs before and after the current righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param id the primary key of the current righe richiesta b f c
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public RigheRichiestaBFC[] findByDipartimento_PrevAndNext(long id,
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws NoSuchRigheRichiestaBFCException;

	/**
	* Removes all the righe richiesta b f cs where dipartimento = &#63; from the database.
	*
	* @param dipartimento the dipartimento
	*/
	public void removeByDipartimento(java.lang.String dipartimento);

	/**
	* Returns the number of righe richiesta b f cs where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the number of matching righe richiesta b f cs
	*/
	public int countByDipartimento(java.lang.String dipartimento);

	/**
	* Returns all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByIdRichiesta(
		long id_richiesta);

	/**
	* Returns a range of all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByIdRichiesta(
		long id_richiesta, int start, int end);

	/**
	* Returns an ordered range of all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByIdRichiesta(
		long id_richiesta, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator);

	/**
	* Returns an ordered range of all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findByIdRichiesta(
		long id_richiesta, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC findByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws NoSuchRigheRichiestaBFCException;

	/**
	* Returns the first righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC fetchByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator);

	/**
	* Returns the last righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC findByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws NoSuchRigheRichiestaBFCException;

	/**
	* Returns the last righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public RigheRichiestaBFC fetchByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator);

	/**
	* Returns the righe richiesta b f cs before and after the current righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id the primary key of the current righe richiesta b f c
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public RigheRichiestaBFC[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws NoSuchRigheRichiestaBFCException;

	/**
	* Removes all the righe richiesta b f cs where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public void removeByIdRichiesta(long id_richiesta);

	/**
	* Returns the number of righe richiesta b f cs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching righe richiesta b f cs
	*/
	public int countByIdRichiesta(long id_richiesta);

	/**
	* Caches the righe richiesta b f c in the entity cache if it is enabled.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	*/
	public void cacheResult(RigheRichiestaBFC righeRichiestaBFC);

	/**
	* Caches the righe richiesta b f cs in the entity cache if it is enabled.
	*
	* @param righeRichiestaBFCs the righe richiesta b f cs
	*/
	public void cacheResult(
		java.util.List<RigheRichiestaBFC> righeRichiestaBFCs);

	/**
	* Creates a new righe richiesta b f c with the primary key. Does not add the righe richiesta b f c to the database.
	*
	* @param id the primary key for the new righe richiesta b f c
	* @return the new righe richiesta b f c
	*/
	public RigheRichiestaBFC create(long id);

	/**
	* Removes the righe richiesta b f c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c that was removed
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public RigheRichiestaBFC remove(long id)
		throws NoSuchRigheRichiestaBFCException;

	public RigheRichiestaBFC updateImpl(RigheRichiestaBFC righeRichiestaBFC);

	/**
	* Returns the righe richiesta b f c with the primary key or throws a {@link NoSuchRigheRichiestaBFCException} if it could not be found.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public RigheRichiestaBFC findByPrimaryKey(long id)
		throws NoSuchRigheRichiestaBFCException;

	/**
	* Returns the righe richiesta b f c with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c, or <code>null</code> if a righe richiesta b f c with the primary key could not be found
	*/
	public RigheRichiestaBFC fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, RigheRichiestaBFC> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the righe richiesta b f cs.
	*
	* @return the righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findAll();

	/**
	* Returns a range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findAll(int start, int end);

	/**
	* Returns an ordered range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator);

	/**
	* Returns an ordered range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe richiesta b f cs
	*/
	public java.util.List<RigheRichiestaBFC> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiestaBFC> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the righe richiesta b f cs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of righe richiesta b f cs.
	*
	* @return the number of righe richiesta b f cs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}