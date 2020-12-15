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

package com.intranet.mef.gestione.riunioni.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.StatoRiunione;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatoRiunione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StatoRiunione
 * @generated
 */
@ProviderType
public class StatoRiunioneCacheModel implements CacheModel<StatoRiunione>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoRiunioneCacheModel)) {
			return false;
		}

		StatoRiunioneCacheModel statoRiunioneCacheModel = (StatoRiunioneCacheModel)obj;

		if (id_stato_riunione == statoRiunioneCacheModel.id_stato_riunione) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_stato_riunione);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_stato_riunione=");
		sb.append(id_stato_riunione);
		sb.append(", label=");
		sb.append(label);
		sb.append(", next_stato=");
		sb.append(next_stato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatoRiunione toEntityModel() {
		StatoRiunioneImpl statoRiunioneImpl = new StatoRiunioneImpl();

		statoRiunioneImpl.setId_stato_riunione(id_stato_riunione);

		if (label == null) {
			statoRiunioneImpl.setLabel(StringPool.BLANK);
		}
		else {
			statoRiunioneImpl.setLabel(label);
		}

		if (next_stato == null) {
			statoRiunioneImpl.setNext_stato(StringPool.BLANK);
		}
		else {
			statoRiunioneImpl.setNext_stato(next_stato);
		}

		statoRiunioneImpl.resetOriginalValues();

		return statoRiunioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_stato_riunione = objectInput.readLong();
		label = objectInput.readUTF();
		next_stato = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_stato_riunione);

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (next_stato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(next_stato);
		}
	}

	public long id_stato_riunione;
	public String label;
	public String next_stato;
}