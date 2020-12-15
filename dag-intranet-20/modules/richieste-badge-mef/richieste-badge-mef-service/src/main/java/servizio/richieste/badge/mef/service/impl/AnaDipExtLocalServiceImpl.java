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

package servizio.richieste.badge.mef.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.richieste.badge.mef.model.AnaDipExt;
import servizio.richieste.badge.mef.service.AnaDipExtLocalServiceUtil;
import servizio.richieste.badge.mef.service.base.AnaDipExtLocalServiceBaseImpl;

/**
 * The implementation of the ana dip ext local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.richieste.badge.mef.service.AnaDipExtLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnaDipExtLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.AnaDipExtLocalServiceUtil
 */
@ProviderType
public class AnaDipExtLocalServiceImpl extends AnaDipExtLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.richieste.badge.mef.service.AnaDipExtLocalServiceUtil} to access the ana dip ext local service.
	 */
	
	final Log _log = LogFactoryUtil.getLog(AnaDipExtLocalServiceImpl.class);
	
	@Override
	public boolean insertAnaDipExt(String nome_dip_ext, String cognome_dip_ext, String cf_dip_ext, String luogonascita_dip_ext, Date datanascita_dip_ext) {
		
		AnaDipExt anaDipExt = anaDipExtPersistence.create(-1);
		anaDipExt.setNome_dip_ext(nome_dip_ext);
		anaDipExt.setCognome_dip_ext(cognome_dip_ext);
		anaDipExt.setCf_dip_ext(cf_dip_ext);
		anaDipExt.setLuogonascita_dip_ext(luogonascita_dip_ext);
		anaDipExt.setDatanascita_dip_ext(datanascita_dip_ext);
	
		try{
			anaDipExtPersistence.updateImpl(anaDipExt);
			 return true;
		} catch(Exception e){
			 _log.error(e);
			 return false;
		}
	}
	
	@Override
	public JSONArray findSuggestionsAnaDipExtBySurname(String cognome){
		
		JSONArray jsonArray = null;
		StringBuilder jsonStringBuilder = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		jsonStringBuilder.append("{"+"\"suggestionsext\""+":[");
		
	    try {
	    	
	    	List<AnaDipExt> allUsersExt = AnaDipExtLocalServiceUtil.getAnaDipExts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	    	
	    	List<AnaDipExt> allUsersExtPost = new ArrayList<AnaDipExt>(0);
	    	
	    	
			if (!allUsersExt.isEmpty()) {
		    	for(AnaDipExt userExt : allUsersExt){
		    		if(userExt.getCognome_dip_ext().toUpperCase().contains(cognome.toUpperCase())){
		    			allUsersExtPost.add(userExt);
		    		}
		    	}
			}
			   

	    	int index = 0;
	    	if (!allUsersExtPost.isEmpty()) {
		    	for(AnaDipExt userExt : allUsersExtPost){
					String jsonString = "{\"" + userExt.getCf_dip_ext() + "\"" + ":" + "{" + "\"nome\"" + ":" + "\"" + userExt.getNome_dip_ext() + "\"" + "," + "\"cognome\"" + ":" + "\"" + userExt.getCognome_dip_ext() + "\"" + "," + "\"luogoNascita\"" + ":" + "\"" + userExt.getLuogonascita_dip_ext() + "\"" + ","+ "\"dataNascita\"" + ":" + "\"" + sdf.format(userExt.getDatanascita_dip_ext()) + "\"" + "," + "\"codiceFiscale\"" + ":" + "\"" + userExt.getCf_dip_ext() + "\"" + "}" + "}";
		    		jsonStringBuilder.append(jsonString);
		    		index++;
		    		if(index < allUsersExtPost.size()){
		    			jsonStringBuilder.append(",");
		    		}
		    	}
	    	}
	    	
		    jsonStringBuilder.append("]}");
		    JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStringBuilder.toString());
		    jsonArray = jsonObject.getJSONArray("suggestionsext");	
		    
	    } catch (Exception e) {
	    	
	    	_log.debug("Errore durante l'apertura della sessione o nel recupero utente", e);
	    	jsonArray = JSONFactoryUtil.createJSONArray();
	    	
	    }
		
		return jsonArray;
	}
	
	@Override
	public List<AnaDipExt> findUtentiByCodiceFiscaleEsterno(String cf_dip_ext){
		    return anaDipExtPersistence.findByCodiceFiscaleEsterno(cf_dip_ext);
		       
		}
	
}