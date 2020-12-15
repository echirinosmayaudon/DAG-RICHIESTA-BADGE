package com.mef.intranet.rubrica.service.impl;
import aQute.bnd.annotation.ProviderType;
import it.intranetdag.rubrica.business.dao.model.xsd.FormRicercaPersona;
import it.intranetdag.rubrica.business.dao.model.xsd.ObjectFactory;
import it.intranetdag.rubrica.services.AnagraficaWS;
import it.intranetdag.rubrica.services.AnagraficaWSPortType;
import it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO;
import com.mef.intranet.rubrica.configuration.MefIntranetEndpointConfigurationValues;
import com.mef.intranet.rubrica.model.SearchData;
import com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil;
import com.mef.intranet.rubrica.service.base.SearchDataLocalServiceBaseImpl;

import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import com.mef.intranet.rubrica.service.persistence.SearchDataPersistence;
/**
 * The implementation of the search data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.mef.intranet.rubrica.service.SearchDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataLocalServiceBaseImpl
 * @see com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil
 */
@ProviderType
public class SearchDataLocalServiceImpl extends SearchDataLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(SearchDataLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.mef.intranet.service.SearchDataLocalServiceUtil} to access the search data local service.
	 */
	
	@Override
	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> getListCognomi(String keyword) throws Exception{
		
		
		String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
		URL url = new URL(wsdl_location_rubrica);
		AnagraficaWS ss = new AnagraficaWS(url);
		AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
		return port.getListCognomi(keyword);
	}
	
	@Override
	public java.util.List<java.lang.String> getAlfabetoTag() throws Exception{
		
		
		String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
		URL url = new URL(wsdl_location_rubrica);
		AnagraficaWS ss = new AnagraficaWS(url);
		AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint(); 
		return port.getAlfabetoTag();
	}
	
	@Override
	public List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastName(String firstName, String lastName) throws Exception{
		
	
		String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
		URL url = new URL(wsdl_location_rubrica);
		AnagraficaWS ss = new AnagraficaWS(url);
		AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
		return port.suggestLastName(firstName,lastName);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO> getListStruttureInterne(java.lang.String idStruttura) throws Exception{
		
		
		String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
		URL url = new URL(wsdl_location_rubrica);
		AnagraficaWS ss = new AnagraficaWS(url);
		AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
		return port.getListStruttureInterne(idStruttura);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO> suggestParolaChiave(String chiave) throws Exception{
		
		
		String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
		URL url = new URL(wsdl_location_rubrica);
		AnagraficaWS ss = new AnagraficaWS(url);
		AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
		return port.suggestParolaChiave(chiave);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO> servElencoAnagraficheUffici(java.lang.String chiave,java.lang.Integer tipoRicerca) throws Exception{
		
		String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
		URL url = new URL(wsdl_location_rubrica);
		AnagraficaWS ss = new AnagraficaWS(url);
		AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
		return port.servElencoAnagraficheUffici(chiave,tipoRicerca);
	}
	
	@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.UfficioVO> getListUffici(java.lang.String idUfficio) throws Exception{
		
		String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
		URL url = new URL(wsdl_location_rubrica);
		AnagraficaWS ss = new AnagraficaWS(url);
		AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
		return port.getListUffici(idUfficio);
	}
	
@Override
	public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getPersoneByCodStrut(java.lang.String codStruttura) throws Exception{
		
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
		return port.getPersoneByCodStrut(codStruttura);
	}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO> servDettagliUfficio(java.lang.String idUfficio) throws Exception {
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint(); 
	java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO> lista = new java.util.ArrayList<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO>();
    lista.add(port.servDettagliUfficio(idUfficio));
    return lista;	
}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> getGerarchiaByCodStrut(java.lang.String codStruttura) throws Exception {
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint(); 
	java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> lista_G = new java.util.ArrayList<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO>();
    lista_G.add(port.getGerarchiaByCodStrut(codStruttura));
    return lista_G;	
}
	
@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersone(String dipartimento, String direzione, String firstName, String incaricoQualifica, String lastName,String organizzazione, String strutturaInterna, String ufficio) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	it.intranetdag.rubrica.business.dao.model.xsd.FormRicercaPersona frp=new it.intranetdag.rubrica.business.dao.model.xsd.FormRicercaPersona();
	ObjectFactory obj = new ObjectFactory();
	
	frp.setDipartimento(obj.createFormRicercaPersonaDipartimento(dipartimento));
	frp.setDirezione(obj.createFormRicercaPersonaDirezione(direzione));
	frp.setFirstName(obj.createFormRicercaPersonaFirstName(firstName));
	frp.setIncaricoQualifica(obj.createFormRicercaPersonaIncaricoQualifica(incaricoQualifica));
	frp.setLastName(obj.createFormRicercaPersonaLastName(lastName));
	frp.setOrganizzazione(obj.createFormRicercaPersonaOrganizzazione(organizzazione));
	frp.setStrutturaInterna(obj.createFormRicercaPersonaStrutturaInterna(strutturaInterna));
	frp.setUfficio(obj.createFormRicercaPersonaUfficio(ufficio));	
	return port.getListPersone(frp);
}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getListTagForChar(java.lang.String character) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.getListTagForChar(character);
}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.DirezioneVO> getListDirezioni(java.lang.String idDirezione) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.getListDirezioni(idDirezione);
}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.EnteVO> getListEnti(java.lang.String idEnte) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.getListEnti(idEnte);
}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersoneTelNum(java.lang.String telefono) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.getListPersoneTelNum(telefono);
}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getNuvolaTag(java.lang.Integer numeroTag) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.getNuvolaTag(numeroTag);
}

@Override
public java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastNameByFirstAndLast(java.lang.String firstName, java.lang.String lastName) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.suggestLastNameByFirstAndLast(firstName,lastName);
}

@Override
public  java.lang.Integer associaTag(java.lang.String codStruttura, java.lang.String tag) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint(); 
	return port.associaTag(codStruttura,tag);
}

@Override
public  java.lang.Integer eliminaTag(java.lang.String tag) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.eliminaTag(tag);
}

@Override
public  java.lang.Integer inserisciTag(java.lang.String tagName) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.inserisciTag(tagName);
}

@Override
public  java.lang.Integer modificaTag(java.lang.String vecchioTag, java.lang.String nuovoTag) throws Exception{
	
	String wsdl_location_rubrica = MefIntranetEndpointConfigurationValues.WSDL_LOCATION_RUBRICA;
	URL url = new URL(wsdl_location_rubrica);
	AnagraficaWS ss = new AnagraficaWS(url);
	AnagraficaWSPortType port = ss.getAnagraficaWSHttpSoap12Endpoint();
	return port.modificaTag(vecchioTag,nuovoTag);
}

@Override
public List<SearchData> getLastResult(int resultsNumber,String screenNameUser){
return searchDataFinder.getLastResult(resultsNumber,screenNameUser);
} 

	
@Override
public SearchData insertSearchData(String jsonData,Date today){
	SearchData sc = searchDataPersistence.create(-1);
	 sc.setSearchData(jsonData);
	 sc.setCreateDate(today);
	 SearchData dataout=null;
	 try{
		 dataout = searchDataPersistence.updateImpl(sc);
		 return dataout;
	 }catch(Exception e){
		 _log.error(e);
		 return dataout;
	 }
	
}
	
}