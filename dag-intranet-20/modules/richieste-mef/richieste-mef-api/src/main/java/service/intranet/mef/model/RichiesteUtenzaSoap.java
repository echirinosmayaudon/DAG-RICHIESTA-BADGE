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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.RichiesteUtenzaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.RichiesteUtenzaServiceSoap
 * @generated
 */
@ProviderType
public class RichiesteUtenzaSoap implements Serializable {
	public static RichiesteUtenzaSoap toSoapModel(RichiesteUtenza model) {
		RichiesteUtenzaSoap soapModel = new RichiesteUtenzaSoap();

		soapModel.setId_richieste_utenza(model.getId_richieste_utenza());
		soapModel.setUtente(model.getUtente());
		soapModel.setDestinatario(model.getDestinatario());
		soapModel.setDettaglio(model.getDettaglio());
		soapModel.setData_richiesta(model.getData_richiesta());

		return soapModel;
	}

	public static RichiesteUtenzaSoap[] toSoapModels(RichiesteUtenza[] models) {
		RichiesteUtenzaSoap[] soapModels = new RichiesteUtenzaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiesteUtenzaSoap[][] toSoapModels(
		RichiesteUtenza[][] models) {
		RichiesteUtenzaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiesteUtenzaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiesteUtenzaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiesteUtenzaSoap[] toSoapModels(
		List<RichiesteUtenza> models) {
		List<RichiesteUtenzaSoap> soapModels = new ArrayList<RichiesteUtenzaSoap>(models.size());

		for (RichiesteUtenza model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiesteUtenzaSoap[soapModels.size()]);
	}

	public RichiesteUtenzaSoap() {
	}

	public long getPrimaryKey() {
		return _id_richieste_utenza;
	}

	public void setPrimaryKey(long pk) {
		setId_richieste_utenza(pk);
	}

	public long getId_richieste_utenza() {
		return _id_richieste_utenza;
	}

	public void setId_richieste_utenza(long id_richieste_utenza) {
		_id_richieste_utenza = id_richieste_utenza;
	}

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public String getDestinatario() {
		return _destinatario;
	}

	public void setDestinatario(String destinatario) {
		_destinatario = destinatario;
	}

	public String getDettaglio() {
		return _dettaglio;
	}

	public void setDettaglio(String dettaglio) {
		_dettaglio = dettaglio;
	}

	public Date getData_richiesta() {
		return _data_richiesta;
	}

	public void setData_richiesta(Date data_richiesta) {
		_data_richiesta = data_richiesta;
	}

	private long _id_richieste_utenza;
	private String _utente;
	private String _destinatario;
	private String _dettaglio;
	private Date _data_richiesta;
}