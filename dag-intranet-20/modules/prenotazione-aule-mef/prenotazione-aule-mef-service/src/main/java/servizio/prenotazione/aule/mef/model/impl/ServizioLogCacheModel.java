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

import servizio.prenotazione.aule.mef.model.ServizioLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ServizioLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLog
 * @generated
 */
@ProviderType
public class ServizioLogCacheModel implements CacheModel<ServizioLog>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServizioLogCacheModel)) {
			return false;
		}

		ServizioLogCacheModel servizioLogCacheModel = (ServizioLogCacheModel)obj;

		if (id_servizio == servizioLogCacheModel.id_servizio) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_servizio);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_servizio=");
		sb.append(id_servizio);
		sb.append(", desc_servizio=");
		sb.append(desc_servizio);
		sb.append(", email_ref=");
		sb.append(email_ref);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServizioLog toEntityModel() {
		ServizioLogImpl servizioLogImpl = new ServizioLogImpl();

		servizioLogImpl.setId_servizio(id_servizio);

		if (desc_servizio == null) {
			servizioLogImpl.setDesc_servizio(StringPool.BLANK);
		}
		else {
			servizioLogImpl.setDesc_servizio(desc_servizio);
		}

		if (email_ref == null) {
			servizioLogImpl.setEmail_ref(StringPool.BLANK);
		}
		else {
			servizioLogImpl.setEmail_ref(email_ref);
		}

		servizioLogImpl.resetOriginalValues();

		return servizioLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_servizio = objectInput.readLong();
		desc_servizio = objectInput.readUTF();
		email_ref = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_servizio);

		if (desc_servizio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc_servizio);
		}

		if (email_ref == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email_ref);
		}
	}

	public long id_servizio;
	public String desc_servizio;
	public String email_ref;
}