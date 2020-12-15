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

package servizio.richiesta.trasporti.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.richiesta.trasporti.model.Mobilita;
import servizio.richiesta.trasporti.service.base.MobilitaLocalServiceBaseImpl;

/**
 * The implementation of the mobilita local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.richiesta.trasporti.service.MobilitaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MobilitaLocalServiceBaseImpl
 * @see servizio.richiesta.trasporti.service.MobilitaLocalServiceUtil
 */
@ProviderType
public class MobilitaLocalServiceImpl extends MobilitaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.richiesta.trasporti.service.MobilitaLocalServiceUtil} to access the mobilita local service.
	 */
	
	@Override
	public List<Mobilita> getMobilitaByPersonId(long person_id){
		
		return mobilitaPersistence.findByPersonId(person_id);
	}
	
}