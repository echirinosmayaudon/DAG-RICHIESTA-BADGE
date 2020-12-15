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

package com.accenture.lavoro.agile.istanza.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.accenture.lavoro.agile.istanza.mef.service.http.OpzioneRichServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.lavoro.agile.istanza.mef.service.http.OpzioneRichServiceSoap
 * @generated
 */
@ProviderType
public class OpzioneRichSoap implements Serializable {
	public static OpzioneRichSoap toSoapModel(OpzioneRich model) {
		OpzioneRichSoap soapModel = new OpzioneRichSoap();

		soapModel.setId_opt(model.getId_opt());
		soapModel.setLabel_opt(model.getLabel_opt());
		soapModel.setTesto_opt(model.getTesto_opt());
		soapModel.setPeso_opt(model.getPeso_opt());
		soapModel.setData_in(model.getData_in());

		return soapModel;
	}

	public static OpzioneRichSoap[] toSoapModels(OpzioneRich[] models) {
		OpzioneRichSoap[] soapModels = new OpzioneRichSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OpzioneRichSoap[][] toSoapModels(OpzioneRich[][] models) {
		OpzioneRichSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OpzioneRichSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OpzioneRichSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OpzioneRichSoap[] toSoapModels(List<OpzioneRich> models) {
		List<OpzioneRichSoap> soapModels = new ArrayList<OpzioneRichSoap>(models.size());

		for (OpzioneRich model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OpzioneRichSoap[soapModels.size()]);
	}

	public OpzioneRichSoap() {
	}

	public long getPrimaryKey() {
		return _id_opt;
	}

	public void setPrimaryKey(long pk) {
		setId_opt(pk);
	}

	public long getId_opt() {
		return _id_opt;
	}

	public void setId_opt(long id_opt) {
		_id_opt = id_opt;
	}

	public String getLabel_opt() {
		return _label_opt;
	}

	public void setLabel_opt(String label_opt) {
		_label_opt = label_opt;
	}

	public String getTesto_opt() {
		return _testo_opt;
	}

	public void setTesto_opt(String testo_opt) {
		_testo_opt = testo_opt;
	}

	public int getPeso_opt() {
		return _peso_opt;
	}

	public void setPeso_opt(int peso_opt) {
		_peso_opt = peso_opt;
	}

	public Date getData_in() {
		return _data_in;
	}

	public void setData_in(Date data_in) {
		_data_in = data_in;
	}

	private long _id_opt;
	private String _label_opt;
	private String _testo_opt;
	private int _peso_opt;
	private Date _data_in;
}