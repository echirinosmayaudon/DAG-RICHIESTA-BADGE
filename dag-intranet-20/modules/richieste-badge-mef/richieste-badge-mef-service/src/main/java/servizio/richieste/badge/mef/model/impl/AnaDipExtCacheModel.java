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

package servizio.richieste.badge.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.richieste.badge.mef.model.AnaDipExt;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AnaDipExt in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnaDipExt
 * @generated
 */
@ProviderType
public class AnaDipExtCacheModel implements CacheModel<AnaDipExt>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnaDipExtCacheModel)) {
			return false;
		}

		AnaDipExtCacheModel anaDipExtCacheModel = (AnaDipExtCacheModel)obj;

		if (id_dip_ext == anaDipExtCacheModel.id_dip_ext) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_dip_ext);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id_dip_ext=");
		sb.append(id_dip_ext);
		sb.append(", nome_dip_ext=");
		sb.append(nome_dip_ext);
		sb.append(", cognome_dip_ext=");
		sb.append(cognome_dip_ext);
		sb.append(", cf_dip_ext=");
		sb.append(cf_dip_ext);
		sb.append(", luogonascita_dip_ext=");
		sb.append(luogonascita_dip_ext);
		sb.append(", datanascita_dip_ext=");
		sb.append(datanascita_dip_ext);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnaDipExt toEntityModel() {
		AnaDipExtImpl anaDipExtImpl = new AnaDipExtImpl();

		anaDipExtImpl.setId_dip_ext(id_dip_ext);

		if (nome_dip_ext == null) {
			anaDipExtImpl.setNome_dip_ext(StringPool.BLANK);
		}
		else {
			anaDipExtImpl.setNome_dip_ext(nome_dip_ext);
		}

		if (cognome_dip_ext == null) {
			anaDipExtImpl.setCognome_dip_ext(StringPool.BLANK);
		}
		else {
			anaDipExtImpl.setCognome_dip_ext(cognome_dip_ext);
		}

		if (cf_dip_ext == null) {
			anaDipExtImpl.setCf_dip_ext(StringPool.BLANK);
		}
		else {
			anaDipExtImpl.setCf_dip_ext(cf_dip_ext);
		}

		if (luogonascita_dip_ext == null) {
			anaDipExtImpl.setLuogonascita_dip_ext(StringPool.BLANK);
		}
		else {
			anaDipExtImpl.setLuogonascita_dip_ext(luogonascita_dip_ext);
		}

		if (datanascita_dip_ext == Long.MIN_VALUE) {
			anaDipExtImpl.setDatanascita_dip_ext(null);
		}
		else {
			anaDipExtImpl.setDatanascita_dip_ext(new Date(datanascita_dip_ext));
		}

		anaDipExtImpl.resetOriginalValues();

		return anaDipExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_dip_ext = objectInput.readLong();
		nome_dip_ext = objectInput.readUTF();
		cognome_dip_ext = objectInput.readUTF();
		cf_dip_ext = objectInput.readUTF();
		luogonascita_dip_ext = objectInput.readUTF();
		datanascita_dip_ext = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_dip_ext);

		if (nome_dip_ext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome_dip_ext);
		}

		if (cognome_dip_ext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cognome_dip_ext);
		}

		if (cf_dip_ext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cf_dip_ext);
		}

		if (luogonascita_dip_ext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(luogonascita_dip_ext);
		}

		objectOutput.writeLong(datanascita_dip_ext);
	}

	public long id_dip_ext;
	public String nome_dip_ext;
	public String cognome_dip_ext;
	public String cf_dip_ext;
	public String luogonascita_dip_ext;
	public long datanascita_dip_ext;
}