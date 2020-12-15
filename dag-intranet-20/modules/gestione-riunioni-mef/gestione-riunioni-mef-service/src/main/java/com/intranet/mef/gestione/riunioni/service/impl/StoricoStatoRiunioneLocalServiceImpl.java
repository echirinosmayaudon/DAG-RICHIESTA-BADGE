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

import com.intranet.mef.gestione.riunioni.service.base.StoricoStatoRiunioneLocalServiceBaseImpl;
import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;

import java.util.List;

/**
 * The implementation of the storico stato riunione local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.StoricoStatoRiunioneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunioneLocalServiceBaseImpl
 * @see com.intranet.mef.service.StoricoStatoRiunioneLocalServiceUtil
 */
@ProviderType
public class StoricoStatoRiunioneLocalServiceImpl
	extends StoricoStatoRiunioneLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.StoricoStatoRiunioneLocalServiceUtil} to access the storico stato riunione local service.
	 */
	
	@Override
	public List<StoricoStatoRiunione> getStoricoStatoRiunioneByIdRiunione(long idRiunione){
		return this.storicoStatoRiunionePersistence.findByStoricoRiunione(idRiunione); 
	} 
	
}