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

package com.intranet.mef.logicaldel.gestione.riunioni.model;

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
 * This class is a wrapper for {@link CancelAmmConv}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConv
 * @generated
 */
@ProviderType
public class CancelAmmConvWrapper implements CancelAmmConv,
	ModelWrapper<CancelAmmConv> {
	public CancelAmmConvWrapper(CancelAmmConv cancelAmmConv) {
		_cancelAmmConv = cancelAmmConv;
	}

	@Override
	public Class<?> getModelClass() {
		return CancelAmmConv.class;
	}

	@Override
	public String getModelClassName() {
		return CancelAmmConv.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_amministrazione_convocante",
			getId_amministrazione_convocante());
		attributes.put("cancellato", getCancellato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_amministrazione_convocante = (Long)attributes.get(
				"id_amministrazione_convocante");

		if (id_amministrazione_convocante != null) {
			setId_amministrazione_convocante(id_amministrazione_convocante);
		}

		Boolean cancellato = (Boolean)attributes.get("cancellato");

		if (cancellato != null) {
			setCancellato(cancellato);
		}
	}

	@Override
	public CancelAmmConv toEscapedModel() {
		return new CancelAmmConvWrapper(_cancelAmmConv.toEscapedModel());
	}

	@Override
	public CancelAmmConv toUnescapedModel() {
		return new CancelAmmConvWrapper(_cancelAmmConv.toUnescapedModel());
	}

	/**
	* Returns the cancellato of this cancel amm conv.
	*
	* @return the cancellato of this cancel amm conv
	*/
	@Override
	public boolean getCancellato() {
		return _cancelAmmConv.getCancellato();
	}

	@Override
	public boolean isCachedModel() {
		return _cancelAmmConv.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this cancel amm conv is cancellato.
	*
	* @return <code>true</code> if this cancel amm conv is cancellato; <code>false</code> otherwise
	*/
	@Override
	public boolean isCancellato() {
		return _cancelAmmConv.isCancellato();
	}

	@Override
	public boolean isEscapedModel() {
		return _cancelAmmConv.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cancelAmmConv.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cancelAmmConv.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CancelAmmConv> toCacheModel() {
		return _cancelAmmConv.toCacheModel();
	}

	@Override
	public int compareTo(CancelAmmConv cancelAmmConv) {
		return _cancelAmmConv.compareTo(cancelAmmConv);
	}

	@Override
	public int hashCode() {
		return _cancelAmmConv.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cancelAmmConv.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CancelAmmConvWrapper((CancelAmmConv)_cancelAmmConv.clone());
	}

	@Override
	public java.lang.String toString() {
		return _cancelAmmConv.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cancelAmmConv.toXmlString();
	}

	/**
	* Returns the id_amministrazione_convocante of this cancel amm conv.
	*
	* @return the id_amministrazione_convocante of this cancel amm conv
	*/
	@Override
	public long getId_amministrazione_convocante() {
		return _cancelAmmConv.getId_amministrazione_convocante();
	}

	/**
	* Returns the primary key of this cancel amm conv.
	*
	* @return the primary key of this cancel amm conv
	*/
	@Override
	public long getPrimaryKey() {
		return _cancelAmmConv.getPrimaryKey();
	}

	@Override
	public void persist() {
		_cancelAmmConv.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cancelAmmConv.setCachedModel(cachedModel);
	}

	/**
	* Sets whether this cancel amm conv is cancellato.
	*
	* @param cancellato the cancellato of this cancel amm conv
	*/
	@Override
	public void setCancellato(boolean cancellato) {
		_cancelAmmConv.setCancellato(cancellato);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cancelAmmConv.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cancelAmmConv.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cancelAmmConv.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_amministrazione_convocante of this cancel amm conv.
	*
	* @param id_amministrazione_convocante the id_amministrazione_convocante of this cancel amm conv
	*/
	@Override
	public void setId_amministrazione_convocante(
		long id_amministrazione_convocante) {
		_cancelAmmConv.setId_amministrazione_convocante(id_amministrazione_convocante);
	}

	@Override
	public void setNew(boolean n) {
		_cancelAmmConv.setNew(n);
	}

	/**
	* Sets the primary key of this cancel amm conv.
	*
	* @param primaryKey the primary key of this cancel amm conv
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cancelAmmConv.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cancelAmmConv.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CancelAmmConvWrapper)) {
			return false;
		}

		CancelAmmConvWrapper cancelAmmConvWrapper = (CancelAmmConvWrapper)obj;

		if (Objects.equals(_cancelAmmConv, cancelAmmConvWrapper._cancelAmmConv)) {
			return true;
		}

		return false;
	}

	@Override
	public CancelAmmConv getWrappedModel() {
		return _cancelAmmConv;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cancelAmmConv.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cancelAmmConv.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cancelAmmConv.resetOriginalValues();
	}

	private final CancelAmmConv _cancelAmmConv;
}