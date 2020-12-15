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
 * This class is a wrapper for {@link StatoRichiesta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichiesta
 * @generated
 */
@ProviderType
public class StatoRichiestaWrapper implements StatoRichiesta,
	ModelWrapper<StatoRichiesta> {
	public StatoRichiestaWrapper(StatoRichiesta statoRichiesta) {
		_statoRichiesta = statoRichiesta;
	}

	@Override
	public Class<?> getModelClass() {
		return StatoRichiesta.class;
	}

	@Override
	public String getModelClassName() {
		return StatoRichiesta.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_stato", getId_stato());
		attributes.put("descrizione_stato", getDescrizione_stato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_stato = (Long)attributes.get("id_stato");

		if (id_stato != null) {
			setId_stato(id_stato);
		}

		String descrizione_stato = (String)attributes.get("descrizione_stato");

		if (descrizione_stato != null) {
			setDescrizione_stato(descrizione_stato);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _statoRichiesta.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _statoRichiesta.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _statoRichiesta.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _statoRichiesta.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.richieste.badge.mef.model.StatoRichiesta> toCacheModel() {
		return _statoRichiesta.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.richieste.badge.mef.model.StatoRichiesta statoRichiesta) {
		return _statoRichiesta.compareTo(statoRichiesta);
	}

	@Override
	public int hashCode() {
		return _statoRichiesta.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statoRichiesta.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StatoRichiestaWrapper((StatoRichiesta)_statoRichiesta.clone());
	}

	/**
	* Returns the descrizione_stato of this stato richiesta.
	*
	* @return the descrizione_stato of this stato richiesta
	*/
	@Override
	public java.lang.String getDescrizione_stato() {
		return _statoRichiesta.getDescrizione_stato();
	}

	@Override
	public java.lang.String toString() {
		return _statoRichiesta.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statoRichiesta.toXmlString();
	}

	/**
	* Returns the id_stato of this stato richiesta.
	*
	* @return the id_stato of this stato richiesta
	*/
	@Override
	public long getId_stato() {
		return _statoRichiesta.getId_stato();
	}

	/**
	* Returns the primary key of this stato richiesta.
	*
	* @return the primary key of this stato richiesta
	*/
	@Override
	public long getPrimaryKey() {
		return _statoRichiesta.getPrimaryKey();
	}

	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta toEscapedModel() {
		return new StatoRichiestaWrapper(_statoRichiesta.toEscapedModel());
	}

	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta toUnescapedModel() {
		return new StatoRichiestaWrapper(_statoRichiesta.toUnescapedModel());
	}

	@Override
	public void persist() {
		_statoRichiesta.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statoRichiesta.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione_stato of this stato richiesta.
	*
	* @param descrizione_stato the descrizione_stato of this stato richiesta
	*/
	@Override
	public void setDescrizione_stato(java.lang.String descrizione_stato) {
		_statoRichiesta.setDescrizione_stato(descrizione_stato);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_statoRichiesta.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_statoRichiesta.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_statoRichiesta.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_stato of this stato richiesta.
	*
	* @param id_stato the id_stato of this stato richiesta
	*/
	@Override
	public void setId_stato(long id_stato) {
		_statoRichiesta.setId_stato(id_stato);
	}

	@Override
	public void setNew(boolean n) {
		_statoRichiesta.setNew(n);
	}

	/**
	* Sets the primary key of this stato richiesta.
	*
	* @param primaryKey the primary key of this stato richiesta
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statoRichiesta.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_statoRichiesta.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoRichiestaWrapper)) {
			return false;
		}

		StatoRichiestaWrapper statoRichiestaWrapper = (StatoRichiestaWrapper)obj;

		if (Objects.equals(_statoRichiesta,
					statoRichiestaWrapper._statoRichiesta)) {
			return true;
		}

		return false;
	}

	@Override
	public StatoRichiesta getWrappedModel() {
		return _statoRichiesta;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _statoRichiesta.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _statoRichiesta.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_statoRichiesta.resetOriginalValues();
	}

	private final StatoRichiesta _statoRichiesta;
}