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

import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InvitatiRiunione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunione
 * @generated
 */
@ProviderType
public class InvitatiRiunioneCacheModel implements CacheModel<InvitatiRiunione>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InvitatiRiunioneCacheModel)) {
			return false;
		}

		InvitatiRiunioneCacheModel invitatiRiunioneCacheModel = (InvitatiRiunioneCacheModel)obj;

		if (invitatiRiunionePK.equals(
					invitatiRiunioneCacheModel.invitatiRiunionePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, invitatiRiunionePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id_segreteria=");
		sb.append(id_segreteria);
		sb.append(", note=");
		sb.append(note);
		sb.append(", partecipanti=");
		sb.append(partecipanti);
		sb.append(", id_stato_invitato=");
		sb.append(id_stato_invitato);
		sb.append(", id_riunione=");
		sb.append(id_riunione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InvitatiRiunione toEntityModel() {
		InvitatiRiunioneImpl invitatiRiunioneImpl = new InvitatiRiunioneImpl();

		invitatiRiunioneImpl.setId_segreteria(id_segreteria);

		if (note == null) {
			invitatiRiunioneImpl.setNote(StringPool.BLANK);
		}
		else {
			invitatiRiunioneImpl.setNote(note);
		}

		if (partecipanti == null) {
			invitatiRiunioneImpl.setPartecipanti(StringPool.BLANK);
		}
		else {
			invitatiRiunioneImpl.setPartecipanti(partecipanti);
		}

		invitatiRiunioneImpl.setId_stato_invitato(id_stato_invitato);
		invitatiRiunioneImpl.setId_riunione(id_riunione);

		invitatiRiunioneImpl.resetOriginalValues();

		return invitatiRiunioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_segreteria = objectInput.readLong();
		note = objectInput.readUTF();
		partecipanti = objectInput.readUTF();

		id_stato_invitato = objectInput.readLong();

		id_riunione = objectInput.readLong();

		invitatiRiunionePK = new InvitatiRiunionePK(id_segreteria, id_riunione);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_segreteria);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (partecipanti == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(partecipanti);
		}

		objectOutput.writeLong(id_stato_invitato);

		objectOutput.writeLong(id_riunione);
	}

	public long id_segreteria;
	public String note;
	public String partecipanti;
	public long id_stato_invitato;
	public long id_riunione;
	public transient InvitatiRiunionePK invitatiRiunionePK;
}