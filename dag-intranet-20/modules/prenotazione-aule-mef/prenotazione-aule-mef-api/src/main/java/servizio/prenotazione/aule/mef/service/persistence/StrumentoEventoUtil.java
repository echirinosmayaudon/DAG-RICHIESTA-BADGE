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

import servizio.prenotazione.aule.mef.model.StrumentoEvento;

import java.util.List;

/**
 * The persistence utility for the strumento evento service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.StrumentoEventoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoEventoPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.StrumentoEventoPersistenceImpl
 * @generated
 */
@ProviderType
public class StrumentoEventoUtil {
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
	public static void clearCache(StrumentoEvento strumentoEvento) {
		getPersistence().clearCache(strumentoEvento);
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
	public static List<StrumentoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StrumentoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StrumentoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StrumentoEvento update(StrumentoEvento strumentoEvento) {
		return getPersistence().update(strumentoEvento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StrumentoEvento update(StrumentoEvento strumentoEvento,
		ServiceContext serviceContext) {
		return getPersistence().update(strumentoEvento, serviceContext);
	}

	/**
	* Returns all the strumento eventos where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the matching strumento eventos
	*/
	public static List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento) {
		return getPersistence().findByDescStrumento(desc_strumento);
	}

	/**
	* Returns a range of all the strumento eventos where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @return the range of matching strumento eventos
	*/
	public static List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end) {
		return getPersistence().findByDescStrumento(desc_strumento, start, end);
	}

	/**
	* Returns an ordered range of all the strumento eventos where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching strumento eventos
	*/
	public static List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		return getPersistence()
				   .findByDescStrumento(desc_strumento, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the strumento eventos where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching strumento eventos
	*/
	public static List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDescStrumento(desc_strumento, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento evento
	* @throws NoSuchStrumentoEventoException if a matching strumento evento could not be found
	*/
	public static StrumentoEvento findByDescStrumento_First(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoEventoException {
		return getPersistence()
				   .findByDescStrumento_First(desc_strumento, orderByComparator);
	}

	/**
	* Returns the first strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento evento, or <code>null</code> if a matching strumento evento could not be found
	*/
	public static StrumentoEvento fetchByDescStrumento_First(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		return getPersistence()
				   .fetchByDescStrumento_First(desc_strumento, orderByComparator);
	}

	/**
	* Returns the last strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento evento
	* @throws NoSuchStrumentoEventoException if a matching strumento evento could not be found
	*/
	public static StrumentoEvento findByDescStrumento_Last(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoEventoException {
		return getPersistence()
				   .findByDescStrumento_Last(desc_strumento, orderByComparator);
	}

	/**
	* Returns the last strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento evento, or <code>null</code> if a matching strumento evento could not be found
	*/
	public static StrumentoEvento fetchByDescStrumento_Last(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		return getPersistence()
				   .fetchByDescStrumento_Last(desc_strumento, orderByComparator);
	}

	/**
	* Returns the strumento eventos before and after the current strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param id_strumento the primary key of the current strumento evento
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next strumento evento
	* @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	*/
	public static StrumentoEvento[] findByDescStrumento_PrevAndNext(
		long id_strumento, java.lang.String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoEventoException {
		return getPersistence()
				   .findByDescStrumento_PrevAndNext(id_strumento,
			desc_strumento, orderByComparator);
	}

	/**
	* Removes all the strumento eventos where desc_strumento = &#63; from the database.
	*
	* @param desc_strumento the desc_strumento
	*/
	public static void removeByDescStrumento(java.lang.String desc_strumento) {
		getPersistence().removeByDescStrumento(desc_strumento);
	}

	/**
	* Returns the number of strumento eventos where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the number of matching strumento eventos
	*/
	public static int countByDescStrumento(java.lang.String desc_strumento) {
		return getPersistence().countByDescStrumento(desc_strumento);
	}

	/**
	* Caches the strumento evento in the entity cache if it is enabled.
	*
	* @param strumentoEvento the strumento evento
	*/
	public static void cacheResult(StrumentoEvento strumentoEvento) {
		getPersistence().cacheResult(strumentoEvento);
	}

	/**
	* Caches the strumento eventos in the entity cache if it is enabled.
	*
	* @param strumentoEventos the strumento eventos
	*/
	public static void cacheResult(List<StrumentoEvento> strumentoEventos) {
		getPersistence().cacheResult(strumentoEventos);
	}

	/**
	* Creates a new strumento evento with the primary key. Does not add the strumento evento to the database.
	*
	* @param id_strumento the primary key for the new strumento evento
	* @return the new strumento evento
	*/
	public static StrumentoEvento create(long id_strumento) {
		return getPersistence().create(id_strumento);
	}

	/**
	* Removes the strumento evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento that was removed
	* @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	*/
	public static StrumentoEvento remove(long id_strumento)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoEventoException {
		return getPersistence().remove(id_strumento);
	}

	public static StrumentoEvento updateImpl(StrumentoEvento strumentoEvento) {
		return getPersistence().updateImpl(strumentoEvento);
	}

	/**
	* Returns the strumento evento with the primary key or throws a {@link NoSuchStrumentoEventoException} if it could not be found.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento
	* @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	*/
	public static StrumentoEvento findByPrimaryKey(long id_strumento)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoEventoException {
		return getPersistence().findByPrimaryKey(id_strumento);
	}

	/**
	* Returns the strumento evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento, or <code>null</code> if a strumento evento with the primary key could not be found
	*/
	public static StrumentoEvento fetchByPrimaryKey(long id_strumento) {
		return getPersistence().fetchByPrimaryKey(id_strumento);
	}

	public static java.util.Map<java.io.Serializable, StrumentoEvento> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the strumento eventos.
	*
	* @return the strumento eventos
	*/
	public static List<StrumentoEvento> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the strumento eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @return the range of strumento eventos
	*/
	public static List<StrumentoEvento> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the strumento eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strumento eventos
	*/
	public static List<StrumentoEvento> findAll(int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the strumento eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strumento eventos
	*/
	public static List<StrumentoEvento> findAll(int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the strumento eventos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of strumento eventos.
	*
	* @return the number of strumento eventos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StrumentoEventoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StrumentoEventoPersistence, StrumentoEventoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StrumentoEventoPersistence.class);
}