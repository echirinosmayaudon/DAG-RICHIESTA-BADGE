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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.PeriodicitaRichPubblicServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.PeriodicitaRichPubblicServiceSoap
 * @generated
 */
@ProviderType
public class PeriodicitaRichPubblicSoap implements Serializable {
	public static PeriodicitaRichPubblicSoap toSoapModel(
		PeriodicitaRichPubblic model) {
		PeriodicitaRichPubblicSoap soapModel = new PeriodicitaRichPubblicSoap();

		soapModel.setId(model.getId());
		soapModel.setPeriodicita(model.getPeriodicita());

		return soapModel;
	}

	public static PeriodicitaRichPubblicSoap[] toSoapModels(
		PeriodicitaRichPubblic[] models) {
		PeriodicitaRichPubblicSoap[] soapModels = new PeriodicitaRichPubblicSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PeriodicitaRichPubblicSoap[][] toSoapModels(
		PeriodicitaRichPubblic[][] models) {
		PeriodicitaRichPubblicSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PeriodicitaRichPubblicSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PeriodicitaRichPubblicSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PeriodicitaRichPubblicSoap[] toSoapModels(
		List<PeriodicitaRichPubblic> models) {
		List<PeriodicitaRichPubblicSoap> soapModels = new ArrayList<PeriodicitaRichPubblicSoap>(models.size());

		for (PeriodicitaRichPubblic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PeriodicitaRichPubblicSoap[soapModels.size()]);
	}

	public PeriodicitaRichPubblicSoap() {
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

	public String getPeriodicita() {
		return _periodicita;
	}

	public void setPeriodicita(String periodicita) {
		_periodicita = periodicita;
	}

	private long _id;
	private String _periodicita;
}