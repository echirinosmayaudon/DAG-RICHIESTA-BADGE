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

package com.intranet.mef.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.AmministrazioneConvocanteServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.AmministrazioneConvocanteServiceSoap
 * @generated
 */
@ProviderType
public class AmministrazioneConvocanteSoap implements Serializable {
	public static AmministrazioneConvocanteSoap toSoapModel(
		AmministrazioneConvocante model) {
		AmministrazioneConvocanteSoap soapModel = new AmministrazioneConvocanteSoap();

		soapModel.setId_amministrazione_convocante(model.getId_amministrazione_convocante());
		soapModel.setNome_amministrazione(model.getNome_amministrazione());

		return soapModel;
	}

	public static AmministrazioneConvocanteSoap[] toSoapModels(
		AmministrazioneConvocante[] models) {
		AmministrazioneConvocanteSoap[] soapModels = new AmministrazioneConvocanteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AmministrazioneConvocanteSoap[][] toSoapModels(
		AmministrazioneConvocante[][] models) {
		AmministrazioneConvocanteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AmministrazioneConvocanteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AmministrazioneConvocanteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AmministrazioneConvocanteSoap[] toSoapModels(
		List<AmministrazioneConvocante> models) {
		List<AmministrazioneConvocanteSoap> soapModels = new ArrayList<AmministrazioneConvocanteSoap>(models.size());

		for (AmministrazioneConvocante model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AmministrazioneConvocanteSoap[soapModels.size()]);
	}

	public AmministrazioneConvocanteSoap() {
	}

	public long getPrimaryKey() {
		return _id_amministrazione_convocante;
	}

	public void setPrimaryKey(long pk) {
		setId_amministrazione_convocante(pk);
	}

	public long getId_amministrazione_convocante() {
		return _id_amministrazione_convocante;
	}

	public void setId_amministrazione_convocante(
		long id_amministrazione_convocante) {
		_id_amministrazione_convocante = id_amministrazione_convocante;
	}

	public String getNome_amministrazione() {
		return _nome_amministrazione;
	}

	public void setNome_amministrazione(String nome_amministrazione) {
		_nome_amministrazione = nome_amministrazione;
	}

	private long _id_amministrazione_convocante;
	private String _nome_amministrazione;
}