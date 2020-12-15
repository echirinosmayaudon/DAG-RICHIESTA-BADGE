package external.bfc.intranet.mef.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import external.bfc.intranet.mef.model.SediBfc;
import external.bfc.intranet.mef.service.SediBfcLocalServiceUtil;
import external.bfc.intranet.mef.service.persistence.SediBfcFinder;

public class SediBfcFinderImpl extends SediBfcFinderBaseImpl implements SediBfcFinder{
	
	private static final Log _log = LogFactoryUtil.getLog(SediBfcFinderImpl.class);
	
	public List<SediBfc> findByIdOrg(long idOrg){
		
		List<SediBfc> res_sediBfc = new ArrayList<SediBfc>(0);
		
		Session session = null;
		 
		try {
			session = openSession();
	        DynamicQuery querySediBfc = SediBfcLocalServiceUtil.dynamicQuery();
	        
	        Property ufficio = PropertyFactoryUtil.forName("idOrg");	
	        querySediBfc.add(ufficio.eq(idOrg));
	        
	        res_sediBfc = SediBfcLocalServiceUtil.dynamicQuery(querySediBfc);
		        
			        
	 }
catch (Exception e) {
	   _log.warn(e);
}
finally {
	
   closeSession(session);
}
		
return res_sediBfc;
		
	
	}
	
}