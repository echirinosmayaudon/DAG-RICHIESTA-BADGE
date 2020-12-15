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

import com.intranet.mef.gestione.riunioni.model.TipoRiunione;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipoRiunione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TipoRiunione
 * @generated
 */
@ProviderType
public class TipoRiunioneCacheModel implements CacheModel<TipoRiunione>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoRiunioneCacheModel)) {
			return false;
		}

		TipoRiunioneCacheModel tipoRiunioneCacheModel = (TipoRiunioneCacheModel)obj;

		if (id_tipo == tipoRiunioneCacheModel.id_tipo) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_tipo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_tipo=");
		sb.append(id_tipo);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipoRiunione toEntityModel() {
		TipoRiunioneImpl tipoRiunioneImpl = new TipoRiunioneImpl();

		tipoRiunioneImpl.setId_tipo(id_tipo);

		if (descrizione == null) {
			tipoRiunioneImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			tipoRiunioneImpl.setDescrizione(descrizione);
		}

		tipoRiunioneImpl.resetOriginalValues();

		return tipoRiunioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_tipo = objectInput.readLong();
		descrizione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_tipo);

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id_tipo;
	public String descrizione;
}