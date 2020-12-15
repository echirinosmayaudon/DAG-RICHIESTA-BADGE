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

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.LogisticaRichieste;
import service.intranet.mef.service.LogisticaRichiesteLocalServiceUtil;
import service.intranet.mef.service.base.LogisticaRichiesteServiceBaseImpl;

/**
 * The implementation of the logistica richieste remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.LogisticaRichiesteService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichiesteServiceBaseImpl
 * @see service.intranet.mef.service.LogisticaRichiesteServiceUtil
 */
@ProviderType
public class LogisticaRichiesteServiceImpl
	extends LogisticaRichiesteServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.LogisticaRichiesteServiceUtil} to access the logistica richieste remote service.
	 */
	
	@Override
	public List<LogisticaRichieste> getLogisticaRichiesteByUtente(String utente){
		return LogisticaRichiesteLocalServiceUtil.getLogisticaRichiesteByUtente(utente);
	} 
	
	@Override
	public List<LogisticaRichieste> getListLogRichiesteByDip(String dipartimento){
		return LogisticaRichiesteLocalServiceUtil.getListLogRichiesteByDip(dipartimento);
	} 
}