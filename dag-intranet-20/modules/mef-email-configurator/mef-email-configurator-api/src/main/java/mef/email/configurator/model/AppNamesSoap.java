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

package mef.email.configurator.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link mef.email.configurator.service.http.AppNamesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see mef.email.configurator.service.http.AppNamesServiceSoap
 * @generated
 */
@ProviderType
public class AppNamesSoap implements Serializable {
	public static AppNamesSoap toSoapModel(AppNames model) {
		AppNamesSoap soapModel = new AppNamesSoap();

		soapModel.setId(model.getId());
		soapModel.setAppname(model.getAppname());
		soapModel.setAppid(model.getAppid());

		return soapModel;
	}

	public static AppNamesSoap[] toSoapModels(AppNames[] models) {
		AppNamesSoap[] soapModels = new AppNamesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppNamesSoap[][] toSoapModels(AppNames[][] models) {
		AppNamesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppNamesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppNamesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppNamesSoap[] toSoapModels(List<AppNames> models) {
		List<AppNamesSoap> soapModels = new ArrayList<AppNamesSoap>(models.size());

		for (AppNames model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppNamesSoap[soapModels.size()]);
	}

	public AppNamesSoap() {
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

	public String getAppname() {
		return _appname;
	}

	public void setAppname(String appname) {
		_appname = appname;
	}

	public long getAppid() {
		return _appid;
	}

	public void setAppid(long appid) {
		_appid = appid;
	}

	private long _id;
	private String _appname;
	private long _appid;
}