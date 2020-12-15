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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import servizio.richieste.badge.mef.model.RichiestaBadge;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for RichiestaBadge. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgeLocalServiceUtil
 * @see servizio.richieste.badge.mef.service.base.RichiestaBadgeLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.impl.RichiestaBadgeLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RichiestaBadgeLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaBadgeLocalServiceUtil} to access the richiesta badge local service. Add custom service methods to {@link servizio.richieste.badge.mef.service.impl.RichiestaBadgeLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	public JSONArray findSuggestionsBySurname(java.lang.String cognome,
		java.lang.String idOrgChart, java.lang.Long userId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of richiesta badges.
	*
	* @return the number of richiesta badges
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRichiestaBadgesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	public List<java.lang.Object[]> findNumbersRichiestaByDataRuoloSedeforIdOggetto(
		Date dataStart, Date dataEnd, boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap);

	public List<RichiestaBadge> findRichiestaByDataRuoloSede(Date dataStart,
		Date dataEnd, boolean is_last, boolean is_internal, long id_stato,
		long id_sedesiap);

	public List<RichiestaBadge> findRichiestaByDipartimentoStato(
		java.lang.String dipartimento, List<java.lang.Long> lista_IdStato);

	public List<RichiestaBadge> findRichiesteByIdRichiesta(long id_richiesta);

	public List<RichiestaBadge> findRichiesteInScadenza(Date data_begin,
		Date data_end, boolean is_last, long id_stato,
		java.lang.String screen_name_richiedente,
		List<java.lang.Long> id_uffici_competenza_list);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBadge> getBadgeRichiesteByRichiedente(
		java.lang.String screename_richiedente, boolean is_last);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBadge> getBadgeRichiesteByRuolo(Date data_modifica,
		boolean is_last, boolean is_internal, long id_stato);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBadge> getBadgeRichiesteByRuoloSede(
		Date data_modifica, boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBadge> getRichiestaBadgeByFilters(
		java.lang.String cogn_intest, java.lang.String nome_intest,
		java.lang.String cf_intest, java.lang.String societa,
		java.lang.String ref_societa, java.lang.String motivazione_rich,
		java.lang.String progetto, java.lang.String screenName,
		List<java.lang.Long> lista_idUffici, boolean is_last,
		List<java.lang.Long> lista_sedi, java.lang.String is_internal,
		List<java.lang.Long> lista_stati);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBadge> getRichiestaBadges(int start, int end);

	public long aggiornaRichiestaBadge(long id_richiesta,
		java.lang.String screename_richiedente, long id_ufficio,
		java.lang.String json_richiedente, boolean is_internal,
		java.lang.String nome_intestatario,
		java.lang.String cognome_intestatario,
		java.lang.String cf_intestatario,
		java.lang.String luogonascita_intestatario,
		Date datanascita_intestatario, long id_oggetto,
		java.lang.String numero_badge, java.lang.String uuid_foto,
		java.lang.String uuid_modulosostituzione, java.lang.String societa,
		java.lang.String referente_societa, java.lang.String progetto,
		java.lang.String json_richiesta_external,
		java.lang.String array_sedi_abilitate, java.lang.String motivazione,
		Date data_scadenza, java.lang.String uuid_modulopdf,
		Date data_richiesta, Date data_modifica, long id_stato,
		java.lang.String utente_cambio_stato, java.lang.String note,
		boolean is_last, long id_sede);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	public long insertRichiestaBadge(long id_richiesta,
		java.lang.String screename_richiedente, long id_ufficio,
		java.lang.String json_richiedente, boolean is_internal,
		java.lang.String nome_intestatario,
		java.lang.String cognome_intestatario,
		java.lang.String cf_intestatario,
		java.lang.String luogonascita_intestatario,
		Date datanascita_intestatario, long id_oggetto,
		java.lang.String numero_badge, java.lang.String uuid_foto,
		java.lang.String uuid_modulosostituzione, java.lang.String societa,
		java.lang.String referente_societa, java.lang.String progetto,
		java.lang.String json_richiesta_external,
		java.lang.String array_sedi_abilitate, java.lang.String motivazione,
		Date data_scadenza, java.lang.String uuid_modulopdf,
		Date data_richiesta, Date data_modifica, long id_stato,
		java.lang.String utente_cambio_stato, java.lang.String note,
		boolean is_last, long id_sede);

	/**
	* Adds the richiesta badge to the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBadge the richiesta badge
	* @return the richiesta badge that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RichiestaBadge addRichiestaBadge(RichiestaBadge richiestaBadge);

	/**
	* Creates a new richiesta badge with the primary key. Does not add the richiesta badge to the database.
	*
	* @param id_pk the primary key for the new richiesta badge
	* @return the new richiesta badge
	*/
	public RichiestaBadge createRichiestaBadge(long id_pk);

	/**
	* Deletes the richiesta badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge that was removed
	* @throws PortalException if a richiesta badge with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public RichiestaBadge deleteRichiestaBadge(long id_pk)
		throws PortalException;

	/**
	* Deletes the richiesta badge from the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBadge the richiesta badge
	* @return the richiesta badge that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public RichiestaBadge deleteRichiestaBadge(RichiestaBadge richiestaBadge);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RichiestaBadge fetchRichiestaBadge(long id_pk);

	/**
	* Returns the richiesta badge with the primary key.
	*
	* @param id_pk the primary key of the richiesta badge
	* @return the richiesta badge
	* @throws PortalException if a richiesta badge with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RichiestaBadge getRichiestaBadge(long id_pk)
		throws PortalException;

	/**
	* Updates the richiesta badge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiestaBadge the richiesta badge
	* @return the richiesta badge that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RichiestaBadge updateRichiestaBadge(RichiestaBadge richiestaBadge);
}