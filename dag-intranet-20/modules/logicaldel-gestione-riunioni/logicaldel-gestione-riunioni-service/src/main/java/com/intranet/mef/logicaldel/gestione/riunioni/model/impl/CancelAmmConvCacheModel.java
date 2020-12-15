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

package com.intranet.mef.logicaldel.gestione.riunioni.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CancelAmmConv in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConv
 * @generated
 */
@ProviderType
public class CancelAmmConvCacheModel implements CacheModel<CancelAmmConv>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CancelAmmConvCacheModel)) {
			return false;
		}

		CancelAmmConvCacheModel cancelAmmConvCacheModel = (CancelAmmConvCacheModel)obj;

		if (id_amministrazione_convocante == cancelAmmConvCacheModel.id_amministrazione_convocante) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_amministrazione_convocante);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_amministrazione_convocante=");
		sb.append(id_amministrazione_convocante);
		sb.append(", cancellato=");
		sb.append(cancellato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CancelAmmConv toEntityModel() {
		CancelAmmConvImpl cancelAmmConvImpl = new CancelAmmConvImpl();

		cancelAmmConvImpl.setId_amministrazione_convocante(id_amministrazione_convocante);
		cancelAmmConvImpl.setCancellato(cancellato);

		cancelAmmConvImpl.resetOriginalValues();

		return cancelAmmConvImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_amministrazione_convocante = objectInput.readLong();

		cancellato = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_amministrazione_convocante);

		objectOutput.writeBoolean(cancellato);
	}

	public long id_amministrazione_convocante;
	public boolean cancellato;
}