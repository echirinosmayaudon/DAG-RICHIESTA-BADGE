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
 * Provides a wrapper for {@link ServizioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLocalService
 * @generated
 */
@ProviderType
public class ServizioLocalServiceWrapper implements ServizioLocalService,
	ServiceWrapper<ServizioLocalService> {
	public ServizioLocalServiceWrapper(
		ServizioLocalService servizioLocalService) {
		_servizioLocalService = servizioLocalService;
	}

	/**
	* Adds the servizio to the database. Also notifies the appropriate model listeners.
	*
	* @param servizio the servizio
	* @return the servizio that was added
	*/
	@Override
	public com.intranet.mef.assistance.model.Servizio addServizio(
		com.intranet.mef.assistance.model.Servizio servizio) {
		return _servizioLocalService.addServizio(servizio);
	}

	/**
	* Creates a new servizio with the primary key. Does not add the servizio to the database.
	*
	* @param assServiceId the primary key for the new servizio
	* @return the new servizio
	*/
	@Override
	public com.intranet.mef.assistance.model.Servizio createServizio(
		java.lang.String assServiceId) {
		return _servizioLocalService.createServizio(assServiceId);
	}

	/**
	* Deletes the servizio from the database. Also notifies the appropriate model listeners.
	*
	* @param servizio the servizio
	* @return the servizio that was removed
	*/
	@Override
	public com.intranet.mef.assistance.model.Servizio deleteServizio(
		com.intranet.mef.assistance.model.Servizio servizio) {
		return _servizioLocalService.deleteServizio(servizio);
	}

	/**
	* Deletes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assServiceId the primary key of the servizio
	* @return the servizio that was removed
	* @throws PortalException if a servizio with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.assistance.model.Servizio deleteServizio(
		java.lang.String assServiceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioLocalService.deleteServizio(assServiceId);
	}

	@Override
	public com.intranet.mef.assistance.model.Servizio fetchServizio(
		java.lang.String assServiceId) {
		return _servizioLocalService.fetchServizio(assServiceId);
	}

	/**
	* Returns the servizio with the primary key.
	*
	* @param assServiceId the primary key of the servizio
	* @return the servizio
	* @throws PortalException if a servizio with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.assistance.model.Servizio getServizio(
		java.lang.String assServiceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioLocalService.getServizio(assServiceId);
	}

	/**
	* Updates the servizio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param servizio the servizio
	* @return the servizio that was updated
	*/
	@Override
	public com.intranet.mef.assistance.model.Servizio updateServizio(
		com.intranet.mef.assistance.model.Servizio servizio) {
		return _servizioLocalService.updateServizio(servizio);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _servizioLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of servizios.
	*
	* @return the number of servizios
	*/
	@Override
	public int getServiziosCount() {
		return _servizioLocalService.getServiziosCount();
	}

	@Override
	public java.lang.String findServiceNameByPK(java.lang.String assServiceId) {
		return _servizioLocalService.findServiceNameByPK(assServiceId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _servizioLocalService.getOSGiServiceIdentifier();
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
		return _servizioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _servizioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _servizioLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.assistance.model.Servizio> findByScopesId(
		java.lang.String assScopeId) {
		return _servizioLocalService.findByScopesId(assScopeId);
	}

	/**
	* Returns a range of all the servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.ServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizios
	* @param end the upper bound of the range of servizios (not inclusive)
	* @return the range of servizios
	*/
	@Override
	public java.util.List<com.intranet.mef.assistance.model.Servizio> getServizios(
		int start, int end) {
		return _servizioLocalService.getServizios(start, end);
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
		return _servizioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _servizioLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void add(java.lang.String assServiceId,
		java.lang.String serviceName, java.lang.String assScopeId,
		java.lang.String levelAssistance) {
		_servizioLocalService.add(assServiceId, serviceName, assScopeId,
			levelAssistance);
	}

	@Override
	public void removeAll() {
		_servizioLocalService.removeAll();
	}

	@Override
	public ServizioLocalService getWrappedService() {
		return _servizioLocalService;
	}

	@Override
	public void setWrappedService(ServizioLocalService servizioLocalService) {
		_servizioLocalService = servizioLocalService;
	}

	private ServizioLocalService _servizioLocalService;
}