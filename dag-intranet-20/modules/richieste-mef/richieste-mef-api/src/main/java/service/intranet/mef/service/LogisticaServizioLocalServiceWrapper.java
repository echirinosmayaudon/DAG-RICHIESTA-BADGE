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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogisticaServizioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaServizioLocalService
 * @generated
 */
@ProviderType
public class LogisticaServizioLocalServiceWrapper
	implements LogisticaServizioLocalService,
		ServiceWrapper<LogisticaServizioLocalService> {
	public LogisticaServizioLocalServiceWrapper(
		LogisticaServizioLocalService logisticaServizioLocalService) {
		_logisticaServizioLocalService = logisticaServizioLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _logisticaServizioLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logisticaServizioLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _logisticaServizioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaServizioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaServizioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of logistica servizios.
	*
	* @return the number of logistica servizios
	*/
	@Override
	public int getLogisticaServiziosCount() {
		return _logisticaServizioLocalService.getLogisticaServiziosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _logisticaServizioLocalService.getOSGiServiceIdentifier();
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
		return _logisticaServizioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _logisticaServizioLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _logisticaServizioLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the logistica servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica servizios
	* @param end the upper bound of the range of logistica servizios (not inclusive)
	* @return the range of logistica servizios
	*/
	@Override
	public java.util.List<service.intranet.mef.model.LogisticaServizio> getLogisticaServizios(
		int start, int end) {
		return _logisticaServizioLocalService.getLogisticaServizios(start, end);
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
		return _logisticaServizioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _logisticaServizioLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the logistica servizio to the database. Also notifies the appropriate model listeners.
	*
	* @param logisticaServizio the logistica servizio
	* @return the logistica servizio that was added
	*/
	@Override
	public service.intranet.mef.model.LogisticaServizio addLogisticaServizio(
		service.intranet.mef.model.LogisticaServizio logisticaServizio) {
		return _logisticaServizioLocalService.addLogisticaServizio(logisticaServizio);
	}

	/**
	* Creates a new logistica servizio with the primary key. Does not add the logistica servizio to the database.
	*
	* @param id the primary key for the new logistica servizio
	* @return the new logistica servizio
	*/
	@Override
	public service.intranet.mef.model.LogisticaServizio createLogisticaServizio(
		long id) {
		return _logisticaServizioLocalService.createLogisticaServizio(id);
	}

	/**
	* Deletes the logistica servizio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica servizio
	* @return the logistica servizio that was removed
	* @throws PortalException if a logistica servizio with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.LogisticaServizio deleteLogisticaServizio(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaServizioLocalService.deleteLogisticaServizio(id);
	}

	/**
	* Deletes the logistica servizio from the database. Also notifies the appropriate model listeners.
	*
	* @param logisticaServizio the logistica servizio
	* @return the logistica servizio that was removed
	*/
	@Override
	public service.intranet.mef.model.LogisticaServizio deleteLogisticaServizio(
		service.intranet.mef.model.LogisticaServizio logisticaServizio) {
		return _logisticaServizioLocalService.deleteLogisticaServizio(logisticaServizio);
	}

	@Override
	public service.intranet.mef.model.LogisticaServizio fetchLogisticaServizio(
		long id) {
		return _logisticaServizioLocalService.fetchLogisticaServizio(id);
	}

	/**
	* Returns the logistica servizio with the primary key.
	*
	* @param id the primary key of the logistica servizio
	* @return the logistica servizio
	* @throws PortalException if a logistica servizio with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.LogisticaServizio getLogisticaServizio(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaServizioLocalService.getLogisticaServizio(id);
	}

	/**
	* Updates the logistica servizio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logisticaServizio the logistica servizio
	* @return the logistica servizio that was updated
	*/
	@Override
	public service.intranet.mef.model.LogisticaServizio updateLogisticaServizio(
		service.intranet.mef.model.LogisticaServizio logisticaServizio) {
		return _logisticaServizioLocalService.updateLogisticaServizio(logisticaServizio);
	}

	@Override
	public LogisticaServizioLocalService getWrappedService() {
		return _logisticaServizioLocalService;
	}

	@Override
	public void setWrappedService(
		LogisticaServizioLocalService logisticaServizioLocalService) {
		_logisticaServizioLocalService = logisticaServizioLocalService;
	}

	private LogisticaServizioLocalService _logisticaServizioLocalService;
}