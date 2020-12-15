package com.intranet.mef.util;

import com.intranet.mef.bean.Richiedente;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import service.intranet.mef.model.LogisticaValutazione;
import service.intranet.mef.service.LogisticaValutazioneLocalServiceUtil;
import service.intranet.mef.model.LogisticaStato;
import service.intranet.mef.service.LogisticaStatoLocalServiceUtil;
import service.intranet.mef.service.LogisticaServizioLocalServiceUtil;
import service.intranet.mef.model.LogisticaServizio;

public class ServiziLogisticiDataUtil {

	public static boolean createTablesLogistica(){
		List<LogisticaValutazione> tableValutazione = (List<LogisticaValutazione>)createListaLogisticaValutazione();
		List<LogisticaStato> tableStato = (List<LogisticaStato>)createListaLogisticaStato();
		List<LogisticaServizio> tableServizio = (List<LogisticaServizio>)createListaLogisticaServizio();
		
		return tableServizio!=null && !tableServizio.isEmpty() && tableStato!=null && !tableStato.isEmpty() && tableValutazione!=null && !tableValutazione.isEmpty();
		
	}
	
	public static List<LogisticaValutazione> createListaLogisticaValutazione(){
		List<LogisticaValutazione> logisticasDB = LogisticaValutazioneLocalServiceUtil.getLogisticaValutaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(logisticasDB==null || logisticasDB.isEmpty()){
			List<String> logisticaValutazione = new ArrayList<>();
			logisticaValutazione.add("buono");
			logisticaValutazione.add("sufficiente");
			logisticaValutazione.add("scarso");
			for(String descrizione: logisticaValutazione){
				LogisticaValutazione logisticaValutazioneDB = LogisticaValutazioneLocalServiceUtil.createLogisticaValutazione(CounterLocalServiceUtil.increment(LogisticaValutazione.class.getName()));
				logisticaValutazioneDB.setDescrizione(descrizione);
				LogisticaValutazioneLocalServiceUtil.addLogisticaValutazione(logisticaValutazioneDB);
			}
			
			logisticasDB =LogisticaValutazioneLocalServiceUtil.getLogisticaValutaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		}
		
		return logisticasDB;
	}
	
	
	public static List<LogisticaStato> createListaLogisticaStato(){
		List<LogisticaStato> logisticasDB = LogisticaStatoLocalServiceUtil.getLogisticaStatos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(logisticasDB==null || logisticasDB.isEmpty()){
			List<String> logistica = new ArrayList<>();
			logistica.add("nuova");
			logistica.add("accettata");
			logistica.add("rifiutata");
			logistica.add("evasa");
			logistica.add("non evasa");
			for(String descrizione: logistica){
				LogisticaStato logisticaDB = LogisticaStatoLocalServiceUtil.createLogisticaStato(CounterLocalServiceUtil.increment(LogisticaStato.class.getName()));
				logisticaDB.setDescrizione(descrizione);
				LogisticaStatoLocalServiceUtil.addLogisticaStato(logisticaDB);
			}
			
			logisticasDB =LogisticaStatoLocalServiceUtil.getLogisticaStatos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		}
		
		return logisticasDB;
	}
	
	
	
	public static List<LogisticaServizio> createListaLogisticaServizio(){
		List<LogisticaServizio> logisticasDB = LogisticaServizioLocalServiceUtil.getLogisticaServizios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(logisticasDB==null || logisticasDB.isEmpty()){
			List<String> logistica = new ArrayList<>();
			logistica.add("facchinaggio");
			logistica.add("riparazione");
			logistica.add("pulizie straordinarie");
			logistica.add("ristrutturazione ambienti");
			for(String descrizione: logistica){
				LogisticaServizio logisticaDB = LogisticaServizioLocalServiceUtil.createLogisticaServizio(CounterLocalServiceUtil.increment(LogisticaServizio.class.getName()));
				logisticaDB.setDescrizione(descrizione);
				LogisticaServizioLocalServiceUtil.addLogisticaServizio(logisticaDB);
			}
			
			logisticasDB =LogisticaServizioLocalServiceUtil.getLogisticaServizios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		}
		
		return logisticasDB;
	}
	

	public  Richiedente richiedenteJsontoData(String json) throws JSONException{	
		Richiedente richiedente = new Richiedente();
		JSONObject obj = JSONFactoryUtil.createJSONObject(json);
		richiedente.setCognome(obj.getString("cognome"));
		richiedente.setEmailDirigente(obj.getString("emailDirigente"));
		richiedente.setNome(obj.getString("nome"));
		richiedente.setPalazzina(obj.getString("palazzina"));
		richiedente.setPiano(obj.getString("piano"));
		richiedente.setScala(obj.getString("scala"));
		richiedente.setStanza(obj.getString("stanza"));
		richiedente.setTelefono(obj.getString("telefono"));
		richiedente.setUbicazione(obj.getString("ubicazione"));
		richiedente.setUfficioRichiedente(obj.getString("ufficioRichiedente"));
		richiedente.setOrganizzazione(obj.getString("organizzazione"));
		richiedente.setEmailRichiedente(obj.getString("emailRichiedente"));
        return richiedente;

	}
	
	public   List<String> richiestaJsontoData(String json) throws JSONException{	
		List<String> listaServizi= new ArrayList<String>(0);
		JSONObject obj = JSONFactoryUtil.createJSONObject(json);
		JSONArray arrayHardware = JSONFactoryUtil.createJSONArray(obj.getString("richieste"));
		for (int i = 0; i < arrayHardware.length(); i++) {
		
			String servizio = arrayHardware.getJSONObject(i).getString("servizio");
		
			listaServizi.add(servizio);    
		}

	           return listaServizi;

	}
}
