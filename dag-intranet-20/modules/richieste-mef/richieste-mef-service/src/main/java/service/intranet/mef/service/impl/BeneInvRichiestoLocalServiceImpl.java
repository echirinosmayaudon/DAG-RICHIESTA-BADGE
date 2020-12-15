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

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.BeneInvRichiesto;
import service.intranet.mef.service.base.BeneInvRichiestoLocalServiceBaseImpl;

/**
 * The implementation of the bene inv richiesto local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.BeneInvRichiestoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvRichiestoLocalServiceBaseImpl
 * @see service.intranet.mef.service.BeneInvRichiestoLocalServiceUtil
 */
@ProviderType
public class BeneInvRichiestoLocalServiceImpl
	extends BeneInvRichiestoLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(BeneInvRichiestoLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.BeneInvRichiestoLocalServiceUtil} to access the bene inv richiesto local service.
	 */
	
	@Override
	public List<BeneInvRichiesto> getListBeniByIdRichiesta(long id_richiesta, boolean in_elenco){
		return this.beneInvRichiestoPersistence.findByBeniInvRichiestiList(id_richiesta, in_elenco);
	} 
	
	@Override
	public BeneInvRichiesto insertBeneInvRichiesto(String tipologia,String descrizione, int quantita, String dettagli, boolean in_elenco, long id_richiesta){
		
		BeneInvRichiesto beneInvRichiesto=beneInvRichiestoPersistence.create(-1);
		beneInvRichiesto.setTipologia(tipologia);
		beneInvRichiesto.setDescrizione(descrizione);
		beneInvRichiesto.setQuantita(quantita);
		beneInvRichiesto.setDettagli(dettagli);
		beneInvRichiesto.setIn_elenco(in_elenco);
		beneInvRichiesto.setId_richiesta(id_richiesta);

		BeneInvRichiesto insertout=null;
		 try{
			 insertout = beneInvRichiestoPersistence.updateImpl(beneInvRichiesto);
			 return insertout;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return insertout;
		 }
	}
	
}