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

package com.accenture.istanza.interpello.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Email. This utility wraps
 * {@link com.accenture.istanza.interpello.service.impl.EmailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmailLocalService
 * @see com.accenture.istanza.interpello.service.base.EmailLocalServiceBaseImpl
 * @see com.accenture.istanza.interpello.service.impl.EmailLocalServiceImpl
 * @generated
 */
@ProviderType
public class EmailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.accenture.istanza.interpello.service.impl.EmailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the email to the database. Also notifies the appropriate model listeners.
	*
	* @param email the email
	* @return the email that was added
	*/
	public static com.accenture.istanza.interpello.model.Email addEmail(
		com.accenture.istanza.interpello.model.Email email) {
		return getService().addEmail(email);
	}

	/**
	* Creates a new email with the primary key. Does not add the email to the database.
	*
	* @param id the primary key for the new email
	* @return the new email
	*/
	public static com.accenture.istanza.interpello.model.Email createEmail(
		long id) {
		return getService().createEmail(id);
	}

	/**
	* Deletes the email from the database. Also notifies the appropriate model listeners.
	*
	* @param email the email
	* @return the email that was removed
	*/
	public static com.accenture.istanza.interpello.model.Email deleteEmail(
		com.accenture.istanza.interpello.model.Email email) {
		return getService().deleteEmail(email);
	}

	/**
	* Deletes the email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email
	* @return the email that was removed
	* @throws PortalException if a email with the primary key could not be found
	*/
	public static com.accenture.istanza.interpello.model.Email deleteEmail(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEmail(id);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.istanza.interpello.model.impl.EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.istanza.interpello.model.impl.EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.accenture.istanza.interpello.model.Email fetchEmail(
		long id) {
		return getService().fetchEmail(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<String> getCcEmailListByIdStruttura(
		long idStruttura) {
		return getService().getCcEmailListByIdStruttura(idStruttura);
	}

	/**
	* Returns the email with the primary key.
	*
	* @param id the primary key of the email
	* @return the email
	* @throws PortalException if a email with the primary key could not be found
	*/
	public static com.accenture.istanza.interpello.model.Email getEmail(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEmail(id);
	}

	/**
	* Returns a range of all the emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.istanza.interpello.model.impl.EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emails
	* @param end the upper bound of the range of emails (not inclusive)
	* @return the range of emails
	*/
	public static java.util.List<com.accenture.istanza.interpello.model.Email> getEmails(
		int start, int end) {
		return getService().getEmails(start, end);
	}

	/**
	* Returns the number of emails.
	*
	* @return the number of emails
	*/
	public static int getEmailsCount() {
		return getService().getEmailsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param email the email
	* @return the email that was updated
	*/
	public static com.accenture.istanza.interpello.model.Email updateEmail(
		com.accenture.istanza.interpello.model.Email email) {
		return getService().updateEmail(email);
	}

	public static EmailLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmailLocalService, EmailLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmailLocalService.class);

		ServiceTracker<EmailLocalService, EmailLocalService> serviceTracker = new ServiceTracker<EmailLocalService, EmailLocalService>(bundle.getBundleContext(),
				EmailLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}