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

package service.intranet.mef.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import service.intranet.mef.service.RichiestaBeneInvServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link RichiestaBeneInvServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link service.intranet.mef.model.RichiestaBeneInvSoap}.
 * If the method in the service utility returns a
 * {@link service.intranet.mef.model.RichiestaBeneInv}, that is translated to a
 * {@link service.intranet.mef.model.RichiestaBeneInvSoap}. Methods that SOAP cannot
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
 * @see RichiestaBeneInvServiceHttp
 * @see service.intranet.mef.model.RichiestaBeneInvSoap
 * @see RichiestaBeneInvServiceUtil
 * @generated
 */
@ProviderType
public class RichiestaBeneInvServiceSoap {
	public static service.intranet.mef.model.RichiestaBeneInvSoap[] getRichiesteBeniInvByFilters(
		long id_richiesta, java.lang.String nome_rich,
		java.lang.String cogn_rich, java.util.Date data,
		java.lang.String dip_dir, Long[] list_id_stato,
		java.lang.String tipologia, boolean in_elenco)
		throws RemoteException {
		try {
			java.util.List<service.intranet.mef.model.RichiestaBeneInv> returnValue =
				RichiestaBeneInvServiceUtil.getRichiesteBeniInvByFilters(id_richiesta,
					nome_rich, cogn_rich, data, dip_dir,
					ListUtil.toList(list_id_stato), tipologia, in_elenco);

			return service.intranet.mef.model.RichiestaBeneInvSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static service.intranet.mef.model.RichiestaBeneInvSoap[] getRichiesteBeniInvByFiltersRichiedente(
		long id_richiesta, java.lang.String screenName, java.util.Date data,
		Long[] list_id_stato, java.lang.String tipologia, boolean in_elenco)
		throws RemoteException {
		try {
			java.util.List<service.intranet.mef.model.RichiestaBeneInv> returnValue =
				RichiestaBeneInvServiceUtil.getRichiesteBeniInvByFiltersRichiedente(id_richiesta,
					screenName, data, ListUtil.toList(list_id_stato),
					tipologia, in_elenco);

			return service.intranet.mef.model.RichiestaBeneInvSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static service.intranet.mef.model.RichiestaBeneInvSoap[] getRichiesteByUtente(
		java.lang.String utente) throws RemoteException {
		try {
			java.util.List<service.intranet.mef.model.RichiestaBeneInv> returnValue =
				RichiestaBeneInvServiceUtil.getRichiesteByUtente(utente);

			return service.intranet.mef.model.RichiestaBeneInvSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static service.intranet.mef.model.RichiestaBeneInvSoap[] getRichiesteByDipartimento(
		java.lang.String dipartimento) throws RemoteException {
		try {
			java.util.List<service.intranet.mef.model.RichiestaBeneInv> returnValue =
				RichiestaBeneInvServiceUtil.getRichiesteByDipartimento(dipartimento);

			return service.intranet.mef.model.RichiestaBeneInvSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static service.intranet.mef.model.RichiestaBeneInvSoap[] getRichiesteByDipartimentoAndStato(
		java.util.List<java.lang.String> dip_dir, long id_stato)
		throws RemoteException {
		try {
			java.util.List<service.intranet.mef.model.RichiestaBeneInv> returnValue =
				RichiestaBeneInvServiceUtil.getRichiesteByDipartimentoAndStato(dip_dir,
					id_stato);

			return service.intranet.mef.model.RichiestaBeneInvSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RichiestaBeneInvServiceSoap.class);
}