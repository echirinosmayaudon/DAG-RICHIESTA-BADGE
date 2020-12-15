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

package service.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.RichiestaInterventiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.RichiestaInterventiServiceSoap
 * @generated
 */
@ProviderType
public class RichiestaInterventiSoap implements Serializable {
	public static RichiestaInterventiSoap toSoapModel(RichiestaInterventi model) {
		RichiestaInterventiSoap soapModel = new RichiestaInterventiSoap();

		soapModel.setId(model.getId());
		soapModel.setUtente(model.getUtente());
		soapModel.setDettaglio(model.getDettaglio());
		soapModel.setData_interventi(model.getData_interventi());

		return soapModel;
	}

	public static RichiestaInterventiSoap[] toSoapModels(
		RichiestaInterventi[] models) {
		RichiestaInterventiSoap[] soapModels = new RichiestaInterventiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiestaInterventiSoap[][] toSoapModels(
		RichiestaInterventi[][] models) {
		RichiestaInterventiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiestaInterventiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiestaInterventiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiestaInterventiSoap[] toSoapModels(
		List<RichiestaInterventi> models) {
		List<RichiestaInterventiSoap> soapModels = new ArrayList<RichiestaInterventiSoap>(models.size());

		for (RichiestaInterventi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiestaInterventiSoap[soapModels.size()]);
	}

	public RichiestaInterventiSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public String getDettaglio() {
		return _dettaglio;
	}

	public void setDettaglio(String dettaglio) {
		_dettaglio = dettaglio;
	}

	public Date getData_interventi() {
		return _data_interventi;
	}

	public void setData_interventi(Date data_interventi) {
		_data_interventi = data_interventi;
	}

	private long _id;
	private String _utente;
	private String _dettaglio;
	private Date _data_interventi;
}