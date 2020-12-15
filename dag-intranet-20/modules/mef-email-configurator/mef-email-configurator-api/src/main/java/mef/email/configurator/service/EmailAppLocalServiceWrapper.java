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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmailAppLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmailAppLocalService
 * @generated
 */
@ProviderType
public class EmailAppLocalServiceWrapper implements EmailAppLocalService,
	ServiceWrapper<EmailAppLocalService> {
	public EmailAppLocalServiceWrapper(
		EmailAppLocalService emailAppLocalService) {
		_emailAppLocalService = emailAppLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _emailAppLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailAppLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _emailAppLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailAppLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailAppLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of email apps.
	*
	* @return the number of email apps
	*/
	@Override
	public int getEmailAppsCount() {
		return _emailAppLocalService.getEmailAppsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _emailAppLocalService.getOSGiServiceIdentifier();
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
		return _emailAppLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _emailAppLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _emailAppLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<mef.email.configurator.model.EmailApp> getEmailApps(
		int start, int end) {
		return _emailAppLocalService.getEmailApps(start, end);
	}

	@Override
	public java.util.List<mef.email.configurator.model.EmailApp> getEmailByAppIdAndStructureId(
		long appId, long structureId) {
		return _emailAppLocalService.getEmailByAppIdAndStructureId(appId,
			structureId);
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
		return _emailAppLocalService.dynamicQueryCount(dynamicQuery);
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
		return _emailAppLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the email app to the database. Also notifies the appropriate model listeners.
	*
	* @param emailApp the email app
	* @return the email app that was added
	*/
	@Override
	public mef.email.configurator.model.EmailApp addEmailApp(
		mef.email.configurator.model.EmailApp emailApp) {
		return _emailAppLocalService.addEmailApp(emailApp);
	}

	/**
	* Creates a new email app with the primary key. Does not add the email app to the database.
	*
	* @param id the primary key for the new email app
	* @return the new email app
	*/
	@Override
	public mef.email.configurator.model.EmailApp createEmailApp(long id) {
		return _emailAppLocalService.createEmailApp(id);
	}

	/**
	* Deletes the email app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email app
	* @return the email app that was removed
	* @throws PortalException if a email app with the primary key could not be found
	*/
	@Override
	public mef.email.configurator.model.EmailApp deleteEmailApp(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailAppLocalService.deleteEmailApp(id);
	}

	/**
	* Deletes the email app from the database. Also notifies the appropriate model listeners.
	*
	* @param emailApp the email app
	* @return the email app that was removed
	*/
	@Override
	public mef.email.configurator.model.EmailApp deleteEmailApp(
		mef.email.configurator.model.EmailApp emailApp) {
		return _emailAppLocalService.deleteEmailApp(emailApp);
	}

	@Override
	public mef.email.configurator.model.EmailApp fetchEmailApp(long id) {
		return _emailAppLocalService.fetchEmailApp(id);
	}

	/**
	* Returns the email app with the primary key.
	*
	* @param id the primary key of the email app
	* @return the email app
	* @throws PortalException if a email app with the primary key could not be found
	*/
	@Override
	public mef.email.configurator.model.EmailApp getEmailApp(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailAppLocalService.getEmailApp(id);
	}

	/**
	* Updates the email app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailApp the email app
	* @return the email app that was updated
	*/
	@Override
	public mef.email.configurator.model.EmailApp updateEmailApp(
		mef.email.configurator.model.EmailApp emailApp) {
		return _emailAppLocalService.updateEmailApp(emailApp);
	}

	@Override
	public EmailAppLocalService getWrappedService() {
		return _emailAppLocalService;
	}

	@Override
	public void setWrappedService(EmailAppLocalService emailAppLocalService) {
		_emailAppLocalService = emailAppLocalService;
	}

	private EmailAppLocalService _emailAppLocalService;
}