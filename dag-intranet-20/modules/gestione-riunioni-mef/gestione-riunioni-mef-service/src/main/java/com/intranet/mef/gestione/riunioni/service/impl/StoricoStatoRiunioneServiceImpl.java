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

import com.intranet.mef.gestione.riunioni.service.base.StoricoStatoRiunioneServiceBaseImpl;
import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;
import com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalServiceUtil;

import java.util.List;

/**
 * The implementation of the storico stato riunione remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.StoricoStatoRiunioneService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunioneServiceBaseImpl
 * @see com.intranet.mef.service.StoricoStatoRiunioneServiceUtil
 */
@ProviderType
public class StoricoStatoRiunioneServiceImpl
	extends StoricoStatoRiunioneServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.StoricoStatoRiunioneServiceUtil} to access the storico stato riunione remote service.
	 */
	
	@Override
	public List<StoricoStatoRiunione> getStoricoStatoRiunioneByIdRiunione(long idRiunione){
		return StoricoStatoRiunioneLocalServiceUtil.getStoricoStatoRiunioneByIdRiunione(idRiunione);
	} 
	
}