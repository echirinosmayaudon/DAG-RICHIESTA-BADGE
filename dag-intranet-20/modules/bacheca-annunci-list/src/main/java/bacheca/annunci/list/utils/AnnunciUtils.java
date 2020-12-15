package bacheca.annunci.list.utils;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

public class AnnunciUtils {
	final Log _log = LogFactoryUtil.getLog(AnnunciUtils.class);
	public static final String CATEGORIA_AREA = "area tematica";
	
	// utilità di estrazione valori da struttura in base al contenuto del journal e al nome del campo da estrarre
	public String getValueFromStructure(String content, String nameField) {
		String title="";
		try {
		Document document = SAXReaderUtil.read(new StringReader(content));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + nameField + "']/dynamic-content");
			if (node != null && node.getText().length() > 0) {
				title = node.getText();
			}
		} catch (DocumentException e) {
			_log.error(e);
		}
		return title;
	}
	
	public String setValuesFromStructure(String content, Map<String, String> fields) {
		
		Document document = null;
		try {
			document = SAXReaderUtil.read(new StringReader(content));
			Iterator it = fields.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				Node node = document.selectSingleNode("/root/dynamic-element[@name='" + pair.getKey().toString() + "']/dynamic-content");
				if (node.getText().length() > 0 && pair.getValue() != null) {
					node.setText(adaptDataStr(pair.getValue().toString()));
				}
				it.remove();
			}
		} catch (DocumentException e) {
			_log.error(e);
			return null;
		}
		return document.asXML();
	}
	
	private String adaptDataStr(String text) {
		
		//String txt=String.format("<![CDATA[%s]]>",text);
		String txt = text;
		if ("cercasi".equals(text) || "offresi".equals(text)) {
			// txt= String.format("<![CDATA[%s]]>","[\""+text+"\"]"); 
			txt = "[\"" + text + "\"]";
		}
		return txt;
	}
	
	public String getStructureIdFromName(String strName) {
		String srtKey = "";
		List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getStructures();
		for (DDMStructure ddmStructure : ddmStructures) {
			
			if (strName.equals(ddmStructure.getName(Locale.getDefault(), true))) {
				
				srtKey = ddmStructure.getStructureKey();
				break;
			}
		}
		return srtKey;
	}
	
	public Element getPhotoElement(String content, String nameField) {
		Document document = null;
		Element elImage = null;
		try {
			document = SAXReaderUtil.read(new StringReader(content)).clone();
		} catch (DocumentException e) {
			_log.error(e);
		}
		Element source = document.getRootElement();
		for (Element el : source.elements("dynamic-element")) {
			if (el.attribute("name").getStringValue().equals(nameField)) {
				elImage = el;
				break;
			}
		}
		return elImage;
	}
	
	public String setPhotoElement(String content, String nameField, Element photoelem) {
		Document document = null;
		String returnContent;
		try {
			document = SAXReaderUtil.read(new StringReader(content)).clone();
		} catch (DocumentException e) {
			_log.error(e);
		}
		Element source = document.getRootElement();
		Element elImage = null;
		for (Element el : source.elements("dynamic-element")) {
			if (el.attribute("name").getStringValue().equals(nameField)) {
				elImage = el;
				break;
			}
		}
		if (elImage != null) {
			
			Element eImage = SAXReaderUtil.createElement("dynamic-content");
			eImage.setName("dynamic-content");
			eImage.setText(photoelem.getText());
			eImage.addAttribute("language-id", "en_US");
			eImage.addAttribute("name", photoelem.getName());
			eImage.addAttribute("title", photoelem.attributeValue("title"));
			eImage.addAttribute("type", "journal");
			eImage.addAttribute("id", photoelem.attributeValue("id"));
			eImage.addAttribute("alt", "");
			elImage.add(eImage);
			returnContent = document.asXML();
		} else
			returnContent = "error: not exist name field " + nameField;
		String contentReturn = returnContent;
		return contentReturn;
	}
	
	public String addPhotoToContent(String content, String nameField, String nameFile, Long id) {
		Document document = null;
		String returnContent;
		try {
			document = SAXReaderUtil.read(new StringReader(content)).clone();
		} catch (DocumentException e) {
			_log.error(e);
		}
		Element source = document.getRootElement();
		Element elImage = null;
		for (Element el : source.elements("dynamic-element")) {
			if (el.attribute("name").getStringValue().equals(nameField)) {
				elImage = el;
				break;
			}
		}
		if (elImage != null) {
			
			Element eImage = SAXReaderUtil.createElement("dynamic-content");
			eImage.setName("dynamic-content");
			eImage.setText("/image/journal/article?img_id=" + Long.toString(id));
			eImage.addAttribute("language-id", "en_US");
			eImage.addAttribute("name", nameFile);
			eImage.addAttribute("title", nameFile);
			eImage.addAttribute("type", "journal");
			eImage.addAttribute("id", Long.toString(id));
			eImage.addAttribute("alt", "");
			elImage.add(eImage);
			returnContent = document.asXML();
		} else
			returnContent = "error: not exist name field " + nameField;
		
		return returnContent;
	}
}
