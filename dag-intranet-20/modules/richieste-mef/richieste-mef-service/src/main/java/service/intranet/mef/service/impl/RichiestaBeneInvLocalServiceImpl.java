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

package service.intranet.mef.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.ModuloTrasporti;
import service.intranet.mef.model.RichiestaBeneInv;
import service.intranet.mef.service.base.RichiestaBeneInvLocalServiceBaseImpl;

/**
 * The implementation of the richiesta bene inv local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.RichiestaBeneInvLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvLocalServiceBaseImpl
 * @see service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil
 */
@ProviderType
public class RichiestaBeneInvLocalServiceImpl
	extends RichiestaBeneInvLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(RichiestaBeneInvLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil} to access the richiesta bene inv local service.
	 */
	
	@Override
	public List<RichiestaBeneInv> getRichiesteBeniInvByFilters(long id_richiesta, String nome_rich, String cogn_rich, Date data, String dip_dir, List<Long> list_id_stato, String tipologia, boolean in_elenco){

		    return richiestaBeneInvFinder.getRichiesteBeniInvByFilters(id_richiesta, nome_rich, cogn_rich, data, dip_dir, list_id_stato, tipologia, in_elenco);
		       
		}
	
	@Override
	public List<RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(long id_richiesta, String screenName, Date data, List<Long> list_id_stato, String tipologia, boolean in_elenco){
		    return richiestaBeneInvFinder.getRichiesteBeniInvByFiltersRichiedente(id_richiesta, screenName, data, list_id_stato, tipologia, in_elenco);       
		}
	
	@Override
	public List<RichiestaBeneInv> getRichiesteByUtente(String utente){
		return this.richiestaBeneInvPersistence.findByUtente(utente);
		
	}
	
	@Override
	public List<RichiestaBeneInv> getRichiesteByDipartimento(String dipartimento){
		return this.richiestaBeneInvPersistence.findByDipartimento(dipartimento);
		
	}
	
	@Override
	public List<RichiestaBeneInv> getRichiesteByDipartimentoAndStato(List<String> dip_dir, long id_stato){
		List<RichiestaBeneInv> resRichieste=new ArrayList<RichiestaBeneInv>();
		for(String dipartimento:dip_dir){
			resRichieste.addAll(this.richiestaBeneInvPersistence.findByDipartimentoStato(dipartimento, id_stato));
		}
		return resRichieste;
		
	}
	
	@Override
	public RichiestaBeneInv insertRichiestaBeneInv(){
		
		RichiestaBeneInv richiestaBeneInv=richiestaBeneInvPersistence.create(-1);
		RichiestaBeneInv insertout=null;
		 try{
			 insertout = richiestaBeneInvPersistence.updateImpl(richiestaBeneInv);
			 return insertout;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return insertout;
		 }
	}
	
}