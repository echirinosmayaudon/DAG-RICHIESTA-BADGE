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

import servizio.prenotazione.aule.mef.model.StrumentoTec;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StrumentoTec in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTec
 * @generated
 */
@ProviderType
public class StrumentoTecCacheModel implements CacheModel<StrumentoTec>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumentoTecCacheModel)) {
			return false;
		}

		StrumentoTecCacheModel strumentoTecCacheModel = (StrumentoTecCacheModel)obj;

		if (id_strumento == strumentoTecCacheModel.id_strumento) {
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
	public StrumentoTec toEntityModel() {
		StrumentoTecImpl strumentoTecImpl = new StrumentoTecImpl();

		strumentoTecImpl.setId_strumento(id_strumento);

		if (desc_strumento == null) {
			strumentoTecImpl.setDesc_strumento(StringPool.BLANK);
		}
		else {
			strumentoTecImpl.setDesc_strumento(desc_strumento);
		}

		if (email_ref == null) {
			strumentoTecImpl.setEmail_ref(StringPool.BLANK);
		}
		else {
			strumentoTecImpl.setEmail_ref(email_ref);
		}

		strumentoTecImpl.resetOriginalValues();

		return strumentoTecImpl;
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