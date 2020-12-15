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

package servizio.local.bfc.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for LocalRich. This utility wraps
 * {@link servizio.local.bfc.service.impl.LocalRichLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichLocalService
 * @see servizio.local.bfc.service.base.LocalRichLocalServiceBaseImpl
 * @see servizio.local.bfc.service.impl.LocalRichLocalServiceImpl
 * @generated
 */
@ProviderType
public class LocalRichLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.local.bfc.service.impl.LocalRichLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of local richs.
	*
	* @return the number of local richs
	*/
	public static int getLocalRichsCount() {
		return getService().getLocalRichsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<servizio.local.bfc.model.LocalRich> findByfilters(
		java.util.List<java.lang.Long> lista_stati,
		java.util.List<java.lang.String> ufficio,
		java.util.List<com.liferay.portal.kernel.model.User> lista_utenti,
		boolean instage) {
		return getService()
				   .findByfilters(lista_stati, ufficio, lista_utenti, instage);
	}

	/**
	* Returns a range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of local richs
	*/
	public static java.util.List<servizio.local.bfc.model.LocalRich> getLocalRichs(
		int start, int end) {
		return getService().getLocalRichs(start, end);
	}

	public static java.util.List<servizio.local.bfc.model.LocalRich> getRichiestebyEmail(
		boolean instage, java.lang.String email) {
		return getService().getRichiestebyEmail(instage, email);
	}

	public static java.util.List<servizio.local.bfc.model.LocalRich> getRichiestebyIdRichiesta(
		long id_richiesta) {
		return getService().getRichiestebyIdRichiesta(id_richiesta);
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
	* Adds the local rich to the database. Also notifies the appropriate model listeners.
	*
	* @param localRich the local rich
	* @return the local rich that was added
	*/
	public static servizio.local.bfc.model.LocalRich addLocalRich(
		servizio.local.bfc.model.LocalRich localRich) {
		return getService().addLocalRich(localRich);
	}

	/**
	* Creates a new local rich with the primary key. Does not add the local rich to the database.
	*
	* @param id the primary key for the new local rich
	* @return the new local rich
	*/
	public static servizio.local.bfc.model.LocalRich createLocalRich(long id) {
		return getService().createLocalRich(id);
	}

	/**
	* Deletes the local rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the local rich
	* @return the local rich that was removed
	* @throws PortalException if a local rich with the primary key could not be found
	*/
	public static servizio.local.bfc.model.LocalRich deleteLocalRich(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLocalRich(id);
	}

	/**
	* Deletes the local rich from the database. Also notifies the appropriate model listeners.
	*
	* @param localRich the local rich
	* @return the local rich that was removed
	*/
	public static servizio.local.bfc.model.LocalRich deleteLocalRich(
		servizio.local.bfc.model.LocalRich localRich) {
		return getService().deleteLocalRich(localRich);
	}

	public static servizio.local.bfc.model.LocalRich fetchLocalRich(long id) {
		return getService().fetchLocalRich(id);
	}

	/**
	* Returns the local rich with the primary key.
	*
	* @param id the primary key of the local rich
	* @return the local rich
	* @throws PortalException if a local rich with the primary key could not be found
	*/
	public static servizio.local.bfc.model.LocalRich getLocalRich(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLocalRich(id);
	}

	public static servizio.local.bfc.model.LocalRich insertLocalRich(
		java.lang.Long id_richiesta, java.lang.Float costoReale,
		java.util.Date dataIns, java.util.Date dataRichiesta,
		java.util.Date dataUpd, java.lang.String email,
		java.lang.Integer flagInvio, java.lang.Long idPeriodicita,
		java.lang.String idSede, java.lang.Long idStatoAttuale,
		java.lang.String ispettorato, java.lang.String note,
		java.lang.String noteRichiedente, java.lang.String oggetto,
		java.lang.Integer preventivo, java.lang.String riferimentoStanza,
		java.lang.String strutIsp, java.lang.String strutIsp2,
		java.lang.String strutUff, java.lang.String telRichiedente,
		java.lang.String ufficio, java.lang.Long uidIns, java.lang.Long uidUpd,
		boolean inStage) {
		return getService()
				   .insertLocalRich(id_richiesta, costoReale, dataIns,
			dataRichiesta, dataUpd, email, flagInvio, idPeriodicita, idSede,
			idStatoAttuale, ispettorato, note, noteRichiedente, oggetto,
			preventivo, riferimentoStanza, strutIsp, strutIsp2, strutUff,
			telRichiedente, ufficio, uidIns, uidUpd, inStage);
	}

	/**
	* Updates the local rich in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param localRich the local rich
	* @return the local rich that was updated
	*/
	public static servizio.local.bfc.model.LocalRich updateLocalRich(
		servizio.local.bfc.model.LocalRich localRich) {
		return getService().updateLocalRich(localRich);
	}

	public static LocalRichLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LocalRichLocalService, LocalRichLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LocalRichLocalService.class);
}