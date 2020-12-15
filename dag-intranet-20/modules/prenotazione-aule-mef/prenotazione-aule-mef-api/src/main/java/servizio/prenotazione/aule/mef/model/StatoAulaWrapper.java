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
 * This class is a wrapper for {@link StatoAula}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoAula
 * @generated
 */
@ProviderType
public class StatoAulaWrapper implements StatoAula, ModelWrapper<StatoAula> {
	public StatoAulaWrapper(StatoAula statoAula) {
		_statoAula = statoAula;
	}

	@Override
	public Class<?> getModelClass() {
		return StatoAula.class;
	}

	@Override
	public String getModelClassName() {
		return StatoAula.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_stato_aula", getId_stato_aula());
		attributes.put("desc_stato", getDesc_stato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_stato_aula = (Long)attributes.get("id_stato_aula");

		if (id_stato_aula != null) {
			setId_stato_aula(id_stato_aula);
		}

		String desc_stato = (String)attributes.get("desc_stato");

		if (desc_stato != null) {
			setDesc_stato(desc_stato);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _statoAula.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _statoAula.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _statoAula.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _statoAula.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.StatoAula> toCacheModel() {
		return _statoAula.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.StatoAula statoAula) {
		return _statoAula.compareTo(statoAula);
	}

	@Override
	public int hashCode() {
		return _statoAula.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statoAula.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StatoAulaWrapper((StatoAula)_statoAula.clone());
	}

	/**
	* Returns the desc_stato of this stato aula.
	*
	* @return the desc_stato of this stato aula
	*/
	@Override
	public java.lang.String getDesc_stato() {
		return _statoAula.getDesc_stato();
	}

	@Override
	public java.lang.String toString() {
		return _statoAula.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statoAula.toXmlString();
	}

	/**
	* Returns the id_stato_aula of this stato aula.
	*
	* @return the id_stato_aula of this stato aula
	*/
	@Override
	public long getId_stato_aula() {
		return _statoAula.getId_stato_aula();
	}

	/**
	* Returns the primary key of this stato aula.
	*
	* @return the primary key of this stato aula
	*/
	@Override
	public long getPrimaryKey() {
		return _statoAula.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula toEscapedModel() {
		return new StatoAulaWrapper(_statoAula.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula toUnescapedModel() {
		return new StatoAulaWrapper(_statoAula.toUnescapedModel());
	}

	@Override
	public void persist() {
		_statoAula.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statoAula.setCachedModel(cachedModel);
	}

	/**
	* Sets the desc_stato of this stato aula.
	*
	* @param desc_stato the desc_stato of this stato aula
	*/
	@Override
	public void setDesc_stato(java.lang.String desc_stato) {
		_statoAula.setDesc_stato(desc_stato);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_statoAula.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_statoAula.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_statoAula.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_stato_aula of this stato aula.
	*
	* @param id_stato_aula the id_stato_aula of this stato aula
	*/
	@Override
	public void setId_stato_aula(long id_stato_aula) {
		_statoAula.setId_stato_aula(id_stato_aula);
	}

	@Override
	public void setNew(boolean n) {
		_statoAula.setNew(n);
	}

	/**
	* Sets the primary key of this stato aula.
	*
	* @param primaryKey the primary key of this stato aula
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statoAula.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_statoAula.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoAulaWrapper)) {
			return false;
		}

		StatoAulaWrapper statoAulaWrapper = (StatoAulaWrapper)obj;

		if (Objects.equals(_statoAula, statoAulaWrapper._statoAula)) {
			return true;
		}

		return false;
	}

	@Override
	public StatoAula getWrappedModel() {
		return _statoAula;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _statoAula.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _statoAula.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_statoAula.resetOriginalValues();
	}

	private final StatoAula _statoAula;
}