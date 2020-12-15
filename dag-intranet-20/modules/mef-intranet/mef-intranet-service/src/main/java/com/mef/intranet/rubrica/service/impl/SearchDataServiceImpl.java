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

package com.mef.intranet.rubrica.service.impl;
import aQute.bnd.annotation.ProviderType;
import it.intranetdag.rubrica.services.AnagraficaWSPortType;
import it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil;
import com.mef.intranet.rubrica.service.base.SearchDataServiceBaseImpl;

import java.util.List;

import javax.xml.bind.JAXBElement;

import java.util.ArrayList;
/**
 * The implementation of the search data remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.mef.intranet.rubrica.service.SearchDataService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataServiceBaseImpl
 * @see com.mef.intranet.rubrica.service.SearchDataServiceUtil
 */
@JSONWebService
@ProviderType
public class SearchDataServiceImpl extends SearchDataServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.mef.intranet.service.SearchDataServiceUtil} to access the search data remote service.
	 */
	
	@Override
	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> getListCognomi(String keyword) throws Exception{
		return SearchDataLocalServiceUtil.getListCognomi(keyword);
	}
	
	
	@Override
	public java.util.List<java.lang.String> getAlfabetoTag() throws Exception{
		return SearchDataLocalServiceUtil.getAlfabetoTag();
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastName(String firstName, String lastName) throws Exception{
		return SearchDataLocalServiceUtil.suggestLastName(firstName,lastName);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO> getListStruttureInterne(java.lang.String idStruttura) throws Exception{
		return SearchDataLocalServiceUtil.getListStruttureInterne( idStruttura);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO> suggestParolaChiave(String chiave) throws Exception{
		return SearchDataLocalServiceUtil.suggestParolaChiave(chiave);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO> servElencoAnagraficheUffici(String chiave, java.lang.Integer tipoRicerca) throws Exception{
		return SearchDataLocalServiceUtil.servElencoAnagraficheUffici(chiave, tipoRicerca);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.UfficioVO> getListUffici(java.lang.String idUfficio) throws Exception{
		return SearchDataLocalServiceUtil.getListUffici(idUfficio);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getPersoneByCodStrut(java.lang.String codStruttura) throws Exception{
		return SearchDataLocalServiceUtil.getPersoneByCodStrut(codStruttura);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO>  servDettagliUfficio(java.lang.String idUfficio) throws Exception{
		return SearchDataLocalServiceUtil.servDettagliUfficio(idUfficio);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersone(String dipartimento, String direzione, String firstName, String incaricoQualifica, String lastName,String organizzazione, String strutturaInterna, String ufficio) throws Exception{
		return SearchDataLocalServiceUtil.getListPersone(dipartimento,direzione, firstName, incaricoQualifica, lastName, organizzazione, strutturaInterna, ufficio);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getListTagForChar(String character) throws Exception{
		return SearchDataLocalServiceUtil.getListTagForChar(character);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.DirezioneVO> getListDirezioni(String idDirezione) throws Exception{
		return SearchDataLocalServiceUtil.getListDirezioni(idDirezione);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.EnteVO> getListEnti(String idEnte) throws Exception{
		return SearchDataLocalServiceUtil.getListEnti(idEnte);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO>  getGerarchiaByCodStrut(java.lang.String codStruttura) throws Exception{
		return SearchDataLocalServiceUtil.getGerarchiaByCodStrut(codStruttura);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO>  getListPersoneTelNum(java.lang.String telefono) throws Exception{
		return SearchDataLocalServiceUtil.getListPersoneTelNum(telefono);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO>  getNuvolaTag(java.lang.Integer numeroTag) throws Exception{
		return SearchDataLocalServiceUtil.getNuvolaTag(numeroTag);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO>  suggestLastNameByFirstAndLast(java.lang.String firstName,java.lang.String lastName) throws Exception{
		return SearchDataLocalServiceUtil.suggestLastNameByFirstAndLast(firstName, lastName);
	}
	
	@Override
	public java.lang.Integer associaTag(java.lang.String codStruttura,java.lang.String tag) throws Exception{
		return SearchDataLocalServiceUtil.associaTag(codStruttura, tag);
	}
	
	@Override
	public java.lang.Integer eliminaTag(java.lang.String tag) throws Exception{
		return SearchDataLocalServiceUtil.eliminaTag( tag);
	}
	
	@Override
	public java.lang.Integer inserisciTag(java.lang.String tagName) throws Exception{
		return SearchDataLocalServiceUtil.inserisciTag( tagName);
	}
	
	@Override
	public java.lang.Integer modificaTag(java.lang.String vecchioTag,java.lang.String nuovoTag ) throws Exception{
		return SearchDataLocalServiceUtil.modificaTag(vecchioTag,nuovoTag );
	}
	
	
	
}