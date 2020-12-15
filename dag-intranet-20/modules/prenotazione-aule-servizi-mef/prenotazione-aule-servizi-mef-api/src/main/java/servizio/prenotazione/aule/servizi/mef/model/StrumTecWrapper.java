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
 * This class is a wrapper for {@link StrumTec}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumTec
 * @generated
 */
@ProviderType
public class StrumTecWrapper implements StrumTec, ModelWrapper<StrumTec> {
	public StrumTecWrapper(StrumTec strumTec) {
		_strumTec = strumTec;
	}

	@Override
	public Class<?> getModelClass() {
		return StrumTec.class;
	}

	@Override
	public String getModelClassName() {
		return StrumTec.class.getName();
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
		return _strumTec.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _strumTec.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _strumTec.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _strumTec.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.servizi.mef.model.StrumTec> toCacheModel() {
		return _strumTec.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.servizi.mef.model.StrumTec strumTec) {
		return _strumTec.compareTo(strumTec);
	}

	@Override
	public int hashCode() {
		return _strumTec.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _strumTec.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StrumTecWrapper((StrumTec)_strumTec.clone());
	}

	/**
	* Returns the email_ref of this strum tec.
	*
	* @return the email_ref of this strum tec
	*/
	@Override
	public java.lang.String getEmail_ref() {
		return _strumTec.getEmail_ref();
	}

	@Override
	public java.lang.String toString() {
		return _strumTec.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _strumTec.toXmlString();
	}

	/**
	* Returns the id_sala of this strum tec.
	*
	* @return the id_sala of this strum tec
	*/
	@Override
	public long getId_sala() {
		return _strumTec.getId_sala();
	}

	/**
	* Returns the id_strum of this strum tec.
	*
	* @return the id_strum of this strum tec
	*/
	@Override
	public long getId_strum() {
		return _strumTec.getId_strum();
	}

	@Override
	public servizio.prenotazione.aule.servizi.mef.model.StrumTec toEscapedModel() {
		return new StrumTecWrapper(_strumTec.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.servizi.mef.model.StrumTec toUnescapedModel() {
		return new StrumTecWrapper(_strumTec.toUnescapedModel());
	}

	/**
	* Returns the primary key of this strum tec.
	*
	* @return the primary key of this strum tec
	*/
	@Override
	public servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK getPrimaryKey() {
		return _strumTec.getPrimaryKey();
	}

	@Override
	public void persist() {
		_strumTec.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_strumTec.setCachedModel(cachedModel);
	}

	/**
	* Sets the email_ref of this strum tec.
	*
	* @param email_ref the email_ref of this strum tec
	*/
	@Override
	public void setEmail_ref(java.lang.String email_ref) {
		_strumTec.setEmail_ref(email_ref);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_strumTec.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_strumTec.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_strumTec.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_sala of this strum tec.
	*
	* @param id_sala the id_sala of this strum tec
	*/
	@Override
	public void setId_sala(long id_sala) {
		_strumTec.setId_sala(id_sala);
	}

	/**
	* Sets the id_strum of this strum tec.
	*
	* @param id_strum the id_strum of this strum tec
	*/
	@Override
	public void setId_strum(long id_strum) {
		_strumTec.setId_strum(id_strum);
	}

	@Override
	public void setNew(boolean n) {
		_strumTec.setNew(n);
	}

	/**
	* Sets the primary key of this strum tec.
	*
	* @param primaryKey the primary key of this strum tec
	*/
	@Override
	public void setPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK primaryKey) {
		_strumTec.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_strumTec.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumTecWrapper)) {
			return false;
		}

		StrumTecWrapper strumTecWrapper = (StrumTecWrapper)obj;

		if (Objects.equals(_strumTec, strumTecWrapper._strumTec)) {
			return true;
		}

		return false;
	}

	@Override
	public StrumTec getWrappedModel() {
		return _strumTec;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _strumTec.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _strumTec.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_strumTec.resetOriginalValues();
	}

	private final StrumTec _strumTec;
}