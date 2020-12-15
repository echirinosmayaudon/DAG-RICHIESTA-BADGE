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

import external.bfc.intranet.mef.model.RichiesteInfo;
import external.bfc.intranet.mef.service.RichiesteInfoLocalServiceUtil;
import external.bfc.intranet.mef.service.persistence.RichiesteInfoFinder;

public class RichiesteInfoFinderImpl extends RichiesteFinderBaseImpl implements RichiesteInfoFinder {

	private static final Log _log = LogFactoryUtil.getLog(RichiesteInfoFinderImpl.class);
	
	public List<RichiesteInfo> findByStati_Ufficio_Utenti(List<Long> lista_stati,List<String> ufficio, List<User> lista_utenti){
		List<RichiesteInfo> res_richiesteInfo=new ArrayList<RichiesteInfo>(0);
		 Session session = null;
		  try {
		        session = openSession();
		        DynamicQuery queryRichiesteInfo=RichiesteInfoLocalServiceUtil.dynamicQuery();
		        
		        if(ufficio!=null && ufficio.size()>0){
		        	Disjunction disjunctionUff = RestrictionsFactoryUtil.disjunction();
		        	for(String uff:ufficio){
		        		Property propertyUfficio=PropertyFactoryUtil.forName("ufficio");
		        		disjunctionUff.add(propertyUfficio.eq(uff));		   				
		   		 }	        	
		        	queryRichiesteInfo.add(disjunctionUff);	
		    	}
		    	if(lista_stati!= null && lista_stati.size()>0){
		   		 Disjunction disjunctionStato = RestrictionsFactoryUtil.disjunction();
		   		 for(long statoid:lista_stati){
		   				Property propertyStato=PropertyFactoryUtil.forName("idStatoAttuale");	
		   				disjunctionStato.add(propertyStato.eq(statoid));
		   				
		   		 }
		   		queryRichiesteInfo.add(disjunctionStato);
		   	}
		
		   	 
				 if(lista_utenti!=null ){
		    	queryRichiesteInfo.add(PropertyFactoryUtil.forName("email").in(lista_utenti));
		    	}
		  		res_richiesteInfo=RichiesteInfoLocalServiceUtil.dynamicQuery(queryRichiesteInfo);
			        
	 }
  catch (Exception e) {
	   _log.warn(e);
  }
  finally {
  	
      closeSession(session);
}
 return res_richiesteInfo;
		
	
	}
	
}
