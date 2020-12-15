package com.mef.intranet.rubrica.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mef.intranet.rubrica.model.SearchData;
import com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil;
import com.mef.intranet.rubrica.service.persistence.SearchDataFinder;

import java.util.ArrayList;
import java.util.List;

public class SearchDataFinderImpl extends SearchDataFinderBaseImpl implements SearchDataFinder {

	final Log _log = LogFactoryUtil.getLog(SearchDataFinderImpl.class);  
		 

	public List<SearchData> getLastResult(int resultsNumber,String screenNameUser){
		List<SearchData> lista_res=new ArrayList<SearchData>();
		 Session session = null;
		  try {
			  
		        session = openSession();
		        DynamicQuery queryResearch =
				DynamicQueryFactoryUtil.forClass(SearchData.class,getClassLoader());
		        queryResearch.add(PropertyFactoryUtil.forName("searchData").like("%"+screenNameUser.toLowerCase()+"%"));
		        queryResearch.addOrder(OrderFactoryUtil.desc("createDate"));
		        queryResearch.setLimit(0, resultsNumber);
		       lista_res=SearchDataLocalServiceUtil.dynamicQuery(queryResearch);
		      
		  }
		  catch (Exception e) {
			  _log.warn(e);
		    }
		    finally {
		    	
		        closeSession(session);
	}
		  return lista_res;	 
		
	}

}
