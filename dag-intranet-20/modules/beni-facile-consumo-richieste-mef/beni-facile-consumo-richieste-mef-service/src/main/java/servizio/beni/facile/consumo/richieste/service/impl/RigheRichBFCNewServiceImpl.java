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

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew;
import servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewLocalServiceUtil;
import servizio.beni.facile.consumo.richieste.service.base.RigheRichBFCNewServiceBaseImpl;

/**
 * The implementation of the righe rich b f c new remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichBFCNewServiceBaseImpl
 * @see servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewServiceUtil
 */
@ProviderType
public class RigheRichBFCNewServiceImpl extends RigheRichBFCNewServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewServiceUtil} to access the righe rich b f c new remote service.
	 */
	
	@Override
	public List<RigheRichBFCNew> getRigheRichiestaByDipartimento(String dipartimento) {
		return RigheRichBFCNewLocalServiceUtil.getRigheRichiestaByDipartimento(dipartimento);
	}
	
	@Override
	public List<RigheRichBFCNew> getRigaRichiestaByIdRichiesta(long id_richiesta) {
		return RigheRichBFCNewLocalServiceUtil.getRigaRichiestaByIdRichiesta(id_richiesta);
	}
}