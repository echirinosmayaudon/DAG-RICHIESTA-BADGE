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

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.RichiestaInterventi;
import service.intranet.mef.model.RichiesteHW;
import service.intranet.mef.service.base.RichiesteHWLocalServiceBaseImpl;

/**
 * The implementation of the richieste h w local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.RichiesteHWLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteHWLocalServiceBaseImpl
 * @see service.intranet.mef.service.RichiesteHWLocalServiceUtil
 */
@ProviderType
public class RichiesteHWLocalServiceImpl extends RichiesteHWLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(RichiesteHWLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.RichiesteHWLocalServiceUtil} to access the richieste h w local service.
	 */
	@Override
	public boolean insertRichiestaHw(String utente,String dettaglio,Date data_richiesta){
		RichiesteHW richiestaHw=richiesteHWPersistence.create(-1);
		richiestaHw.setUtente(utente);
		richiestaHw.setDettaglio(dettaglio);	
		richiestaHw.setData_richiesta(data_richiesta);
		 try{
			 richiesteHWPersistence.updateImpl(richiestaHw);
			 return true;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return false;
		 }
	}
	
	
}