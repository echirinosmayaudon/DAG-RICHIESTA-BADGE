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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.StatoInvitatoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.StatoInvitatoServiceSoap
 * @generated
 */
@ProviderType
public class StatoInvitatoSoap implements Serializable {
	public static StatoInvitatoSoap toSoapModel(StatoInvitato model) {
		StatoInvitatoSoap soapModel = new StatoInvitatoSoap();

		soapModel.setId_stato_invitato(model.getId_stato_invitato());
		soapModel.setNome_stato(model.getNome_stato());

		return soapModel;
	}

	public static StatoInvitatoSoap[] toSoapModels(StatoInvitato[] models) {
		StatoInvitatoSoap[] soapModels = new StatoInvitatoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatoInvitatoSoap[][] toSoapModels(StatoInvitato[][] models) {
		StatoInvitatoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatoInvitatoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatoInvitatoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatoInvitatoSoap[] toSoapModels(List<StatoInvitato> models) {
		List<StatoInvitatoSoap> soapModels = new ArrayList<StatoInvitatoSoap>(models.size());

		for (StatoInvitato model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatoInvitatoSoap[soapModels.size()]);
	}

	public StatoInvitatoSoap() {
	}

	public long getPrimaryKey() {
		return _id_stato_invitato;
	}

	public void setPrimaryKey(long pk) {
		setId_stato_invitato(pk);
	}

	public long getId_stato_invitato() {
		return _id_stato_invitato;
	}

	public void setId_stato_invitato(long id_stato_invitato) {
		_id_stato_invitato = id_stato_invitato;
	}

	public String getNome_stato() {
		return _nome_stato;
	}

	public void setNome_stato(String nome_stato) {
		_nome_stato = nome_stato;
	}

	private long _id_stato_invitato;
	private String _nome_stato;
}