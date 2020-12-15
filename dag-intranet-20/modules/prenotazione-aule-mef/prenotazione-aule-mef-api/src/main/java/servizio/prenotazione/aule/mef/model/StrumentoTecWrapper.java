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
 * This class is a wrapper for {@link StrumentoTec}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTec
 * @generated
 */
@ProviderType
public class StrumentoTecWrapper implements StrumentoTec,
	ModelWrapper<StrumentoTec> {
	public StrumentoTecWrapper(StrumentoTec strumentoTec) {
		_strumentoTec = strumentoTec;
	}

	@Override
	public Class<?> getModelClass() {
		return StrumentoTec.class;
	}

	@Override
	public String getModelClassName() {
		return StrumentoTec.class.getName();
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
		return _strumentoTec.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _strumentoTec.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _strumentoTec.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _strumentoTec.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.StrumentoTec> toCacheModel() {
		return _strumentoTec.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.StrumentoTec strumentoTec) {
		return _strumentoTec.compareTo(strumentoTec);
	}

	@Override
	public int hashCode() {
		return _strumentoTec.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _strumentoTec.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StrumentoTecWrapper((StrumentoTec)_strumentoTec.clone());
	}

	/**
	* Returns the desc_strumento of this strumento tec.
	*
	* @return the desc_strumento of this strumento tec
	*/
	@Override
	public java.lang.String getDesc_strumento() {
		return _strumentoTec.getDesc_strumento();
	}

	/**
	* Returns the email_ref of this strumento tec.
	*
	* @return the email_ref of this strumento tec
	*/
	@Override
	public java.lang.String getEmail_ref() {
		return _strumentoTec.getEmail_ref();
	}

	@Override
	public java.lang.String toString() {
		return _strumentoTec.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _strumentoTec.toXmlString();
	}

	/**
	* Returns the id_strumento of this strumento tec.
	*
	* @return the id_strumento of this strumento tec
	*/
	@Override
	public long getId_strumento() {
		return _strumentoTec.getId_strumento();
	}

	/**
	* Returns the primary key of this strumento tec.
	*
	* @return the primary key of this strumento tec
	*/
	@Override
	public long getPrimaryKey() {
		return _strumentoTec.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec toEscapedModel() {
		return new StrumentoTecWrapper(_strumentoTec.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec toUnescapedModel() {
		return new StrumentoTecWrapper(_strumentoTec.toUnescapedModel());
	}

	@Override
	public void persist() {
		_strumentoTec.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_strumentoTec.setCachedModel(cachedModel);
	}

	/**
	* Sets the desc_strumento of this strumento tec.
	*
	* @param desc_strumento the desc_strumento of this strumento tec
	*/
	@Override
	public void setDesc_strumento(java.lang.String desc_strumento) {
		_strumentoTec.setDesc_strumento(desc_strumento);
	}

	/**
	* Sets the email_ref of this strumento tec.
	*
	* @param email_ref the email_ref of this strumento tec
	*/
	@Override
	public void setEmail_ref(java.lang.String email_ref) {
		_strumentoTec.setEmail_ref(email_ref);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_strumentoTec.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_strumentoTec.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_strumentoTec.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_strumento of this strumento tec.
	*
	* @param id_strumento the id_strumento of this strumento tec
	*/
	@Override
	public void setId_strumento(long id_strumento) {
		_strumentoTec.setId_strumento(id_strumento);
	}

	@Override
	public void setNew(boolean n) {
		_strumentoTec.setNew(n);
	}

	/**
	* Sets the primary key of this strumento tec.
	*
	* @param primaryKey the primary key of this strumento tec
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_strumentoTec.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_strumentoTec.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumentoTecWrapper)) {
			return false;
		}

		StrumentoTecWrapper strumentoTecWrapper = (StrumentoTecWrapper)obj;

		if (Objects.equals(_strumentoTec, strumentoTecWrapper._strumentoTec)) {
			return true;
		}

		return false;
	}

	@Override
	public StrumentoTec getWrappedModel() {
		return _strumentoTec;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _strumentoTec.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _strumentoTec.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_strumentoTec.resetOriginalValues();
	}

	private final StrumentoTec _strumentoTec;
}