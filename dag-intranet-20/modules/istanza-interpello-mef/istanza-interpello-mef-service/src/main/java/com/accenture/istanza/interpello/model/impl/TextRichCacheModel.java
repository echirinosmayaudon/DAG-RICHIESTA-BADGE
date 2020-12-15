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

import com.accenture.istanza.interpello.model.TextRich;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TextRich in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TextRich
 * @generated
 */
@ProviderType
public class TextRichCacheModel implements CacheModel<TextRich>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TextRichCacheModel)) {
			return false;
		}

		TextRichCacheModel textRichCacheModel = (TextRichCacheModel)obj;

		if (id_text == textRichCacheModel.id_text) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_text);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_text=");
		sb.append(id_text);
		sb.append(", label_text=");
		sb.append(label_text);
		sb.append(", testo_text=");
		sb.append(testo_text);
		sb.append(", data_in=");
		sb.append(data_in);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TextRich toEntityModel() {
		TextRichImpl textRichImpl = new TextRichImpl();

		textRichImpl.setId_text(id_text);

		if (label_text == null) {
			textRichImpl.setLabel_text("");
		}
		else {
			textRichImpl.setLabel_text(label_text);
		}

		if (testo_text == null) {
			textRichImpl.setTesto_text("");
		}
		else {
			textRichImpl.setTesto_text(testo_text);
		}

		if (data_in == Long.MIN_VALUE) {
			textRichImpl.setData_in(null);
		}
		else {
			textRichImpl.setData_in(new Date(data_in));
		}

		textRichImpl.resetOriginalValues();

		return textRichImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_text = objectInput.readLong();
		label_text = objectInput.readUTF();
		testo_text = objectInput.readUTF();
		data_in = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_text);

		if (label_text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(label_text);
		}

		if (testo_text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testo_text);
		}

		objectOutput.writeLong(data_in);
	}

	public long id_text;
	public String label_text;
	public String testo_text;
	public long data_in;
}