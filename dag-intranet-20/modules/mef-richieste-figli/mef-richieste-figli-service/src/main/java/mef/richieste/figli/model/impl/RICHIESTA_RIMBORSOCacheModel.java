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

package mef.richieste.figli.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import mef.richieste.figli.model.RICHIESTA_RIMBORSO;

/**
 * The cache model class for representing RICHIESTA_RIMBORSO in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RICHIESTA_RIMBORSOCacheModel
	implements CacheModel<RICHIESTA_RIMBORSO>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RICHIESTA_RIMBORSOCacheModel)) {
			return false;
		}

		RICHIESTA_RIMBORSOCacheModel richiesta_rimborsoCacheModel =
			(RICHIESTA_RIMBORSOCacheModel)obj;

		if (Id == richiesta_rimborsoCacheModel.Id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", Nome_Richiedente=");
		sb.append(Nome_Richiedente);
		sb.append(", Cognome_Richiedente=");
		sb.append(Cognome_Richiedente);
		sb.append(", Codice_Fiscale_Richiedente=");
		sb.append(Codice_Fiscale_Richiedente);
		sb.append(", Utente_Inserimento=");
		sb.append(Utente_Inserimento);
		sb.append(", Data_Inserimento=");
		sb.append(Data_Inserimento);
		sb.append(", Iban=");
		sb.append(Iban);
		sb.append(", Importo=");
		sb.append(Importo);
		sb.append(", Figlio_Nome=");
		sb.append(Figlio_Nome);
		sb.append(", Figlio_Cognome=");
		sb.append(Figlio_Cognome);
		sb.append(", Figlio_Data_Nascita=");
		sb.append(Figlio_Data_Nascita);
		sb.append(", Figlio_Luogo_Nascita=");
		sb.append(Figlio_Luogo_Nascita);
		sb.append(", Figlio_Codice_Fiscale=");
		sb.append(Figlio_Codice_Fiscale);
		sb.append(", Note=");
		sb.append(Note);
		sb.append(", Flag_Inviato=");
		sb.append(Flag_Inviato);
		sb.append(", Telefono=");
		sb.append(Telefono);
		sb.append(", Allegato_UUID=");
		sb.append(Allegato_UUID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RICHIESTA_RIMBORSO toEntityModel() {
		RICHIESTA_RIMBORSOImpl richiesta_rimborsoImpl =
			new RICHIESTA_RIMBORSOImpl();

		richiesta_rimborsoImpl.setId(Id);

		if (Nome_Richiedente == null) {
			richiesta_rimborsoImpl.setNome_Richiedente("");
		}
		else {
			richiesta_rimborsoImpl.setNome_Richiedente(Nome_Richiedente);
		}

		if (Cognome_Richiedente == null) {
			richiesta_rimborsoImpl.setCognome_Richiedente("");
		}
		else {
			richiesta_rimborsoImpl.setCognome_Richiedente(Cognome_Richiedente);
		}

		if (Codice_Fiscale_Richiedente == null) {
			richiesta_rimborsoImpl.setCodice_Fiscale_Richiedente("");
		}
		else {
			richiesta_rimborsoImpl.setCodice_Fiscale_Richiedente(
				Codice_Fiscale_Richiedente);
		}

		if (Utente_Inserimento == null) {
			richiesta_rimborsoImpl.setUtente_Inserimento("");
		}
		else {
			richiesta_rimborsoImpl.setUtente_Inserimento(Utente_Inserimento);
		}

		if (Data_Inserimento == null) {
			richiesta_rimborsoImpl.setData_Inserimento("");
		}
		else {
			richiesta_rimborsoImpl.setData_Inserimento(Data_Inserimento);
		}

		if (Iban == null) {
			richiesta_rimborsoImpl.setIban("");
		}
		else {
			richiesta_rimborsoImpl.setIban(Iban);
		}

		if (Importo == null) {
			richiesta_rimborsoImpl.setImporto("");
		}
		else {
			richiesta_rimborsoImpl.setImporto(Importo);
		}

		if (Figlio_Nome == null) {
			richiesta_rimborsoImpl.setFiglio_Nome("");
		}
		else {
			richiesta_rimborsoImpl.setFiglio_Nome(Figlio_Nome);
		}

		if (Figlio_Cognome == null) {
			richiesta_rimborsoImpl.setFiglio_Cognome("");
		}
		else {
			richiesta_rimborsoImpl.setFiglio_Cognome(Figlio_Cognome);
		}

		if (Figlio_Data_Nascita == null) {
			richiesta_rimborsoImpl.setFiglio_Data_Nascita("");
		}
		else {
			richiesta_rimborsoImpl.setFiglio_Data_Nascita(Figlio_Data_Nascita);
		}

		if (Figlio_Luogo_Nascita == null) {
			richiesta_rimborsoImpl.setFiglio_Luogo_Nascita("");
		}
		else {
			richiesta_rimborsoImpl.setFiglio_Luogo_Nascita(
				Figlio_Luogo_Nascita);
		}

		if (Figlio_Codice_Fiscale == null) {
			richiesta_rimborsoImpl.setFiglio_Codice_Fiscale("");
		}
		else {
			richiesta_rimborsoImpl.setFiglio_Codice_Fiscale(
				Figlio_Codice_Fiscale);
		}

		if (Note == null) {
			richiesta_rimborsoImpl.setNote("");
		}
		else {
			richiesta_rimborsoImpl.setNote(Note);
		}

		richiesta_rimborsoImpl.setFlag_Inviato(Flag_Inviato);

		if (Telefono == null) {
			richiesta_rimborsoImpl.setTelefono("");
		}
		else {
			richiesta_rimborsoImpl.setTelefono(Telefono);
		}

		if (Allegato_UUID == null) {
			richiesta_rimborsoImpl.setAllegato_UUID("");
		}
		else {
			richiesta_rimborsoImpl.setAllegato_UUID(Allegato_UUID);
		}

		richiesta_rimborsoImpl.resetOriginalValues();

		return richiesta_rimborsoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readLong();
		Nome_Richiedente = objectInput.readUTF();
		Cognome_Richiedente = objectInput.readUTF();
		Codice_Fiscale_Richiedente = objectInput.readUTF();
		Utente_Inserimento = objectInput.readUTF();
		Data_Inserimento = objectInput.readUTF();
		Iban = objectInput.readUTF();
		Importo = objectInput.readUTF();
		Figlio_Nome = objectInput.readUTF();
		Figlio_Cognome = objectInput.readUTF();
		Figlio_Data_Nascita = objectInput.readUTF();
		Figlio_Luogo_Nascita = objectInput.readUTF();
		Figlio_Codice_Fiscale = objectInput.readUTF();
		Note = objectInput.readUTF();

		Flag_Inviato = objectInput.readBoolean();
		Telefono = objectInput.readUTF();
		Allegato_UUID = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(Id);

		if (Nome_Richiedente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Nome_Richiedente);
		}

		if (Cognome_Richiedente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Cognome_Richiedente);
		}

		if (Codice_Fiscale_Richiedente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Codice_Fiscale_Richiedente);
		}

		if (Utente_Inserimento == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Utente_Inserimento);
		}

		if (Data_Inserimento == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Data_Inserimento);
		}

		if (Iban == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Iban);
		}

		if (Importo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Importo);
		}

		if (Figlio_Nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Figlio_Nome);
		}

		if (Figlio_Cognome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Figlio_Cognome);
		}

		if (Figlio_Data_Nascita == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Figlio_Data_Nascita);
		}

		if (Figlio_Luogo_Nascita == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Figlio_Luogo_Nascita);
		}

		if (Figlio_Codice_Fiscale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Figlio_Codice_Fiscale);
		}

		if (Note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Note);
		}

		objectOutput.writeBoolean(Flag_Inviato);

		if (Telefono == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Telefono);
		}

		if (Allegato_UUID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Allegato_UUID);
		}
	}

	public long Id;
	public String Nome_Richiedente;
	public String Cognome_Richiedente;
	public String Codice_Fiscale_Richiedente;
	public String Utente_Inserimento;
	public String Data_Inserimento;
	public String Iban;
	public String Importo;
	public String Figlio_Nome;
	public String Figlio_Cognome;
	public String Figlio_Data_Nascita;
	public String Figlio_Luogo_Nascita;
	public String Figlio_Codice_Fiscale;
	public String Note;
	public boolean Flag_Inviato;
	public String Telefono;
	public String Allegato_UUID;

}