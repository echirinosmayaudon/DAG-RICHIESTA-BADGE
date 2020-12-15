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

package com.intranet.mef.gestione.riunioni.service.http;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.service.LuogoServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link LuogoServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.intranet.mef.gestione.riunioni.model.LuogoSoap}.
 * If the method in the service utility returns a
 * {@link com.intranet.mef.gestione.riunioni.model.Luogo}, that is translated to a
 * {@link com.intranet.mef.gestione.riunioni.model.LuogoSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LuogoServiceHttp
 * @see com.intranet.mef.gestione.riunioni.model.LuogoSoap
 * @see LuogoServiceUtil
 * @generated
 */
@ProviderType
public class LuogoServiceSoap {
	public static boolean setLuogo(java.lang.String nome)
		throws RemoteException {
		try {
			boolean returnValue = LuogoServiceUtil.setLuogo(nome);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.intranet.mef.gestione.riunioni.model.LuogoSoap[] findByKeywordLuogo(
		java.lang.String keyword) throws RemoteException {
		try {
			java.util.List<com.intranet.mef.gestione.riunioni.model.Luogo> returnValue =
				LuogoServiceUtil.findByKeywordLuogo(keyword);

			return com.intranet.mef.gestione.riunioni.model.LuogoSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LuogoServiceSoap.class);
}