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
 * This class is a wrapper for {@link RigheRichiesteInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiesteInfo
 * @generated
 */
@ProviderType
public class RigheRichiesteInfoWrapper implements RigheRichiesteInfo,
	ModelWrapper<RigheRichiesteInfo> {
	public RigheRichiesteInfoWrapper(RigheRichiesteInfo righeRichiesteInfo) {
		_righeRichiesteInfo = righeRichiesteInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return RigheRichiesteInfo.class;
	}

	@Override
	public String getModelClassName() {
		return RigheRichiesteInfo.class.getName();
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
		return _righeRichiesteInfo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _righeRichiesteInfo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _righeRichiesteInfo.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _righeRichiesteInfo.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<external.bfc.intranet.mef.model.RigheRichiesteInfo> toCacheModel() {
		return _righeRichiesteInfo.toCacheModel();
	}

	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo toEscapedModel() {
		return new RigheRichiesteInfoWrapper(_righeRichiesteInfo.toEscapedModel());
	}

	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo toUnescapedModel() {
		return new RigheRichiesteInfoWrapper(_righeRichiesteInfo.toUnescapedModel());
	}

	/**
	* Returns the primary key of this righe richieste info.
	*
	* @return the primary key of this righe richieste info
	*/
	@Override
	public external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK getPrimaryKey() {
		return _righeRichiesteInfo.getPrimaryKey();
	}

	/**
	* Returns the importo of this righe richieste info.
	*
	* @return the importo of this righe richieste info
	*/
	@Override
	public float getImporto() {
		return _righeRichiesteInfo.getImporto();
	}

	@Override
	public int compareTo(
		external.bfc.intranet.mef.model.RigheRichiesteInfo righeRichiesteInfo) {
		return _righeRichiesteInfo.compareTo(righeRichiesteInfo);
	}

	@Override
	public int hashCode() {
		return _righeRichiesteInfo.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _righeRichiesteInfo.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RigheRichiesteInfoWrapper((RigheRichiesteInfo)_righeRichiesteInfo.clone());
	}

	/**
	* Returns the descrizione of this righe richieste info.
	*
	* @return the descrizione of this righe richieste info
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _righeRichiesteInfo.getDescrizione();
	}

	/**
	* Returns the gruppo of this righe richieste info.
	*
	* @return the gruppo of this righe richieste info
	*/
	@Override
	public java.lang.String getGruppo() {
		return _righeRichiesteInfo.getGruppo();
	}

	/**
	* Returns the sottogruppo of this righe richieste info.
	*
	* @return the sottogruppo of this righe richieste info
	*/
	@Override
	public java.lang.String getSottogruppo() {
		return _righeRichiesteInfo.getSottogruppo();
	}

	@Override
	public java.lang.String toString() {
		return _righeRichiesteInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _righeRichiesteInfo.toXmlString();
	}

	/**
	* Returns the data ins of this righe richieste info.
	*
	* @return the data ins of this righe richieste info
	*/
	@Override
	public Date getDataIns() {
		return _righeRichiesteInfo.getDataIns();
	}

	/**
	* Returns the data upd of this righe richieste info.
	*
	* @return the data upd of this righe richieste info
	*/
	@Override
	public Date getDataUpd() {
		return _righeRichiesteInfo.getDataUpd();
	}

	/**
	* Returns the ID of this righe richieste info.
	*
	* @return the ID of this righe richieste info
	*/
	@Override
	public long getId() {
		return _righeRichiesteInfo.getId();
	}

	/**
	* Returns the id materiale of this righe richieste info.
	*
	* @return the id materiale of this righe richieste info
	*/
	@Override
	public long getIdMateriale() {
		return _righeRichiesteInfo.getIdMateriale();
	}

	/**
	* Returns the numero riga of this righe richieste info.
	*
	* @return the numero riga of this righe richieste info
	*/
	@Override
	public long getNumeroRiga() {
		return _righeRichiesteInfo.getNumeroRiga();
	}

	/**
	* Returns the quantita disponibile of this righe richieste info.
	*
	* @return the quantita disponibile of this righe richieste info
	*/
	@Override
	public long getQuantitaDisponibile() {
		return _righeRichiesteInfo.getQuantitaDisponibile();
	}

	/**
	* Returns the quantita richiesta of this righe richieste info.
	*
	* @return the quantita richiesta of this righe richieste info
	*/
	@Override
	public long getQuantitaRichiesta() {
		return _righeRichiesteInfo.getQuantitaRichiesta();
	}

	/**
	* Returns the uid ins of this righe richieste info.
	*
	* @return the uid ins of this righe richieste info
	*/
	@Override
	public long getUidIns() {
		return _righeRichiesteInfo.getUidIns();
	}

	/**
	* Returns the uid upd of this righe richieste info.
	*
	* @return the uid upd of this righe richieste info
	*/
	@Override
	public long getUidUpd() {
		return _righeRichiesteInfo.getUidUpd();
	}

	@Override
	public void persist() {
		_righeRichiesteInfo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_righeRichiesteInfo.setCachedModel(cachedModel);
	}

	/**
	* Sets the data ins of this righe richieste info.
	*
	* @param dataIns the data ins of this righe richieste info
	*/
	@Override
	public void setDataIns(Date dataIns) {
		_righeRichiesteInfo.setDataIns(dataIns);
	}

	/**
	* Sets the data upd of this righe richieste info.
	*
	* @param dataUpd the data upd of this righe richieste info
	*/
	@Override
	public void setDataUpd(Date dataUpd) {
		_righeRichiesteInfo.setDataUpd(dataUpd);
	}

	/**
	* Sets the descrizione of this righe richieste info.
	*
	* @param descrizione the descrizione of this righe richieste info
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_righeRichiesteInfo.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_righeRichiesteInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_righeRichiesteInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_righeRichiesteInfo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gruppo of this righe richieste info.
	*
	* @param gruppo the gruppo of this righe richieste info
	*/
	@Override
	public void setGruppo(java.lang.String gruppo) {
		_righeRichiesteInfo.setGruppo(gruppo);
	}

	/**
	* Sets the ID of this righe richieste info.
	*
	* @param id the ID of this righe richieste info
	*/
	@Override
	public void setId(long id) {
		_righeRichiesteInfo.setId(id);
	}

	/**
	* Sets the id materiale of this righe richieste info.
	*
	* @param idMateriale the id materiale of this righe richieste info
	*/
	@Override
	public void setIdMateriale(long idMateriale) {
		_righeRichiesteInfo.setIdMateriale(idMateriale);
	}

	/**
	* Sets the importo of this righe richieste info.
	*
	* @param importo the importo of this righe richieste info
	*/
	@Override
	public void setImporto(float importo) {
		_righeRichiesteInfo.setImporto(importo);
	}

	@Override
	public void setNew(boolean n) {
		_righeRichiesteInfo.setNew(n);
	}

	/**
	* Sets the numero riga of this righe richieste info.
	*
	* @param numeroRiga the numero riga of this righe richieste info
	*/
	@Override
	public void setNumeroRiga(long numeroRiga) {
		_righeRichiesteInfo.setNumeroRiga(numeroRiga);
	}

	/**
	* Sets the primary key of this righe richieste info.
	*
	* @param primaryKey the primary key of this righe richieste info
	*/
	@Override
	public void setPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK primaryKey) {
		_righeRichiesteInfo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_righeRichiesteInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the quantita disponibile of this righe richieste info.
	*
	* @param quantitaDisponibile the quantita disponibile of this righe richieste info
	*/
	@Override
	public void setQuantitaDisponibile(long quantitaDisponibile) {
		_righeRichiesteInfo.setQuantitaDisponibile(quantitaDisponibile);
	}

	/**
	* Sets the quantita richiesta of this righe richieste info.
	*
	* @param quantitaRichiesta the quantita richiesta of this righe richieste info
	*/
	@Override
	public void setQuantitaRichiesta(long quantitaRichiesta) {
		_righeRichiesteInfo.setQuantitaRichiesta(quantitaRichiesta);
	}

	/**
	* Sets the sottogruppo of this righe richieste info.
	*
	* @param sottogruppo the sottogruppo of this righe richieste info
	*/
	@Override
	public void setSottogruppo(java.lang.String sottogruppo) {
		_righeRichiesteInfo.setSottogruppo(sottogruppo);
	}

	/**
	* Sets the uid ins of this righe richieste info.
	*
	* @param uidIns the uid ins of this righe richieste info
	*/
	@Override
	public void setUidIns(long uidIns) {
		_righeRichiesteInfo.setUidIns(uidIns);
	}

	/**
	* Sets the uid upd of this righe richieste info.
	*
	* @param uidUpd the uid upd of this righe richieste info
	*/
	@Override
	public void setUidUpd(long uidUpd) {
		_righeRichiesteInfo.setUidUpd(uidUpd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichiesteInfoWrapper)) {
			return false;
		}

		RigheRichiesteInfoWrapper righeRichiesteInfoWrapper = (RigheRichiesteInfoWrapper)obj;

		if (Objects.equals(_righeRichiesteInfo,
					righeRichiesteInfoWrapper._righeRichiesteInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public RigheRichiesteInfo getWrappedModel() {
		return _righeRichiesteInfo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _righeRichiesteInfo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _righeRichiesteInfo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_righeRichiesteInfo.resetOriginalValues();
	}

	private final RigheRichiesteInfo _righeRichiesteInfo;
}