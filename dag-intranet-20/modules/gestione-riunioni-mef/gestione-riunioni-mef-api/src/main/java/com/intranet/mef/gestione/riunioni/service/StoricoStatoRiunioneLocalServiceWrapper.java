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
 * Provides a wrapper for {@link StoricoStatoRiunioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunioneLocalService
 * @generated
 */
@ProviderType
public class StoricoStatoRiunioneLocalServiceWrapper
	implements StoricoStatoRiunioneLocalService,
		ServiceWrapper<StoricoStatoRiunioneLocalService> {
	public StoricoStatoRiunioneLocalServiceWrapper(
		StoricoStatoRiunioneLocalService storicoStatoRiunioneLocalService) {
		_storicoStatoRiunioneLocalService = storicoStatoRiunioneLocalService;
	}

	/**
	* Adds the storico stato riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunione the storico stato riunione
	* @return the storico stato riunione that was added
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione addStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione storicoStatoRiunione) {
		return _storicoStatoRiunioneLocalService.addStoricoStatoRiunione(storicoStatoRiunione);
	}

	/**
	* Creates a new storico stato riunione with the primary key. Does not add the storico stato riunione to the database.
	*
	* @param storicoStatoRiunionePK the primary key for the new storico stato riunione
	* @return the new storico stato riunione
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione createStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK) {
		return _storicoStatoRiunioneLocalService.createStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	/**
	* Deletes the storico stato riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunione the storico stato riunione
	* @return the storico stato riunione that was removed
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione deleteStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione storicoStatoRiunione) {
		return _storicoStatoRiunioneLocalService.deleteStoricoStatoRiunione(storicoStatoRiunione);
	}

	/**
	* Deletes the storico stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione that was removed
	* @throws PortalException if a storico stato riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione deleteStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _storicoStatoRiunioneLocalService.deleteStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione fetchStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK) {
		return _storicoStatoRiunioneLocalService.fetchStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	/**
	* Returns the storico stato riunione with the primary key.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione
	* @throws PortalException if a storico stato riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione getStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _storicoStatoRiunioneLocalService.getStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	/**
	* Updates the storico stato riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunione the storico stato riunione
	* @return the storico stato riunione that was updated
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione updateStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione storicoStatoRiunione) {
		return _storicoStatoRiunioneLocalService.updateStoricoStatoRiunione(storicoStatoRiunione);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _storicoStatoRiunioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _storicoStatoRiunioneLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _storicoStatoRiunioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _storicoStatoRiunioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _storicoStatoRiunioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of storico stato riuniones.
	*
	* @return the number of storico stato riuniones
	*/
	@Override
	public int getStoricoStatoRiunionesCount() {
		return _storicoStatoRiunioneLocalService.getStoricoStatoRiunionesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _storicoStatoRiunioneLocalService.getOSGiServiceIdentifier();
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
		return _storicoStatoRiunioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storicoStatoRiunioneLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storicoStatoRiunioneLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione> getStoricoStatoRiunioneByIdRiunione(
		long idRiunione) {
		return _storicoStatoRiunioneLocalService.getStoricoStatoRiunioneByIdRiunione(idRiunione);
	}

	/**
	* Returns a range of all the storico stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @return the range of storico stato riuniones
	*/
	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione> getStoricoStatoRiuniones(
		int start, int end) {
		return _storicoStatoRiunioneLocalService.getStoricoStatoRiuniones(start,
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
		return _storicoStatoRiunioneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _storicoStatoRiunioneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public StoricoStatoRiunioneLocalService getWrappedService() {
		return _storicoStatoRiunioneLocalService;
	}

	@Override
	public void setWrappedService(
		StoricoStatoRiunioneLocalService storicoStatoRiunioneLocalService) {
		_storicoStatoRiunioneLocalService = storicoStatoRiunioneLocalService;
	}

	private StoricoStatoRiunioneLocalService _storicoStatoRiunioneLocalService;
}