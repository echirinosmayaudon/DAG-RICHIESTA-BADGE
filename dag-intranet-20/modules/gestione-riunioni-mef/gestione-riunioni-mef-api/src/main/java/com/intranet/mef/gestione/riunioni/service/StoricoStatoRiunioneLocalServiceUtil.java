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
 * Provides the local service utility for StoricoStatoRiunione. This utility wraps
 * {@link com.intranet.mef.gestione.riunioni.service.impl.StoricoStatoRiunioneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunioneLocalService
 * @see com.intranet.mef.gestione.riunioni.service.base.StoricoStatoRiunioneLocalServiceBaseImpl
 * @see com.intranet.mef.gestione.riunioni.service.impl.StoricoStatoRiunioneLocalServiceImpl
 * @generated
 */
@ProviderType
public class StoricoStatoRiunioneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.gestione.riunioni.service.impl.StoricoStatoRiunioneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the storico stato riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunione the storico stato riunione
	* @return the storico stato riunione that was added
	*/
	public static com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione addStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione storicoStatoRiunione) {
		return getService().addStoricoStatoRiunione(storicoStatoRiunione);
	}

	/**
	* Creates a new storico stato riunione with the primary key. Does not add the storico stato riunione to the database.
	*
	* @param storicoStatoRiunionePK the primary key for the new storico stato riunione
	* @return the new storico stato riunione
	*/
	public static com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione createStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK) {
		return getService().createStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	/**
	* Deletes the storico stato riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunione the storico stato riunione
	* @return the storico stato riunione that was removed
	*/
	public static com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione deleteStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione storicoStatoRiunione) {
		return getService().deleteStoricoStatoRiunione(storicoStatoRiunione);
	}

	/**
	* Deletes the storico stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione that was removed
	* @throws PortalException if a storico stato riunione with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione deleteStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	public static com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione fetchStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK) {
		return getService().fetchStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	/**
	* Returns the storico stato riunione with the primary key.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione
	* @throws PortalException if a storico stato riunione with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione getStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStoricoStatoRiunione(storicoStatoRiunionePK);
	}

	/**
	* Updates the storico stato riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunione the storico stato riunione
	* @return the storico stato riunione that was updated
	*/
	public static com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione updateStoricoStatoRiunione(
		com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione storicoStatoRiunione) {
		return getService().updateStoricoStatoRiunione(storicoStatoRiunione);
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
	* Returns the number of storico stato riuniones.
	*
	* @return the number of storico stato riuniones
	*/
	public static int getStoricoStatoRiunionesCount() {
		return getService().getStoricoStatoRiunionesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione> getStoricoStatoRiunioneByIdRiunione(
		long idRiunione) {
		return getService().getStoricoStatoRiunioneByIdRiunione(idRiunione);
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
	public static java.util.List<com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione> getStoricoStatoRiuniones(
		int start, int end) {
		return getService().getStoricoStatoRiuniones(start, end);
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

	public static StoricoStatoRiunioneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StoricoStatoRiunioneLocalService, StoricoStatoRiunioneLocalService> _serviceTracker =
		ServiceTrackerFactory.open(StoricoStatoRiunioneLocalService.class);
}