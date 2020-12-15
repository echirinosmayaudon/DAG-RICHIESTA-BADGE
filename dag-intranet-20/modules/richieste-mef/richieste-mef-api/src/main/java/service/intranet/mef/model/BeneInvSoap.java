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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.BeneInvServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.BeneInvServiceSoap
 * @generated
 */
@ProviderType
public class BeneInvSoap implements Serializable {
	public static BeneInvSoap toSoapModel(BeneInv model) {
		BeneInvSoap soapModel = new BeneInvSoap();

		soapModel.setId(model.getId());
		soapModel.setBene(model.getBene());
		soapModel.setId_tipo(model.getId_tipo());

		return soapModel;
	}

	public static BeneInvSoap[] toSoapModels(BeneInv[] models) {
		BeneInvSoap[] soapModels = new BeneInvSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BeneInvSoap[][] toSoapModels(BeneInv[][] models) {
		BeneInvSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BeneInvSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BeneInvSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BeneInvSoap[] toSoapModels(List<BeneInv> models) {
		List<BeneInvSoap> soapModels = new ArrayList<BeneInvSoap>(models.size());

		for (BeneInv model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BeneInvSoap[soapModels.size()]);
	}

	public BeneInvSoap() {
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

	public String getBene() {
		return _bene;
	}

	public void setBene(String bene) {
		_bene = bene;
	}

	public long getId_tipo() {
		return _id_tipo;
	}

	public void setId_tipo(long id_tipo) {
		_id_tipo = id_tipo;
	}

	private long _id;
	private String _bene;
	private long _id_tipo;
}