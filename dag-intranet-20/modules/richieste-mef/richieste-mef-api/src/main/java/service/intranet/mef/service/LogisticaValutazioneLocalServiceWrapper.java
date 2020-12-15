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
 * Provides a wrapper for {@link LogisticaValutazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaValutazioneLocalService
 * @generated
 */
@ProviderType
public class LogisticaValutazioneLocalServiceWrapper
	implements LogisticaValutazioneLocalService,
		ServiceWrapper<LogisticaValutazioneLocalService> {
	public LogisticaValutazioneLocalServiceWrapper(
		LogisticaValutazioneLocalService logisticaValutazioneLocalService) {
		_logisticaValutazioneLocalService = logisticaValutazioneLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _logisticaValutazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logisticaValutazioneLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _logisticaValutazioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaValutazioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaValutazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of logistica valutaziones.
	*
	* @return the number of logistica valutaziones
	*/
	@Override
	public int getLogisticaValutazionesCount() {
		return _logisticaValutazioneLocalService.getLogisticaValutazionesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _logisticaValutazioneLocalService.getOSGiServiceIdentifier();
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
		return _logisticaValutazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _logisticaValutazioneLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _logisticaValutazioneLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the logistica valutaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica valutaziones
	* @param end the upper bound of the range of logistica valutaziones (not inclusive)
	* @return the range of logistica valutaziones
	*/
	@Override
	public java.util.List<service.intranet.mef.model.LogisticaValutazione> getLogisticaValutaziones(
		int start, int end) {
		return _logisticaValutazioneLocalService.getLogisticaValutaziones(start,
			end);
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
		return _logisticaValutazioneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _logisticaValutazioneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the logistica valutazione to the database. Also notifies the appropriate model listeners.
	*
	* @param logisticaValutazione the logistica valutazione
	* @return the logistica valutazione that was added
	*/
	@Override
	public service.intranet.mef.model.LogisticaValutazione addLogisticaValutazione(
		service.intranet.mef.model.LogisticaValutazione logisticaValutazione) {
		return _logisticaValutazioneLocalService.addLogisticaValutazione(logisticaValutazione);
	}

	/**
	* Creates a new logistica valutazione with the primary key. Does not add the logistica valutazione to the database.
	*
	* @param id the primary key for the new logistica valutazione
	* @return the new logistica valutazione
	*/
	@Override
	public service.intranet.mef.model.LogisticaValutazione createLogisticaValutazione(
		long id) {
		return _logisticaValutazioneLocalService.createLogisticaValutazione(id);
	}

	/**
	* Deletes the logistica valutazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione that was removed
	* @throws PortalException if a logistica valutazione with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.LogisticaValutazione deleteLogisticaValutazione(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaValutazioneLocalService.deleteLogisticaValutazione(id);
	}

	/**
	* Deletes the logistica valutazione from the database. Also notifies the appropriate model listeners.
	*
	* @param logisticaValutazione the logistica valutazione
	* @return the logistica valutazione that was removed
	*/
	@Override
	public service.intranet.mef.model.LogisticaValutazione deleteLogisticaValutazione(
		service.intranet.mef.model.LogisticaValutazione logisticaValutazione) {
		return _logisticaValutazioneLocalService.deleteLogisticaValutazione(logisticaValutazione);
	}

	@Override
	public service.intranet.mef.model.LogisticaValutazione fetchLogisticaValutazione(
		long id) {
		return _logisticaValutazioneLocalService.fetchLogisticaValutazione(id);
	}

	/**
	* Returns the logistica valutazione with the primary key.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione
	* @throws PortalException if a logistica valutazione with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.LogisticaValutazione getLogisticaValutazione(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _logisticaValutazioneLocalService.getLogisticaValutazione(id);
	}

	/**
	* Updates the logistica valutazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logisticaValutazione the logistica valutazione
	* @return the logistica valutazione that was updated
	*/
	@Override
	public service.intranet.mef.model.LogisticaValutazione updateLogisticaValutazione(
		service.intranet.mef.model.LogisticaValutazione logisticaValutazione) {
		return _logisticaValutazioneLocalService.updateLogisticaValutazione(logisticaValutazione);
	}

	@Override
	public LogisticaValutazioneLocalService getWrappedService() {
		return _logisticaValutazioneLocalService;
	}

	@Override
	public void setWrappedService(
		LogisticaValutazioneLocalService logisticaValutazioneLocalService) {
		_logisticaValutazioneLocalService = logisticaValutazioneLocalService;
	}

	private LogisticaValutazioneLocalService _logisticaValutazioneLocalService;
}