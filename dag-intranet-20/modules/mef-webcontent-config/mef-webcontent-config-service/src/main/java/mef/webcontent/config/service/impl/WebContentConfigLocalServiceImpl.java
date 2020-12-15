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

package mef.webcontent.config.service.impl;

import aQute.bnd.annotation.ProviderType;
import mef.webcontent.config.model.WebContentConfig;
import mef.webcontent.config.service.base.WebContentConfigLocalServiceBaseImpl;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
/**
 * The implementation of the web content config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link mef.webcontent.config.service.WebContentConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebContentConfigLocalServiceBaseImpl
 * @see mef.webcontent.config.service.WebContentConfigLocalServiceUtil
 */
@ProviderType
public class WebContentConfigLocalServiceImpl
	extends WebContentConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link mef.webcontent.config.service.WebContentConfigLocalServiceUtil} to access the web content config local service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(WebContentConfigLocalServiceImpl.class);
	//web content configurator
	@Override
	public String webContentConfigurator(long groupid, String id, String html) {

		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticle(groupid, id);

			article.setContent(formatContent(html));
			JournalArticleLocalServiceUtil.updateJournalArticle(article);
			return "OK";
		} catch (PortalException e) {
			_log.info(e);
			return "KO";
		}

//		try {
//			if(webContentConfigPersistence.fetchByPrimaryKey(Long.parseLong(id))==null){
//				WebContentConfig webcontentrecord = webContentConfigPersistence.create(Long.parseLong(id));
//				webcontentrecord.setHtml(html);
//				webContentConfigPersistence.updateImpl(webcontentrecord);
//				return "{esito:\"OK\"}";
//			}else{
//				WebContentConfig webcontentrecord = webContentConfigPersistence.findByPrimaryKey(Long.parseLong(id));
//				webcontentrecord.setHtml(html);
//				webContentConfigPersistence.updateImpl(webcontentrecord);
//				return "{esito:\"OK\"}";
//			}
//			
//		} catch (Exception e1) {
//			_log.info(e1);
//			return "{esito:\"update failed\"}";
//		}
	

	}
	
	
	private String formatContent(String html) {
				//<root>
		        Element rootElement = SAXReaderUtil.createElement("root");
		        //creo i linguaggi nella root	        
		        //per i test sostituire it_IT con en_US
		        rootElement.addAttribute("available-locales","it_IT");
		        rootElement.addAttribute("default-locale","it_IT");
		        //creo il doc e inserisco la root
		        Document contentDoc = SAXReaderUtil.createDocument(rootElement);
		        // creo il contenuto
		        Element dynamiccontentElement = SAXReaderUtil.createElement("dynamic-element");
		        dynamiccontentElement.addAttribute("name", "content");
		        dynamiccontentElement.addAttribute("type", "text_area");
		        dynamiccontentElement.addAttribute("index-type", "text");	        
		        Element contentElement = SAXReaderUtil.createElement("dynamic-content");
		        contentElement.addAttribute("language-id", "it_IT");
		        //inserisco l'html nel content element
			    contentElement.addText(html); 
		        dynamiccontentElement.add(contentElement);	        
		        //inserisco il contenuto dentro root
		        rootElement.add(dynamiccontentElement);
		       //converto da documento a stringa
		       return contentDoc.asXML();
		   }
	
	

	
}