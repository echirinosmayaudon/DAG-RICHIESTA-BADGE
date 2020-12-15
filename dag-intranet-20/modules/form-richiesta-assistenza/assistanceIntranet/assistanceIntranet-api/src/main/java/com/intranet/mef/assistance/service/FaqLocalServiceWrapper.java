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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FaqLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FaqLocalService
 * @generated
 */
@ProviderType
public class FaqLocalServiceWrapper implements FaqLocalService,
	ServiceWrapper<FaqLocalService> {
	public FaqLocalServiceWrapper(FaqLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	/**
	* Adds the faq to the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was added
	*/
	@Override
	public com.intranet.mef.assistance.model.Faq addFaq(
		com.intranet.mef.assistance.model.Faq faq) {
		return _faqLocalService.addFaq(faq);
	}

	/**
	* Creates a new faq with the primary key. Does not add the faq to the database.
	*
	* @param faqPK the primary key for the new faq
	* @return the new faq
	*/
	@Override
	public com.intranet.mef.assistance.model.Faq createFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK) {
		return _faqLocalService.createFaq(faqPK);
	}

	/**
	* Deletes the faq from the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was removed
	*/
	@Override
	public com.intranet.mef.assistance.model.Faq deleteFaq(
		com.intranet.mef.assistance.model.Faq faq) {
		return _faqLocalService.deleteFaq(faq);
	}

	/**
	* Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param faqPK the primary key of the faq
	* @return the faq that was removed
	* @throws PortalException if a faq with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.assistance.model.Faq deleteFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.deleteFaq(faqPK);
	}

	@Override
	public com.intranet.mef.assistance.model.Faq fetchFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK) {
		return _faqLocalService.fetchFaq(faqPK);
	}

	/**
	* Returns the faq with the primary key.
	*
	* @param faqPK the primary key of the faq
	* @return the faq
	* @throws PortalException if a faq with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.assistance.model.Faq getFaq(
		com.intranet.mef.assistance.service.persistence.FaqPK faqPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.getFaq(faqPK);
	}

	/**
	* Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was updated
	*/
	@Override
	public com.intranet.mef.assistance.model.Faq updateFaq(
		com.intranet.mef.assistance.model.Faq faq) {
		return _faqLocalService.updateFaq(faq);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _faqLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of faqs.
	*
	* @return the number of faqs
	*/
	@Override
	public int getFaqsCount() {
		return _faqLocalService.getFaqsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _faqLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _faqLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _faqLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _faqLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.assistance.model.Faq> findByProblemId(
		java.lang.String key) {
		return _faqLocalService.findByProblemId(key);
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
	@Override
	public java.util.List<com.intranet.mef.assistance.model.Faq> getFaqs(
		int start, int end) {
		return _faqLocalService.getFaqs(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _faqLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _faqLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void add(java.lang.String faqId, java.lang.String siebelId,
		java.lang.String questions, java.lang.String response) {
		_faqLocalService.add(faqId, siebelId, questions, response);
	}

	@Override
	public void removeAll() {
		_faqLocalService.removeAll();
	}

	@Override
	public FaqLocalService getWrappedService() {
		return _faqLocalService;
	}

	@Override
	public void setWrappedService(FaqLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	private FaqLocalService _faqLocalService;
}