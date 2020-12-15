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

package mef.email.configurator.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EmailApp. This utility wraps
 * {@link mef.email.configurator.service.impl.EmailAppLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmailAppLocalService
 * @see mef.email.configurator.service.base.EmailAppLocalServiceBaseImpl
 * @see mef.email.configurator.service.impl.EmailAppLocalServiceImpl
 * @generated
 */
@ProviderType
public class EmailAppLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link mef.email.configurator.service.impl.EmailAppLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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
	* Returns the number of email apps.
	*
	* @return the number of email apps
	*/
	public static int getEmailAppsCount() {
		return getService().getEmailAppsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link mef.email.configurator.model.impl.EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link mef.email.configurator.model.impl.EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the email apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link mef.email.configurator.model.impl.EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email apps
	* @param end the upper bound of the range of email apps (not inclusive)
	* @return the range of email apps
	*/
	public static java.util.List<mef.email.configurator.model.EmailApp> getEmailApps(
		int start, int end) {
		return getService().getEmailApps(start, end);
	}

	public static java.util.List<mef.email.configurator.model.EmailApp> getEmailByAppIdAndStructureId(
		long appId, long structureId) {
		return getService().getEmailByAppIdAndStructureId(appId, structureId);
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

	/**
	* Adds the email app to the database. Also notifies the appropriate model listeners.
	*
	* @param emailApp the email app
	* @return the email app that was added
	*/
	public static mef.email.configurator.model.EmailApp addEmailApp(
		mef.email.configurator.model.EmailApp emailApp) {
		return getService().addEmailApp(emailApp);
	}

	/**
	* Creates a new email app with the primary key. Does not add the email app to the database.
	*
	* @param id the primary key for the new email app
	* @return the new email app
	*/
	public static mef.email.configurator.model.EmailApp createEmailApp(long id) {
		return getService().createEmailApp(id);
	}

	/**
	* Deletes the email app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email app
	* @return the email app that was removed
	* @throws PortalException if a email app with the primary key could not be found
	*/
	public static mef.email.configurator.model.EmailApp deleteEmailApp(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEmailApp(id);
	}

	/**
	* Deletes the email app from the database. Also notifies the appropriate model listeners.
	*
	* @param emailApp the email app
	* @return the email app that was removed
	*/
	public static mef.email.configurator.model.EmailApp deleteEmailApp(
		mef.email.configurator.model.EmailApp emailApp) {
		return getService().deleteEmailApp(emailApp);
	}

	public static mef.email.configurator.model.EmailApp fetchEmailApp(long id) {
		return getService().fetchEmailApp(id);
	}

	/**
	* Returns the email app with the primary key.
	*
	* @param id the primary key of the email app
	* @return the email app
	* @throws PortalException if a email app with the primary key could not be found
	*/
	public static mef.email.configurator.model.EmailApp getEmailApp(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEmailApp(id);
	}

	/**
	* Updates the email app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailApp the email app
	* @return the email app that was updated
	*/
	public static mef.email.configurator.model.EmailApp updateEmailApp(
		mef.email.configurator.model.EmailApp emailApp) {
		return getService().updateEmailApp(emailApp);
	}

	public static EmailAppLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmailAppLocalService, EmailAppLocalService> _serviceTracker =
		ServiceTrackerFactory.open(EmailAppLocalService.class);
}