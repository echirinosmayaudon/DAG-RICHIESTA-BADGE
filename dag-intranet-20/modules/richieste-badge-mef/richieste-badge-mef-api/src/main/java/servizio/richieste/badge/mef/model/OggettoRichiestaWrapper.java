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

package servizio.richieste.badge.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link OggettoRichiesta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OggettoRichiesta
 * @generated
 */
@ProviderType
public class OggettoRichiestaWrapper implements OggettoRichiesta,
	ModelWrapper<OggettoRichiesta> {
	public OggettoRichiestaWrapper(OggettoRichiesta oggettoRichiesta) {
		_oggettoRichiesta = oggettoRichiesta;
	}

	@Override
	public Class<?> getModelClass() {
		return OggettoRichiesta.class;
	}

	@Override
	public String getModelClassName() {
		return OggettoRichiesta.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_oggetto", getId_oggetto());
		attributes.put("descrizione_oggetto", getDescrizione_oggetto());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_oggetto = (Long)attributes.get("id_oggetto");

		if (id_oggetto != null) {
			setId_oggetto(id_oggetto);
		}

		String descrizione_oggetto = (String)attributes.get(
				"descrizione_oggetto");

		if (descrizione_oggetto != null) {
			setDescrizione_oggetto(descrizione_oggetto);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _oggettoRichiesta.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _oggettoRichiesta.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _oggettoRichiesta.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _oggettoRichiesta.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.richieste.badge.mef.model.OggettoRichiesta> toCacheModel() {
		return _oggettoRichiesta.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.richieste.badge.mef.model.OggettoRichiesta oggettoRichiesta) {
		return _oggettoRichiesta.compareTo(oggettoRichiesta);
	}

	@Override
	public int hashCode() {
		return _oggettoRichiesta.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _oggettoRichiesta.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new OggettoRichiestaWrapper((OggettoRichiesta)_oggettoRichiesta.clone());
	}

	/**
	* Returns the descrizione_oggetto of this oggetto richiesta.
	*
	* @return the descrizione_oggetto of this oggetto richiesta
	*/
	@Override
	public java.lang.String getDescrizione_oggetto() {
		return _oggettoRichiesta.getDescrizione_oggetto();
	}

	@Override
	public java.lang.String toString() {
		return _oggettoRichiesta.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _oggettoRichiesta.toXmlString();
	}

	/**
	* Returns the id_oggetto of this oggetto richiesta.
	*
	* @return the id_oggetto of this oggetto richiesta
	*/
	@Override
	public long getId_oggetto() {
		return _oggettoRichiesta.getId_oggetto();
	}

	/**
	* Returns the primary key of this oggetto richiesta.
	*
	* @return the primary key of this oggetto richiesta
	*/
	@Override
	public long getPrimaryKey() {
		return _oggettoRichiesta.getPrimaryKey();
	}

	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta toEscapedModel() {
		return new OggettoRichiestaWrapper(_oggettoRichiesta.toEscapedModel());
	}

	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta toUnescapedModel() {
		return new OggettoRichiestaWrapper(_oggettoRichiesta.toUnescapedModel());
	}

	@Override
	public void persist() {
		_oggettoRichiesta.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_oggettoRichiesta.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione_oggetto of this oggetto richiesta.
	*
	* @param descrizione_oggetto the descrizione_oggetto of this oggetto richiesta
	*/
	@Override
	public void setDescrizione_oggetto(java.lang.String descrizione_oggetto) {
		_oggettoRichiesta.setDescrizione_oggetto(descrizione_oggetto);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_oggettoRichiesta.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_oggettoRichiesta.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_oggettoRichiesta.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_oggetto of this oggetto richiesta.
	*
	* @param id_oggetto the id_oggetto of this oggetto richiesta
	*/
	@Override
	public void setId_oggetto(long id_oggetto) {
		_oggettoRichiesta.setId_oggetto(id_oggetto);
	}

	@Override
	public void setNew(boolean n) {
		_oggettoRichiesta.setNew(n);
	}

	/**
	* Sets the primary key of this oggetto richiesta.
	*
	* @param primaryKey the primary key of this oggetto richiesta
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_oggettoRichiesta.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_oggettoRichiesta.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OggettoRichiestaWrapper)) {
			return false;
		}

		OggettoRichiestaWrapper oggettoRichiestaWrapper = (OggettoRichiestaWrapper)obj;

		if (Objects.equals(_oggettoRichiesta,
					oggettoRichiestaWrapper._oggettoRichiesta)) {
			return true;
		}

		return false;
	}

	@Override
	public OggettoRichiesta getWrappedModel() {
		return _oggettoRichiesta;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _oggettoRichiesta.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _oggettoRichiesta.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_oggettoRichiesta.resetOriginalValues();
	}

	private final OggettoRichiesta _oggettoRichiesta;
}