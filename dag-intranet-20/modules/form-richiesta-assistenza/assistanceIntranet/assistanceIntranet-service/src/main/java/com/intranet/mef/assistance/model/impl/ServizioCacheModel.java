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

import com.intranet.mef.assistance.model.Servizio;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Servizio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Servizio
 * @generated
 */
@ProviderType
public class ServizioCacheModel implements CacheModel<Servizio>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServizioCacheModel)) {
			return false;
		}

		ServizioCacheModel servizioCacheModel = (ServizioCacheModel)obj;

		if (assServiceId.equals(servizioCacheModel.assServiceId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, assServiceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", assServiceId=");
		sb.append(assServiceId);
		sb.append(", serviceName=");
		sb.append(serviceName);
		sb.append(", assScopeId=");
		sb.append(assScopeId);
		sb.append(", levelAssistance=");
		sb.append(levelAssistance);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Servizio toEntityModel() {
		ServizioImpl servizioImpl = new ServizioImpl();

		if (uuid == null) {
			servizioImpl.setUuid(StringPool.BLANK);
		}
		else {
			servizioImpl.setUuid(uuid);
		}

		if (assServiceId == null) {
			servizioImpl.setAssServiceId(StringPool.BLANK);
		}
		else {
			servizioImpl.setAssServiceId(assServiceId);
		}

		if (serviceName == null) {
			servizioImpl.setServiceName(StringPool.BLANK);
		}
		else {
			servizioImpl.setServiceName(serviceName);
		}

		if (assScopeId == null) {
			servizioImpl.setAssScopeId(StringPool.BLANK);
		}
		else {
			servizioImpl.setAssScopeId(assScopeId);
		}

		if (levelAssistance == null) {
			servizioImpl.setLevelAssistance(StringPool.BLANK);
		}
		else {
			servizioImpl.setLevelAssistance(levelAssistance);
		}

		servizioImpl.resetOriginalValues();

		return servizioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		assServiceId = objectInput.readUTF();
		serviceName = objectInput.readUTF();
		assScopeId = objectInput.readUTF();
		levelAssistance = objectInput.readUTF();
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

		if (assServiceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assServiceId);
		}

		if (serviceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceName);
		}

		if (assScopeId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assScopeId);
		}

		if (levelAssistance == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(levelAssistance);
		}
	}

	public String uuid;
	public String assServiceId;
	public String serviceName;
	public String assScopeId;
	public String levelAssistance;
}