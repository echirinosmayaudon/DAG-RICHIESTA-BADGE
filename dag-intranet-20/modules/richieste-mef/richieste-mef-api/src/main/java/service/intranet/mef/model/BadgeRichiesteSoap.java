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

package service.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.BadgeRichiesteServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.BadgeRichiesteServiceSoap
 * @generated
 */
@ProviderType
public class BadgeRichiesteSoap implements Serializable {
	public static BadgeRichiesteSoap toSoapModel(BadgeRichieste model) {
		BadgeRichiesteSoap soapModel = new BadgeRichiesteSoap();

		soapModel.setId(model.getId());
		soapModel.setUtente(model.getUtente());
		soapModel.setDettaglio_richiedente(model.getDettaglio_richiedente());
		soapModel.setCognome(model.getCognome());
		soapModel.setNome(model.getNome());
		soapModel.setLuogo_nascita(model.getLuogo_nascita());
		soapModel.setData_nascita(model.getData_nascita());
		soapModel.setCodice_fiscale(model.getCodice_fiscale());
		soapModel.setNumerobadge(model.getNumerobadge());
		soapModel.setAllegatoUuid(model.getAllegatoUuid());
		soapModel.setOperazione(model.getOperazione());
		soapModel.setData_richiesta(model.getData_richiesta());
		soapModel.setProcedura(model.getProcedura());
		soapModel.setDisattivazione(model.getDisattivazione());

		return soapModel;
	}

	public static BadgeRichiesteSoap[] toSoapModels(BadgeRichieste[] models) {
		BadgeRichiesteSoap[] soapModels = new BadgeRichiesteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BadgeRichiesteSoap[][] toSoapModels(BadgeRichieste[][] models) {
		BadgeRichiesteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BadgeRichiesteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BadgeRichiesteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BadgeRichiesteSoap[] toSoapModels(List<BadgeRichieste> models) {
		List<BadgeRichiesteSoap> soapModels = new ArrayList<BadgeRichiesteSoap>(models.size());

		for (BadgeRichieste model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BadgeRichiesteSoap[soapModels.size()]);
	}

	public BadgeRichiesteSoap() {
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

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public String getDettaglio_richiedente() {
		return _dettaglio_richiedente;
	}

	public void setDettaglio_richiedente(String dettaglio_richiedente) {
		_dettaglio_richiedente = dettaglio_richiedente;
	}

	public String getCognome() {
		return _cognome;
	}

	public void setCognome(String cognome) {
		_cognome = cognome;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getLuogo_nascita() {
		return _luogo_nascita;
	}

	public void setLuogo_nascita(String luogo_nascita) {
		_luogo_nascita = luogo_nascita;
	}

	public Date getData_nascita() {
		return _data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		_data_nascita = data_nascita;
	}

	public String getCodice_fiscale() {
		return _codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		_codice_fiscale = codice_fiscale;
	}

	public String getNumerobadge() {
		return _numerobadge;
	}

	public void setNumerobadge(String numerobadge) {
		_numerobadge = numerobadge;
	}

	public String getAllegatoUuid() {
		return _allegatoUuid;
	}

	public void setAllegatoUuid(String allegatoUuid) {
		_allegatoUuid = allegatoUuid;
	}

	public String getOperazione() {
		return _operazione;
	}

	public void setOperazione(String operazione) {
		_operazione = operazione;
	}

	public Date getData_richiesta() {
		return _data_richiesta;
	}

	public void setData_richiesta(Date data_richiesta) {
		_data_richiesta = data_richiesta;
	}

	public String getProcedura() {
		return _procedura;
	}

	public void setProcedura(String procedura) {
		_procedura = procedura;
	}

	public Date getDisattivazione() {
		return _disattivazione;
	}

	public void setDisattivazione(Date disattivazione) {
		_disattivazione = disattivazione;
	}

	private long _id;
	private String _utente;
	private String _dettaglio_richiedente;
	private String _cognome;
	private String _nome;
	private String _luogo_nascita;
	private Date _data_nascita;
	private String _codice_fiscale;
	private String _numerobadge;
	private String _allegatoUuid;
	private String _operazione;
	private Date _data_richiesta;
	private String _procedura;
	private Date _disattivazione;
}