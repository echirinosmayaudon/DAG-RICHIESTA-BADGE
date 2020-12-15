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

import com.intranet.mef.gestione.riunioni.service.base.LuogoLocalServiceBaseImpl;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelLuogo;
import com.intranet.mef.logicaldel.gestione.riunioni.service.CancelLuogoLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.model.Luogo;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The implementation of the luogo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.LuogoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LuogoLocalServiceBaseImpl
 * @see com.intranet.mef.service.LuogoLocalServiceUtil
 */
@ProviderType
public class LuogoLocalServiceImpl extends LuogoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.LuogoLocalServiceUtil} to access the luogo local service.
	 */
	final Log _log = LogFactoryUtil.getLog(LuogoLocalServiceImpl.class);
	@Override
	public boolean setLuogo(String nome) {
		Luogo luogo = luogoPersistence.create(-1);
		luogo.setNome(nome);
			try{
				luogoPersistence.updateImpl(luogo);
				CancelLuogo cancelLuogoRecord = CancelLuogoLocalServiceUtil.createCancelLuogo(luogo.getId_luogo());
				cancelLuogoRecord.setCancellato(false);
				CancelLuogoLocalServiceUtil.addCancelLuogo(cancelLuogoRecord);
				return true;
			}catch(Exception e){
				 _log.error(e);
				 return false;
			}
	}
	
	@Override
	public List<Luogo> findByKeywordLuogo(String keyword) {
		List<Luogo> resLuoghi = new ArrayList<Luogo>();
		List<Luogo> listaLuoghiKeyword = luogoFinder.findByKeywordLuogo(keyword);
		if (listaLuoghiKeyword != null && !listaLuoghiKeyword.isEmpty()) {
			List<CancelLuogo> listaLuoghi = CancelLuogoLocalServiceUtil.getLuogoByCancStatus(false);

			if (listaLuoghi != null && !listaLuoghi.isEmpty()) {
				for (Luogo luogo : listaLuoghiKeyword) {
					for (CancelLuogo luogoNonCancellato : listaLuoghi) {
						if (luogo.getId_luogo() == luogoNonCancellato.getId_luogo()) {
							resLuoghi.add(luogo);
							break;
						}
					}
				}
			}
			
			Collections.sort(resLuoghi, new Comparator<Luogo>() {
				@Override
				public int compare(Luogo o1, Luogo o2) {
					return (o1.getNome().trim().toUpperCase().compareTo(o2.getNome().trim().toUpperCase()));
				}
			});

		}
		return resLuoghi;
	}
}