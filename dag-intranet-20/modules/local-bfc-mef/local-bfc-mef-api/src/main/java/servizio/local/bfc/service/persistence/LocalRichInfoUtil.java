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

import servizio.local.bfc.model.LocalRichInfo;

import java.util.List;

/**
 * The persistence utility for the local rich info service. This utility wraps {@link servizio.local.bfc.service.persistence.impl.LocalRichInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichInfoPersistence
 * @see servizio.local.bfc.service.persistence.impl.LocalRichInfoPersistenceImpl
 * @generated
 */
@ProviderType
public class LocalRichInfoUtil {
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
	public static void clearCache(LocalRichInfo localRichInfo) {
		getPersistence().clearCache(localRichInfo);
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
	public static List<LocalRichInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LocalRichInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LocalRichInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LocalRichInfo update(LocalRichInfo localRichInfo) {
		return getPersistence().update(localRichInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LocalRichInfo update(LocalRichInfo localRichInfo,
		ServiceContext serviceContext) {
		return getPersistence().update(localRichInfo, serviceContext);
	}

	/**
	* Returns all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the matching local rich infos
	*/
	public static List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		java.lang.String email) {
		return getPersistence().findByemailReqBfcInfo(inStage, email);
	}

	/**
	* Returns a range of all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @return the range of matching local rich infos
	*/
	public static List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		java.lang.String email, int start, int end) {
		return getPersistence().findByemailReqBfcInfo(inStage, email, start, end);
	}

	/**
	* Returns an ordered range of all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local rich infos
	*/
	public static List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		java.lang.String email, int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence()
				   .findByemailReqBfcInfo(inStage, email, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local rich infos
	*/
	public static List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		java.lang.String email, int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemailReqBfcInfo(inStage, email, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public static LocalRichInfo findByemailReqBfcInfo_First(boolean inStage,
		java.lang.String email,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence()
				   .findByemailReqBfcInfo_First(inStage, email,
			orderByComparator);
	}

	/**
	* Returns the first local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public static LocalRichInfo fetchByemailReqBfcInfo_First(boolean inStage,
		java.lang.String email,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence()
				   .fetchByemailReqBfcInfo_First(inStage, email,
			orderByComparator);
	}

	/**
	* Returns the last local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public static LocalRichInfo findByemailReqBfcInfo_Last(boolean inStage,
		java.lang.String email,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence()
				   .findByemailReqBfcInfo_Last(inStage, email, orderByComparator);
	}

	/**
	* Returns the last local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public static LocalRichInfo fetchByemailReqBfcInfo_Last(boolean inStage,
		java.lang.String email,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence()
				   .fetchByemailReqBfcInfo_Last(inStage, email,
			orderByComparator);
	}

	/**
	* Returns the local rich infos before and after the current local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param id the primary key of the current local rich info
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich info
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public static LocalRichInfo[] findByemailReqBfcInfo_PrevAndNext(long id,
		boolean inStage, java.lang.String email,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence()
				   .findByemailReqBfcInfo_PrevAndNext(id, inStage, email,
			orderByComparator);
	}

	/**
	* Removes all the local rich infos where inStage = &#63; and email = &#63; from the database.
	*
	* @param inStage the in stage
	* @param email the email
	*/
	public static void removeByemailReqBfcInfo(boolean inStage,
		java.lang.String email) {
		getPersistence().removeByemailReqBfcInfo(inStage, email);
	}

	/**
	* Returns the number of local rich infos where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the number of matching local rich infos
	*/
	public static int countByemailReqBfcInfo(boolean inStage,
		java.lang.String email) {
		return getPersistence().countByemailReqBfcInfo(inStage, email);
	}

	/**
	* Returns all the local rich infos where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching local rich infos
	*/
	public static List<LocalRichInfo> findByIdRichiesta(long id_richiesta) {
		return getPersistence().findByIdRichiesta(id_richiesta);
	}

	/**
	* Returns a range of all the local rich infos where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @return the range of matching local rich infos
	*/
	public static List<LocalRichInfo> findByIdRichiesta(long id_richiesta,
		int start, int end) {
		return getPersistence().findByIdRichiesta(id_richiesta, start, end);
	}

	/**
	* Returns an ordered range of all the local rich infos where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local rich infos
	*/
	public static List<LocalRichInfo> findByIdRichiesta(long id_richiesta,
		int start, int end, OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the local rich infos where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local rich infos
	*/
	public static List<LocalRichInfo> findByIdRichiesta(long id_richiesta,
		int start, int end, OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdRichiesta(id_richiesta, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public static LocalRichInfo findByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence()
				   .findByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the first local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public static LocalRichInfo fetchByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_First(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public static LocalRichInfo findByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence()
				   .findByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the last local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public static LocalRichInfo fetchByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence()
				   .fetchByIdRichiesta_Last(id_richiesta, orderByComparator);
	}

	/**
	* Returns the local rich infos before and after the current local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id the primary key of the current local rich info
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich info
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public static LocalRichInfo[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta, OrderByComparator<LocalRichInfo> orderByComparator)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence()
				   .findByIdRichiesta_PrevAndNext(id, id_richiesta,
			orderByComparator);
	}

	/**
	* Removes all the local rich infos where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public static void removeByIdRichiesta(long id_richiesta) {
		getPersistence().removeByIdRichiesta(id_richiesta);
	}

	/**
	* Returns the number of local rich infos where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching local rich infos
	*/
	public static int countByIdRichiesta(long id_richiesta) {
		return getPersistence().countByIdRichiesta(id_richiesta);
	}

	/**
	* Caches the local rich info in the entity cache if it is enabled.
	*
	* @param localRichInfo the local rich info
	*/
	public static void cacheResult(LocalRichInfo localRichInfo) {
		getPersistence().cacheResult(localRichInfo);
	}

	/**
	* Caches the local rich infos in the entity cache if it is enabled.
	*
	* @param localRichInfos the local rich infos
	*/
	public static void cacheResult(List<LocalRichInfo> localRichInfos) {
		getPersistence().cacheResult(localRichInfos);
	}

	/**
	* Creates a new local rich info with the primary key. Does not add the local rich info to the database.
	*
	* @param id the primary key for the new local rich info
	* @return the new local rich info
	*/
	public static LocalRichInfo create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the local rich info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info that was removed
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public static LocalRichInfo remove(long id)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence().remove(id);
	}

	public static LocalRichInfo updateImpl(LocalRichInfo localRichInfo) {
		return getPersistence().updateImpl(localRichInfo);
	}

	/**
	* Returns the local rich info with the primary key or throws a {@link NoSuchLocalRichInfoException} if it could not be found.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public static LocalRichInfo findByPrimaryKey(long id)
		throws servizio.local.bfc.exception.NoSuchLocalRichInfoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the local rich info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info, or <code>null</code> if a local rich info with the primary key could not be found
	*/
	public static LocalRichInfo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, LocalRichInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the local rich infos.
	*
	* @return the local rich infos
	*/
	public static List<LocalRichInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the local rich infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @return the range of local rich infos
	*/
	public static List<LocalRichInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the local rich infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of local rich infos
	*/
	public static List<LocalRichInfo> findAll(int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the local rich infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of local rich infos
	*/
	public static List<LocalRichInfo> findAll(int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the local rich infos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of local rich infos.
	*
	* @return the number of local rich infos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LocalRichInfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LocalRichInfoPersistence, LocalRichInfoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LocalRichInfoPersistence.class);
}