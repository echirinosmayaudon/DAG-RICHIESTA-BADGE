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

package external.bfc.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link external.bfc.intranet.mef.service.http.RichiesteSequenceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.http.RichiesteSequenceServiceSoap
 * @generated
 */
@ProviderType
public class RichiesteSequenceSoap implements Serializable {
	public static RichiesteSequenceSoap toSoapModel(RichiesteSequence model) {
		RichiesteSequenceSoap soapModel = new RichiesteSequenceSoap();

		soapModel.setIdSeq(model.getIdSeq());

		return soapModel;
	}

	public static RichiesteSequenceSoap[] toSoapModels(
		RichiesteSequence[] models) {
		RichiesteSequenceSoap[] soapModels = new RichiesteSequenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiesteSequenceSoap[][] toSoapModels(
		RichiesteSequence[][] models) {
		RichiesteSequenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiesteSequenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiesteSequenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiesteSequenceSoap[] toSoapModels(
		List<RichiesteSequence> models) {
		List<RichiesteSequenceSoap> soapModels = new ArrayList<RichiesteSequenceSoap>(models.size());

		for (RichiesteSequence model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiesteSequenceSoap[soapModels.size()]);
	}

	public RichiesteSequenceSoap() {
	}

	public long getPrimaryKey() {
		return _idSeq;
	}

	public void setPrimaryKey(long pk) {
		setIdSeq(pk);
	}

	public long getIdSeq() {
		return _idSeq;
	}

	public void setIdSeq(long idSeq) {
		_idSeq = idSeq;
	}

	private long _idSeq;
}