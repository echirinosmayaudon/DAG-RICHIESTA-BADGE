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

package com.intranet.mef.assistance.service.impl;

import java.util.List;

import com.intranet.mef.assistance.model.Servizio;
import com.intranet.mef.assistance.service.base.ServizioLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the servizio local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.assistance.service.ServizioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLocalServiceBaseImpl
 * @see com.intranet.mef.assistance.service.ServizioLocalServiceUtil
 */
@ProviderType
public class ServizioLocalServiceImpl extends ServizioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.assistance.service.ServizioLocalServiceUtil} to access the servizio local service.
	 */
	public void add(String assServiceId, String serviceName, String assScopeId,
		String levelAssistance){

		Servizio servizio = servizioPersistence.create(assServiceId);
		servizio.setServiceName(serviceName); 
		servizio.setAssScopeId(assScopeId); 
		servizio.setLevelAssistance(levelAssistance);

		servizioPersistence.update(servizio);		

	}

	public List<Servizio> findByScopesId(String assScopeId){
		return servizioPersistence.findByScopesId(assScopeId);

	}

	public String findServiceNameByPK(String assServiceId){
		Servizio servizio = servizioPersistence.
			fetchByPrimaryKey(assServiceId);
		return servizio.getServiceName();		

	}

	public void removeAll(){
		servizioPersistence.removeAll();
	}
}