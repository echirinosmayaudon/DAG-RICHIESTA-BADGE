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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for InvitatiRiunione. This utility wraps
 * {@link com.intranet.mef.gestione.riunioni.service.impl.InvitatiRiunioneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunioneLocalService
 * @see com.intranet.mef.gestione.riunioni.service.base.InvitatiRiunioneLocalServiceBaseImpl
 * @see com.intranet.mef.gestione.riunioni.service.impl.InvitatiRiunioneLocalServiceImpl
 * @generated
 */
@ProviderType
public class InvitatiRiunioneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.gestione.riunioni.service.impl.InvitatiRiunioneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the invitati riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunione the invitati riunione
	* @return the invitati riunione that was added
	*/
	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione addInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.model.InvitatiRiunione invitatiRiunione) {
		return getService().addInvitatiRiunione(invitatiRiunione);
	}

	/**
	* Creates a new invitati riunione with the primary key. Does not add the invitati riunione to the database.
	*
	* @param invitatiRiunionePK the primary key for the new invitati riunione
	* @return the new invitati riunione
	*/
	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione createInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK) {
		return getService().createInvitatiRiunione(invitatiRiunionePK);
	}

	/**
	* Deletes the invitati riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunione the invitati riunione
	* @return the invitati riunione that was removed
	*/
	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione deleteInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.model.InvitatiRiunione invitatiRiunione) {
		return getService().deleteInvitatiRiunione(invitatiRiunione);
	}

	/**
	* Deletes the invitati riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione that was removed
	* @throws PortalException if a invitati riunione with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione deleteInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteInvitatiRiunione(invitatiRiunionePK);
	}

	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione fetchInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK) {
		return getService().fetchInvitatiRiunione(invitatiRiunionePK);
	}

	/**
	* Returns the invitati riunione with the primary key.
	*
	* @param invitatiRiunionePK the primary key of the invitati riunione
	* @return the invitati riunione
	* @throws PortalException if a invitati riunione with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione getInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK invitatiRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getInvitatiRiunione(invitatiRiunionePK);
	}

	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione getInvitatiRiunioneByPK(
		long id_segreteria, long id_riunione) {
		return getService().getInvitatiRiunioneByPK(id_segreteria, id_riunione);
	}

	/**
	* Updates the invitati riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invitatiRiunione the invitati riunione
	* @return the invitati riunione that was updated
	*/
	public static com.intranet.mef.gestione.riunioni.model.InvitatiRiunione updateInvitatiRiunione(
		com.intranet.mef.gestione.riunioni.model.InvitatiRiunione invitatiRiunione) {
		return getService().updateInvitatiRiunione(invitatiRiunione);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of invitati riuniones.
	*
	* @return the number of invitati riuniones
	*/
	public static int getInvitatiRiunionesCount() {
		return getService().getInvitatiRiunionesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiunioneByIdRiunione(
		long idRiunione) {
		return getService().getInvitatiRiunioneByIdRiunione(idRiunione);
	}

	public static java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiunioneBySegreteria(
		long id_segreteria) {
		return getService().getInvitatiRiunioneBySegreteria(id_segreteria);
	}

	public static java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiunioneBySegreteriaRiunione(
		long id_segreteria, long[] id_riuniones) {
		return getService()
				   .getInvitatiRiunioneBySegreteriaRiunione(id_segreteria,
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
	public static java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiuniones(
		int start, int end) {
		return getService().getInvitatiRiuniones(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static InvitatiRiunioneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InvitatiRiunioneLocalService, InvitatiRiunioneLocalService> _serviceTracker =
		ServiceTrackerFactory.open(InvitatiRiunioneLocalService.class);
}