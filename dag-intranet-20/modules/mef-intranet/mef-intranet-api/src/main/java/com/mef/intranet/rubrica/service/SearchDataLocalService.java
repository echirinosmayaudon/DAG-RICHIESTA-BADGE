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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mef.intranet.rubrica.model.SearchData;

import it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for SearchData. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataLocalServiceUtil
 * @see com.mef.intranet.rubrica.service.base.SearchDataLocalServiceBaseImpl
 * @see com.mef.intranet.rubrica.service.impl.SearchDataLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SearchDataLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SearchDataLocalServiceUtil} to access the search data local service. Add custom service methods to {@link com.mef.intranet.rubrica.service.impl.SearchDataLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	* Adds the search data to the database. Also notifies the appropriate model listeners.
	*
	* @param searchData the search data
	* @return the search data that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public SearchData addSearchData(SearchData searchData);

	/**
	* Creates a new search data with the primary key. Does not add the search data to the database.
	*
	* @param searchId the primary key for the new search data
	* @return the new search data
	*/
	public SearchData createSearchData(long searchId);

	/**
	* Deletes the search data from the database. Also notifies the appropriate model listeners.
	*
	* @param searchData the search data
	* @return the search data that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public SearchData deleteSearchData(SearchData searchData);

	/**
	* Deletes the search data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchId the primary key of the search data
	* @return the search data that was removed
	* @throws PortalException if a search data with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public SearchData deleteSearchData(long searchId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SearchData fetchSearchData(long searchId);

	/**
	* Returns the search data with the primary key.
	*
	* @param searchId the primary key of the search data
	* @return the search data
	* @throws PortalException if a search data with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SearchData getSearchData(long searchId) throws PortalException;

	public SearchData insertSearchData(java.lang.String jsonData, Date today);

	/**
	* Updates the search data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchData the search data
	* @return the search data that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public SearchData updateSearchData(SearchData searchData);

	/**
	* Returns the number of search datas.
	*
	* @return the number of search datas
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSearchDatasCount();

	public java.lang.Integer associaTag(java.lang.String codStruttura,
		java.lang.String tag) throws java.lang.Exception;

	public java.lang.Integer eliminaTag(java.lang.String tag)
		throws java.lang.Exception;

	public java.lang.Integer inserisciTag(java.lang.String tagName)
		throws java.lang.Exception;

	public java.lang.Integer modificaTag(java.lang.String vecchioTag,
		java.lang.String nuovoTag) throws java.lang.Exception;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.intranet.rubrica.model.impl.SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.intranet.rubrica.model.impl.SearchDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<java.lang.String> getAlfabetoTag() throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> getGerarchiaByCodStrut(
		java.lang.String codStruttura) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SearchData> getLastResult(int resultsNumber,
		java.lang.String screenNameUser);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> getListCognomi(
		java.lang.String keyword) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.DirezioneVO> getListDirezioni(
		java.lang.String idDirezione) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.EnteVO> getListEnti(
		java.lang.String idEnte) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersone(
		java.lang.String dipartimento, java.lang.String direzione,
		java.lang.String firstName, java.lang.String incaricoQualifica,
		java.lang.String lastName, java.lang.String organizzazione,
		java.lang.String strutturaInterna, java.lang.String ufficio)
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersoneTelNum(
		java.lang.String telefono) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO> getListStruttureInterne(
		java.lang.String idStruttura) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getListTagForChar(
		java.lang.String character) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.UfficioVO> getListUffici(
		java.lang.String idUfficio) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getNuvolaTag(
		java.lang.Integer numeroTag) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getPersoneByCodStrut(
		java.lang.String codStruttura) throws java.lang.Exception;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SearchData> getSearchDatas(int start, int end);

	public List<AnagraficaUfficioVO> servDettagliUfficio(
		java.lang.String idUfficio) throws java.lang.Exception;

	public List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO> servElencoAnagraficheUffici(
		java.lang.String chiave, java.lang.Integer tipoRicerca)
		throws java.lang.Exception;

	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastName(
		java.lang.String firstName, java.lang.String lastName)
		throws java.lang.Exception;

	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastNameByFirstAndLast(
		java.lang.String firstName, java.lang.String lastName)
		throws java.lang.Exception;

	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO> suggestParolaChiave(
		java.lang.String chiave) throws java.lang.Exception;

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
}