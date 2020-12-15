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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.beni.facile.consumo.model.ServizioMateriale;

import java.util.List;

/**
 * The persistence utility for the servizio materiale service. This utility wraps {@link servizio.beni.facile.consumo.service.persistence.impl.ServizioMaterialePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioMaterialePersistence
 * @see servizio.beni.facile.consumo.service.persistence.impl.ServizioMaterialePersistenceImpl
 * @generated
 */
@ProviderType
public class ServizioMaterialeUtil {
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
	public static void clearCache(ServizioMateriale servizioMateriale) {
		getPersistence().clearCache(servizioMateriale);
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
	public static List<ServizioMateriale> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServizioMateriale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServizioMateriale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServizioMateriale update(ServizioMateriale servizioMateriale) {
		return getPersistence().update(servizioMateriale);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServizioMateriale update(
		ServizioMateriale servizioMateriale, ServiceContext serviceContext) {
		return getPersistence().update(servizioMateriale, serviceContext);
	}

	/**
	* Returns all the servizio materiales where categoria = &#63;.
	*
	* @param categoria the categoria
	* @return the matching servizio materiales
	*/
	public static List<ServizioMateriale> findByCategoria(
		java.lang.String categoria) {
		return getPersistence().findByCategoria(categoria);
	}

	/**
	* Returns a range of all the servizio materiales where categoria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoria the categoria
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @return the range of matching servizio materiales
	*/
	public static List<ServizioMateriale> findByCategoria(
		java.lang.String categoria, int start, int end) {
		return getPersistence().findByCategoria(categoria, start, end);
	}

	/**
	* Returns an ordered range of all the servizio materiales where categoria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoria the categoria
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servizio materiales
	*/
	public static List<ServizioMateriale> findByCategoria(
		java.lang.String categoria, int start, int end,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		return getPersistence()
				   .findByCategoria(categoria, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servizio materiales where categoria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoria the categoria
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servizio materiales
	*/
	public static List<ServizioMateriale> findByCategoria(
		java.lang.String categoria, int start, int end,
		OrderByComparator<ServizioMateriale> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCategoria(categoria, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio materiale
	* @throws NoSuchServizioMaterialeException if a matching servizio materiale could not be found
	*/
	public static ServizioMateriale findByCategoria_First(
		java.lang.String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchServizioMaterialeException {
		return getPersistence()
				   .findByCategoria_First(categoria, orderByComparator);
	}

	/**
	* Returns the first servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio materiale, or <code>null</code> if a matching servizio materiale could not be found
	*/
	public static ServizioMateriale fetchByCategoria_First(
		java.lang.String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		return getPersistence()
				   .fetchByCategoria_First(categoria, orderByComparator);
	}

	/**
	* Returns the last servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio materiale
	* @throws NoSuchServizioMaterialeException if a matching servizio materiale could not be found
	*/
	public static ServizioMateriale findByCategoria_Last(
		java.lang.String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchServizioMaterialeException {
		return getPersistence()
				   .findByCategoria_Last(categoria, orderByComparator);
	}

	/**
	* Returns the last servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio materiale, or <code>null</code> if a matching servizio materiale could not be found
	*/
	public static ServizioMateriale fetchByCategoria_Last(
		java.lang.String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		return getPersistence()
				   .fetchByCategoria_Last(categoria, orderByComparator);
	}

	/**
	* Returns the servizio materiales before and after the current servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param gruppo the primary key of the current servizio materiale
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next servizio materiale
	* @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	*/
	public static ServizioMateriale[] findByCategoria_PrevAndNext(
		java.lang.String gruppo, java.lang.String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchServizioMaterialeException {
		return getPersistence()
				   .findByCategoria_PrevAndNext(gruppo, categoria,
			orderByComparator);
	}

	/**
	* Removes all the servizio materiales where categoria = &#63; from the database.
	*
	* @param categoria the categoria
	*/
	public static void removeByCategoria(java.lang.String categoria) {
		getPersistence().removeByCategoria(categoria);
	}

	/**
	* Returns the number of servizio materiales where categoria = &#63;.
	*
	* @param categoria the categoria
	* @return the number of matching servizio materiales
	*/
	public static int countByCategoria(java.lang.String categoria) {
		return getPersistence().countByCategoria(categoria);
	}

	/**
	* Caches the servizio materiale in the entity cache if it is enabled.
	*
	* @param servizioMateriale the servizio materiale
	*/
	public static void cacheResult(ServizioMateriale servizioMateriale) {
		getPersistence().cacheResult(servizioMateriale);
	}

	/**
	* Caches the servizio materiales in the entity cache if it is enabled.
	*
	* @param servizioMateriales the servizio materiales
	*/
	public static void cacheResult(List<ServizioMateriale> servizioMateriales) {
		getPersistence().cacheResult(servizioMateriales);
	}

	/**
	* Creates a new servizio materiale with the primary key. Does not add the servizio materiale to the database.
	*
	* @param gruppo the primary key for the new servizio materiale
	* @return the new servizio materiale
	*/
	public static ServizioMateriale create(java.lang.String gruppo) {
		return getPersistence().create(gruppo);
	}

	/**
	* Removes the servizio materiale with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale that was removed
	* @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	*/
	public static ServizioMateriale remove(java.lang.String gruppo)
		throws servizio.beni.facile.consumo.exception.NoSuchServizioMaterialeException {
		return getPersistence().remove(gruppo);
	}

	public static ServizioMateriale updateImpl(
		ServizioMateriale servizioMateriale) {
		return getPersistence().updateImpl(servizioMateriale);
	}

	/**
	* Returns the servizio materiale with the primary key or throws a {@link NoSuchServizioMaterialeException} if it could not be found.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale
	* @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	*/
	public static ServizioMateriale findByPrimaryKey(java.lang.String gruppo)
		throws servizio.beni.facile.consumo.exception.NoSuchServizioMaterialeException {
		return getPersistence().findByPrimaryKey(gruppo);
	}

	/**
	* Returns the servizio materiale with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale, or <code>null</code> if a servizio materiale with the primary key could not be found
	*/
	public static ServizioMateriale fetchByPrimaryKey(java.lang.String gruppo) {
		return getPersistence().fetchByPrimaryKey(gruppo);
	}

	public static java.util.Map<java.io.Serializable, ServizioMateriale> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the servizio materiales.
	*
	* @return the servizio materiales
	*/
	public static List<ServizioMateriale> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @return the range of servizio materiales
	*/
	public static List<ServizioMateriale> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of servizio materiales
	*/
	public static List<ServizioMateriale> findAll(int start, int end,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of servizio materiales
	*/
	public static List<ServizioMateriale> findAll(int start, int end,
		OrderByComparator<ServizioMateriale> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the servizio materiales from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of servizio materiales.
	*
	* @return the number of servizio materiales
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServizioMaterialePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServizioMaterialePersistence, ServizioMaterialePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ServizioMaterialePersistence.class);
}