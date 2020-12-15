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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link OrganizationChart}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChart
 * @generated
 */
@ProviderType
public class OrganizationChartWrapper implements OrganizationChart,
	ModelWrapper<OrganizationChart> {
	public OrganizationChartWrapper(OrganizationChart organizationChart) {
		_organizationChart = organizationChart;
	}

	@Override
	public Class<?> getModelClass() {
		return OrganizationChart.class;
	}

	@Override
	public String getModelClassName() {
		return OrganizationChart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idOrgChart", getIdOrgChart());
		attributes.put("name", getName());
		attributes.put("level", getLevel());
		attributes.put("idParent", getIdParent());
		attributes.put("type", getType());
		attributes.put("locationId", getLocationId());
		attributes.put("emailOffice", getEmailOffice());
		attributes.put("faxOffice", getFaxOffice());
		attributes.put("level1", getLevel1());
		attributes.put("level2", getLevel2());
		attributes.put("level3", getLevel3());
		attributes.put("level4", getLevel4());
		attributes.put("level5", getLevel5());
		attributes.put("acronimo", getAcronimo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idOrgChart = (Long)attributes.get("idOrgChart");

		if (idOrgChart != null) {
			setIdOrgChart(idOrgChart);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long idParent = (Long)attributes.get("idParent");

		if (idParent != null) {
			setIdParent(idParent);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String emailOffice = (String)attributes.get("emailOffice");

		if (emailOffice != null) {
			setEmailOffice(emailOffice);
		}

		String faxOffice = (String)attributes.get("faxOffice");

		if (faxOffice != null) {
			setFaxOffice(faxOffice);
		}

		Long level1 = (Long)attributes.get("level1");

		if (level1 != null) {
			setLevel1(level1);
		}

		Long level2 = (Long)attributes.get("level2");

		if (level2 != null) {
			setLevel2(level2);
		}

		Long level3 = (Long)attributes.get("level3");

		if (level3 != null) {
			setLevel3(level3);
		}

		Long level4 = (Long)attributes.get("level4");

		if (level4 != null) {
			setLevel4(level4);
		}

		Long level5 = (Long)attributes.get("level5");

		if (level5 != null) {
			setLevel5(level5);
		}

		String acronimo = (String)attributes.get("acronimo");

		if (acronimo != null) {
			setAcronimo(acronimo);
		}
	}

	@Override
	public OrganizationChart toEscapedModel() {
		return new OrganizationChartWrapper(_organizationChart.toEscapedModel());
	}

	@Override
	public OrganizationChart toUnescapedModel() {
		return new OrganizationChartWrapper(_organizationChart.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _organizationChart.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _organizationChart.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _organizationChart.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _organizationChart.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<OrganizationChart> toCacheModel() {
		return _organizationChart.toCacheModel();
	}

	@Override
	public int compareTo(OrganizationChart organizationChart) {
		return _organizationChart.compareTo(organizationChart);
	}

	/**
	* Returns the level of this organization chart.
	*
	* @return the level of this organization chart
	*/
	@Override
	public int getLevel() {
		return _organizationChart.getLevel();
	}

	@Override
	public int hashCode() {
		return _organizationChart.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _organizationChart.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationChartWrapper((OrganizationChart)_organizationChart.clone());
	}

	/**
	* Returns the acronimo of this organization chart.
	*
	* @return the acronimo of this organization chart
	*/
	@Override
	public java.lang.String getAcronimo() {
		return _organizationChart.getAcronimo();
	}

	/**
	* Returns the email office of this organization chart.
	*
	* @return the email office of this organization chart
	*/
	@Override
	public java.lang.String getEmailOffice() {
		return _organizationChart.getEmailOffice();
	}

	/**
	* Returns the fax office of this organization chart.
	*
	* @return the fax office of this organization chart
	*/
	@Override
	public java.lang.String getFaxOffice() {
		return _organizationChart.getFaxOffice();
	}

	/**
	* Returns the name of this organization chart.
	*
	* @return the name of this organization chart
	*/
	@Override
	public java.lang.String getName() {
		return _organizationChart.getName();
	}

	/**
	* Returns the type of this organization chart.
	*
	* @return the type of this organization chart
	*/
	@Override
	public java.lang.String getType() {
		return _organizationChart.getType();
	}

	@Override
	public java.lang.String toString() {
		return _organizationChart.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organizationChart.toXmlString();
	}

	/**
	* Returns the id org chart of this organization chart.
	*
	* @return the id org chart of this organization chart
	*/
	@Override
	public long getIdOrgChart() {
		return _organizationChart.getIdOrgChart();
	}

	/**
	* Returns the id parent of this organization chart.
	*
	* @return the id parent of this organization chart
	*/
	@Override
	public long getIdParent() {
		return _organizationChart.getIdParent();
	}

	/**
	* Returns the level1 of this organization chart.
	*
	* @return the level1 of this organization chart
	*/
	@Override
	public long getLevel1() {
		return _organizationChart.getLevel1();
	}

	/**
	* Returns the level2 of this organization chart.
	*
	* @return the level2 of this organization chart
	*/
	@Override
	public long getLevel2() {
		return _organizationChart.getLevel2();
	}

	/**
	* Returns the level3 of this organization chart.
	*
	* @return the level3 of this organization chart
	*/
	@Override
	public long getLevel3() {
		return _organizationChart.getLevel3();
	}

	/**
	* Returns the level4 of this organization chart.
	*
	* @return the level4 of this organization chart
	*/
	@Override
	public long getLevel4() {
		return _organizationChart.getLevel4();
	}

	/**
	* Returns the level5 of this organization chart.
	*
	* @return the level5 of this organization chart
	*/
	@Override
	public long getLevel5() {
		return _organizationChart.getLevel5();
	}

	/**
	* Returns the location ID of this organization chart.
	*
	* @return the location ID of this organization chart
	*/
	@Override
	public long getLocationId() {
		return _organizationChart.getLocationId();
	}

	/**
	* Returns the primary key of this organization chart.
	*
	* @return the primary key of this organization chart
	*/
	@Override
	public long getPrimaryKey() {
		return _organizationChart.getPrimaryKey();
	}

	@Override
	public void persist() {
		_organizationChart.persist();
	}

	/**
	* Sets the acronimo of this organization chart.
	*
	* @param acronimo the acronimo of this organization chart
	*/
	@Override
	public void setAcronimo(java.lang.String acronimo) {
		_organizationChart.setAcronimo(acronimo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organizationChart.setCachedModel(cachedModel);
	}

	/**
	* Sets the email office of this organization chart.
	*
	* @param emailOffice the email office of this organization chart
	*/
	@Override
	public void setEmailOffice(java.lang.String emailOffice) {
		_organizationChart.setEmailOffice(emailOffice);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_organizationChart.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_organizationChart.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_organizationChart.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fax office of this organization chart.
	*
	* @param faxOffice the fax office of this organization chart
	*/
	@Override
	public void setFaxOffice(java.lang.String faxOffice) {
		_organizationChart.setFaxOffice(faxOffice);
	}

	/**
	* Sets the id org chart of this organization chart.
	*
	* @param idOrgChart the id org chart of this organization chart
	*/
	@Override
	public void setIdOrgChart(long idOrgChart) {
		_organizationChart.setIdOrgChart(idOrgChart);
	}

	/**
	* Sets the id parent of this organization chart.
	*
	* @param idParent the id parent of this organization chart
	*/
	@Override
	public void setIdParent(long idParent) {
		_organizationChart.setIdParent(idParent);
	}

	/**
	* Sets the level of this organization chart.
	*
	* @param level the level of this organization chart
	*/
	@Override
	public void setLevel(int level) {
		_organizationChart.setLevel(level);
	}

	/**
	* Sets the level1 of this organization chart.
	*
	* @param level1 the level1 of this organization chart
	*/
	@Override
	public void setLevel1(long level1) {
		_organizationChart.setLevel1(level1);
	}

	/**
	* Sets the level2 of this organization chart.
	*
	* @param level2 the level2 of this organization chart
	*/
	@Override
	public void setLevel2(long level2) {
		_organizationChart.setLevel2(level2);
	}

	/**
	* Sets the level3 of this organization chart.
	*
	* @param level3 the level3 of this organization chart
	*/
	@Override
	public void setLevel3(long level3) {
		_organizationChart.setLevel3(level3);
	}

	/**
	* Sets the level4 of this organization chart.
	*
	* @param level4 the level4 of this organization chart
	*/
	@Override
	public void setLevel4(long level4) {
		_organizationChart.setLevel4(level4);
	}

	/**
	* Sets the level5 of this organization chart.
	*
	* @param level5 the level5 of this organization chart
	*/
	@Override
	public void setLevel5(long level5) {
		_organizationChart.setLevel5(level5);
	}

	/**
	* Sets the location ID of this organization chart.
	*
	* @param locationId the location ID of this organization chart
	*/
	@Override
	public void setLocationId(long locationId) {
		_organizationChart.setLocationId(locationId);
	}

	/**
	* Sets the name of this organization chart.
	*
	* @param name the name of this organization chart
	*/
	@Override
	public void setName(java.lang.String name) {
		_organizationChart.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_organizationChart.setNew(n);
	}

	/**
	* Sets the primary key of this organization chart.
	*
	* @param primaryKey the primary key of this organization chart
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_organizationChart.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_organizationChart.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type of this organization chart.
	*
	* @param type the type of this organization chart
	*/
	@Override
	public void setType(java.lang.String type) {
		_organizationChart.setType(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationChartWrapper)) {
			return false;
		}

		OrganizationChartWrapper organizationChartWrapper = (OrganizationChartWrapper)obj;

		if (Objects.equals(_organizationChart,
					organizationChartWrapper._organizationChart)) {
			return true;
		}

		return false;
	}

	@Override
	public OrganizationChart getWrappedModel() {
		return _organizationChart;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _organizationChart.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _organizationChart.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_organizationChart.resetOriginalValues();
	}

	private final OrganizationChart _organizationChart;
}