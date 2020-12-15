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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.BeneInvRichiestoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.BeneInvRichiestoServiceSoap
 * @generated
 */
@ProviderType
public class BeneInvRichiestoSoap implements Serializable {
	public static BeneInvRichiestoSoap toSoapModel(BeneInvRichiesto model) {
		BeneInvRichiestoSoap soapModel = new BeneInvRichiestoSoap();

		soapModel.setId_bene_rich(model.getId_bene_rich());
		soapModel.setTipologia(model.getTipologia());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setQuantita(model.getQuantita());
		soapModel.setDettagli(model.getDettagli());
		soapModel.setIn_elenco(model.getIn_elenco());
		soapModel.setId_richiesta(model.getId_richiesta());

		return soapModel;
	}

	public static BeneInvRichiestoSoap[] toSoapModels(BeneInvRichiesto[] models) {
		BeneInvRichiestoSoap[] soapModels = new BeneInvRichiestoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BeneInvRichiestoSoap[][] toSoapModels(
		BeneInvRichiesto[][] models) {
		BeneInvRichiestoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BeneInvRichiestoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BeneInvRichiestoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BeneInvRichiestoSoap[] toSoapModels(
		List<BeneInvRichiesto> models) {
		List<BeneInvRichiestoSoap> soapModels = new ArrayList<BeneInvRichiestoSoap>(models.size());

		for (BeneInvRichiesto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BeneInvRichiestoSoap[soapModels.size()]);
	}

	public BeneInvRichiestoSoap() {
	}

	public long getPrimaryKey() {
		return _id_bene_rich;
	}

	public void setPrimaryKey(long pk) {
		setId_bene_rich(pk);
	}

	public long getId_bene_rich() {
		return _id_bene_rich;
	}

	public void setId_bene_rich(long id_bene_rich) {
		_id_bene_rich = id_bene_rich;
	}

	public String getTipologia() {
		return _tipologia;
	}

	public void setTipologia(String tipologia) {
		_tipologia = tipologia;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public int getQuantita() {
		return _quantita;
	}

	public void setQuantita(int quantita) {
		_quantita = quantita;
	}

	public String getDettagli() {
		return _dettagli;
	}

	public void setDettagli(String dettagli) {
		_dettagli = dettagli;
	}

	public boolean getIn_elenco() {
		return _in_elenco;
	}

	public boolean isIn_elenco() {
		return _in_elenco;
	}

	public void setIn_elenco(boolean in_elenco) {
		_in_elenco = in_elenco;
	}

	public long getId_richiesta() {
		return _id_richiesta;
	}

	public void setId_richiesta(long id_richiesta) {
		_id_richiesta = id_richiesta;
	}

	private long _id_bene_rich;
	private String _tipologia;
	private String _descrizione;
	private int _quantita;
	private String _dettagli;
	private boolean _in_elenco;
	private long _id_richiesta;
}