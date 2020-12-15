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
 * Provides a wrapper for {@link RiunioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RiunioneLocalService
 * @generated
 */
@ProviderType
public class RiunioneLocalServiceWrapper implements RiunioneLocalService,
	ServiceWrapper<RiunioneLocalService> {
	public RiunioneLocalServiceWrapper(
		RiunioneLocalService riunioneLocalService) {
		_riunioneLocalService = riunioneLocalService;
	}

	@Override
	public boolean modifyStatoRiunione(long id_riunione,
		java.util.Date data_modifica, long id_stato_riunione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.modifyStatoRiunione(id_riunione,
			data_modifica, id_stato_riunione);
	}

	@Override
	public boolean updateDataSollecitoRiunione(long riunioneId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.updateDataSollecitoRiunione(riunioneId);
	}

	@Override
	public boolean updateSpostaRiunione(long riunioneId,
		java.util.Date data_inizio, long id_luogo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.updateSpostaRiunione(riunioneId,
			data_inizio, id_luogo);
	}

	/**
	* Adds the riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param riunione the riunione
	* @return the riunione that was added
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Riunione addRiunione(
		com.intranet.mef.gestione.riunioni.model.Riunione riunione) {
		return _riunioneLocalService.addRiunione(riunione);
	}

	/**
	* Creates a new riunione with the primary key. Does not add the riunione to the database.
	*
	* @param id_riunione the primary key for the new riunione
	* @return the new riunione
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Riunione createRiunione(
		long id_riunione) {
		return _riunioneLocalService.createRiunione(id_riunione);
	}

	/**
	* Deletes the riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param riunione the riunione
	* @return the riunione that was removed
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Riunione deleteRiunione(
		com.intranet.mef.gestione.riunioni.model.Riunione riunione) {
		return _riunioneLocalService.deleteRiunione(riunione);
	}

	/**
	* Deletes the riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione that was removed
	* @throws PortalException if a riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Riunione deleteRiunione(
		long id_riunione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.deleteRiunione(id_riunione);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.Riunione fetchRiunione(
		long id_riunione) {
		return _riunioneLocalService.fetchRiunione(id_riunione);
	}

	/**
	* Returns the riunione with the primary key.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione
	* @throws PortalException if a riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Riunione getRiunione(
		long id_riunione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.getRiunione(id_riunione);
	}

	/**
	* Updates the riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param riunione the riunione
	* @return the riunione that was updated
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Riunione updateRiunione(
		com.intranet.mef.gestione.riunioni.model.Riunione riunione) {
		return _riunioneLocalService.updateRiunione(riunione);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _riunioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _riunioneLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _riunioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of riuniones.
	*
	* @return the number of riuniones
	*/
	@Override
	public int getRiunionesCount() {
		return _riunioneLocalService.getRiunionesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _riunioneLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String updateDatiRiunione(long riunioneId,
		java.lang.String oggetto, java.lang.String protocollo,
		long id_amministrazione_convocante, java.lang.String note, long id_tipo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _riunioneLocalService.updateDatiRiunione(riunioneId, oggetto,
			protocollo, id_amministrazione_convocante, note, id_tipo);
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
		return _riunioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _riunioneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _riunioneLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.Riunione> findByFilters(
		java.util.Date da, java.util.Date a, long stato, java.lang.String ogg,
		long isp, java.lang.String prot, long am, long type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _riunioneLocalService.findByFilters(da, a, stato, ogg, isp,
			prot, am, type);
	}

	/**
	* Returns a range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @return the range of riuniones
	*/
	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.Riunione> getRiuniones(
		int start, int end) {
		return _riunioneLocalService.getRiuniones(start, end);
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
		return _riunioneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _riunioneLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public long setRiunione(java.lang.String oggetto,
		java.util.Date data_inizio, java.util.Date data_fine,
		java.lang.String note, java.util.Date data_modifica,
		java.util.Date data_creazione, java.lang.String protocollo,
		long id_stato_riunione, long id_tipo, long id_luogo,
		long id_amministrazione_convocante, long[] id_segreteria) {
		return _riunioneLocalService.setRiunione(oggetto, data_inizio,
			data_fine, note, data_modifica, data_creazione, protocollo,
			id_stato_riunione, id_tipo, id_luogo,
			id_amministrazione_convocante, id_segreteria);
	}

	@Override
	public RiunioneLocalService getWrappedService() {
		return _riunioneLocalService;
	}

	@Override
	public void setWrappedService(RiunioneLocalService riunioneLocalService) {
		_riunioneLocalService = riunioneLocalService;
	}

	private RiunioneLocalService _riunioneLocalService;
}