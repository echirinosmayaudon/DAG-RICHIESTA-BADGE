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

import servizio.richieste.badge.mef.exception.NoSuchOggettoRichiestaException;
import servizio.richieste.badge.mef.model.OggettoRichiesta;

/**
 * The persistence interface for the oggetto richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.persistence.impl.OggettoRichiestaPersistenceImpl
 * @see OggettoRichiestaUtil
 * @generated
 */
@ProviderType
public interface OggettoRichiestaPersistence extends BasePersistence<OggettoRichiesta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OggettoRichiestaUtil} to access the oggetto richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the oggetto richiesta in the entity cache if it is enabled.
	*
	* @param oggettoRichiesta the oggetto richiesta
	*/
	public void cacheResult(OggettoRichiesta oggettoRichiesta);

	/**
	* Caches the oggetto richiestas in the entity cache if it is enabled.
	*
	* @param oggettoRichiestas the oggetto richiestas
	*/
	public void cacheResult(java.util.List<OggettoRichiesta> oggettoRichiestas);

	/**
	* Creates a new oggetto richiesta with the primary key. Does not add the oggetto richiesta to the database.
	*
	* @param id_oggetto the primary key for the new oggetto richiesta
	* @return the new oggetto richiesta
	*/
	public OggettoRichiesta create(long id_oggetto);

	/**
	* Removes the oggetto richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta that was removed
	* @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	*/
	public OggettoRichiesta remove(long id_oggetto)
		throws NoSuchOggettoRichiestaException;

	public OggettoRichiesta updateImpl(OggettoRichiesta oggettoRichiesta);

	/**
	* Returns the oggetto richiesta with the primary key or throws a {@link NoSuchOggettoRichiestaException} if it could not be found.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta
	* @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	*/
	public OggettoRichiesta findByPrimaryKey(long id_oggetto)
		throws NoSuchOggettoRichiestaException;

	/**
	* Returns the oggetto richiesta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta, or <code>null</code> if a oggetto richiesta with the primary key could not be found
	*/
	public OggettoRichiesta fetchByPrimaryKey(long id_oggetto);

	@Override
	public java.util.Map<java.io.Serializable, OggettoRichiesta> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the oggetto richiestas.
	*
	* @return the oggetto richiestas
	*/
	public java.util.List<OggettoRichiesta> findAll();

	/**
	* Returns a range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @return the range of oggetto richiestas
	*/
	public java.util.List<OggettoRichiesta> findAll(int start, int end);

	/**
	* Returns an ordered range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of oggetto richiestas
	*/
	public java.util.List<OggettoRichiesta> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OggettoRichiesta> orderByComparator);

	/**
	* Returns an ordered range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of oggetto richiestas
	*/
	public java.util.List<OggettoRichiesta> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OggettoRichiesta> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the oggetto richiestas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of oggetto richiestas.
	*
	* @return the number of oggetto richiestas
	*/
	public int countAll();
}