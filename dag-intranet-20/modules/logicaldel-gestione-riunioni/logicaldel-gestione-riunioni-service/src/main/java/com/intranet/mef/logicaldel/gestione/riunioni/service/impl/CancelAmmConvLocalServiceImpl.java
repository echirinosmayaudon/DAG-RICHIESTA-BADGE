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

package com.intranet.mef.logicaldel.gestione.riunioni.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.logicaldel.gestione.riunioni.service.base.CancelAmmConvLocalServiceBaseImpl;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;
import java.util.List;

/**
 * The implementation of the cancel amm conv local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.logicaldel.gestione.riunioni.service.CancelAmmConvLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConvLocalServiceBaseImpl
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.CancelAmmConvLocalServiceUtil
 */
@ProviderType
public class CancelAmmConvLocalServiceImpl
	extends CancelAmmConvLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.logicaldel.gestione.riunioni.service.CancelAmmConvLocalServiceUtil} to access the cancel amm conv local service.
	 */
	@Override
	public List<CancelAmmConv> getAmmConvByCancStatus(boolean cancellato){
		return this.cancelAmmConvPersistence.findByAmmConvList(cancellato);
	}
	
}