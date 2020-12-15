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
 * Provides the local service utility for TipoRiunione. This utility wraps
 * {@link com.intranet.mef.gestione.riunioni.service.impl.TipoRiunioneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipoRiunioneLocalService
 * @see com.intranet.mef.gestione.riunioni.service.base.TipoRiunioneLocalServiceBaseImpl
 * @see com.intranet.mef.gestione.riunioni.service.impl.TipoRiunioneLocalServiceImpl
 * @generated
 */
@ProviderType
public class TipoRiunioneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.gestione.riunioni.service.impl.TipoRiunioneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tipo riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param tipoRiunione the tipo riunione
	* @return the tipo riunione that was added
	*/
	public static com.intranet.mef.gestione.riunioni.model.TipoRiunione addTipoRiunione(
		com.intranet.mef.gestione.riunioni.model.TipoRiunione tipoRiunione) {
		return getService().addTipoRiunione(tipoRiunione);
	}

	/**
	* Creates a new tipo riunione with the primary key. Does not add the tipo riunione to the database.
	*
	* @param id_tipo the primary key for the new tipo riunione
	* @return the new tipo riunione
	*/
	public static com.intranet.mef.gestione.riunioni.model.TipoRiunione createTipoRiunione(
		long id_tipo) {
		return getService().createTipoRiunione(id_tipo);
	}

	/**
	* Deletes the tipo riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param tipoRiunione the tipo riunione
	* @return the tipo riunione that was removed
	*/
	public static com.intranet.mef.gestione.riunioni.model.TipoRiunione deleteTipoRiunione(
		com.intranet.mef.gestione.riunioni.model.TipoRiunione tipoRiunione) {
		return getService().deleteTipoRiunione(tipoRiunione);
	}

	/**
	* Deletes the tipo riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione that was removed
	* @throws PortalException if a tipo riunione with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.TipoRiunione deleteTipoRiunione(
		long id_tipo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTipoRiunione(id_tipo);
	}

	public static com.intranet.mef.gestione.riunioni.model.TipoRiunione fetchTipoRiunione(
		long id_tipo) {
		return getService().fetchTipoRiunione(id_tipo);
	}

	/**
	* Returns the tipo riunione with the primary key.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione
	* @throws PortalException if a tipo riunione with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.TipoRiunione getTipoRiunione(
		long id_tipo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTipoRiunione(id_tipo);
	}

	/**
	* Updates the tipo riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipoRiunione the tipo riunione
	* @return the tipo riunione that was updated
	*/
	public static com.intranet.mef.gestione.riunioni.model.TipoRiunione updateTipoRiunione(
		com.intranet.mef.gestione.riunioni.model.TipoRiunione tipoRiunione) {
		return getService().updateTipoRiunione(tipoRiunione);
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
	* Returns the number of tipo riuniones.
	*
	* @return the number of tipo riuniones
	*/
	public static int getTipoRiunionesCount() {
		return getService().getTipoRiunionesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List<com.intranet.mef.gestione.riunioni.model.TipoRiunione> getTipoRiuniones(
		int start, int end) {
		return getService().getTipoRiuniones(start, end);
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

	public static TipoRiunioneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipoRiunioneLocalService, TipoRiunioneLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TipoRiunioneLocalService.class);
}