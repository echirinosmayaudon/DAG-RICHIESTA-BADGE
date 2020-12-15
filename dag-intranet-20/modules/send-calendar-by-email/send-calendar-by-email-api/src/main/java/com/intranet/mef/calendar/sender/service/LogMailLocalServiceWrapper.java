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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogMailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LogMailLocalService
 * @generated
 */
@ProviderType
public class LogMailLocalServiceWrapper implements LogMailLocalService,
	ServiceWrapper<LogMailLocalService> {
	public LogMailLocalServiceWrapper(LogMailLocalService logMailLocalService) {
		_logMailLocalService = logMailLocalService;
	}

	/**
	* Adds the log mail to the database. Also notifies the appropriate model listeners.
	*
	* @param logMail the log mail
	* @return the log mail that was added
	*/
	@Override
	public com.intranet.mef.calendar.sender.model.LogMail addLogMail(
		com.intranet.mef.calendar.sender.model.LogMail logMail) {
		return _logMailLocalService.addLogMail(logMail);
	}

	/**
	* Creates a new log mail with the primary key. Does not add the log mail to the database.
	*
	* @param logMailId the primary key for the new log mail
	* @return the new log mail
	*/
	@Override
	public com.intranet.mef.calendar.sender.model.LogMail createLogMail(
		long logMailId) {
		return _logMailLocalService.createLogMail(logMailId);
	}

	/**
	* Deletes the log mail from the database. Also notifies the appropriate model listeners.
	*
	* @param logMail the log mail
	* @return the log mail that was removed
	*/
	@Override
	public com.intranet.mef.calendar.sender.model.LogMail deleteLogMail(
		com.intranet.mef.calendar.sender.model.LogMail logMail) {
		return _logMailLocalService.deleteLogMail(logMail);
	}

	/**
	* Deletes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail that was removed
	* @throws PortalException if a log mail with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.calendar.sender.model.LogMail deleteLogMail(
		long logMailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logMailLocalService.deleteLogMail(logMailId);
	}

	@Override
	public com.intranet.mef.calendar.sender.model.LogMail fetchLogMail(
		long logMailId) {
		return _logMailLocalService.fetchLogMail(logMailId);
	}

	/**
	* Returns the log mail with the primary key.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail
	* @throws PortalException if a log mail with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.calendar.sender.model.LogMail getLogMail(
		long logMailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logMailLocalService.getLogMail(logMailId);
	}

	/**
	* Updates the log mail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logMail the log mail
	* @return the log mail that was updated
	*/
	@Override
	public com.intranet.mef.calendar.sender.model.LogMail updateLogMail(
		com.intranet.mef.calendar.sender.model.LogMail logMail) {
		return _logMailLocalService.updateLogMail(logMail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _logMailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logMailLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _logMailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logMailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logMailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of log mails.
	*
	* @return the number of log mails
	*/
	@Override
	public int getLogMailsCount() {
		return _logMailLocalService.getLogMailsCount();
	}

	@Override
	public java.io.File generateIcsFile(java.lang.Long timeStart,
		java.lang.Long timeFinish, java.lang.String eventTitle,
		java.lang.String eventDescription, java.lang.String icsDescription)
		throws java.io.IOException {
		return _logMailLocalService.generateIcsFile(timeStart, timeFinish,
			eventTitle, eventDescription, icsDescription);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _logMailLocalService.getOSGiServiceIdentifier();
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
		return _logMailLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _logMailLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _logMailLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<com.intranet.mef.calendar.sender.model.LogMail> getLogMails(
		int start, int end) {
		return _logMailLocalService.getLogMails(start, end);
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
		return _logMailLocalService.dynamicQueryCount(dynamicQuery);
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
		return _logMailLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void sendMailWithAttachment(java.lang.String mailTo,
		java.lang.Long timeStart, java.lang.Long timeFinish,
		java.lang.String eventTitle, java.lang.String eventDescription,
		java.lang.String icsDescription) throws java.io.IOException {
		_logMailLocalService.sendMailWithAttachment(mailTo, timeStart,
			timeFinish, eventTitle, eventDescription, icsDescription);
	}

	@Override
	public LogMailLocalService getWrappedService() {
		return _logMailLocalService;
	}

	@Override
	public void setWrappedService(LogMailLocalService logMailLocalService) {
		_logMailLocalService = logMailLocalService;
	}

	private LogMailLocalService _logMailLocalService;
}