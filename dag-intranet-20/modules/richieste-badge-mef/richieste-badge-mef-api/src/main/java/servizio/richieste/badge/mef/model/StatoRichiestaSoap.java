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
 * This class is used by SOAP remote services, specifically {@link servizio.richieste.badge.mef.service.http.StatoRichiestaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.http.StatoRichiestaServiceSoap
 * @generated
 */
@ProviderType
public class StatoRichiestaSoap implements Serializable {
	public static StatoRichiestaSoap toSoapModel(StatoRichiesta model) {
		StatoRichiestaSoap soapModel = new StatoRichiestaSoap();

		soapModel.setId_stato(model.getId_stato());
		soapModel.setDescrizione_stato(model.getDescrizione_stato());

		return soapModel;
	}

	public static StatoRichiestaSoap[] toSoapModels(StatoRichiesta[] models) {
		StatoRichiestaSoap[] soapModels = new StatoRichiestaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatoRichiestaSoap[][] toSoapModels(StatoRichiesta[][] models) {
		StatoRichiestaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatoRichiestaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatoRichiestaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatoRichiestaSoap[] toSoapModels(List<StatoRichiesta> models) {
		List<StatoRichiestaSoap> soapModels = new ArrayList<StatoRichiestaSoap>(models.size());

		for (StatoRichiesta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatoRichiestaSoap[soapModels.size()]);
	}

	public StatoRichiestaSoap() {
	}

	public long getPrimaryKey() {
		return _id_stato;
	}

	public void setPrimaryKey(long pk) {
		setId_stato(pk);
	}

	public long getId_stato() {
		return _id_stato;
	}

	public void setId_stato(long id_stato) {
		_id_stato = id_stato;
	}

	public String getDescrizione_stato() {
		return _descrizione_stato;
	}

	public void setDescrizione_stato(String descrizione_stato) {
		_descrizione_stato = descrizione_stato;
	}

	private long _id_stato;
	private String _descrizione_stato;
}