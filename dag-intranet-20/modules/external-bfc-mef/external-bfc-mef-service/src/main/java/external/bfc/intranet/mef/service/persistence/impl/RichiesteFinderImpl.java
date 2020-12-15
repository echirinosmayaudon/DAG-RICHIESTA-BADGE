package external.bfc.intranet.mef.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import java.util.ArrayList;
import java.util.List;

import external.bfc.intranet.mef.model.Richieste;
import external.bfc.intranet.mef.service.RichiesteLocalServiceUtil;
import external.bfc.intranet.mef.service.persistence.RichiesteFinder;

public class RichiesteFinderImpl extends RichiesteFinderBaseImpl implements RichiesteFinder {

	private static final Log _log = LogFactoryUtil.getLog(RichiesteFinderImpl.class);
	
	public List<Richieste> findByStati_Ufficio_Utenti(List<Long> lista_stati, List<String> ufficio, List<User> lista_utenti){
		
		List<Richieste> res_richieste=new ArrayList<>(0);
		 Session session = null;
		  try {
		        session = openSession();
		        DynamicQuery queryRichieste=RichiesteLocalServiceUtil.dynamicQuery();
		        
		        if(ufficio!=null && ufficio.size()>0){
		        	Disjunction disjunctionUff = RestrictionsFactoryUtil.disjunction();
		        	for(String uff:ufficio){
		        		Property propertyUfficio=PropertyFactoryUtil.forName("ufficio");
		        		disjunctionUff.add(propertyUfficio.eq(uff));		   				
		   		 }	        	
		       	 queryRichieste.add(disjunctionUff);	
		    	}
		    	if(lista_stati!= null && lista_stati.size()>0){
		   		 Disjunction disjunctionStato = RestrictionsFactoryUtil.disjunction();
		   		 for(long statoid:lista_stati){
		   				Property propertyStato=PropertyFactoryUtil.forName("idStatoAttuale");	
		   				disjunctionStato.add(propertyStato.eq(statoid));
		   				
		   		 }
		   		 queryRichieste.add(disjunctionStato);
		   	}
		
		    	if(lista_utenti!=null){
			  		 queryRichieste.add(PropertyFactoryUtil.forName("email").in(lista_utenti));
			    	}
			    	 res_richieste=RichiesteLocalServiceUtil.dynamicQuery(queryRichieste);
			        
	 }
   catch (Exception e) {
   	_log.warn(e);
   }
   finally {
   	
       closeSession(session);
}
  return res_richieste;
	
	}
	
}
