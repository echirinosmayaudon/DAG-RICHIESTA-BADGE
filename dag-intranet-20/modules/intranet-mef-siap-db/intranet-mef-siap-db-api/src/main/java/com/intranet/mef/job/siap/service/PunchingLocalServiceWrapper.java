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
 * Provides a wrapper for {@link PunchingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PunchingLocalService
 * @generated
 */
@ProviderType
public class PunchingLocalServiceWrapper implements PunchingLocalService,
	ServiceWrapper<PunchingLocalService> {
	public PunchingLocalServiceWrapper(
		PunchingLocalService punchingLocalService) {
		_punchingLocalService = punchingLocalService;
	}

	/**
	* Adds the punching to the database. Also notifies the appropriate model listeners.
	*
	* @param punching the punching
	* @return the punching that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.Punching addPunching(
		com.intranet.mef.job.siap.model.Punching punching) {
		return _punchingLocalService.addPunching(punching);
	}

	/**
	* Creates a new punching with the primary key. Does not add the punching to the database.
	*
	* @param custom_key the primary key for the new punching
	* @return the new punching
	*/
	@Override
	public com.intranet.mef.job.siap.model.Punching createPunching(
		java.lang.String custom_key) {
		return _punchingLocalService.createPunching(custom_key);
	}

	/**
	* Deletes the punching from the database. Also notifies the appropriate model listeners.
	*
	* @param punching the punching
	* @return the punching that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.Punching deletePunching(
		com.intranet.mef.job.siap.model.Punching punching) {
		return _punchingLocalService.deletePunching(punching);
	}

	/**
	* Deletes the punching with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the punching
	* @return the punching that was removed
	* @throws PortalException if a punching with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.Punching deletePunching(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _punchingLocalService.deletePunching(custom_key);
	}

	@Override
	public com.intranet.mef.job.siap.model.Punching fetchPunching(
		java.lang.String custom_key) {
		return _punchingLocalService.fetchPunching(custom_key);
	}

	/**
	* Returns the punching with the primary key.
	*
	* @param custom_key the primary key of the punching
	* @return the punching
	* @throws PortalException if a punching with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.Punching getPunching(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _punchingLocalService.getPunching(custom_key);
	}

	/**
	* Updates the punching in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param punching the punching
	* @return the punching that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.Punching updatePunching(
		com.intranet.mef.job.siap.model.Punching punching) {
		return _punchingLocalService.updatePunching(punching);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _punchingLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _punchingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _punchingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of punchings.
	*
	* @return the number of punchings
	*/
	@Override
	public int getPunchingsCount() {
		return _punchingLocalService.getPunchingsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _punchingLocalService.getOSGiServiceIdentifier();
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
		return _punchingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _punchingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _punchingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.job.siap.model.Punching> getPunchingByPersonId(
		long personId) {
		return _punchingLocalService.getPunchingByPersonId(personId);
	}

	/**
	* Returns a range of all the punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @return the range of punchings
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.Punching> getPunchings(
		int start, int end) {
		return _punchingLocalService.getPunchings(start, end);
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
		return _punchingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _punchingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public PunchingLocalService getWrappedService() {
		return _punchingLocalService;
	}

	@Override
	public void setWrappedService(PunchingLocalService punchingLocalService) {
		_punchingLocalService = punchingLocalService;
	}

	private PunchingLocalService _punchingLocalService;
}