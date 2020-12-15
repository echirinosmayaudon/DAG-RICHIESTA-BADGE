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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.mef.model.Prenotazione;

import java.util.List;

/**
 * The persistence utility for the prenotazione service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.PrenotazionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazionePersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.PrenotazionePersistenceImpl
 * @generated
 */
@ProviderType
public class PrenotazioneUtil {
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
	public static void clearCache(Prenotazione prenotazione) {
		getPersistence().clearCache(prenotazione);
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
	public static List<Prenotazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Prenotazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Prenotazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Prenotazione update(Prenotazione prenotazione) {
		return getPersistence().update(prenotazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Prenotazione update(Prenotazione prenotazione,
		ServiceContext serviceContext) {
		return getPersistence().update(prenotazione, serviceContext);
	}

	/**
	* Returns all the prenotaziones where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @return the matching prenotaziones
	*/
	public static List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale) {
		return getPersistence().findByCodFiscale(cod_fiscale);
	}

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
	public static List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale, int start, int end) {
		return getPersistence().findByCodFiscale(cod_fiscale, start, end);
	}

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
	public static List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {
		return getPersistence()
				   .findByCodFiscale(cod_fiscale, start, end, orderByComparator);
	}

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
	public static List<Prenotazione> findByCodFiscale(
		java.lang.String cod_fiscale, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCodFiscale(cod_fiscale, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching prenotazione
	* @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	*/
	public static Prenotazione findByCodFiscale_First(
		java.lang.String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchPrenotazioneException {
		return getPersistence()
				   .findByCodFiscale_First(cod_fiscale, orderByComparator);
	}

	/**
	* Returns the first prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	*/
	public static Prenotazione fetchByCodFiscale_First(
		java.lang.String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator) {
		return getPersistence()
				   .fetchByCodFiscale_First(cod_fiscale, orderByComparator);
	}

	/**
	* Returns the last prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching prenotazione
	* @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	*/
	public static Prenotazione findByCodFiscale_Last(
		java.lang.String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchPrenotazioneException {
		return getPersistence()
				   .findByCodFiscale_Last(cod_fiscale, orderByComparator);
	}

	/**
	* Returns the last prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	*/
	public static Prenotazione fetchByCodFiscale_Last(
		java.lang.String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator) {
		return getPersistence()
				   .fetchByCodFiscale_Last(cod_fiscale, orderByComparator);
	}

	/**
	* Returns the prenotaziones before and after the current prenotazione in the ordered set where cod_fiscale = &#63;.
	*
	* @param id_prenota the primary key of the current prenotazione
	* @param cod_fiscale the cod_fiscale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next prenotazione
	* @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	*/
	public static Prenotazione[] findByCodFiscale_PrevAndNext(long id_prenota,
		java.lang.String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchPrenotazioneException {
		return getPersistence()
				   .findByCodFiscale_PrevAndNext(id_prenota, cod_fiscale,
			orderByComparator);
	}

	/**
	* Removes all the prenotaziones where cod_fiscale = &#63; from the database.
	*
	* @param cod_fiscale the cod_fiscale
	*/
	public static void removeByCodFiscale(java.lang.String cod_fiscale) {
		getPersistence().removeByCodFiscale(cod_fiscale);
	}

	/**
	* Returns the number of prenotaziones where cod_fiscale = &#63;.
	*
	* @param cod_fiscale the cod_fiscale
	* @return the number of matching prenotaziones
	*/
	public static int countByCodFiscale(java.lang.String cod_fiscale) {
		return getPersistence().countByCodFiscale(cod_fiscale);
	}

	/**
	* Caches the prenotazione in the entity cache if it is enabled.
	*
	* @param prenotazione the prenotazione
	*/
	public static void cacheResult(Prenotazione prenotazione) {
		getPersistence().cacheResult(prenotazione);
	}

	/**
	* Caches the prenotaziones in the entity cache if it is enabled.
	*
	* @param prenotaziones the prenotaziones
	*/
	public static void cacheResult(List<Prenotazione> prenotaziones) {
		getPersistence().cacheResult(prenotaziones);
	}

	/**
	* Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	*
	* @param id_prenota the primary key for the new prenotazione
	* @return the new prenotazione
	*/
	public static Prenotazione create(long id_prenota) {
		return getPersistence().create(id_prenota);
	}

	/**
	* Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione that was removed
	* @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	*/
	public static Prenotazione remove(long id_prenota)
		throws servizio.prenotazione.aule.mef.exception.NoSuchPrenotazioneException {
		return getPersistence().remove(id_prenota);
	}

	public static Prenotazione updateImpl(Prenotazione prenotazione) {
		return getPersistence().updateImpl(prenotazione);
	}

	/**
	* Returns the prenotazione with the primary key or throws a {@link NoSuchPrenotazioneException} if it could not be found.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione
	* @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	*/
	public static Prenotazione findByPrimaryKey(long id_prenota)
		throws servizio.prenotazione.aule.mef.exception.NoSuchPrenotazioneException {
		return getPersistence().findByPrimaryKey(id_prenota);
	}

	/**
	* Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	*/
	public static Prenotazione fetchByPrimaryKey(long id_prenota) {
		return getPersistence().fetchByPrimaryKey(id_prenota);
	}

	public static java.util.Map<java.io.Serializable, Prenotazione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the prenotaziones.
	*
	* @return the prenotaziones
	*/
	public static List<Prenotazione> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Prenotazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Prenotazione> findAll(int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Prenotazione> findAll(int start, int end,
		OrderByComparator<Prenotazione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the prenotaziones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of prenotaziones.
	*
	* @return the number of prenotaziones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PrenotazionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PrenotazionePersistence, PrenotazionePersistence> _serviceTracker =
		ServiceTrackerFactory.open(PrenotazionePersistence.class);
}