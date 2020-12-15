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
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.TipoEventoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.TipoEventoServiceSoap
 * @generated
 */
@ProviderType
public class TipoEventoSoap implements Serializable {
	public static TipoEventoSoap toSoapModel(TipoEvento model) {
		TipoEventoSoap soapModel = new TipoEventoSoap();

		soapModel.setId_evento(model.getId_evento());
		soapModel.setDesc_evento(model.getDesc_evento());

		return soapModel;
	}

	public static TipoEventoSoap[] toSoapModels(TipoEvento[] models) {
		TipoEventoSoap[] soapModels = new TipoEventoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipoEventoSoap[][] toSoapModels(TipoEvento[][] models) {
		TipoEventoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipoEventoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipoEventoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipoEventoSoap[] toSoapModels(List<TipoEvento> models) {
		List<TipoEventoSoap> soapModels = new ArrayList<TipoEventoSoap>(models.size());

		for (TipoEvento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipoEventoSoap[soapModels.size()]);
	}

	public TipoEventoSoap() {
	}

	public long getPrimaryKey() {
		return _id_evento;
	}

	public void setPrimaryKey(long pk) {
		setId_evento(pk);
	}

	public long getId_evento() {
		return _id_evento;
	}

	public void setId_evento(long id_evento) {
		_id_evento = id_evento;
	}

	public String getDesc_evento() {
		return _desc_evento;
	}

	public void setDesc_evento(String desc_evento) {
		_desc_evento = desc_evento;
	}

	private long _id_evento;
	private String _desc_evento;
}