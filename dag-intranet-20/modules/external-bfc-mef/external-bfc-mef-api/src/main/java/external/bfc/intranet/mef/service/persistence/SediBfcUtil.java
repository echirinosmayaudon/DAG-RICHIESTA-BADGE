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

import external.bfc.intranet.mef.model.SediBfc;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the sedi bfc service. This utility wraps {@link external.bfc.intranet.mef.service.persistence.impl.SediBfcPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediBfcPersistence
 * @see external.bfc.intranet.mef.service.persistence.impl.SediBfcPersistenceImpl
 * @generated
 */
@ProviderType
public class SediBfcUtil {
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
	public static void clearCache(SediBfc sediBfc) {
		getPersistence().clearCache(sediBfc);
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
	public static List<SediBfc> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SediBfc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SediBfc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SediBfc update(SediBfc sediBfc) {
		return getPersistence().update(sediBfc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SediBfc update(SediBfc sediBfc, ServiceContext serviceContext) {
		return getPersistence().update(sediBfc, serviceContext);
	}

	/**
	* Returns all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @return the matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app) {
		return getPersistence().findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app);
	}

	/**
	* Returns a range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @return the range of matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end) {
		return getPersistence()
				   .findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app, start, end);
	}

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence()
				   .findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public static SediBfc findByIdOrgLiv2AndFlagApp_First(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence()
				   .findByIdOrgLiv2AndFlagApp_First(id_org_liv2, flag_app,
			orderByComparator);
	}

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public static SediBfc fetchByIdOrgLiv2AndFlagApp_First(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence()
				   .fetchByIdOrgLiv2AndFlagApp_First(id_org_liv2, flag_app,
			orderByComparator);
	}

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public static SediBfc findByIdOrgLiv2AndFlagApp_Last(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence()
				   .findByIdOrgLiv2AndFlagApp_Last(id_org_liv2, flag_app,
			orderByComparator);
	}

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public static SediBfc fetchByIdOrgLiv2AndFlagApp_Last(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence()
				   .fetchByIdOrgLiv2AndFlagApp_Last(id_org_liv2, flag_app,
			orderByComparator);
	}

	/**
	* Returns the sedi bfcs before and after the current sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id the primary key of the current sedi bfc
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi bfc
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public static SediBfc[] findByIdOrgLiv2AndFlagApp_PrevAndNext(long id,
		long id_org_liv2, boolean flag_app,
		OrderByComparator<SediBfc> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence()
				   .findByIdOrgLiv2AndFlagApp_PrevAndNext(id, id_org_liv2,
			flag_app, orderByComparator);
	}

	/**
	* Removes all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63; from the database.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	*/
	public static void removeByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app) {
		getPersistence().removeByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app);
	}

	/**
	* Returns the number of sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @return the number of matching sedi bfcs
	*/
	public static int countByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app) {
		return getPersistence().countByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app);
	}

	/**
	* Returns all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @return the matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app) {
		return getPersistence().findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app);
	}

	/**
	* Returns a range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @return the range of matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end) {
		return getPersistence()
				   .findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app, start, end);
	}

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence()
				   .findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi bfcs
	*/
	public static List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public static SediBfc findByIdOrgLiv3AndFlagApp_First(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence()
				   .findByIdOrgLiv3AndFlagApp_First(id_org_liv3, flag_app,
			orderByComparator);
	}

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public static SediBfc fetchByIdOrgLiv3AndFlagApp_First(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence()
				   .fetchByIdOrgLiv3AndFlagApp_First(id_org_liv3, flag_app,
			orderByComparator);
	}

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public static SediBfc findByIdOrgLiv3AndFlagApp_Last(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence()
				   .findByIdOrgLiv3AndFlagApp_Last(id_org_liv3, flag_app,
			orderByComparator);
	}

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public static SediBfc fetchByIdOrgLiv3AndFlagApp_Last(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence()
				   .fetchByIdOrgLiv3AndFlagApp_Last(id_org_liv3, flag_app,
			orderByComparator);
	}

	/**
	* Returns the sedi bfcs before and after the current sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id the primary key of the current sedi bfc
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi bfc
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public static SediBfc[] findByIdOrgLiv3AndFlagApp_PrevAndNext(long id,
		long id_org_liv3, boolean flag_app,
		OrderByComparator<SediBfc> orderByComparator)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence()
				   .findByIdOrgLiv3AndFlagApp_PrevAndNext(id, id_org_liv3,
			flag_app, orderByComparator);
	}

	/**
	* Removes all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63; from the database.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	*/
	public static void removeByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app) {
		getPersistence().removeByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app);
	}

	/**
	* Returns the number of sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @return the number of matching sedi bfcs
	*/
	public static int countByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app) {
		return getPersistence().countByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app);
	}

	/**
	* Caches the sedi bfc in the entity cache if it is enabled.
	*
	* @param sediBfc the sedi bfc
	*/
	public static void cacheResult(SediBfc sediBfc) {
		getPersistence().cacheResult(sediBfc);
	}

	/**
	* Caches the sedi bfcs in the entity cache if it is enabled.
	*
	* @param sediBfcs the sedi bfcs
	*/
	public static void cacheResult(List<SediBfc> sediBfcs) {
		getPersistence().cacheResult(sediBfcs);
	}

	/**
	* Creates a new sedi bfc with the primary key. Does not add the sedi bfc to the database.
	*
	* @param id the primary key for the new sedi bfc
	* @return the new sedi bfc
	*/
	public static SediBfc create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the sedi bfc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc that was removed
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public static SediBfc remove(long id)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence().remove(id);
	}

	public static SediBfc updateImpl(SediBfc sediBfc) {
		return getPersistence().updateImpl(sediBfc);
	}

	/**
	* Returns the sedi bfc with the primary key or throws a {@link NoSuchSediBfcException} if it could not be found.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public static SediBfc findByPrimaryKey(long id)
		throws external.bfc.intranet.mef.exception.NoSuchSediBfcException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the sedi bfc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc, or <code>null</code> if a sedi bfc with the primary key could not be found
	*/
	public static SediBfc fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, SediBfc> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the sedi bfcs.
	*
	* @return the sedi bfcs
	*/
	public static List<SediBfc> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sedi bfcs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @return the range of sedi bfcs
	*/
	public static List<SediBfc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sedi bfcs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sedi bfcs
	*/
	public static List<SediBfc> findAll(int start, int end,
		OrderByComparator<SediBfc> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sedi bfcs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sedi bfcs
	*/
	public static List<SediBfc> findAll(int start, int end,
		OrderByComparator<SediBfc> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the sedi bfcs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sedi bfcs.
	*
	* @return the number of sedi bfcs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SediBfcPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SediBfcPersistence, SediBfcPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SediBfcPersistence.class);
}