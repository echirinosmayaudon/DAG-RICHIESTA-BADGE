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

package com.intranet.mef.assistance.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Faq;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the faq service. This utility wraps {@link com.intranet.mef.assistance.service.persistence.impl.FaqPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FaqPersistence
 * @see com.intranet.mef.assistance.service.persistence.impl.FaqPersistenceImpl
 * @generated
 */
@ProviderType
public class FaqUtil {
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
	public static void clearCache(Faq faq) {
		getPersistence().clearCache(faq);
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
	public static List<Faq> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Faq> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Faq> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Faq> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Faq update(Faq faq) {
		return getPersistence().update(faq);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Faq update(Faq faq, ServiceContext serviceContext) {
		return getPersistence().update(faq, serviceContext);
	}

	/**
	* Returns all the faqs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching faqs
	*/
	public static List<Faq> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the faqs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of matching faqs
	*/
	public static List<Faq> findByUuid(java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the faqs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching faqs
	*/
	public static List<Faq> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Faq> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the faqs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching faqs
	*/
	public static List<Faq> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Faq> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public static Faq findByUuid_First(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public static Faq fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public static Faq findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public static Faq fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the faqs before and after the current faq in the ordered set where uuid = &#63;.
	*
	* @param faqPK the primary key of the current faq
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next faq
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public static Faq[] findByUuid_PrevAndNext(FaqPK faqPK,
		java.lang.String uuid, OrderByComparator<Faq> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence()
				   .findByUuid_PrevAndNext(faqPK, uuid, orderByComparator);
	}

	/**
	* Removes all the faqs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of faqs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching faqs
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the faqs where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @return the matching faqs
	*/
	public static List<Faq> findByFaqId(java.lang.String faqId) {
		return getPersistence().findByFaqId(faqId);
	}

	/**
	* Returns a range of all the faqs where faqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param faqId the faq ID
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of matching faqs
	*/
	public static List<Faq> findByFaqId(java.lang.String faqId, int start,
		int end) {
		return getPersistence().findByFaqId(faqId, start, end);
	}

	/**
	* Returns an ordered range of all the faqs where faqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param faqId the faq ID
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching faqs
	*/
	public static List<Faq> findByFaqId(java.lang.String faqId, int start,
		int end, OrderByComparator<Faq> orderByComparator) {
		return getPersistence().findByFaqId(faqId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the faqs where faqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param faqId the faq ID
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching faqs
	*/
	public static List<Faq> findByFaqId(java.lang.String faqId, int start,
		int end, OrderByComparator<Faq> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFaqId(faqId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public static Faq findByFaqId_First(java.lang.String faqId,
		OrderByComparator<Faq> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence().findByFaqId_First(faqId, orderByComparator);
	}

	/**
	* Returns the first faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public static Faq fetchByFaqId_First(java.lang.String faqId,
		OrderByComparator<Faq> orderByComparator) {
		return getPersistence().fetchByFaqId_First(faqId, orderByComparator);
	}

	/**
	* Returns the last faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public static Faq findByFaqId_Last(java.lang.String faqId,
		OrderByComparator<Faq> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence().findByFaqId_Last(faqId, orderByComparator);
	}

	/**
	* Returns the last faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public static Faq fetchByFaqId_Last(java.lang.String faqId,
		OrderByComparator<Faq> orderByComparator) {
		return getPersistence().fetchByFaqId_Last(faqId, orderByComparator);
	}

	/**
	* Returns the faqs before and after the current faq in the ordered set where faqId = &#63;.
	*
	* @param faqPK the primary key of the current faq
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next faq
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public static Faq[] findByFaqId_PrevAndNext(FaqPK faqPK,
		java.lang.String faqId, OrderByComparator<Faq> orderByComparator)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence()
				   .findByFaqId_PrevAndNext(faqPK, faqId, orderByComparator);
	}

	/**
	* Removes all the faqs where faqId = &#63; from the database.
	*
	* @param faqId the faq ID
	*/
	public static void removeByFaqId(java.lang.String faqId) {
		getPersistence().removeByFaqId(faqId);
	}

	/**
	* Returns the number of faqs where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @return the number of matching faqs
	*/
	public static int countByFaqId(java.lang.String faqId) {
		return getPersistence().countByFaqId(faqId);
	}

	/**
	* Caches the faq in the entity cache if it is enabled.
	*
	* @param faq the faq
	*/
	public static void cacheResult(Faq faq) {
		getPersistence().cacheResult(faq);
	}

	/**
	* Caches the faqs in the entity cache if it is enabled.
	*
	* @param faqs the faqs
	*/
	public static void cacheResult(List<Faq> faqs) {
		getPersistence().cacheResult(faqs);
	}

	/**
	* Creates a new faq with the primary key. Does not add the faq to the database.
	*
	* @param faqPK the primary key for the new faq
	* @return the new faq
	*/
	public static Faq create(FaqPK faqPK) {
		return getPersistence().create(faqPK);
	}

	/**
	* Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param faqPK the primary key of the faq
	* @return the faq that was removed
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public static Faq remove(FaqPK faqPK)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence().remove(faqPK);
	}

	public static Faq updateImpl(Faq faq) {
		return getPersistence().updateImpl(faq);
	}

	/**
	* Returns the faq with the primary key or throws a {@link NoSuchFaqException} if it could not be found.
	*
	* @param faqPK the primary key of the faq
	* @return the faq
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public static Faq findByPrimaryKey(FaqPK faqPK)
		throws com.intranet.mef.assistance.exception.NoSuchFaqException {
		return getPersistence().findByPrimaryKey(faqPK);
	}

	/**
	* Returns the faq with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param faqPK the primary key of the faq
	* @return the faq, or <code>null</code> if a faq with the primary key could not be found
	*/
	public static Faq fetchByPrimaryKey(FaqPK faqPK) {
		return getPersistence().fetchByPrimaryKey(faqPK);
	}

	public static java.util.Map<java.io.Serializable, Faq> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the faqs.
	*
	* @return the faqs
	*/
	public static List<Faq> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of faqs
	*/
	public static List<Faq> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of faqs
	*/
	public static List<Faq> findAll(int start, int end,
		OrderByComparator<Faq> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of faqs
	*/
	public static List<Faq> findAll(int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the faqs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of faqs.
	*
	* @return the number of faqs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FaqPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FaqPersistence, FaqPersistence> _serviceTracker =
		ServiceTrackerFactory.open(FaqPersistence.class);
}