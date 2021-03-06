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

package service.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RichiestaBeneInv service. Represents a row in the &quot;MFORM_RichiestaBeneInv&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link service.intranet.mef.model.impl.RichiestaBeneInvModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link service.intranet.mef.model.impl.RichiestaBeneInvImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInv
 * @see service.intranet.mef.model.impl.RichiestaBeneInvImpl
 * @see service.intranet.mef.model.impl.RichiestaBeneInvModelImpl
 * @generated
 */
@ProviderType
public interface RichiestaBeneInvModel extends BaseModel<RichiestaBeneInv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a richiesta bene inv model instance should use the {@link RichiestaBeneInv} interface instead.
	 */

	/**
	 * Returns the primary key of this richiesta bene inv.
	 *
	 * @return the primary key of this richiesta bene inv
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this richiesta bene inv.
	 *
	 * @param primaryKey the primary key of this richiesta bene inv
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_richiesta of this richiesta bene inv.
	 *
	 * @return the id_richiesta of this richiesta bene inv
	 */
	public long getId_richiesta();

	/**
	 * Sets the id_richiesta of this richiesta bene inv.
	 *
	 * @param id_richiesta the id_richiesta of this richiesta bene inv
	 */
	public void setId_richiesta(long id_richiesta);

	/**
	 * Returns the utente of this richiesta bene inv.
	 *
	 * @return the utente of this richiesta bene inv
	 */
	@AutoEscape
	public String getUtente();

	/**
	 * Sets the utente of this richiesta bene inv.
	 *
	 * @param utente the utente of this richiesta bene inv
	 */
	public void setUtente(String utente);

	/**
	 * Returns the nome_rich of this richiesta bene inv.
	 *
	 * @return the nome_rich of this richiesta bene inv
	 */
	@AutoEscape
	public String getNome_rich();

	/**
	 * Sets the nome_rich of this richiesta bene inv.
	 *
	 * @param nome_rich the nome_rich of this richiesta bene inv
	 */
	public void setNome_rich(String nome_rich);

	/**
	 * Returns the cogn_rich of this richiesta bene inv.
	 *
	 * @return the cogn_rich of this richiesta bene inv
	 */
	@AutoEscape
	public String getCogn_rich();

	/**
	 * Sets the cogn_rich of this richiesta bene inv.
	 *
	 * @param cogn_rich the cogn_rich of this richiesta bene inv
	 */
	public void setCogn_rich(String cogn_rich);

	/**
	 * Returns the dip_dir of this richiesta bene inv.
	 *
	 * @return the dip_dir of this richiesta bene inv
	 */
	@AutoEscape
	public String getDip_dir();

	/**
	 * Sets the dip_dir of this richiesta bene inv.
	 *
	 * @param dip_dir the dip_dir of this richiesta bene inv
	 */
	public void setDip_dir(String dip_dir);

	/**
	 * Returns the dati_rich of this richiesta bene inv.
	 *
	 * @return the dati_rich of this richiesta bene inv
	 */
	@AutoEscape
	public String getDati_rich();

	/**
	 * Sets the dati_rich of this richiesta bene inv.
	 *
	 * @param dati_rich the dati_rich of this richiesta bene inv
	 */
	public void setDati_rich(String dati_rich);

	/**
	 * Returns the oggetto of this richiesta bene inv.
	 *
	 * @return the oggetto of this richiesta bene inv
	 */
	@AutoEscape
	public String getOggetto();

	/**
	 * Sets the oggetto of this richiesta bene inv.
	 *
	 * @param oggetto the oggetto of this richiesta bene inv
	 */
	public void setOggetto(String oggetto);

	/**
	 * Returns the data of this richiesta bene inv.
	 *
	 * @return the data of this richiesta bene inv
	 */
	public Date getData();

	/**
	 * Sets the data of this richiesta bene inv.
	 *
	 * @param data the data of this richiesta bene inv
	 */
	public void setData(Date data);

	/**
	 * Returns the beneficiario of this richiesta bene inv.
	 *
	 * @return the beneficiario of this richiesta bene inv
	 */
	@AutoEscape
	public String getBeneficiario();

	/**
	 * Sets the beneficiario of this richiesta bene inv.
	 *
	 * @param beneficiario the beneficiario of this richiesta bene inv
	 */
	public void setBeneficiario(String beneficiario);

	/**
	 * Returns the destinazione of this richiesta bene inv.
	 *
	 * @return the destinazione of this richiesta bene inv
	 */
	@AutoEscape
	public String getDestinazione();

	/**
	 * Sets the destinazione of this richiesta bene inv.
	 *
	 * @param destinazione the destinazione of this richiesta bene inv
	 */
	public void setDestinazione(String destinazione);

	/**
	 * Returns the id_stato of this richiesta bene inv.
	 *
	 * @return the id_stato of this richiesta bene inv
	 */
	public long getId_stato();

	/**
	 * Sets the id_stato of this richiesta bene inv.
	 *
	 * @param id_stato the id_stato of this richiesta bene inv
	 */
	public void setId_stato(long id_stato);

	/**
	 * Returns the note_consegn of this richiesta bene inv.
	 *
	 * @return the note_consegn of this richiesta bene inv
	 */
	@AutoEscape
	public String getNote_consegn();

	/**
	 * Sets the note_consegn of this richiesta bene inv.
	 *
	 * @param note_consegn the note_consegn of this richiesta bene inv
	 */
	public void setNote_consegn(String note_consegn);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		service.intranet.mef.model.RichiestaBeneInv richiestaBeneInv);

	@Override
	public int hashCode();

	@Override
	public CacheModel<service.intranet.mef.model.RichiestaBeneInv> toCacheModel();

	@Override
	public service.intranet.mef.model.RichiestaBeneInv toEscapedModel();

	@Override
	public service.intranet.mef.model.RichiestaBeneInv toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}