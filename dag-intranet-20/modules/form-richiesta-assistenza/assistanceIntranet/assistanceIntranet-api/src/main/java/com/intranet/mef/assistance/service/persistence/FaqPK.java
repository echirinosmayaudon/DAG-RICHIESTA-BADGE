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

package com.intranet.mef.assistance.service.persistence;

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
public class FaqPK implements Comparable<FaqPK>, Serializable {
	public String faqId;
	public String siebelId;

	public FaqPK() {
	}

	public FaqPK(String faqId, String siebelId) {
		this.faqId = faqId;
		this.siebelId = siebelId;
	}

	public String getFaqId() {
		return faqId;
	}

	public void setFaqId(String faqId) {
		this.faqId = faqId;
	}

	public String getSiebelId() {
		return siebelId;
	}

	public void setSiebelId(String siebelId) {
		this.siebelId = siebelId;
	}

	@Override
	public int compareTo(FaqPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = faqId.compareTo(pk.faqId);

		if (value != 0) {
			return value;
		}

		value = siebelId.compareTo(pk.siebelId);

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

		if (!(obj instanceof FaqPK)) {
			return false;
		}

		FaqPK pk = (FaqPK)obj;

		if ((faqId.equals(pk.faqId)) && (siebelId.equals(pk.siebelId))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, faqId);
		hashCode = HashUtil.hash(hashCode, siebelId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("faqId");
		sb.append(StringPool.EQUAL);
		sb.append(faqId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("siebelId");
		sb.append(StringPool.EQUAL);
		sb.append(siebelId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}