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

package service.intranet.mef.service.impl;

import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.BadgeRichieste;
import service.intranet.mef.service.base.BadgeRichiesteLocalServiceBaseImpl;
import com.intranet.mef.central.util.UserAddressUtil;
import com.intranet.mef.job.siap.model.City;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;

/**
 * The implementation of the badge richieste local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.BadgeRichiesteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BadgeRichiesteLocalServiceBaseImpl
 * @see service.intranet.mef.service.BadgeRichiesteLocalServiceUtil
 */
@ProviderType
public class BadgeRichiesteLocalServiceImpl
	extends BadgeRichiesteLocalServiceBaseImpl {
	
	final Log _log = LogFactoryUtil.getLog(BadgeRichiesteLocalServiceImpl.class);
	
	@Override
	public JSONArray findSuggestionsBySurname(String cognome, String idOrgChart, Long userId){
		JSONArray jsonArray = null;
		User user = null;
		boolean isTerzoUfficioDirPersonale = false;
		StringBuilder jsonStringBuilder = new StringBuilder();
		List<User> listUserOfSameOffice = new ArrayList<User>();
		List<User> listUserHaveDirector = new ArrayList<User>(); 
		List<User> usersMerge = new ArrayList<User>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		jsonStringBuilder.append("{"+"\"suggestions\""+":[");
		
	    try {
	    	user = UserLocalServiceUtil.getUser(userId);
	    	if(user != null){
		    	long companyId = user.getCompanyId();
			    long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());
			    List<User> allUsers = new ArrayList<>();
			    String jsonString;
			    
			    //Utente appartenente all'ufficio 3 della direzione del personale
			    if(idOrgChart != null && ("24996").equals(idOrgChart)){
			    	isTerzoUfficioDirPersonale = true;
			    	allUsers = UserLocalServiceUtil.getUsers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			    	for(User utente : allUsers){
			    		if(!utente.getLastName().toUpperCase().contains(cognome.toUpperCase())){
			    			allUsers.remove(utente);
			    		}
			    	}
			    }
			    
			    if(!isTerzoUfficioDirPersonale){
				    //Lista utenti appartenenti allo stesso ufficio
			    	java.util.List<com.liferay.expando.kernel.model.ExpandoValue> expandoValuesSameOffice = 
			    			com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil.getColumnValues
			    			(companyId, classNameId,ExpandoTableConstants.DEFAULT_TABLE_NAME, "idOrgChart", idOrgChart,com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, 
			    			com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			    	User userSameOffice = null;
			    	for(ExpandoValue ev : expandoValuesSameOffice){
			    		userSameOffice = UserLocalServiceUtil.getUser(ev.getClassPK());
			    		if(userSameOffice != null){
			    			if(userSameOffice.getLastName().toUpperCase().contains(cognome.toUpperCase())){
			    				listUserOfSameOffice.add(userSameOffice);
			    			}
			    		}
			    	}
			    	usersMerge.addAll(listUserOfSameOffice);
			    	//Lista utenti per cui l'utente richiedente dirigente
			    	List<Role> listaRuoliUtente = user.getRoles();
			    	for(Role ruolo : listaRuoliUtente){
			    		if(("dirigente").equalsIgnoreCase(ruolo.getName())){
			    			User userHaveDirector; 
					    	for(ExpandoValue expandoValue : expandoValuesSameOffice){
					    		userHaveDirector = UserLocalServiceUtil.getUser(expandoValue.getClassPK());
					    		if(userHaveDirector != null){
					    			if(userHaveDirector.getLastName().toUpperCase().contains(cognome)){
					    				listUserHaveDirector.add(userSameOffice);
					    			}
					    		}
					    	}
					    	usersMerge.addAll(listUserHaveDirector);
			    			break;
			    		}
			    	}
			    	int index = 0;
			    	for(User usr : usersMerge){
			    		City cittaNatale;
			    		String luogoNascita = "";
			    		List<Address> userAddresses = usr.getAddresses();
			    		Long businessAddrTypeId = UserAddressUtil.getAddressTypeIdByName(UserAddressUtil.BIRTH);
			    		for (Address address: userAddresses){
			    			if (address.getTypeId() == businessAddrTypeId){
			    				if (address.getCity()!= null && !("").equals(address.getCity())){
			    					   String codiceComune = address.getCity();
			    					   try{
			    						   cittaNatale = CityLocalServiceUtil.getCity(codiceComune);
			    						   luogoNascita = cittaNatale.getName();
			    					   }catch(PortalException e){
			    						   _log.debug("Errore nel recupero della citta natale", e);
			    					   }
			    					   
			    				   }
			    			}
			    		}
						jsonString = "{\"" + user.getScreenName() + "\"" + ":" + "{" + "\"nome\"" + ":" + "\"" + usr.getFirstName() + "\"" + "," + "\"cognome\"" + ":" + "\"" + usr.getLastName() + "\"" + "," + "\"luogoNascita\"" + ":" + "\"" + luogoNascita + "\"" + ","+ "\"dataNascita\"" + ":" + "\"" + sdf.format(usr.getBirthday()) + "\"" + "," + "\"codiceFisale\"" + ":" + "\"" + usr.getScreenName() + "\"" + "}" + "}";
			    		jsonStringBuilder.append(jsonString);
			    		index++;
			    		if(index < usersMerge.size()){
			    			jsonStringBuilder.append(",");
			    		}
			    	}
			    }else{
			    	int index = 0;
			    	for(User usr : allUsers){
			    		String luogoNascita = "";
			    		City cittaNatale;
			    		List<Address> userAddresses = usr.getAddresses();
			    		Long businessAddrTypeId = UserAddressUtil.getAddressTypeIdByName(UserAddressUtil.BIRTH);
			    		for (Address address: userAddresses){
			    			if (address.getTypeId() == businessAddrTypeId){
			    				if (address.getCity()!= null && !("").equals(address.getCity())){
			    					   String codiceComune = address.getCity();
			    					   try{
			    						   cittaNatale = CityLocalServiceUtil.getCity(codiceComune);
			    						   luogoNascita = cittaNatale.getName();
			    					   }catch(PortalException e){
			    						   _log.debug("Errore nel recupero della citta natale", e);
			    					   }
			    					   
			    				   }
			    			}
			    		}
			    		jsonString = "\"" + user.getScreenName() + "\"" + ":" + "{" + "\"nome\"" + ":" + "\"" + usr.getFirstName() + "\"" + "," + "\"cognome\"" + ":" + "\"" + usr.getLastName() + "\"" + "," + "\"luogoNascita\"" + ":" + "\"" + luogoNascita + "\"" + ","+ "\"dataNascita\"" + ":" + "\"" + sdf.format(usr.getBirthday()) + "\"" + "," + "\"codiceFisale\"" + ":" + "\"" + usr.getScreenName() + "\"" + "}" + "}";
			    		jsonStringBuilder.append(jsonString);
			    		index++;
			    		if(index < allUsers.size()){
			    			jsonStringBuilder.append(",");
			    		}
			    	}
			    }
			    
			    jsonStringBuilder.append("]}");
			    JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStringBuilder.toString());
			    jsonArray = jsonObject.getJSONArray("suggestions");	
	    	}
	    }catch (Exception e) {
	    	_log.debug("Errore durante l'apertura della sessione o nel recupero utente", e);
	    	jsonArray = JSONFactoryUtil.createJSONArray();
	    }
		
		return jsonArray;
	}
	
	
	@Override
	public boolean insertRichiestaBadge(String utente,String dettaglio_richiedente,String nome, String cognome, String luogo_nascita, Date data_nascita, String codice_fiscale, String numerobadge, String allegatoUuid, String operazione, Date data_richiesta, String procedura, Date disattivazione ){
		BadgeRichieste richiestaBadge=badgeRichiestePersistence.create(-1);
		richiestaBadge.setUtente(utente);
		richiestaBadge.setDettaglio_richiedente(dettaglio_richiedente);
		richiestaBadge.setNome(nome);
		richiestaBadge.setCognome(cognome);
		richiestaBadge.setLuogo_nascita(luogo_nascita);
		richiestaBadge.setData_nascita(data_nascita);
		richiestaBadge.setCodice_fiscale(codice_fiscale);
		richiestaBadge.setNumerobadge(numerobadge);
		richiestaBadge.setAllegatoUuid(allegatoUuid);
		richiestaBadge.setOperazione(operazione);
		richiestaBadge.setData_richiesta(data_richiesta);
		richiestaBadge.setProcedura(procedura);
		richiestaBadge.setDisattivazione(disattivazione);
		 try{
		 badgeRichiestePersistence.updateImpl(richiestaBadge);
			 return true;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return false;
		 }
	}
	
	
}