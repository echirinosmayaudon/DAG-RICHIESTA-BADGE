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

import service.intranet.mef.model.RichiesteUtenza;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichiesteUtenza in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteUtenza
 * @generated
 */
@ProviderType
public class RichiesteUtenzaCacheModel implements CacheModel<RichiesteUtenza>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteUtenzaCacheModel)) {
			return false;
		}

		RichiesteUtenzaCacheModel richiesteUtenzaCacheModel = (RichiesteUtenzaCacheModel)obj;

		if (id_richieste_utenza == richiesteUtenzaCacheModel.id_richieste_utenza) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_richieste_utenza);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id_richieste_utenza=");
		sb.append(id_richieste_utenza);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", destinatario=");
		sb.append(destinatario);
		sb.append(", dettaglio=");
		sb.append(dettaglio);
		sb.append(", data_richiesta=");
		sb.append(data_richiesta);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiesteUtenza toEntityModel() {
		RichiesteUtenzaImpl richiesteUtenzaImpl = new RichiesteUtenzaImpl();

		richiesteUtenzaImpl.setId_richieste_utenza(id_richieste_utenza);

		if (utente == null) {
			richiesteUtenzaImpl.setUtente(StringPool.BLANK);
		}
		else {
			richiesteUtenzaImpl.setUtente(utente);
		}

		if (destinatario == null) {
			richiesteUtenzaImpl.setDestinatario(StringPool.BLANK);
		}
		else {
			richiesteUtenzaImpl.setDestinatario(destinatario);
		}

		if (dettaglio == null) {
			richiesteUtenzaImpl.setDettaglio(StringPool.BLANK);
		}
		else {
			richiesteUtenzaImpl.setDettaglio(dettaglio);
		}

		if (data_richiesta == Long.MIN_VALUE) {
			richiesteUtenzaImpl.setData_richiesta(null);
		}
		else {
			richiesteUtenzaImpl.setData_richiesta(new Date(data_richiesta));
		}

		richiesteUtenzaImpl.resetOriginalValues();

		return richiesteUtenzaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_richieste_utenza = objectInput.readLong();
		utente = objectInput.readUTF();
		destinatario = objectInput.readUTF();
		dettaglio = objectInput.readUTF();
		data_richiesta = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_richieste_utenza);

		if (utente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente);
		}

		if (destinatario == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(destinatario);
		}

		if (dettaglio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dettaglio);
		}

		objectOutput.writeLong(data_richiesta);
	}

	public long id_richieste_utenza;
	public String utente;
	public String destinatario;
	public String dettaglio;
	public long data_richiesta;
}