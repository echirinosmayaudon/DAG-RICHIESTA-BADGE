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

package com.mef.intranet.rubrica.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mef.intranet.rubrica.service.http.SearchDataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.mef.intranet.rubrica.service.http.SearchDataServiceSoap
 * @generated
 */
@ProviderType
public class SearchDataSoap implements Serializable {
	public static SearchDataSoap toSoapModel(SearchData model) {
		SearchDataSoap soapModel = new SearchDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSearchId(model.getSearchId());
		soapModel.setSearchData(model.getSearchData());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static SearchDataSoap[] toSoapModels(SearchData[] models) {
		SearchDataSoap[] soapModels = new SearchDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SearchDataSoap[][] toSoapModels(SearchData[][] models) {
		SearchDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SearchDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SearchDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SearchDataSoap[] toSoapModels(List<SearchData> models) {
		List<SearchDataSoap> soapModels = new ArrayList<SearchDataSoap>(models.size());

		for (SearchData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SearchDataSoap[soapModels.size()]);
	}

	public SearchDataSoap() {
	}

	public long getPrimaryKey() {
		return _searchId;
	}

	public void setPrimaryKey(long pk) {
		setSearchId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSearchId() {
		return _searchId;
	}

	public void setSearchId(long searchId) {
		_searchId = searchId;
	}

	public String getSearchData() {
		return _searchData;
	}

	public void setSearchData(String searchData) {
		_searchData = searchData;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private String _uuid;
	private long _searchId;
	private String _searchData;
	private Date _createDate;
}