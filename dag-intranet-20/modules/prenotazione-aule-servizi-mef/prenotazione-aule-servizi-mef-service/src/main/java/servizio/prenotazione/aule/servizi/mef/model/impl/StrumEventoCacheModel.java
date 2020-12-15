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

package servizio.prenotazione.aule.servizi.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.prenotazione.aule.servizi.mef.model.StrumEvento;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StrumEvento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StrumEvento
 * @generated
 */
@ProviderType
public class StrumEventoCacheModel implements CacheModel<StrumEvento>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumEventoCacheModel)) {
			return false;
		}

		StrumEventoCacheModel strumEventoCacheModel = (StrumEventoCacheModel)obj;

		if (strumEventoPK.equals(strumEventoCacheModel.strumEventoPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, strumEventoPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_strum=");
		sb.append(id_strum);
		sb.append(", id_sala=");
		sb.append(id_sala);
		sb.append(", email_ref=");
		sb.append(email_ref);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StrumEvento toEntityModel() {
		StrumEventoImpl strumEventoImpl = new StrumEventoImpl();

		strumEventoImpl.setId_strum(id_strum);
		strumEventoImpl.setId_sala(id_sala);

		if (email_ref == null) {
			strumEventoImpl.setEmail_ref(StringPool.BLANK);
		}
		else {
			strumEventoImpl.setEmail_ref(email_ref);
		}

		strumEventoImpl.resetOriginalValues();

		return strumEventoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_strum = objectInput.readLong();

		id_sala = objectInput.readLong();
		email_ref = objectInput.readUTF();

		strumEventoPK = new StrumEventoPK(id_strum, id_sala);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_strum);

		objectOutput.writeLong(id_sala);

		if (email_ref == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email_ref);
		}
	}

	public long id_strum;
	public long id_sala;
	public String email_ref;
	public transient StrumEventoPK strumEventoPK;
}