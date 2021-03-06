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

package service.intranet.mef.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.BeneInvRichiesto;
import service.intranet.mef.model.RichiestaBeneInv;
import service.intranet.mef.service.BeneInvRichiestoLocalServiceUtil;
import service.intranet.mef.service.base.BeneInvRichiestoServiceBaseImpl;

/**
 * The implementation of the bene inv richiesto remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.BeneInvRichiestoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvRichiestoServiceBaseImpl
 * @see service.intranet.mef.service.BeneInvRichiestoServiceUtil
 */
@ProviderType
public class BeneInvRichiestoServiceImpl extends BeneInvRichiestoServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.BeneInvRichiestoServiceUtil} to access the bene inv richiesto remote service.
	 */
	
	@Override
	public List<BeneInvRichiesto> getListBeniByIdRichiesta(long id_richiesta, boolean in_elenco){
		return BeneInvRichiestoLocalServiceUtil.getListBeniByIdRichiesta(id_richiesta, in_elenco);
	}
	
	
	
	
}