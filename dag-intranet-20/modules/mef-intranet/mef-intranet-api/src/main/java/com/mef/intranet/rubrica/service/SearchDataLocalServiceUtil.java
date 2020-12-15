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

package com.mef.intranet.rubrica.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SearchData. This utility wraps
 * {@link com.mef.intranet.rubrica.service.impl.SearchDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataLocalService
 * @see com.mef.intranet.rubrica.service.base.SearchDataLocalServiceBaseImpl
 * @see com.mef.intranet.rubrica.service.impl.SearchDataLocalServiceImpl
 * @generated
 */
@ProviderType
public class SearchDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.mef.intranet.rubrica.service.impl.SearchDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the search data to the database. Also notifies the appropriate model listeners.
	*
	* @param searchData the search data
	* @return the search data that was added
	*/
	public static com.mef.intranet.rubrica.model.SearchData addSearchData(
		com.mef.intranet.rubrica.model.SearchData searchData) {
		return getService().addSearchData(searchData);
	}

	/**
	* Creates a new search data with the primary key. Does not add the search data to the database.
	*
	* @param searchId the primary key for the new search data
	* @return the new search data
	*/
	public static com.mef.intranet.rubrica.model.SearchData createSearchData(
		long searchId) {
		return getService().createSearchData(searchId);
	}

	/**
	* Deletes the search data from the database. Also notifies the appropriate model listeners.
	*
	* @param searchData the search data
	* @return the search data that was removed
	*/
	public static com.mef.intranet.rubrica.model.SearchData deleteSearchData(
		com.mef.intranet.rubrica.model.SearchData searchData) {
		return getService().deleteSearchData(searchData);
	}

	/**
	* Deletes the search data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchId the primary key of the search data
	* @return the search data that was removed
	* @throws PortalException if a search data with the primary key could not be found
	*/
	public static com.mef.intranet.rubrica.model.SearchData deleteSearchData(
		long searchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSearchData(searchId);
	}

	public static com.mef.intranet.rubrica.model.SearchData fetchSearchData(
		long searchId) {
		return getService().fetchSearchData(searchId);
	}

	/**
	* Returns the search data with the primary key.
	*
	* @param searchId the primary key of the search data
	* @return the search data
	* @throws PortalException if a search data with the primary key could not be found
	*/
	public static com.mef.intranet.rubrica.model.SearchData getSearchData(
		long searchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSearchData(searchId);
	}

	public static com.mef.intranet.rubrica.model.SearchData insertSearchData(
		java.lang.String jsonData, java.util.Date today) {
		return getService().insertSearchData(jsonData, today);
	}

	/**
	* Updates the search data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchData the search data
	* @return the search data that was updated
	*/
	public static com.mef.intranet.rubrica.model.SearchData updateSearchData(
		com.mef.intranet.rubrica.model.SearchData searchData) {
		return getService().updateSearchData(searchData);
	}

	/**
	* Returns the number of search datas.
	*
	* @return the number of search datas
	*/
	public static int getSearchDatasCount() {
		return getService().getSearchDatasCount();
	}

	public static java.lang.Integer associaTag(java.lang.String codStruttura,
		java.lang.String tag) throws java.lang.Exception {
		return getService().associaTag(codStruttura, tag);
	}

	public static java.lang.Integer eliminaTag(java.lang.String tag)
		throws java.lang.Exception {
		return getService().eliminaTag(tag);
	}

	public static java.lang.Integer inserisciTag(java.lang.String tagName)
		throws java.lang.Exception {
		return getService().inserisciTag(tagName);
	}

	public static java.lang.Integer modificaTag(java.lang.String vecchioTag,
		java.lang.String nuovoTag) throws java.lang.Exception {
		return getService().modificaTag(vecchioTag, nuovoTag);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.intranet.rubrica.model.impl.SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.intranet.rubrica.model.impl.SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<java.lang.String> getAlfabetoTag()
		throws java.lang.Exception {
		return getService().getAlfabetoTag();
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> getGerarchiaByCodStrut(
		java.lang.String codStruttura) throws java.lang.Exception {
		return getService().getGerarchiaByCodStrut(codStruttura);
	}

	public static java.util.List<com.mef.intranet.rubrica.model.SearchData> getLastResult(
		int resultsNumber, java.lang.String screenNameUser) {
		return getService().getLastResult(resultsNumber, screenNameUser);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> getListCognomi(
		java.lang.String keyword) throws java.lang.Exception {
		return getService().getListCognomi(keyword);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.DirezioneVO> getListDirezioni(
		java.lang.String idDirezione) throws java.lang.Exception {
		return getService().getListDirezioni(idDirezione);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.EnteVO> getListEnti(
		java.lang.String idEnte) throws java.lang.Exception {
		return getService().getListEnti(idEnte);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersone(
		java.lang.String dipartimento, java.lang.String direzione,
		java.lang.String firstName, java.lang.String incaricoQualifica,
		java.lang.String lastName, java.lang.String organizzazione,
		java.lang.String strutturaInterna, java.lang.String ufficio)
		throws java.lang.Exception {
		return getService()
				   .getListPersone(dipartimento, direzione, firstName,
			incaricoQualifica, lastName, organizzazione, strutturaInterna,
			ufficio);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersoneTelNum(
		java.lang.String telefono) throws java.lang.Exception {
		return getService().getListPersoneTelNum(telefono);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO> getListStruttureInterne(
		java.lang.String idStruttura) throws java.lang.Exception {
		return getService().getListStruttureInterne(idStruttura);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getListTagForChar(
		java.lang.String character) throws java.lang.Exception {
		return getService().getListTagForChar(character);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.UfficioVO> getListUffici(
		java.lang.String idUfficio) throws java.lang.Exception {
		return getService().getListUffici(idUfficio);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getNuvolaTag(
		java.lang.Integer numeroTag) throws java.lang.Exception {
		return getService().getNuvolaTag(numeroTag);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getPersoneByCodStrut(
		java.lang.String codStruttura) throws java.lang.Exception {
		return getService().getPersoneByCodStrut(codStruttura);
	}

	/**
	* Returns a range of all the search datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.intranet.rubrica.model.impl.SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search datas
	* @param end the upper bound of the range of search datas (not inclusive)
	* @return the range of search datas
	*/
	public static java.util.List<com.mef.intranet.rubrica.model.SearchData> getSearchDatas(
		int start, int end) {
		return getService().getSearchDatas(start, end);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO> servDettagliUfficio(
		java.lang.String idUfficio) throws java.lang.Exception {
		return getService().servDettagliUfficio(idUfficio);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO> servElencoAnagraficheUffici(
		java.lang.String chiave, java.lang.Integer tipoRicerca)
		throws java.lang.Exception {
		return getService().servElencoAnagraficheUffici(chiave, tipoRicerca);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastName(
		java.lang.String firstName, java.lang.String lastName)
		throws java.lang.Exception {
		return getService().suggestLastName(firstName, lastName);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastNameByFirstAndLast(
		java.lang.String firstName, java.lang.String lastName)
		throws java.lang.Exception {
		return getService().suggestLastNameByFirstAndLast(firstName, lastName);
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO> suggestParolaChiave(
		java.lang.String chiave) throws java.lang.Exception {
		return getService().suggestParolaChiave(chiave);
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

	public static SearchDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SearchDataLocalService, SearchDataLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SearchDataLocalService.class);
}