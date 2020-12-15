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

package servizio.prenotazione.aule.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.OrarioServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.OrarioServiceSoap
 * @generated
 */
@ProviderType
public class OrarioSoap implements Serializable {
	public static OrarioSoap toSoapModel(Orario model) {
		OrarioSoap soapModel = new OrarioSoap();

		soapModel.setId_ora(model.getId_ora());
		soapModel.setOre(model.getOre());

		return soapModel;
	}

	public static OrarioSoap[] toSoapModels(Orario[] models) {
		OrarioSoap[] soapModels = new OrarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrarioSoap[][] toSoapModels(Orario[][] models) {
		OrarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrarioSoap[] toSoapModels(List<Orario> models) {
		List<OrarioSoap> soapModels = new ArrayList<OrarioSoap>(models.size());

		for (Orario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrarioSoap[soapModels.size()]);
	}

	public OrarioSoap() {
	}

	public long getPrimaryKey() {
		return _id_ora;
	}

	public void setPrimaryKey(long pk) {
		setId_ora(pk);
	}

	public long getId_ora() {
		return _id_ora;
	}

	public void setId_ora(long id_ora) {
		_id_ora = id_ora;
	}

	public String getOre() {
		return _ore;
	}

	public void setOre(String ore) {
		_ore = ore;
	}

	private long _id_ora;
	private String _ore;
}