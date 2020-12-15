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

package servizio.beni.facile.consumo.richieste.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew;
import servizio.beni.facile.consumo.richieste.service.base.RigheRichBFCNewLocalServiceBaseImpl;

/**
 * The implementation of the righe rich b f c new local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichBFCNewLocalServiceBaseImpl
 * @see servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewLocalServiceUtil
 */
@ProviderType
public class RigheRichBFCNewLocalServiceImpl
	extends RigheRichBFCNewLocalServiceBaseImpl {
	
	final Log _log = LogFactoryUtil.getLog(RigheRichBFCNewLocalServiceImpl.class);
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewLocalServiceUtil} to access the righe rich b f c new local service.
	 */
	
	@Override
	public List<RigheRichBFCNew> getRigheRichiestaByDipartimento(String dipartimento) {
		return this.righeRichBFCNewPersistence.findByDipartimento(dipartimento);
	}
	
	@Override
	public List<RigheRichBFCNew> getRigaRichiestaByIdRichiesta(long id_richiesta) {
		return this.righeRichBFCNewPersistence.findByIdRichiesta(id_richiesta);
	}
	
	@Override
	public boolean insertRigheRichBFCNew(long id_result, String dipartimento, String json){
		RigheRichBFCNew rigaInserita = righeRichBFCNewPersistence.create(-1);
		rigaInserita.setId_rich(id_result);
		rigaInserita.setDipartimento(dipartimento);
		if (json.length() <= 4000) {
			rigaInserita.setDati1(json);
		} else if (json.length() > 4000 && json.length() <= 8000) {
			rigaInserita.setDati1(json.substring(0, 3999));
			rigaInserita.setDati2(json.substring(4000, json.length()));
		} else if (json.length() > 8000 && json.length() <= 12000) {
			rigaInserita.setDati1(json.substring(0, 3999));
			rigaInserita.setDati2(json.substring(4000, 7999));
			rigaInserita.setDati3(json.substring(8000, json.length()));
		} else if (json.length() > 12000 && json.length() <= 16000) {
			rigaInserita.setDati1(json.substring(0, 3999));
			rigaInserita.setDati2(json.substring(4000, 7999));
			rigaInserita.setDati3(json.substring(8000, 12000));
			rigaInserita.setDati4(json.substring(12000, json.length()));
		}
		try{
			righeRichBFCNewPersistence.updateImpl(rigaInserita);
			return true;
		}catch(Exception e){
			_log.error(e);
			return false;
		}
	}
	
}