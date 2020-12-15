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

package com.accenture.istanza.interpello.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.accenture.istanza.interpello.service.http.RichInterpelloServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.istanza.interpello.service.http.RichInterpelloServiceSoap
 * @generated
 */
@ProviderType
public class RichInterpelloSoap implements Serializable {
	public static RichInterpelloSoap toSoapModel(RichInterpello model) {
		RichInterpelloSoap soapModel = new RichInterpelloSoap();

		soapModel.setId(model.getId());
		soapModel.setId_richiesta(model.getId_richiesta());
		soapModel.setCognome(model.getCognome());
		soapModel.setNome(model.getNome());
		soapModel.setDipartimento(model.getDipartimento());
		soapModel.setDirezione(model.getDirezione());
		soapModel.setUfficio(model.getUfficio());
		soapModel.setScreename(model.getScreename());
		soapModel.setJson_richiedente(model.getJson_richiedente());
		soapModel.setJson_richiesta(model.getJson_richiesta());
		soapModel.setBando(model.getBando());
		soapModel.setData_richiesta(model.getData_richiesta());
		soapModel.setAllegato(model.getAllegato());
		soapModel.setPdf(model.getPdf());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static RichInterpelloSoap[] toSoapModels(RichInterpello[] models) {
		RichInterpelloSoap[] soapModels = new RichInterpelloSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichInterpelloSoap[][] toSoapModels(RichInterpello[][] models) {
		RichInterpelloSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichInterpelloSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichInterpelloSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichInterpelloSoap[] toSoapModels(List<RichInterpello> models) {
		List<RichInterpelloSoap> soapModels = new ArrayList<RichInterpelloSoap>(models.size());

		for (RichInterpello model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichInterpelloSoap[soapModels.size()]);
	}

	public RichInterpelloSoap() {
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

	public long getId_richiesta() {
		return _id_richiesta;
	}

	public void setId_richiesta(long id_richiesta) {
		_id_richiesta = id_richiesta;
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

	public long getDipartimento() {
		return _dipartimento;
	}

	public void setDipartimento(long dipartimento) {
		_dipartimento = dipartimento;
	}

	public long getDirezione() {
		return _direzione;
	}

	public void setDirezione(long direzione) {
		_direzione = direzione;
	}

	public long getUfficio() {
		return _ufficio;
	}

	public void setUfficio(long ufficio) {
		_ufficio = ufficio;
	}

	public String getScreename() {
		return _screename;
	}

	public void setScreename(String screename) {
		_screename = screename;
	}

	public String getJson_richiedente() {
		return _json_richiedente;
	}

	public void setJson_richiedente(String json_richiedente) {
		_json_richiedente = json_richiedente;
	}

	public String getJson_richiesta() {
		return _json_richiesta;
	}

	public void setJson_richiesta(String json_richiesta) {
		_json_richiesta = json_richiesta;
	}

	public String getBando() {
		return _bando;
	}

	public void setBando(String bando) {
		_bando = bando;
	}

	public Date getData_richiesta() {
		return _data_richiesta;
	}

	public void setData_richiesta(Date data_richiesta) {
		_data_richiesta = data_richiesta;
	}

	public String getAllegato() {
		return _allegato;
	}

	public void setAllegato(String allegato) {
		_allegato = allegato;
	}

	public String getPdf() {
		return _pdf;
	}

	public void setPdf(String pdf) {
		_pdf = pdf;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _id;
	private long _id_richiesta;
	private String _cognome;
	private String _nome;
	private long _dipartimento;
	private long _direzione;
	private long _ufficio;
	private String _screename;
	private String _json_richiedente;
	private String _json_richiesta;
	private String _bando;
	private Date _data_richiesta;
	private String _allegato;
	private String _pdf;
	private String _note;
}