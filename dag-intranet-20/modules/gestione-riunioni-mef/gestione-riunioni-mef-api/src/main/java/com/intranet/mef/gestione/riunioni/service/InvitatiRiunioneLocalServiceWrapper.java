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
 * Provides a wrapper for {@link InvitatiRiunioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunioneLocalService
 * @generated
 */
@ProviderType
public class InvitatiRiunioneLocalServiceWrapper
	implements InvitatiRiunioneLocalService,
		ServiceWrapper<InvitatiRiunioneLocalService> {
	public InvitatiRiunioneLocalServiceWrapper(
		InvitatiRiunioneLocalService invitatiRiunioneLocalService) {
		_invitatiRiunioneLocalService = invitatiRiunioneLocalService;
	}

	/**
	* Adds the invitati riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunione the invitati riunione
	* @return the invitati riunione that was added
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione addInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.model.InvitatiRiunione invitatiRiunione) {
		return _invitatiRiunioneLocalService.addInvitatiRiunione(invitatiRiunione);
	}

	/**
	* Creates a new invitati riunione with the primary key. Does not add the invitati riunione to the database.
	*
	* @param invitatiRiunionePK the primary key for the new invitati riunione
	* @return the new invitati riunione
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione createInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK) {
		return _invitatiRiunioneLocalService.createInvitatiRiunione(invitatiRiunionePK);
	}

	/**
	* Deletes the invitati riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunione the invitati riunione
	* @return the invitati riunione that was removed
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione deleteInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.model.InvitatiRiunione invitatiRiunione) {
		return _invitatiRiunioneLocalService.deleteInvitatiRiunione(invitatiRiunione);
	}

	/**
	* Deletes the invitati riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione that was removed
	* @throws PortalException if a invitati riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione deleteInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _invitatiRiunioneLocalService.deleteInvitatiRiunione(invitatiRiunionePK);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione fetchInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK) {
		return _invitatiRiunioneLocalService.fetchInvitatiRiunione(invitatiRiunionePK);
	}

	/**
	* Returns the invitati riunione with the primary key.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione
	* @throws PortalException if a invitati riunione with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione getInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _invitatiRiunioneLocalService.getInvitatiRiunione(invitatiRiunionePK);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione getInvitatiRiunioneByPK(
		long id_segreteria, long id_riunione) {
		return _invitatiRiunioneLocalService.getInvitatiRiunioneByPK(id_segreteria,
			id_riunione);
	}

	/**
	* Updates the invitati riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunione the invitati riunione
	* @return the invitati riunione that was updated
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione updateInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.model.InvitatiRiunione invitatiRiunione) {
		return _invitatiRiunioneLocalService.updateInvitatiRiunione(invitatiRiunione);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _invitatiRiunioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invitatiRiunioneLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _invitatiRiunioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _invitatiRiunioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _invitatiRiunioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of invitati riuniones.
	*
	* @return the number of invitati riuniones
	*/
	@Override
	public int getInvitatiRiunionesCount() {
		return _invitatiRiunioneLocalService.getInvitatiRiunionesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _invitatiRiunioneLocalService.getOSGiServiceIdentifier();
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
		return _invitatiRiunioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitatiRiunioneLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitatiRiunioneLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiunioneByIdRiunione(
		long idRiunione) {
		return _invitatiRiunioneLocalService.getInvitatiRiunioneByIdRiunione(idRiunione);
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiunioneBySegreteria(
		long id_segreteria) {
		return _invitatiRiunioneLocalService.getInvitatiRiunioneBySegreteria(id_segreteria);
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiunioneBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones) {
		return _invitatiRiunioneLocalService.getInvitatiRiunioneBySegreteriaRiunione(id_segreteria,
			id_riuniones);
	}

	/**
	* Returns a range of all the invitati riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitati riuniones
	* @param end the upper bound of the range of invitati riuniones (not inclusive)
	* @return the range of invitati riuniones
	*/
	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiuniones(
		int start, int end) {
		return _invitatiRiunioneLocalService.getInvitatiRiuniones(start, end);
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
		return _invitatiRiunioneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _invitatiRiunioneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public InvitatiRiunioneLocalService getWrappedService() {
		return _invitatiRiunioneLocalService;
	}

	@Override
	public void setWrappedService(
		InvitatiRiunioneLocalService invitatiRiunioneLocalService) {
		_invitatiRiunioneLocalService = invitatiRiunioneLocalService;
	}

	private InvitatiRiunioneLocalService _invitatiRiunioneLocalService;
}