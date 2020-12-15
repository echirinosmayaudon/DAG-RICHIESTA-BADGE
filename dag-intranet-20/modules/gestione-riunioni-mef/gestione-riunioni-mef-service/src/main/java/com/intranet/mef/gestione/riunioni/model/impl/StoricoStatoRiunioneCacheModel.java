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

import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;
import com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StoricoStatoRiunione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunione
 * @generated
 */
@ProviderType
public class StoricoStatoRiunioneCacheModel implements CacheModel<StoricoStatoRiunione>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoricoStatoRiunioneCacheModel)) {
			return false;
		}

		StoricoStatoRiunioneCacheModel storicoStatoRiunioneCacheModel = (StoricoStatoRiunioneCacheModel)obj;

		if (storicoStatoRiunionePK.equals(
					storicoStatoRiunioneCacheModel.storicoStatoRiunionePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, storicoStatoRiunionePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_riunione=");
		sb.append(id_riunione);
		sb.append(", id_storico=");
		sb.append(id_storico);
		sb.append(", data=");
		sb.append(data);
		sb.append(", id_stato_riunione=");
		sb.append(id_stato_riunione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StoricoStatoRiunione toEntityModel() {
		StoricoStatoRiunioneImpl storicoStatoRiunioneImpl = new StoricoStatoRiunioneImpl();

		storicoStatoRiunioneImpl.setId_riunione(id_riunione);
		storicoStatoRiunioneImpl.setId_storico(id_storico);

		if (data == Long.MIN_VALUE) {
			storicoStatoRiunioneImpl.setData(null);
		}
		else {
			storicoStatoRiunioneImpl.setData(new Date(data));
		}

		storicoStatoRiunioneImpl.setId_stato_riunione(id_stato_riunione);

		storicoStatoRiunioneImpl.resetOriginalValues();

		return storicoStatoRiunioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_riunione = objectInput.readLong();

		id_storico = objectInput.readLong();
		data = objectInput.readLong();

		id_stato_riunione = objectInput.readLong();

		storicoStatoRiunionePK = new StoricoStatoRiunionePK(id_riunione,
				id_storico);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_riunione);

		objectOutput.writeLong(id_storico);
		objectOutput.writeLong(data);

		objectOutput.writeLong(id_stato_riunione);
	}

	public long id_riunione;
	public long id_storico;
	public long data;
	public long id_stato_riunione;
	public transient StoricoStatoRiunionePK storicoStatoRiunionePK;
}