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

package servizio.local.bfc.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.local.bfc.model.LocalRich;

import java.util.List;

/**
 * The persistence utility for the local rich service. This utility wraps {@link servizio.local.bfc.service.persistence.impl.LocalRichPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichPersistence
 * @see servizio.local.bfc.service.persistence.impl.LocalRichPersistenceImpl
 * @generated
 */
@ProviderType
public class LocalRichUtil {
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
	public static void clearCache(LocalRich localRich) {
		getPersistence().clearCache(localRich);
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
	public static List<LocalRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LocalRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LocalRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LocalRich update(LocalRich localRich) {
		return getPersistence().update(localRich);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LocalRich update(LocalRich localRich,
		ServiceContext serviceContext) {
		return getPersistence().update(localRich, serviceContext);
	}

	/**
	* Returns all the local richs where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the matching local richs
	*/
	public static List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email) {
		return getPersistence().findByemailReqBfc(inStage, email);
	}

	/**
	* Returns a range of all the local richs where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of matching local richs
	*/
	public static List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email, int start, int end) {
		return getPersistence().findByemailReqBfc(inStage, email, start, end);
	}

	/**
	* Returns an ordered range of all the local richs where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local richs
	*/
	public static List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email, int start, int end,
		OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence()
				   .findByemailReqBfc(inStage, email, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the local richs where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local richs
	*/
	public static List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email, int start, int end,
		OrderByComparator<LocalRich> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemailReqBfc(inStage, email, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public static LocalRich findByemailReqBfc_First(boolean inStage,
		java.lang.String email, OrderByComparator<LocalRich> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence()
				   .findByemailReqBfc_First(inStage, email, orderByComparator);
	}

	/**
	* Returns the first local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public static LocalRich fetchByemailReqBfc_First(boolean inStage,
		java.lang.String email, OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence()
				   .fetchByemailReqBfc_First(inStage, email, orderByComparator);
	}

	/**
	* Returns the last local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public static LocalRich findByemailReqBfc_Last(boolean inStage,
		java.lang.String email, OrderByComparator<LocalRich> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence()
				   .findByemailReqBfc_Last(inStage, email, orderByComparator);
	}

	/**
	* Returns the last local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public static LocalRich fetchByemailReqBfc_Last(boolean inStage,
		java.lang.String email, OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence()
				   .fetchByemailReqBfc_Last(inStage, email, orderByComparator);
	}

	/**
	* Returns the local richs before and after the current local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param id the primary key of the current local rich
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public static LocalRich[] findByemailReqBfc_PrevAndNext(long id,
		boolean inStage, java.lang.String email,
		OrderByComparator<LocalRich> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence()
				   .findByemailReqBfc_PrevAndNext(id, inStage, email,
			orderByComparator);
	}

	/**
	* Removes all the local richs where inStage = &#63; and email = &#63; from the database.
	*
	* @param inStage the in stage
	* @param email the email
	*/
	public static void removeByemailReqBfc(boolean inStage,
		java.lang.String email) {
		getPersistence().removeByemailReqBfc(inStage, email);
	}

	/**
	* Returns the number of local richs where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the number of matching local richs
	*/
	public static int countByemailReqBfc(boolean inStage, java.lang.String email) {
		return getPersistence().countByemailReqBfc(inStage, email);
	}

	/**
	* Returns all the local richs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching local richs
	*/
	public static List<LocalRich> findByIdRichiesta(long id_richiesta) {
		return getPersistence().findByIdRichiesta(id_richiesta);
	}

	/**
	* Returns a range of all the local richs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of matching local richs
	*/
	public static List<LocalRich> findByIdRichiesta(long id_richiesta,
		int start, int end) {
		return getPersistence().findByIdRichiesta(id_richiesta, start, end);
	}

	/**
	* Returns an ordered range of all the local richs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local richs
	*/
	public static List<LocalRich> findByIdRichiesta(long id_richiesta,
		int start, int end, OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the local richs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local richs
	*/
	public static List<LocalRich> findByIdRichiesta(long id_richiesta,
		int start, int end, OrderByComparator<LocalRich> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public static LocalRich findByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence()
				   .findByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the first local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public static LocalRich fetchByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public static LocalRich findByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence()
				   .findByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public static LocalRich fetchByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the local richs before and after the current local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id the primary key of the current local rich
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public static LocalRich[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta, OrderByComparator<LocalRich> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence()
				   .findByIdRichiesta_PrevAndNext(id, id_richiesta,
			orderByComparator);
	}

	/**
	* Removes all the local richs where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public static void removeByIdRichiesta(long id_richiesta) {
		getPersistence().removeByIdRichiesta(id_richiesta);
	}

	/**
	* Returns the number of local richs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching local richs
	*/
	public static int countByIdRichiesta(long id_richiesta) {
		return getPersistence().countByIdRichiesta(id_richiesta);
	}

	/**
	* Caches the local rich in the entity cache if it is enabled.
	*
	* @param localRich the local rich
	*/
	public static void cacheResult(LocalRich localRich) {
		getPersistence().cacheResult(localRich);
	}

	/**
	* Caches the local richs in the entity cache if it is enabled.
	*
	* @param localRichs the local richs
	*/
	public static void cacheResult(List<LocalRich> localRichs) {
		getPersistence().cacheResult(localRichs);
	}

	/**
	* Creates a new local rich with the primary key. Does not add the local rich to the database.
	*
	* @param id the primary key for the new local rich
	* @return the new local rich
	*/
	public static LocalRich create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the local rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the local rich
	* @return the local rich that was removed
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public static LocalRich remove(long id)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence().remove(id);
	}

	public static LocalRich updateImpl(LocalRich localRich) {
		return getPersistence().updateImpl(localRich);
	}

	/**
	* Returns the local rich with the primary key or throws a {@link NoSuchLocalRichException} if it could not be found.
	*
	* @param id the primary key of the local rich
	* @return the local rich
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public static LocalRich findByPrimaryKey(long id)
		throws servizio.local.bfc.exception.NoSuchLocalRichException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the local rich with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the local rich
	* @return the local rich, or <code>null</code> if a local rich with the primary key could not be found
	*/
	public static LocalRich fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, LocalRich> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the local richs.
	*
	* @return the local richs
	*/
	public static List<LocalRich> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of local richs
	*/
	public static List<LocalRich> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of local richs
	*/
	public static List<LocalRich> findAll(int start, int end,
		OrderByComparator<LocalRich> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of local richs
	*/
	public static List<LocalRich> findAll(int start, int end,
		OrderByComparator<LocalRich> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the local richs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of local richs.
	*
	* @return the number of local richs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LocalRichPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LocalRichPersistence, LocalRichPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LocalRichPersistence.class);
}