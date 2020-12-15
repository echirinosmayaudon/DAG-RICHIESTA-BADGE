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

import servizio.prenotazione.aule.mef.model.TipoEvento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipoEvento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TipoEvento
 * @generated
 */
@ProviderType
public class TipoEventoCacheModel implements CacheModel<TipoEvento>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoEventoCacheModel)) {
			return false;
		}

		TipoEventoCacheModel tipoEventoCacheModel = (TipoEventoCacheModel)obj;

		if (id_evento == tipoEventoCacheModel.id_evento) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_evento);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_evento=");
		sb.append(id_evento);
		sb.append(", desc_evento=");
		sb.append(desc_evento);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipoEvento toEntityModel() {
		TipoEventoImpl tipoEventoImpl = new TipoEventoImpl();

		tipoEventoImpl.setId_evento(id_evento);

		if (desc_evento == null) {
			tipoEventoImpl.setDesc_evento(StringPool.BLANK);
		}
		else {
			tipoEventoImpl.setDesc_evento(desc_evento);
		}

		tipoEventoImpl.resetOriginalValues();

		return tipoEventoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_evento = objectInput.readLong();
		desc_evento = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_evento);

		if (desc_evento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc_evento);
		}
	}

	public long id_evento;
	public String desc_evento;
}