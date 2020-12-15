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

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.prenotazione.aule.mef.model.Sala;
import servizio.prenotazione.aule.mef.model.SalaStruttura;
import servizio.prenotazione.aule.mef.service.SalaLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.base.SalaServiceBaseImpl;

/**
 * The implementation of the sala remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.prenotazione.aule.mef.service.SalaService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.SalaServiceUtil
 */
@ProviderType
public class SalaServiceImpl extends SalaServiceBaseImpl {

	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.prenotazione.aule.mef.service.SalaServiceUtil} to access the sala remote service.
	 */
	
	@Override
	public List<Sala> getSaleBySalaStrutturaList(List<SalaStruttura> list_sala_struttura) throws PortalException{
	return SalaLocalServiceUtil.getSaleBySalaStrutturaList(list_sala_struttura);
	}
	
	
}