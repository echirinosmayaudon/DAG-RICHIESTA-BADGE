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

package com.mef.intranet.rubrica.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.mef.intranet.rubrica.service.SearchDataServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link SearchDataServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.mef.intranet.rubrica.model.SearchDataSoap}.
 * If the method in the service utility returns a
 * {@link com.mef.intranet.rubrica.model.SearchData}, that is translated to a
 * {@link com.mef.intranet.rubrica.model.SearchDataSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataServiceHttp
 * @see com.mef.intranet.rubrica.model.SearchDataSoap
 * @see SearchDataServiceUtil
 * @generated
 */
@ProviderType
public class SearchDataServiceSoap {
	public static it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVOSoap[] getListCognomi(
		java.lang.String keyword) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> returnValue =
				SearchDataServiceUtil.getListCognomi(keyword);

			return it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String[] getAlfabetoTag() throws RemoteException {
		try {
			java.util.List<java.lang.String> returnValue = SearchDataServiceUtil.getAlfabetoTag();

			return returnValue.toArray(new java.lang.String[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVOSoap[] suggestLastName(
		java.lang.String firstName, java.lang.String lastName)
		throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> returnValue =
				SearchDataServiceUtil.suggestLastName(firstName, lastName);

			return it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVOSoap[] getListStruttureInterne(
		java.lang.String idStruttura) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO> returnValue =
				SearchDataServiceUtil.getListStruttureInterne(idStruttura);

			return it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVOSoap[] suggestParolaChiave(
		java.lang.String chiave) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO> returnValue =
				SearchDataServiceUtil.suggestParolaChiave(chiave);

			return it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVOSoap[] servElencoAnagraficheUffici(
		java.lang.String chiave, java.lang.Integer tipoRicerca)
		throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO> returnValue =
				SearchDataServiceUtil.servElencoAnagraficheUffici(chiave,
					tipoRicerca);

			return it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.UfficioVOSoap[] getListUffici(
		java.lang.String idUfficio) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.UfficioVO> returnValue =
				SearchDataServiceUtil.getListUffici(idUfficio);

			return it.intranetdag.rubrica.services.vo.xsd.UfficioVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.AnagraficaVOSoap[] getPersoneByCodStrut(
		java.lang.String codStruttura) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> returnValue =
				SearchDataServiceUtil.getPersoneByCodStrut(codStruttura);

			return it.intranetdag.rubrica.services.vo.xsd.AnagraficaVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVOSoap[] servDettagliUfficio(
		java.lang.String idUfficio) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO> returnValue =
				SearchDataServiceUtil.servDettagliUfficio(idUfficio);

			return it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.AnagraficaVOSoap[] getListPersone(
		java.lang.String dipartimento, java.lang.String direzione,
		java.lang.String firstName, java.lang.String incaricoQualifica,
		java.lang.String lastName, java.lang.String organizzazione,
		java.lang.String strutturaInterna, java.lang.String ufficio)
		throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> returnValue =
				SearchDataServiceUtil.getListPersone(dipartimento, direzione,
					firstName, incaricoQualifica, lastName, organizzazione,
					strutturaInterna, ufficio);

			return it.intranetdag.rubrica.services.vo.xsd.AnagraficaVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.TagVOSoap[] getListTagForChar(
		java.lang.String character) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> returnValue =
				SearchDataServiceUtil.getListTagForChar(character);

			return it.intranetdag.rubrica.services.vo.xsd.TagVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.DirezioneVOSoap[] getListDirezioni(
		java.lang.String idDirezione) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.DirezioneVO> returnValue =
				SearchDataServiceUtil.getListDirezioni(idDirezione);

			return it.intranetdag.rubrica.services.vo.xsd.DirezioneVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.EnteVOSoap[] getListEnti(
		java.lang.String idEnte) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.EnteVO> returnValue =
				SearchDataServiceUtil.getListEnti(idEnte);

			return it.intranetdag.rubrica.services.vo.xsd.EnteVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.GerarchiaVOSoap[] getGerarchiaByCodStrut(
		java.lang.String codStruttura) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> returnValue =
				SearchDataServiceUtil.getGerarchiaByCodStrut(codStruttura);

			return it.intranetdag.rubrica.services.vo.xsd.GerarchiaVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.AnagraficaVOSoap[] getListPersoneTelNum(
		java.lang.String telefono) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> returnValue =
				SearchDataServiceUtil.getListPersoneTelNum(telefono);

			return it.intranetdag.rubrica.services.vo.xsd.AnagraficaVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.TagVOSoap[] getNuvolaTag(
		java.lang.Integer numeroTag) throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> returnValue =
				SearchDataServiceUtil.getNuvolaTag(numeroTag);

			return it.intranetdag.rubrica.services.vo.xsd.TagVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVOSoap[] suggestLastNameByFirstAndLast(
		java.lang.String firstName, java.lang.String lastName)
		throws RemoteException {
		try {
			java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> returnValue =
				SearchDataServiceUtil.suggestLastNameByFirstAndLast(firstName,
					lastName);

			return it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVOSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Integer associaTag(java.lang.String codStruttura,
		java.lang.String tag) throws RemoteException {
		try {
			java.lang.Integer returnValue = SearchDataServiceUtil.associaTag(codStruttura,
					tag);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Integer eliminaTag(java.lang.String tag)
		throws RemoteException {
		try {
			java.lang.Integer returnValue = SearchDataServiceUtil.eliminaTag(tag);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Integer inserisciTag(java.lang.String tagName)
		throws RemoteException {
		try {
			java.lang.Integer returnValue = SearchDataServiceUtil.inserisciTag(tagName);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Integer modificaTag(java.lang.String vecchioTag,
		java.lang.String nuovoTag) throws RemoteException {
		try {
			java.lang.Integer returnValue = SearchDataServiceUtil.modificaTag(vecchioTag,
					nuovoTag);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SearchDataServiceSoap.class);
}