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

package mef.richieste.figli.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link mef.richieste.figli.service.http.RICHIESTA_RIMBORSOServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RICHIESTA_RIMBORSOSoap implements Serializable {

	public static RICHIESTA_RIMBORSOSoap toSoapModel(RICHIESTA_RIMBORSO model) {
		RICHIESTA_RIMBORSOSoap soapModel = new RICHIESTA_RIMBORSOSoap();

		soapModel.setId(model.getId());
		soapModel.setNome_Richiedente(model.getNome_Richiedente());
		soapModel.setCognome_Richiedente(model.getCognome_Richiedente());
		soapModel.setCodice_Fiscale_Richiedente(
			model.getCodice_Fiscale_Richiedente());
		soapModel.setUtente_Inserimento(model.getUtente_Inserimento());
		soapModel.setData_Inserimento(model.getData_Inserimento());
		soapModel.setIban(model.getIban());
		soapModel.setImporto(model.getImporto());
		soapModel.setFiglio_Nome(model.getFiglio_Nome());
		soapModel.setFiglio_Cognome(model.getFiglio_Cognome());
		soapModel.setFiglio_Data_Nascita(model.getFiglio_Data_Nascita());
		soapModel.setFiglio_Luogo_Nascita(model.getFiglio_Luogo_Nascita());
		soapModel.setFiglio_Codice_Fiscale(model.getFiglio_Codice_Fiscale());
		soapModel.setNote(model.getNote());
		soapModel.setFlag_Inviato(model.getFlag_Inviato());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setAllegato_UUID(model.getAllegato_UUID());

		return soapModel;
	}

	public static RICHIESTA_RIMBORSOSoap[] toSoapModels(
		RICHIESTA_RIMBORSO[] models) {

		RICHIESTA_RIMBORSOSoap[] soapModels =
			new RICHIESTA_RIMBORSOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RICHIESTA_RIMBORSOSoap[][] toSoapModels(
		RICHIESTA_RIMBORSO[][] models) {

		RICHIESTA_RIMBORSOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RICHIESTA_RIMBORSOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RICHIESTA_RIMBORSOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RICHIESTA_RIMBORSOSoap[] toSoapModels(
		List<RICHIESTA_RIMBORSO> models) {

		List<RICHIESTA_RIMBORSOSoap> soapModels =
			new ArrayList<RICHIESTA_RIMBORSOSoap>(models.size());

		for (RICHIESTA_RIMBORSO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new RICHIESTA_RIMBORSOSoap[soapModels.size()]);
	}

	public RICHIESTA_RIMBORSOSoap() {
	}

	public long getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public String getNome_Richiedente() {
		return _Nome_Richiedente;
	}

	public void setNome_Richiedente(String Nome_Richiedente) {
		_Nome_Richiedente = Nome_Richiedente;
	}

	public String getCognome_Richiedente() {
		return _Cognome_Richiedente;
	}

	public void setCognome_Richiedente(String Cognome_Richiedente) {
		_Cognome_Richiedente = Cognome_Richiedente;
	}

	public String getCodice_Fiscale_Richiedente() {
		return _Codice_Fiscale_Richiedente;
	}

	public void setCodice_Fiscale_Richiedente(
		String Codice_Fiscale_Richiedente) {

		_Codice_Fiscale_Richiedente = Codice_Fiscale_Richiedente;
	}

	public String getUtente_Inserimento() {
		return _Utente_Inserimento;
	}

	public void setUtente_Inserimento(String Utente_Inserimento) {
		_Utente_Inserimento = Utente_Inserimento;
	}

	public String getData_Inserimento() {
		return _Data_Inserimento;
	}

	public void setData_Inserimento(String Data_Inserimento) {
		_Data_Inserimento = Data_Inserimento;
	}

	public String getIban() {
		return _Iban;
	}

	public void setIban(String Iban) {
		_Iban = Iban;
	}

	public String getImporto() {
		return _Importo;
	}

	public void setImporto(String Importo) {
		_Importo = Importo;
	}

	public String getFiglio_Nome() {
		return _Figlio_Nome;
	}

	public void setFiglio_Nome(String Figlio_Nome) {
		_Figlio_Nome = Figlio_Nome;
	}

	public String getFiglio_Cognome() {
		return _Figlio_Cognome;
	}

	public void setFiglio_Cognome(String Figlio_Cognome) {
		_Figlio_Cognome = Figlio_Cognome;
	}

	public String getFiglio_Data_Nascita() {
		return _Figlio_Data_Nascita;
	}

	public void setFiglio_Data_Nascita(String Figlio_Data_Nascita) {
		_Figlio_Data_Nascita = Figlio_Data_Nascita;
	}

	public String getFiglio_Luogo_Nascita() {
		return _Figlio_Luogo_Nascita;
	}

	public void setFiglio_Luogo_Nascita(String Figlio_Luogo_Nascita) {
		_Figlio_Luogo_Nascita = Figlio_Luogo_Nascita;
	}

	public String getFiglio_Codice_Fiscale() {
		return _Figlio_Codice_Fiscale;
	}

	public void setFiglio_Codice_Fiscale(String Figlio_Codice_Fiscale) {
		_Figlio_Codice_Fiscale = Figlio_Codice_Fiscale;
	}

	public String getNote() {
		return _Note;
	}

	public void setNote(String Note) {
		_Note = Note;
	}

	public Boolean getFlag_Inviato() {
		return _Flag_Inviato;
	}

	public void setFlag_Inviato(Boolean Flag_Inviato) {
		_Flag_Inviato = Flag_Inviato;
	}

	public String getTelefono() {
		return _Telefono;
	}

	public void setTelefono(String Telefono) {
		_Telefono = Telefono;
	}

	public String getAllegato_UUID() {
		return _Allegato_UUID;
	}

	public void setAllegato_UUID(String Allegato_UUID) {
		_Allegato_UUID = Allegato_UUID;
	}

	private long _Id;
	private String _Nome_Richiedente;
	private String _Cognome_Richiedente;
	private String _Codice_Fiscale_Richiedente;
	private String _Utente_Inserimento;
	private String _Data_Inserimento;
	private String _Iban;
	private String _Importo;
	private String _Figlio_Nome;
	private String _Figlio_Cognome;
	private String _Figlio_Data_Nascita;
	private String _Figlio_Luogo_Nascita;
	private String _Figlio_Codice_Fiscale;
	private String _Note;
	private Boolean _Flag_Inviato;
	private String _Telefono;
	private String _Allegato_UUID;

}