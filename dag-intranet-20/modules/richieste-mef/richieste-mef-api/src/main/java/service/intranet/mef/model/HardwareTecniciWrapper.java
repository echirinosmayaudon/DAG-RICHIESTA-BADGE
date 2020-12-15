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
 * This class is a wrapper for {@link HardwareTecnici}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HardwareTecnici
 * @generated
 */
@ProviderType
public class HardwareTecniciWrapper implements HardwareTecnici,
	ModelWrapper<HardwareTecnici> {
	public HardwareTecniciWrapper(HardwareTecnici hardwareTecnici) {
		_hardwareTecnici = hardwareTecnici;
	}

	@Override
	public Class<?> getModelClass() {
		return HardwareTecnici.class;
	}

	@Override
	public String getModelClassName() {
		return HardwareTecnici.class.getName();
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
		return _hardwareTecnici.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _hardwareTecnici.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _hardwareTecnici.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _hardwareTecnici.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.HardwareTecnici> toCacheModel() {
		return _hardwareTecnici.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.HardwareTecnici hardwareTecnici) {
		return _hardwareTecnici.compareTo(hardwareTecnici);
	}

	@Override
	public int hashCode() {
		return _hardwareTecnici.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hardwareTecnici.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new HardwareTecniciWrapper((HardwareTecnici)_hardwareTecnici.clone());
	}

	/**
	* Returns the descrizione of this hardware tecnici.
	*
	* @return the descrizione of this hardware tecnici
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _hardwareTecnici.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _hardwareTecnici.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _hardwareTecnici.toXmlString();
	}

	/**
	* Returns the ID of this hardware tecnici.
	*
	* @return the ID of this hardware tecnici
	*/
	@Override
	public long getId() {
		return _hardwareTecnici.getId();
	}

	/**
	* Returns the primary key of this hardware tecnici.
	*
	* @return the primary key of this hardware tecnici
	*/
	@Override
	public long getPrimaryKey() {
		return _hardwareTecnici.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.HardwareTecnici toEscapedModel() {
		return new HardwareTecniciWrapper(_hardwareTecnici.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.HardwareTecnici toUnescapedModel() {
		return new HardwareTecniciWrapper(_hardwareTecnici.toUnescapedModel());
	}

	@Override
	public void persist() {
		_hardwareTecnici.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_hardwareTecnici.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this hardware tecnici.
	*
	* @param descrizione the descrizione of this hardware tecnici
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_hardwareTecnici.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_hardwareTecnici.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_hardwareTecnici.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_hardwareTecnici.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this hardware tecnici.
	*
	* @param id the ID of this hardware tecnici
	*/
	@Override
	public void setId(long id) {
		_hardwareTecnici.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_hardwareTecnici.setNew(n);
	}

	/**
	* Sets the primary key of this hardware tecnici.
	*
	* @param primaryKey the primary key of this hardware tecnici
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_hardwareTecnici.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_hardwareTecnici.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HardwareTecniciWrapper)) {
			return false;
		}

		HardwareTecniciWrapper hardwareTecniciWrapper = (HardwareTecniciWrapper)obj;

		if (Objects.equals(_hardwareTecnici,
					hardwareTecniciWrapper._hardwareTecnici)) {
			return true;
		}

		return false;
	}

	@Override
	public HardwareTecnici getWrappedModel() {
		return _hardwareTecnici;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _hardwareTecnici.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _hardwareTecnici.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_hardwareTecnici.resetOriginalValues();
	}

	private final HardwareTecnici _hardwareTecnici;
}