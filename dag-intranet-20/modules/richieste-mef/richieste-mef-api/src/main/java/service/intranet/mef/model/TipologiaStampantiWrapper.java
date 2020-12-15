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
 * This class is a wrapper for {@link TipologiaStampanti}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaStampanti
 * @generated
 */
@ProviderType
public class TipologiaStampantiWrapper implements TipologiaStampanti,
	ModelWrapper<TipologiaStampanti> {
	public TipologiaStampantiWrapper(TipologiaStampanti tipologiaStampanti) {
		_tipologiaStampanti = tipologiaStampanti;
	}

	@Override
	public Class<?> getModelClass() {
		return TipologiaStampanti.class;
	}

	@Override
	public String getModelClassName() {
		return TipologiaStampanti.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_tipologia_stampanti", getId_tipologia_stampanti());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_tipologia_stampanti = (Long)attributes.get(
				"id_tipologia_stampanti");

		if (id_tipologia_stampanti != null) {
			setId_tipologia_stampanti(id_tipologia_stampanti);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _tipologiaStampanti.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipologiaStampanti.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipologiaStampanti.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipologiaStampanti.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.TipologiaStampanti> toCacheModel() {
		return _tipologiaStampanti.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.TipologiaStampanti tipologiaStampanti) {
		return _tipologiaStampanti.compareTo(tipologiaStampanti);
	}

	@Override
	public int hashCode() {
		return _tipologiaStampanti.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipologiaStampanti.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipologiaStampantiWrapper((TipologiaStampanti)_tipologiaStampanti.clone());
	}

	/**
	* Returns the descrizione of this tipologia stampanti.
	*
	* @return the descrizione of this tipologia stampanti
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _tipologiaStampanti.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _tipologiaStampanti.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipologiaStampanti.toXmlString();
	}

	/**
	* Returns the id_tipologia_stampanti of this tipologia stampanti.
	*
	* @return the id_tipologia_stampanti of this tipologia stampanti
	*/
	@Override
	public long getId_tipologia_stampanti() {
		return _tipologiaStampanti.getId_tipologia_stampanti();
	}

	/**
	* Returns the primary key of this tipologia stampanti.
	*
	* @return the primary key of this tipologia stampanti
	*/
	@Override
	public long getPrimaryKey() {
		return _tipologiaStampanti.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.TipologiaStampanti toEscapedModel() {
		return new TipologiaStampantiWrapper(_tipologiaStampanti.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.TipologiaStampanti toUnescapedModel() {
		return new TipologiaStampantiWrapper(_tipologiaStampanti.toUnescapedModel());
	}

	@Override
	public void persist() {
		_tipologiaStampanti.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipologiaStampanti.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this tipologia stampanti.
	*
	* @param descrizione the descrizione of this tipologia stampanti
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_tipologiaStampanti.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipologiaStampanti.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipologiaStampanti.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipologiaStampanti.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_tipologia_stampanti of this tipologia stampanti.
	*
	* @param id_tipologia_stampanti the id_tipologia_stampanti of this tipologia stampanti
	*/
	@Override
	public void setId_tipologia_stampanti(long id_tipologia_stampanti) {
		_tipologiaStampanti.setId_tipologia_stampanti(id_tipologia_stampanti);
	}

	@Override
	public void setNew(boolean n) {
		_tipologiaStampanti.setNew(n);
	}

	/**
	* Sets the primary key of this tipologia stampanti.
	*
	* @param primaryKey the primary key of this tipologia stampanti
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipologiaStampanti.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipologiaStampanti.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipologiaStampantiWrapper)) {
			return false;
		}

		TipologiaStampantiWrapper tipologiaStampantiWrapper = (TipologiaStampantiWrapper)obj;

		if (Objects.equals(_tipologiaStampanti,
					tipologiaStampantiWrapper._tipologiaStampanti)) {
			return true;
		}

		return false;
	}

	@Override
	public TipologiaStampanti getWrappedModel() {
		return _tipologiaStampanti;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipologiaStampanti.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipologiaStampanti.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipologiaStampanti.resetOriginalValues();
	}

	private final TipologiaStampanti _tipologiaStampanti;
}