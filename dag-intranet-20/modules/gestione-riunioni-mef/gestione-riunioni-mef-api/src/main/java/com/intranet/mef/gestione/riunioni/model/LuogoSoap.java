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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.LuogoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.LuogoServiceSoap
 * @generated
 */
@ProviderType
public class LuogoSoap implements Serializable {
	public static LuogoSoap toSoapModel(Luogo model) {
		LuogoSoap soapModel = new LuogoSoap();

		soapModel.setId_luogo(model.getId_luogo());
		soapModel.setNome(model.getNome());

		return soapModel;
	}

	public static LuogoSoap[] toSoapModels(Luogo[] models) {
		LuogoSoap[] soapModels = new LuogoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LuogoSoap[][] toSoapModels(Luogo[][] models) {
		LuogoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LuogoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LuogoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LuogoSoap[] toSoapModels(List<Luogo> models) {
		List<LuogoSoap> soapModels = new ArrayList<LuogoSoap>(models.size());

		for (Luogo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LuogoSoap[soapModels.size()]);
	}

	public LuogoSoap() {
	}

	public long getPrimaryKey() {
		return _id_luogo;
	}

	public void setPrimaryKey(long pk) {
		setId_luogo(pk);
	}

	public long getId_luogo() {
		return _id_luogo;
	}

	public void setId_luogo(long id_luogo) {
		_id_luogo = id_luogo;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	private long _id_luogo;
	private String _nome;
}