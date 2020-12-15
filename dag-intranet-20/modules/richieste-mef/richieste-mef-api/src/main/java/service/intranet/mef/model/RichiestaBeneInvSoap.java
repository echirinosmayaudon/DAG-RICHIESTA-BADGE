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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.RichiestaBeneInvServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.RichiestaBeneInvServiceSoap
 * @generated
 */
@ProviderType
public class RichiestaBeneInvSoap implements Serializable {
	public static RichiestaBeneInvSoap toSoapModel(RichiestaBeneInv model) {
		RichiestaBeneInvSoap soapModel = new RichiestaBeneInvSoap();

		soapModel.setId_richiesta(model.getId_richiesta());
		soapModel.setUtente(model.getUtente());
		soapModel.setNome_rich(model.getNome_rich());
		soapModel.setCogn_rich(model.getCogn_rich());
		soapModel.setDip_dir(model.getDip_dir());
		soapModel.setDati_rich(model.getDati_rich());
		soapModel.setOggetto(model.getOggetto());
		soapModel.setData(model.getData());
		soapModel.setBeneficiario(model.getBeneficiario());
		soapModel.setDestinazione(model.getDestinazione());
		soapModel.setId_stato(model.getId_stato());
		soapModel.setNote_consegn(model.getNote_consegn());

		return soapModel;
	}

	public static RichiestaBeneInvSoap[] toSoapModels(RichiestaBeneInv[] models) {
		RichiestaBeneInvSoap[] soapModels = new RichiestaBeneInvSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiestaBeneInvSoap[][] toSoapModels(
		RichiestaBeneInv[][] models) {
		RichiestaBeneInvSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiestaBeneInvSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiestaBeneInvSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiestaBeneInvSoap[] toSoapModels(
		List<RichiestaBeneInv> models) {
		List<RichiestaBeneInvSoap> soapModels = new ArrayList<RichiestaBeneInvSoap>(models.size());

		for (RichiestaBeneInv model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiestaBeneInvSoap[soapModels.size()]);
	}

	public RichiestaBeneInvSoap() {
	}

	public long getPrimaryKey() {
		return _id_richiesta;
	}

	public void setPrimaryKey(long pk) {
		setId_richiesta(pk);
	}

	public long getId_richiesta() {
		return _id_richiesta;
	}

	public void setId_richiesta(long id_richiesta) {
		_id_richiesta = id_richiesta;
	}

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public String getNome_rich() {
		return _nome_rich;
	}

	public void setNome_rich(String nome_rich) {
		_nome_rich = nome_rich;
	}

	public String getCogn_rich() {
		return _cogn_rich;
	}

	public void setCogn_rich(String cogn_rich) {
		_cogn_rich = cogn_rich;
	}

	public String getDip_dir() {
		return _dip_dir;
	}

	public void setDip_dir(String dip_dir) {
		_dip_dir = dip_dir;
	}

	public String getDati_rich() {
		return _dati_rich;
	}

	public void setDati_rich(String dati_rich) {
		_dati_rich = dati_rich;
	}

	public String getOggetto() {
		return _oggetto;
	}

	public void setOggetto(String oggetto) {
		_oggetto = oggetto;
	}

	public Date getData() {
		return _data;
	}

	public void setData(Date data) {
		_data = data;
	}

	public String getBeneficiario() {
		return _beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		_beneficiario = beneficiario;
	}

	public String getDestinazione() {
		return _destinazione;
	}

	public void setDestinazione(String destinazione) {
		_destinazione = destinazione;
	}

	public long getId_stato() {
		return _id_stato;
	}

	public void setId_stato(long id_stato) {
		_id_stato = id_stato;
	}

	public String getNote_consegn() {
		return _note_consegn;
	}

	public void setNote_consegn(String note_consegn) {
		_note_consegn = note_consegn;
	}

	private long _id_richiesta;
	private String _utente;
	private String _nome_rich;
	private String _cogn_rich;
	private String _dip_dir;
	private String _dati_rich;
	private String _oggetto;
	private Date _data;
	private String _beneficiario;
	private String _destinazione;
	private long _id_stato;
	private String _note_consegn;
}