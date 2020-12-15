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
 * Provides the remote service utility for SearchData. This utility wraps
 * {@link com.mef.intranet.rubrica.service.impl.SearchDataServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataService
 * @see com.mef.intranet.rubrica.service.base.SearchDataServiceBaseImpl
 * @see com.mef.intranet.rubrica.service.impl.SearchDataServiceImpl
 * @generated
 */
@ProviderType
public class SearchDataServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.mef.intranet.rubrica.service.impl.SearchDataServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
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

	public static java.util.List<java.lang.String> getAlfabetoTag()
		throws java.lang.Exception {
		return getService().getAlfabetoTag();
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> getGerarchiaByCodStrut(
		java.lang.String codStruttura) throws java.lang.Exception {
		return getService().getGerarchiaByCodStrut(codStruttura);
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

	public static SearchDataService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SearchDataService, SearchDataService> _serviceTracker =
		ServiceTrackerFactory.open(SearchDataService.class);
}