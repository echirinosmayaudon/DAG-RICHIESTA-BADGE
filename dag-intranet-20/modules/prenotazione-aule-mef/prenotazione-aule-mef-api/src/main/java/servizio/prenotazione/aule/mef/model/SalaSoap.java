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

package servizio.prenotazione.aule.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.SalaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.SalaServiceSoap
 * @generated
 */
@ProviderType
public class SalaSoap implements Serializable {
	public static SalaSoap toSoapModel(Sala model) {
		SalaSoap soapModel = new SalaSoap();

		soapModel.setId_sala(model.getId_sala());
		soapModel.setDesc_sala(model.getDesc_sala());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setCitta(model.getCitta());
		soapModel.setCap(model.getCap());
		soapModel.setCod_prov(model.getCod_prov());
		soapModel.setPiano(model.getPiano());
		soapModel.setStanza(model.getStanza());
		soapModel.setPosti(model.getPosti());
		soapModel.setVideo_conferenza(model.getVideo_conferenza());
		soapModel.setProiettore(model.getProiettore());
		soapModel.setPostazione_rete(model.getPostazione_rete());
		soapModel.setAutorizzazione(model.getAutorizzazione());
		soapModel.setEmail_ref(model.getEmail_ref());

		return soapModel;
	}

	public static SalaSoap[] toSoapModels(Sala[] models) {
		SalaSoap[] soapModels = new SalaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SalaSoap[][] toSoapModels(Sala[][] models) {
		SalaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SalaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SalaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SalaSoap[] toSoapModels(List<Sala> models) {
		List<SalaSoap> soapModels = new ArrayList<SalaSoap>(models.size());

		for (Sala model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SalaSoap[soapModels.size()]);
	}

	public SalaSoap() {
	}

	public long getPrimaryKey() {
		return _id_sala;
	}

	public void setPrimaryKey(long pk) {
		setId_sala(pk);
	}

	public long getId_sala() {
		return _id_sala;
	}

	public void setId_sala(long id_sala) {
		_id_sala = id_sala;
	}

	public String getDesc_sala() {
		return _desc_sala;
	}

	public void setDesc_sala(String desc_sala) {
		_desc_sala = desc_sala;
	}

	public String getIndirizzo() {
		return _indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
	}

	public String getCitta() {
		return _citta;
	}

	public void setCitta(String citta) {
		_citta = citta;
	}

	public String getCap() {
		return _cap;
	}

	public void setCap(String cap) {
		_cap = cap;
	}

	public String getCod_prov() {
		return _cod_prov;
	}

	public void setCod_prov(String cod_prov) {
		_cod_prov = cod_prov;
	}

	public String getPiano() {
		return _piano;
	}

	public void setPiano(String piano) {
		_piano = piano;
	}

	public String getStanza() {
		return _stanza;
	}

	public void setStanza(String stanza) {
		_stanza = stanza;
	}

	public int getPosti() {
		return _posti;
	}

	public void setPosti(int posti) {
		_posti = posti;
	}

	public boolean getVideo_conferenza() {
		return _video_conferenza;
	}

	public boolean isVideo_conferenza() {
		return _video_conferenza;
	}

	public void setVideo_conferenza(boolean video_conferenza) {
		_video_conferenza = video_conferenza;
	}

	public boolean getProiettore() {
		return _proiettore;
	}

	public boolean isProiettore() {
		return _proiettore;
	}

	public void setProiettore(boolean proiettore) {
		_proiettore = proiettore;
	}

	public boolean getPostazione_rete() {
		return _postazione_rete;
	}

	public boolean isPostazione_rete() {
		return _postazione_rete;
	}

	public void setPostazione_rete(boolean postazione_rete) {
		_postazione_rete = postazione_rete;
	}

	public boolean getAutorizzazione() {
		return _autorizzazione;
	}

	public boolean isAutorizzazione() {
		return _autorizzazione;
	}

	public void setAutorizzazione(boolean autorizzazione) {
		_autorizzazione = autorizzazione;
	}

	public String getEmail_ref() {
		return _email_ref;
	}

	public void setEmail_ref(String email_ref) {
		_email_ref = email_ref;
	}

	private long _id_sala;
	private String _desc_sala;
	private String _indirizzo;
	private String _citta;
	private String _cap;
	private String _cod_prov;
	private String _piano;
	private String _stanza;
	private int _posti;
	private boolean _video_conferenza;
	private boolean _proiettore;
	private boolean _postazione_rete;
	private boolean _autorizzazione;
	private String _email_ref;
}