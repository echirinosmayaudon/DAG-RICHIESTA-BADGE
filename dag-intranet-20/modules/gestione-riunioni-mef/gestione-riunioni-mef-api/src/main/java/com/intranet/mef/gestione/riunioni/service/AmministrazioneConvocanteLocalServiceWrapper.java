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
 * Provides a wrapper for {@link AmministrazioneConvocanteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmministrazioneConvocanteLocalService
 * @generated
 */
@ProviderType
public class AmministrazioneConvocanteLocalServiceWrapper
	implements AmministrazioneConvocanteLocalService,
		ServiceWrapper<AmministrazioneConvocanteLocalService> {
	public AmministrazioneConvocanteLocalServiceWrapper(
		AmministrazioneConvocanteLocalService amministrazioneConvocanteLocalService) {
		_amministrazioneConvocanteLocalService = amministrazioneConvocanteLocalService;
	}

	@Override
	public boolean setAmministrazioneConvocante(
		java.lang.String nome_amministrazione) {
		return _amministrazioneConvocanteLocalService.setAmministrazioneConvocante(nome_amministrazione);
	}

	/**
	* Adds the amministrazione convocante to the database. Also notifies the appropriate model listeners.
	*
	* @param amministrazioneConvocante the amministrazione convocante
	* @return the amministrazione convocante that was added
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante addAmministrazioneConvocante(
		com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante amministrazioneConvocante) {
		return _amministrazioneConvocanteLocalService.addAmministrazioneConvocante(amministrazioneConvocante);
	}

	/**
	* Creates a new amministrazione convocante with the primary key. Does not add the amministrazione convocante to the database.
	*
	* @param id_amministrazione_convocante the primary key for the new amministrazione convocante
	* @return the new amministrazione convocante
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante createAmministrazioneConvocante(
		long id_amministrazione_convocante) {
		return _amministrazioneConvocanteLocalService.createAmministrazioneConvocante(id_amministrazione_convocante);
	}

	/**
	* Deletes the amministrazione convocante from the database. Also notifies the appropriate model listeners.
	*
	* @param amministrazioneConvocante the amministrazione convocante
	* @return the amministrazione convocante that was removed
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante deleteAmministrazioneConvocante(
		com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante amministrazioneConvocante) {
		return _amministrazioneConvocanteLocalService.deleteAmministrazioneConvocante(amministrazioneConvocante);
	}

	/**
	* Deletes the amministrazione convocante with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante that was removed
	* @throws PortalException if a amministrazione convocante with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante deleteAmministrazioneConvocante(
		long id_amministrazione_convocante)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amministrazioneConvocanteLocalService.deleteAmministrazioneConvocante(id_amministrazione_convocante);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante fetchAmministrazioneConvocante(
		long id_amministrazione_convocante) {
		return _amministrazioneConvocanteLocalService.fetchAmministrazioneConvocante(id_amministrazione_convocante);
	}

	/**
	* Returns the amministrazione convocante with the primary key.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante
	* @throws PortalException if a amministrazione convocante with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante getAmministrazioneConvocante(
		long id_amministrazione_convocante)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amministrazioneConvocanteLocalService.getAmministrazioneConvocante(id_amministrazione_convocante);
	}

	/**
	* Updates the amministrazione convocante in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param amministrazioneConvocante the amministrazione convocante
	* @return the amministrazione convocante that was updated
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante updateAmministrazioneConvocante(
		com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante amministrazioneConvocante) {
		return _amministrazioneConvocanteLocalService.updateAmministrazioneConvocante(amministrazioneConvocante);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _amministrazioneConvocanteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amministrazioneConvocanteLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _amministrazioneConvocanteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amministrazioneConvocanteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amministrazioneConvocanteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of amministrazione convocantes.
	*
	* @return the number of amministrazione convocantes
	*/
	@Override
	public int getAmministrazioneConvocantesCount() {
		return _amministrazioneConvocanteLocalService.getAmministrazioneConvocantesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amministrazioneConvocanteLocalService.getOSGiServiceIdentifier();
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
		return _amministrazioneConvocanteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _amministrazioneConvocanteLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _amministrazioneConvocanteLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante> findByKeywordAdmin(
		java.lang.String keyword) {
		return _amministrazioneConvocanteLocalService.findByKeywordAdmin(keyword);
	}

	/**
	* Returns a range of all the amministrazione convocantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amministrazione convocantes
	* @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	* @return the range of amministrazione convocantes
	*/
	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante> getAmministrazioneConvocantes(
		int start, int end) {
		return _amministrazioneConvocanteLocalService.getAmministrazioneConvocantes(start,
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
		return _amministrazioneConvocanteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _amministrazioneConvocanteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public AmministrazioneConvocanteLocalService getWrappedService() {
		return _amministrazioneConvocanteLocalService;
	}

	@Override
	public void setWrappedService(
		AmministrazioneConvocanteLocalService amministrazioneConvocanteLocalService) {
		_amministrazioneConvocanteLocalService = amministrazioneConvocanteLocalService;
	}

	private AmministrazioneConvocanteLocalService _amministrazioneConvocanteLocalService;
}