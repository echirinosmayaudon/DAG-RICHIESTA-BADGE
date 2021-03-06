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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the OrganizationChart service. Represents a row in the &quot;LF_ORGANIGRAMMA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.job.siap.model.impl.OrganizationChartModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.job.siap.model.impl.OrganizationChartImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChart
 * @see com.intranet.mef.job.siap.model.impl.OrganizationChartImpl
 * @see com.intranet.mef.job.siap.model.impl.OrganizationChartModelImpl
 * @generated
 */
@ProviderType
public interface OrganizationChartModel extends BaseModel<OrganizationChart> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a organization chart model instance should use the {@link OrganizationChart} interface instead.
	 */

	/**
	 * Returns the primary key of this organization chart.
	 *
	 * @return the primary key of this organization chart
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this organization chart.
	 *
	 * @param primaryKey the primary key of this organization chart
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id org chart of this organization chart.
	 *
	 * @return the id org chart of this organization chart
	 */
	public long getIdOrgChart();

	/**
	 * Sets the id org chart of this organization chart.
	 *
	 * @param idOrgChart the id org chart of this organization chart
	 */
	public void setIdOrgChart(long idOrgChart);

	/**
	 * Returns the name of this organization chart.
	 *
	 * @return the name of this organization chart
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this organization chart.
	 *
	 * @param name the name of this organization chart
	 */
	public void setName(String name);

	/**
	 * Returns the level of this organization chart.
	 *
	 * @return the level of this organization chart
	 */
	public int getLevel();

	/**
	 * Sets the level of this organization chart.
	 *
	 * @param level the level of this organization chart
	 */
	public void setLevel(int level);

	/**
	 * Returns the id parent of this organization chart.
	 *
	 * @return the id parent of this organization chart
	 */
	public long getIdParent();

	/**
	 * Sets the id parent of this organization chart.
	 *
	 * @param idParent the id parent of this organization chart
	 */
	public void setIdParent(long idParent);

	/**
	 * Returns the type of this organization chart.
	 *
	 * @return the type of this organization chart
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this organization chart.
	 *
	 * @param type the type of this organization chart
	 */
	public void setType(String type);

	/**
	 * Returns the location ID of this organization chart.
	 *
	 * @return the location ID of this organization chart
	 */
	public long getLocationId();

	/**
	 * Sets the location ID of this organization chart.
	 *
	 * @param locationId the location ID of this organization chart
	 */
	public void setLocationId(long locationId);

	/**
	 * Returns the email office of this organization chart.
	 *
	 * @return the email office of this organization chart
	 */
	@AutoEscape
	public String getEmailOffice();

	/**
	 * Sets the email office of this organization chart.
	 *
	 * @param emailOffice the email office of this organization chart
	 */
	public void setEmailOffice(String emailOffice);

	/**
	 * Returns the fax office of this organization chart.
	 *
	 * @return the fax office of this organization chart
	 */
	@AutoEscape
	public String getFaxOffice();

	/**
	 * Sets the fax office of this organization chart.
	 *
	 * @param faxOffice the fax office of this organization chart
	 */
	public void setFaxOffice(String faxOffice);

	/**
	 * Returns the level1 of this organization chart.
	 *
	 * @return the level1 of this organization chart
	 */
	public long getLevel1();

	/**
	 * Sets the level1 of this organization chart.
	 *
	 * @param level1 the level1 of this organization chart
	 */
	public void setLevel1(long level1);

	/**
	 * Returns the level2 of this organization chart.
	 *
	 * @return the level2 of this organization chart
	 */
	public long getLevel2();

	/**
	 * Sets the level2 of this organization chart.
	 *
	 * @param level2 the level2 of this organization chart
	 */
	public void setLevel2(long level2);

	/**
	 * Returns the level3 of this organization chart.
	 *
	 * @return the level3 of this organization chart
	 */
	public long getLevel3();

	/**
	 * Sets the level3 of this organization chart.
	 *
	 * @param level3 the level3 of this organization chart
	 */
	public void setLevel3(long level3);

	/**
	 * Returns the level4 of this organization chart.
	 *
	 * @return the level4 of this organization chart
	 */
	public long getLevel4();

	/**
	 * Sets the level4 of this organization chart.
	 *
	 * @param level4 the level4 of this organization chart
	 */
	public void setLevel4(long level4);

	/**
	 * Returns the level5 of this organization chart.
	 *
	 * @return the level5 of this organization chart
	 */
	public long getLevel5();

	/**
	 * Sets the level5 of this organization chart.
	 *
	 * @param level5 the level5 of this organization chart
	 */
	public void setLevel5(long level5);

	/**
	 * Returns the acronimo of this organization chart.
	 *
	 * @return the acronimo of this organization chart
	 */
	@AutoEscape
	public String getAcronimo();

	/**
	 * Sets the acronimo of this organization chart.
	 *
	 * @param acronimo the acronimo of this organization chart
	 */
	public void setAcronimo(String acronimo);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(OrganizationChart organizationChart);

	@Override
	public int hashCode();

	@Override
	public CacheModel<OrganizationChart> toCacheModel();

	@Override
	public OrganizationChart toEscapedModel();

	@Override
	public OrganizationChart toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}