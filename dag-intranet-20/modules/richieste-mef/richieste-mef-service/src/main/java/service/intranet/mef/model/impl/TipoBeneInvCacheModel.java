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

import service.intranet.mef.model.TipoBeneInv;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipoBeneInv in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TipoBeneInv
 * @generated
 */
@ProviderType
public class TipoBeneInvCacheModel implements CacheModel<TipoBeneInv>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoBeneInvCacheModel)) {
			return false;
		}

		TipoBeneInvCacheModel tipoBeneInvCacheModel = (TipoBeneInvCacheModel)obj;

		if (id == tipoBeneInvCacheModel.id) {
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
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipoBeneInv toEntityModel() {
		TipoBeneInvImpl tipoBeneInvImpl = new TipoBeneInvImpl();

		tipoBeneInvImpl.setId(id);

		if (tipo == null) {
			tipoBeneInvImpl.setTipo(StringPool.BLANK);
		}
		else {
			tipoBeneInvImpl.setTipo(tipo);
		}

		tipoBeneInvImpl.resetOriginalValues();

		return tipoBeneInvImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		tipo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (tipo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipo);
		}
	}

	public long id;
	public String tipo;
}