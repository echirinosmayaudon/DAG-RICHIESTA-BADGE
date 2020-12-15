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

package autorizzazione.dir.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScrivaniaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaLocalService
 * @generated
 */
@ProviderType
public class ScrivaniaLocalServiceWrapper implements ScrivaniaLocalService,
	ServiceWrapper<ScrivaniaLocalService> {
	public ScrivaniaLocalServiceWrapper(
		ScrivaniaLocalService scrivaniaLocalService) {
		_scrivaniaLocalService = scrivaniaLocalService;
	}

	/**
	* Adds the scrivania to the database. Also notifies the appropriate model listeners.
	*
	* @param scrivania the scrivania
	* @return the scrivania that was added
	*/
	@Override
	public autorizzazione.dir.mef.model.Scrivania addScrivania(
		autorizzazione.dir.mef.model.Scrivania scrivania) {
		return _scrivaniaLocalService.addScrivania(scrivania);
	}

	/**
	* Creates a new scrivania with the primary key. Does not add the scrivania to the database.
	*
	* @param scrivaniaPK the primary key for the new scrivania
	* @return the new scrivania
	*/
	@Override
	public autorizzazione.dir.mef.model.Scrivania createScrivania(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK) {
		return _scrivaniaLocalService.createScrivania(scrivaniaPK);
	}

	/**
	* Deletes the scrivania from the database. Also notifies the appropriate model listeners.
	*
	* @param scrivania the scrivania
	* @return the scrivania that was removed
	*/
	@Override
	public autorizzazione.dir.mef.model.Scrivania deleteScrivania(
		autorizzazione.dir.mef.model.Scrivania scrivania) {
		return _scrivaniaLocalService.deleteScrivania(scrivania);
	}

	/**
	* Deletes the scrivania with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania that was removed
	* @throws PortalException if a scrivania with the primary key could not be found
	*/
	@Override
	public autorizzazione.dir.mef.model.Scrivania deleteScrivania(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scrivaniaLocalService.deleteScrivania(scrivaniaPK);
	}

	@Override
	public autorizzazione.dir.mef.model.Scrivania fetchScrivania(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK) {
		return _scrivaniaLocalService.fetchScrivania(scrivaniaPK);
	}

	/**
	* Returns the scrivania with the primary key.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania
	* @throws PortalException if a scrivania with the primary key could not be found
	*/
	@Override
	public autorizzazione.dir.mef.model.Scrivania getScrivania(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scrivaniaLocalService.getScrivania(scrivaniaPK);
	}

	/**
	* Updates the scrivania in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scrivania the scrivania
	* @return the scrivania that was updated
	*/
	@Override
	public autorizzazione.dir.mef.model.Scrivania updateScrivania(
		autorizzazione.dir.mef.model.Scrivania scrivania) {
		return _scrivaniaLocalService.updateScrivania(scrivania);
	}

	@Override
	public boolean addAppToHome(long userId, long applicationId) {
		return _scrivaniaLocalService.addAppToHome(userId, applicationId);
	}

	@Override
	public boolean addAppToProfile(long userId, long applicationId) {
		return _scrivaniaLocalService.addAppToProfile(userId, applicationId);
	}

	@Override
	public boolean removeAppFromHome(long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return _scrivaniaLocalService.removeAppFromHome(userId, applicationId);
	}

	@Override
	public boolean removeAppFromProfile(long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return _scrivaniaLocalService.removeAppFromProfile(userId, applicationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _scrivaniaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scrivaniaLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _scrivaniaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scrivaniaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scrivaniaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of scrivanias.
	*
	* @return the number of scrivanias
	*/
	@Override
	public int getScrivaniasCount() {
		return _scrivaniaLocalService.getScrivaniasCount();
	}

	@Override
	public java.lang.String getHomeApps(long userId) {
		return _scrivaniaLocalService.getHomeApps(userId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _scrivaniaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getProfileApps(long userId) {
		return _scrivaniaLocalService.getProfileApps(userId);
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
		return _scrivaniaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scrivaniaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scrivaniaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the scrivanias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @return the range of scrivanias
	*/
	@Override
	public java.util.List<autorizzazione.dir.mef.model.Scrivania> getScrivanias(
		int start, int end) {
		return _scrivaniaLocalService.getScrivanias(start, end);
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
		return _scrivaniaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _scrivaniaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ScrivaniaLocalService getWrappedService() {
		return _scrivaniaLocalService;
	}

	@Override
	public void setWrappedService(ScrivaniaLocalService scrivaniaLocalService) {
		_scrivaniaLocalService = scrivaniaLocalService;
	}

	private ScrivaniaLocalService _scrivaniaLocalService;
}