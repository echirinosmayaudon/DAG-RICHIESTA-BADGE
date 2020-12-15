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

import external.bfc.intranet.mef.model.RigheRichiesteInfo;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the righe richieste info service. This utility wraps {@link external.bfc.intranet.mef.service.persistence.impl.RigheRichiesteInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiesteInfoPersistence
 * @see external.bfc.intranet.mef.service.persistence.impl.RigheRichiesteInfoPersistenceImpl
 * @generated
 */
@ProviderType
public class RigheRichiesteInfoUtil {
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
	public static void clearCache(RigheRichiesteInfo righeRichiesteInfo) {
		getPersistence().clearCache(righeRichiesteInfo);
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
	public static List<RigheRichiesteInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RigheRichiesteInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RigheRichiesteInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RigheRichiesteInfo update(
		RigheRichiesteInfo righeRichiesteInfo) {
		return getPersistence().update(righeRichiesteInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RigheRichiesteInfo update(
		RigheRichiesteInfo righeRichiesteInfo, ServiceContext serviceContext) {
		return getPersistence().update(righeRichiesteInfo, serviceContext);
	}

	/**
	* Returns all the righe richieste infos where id = &#63;.
	*
	* @param id the ID
	* @return the matching righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findByrichiesteInfoId(long id) {
		return getPersistence().findByrichiesteInfoId(id);
	}

	/**
	* Returns a range of all the righe richieste infos where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @return the range of matching righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findByrichiesteInfoId(long id,
		int start, int end) {
		return getPersistence().findByrichiesteInfoId(id, start, end);
	}

	/**
	* Returns an ordered range of all the righe richieste infos where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findByrichiesteInfoId(long id,
		int start, int end,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		return getPersistence()
				   .findByrichiesteInfoId(id, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe richieste infos where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findByrichiesteInfoId(long id,
		int start, int end,
		OrderByComparator<RigheRichiesteInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByrichiesteInfoId(id, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a matching righe richieste info could not be found
	*/
	public static RigheRichiesteInfo findByrichiesteInfoId_First(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteInfoException {
		return getPersistence()
				   .findByrichiesteInfoId_First(id, orderByComparator);
	}

	/**
	* Returns the first righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste info, or <code>null</code> if a matching righe richieste info could not be found
	*/
	public static RigheRichiesteInfo fetchByrichiesteInfoId_First(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		return getPersistence()
				   .fetchByrichiesteInfoId_First(id, orderByComparator);
	}

	/**
	* Returns the last righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a matching righe richieste info could not be found
	*/
	public static RigheRichiesteInfo findByrichiesteInfoId_Last(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteInfoException {
		return getPersistence().findByrichiesteInfoId_Last(id, orderByComparator);
	}

	/**
	* Returns the last righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste info, or <code>null</code> if a matching righe richieste info could not be found
	*/
	public static RigheRichiesteInfo fetchByrichiesteInfoId_Last(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		return getPersistence()
				   .fetchByrichiesteInfoId_Last(id, orderByComparator);
	}

	/**
	* Returns the righe richieste infos before and after the current righe richieste info in the ordered set where id = &#63;.
	*
	* @param righeRichiesteInfoPK the primary key of the current righe richieste info
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	*/
	public static RigheRichiesteInfo[] findByrichiesteInfoId_PrevAndNext(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK,
		long id, OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteInfoException {
		return getPersistence()
				   .findByrichiesteInfoId_PrevAndNext(righeRichiesteInfoPK, id,
			orderByComparator);
	}

	/**
	* Removes all the righe richieste infos where id = &#63; from the database.
	*
	* @param id the ID
	*/
	public static void removeByrichiesteInfoId(long id) {
		getPersistence().removeByrichiesteInfoId(id);
	}

	/**
	* Returns the number of righe richieste infos where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching righe richieste infos
	*/
	public static int countByrichiesteInfoId(long id) {
		return getPersistence().countByrichiesteInfoId(id);
	}

	/**
	* Caches the righe richieste info in the entity cache if it is enabled.
	*
	* @param righeRichiesteInfo the righe richieste info
	*/
	public static void cacheResult(RigheRichiesteInfo righeRichiesteInfo) {
		getPersistence().cacheResult(righeRichiesteInfo);
	}

	/**
	* Caches the righe richieste infos in the entity cache if it is enabled.
	*
	* @param righeRichiesteInfos the righe richieste infos
	*/
	public static void cacheResult(List<RigheRichiesteInfo> righeRichiesteInfos) {
		getPersistence().cacheResult(righeRichiesteInfos);
	}

	/**
	* Creates a new righe richieste info with the primary key. Does not add the righe richieste info to the database.
	*
	* @param righeRichiesteInfoPK the primary key for the new righe richieste info
	* @return the new righe richieste info
	*/
	public static RigheRichiesteInfo create(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK) {
		return getPersistence().create(righeRichiesteInfoPK);
	}

	/**
	* Removes the righe richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info that was removed
	* @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	*/
	public static RigheRichiesteInfo remove(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteInfoException {
		return getPersistence().remove(righeRichiesteInfoPK);
	}

	public static RigheRichiesteInfo updateImpl(
		RigheRichiesteInfo righeRichiesteInfo) {
		return getPersistence().updateImpl(righeRichiesteInfo);
	}

	/**
	* Returns the righe richieste info with the primary key or throws a {@link NoSuchRigheRichiesteInfoException} if it could not be found.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	*/
	public static RigheRichiesteInfo findByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteInfoException {
		return getPersistence().findByPrimaryKey(righeRichiesteInfoPK);
	}

	/**
	* Returns the righe richieste info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info, or <code>null</code> if a righe richieste info with the primary key could not be found
	*/
	public static RigheRichiesteInfo fetchByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK) {
		return getPersistence().fetchByPrimaryKey(righeRichiesteInfoPK);
	}

	public static java.util.Map<java.io.Serializable, RigheRichiesteInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the righe richieste infos.
	*
	* @return the righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the righe richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @return the range of righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the righe richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findAll(int start, int end,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe richieste infos
	*/
	public static List<RigheRichiesteInfo> findAll(int start, int end,
		OrderByComparator<RigheRichiesteInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the righe richieste infos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of righe richieste infos.
	*
	* @return the number of righe richieste infos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RigheRichiesteInfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RigheRichiesteInfoPersistence, RigheRichiesteInfoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RigheRichiesteInfoPersistence.class);
}