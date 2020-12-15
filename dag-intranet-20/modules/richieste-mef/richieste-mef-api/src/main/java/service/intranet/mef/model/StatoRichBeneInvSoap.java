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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.StatoRichBeneInvServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.StatoRichBeneInvServiceSoap
 * @generated
 */
@ProviderType
public class StatoRichBeneInvSoap implements Serializable {
	public static StatoRichBeneInvSoap toSoapModel(StatoRichBeneInv model) {
		StatoRichBeneInvSoap soapModel = new StatoRichBeneInvSoap();

		soapModel.setId(model.getId());
		soapModel.setStato(model.getStato());

		return soapModel;
	}

	public static StatoRichBeneInvSoap[] toSoapModels(StatoRichBeneInv[] models) {
		StatoRichBeneInvSoap[] soapModels = new StatoRichBeneInvSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatoRichBeneInvSoap[][] toSoapModels(
		StatoRichBeneInv[][] models) {
		StatoRichBeneInvSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatoRichBeneInvSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatoRichBeneInvSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatoRichBeneInvSoap[] toSoapModels(
		List<StatoRichBeneInv> models) {
		List<StatoRichBeneInvSoap> soapModels = new ArrayList<StatoRichBeneInvSoap>(models.size());

		for (StatoRichBeneInv model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatoRichBeneInvSoap[soapModels.size()]);
	}

	public StatoRichBeneInvSoap() {
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

	public String getStato() {
		return _stato;
	}

	public void setStato(String stato) {
		_stato = stato;
	}

	private long _id;
	private String _stato;
}