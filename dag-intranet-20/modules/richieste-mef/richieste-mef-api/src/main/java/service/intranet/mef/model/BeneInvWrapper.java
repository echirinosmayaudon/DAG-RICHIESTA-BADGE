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
 * This class is a wrapper for {@link BeneInv}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInv
 * @generated
 */
@ProviderType
public class BeneInvWrapper implements BeneInv, ModelWrapper<BeneInv> {
	public BeneInvWrapper(BeneInv beneInv) {
		_beneInv = beneInv;
	}

	@Override
	public Class<?> getModelClass() {
		return BeneInv.class;
	}

	@Override
	public String getModelClassName() {
		return BeneInv.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("bene", getBene());
		attributes.put("id_tipo", getId_tipo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String bene = (String)attributes.get("bene");

		if (bene != null) {
			setBene(bene);
		}

		Long id_tipo = (Long)attributes.get("id_tipo");

		if (id_tipo != null) {
			setId_tipo(id_tipo);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _beneInv.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _beneInv.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _beneInv.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _beneInv.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.BeneInv> toCacheModel() {
		return _beneInv.toCacheModel();
	}

	@Override
	public int compareTo(service.intranet.mef.model.BeneInv beneInv) {
		return _beneInv.compareTo(beneInv);
	}

	@Override
	public int hashCode() {
		return _beneInv.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _beneInv.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BeneInvWrapper((BeneInv)_beneInv.clone());
	}

	/**
	* Returns the bene of this bene inv.
	*
	* @return the bene of this bene inv
	*/
	@Override
	public java.lang.String getBene() {
		return _beneInv.getBene();
	}

	@Override
	public java.lang.String toString() {
		return _beneInv.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _beneInv.toXmlString();
	}

	/**
	* Returns the ID of this bene inv.
	*
	* @return the ID of this bene inv
	*/
	@Override
	public long getId() {
		return _beneInv.getId();
	}

	/**
	* Returns the id_tipo of this bene inv.
	*
	* @return the id_tipo of this bene inv
	*/
	@Override
	public long getId_tipo() {
		return _beneInv.getId_tipo();
	}

	/**
	* Returns the primary key of this bene inv.
	*
	* @return the primary key of this bene inv
	*/
	@Override
	public long getPrimaryKey() {
		return _beneInv.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.BeneInv toEscapedModel() {
		return new BeneInvWrapper(_beneInv.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.BeneInv toUnescapedModel() {
		return new BeneInvWrapper(_beneInv.toUnescapedModel());
	}

	@Override
	public void persist() {
		_beneInv.persist();
	}

	/**
	* Sets the bene of this bene inv.
	*
	* @param bene the bene of this bene inv
	*/
	@Override
	public void setBene(java.lang.String bene) {
		_beneInv.setBene(bene);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_beneInv.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_beneInv.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_beneInv.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_beneInv.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this bene inv.
	*
	* @param id the ID of this bene inv
	*/
	@Override
	public void setId(long id) {
		_beneInv.setId(id);
	}

	/**
	* Sets the id_tipo of this bene inv.
	*
	* @param id_tipo the id_tipo of this bene inv
	*/
	@Override
	public void setId_tipo(long id_tipo) {
		_beneInv.setId_tipo(id_tipo);
	}

	@Override
	public void setNew(boolean n) {
		_beneInv.setNew(n);
	}

	/**
	* Sets the primary key of this bene inv.
	*
	* @param primaryKey the primary key of this bene inv
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_beneInv.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_beneInv.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BeneInvWrapper)) {
			return false;
		}

		BeneInvWrapper beneInvWrapper = (BeneInvWrapper)obj;

		if (Objects.equals(_beneInv, beneInvWrapper._beneInv)) {
			return true;
		}

		return false;
	}

	@Override
	public BeneInv getWrappedModel() {
		return _beneInv;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _beneInv.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _beneInv.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_beneInv.resetOriginalValues();
	}

	private final BeneInv _beneInv;
}