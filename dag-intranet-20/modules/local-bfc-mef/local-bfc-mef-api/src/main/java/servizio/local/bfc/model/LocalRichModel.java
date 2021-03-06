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

package servizio.local.bfc.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LocalRich service. Represents a row in the &quot;LOCBFC_LocalRich&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.local.bfc.model.impl.LocalRichModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.local.bfc.model.impl.LocalRichImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRich
 * @see servizio.local.bfc.model.impl.LocalRichImpl
 * @see servizio.local.bfc.model.impl.LocalRichModelImpl
 * @generated
 */
@ProviderType
public interface LocalRichModel extends BaseModel<LocalRich> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a local rich model instance should use the {@link LocalRich} interface instead.
	 */

	/**
	 * Returns the primary key of this local rich.
	 *
	 * @return the primary key of this local rich
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this local rich.
	 *
	 * @param primaryKey the primary key of this local rich
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id stato attuale of this local rich.
	 *
	 * @return the id stato attuale of this local rich
	 */
	public long getIdStatoAttuale();

	/**
	 * Sets the id stato attuale of this local rich.
	 *
	 * @param idStatoAttuale the id stato attuale of this local rich
	 */
	public void setIdStatoAttuale(long idStatoAttuale);

	/**
	 * Returns the ID of this local rich.
	 *
	 * @return the ID of this local rich
	 */
	public long getId();

	/**
	 * Sets the ID of this local rich.
	 *
	 * @param id the ID of this local rich
	 */
	public void setId(long id);

	/**
	 * Returns the id_richiesta of this local rich.
	 *
	 * @return the id_richiesta of this local rich
	 */
	public long getId_richiesta();

	/**
	 * Sets the id_richiesta of this local rich.
	 *
	 * @param id_richiesta the id_richiesta of this local rich
	 */
	public void setId_richiesta(long id_richiesta);

	/**
	 * Returns the data richiesta of this local rich.
	 *
	 * @return the data richiesta of this local rich
	 */
	public Date getDataRichiesta();

	/**
	 * Sets the data richiesta of this local rich.
	 *
	 * @param dataRichiesta the data richiesta of this local rich
	 */
	public void setDataRichiesta(Date dataRichiesta);

	/**
	 * Returns the id periodicita of this local rich.
	 *
	 * @return the id periodicita of this local rich
	 */
	public long getIdPeriodicita();

	/**
	 * Sets the id periodicita of this local rich.
	 *
	 * @param idPeriodicita the id periodicita of this local rich
	 */
	public void setIdPeriodicita(long idPeriodicita);

	/**
	 * Returns the email of this local rich.
	 *
	 * @return the email of this local rich
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this local rich.
	 *
	 * @param email the email of this local rich
	 */
	public void setEmail(String email);

	/**
	 * Returns the rif stanza of this local rich.
	 *
	 * @return the rif stanza of this local rich
	 */
	@AutoEscape
	public String getRifStanza();

	/**
	 * Sets the rif stanza of this local rich.
	 *
	 * @param rifStanza the rif stanza of this local rich
	 */
	public void setRifStanza(String rifStanza);

	/**
	 * Returns the ispettorato of this local rich.
	 *
	 * @return the ispettorato of this local rich
	 */
	@AutoEscape
	public String getIspettorato();

	/**
	 * Sets the ispettorato of this local rich.
	 *
	 * @param ispettorato the ispettorato of this local rich
	 */
	public void setIspettorato(String ispettorato);

	/**
	 * Returns the note rich of this local rich.
	 *
	 * @return the note rich of this local rich
	 */
	@AutoEscape
	public String getNoteRich();

	/**
	 * Sets the note rich of this local rich.
	 *
	 * @param noteRich the note rich of this local rich
	 */
	public void setNoteRich(String noteRich);

	/**
	 * Returns the ufficio of this local rich.
	 *
	 * @return the ufficio of this local rich
	 */
	@AutoEscape
	public String getUfficio();

	/**
	 * Sets the ufficio of this local rich.
	 *
	 * @param ufficio the ufficio of this local rich
	 */
	public void setUfficio(String ufficio);

	/**
	 * Returns the note of this local rich.
	 *
	 * @return the note of this local rich
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this local rich.
	 *
	 * @param note the note of this local rich
	 */
	public void setNote(String note);

	/**
	 * Returns the uid ins of this local rich.
	 *
	 * @return the uid ins of this local rich
	 */
	public long getUidIns();

	/**
	 * Sets the uid ins of this local rich.
	 *
	 * @param uidIns the uid ins of this local rich
	 */
	public void setUidIns(long uidIns);

	/**
	 * Returns the data ins of this local rich.
	 *
	 * @return the data ins of this local rich
	 */
	public Date getDataIns();

	/**
	 * Sets the data ins of this local rich.
	 *
	 * @param dataIns the data ins of this local rich
	 */
	public void setDataIns(Date dataIns);

	/**
	 * Returns the uid upd of this local rich.
	 *
	 * @return the uid upd of this local rich
	 */
	public long getUidUpd();

	/**
	 * Sets the uid upd of this local rich.
	 *
	 * @param uidUpd the uid upd of this local rich
	 */
	public void setUidUpd(long uidUpd);

	/**
	 * Returns the data upd of this local rich.
	 *
	 * @return the data upd of this local rich
	 */
	public Date getDataUpd();

	/**
	 * Sets the data upd of this local rich.
	 *
	 * @param dataUpd the data upd of this local rich
	 */
	public void setDataUpd(Date dataUpd);

	/**
	 * Returns the oggetto of this local rich.
	 *
	 * @return the oggetto of this local rich
	 */
	@AutoEscape
	public String getOggetto();

	/**
	 * Sets the oggetto of this local rich.
	 *
	 * @param oggetto the oggetto of this local rich
	 */
	public void setOggetto(String oggetto);

	/**
	 * Returns the id sede of this local rich.
	 *
	 * @return the id sede of this local rich
	 */
	@AutoEscape
	public String getIdSede();

	/**
	 * Sets the id sede of this local rich.
	 *
	 * @param idSede the id sede of this local rich
	 */
	public void setIdSede(String idSede);

	/**
	 * Returns the strut isp of this local rich.
	 *
	 * @return the strut isp of this local rich
	 */
	@AutoEscape
	public String getStrutIsp();

	/**
	 * Sets the strut isp of this local rich.
	 *
	 * @param strutIsp the strut isp of this local rich
	 */
	public void setStrutIsp(String strutIsp);

	/**
	 * Returns the strut uff of this local rich.
	 *
	 * @return the strut uff of this local rich
	 */
	@AutoEscape
	public String getStrutUff();

	/**
	 * Sets the strut uff of this local rich.
	 *
	 * @param strutUff the strut uff of this local rich
	 */
	public void setStrutUff(String strutUff);

	/**
	 * Returns the strut isp2 of this local rich.
	 *
	 * @return the strut isp2 of this local rich
	 */
	@AutoEscape
	public String getStrutIsp2();

	/**
	 * Sets the strut isp2 of this local rich.
	 *
	 * @param strutIsp2 the strut isp2 of this local rich
	 */
	public void setStrutIsp2(String strutIsp2);

	/**
	 * Returns the tel rich of this local rich.
	 *
	 * @return the tel rich of this local rich
	 */
	@AutoEscape
	public String getTelRich();

	/**
	 * Sets the tel rich of this local rich.
	 *
	 * @param telRich the tel rich of this local rich
	 */
	public void setTelRich(String telRich);

	/**
	 * Returns the costo reale of this local rich.
	 *
	 * @return the costo reale of this local rich
	 */
	public float getCostoReale();

	/**
	 * Sets the costo reale of this local rich.
	 *
	 * @param costoReale the costo reale of this local rich
	 */
	public void setCostoReale(float costoReale);

	/**
	 * Returns the preventivo of this local rich.
	 *
	 * @return the preventivo of this local rich
	 */
	public int getPreventivo();

	/**
	 * Sets the preventivo of this local rich.
	 *
	 * @param preventivo the preventivo of this local rich
	 */
	public void setPreventivo(int preventivo);

	/**
	 * Returns the flag invio of this local rich.
	 *
	 * @return the flag invio of this local rich
	 */
	public int getFlagInvio();

	/**
	 * Sets the flag invio of this local rich.
	 *
	 * @param flagInvio the flag invio of this local rich
	 */
	public void setFlagInvio(int flagInvio);

	/**
	 * Returns the in stage of this local rich.
	 *
	 * @return the in stage of this local rich
	 */
	public boolean getInStage();

	/**
	 * Returns <code>true</code> if this local rich is in stage.
	 *
	 * @return <code>true</code> if this local rich is in stage; <code>false</code> otherwise
	 */
	public boolean isInStage();

	/**
	 * Sets whether this local rich is in stage.
	 *
	 * @param inStage the in stage of this local rich
	 */
	public void setInStage(boolean inStage);

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
	public int compareTo(servizio.local.bfc.model.LocalRich localRich);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.local.bfc.model.LocalRich> toCacheModel();

	@Override
	public servizio.local.bfc.model.LocalRich toEscapedModel();

	@Override
	public servizio.local.bfc.model.LocalRich toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}