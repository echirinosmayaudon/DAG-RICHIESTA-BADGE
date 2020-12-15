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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.TipoBeneInvServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.TipoBeneInvServiceSoap
 * @generated
 */
@ProviderType
public class TipoBeneInvSoap implements Serializable {
	public static TipoBeneInvSoap toSoapModel(TipoBeneInv model) {
		TipoBeneInvSoap soapModel = new TipoBeneInvSoap();

		soapModel.setId(model.getId());
		soapModel.setTipo(model.getTipo());

		return soapModel;
	}

	public static TipoBeneInvSoap[] toSoapModels(TipoBeneInv[] models) {
		TipoBeneInvSoap[] soapModels = new TipoBeneInvSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipoBeneInvSoap[][] toSoapModels(TipoBeneInv[][] models) {
		TipoBeneInvSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipoBeneInvSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipoBeneInvSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipoBeneInvSoap[] toSoapModels(List<TipoBeneInv> models) {
		List<TipoBeneInvSoap> soapModels = new ArrayList<TipoBeneInvSoap>(models.size());

		for (TipoBeneInv model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipoBeneInvSoap[soapModels.size()]);
	}

	public TipoBeneInvSoap() {
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

	public String getTipo() {
		return _tipo;
	}

	public void setTipo(String tipo) {
		_tipo = tipo;
	}

	private long _id;
	private String _tipo;
}