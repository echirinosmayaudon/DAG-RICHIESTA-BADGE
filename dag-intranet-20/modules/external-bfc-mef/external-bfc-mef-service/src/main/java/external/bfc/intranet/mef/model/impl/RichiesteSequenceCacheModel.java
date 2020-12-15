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

package external.bfc.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import external.bfc.intranet.mef.model.RichiesteSequence;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RichiesteSequence in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequence
 * @generated
 */
@ProviderType
public class RichiesteSequenceCacheModel implements CacheModel<RichiesteSequence>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteSequenceCacheModel)) {
			return false;
		}

		RichiesteSequenceCacheModel richiesteSequenceCacheModel = (RichiesteSequenceCacheModel)obj;

		if (idSeq == richiesteSequenceCacheModel.idSeq) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idSeq);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{idSeq=");
		sb.append(idSeq);

		return sb.toString();
	}

	@Override
	public RichiesteSequence toEntityModel() {
		RichiesteSequenceImpl richiesteSequenceImpl = new RichiesteSequenceImpl();

		richiesteSequenceImpl.setIdSeq(idSeq);

		richiesteSequenceImpl.resetOriginalValues();

		return richiesteSequenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idSeq = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idSeq);
	}

	public long idSeq;
}