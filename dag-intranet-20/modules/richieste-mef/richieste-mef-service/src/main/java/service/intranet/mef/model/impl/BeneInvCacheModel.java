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

package service.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import service.intranet.mef.model.BeneInv;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BeneInv in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BeneInv
 * @generated
 */
@ProviderType
public class BeneInvCacheModel implements CacheModel<BeneInv>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BeneInvCacheModel)) {
			return false;
		}

		BeneInvCacheModel beneInvCacheModel = (BeneInvCacheModel)obj;

		if (id == beneInvCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", bene=");
		sb.append(bene);
		sb.append(", id_tipo=");
		sb.append(id_tipo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BeneInv toEntityModel() {
		BeneInvImpl beneInvImpl = new BeneInvImpl();

		beneInvImpl.setId(id);

		if (bene == null) {
			beneInvImpl.setBene(StringPool.BLANK);
		}
		else {
			beneInvImpl.setBene(bene);
		}

		beneInvImpl.setId_tipo(id_tipo);

		beneInvImpl.resetOriginalValues();

		return beneInvImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		bene = objectInput.readUTF();

		id_tipo = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (bene == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bene);
		}

		objectOutput.writeLong(id_tipo);
	}

	public long id;
	public String bene;
	public long id_tipo;
}