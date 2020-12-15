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
 * This class is a wrapper for {@link StrumentoEvento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoEvento
 * @generated
 */
@ProviderType
public class StrumentoEventoWrapper implements StrumentoEvento,
	ModelWrapper<StrumentoEvento> {
	public StrumentoEventoWrapper(StrumentoEvento strumentoEvento) {
		_strumentoEvento = strumentoEvento;
	}

	@Override
	public Class<?> getModelClass() {
		return StrumentoEvento.class;
	}

	@Override
	public String getModelClassName() {
		return StrumentoEvento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_strumento", getId_strumento());
		attributes.put("desc_strumento", getDesc_strumento());
		attributes.put("email_ref", getEmail_ref());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_strumento = (Long)attributes.get("id_strumento");

		if (id_strumento != null) {
			setId_strumento(id_strumento);
		}

		String desc_strumento = (String)attributes.get("desc_strumento");

		if (desc_strumento != null) {
			setDesc_strumento(desc_strumento);
		}

		String email_ref = (String)attributes.get("email_ref");

		if (email_ref != null) {
			setEmail_ref(email_ref);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _strumentoEvento.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _strumentoEvento.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _strumentoEvento.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _strumentoEvento.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.StrumentoEvento> toCacheModel() {
		return _strumentoEvento.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.StrumentoEvento strumentoEvento) {
		return _strumentoEvento.compareTo(strumentoEvento);
	}

	@Override
	public int hashCode() {
		return _strumentoEvento.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _strumentoEvento.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StrumentoEventoWrapper((StrumentoEvento)_strumentoEvento.clone());
	}

	/**
	* Returns the desc_strumento of this strumento evento.
	*
	* @return the desc_strumento of this strumento evento
	*/
	@Override
	public java.lang.String getDesc_strumento() {
		return _strumentoEvento.getDesc_strumento();
	}

	/**
	* Returns the email_ref of this strumento evento.
	*
	* @return the email_ref of this strumento evento
	*/
	@Override
	public java.lang.String getEmail_ref() {
		return _strumentoEvento.getEmail_ref();
	}

	@Override
	public java.lang.String toString() {
		return _strumentoEvento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _strumentoEvento.toXmlString();
	}

	/**
	* Returns the id_strumento of this strumento evento.
	*
	* @return the id_strumento of this strumento evento
	*/
	@Override
	public long getId_strumento() {
		return _strumentoEvento.getId_strumento();
	}

	/**
	* Returns the primary key of this strumento evento.
	*
	* @return the primary key of this strumento evento
	*/
	@Override
	public long getPrimaryKey() {
		return _strumentoEvento.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento toEscapedModel() {
		return new StrumentoEventoWrapper(_strumentoEvento.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento toUnescapedModel() {
		return new StrumentoEventoWrapper(_strumentoEvento.toUnescapedModel());
	}

	@Override
	public void persist() {
		_strumentoEvento.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_strumentoEvento.setCachedModel(cachedModel);
	}

	/**
	* Sets the desc_strumento of this strumento evento.
	*
	* @param desc_strumento the desc_strumento of this strumento evento
	*/
	@Override
	public void setDesc_strumento(java.lang.String desc_strumento) {
		_strumentoEvento.setDesc_strumento(desc_strumento);
	}

	/**
	* Sets the email_ref of this strumento evento.
	*
	* @param email_ref the email_ref of this strumento evento
	*/
	@Override
	public void setEmail_ref(java.lang.String email_ref) {
		_strumentoEvento.setEmail_ref(email_ref);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_strumentoEvento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_strumentoEvento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_strumentoEvento.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_strumento of this strumento evento.
	*
	* @param id_strumento the id_strumento of this strumento evento
	*/
	@Override
	public void setId_strumento(long id_strumento) {
		_strumentoEvento.setId_strumento(id_strumento);
	}

	@Override
	public void setNew(boolean n) {
		_strumentoEvento.setNew(n);
	}

	/**
	* Sets the primary key of this strumento evento.
	*
	* @param primaryKey the primary key of this strumento evento
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_strumentoEvento.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_strumentoEvento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumentoEventoWrapper)) {
			return false;
		}

		StrumentoEventoWrapper strumentoEventoWrapper = (StrumentoEventoWrapper)obj;

		if (Objects.equals(_strumentoEvento,
					strumentoEventoWrapper._strumentoEvento)) {
			return true;
		}

		return false;
	}

	@Override
	public StrumentoEvento getWrappedModel() {
		return _strumentoEvento;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _strumentoEvento.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _strumentoEvento.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_strumentoEvento.resetOriginalValues();
	}

	private final StrumentoEvento _strumentoEvento;
}