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
 * Provides the local service utility for StatoInvitato. This utility wraps
 * {@link com.intranet.mef.gestione.riunioni.service.impl.StatoInvitatoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StatoInvitatoLocalService
 * @see com.intranet.mef.gestione.riunioni.service.base.StatoInvitatoLocalServiceBaseImpl
 * @see com.intranet.mef.gestione.riunioni.service.impl.StatoInvitatoLocalServiceImpl
 * @generated
 */
@ProviderType
public class StatoInvitatoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.gestione.riunioni.service.impl.StatoInvitatoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the stato invitato to the database. Also notifies the appropriate model listeners.
	*
	* @param statoInvitato the stato invitato
	* @return the stato invitato that was added
	*/
	public static com.intranet.mef.gestione.riunioni.model.StatoInvitato addStatoInvitato(
		com.intranet.mef.gestione.riunioni.model.StatoInvitato statoInvitato) {
		return getService().addStatoInvitato(statoInvitato);
	}

	/**
	* Creates a new stato invitato with the primary key. Does not add the stato invitato to the database.
	*
	* @param id_stato_invitato the primary key for the new stato invitato
	* @return the new stato invitato
	*/
	public static com.intranet.mef.gestione.riunioni.model.StatoInvitato createStatoInvitato(
		long id_stato_invitato) {
		return getService().createStatoInvitato(id_stato_invitato);
	}

	/**
	* Deletes the stato invitato from the database. Also notifies the appropriate model listeners.
	*
	* @param statoInvitato the stato invitato
	* @return the stato invitato that was removed
	*/
	public static com.intranet.mef.gestione.riunioni.model.StatoInvitato deleteStatoInvitato(
		com.intranet.mef.gestione.riunioni.model.StatoInvitato statoInvitato) {
		return getService().deleteStatoInvitato(statoInvitato);
	}

	/**
	* Deletes the stato invitato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato that was removed
	* @throws PortalException if a stato invitato with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.StatoInvitato deleteStatoInvitato(
		long id_stato_invitato)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStatoInvitato(id_stato_invitato);
	}

	public static com.intranet.mef.gestione.riunioni.model.StatoInvitato fetchStatoInvitato(
		long id_stato_invitato) {
		return getService().fetchStatoInvitato(id_stato_invitato);
	}

	/**
	* Returns the stato invitato with the primary key.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato
	* @throws PortalException if a stato invitato with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.StatoInvitato getStatoInvitato(
		long id_stato_invitato)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStatoInvitato(id_stato_invitato);
	}

	/**
	* Updates the stato invitato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statoInvitato the stato invitato
	* @return the stato invitato that was updated
	*/
	public static com.intranet.mef.gestione.riunioni.model.StatoInvitato updateStatoInvitato(
		com.intranet.mef.gestione.riunioni.model.StatoInvitato statoInvitato) {
		return getService().updateStatoInvitato(statoInvitato);
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
	* Returns the number of stato invitatos.
	*
	* @return the number of stato invitatos
	*/
	public static int getStatoInvitatosCount() {
		return getService().getStatoInvitatosCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the stato invitatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato invitatos
	* @param end the upper bound of the range of stato invitatos (not inclusive)
	* @return the range of stato invitatos
	*/
	public static java.util.List<com.intranet.mef.gestione.riunioni.model.StatoInvitato> getStatoInvitatos(
		int start, int end) {
		return getService().getStatoInvitatos(start, end);
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

	public static StatoInvitatoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatoInvitatoLocalService, StatoInvitatoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(StatoInvitatoLocalService.class);
}