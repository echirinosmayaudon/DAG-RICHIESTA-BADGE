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

package com.mef.geco.intranet.service.impl;

import aQute.bnd.annotation.ProviderType;
import geco.mef.it.MaterialeBean;
import geco.mef.it.SottoGruppoBean;
import geco.mef.it.SchedaMaterialeBean;
import it.tesoro.geco.geco_webservice.services.richiestabfcservice.RichiestaBFCService;
import it.tesoro.geco.geco_webservice.services.richiestabfcservice.RichiestaBFCServiceService;
import it.tesoro.geco.geco_webservice.services.schedaservice.SchedaService;
import it.tesoro.geco.geco_webservice.services.schedaservice.SchedaServiceService;
import it.tesoro.geco_bfc.geco_webservice.services.sottogrupposervice.SottogruppoService;
import it.tesoro.geco_bfc.geco_webservice.services.sottogrupposervice.SottogruppoServiceService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.mef.geco.intranet.configuration.MefGecoIntranetEndpointConfigurationValues;
import com.mef.geco.intranet.service.base.supportDataLocalServiceBaseImpl;
import com.mef.geco.intranet.util.XmlUtil;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * The implementation of the support data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.mef.geco.intranet.service.supportDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see supportDataLocalServiceBaseImpl
 * @see com.mef.geco.intranet.service.supportDataLocalServiceUtil
 */
@ProviderType
public class supportDataLocalServiceImpl extends supportDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.mef.geco.intranet.service.supportDataLocalServiceUtil} to access the support data local service.
	 */
	final Log _log = LogFactoryUtil.getLog(supportDataLocalServiceImpl.class);
	public static final String ESERCIZIO = "esercizio";
	public static final String COLLAUDO = "collaudo";
	public static final String GECO = "geco";
	public static final String PIGRECO = "pigreco";
	public static final String SEPARATOR= "-";
	
	@Override
	public  List<SottoGruppoBean> getListSottogruppi(String origine, String tipoMateriale, String codiceGruppo, String codiceUfficio, String servizio, String ambiente){

		URL wsdlURL = null;		
		String endpoint = null;
		
		if(ESERCIZIO.equalsIgnoreCase(ambiente)){
			
			if(GECO.equalsIgnoreCase(servizio)){
				
				 _log.info(GECO);		 
				 endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_GECO_ESERCIZIO_SOTTOGRUPPI;
				 wsdlURL = this.getClass().getClassLoader().getResource("wsdl/SottogruppoServiceCXF.wsdl");
				
			//pigreco inizialization
			}
			if(PIGRECO.equalsIgnoreCase(servizio)){
				_log.info(PIGRECO);
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_PIGRECO_ESERCIZIO_SOTTOGRUPPI;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/PigrecoSottogruppoServiceCXF.wsdl");
			 
			}
			
			
			
		}
		if(COLLAUDO.equalsIgnoreCase(ambiente)){
			
			if(GECO.equalsIgnoreCase(servizio)){				
				 _log.info(GECO +SEPARATOR+ COLLAUDO);
				
				 endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_GECO_COLLAUDO_SOTTOGRUPPI;
				 wsdlURL = this.getClass().getClassLoader().getResource("wsdl/CollaudoSottogruppoServiceCXF.wsdl");
				
			//pigreco inizialization
			}
			if(PIGRECO.equalsIgnoreCase(servizio)){
				_log.info(PIGRECO +SEPARATOR+ COLLAUDO);
				
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_PIGRECO_COLLAUDO_SOTTOGRUPPI;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/CollaudoPigrecoSottogruppoServiceCXF.wsdl");
			 
			}
			
			
		}
		 QName service = new QName(endpoint, "SottogruppoServiceService");
		 QName sottogruppoService = new QName(endpoint, "SottogruppoService");
		 SottogruppoServiceService servicestub = new SottogruppoServiceService(wsdlURL,service);
		 SottogruppoService port = servicestub.getSottogruppoService(sottogruppoService);
		 
		 XmlUtil util =new XmlUtil();			   
		 Document doc= util.generateXmlSottoGruppiInput(origine, tipoMateriale, codiceGruppo, codiceUfficio);
		 String requestParam=null;
		 
		 try {
			 requestParam = util.generateStringFromXML(doc);
			 _log.info(requestParam);
		} catch (TransformerException e) {				
			_log.error("transformer exception: "+e);		
		    return null;
		}
 
		 String  output = port.getSottogruppi(requestParam);
		 _log.info(output);
		 Document docOutput = null;
		  try {
			 docOutput = util.convertStringToDocument(output);
		} catch (ParserConfigurationException e) {
			_log.error(e);
			return null;
		} catch (SAXException e) {
			_log.error("sax exception: "+e);
			return null;
		} catch (IOException e) {
			_log.error("io exception: "+e);
			return null;
		}
		  
		
		
	  
		return util.getBeanFromSottoGruppoDoc(docOutput);
		 
	 }
	
	@Override
	public String nuovaRichiestaBfc(String origine, String idIntranet, String codUtente, String codiceUfficio, String email, String ispettorato, String ufficio, String telefono_richiedente, String riferimento_stanza, String idSede, String oggetto, String data, String periodicita, String budget, String consuntivo, List<MaterialeBean> listamateriali, String note, String servizio, String ambiente){
		

		XmlUtil util =new XmlUtil();
		URL wsdlURL = null;
		String endpoint = null;
	
		if(ESERCIZIO.equalsIgnoreCase(ambiente)){		
			if(GECO.equalsIgnoreCase(servizio)){
				_log.info(GECO);
				
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_GECO_ESERCIZIO_RICHIESTA;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/RichiestaBFCServiceCXF.wsdl");	
			
			}
			if(PIGRECO.equalsIgnoreCase(servizio)){
				_log.info(PIGRECO);
				
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_PIGRECO_ESERCIZIO_RICHIESTA;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/PigrecoRichiestaBFCServiceCXF.wsdl");
			}

		}
		
		if(COLLAUDO.equalsIgnoreCase(ambiente)){			
			if(GECO.equalsIgnoreCase(servizio)){
				_log.info(GECO +SEPARATOR+COLLAUDO );
			
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_GECO_COLLAUDO_RICHIESTA;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/CollaudoRichiestaBFCServiceCXF.wsdl");				
			}
			if(PIGRECO.equalsIgnoreCase(servizio)){
				_log.info(PIGRECO +SEPARATOR+COLLAUDO );
				
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_PIGRECO_COLLAUDO_RICHIESTA;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/CollaudoPigrecoRichiestaBFCServiceCXF.wsdl");	
			}
		}
		
		QName service = new QName(endpoint, "RichiestaBFCServiceService");
		QName RichiestaBFCService = new QName(endpoint, "RichiestaBFCService");
		RichiestaBFCServiceService ss = new RichiestaBFCServiceService(wsdlURL,service);
		RichiestaBFCService port = ss.getRichiestaBFCService(RichiestaBFCService);
	    Document doc= util.generateXmlCreateNuovaRichiestaInput(origine, idIntranet, codUtente, codiceUfficio, email, ispettorato, ufficio, telefono_richiedente, riferimento_stanza, idSede, oggetto, data, periodicita, budget, consuntivo, listamateriali, note);
	    String requestParam= null;
	    try {
			 requestParam = util.generateStringFromXML(doc);
			 _log.info(requestParam);
		} catch (TransformerException e) {				
			_log.error("transformer exception: "+e);		
		    return "1";
		}
	    	  
	    String	output = port.nuovaRichiestaMateriale(requestParam);
	    _log.info(output);
	    Document docOutput = null;
		  try {
			 docOutput = util.convertStringToDocument(output);
		} catch (ParserConfigurationException e) {
			_log.error(e);
			return null;
		} catch (SAXException e) {
			_log.error("sax exception: "+e);
			return null;
		} catch (IOException e) {
			_log.error("io exception: "+e);
			return null;
		}
		  
  
		return util.getResultFromCreateNuovaRichiestaDoc(docOutput); 
	}
	
	
	@Override
	public  List<SchedaMaterialeBean> getListMateriali(String origine, String tipoMateriale, String codiceGruppo,String codiceSottogruppo,String codiceUfficio, String servizio, String ambiente){
		
		
		
		URL wsdlURL = null;
		String endpoint = null;
		
		if(ESERCIZIO.equalsIgnoreCase(ambiente)){
			if(GECO.equalsIgnoreCase(servizio)){
				_log.info(GECO);
				
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_GECO_ESERCIZIO_MATERIALI;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/SchedaServiceCXF.wsdl");
			}
			
			if(PIGRECO.equalsIgnoreCase(servizio)){
				_log.info(PIGRECO);
				
				endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_PIGRECO_ESERCIZIO_MATERIALI;
				wsdlURL = this.getClass().getClassLoader().getResource("wsdl/PigrecoSchedaServiceCXF.wsdl");
			}
			
			
		
		}	
		 if(COLLAUDO.equalsIgnoreCase(ambiente)){
			
			 if(GECO.equalsIgnoreCase(servizio)){
				 	_log.info(GECO+SEPARATOR+COLLAUDO);
				 
				 	endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_GECO_COLLAUDO_MATERIALI;
					wsdlURL = this.getClass().getClassLoader().getResource("wsdl/CollaudoSchedaServiceCXF.wsdl");
				}
				
				if(PIGRECO.equalsIgnoreCase(servizio)){
					_log.info(PIGRECO+SEPARATOR+COLLAUDO);
				
					endpoint= MefGecoIntranetEndpointConfigurationValues.ENDPOINT_PIGRECO_COLLAUDO_MATERIALI;
					wsdlURL = this.getClass().getClassLoader().getResource("wsdl/CollaudoPigrecoSchedaServiceCXF.wsdl");
				}
			}
		 
		 	QName service = new QName(endpoint, "SchedaServiceService");
		 	QName schedaService = new QName(endpoint, "SchedaService");
		 	SchedaServiceService servicestub = new SchedaServiceService(wsdlURL,service);
		 	SchedaService port = servicestub.getSchedaService(schedaService);
		
		 XmlUtil util =new XmlUtil();			   
		 Document doc= util.generateXmlSchedaInput(origine, tipoMateriale, codiceGruppo, codiceSottogruppo, codiceUfficio);
		 String requestParam=null;
		 
		 try {
			 requestParam = util.generateStringFromXML(doc);
			 _log.info(requestParam);
		} catch (TransformerException e) {				
			_log.error("transformer exception: "+e);		
		    return null;
		}

		 String output = port.getSchede(requestParam);
		 _log.info(output);
		 Document docOutput = null;
		  try {
			 docOutput = util.convertStringToDocument(output);
		} catch (ParserConfigurationException e) {
			_log.error(e);
			return null;
		} catch (SAXException e) {
			_log.error("sax exception: "+e);
			return null;
		} catch (IOException e) {
			_log.error("io exception: "+e);
			return null;
		}
		  
		
		
	  
		return util.getBeanFromSchedaDoc(docOutput);
		 
	 }


	
}