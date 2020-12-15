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
 * This class is a wrapper for {@link TipoBeneInv}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoBeneInv
 * @generated
 */
@ProviderType
public class TipoBeneInvWrapper implements TipoBeneInv,
	ModelWrapper<TipoBeneInv> {
	public TipoBeneInvWrapper(TipoBeneInv tipoBeneInv) {
		_tipoBeneInv = tipoBeneInv;
	}

	@Override
	public Class<?> getModelClass() {
		return TipoBeneInv.class;
	}

	@Override
	public String getModelClassName() {
		return TipoBeneInv.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipo", getTipo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _tipoBeneInv.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipoBeneInv.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipoBeneInv.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipoBeneInv.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.TipoBeneInv> toCacheModel() {
		return _tipoBeneInv.toCacheModel();
	}

	@Override
	public int compareTo(service.intranet.mef.model.TipoBeneInv tipoBeneInv) {
		return _tipoBeneInv.compareTo(tipoBeneInv);
	}

	@Override
	public int hashCode() {
		return _tipoBeneInv.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipoBeneInv.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipoBeneInvWrapper((TipoBeneInv)_tipoBeneInv.clone());
	}

	/**
	* Returns the tipo of this tipo bene inv.
	*
	* @return the tipo of this tipo bene inv
	*/
	@Override
	public java.lang.String getTipo() {
		return _tipoBeneInv.getTipo();
	}

	@Override
	public java.lang.String toString() {
		return _tipoBeneInv.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipoBeneInv.toXmlString();
	}

	/**
	* Returns the ID of this tipo bene inv.
	*
	* @return the ID of this tipo bene inv
	*/
	@Override
	public long getId() {
		return _tipoBeneInv.getId();
	}

	/**
	* Returns the primary key of this tipo bene inv.
	*
	* @return the primary key of this tipo bene inv
	*/
	@Override
	public long getPrimaryKey() {
		return _tipoBeneInv.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.TipoBeneInv toEscapedModel() {
		return new TipoBeneInvWrapper(_tipoBeneInv.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.TipoBeneInv toUnescapedModel() {
		return new TipoBeneInvWrapper(_tipoBeneInv.toUnescapedModel());
	}

	@Override
	public void persist() {
		_tipoBeneInv.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipoBeneInv.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipoBeneInv.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipoBeneInv.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipoBeneInv.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this tipo bene inv.
	*
	* @param id the ID of this tipo bene inv
	*/
	@Override
	public void setId(long id) {
		_tipoBeneInv.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_tipoBeneInv.setNew(n);
	}

	/**
	* Sets the primary key of this tipo bene inv.
	*
	* @param primaryKey the primary key of this tipo bene inv
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipoBeneInv.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipoBeneInv.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tipo of this tipo bene inv.
	*
	* @param tipo the tipo of this tipo bene inv
	*/
	@Override
	public void setTipo(java.lang.String tipo) {
		_tipoBeneInv.setTipo(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoBeneInvWrapper)) {
			return false;
		}

		TipoBeneInvWrapper tipoBeneInvWrapper = (TipoBeneInvWrapper)obj;

		if (Objects.equals(_tipoBeneInv, tipoBeneInvWrapper._tipoBeneInv)) {
			return true;
		}

		return false;
	}

	@Override
	public TipoBeneInv getWrappedModel() {
		return _tipoBeneInv;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipoBeneInv.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipoBeneInv.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipoBeneInv.resetOriginalValues();
	}

	private final TipoBeneInv _tipoBeneInv;
}