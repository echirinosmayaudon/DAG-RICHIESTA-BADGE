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

import servizio.beni.facile.consumo.model.RigheRichiestaBFC;

import java.util.List;

/**
 * The persistence utility for the righe richiesta b f c service. This utility wraps {@link servizio.beni.facile.consumo.service.persistence.impl.RigheRichiestaBFCPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCPersistence
 * @see servizio.beni.facile.consumo.service.persistence.impl.RigheRichiestaBFCPersistenceImpl
 * @generated
 */
@ProviderType
public class RigheRichiestaBFCUtil {
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
	public static void clearCache(RigheRichiestaBFC righeRichiestaBFC) {
		getPersistence().clearCache(righeRichiestaBFC);
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
	public static List<RigheRichiestaBFC> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RigheRichiestaBFC> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RigheRichiestaBFC> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RigheRichiestaBFC update(RigheRichiestaBFC righeRichiestaBFC) {
		return getPersistence().update(righeRichiestaBFC);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RigheRichiestaBFC update(
		RigheRichiestaBFC righeRichiestaBFC, ServiceContext serviceContext) {
		return getPersistence().update(righeRichiestaBFC, serviceContext);
	}

	/**
	* Returns all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento) {
		return getPersistence().findByDipartimento(dipartimento);
	}

	/**
	* Returns a range of all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento, int start, int end) {
		return getPersistence().findByDipartimento(dipartimento, start, end);
	}

	/**
	* Returns an ordered range of all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence()
				   .findByDipartimento(dipartimento, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe richiesta b f cs where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		OrderByComparator<RigheRichiestaBFC> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDipartimento(dipartimento, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC findByDipartimento_First(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence()
				   .findByDipartimento_First(dipartimento, orderByComparator);
	}

	/**
	* Returns the first righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC fetchByDipartimento_First(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_First(dipartimento, orderByComparator);
	}

	/**
	* Returns the last righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC findByDipartimento_Last(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence()
				   .findByDipartimento_Last(dipartimento, orderByComparator);
	}

	/**
	* Returns the last righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC fetchByDipartimento_Last(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_Last(dipartimento, orderByComparator);
	}

	/**
	* Returns the righe richiesta b f cs before and after the current righe richiesta b f c in the ordered set where dipartimento = &#63;.
	*
	* @param id the primary key of the current righe richiesta b f c
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public static RigheRichiestaBFC[] findByDipartimento_PrevAndNext(long id,
		java.lang.String dipartimento,
		OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence()
				   .findByDipartimento_PrevAndNext(id, dipartimento,
			orderByComparator);
	}

	/**
	* Removes all the righe richiesta b f cs where dipartimento = &#63; from the database.
	*
	* @param dipartimento the dipartimento
	*/
	public static void removeByDipartimento(java.lang.String dipartimento) {
		getPersistence().removeByDipartimento(dipartimento);
	}

	/**
	* Returns the number of righe richiesta b f cs where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the number of matching righe richiesta b f cs
	*/
	public static int countByDipartimento(java.lang.String dipartimento) {
		return getPersistence().countByDipartimento(dipartimento);
	}

	/**
	* Returns all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByIdRichiesta(long id_richiesta) {
		return getPersistence().findByIdRichiesta(id_richiesta);
	}

	/**
	* Returns a range of all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByIdRichiesta(long id_richiesta,
		int start, int end) {
		return getPersistence().findByIdRichiesta(id_richiesta, start, end);
	}

	/**
	* Returns an ordered range of all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByIdRichiesta(long id_richiesta,
		int start, int end,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe richiesta b f cs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findByIdRichiesta(long id_richiesta,
		int start, int end,
		OrderByComparator<RigheRichiestaBFC> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC findByIdRichiesta_First(long id_richiesta,
		OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence()
				   .findByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the first righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC fetchByIdRichiesta_First(
		long id_richiesta,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC findByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence()
				   .findByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richiesta b f c, or <code>null</code> if a matching righe richiesta b f c could not be found
	*/
	public static RigheRichiestaBFC fetchByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the righe richiesta b f cs before and after the current righe richiesta b f c in the ordered set where id_richiesta = &#63;.
	*
	* @param id the primary key of the current righe richiesta b f c
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public static RigheRichiestaBFC[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta,
		OrderByComparator<RigheRichiestaBFC> orderByComparator)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence()
				   .findByIdRichiesta_PrevAndNext(id, id_richiesta,
			orderByComparator);
	}

	/**
	* Removes all the righe richiesta b f cs where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public static void removeByIdRichiesta(long id_richiesta) {
		getPersistence().removeByIdRichiesta(id_richiesta);
	}

	/**
	* Returns the number of righe richiesta b f cs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching righe richiesta b f cs
	*/
	public static int countByIdRichiesta(long id_richiesta) {
		return getPersistence().countByIdRichiesta(id_richiesta);
	}

	/**
	* Caches the righe richiesta b f c in the entity cache if it is enabled.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	*/
	public static void cacheResult(RigheRichiestaBFC righeRichiestaBFC) {
		getPersistence().cacheResult(righeRichiestaBFC);
	}

	/**
	* Caches the righe richiesta b f cs in the entity cache if it is enabled.
	*
	* @param righeRichiestaBFCs the righe richiesta b f cs
	*/
	public static void cacheResult(List<RigheRichiestaBFC> righeRichiestaBFCs) {
		getPersistence().cacheResult(righeRichiestaBFCs);
	}

	/**
	* Creates a new righe richiesta b f c with the primary key. Does not add the righe richiesta b f c to the database.
	*
	* @param id the primary key for the new righe richiesta b f c
	* @return the new righe richiesta b f c
	*/
	public static RigheRichiestaBFC create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the righe richiesta b f c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c that was removed
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public static RigheRichiestaBFC remove(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence().remove(id);
	}

	public static RigheRichiestaBFC updateImpl(
		RigheRichiestaBFC righeRichiestaBFC) {
		return getPersistence().updateImpl(righeRichiestaBFC);
	}

	/**
	* Returns the righe richiesta b f c with the primary key or throws a {@link NoSuchRigheRichiestaBFCException} if it could not be found.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c
	* @throws NoSuchRigheRichiestaBFCException if a righe richiesta b f c with the primary key could not be found
	*/
	public static RigheRichiestaBFC findByPrimaryKey(long id)
		throws servizio.beni.facile.consumo.exception.NoSuchRigheRichiestaBFCException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the righe richiesta b f c with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c, or <code>null</code> if a righe richiesta b f c with the primary key could not be found
	*/
	public static RigheRichiestaBFC fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, RigheRichiestaBFC> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the righe richiesta b f cs.
	*
	* @return the righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findAll(int start, int end,
		OrderByComparator<RigheRichiestaBFC> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe richiesta b f cs
	*/
	public static List<RigheRichiestaBFC> findAll(int start, int end,
		OrderByComparator<RigheRichiestaBFC> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the righe richiesta b f cs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of righe richiesta b f cs.
	*
	* @return the number of righe richiesta b f cs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RigheRichiestaBFCPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RigheRichiestaBFCPersistence, RigheRichiestaBFCPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RigheRichiestaBFCPersistence.class);
}