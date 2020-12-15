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

package servizio.beni.facile.consumo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.beni.facile.consumo.service.http.CambioStatoDirigenteServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.http.CambioStatoDirigenteServiceSoap
 * @generated
 */
@ProviderType
public class CambioStatoDirigenteSoap implements Serializable {
	public static CambioStatoDirigenteSoap toSoapModel(
		CambioStatoDirigente model) {
		CambioStatoDirigenteSoap soapModel = new CambioStatoDirigenteSoap();

		soapModel.setId(model.getId());
		soapModel.setId_rich(model.getId_rich());
		soapModel.setData(model.getData());
		soapModel.setUtente(model.getUtente());
		soapModel.setId_stato(model.getId_stato());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static CambioStatoDirigenteSoap[] toSoapModels(
		CambioStatoDirigente[] models) {
		CambioStatoDirigenteSoap[] soapModels = new CambioStatoDirigenteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CambioStatoDirigenteSoap[][] toSoapModels(
		CambioStatoDirigente[][] models) {
		CambioStatoDirigenteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CambioStatoDirigenteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CambioStatoDirigenteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CambioStatoDirigenteSoap[] toSoapModels(
		List<CambioStatoDirigente> models) {
		List<CambioStatoDirigenteSoap> soapModels = new ArrayList<CambioStatoDirigenteSoap>(models.size());

		for (CambioStatoDirigente model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CambioStatoDirigenteSoap[soapModels.size()]);
	}

	public CambioStatoDirigenteSoap() {
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

	public long getId_rich() {
		return _id_rich;
	}

	public void setId_rich(long id_rich) {
		_id_rich = id_rich;
	}

	public Date getData() {
		return _data;
	}

	public void setData(Date data) {
		_data = data;
	}

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public long getId_stato() {
		return _id_stato;
	}

	public void setId_stato(long id_stato) {
		_id_stato = id_stato;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _id;
	private long _id_rich;
	private Date _data;
	private String _utente;
	private long _id_stato;
	private String _note;
}