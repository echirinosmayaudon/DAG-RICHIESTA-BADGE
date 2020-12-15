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
import service.intranet.mef.service.base.RichiestaInterventiLocalServiceBaseImpl;

/**
 * The implementation of the richiesta interventi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.RichiestaInterventiLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaInterventiLocalServiceBaseImpl
 * @see service.intranet.mef.service.RichiestaInterventiLocalServiceUtil
 */
@ProviderType
public class RichiestaInterventiLocalServiceImpl
	extends RichiestaInterventiLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(RichiestaInterventiLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.RichiestaInterventiLocalServiceUtil} to access the richiesta interventi local service.
	 */
	
	@Override
	public boolean insertRichiestaInterventi(String utente,String dettaglio,Date data_interventi){
		RichiestaInterventi richiestaInt=richiestaInterventiPersistence.create(-1);
		richiestaInt.setUtente(utente);
		richiestaInt.setDettaglio(dettaglio);
		richiestaInt.setData_interventi(data_interventi);
		 try{
			 richiestaInterventiPersistence.updateImpl(richiestaInt);
			 return true;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return false;
		 }
	}
}