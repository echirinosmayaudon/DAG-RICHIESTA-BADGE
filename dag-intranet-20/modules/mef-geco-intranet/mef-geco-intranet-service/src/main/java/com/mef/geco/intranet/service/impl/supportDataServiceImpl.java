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

package com.mef.geco.intranet.service.impl;

import aQute.bnd.annotation.ProviderType;
import geco.mef.it.SchedaMaterialeBean;
import geco.mef.it.SottoGruppoBean;

import com.mef.geco.intranet.service.supportDataLocalServiceUtil;
import com.mef.geco.intranet.service.base.supportDataServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the support data remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.mef.geco.intranet.service.supportDataService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see supportDataServiceBaseImpl
 * @see com.mef.geco.intranet.service.supportDataServiceUtil
 */
@ProviderType
public class supportDataServiceImpl extends supportDataServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.mef.geco.intranet.service.supportDataServiceUtil} to access the support data remote service.
	 */
	@Override
	public  List<SottoGruppoBean> getListSottogruppi(String origine, String tipoMateriale, String codiceGruppo, String codiceUfficio, String servizio, String ambiente){
		return supportDataLocalServiceUtil.getListSottogruppi(origine, tipoMateriale, codiceGruppo, codiceUfficio, servizio, ambiente);
	}
	
	
	@Override
	public  List<SchedaMaterialeBean> getListMateriali(String origine, String tipoMateriale, String codiceGruppo,String codiceSottogruppo,String codiceUfficio, String servizio, String ambiente){
		return supportDataLocalServiceUtil.getListMateriali(origine, tipoMateriale, codiceGruppo, codiceSottogruppo, codiceUfficio, servizio, ambiente);
	}
	
}