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

import external.bfc.intranet.mef.service.base.RichiesteInfoLocalServiceBaseImpl;
import external.bfc.intranet.mef.model.RichiesteInfo;
import external.bfc.intranet.mef.service.persistence.RichiesteInfoUtil;
import com.liferay.portal.kernel.model.User;

/**
 * The implementation of the richieste info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link external.bfc.intranet.mef.service.RichiesteInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteInfoLocalServiceBaseImpl
 * @see external.bfc.intranet.mef.service.RichiesteInfoLocalServiceUtil
 */
@ProviderType
public class RichiesteInfoLocalServiceImpl
	extends RichiesteInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link external.bfc.intranet.mef.service.RichiesteInfoLocalServiceUtil} to access the richieste info local service.
	 */
	@Override
	public List<RichiesteInfo> getRichiesteInfobyEmail(String email){
		return RichiesteInfoUtil.findByemailReqBfcInfo(email);
	}
	
	@Override
	public List<RichiesteInfo> findByfilters(List<Long> lista_stati, List<String> ufficio, List<User> lista_utenti){
	 return richiesteInfoFinder.findByStati_Ufficio_Utenti(lista_stati, ufficio, lista_utenti);
	}
	
	
}