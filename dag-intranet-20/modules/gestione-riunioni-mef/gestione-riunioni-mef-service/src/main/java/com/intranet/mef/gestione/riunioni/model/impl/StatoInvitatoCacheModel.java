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

import com.intranet.mef.gestione.riunioni.model.StatoInvitato;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatoInvitato in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StatoInvitato
 * @generated
 */
@ProviderType
public class StatoInvitatoCacheModel implements CacheModel<StatoInvitato>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoInvitatoCacheModel)) {
			return false;
		}

		StatoInvitatoCacheModel statoInvitatoCacheModel = (StatoInvitatoCacheModel)obj;

		if (id_stato_invitato == statoInvitatoCacheModel.id_stato_invitato) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_stato_invitato);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_stato_invitato=");
		sb.append(id_stato_invitato);
		sb.append(", nome_stato=");
		sb.append(nome_stato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatoInvitato toEntityModel() {
		StatoInvitatoImpl statoInvitatoImpl = new StatoInvitatoImpl();

		statoInvitatoImpl.setId_stato_invitato(id_stato_invitato);

		if (nome_stato == null) {
			statoInvitatoImpl.setNome_stato(StringPool.BLANK);
		}
		else {
			statoInvitatoImpl.setNome_stato(nome_stato);
		}

		statoInvitatoImpl.resetOriginalValues();

		return statoInvitatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_stato_invitato = objectInput.readLong();
		nome_stato = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_stato_invitato);

		if (nome_stato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome_stato);
		}
	}

	public long id_stato_invitato;
	public String nome_stato;
}