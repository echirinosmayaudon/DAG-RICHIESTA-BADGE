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

package servizio.prenotazione.aule.mef.model;

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
 * This class is a wrapper for {@link TipoEvento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoEvento
 * @generated
 */
@ProviderType
public class TipoEventoWrapper implements TipoEvento, ModelWrapper<TipoEvento> {
	public TipoEventoWrapper(TipoEvento tipoEvento) {
		_tipoEvento = tipoEvento;
	}

	@Override
	public Class<?> getModelClass() {
		return TipoEvento.class;
	}

	@Override
	public String getModelClassName() {
		return TipoEvento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_evento", getId_evento());
		attributes.put("desc_evento", getDesc_evento());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_evento = (Long)attributes.get("id_evento");

		if (id_evento != null) {
			setId_evento(id_evento);
		}

		String desc_evento = (String)attributes.get("desc_evento");

		if (desc_evento != null) {
			setDesc_evento(desc_evento);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _tipoEvento.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipoEvento.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipoEvento.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipoEvento.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.TipoEvento> toCacheModel() {
		return _tipoEvento.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.TipoEvento tipoEvento) {
		return _tipoEvento.compareTo(tipoEvento);
	}

	@Override
	public int hashCode() {
		return _tipoEvento.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipoEvento.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipoEventoWrapper((TipoEvento)_tipoEvento.clone());
	}

	/**
	* Returns the desc_evento of this tipo evento.
	*
	* @return the desc_evento of this tipo evento
	*/
	@Override
	public java.lang.String getDesc_evento() {
		return _tipoEvento.getDesc_evento();
	}

	@Override
	public java.lang.String toString() {
		return _tipoEvento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipoEvento.toXmlString();
	}

	/**
	* Returns the id_evento of this tipo evento.
	*
	* @return the id_evento of this tipo evento
	*/
	@Override
	public long getId_evento() {
		return _tipoEvento.getId_evento();
	}

	/**
	* Returns the primary key of this tipo evento.
	*
	* @return the primary key of this tipo evento
	*/
	@Override
	public long getPrimaryKey() {
		return _tipoEvento.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento toEscapedModel() {
		return new TipoEventoWrapper(_tipoEvento.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento toUnescapedModel() {
		return new TipoEventoWrapper(_tipoEvento.toUnescapedModel());
	}

	@Override
	public void persist() {
		_tipoEvento.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipoEvento.setCachedModel(cachedModel);
	}

	/**
	* Sets the desc_evento of this tipo evento.
	*
	* @param desc_evento the desc_evento of this tipo evento
	*/
	@Override
	public void setDesc_evento(java.lang.String desc_evento) {
		_tipoEvento.setDesc_evento(desc_evento);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipoEvento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipoEvento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipoEvento.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_evento of this tipo evento.
	*
	* @param id_evento the id_evento of this tipo evento
	*/
	@Override
	public void setId_evento(long id_evento) {
		_tipoEvento.setId_evento(id_evento);
	}

	@Override
	public void setNew(boolean n) {
		_tipoEvento.setNew(n);
	}

	/**
	* Sets the primary key of this tipo evento.
	*
	* @param primaryKey the primary key of this tipo evento
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipoEvento.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipoEvento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoEventoWrapper)) {
			return false;
		}

		TipoEventoWrapper tipoEventoWrapper = (TipoEventoWrapper)obj;

		if (Objects.equals(_tipoEvento, tipoEventoWrapper._tipoEvento)) {
			return true;
		}

		return false;
	}

	@Override
	public TipoEvento getWrappedModel() {
		return _tipoEvento;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipoEvento.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipoEvento.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipoEvento.resetOriginalValues();
	}

	private final TipoEvento _tipoEvento;
}