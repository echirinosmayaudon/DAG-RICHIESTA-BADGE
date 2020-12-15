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

package servizio.prenotazione.aule.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.prenotazione.aule.mef.model.Orario;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Orario in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Orario
 * @generated
 */
@ProviderType
public class OrarioCacheModel implements CacheModel<Orario>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrarioCacheModel)) {
			return false;
		}

		OrarioCacheModel orarioCacheModel = (OrarioCacheModel)obj;

		if (id_ora == orarioCacheModel.id_ora) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_ora);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_ora=");
		sb.append(id_ora);
		sb.append(", ore=");
		sb.append(ore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Orario toEntityModel() {
		OrarioImpl orarioImpl = new OrarioImpl();

		orarioImpl.setId_ora(id_ora);

		if (ore == null) {
			orarioImpl.setOre(StringPool.BLANK);
		}
		else {
			orarioImpl.setOre(ore);
		}

		orarioImpl.resetOriginalValues();

		return orarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ora = objectInput.readLong();
		ore = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_ora);

		if (ore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ore);
		}
	}

	public long id_ora;
	public String ore;
}