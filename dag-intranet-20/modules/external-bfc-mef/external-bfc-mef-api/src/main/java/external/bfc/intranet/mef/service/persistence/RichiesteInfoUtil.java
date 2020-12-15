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

package external.bfc.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import external.bfc.intranet.mef.model.RichiesteInfo;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the richieste info service. This utility wraps {@link external.bfc.intranet.mef.service.persistence.impl.RichiesteInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteInfoPersistence
 * @see external.bfc.intranet.mef.service.persistence.impl.RichiesteInfoPersistenceImpl
 * @generated
 */
@ProviderType
public class RichiesteInfoUtil {
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
	public static void clearCache(RichiesteInfo richiesteInfo) {
		getPersistence().clearCache(richiesteInfo);
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
	public static List<RichiesteInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiesteInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiesteInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiesteInfo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiesteInfo update(RichiesteInfo richiesteInfo) {
		return getPersistence().update(richiesteInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiesteInfo update(RichiesteInfo richiesteInfo,
		ServiceContext serviceContext) {
		return getPersistence().update(richiesteInfo, serviceContext);
	}

	/**
	* Returns all the richieste infos where email = &#63;.
	*
	* @param email the email
	* @return the matching richieste infos
	*/
	public static List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email) {
		return getPersistence().findByemailReqBfcInfo(email);
	}

	/**
	* Returns a range of all the richieste infos where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @return the range of matching richieste infos
	*/
	public static List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email, int start, int end) {
		return getPersistence().findByemailReqBfcInfo(email, start, end);
	}

	/**
	* Returns an ordered range of all the richieste infos where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richieste infos
	*/
	public static List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email, int start, int end,
		OrderByComparator<RichiesteInfo> orderByComparator) {
		return getPersistence()
				   .findByemailReqBfcInfo(email, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richieste infos where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richieste infos
	*/
	public static List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email, int start, int end,
		OrderByComparator<RichiesteInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemailReqBfcInfo(email, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste info
	* @throws NoSuchRichiesteInfoException if a matching richieste info could not be found
	*/
	public static RichiesteInfo findByemailReqBfcInfo_First(
		java.lang.String email,
		OrderByComparator<RichiesteInfo> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteInfoException {
		return getPersistence()
				   .findByemailReqBfcInfo_First(email, orderByComparator);
	}

	/**
	* Returns the first richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste info, or <code>null</code> if a matching richieste info could not be found
	*/
	public static RichiesteInfo fetchByemailReqBfcInfo_First(
		java.lang.String email,
		OrderByComparator<RichiesteInfo> orderByComparator) {
		return getPersistence()
				   .fetchByemailReqBfcInfo_First(email, orderByComparator);
	}

	/**
	* Returns the last richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste info
	* @throws NoSuchRichiesteInfoException if a matching richieste info could not be found
	*/
	public static RichiesteInfo findByemailReqBfcInfo_Last(
		java.lang.String email,
		OrderByComparator<RichiesteInfo> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteInfoException {
		return getPersistence()
				   .findByemailReqBfcInfo_Last(email, orderByComparator);
	}

	/**
	* Returns the last richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste info, or <code>null</code> if a matching richieste info could not be found
	*/
	public static RichiesteInfo fetchByemailReqBfcInfo_Last(
		java.lang.String email,
		OrderByComparator<RichiesteInfo> orderByComparator) {
		return getPersistence()
				   .fetchByemailReqBfcInfo_Last(email, orderByComparator);
	}

	/**
	* Returns the richieste infos before and after the current richieste info in the ordered set where email = &#63;.
	*
	* @param id the primary key of the current richieste info
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richieste info
	* @throws NoSuchRichiesteInfoException if a richieste info with the primary key could not be found
	*/
	public static RichiesteInfo[] findByemailReqBfcInfo_PrevAndNext(long id,
		java.lang.String email,
		OrderByComparator<RichiesteInfo> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteInfoException {
		return getPersistence()
				   .findByemailReqBfcInfo_PrevAndNext(id, email,
			orderByComparator);
	}

	/**
	* Removes all the richieste infos where email = &#63; from the database.
	*
	* @param email the email
	*/
	public static void removeByemailReqBfcInfo(java.lang.String email) {
		getPersistence().removeByemailReqBfcInfo(email);
	}

	/**
	* Returns the number of richieste infos where email = &#63;.
	*
	* @param email the email
	* @return the number of matching richieste infos
	*/
	public static int countByemailReqBfcInfo(java.lang.String email) {
		return getPersistence().countByemailReqBfcInfo(email);
	}

	/**
	* Caches the richieste info in the entity cache if it is enabled.
	*
	* @param richiesteInfo the richieste info
	*/
	public static void cacheResult(RichiesteInfo richiesteInfo) {
		getPersistence().cacheResult(richiesteInfo);
	}

	/**
	* Caches the richieste infos in the entity cache if it is enabled.
	*
	* @param richiesteInfos the richieste infos
	*/
	public static void cacheResult(List<RichiesteInfo> richiesteInfos) {
		getPersistence().cacheResult(richiesteInfos);
	}

	/**
	* Creates a new richieste info with the primary key. Does not add the richieste info to the database.
	*
	* @param id the primary key for the new richieste info
	* @return the new richieste info
	*/
	public static RichiesteInfo create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info that was removed
	* @throws NoSuchRichiesteInfoException if a richieste info with the primary key could not be found
	*/
	public static RichiesteInfo remove(long id)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteInfoException {
		return getPersistence().remove(id);
	}

	public static RichiesteInfo updateImpl(RichiesteInfo richiesteInfo) {
		return getPersistence().updateImpl(richiesteInfo);
	}

	/**
	* Returns the richieste info with the primary key or throws a {@link NoSuchRichiesteInfoException} if it could not be found.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info
	* @throws NoSuchRichiesteInfoException if a richieste info with the primary key could not be found
	*/
	public static RichiesteInfo findByPrimaryKey(long id)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteInfoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the richieste info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info, or <code>null</code> if a richieste info with the primary key could not be found
	*/
	public static RichiesteInfo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, RichiesteInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richieste infos.
	*
	* @return the richieste infos
	*/
	public static List<RichiesteInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @return the range of richieste infos
	*/
	public static List<RichiesteInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste infos
	*/
	public static List<RichiesteInfo> findAll(int start, int end,
		OrderByComparator<RichiesteInfo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste infos
	*/
	public static List<RichiesteInfo> findAll(int start, int end,
		OrderByComparator<RichiesteInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richieste infos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richieste infos.
	*
	* @return the number of richieste infos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RichiesteInfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiesteInfoPersistence, RichiesteInfoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiesteInfoPersistence.class);
}