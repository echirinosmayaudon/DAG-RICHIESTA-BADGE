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

package servizio.prenotazione.aule.servizi.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StrumEvento. This utility wraps
 * {@link servizio.prenotazione.aule.servizi.mef.service.impl.StrumEventoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StrumEventoLocalService
 * @see servizio.prenotazione.aule.servizi.mef.service.base.StrumEventoLocalServiceBaseImpl
 * @see servizio.prenotazione.aule.servizi.mef.service.impl.StrumEventoLocalServiceImpl
 * @generated
 */
@ProviderType
public class StrumEventoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.prenotazione.aule.servizi.mef.service.impl.StrumEventoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of strum eventos.
	*
	* @return the number of strum eventos
	*/
	public static int getStrumEventosCount() {
		return getService().getStrumEventosCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the strum eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum eventos
	* @param end the upper bound of the range of strum eventos (not inclusive)
	* @return the range of strum eventos
	*/
	public static java.util.List<servizio.prenotazione.aule.servizi.mef.model.StrumEvento> getStrumEventos(
		int start, int end) {
		return getService().getStrumEventos(start, end);
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
	* Adds the strum evento to the database. Also notifies the appropriate model listeners.
	*
	* @param strumEvento the strum evento
	* @return the strum evento that was added
	*/
	public static servizio.prenotazione.aule.servizi.mef.model.StrumEvento addStrumEvento(
		servizio.prenotazione.aule.servizi.mef.model.StrumEvento strumEvento) {
		return getService().addStrumEvento(strumEvento);
	}

	/**
	* Creates a new strum evento with the primary key. Does not add the strum evento to the database.
	*
	* @param strumEventoPK the primary key for the new strum evento
	* @return the new strum evento
	*/
	public static servizio.prenotazione.aule.servizi.mef.model.StrumEvento createStrumEvento(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK) {
		return getService().createStrumEvento(strumEventoPK);
	}

	/**
	* Deletes the strum evento from the database. Also notifies the appropriate model listeners.
	*
	* @param strumEvento the strum evento
	* @return the strum evento that was removed
	*/
	public static servizio.prenotazione.aule.servizi.mef.model.StrumEvento deleteStrumEvento(
		servizio.prenotazione.aule.servizi.mef.model.StrumEvento strumEvento) {
		return getService().deleteStrumEvento(strumEvento);
	}

	/**
	* Deletes the strum evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento that was removed
	* @throws PortalException if a strum evento with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.servizi.mef.model.StrumEvento deleteStrumEvento(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStrumEvento(strumEventoPK);
	}

	public static servizio.prenotazione.aule.servizi.mef.model.StrumEvento fetchStrumEvento(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK) {
		return getService().fetchStrumEvento(strumEventoPK);
	}

	/**
	* Returns the strum evento with the primary key.
	*
	* @param strumEventoPK the primary key of the strum evento
	* @return the strum evento
	* @throws PortalException if a strum evento with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.servizi.mef.model.StrumEvento getStrumEvento(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK strumEventoPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStrumEvento(strumEventoPK);
	}

	/**
	* Updates the strum evento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param strumEvento the strum evento
	* @return the strum evento that was updated
	*/
	public static servizio.prenotazione.aule.servizi.mef.model.StrumEvento updateStrumEvento(
		servizio.prenotazione.aule.servizi.mef.model.StrumEvento strumEvento) {
		return getService().updateStrumEvento(strumEvento);
	}

	public static StrumEventoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StrumEventoLocalService, StrumEventoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(StrumEventoLocalService.class);
}