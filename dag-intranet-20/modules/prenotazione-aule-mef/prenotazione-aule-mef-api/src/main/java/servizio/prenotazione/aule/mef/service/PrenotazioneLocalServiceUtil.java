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

package servizio.prenotazione.aule.mef.service;

import aQute.bnd.annotation.ProviderType;
import servizio.prenotazione.aule.mef.model.Prenotazione;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Prenotazione. This utility wraps
 * {@link servizio.prenotazione.aule.mef.service.impl.PrenotazioneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneLocalService
 * @see servizio.prenotazione.aule.mef.service.base.PrenotazioneLocalServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.impl.PrenotazioneLocalServiceImpl
 * @generated
 */
@ProviderType
public class PrenotazioneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.prenotazione.aule.mef.service.impl.PrenotazioneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static Prenotazione insertPrenotazione() {
		return getService().insertPrenotazione();
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
	* Returns the number of prenotaziones.
	*
	* @return the number of prenotaziones
	*/
	public static int getPrenotazionesCount() {
		return getService().getPrenotazionesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the prenotaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of prenotaziones
	* @param end the upper bound of the range of prenotaziones (not inclusive)
	* @return the range of prenotaziones
	*/
	public static java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> getPrenotaziones(
		int start, int end) {
		return getService().getPrenotaziones(start, end);
	}

	public static java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> getPrenotazioniByCodFiscale(
		java.lang.String cod_fiscale) {
		return getService().getPrenotazioniByCodFiscale(cod_fiscale);
	}

	public static java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> getPrenotazioniByFilters(
		java.util.List<java.lang.Long> id_sale_list,
		java.util.Date data_inizio, java.util.Date data_fine, long id_stato) {
		return getService()
				   .getPrenotazioniByFilters(id_sale_list, data_inizio,
			data_fine, id_stato);
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
	* Adds the prenotazione to the database. Also notifies the appropriate model listeners.
	*
	* @param prenotazione the prenotazione
	* @return the prenotazione that was added
	*/
	public static servizio.prenotazione.aule.mef.model.Prenotazione addPrenotazione(
		servizio.prenotazione.aule.mef.model.Prenotazione prenotazione) {
		return getService().addPrenotazione(prenotazione);
	}

	/**
	* Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	*
	* @param id_prenota the primary key for the new prenotazione
	* @return the new prenotazione
	*/
	public static servizio.prenotazione.aule.mef.model.Prenotazione createPrenotazione(
		long id_prenota) {
		return getService().createPrenotazione(id_prenota);
	}

	/**
	* Deletes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione that was removed
	* @throws PortalException if a prenotazione with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.Prenotazione deletePrenotazione(
		long id_prenota)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePrenotazione(id_prenota);
	}

	/**
	* Deletes the prenotazione from the database. Also notifies the appropriate model listeners.
	*
	* @param prenotazione the prenotazione
	* @return the prenotazione that was removed
	*/
	public static servizio.prenotazione.aule.mef.model.Prenotazione deletePrenotazione(
		servizio.prenotazione.aule.mef.model.Prenotazione prenotazione) {
		return getService().deletePrenotazione(prenotazione);
	}

	public static servizio.prenotazione.aule.mef.model.Prenotazione fetchPrenotazione(
		long id_prenota) {
		return getService().fetchPrenotazione(id_prenota);
	}

	/**
	* Returns the prenotazione with the primary key.
	*
	* @param id_prenota the primary key of the prenotazione
	* @return the prenotazione
	* @throws PortalException if a prenotazione with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.Prenotazione getPrenotazione(
		long id_prenota)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPrenotazione(id_prenota);
	}

	/**
	* Updates the prenotazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param prenotazione the prenotazione
	* @return the prenotazione that was updated
	*/
	public static servizio.prenotazione.aule.mef.model.Prenotazione updatePrenotazione(
		servizio.prenotazione.aule.mef.model.Prenotazione prenotazione) {
		return getService().updatePrenotazione(prenotazione);
	}

	public static PrenotazioneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PrenotazioneLocalService, PrenotazioneLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PrenotazioneLocalService.class);
}