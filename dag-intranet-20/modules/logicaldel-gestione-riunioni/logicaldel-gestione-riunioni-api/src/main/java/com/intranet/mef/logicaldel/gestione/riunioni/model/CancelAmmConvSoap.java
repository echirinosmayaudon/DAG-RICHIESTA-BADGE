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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.logicaldel.gestione.riunioni.service.http.CancelAmmConvServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.http.CancelAmmConvServiceSoap
 * @generated
 */
@ProviderType
public class CancelAmmConvSoap implements Serializable {
	public static CancelAmmConvSoap toSoapModel(CancelAmmConv model) {
		CancelAmmConvSoap soapModel = new CancelAmmConvSoap();

		soapModel.setId_amministrazione_convocante(model.getId_amministrazione_convocante());
		soapModel.setCancellato(model.getCancellato());

		return soapModel;
	}

	public static CancelAmmConvSoap[] toSoapModels(CancelAmmConv[] models) {
		CancelAmmConvSoap[] soapModels = new CancelAmmConvSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CancelAmmConvSoap[][] toSoapModels(CancelAmmConv[][] models) {
		CancelAmmConvSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CancelAmmConvSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CancelAmmConvSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CancelAmmConvSoap[] toSoapModels(List<CancelAmmConv> models) {
		List<CancelAmmConvSoap> soapModels = new ArrayList<CancelAmmConvSoap>(models.size());

		for (CancelAmmConv model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CancelAmmConvSoap[soapModels.size()]);
	}

	public CancelAmmConvSoap() {
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

	public boolean getCancellato() {
		return _cancellato;
	}

	public boolean isCancellato() {
		return _cancellato;
	}

	public void setCancellato(boolean cancellato) {
		_cancellato = cancellato;
	}

	private long _id_amministrazione_convocante;
	private boolean _cancellato;
}