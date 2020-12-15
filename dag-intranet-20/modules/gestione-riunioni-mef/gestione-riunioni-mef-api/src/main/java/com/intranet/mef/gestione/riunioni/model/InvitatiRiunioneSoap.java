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

package com.intranet.mef.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.InvitatiRiunioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.InvitatiRiunioneServiceSoap
 * @generated
 */
@ProviderType
public class InvitatiRiunioneSoap implements Serializable {
	public static InvitatiRiunioneSoap toSoapModel(InvitatiRiunione model) {
		InvitatiRiunioneSoap soapModel = new InvitatiRiunioneSoap();

		soapModel.setId_segreteria(model.getId_segreteria());
		soapModel.setNote(model.getNote());
		soapModel.setPartecipanti(model.getPartecipanti());
		soapModel.setId_stato_invitato(model.getId_stato_invitato());
		soapModel.setId_riunione(model.getId_riunione());

		return soapModel;
	}

	public static InvitatiRiunioneSoap[] toSoapModels(InvitatiRiunione[] models) {
		InvitatiRiunioneSoap[] soapModels = new InvitatiRiunioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvitatiRiunioneSoap[][] toSoapModels(
		InvitatiRiunione[][] models) {
		InvitatiRiunioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InvitatiRiunioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvitatiRiunioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvitatiRiunioneSoap[] toSoapModels(
		List<InvitatiRiunione> models) {
		List<InvitatiRiunioneSoap> soapModels = new ArrayList<InvitatiRiunioneSoap>(models.size());

		for (InvitatiRiunione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvitatiRiunioneSoap[soapModels.size()]);
	}

	public InvitatiRiunioneSoap() {
	}

	public InvitatiRiunionePK getPrimaryKey() {
		return new InvitatiRiunionePK(_id_segreteria, _id_riunione);
	}

	public void setPrimaryKey(InvitatiRiunionePK pk) {
		setId_segreteria(pk.id_segreteria);
		setId_riunione(pk.id_riunione);
	}

	public long getId_segreteria() {
		return _id_segreteria;
	}

	public void setId_segreteria(long id_segreteria) {
		_id_segreteria = id_segreteria;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getPartecipanti() {
		return _partecipanti;
	}

	public void setPartecipanti(String partecipanti) {
		_partecipanti = partecipanti;
	}

	public long getId_stato_invitato() {
		return _id_stato_invitato;
	}

	public void setId_stato_invitato(long id_stato_invitato) {
		_id_stato_invitato = id_stato_invitato;
	}

	public long getId_riunione() {
		return _id_riunione;
	}

	public void setId_riunione(long id_riunione) {
		_id_riunione = id_riunione;
	}

	private long _id_segreteria;
	private String _note;
	private String _partecipanti;
	private long _id_stato_invitato;
	private long _id_riunione;
}