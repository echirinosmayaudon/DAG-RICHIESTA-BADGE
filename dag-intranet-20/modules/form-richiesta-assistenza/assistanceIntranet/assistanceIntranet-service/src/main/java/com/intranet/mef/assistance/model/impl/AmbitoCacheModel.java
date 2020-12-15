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

package com.intranet.mef.assistance.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Ambito;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Ambito in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Ambito
 * @generated
 */
@ProviderType
public class AmbitoCacheModel implements CacheModel<Ambito>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmbitoCacheModel)) {
			return false;
		}

		AmbitoCacheModel ambitoCacheModel = (AmbitoCacheModel)obj;

		if (assScopeId.equals(ambitoCacheModel.assScopeId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, assScopeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", assScopeId=");
		sb.append(assScopeId);
		sb.append(", scopeName=");
		sb.append(scopeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ambito toEntityModel() {
		AmbitoImpl ambitoImpl = new AmbitoImpl();

		if (uuid == null) {
			ambitoImpl.setUuid(StringPool.BLANK);
		}
		else {
			ambitoImpl.setUuid(uuid);
		}

		if (assScopeId == null) {
			ambitoImpl.setAssScopeId(StringPool.BLANK);
		}
		else {
			ambitoImpl.setAssScopeId(assScopeId);
		}

		if (scopeName == null) {
			ambitoImpl.setScopeName(StringPool.BLANK);
		}
		else {
			ambitoImpl.setScopeName(scopeName);
		}

		ambitoImpl.resetOriginalValues();

		return ambitoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		assScopeId = objectInput.readUTF();
		scopeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (assScopeId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assScopeId);
		}

		if (scopeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scopeName);
		}
	}

	public String uuid;
	public String assScopeId;
	public String scopeName;
}