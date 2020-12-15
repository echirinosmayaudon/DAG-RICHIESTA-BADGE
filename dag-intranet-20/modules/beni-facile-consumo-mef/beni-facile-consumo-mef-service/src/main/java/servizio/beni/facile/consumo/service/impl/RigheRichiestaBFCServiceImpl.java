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

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.beni.facile.consumo.model.RigheRichiestaBFC;
import servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalServiceUtil;
import servizio.beni.facile.consumo.service.base.RigheRichiestaBFCServiceBaseImpl;

/**
 * The implementation of the righe richiesta b f c remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.beni.facile.consumo.service.RigheRichiestaBFCService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCServiceBaseImpl
 * @see servizio.beni.facile.consumo.service.RigheRichiestaBFCServiceUtil
 */
@ProviderType
public class RigheRichiestaBFCServiceImpl
	extends RigheRichiestaBFCServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.beni.facile.consumo.service.RigheRichiestaBFCServiceUtil} to access the righe richiesta b f c remote service.
	 */
	@Override
	public List<RigheRichiestaBFC> getRigheRichiestaByDipartimento(String dipartimento) {
		return RigheRichiestaBFCLocalServiceUtil.getRigheRichiestaByDipartimento(dipartimento);
	}
	
	@Override
	public List<RigheRichiestaBFC> getRigaRichiestaByIdRichiesta(long id_richiesta) {
		return RigheRichiestaBFCLocalServiceUtil.getRigaRichiestaByIdRichiesta(id_richiesta);
	}
}