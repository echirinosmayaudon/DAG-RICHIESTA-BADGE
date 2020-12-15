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

import com.intranet.mef.gestione.riunioni.exception.NoSuchStatoInvitatoException;
import com.intranet.mef.gestione.riunioni.model.StatoInvitato;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the stato invitato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.StatoInvitatoPersistenceImpl
 * @see StatoInvitatoUtil
 * @generated
 */
@ProviderType
public interface StatoInvitatoPersistence extends BasePersistence<StatoInvitato> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatoInvitatoUtil} to access the stato invitato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the stato invitato in the entity cache if it is enabled.
	*
	* @param statoInvitato the stato invitato
	*/
	public void cacheResult(StatoInvitato statoInvitato);

	/**
	* Caches the stato invitatos in the entity cache if it is enabled.
	*
	* @param statoInvitatos the stato invitatos
	*/
	public void cacheResult(java.util.List<StatoInvitato> statoInvitatos);

	/**
	* Creates a new stato invitato with the primary key. Does not add the stato invitato to the database.
	*
	* @param id_stato_invitato the primary key for the new stato invitato
	* @return the new stato invitato
	*/
	public StatoInvitato create(long id_stato_invitato);

	/**
	* Removes the stato invitato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato that was removed
	* @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	*/
	public StatoInvitato remove(long id_stato_invitato)
		throws NoSuchStatoInvitatoException;

	public StatoInvitato updateImpl(StatoInvitato statoInvitato);

	/**
	* Returns the stato invitato with the primary key or throws a {@link NoSuchStatoInvitatoException} if it could not be found.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato
	* @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	*/
	public StatoInvitato findByPrimaryKey(long id_stato_invitato)
		throws NoSuchStatoInvitatoException;

	/**
	* Returns the stato invitato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato, or <code>null</code> if a stato invitato with the primary key could not be found
	*/
	public StatoInvitato fetchByPrimaryKey(long id_stato_invitato);

	@Override
	public java.util.Map<java.io.Serializable, StatoInvitato> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the stato invitatos.
	*
	* @return the stato invitatos
	*/
	public java.util.List<StatoInvitato> findAll();

	/**
	* Returns a range of all the stato invitatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato invitatos
	* @param end the upper bound of the range of stato invitatos (not inclusive)
	* @return the range of stato invitatos
	*/
	public java.util.List<StatoInvitato> findAll(int start, int end);

	/**
	* Returns an ordered range of all the stato invitatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato invitatos
	* @param end the upper bound of the range of stato invitatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato invitatos
	*/
	public java.util.List<StatoInvitato> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoInvitato> orderByComparator);

	/**
	* Returns an ordered range of all the stato invitatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato invitatos
	* @param end the upper bound of the range of stato invitatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato invitatos
	*/
	public java.util.List<StatoInvitato> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoInvitato> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the stato invitatos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of stato invitatos.
	*
	* @return the number of stato invitatos
	*/
	public int countAll();
}