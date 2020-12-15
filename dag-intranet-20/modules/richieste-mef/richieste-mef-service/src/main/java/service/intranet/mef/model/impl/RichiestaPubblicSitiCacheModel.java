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

import service.intranet.mef.model.RichiestaPubblicSiti;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RichiestaPubblicSiti in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPubblicSiti
 * @generated
 */
@ProviderType
public class RichiestaPubblicSitiCacheModel implements CacheModel<RichiestaPubblicSiti>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaPubblicSitiCacheModel)) {
			return false;
		}

		RichiestaPubblicSitiCacheModel richiestaPubblicSitiCacheModel = (RichiestaPubblicSitiCacheModel)obj;

		if (id_rich_pubblic == richiestaPubblicSitiCacheModel.id_rich_pubblic) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_rich_pubblic);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id_rich_pubblic=");
		sb.append(id_rich_pubblic);
		sb.append(", dati_richiedente=");
		sb.append(dati_richiedente);
		sb.append(", dati_docum=");
		sb.append(dati_docum);
		sb.append(", titolo=");
		sb.append(titolo);
		sb.append(", sottotitolo=");
		sb.append(sottotitolo);
		sb.append(", novita_abstract=");
		sb.append(novita_abstract);
		sb.append(", note_riferim=");
		sb.append(note_riferim);
		sb.append(", dati_stampa_carta=");
		sb.append(dati_stampa_carta);
		sb.append(", dati_altro=");
		sb.append(dati_altro);
		sb.append(", dati_autorizzaz=");
		sb.append(dati_autorizzaz);
		sb.append(", note_autorizzaz=");
		sb.append(note_autorizzaz);
		sb.append(", lista_allegati=");
		sb.append(lista_allegati);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiestaPubblicSiti toEntityModel() {
		RichiestaPubblicSitiImpl richiestaPubblicSitiImpl = new RichiestaPubblicSitiImpl();

		richiestaPubblicSitiImpl.setId_rich_pubblic(id_rich_pubblic);

		if (dati_richiedente == null) {
			richiestaPubblicSitiImpl.setDati_richiedente(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setDati_richiedente(dati_richiedente);
		}

		if (dati_docum == null) {
			richiestaPubblicSitiImpl.setDati_docum(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setDati_docum(dati_docum);
		}

		if (titolo == null) {
			richiestaPubblicSitiImpl.setTitolo(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setTitolo(titolo);
		}

		if (sottotitolo == null) {
			richiestaPubblicSitiImpl.setSottotitolo(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setSottotitolo(sottotitolo);
		}

		if (novita_abstract == null) {
			richiestaPubblicSitiImpl.setNovita_abstract(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setNovita_abstract(novita_abstract);
		}

		if (note_riferim == null) {
			richiestaPubblicSitiImpl.setNote_riferim(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setNote_riferim(note_riferim);
		}

		if (dati_stampa_carta == null) {
			richiestaPubblicSitiImpl.setDati_stampa_carta(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setDati_stampa_carta(dati_stampa_carta);
		}

		if (dati_altro == null) {
			richiestaPubblicSitiImpl.setDati_altro(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setDati_altro(dati_altro);
		}

		if (dati_autorizzaz == null) {
			richiestaPubblicSitiImpl.setDati_autorizzaz(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setDati_autorizzaz(dati_autorizzaz);
		}

		if (note_autorizzaz == null) {
			richiestaPubblicSitiImpl.setNote_autorizzaz(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setNote_autorizzaz(note_autorizzaz);
		}

		if (lista_allegati == null) {
			richiestaPubblicSitiImpl.setLista_allegati(StringPool.BLANK);
		}
		else {
			richiestaPubblicSitiImpl.setLista_allegati(lista_allegati);
		}

		richiestaPubblicSitiImpl.resetOriginalValues();

		return richiestaPubblicSitiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_rich_pubblic = objectInput.readLong();
		dati_richiedente = objectInput.readUTF();
		dati_docum = objectInput.readUTF();
		titolo = objectInput.readUTF();
		sottotitolo = objectInput.readUTF();
		novita_abstract = objectInput.readUTF();
		note_riferim = objectInput.readUTF();
		dati_stampa_carta = objectInput.readUTF();
		dati_altro = objectInput.readUTF();
		dati_autorizzaz = objectInput.readUTF();
		note_autorizzaz = objectInput.readUTF();
		lista_allegati = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_rich_pubblic);

		if (dati_richiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati_richiedente);
		}

		if (dati_docum == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati_docum);
		}

		if (titolo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(titolo);
		}

		if (sottotitolo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sottotitolo);
		}

		if (novita_abstract == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(novita_abstract);
		}

		if (note_riferim == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note_riferim);
		}

		if (dati_stampa_carta == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati_stampa_carta);
		}

		if (dati_altro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati_altro);
		}

		if (dati_autorizzaz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati_autorizzaz);
		}

		if (note_autorizzaz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note_autorizzaz);
		}

		if (lista_allegati == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lista_allegati);
		}
	}

	public long id_rich_pubblic;
	public String dati_richiedente;
	public String dati_docum;
	public String titolo;
	public String sottotitolo;
	public String novita_abstract;
	public String note_riferim;
	public String dati_stampa_carta;
	public String dati_altro;
	public String dati_autorizzaz;
	public String note_autorizzaz;
	public String lista_allegati;
}