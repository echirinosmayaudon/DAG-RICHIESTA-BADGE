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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.TipologiaStampantiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.TipologiaStampantiServiceSoap
 * @generated
 */
@ProviderType
public class TipologiaStampantiSoap implements Serializable {
	public static TipologiaStampantiSoap toSoapModel(TipologiaStampanti model) {
		TipologiaStampantiSoap soapModel = new TipologiaStampantiSoap();

		soapModel.setId_tipologia_stampanti(model.getId_tipologia_stampanti());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static TipologiaStampantiSoap[] toSoapModels(
		TipologiaStampanti[] models) {
		TipologiaStampantiSoap[] soapModels = new TipologiaStampantiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipologiaStampantiSoap[][] toSoapModels(
		TipologiaStampanti[][] models) {
		TipologiaStampantiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipologiaStampantiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipologiaStampantiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipologiaStampantiSoap[] toSoapModels(
		List<TipologiaStampanti> models) {
		List<TipologiaStampantiSoap> soapModels = new ArrayList<TipologiaStampantiSoap>(models.size());

		for (TipologiaStampanti model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipologiaStampantiSoap[soapModels.size()]);
	}

	public TipologiaStampantiSoap() {
	}

	public long getPrimaryKey() {
		return _id_tipologia_stampanti;
	}

	public void setPrimaryKey(long pk) {
		setId_tipologia_stampanti(pk);
	}

	public long getId_tipologia_stampanti() {
		return _id_tipologia_stampanti;
	}

	public void setId_tipologia_stampanti(long id_tipologia_stampanti) {
		_id_tipologia_stampanti = id_tipologia_stampanti;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id_tipologia_stampanti;
	private String _descrizione;
}