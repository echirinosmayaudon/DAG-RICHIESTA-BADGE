package com.intranet.mef.gestione.riunioni.service.persistence.impl;

import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.model.Riunione;
import com.intranet.mef.gestione.riunioni.model.StatoRiunione;
import com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.persistence.RiunioneFinder;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RiunioneFinderImpl extends RiunioneFinderBaseImpl implements RiunioneFinder {

	final Log _log = LogFactoryUtil.getLog(RiunioneFinderImpl.class);

	public List<Riunione> findByFilters(Date da, Date a, long stato, String ogg, long isp, String prot, long am,
			long type) {

		List<Riunione> res = new ArrayList<>();
		List<InvitatiRiunione> list_r = new ArrayList<>();
		Session session = null;
		try {
			session = openSession();

			DynamicQuery queryRiunione = DynamicQueryFactoryUtil.forClass(Riunione.class, getClassLoader());
			Property propertyDate = PropertyFactoryUtil.forName("data_inizio");

			queryRiunione.add(propertyDate.between(da, a));
			queryRiunione.addOrder(OrderFactoryUtil.asc("data_inizio"));
			if (stato != 0) {
				queryRiunione.add(PropertyFactoryUtil.forName("id_stato_riunione").eq(stato));
				
			}else{
				
	             List<StatoRiunione> statiRiunione = StatoRiunioneLocalServiceUtil.findByLabel("eliminata");
	             if(statiRiunione!=null && !statiRiunione.isEmpty()){
				 queryRiunione.add(PropertyFactoryUtil.forName("id_stato_riunione").ne(statiRiunione.get(0).getId_stato_riunione()));
	             }
	        }
	             

			if (!"".equals(ogg)) {		
				Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
				String value = (new StringBuilder("%")).append(ogg).append("%").toString();
				disjunctionKey.add(RestrictionsFactoryUtil.ilike("oggetto", value));
				disjunctionKey.add(RestrictionsFactoryUtil.ilike("note", value));				
				queryRiunione.add(disjunctionKey);
			}

			if (isp != 0) {
				list_r = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneBySegreteria(isp);
				List<Long> listIdRiunione = list_r.stream().map(u -> u.getId_riunione()).collect(Collectors.toList());
				//create a cycle for avoid limit fo 1000 elements for in list
				int maxSize=800;
				int listSize = listIdRiunione.size();
				Criterion crit=null;
				  for (int i = 0; i < listSize; i += maxSize) {
					  if(i==0)
						  crit = PropertyFactoryUtil.forName("id_riunione").in( new ArrayList<Long>(listIdRiunione.subList(0, Math.min(listSize, maxSize))));
					  else
					  	  crit= RestrictionsFactoryUtil.or(crit,PropertyFactoryUtil.forName("id_riunione").in( new ArrayList<Long>(listIdRiunione.subList(i, Math.min(listSize, i + maxSize))))); 
				  }
				  queryRiunione.add(crit);
			}
			if (prot != null && !"".equals(prot)) {
				queryRiunione.add(RestrictionsFactoryUtil.ilike("protocollo", prot));				
			}
			if (am != 0) {
				Property propert = PropertyFactoryUtil.forName("id_amministrazione_convocante");
				queryRiunione.add(propert.eq(am));
			}
			if (type != 0) {
				Property propert = PropertyFactoryUtil.forName("id_tipo");
				queryRiunione.add(propert.eq(type));
			}

			res = RiunioneLocalServiceUtil.dynamicQuery(queryRiunione);

		} catch (Exception e) {
			_log.warn(e);
		} finally {

			closeSession(session);
		}
		return res;
	}
}
