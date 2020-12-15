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

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.LogisticaRichieste;
import service.intranet.mef.model.RichiestaBeneInv;
import service.intranet.mef.service.LogisticaRichiesteLocalServiceUtil;
import service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil;
import service.intranet.mef.service.base.RichiestaBeneInvServiceBaseImpl;

/**
 * The implementation of the richiesta bene inv remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.RichiestaBeneInvService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvServiceBaseImpl
 * @see service.intranet.mef.service.RichiestaBeneInvServiceUtil
 */
@ProviderType
public class RichiestaBeneInvServiceImpl extends RichiestaBeneInvServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.RichiestaBeneInvServiceUtil} to access the richiesta bene inv remote service.
	 */
	@Override
	public List<RichiestaBeneInv> getRichiesteBeniInvByFilters(long id_richiesta, String nome_rich, String cogn_rich, Date data, String dip_dir, List<Long> list_id_stato, String tipologia, boolean in_elenco){
		return RichiestaBeneInvLocalServiceUtil.getRichiesteBeniInvByFilters(id_richiesta, nome_rich, cogn_rich, data, dip_dir, list_id_stato, tipologia, in_elenco);
	}
	
	@Override
	public List<RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(long id_richiesta, String screenName, Date data, List<Long> list_id_stato, String tipologia, boolean in_elenco){
		return RichiestaBeneInvLocalServiceUtil.getRichiesteBeniInvByFiltersRichiedente(id_richiesta, screenName, data, list_id_stato, tipologia, in_elenco);
	}
	
	@Override
	public List<RichiestaBeneInv> getRichiesteByUtente(String utente){
		return RichiestaBeneInvLocalServiceUtil.getRichiesteByUtente(utente);
	} 
	
	@Override
	public List<RichiestaBeneInv> getRichiesteByDipartimento(String dipartimento){
		return RichiestaBeneInvLocalServiceUtil.getRichiesteByDipartimento(dipartimento);
	} 
	
	@Override
	public List<RichiestaBeneInv> getRichiesteByDipartimentoAndStato(List<String> dip_dir, long id_stato){
		return RichiestaBeneInvLocalServiceUtil.getRichiesteByDipartimentoAndStato(dip_dir,id_stato);
	} 
	
}