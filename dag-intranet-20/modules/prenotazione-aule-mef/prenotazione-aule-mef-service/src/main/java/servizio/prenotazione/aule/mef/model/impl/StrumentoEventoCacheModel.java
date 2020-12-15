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

import servizio.prenotazione.aule.mef.model.StrumentoEvento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StrumentoEvento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoEvento
 * @generated
 */
@ProviderType
public class StrumentoEventoCacheModel implements CacheModel<StrumentoEvento>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumentoEventoCacheModel)) {
			return false;
		}

		StrumentoEventoCacheModel strumentoEventoCacheModel = (StrumentoEventoCacheModel)obj;

		if (id_strumento == strumentoEventoCacheModel.id_strumento) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_strumento);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_strumento=");
		sb.append(id_strumento);
		sb.append(", desc_strumento=");
		sb.append(desc_strumento);
		sb.append(", email_ref=");
		sb.append(email_ref);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StrumentoEvento toEntityModel() {
		StrumentoEventoImpl strumentoEventoImpl = new StrumentoEventoImpl();

		strumentoEventoImpl.setId_strumento(id_strumento);

		if (desc_strumento == null) {
			strumentoEventoImpl.setDesc_strumento(StringPool.BLANK);
		}
		else {
			strumentoEventoImpl.setDesc_strumento(desc_strumento);
		}

		if (email_ref == null) {
			strumentoEventoImpl.setEmail_ref(StringPool.BLANK);
		}
		else {
			strumentoEventoImpl.setEmail_ref(email_ref);
		}

		strumentoEventoImpl.resetOriginalValues();

		return strumentoEventoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_strumento = objectInput.readLong();
		desc_strumento = objectInput.readUTF();
		email_ref = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_strumento);

		if (desc_strumento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc_strumento);
		}

		if (email_ref == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email_ref);
		}
	}

	public long id_strumento;
	public String desc_strumento;
	public String email_ref;
}