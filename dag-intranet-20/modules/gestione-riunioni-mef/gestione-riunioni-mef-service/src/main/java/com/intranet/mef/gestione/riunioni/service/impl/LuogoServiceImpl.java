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

import com.intranet.mef.gestione.riunioni.service.base.LuogoServiceBaseImpl;
import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.model.Luogo;
import com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil;

import java.util.List;

/**
 * The implementation of the luogo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.LuogoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LuogoServiceBaseImpl
 * @see com.intranet.mef.service.LuogoServiceUtil
 */
@ProviderType
public class LuogoServiceImpl extends LuogoServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.LuogoServiceUtil} to access the luogo remote service.
	 */
	@Override
	public boolean setLuogo(String nome) {
	return LuogoLocalServiceUtil.setLuogo(nome);
	}

	@Override
	public List<Luogo> findByKeywordLuogo(String keyword){	
		return LuogoLocalServiceUtil.findByKeywordLuogo(keyword);
	}
	
}