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

package mef.webcontent.config.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link mef.webcontent.config.service.http.WebContentConfigServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see mef.webcontent.config.service.http.WebContentConfigServiceSoap
 * @generated
 */
@ProviderType
public class WebContentConfigSoap implements Serializable {
	public static WebContentConfigSoap toSoapModel(WebContentConfig model) {
		WebContentConfigSoap soapModel = new WebContentConfigSoap();

		soapModel.setContentid(model.getContentid());
		soapModel.setHtml(model.getHtml());

		return soapModel;
	}

	public static WebContentConfigSoap[] toSoapModels(WebContentConfig[] models) {
		WebContentConfigSoap[] soapModels = new WebContentConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebContentConfigSoap[][] toSoapModels(
		WebContentConfig[][] models) {
		WebContentConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebContentConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebContentConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebContentConfigSoap[] toSoapModels(
		List<WebContentConfig> models) {
		List<WebContentConfigSoap> soapModels = new ArrayList<WebContentConfigSoap>(models.size());

		for (WebContentConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebContentConfigSoap[soapModels.size()]);
	}

	public WebContentConfigSoap() {
	}

	public long getPrimaryKey() {
		return _contentid;
	}

	public void setPrimaryKey(long pk) {
		setContentid(pk);
	}

	public long getContentid() {
		return _contentid;
	}

	public void setContentid(long contentid) {
		_contentid = contentid;
	}

	public String getHtml() {
		return _html;
	}

	public void setHtml(String html) {
		_html = html;
	}

	private long _contentid;
	private String _html;
}