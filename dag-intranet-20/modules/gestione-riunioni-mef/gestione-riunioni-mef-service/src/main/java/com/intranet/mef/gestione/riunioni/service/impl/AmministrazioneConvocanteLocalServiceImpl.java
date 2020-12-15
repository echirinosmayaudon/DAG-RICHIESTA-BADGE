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

import com.intranet.mef.gestione.riunioni.service.base.AmministrazioneConvocanteLocalServiceBaseImpl;
import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;
import com.intranet.mef.logicaldel.gestione.riunioni.service.CancelAmmConvLocalServiceUtil;


/**
 * The implementation of the amministrazione convocante local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.AmministrazioneConvocanteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmministrazioneConvocanteLocalServiceBaseImpl
 * @see com.intranet.mef.service.AmministrazioneConvocanteLocalServiceUtil
 */
@ProviderType
public class AmministrazioneConvocanteLocalServiceImpl
	extends AmministrazioneConvocanteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.AmministrazioneConvocanteLocalServiceUtil} to access the amministrazione convocante local service.
	 */
	final Log _log = LogFactoryUtil.getLog(AmministrazioneConvocanteLocalServiceImpl.class);
	@Override
	public boolean setAmministrazioneConvocante(String nome_amministrazione) {	
		AmministrazioneConvocante adm = amministrazioneConvocantePersistence.create(-1);	
		adm.setNome_amministrazione(nome_amministrazione);		
			 try{
				amministrazioneConvocantePersistence.updateImpl(adm);
				CancelAmmConv cancelAmmConvRecord = CancelAmmConvLocalServiceUtil.createCancelAmmConv(adm.getId_amministrazione_convocante());
				cancelAmmConvRecord.setCancellato(false);
				CancelAmmConvLocalServiceUtil.addCancelAmmConv(cancelAmmConvRecord);
				return true;
			 }catch(Exception e){
				 _log.error(e);
				 return false;
			 }
			
		}
		

	@Override
	public List<AmministrazioneConvocante> findByKeywordAdmin(String keyword){	
		List<AmministrazioneConvocante> resAmmConv = new ArrayList<AmministrazioneConvocante>();
		List<AmministrazioneConvocante> listaAmmConvKeyword = amministrazioneConvocanteFinder.findByKeywordAdmin(keyword);
		if (listaAmmConvKeyword != null && !listaAmmConvKeyword.isEmpty()) {
			List<CancelAmmConv> listaAmmConv = CancelAmmConvLocalServiceUtil.getAmmConvByCancStatus(false);

			if (listaAmmConv != null && !listaAmmConv.isEmpty()) {
				for (AmministrazioneConvocante ammConv : listaAmmConvKeyword) {
					for (CancelAmmConv ammNonCancellata : listaAmmConv) {
						if (ammConv.getId_amministrazione_convocante() == ammNonCancellata.getId_amministrazione_convocante()) {
							resAmmConv.add(ammConv);
							break;
						}
					}
				}
			}
			
			Collections.sort(resAmmConv, new Comparator<AmministrazioneConvocante>() {
				@Override
				public int compare(AmministrazioneConvocante o1, AmministrazioneConvocante o2) {
					return (o1.getNome_amministrazione().trim().toUpperCase().compareTo(o2.getNome_amministrazione().trim().toUpperCase()));
				}
			});

		}
		return resAmmConv;
	}
	
	
}