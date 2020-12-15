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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for LogisticaRichieste. This utility wraps
 * {@link service.intranet.mef.service.impl.LogisticaRichiesteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichiesteLocalService
 * @see service.intranet.mef.service.base.LogisticaRichiesteLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.LogisticaRichiesteLocalServiceImpl
 * @generated
 */
@ProviderType
public class LogisticaRichiesteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.LogisticaRichiesteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of logistica richiestes.
	*
	* @return the number of logistica richiestes
	*/
	public static int getLogisticaRichiestesCount() {
		return getService().getLogisticaRichiestesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<service.intranet.mef.model.LogisticaRichieste> getListLogRichiesteByDip(
		java.lang.String dipartimento) {
		return getService().getListLogRichiesteByDip(dipartimento);
	}

	public static java.util.List<service.intranet.mef.model.LogisticaRichieste> getLogisticaRichiesteByUtente(
		java.lang.String utente) {
		return getService().getLogisticaRichiesteByUtente(utente);
	}

	/**
	* Returns a range of all the logistica richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @return the range of logistica richiestes
	*/
	public static java.util.List<service.intranet.mef.model.LogisticaRichieste> getLogisticaRichiestes(
		int start, int end) {
		return getService().getLogisticaRichiestes(start, end);
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
	* Adds the logistica richieste to the database. Also notifies the appropriate model listeners.
	*
	* @param logisticaRichieste the logistica richieste
	* @return the logistica richieste that was added
	*/
	public static service.intranet.mef.model.LogisticaRichieste addLogisticaRichieste(
		service.intranet.mef.model.LogisticaRichieste logisticaRichieste) {
		return getService().addLogisticaRichieste(logisticaRichieste);
	}

	/**
	* Creates a new logistica richieste with the primary key. Does not add the logistica richieste to the database.
	*
	* @param id the primary key for the new logistica richieste
	* @return the new logistica richieste
	*/
	public static service.intranet.mef.model.LogisticaRichieste createLogisticaRichieste(
		long id) {
		return getService().createLogisticaRichieste(id);
	}

	/**
	* Deletes the logistica richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste that was removed
	* @throws PortalException if a logistica richieste with the primary key could not be found
	*/
	public static service.intranet.mef.model.LogisticaRichieste deleteLogisticaRichieste(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLogisticaRichieste(id);
	}

	/**
	* Deletes the logistica richieste from the database. Also notifies the appropriate model listeners.
	*
	* @param logisticaRichieste the logistica richieste
	* @return the logistica richieste that was removed
	*/
	public static service.intranet.mef.model.LogisticaRichieste deleteLogisticaRichieste(
		service.intranet.mef.model.LogisticaRichieste logisticaRichieste) {
		return getService().deleteLogisticaRichieste(logisticaRichieste);
	}

	public static service.intranet.mef.model.LogisticaRichieste fetchLogisticaRichieste(
		long id) {
		return getService().fetchLogisticaRichieste(id);
	}

	/**
	* Returns the logistica richieste with the primary key.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste
	* @throws PortalException if a logistica richieste with the primary key could not be found
	*/
	public static service.intranet.mef.model.LogisticaRichieste getLogisticaRichieste(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLogisticaRichieste(id);
	}

	public static service.intranet.mef.model.LogisticaRichieste insertRichiestaLogistici(
		java.lang.String oggetto, java.lang.String utente,
		java.lang.String dipartimento, java.util.Date data_richiesta,
		java.lang.String dettaglio_richiedente,
		java.lang.String dettaglio_richieste, java.lang.String note_gestore,
		long id_valutazione, long id_stato, java.lang.String note) {
		return getService()
				   .insertRichiestaLogistici(oggetto, utente, dipartimento,
			data_richiesta, dettaglio_richiedente, dettaglio_richieste,
			note_gestore, id_valutazione, id_stato, note);
	}

	/**
	* Updates the logistica richieste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logisticaRichieste the logistica richieste
	* @return the logistica richieste that was updated
	*/
	public static service.intranet.mef.model.LogisticaRichieste updateLogisticaRichieste(
		service.intranet.mef.model.LogisticaRichieste logisticaRichieste) {
		return getService().updateLogisticaRichieste(logisticaRichieste);
	}

	public static LogisticaRichiesteLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LogisticaRichiesteLocalService, LogisticaRichiesteLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LogisticaRichiesteLocalService.class);
}