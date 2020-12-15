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

package com.intranet.mef.gestione.riunioni.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.Luogo;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Luogo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Luogo
 * @generated
 */
@ProviderType
public class LuogoCacheModel implements CacheModel<Luogo>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LuogoCacheModel)) {
			return false;
		}

		LuogoCacheModel luogoCacheModel = (LuogoCacheModel)obj;

		if (id_luogo == luogoCacheModel.id_luogo) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_luogo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_luogo=");
		sb.append(id_luogo);
		sb.append(", nome=");
		sb.append(nome);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Luogo toEntityModel() {
		LuogoImpl luogoImpl = new LuogoImpl();

		luogoImpl.setId_luogo(id_luogo);

		if (nome == null) {
			luogoImpl.setNome(StringPool.BLANK);
		}
		else {
			luogoImpl.setNome(nome);
		}

		luogoImpl.resetOriginalValues();

		return luogoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_luogo = objectInput.readLong();
		nome = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_luogo);

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}
	}

	public long id_luogo;
	public String nome;
}