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

package com.intranet.mef.job.siap.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FestivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FestivityLocalService
 * @generated
 */
@ProviderType
public class FestivityLocalServiceWrapper implements FestivityLocalService,
	ServiceWrapper<FestivityLocalService> {
	public FestivityLocalServiceWrapper(
		FestivityLocalService festivityLocalService) {
		_festivityLocalService = festivityLocalService;
	}

	/**
	* Adds the festivity to the database. Also notifies the appropriate model listeners.
	*
	* @param festivity the festivity
	* @return the festivity that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.Festivity addFestivity(
		com.intranet.mef.job.siap.model.Festivity festivity) {
		return _festivityLocalService.addFestivity(festivity);
	}

	/**
	* Creates a new festivity with the primary key. Does not add the festivity to the database.
	*
	* @param personId the primary key for the new festivity
	* @return the new festivity
	*/
	@Override
	public com.intranet.mef.job.siap.model.Festivity createFestivity(
		long personId) {
		return _festivityLocalService.createFestivity(personId);
	}

	/**
	* Deletes the festivity from the database. Also notifies the appropriate model listeners.
	*
	* @param festivity the festivity
	* @return the festivity that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.Festivity deleteFestivity(
		com.intranet.mef.job.siap.model.Festivity festivity) {
		return _festivityLocalService.deleteFestivity(festivity);
	}

	/**
	* Deletes the festivity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the festivity
	* @return the festivity that was removed
	* @throws PortalException if a festivity with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.Festivity deleteFestivity(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _festivityLocalService.deleteFestivity(personId);
	}

	@Override
	public com.intranet.mef.job.siap.model.Festivity fetchFestivity(
		long personId) {
		return _festivityLocalService.fetchFestivity(personId);
	}

	/**
	* Returns the festivity with the primary key.
	*
	* @param personId the primary key of the festivity
	* @return the festivity
	* @throws PortalException if a festivity with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.Festivity getFestivity(long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _festivityLocalService.getFestivity(personId);
	}

	/**
	* Updates the festivity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param festivity the festivity
	* @return the festivity that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.Festivity updateFestivity(
		com.intranet.mef.job.siap.model.Festivity festivity) {
		return _festivityLocalService.updateFestivity(festivity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _festivityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _festivityLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _festivityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _festivityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _festivityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of festivities.
	*
	* @return the number of festivities
	*/
	@Override
	public int getFestivitiesCount() {
		return _festivityLocalService.getFestivitiesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _festivityLocalService.getOSGiServiceIdentifier();
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
		return _festivityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _festivityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _festivityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the festivities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.FestivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of festivities
	* @param end the upper bound of the range of festivities (not inclusive)
	* @return the range of festivities
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.Festivity> getFestivities(
		int start, int end) {
		return _festivityLocalService.getFestivities(start, end);
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
		return _festivityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _festivityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public FestivityLocalService getWrappedService() {
		return _festivityLocalService;
	}

	@Override
	public void setWrappedService(FestivityLocalService festivityLocalService) {
		_festivityLocalService = festivityLocalService;
	}

	private FestivityLocalService _festivityLocalService;
}