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
 * This class is a wrapper for {@link TipologiaComputer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComputer
 * @generated
 */
@ProviderType
public class TipologiaComputerWrapper implements TipologiaComputer,
	ModelWrapper<TipologiaComputer> {
	public TipologiaComputerWrapper(TipologiaComputer tipologiaComputer) {
		_tipologiaComputer = tipologiaComputer;
	}

	@Override
	public Class<?> getModelClass() {
		return TipologiaComputer.class;
	}

	@Override
	public String getModelClassName() {
		return TipologiaComputer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_tipologia_computer", getId_tipologia_computer());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_tipologia_computer = (Long)attributes.get(
				"id_tipologia_computer");

		if (id_tipologia_computer != null) {
			setId_tipologia_computer(id_tipologia_computer);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _tipologiaComputer.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipologiaComputer.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipologiaComputer.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipologiaComputer.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.TipologiaComputer> toCacheModel() {
		return _tipologiaComputer.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.TipologiaComputer tipologiaComputer) {
		return _tipologiaComputer.compareTo(tipologiaComputer);
	}

	@Override
	public int hashCode() {
		return _tipologiaComputer.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipologiaComputer.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipologiaComputerWrapper((TipologiaComputer)_tipologiaComputer.clone());
	}

	/**
	* Returns the descrizione of this tipologia computer.
	*
	* @return the descrizione of this tipologia computer
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _tipologiaComputer.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _tipologiaComputer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipologiaComputer.toXmlString();
	}

	/**
	* Returns the id_tipologia_computer of this tipologia computer.
	*
	* @return the id_tipologia_computer of this tipologia computer
	*/
	@Override
	public long getId_tipologia_computer() {
		return _tipologiaComputer.getId_tipologia_computer();
	}

	/**
	* Returns the primary key of this tipologia computer.
	*
	* @return the primary key of this tipologia computer
	*/
	@Override
	public long getPrimaryKey() {
		return _tipologiaComputer.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.TipologiaComputer toEscapedModel() {
		return new TipologiaComputerWrapper(_tipologiaComputer.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.TipologiaComputer toUnescapedModel() {
		return new TipologiaComputerWrapper(_tipologiaComputer.toUnescapedModel());
	}

	@Override
	public void persist() {
		_tipologiaComputer.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipologiaComputer.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this tipologia computer.
	*
	* @param descrizione the descrizione of this tipologia computer
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_tipologiaComputer.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipologiaComputer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipologiaComputer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipologiaComputer.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_tipologia_computer of this tipologia computer.
	*
	* @param id_tipologia_computer the id_tipologia_computer of this tipologia computer
	*/
	@Override
	public void setId_tipologia_computer(long id_tipologia_computer) {
		_tipologiaComputer.setId_tipologia_computer(id_tipologia_computer);
	}

	@Override
	public void setNew(boolean n) {
		_tipologiaComputer.setNew(n);
	}

	/**
	* Sets the primary key of this tipologia computer.
	*
	* @param primaryKey the primary key of this tipologia computer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipologiaComputer.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipologiaComputer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipologiaComputerWrapper)) {
			return false;
		}

		TipologiaComputerWrapper tipologiaComputerWrapper = (TipologiaComputerWrapper)obj;

		if (Objects.equals(_tipologiaComputer,
					tipologiaComputerWrapper._tipologiaComputer)) {
			return true;
		}

		return false;
	}

	@Override
	public TipologiaComputer getWrappedModel() {
		return _tipologiaComputer;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipologiaComputer.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipologiaComputer.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipologiaComputer.resetOriginalValues();
	}

	private final TipologiaComputer _tipologiaComputer;
}