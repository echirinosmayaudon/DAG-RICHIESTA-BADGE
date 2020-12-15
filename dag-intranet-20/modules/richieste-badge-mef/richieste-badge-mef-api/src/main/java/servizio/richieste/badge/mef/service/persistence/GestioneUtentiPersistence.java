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

import servizio.richieste.badge.mef.exception.NoSuchGestioneUtentiException;
import servizio.richieste.badge.mef.model.GestioneUtenti;

/**
 * The persistence interface for the gestione utenti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.persistence.impl.GestioneUtentiPersistenceImpl
 * @see GestioneUtentiUtil
 * @generated
 */
@ProviderType
public interface GestioneUtentiPersistence extends BasePersistence<GestioneUtenti> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GestioneUtentiUtil} to access the gestione utenti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the gestione utenti in the entity cache if it is enabled.
	*
	* @param gestioneUtenti the gestione utenti
	*/
	public void cacheResult(GestioneUtenti gestioneUtenti);

	/**
	* Caches the gestione utentis in the entity cache if it is enabled.
	*
	* @param gestioneUtentis the gestione utentis
	*/
	public void cacheResult(java.util.List<GestioneUtenti> gestioneUtentis);

	/**
	* Creates a new gestione utenti with the primary key. Does not add the gestione utenti to the database.
	*
	* @param id_gest_utenti the primary key for the new gestione utenti
	* @return the new gestione utenti
	*/
	public GestioneUtenti create(long id_gest_utenti);

	/**
	* Removes the gestione utenti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_gest_utenti the primary key of the gestione utenti
	* @return the gestione utenti that was removed
	* @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	*/
	public GestioneUtenti remove(long id_gest_utenti)
		throws NoSuchGestioneUtentiException;

	public GestioneUtenti updateImpl(GestioneUtenti gestioneUtenti);

	/**
	* Returns the gestione utenti with the primary key or throws a {@link NoSuchGestioneUtentiException} if it could not be found.
	*
	* @param id_gest_utenti the primary key of the gestione utenti
	* @return the gestione utenti
	* @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	*/
	public GestioneUtenti findByPrimaryKey(long id_gest_utenti)
		throws NoSuchGestioneUtentiException;

	/**
	* Returns the gestione utenti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_gest_utenti the primary key of the gestione utenti
	* @return the gestione utenti, or <code>null</code> if a gestione utenti with the primary key could not be found
	*/
	public GestioneUtenti fetchByPrimaryKey(long id_gest_utenti);

	@Override
	public java.util.Map<java.io.Serializable, GestioneUtenti> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the gestione utentis.
	*
	* @return the gestione utentis
	*/
	public java.util.List<GestioneUtenti> findAll();

	/**
	* Returns a range of all the gestione utentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gestione utentis
	* @param end the upper bound of the range of gestione utentis (not inclusive)
	* @return the range of gestione utentis
	*/
	public java.util.List<GestioneUtenti> findAll(int start, int end);

	/**
	* Returns an ordered range of all the gestione utentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gestione utentis
	* @param end the upper bound of the range of gestione utentis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gestione utentis
	*/
	public java.util.List<GestioneUtenti> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GestioneUtenti> orderByComparator);

	/**
	* Returns an ordered range of all the gestione utentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gestione utentis
	* @param end the upper bound of the range of gestione utentis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of gestione utentis
	*/
	public java.util.List<GestioneUtenti> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GestioneUtenti> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the gestione utentis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of gestione utentis.
	*
	* @return the number of gestione utentis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}