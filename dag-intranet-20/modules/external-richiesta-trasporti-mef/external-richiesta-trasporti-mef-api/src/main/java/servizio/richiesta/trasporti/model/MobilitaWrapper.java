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

package servizio.richiesta.trasporti.model;

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
 * This class is a wrapper for {@link Mobilita}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Mobilita
 * @generated
 */
@ProviderType
public class MobilitaWrapper implements Mobilita, ModelWrapper<Mobilita> {
	public MobilitaWrapper(Mobilita mobilita) {
		_mobilita = mobilita;
	}

	@Override
	public Class<?> getModelClass() {
		return Mobilita.class;
	}

	@Override
	public String getModelClassName() {
		return Mobilita.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("custom_key", getCustom_key());
		attributes.put("person_id", getPerson_id());
		attributes.put("tipo_mobilita", getTipo_mobilita());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String custom_key = (String)attributes.get("custom_key");

		if (custom_key != null) {
			setCustom_key(custom_key);
		}

		Long person_id = (Long)attributes.get("person_id");

		if (person_id != null) {
			setPerson_id(person_id);
		}

		String tipo_mobilita = (String)attributes.get("tipo_mobilita");

		if (tipo_mobilita != null) {
			setTipo_mobilita(tipo_mobilita);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _mobilita.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _mobilita.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _mobilita.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _mobilita.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.richiesta.trasporti.model.Mobilita> toCacheModel() {
		return _mobilita.toCacheModel();
	}

	@Override
	public int compareTo(servizio.richiesta.trasporti.model.Mobilita mobilita) {
		return _mobilita.compareTo(mobilita);
	}

	@Override
	public int hashCode() {
		return _mobilita.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mobilita.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new MobilitaWrapper((Mobilita)_mobilita.clone());
	}

	/**
	* Returns the custom_key of this mobilita.
	*
	* @return the custom_key of this mobilita
	*/
	@Override
	public java.lang.String getCustom_key() {
		return _mobilita.getCustom_key();
	}

	/**
	* Returns the primary key of this mobilita.
	*
	* @return the primary key of this mobilita
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _mobilita.getPrimaryKey();
	}

	/**
	* Returns the tipo_mobilita of this mobilita.
	*
	* @return the tipo_mobilita of this mobilita
	*/
	@Override
	public java.lang.String getTipo_mobilita() {
		return _mobilita.getTipo_mobilita();
	}

	@Override
	public java.lang.String toString() {
		return _mobilita.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _mobilita.toXmlString();
	}

	/**
	* Returns the person_id of this mobilita.
	*
	* @return the person_id of this mobilita
	*/
	@Override
	public long getPerson_id() {
		return _mobilita.getPerson_id();
	}

	@Override
	public servizio.richiesta.trasporti.model.Mobilita toEscapedModel() {
		return new MobilitaWrapper(_mobilita.toEscapedModel());
	}

	@Override
	public servizio.richiesta.trasporti.model.Mobilita toUnescapedModel() {
		return new MobilitaWrapper(_mobilita.toUnescapedModel());
	}

	@Override
	public void persist() {
		_mobilita.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mobilita.setCachedModel(cachedModel);
	}

	/**
	* Sets the custom_key of this mobilita.
	*
	* @param custom_key the custom_key of this mobilita
	*/
	@Override
	public void setCustom_key(java.lang.String custom_key) {
		_mobilita.setCustom_key(custom_key);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_mobilita.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_mobilita.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_mobilita.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_mobilita.setNew(n);
	}

	/**
	* Sets the person_id of this mobilita.
	*
	* @param person_id the person_id of this mobilita
	*/
	@Override
	public void setPerson_id(long person_id) {
		_mobilita.setPerson_id(person_id);
	}

	/**
	* Sets the primary key of this mobilita.
	*
	* @param primaryKey the primary key of this mobilita
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_mobilita.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_mobilita.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tipo_mobilita of this mobilita.
	*
	* @param tipo_mobilita the tipo_mobilita of this mobilita
	*/
	@Override
	public void setTipo_mobilita(java.lang.String tipo_mobilita) {
		_mobilita.setTipo_mobilita(tipo_mobilita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MobilitaWrapper)) {
			return false;
		}

		MobilitaWrapper mobilitaWrapper = (MobilitaWrapper)obj;

		if (Objects.equals(_mobilita, mobilitaWrapper._mobilita)) {
			return true;
		}

		return false;
	}

	@Override
	public Mobilita getWrappedModel() {
		return _mobilita;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _mobilita.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _mobilita.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_mobilita.resetOriginalValues();
	}

	private final Mobilita _mobilita;
}