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

package servizio.richieste.badge.mef.model;

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
 * This class is a wrapper for {@link AnaDipExt}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnaDipExt
 * @generated
 */
@ProviderType
public class AnaDipExtWrapper implements AnaDipExt, ModelWrapper<AnaDipExt> {
	public AnaDipExtWrapper(AnaDipExt anaDipExt) {
		_anaDipExt = anaDipExt;
	}

	@Override
	public Class<?> getModelClass() {
		return AnaDipExt.class;
	}

	@Override
	public String getModelClassName() {
		return AnaDipExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_dip_ext", getId_dip_ext());
		attributes.put("nome_dip_ext", getNome_dip_ext());
		attributes.put("cognome_dip_ext", getCognome_dip_ext());
		attributes.put("cf_dip_ext", getCf_dip_ext());
		attributes.put("luogonascita_dip_ext", getLuogonascita_dip_ext());
		attributes.put("datanascita_dip_ext", getDatanascita_dip_ext());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_dip_ext = (Long)attributes.get("id_dip_ext");

		if (id_dip_ext != null) {
			setId_dip_ext(id_dip_ext);
		}

		String nome_dip_ext = (String)attributes.get("nome_dip_ext");

		if (nome_dip_ext != null) {
			setNome_dip_ext(nome_dip_ext);
		}

		String cognome_dip_ext = (String)attributes.get("cognome_dip_ext");

		if (cognome_dip_ext != null) {
			setCognome_dip_ext(cognome_dip_ext);
		}

		String cf_dip_ext = (String)attributes.get("cf_dip_ext");

		if (cf_dip_ext != null) {
			setCf_dip_ext(cf_dip_ext);
		}

		String luogonascita_dip_ext = (String)attributes.get(
				"luogonascita_dip_ext");

		if (luogonascita_dip_ext != null) {
			setLuogonascita_dip_ext(luogonascita_dip_ext);
		}

		Date datanascita_dip_ext = (Date)attributes.get("datanascita_dip_ext");

		if (datanascita_dip_ext != null) {
			setDatanascita_dip_ext(datanascita_dip_ext);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _anaDipExt.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _anaDipExt.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _anaDipExt.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _anaDipExt.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.richieste.badge.mef.model.AnaDipExt> toCacheModel() {
		return _anaDipExt.toCacheModel();
	}

	@Override
	public int compareTo(servizio.richieste.badge.mef.model.AnaDipExt anaDipExt) {
		return _anaDipExt.compareTo(anaDipExt);
	}

	@Override
	public int hashCode() {
		return _anaDipExt.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _anaDipExt.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AnaDipExtWrapper((AnaDipExt)_anaDipExt.clone());
	}

	/**
	* Returns the cf_dip_ext of this ana dip ext.
	*
	* @return the cf_dip_ext of this ana dip ext
	*/
	@Override
	public java.lang.String getCf_dip_ext() {
		return _anaDipExt.getCf_dip_ext();
	}

	/**
	* Returns the cognome_dip_ext of this ana dip ext.
	*
	* @return the cognome_dip_ext of this ana dip ext
	*/
	@Override
	public java.lang.String getCognome_dip_ext() {
		return _anaDipExt.getCognome_dip_ext();
	}

	/**
	* Returns the luogonascita_dip_ext of this ana dip ext.
	*
	* @return the luogonascita_dip_ext of this ana dip ext
	*/
	@Override
	public java.lang.String getLuogonascita_dip_ext() {
		return _anaDipExt.getLuogonascita_dip_ext();
	}

	/**
	* Returns the nome_dip_ext of this ana dip ext.
	*
	* @return the nome_dip_ext of this ana dip ext
	*/
	@Override
	public java.lang.String getNome_dip_ext() {
		return _anaDipExt.getNome_dip_ext();
	}

	@Override
	public java.lang.String toString() {
		return _anaDipExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _anaDipExt.toXmlString();
	}

	/**
	* Returns the datanascita_dip_ext of this ana dip ext.
	*
	* @return the datanascita_dip_ext of this ana dip ext
	*/
	@Override
	public Date getDatanascita_dip_ext() {
		return _anaDipExt.getDatanascita_dip_ext();
	}

	/**
	* Returns the id_dip_ext of this ana dip ext.
	*
	* @return the id_dip_ext of this ana dip ext
	*/
	@Override
	public long getId_dip_ext() {
		return _anaDipExt.getId_dip_ext();
	}

	/**
	* Returns the primary key of this ana dip ext.
	*
	* @return the primary key of this ana dip ext
	*/
	@Override
	public long getPrimaryKey() {
		return _anaDipExt.getPrimaryKey();
	}

	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt toEscapedModel() {
		return new AnaDipExtWrapper(_anaDipExt.toEscapedModel());
	}

	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt toUnescapedModel() {
		return new AnaDipExtWrapper(_anaDipExt.toUnescapedModel());
	}

	@Override
	public void persist() {
		_anaDipExt.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_anaDipExt.setCachedModel(cachedModel);
	}

	/**
	* Sets the cf_dip_ext of this ana dip ext.
	*
	* @param cf_dip_ext the cf_dip_ext of this ana dip ext
	*/
	@Override
	public void setCf_dip_ext(java.lang.String cf_dip_ext) {
		_anaDipExt.setCf_dip_ext(cf_dip_ext);
	}

	/**
	* Sets the cognome_dip_ext of this ana dip ext.
	*
	* @param cognome_dip_ext the cognome_dip_ext of this ana dip ext
	*/
	@Override
	public void setCognome_dip_ext(java.lang.String cognome_dip_ext) {
		_anaDipExt.setCognome_dip_ext(cognome_dip_ext);
	}

	/**
	* Sets the datanascita_dip_ext of this ana dip ext.
	*
	* @param datanascita_dip_ext the datanascita_dip_ext of this ana dip ext
	*/
	@Override
	public void setDatanascita_dip_ext(Date datanascita_dip_ext) {
		_anaDipExt.setDatanascita_dip_ext(datanascita_dip_ext);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_anaDipExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_anaDipExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_anaDipExt.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_dip_ext of this ana dip ext.
	*
	* @param id_dip_ext the id_dip_ext of this ana dip ext
	*/
	@Override
	public void setId_dip_ext(long id_dip_ext) {
		_anaDipExt.setId_dip_ext(id_dip_ext);
	}

	/**
	* Sets the luogonascita_dip_ext of this ana dip ext.
	*
	* @param luogonascita_dip_ext the luogonascita_dip_ext of this ana dip ext
	*/
	@Override
	public void setLuogonascita_dip_ext(java.lang.String luogonascita_dip_ext) {
		_anaDipExt.setLuogonascita_dip_ext(luogonascita_dip_ext);
	}

	@Override
	public void setNew(boolean n) {
		_anaDipExt.setNew(n);
	}

	/**
	* Sets the nome_dip_ext of this ana dip ext.
	*
	* @param nome_dip_ext the nome_dip_ext of this ana dip ext
	*/
	@Override
	public void setNome_dip_ext(java.lang.String nome_dip_ext) {
		_anaDipExt.setNome_dip_ext(nome_dip_ext);
	}

	/**
	* Sets the primary key of this ana dip ext.
	*
	* @param primaryKey the primary key of this ana dip ext
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_anaDipExt.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_anaDipExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnaDipExtWrapper)) {
			return false;
		}

		AnaDipExtWrapper anaDipExtWrapper = (AnaDipExtWrapper)obj;

		if (Objects.equals(_anaDipExt, anaDipExtWrapper._anaDipExt)) {
			return true;
		}

		return false;
	}

	@Override
	public AnaDipExt getWrappedModel() {
		return _anaDipExt;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _anaDipExt.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _anaDipExt.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_anaDipExt.resetOriginalValues();
	}

	private final AnaDipExt _anaDipExt;
}