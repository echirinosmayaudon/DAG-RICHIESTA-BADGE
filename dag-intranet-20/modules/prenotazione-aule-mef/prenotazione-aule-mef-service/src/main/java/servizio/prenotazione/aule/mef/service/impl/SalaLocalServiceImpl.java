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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.prenotazione.aule.mef.model.Sala;
import servizio.prenotazione.aule.mef.model.SalaStruttura;
import servizio.prenotazione.aule.mef.service.SalaLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.base.SalaLocalServiceBaseImpl;

/**
 * The implementation of the sala local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.prenotazione.aule.mef.service.SalaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaLocalServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.SalaLocalServiceUtil
 */
@ProviderType
public class SalaLocalServiceImpl extends SalaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.prenotazione.aule.mef.service.SalaLocalServiceUtil} to access the sala local service.
	 */
	
	@Override
	public List<Sala> getSaleBySalaStrutturaList(List<SalaStruttura> list_sala_struttura) throws PortalException {
		List<Sala> list_sale = new ArrayList<Sala>();
		if (!list_sala_struttura.isEmpty()) {
			for (SalaStruttura salaStruttura: list_sala_struttura) {
				list_sale.add(SalaLocalServiceUtil.getSala(salaStruttura.getId_sala()));
			}
		}
		return list_sale;
	}
	
	
	
	

}