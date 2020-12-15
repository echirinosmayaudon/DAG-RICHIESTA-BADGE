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

package servizio.beni.facile.consumo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.beni.facile.consumo.service.http.PeriodicitaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.http.PeriodicitaServiceSoap
 * @generated
 */
@ProviderType
public class PeriodicitaSoap implements Serializable {
	public static PeriodicitaSoap toSoapModel(Periodicita model) {
		PeriodicitaSoap soapModel = new PeriodicitaSoap();

		soapModel.setId(model.getId());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static PeriodicitaSoap[] toSoapModels(Periodicita[] models) {
		PeriodicitaSoap[] soapModels = new PeriodicitaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PeriodicitaSoap[][] toSoapModels(Periodicita[][] models) {
		PeriodicitaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PeriodicitaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PeriodicitaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PeriodicitaSoap[] toSoapModels(List<Periodicita> models) {
		List<PeriodicitaSoap> soapModels = new ArrayList<PeriodicitaSoap>(models.size());

		for (Periodicita model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PeriodicitaSoap[soapModels.size()]);
	}

	public PeriodicitaSoap() {
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

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id;
	private String _descrizione;
}