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

import servizio.richieste.badge.mef.model.SediEsterne;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SediEsterne in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SediEsterne
 * @generated
 */
@ProviderType
public class SediEsterneCacheModel implements CacheModel<SediEsterne>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SediEsterneCacheModel)) {
			return false;
		}

		SediEsterneCacheModel sediEsterneCacheModel = (SediEsterneCacheModel)obj;

		if (id_sede_esterna == sediEsterneCacheModel.id_sede_esterna) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_sede_esterna);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_sede_esterna=");
		sb.append(id_sede_esterna);
		sb.append(", nome_sede_esterna=");
		sb.append(nome_sede_esterna);
		sb.append(", id_sedesiap=");
		sb.append(id_sedesiap);
		sb.append(", acronimo_sede=");
		sb.append(acronimo_sede);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SediEsterne toEntityModel() {
		SediEsterneImpl sediEsterneImpl = new SediEsterneImpl();

		sediEsterneImpl.setId_sede_esterna(id_sede_esterna);

		if (nome_sede_esterna == null) {
			sediEsterneImpl.setNome_sede_esterna(StringPool.BLANK);
		}
		else {
			sediEsterneImpl.setNome_sede_esterna(nome_sede_esterna);
		}

		sediEsterneImpl.setId_sedesiap(id_sedesiap);

		if (acronimo_sede == null) {
			sediEsterneImpl.setAcronimo_sede(StringPool.BLANK);
		}
		else {
			sediEsterneImpl.setAcronimo_sede(acronimo_sede);
		}

		sediEsterneImpl.resetOriginalValues();

		return sediEsterneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_sede_esterna = objectInput.readLong();
		nome_sede_esterna = objectInput.readUTF();

		id_sedesiap = objectInput.readLong();
		acronimo_sede = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_sede_esterna);

		if (nome_sede_esterna == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome_sede_esterna);
		}

		objectOutput.writeLong(id_sedesiap);

		if (acronimo_sede == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acronimo_sede);
		}
	}

	public long id_sede_esterna;
	public String nome_sede_esterna;
	public long id_sedesiap;
	public String acronimo_sede;
}