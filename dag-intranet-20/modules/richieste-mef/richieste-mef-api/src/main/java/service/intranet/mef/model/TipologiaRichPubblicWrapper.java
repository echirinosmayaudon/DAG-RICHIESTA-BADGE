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
 * This class is a wrapper for {@link TipologiaRichPubblic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaRichPubblic
 * @generated
 */
@ProviderType
public class TipologiaRichPubblicWrapper implements TipologiaRichPubblic,
	ModelWrapper<TipologiaRichPubblic> {
	public TipologiaRichPubblicWrapper(
		TipologiaRichPubblic tipologiaRichPubblic) {
		_tipologiaRichPubblic = tipologiaRichPubblic;
	}

	@Override
	public Class<?> getModelClass() {
		return TipologiaRichPubblic.class;
	}

	@Override
	public String getModelClassName() {
		return TipologiaRichPubblic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipologia", getTipologia());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tipologia = (String)attributes.get("tipologia");

		if (tipologia != null) {
			setTipologia(tipologia);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _tipologiaRichPubblic.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipologiaRichPubblic.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipologiaRichPubblic.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipologiaRichPubblic.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.TipologiaRichPubblic> toCacheModel() {
		return _tipologiaRichPubblic.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.TipologiaRichPubblic tipologiaRichPubblic) {
		return _tipologiaRichPubblic.compareTo(tipologiaRichPubblic);
	}

	@Override
	public int hashCode() {
		return _tipologiaRichPubblic.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipologiaRichPubblic.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipologiaRichPubblicWrapper((TipologiaRichPubblic)_tipologiaRichPubblic.clone());
	}

	/**
	* Returns the tipologia of this tipologia rich pubblic.
	*
	* @return the tipologia of this tipologia rich pubblic
	*/
	@Override
	public java.lang.String getTipologia() {
		return _tipologiaRichPubblic.getTipologia();
	}

	@Override
	public java.lang.String toString() {
		return _tipologiaRichPubblic.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipologiaRichPubblic.toXmlString();
	}

	/**
	* Returns the ID of this tipologia rich pubblic.
	*
	* @return the ID of this tipologia rich pubblic
	*/
	@Override
	public long getId() {
		return _tipologiaRichPubblic.getId();
	}

	/**
	* Returns the primary key of this tipologia rich pubblic.
	*
	* @return the primary key of this tipologia rich pubblic
	*/
	@Override
	public long getPrimaryKey() {
		return _tipologiaRichPubblic.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.TipologiaRichPubblic toEscapedModel() {
		return new TipologiaRichPubblicWrapper(_tipologiaRichPubblic.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.TipologiaRichPubblic toUnescapedModel() {
		return new TipologiaRichPubblicWrapper(_tipologiaRichPubblic.toUnescapedModel());
	}

	@Override
	public void persist() {
		_tipologiaRichPubblic.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipologiaRichPubblic.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipologiaRichPubblic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipologiaRichPubblic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipologiaRichPubblic.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this tipologia rich pubblic.
	*
	* @param id the ID of this tipologia rich pubblic
	*/
	@Override
	public void setId(long id) {
		_tipologiaRichPubblic.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_tipologiaRichPubblic.setNew(n);
	}

	/**
	* Sets the primary key of this tipologia rich pubblic.
	*
	* @param primaryKey the primary key of this tipologia rich pubblic
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipologiaRichPubblic.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipologiaRichPubblic.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tipologia of this tipologia rich pubblic.
	*
	* @param tipologia the tipologia of this tipologia rich pubblic
	*/
	@Override
	public void setTipologia(java.lang.String tipologia) {
		_tipologiaRichPubblic.setTipologia(tipologia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipologiaRichPubblicWrapper)) {
			return false;
		}

		TipologiaRichPubblicWrapper tipologiaRichPubblicWrapper = (TipologiaRichPubblicWrapper)obj;

		if (Objects.equals(_tipologiaRichPubblic,
					tipologiaRichPubblicWrapper._tipologiaRichPubblic)) {
			return true;
		}

		return false;
	}

	@Override
	public TipologiaRichPubblic getWrappedModel() {
		return _tipologiaRichPubblic;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipologiaRichPubblic.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipologiaRichPubblic.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipologiaRichPubblic.resetOriginalValues();
	}

	private final TipologiaRichPubblic _tipologiaRichPubblic;
}