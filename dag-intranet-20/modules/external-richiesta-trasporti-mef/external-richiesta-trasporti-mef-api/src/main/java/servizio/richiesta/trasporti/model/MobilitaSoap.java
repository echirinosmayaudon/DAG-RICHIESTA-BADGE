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

package servizio.richiesta.trasporti.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.richiesta.trasporti.service.http.MobilitaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richiesta.trasporti.service.http.MobilitaServiceSoap
 * @generated
 */
@ProviderType
public class MobilitaSoap implements Serializable {
	public static MobilitaSoap toSoapModel(Mobilita model) {
		MobilitaSoap soapModel = new MobilitaSoap();

		soapModel.setCustom_key(model.getCustom_key());
		soapModel.setPerson_id(model.getPerson_id());
		soapModel.setTipo_mobilita(model.getTipo_mobilita());

		return soapModel;
	}

	public static MobilitaSoap[] toSoapModels(Mobilita[] models) {
		MobilitaSoap[] soapModels = new MobilitaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MobilitaSoap[][] toSoapModels(Mobilita[][] models) {
		MobilitaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MobilitaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MobilitaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MobilitaSoap[] toSoapModels(List<Mobilita> models) {
		List<MobilitaSoap> soapModels = new ArrayList<MobilitaSoap>(models.size());

		for (Mobilita model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MobilitaSoap[soapModels.size()]);
	}

	public MobilitaSoap() {
	}

	public String getPrimaryKey() {
		return _custom_key;
	}

	public void setPrimaryKey(String pk) {
		setCustom_key(pk);
	}

	public String getCustom_key() {
		return _custom_key;
	}

	public void setCustom_key(String custom_key) {
		_custom_key = custom_key;
	}

	public long getPerson_id() {
		return _person_id;
	}

	public void setPerson_id(long person_id) {
		_person_id = person_id;
	}

	public String getTipo_mobilita() {
		return _tipo_mobilita;
	}

	public void setTipo_mobilita(String tipo_mobilita) {
		_tipo_mobilita = tipo_mobilita;
	}

	private String _custom_key;
	private long _person_id;
	private String _tipo_mobilita;
}