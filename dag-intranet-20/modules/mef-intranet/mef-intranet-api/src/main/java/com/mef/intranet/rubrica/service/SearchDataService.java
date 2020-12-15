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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO;

import java.util.List;

/**
 * Provides the remote service interface for SearchData. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataServiceUtil
 * @see com.mef.intranet.rubrica.service.base.SearchDataServiceBaseImpl
 * @see com.mef.intranet.rubrica.service.impl.SearchDataServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=mefrubrica", "json.web.service.context.path=SearchData"}, service = SearchDataService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SearchDataService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SearchDataServiceUtil} to access the search data remote service. Add custom service methods to {@link com.mef.intranet.rubrica.service.impl.SearchDataServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<java.lang.String> getAlfabetoTag() throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> getGerarchiaByCodStrut(
		java.lang.String codStruttura) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SuggestCognomeVO> getListCognomi(java.lang.String keyword)
		throws java.lang.Exception;

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

	public List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO> servDettagliUfficio(
		java.lang.String idUfficio) throws java.lang.Exception;

	public List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO> servElencoAnagraficheUffici(
		java.lang.String chiave, java.lang.Integer tipoRicerca)
		throws java.lang.Exception;

	public List<SuggestCognomeVO> suggestLastName(java.lang.String firstName,
		java.lang.String lastName) throws java.lang.Exception;

	public List<SuggestCognomeVO> suggestLastNameByFirstAndLast(
		java.lang.String firstName, java.lang.String lastName)
		throws java.lang.Exception;

	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO> suggestParolaChiave(
		java.lang.String chiave) throws java.lang.Exception;
}