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

package servizio.whistleblowing.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Segnalazione. This utility wraps
 * {@link servizio.whistleblowing.mef.service.impl.SegnalazioneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneLocalService
 * @see servizio.whistleblowing.mef.service.base.SegnalazioneLocalServiceBaseImpl
 * @see servizio.whistleblowing.mef.service.impl.SegnalazioneLocalServiceImpl
 * @generated
 */
@ProviderType
public class SegnalazioneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.whistleblowing.mef.service.impl.SegnalazioneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean insertSegnalazione(
		java.lang.String json_dati_personali, java.lang.String luogo,
		java.lang.String azioni_omissioni, java.lang.String descrizione,
		java.lang.String autore, java.lang.String altri_testimoni) {
		return getService()
				   .insertSegnalazione(json_dati_personali, luogo,
			azioni_omissioni, descrizione, autore, altri_testimoni);
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
	* Returns the number of segnalaziones.
	*
	* @return the number of segnalaziones
	*/
	public static int getSegnalazionesCount() {
		return getService().getSegnalazionesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.whistleblowing.mef.model.impl.SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.whistleblowing.mef.model.impl.SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the segnalaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.whistleblowing.mef.model.impl.SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segnalaziones
	* @param end the upper bound of the range of segnalaziones (not inclusive)
	* @return the range of segnalaziones
	*/
	public static java.util.List<servizio.whistleblowing.mef.model.Segnalazione> getSegnalaziones(
		int start, int end) {
		return getService().getSegnalaziones(start, end);
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
	* Adds the segnalazione to the database. Also notifies the appropriate model listeners.
	*
	* @param segnalazione the segnalazione
	* @return the segnalazione that was added
	*/
	public static servizio.whistleblowing.mef.model.Segnalazione addSegnalazione(
		servizio.whistleblowing.mef.model.Segnalazione segnalazione) {
		return getService().addSegnalazione(segnalazione);
	}

	/**
	* Creates a new segnalazione with the primary key. Does not add the segnalazione to the database.
	*
	* @param id_segnalazione the primary key for the new segnalazione
	* @return the new segnalazione
	*/
	public static servizio.whistleblowing.mef.model.Segnalazione createSegnalazione(
		long id_segnalazione) {
		return getService().createSegnalazione(id_segnalazione);
	}

	/**
	* Deletes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_segnalazione the primary key of the segnalazione
	* @return the segnalazione that was removed
	* @throws PortalException if a segnalazione with the primary key could not be found
	*/
	public static servizio.whistleblowing.mef.model.Segnalazione deleteSegnalazione(
		long id_segnalazione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSegnalazione(id_segnalazione);
	}

	/**
	* Deletes the segnalazione from the database. Also notifies the appropriate model listeners.
	*
	* @param segnalazione the segnalazione
	* @return the segnalazione that was removed
	*/
	public static servizio.whistleblowing.mef.model.Segnalazione deleteSegnalazione(
		servizio.whistleblowing.mef.model.Segnalazione segnalazione) {
		return getService().deleteSegnalazione(segnalazione);
	}

	public static servizio.whistleblowing.mef.model.Segnalazione fetchSegnalazione(
		long id_segnalazione) {
		return getService().fetchSegnalazione(id_segnalazione);
	}

	/**
	* Returns the segnalazione with the primary key.
	*
	* @param id_segnalazione the primary key of the segnalazione
	* @return the segnalazione
	* @throws PortalException if a segnalazione with the primary key could not be found
	*/
	public static servizio.whistleblowing.mef.model.Segnalazione getSegnalazione(
		long id_segnalazione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSegnalazione(id_segnalazione);
	}

	/**
	* Updates the segnalazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param segnalazione the segnalazione
	* @return the segnalazione that was updated
	*/
	public static servizio.whistleblowing.mef.model.Segnalazione updateSegnalazione(
		servizio.whistleblowing.mef.model.Segnalazione segnalazione) {
		return getService().updateSegnalazione(segnalazione);
	}

	public static SegnalazioneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SegnalazioneLocalService, SegnalazioneLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SegnalazioneLocalService.class);
}