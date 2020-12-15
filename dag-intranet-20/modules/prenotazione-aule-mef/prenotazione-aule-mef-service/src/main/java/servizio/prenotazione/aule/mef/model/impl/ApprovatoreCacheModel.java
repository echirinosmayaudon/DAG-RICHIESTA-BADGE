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

import servizio.prenotazione.aule.mef.model.Approvatore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Approvatore in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Approvatore
 * @generated
 */
@ProviderType
public class ApprovatoreCacheModel implements CacheModel<Approvatore>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApprovatoreCacheModel)) {
			return false;
		}

		ApprovatoreCacheModel approvatoreCacheModel = (ApprovatoreCacheModel)obj;

		if (id_approvatore == approvatoreCacheModel.id_approvatore) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_approvatore);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_approvatore=");
		sb.append(id_approvatore);
		sb.append(", id_sala=");
		sb.append(id_sala);
		sb.append(", email_approvatore=");
		sb.append(email_approvatore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Approvatore toEntityModel() {
		ApprovatoreImpl approvatoreImpl = new ApprovatoreImpl();

		approvatoreImpl.setId_approvatore(id_approvatore);
		approvatoreImpl.setId_sala(id_sala);

		if (email_approvatore == null) {
			approvatoreImpl.setEmail_approvatore(StringPool.BLANK);
		}
		else {
			approvatoreImpl.setEmail_approvatore(email_approvatore);
		}

		approvatoreImpl.resetOriginalValues();

		return approvatoreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_approvatore = objectInput.readLong();

		id_sala = objectInput.readLong();
		email_approvatore = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_approvatore);

		objectOutput.writeLong(id_sala);

		if (email_approvatore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email_approvatore);
		}
	}

	public long id_approvatore;
	public long id_sala;
	public String email_approvatore;
}