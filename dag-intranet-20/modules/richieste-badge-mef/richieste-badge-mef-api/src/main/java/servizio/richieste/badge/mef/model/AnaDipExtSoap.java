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

package servizio.richieste.badge.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.richieste.badge.mef.service.http.AnaDipExtServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.http.AnaDipExtServiceSoap
 * @generated
 */
@ProviderType
public class AnaDipExtSoap implements Serializable {
	public static AnaDipExtSoap toSoapModel(AnaDipExt model) {
		AnaDipExtSoap soapModel = new AnaDipExtSoap();

		soapModel.setId_dip_ext(model.getId_dip_ext());
		soapModel.setNome_dip_ext(model.getNome_dip_ext());
		soapModel.setCognome_dip_ext(model.getCognome_dip_ext());
		soapModel.setCf_dip_ext(model.getCf_dip_ext());
		soapModel.setLuogonascita_dip_ext(model.getLuogonascita_dip_ext());
		soapModel.setDatanascita_dip_ext(model.getDatanascita_dip_ext());

		return soapModel;
	}

	public static AnaDipExtSoap[] toSoapModels(AnaDipExt[] models) {
		AnaDipExtSoap[] soapModels = new AnaDipExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnaDipExtSoap[][] toSoapModels(AnaDipExt[][] models) {
		AnaDipExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnaDipExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnaDipExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnaDipExtSoap[] toSoapModels(List<AnaDipExt> models) {
		List<AnaDipExtSoap> soapModels = new ArrayList<AnaDipExtSoap>(models.size());

		for (AnaDipExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnaDipExtSoap[soapModels.size()]);
	}

	public AnaDipExtSoap() {
	}

	public long getPrimaryKey() {
		return _id_dip_ext;
	}

	public void setPrimaryKey(long pk) {
		setId_dip_ext(pk);
	}

	public long getId_dip_ext() {
		return _id_dip_ext;
	}

	public void setId_dip_ext(long id_dip_ext) {
		_id_dip_ext = id_dip_ext;
	}

	public String getNome_dip_ext() {
		return _nome_dip_ext;
	}

	public void setNome_dip_ext(String nome_dip_ext) {
		_nome_dip_ext = nome_dip_ext;
	}

	public String getCognome_dip_ext() {
		return _cognome_dip_ext;
	}

	public void setCognome_dip_ext(String cognome_dip_ext) {
		_cognome_dip_ext = cognome_dip_ext;
	}

	public String getCf_dip_ext() {
		return _cf_dip_ext;
	}

	public void setCf_dip_ext(String cf_dip_ext) {
		_cf_dip_ext = cf_dip_ext;
	}

	public String getLuogonascita_dip_ext() {
		return _luogonascita_dip_ext;
	}

	public void setLuogonascita_dip_ext(String luogonascita_dip_ext) {
		_luogonascita_dip_ext = luogonascita_dip_ext;
	}

	public Date getDatanascita_dip_ext() {
		return _datanascita_dip_ext;
	}

	public void setDatanascita_dip_ext(Date datanascita_dip_ext) {
		_datanascita_dip_ext = datanascita_dip_ext;
	}

	private long _id_dip_ext;
	private String _nome_dip_ext;
	private String _cognome_dip_ext;
	private String _cf_dip_ext;
	private String _luogonascita_dip_ext;
	private Date _datanascita_dip_ext;
}