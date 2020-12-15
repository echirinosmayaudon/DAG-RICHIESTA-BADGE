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
import com.intranet.mef.gestione.riunioni.service.base.InvitatiRiunioneLocalServiceBaseImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the invitati riunione local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.InvitatiRiunioneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunioneLocalServiceBaseImpl
 * @see com.intranet.mef.service.InvitatiRiunioneLocalServiceUtil
 */
@ProviderType
public class InvitatiRiunioneLocalServiceImpl
	extends InvitatiRiunioneLocalServiceBaseImpl {
	
	final Log _log = LogFactoryUtil.getLog(InvitatiRiunioneLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.InvitatiRiunioneLocalServiceUtil} to access the invitati riunione local service.
	 */
	
	@Override
	public List<InvitatiRiunione> getInvitatiRiunioneByIdRiunione(long idRiunione){
		return this.invitatiRiunionePersistence.findByRiunione(idRiunione); 
	} 
	
	
	@Override
	public List<InvitatiRiunione> getInvitatiRiunioneBySegreteria(long id_segreteria){
		List<InvitatiRiunione> lista_i;			
		lista_i=this.invitatiRiunionePersistence.findBySegreteria(id_segreteria);				
		return lista_i;				
	}
	
	@Override
	public List<InvitatiRiunione> getInvitatiRiunioneBySegreteriaRiunione(long id_segreteria,
			long[] id_riuniones)  {
		List<InvitatiRiunione> lista_i;
		lista_i=this.invitatiRiunionePersistence.findBySegreteriaRiunione(id_segreteria, id_riuniones);		
		return lista_i;
		
	}
	
	@Override
	public InvitatiRiunione getInvitatiRiunioneByPK(long id_segreteria, long id_riunione) {
		
		InvitatiRiunione invitatiRiunione = null;
		
		try {
			InvitatiRiunionePK invitatiRiunionePK = new InvitatiRiunionePK();
		
		
		invitatiRiunionePK.setId_segreteria(id_segreteria);
		invitatiRiunionePK.setId_riunione(id_riunione);
		
		invitatiRiunione = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunione(invitatiRiunionePK);
		
		}catch (Exception e){
			_log.error(e);
		}
		
		return invitatiRiunione;
	}


	
}