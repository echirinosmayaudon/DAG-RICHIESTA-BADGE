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

package com.intranet.mef.calendar.sender.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for LogMail. This utility wraps
 * {@link com.intranet.mef.calendar.sender.service.impl.LogMailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LogMailLocalService
 * @see com.intranet.mef.calendar.sender.service.base.LogMailLocalServiceBaseImpl
 * @see com.intranet.mef.calendar.sender.service.impl.LogMailLocalServiceImpl
 * @generated
 */
@ProviderType
public class LogMailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.calendar.sender.service.impl.LogMailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the log mail to the database. Also notifies the appropriate model listeners.
	*
	* @param logMail the log mail
	* @return the log mail that was added
	*/
	public static com.intranet.mef.calendar.sender.model.LogMail addLogMail(
		com.intranet.mef.calendar.sender.model.LogMail logMail) {
		return getService().addLogMail(logMail);
	}

	/**
	* Creates a new log mail with the primary key. Does not add the log mail to the database.
	*
	* @param logMailId the primary key for the new log mail
	* @return the new log mail
	*/
	public static com.intranet.mef.calendar.sender.model.LogMail createLogMail(
		long logMailId) {
		return getService().createLogMail(logMailId);
	}

	/**
	* Deletes the log mail from the database. Also notifies the appropriate model listeners.
	*
	* @param logMail the log mail
	* @return the log mail that was removed
	*/
	public static com.intranet.mef.calendar.sender.model.LogMail deleteLogMail(
		com.intranet.mef.calendar.sender.model.LogMail logMail) {
		return getService().deleteLogMail(logMail);
	}

	/**
	* Deletes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail that was removed
	* @throws PortalException if a log mail with the primary key could not be found
	*/
	public static com.intranet.mef.calendar.sender.model.LogMail deleteLogMail(
		long logMailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLogMail(logMailId);
	}

	public static com.intranet.mef.calendar.sender.model.LogMail fetchLogMail(
		long logMailId) {
		return getService().fetchLogMail(logMailId);
	}

	/**
	* Returns the log mail with the primary key.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail
	* @throws PortalException if a log mail with the primary key could not be found
	*/
	public static com.intranet.mef.calendar.sender.model.LogMail getLogMail(
		long logMailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLogMail(logMailId);
	}

	/**
	* Updates the log mail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logMail the log mail
	* @return the log mail that was updated
	*/
	public static com.intranet.mef.calendar.sender.model.LogMail updateLogMail(
		com.intranet.mef.calendar.sender.model.LogMail logMail) {
		return getService().updateLogMail(logMail);
	}

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
	* Returns the number of log mails.
	*
	* @return the number of log mails
	*/
	public static int getLogMailsCount() {
		return getService().getLogMailsCount();
	}

	public static java.io.File generateIcsFile(java.lang.Long timeStart,
		java.lang.Long timeFinish, java.lang.String eventTitle,
		java.lang.String eventDescription, java.lang.String icsDescription)
		throws java.io.IOException {
		return getService()
				   .generateIcsFile(timeStart, timeFinish, eventTitle,
			eventDescription, icsDescription);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.calendar.sender.model.impl.LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.calendar.sender.model.impl.LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the log mails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.calendar.sender.model.impl.LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @return the range of log mails
	*/
	public static java.util.List<com.intranet.mef.calendar.sender.model.LogMail> getLogMails(
		int start, int end) {
		return getService().getLogMails(start, end);
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

	public static void sendMailWithAttachment(java.lang.String mailTo,
		java.lang.Long timeStart, java.lang.Long timeFinish,
		java.lang.String eventTitle, java.lang.String eventDescription,
		java.lang.String icsDescription) throws java.io.IOException {
		getService()
			.sendMailWithAttachment(mailTo, timeStart, timeFinish, eventTitle,
			eventDescription, icsDescription);
	}

	public static LogMailLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LogMailLocalService, LogMailLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LogMailLocalService.class);
}