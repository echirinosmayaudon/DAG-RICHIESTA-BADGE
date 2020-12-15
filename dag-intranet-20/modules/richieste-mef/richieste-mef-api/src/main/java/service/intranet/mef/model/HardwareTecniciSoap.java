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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.HardwareTecniciServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.HardwareTecniciServiceSoap
 * @generated
 */
@ProviderType
public class HardwareTecniciSoap implements Serializable {
	public static HardwareTecniciSoap toSoapModel(HardwareTecnici model) {
		HardwareTecniciSoap soapModel = new HardwareTecniciSoap();

		soapModel.setId(model.getId());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static HardwareTecniciSoap[] toSoapModels(HardwareTecnici[] models) {
		HardwareTecniciSoap[] soapModels = new HardwareTecniciSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HardwareTecniciSoap[][] toSoapModels(
		HardwareTecnici[][] models) {
		HardwareTecniciSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HardwareTecniciSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HardwareTecniciSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HardwareTecniciSoap[] toSoapModels(
		List<HardwareTecnici> models) {
		List<HardwareTecniciSoap> soapModels = new ArrayList<HardwareTecniciSoap>(models.size());

		for (HardwareTecnici model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HardwareTecniciSoap[soapModels.size()]);
	}

	public HardwareTecniciSoap() {
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

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id;
	private String _descrizione;
}