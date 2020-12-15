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

package servizio.beni.facile.consumo.richieste.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew;

import java.util.List;

/**
 * The persistence utility for the righe rich b f c new service. This utility wraps {@link servizio.beni.facile.consumo.richieste.service.persistence.impl.RigheRichBFCNewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichBFCNewPersistence
 * @see servizio.beni.facile.consumo.richieste.service.persistence.impl.RigheRichBFCNewPersistenceImpl
 * @generated
 */
@ProviderType
public class RigheRichBFCNewUtil {
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
	public static void clearCache(RigheRichBFCNew righeRichBFCNew) {
		getPersistence().clearCache(righeRichBFCNew);
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
	public static List<RigheRichBFCNew> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RigheRichBFCNew> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RigheRichBFCNew> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RigheRichBFCNew update(RigheRichBFCNew righeRichBFCNew) {
		return getPersistence().update(righeRichBFCNew);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RigheRichBFCNew update(RigheRichBFCNew righeRichBFCNew,
		ServiceContext serviceContext) {
		return getPersistence().update(righeRichBFCNew, serviceContext);
	}

	/**
	* Returns all the righe rich b f c news where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento) {
		return getPersistence().findByDipartimento(dipartimento);
	}

	/**
	* Returns a range of all the righe rich b f c news where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @return the range of matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento, int start, int end) {
		return getPersistence().findByDipartimento(dipartimento, start, end);
	}

	/**
	* Returns an ordered range of all the righe rich b f c news where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence()
				   .findByDipartimento(dipartimento, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe rich b f c news where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDipartimento(dipartimento, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew findByDipartimento_First(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence()
				   .findByDipartimento_First(dipartimento, orderByComparator);
	}

	/**
	* Returns the first righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew fetchByDipartimento_First(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_First(dipartimento, orderByComparator);
	}

	/**
	* Returns the last righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew findByDipartimento_Last(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence()
				   .findByDipartimento_Last(dipartimento, orderByComparator);
	}

	/**
	* Returns the last righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew fetchByDipartimento_Last(
		java.lang.String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_Last(dipartimento, orderByComparator);
	}

	/**
	* Returns the righe rich b f c news before and after the current righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param id the primary key of the current righe rich b f c new
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public static RigheRichBFCNew[] findByDipartimento_PrevAndNext(long id,
		java.lang.String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence()
				   .findByDipartimento_PrevAndNext(id, dipartimento,
			orderByComparator);
	}

	/**
	* Removes all the righe rich b f c news where dipartimento = &#63; from the database.
	*
	* @param dipartimento the dipartimento
	*/
	public static void removeByDipartimento(java.lang.String dipartimento) {
		getPersistence().removeByDipartimento(dipartimento);
	}

	/**
	* Returns the number of righe rich b f c news where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the number of matching righe rich b f c news
	*/
	public static int countByDipartimento(java.lang.String dipartimento) {
		return getPersistence().countByDipartimento(dipartimento);
	}

	/**
	* Returns all the righe rich b f c news where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByIdRichiesta(long id_rich) {
		return getPersistence().findByIdRichiesta(id_rich);
	}

	/**
	* Returns a range of all the righe rich b f c news where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @return the range of matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByIdRichiesta(long id_rich,
		int start, int end) {
		return getPersistence().findByIdRichiesta(id_rich, start, end);
	}

	/**
	* Returns an ordered range of all the righe rich b f c news where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByIdRichiesta(long id_rich,
		int start, int end, OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence()
				   .findByIdRichiesta(id_rich, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe rich b f c news where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findByIdRichiesta(long id_rich,
		int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdRichiesta(id_rich, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew findByIdRichiesta_First(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence()
				   .findByIdRichiesta_First(id_rich, orderByComparator);
	}

	/**
	* Returns the first righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew fetchByIdRichiesta_First(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_First(id_rich, orderByComparator);
	}

	/**
	* Returns the last righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew findByIdRichiesta_Last(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence()
				   .findByIdRichiesta_Last(id_rich, orderByComparator);
	}

	/**
	* Returns the last righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public static RigheRichBFCNew fetchByIdRichiesta_Last(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_Last(id_rich, orderByComparator);
	}

	/**
	* Returns the righe rich b f c news before and after the current righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id the primary key of the current righe rich b f c new
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public static RigheRichBFCNew[] findByIdRichiesta_PrevAndNext(long id,
		long id_rich, OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence()
				   .findByIdRichiesta_PrevAndNext(id, id_rich, orderByComparator);
	}

	/**
	* Removes all the righe rich b f c news where id_rich = &#63; from the database.
	*
	* @param id_rich the id_rich
	*/
	public static void removeByIdRichiesta(long id_rich) {
		getPersistence().removeByIdRichiesta(id_rich);
	}

	/**
	* Returns the number of righe rich b f c news where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the number of matching righe rich b f c news
	*/
	public static int countByIdRichiesta(long id_rich) {
		return getPersistence().countByIdRichiesta(id_rich);
	}

	/**
	* Caches the righe rich b f c new in the entity cache if it is enabled.
	*
	* @param righeRichBFCNew the righe rich b f c new
	*/
	public static void cacheResult(RigheRichBFCNew righeRichBFCNew) {
		getPersistence().cacheResult(righeRichBFCNew);
	}

	/**
	* Caches the righe rich b f c news in the entity cache if it is enabled.
	*
	* @param righeRichBFCNews the righe rich b f c news
	*/
	public static void cacheResult(List<RigheRichBFCNew> righeRichBFCNews) {
		getPersistence().cacheResult(righeRichBFCNews);
	}

	/**
	* Creates a new righe rich b f c new with the primary key. Does not add the righe rich b f c new to the database.
	*
	* @param id the primary key for the new righe rich b f c new
	* @return the new righe rich b f c new
	*/
	public static RigheRichBFCNew create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the righe rich b f c new with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the righe rich b f c new
	* @return the righe rich b f c new that was removed
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public static RigheRichBFCNew remove(long id)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence().remove(id);
	}

	public static RigheRichBFCNew updateImpl(RigheRichBFCNew righeRichBFCNew) {
		return getPersistence().updateImpl(righeRichBFCNew);
	}

	/**
	* Returns the righe rich b f c new with the primary key or throws a {@link NoSuchRigheRichBFCNewException} if it could not be found.
	*
	* @param id the primary key of the righe rich b f c new
	* @return the righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public static RigheRichBFCNew findByPrimaryKey(long id)
		throws servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the righe rich b f c new with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the righe rich b f c new
	* @return the righe rich b f c new, or <code>null</code> if a righe rich b f c new with the primary key could not be found
	*/
	public static RigheRichBFCNew fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, RigheRichBFCNew> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the righe rich b f c news.
	*
	* @return the righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the righe rich b f c news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @return the range of righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the righe rich b f c news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findAll(int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe rich b f c news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe rich b f c news
	*/
	public static List<RigheRichBFCNew> findAll(int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the righe rich b f c news from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of righe rich b f c news.
	*
	* @return the number of righe rich b f c news
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RigheRichBFCNewPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RigheRichBFCNewPersistence, RigheRichBFCNewPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RigheRichBFCNewPersistence.class);
}