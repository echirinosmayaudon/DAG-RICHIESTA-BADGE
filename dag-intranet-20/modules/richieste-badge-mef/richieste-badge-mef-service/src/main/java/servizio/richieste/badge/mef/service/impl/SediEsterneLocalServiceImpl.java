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

package servizio.richieste.badge.mef.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

import servizio.richieste.badge.mef.service.base.SediEsterneLocalServiceBaseImpl;
import servizio.richieste.badge.mef.service.persistence.SediEsternePersistence;
import servizio.richieste.badge.mef.model.SediEsterne;
/**
 * The implementation of the sedi esterne local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.richieste.badge.mef.service.SediEsterneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediEsterneLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.SediEsterneLocalServiceUtil
 */
@ProviderType
public class SediEsterneLocalServiceImpl extends SediEsterneLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.richieste.badge.mef.service.SediEsterneLocalServiceUtil} to access the sedi esterne local service.
	 */
	@Override
	public List<SediEsterne> getSediEsterneByIdSiap(long id_sedesiap){
		return this.sediEsternePersistence.findByIdSedeSiap(id_sedesiap);
	}
	@Override
	public List<SediEsterne> getSediEsterneByAcronimoSede(String acronimo_sede){
		return this.sediEsternePersistence.findByAcronimoSede(acronimo_sede);
	}
}