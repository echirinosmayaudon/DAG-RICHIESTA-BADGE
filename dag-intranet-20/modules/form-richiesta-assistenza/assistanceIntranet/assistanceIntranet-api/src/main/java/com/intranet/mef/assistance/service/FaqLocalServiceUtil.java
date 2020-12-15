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

package com.intranet.mef.assistance.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Faq. This utility wraps
 * {@link com.intranet.mef.assistance.service.impl.FaqLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FaqLocalService
 * @see com.intranet.mef.assistance.service.base.FaqLocalServiceBaseImpl
 * @see com.intranet.mef.assistance.service.impl.FaqLocalServiceImpl
 * @generated
 */
@ProviderType
public class FaqLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.assistance.service.impl.FaqLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the faq to the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was added
	*/
	public static com.intranet.mef.assistance.model.Faq addFaq(
		com.intranet.mef.assistance.model.Faq faq) {
		return getService().addFaq(faq);
	}

	/**
	* Creates a new faq with the primary key. Does not add the faq to the database.
	*
	* @param faqPK the primary key for the new faq
	* @return the new faq
	*/
	public static com.intranet.mef.assistance.model.Faq createFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK) {
		return getService().createFaq(faqPK);
	}

	/**
	* Deletes the faq from the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was removed
	*/
	public static com.intranet.mef.assistance.model.Faq deleteFaq(
		com.intranet.mef.assistance.model.Faq faq) {
		return getService().deleteFaq(faq);
	}

	/**
	* Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param faqPK the primary key of the faq
	* @return the faq that was removed
	* @throws PortalException if a faq with the primary key could not be found
	*/
	public static com.intranet.mef.assistance.model.Faq deleteFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFaq(faqPK);
	}

	public static com.intranet.mef.assistance.model.Faq fetchFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK) {
		return getService().fetchFaq(faqPK);
	}

	/**
	* Returns the faq with the primary key.
	*
	* @param faqPK the primary key of the faq
	* @return the faq
	* @throws PortalException if a faq with the primary key could not be found
	*/
	public static com.intranet.mef.assistance.model.Faq getFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFaq(faqPK);
	}

	/**
	* Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was updated
	*/
	public static com.intranet.mef.assistance.model.Faq updateFaq(
		com.intranet.mef.assistance.model.Faq faq) {
		return getService().updateFaq(faq);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of faqs.
	*
	* @return the number of faqs
	*/
	public static int getFaqsCount() {
		return getService().getFaqsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.intranet.mef.assistance.model.Faq> findByProblemId(
		java.lang.String key) {
		return getService().findByProblemId(key);
	}

	/**
	* Returns a range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of faqs
	*/
	public static java.util.List<com.intranet.mef.assistance.model.Faq> getFaqs(
		int start, int end) {
		return getService().getFaqs(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void add(java.lang.String faqId, java.lang.String siebelId,
		java.lang.String questions, java.lang.String response) {
		getService().add(faqId, siebelId, questions, response);
	}

	public static void removeAll() {
		getService().removeAll();
	}

	public static FaqLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FaqLocalService, FaqLocalService> _serviceTracker =
		ServiceTrackerFactory.open(FaqLocalService.class);
}