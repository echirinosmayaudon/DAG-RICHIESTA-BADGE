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

import servizio.beni.facile.consumo.model.CambioStatoDirigente;

import java.util.List;

/**
 * The persistence utility for the cambio stato dirigente service. This utility wraps {@link servizio.beni.facile.consumo.service.persistence.impl.CambioStatoDirigentePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CambioStatoDirigentePersistence
 * @see servizio.beni.facile.consumo.service.persistence.impl.CambioStatoDirigentePersistenceImpl
 * @generated
 */
@ProviderType
public class CambioStatoDirigenteUtil {
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
	public static void clearCache(CambioStatoDirigente cambioStatoDirigente) {
		getPersistence().clearCache(cambioStatoDirigente);
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
	public static List<CambioStatoDirigente> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CambioStatoDirigente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CambioStatoDirigente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CambioStatoDirigente update(
		CambioStatoDirigente cambioStatoDirigente) {
		return getPersistence().update(cambioStatoDirigente);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CambioStatoDirigente update(
		CambioStatoDirigente cambioStatoDirigente, ServiceContext serviceContext) {
		return getPersistence().update(cambioStatoDirigente, serviceContext);
	}

	/**
	* Returns all the cambio stato dirigentes where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the matching cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findByIdRichiesta(long id_rich) {
		return getPersistence().findByIdRichiesta(id_rich);
	}

	/**
	* Returns a range of all the cambio stato dirigentes where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @return the range of matching cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findByIdRichiesta(long id_rich,
		int start, int end) {
		return getPersistence().findByIdRichiesta(id_rich, start, end);
	}

	/**
	* Returns an ordered range of all the cambio stato dirigentes where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findByIdRichiesta(long id_rich,
		int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		return getPersistence()
				   .findByIdRichiesta(id_rich, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cambio stato dirigentes where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findByIdRichiesta(long id_rich,
		int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdRichiesta(id_rich, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a matching cambio stato dirigente could not be found
	*/
	public static CambioStatoDirigente findByIdRichiesta_First(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchCambioStatoDirigenteException {
		return getPersistence()
				   .findByIdRichiesta_First(id_rich, orderByComparator);
	}

	/**
	* Returns the first cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cambio stato dirigente, or <code>null</code> if a matching cambio stato dirigente could not be found
	*/
	public static CambioStatoDirigente fetchByIdRichiesta_First(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_First(id_rich, orderByComparator);
	}

	/**
	* Returns the last cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a matching cambio stato dirigente could not be found
	*/
	public static CambioStatoDirigente findByIdRichiesta_Last(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchCambioStatoDirigenteException {
		return getPersistence()
				   .findByIdRichiesta_Last(id_rich, orderByComparator);
	}

	/**
	* Returns the last cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cambio stato dirigente, or <code>null</code> if a matching cambio stato dirigente could not be found
	*/
	public static CambioStatoDirigente fetchByIdRichiesta_Last(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_Last(id_rich, orderByComparator);
	}

	/**
	* Returns the cambio stato dirigentes before and after the current cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id the primary key of the current cambio stato dirigente
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	*/
	public static CambioStatoDirigente[] findByIdRichiesta_PrevAndNext(
		long id, long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchCambioStatoDirigenteException {
		return getPersistence()
				   .findByIdRichiesta_PrevAndNext(id, id_rich, orderByComparator);
	}

	/**
	* Removes all the cambio stato dirigentes where id_rich = &#63; from the database.
	*
	* @param id_rich the id_rich
	*/
	public static void removeByIdRichiesta(long id_rich) {
		getPersistence().removeByIdRichiesta(id_rich);
	}

	/**
	* Returns the number of cambio stato dirigentes where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the number of matching cambio stato dirigentes
	*/
	public static int countByIdRichiesta(long id_rich) {
		return getPersistence().countByIdRichiesta(id_rich);
	}

	/**
	* Caches the cambio stato dirigente in the entity cache if it is enabled.
	*
	* @param cambioStatoDirigente the cambio stato dirigente
	*/
	public static void cacheResult(CambioStatoDirigente cambioStatoDirigente) {
		getPersistence().cacheResult(cambioStatoDirigente);
	}

	/**
	* Caches the cambio stato dirigentes in the entity cache if it is enabled.
	*
	* @param cambioStatoDirigentes the cambio stato dirigentes
	*/
	public static void cacheResult(
		List<CambioStatoDirigente> cambioStatoDirigentes) {
		getPersistence().cacheResult(cambioStatoDirigentes);
	}

	/**
	* Creates a new cambio stato dirigente with the primary key. Does not add the cambio stato dirigente to the database.
	*
	* @param id the primary key for the new cambio stato dirigente
	* @return the new cambio stato dirigente
	*/
	public static CambioStatoDirigente create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cambio stato dirigente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente that was removed
	* @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	*/
	public static CambioStatoDirigente remove(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchCambioStatoDirigenteException {
		return getPersistence().remove(id);
	}

	public static CambioStatoDirigente updateImpl(
		CambioStatoDirigente cambioStatoDirigente) {
		return getPersistence().updateImpl(cambioStatoDirigente);
	}

	/**
	* Returns the cambio stato dirigente with the primary key or throws a {@link NoSuchCambioStatoDirigenteException} if it could not be found.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	*/
	public static CambioStatoDirigente findByPrimaryKey(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchCambioStatoDirigenteException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cambio stato dirigente with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente, or <code>null</code> if a cambio stato dirigente with the primary key could not be found
	*/
	public static CambioStatoDirigente fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, CambioStatoDirigente> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the cambio stato dirigentes.
	*
	* @return the cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cambio stato dirigentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @return the range of cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cambio stato dirigentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findAll(int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cambio stato dirigentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cambio stato dirigentes
	*/
	public static List<CambioStatoDirigente> findAll(int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the cambio stato dirigentes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cambio stato dirigentes.
	*
	* @return the number of cambio stato dirigentes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CambioStatoDirigentePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CambioStatoDirigentePersistence, CambioStatoDirigentePersistence> _serviceTracker =
		ServiceTrackerFactory.open(CambioStatoDirigentePersistence.class);
}