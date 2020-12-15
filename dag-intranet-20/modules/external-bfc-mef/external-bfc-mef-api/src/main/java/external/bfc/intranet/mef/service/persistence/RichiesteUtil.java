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

import external.bfc.intranet.mef.model.Richieste;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the richieste service. This utility wraps {@link external.bfc.intranet.mef.service.persistence.impl.RichiestePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestePersistence
 * @see external.bfc.intranet.mef.service.persistence.impl.RichiestePersistenceImpl
 * @generated
 */
@ProviderType
public class RichiesteUtil {
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
	public static void clearCache(Richieste richieste) {
		getPersistence().clearCache(richieste);
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
	public static List<Richieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Richieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Richieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Richieste> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Richieste update(Richieste richieste) {
		return getPersistence().update(richieste);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Richieste update(Richieste richieste,
		ServiceContext serviceContext) {
		return getPersistence().update(richieste, serviceContext);
	}

	/**
	* Returns all the richiestes where email = &#63;.
	*
	* @param email the email
	* @return the matching richiestes
	*/
	public static List<Richieste> findByemailReqBfc(java.lang.String email) {
		return getPersistence().findByemailReqBfc(email);
	}

	/**
	* Returns a range of all the richiestes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @return the range of matching richiestes
	*/
	public static List<Richieste> findByemailReqBfc(java.lang.String email,
		int start, int end) {
		return getPersistence().findByemailReqBfc(email, start, end);
	}

	/**
	* Returns an ordered range of all the richiestes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiestes
	*/
	public static List<Richieste> findByemailReqBfc(java.lang.String email,
		int start, int end, OrderByComparator<Richieste> orderByComparator) {
		return getPersistence()
				   .findByemailReqBfc(email, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiestes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiestes
	*/
	public static List<Richieste> findByemailReqBfc(java.lang.String email,
		int start, int end, OrderByComparator<Richieste> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemailReqBfc(email, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste
	* @throws NoSuchRichiesteException if a matching richieste could not be found
	*/
	public static Richieste findByemailReqBfc_First(java.lang.String email,
		OrderByComparator<Richieste> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteException {
		return getPersistence().findByemailReqBfc_First(email, orderByComparator);
	}

	/**
	* Returns the first richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste, or <code>null</code> if a matching richieste could not be found
	*/
	public static Richieste fetchByemailReqBfc_First(java.lang.String email,
		OrderByComparator<Richieste> orderByComparator) {
		return getPersistence()
				   .fetchByemailReqBfc_First(email, orderByComparator);
	}

	/**
	* Returns the last richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste
	* @throws NoSuchRichiesteException if a matching richieste could not be found
	*/
	public static Richieste findByemailReqBfc_Last(java.lang.String email,
		OrderByComparator<Richieste> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteException {
		return getPersistence().findByemailReqBfc_Last(email, orderByComparator);
	}

	/**
	* Returns the last richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste, or <code>null</code> if a matching richieste could not be found
	*/
	public static Richieste fetchByemailReqBfc_Last(java.lang.String email,
		OrderByComparator<Richieste> orderByComparator) {
		return getPersistence().fetchByemailReqBfc_Last(email, orderByComparator);
	}

	/**
	* Returns the richiestes before and after the current richieste in the ordered set where email = &#63;.
	*
	* @param id the primary key of the current richieste
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richieste
	* @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	*/
	public static Richieste[] findByemailReqBfc_PrevAndNext(long id,
		java.lang.String email, OrderByComparator<Richieste> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteException {
		return getPersistence()
				   .findByemailReqBfc_PrevAndNext(id, email, orderByComparator);
	}

	/**
	* Removes all the richiestes where email = &#63; from the database.
	*
	* @param email the email
	*/
	public static void removeByemailReqBfc(java.lang.String email) {
		getPersistence().removeByemailReqBfc(email);
	}

	/**
	* Returns the number of richiestes where email = &#63;.
	*
	* @param email the email
	* @return the number of matching richiestes
	*/
	public static int countByemailReqBfc(java.lang.String email) {
		return getPersistence().countByemailReqBfc(email);
	}

	/**
	* Caches the richieste in the entity cache if it is enabled.
	*
	* @param richieste the richieste
	*/
	public static void cacheResult(Richieste richieste) {
		getPersistence().cacheResult(richieste);
	}

	/**
	* Caches the richiestes in the entity cache if it is enabled.
	*
	* @param richiestes the richiestes
	*/
	public static void cacheResult(List<Richieste> richiestes) {
		getPersistence().cacheResult(richiestes);
	}

	/**
	* Creates a new richieste with the primary key. Does not add the richieste to the database.
	*
	* @param id the primary key for the new richieste
	* @return the new richieste
	*/
	public static Richieste create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the richieste
	* @return the richieste that was removed
	* @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	*/
	public static Richieste remove(long id)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteException {
		return getPersistence().remove(id);
	}

	public static Richieste updateImpl(Richieste richieste) {
		return getPersistence().updateImpl(richieste);
	}

	/**
	* Returns the richieste with the primary key or throws a {@link NoSuchRichiesteException} if it could not be found.
	*
	* @param id the primary key of the richieste
	* @return the richieste
	* @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	*/
	public static Richieste findByPrimaryKey(long id)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the richieste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the richieste
	* @return the richieste, or <code>null</code> if a richieste with the primary key could not be found
	*/
	public static Richieste fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Richieste> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richiestes.
	*
	* @return the richiestes
	*/
	public static List<Richieste> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @return the range of richiestes
	*/
	public static List<Richieste> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richiestes
	*/
	public static List<Richieste> findAll(int start, int end,
		OrderByComparator<Richieste> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richiestes
	*/
	public static List<Richieste> findAll(int start, int end,
		OrderByComparator<Richieste> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richiestes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richiestes.
	*
	* @return the number of richiestes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RichiestePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestePersistence, RichiestePersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiestePersistence.class);
}