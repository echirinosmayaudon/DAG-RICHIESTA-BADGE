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

package servizio.prenotazione.aule.servizi.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumEventoException;
import servizio.prenotazione.aule.servizi.mef.model.StrumEvento;

/**
 * The persistence interface for the strum evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.impl.StrumEventoPersistenceImpl
 * @see StrumEventoUtil
 * @generated
 */
@ProviderType
public interface StrumEventoPersistence extends BasePersistence<StrumEvento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StrumEventoUtil} to access the strum evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the strum evento in the entity cache if it is enabled.
	*
	* @param strumEvento the strum evento
	*/
	public void cacheResult(StrumEvento strumEvento);

	/**
	* Caches the strum eventos in the entity cache if it is enabled.
	*
	* @param strumEventos the strum eventos
	*/
	public void cacheResult(java.util.List<StrumEvento> strumEventos);

	/**
	* Creates a new strum evento with the primary key. Does not add the strum evento to the database.
	*
	* @param strumEventoPK the primary key for the new strum evento
	* @return the new strum evento
	*/
	public StrumEvento create(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK);

	/**
	* Removes the strum evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento that was removed
	* @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	*/
	public StrumEvento remove(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK)
		throws NoSuchStrumEventoException;

	public StrumEvento updateImpl(StrumEvento strumEvento);

	/**
	* Returns the strum evento with the primary key or throws a {@link NoSuchStrumEventoException} if it could not be found.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento
	* @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	*/
	public StrumEvento findByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK)
		throws NoSuchStrumEventoException;

	/**
	* Returns the strum evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento, or <code>null</code> if a strum evento with the primary key could not be found
	*/
	public StrumEvento fetchByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK);

	@Override
	public java.util.Map<java.io.Serializable, StrumEvento> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the strum eventos.
	*
	* @return the strum eventos
	*/
	public java.util.List<StrumEvento> findAll();

	/**
	* Returns a range of all the strum eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum eventos
	* @param end the upper bound of the range of strum eventos (not inclusive)
	* @return the range of strum eventos
	*/
	public java.util.List<StrumEvento> findAll(int start, int end);

	/**
	* Returns an ordered range of all the strum eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum eventos
	* @param end the upper bound of the range of strum eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strum eventos
	*/
	public java.util.List<StrumEvento> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumEvento> orderByComparator);

	/**
	* Returns an ordered range of all the strum eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum eventos
	* @param end the upper bound of the range of strum eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strum eventos
	*/
	public java.util.List<StrumEvento> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumEvento> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the strum eventos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of strum eventos.
	*
	* @return the number of strum eventos
	*/
	public int countAll();
}