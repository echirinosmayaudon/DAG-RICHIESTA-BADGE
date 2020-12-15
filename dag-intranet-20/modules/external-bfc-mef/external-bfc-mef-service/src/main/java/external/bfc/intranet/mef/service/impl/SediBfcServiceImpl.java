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

package external.bfc.intranet.mef.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import external.bfc.intranet.mef.model.SediBfc;
import external.bfc.intranet.mef.service.SediBfcLocalServiceUtil;
import external.bfc.intranet.mef.service.base.SediBfcServiceBaseImpl;

/**
 * The implementation of the sedi bfc remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link external.bfc.intranet.mef.service.SediBfcService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediBfcServiceBaseImpl
 * @see external.bfc.intranet.mef.service.SediBfcServiceUtil
 */
@ProviderType
public class SediBfcServiceImpl extends SediBfcServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link external.bfc.intranet.mef.service.SediBfcServiceUtil} to access the sedi bfc remote service.
	 */
	
	@Override
	public List<SediBfc> getSediBfcByIdOrgLiv2AndFlagApp(long id_org_liv2, boolean flag_app){
		
		return SediBfcLocalServiceUtil.getSediBfcByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app);
	}
	
	@Override
	public List<SediBfc> getSediBfcByIdOrgLiv3AndFlagApp(long id_org_liv3,  boolean flag_app){
		
		return SediBfcLocalServiceUtil.getSediBfcByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app);
	}
	
}