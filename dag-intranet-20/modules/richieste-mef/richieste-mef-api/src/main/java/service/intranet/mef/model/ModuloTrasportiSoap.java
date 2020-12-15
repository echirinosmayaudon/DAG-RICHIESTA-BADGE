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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.ModuloTrasportiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.ModuloTrasportiServiceSoap
 * @generated
 */
@ProviderType
public class ModuloTrasportiSoap implements Serializable {
	public static ModuloTrasportiSoap toSoapModel(ModuloTrasporti model) {
		ModuloTrasportiSoap soapModel = new ModuloTrasportiSoap();

		soapModel.setId_modulo_trasporti(model.getId_modulo_trasporti());
		soapModel.setCognome(model.getCognome());
		soapModel.setNome(model.getNome());
		soapModel.setCodice_fiscale(model.getCodice_fiscale());
		soapModel.setUtente_inserimento(model.getUtente_inserimento());
		soapModel.setData_inserimento(model.getData_inserimento());
		soapModel.setFlag_tipospesa(model.getFlag_tipospesa());
		soapModel.setIban(model.getIban());
		soapModel.setImporto(model.getImporto());
		soapModel.setData_titolo_annuale(model.getData_titolo_annuale());
		soapModel.setNr_titoli_mensili(model.getNr_titoli_mensili());
		soapModel.setFiglio_nome(model.getFiglio_nome());
		soapModel.setFiglio_cognome(model.getFiglio_cognome());
		soapModel.setFiglio_data_nascita(model.getFiglio_data_nascita());
		soapModel.setFiglio_luogo_data(model.getFiglio_luogo_data());
		soapModel.setFiglio_codicefiscale(model.getFiglio_codicefiscale());
		soapModel.setNote(model.getNote());
		soapModel.setFlag_inviato(model.getFlag_inviato());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setAllegatoUuid(model.getAllegatoUuid());

		return soapModel;
	}

	public static ModuloTrasportiSoap[] toSoapModels(ModuloTrasporti[] models) {
		ModuloTrasportiSoap[] soapModels = new ModuloTrasportiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ModuloTrasportiSoap[][] toSoapModels(
		ModuloTrasporti[][] models) {
		ModuloTrasportiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ModuloTrasportiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ModuloTrasportiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ModuloTrasportiSoap[] toSoapModels(
		List<ModuloTrasporti> models) {
		List<ModuloTrasportiSoap> soapModels = new ArrayList<ModuloTrasportiSoap>(models.size());

		for (ModuloTrasporti model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ModuloTrasportiSoap[soapModels.size()]);
	}

	public ModuloTrasportiSoap() {
	}

	public long getPrimaryKey() {
		return _id_modulo_trasporti;
	}

	public void setPrimaryKey(long pk) {
		setId_modulo_trasporti(pk);
	}

	public long getId_modulo_trasporti() {
		return _id_modulo_trasporti;
	}

	public void setId_modulo_trasporti(long id_modulo_trasporti) {
		_id_modulo_trasporti = id_modulo_trasporti;
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

	public String getCodice_fiscale() {
		return _codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		_codice_fiscale = codice_fiscale;
	}

	public String getUtente_inserimento() {
		return _utente_inserimento;
	}

	public void setUtente_inserimento(String utente_inserimento) {
		_utente_inserimento = utente_inserimento;
	}

	public Date getData_inserimento() {
		return _data_inserimento;
	}

	public void setData_inserimento(Date data_inserimento) {
		_data_inserimento = data_inserimento;
	}

	public String getFlag_tipospesa() {
		return _flag_tipospesa;
	}

	public void setFlag_tipospesa(String flag_tipospesa) {
		_flag_tipospesa = flag_tipospesa;
	}

	public String getIban() {
		return _iban;
	}

	public void setIban(String iban) {
		_iban = iban;
	}

	public String getImporto() {
		return _importo;
	}

	public void setImporto(String importo) {
		_importo = importo;
	}

	public Date getData_titolo_annuale() {
		return _data_titolo_annuale;
	}

	public void setData_titolo_annuale(Date data_titolo_annuale) {
		_data_titolo_annuale = data_titolo_annuale;
	}

	public String getNr_titoli_mensili() {
		return _nr_titoli_mensili;
	}

	public void setNr_titoli_mensili(String nr_titoli_mensili) {
		_nr_titoli_mensili = nr_titoli_mensili;
	}

	public String getFiglio_nome() {
		return _figlio_nome;
	}

	public void setFiglio_nome(String figlio_nome) {
		_figlio_nome = figlio_nome;
	}

	public String getFiglio_cognome() {
		return _figlio_cognome;
	}

	public void setFiglio_cognome(String figlio_cognome) {
		_figlio_cognome = figlio_cognome;
	}

	public Date getFiglio_data_nascita() {
		return _figlio_data_nascita;
	}

	public void setFiglio_data_nascita(Date figlio_data_nascita) {
		_figlio_data_nascita = figlio_data_nascita;
	}

	public String getFiglio_luogo_data() {
		return _figlio_luogo_data;
	}

	public void setFiglio_luogo_data(String figlio_luogo_data) {
		_figlio_luogo_data = figlio_luogo_data;
	}

	public String getFiglio_codicefiscale() {
		return _figlio_codicefiscale;
	}

	public void setFiglio_codicefiscale(String figlio_codicefiscale) {
		_figlio_codicefiscale = figlio_codicefiscale;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getFlag_inviato() {
		return _flag_inviato;
	}

	public void setFlag_inviato(String flag_inviato) {
		_flag_inviato = flag_inviato;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public String getAllegatoUuid() {
		return _allegatoUuid;
	}

	public void setAllegatoUuid(String allegatoUuid) {
		_allegatoUuid = allegatoUuid;
	}

	private long _id_modulo_trasporti;
	private String _cognome;
	private String _nome;
	private String _codice_fiscale;
	private String _utente_inserimento;
	private Date _data_inserimento;
	private String _flag_tipospesa;
	private String _iban;
	private String _importo;
	private Date _data_titolo_annuale;
	private String _nr_titoli_mensili;
	private String _figlio_nome;
	private String _figlio_cognome;
	private Date _figlio_data_nascita;
	private String _figlio_luogo_data;
	private String _figlio_codicefiscale;
	private String _note;
	private String _flag_inviato;
	private String _telefono;
	private String _allegatoUuid;
}