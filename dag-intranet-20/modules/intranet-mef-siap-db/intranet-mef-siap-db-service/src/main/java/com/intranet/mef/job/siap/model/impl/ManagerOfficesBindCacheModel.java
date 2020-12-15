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

import com.intranet.mef.job.siap.model.ManagerOfficesBind;
import com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ManagerOfficesBind in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ManagerOfficesBind
 * @generated
 */
@ProviderType
public class ManagerOfficesBindCacheModel implements CacheModel<ManagerOfficesBind>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ManagerOfficesBindCacheModel)) {
			return false;
		}

		ManagerOfficesBindCacheModel managerOfficesBindCacheModel = (ManagerOfficesBindCacheModel)obj;

		if (managerOfficesBindPK.equals(
					managerOfficesBindCacheModel.managerOfficesBindPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, managerOfficesBindPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{personalId=");
		sb.append(personalId);
		sb.append(", idOrgChart=");
		sb.append(idOrgChart);
		sb.append(", primary=");
		sb.append(primary);
		sb.append(", regency=");
		sb.append(regency);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ManagerOfficesBind toEntityModel() {
		ManagerOfficesBindImpl managerOfficesBindImpl = new ManagerOfficesBindImpl();

		managerOfficesBindImpl.setPersonalId(personalId);
		managerOfficesBindImpl.setIdOrgChart(idOrgChart);

		if (primary == null) {
			managerOfficesBindImpl.setPrimary(StringPool.BLANK);
		}
		else {
			managerOfficesBindImpl.setPrimary(primary);
		}

		if (regency == null) {
			managerOfficesBindImpl.setRegency(StringPool.BLANK);
		}
		else {
			managerOfficesBindImpl.setRegency(regency);
		}

		managerOfficesBindImpl.resetOriginalValues();

		return managerOfficesBindImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personalId = objectInput.readLong();

		idOrgChart = objectInput.readLong();
		primary = objectInput.readUTF();
		regency = objectInput.readUTF();

		managerOfficesBindPK = new ManagerOfficesBindPK(personalId, idOrgChart);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personalId);

		objectOutput.writeLong(idOrgChart);

		if (primary == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(primary);
		}

		if (regency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regency);
		}
	}

	public long personalId;
	public long idOrgChart;
	public String primary;
	public String regency;
	public transient ManagerOfficesBindPK managerOfficesBindPK;
}