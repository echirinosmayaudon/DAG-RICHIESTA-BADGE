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

package servizio.richieste.badge.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SediEsterne. This utility wraps
 * {@link servizio.richieste.badge.mef.service.impl.SediEsterneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SediEsterneLocalService
 * @see servizio.richieste.badge.mef.service.base.SediEsterneLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.impl.SediEsterneLocalServiceImpl
 * @generated
 */
@ProviderType
public class SediEsterneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.richieste.badge.mef.service.impl.SediEsterneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
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
	* Returns the number of sedi esternes.
	*
	* @return the number of sedi esternes
	*/
	public static int getSediEsternesCount() {
		return getService().getSediEsternesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<servizio.richieste.badge.mef.model.SediEsterne> getSediEsterneByAcronimoSede(
		java.lang.String acronimo_sede) {
		return getService().getSediEsterneByAcronimoSede(acronimo_sede);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.SediEsterne> getSediEsterneByIdSiap(
		long id_sedesiap) {
		return getService().getSediEsterneByIdSiap(id_sedesiap);
	}

	/**
	* Returns a range of all the sedi esternes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @return the range of sedi esternes
	*/
	public static java.util.List<servizio.richieste.badge.mef.model.SediEsterne> getSediEsternes(
		int start, int end) {
		return getService().getSediEsternes(start, end);
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

	/**
	* Adds the sedi esterne to the database. Also notifies the appropriate model listeners.
	*
	* @param sediEsterne the sedi esterne
	* @return the sedi esterne that was added
	*/
	public static servizio.richieste.badge.mef.model.SediEsterne addSediEsterne(
		servizio.richieste.badge.mef.model.SediEsterne sediEsterne) {
		return getService().addSediEsterne(sediEsterne);
	}

	/**
	* Creates a new sedi esterne with the primary key. Does not add the sedi esterne to the database.
	*
	* @param id_sede_esterna the primary key for the new sedi esterne
	* @return the new sedi esterne
	*/
	public static servizio.richieste.badge.mef.model.SediEsterne createSediEsterne(
		long id_sede_esterna) {
		return getService().createSediEsterne(id_sede_esterna);
	}

	/**
	* Deletes the sedi esterne with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne that was removed
	* @throws PortalException if a sedi esterne with the primary key could not be found
	*/
	public static servizio.richieste.badge.mef.model.SediEsterne deleteSediEsterne(
		long id_sede_esterna)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSediEsterne(id_sede_esterna);
	}

	/**
	* Deletes the sedi esterne from the database. Also notifies the appropriate model listeners.
	*
	* @param sediEsterne the sedi esterne
	* @return the sedi esterne that was removed
	*/
	public static servizio.richieste.badge.mef.model.SediEsterne deleteSediEsterne(
		servizio.richieste.badge.mef.model.SediEsterne sediEsterne) {
		return getService().deleteSediEsterne(sediEsterne);
	}

	public static servizio.richieste.badge.mef.model.SediEsterne fetchSediEsterne(
		long id_sede_esterna) {
		return getService().fetchSediEsterne(id_sede_esterna);
	}

	/**
	* Returns the sedi esterne with the primary key.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne
	* @throws PortalException if a sedi esterne with the primary key could not be found
	*/
	public static servizio.richieste.badge.mef.model.SediEsterne getSediEsterne(
		long id_sede_esterna)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSediEsterne(id_sede_esterna);
	}

	/**
	* Updates the sedi esterne in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sediEsterne the sedi esterne
	* @return the sedi esterne that was updated
	*/
	public static servizio.richieste.badge.mef.model.SediEsterne updateSediEsterne(
		servizio.richieste.badge.mef.model.SediEsterne sediEsterne) {
		return getService().updateSediEsterne(sediEsterne);
	}

	public static SediEsterneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SediEsterneLocalService, SediEsterneLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SediEsterneLocalService.class);
}