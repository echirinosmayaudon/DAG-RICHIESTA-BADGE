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

import com.intranet.mef.central.util.UserAddressUtil;
import com.intranet.mef.job.siap.model.City;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
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
import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil;
import servizio.richieste.badge.mef.service.base.RichiestaBadgeLocalServiceBaseImpl;
import servizio.richieste.badge.mef.service.persistence.RichiestaBadgeFinder;

/**
 * The implementation of the richiesta badge local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.richieste.badge.mef.service.RichiestaBadgeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgeLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil
 */
@ProviderType
public class RichiestaBadgeLocalServiceImpl
	extends RichiestaBadgeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil} to access the richiesta badge local service.
	 */
	
final Log _log = LogFactoryUtil.getLog(RichiestaBadgeLocalServiceImpl.class);
	
	@Override
	public long insertRichiestaBadge(long id_richiesta, String screename_richiedente, long id_ufficio, String json_richiedente, boolean is_internal, 
			String nome_intestatario, String cognome_intestatario, String cf_intestatario, String luogonascita_intestatario, Date datanascita_intestatario, 
			long id_oggetto, String numero_badge, String uuid_foto, String uuid_modulosostituzione, String societa, String referente_societa, String progetto, 
			String json_richiesta_external, String array_sedi_abilitate, String motivazione, Date data_scadenza, String uuid_modulopdf, Date data_richiesta, 
			Date data_modifica, long id_stato, String utente_cambio_stato, String note, boolean is_last, long id_sede ) {
		
		RichiestaBadge richiestaBadge = richiestaBadgePersistence.create(-1);
	
		richiestaBadge.setScreename_richiedente(screename_richiedente);
		richiestaBadge.setId_ufficio(id_ufficio);
		richiestaBadge.setJson_richiedente(json_richiedente);
		richiestaBadge.setIs_internal(is_internal);
		richiestaBadge.setNome_intestatario(nome_intestatario);
		richiestaBadge.setCognome_intestatario(cognome_intestatario);
		richiestaBadge.setCf_intestatario(cf_intestatario);
		richiestaBadge.setLuogonascita_intestatario(luogonascita_intestatario);
		richiestaBadge.setDatanascita_intestatario(datanascita_intestatario);
		richiestaBadge.setId_oggetto(id_oggetto);
		richiestaBadge.setNumero_badge(numero_badge);
		richiestaBadge.setUuid_foto(uuid_foto);
		richiestaBadge.setUuid_modulosostituzione(uuid_modulosostituzione);
		richiestaBadge.setSocieta(societa);
		richiestaBadge.setReferente_societa(referente_societa);
		richiestaBadge.setProgetto(progetto);
		richiestaBadge.setJson_richiesta_external(json_richiesta_external);
		richiestaBadge.setArray_sedi_abilitate(array_sedi_abilitate);
		richiestaBadge.setMotivazione(motivazione);
		richiestaBadge.setData_scadenza(data_scadenza);
		richiestaBadge.setUuid_modulopdf(uuid_modulopdf);
		richiestaBadge.setData_richiesta(data_richiesta);
		richiestaBadge.setData_modifica(data_modifica);
		richiestaBadge.setId_stato(id_stato);
		richiestaBadge.setUtente_cambio_stato(utente_cambio_stato);
		richiestaBadge.setNote(note);
		richiestaBadge.setIs_last(is_last);
		richiestaBadge.setId_sedesiap(id_sede);
	
		try{
			richiestaBadgePersistence.updateImpl(richiestaBadge);
			richiestaBadge.setId_richiesta(richiestaBadge.getPrimaryKey());
			richiestaBadgePersistence.updateImpl(richiestaBadge); 
			 return richiestaBadge.getId_richiesta();
		} catch(Exception e){
			 _log.error(e);
			 return 0;
		}
	}
	
	 @Override
	 public long aggiornaRichiestaBadge(long id_richiesta, String
	 screename_richiedente, long id_ufficio, String json_richiedente, boolean
	 is_internal,
	 String nome_intestatario, String cognome_intestatario, String
	 cf_intestatario, String luogonascita_intestatario, Date
	 datanascita_intestatario,
	 long id_oggetto, String numero_badge, String uuid_foto, String
	 uuid_modulosostituzione, String societa, String referente_societa, String
	 progetto,
	 String json_richiesta_external, String array_sedi_abilitate, String
	 motivazione, Date data_scadenza, String uuid_modulopdf, Date
	 data_richiesta,
	 Date data_modifica, long id_stato, String utente_cambio_stato, String
	 note, boolean is_last, long id_sede ) {
	
	 RichiestaBadge richiesta_badge_precedente = null;
	 long id_richiesta_precedente  = 0L;
	 
	 try {
		 richiesta_badge_precedente = RichiestaBadgeLocalServiceUtil.getRichiestaBadge(id_richiesta);
		 richiesta_badge_precedente.setIs_last(false);
		 id_richiesta_precedente = richiesta_badge_precedente.getId_richiesta();
		 RichiestaBadgeLocalServiceUtil.updateRichiestaBadge(richiesta_badge_precedente);
	 } catch (Exception e) {
		 _log.error("Errore nel recupero della richiesta: " + e);
	 }
		 
	 RichiestaBadge richiestaBadge = richiestaBadgePersistence.create(-1);
	
	 richiestaBadge.setId_richiesta(id_richiesta_precedente);
	 richiestaBadge.setScreename_richiedente(screename_richiedente);
	 richiestaBadge.setId_ufficio(id_ufficio);
	 richiestaBadge.setJson_richiedente(json_richiedente);
	 richiestaBadge.setIs_internal(is_internal);
	 richiestaBadge.setNome_intestatario(nome_intestatario);
	 richiestaBadge.setCognome_intestatario(cognome_intestatario);
	 richiestaBadge.setCf_intestatario(cf_intestatario);
	 richiestaBadge.setLuogonascita_intestatario(luogonascita_intestatario);
	 richiestaBadge.setDatanascita_intestatario(datanascita_intestatario);
	 richiestaBadge.setId_oggetto(id_oggetto);
	 richiestaBadge.setNumero_badge(numero_badge);
	 richiestaBadge.setUuid_foto(uuid_foto);
	 richiestaBadge.setUuid_modulosostituzione(uuid_modulosostituzione);
	 richiestaBadge.setSocieta(societa);
	 richiestaBadge.setReferente_societa(referente_societa);
	 richiestaBadge.setProgetto(progetto);
	 richiestaBadge.setJson_richiesta_external(json_richiesta_external);
	 richiestaBadge.setArray_sedi_abilitate(array_sedi_abilitate);
	 richiestaBadge.setMotivazione(motivazione);
	 richiestaBadge.setData_scadenza(data_scadenza);
	 richiestaBadge.setUuid_modulopdf(uuid_modulopdf);
	 richiestaBadge.setData_richiesta(data_richiesta);
	 richiestaBadge.setData_modifica(data_modifica);
	 richiestaBadge.setId_stato(id_stato);
	 richiestaBadge.setUtente_cambio_stato(utente_cambio_stato);
	 richiestaBadge.setNote(note);
	 richiestaBadge.setIs_last(is_last);
	 richiestaBadge.setId_sedesiap(id_sede);
	
	 try{
	 richiestaBadgePersistence.updateImpl(richiestaBadge);
	 // richiestaBadge.setId_richiesta(richiestaBadge.getPrimaryKey());
	 return richiestaBadge.getId_pk();
	 } catch(Exception e){
	 _log.error(e);
	 return 0;
	 }
	 }
	
	@Override
	public List<RichiestaBadge> getBadgeRichiesteByRichiedente (String screename_richiedente, boolean is_last){
		return this.richiestaBadgePersistence.findByRichiedente(screename_richiedente, is_last);
	}
	
	@Override
	public List<RichiestaBadge> getBadgeRichiesteByRuolo (Date data_modifica,
			boolean is_last, boolean is_internal, long id_stato){
		return this.richiestaBadgePersistence.findByRuolo(is_last, is_internal, id_stato);
	}
	
	@Override
	public List<RichiestaBadge> getBadgeRichiesteByRuoloSede (Date data_modifica,
			boolean is_last, boolean is_internal, long id_stato, long id_sedesiap){
		return this.richiestaBadgePersistence.findByRuoloSede(is_last, is_internal, id_stato,id_sedesiap);
	}
	
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
			    
			    //Utente appartenente all'ufficio terzo della direzione del personale
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
			    	//Lista utenti per cui l'utente richiedente e dirigente
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
	public List<RichiestaBadge> getRichiestaBadgeByFilters(String cogn_intest, String nome_intest, String cf_intest, String societa, String ref_societa, String motivazione_rich, String progetto, String screenName, List<Long> lista_idUffici, boolean is_last, List<Long> lista_sedi, String is_internal,List<Long> lista_stati){
		    return richiestaBadgeFinder.getRichiestaBadgeByFilters(cogn_intest, nome_intest, cf_intest, societa, ref_societa, motivazione_rich, progetto, screenName, lista_idUffici, is_last, lista_sedi, is_internal, lista_stati);
		       
		}
	
	@Override
	public List<RichiestaBadge> findRichiestaByDipartimentoStato(String dipartimento, List<Long> lista_IdStato ){
		    return richiestaBadgeFinder.findRichiestaByDipartimentoStato(dipartimento, lista_IdStato);
		       
		}
	
	
	@Override
	public List<RichiestaBadge> findRichiestaByDataRuoloSede(Date dataStart, Date dataEnd, boolean is_last, boolean is_internal, long id_stato, long id_sedesiap){
		    return richiestaBadgeFinder.findRichiestaByDataRuoloSede(dataStart, dataEnd, is_last, is_internal, id_stato, id_sedesiap);
		       
		}
	
	@Override
	public List<RichiestaBadge> findRichiesteInScadenza(Date data_begin, Date data_end, boolean is_last, long id_stato, String screen_name_richiedente, List<Long> id_uffici_competenza_list){	
		return richiestaBadgeFinder.findRichiesteInScadenza(data_begin, data_end, is_last, id_stato, screen_name_richiedente, id_uffici_competenza_list);
	}
	
	@Override
	public List<Object[]> findNumbersRichiestaByDataRuoloSedeforIdOggetto(Date dataStart, Date dataEnd, boolean is_last, boolean is_internal, long id_stato, long id_sedesiap  ){
		return richiestaBadgeFinder.findNumbersRichiestaByDataRuoloSedeforIdOggetto(dataStart, dataEnd, is_last, is_internal, id_stato, id_sedesiap);
	}
	
	@Override
	public List<RichiestaBadge> findRichiesteByIdRichiesta(long id_richiesta){	
		return richiestaBadgePersistence.findByIdRichiesta(id_richiesta);
	}

	
}