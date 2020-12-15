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

package com.intranet.mef.gestione.riunioni.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;
import com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.intranet.mef.gestione.riunioni.service.base.RiunioneLocalServiceBaseImpl;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.model.Riunione;
import com.intranet.mef.gestione.riunioni.model.StatoRiunione;
import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;

import java.util.Date;
import java.util.List;
/**
 * The implementation of the riunione local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.RiunioneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RiunioneLocalServiceBaseImpl
 * @see com.intranet.mef.service.RiunioneLocalServiceUtil
 */
@ProviderType
public class RiunioneLocalServiceImpl extends RiunioneLocalServiceBaseImpl {
	
	final Log _log = LogFactoryUtil.getLog(RiunioneLocalServiceImpl.class); 
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.RiunioneLocalServiceUtil} to access the riunione local service.
	 */
	
	@Override
	public long setRiunione(String oggetto, Date data_inizio, Date data_fine, String note, Date data_modifica, Date data_creazione, String protocollo, long id_stato_riunione, long id_tipo, long id_luogo, long id_amministrazione_convocante, long[] id_segreteria) {
	
		Riunione r = riunionePersistence.create(-1);
		r.setOggetto(oggetto);
		r.setData_inizio(data_inizio);
		r.setData_fine(data_fine);
		r.setNote(note);
		r.setData_modifica(data_modifica);
		r.setData_creazione(data_creazione);
		r.setProtocollo(protocollo);
		r.setId_stato_riunione(id_stato_riunione);
		r.setId_tipo(id_tipo);
		r.setId_luogo(id_luogo);
		r.setId_amministrazione_convocante(id_amministrazione_convocante);			
			try{
			riunionePersistence.updateImpl(r);
			}catch(Exception e){
				_log.error(e);
				return 0L;
			}
        	for (int i=0; i<id_segreteria.length; i++) {
        		InvitatiRiunionePK invitatiRiunionePK = new InvitatiRiunionePK();
        		invitatiRiunionePK.setId_riunione(r.getId_riunione());
        		invitatiRiunionePK.setId_segreteria(id_segreteria[i]);
        		InvitatiRiunione inv = InvitatiRiunioneLocalServiceUtil.createInvitatiRiunione(invitatiRiunionePK);
        		InvitatiRiunioneLocalServiceUtil.addInvitatiRiunione(inv);
        	}
			
			Long id_storico = CounterLocalServiceUtil.increment(StoricoStatoRiunione.class.getName());
			
			StoricoStatoRiunionePK storicoStatoRiunionePK = new StoricoStatoRiunionePK();
			storicoStatoRiunionePK.setId_riunione(r.getId_riunione());
			storicoStatoRiunionePK.setId_storico(id_storico);
    		
			StoricoStatoRiunione sto = StoricoStatoRiunioneLocalServiceUtil.createStoricoStatoRiunione(storicoStatoRiunionePK);
			sto.setData(data_creazione);
			sto.setId_stato_riunione(id_stato_riunione);
			
			StoricoStatoRiunioneLocalServiceUtil.addStoricoStatoRiunione(sto);
			return r.getId_riunione();
		
	}
	
	
	@Override
	public String updateDatiRiunione(long riunioneId, String oggetto, String protocollo,long id_amministrazione_convocante,String note, long id_tipo) throws PortalException{
		Riunione r = RiunioneLocalServiceUtil.getRiunione(riunioneId);
		String out;
		StatoRiunione statoriunione = StatoRiunioneLocalServiceUtil .getStatoRiunione(r.getId_stato_riunione());
		if("effettuata".equalsIgnoreCase(statoriunione.getLabel())){
			out="effettuata";
		}
		else{
			Date data_modifica= new Date();
			r.setData_modifica(data_modifica); 
			r.setOggetto(oggetto);
			r.setId_tipo(id_tipo);
			r.setProtocollo(protocollo);
			r.setId_amministrazione_convocante(id_amministrazione_convocante);
			r.setNote(note);			
			RiunioneLocalServiceUtil.updateRiunione(r);
			out="updated";
            if("indetta".equalsIgnoreCase(statoriunione.getLabel())){
			  out="indetta";
			}
		}
		
	    	List <InvitatiRiunione> iR = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
	    	for (InvitatiRiunione j:iR) {
	    		j.setId_stato_invitato(0);
	    	
	    }
		return out;
	}
	
	
	
	@Override
	public boolean updateSpostaRiunione(long riunioneId, Date data_inizio, long id_luogo) throws PortalException{
		Riunione r = RiunioneLocalServiceUtil.getRiunione(riunioneId);
		boolean out=false;
		StatoRiunione statoriunione = StatoRiunioneLocalServiceUtil .getStatoRiunione(r.getId_stato_riunione());
		 if("indetta".equalsIgnoreCase(statoriunione.getLabel())){		
			    Date data_modifica= new Date();
				r.setData_modifica(data_modifica); 
			    r.setData_inizio(data_inizio);
		        r.setId_luogo(id_luogo);				
				RiunioneLocalServiceUtil.updateRiunione(r);			
				out=true;
			}
		 
		    	List <InvitatiRiunione> iR = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
		    	for (InvitatiRiunione j:iR) {
		    		j.setId_stato_invitato(0);
		    	
		    }
		
		return out;
	}
	
	@Override
	public boolean updateDataSollecitoRiunione(long riunioneId) throws PortalException{
		Riunione r = RiunioneLocalServiceUtil.getRiunione(riunioneId);
		Date data_ultimo_sollecito= new Date();
		r.setData_ultimo_sollecito(data_ultimo_sollecito); 				
		return RiunioneLocalServiceUtil.updateRiunione(r)!=null;			
	}
	
	@Override
	public boolean modifyStatoRiunione(long id_riunione, Date data_modifica, long id_stato_riunione) throws PortalException{
		
		Riunione riun = RiunioneLocalServiceUtil.getRiunione(id_riunione);
		riun.setId_stato_riunione(id_stato_riunione);
		riun.setData_modifica(data_modifica);
		RiunioneLocalServiceUtil.updateRiunione(riun);
		
		int numBeforeSto = StoricoStatoRiunioneLocalServiceUtil.getStoricoStatoRiunionesCount();
		
		Long id_storico = CounterLocalServiceUtil.increment(StoricoStatoRiunione.class.getName());
		
		StoricoStatoRiunionePK storicoStatoRiunionePK = new StoricoStatoRiunionePK();
		storicoStatoRiunionePK.setId_riunione(id_riunione);
		storicoStatoRiunionePK.setId_storico(id_storico);
		
		StoricoStatoRiunione sto = StoricoStatoRiunioneLocalServiceUtil.createStoricoStatoRiunione(storicoStatoRiunionePK);
		sto.setData(data_modifica);
		sto.setId_stato_riunione(id_stato_riunione);
		
		StoricoStatoRiunioneLocalServiceUtil.addStoricoStatoRiunione(sto);
		int numAfterSto = StoricoStatoRiunioneLocalServiceUtil.getStoricoStatoRiunionesCount();
	    
	    if(id_stato_riunione==2) {
	    	List <InvitatiRiunione> iR = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(id_riunione);
	    	for (InvitatiRiunione j:iR) {
	    		j.setId_stato_invitato(0);
	    	}
	    }
	    
		if(numAfterSto>numBeforeSto) {
			return true;
		}
	
		else {
			return false;
		}
		
	}
	
	@Override
	public List<Riunione> findByFilters(Date da,Date a, long stato,String ogg,long isp,String prot, long am, long type ) throws SystemException{	
		return riunioneFinder.findByFilters(da, a, stato, ogg, isp,prot,am,type);
	}
	
	
}