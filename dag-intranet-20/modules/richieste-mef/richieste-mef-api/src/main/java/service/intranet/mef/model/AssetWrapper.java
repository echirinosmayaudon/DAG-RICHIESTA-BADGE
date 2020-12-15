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
 * This class is a wrapper for {@link Asset}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Asset
 * @generated
 */
@ProviderType
public class AssetWrapper implements Asset, ModelWrapper<Asset> {
	public AssetWrapper(Asset asset) {
		_asset = asset;
	}

	@Override
	public Class<?> getModelClass() {
		return Asset.class;
	}

	@Override
	public String getModelClassName() {
		return Asset.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _asset.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _asset.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _asset.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _asset.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.Asset> toCacheModel() {
		return _asset.toCacheModel();
	}

	@Override
	public int compareTo(service.intranet.mef.model.Asset asset) {
		return _asset.compareTo(asset);
	}

	@Override
	public int hashCode() {
		return _asset.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _asset.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AssetWrapper((Asset)_asset.clone());
	}

	/**
	* Returns the descrizione of this asset.
	*
	* @return the descrizione of this asset
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _asset.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _asset.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _asset.toXmlString();
	}

	/**
	* Returns the ID of this asset.
	*
	* @return the ID of this asset
	*/
	@Override
	public long getId() {
		return _asset.getId();
	}

	/**
	* Returns the primary key of this asset.
	*
	* @return the primary key of this asset
	*/
	@Override
	public long getPrimaryKey() {
		return _asset.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.Asset toEscapedModel() {
		return new AssetWrapper(_asset.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.Asset toUnescapedModel() {
		return new AssetWrapper(_asset.toUnescapedModel());
	}

	@Override
	public void persist() {
		_asset.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_asset.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this asset.
	*
	* @param descrizione the descrizione of this asset
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_asset.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_asset.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_asset.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_asset.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this asset.
	*
	* @param id the ID of this asset
	*/
	@Override
	public void setId(long id) {
		_asset.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_asset.setNew(n);
	}

	/**
	* Sets the primary key of this asset.
	*
	* @param primaryKey the primary key of this asset
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_asset.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_asset.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssetWrapper)) {
			return false;
		}

		AssetWrapper assetWrapper = (AssetWrapper)obj;

		if (Objects.equals(_asset, assetWrapper._asset)) {
			return true;
		}

		return false;
	}

	@Override
	public Asset getWrappedModel() {
		return _asset;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _asset.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _asset.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_asset.resetOriginalValues();
	}

	private final Asset _asset;
}