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

package servizio.beni.facile.consumo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.beni.facile.consumo.service.http.GestioneUtentiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.http.GestioneUtentiServiceSoap
 * @generated
 */
@ProviderType
public class GestioneUtentiSoap implements Serializable {
	public static GestioneUtentiSoap toSoapModel(GestioneUtenti model) {
		GestioneUtentiSoap soapModel = new GestioneUtentiSoap();

		soapModel.setId(model.getId());
		soapModel.setData(model.getData());
		soapModel.setCod_fiscale(model.getCod_fiscale());
		soapModel.setNome(model.getNome());
		soapModel.setCognome(model.getCognome());
		soapModel.setUfficio(model.getUfficio());
		soapModel.setAbilitazione(model.getAbilitazione());
		soapModel.setDelega(model.getDelega());

		return soapModel;
	}

	public static GestioneUtentiSoap[] toSoapModels(GestioneUtenti[] models) {
		GestioneUtentiSoap[] soapModels = new GestioneUtentiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GestioneUtentiSoap[][] toSoapModels(GestioneUtenti[][] models) {
		GestioneUtentiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GestioneUtentiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GestioneUtentiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GestioneUtentiSoap[] toSoapModels(List<GestioneUtenti> models) {
		List<GestioneUtentiSoap> soapModels = new ArrayList<GestioneUtentiSoap>(models.size());

		for (GestioneUtenti model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GestioneUtentiSoap[soapModels.size()]);
	}

	public GestioneUtentiSoap() {
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

	public Date getData() {
		return _data;
	}

	public void setData(Date data) {
		_data = data;
	}

	public String getCod_fiscale() {
		return _cod_fiscale;
	}

	public void setCod_fiscale(String cod_fiscale) {
		_cod_fiscale = cod_fiscale;
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

	public String getUfficio() {
		return _ufficio;
	}

	public void setUfficio(String ufficio) {
		_ufficio = ufficio;
	}

	public boolean getAbilitazione() {
		return _abilitazione;
	}

	public boolean isAbilitazione() {
		return _abilitazione;
	}

	public void setAbilitazione(boolean abilitazione) {
		_abilitazione = abilitazione;
	}

	public boolean getDelega() {
		return _delega;
	}

	public boolean isDelega() {
		return _delega;
	}

	public void setDelega(boolean delega) {
		_delega = delega;
	}

	private long _id;
	private Date _data;
	private String _cod_fiscale;
	private String _nome;
	private String _cognome;
	private String _ufficio;
	private boolean _abilitazione;
	private boolean _delega;
}