package com.mef.geco.intranet.util;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import geco.mef.it.MaterialeBean;
import geco.mef.it.SchedaMaterialeBean;
import geco.mef.it.SottoGruppoBean;



public class XmlUtil {
	final Log _log = LogFactoryUtil.getLog(XmlUtil.class);
	
public Document generateXmlSottoGruppiInput(String origine, String tipoMateriale, String codiceGruppo, String codiceUfficio){
	Document doc =null;
	 try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			 doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("root");
			doc.appendChild(rootElement);

			// richiesta elements
			Element richiesta = doc.createElement("richiesta");
			rootElement.appendChild(richiesta);


			// origine element
			Element origineElem = doc.createElement("origine");
			origineElem.appendChild(doc.createTextNode(origine));
			richiesta.appendChild(origineElem);

			// tipo elemento elements
			Element tipoMaterialeElem = doc.createElement("tipoMateriale");
			tipoMaterialeElem.appendChild(doc.createTextNode(tipoMateriale));
			richiesta.appendChild(tipoMaterialeElem);

			// codice gruppo  elements
			Element codiceGruppoElem = doc.createElement("codiceGruppo");
			codiceGruppoElem.appendChild(doc.createTextNode(codiceGruppo));
			rootElement.appendChild(codiceGruppoElem);

			// codice ufficio elements
			Element codiceUfficioElem = doc.createElement("codiceUfficio");
			codiceUfficioElem.appendChild(doc.createTextNode(codiceUfficio));
			rootElement.appendChild(codiceUfficioElem);

		  } catch (ParserConfigurationException pce) {
			_log.error("parse configuation exception:"+pce);
		  } 
	 return doc;
		}

public Document generateXmlCreateNuovaRichiestaInput(String origine, String idIntranet, String codUtente, String codiceUfficio, String email, String ispettorato,String ufficio,String telefono_richiedente,
		 String riferimento_stanza, String idSede,String oggetto, String data, String periodicita,String budget,String consuntivo,
		 List<MaterialeBean> listaMateriali, String note){
Document doc =null;
try {

DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

// root elements
doc = docBuilder.newDocument();
Element rootElement = doc.createElement("root");
doc.appendChild(rootElement);

// richiesta elements
Element richiesta = doc.createElement("richiesta");
rootElement.appendChild(richiesta);

// origine element
Element origineElem = doc.createElement("origine");
origineElem.appendChild(doc.createTextNode(origine));
richiesta.appendChild(origineElem);

// id intranet element
Element idIntranetElem = doc.createElement("idIntranet");
idIntranetElem.appendChild(doc.createTextNode(idIntranet));
richiesta.appendChild(idIntranetElem);

// corpo  element
Element corpoElem = doc.createElement("corpo");
rootElement.appendChild(corpoElem);

// codice utente 
Element codiceUtenteElem = doc.createElement("codUtente");
codiceUtenteElem.appendChild(doc.createTextNode(codUtente));
corpoElem.appendChild(codiceUtenteElem);

// codice ufficio 
Element codiceUfficioElem = doc.createElement("codiceUfficio");
codiceUfficioElem.appendChild(doc.createTextNode(codiceUfficio));
corpoElem.appendChild(codiceUfficioElem);

// email
Element emailElem = doc.createElement("email");
emailElem.appendChild(doc.createTextNode(email));
corpoElem.appendChild(emailElem);

// ispettorato
Element ispettoratoElem = doc.createElement("ispettorato");
ispettoratoElem.appendChild(doc.createTextNode(ispettorato));
corpoElem.appendChild(ispettoratoElem);

// ufficio
Element ufficioElem = doc.createElement("ufficio");
ufficioElem.appendChild(doc.createTextNode(ufficio));
corpoElem.appendChild(ufficioElem);

// telefono_richiedente
Element telefono_richiedenteElem = doc.createElement("telefono_richiedente");
telefono_richiedenteElem.appendChild(doc.createTextNode(telefono_richiedente));
corpoElem.appendChild(telefono_richiedenteElem);

// riferimento_stanza
Element riferimento_stanzaElem = doc.createElement("riferimento_stanza");
riferimento_stanzaElem.appendChild(doc.createTextNode(riferimento_stanza));
corpoElem.appendChild(riferimento_stanzaElem);

// idSede
Element idSedeElem = doc.createElement("idSede");
idSedeElem.appendChild(doc.createTextNode(idSede));
corpoElem.appendChild(idSedeElem);

// oggetto
Element oggettoElem = doc.createElement("oggetto");
oggettoElem.appendChild(doc.createTextNode(oggetto));
corpoElem.appendChild(oggettoElem);

// data
Element dataElem = doc.createElement("data");
dataElem.appendChild(doc.createTextNode(data));
corpoElem.appendChild(dataElem);

// periodicita
Element periodicitaElem = doc.createElement("periodicita");
periodicitaElem.appendChild(doc.createTextNode(periodicita));
corpoElem.appendChild(periodicitaElem);

// budget
Element budgetElem = doc.createElement("budget");
budgetElem.appendChild(doc.createTextNode(budget));
corpoElem.appendChild(budgetElem);

// consuntivo
Element consuntivoElem = doc.createElement("consuntivo");
consuntivoElem.appendChild(doc.createTextNode(consuntivo));
corpoElem.appendChild(consuntivoElem);


// corpo  element
Element beniRichiestiElem = doc.createElement("beniRichiesti");
corpoElem.appendChild(beniRichiestiElem);

for(MaterialeBean item: listaMateriali){			
//materiale element
Element materialeElem = doc.createElement("materiale");
beniRichiestiElem.appendChild(materialeElem);

//gruppo		
Element gruppoElem = doc.createElement("gruppo");
gruppoElem.appendChild(doc.createTextNode(item.getGruppo()));
materialeElem.appendChild(gruppoElem);

//sottogruppo
Element sottogruppoElem = doc.createElement("sottogruppo");
sottogruppoElem.appendChild(doc.createTextNode(item.getSottogruppo()));
materialeElem.appendChild(sottogruppoElem);

//scheda
Element schedaElem = doc.createElement("scheda");
schedaElem.appendChild(doc.createTextNode(item.getScheda()));
materialeElem.appendChild(schedaElem);


//scheda
Element qtarichiestaElem = doc.createElement("qtarichiesta");
qtarichiestaElem.appendChild(doc.createTextNode(item.getQtarichiesta()));
materialeElem.appendChild(qtarichiestaElem);


}
// note
Element noteElem = doc.createElement("note");
noteElem.appendChild(doc.createTextNode(note));
corpoElem.appendChild(noteElem);


} catch (ParserConfigurationException pce) {
	_log.error("parse configuation exception:"+pce);
} 
return doc;
}

public Document generateXmlSchedaInput(String origine, String tipoMateriale, String codiceGruppo, String codiceSottogruppo,  String codiceUfficio){
	Document doc =null;
	 try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			 doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("root");
			doc.appendChild(rootElement);

			// richiesta elements
			Element richiesta = doc.createElement("richiesta");
			rootElement.appendChild(richiesta);


			// origine element
			Element origineElem = doc.createElement("origine");
			origineElem.appendChild(doc.createTextNode(origine));
			richiesta.appendChild(origineElem);

			// tipo elemento elements
			Element tipoMaterialeElem = doc.createElement("tipoMateriale");
			tipoMaterialeElem.appendChild(doc.createTextNode(tipoMateriale));
			richiesta.appendChild(tipoMaterialeElem);

			// codice gruppo  elements
			Element codiceGruppoElem = doc.createElement("codiceGruppo");
			codiceGruppoElem.appendChild(doc.createTextNode(codiceGruppo));
			rootElement.appendChild(codiceGruppoElem);
			
			// codice sottogruppo  elements
			Element codiceSottoGruppoElem = doc.createElement("codiceSottogruppo");
			codiceSottoGruppoElem.appendChild(doc.createTextNode(codiceSottogruppo));
			rootElement.appendChild(codiceSottoGruppoElem);

			// codice ufficio elements
			Element codiceUfficioElem = doc.createElement("codiceUfficio");
			codiceUfficioElem.appendChild(doc.createTextNode(codiceUfficio));
			rootElement.appendChild(codiceUfficioElem);

		  } catch (ParserConfigurationException pce) {
			  _log.error("parse configuation exception:"+pce);
		  } 
	 return doc;
		}



public String generateStringFromXML(Document doc) throws TransformerException{
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer();
	transformer.setOutputProperty(OutputKeys.INDENT, "no");
	//transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	StringWriter writer = new StringWriter();
	transformer.transform(new DOMSource(doc), new StreamResult(writer));
	return writer.toString();
}


public  Document convertStringToDocument(String xmlStr) throws ParserConfigurationException, SAXException, IOException {
	DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();  
	InputSource is = new InputSource();
	is.setCharacterStream(new StringReader(xmlStr));
	Document doc = db.parse(is);
	return doc;
}


public String getResultFromCreateNuovaRichiestaDoc(Document doc){
	NodeList esitoNodeList= doc.getElementsByTagName("esito");
	Node esitoItem = esitoNodeList.item(0);
   
	if(esitoItem.getAttributes().getNamedItem("codice")!=null){
		String code= esitoItem.getAttributes().getNamedItem("codice").getNodeValue();
		return code;
	}
	else{
		NodeList resultNodeList= doc.getElementsByTagName("codice");	
		String codeAlt = (String) resultNodeList.item(0).getTextContent();
		return codeAlt;
	}
	
}


public List<SchedaMaterialeBean> getBeanFromSchedaDoc(Document doc){
	List<SchedaMaterialeBean> out= new ArrayList<SchedaMaterialeBean>(0);
	NodeList materialeList = doc.getElementsByTagName("materiale");
	for (int i = 0; i < materialeList.getLength(); ++i)
	{
		SchedaMaterialeBean materiale= new SchedaMaterialeBean();
		Element materialeElem = (Element) materialeList.item(i); 
	    String codiceGruppo = materialeElem.getElementsByTagName("codiceGruppo").item(0).getTextContent();
	    materiale.setCodiceGruppo(codiceGruppo);
	    String codiceSottogruppo = materialeElem.getElementsByTagName("codiceSottogruppo").item(0).getTextContent();
	    materiale.setCodiceSottogruppo(codiceSottogruppo);
	    String numeroScheda = materialeElem.getElementsByTagName("numeroScheda").item(0).getTextContent();
	    materiale.setNumeroScheda(numeroScheda);
	    String descrizione = materialeElem.getElementsByTagName("descrizione").item(0).getTextContent();
	    materiale.setDescrizione(descrizione);
	    String prezzoMedio = materialeElem.getElementsByTagName("prezzoMedio").item(0).getTextContent();
	    materiale.setPrezzoMedio(prezzoMedio);
	    String disponibilita = materialeElem.getElementsByTagName("disponibilita").item(0).getTextContent();
	    materiale.setDisponibilita(disponibilita);
	    
	    out.add(materiale);
	       
	}
	return out;
}


public List<SottoGruppoBean> getBeanFromSottoGruppoDoc(Document doc){
	List<SottoGruppoBean> out= new ArrayList<SottoGruppoBean>(0);
	NodeList sottoGruppoList = doc.getElementsByTagName("sottogruppo");
	for (int i = 0; i < sottoGruppoList.getLength(); ++i)
	{
		SottoGruppoBean sottogruppo= new SottoGruppoBean();
		Element sottogruppoElem = (Element) sottoGruppoList.item(i); 
	    String codice = sottogruppoElem.getElementsByTagName("codice").item(0).getTextContent();
	    sottogruppo.setCodice(codice);
	    String descrizione = sottogruppoElem.getElementsByTagName("descrizione").item(0).getTextContent();
	    sottogruppo.setDescrizione(descrizione);
	    out.add(sottogruppo);
	    
	    
	}
	return out;
}


}
	

