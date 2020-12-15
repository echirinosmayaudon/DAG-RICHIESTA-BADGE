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

import service.intranet.mef.model.RichiestaBeneInv;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichiestaBeneInv in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInv
 * @generated
 */
@ProviderType
public class RichiestaBeneInvCacheModel implements CacheModel<RichiestaBeneInv>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaBeneInvCacheModel)) {
			return false;
		}

		RichiestaBeneInvCacheModel richiestaBeneInvCacheModel = (RichiestaBeneInvCacheModel)obj;

		if (id_richiesta == richiestaBeneInvCacheModel.id_richiesta) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_richiesta);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id_richiesta=");
		sb.append(id_richiesta);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", nome_rich=");
		sb.append(nome_rich);
		sb.append(", cogn_rich=");
		sb.append(cogn_rich);
		sb.append(", dip_dir=");
		sb.append(dip_dir);
		sb.append(", dati_rich=");
		sb.append(dati_rich);
		sb.append(", oggetto=");
		sb.append(oggetto);
		sb.append(", data=");
		sb.append(data);
		sb.append(", beneficiario=");
		sb.append(beneficiario);
		sb.append(", destinazione=");
		sb.append(destinazione);
		sb.append(", id_stato=");
		sb.append(id_stato);
		sb.append(", note_consegn=");
		sb.append(note_consegn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiestaBeneInv toEntityModel() {
		RichiestaBeneInvImpl richiestaBeneInvImpl = new RichiestaBeneInvImpl();

		richiestaBeneInvImpl.setId_richiesta(id_richiesta);

		if (utente == null) {
			richiestaBeneInvImpl.setUtente(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setUtente(utente);
		}

		if (nome_rich == null) {
			richiestaBeneInvImpl.setNome_rich(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setNome_rich(nome_rich);
		}

		if (cogn_rich == null) {
			richiestaBeneInvImpl.setCogn_rich(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setCogn_rich(cogn_rich);
		}

		if (dip_dir == null) {
			richiestaBeneInvImpl.setDip_dir(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setDip_dir(dip_dir);
		}

		if (dati_rich == null) {
			richiestaBeneInvImpl.setDati_rich(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setDati_rich(dati_rich);
		}

		if (oggetto == null) {
			richiestaBeneInvImpl.setOggetto(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setOggetto(oggetto);
		}

		if (data == Long.MIN_VALUE) {
			richiestaBeneInvImpl.setData(null);
		}
		else {
			richiestaBeneInvImpl.setData(new Date(data));
		}

		if (beneficiario == null) {
			richiestaBeneInvImpl.setBeneficiario(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setBeneficiario(beneficiario);
		}

		if (destinazione == null) {
			richiestaBeneInvImpl.setDestinazione(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setDestinazione(destinazione);
		}

		richiestaBeneInvImpl.setId_stato(id_stato);

		if (note_consegn == null) {
			richiestaBeneInvImpl.setNote_consegn(StringPool.BLANK);
		}
		else {
			richiestaBeneInvImpl.setNote_consegn(note_consegn);
		}

		richiestaBeneInvImpl.resetOriginalValues();

		return richiestaBeneInvImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_richiesta = objectInput.readLong();
		utente = objectInput.readUTF();
		nome_rich = objectInput.readUTF();
		cogn_rich = objectInput.readUTF();
		dip_dir = objectInput.readUTF();
		dati_rich = objectInput.readUTF();
		oggetto = objectInput.readUTF();
		data = objectInput.readLong();
		beneficiario = objectInput.readUTF();
		destinazione = objectInput.readUTF();

		id_stato = objectInput.readLong();
		note_consegn = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_richiesta);

		if (utente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente);
		}

		if (nome_rich == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome_rich);
		}

		if (cogn_rich == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cogn_rich);
		}

		if (dip_dir == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dip_dir);
		}

		if (dati_rich == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati_rich);
		}

		if (oggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(oggetto);
		}

		objectOutput.writeLong(data);

		if (beneficiario == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(beneficiario);
		}

		if (destinazione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(destinazione);
		}

		objectOutput.writeLong(id_stato);

		if (note_consegn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note_consegn);
		}
	}

	public long id_richiesta;
	public String utente;
	public String nome_rich;
	public String cogn_rich;
	public String dip_dir;
	public String dati_rich;
	public String oggetto;
	public long data;
	public String beneficiario;
	public String destinazione;
	public long id_stato;
	public String note_consegn;
}