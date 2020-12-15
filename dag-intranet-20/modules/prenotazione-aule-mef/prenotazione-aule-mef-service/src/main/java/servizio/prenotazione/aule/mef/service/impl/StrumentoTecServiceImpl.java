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

package servizio.prenotazione.aule.mef.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.prenotazione.aule.mef.model.StrumentoTec;
import servizio.prenotazione.aule.mef.service.StrumentoTecLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.base.StrumentoTecServiceBaseImpl;

/**
 * The implementation of the strumento tec remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.prenotazione.aule.mef.service.StrumentoTecService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTecServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.StrumentoTecServiceUtil
 */
@ProviderType
public class StrumentoTecServiceImpl extends StrumentoTecServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.prenotazione.aule.mef.service.StrumentoTecServiceUtil} to access the strumento tec remote service.
	 */
	
	@Override
	public List<StrumentoTec> getStrumentoTecListByDescStrumento(String desc_strumento){
		return StrumentoTecLocalServiceUtil.getStrumentoTecListByDescStrumento(desc_strumento);
		       
		}
}