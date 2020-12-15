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

package service.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import service.intranet.mef.model.StatoRichBeneInv;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatoRichBeneInv in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichBeneInv
 * @generated
 */
@ProviderType
public class StatoRichBeneInvCacheModel implements CacheModel<StatoRichBeneInv>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoRichBeneInvCacheModel)) {
			return false;
		}

		StatoRichBeneInvCacheModel statoRichBeneInvCacheModel = (StatoRichBeneInvCacheModel)obj;

		if (id == statoRichBeneInvCacheModel.id) {
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
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", stato=");
		sb.append(stato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatoRichBeneInv toEntityModel() {
		StatoRichBeneInvImpl statoRichBeneInvImpl = new StatoRichBeneInvImpl();

		statoRichBeneInvImpl.setId(id);

		if (stato == null) {
			statoRichBeneInvImpl.setStato(StringPool.BLANK);
		}
		else {
			statoRichBeneInvImpl.setStato(stato);
		}

		statoRichBeneInvImpl.resetOriginalValues();

		return statoRichBeneInvImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		stato = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (stato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stato);
		}
	}

	public long id;
	public String stato;
}