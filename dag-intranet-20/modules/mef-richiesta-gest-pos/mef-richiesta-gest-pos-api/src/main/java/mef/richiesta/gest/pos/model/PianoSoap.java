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

package mef.richiesta.gest.pos.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PianoSoap implements Serializable {

	public static PianoSoap toSoapModel(Piano model) {
		PianoSoap soapModel = new PianoSoap();

		soapModel.setId_pk_piano(model.getId_pk_piano());
		soapModel.setId_piano(model.getId_piano());
		soapModel.setId_sede(model.getId_sede());
		soapModel.setCod_piano(model.getCod_piano());
		soapModel.setDesc(model.getDesc());
		soapModel.setData_ins(model.getData_ins());
		soapModel.setData_agg(model.getData_agg());
		soapModel.setUser_ins(model.getUser_ins());
		soapModel.setUser_agg(model.getUser_agg());

		return soapModel;
	}

	public static PianoSoap[] toSoapModels(Piano[] models) {
		PianoSoap[] soapModels = new PianoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PianoSoap[][] toSoapModels(Piano[][] models) {
		PianoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PianoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PianoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PianoSoap[] toSoapModels(List<Piano> models) {
		List<PianoSoap> soapModels = new ArrayList<PianoSoap>(models.size());

		for (Piano model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PianoSoap[soapModels.size()]);
	}

	public PianoSoap() {
	}

	public long getPrimaryKey() {
		return _id_pk_piano;
	}

	public void setPrimaryKey(long pk) {
		setId_pk_piano(pk);
	}

	public long getId_pk_piano() {
		return _id_pk_piano;
	}

	public void setId_pk_piano(long id_pk_piano) {
		_id_pk_piano = id_pk_piano;
	}

	public long getId_piano() {
		return _id_piano;
	}

	public void setId_piano(long id_piano) {
		_id_piano = id_piano;
	}

	public long getId_sede() {
		return _id_sede;
	}

	public void setId_sede(long id_sede) {
		_id_sede = id_sede;
	}

	public String getCod_piano() {
		return _cod_piano;
	}

	public void setCod_piano(String cod_piano) {
		_cod_piano = cod_piano;
	}

	public String getDesc() {
		return _desc;
	}

	public void setDesc(String desc) {
		_desc = desc;
	}

	public String getData_ins() {
		return _data_ins;
	}

	public void setData_ins(String data_ins) {
		_data_ins = data_ins;
	}

	public String getData_agg() {
		return _data_agg;
	}

	public void setData_agg(String data_agg) {
		_data_agg = data_agg;
	}

	public String getUser_ins() {
		return _user_ins;
	}

	public void setUser_ins(String user_ins) {
		_user_ins = user_ins;
	}

	public String getUser_agg() {
		return _user_agg;
	}

	public void setUser_agg(String user_agg) {
		_user_agg = user_agg;
	}

	private long _id_pk_piano;
	private long _id_piano;
	private long _id_sede;
	private String _cod_piano;
	private String _desc;
	private String _data_ins;
	private String _data_agg;
	private String _user_ins;
	private String _user_agg;

}