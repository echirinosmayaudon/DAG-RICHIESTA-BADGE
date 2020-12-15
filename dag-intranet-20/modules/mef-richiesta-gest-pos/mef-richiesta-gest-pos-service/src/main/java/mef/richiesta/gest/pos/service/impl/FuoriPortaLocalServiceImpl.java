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

package mef.richiesta.gest.pos.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import mef.richiesta.gest.pos.model.FuoriPorta;
import mef.richiesta.gest.pos.service.PianoLocalServiceUtil;
import mef.richiesta.gest.pos.service.base.FuoriPortaLocalServiceBaseImpl;

/**
 * The implementation of the fuori porta local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>mef.richiesta.gest.pos.service.FuoriPortaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FuoriPortaLocalServiceBaseImpl
 */
public class FuoriPortaLocalServiceImpl extends FuoriPortaLocalServiceBaseImpl {

	public List<FuoriPorta> getFuoriPortaFromCorridoio(long idCorridoio){
		List<FuoriPorta> listaFuoriPorte = null;
		DynamicQuery dqCorridoio = PianoLocalServiceUtil.dynamicQuery();
		Criterion criterion = RestrictionsFactoryUtil.eq("id_corridoio", idCorridoio);
		dqCorridoio.add(criterion);
		listaFuoriPorte = PianoLocalServiceUtil.dynamicQuery(dqCorridoio);

		return listaFuoriPorte;
		}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>mef.richiesta.gest.pos.service.FuoriPortaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>mef.richiesta.gest.pos.service.FuoriPortaLocalServiceUtil</code>.
	 */
}