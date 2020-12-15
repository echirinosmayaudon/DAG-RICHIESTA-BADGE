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

package com.accenture.istanza.interpello.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.accenture.istanza.interpello.service.http.TextRichServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.istanza.interpello.service.http.TextRichServiceSoap
 * @generated
 */
@ProviderType
public class TextRichSoap implements Serializable {
	public static TextRichSoap toSoapModel(TextRich model) {
		TextRichSoap soapModel = new TextRichSoap();

		soapModel.setId_text(model.getId_text());
		soapModel.setLabel_text(model.getLabel_text());
		soapModel.setTesto_text(model.getTesto_text());
		soapModel.setData_in(model.getData_in());

		return soapModel;
	}

	public static TextRichSoap[] toSoapModels(TextRich[] models) {
		TextRichSoap[] soapModels = new TextRichSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TextRichSoap[][] toSoapModels(TextRich[][] models) {
		TextRichSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TextRichSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TextRichSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TextRichSoap[] toSoapModels(List<TextRich> models) {
		List<TextRichSoap> soapModels = new ArrayList<TextRichSoap>(models.size());

		for (TextRich model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TextRichSoap[soapModels.size()]);
	}

	public TextRichSoap() {
	}

	public long getPrimaryKey() {
		return _id_text;
	}

	public void setPrimaryKey(long pk) {
		setId_text(pk);
	}

	public long getId_text() {
		return _id_text;
	}

	public void setId_text(long id_text) {
		_id_text = id_text;
	}

	public String getLabel_text() {
		return _label_text;
	}

	public void setLabel_text(String label_text) {
		_label_text = label_text;
	}

	public String getTesto_text() {
		return _testo_text;
	}

	public void setTesto_text(String testo_text) {
		_testo_text = testo_text;
	}

	public Date getData_in() {
		return _data_in;
	}

	public void setData_in(Date data_in) {
		_data_in = data_in;
	}

	private long _id_text;
	private String _label_text;
	private String _testo_text;
	private Date _data_in;
}