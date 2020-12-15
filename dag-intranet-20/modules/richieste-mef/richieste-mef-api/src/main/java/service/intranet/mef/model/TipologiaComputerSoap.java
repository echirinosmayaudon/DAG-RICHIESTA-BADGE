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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.TipologiaComputerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.TipologiaComputerServiceSoap
 * @generated
 */
@ProviderType
public class TipologiaComputerSoap implements Serializable {
	public static TipologiaComputerSoap toSoapModel(TipologiaComputer model) {
		TipologiaComputerSoap soapModel = new TipologiaComputerSoap();

		soapModel.setId_tipologia_computer(model.getId_tipologia_computer());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static TipologiaComputerSoap[] toSoapModels(
		TipologiaComputer[] models) {
		TipologiaComputerSoap[] soapModels = new TipologiaComputerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipologiaComputerSoap[][] toSoapModels(
		TipologiaComputer[][] models) {
		TipologiaComputerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipologiaComputerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipologiaComputerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipologiaComputerSoap[] toSoapModels(
		List<TipologiaComputer> models) {
		List<TipologiaComputerSoap> soapModels = new ArrayList<TipologiaComputerSoap>(models.size());

		for (TipologiaComputer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipologiaComputerSoap[soapModels.size()]);
	}

	public TipologiaComputerSoap() {
	}

	public long getPrimaryKey() {
		return _id_tipologia_computer;
	}

	public void setPrimaryKey(long pk) {
		setId_tipologia_computer(pk);
	}

	public long getId_tipologia_computer() {
		return _id_tipologia_computer;
	}

	public void setId_tipologia_computer(long id_tipologia_computer) {
		_id_tipologia_computer = id_tipologia_computer;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id_tipologia_computer;
	private String _descrizione;
}