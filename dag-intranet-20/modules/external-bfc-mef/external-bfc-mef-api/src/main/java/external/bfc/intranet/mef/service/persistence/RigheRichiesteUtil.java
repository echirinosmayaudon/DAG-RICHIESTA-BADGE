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

import external.bfc.intranet.mef.model.RigheRichieste;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the righe richieste service. This utility wraps {@link external.bfc.intranet.mef.service.persistence.impl.RigheRichiestePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestePersistence
 * @see external.bfc.intranet.mef.service.persistence.impl.RigheRichiestePersistenceImpl
 * @generated
 */
@ProviderType
public class RigheRichiesteUtil {
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
	public static void clearCache(RigheRichieste righeRichieste) {
		getPersistence().clearCache(righeRichieste);
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
	public static List<RigheRichieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RigheRichieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RigheRichieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RigheRichieste> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RigheRichieste update(RigheRichieste righeRichieste) {
		return getPersistence().update(righeRichieste);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RigheRichieste update(RigheRichieste righeRichieste,
		ServiceContext serviceContext) {
		return getPersistence().update(righeRichieste, serviceContext);
	}

	/**
	* Returns all the righe richiestes where id = &#63;.
	*
	* @param id the ID
	* @return the matching righe richiestes
	*/
	public static List<RigheRichieste> findByrichiesteId(long id) {
		return getPersistence().findByrichiesteId(id);
	}

	/**
	* Returns a range of all the righe richiestes where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @return the range of matching righe richiestes
	*/
	public static List<RigheRichieste> findByrichiesteId(long id, int start,
		int end) {
		return getPersistence().findByrichiesteId(id, start, end);
	}

	/**
	* Returns an ordered range of all the righe richiestes where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richiestes
	*/
	public static List<RigheRichieste> findByrichiesteId(long id, int start,
		int end, OrderByComparator<RigheRichieste> orderByComparator) {
		return getPersistence()
				   .findByrichiesteId(id, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe richiestes where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richiestes
	*/
	public static List<RigheRichieste> findByrichiesteId(long id, int start,
		int end, OrderByComparator<RigheRichieste> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByrichiesteId(id, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste
	* @throws NoSuchRigheRichiesteException if a matching righe richieste could not be found
	*/
	public static RigheRichieste findByrichiesteId_First(long id,
		OrderByComparator<RigheRichieste> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteException {
		return getPersistence().findByrichiesteId_First(id, orderByComparator);
	}

	/**
	* Returns the first righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste, or <code>null</code> if a matching righe richieste could not be found
	*/
	public static RigheRichieste fetchByrichiesteId_First(long id,
		OrderByComparator<RigheRichieste> orderByComparator) {
		return getPersistence().fetchByrichiesteId_First(id, orderByComparator);
	}

	/**
	* Returns the last righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste
	* @throws NoSuchRigheRichiesteException if a matching righe richieste could not be found
	*/
	public static RigheRichieste findByrichiesteId_Last(long id,
		OrderByComparator<RigheRichieste> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteException {
		return getPersistence().findByrichiesteId_Last(id, orderByComparator);
	}

	/**
	* Returns the last righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste, or <code>null</code> if a matching righe richieste could not be found
	*/
	public static RigheRichieste fetchByrichiesteId_Last(long id,
		OrderByComparator<RigheRichieste> orderByComparator) {
		return getPersistence().fetchByrichiesteId_Last(id, orderByComparator);
	}

	/**
	* Returns the righe richiestes before and after the current righe richieste in the ordered set where id = &#63;.
	*
	* @param righeRichiestePK the primary key of the current righe richieste
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richieste
	* @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	*/
	public static RigheRichieste[] findByrichiesteId_PrevAndNext(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK,
		long id, OrderByComparator<RigheRichieste> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteException {
		return getPersistence()
				   .findByrichiesteId_PrevAndNext(righeRichiestePK, id,
			orderByComparator);
	}

	/**
	* Removes all the righe richiestes where id = &#63; from the database.
	*
	* @param id the ID
	*/
	public static void removeByrichiesteId(long id) {
		getPersistence().removeByrichiesteId(id);
	}

	/**
	* Returns the number of righe richiestes where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching righe richiestes
	*/
	public static int countByrichiesteId(long id) {
		return getPersistence().countByrichiesteId(id);
	}

	/**
	* Caches the righe richieste in the entity cache if it is enabled.
	*
	* @param righeRichieste the righe richieste
	*/
	public static void cacheResult(RigheRichieste righeRichieste) {
		getPersistence().cacheResult(righeRichieste);
	}

	/**
	* Caches the righe richiestes in the entity cache if it is enabled.
	*
	* @param righeRichiestes the righe richiestes
	*/
	public static void cacheResult(List<RigheRichieste> righeRichiestes) {
		getPersistence().cacheResult(righeRichiestes);
	}

	/**
	* Creates a new righe richieste with the primary key. Does not add the righe richieste to the database.
	*
	* @param righeRichiestePK the primary key for the new righe richieste
	* @return the new righe richieste
	*/
	public static RigheRichieste create(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK) {
		return getPersistence().create(righeRichiestePK);
	}

	/**
	* Removes the righe richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste that was removed
	* @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	*/
	public static RigheRichieste remove(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteException {
		return getPersistence().remove(righeRichiestePK);
	}

	public static RigheRichieste updateImpl(RigheRichieste righeRichieste) {
		return getPersistence().updateImpl(righeRichieste);
	}

	/**
	* Returns the righe richieste with the primary key or throws a {@link NoSuchRigheRichiesteException} if it could not be found.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste
	* @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	*/
	public static RigheRichieste findByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK)
		throws external.bfc.intranet.mef.exception.NoSuchRigheRichiesteException {
		return getPersistence().findByPrimaryKey(righeRichiestePK);
	}

	/**
	* Returns the righe richieste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste, or <code>null</code> if a righe richieste with the primary key could not be found
	*/
	public static RigheRichieste fetchByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK) {
		return getPersistence().fetchByPrimaryKey(righeRichiestePK);
	}

	public static java.util.Map<java.io.Serializable, RigheRichieste> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the righe richiestes.
	*
	* @return the righe richiestes
	*/
	public static List<RigheRichieste> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the righe richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @return the range of righe richiestes
	*/
	public static List<RigheRichieste> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the righe richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe richiestes
	*/
	public static List<RigheRichieste> findAll(int start, int end,
		OrderByComparator<RigheRichieste> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the righe richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe richiestes
	*/
	public static List<RigheRichieste> findAll(int start, int end,
		OrderByComparator<RigheRichieste> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the righe richiestes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of righe richiestes.
	*
	* @return the number of righe richiestes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RigheRichiestePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RigheRichiestePersistence, RigheRichiestePersistence> _serviceTracker =
		ServiceTrackerFactory.open(RigheRichiestePersistence.class);
}