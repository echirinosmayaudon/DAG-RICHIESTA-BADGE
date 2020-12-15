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

package servizio.richieste.badge.mef.service.impl;

import com.liferay.portal.kernel.json.JSONArray;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil;
import servizio.richieste.badge.mef.service.base.RichiestaBadgeServiceBaseImpl;

/**
 * The implementation of the richiesta badge remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.richieste.badge.mef.service.RichiestaBadgeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgeServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.RichiestaBadgeServiceUtil
 */
@ProviderType
public class RichiestaBadgeServiceImpl extends RichiestaBadgeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.richieste.badge.mef.service.RichiestaBadgeServiceUtil} to access the richiesta badge remote service.
	 */
	
	public JSONArray findSuggestionsBySurname(String cognome, String idOrgChart, Long userId){
		return RichiestaBadgeLocalServiceUtil.findSuggestionsBySurname(cognome, idOrgChart, userId);
	}
	
	@Override
	public List<RichiestaBadge> getRichiestaBadgeByFilters( String cogn_intest, String nome_intest, String cf_intest, String societa, String ref_societa, String motivazione_rich, String progetto, String screenName, List<Long> lista_IdUffici, boolean is_last, List<Long> lista_sedi, String is_internal, List<Long> lista_stati){
		return RichiestaBadgeLocalServiceUtil.getRichiestaBadgeByFilters(cogn_intest, nome_intest, cf_intest, societa, ref_societa, motivazione_rich, progetto, screenName, lista_IdUffici, is_last, lista_sedi, is_internal, lista_stati);
	} 
	
	@Override
	public List<RichiestaBadge> findRichiestaByDipartimentoStato(String dipartimento, List<Long> lista_IdStato ){	
		return RichiestaBadgeLocalServiceUtil.findRichiestaByDipartimentoStato(dipartimento, lista_IdStato);
	} 
	
}