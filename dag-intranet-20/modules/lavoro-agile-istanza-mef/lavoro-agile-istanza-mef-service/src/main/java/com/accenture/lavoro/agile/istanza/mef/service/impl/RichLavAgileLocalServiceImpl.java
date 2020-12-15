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

package com.accenture.lavoro.agile.istanza.mef.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;
import com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile;
import com.accenture.lavoro.agile.istanza.mef.service.base.RichLavAgileLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The implementation of the rich lav agile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichLavAgileLocalServiceBaseImpl
 * @see com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalServiceUtil
 */
@ProviderType
public class RichLavAgileLocalServiceImpl
	extends RichLavAgileLocalServiceBaseImpl {
	
    Log _log = LogFactoryUtil.getLog(RichLavAgileLocalServiceImpl.class);
	
    @Override
	public long insertRichiestaAgile(long id_richiesta, String cognome, String nome, long dipartimento, long direzione, long ufficio, String screename, 
			String jsonRichiedente, String jsonRichiesta, int peso_tot, String peso_plus, String bando, Date data_richiesta, String allegato, 
			String pdf) {
		
		
		RichLavAgile richiestaLavAgile = richLavAgilePersistence.create(-1);
				
		richiestaLavAgile.setId_richiesta(id_richiesta);
		richiestaLavAgile.setCognome(cognome);
		richiestaLavAgile.setNome(nome);
		richiestaLavAgile.setDipartimento(dipartimento);
		richiestaLavAgile.setDirezione(direzione);
		richiestaLavAgile.setUfficio(ufficio);
		richiestaLavAgile.setScreename(screename);
		richiestaLavAgile.setJson_richiedente(jsonRichiedente);
		richiestaLavAgile.setJson_richiesta(jsonRichiesta);
		richiestaLavAgile.setPeso_tot(peso_tot);
		richiestaLavAgile.setPeso_plus(peso_plus);
		richiestaLavAgile.setBando(bando);
		richiestaLavAgile.setData_richiesta(data_richiesta);
		richiestaLavAgile.setAllegato(allegato);
		richiestaLavAgile.setPdf(pdf);
		
		
		try{
			richLavAgilePersistence.updateImpl(richiestaLavAgile);
			richiestaLavAgile.setId_richiesta(richiestaLavAgile.getPrimaryKey());
			richLavAgilePersistence.updateImpl(richiestaLavAgile); 
			 return richiestaLavAgile.getId_richiesta();
		} catch(Exception e){
			 _log.error(e);
			 return 0;
		}
		
	}
    
    
    @Override
	public List<RichLavAgile> getRichByScreename(String screename){
    	List<RichLavAgile> listaRich = this.richLavAgilePersistence.findByscreename(screename);
		return listaRich;
		
	}

    
    @Override
   	public List<RichLavAgile> getRichiesteOrder(String order, long codiceIstanza, String cognome,long dip, long dir, long uff){
       	List<RichLavAgile> listaRes = richLavAgileFinder.getRichiesteOrder(order,codiceIstanza,  cognome, dip, dir, uff);
       	return listaRes;
   		}
    
}