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

package servizio.prenotazione.aule.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.prenotazione.aule.mef.exception.NoSuchPrenotazioneException;
import servizio.prenotazione.aule.mef.model.Prenotazione;

/**
 * The persistence interface for the prenotazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.PrenotazionePersistenceImpl
 * @see PrenotazioneUtil
 * @generated
 */
@ProviderType
public interface PrenotazionePersistence extends BasePersistence<Prenotazione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrenotazioneUtil} to access the prenotazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the prenotaziones where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @return the matching prenotaziones
	*/
	public java.util.List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale);

	/**
	* Returns a range of all the prenotaziones where cod_fiscale = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cod_fiscale the cod_fiscale
	* @param start the lower bound of the range of prenotaziones
	* @param end the upper bound of the range of prenotaziones (not inclusive)
	* @return the range of matching prenotaziones
	*/
	public java.util.List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale, int start, int end);

	/**
	* Returns an ordered range of all the prenotaziones where cod_fiscale = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cod_fiscale the cod_fiscale
	* @param start the lower bound of the range of prenotaziones
	* @param end the upper bound of the range of prenotaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching prenotaziones
	*/
	public java.util.List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator);

	/**
	* Returns an ordered range of all the prenotaziones where cod_fiscale = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cod_fiscale the cod_fiscale
	* @param start the lower bound of the range of prenotaziones
	* @param end the upper bound of the range of prenotaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching prenotaziones
	*/
	public java.util.List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching prenotazione
	* @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	*/
	public Prenotazione findByCodFiscale_First(java.lang.String cod_fiscale,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	* Returns the first prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	*/
	public Prenotazione fetchByCodFiscale_First(java.lang.String cod_fiscale,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator);

	/**
	* Returns the last prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching prenotazione
	* @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	*/
	public Prenotazione findByCodFiscale_Last(java.lang.String cod_fiscale,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	* Returns the last prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	*/
	public Prenotazione fetchByCodFiscale_Last(java.lang.String cod_fiscale,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator);

	/**
	* Returns the prenotaziones before and after the current prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param id_prenota the primary key of the current prenotazione
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next prenotazione
	* @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	*/
	public Prenotazione[] findByCodFiscale_PrevAndNext(long id_prenota,
		java.lang.String cod_fiscale,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	* Removes all the prenotaziones where cod_fiscale = &#63; from the database.
	*
	* @param cod_fiscale the cod_fiscale
	*/
	public void removeByCodFiscale(java.lang.String cod_fiscale);

	/**
	* Returns the number of prenotaziones where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @return the number of matching prenotaziones
	*/
	public int countByCodFiscale(java.lang.String cod_fiscale);

	/**
	* Caches the prenotazione in the entity cache if it is enabled.
	*
	* @param prenotazione the prenotazione
	*/
	public void cacheResult(Prenotazione prenotazione);

	/**
	* Caches the prenotaziones in the entity cache if it is enabled.
	*
	* @param prenotaziones the prenotaziones
	*/
	public void cacheResult(java.util.List<Prenotazione> prenotaziones);

	/**
	* Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	*
	* @param id_prenota the primary key for the new prenotazione
	* @return the new prenotazione
	*/
	public Prenotazione create(long id_prenota);

	/**
	* Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione that was removed
	* @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	*/
	public Prenotazione remove(long id_prenota)
		throws NoSuchPrenotazioneException;

	public Prenotazione updateImpl(Prenotazione prenotazione);

	/**
	* Returns the prenotazione with the primary key or throws a {@link NoSuchPrenotazioneException} if it could not be found.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione
	* @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	*/
	public Prenotazione findByPrimaryKey(long id_prenota)
		throws NoSuchPrenotazioneException;

	/**
	* Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	*/
	public Prenotazione fetchByPrimaryKey(long id_prenota);

	@Override
	public java.util.Map<java.io.Serializable, Prenotazione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the prenotaziones.
	*
	* @return the prenotaziones
	*/
	public java.util.List<Prenotazione> findAll();

	/**
	* Returns a range of all the prenotaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of prenotaziones
	* @param end the upper bound of the range of prenotaziones (not inclusive)
	* @return the range of prenotaziones
	*/
	public java.util.List<Prenotazione> findAll(int start, int end);

	/**
	* Returns an ordered range of all the prenotaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of prenotaziones
	* @param end the upper bound of the range of prenotaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of prenotaziones
	*/
	public java.util.List<Prenotazione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator);

	/**
	* Returns an ordered range of all the prenotaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of prenotaziones
	* @param end the upper bound of the range of prenotaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of prenotaziones
	*/
	public java.util.List<Prenotazione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the prenotaziones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of prenotaziones.
	*
	* @return the number of prenotaziones
	*/
	public int countAll();
}