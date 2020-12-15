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

package com.intranet.mef.job.siap.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.OrganizationChartServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.OrganizationChartServiceSoap
 * @generated
 */
@ProviderType
public class OrganizationChartSoap implements Serializable {
	public static OrganizationChartSoap toSoapModel(OrganizationChart model) {
		OrganizationChartSoap soapModel = new OrganizationChartSoap();

		soapModel.setIdOrgChart(model.getIdOrgChart());
		soapModel.setName(model.getName());
		soapModel.setLevel(model.getLevel());
		soapModel.setIdParent(model.getIdParent());
		soapModel.setType(model.getType());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setEmailOffice(model.getEmailOffice());
		soapModel.setFaxOffice(model.getFaxOffice());
		soapModel.setLevel1(model.getLevel1());
		soapModel.setLevel2(model.getLevel2());
		soapModel.setLevel3(model.getLevel3());
		soapModel.setLevel4(model.getLevel4());
		soapModel.setLevel5(model.getLevel5());
		soapModel.setAcronimo(model.getAcronimo());

		return soapModel;
	}

	public static OrganizationChartSoap[] toSoapModels(
		OrganizationChart[] models) {
		OrganizationChartSoap[] soapModels = new OrganizationChartSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationChartSoap[][] toSoapModels(
		OrganizationChart[][] models) {
		OrganizationChartSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationChartSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationChartSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationChartSoap[] toSoapModels(
		List<OrganizationChart> models) {
		List<OrganizationChartSoap> soapModels = new ArrayList<OrganizationChartSoap>(models.size());

		for (OrganizationChart model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationChartSoap[soapModels.size()]);
	}

	public OrganizationChartSoap() {
	}

	public long getPrimaryKey() {
		return _idOrgChart;
	}

	public void setPrimaryKey(long pk) {
		setIdOrgChart(pk);
	}

	public long getIdOrgChart() {
		return _idOrgChart;
	}

	public void setIdOrgChart(long idOrgChart) {
		_idOrgChart = idOrgChart;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public long getIdParent() {
		return _idParent;
	}

	public void setIdParent(long idParent) {
		_idParent = idParent;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public String getEmailOffice() {
		return _emailOffice;
	}

	public void setEmailOffice(String emailOffice) {
		_emailOffice = emailOffice;
	}

	public String getFaxOffice() {
		return _faxOffice;
	}

	public void setFaxOffice(String faxOffice) {
		_faxOffice = faxOffice;
	}

	public long getLevel1() {
		return _level1;
	}

	public void setLevel1(long level1) {
		_level1 = level1;
	}

	public long getLevel2() {
		return _level2;
	}

	public void setLevel2(long level2) {
		_level2 = level2;
	}

	public long getLevel3() {
		return _level3;
	}

	public void setLevel3(long level3) {
		_level3 = level3;
	}

	public long getLevel4() {
		return _level4;
	}

	public void setLevel4(long level4) {
		_level4 = level4;
	}

	public long getLevel5() {
		return _level5;
	}

	public void setLevel5(long level5) {
		_level5 = level5;
	}

	public String getAcronimo() {
		return _acronimo;
	}

	public void setAcronimo(String acronimo) {
		_acronimo = acronimo;
	}

	private long _idOrgChart;
	private String _name;
	private int _level;
	private long _idParent;
	private String _type;
	private long _locationId;
	private String _emailOffice;
	private String _faxOffice;
	private long _level1;
	private long _level2;
	private long _level3;
	private long _level4;
	private long _level5;
	private String _acronimo;
}