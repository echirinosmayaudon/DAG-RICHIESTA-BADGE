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

package autorizzazione.dir.mef.service.impl;

import autorizzazione.dir.mef.service.base.AutorizzazioneDirLocalServiceBaseImpl;

/**
 * The implementation of the autorizzazione dir local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link autorizzazione.dir.mef.service.AutorizzazioneDirLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutorizzazioneDirLocalServiceBaseImpl
 * @see autorizzazione.dir.mef.service.AutorizzazioneDirLocalServiceUtil
 */
public class AutorizzazioneDirLocalServiceImpl
	extends AutorizzazioneDirLocalServiceBaseImpl {
	
	@Override
	public boolean isAuthorized(long idApplicazione, long mef, long dipartimento, long direzione, long ufficio, String codiceFiscale){
		return autorizzazioneDirFinder.isAuthorized(idApplicazione, mef, dipartimento, direzione, ufficio, codiceFiscale);
	}

	@Override
	public boolean isNewsVisible(long mef, long direzione, long dipartimento, long ufficio, String codiceFiscale,
			String tag) {
		return autorizzazioneDirFinder.isNewsVisible(mef, direzione, dipartimento, ufficio, codiceFiscale, tag);
	}
	
	
}