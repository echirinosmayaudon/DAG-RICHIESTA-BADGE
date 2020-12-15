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

package servizio.prenotazione.aule.servizi.mef.model;

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
 * This class is a wrapper for {@link StrumEvento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumEvento
 * @generated
 */
@ProviderType
public class StrumEventoWrapper implements StrumEvento,
	ModelWrapper<StrumEvento> {
	public StrumEventoWrapper(StrumEvento strumEvento) {
		_strumEvento = strumEvento;
	}

	@Override
	public Class<?> getModelClass() {
		return StrumEvento.class;
	}

	@Override
	public String getModelClassName() {
		return StrumEvento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_strum", getId_strum());
		attributes.put("id_sala", getId_sala());
		attributes.put("email_ref", getEmail_ref());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_strum = (Long)attributes.get("id_strum");

		if (id_strum != null) {
			setId_strum(id_strum);
		}

		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		String email_ref = (String)attributes.get("email_ref");

		if (email_ref != null) {
			setEmail_ref(email_ref);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _strumEvento.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _strumEvento.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _strumEvento.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _strumEvento.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.servizi.mef.model.StrumEvento> toCacheModel() {
		return _strumEvento.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.servizi.mef.model.StrumEvento strumEvento) {
		return _strumEvento.compareTo(strumEvento);
	}

	@Override
	public int hashCode() {
		return _strumEvento.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _strumEvento.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StrumEventoWrapper((StrumEvento)_strumEvento.clone());
	}

	/**
	* Returns the email_ref of this strum evento.
	*
	* @return the email_ref of this strum evento
	*/
	@Override
	public java.lang.String getEmail_ref() {
		return _strumEvento.getEmail_ref();
	}

	@Override
	public java.lang.String toString() {
		return _strumEvento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _strumEvento.toXmlString();
	}

	/**
	* Returns the id_sala of this strum evento.
	*
	* @return the id_sala of this strum evento
	*/
	@Override
	public long getId_sala() {
		return _strumEvento.getId_sala();
	}

	/**
	* Returns the id_strum of this strum evento.
	*
	* @return the id_strum of this strum evento
	*/
	@Override
	public long getId_strum() {
		return _strumEvento.getId_strum();
	}

	@Override
	public servizio.prenotazione.aule.servizi.mef.model.StrumEvento toEscapedModel() {
		return new StrumEventoWrapper(_strumEvento.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.servizi.mef.model.StrumEvento toUnescapedModel() {
		return new StrumEventoWrapper(_strumEvento.toUnescapedModel());
	}

	/**
	* Returns the primary key of this strum evento.
	*
	* @return the primary key of this strum evento
	*/
	@Override
	public servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK getPrimaryKey() {
		return _strumEvento.getPrimaryKey();
	}

	@Override
	public void persist() {
		_strumEvento.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_strumEvento.setCachedModel(cachedModel);
	}

	/**
	* Sets the email_ref of this strum evento.
	*
	* @param email_ref the email_ref of this strum evento
	*/
	@Override
	public void setEmail_ref(java.lang.String email_ref) {
		_strumEvento.setEmail_ref(email_ref);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_strumEvento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_strumEvento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_strumEvento.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_sala of this strum evento.
	*
	* @param id_sala the id_sala of this strum evento
	*/
	@Override
	public void setId_sala(long id_sala) {
		_strumEvento.setId_sala(id_sala);
	}

	/**
	* Sets the id_strum of this strum evento.
	*
	* @param id_strum the id_strum of this strum evento
	*/
	@Override
	public void setId_strum(long id_strum) {
		_strumEvento.setId_strum(id_strum);
	}

	@Override
	public void setNew(boolean n) {
		_strumEvento.setNew(n);
	}

	/**
	* Sets the primary key of this strum evento.
	*
	* @param primaryKey the primary key of this strum evento
	*/
	@Override
	public void setPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK primaryKey) {
		_strumEvento.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_strumEvento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumEventoWrapper)) {
			return false;
		}

		StrumEventoWrapper strumEventoWrapper = (StrumEventoWrapper)obj;

		if (Objects.equals(_strumEvento, strumEventoWrapper._strumEvento)) {
			return true;
		}

		return false;
	}

	@Override
	public StrumEvento getWrappedModel() {
		return _strumEvento;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _strumEvento.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _strumEvento.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_strumEvento.resetOriginalValues();
	}

	private final StrumEvento _strumEvento;
}