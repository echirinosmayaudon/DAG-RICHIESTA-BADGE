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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.RichiesteHWServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.RichiesteHWServiceSoap
 * @generated
 */
@ProviderType
public class RichiesteHWSoap implements Serializable {
	public static RichiesteHWSoap toSoapModel(RichiesteHW model) {
		RichiesteHWSoap soapModel = new RichiesteHWSoap();

		soapModel.setId_richieste_hw(model.getId_richieste_hw());
		soapModel.setUtente(model.getUtente());
		soapModel.setDettaglio(model.getDettaglio());
		soapModel.setData_richiesta(model.getData_richiesta());

		return soapModel;
	}

	public static RichiesteHWSoap[] toSoapModels(RichiesteHW[] models) {
		RichiesteHWSoap[] soapModels = new RichiesteHWSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiesteHWSoap[][] toSoapModels(RichiesteHW[][] models) {
		RichiesteHWSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiesteHWSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiesteHWSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiesteHWSoap[] toSoapModels(List<RichiesteHW> models) {
		List<RichiesteHWSoap> soapModels = new ArrayList<RichiesteHWSoap>(models.size());

		for (RichiesteHW model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiesteHWSoap[soapModels.size()]);
	}

	public RichiesteHWSoap() {
	}

	public long getPrimaryKey() {
		return _id_richieste_hw;
	}

	public void setPrimaryKey(long pk) {
		setId_richieste_hw(pk);
	}

	public long getId_richieste_hw() {
		return _id_richieste_hw;
	}

	public void setId_richieste_hw(long id_richieste_hw) {
		_id_richieste_hw = id_richieste_hw;
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

	public Date getData_richiesta() {
		return _data_richiesta;
	}

	public void setData_richiesta(Date data_richiesta) {
		_data_richiesta = data_richiesta;
	}

	private long _id_richieste_hw;
	private String _utente;
	private String _dettaglio;
	private Date _data_richiesta;
}