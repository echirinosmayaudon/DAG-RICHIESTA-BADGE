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

package com.intranet.mef.job.siap.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.model.OrganizationChart;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrganizationChart in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChart
 * @generated
 */
@ProviderType
public class OrganizationChartCacheModel implements CacheModel<OrganizationChart>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationChartCacheModel)) {
			return false;
		}

		OrganizationChartCacheModel organizationChartCacheModel = (OrganizationChartCacheModel)obj;

		if (idOrgChart == organizationChartCacheModel.idOrgChart) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idOrgChart);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{idOrgChart=");
		sb.append(idOrgChart);
		sb.append(", name=");
		sb.append(name);
		sb.append(", level=");
		sb.append(level);
		sb.append(", idParent=");
		sb.append(idParent);
		sb.append(", type=");
		sb.append(type);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", emailOffice=");
		sb.append(emailOffice);
		sb.append(", faxOffice=");
		sb.append(faxOffice);
		sb.append(", level1=");
		sb.append(level1);
		sb.append(", level2=");
		sb.append(level2);
		sb.append(", level3=");
		sb.append(level3);
		sb.append(", level4=");
		sb.append(level4);
		sb.append(", level5=");
		sb.append(level5);
		sb.append(", acronimo=");
		sb.append(acronimo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizationChart toEntityModel() {
		OrganizationChartImpl organizationChartImpl = new OrganizationChartImpl();

		organizationChartImpl.setIdOrgChart(idOrgChart);

		if (name == null) {
			organizationChartImpl.setName(StringPool.BLANK);
		}
		else {
			organizationChartImpl.setName(name);
		}

		organizationChartImpl.setLevel(level);
		organizationChartImpl.setIdParent(idParent);

		if (type == null) {
			organizationChartImpl.setType(StringPool.BLANK);
		}
		else {
			organizationChartImpl.setType(type);
		}

		organizationChartImpl.setLocationId(locationId);

		if (emailOffice == null) {
			organizationChartImpl.setEmailOffice(StringPool.BLANK);
		}
		else {
			organizationChartImpl.setEmailOffice(emailOffice);
		}

		if (faxOffice == null) {
			organizationChartImpl.setFaxOffice(StringPool.BLANK);
		}
		else {
			organizationChartImpl.setFaxOffice(faxOffice);
		}

		organizationChartImpl.setLevel1(level1);
		organizationChartImpl.setLevel2(level2);
		organizationChartImpl.setLevel3(level3);
		organizationChartImpl.setLevel4(level4);
		organizationChartImpl.setLevel5(level5);

		if (acronimo == null) {
			organizationChartImpl.setAcronimo(StringPool.BLANK);
		}
		else {
			organizationChartImpl.setAcronimo(acronimo);
		}

		organizationChartImpl.resetOriginalValues();

		return organizationChartImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idOrgChart = objectInput.readLong();
		name = objectInput.readUTF();

		level = objectInput.readInt();

		idParent = objectInput.readLong();
		type = objectInput.readUTF();

		locationId = objectInput.readLong();
		emailOffice = objectInput.readUTF();
		faxOffice = objectInput.readUTF();

		level1 = objectInput.readLong();

		level2 = objectInput.readLong();

		level3 = objectInput.readLong();

		level4 = objectInput.readLong();

		level5 = objectInput.readLong();
		acronimo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idOrgChart);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(level);

		objectOutput.writeLong(idParent);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(locationId);

		if (emailOffice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailOffice);
		}

		if (faxOffice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(faxOffice);
		}

		objectOutput.writeLong(level1);

		objectOutput.writeLong(level2);

		objectOutput.writeLong(level3);

		objectOutput.writeLong(level4);

		objectOutput.writeLong(level5);

		if (acronimo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acronimo);
		}
	}

	public long idOrgChart;
	public String name;
	public int level;
	public long idParent;
	public String type;
	public long locationId;
	public String emailOffice;
	public String faxOffice;
	public long level1;
	public long level2;
	public long level3;
	public long level4;
	public long level5;
	public String acronimo;
}