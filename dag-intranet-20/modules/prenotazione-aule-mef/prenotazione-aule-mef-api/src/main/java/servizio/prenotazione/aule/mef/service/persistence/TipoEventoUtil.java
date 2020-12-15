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

import servizio.prenotazione.aule.mef.model.TipoEvento;

import java.util.List;

/**
 * The persistence utility for the tipo evento service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.TipoEventoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoEventoPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.TipoEventoPersistenceImpl
 * @generated
 */
@ProviderType
public class TipoEventoUtil {
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
	public static void clearCache(TipoEvento tipoEvento) {
		getPersistence().clearCache(tipoEvento);
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
	public static List<TipoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipoEvento update(TipoEvento tipoEvento) {
		return getPersistence().update(tipoEvento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipoEvento update(TipoEvento tipoEvento,
		ServiceContext serviceContext) {
		return getPersistence().update(tipoEvento, serviceContext);
	}

	/**
	* Caches the tipo evento in the entity cache if it is enabled.
	*
	* @param tipoEvento the tipo evento
	*/
	public static void cacheResult(TipoEvento tipoEvento) {
		getPersistence().cacheResult(tipoEvento);
	}

	/**
	* Caches the tipo eventos in the entity cache if it is enabled.
	*
	* @param tipoEventos the tipo eventos
	*/
	public static void cacheResult(List<TipoEvento> tipoEventos) {
		getPersistence().cacheResult(tipoEventos);
	}

	/**
	* Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	*
	* @param id_evento the primary key for the new tipo evento
	* @return the new tipo evento
	*/
	public static TipoEvento create(long id_evento) {
		return getPersistence().create(id_evento);
	}

	/**
	* Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento that was removed
	* @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	*/
	public static TipoEvento remove(long id_evento)
		throws servizio.prenotazione.aule.mef.exception.NoSuchTipoEventoException {
		return getPersistence().remove(id_evento);
	}

	public static TipoEvento updateImpl(TipoEvento tipoEvento) {
		return getPersistence().updateImpl(tipoEvento);
	}

	/**
	* Returns the tipo evento with the primary key or throws a {@link NoSuchTipoEventoException} if it could not be found.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento
	* @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	*/
	public static TipoEvento findByPrimaryKey(long id_evento)
		throws servizio.prenotazione.aule.mef.exception.NoSuchTipoEventoException {
		return getPersistence().findByPrimaryKey(id_evento);
	}

	/**
	* Returns the tipo evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento, or <code>null</code> if a tipo evento with the primary key could not be found
	*/
	public static TipoEvento fetchByPrimaryKey(long id_evento) {
		return getPersistence().fetchByPrimaryKey(id_evento);
	}

	public static java.util.Map<java.io.Serializable, TipoEvento> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tipo eventos.
	*
	* @return the tipo eventos
	*/
	public static List<TipoEvento> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tipo eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo eventos
	* @param end the upper bound of the range of tipo eventos (not inclusive)
	* @return the range of tipo eventos
	*/
	public static List<TipoEvento> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipo eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo eventos
	* @param end the upper bound of the range of tipo eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo eventos
	*/
	public static List<TipoEvento> findAll(int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tipo eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo eventos
	* @param end the upper bound of the range of tipo eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipo eventos
	*/
	public static List<TipoEvento> findAll(int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tipo eventos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipo eventos.
	*
	* @return the number of tipo eventos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipoEventoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipoEventoPersistence, TipoEventoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipoEventoPersistence.class);
}