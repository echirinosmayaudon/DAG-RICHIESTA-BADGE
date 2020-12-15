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

import com.intranet.mef.gestione.riunioni.service.base.InvitatiRiunioneServiceBaseImpl;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the invitati riunione remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.InvitatiRiunioneService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunioneServiceBaseImpl
 * @see com.intranet.mef.service.InvitatiRiunioneServiceUtil
 */
@ProviderType
public class InvitatiRiunioneServiceImpl extends InvitatiRiunioneServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.InvitatiRiunioneServiceUtil} to access the invitati riunione remote service.
	 */
	
	@Override
	public List<InvitatiRiunione> getInvitatiRiunioneByIdRiunione(long idRiunione){
		return InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(idRiunione);
	} 
	
	@Override
	public InvitatiRiunione getInvitatiRiunioneByPK(long id_segreteria, long id_riunione) {
		return InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByPK(id_segreteria, id_riunione);
	}
	
	
	

	
}