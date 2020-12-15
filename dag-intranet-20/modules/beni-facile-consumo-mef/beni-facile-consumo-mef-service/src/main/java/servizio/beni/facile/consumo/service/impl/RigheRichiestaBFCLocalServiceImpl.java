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
import servizio.beni.facile.consumo.service.base.RigheRichiestaBFCLocalServiceBaseImpl;

/**
 * The implementation of the righe richiesta b f c local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCLocalServiceBaseImpl
 * @see servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalServiceUtil
 */
@ProviderType
public class RigheRichiestaBFCLocalServiceImpl
	extends RigheRichiestaBFCLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalServiceUtil} to access the righe richiesta b f c local service.
	 */
	
	@Override
	public List<RigheRichiestaBFC> getRigheRichiestaByDipartimento(String dipartimento) {
		return this.righeRichiestaBFCPersistence.findByDipartimento(dipartimento);
	}
	
	@Override
	public List<RigheRichiestaBFC> getRigaRichiestaByIdRichiesta(long id_richiesta) {
		return this.righeRichiestaBFCPersistence.findByIdRichiesta(id_richiesta);
	}
	
}