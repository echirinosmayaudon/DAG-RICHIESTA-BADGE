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

package com.intranet.mef.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipoRiunioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipoRiunioneLocalService
 * @generated
 */
@ProviderType
public class TipoRiunioneLocalServiceWrapper implements TipoRiunioneLocalService,
	ServiceWrapper<TipoRiunioneLocalService> {
	public TipoRiunioneLocalServiceWrapper(
		TipoRiunioneLocalService tipoRiunioneLocalService) {
		_tipoRiunioneLocalService = tipoRiunioneLocalService;
	}

	/**
	* Adds the tipo riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param tipoRiunione the tipo riunione
	* @return the tipo riunione that was added
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.TipoRiunione addTipoRiunione(
		com.intranet.mef.gestione.riunioni.model.TipoRiunione tipoRiunione) {
		return _tipoRiunioneLocalService.addTipoRiunione(tipoRiunione);
	}

	/**
	* Creates a new tipo riunione with the primary key. Does not add the tipo riunione to the database.
	*
	* @param id_tipo the primary key for the new tipo riunione
	* @return the new tipo riunione
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.TipoRiunione createTipoRiunione(
		long id_tipo) {
		return _tipoRiunioneLocalService.createTipoRiunione(id_tipo);
	}

	/**
	* Deletes the tipo riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param tipoRiunione the tipo riunione
	* @return the tipo riunione that was removed
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.TipoRiunione deleteTipoRiunione(
		com.intranet.mef.gestione.riunioni.model.TipoRiunione tipoRiunione) {
		return _tipoRiunioneLocalService.deleteTipoRiunione(tipoRiunione);
	}

	/**
	* Deletes the tipo riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione that was removed
	* @throws PortalException if a tipo riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.TipoRiunione deleteTipoRiunione(
		long id_tipo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoRiunioneLocalService.deleteTipoRiunione(id_tipo);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.TipoRiunione fetchTipoRiunione(
		long id_tipo) {
		return _tipoRiunioneLocalService.fetchTipoRiunione(id_tipo);
	}

	/**
	* Returns the tipo riunione with the primary key.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione
	* @throws PortalException if a tipo riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.TipoRiunione getTipoRiunione(
		long id_tipo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoRiunioneLocalService.getTipoRiunione(id_tipo);
	}

	/**
	* Updates the tipo riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipoRiunione the tipo riunione
	* @return the tipo riunione that was updated
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.TipoRiunione updateTipoRiunione(
		com.intranet.mef.gestione.riunioni.model.TipoRiunione tipoRiunione) {
		return _tipoRiunioneLocalService.updateTipoRiunione(tipoRiunione);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tipoRiunioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipoRiunioneLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tipoRiunioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoRiunioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoRiunioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of tipo riuniones.
	*
	* @return the number of tipo riuniones
	*/
	@Override
	public int getTipoRiunionesCount() {
		return _tipoRiunioneLocalService.getTipoRiunionesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipoRiunioneLocalService.getOSGiServiceIdentifier();
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
		return _tipoRiunioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipoRiunioneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipoRiunioneLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the tipo riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo riuniones
	* @param end the upper bound of the range of tipo riuniones (not inclusive)
	* @return the range of tipo riuniones
	*/
	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.TipoRiunione> getTipoRiuniones(
		int start, int end) {
		return _tipoRiunioneLocalService.getTipoRiuniones(start, end);
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
		return _tipoRiunioneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tipoRiunioneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public TipoRiunioneLocalService getWrappedService() {
		return _tipoRiunioneLocalService;
	}

	@Override
	public void setWrappedService(
		TipoRiunioneLocalService tipoRiunioneLocalService) {
		_tipoRiunioneLocalService = tipoRiunioneLocalService;
	}

	private TipoRiunioneLocalService _tipoRiunioneLocalService;
}