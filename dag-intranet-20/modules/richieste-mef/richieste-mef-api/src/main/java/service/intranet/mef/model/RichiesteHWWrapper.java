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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link RichiesteHW}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteHW
 * @generated
 */
@ProviderType
public class RichiesteHWWrapper implements RichiesteHW,
	ModelWrapper<RichiesteHW> {
	public RichiesteHWWrapper(RichiesteHW richiesteHW) {
		_richiesteHW = richiesteHW;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiesteHW.class;
	}

	@Override
	public String getModelClassName() {
		return RichiesteHW.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_richieste_hw", getId_richieste_hw());
		attributes.put("utente", getUtente());
		attributes.put("dettaglio", getDettaglio());
		attributes.put("data_richiesta", getData_richiesta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_richieste_hw = (Long)attributes.get("id_richieste_hw");

		if (id_richieste_hw != null) {
			setId_richieste_hw(id_richieste_hw);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		String dettaglio = (String)attributes.get("dettaglio");

		if (dettaglio != null) {
			setDettaglio(dettaglio);
		}

		Date data_richiesta = (Date)attributes.get("data_richiesta");

		if (data_richiesta != null) {
			setData_richiesta(data_richiesta);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _richiesteHW.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiesteHW.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiesteHW.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiesteHW.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.RichiesteHW> toCacheModel() {
		return _richiesteHW.toCacheModel();
	}

	@Override
	public int compareTo(service.intranet.mef.model.RichiesteHW richiesteHW) {
		return _richiesteHW.compareTo(richiesteHW);
	}

	@Override
	public int hashCode() {
		return _richiesteHW.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiesteHW.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiesteHWWrapper((RichiesteHW)_richiesteHW.clone());
	}

	/**
	* Returns the dettaglio of this richieste h w.
	*
	* @return the dettaglio of this richieste h w
	*/
	@Override
	public java.lang.String getDettaglio() {
		return _richiesteHW.getDettaglio();
	}

	/**
	* Returns the utente of this richieste h w.
	*
	* @return the utente of this richieste h w
	*/
	@Override
	public java.lang.String getUtente() {
		return _richiesteHW.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _richiesteHW.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiesteHW.toXmlString();
	}

	/**
	* Returns the data_richiesta of this richieste h w.
	*
	* @return the data_richiesta of this richieste h w
	*/
	@Override
	public Date getData_richiesta() {
		return _richiesteHW.getData_richiesta();
	}

	/**
	* Returns the id_richieste_hw of this richieste h w.
	*
	* @return the id_richieste_hw of this richieste h w
	*/
	@Override
	public long getId_richieste_hw() {
		return _richiesteHW.getId_richieste_hw();
	}

	/**
	* Returns the primary key of this richieste h w.
	*
	* @return the primary key of this richieste h w
	*/
	@Override
	public long getPrimaryKey() {
		return _richiesteHW.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.RichiesteHW toEscapedModel() {
		return new RichiesteHWWrapper(_richiesteHW.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.RichiesteHW toUnescapedModel() {
		return new RichiesteHWWrapper(_richiesteHW.toUnescapedModel());
	}

	@Override
	public void persist() {
		_richiesteHW.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiesteHW.setCachedModel(cachedModel);
	}

	/**
	* Sets the data_richiesta of this richieste h w.
	*
	* @param data_richiesta the data_richiesta of this richieste h w
	*/
	@Override
	public void setData_richiesta(Date data_richiesta) {
		_richiesteHW.setData_richiesta(data_richiesta);
	}

	/**
	* Sets the dettaglio of this richieste h w.
	*
	* @param dettaglio the dettaglio of this richieste h w
	*/
	@Override
	public void setDettaglio(java.lang.String dettaglio) {
		_richiesteHW.setDettaglio(dettaglio);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiesteHW.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiesteHW.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiesteHW.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_richieste_hw of this richieste h w.
	*
	* @param id_richieste_hw the id_richieste_hw of this richieste h w
	*/
	@Override
	public void setId_richieste_hw(long id_richieste_hw) {
		_richiesteHW.setId_richieste_hw(id_richieste_hw);
	}

	@Override
	public void setNew(boolean n) {
		_richiesteHW.setNew(n);
	}

	/**
	* Sets the primary key of this richieste h w.
	*
	* @param primaryKey the primary key of this richieste h w
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiesteHW.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiesteHW.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the utente of this richieste h w.
	*
	* @param utente the utente of this richieste h w
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_richiesteHW.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteHWWrapper)) {
			return false;
		}

		RichiesteHWWrapper richiesteHWWrapper = (RichiesteHWWrapper)obj;

		if (Objects.equals(_richiesteHW, richiesteHWWrapper._richiesteHW)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiesteHW getWrappedModel() {
		return _richiesteHW;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiesteHW.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiesteHW.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiesteHW.resetOriginalValues();
	}

	private final RichiesteHW _richiesteHW;
}