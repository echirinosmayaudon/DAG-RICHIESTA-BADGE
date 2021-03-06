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

package servizio.prenotazione.aule.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Sala service. Represents a row in the &quot;MEFAULE_Sala&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.prenotazione.aule.mef.model.impl.SalaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.prenotazione.aule.mef.model.impl.SalaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Sala
 * @see servizio.prenotazione.aule.mef.model.impl.SalaImpl
 * @see servizio.prenotazione.aule.mef.model.impl.SalaModelImpl
 * @generated
 */
@ProviderType
public interface SalaModel extends BaseModel<Sala> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sala model instance should use the {@link Sala} interface instead.
	 */

	/**
	 * Returns the primary key of this sala.
	 *
	 * @return the primary key of this sala
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sala.
	 *
	 * @param primaryKey the primary key of this sala
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_sala of this sala.
	 *
	 * @return the id_sala of this sala
	 */
	public long getId_sala();

	/**
	 * Sets the id_sala of this sala.
	 *
	 * @param id_sala the id_sala of this sala
	 */
	public void setId_sala(long id_sala);

	/**
	 * Returns the desc_sala of this sala.
	 *
	 * @return the desc_sala of this sala
	 */
	@AutoEscape
	public String getDesc_sala();

	/**
	 * Sets the desc_sala of this sala.
	 *
	 * @param desc_sala the desc_sala of this sala
	 */
	public void setDesc_sala(String desc_sala);

	/**
	 * Returns the indirizzo of this sala.
	 *
	 * @return the indirizzo of this sala
	 */
	@AutoEscape
	public String getIndirizzo();

	/**
	 * Sets the indirizzo of this sala.
	 *
	 * @param indirizzo the indirizzo of this sala
	 */
	public void setIndirizzo(String indirizzo);

	/**
	 * Returns the citta of this sala.
	 *
	 * @return the citta of this sala
	 */
	@AutoEscape
	public String getCitta();

	/**
	 * Sets the citta of this sala.
	 *
	 * @param citta the citta of this sala
	 */
	public void setCitta(String citta);

	/**
	 * Returns the cap of this sala.
	 *
	 * @return the cap of this sala
	 */
	@AutoEscape
	public String getCap();

	/**
	 * Sets the cap of this sala.
	 *
	 * @param cap the cap of this sala
	 */
	public void setCap(String cap);

	/**
	 * Returns the cod_prov of this sala.
	 *
	 * @return the cod_prov of this sala
	 */
	@AutoEscape
	public String getCod_prov();

	/**
	 * Sets the cod_prov of this sala.
	 *
	 * @param cod_prov the cod_prov of this sala
	 */
	public void setCod_prov(String cod_prov);

	/**
	 * Returns the piano of this sala.
	 *
	 * @return the piano of this sala
	 */
	@AutoEscape
	public String getPiano();

	/**
	 * Sets the piano of this sala.
	 *
	 * @param piano the piano of this sala
	 */
	public void setPiano(String piano);

	/**
	 * Returns the stanza of this sala.
	 *
	 * @return the stanza of this sala
	 */
	@AutoEscape
	public String getStanza();

	/**
	 * Sets the stanza of this sala.
	 *
	 * @param stanza the stanza of this sala
	 */
	public void setStanza(String stanza);

	/**
	 * Returns the posti of this sala.
	 *
	 * @return the posti of this sala
	 */
	public int getPosti();

	/**
	 * Sets the posti of this sala.
	 *
	 * @param posti the posti of this sala
	 */
	public void setPosti(int posti);

	/**
	 * Returns the video_conferenza of this sala.
	 *
	 * @return the video_conferenza of this sala
	 */
	public boolean getVideo_conferenza();

	/**
	 * Returns <code>true</code> if this sala is video_conferenza.
	 *
	 * @return <code>true</code> if this sala is video_conferenza; <code>false</code> otherwise
	 */
	public boolean isVideo_conferenza();

	/**
	 * Sets whether this sala is video_conferenza.
	 *
	 * @param video_conferenza the video_conferenza of this sala
	 */
	public void setVideo_conferenza(boolean video_conferenza);

	/**
	 * Returns the proiettore of this sala.
	 *
	 * @return the proiettore of this sala
	 */
	public boolean getProiettore();

	/**
	 * Returns <code>true</code> if this sala is proiettore.
	 *
	 * @return <code>true</code> if this sala is proiettore; <code>false</code> otherwise
	 */
	public boolean isProiettore();

	/**
	 * Sets whether this sala is proiettore.
	 *
	 * @param proiettore the proiettore of this sala
	 */
	public void setProiettore(boolean proiettore);

	/**
	 * Returns the postazione_rete of this sala.
	 *
	 * @return the postazione_rete of this sala
	 */
	public boolean getPostazione_rete();

	/**
	 * Returns <code>true</code> if this sala is postazione_rete.
	 *
	 * @return <code>true</code> if this sala is postazione_rete; <code>false</code> otherwise
	 */
	public boolean isPostazione_rete();

	/**
	 * Sets whether this sala is postazione_rete.
	 *
	 * @param postazione_rete the postazione_rete of this sala
	 */
	public void setPostazione_rete(boolean postazione_rete);

	/**
	 * Returns the autorizzazione of this sala.
	 *
	 * @return the autorizzazione of this sala
	 */
	public boolean getAutorizzazione();

	/**
	 * Returns <code>true</code> if this sala is autorizzazione.
	 *
	 * @return <code>true</code> if this sala is autorizzazione; <code>false</code> otherwise
	 */
	public boolean isAutorizzazione();

	/**
	 * Sets whether this sala is autorizzazione.
	 *
	 * @param autorizzazione the autorizzazione of this sala
	 */
	public void setAutorizzazione(boolean autorizzazione);

	/**
	 * Returns the email_ref of this sala.
	 *
	 * @return the email_ref of this sala
	 */
	@AutoEscape
	public String getEmail_ref();

	/**
	 * Sets the email_ref of this sala.
	 *
	 * @param email_ref the email_ref of this sala
	 */
	public void setEmail_ref(String email_ref);

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
	public int compareTo(servizio.prenotazione.aule.mef.model.Sala sala);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.prenotazione.aule.mef.model.Sala> toCacheModel();

	@Override
	public servizio.prenotazione.aule.mef.model.Sala toEscapedModel();

	@Override
	public servizio.prenotazione.aule.mef.model.Sala toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}