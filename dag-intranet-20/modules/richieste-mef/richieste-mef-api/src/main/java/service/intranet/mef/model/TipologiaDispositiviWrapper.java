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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TipologiaDispositivi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaDispositivi
 * @generated
 */
@ProviderType
public class TipologiaDispositiviWrapper implements TipologiaDispositivi,
	ModelWrapper<TipologiaDispositivi> {
	public TipologiaDispositiviWrapper(
		TipologiaDispositivi tipologiaDispositivi) {
		_tipologiaDispositivi = tipologiaDispositivi;
	}

	@Override
	public Class<?> getModelClass() {
		return TipologiaDispositivi.class;
	}

	@Override
	public String getModelClassName() {
		return TipologiaDispositivi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_tipologia_dispositivi", getId_tipologia_dispositivi());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_tipologia_dispositivi = (Long)attributes.get(
				"id_tipologia_dispositivi");

		if (id_tipologia_dispositivi != null) {
			setId_tipologia_dispositivi(id_tipologia_dispositivi);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _tipologiaDispositivi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipologiaDispositivi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipologiaDispositivi.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipologiaDispositivi.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.TipologiaDispositivi> toCacheModel() {
		return _tipologiaDispositivi.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.TipologiaDispositivi tipologiaDispositivi) {
		return _tipologiaDispositivi.compareTo(tipologiaDispositivi);
	}

	@Override
	public int hashCode() {
		return _tipologiaDispositivi.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipologiaDispositivi.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipologiaDispositiviWrapper((TipologiaDispositivi)_tipologiaDispositivi.clone());
	}

	/**
	* Returns the descrizione of this tipologia dispositivi.
	*
	* @return the descrizione of this tipologia dispositivi
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _tipologiaDispositivi.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _tipologiaDispositivi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipologiaDispositivi.toXmlString();
	}

	/**
	* Returns the id_tipologia_dispositivi of this tipologia dispositivi.
	*
	* @return the id_tipologia_dispositivi of this tipologia dispositivi
	*/
	@Override
	public long getId_tipologia_dispositivi() {
		return _tipologiaDispositivi.getId_tipologia_dispositivi();
	}

	/**
	* Returns the primary key of this tipologia dispositivi.
	*
	* @return the primary key of this tipologia dispositivi
	*/
	@Override
	public long getPrimaryKey() {
		return _tipologiaDispositivi.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.TipologiaDispositivi toEscapedModel() {
		return new TipologiaDispositiviWrapper(_tipologiaDispositivi.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.TipologiaDispositivi toUnescapedModel() {
		return new TipologiaDispositiviWrapper(_tipologiaDispositivi.toUnescapedModel());
	}

	@Override
	public void persist() {
		_tipologiaDispositivi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipologiaDispositivi.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this tipologia dispositivi.
	*
	* @param descrizione the descrizione of this tipologia dispositivi
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_tipologiaDispositivi.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipologiaDispositivi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipologiaDispositivi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipologiaDispositivi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_tipologia_dispositivi of this tipologia dispositivi.
	*
	* @param id_tipologia_dispositivi the id_tipologia_dispositivi of this tipologia dispositivi
	*/
	@Override
	public void setId_tipologia_dispositivi(long id_tipologia_dispositivi) {
		_tipologiaDispositivi.setId_tipologia_dispositivi(id_tipologia_dispositivi);
	}

	@Override
	public void setNew(boolean n) {
		_tipologiaDispositivi.setNew(n);
	}

	/**
	* Sets the primary key of this tipologia dispositivi.
	*
	* @param primaryKey the primary key of this tipologia dispositivi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipologiaDispositivi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipologiaDispositivi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipologiaDispositiviWrapper)) {
			return false;
		}

		TipologiaDispositiviWrapper tipologiaDispositiviWrapper = (TipologiaDispositiviWrapper)obj;

		if (Objects.equals(_tipologiaDispositivi,
					tipologiaDispositiviWrapper._tipologiaDispositivi)) {
			return true;
		}

		return false;
	}

	@Override
	public TipologiaDispositivi getWrappedModel() {
		return _tipologiaDispositivi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipologiaDispositivi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipologiaDispositivi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipologiaDispositivi.resetOriginalValues();
	}

	private final TipologiaDispositivi _tipologiaDispositivi;
}