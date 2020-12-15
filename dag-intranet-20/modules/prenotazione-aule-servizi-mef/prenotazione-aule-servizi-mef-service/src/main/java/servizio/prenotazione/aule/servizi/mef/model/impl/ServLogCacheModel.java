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

import servizio.prenotazione.aule.servizi.mef.model.ServLog;
import servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ServLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ServLog
 * @generated
 */
@ProviderType
public class ServLogCacheModel implements CacheModel<ServLog>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServLogCacheModel)) {
			return false;
		}

		ServLogCacheModel servLogCacheModel = (ServLogCacheModel)obj;

		if (servLogPK.equals(servLogCacheModel.servLogPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, servLogPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_serv=");
		sb.append(id_serv);
		sb.append(", id_sala=");
		sb.append(id_sala);
		sb.append(", email_ref=");
		sb.append(email_ref);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServLog toEntityModel() {
		ServLogImpl servLogImpl = new ServLogImpl();

		servLogImpl.setId_serv(id_serv);
		servLogImpl.setId_sala(id_sala);

		if (email_ref == null) {
			servLogImpl.setEmail_ref(StringPool.BLANK);
		}
		else {
			servLogImpl.setEmail_ref(email_ref);
		}

		servLogImpl.resetOriginalValues();

		return servLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_serv = objectInput.readLong();

		id_sala = objectInput.readLong();
		email_ref = objectInput.readUTF();

		servLogPK = new ServLogPK(id_serv, id_sala);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_serv);

		objectOutput.writeLong(id_sala);

		if (email_ref == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email_ref);
		}
	}

	public long id_serv;
	public long id_sala;
	public String email_ref;
	public transient ServLogPK servLogPK;
}