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

package com.intranet.mef.job.siap.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ManagerOfficesBindPK implements Comparable<ManagerOfficesBindPK>,
	Serializable {
	public long personalId;
	public long idOrgChart;

	public ManagerOfficesBindPK() {
	}

	public ManagerOfficesBindPK(long personalId, long idOrgChart) {
		this.personalId = personalId;
		this.idOrgChart = idOrgChart;
	}

	public long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(long personalId) {
		this.personalId = personalId;
	}

	public long getIdOrgChart() {
		return idOrgChart;
	}

	public void setIdOrgChart(long idOrgChart) {
		this.idOrgChart = idOrgChart;
	}

	@Override
	public int compareTo(ManagerOfficesBindPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (personalId < pk.personalId) {
			value = -1;
		}
		else if (personalId > pk.personalId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (idOrgChart < pk.idOrgChart) {
			value = -1;
		}
		else if (idOrgChart > pk.idOrgChart) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ManagerOfficesBindPK)) {
			return false;
		}

		ManagerOfficesBindPK pk = (ManagerOfficesBindPK)obj;

		if ((personalId == pk.personalId) && (idOrgChart == pk.idOrgChart)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, personalId);
		hashCode = HashUtil.hash(hashCode, idOrgChart);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("personalId");
		sb.append(StringPool.EQUAL);
		sb.append(personalId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("idOrgChart");
		sb.append(StringPool.EQUAL);
		sb.append(idOrgChart);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}