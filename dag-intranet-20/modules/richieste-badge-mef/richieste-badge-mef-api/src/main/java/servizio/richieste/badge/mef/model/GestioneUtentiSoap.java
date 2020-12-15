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
 * This class is used by SOAP remote services, specifically {@link servizio.richieste.badge.mef.service.http.GestioneUtentiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.http.GestioneUtentiServiceSoap
 * @generated
 */
@ProviderType
public class GestioneUtentiSoap implements Serializable {
	public static GestioneUtentiSoap toSoapModel(GestioneUtenti model) {
		GestioneUtentiSoap soapModel = new GestioneUtentiSoap();

		soapModel.setId_gest_utenti(model.getId_gest_utenti());
		soapModel.setData(model.getData());
		soapModel.setScreename_dirigente(model.getScreename_dirigente());
		soapModel.setScreename_utente(model.getScreename_utente());
		soapModel.setId_ufficio(model.getId_ufficio());
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
		return _id_gest_utenti;
	}

	public void setPrimaryKey(long pk) {
		setId_gest_utenti(pk);
	}

	public long getId_gest_utenti() {
		return _id_gest_utenti;
	}

	public void setId_gest_utenti(long id_gest_utenti) {
		_id_gest_utenti = id_gest_utenti;
	}

	public Date getData() {
		return _data;
	}

	public void setData(Date data) {
		_data = data;
	}

	public String getScreename_dirigente() {
		return _screename_dirigente;
	}

	public void setScreename_dirigente(String screename_dirigente) {
		_screename_dirigente = screename_dirigente;
	}

	public String getScreename_utente() {
		return _screename_utente;
	}

	public void setScreename_utente(String screename_utente) {
		_screename_utente = screename_utente;
	}

	public long getId_ufficio() {
		return _id_ufficio;
	}

	public void setId_ufficio(long id_ufficio) {
		_id_ufficio = id_ufficio;
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

	private long _id_gest_utenti;
	private Date _data;
	private String _screename_dirigente;
	private String _screename_utente;
	private long _id_ufficio;
	private boolean _abilitazione;
	private boolean _delega;
}