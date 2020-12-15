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

package com.intranet.mef.assistance.model;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.service.persistence.FaqPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FaqSoap implements Serializable {
	public static FaqSoap toSoapModel(Faq model) {
		FaqSoap soapModel = new FaqSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFaqId(model.getFaqId());
		soapModel.setSiebelId(model.getSiebelId());
		soapModel.setQuestions(model.getQuestions());
		soapModel.setResponse(model.getResponse());

		return soapModel;
	}

	public static FaqSoap[] toSoapModels(Faq[] models) {
		FaqSoap[] soapModels = new FaqSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FaqSoap[][] toSoapModels(Faq[][] models) {
		FaqSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FaqSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FaqSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FaqSoap[] toSoapModels(List<Faq> models) {
		List<FaqSoap> soapModels = new ArrayList<FaqSoap>(models.size());

		for (Faq model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FaqSoap[soapModels.size()]);
	}

	public FaqSoap() {
	}

	public FaqPK getPrimaryKey() {
		return new FaqPK(_faqId, _siebelId);
	}

	public void setPrimaryKey(FaqPK pk) {
		setFaqId(pk.faqId);
		setSiebelId(pk.siebelId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getFaqId() {
		return _faqId;
	}

	public void setFaqId(String faqId) {
		_faqId = faqId;
	}

	public String getSiebelId() {
		return _siebelId;
	}

	public void setSiebelId(String siebelId) {
		_siebelId = siebelId;
	}

	public String getQuestions() {
		return _questions;
	}

	public void setQuestions(String questions) {
		_questions = questions;
	}

	public String getResponse() {
		return _response;
	}

	public void setResponse(String response) {
		_response = response;
	}

	private String _uuid;
	private String _faqId;
	private String _siebelId;
	private String _questions;
	private String _response;
}