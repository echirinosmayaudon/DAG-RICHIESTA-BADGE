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

package servizio.richiesta.trasporti.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.richiesta.trasporti.model.Mobilita;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Mobilita in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Mobilita
 * @generated
 */
@ProviderType
public class MobilitaCacheModel implements CacheModel<Mobilita>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MobilitaCacheModel)) {
			return false;
		}

		MobilitaCacheModel mobilitaCacheModel = (MobilitaCacheModel)obj;

		if (custom_key.equals(mobilitaCacheModel.custom_key)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, custom_key);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{custom_key=");
		sb.append(custom_key);
		sb.append(", person_id=");
		sb.append(person_id);
		sb.append(", tipo_mobilita=");
		sb.append(tipo_mobilita);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Mobilita toEntityModel() {
		MobilitaImpl mobilitaImpl = new MobilitaImpl();

		if (custom_key == null) {
			mobilitaImpl.setCustom_key(StringPool.BLANK);
		}
		else {
			mobilitaImpl.setCustom_key(custom_key);
		}

		mobilitaImpl.setPerson_id(person_id);

		if (tipo_mobilita == null) {
			mobilitaImpl.setTipo_mobilita(StringPool.BLANK);
		}
		else {
			mobilitaImpl.setTipo_mobilita(tipo_mobilita);
		}

		mobilitaImpl.resetOriginalValues();

		return mobilitaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		custom_key = objectInput.readUTF();

		person_id = objectInput.readLong();
		tipo_mobilita = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (custom_key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(custom_key);
		}

		objectOutput.writeLong(person_id);

		if (tipo_mobilita == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipo_mobilita);
		}
	}

	public String custom_key;
	public long person_id;
	public String tipo_mobilita;
}