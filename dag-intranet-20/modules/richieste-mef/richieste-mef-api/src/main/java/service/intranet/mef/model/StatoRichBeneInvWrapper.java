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
 * This class is a wrapper for {@link StatoRichBeneInv}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichBeneInv
 * @generated
 */
@ProviderType
public class StatoRichBeneInvWrapper implements StatoRichBeneInv,
	ModelWrapper<StatoRichBeneInv> {
	public StatoRichBeneInvWrapper(StatoRichBeneInv statoRichBeneInv) {
		_statoRichBeneInv = statoRichBeneInv;
	}

	@Override
	public Class<?> getModelClass() {
		return StatoRichBeneInv.class;
	}

	@Override
	public String getModelClassName() {
		return StatoRichBeneInv.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("stato", getStato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _statoRichBeneInv.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _statoRichBeneInv.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _statoRichBeneInv.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _statoRichBeneInv.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.StatoRichBeneInv> toCacheModel() {
		return _statoRichBeneInv.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.StatoRichBeneInv statoRichBeneInv) {
		return _statoRichBeneInv.compareTo(statoRichBeneInv);
	}

	@Override
	public int hashCode() {
		return _statoRichBeneInv.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statoRichBeneInv.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StatoRichBeneInvWrapper((StatoRichBeneInv)_statoRichBeneInv.clone());
	}

	/**
	* Returns the stato of this stato rich bene inv.
	*
	* @return the stato of this stato rich bene inv
	*/
	@Override
	public java.lang.String getStato() {
		return _statoRichBeneInv.getStato();
	}

	@Override
	public java.lang.String toString() {
		return _statoRichBeneInv.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statoRichBeneInv.toXmlString();
	}

	/**
	* Returns the ID of this stato rich bene inv.
	*
	* @return the ID of this stato rich bene inv
	*/
	@Override
	public long getId() {
		return _statoRichBeneInv.getId();
	}

	/**
	* Returns the primary key of this stato rich bene inv.
	*
	* @return the primary key of this stato rich bene inv
	*/
	@Override
	public long getPrimaryKey() {
		return _statoRichBeneInv.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.StatoRichBeneInv toEscapedModel() {
		return new StatoRichBeneInvWrapper(_statoRichBeneInv.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.StatoRichBeneInv toUnescapedModel() {
		return new StatoRichBeneInvWrapper(_statoRichBeneInv.toUnescapedModel());
	}

	@Override
	public void persist() {
		_statoRichBeneInv.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statoRichBeneInv.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_statoRichBeneInv.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_statoRichBeneInv.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_statoRichBeneInv.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this stato rich bene inv.
	*
	* @param id the ID of this stato rich bene inv
	*/
	@Override
	public void setId(long id) {
		_statoRichBeneInv.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_statoRichBeneInv.setNew(n);
	}

	/**
	* Sets the primary key of this stato rich bene inv.
	*
	* @param primaryKey the primary key of this stato rich bene inv
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statoRichBeneInv.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_statoRichBeneInv.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the stato of this stato rich bene inv.
	*
	* @param stato the stato of this stato rich bene inv
	*/
	@Override
	public void setStato(java.lang.String stato) {
		_statoRichBeneInv.setStato(stato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoRichBeneInvWrapper)) {
			return false;
		}

		StatoRichBeneInvWrapper statoRichBeneInvWrapper = (StatoRichBeneInvWrapper)obj;

		if (Objects.equals(_statoRichBeneInv,
					statoRichBeneInvWrapper._statoRichBeneInv)) {
			return true;
		}

		return false;
	}

	@Override
	public StatoRichBeneInv getWrappedModel() {
		return _statoRichBeneInv;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _statoRichBeneInv.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _statoRichBeneInv.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_statoRichBeneInv.resetOriginalValues();
	}

	private final StatoRichBeneInv _statoRichBeneInv;
}