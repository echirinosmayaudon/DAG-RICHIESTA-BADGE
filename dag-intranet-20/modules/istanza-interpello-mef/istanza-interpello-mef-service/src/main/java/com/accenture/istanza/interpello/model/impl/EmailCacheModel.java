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

package com.accenture.istanza.interpello.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.istanza.interpello.model.Email;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Email in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Email
 * @generated
 */
@ProviderType
public class EmailCacheModel implements CacheModel<Email>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailCacheModel)) {
			return false;
		}

		EmailCacheModel emailCacheModel = (EmailCacheModel)obj;

		if (id == emailCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idStruttura=");
		sb.append(idStruttura);
		sb.append(", mailCC=");
		sb.append(mailCC);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Email toEntityModel() {
		EmailImpl emailImpl = new EmailImpl();

		emailImpl.setId(id);
		emailImpl.setIdStruttura(idStruttura);

		if (mailCC == null) {
			emailImpl.setMailCC("");
		}
		else {
			emailImpl.setMailCC(mailCC);
		}

		emailImpl.resetOriginalValues();

		return emailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		idStruttura = objectInput.readLong();
		mailCC = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(idStruttura);

		if (mailCC == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mailCC);
		}
	}

	public long id;
	public long idStruttura;
	public String mailCC;
}