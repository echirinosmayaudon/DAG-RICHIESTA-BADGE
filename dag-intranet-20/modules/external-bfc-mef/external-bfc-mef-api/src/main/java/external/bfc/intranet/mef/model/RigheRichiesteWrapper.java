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

package external.bfc.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link RigheRichieste}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichieste
 * @generated
 */
@ProviderType
public class RigheRichiesteWrapper implements RigheRichieste,
	ModelWrapper<RigheRichieste> {
	public RigheRichiesteWrapper(RigheRichieste righeRichieste) {
		_righeRichieste = righeRichieste;
	}

	@Override
	public Class<?> getModelClass() {
		return RigheRichieste.class;
	}

	@Override
	public String getModelClassName() {
		return RigheRichieste.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idMateriale", getIdMateriale());
		attributes.put("numeroRiga", getNumeroRiga());
		attributes.put("quantitaRichiesta", getQuantitaRichiesta());
		attributes.put("quantitaDisponibile", getQuantitaDisponibile());
		attributes.put("uidIns", getUidIns());
		attributes.put("dataIns", getDataIns());
		attributes.put("uidUpd", getUidUpd());
		attributes.put("dataUpd", getDataUpd());
		attributes.put("importo", getImporto());
		attributes.put("sottogruppo", getSottogruppo());
		attributes.put("gruppo", getGruppo());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idMateriale = (Long)attributes.get("idMateriale");

		if (idMateriale != null) {
			setIdMateriale(idMateriale);
		}

		Long numeroRiga = (Long)attributes.get("numeroRiga");

		if (numeroRiga != null) {
			setNumeroRiga(numeroRiga);
		}

		Long quantitaRichiesta = (Long)attributes.get("quantitaRichiesta");

		if (quantitaRichiesta != null) {
			setQuantitaRichiesta(quantitaRichiesta);
		}

		Long quantitaDisponibile = (Long)attributes.get("quantitaDisponibile");

		if (quantitaDisponibile != null) {
			setQuantitaDisponibile(quantitaDisponibile);
		}

		Long uidIns = (Long)attributes.get("uidIns");

		if (uidIns != null) {
			setUidIns(uidIns);
		}

		Date dataIns = (Date)attributes.get("dataIns");

		if (dataIns != null) {
			setDataIns(dataIns);
		}

		Long uidUpd = (Long)attributes.get("uidUpd");

		if (uidUpd != null) {
			setUidUpd(uidUpd);
		}

		Date dataUpd = (Date)attributes.get("dataUpd");

		if (dataUpd != null) {
			setDataUpd(dataUpd);
		}

		Float importo = (Float)attributes.get("importo");

		if (importo != null) {
			setImporto(importo);
		}

		String sottogruppo = (String)attributes.get("sottogruppo");

		if (sottogruppo != null) {
			setSottogruppo(sottogruppo);
		}

		String gruppo = (String)attributes.get("gruppo");

		if (gruppo != null) {
			setGruppo(gruppo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _righeRichieste.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _righeRichieste.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _righeRichieste.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _righeRichieste.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<external.bfc.intranet.mef.model.RigheRichieste> toCacheModel() {
		return _righeRichieste.toCacheModel();
	}

	@Override
	public external.bfc.intranet.mef.model.RigheRichieste toEscapedModel() {
		return new RigheRichiesteWrapper(_righeRichieste.toEscapedModel());
	}

	@Override
	public external.bfc.intranet.mef.model.RigheRichieste toUnescapedModel() {
		return new RigheRichiesteWrapper(_righeRichieste.toUnescapedModel());
	}

	/**
	* Returns the primary key of this righe richieste.
	*
	* @return the primary key of this righe richieste
	*/
	@Override
	public external.bfc.intranet.mef.service.persistence.RigheRichiestePK getPrimaryKey() {
		return _righeRichieste.getPrimaryKey();
	}

	/**
	* Returns the importo of this righe richieste.
	*
	* @return the importo of this righe richieste
	*/
	@Override
	public float getImporto() {
		return _righeRichieste.getImporto();
	}

	@Override
	public int compareTo(
		external.bfc.intranet.mef.model.RigheRichieste righeRichieste) {
		return _righeRichieste.compareTo(righeRichieste);
	}

	@Override
	public int hashCode() {
		return _righeRichieste.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _righeRichieste.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RigheRichiesteWrapper((RigheRichieste)_righeRichieste.clone());
	}

	/**
	* Returns the descrizione of this righe richieste.
	*
	* @return the descrizione of this righe richieste
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _righeRichieste.getDescrizione();
	}

	/**
	* Returns the gruppo of this righe richieste.
	*
	* @return the gruppo of this righe richieste
	*/
	@Override
	public java.lang.String getGruppo() {
		return _righeRichieste.getGruppo();
	}

	/**
	* Returns the sottogruppo of this righe richieste.
	*
	* @return the sottogruppo of this righe richieste
	*/
	@Override
	public java.lang.String getSottogruppo() {
		return _righeRichieste.getSottogruppo();
	}

	@Override
	public java.lang.String toString() {
		return _righeRichieste.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _righeRichieste.toXmlString();
	}

	/**
	* Returns the data ins of this righe richieste.
	*
	* @return the data ins of this righe richieste
	*/
	@Override
	public Date getDataIns() {
		return _righeRichieste.getDataIns();
	}

	/**
	* Returns the data upd of this righe richieste.
	*
	* @return the data upd of this righe richieste
	*/
	@Override
	public Date getDataUpd() {
		return _righeRichieste.getDataUpd();
	}

	/**
	* Returns the ID of this righe richieste.
	*
	* @return the ID of this righe richieste
	*/
	@Override
	public long getId() {
		return _righeRichieste.getId();
	}

	/**
	* Returns the id materiale of this righe richieste.
	*
	* @return the id materiale of this righe richieste
	*/
	@Override
	public long getIdMateriale() {
		return _righeRichieste.getIdMateriale();
	}

	/**
	* Returns the numero riga of this righe richieste.
	*
	* @return the numero riga of this righe richieste
	*/
	@Override
	public long getNumeroRiga() {
		return _righeRichieste.getNumeroRiga();
	}

	/**
	* Returns the quantita disponibile of this righe richieste.
	*
	* @return the quantita disponibile of this righe richieste
	*/
	@Override
	public long getQuantitaDisponibile() {
		return _righeRichieste.getQuantitaDisponibile();
	}

	/**
	* Returns the quantita richiesta of this righe richieste.
	*
	* @return the quantita richiesta of this righe richieste
	*/
	@Override
	public long getQuantitaRichiesta() {
		return _righeRichieste.getQuantitaRichiesta();
	}

	/**
	* Returns the uid ins of this righe richieste.
	*
	* @return the uid ins of this righe richieste
	*/
	@Override
	public long getUidIns() {
		return _righeRichieste.getUidIns();
	}

	/**
	* Returns the uid upd of this righe richieste.
	*
	* @return the uid upd of this righe richieste
	*/
	@Override
	public long getUidUpd() {
		return _righeRichieste.getUidUpd();
	}

	@Override
	public void persist() {
		_righeRichieste.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_righeRichieste.setCachedModel(cachedModel);
	}

	/**
	* Sets the data ins of this righe richieste.
	*
	* @param dataIns the data ins of this righe richieste
	*/
	@Override
	public void setDataIns(Date dataIns) {
		_righeRichieste.setDataIns(dataIns);
	}

	/**
	* Sets the data upd of this righe richieste.
	*
	* @param dataUpd the data upd of this righe richieste
	*/
	@Override
	public void setDataUpd(Date dataUpd) {
		_righeRichieste.setDataUpd(dataUpd);
	}

	/**
	* Sets the descrizione of this righe richieste.
	*
	* @param descrizione the descrizione of this righe richieste
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_righeRichieste.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_righeRichieste.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_righeRichieste.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_righeRichieste.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gruppo of this righe richieste.
	*
	* @param gruppo the gruppo of this righe richieste
	*/
	@Override
	public void setGruppo(java.lang.String gruppo) {
		_righeRichieste.setGruppo(gruppo);
	}

	/**
	* Sets the ID of this righe richieste.
	*
	* @param id the ID of this righe richieste
	*/
	@Override
	public void setId(long id) {
		_righeRichieste.setId(id);
	}

	/**
	* Sets the id materiale of this righe richieste.
	*
	* @param idMateriale the id materiale of this righe richieste
	*/
	@Override
	public void setIdMateriale(long idMateriale) {
		_righeRichieste.setIdMateriale(idMateriale);
	}

	/**
	* Sets the importo of this righe richieste.
	*
	* @param importo the importo of this righe richieste
	*/
	@Override
	public void setImporto(float importo) {
		_righeRichieste.setImporto(importo);
	}

	@Override
	public void setNew(boolean n) {
		_righeRichieste.setNew(n);
	}

	/**
	* Sets the numero riga of this righe richieste.
	*
	* @param numeroRiga the numero riga of this righe richieste
	*/
	@Override
	public void setNumeroRiga(long numeroRiga) {
		_righeRichieste.setNumeroRiga(numeroRiga);
	}

	/**
	* Sets the primary key of this righe richieste.
	*
	* @param primaryKey the primary key of this righe richieste
	*/
	@Override
	public void setPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK primaryKey) {
		_righeRichieste.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_righeRichieste.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the quantita disponibile of this righe richieste.
	*
	* @param quantitaDisponibile the quantita disponibile of this righe richieste
	*/
	@Override
	public void setQuantitaDisponibile(long quantitaDisponibile) {
		_righeRichieste.setQuantitaDisponibile(quantitaDisponibile);
	}

	/**
	* Sets the quantita richiesta of this righe richieste.
	*
	* @param quantitaRichiesta the quantita richiesta of this righe richieste
	*/
	@Override
	public void setQuantitaRichiesta(long quantitaRichiesta) {
		_righeRichieste.setQuantitaRichiesta(quantitaRichiesta);
	}

	/**
	* Sets the sottogruppo of this righe richieste.
	*
	* @param sottogruppo the sottogruppo of this righe richieste
	*/
	@Override
	public void setSottogruppo(java.lang.String sottogruppo) {
		_righeRichieste.setSottogruppo(sottogruppo);
	}

	/**
	* Sets the uid ins of this righe richieste.
	*
	* @param uidIns the uid ins of this righe richieste
	*/
	@Override
	public void setUidIns(long uidIns) {
		_righeRichieste.setUidIns(uidIns);
	}

	/**
	* Sets the uid upd of this righe richieste.
	*
	* @param uidUpd the uid upd of this righe richieste
	*/
	@Override
	public void setUidUpd(long uidUpd) {
		_righeRichieste.setUidUpd(uidUpd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichiesteWrapper)) {
			return false;
		}

		RigheRichiesteWrapper righeRichiesteWrapper = (RigheRichiesteWrapper)obj;

		if (Objects.equals(_righeRichieste,
					righeRichiesteWrapper._righeRichieste)) {
			return true;
		}

		return false;
	}

	@Override
	public RigheRichieste getWrappedModel() {
		return _righeRichieste;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _righeRichieste.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _righeRichieste.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_righeRichieste.resetOriginalValues();
	}

	private final RigheRichieste _righeRichieste;
}