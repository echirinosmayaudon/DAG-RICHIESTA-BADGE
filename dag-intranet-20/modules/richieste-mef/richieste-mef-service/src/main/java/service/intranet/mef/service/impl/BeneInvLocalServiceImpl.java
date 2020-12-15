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

package service.intranet.mef.service.impl;



import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.BeneInv;
import service.intranet.mef.service.base.BeneInvLocalServiceBaseImpl;

/**
 * The implementation of the bene inv local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.BeneInvLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvLocalServiceBaseImpl
 * @see service.intranet.mef.service.BeneInvLocalServiceUtil
 */
@ProviderType
public class BeneInvLocalServiceImpl extends BeneInvLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.BeneInvLocalServiceUtil} to access the bene inv local service.
	 */
	
	
	@Override
	public List<BeneInv> getBeneInvByTipoBene(long id_tipo){
		return this.beneInvPersistence.findByTipoBeneInv(id_tipo);
	} 
}