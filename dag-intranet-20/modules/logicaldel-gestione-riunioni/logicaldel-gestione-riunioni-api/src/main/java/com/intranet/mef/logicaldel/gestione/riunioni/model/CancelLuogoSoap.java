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

package com.intranet.mef.logicaldel.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.logicaldel.gestione.riunioni.service.http.CancelLuogoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.http.CancelLuogoServiceSoap
 * @generated
 */
@ProviderType
public class CancelLuogoSoap implements Serializable {
	public static CancelLuogoSoap toSoapModel(CancelLuogo model) {
		CancelLuogoSoap soapModel = new CancelLuogoSoap();

		soapModel.setId_luogo(model.getId_luogo());
		soapModel.setCancellato(model.getCancellato());

		return soapModel;
	}

	public static CancelLuogoSoap[] toSoapModels(CancelLuogo[] models) {
		CancelLuogoSoap[] soapModels = new CancelLuogoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CancelLuogoSoap[][] toSoapModels(CancelLuogo[][] models) {
		CancelLuogoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CancelLuogoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CancelLuogoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CancelLuogoSoap[] toSoapModels(List<CancelLuogo> models) {
		List<CancelLuogoSoap> soapModels = new ArrayList<CancelLuogoSoap>(models.size());

		for (CancelLuogo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CancelLuogoSoap[soapModels.size()]);
	}

	public CancelLuogoSoap() {
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

	public boolean getCancellato() {
		return _cancellato;
	}

	public boolean isCancellato() {
		return _cancellato;
	}

	public void setCancellato(boolean cancellato) {
		_cancellato = cancellato;
	}

	private long _id_luogo;
	private boolean _cancellato;
}