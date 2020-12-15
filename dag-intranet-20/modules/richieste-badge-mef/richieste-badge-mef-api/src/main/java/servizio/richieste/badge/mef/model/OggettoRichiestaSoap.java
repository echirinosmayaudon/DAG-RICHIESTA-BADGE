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

package servizio.richieste.badge.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.richieste.badge.mef.service.http.OggettoRichiestaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.http.OggettoRichiestaServiceSoap
 * @generated
 */
@ProviderType
public class OggettoRichiestaSoap implements Serializable {
	public static OggettoRichiestaSoap toSoapModel(OggettoRichiesta model) {
		OggettoRichiestaSoap soapModel = new OggettoRichiestaSoap();

		soapModel.setId_oggetto(model.getId_oggetto());
		soapModel.setDescrizione_oggetto(model.getDescrizione_oggetto());

		return soapModel;
	}

	public static OggettoRichiestaSoap[] toSoapModels(OggettoRichiesta[] models) {
		OggettoRichiestaSoap[] soapModels = new OggettoRichiestaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OggettoRichiestaSoap[][] toSoapModels(
		OggettoRichiesta[][] models) {
		OggettoRichiestaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OggettoRichiestaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OggettoRichiestaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OggettoRichiestaSoap[] toSoapModels(
		List<OggettoRichiesta> models) {
		List<OggettoRichiestaSoap> soapModels = new ArrayList<OggettoRichiestaSoap>(models.size());

		for (OggettoRichiesta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OggettoRichiestaSoap[soapModels.size()]);
	}

	public OggettoRichiestaSoap() {
	}

	public long getPrimaryKey() {
		return _id_oggetto;
	}

	public void setPrimaryKey(long pk) {
		setId_oggetto(pk);
	}

	public long getId_oggetto() {
		return _id_oggetto;
	}

	public void setId_oggetto(long id_oggetto) {
		_id_oggetto = id_oggetto;
	}

	public String getDescrizione_oggetto() {
		return _descrizione_oggetto;
	}

	public void setDescrizione_oggetto(String descrizione_oggetto) {
		_descrizione_oggetto = descrizione_oggetto;
	}

	private long _id_oggetto;
	private String _descrizione_oggetto;
}