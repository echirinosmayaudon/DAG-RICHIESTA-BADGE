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

package servizio.prenotazione.aule.mef.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import servizio.prenotazione.aule.mef.service.PrenotazioneServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link PrenotazioneServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link servizio.prenotazione.aule.mef.model.PrenotazioneSoap}.
 * If the method in the service utility returns a
 * {@link servizio.prenotazione.aule.mef.model.Prenotazione}, that is translated to a
 * {@link servizio.prenotazione.aule.mef.model.PrenotazioneSoap}. Methods that SOAP cannot
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
 * @see PrenotazioneServiceHttp
 * @see servizio.prenotazione.aule.mef.model.PrenotazioneSoap
 * @see PrenotazioneServiceUtil
 * @generated
 */
@ProviderType
public class PrenotazioneServiceSoap {
	public static servizio.prenotazione.aule.mef.model.PrenotazioneSoap[] getPrenotazioniByFilters(
		Long[] id_sale_list, java.util.Date data_inizio,
		java.util.Date data_fine, long id_stato) throws RemoteException {
		try {
			java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> returnValue =
				PrenotazioneServiceUtil.getPrenotazioniByFilters(ListUtil.toList(
						id_sale_list), data_inizio, data_fine, id_stato);

			return servizio.prenotazione.aule.mef.model.PrenotazioneSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static servizio.prenotazione.aule.mef.model.PrenotazioneSoap[] getPrenotazioniByCodFiscale(
		java.lang.String cod_fiscale) throws RemoteException {
		try {
			java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> returnValue =
				PrenotazioneServiceUtil.getPrenotazioniByCodFiscale(cod_fiscale);

			return servizio.prenotazione.aule.mef.model.PrenotazioneSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PrenotazioneServiceSoap.class);
}