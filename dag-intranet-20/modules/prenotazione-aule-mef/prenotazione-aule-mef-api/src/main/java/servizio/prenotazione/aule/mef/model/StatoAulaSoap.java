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
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.StatoAulaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.StatoAulaServiceSoap
 * @generated
 */
@ProviderType
public class StatoAulaSoap implements Serializable {
	public static StatoAulaSoap toSoapModel(StatoAula model) {
		StatoAulaSoap soapModel = new StatoAulaSoap();

		soapModel.setId_stato_aula(model.getId_stato_aula());
		soapModel.setDesc_stato(model.getDesc_stato());

		return soapModel;
	}

	public static StatoAulaSoap[] toSoapModels(StatoAula[] models) {
		StatoAulaSoap[] soapModels = new StatoAulaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatoAulaSoap[][] toSoapModels(StatoAula[][] models) {
		StatoAulaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatoAulaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatoAulaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatoAulaSoap[] toSoapModels(List<StatoAula> models) {
		List<StatoAulaSoap> soapModels = new ArrayList<StatoAulaSoap>(models.size());

		for (StatoAula model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatoAulaSoap[soapModels.size()]);
	}

	public StatoAulaSoap() {
	}

	public long getPrimaryKey() {
		return _id_stato_aula;
	}

	public void setPrimaryKey(long pk) {
		setId_stato_aula(pk);
	}

	public long getId_stato_aula() {
		return _id_stato_aula;
	}

	public void setId_stato_aula(long id_stato_aula) {
		_id_stato_aula = id_stato_aula;
	}

	public String getDesc_stato() {
		return _desc_stato;
	}

	public void setDesc_stato(String desc_stato) {
		_desc_stato = desc_stato;
	}

	private long _id_stato_aula;
	private String _desc_stato;
}