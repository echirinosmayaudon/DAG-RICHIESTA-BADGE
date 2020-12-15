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

import com.intranet.mef.job.siap.model.UserPosition;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserPosition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserPosition
 * @generated
 */
@ProviderType
public class UserPositionCacheModel implements CacheModel<UserPosition>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPositionCacheModel)) {
			return false;
		}

		UserPositionCacheModel userPositionCacheModel = (UserPositionCacheModel)obj;

		if (pos.equals(userPositionCacheModel.pos)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pos);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{pos=");
		sb.append(pos);
		sb.append(", ruoloGiuridico=");
		sb.append(ruoloGiuridico);
		sb.append(", ruoloEconomico=");
		sb.append(ruoloEconomico);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserPosition toEntityModel() {
		UserPositionImpl userPositionImpl = new UserPositionImpl();

		if (pos == null) {
			userPositionImpl.setPos(StringPool.BLANK);
		}
		else {
			userPositionImpl.setPos(pos);
		}

		if (ruoloGiuridico == null) {
			userPositionImpl.setRuoloGiuridico(StringPool.BLANK);
		}
		else {
			userPositionImpl.setRuoloGiuridico(ruoloGiuridico);
		}

		if (ruoloEconomico == null) {
			userPositionImpl.setRuoloEconomico(StringPool.BLANK);
		}
		else {
			userPositionImpl.setRuoloEconomico(ruoloEconomico);
		}

		userPositionImpl.resetOriginalValues();

		return userPositionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pos = objectInput.readUTF();
		ruoloGiuridico = objectInput.readUTF();
		ruoloEconomico = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (pos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pos);
		}

		if (ruoloGiuridico == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ruoloGiuridico);
		}

		if (ruoloEconomico == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ruoloEconomico);
		}
	}

	public String pos;
	public String ruoloGiuridico;
	public String ruoloEconomico;
}