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
 * This class is used by SOAP remote services, specifically {@link servizio.richieste.badge.mef.service.http.SediEsterneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.http.SediEsterneServiceSoap
 * @generated
 */
@ProviderType
public class SediEsterneSoap implements Serializable {
	public static SediEsterneSoap toSoapModel(SediEsterne model) {
		SediEsterneSoap soapModel = new SediEsterneSoap();

		soapModel.setId_sede_esterna(model.getId_sede_esterna());
		soapModel.setNome_sede_esterna(model.getNome_sede_esterna());
		soapModel.setId_sedesiap(model.getId_sedesiap());
		soapModel.setAcronimo_sede(model.getAcronimo_sede());

		return soapModel;
	}

	public static SediEsterneSoap[] toSoapModels(SediEsterne[] models) {
		SediEsterneSoap[] soapModels = new SediEsterneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SediEsterneSoap[][] toSoapModels(SediEsterne[][] models) {
		SediEsterneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SediEsterneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SediEsterneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SediEsterneSoap[] toSoapModels(List<SediEsterne> models) {
		List<SediEsterneSoap> soapModels = new ArrayList<SediEsterneSoap>(models.size());

		for (SediEsterne model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SediEsterneSoap[soapModels.size()]);
	}

	public SediEsterneSoap() {
	}

	public long getPrimaryKey() {
		return _id_sede_esterna;
	}

	public void setPrimaryKey(long pk) {
		setId_sede_esterna(pk);
	}

	public long getId_sede_esterna() {
		return _id_sede_esterna;
	}

	public void setId_sede_esterna(long id_sede_esterna) {
		_id_sede_esterna = id_sede_esterna;
	}

	public String getNome_sede_esterna() {
		return _nome_sede_esterna;
	}

	public void setNome_sede_esterna(String nome_sede_esterna) {
		_nome_sede_esterna = nome_sede_esterna;
	}

	public long getId_sedesiap() {
		return _id_sedesiap;
	}

	public void setId_sedesiap(long id_sedesiap) {
		_id_sedesiap = id_sedesiap;
	}

	public String getAcronimo_sede() {
		return _acronimo_sede;
	}

	public void setAcronimo_sede(String acronimo_sede) {
		_acronimo_sede = acronimo_sede;
	}

	private long _id_sede_esterna;
	private String _nome_sede_esterna;
	private long _id_sedesiap;
	private String _acronimo_sede;
}