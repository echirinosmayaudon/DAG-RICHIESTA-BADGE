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
 * Provides the local service utility for RichiestaBadge. This utility wraps
 * {@link servizio.richieste.badge.mef.service.impl.RichiestaBadgeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgeLocalService
 * @see servizio.richieste.badge.mef.service.base.RichiestaBadgeLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.impl.RichiestaBadgeLocalServiceImpl
 * @generated
 */
@ProviderType
public class RichiestaBadgeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.richieste.badge.mef.service.impl.RichiestaBadgeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONArray findSuggestionsBySurname(
		java.lang.String cognome, java.lang.String idOrgChart,
		java.lang.Long userId) {
		return getService().findSuggestionsBySurname(cognome, idOrgChart, userId);
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
	* Returns the number of richiesta badges.
	*
	* @return the number of richiesta badges
	*/
	public static int getRichiestaBadgesCount() {
		return getService().getRichiestaBadgesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<java.lang.Object[]> findNumbersRichiestaByDataRuoloSedeforIdOggetto(
		java.util.Date dataStart, java.util.Date dataEnd, boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap) {
		return getService()
				   .findNumbersRichiestaByDataRuoloSedeforIdOggetto(dataStart,
			dataEnd, is_last, is_internal, id_stato, id_sedesiap);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiestaByDataRuoloSede(
		java.util.Date dataStart, java.util.Date dataEnd, boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap) {
		return getService()
				   .findRichiestaByDataRuoloSede(dataStart, dataEnd, is_last,
			is_internal, id_stato, id_sedesiap);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiestaByDipartimentoStato(
		java.lang.String dipartimento,
		java.util.List<java.lang.Long> lista_IdStato) {
		return getService()
				   .findRichiestaByDipartimentoStato(dipartimento, lista_IdStato);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiesteByIdRichiesta(
		long id_richiesta) {
		return getService().findRichiesteByIdRichiesta(id_richiesta);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiesteInScadenza(
		java.util.Date data_begin, java.util.Date data_end, boolean is_last,
		long id_stato, java.lang.String screen_name_richiedente,
		java.util.List<java.lang.Long> id_uffici_competenza_list) {
		return getService()
				   .findRichiesteInScadenza(data_begin, data_end, is_last,
			id_stato, screen_name_richiedente, id_uffici_competenza_list);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getBadgeRichiesteByRichiedente(
		java.lang.String screename_richiedente, boolean is_last) {
		return getService()
				   .getBadgeRichiesteByRichiedente(screename_richiedente,
			is_last);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getBadgeRichiesteByRuolo(
		java.util.Date data_modifica, boolean is_last, boolean is_internal,
		long id_stato) {
		return getService()
				   .getBadgeRichiesteByRuolo(data_modifica, is_last,
			is_internal, id_stato);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getBadgeRichiesteByRuoloSede(
		java.util.Date data_modifica, boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap) {
		return getService()
				   .getBadgeRichiesteByRuoloSede(data_modifica, is_last,
			is_internal, id_stato, id_sedesiap);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getRichiestaBadgeByFilters(
		java.lang.String cogn_intest, java.lang.String nome_intest,
		java.lang.String cf_intest, java.lang.String societa,
		java.lang.String ref_societa, java.lang.String motivazione_rich,
		java.lang.String progetto, java.lang.String screenName,
		java.util.List<java.lang.Long> lista_idUffici, boolean is_last,
		java.util.List<java.lang.Long> lista_sedi,
		java.lang.String is_internal, java.util.List<java.lang.Long> lista_stati) {
		return getService()
				   .getRichiestaBadgeByFilters(cogn_intest, nome_intest,
			cf_intest, societa, ref_societa, motivazione_rich, progetto,
			screenName, lista_idUffici, is_last, lista_sedi, is_internal,
			lista_stati);
	}

	/**
	* Returns a range of all the richiesta badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta badges
	* @param end the upper bound of the range of richiesta badges (not inclusive)
	* @return the range of richiesta badges
	*/
	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getRichiestaBadges(
		int start, int end) {
		return getService().getRichiestaBadges(start, end);
	}

	public static long aggiornaRichiestaBadge(long id_richiesta,
		java.lang.String screename_richiedente, long id_ufficio,
		java.lang.String json_richiedente, boolean is_internal,
		java.lang.String nome_intestatario,
		java.lang.String cognome_intestatario,
		java.lang.String cf_intestatario,
		java.lang.String luogonascita_intestatario,
		java.util.Date datanascita_intestatario, long id_oggetto,
		java.lang.String numero_badge, java.lang.String uuid_foto,
		java.lang.String uuid_modulosostituzione, java.lang.String societa,
		java.lang.String referente_societa, java.lang.String progetto,
		java.lang.String json_richiesta_external,
		java.lang.String array_sedi_abilitate, java.lang.String motivazione,
		java.util.Date data_scadenza, java.lang.String uuid_modulopdf,
		java.util.Date data_richiesta, java.util.Date data_modifica,
		long id_stato, java.lang.String utente_cambio_stato,
		java.lang.String note, boolean is_last, long id_sede) {
		return getService()
				   .aggiornaRichiestaBadge(id_richiesta, screename_richiedente,
			id_ufficio, json_richiedente, is_internal, nome_intestatario,
			cognome_intestatario, cf_intestatario, luogonascita_intestatario,
			datanascita_intestatario, id_oggetto, numero_badge, uuid_foto,
			uuid_modulosostituzione, societa, referente_societa, progetto,
			json_richiesta_external, array_sedi_abilitate, motivazione,
			data_scadenza, uuid_modulopdf, data_richiesta, data_modifica,
			id_stato, utente_cambio_stato, note, is_last, id_sede);
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

	public static long insertRichiestaBadge(long id_richiesta,
		java.lang.String screename_richiedente, long id_ufficio,
		java.lang.String json_richiedente, boolean is_internal,
		java.lang.String nome_intestatario,
		java.lang.String cognome_intestatario,
		java.lang.String cf_intestatario,
		java.lang.String luogonascita_intestatario,
		java.util.Date datanascita_intestatario, long id_oggetto,
		java.lang.String numero_badge, java.lang.String uuid_foto,
		java.lang.String uuid_modulosostituzione, java.lang.String societa,
		java.lang.String referente_societa, java.lang.String progetto,
		java.lang.String json_richiesta_external,
		java.lang.String array_sedi_abilitate, java.lang.String motivazione,
		java.util.Date data_scadenza, java.lang.String uuid_modulopdf,
		java.util.Date data_richiesta, java.util.Date data_modifica,
		long id_stato, java.lang.String utente_cambio_stato,
		java.lang.String note, boolean is_last, long id_sede) {
		return getService()
				   .insertRichiestaBadge(id_richiesta, screename_richiedente,
			id_ufficio, json_richiedente, is_internal, nome_intestatario,
			cognome_intestatario, cf_intestatario, luogonascita_intestatario,
			datanascita_intestatario, id_oggetto, numero_badge, uuid_foto,
			uuid_modulosostituzione, societa, referente_societa, progetto,
			json_richiesta_external, array_sedi_abilitate, motivazione,
			data_scadenza, uuid_modulopdf, data_richiesta, data_modifica,
			id_stato, utente_cambio_stato, note, is_last, id_sede);
	}

	/**
	* Adds the richiesta badge to the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBadge the richiesta badge
	* @return the richiesta badge that was added
	*/
	public static servizio.richieste.badge.mef.model.RichiestaBadge addRichiestaBadge(
		servizio.richieste.badge.mef.model.RichiestaBadge richiestaBadge) {
		return getService().addRichiestaBadge(richiestaBadge);
	}

	/**
	* Creates a new richiesta badge with the primary key. Does not add the richiesta badge to the database.
	*
	* @param id_pk the primary key for the new richiesta badge
	* @return the new richiesta badge
	*/
	public static servizio.richieste.badge.mef.model.RichiestaBadge createRichiestaBadge(
		long id_pk) {
		return getService().createRichiestaBadge(id_pk);
	}

	/**
	* Deletes the richiesta badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge that was removed
	* @throws PortalException if a richiesta badge with the primary key could not be found
	*/
	public static servizio.richieste.badge.mef.model.RichiestaBadge deleteRichiestaBadge(
		long id_pk) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRichiestaBadge(id_pk);
	}

	/**
	* Deletes the richiesta badge from the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBadge the richiesta badge
	* @return the richiesta badge that was removed
	*/
	public static servizio.richieste.badge.mef.model.RichiestaBadge deleteRichiestaBadge(
		servizio.richieste.badge.mef.model.RichiestaBadge richiestaBadge) {
		return getService().deleteRichiestaBadge(richiestaBadge);
	}

	public static servizio.richieste.badge.mef.model.RichiestaBadge fetchRichiestaBadge(
		long id_pk) {
		return getService().fetchRichiestaBadge(id_pk);
	}

	/**
	* Returns the richiesta badge with the primary key.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge
	* @throws PortalException if a richiesta badge with the primary key could not be found
	*/
	public static servizio.richieste.badge.mef.model.RichiestaBadge getRichiestaBadge(
		long id_pk) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRichiestaBadge(id_pk);
	}

	/**
	* Updates the richiesta badge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiestaBadge the richiesta badge
	* @return the richiesta badge that was updated
	*/
	public static servizio.richieste.badge.mef.model.RichiestaBadge updateRichiestaBadge(
		servizio.richieste.badge.mef.model.RichiestaBadge richiestaBadge) {
		return getService().updateRichiestaBadge(richiestaBadge);
	}

	public static RichiestaBadgeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaBadgeLocalService, RichiestaBadgeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaBadgeLocalService.class);
}