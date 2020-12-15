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
public class SedeSoap implements Serializable {

	public static SedeSoap toSoapModel(Sede model) {
		SedeSoap soapModel = new SedeSoap();

		soapModel.setId_pk_sede(model.getId_pk_sede());
		soapModel.setId_sede(model.getId_sede());
		soapModel.setCod_sede(model.getCod_sede());
		soapModel.setDesc(model.getDesc());
		soapModel.setData_ins(model.getData_ins());
		soapModel.setData_agg(model.getData_agg());
		soapModel.setUser_ins(model.getUser_ins());
		soapModel.setUser_agg(model.getUser_agg());

		return soapModel;
	}

	public static SedeSoap[] toSoapModels(Sede[] models) {
		SedeSoap[] soapModels = new SedeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SedeSoap[][] toSoapModels(Sede[][] models) {
		SedeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SedeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SedeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SedeSoap[] toSoapModels(List<Sede> models) {
		List<SedeSoap> soapModels = new ArrayList<SedeSoap>(models.size());

		for (Sede model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SedeSoap[soapModels.size()]);
	}

	public SedeSoap() {
	}

	public long getPrimaryKey() {
		return _id_pk_sede;
	}

	public void setPrimaryKey(long pk) {
		setId_pk_sede(pk);
	}

	public long getId_pk_sede() {
		return _id_pk_sede;
	}

	public void setId_pk_sede(long id_pk_sede) {
		_id_pk_sede = id_pk_sede;
	}

	public long getId_sede() {
		return _id_sede;
	}

	public void setId_sede(long id_sede) {
		_id_sede = id_sede;
	}

	public String getCod_sede() {
		return _cod_sede;
	}

	public void setCod_sede(String cod_sede) {
		_cod_sede = cod_sede;
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

	private long _id_pk_sede;
	private long _id_sede;
	private String _cod_sede;
	private String _desc;
	private String _data_ins;
	private String _data_agg;
	private String _user_ins;
	private String _user_agg;

}