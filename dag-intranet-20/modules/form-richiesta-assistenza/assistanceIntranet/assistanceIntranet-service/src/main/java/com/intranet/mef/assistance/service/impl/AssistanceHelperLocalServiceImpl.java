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

package com.intranet.mef.assistance.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.intranet.mef.assistance.service.base.AssistanceHelperLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the assistance helper local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.assistance.service.AssistanceHelperLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssistanceHelperLocalServiceBaseImpl
 * @see com.intranet.mef.assistance.service.AssistanceHelperLocalServiceUtil
 */
@ProviderType
public class AssistanceHelperLocalServiceImpl
extends AssistanceHelperLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.assistance.service.AssistanceHelperLocalServiceUtil} to access the assistance helper local service.
	 */

	public void uploadTripleteFaq(File csvTriplete, File csvFaq){

		ambitoLocalService.removeAll();
		servizioLocalService.removeAll();
		areaLocalService.removeAll();
		topicLocalService.removeAll();
		problemLocalService.removeAll();
		faqLocalService.removeAll();

		//gestione dei file
		//FAQ
		setMapFaq(csvFaq);
		//Fine Faq

		//Triplette
		setMapTriplette(csvTriplete);
		//Fine Triplette
	}

	protected void setMapFaq(File csvFaq){

		String line = "";
		String cvsSplitBy = ";";
		BufferedReader br = null;
		FileInputStream fIS = null;
		InputStreamReader iSR = null;

		try {

			fIS = new FileInputStream(csvFaq);
			iSR = new InputStreamReader(fIS, "UTF-8");
			br = new BufferedReader(iSR);

			int i = 0;		

			while ((line = br.readLine()) != null) {
				String[] element = line.split(cvsSplitBy);
				if (i > 0){
					faqLocalService.add(element[0], element[1], element[2], 
						element[3]);
				}
				i++;
			}

		}catch(Exception e){
			_log.error(e);
		}finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					if (_log.isErrorEnabled()){
						_log.error(e);
					}
				}
			}

			if (iSR != null) {
				try {
					iSR.close();
				} catch (IOException e) {
					if (_log.isErrorEnabled()){
						_log.error(e);
					}
				}
			}

			if (fIS != null) {
				try {
					fIS.close();
				} catch (IOException e) {
					if (_log.isErrorEnabled()){
						_log.error(e);
					}
				}
			}
		}

	}

	protected void setMapTriplette(File csvTriplete){

		Map<String, String> ambitoCsv = new HashMap<>();
		Map<String, String> servizioCsv = new HashMap<>();
		Map<String, String> areaCsv = new HashMap<>();
		Map<String, String> topicCsv = new HashMap<>();
		Map<String, String> problemCsv = new HashMap<>();

		BufferedReader br = null;
		FileInputStream fIS = null;
		InputStreamReader iSR = null;
		String mapSplitBy = "###";

		try {

			fIS = new FileInputStream(csvTriplete);
			iSR = new InputStreamReader(fIS, "UTF-8");
			br = new BufferedReader(iSR);

			int i = 0;		

			String line;
			while ((line = br.readLine()) != null) {
				String[] element = line.split(StringPool.SEMICOLON);
				if (i > 0){

					String keyAmbito = element[2];
					String keyAmbitoValue = element[1];
					ambitoCsv.put(keyAmbito, keyAmbitoValue);

					String keyService = element[4];
					String keyServiceValue = element[3] + mapSplitBy + keyAmbito +
						mapSplitBy + element[11];
					servizioCsv.put(keyService, keyServiceValue);

					String keyArea = element[6];
					String keyAreaValue = element[5] + mapSplitBy + keyService;
					areaCsv.put(keyArea, keyAreaValue);

					String keyTopic = element[8];
					String keyTopicValue = element[7] + mapSplitBy + keyArea;
					topicCsv.put(keyTopic,keyTopicValue);

					String keyProblem = element[10];
					String keyProblemValue = element[9] + mapSplitBy + keyTopic;
					problemCsv.put(keyProblem, keyProblemValue);

				}
				i++;
			}

		}catch(Exception e){
			_log.error(e);
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					if (_log.isErrorEnabled()){
						_log.error(e);
					}
				}
			}

			if (iSR != null) {
				try {
					iSR.close();
				} catch (IOException e) {
					if (_log.isErrorEnabled()){
						_log.error(e);
					}
				}
			}

			if (fIS != null) {
				try {
					fIS.close();
				} catch (IOException e) {
					if (_log.isErrorEnabled()){
						_log.error(e);
					}
				}
			}
		}

		Iterator<Map.Entry<String, String>> iteratorAmbito =
			ambitoCsv.entrySet().iterator();

		while (iteratorAmbito.hasNext()) {
			Map.Entry<String, String> entry = iteratorAmbito.next();
			String key = entry.getKey();
			String value = entry.getValue();  
			ambitoLocalService.add(key, value);
		}

		Iterator<Map.Entry<String, String>> iteratorServizio =
			servizioCsv.entrySet().iterator();

		while (iteratorServizio.hasNext()) {
			Map.Entry<String, String> entry = iteratorServizio.next();
			String key = entry.getKey();
			String value = entry.getValue();
			String[] element = value.split(mapSplitBy);	 
			servizioLocalService.add(key, element[0], element[1], element[2]);
		}

		Iterator<Map.Entry<String, String>> iteratorArea =
			areaCsv.entrySet().iterator();

		while (iteratorArea.hasNext()) {
			Map.Entry<String, String> entry = iteratorArea.next();
			String key = entry.getKey();
			String value = entry.getValue();
			String[] element = value.split(mapSplitBy);	 
			areaLocalService.add(key, element[0], element[1]);
		}

		Iterator<Map.Entry<String, String>> iteratorTopic =
			topicCsv.entrySet().iterator();

		while (iteratorTopic.hasNext()) {
			Map.Entry<String, String> entry = iteratorTopic.next();
			String key = entry.getKey();
			String value = entry.getValue();
			String[] element = value.split(mapSplitBy);	 
			topicLocalService.add(key, element[0], element[1]);
		}

		Iterator<Map.Entry<String, String>> iteratorProblem =
			problemCsv.entrySet().iterator();

		while (iteratorProblem.hasNext()) {
			Map.Entry<String, String> entry = iteratorProblem.next();
			String key = entry.getKey();
			String value = entry.getValue();
			String[] element = value.split(mapSplitBy);	 
			problemLocalService.add(key, element[0], element[1]);
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(
		AssistanceHelperLocalServiceImpl.class);

}