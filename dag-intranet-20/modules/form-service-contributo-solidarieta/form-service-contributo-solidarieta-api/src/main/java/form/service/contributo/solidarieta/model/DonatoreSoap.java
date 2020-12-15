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

package form.service.contributo.solidarieta.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link form.service.contributo.solidarieta.service.http.DonatoreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DonatoreSoap implements Serializable {

	public static DonatoreSoap toSoapModel(Donatore model) {
		DonatoreSoap soapModel = new DonatoreSoap();

		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setCognome(model.getCognome());
		soapModel.setCod_fiscale(model.getCod_fiscale());
		soapModel.setEmail(model.getEmail());
		soapModel.setImporto(model.getImporto());
		soapModel.setData_inserimento(model.getData_inserimento());

		return soapModel;
	}

	public static DonatoreSoap[] toSoapModels(Donatore[] models) {
		DonatoreSoap[] soapModels = new DonatoreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DonatoreSoap[][] toSoapModels(Donatore[][] models) {
		DonatoreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DonatoreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DonatoreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DonatoreSoap[] toSoapModels(List<Donatore> models) {
		List<DonatoreSoap> soapModels = new ArrayList<DonatoreSoap>(
			models.size());

		for (Donatore model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DonatoreSoap[soapModels.size()]);
	}

	public DonatoreSoap() {
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

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getCognome() {
		return _cognome;
	}

	public void setCognome(String cognome) {
		_cognome = cognome;
	}

	public String getCod_fiscale() {
		return _cod_fiscale;
	}

	public void setCod_fiscale(String cod_fiscale) {
		_cod_fiscale = cod_fiscale;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getImporto() {
		return _importo;
	}

	public void setImporto(String importo) {
		_importo = importo;
	}

	public String getData_inserimento() {
		return _data_inserimento;
	}

	public void setData_inserimento(String data_inserimento) {
		_data_inserimento = data_inserimento;
	}

	private long _id;
	private String _nome;
	private String _cognome;
	private String _cod_fiscale;
	private String _email;
	private String _importo;
	private String _data_inserimento;

}