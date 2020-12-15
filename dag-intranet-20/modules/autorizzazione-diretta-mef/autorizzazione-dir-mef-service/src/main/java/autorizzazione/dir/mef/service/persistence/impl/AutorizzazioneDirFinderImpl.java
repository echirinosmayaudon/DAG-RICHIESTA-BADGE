
package autorizzazione.dir.mef.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import autorizzazione.dir.mef.service.persistence.impl.AutorizzazioneDirFinderBaseImpl;
import autorizzazione.dir.mef.service.persistence.AutorizzazioneDirFinder;

import java.util.ArrayList;
import java.util.List;

import autorizzazione.dir.mef.model.AutorizzazioneDir;
import autorizzazione.dir.mef.service.AutorizzazioneDirLocalServiceUtil;

public class AutorizzazioneDirFinderImpl extends AutorizzazioneDirFinderBaseImpl implements AutorizzazioneDirFinder {
	
	final Log _log = LogFactoryUtil.getLog(AutorizzazioneDirPersistenceImpl.class);
	
	public boolean isAuthorized(long idApplicazione, long mef, long dipartimento, long direzione, long ufficio, String codiceFiscale){
		
		boolean isAuthorized = false;
		
		Session session = null;
		List<AutorizzazioneDir> listaAutorizzazioni = new ArrayList<AutorizzazioneDir>();
		
	    try {
	        session = openSession();
	        DynamicQuery queryRiunione =
					DynamicQueryFactoryUtil.forClass(AutorizzazioneDir.class,getClassLoader());
	        
	        //Properties for Disjunction
	        Property propertyCodiceFiscale=PropertyFactoryUtil.forName("codice_fiscale");
	        Property propertyMef=PropertyFactoryUtil.forName("mef");
	        Property propertyDipartimento=PropertyFactoryUtil.forName("dipartimento");
	        Property propertyDirezione=PropertyFactoryUtil.forName("direzione");
	        Property propertyUfficio=PropertyFactoryUtil.forName("ufficio");
	       
	        Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
	        
	        if(idApplicazione != 0){
	        	queryRiunione.add(RestrictionsFactoryUtil.eq("id_applicazione", idApplicazione));
	        }
	        
	        //Populate Disjunction
	        if(codiceFiscale != null && !"".equals(codiceFiscale)){
				String codiceFiscalevalue = (new StringBuilder("%")).append(codiceFiscale).append("%").toString();
				disjunctionKey.add(propertyCodiceFiscale.like(codiceFiscalevalue));	
	        }
	        if(mef != 0){
	        	disjunctionKey.add(propertyMef.eq(mef));
	        }
	        if(dipartimento != 0){
	        	disjunctionKey.add(propertyDipartimento.eq(dipartimento));
	        }
	        if(direzione != 0){
	        	disjunctionKey.add(propertyDirezione.eq(direzione));
	        }
	        if(ufficio != 0){
	        	disjunctionKey.add(propertyUfficio.eq(ufficio));
	        }
	        queryRiunione.add(disjunctionKey);
	        
	        //Do Query
	        listaAutorizzazioni =  AutorizzazioneDirLocalServiceUtil.dynamicQuery(queryRiunione);
	        
	    }catch (Exception e) {
	    	_log.debug("Errore durante l'apertura della sessione", e);
	    }
	    finally {
	    	
	        closeSession(session);
	    }
		
	    if(listaAutorizzazioni != null && listaAutorizzazioni.size() > 0){
	    	isAuthorized = true;
	    }
	    
	    //Check for negations exceptions
		for(AutorizzazioneDir autorizzazioneDiretta : listaAutorizzazioni){
			if(autorizzazioneDiretta.getNega() == true){
				isAuthorized = false;
				break;
			}
		}
		
		return isAuthorized;
	}
	
	public boolean isNewsVisible(long mef, long direzione, long dipartimento, long ufficio, String codiceFiscale, String tag){
		boolean result = Boolean.TRUE;
		
		Session session = null;
		List<AutorizzazioneDir> listaAutorizzazioni = new ArrayList<AutorizzazioneDir>();
		
	    try {
	        session = openSession();
	        DynamicQuery queryApplicazione =
					DynamicQueryFactoryUtil.forClass(AutorizzazioneDir.class,getClassLoader());
	        Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
	        
	        //Properties for Disjunction
	        Property propertyMef=PropertyFactoryUtil.forName("mef");
	        Property propertyDirezione=PropertyFactoryUtil.forName("direzione");
	        Property propertyDipartimento=PropertyFactoryUtil.forName("dipartimento");
	        Property propertyUfficio=PropertyFactoryUtil.forName("ufficio");
	        Property propertyCodiceFiscale=PropertyFactoryUtil.forName("codice_fiscale");
	        
	        if(tag != null && !"".equals(tag)){
	        	
	        	queryApplicazione.add(RestrictionsFactoryUtil.ilike("tag", tag));
	        
		        //Populate Disjunction
		        if(mef != 0){
		        	disjunctionKey.add(propertyMef.eq(mef));
		        }
		        if(direzione != 0){
		        	disjunctionKey.add(propertyDirezione.eq(direzione));
		        }
		        if(dipartimento != 0){
		        	disjunctionKey.add(propertyDipartimento.eq(dipartimento));
		        }
		        if(ufficio != 0){
		        	disjunctionKey.add(propertyUfficio.eq(ufficio));
		        }
		        if(codiceFiscale != null && !"".equals(codiceFiscale)){
					String codiceFiscalevalue = (new StringBuilder("%")).append(codiceFiscale).append("%").toString();
					disjunctionKey.add(propertyCodiceFiscale.like(codiceFiscalevalue));	
		        }
		        queryApplicazione.add(disjunctionKey);
		        
		        //Do Query
		        listaAutorizzazioni =  AutorizzazioneDirLocalServiceUtil.dynamicQuery(queryApplicazione);
	        }
	        
	        
	    }catch (Exception e) {
	    	_log.debug("Errore durante l'apertura della sessione", e);
	    }
	    finally {
	    	
	        closeSession(session);
	    }
	    
	    //Check Negazione
	    if(listaAutorizzazioni != null && listaAutorizzazioni.size() > 0){
	    	for(AutorizzazioneDir autorizzazioneDiretta : listaAutorizzazioni){
	    		if(autorizzazioneDiretta.getNega() == true){
	    			result = false;
	    			break;
	    		}
	    	}
	    }
		
	    return result;
	}
	
}