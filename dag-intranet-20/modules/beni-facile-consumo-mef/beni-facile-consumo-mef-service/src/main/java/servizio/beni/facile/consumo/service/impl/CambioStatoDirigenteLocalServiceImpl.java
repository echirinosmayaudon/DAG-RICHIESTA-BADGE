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

package servizio.beni.facile.consumo.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.beni.facile.consumo.model.CambioStatoDirigente;
import servizio.beni.facile.consumo.service.base.CambioStatoDirigenteLocalServiceBaseImpl;

/**
 * The implementation of the cambio stato dirigente local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CambioStatoDirigenteLocalServiceBaseImpl
 * @see servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalServiceUtil
 */
@ProviderType
public class CambioStatoDirigenteLocalServiceImpl
	extends CambioStatoDirigenteLocalServiceBaseImpl {
	
	final Log _log = LogFactoryUtil.getLog(CambioStatoDirigenteLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalServiceUtil} to access the cambio stato dirigente local service.
	 */
	
	@Override
	public List<CambioStatoDirigente> getCambioStatoDirigenteByIdRichiesta(long id_rich) {
		return this.cambioStatoDirigentePersistence.findByIdRichiesta(id_rich);
	}
	
	
	@Override
	public boolean insertCambioStatoDirigente(long id_rich, long id_stato, Date data, String note, String nomeutente){
		CambioStatoDirigente cambioStatoDirigenteRecord = cambioStatoDirigentePersistence.create(-1);
		cambioStatoDirigenteRecord.setId_rich(id_rich);
		cambioStatoDirigenteRecord.setId_stato(id_stato);
		cambioStatoDirigenteRecord.setData(data);
		if(note!=null) {
		cambioStatoDirigenteRecord.setNote(note);
		}
		cambioStatoDirigenteRecord.setUtente(nomeutente);
		try{
			cambioStatoDirigentePersistence.updateImpl(cambioStatoDirigenteRecord);
			return true;
		}catch(Exception e){
			_log.error(e);
			return false;
		}
	}
}