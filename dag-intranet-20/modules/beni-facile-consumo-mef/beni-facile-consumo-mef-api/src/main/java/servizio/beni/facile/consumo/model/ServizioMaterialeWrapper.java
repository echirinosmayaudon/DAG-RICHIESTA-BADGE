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

package servizio.beni.facile.consumo.model;

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
 * This class is a wrapper for {@link ServizioMateriale}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioMateriale
 * @generated
 */
@ProviderType
public class ServizioMaterialeWrapper implements ServizioMateriale,
	ModelWrapper<ServizioMateriale> {
	public ServizioMaterialeWrapper(ServizioMateriale servizioMateriale) {
		_servizioMateriale = servizioMateriale;
	}

	@Override
	public Class<?> getModelClass() {
		return ServizioMateriale.class;
	}

	@Override
	public String getModelClassName() {
		return ServizioMateriale.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gruppo", getGruppo());
		attributes.put("descrizione", getDescrizione());
		attributes.put("categoria", getCategoria());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String gruppo = (String)attributes.get("gruppo");

		if (gruppo != null) {
			setGruppo(gruppo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String categoria = (String)attributes.get("categoria");

		if (categoria != null) {
			setCategoria(categoria);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _servizioMateriale.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _servizioMateriale.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _servizioMateriale.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _servizioMateriale.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.beni.facile.consumo.model.ServizioMateriale> toCacheModel() {
		return _servizioMateriale.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.beni.facile.consumo.model.ServizioMateriale servizioMateriale) {
		return _servizioMateriale.compareTo(servizioMateriale);
	}

	@Override
	public int hashCode() {
		return _servizioMateriale.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _servizioMateriale.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ServizioMaterialeWrapper((ServizioMateriale)_servizioMateriale.clone());
	}

	/**
	* Returns the categoria of this servizio materiale.
	*
	* @return the categoria of this servizio materiale
	*/
	@Override
	public java.lang.String getCategoria() {
		return _servizioMateriale.getCategoria();
	}

	/**
	* Returns the descrizione of this servizio materiale.
	*
	* @return the descrizione of this servizio materiale
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _servizioMateriale.getDescrizione();
	}

	/**
	* Returns the gruppo of this servizio materiale.
	*
	* @return the gruppo of this servizio materiale
	*/
	@Override
	public java.lang.String getGruppo() {
		return _servizioMateriale.getGruppo();
	}

	/**
	* Returns the primary key of this servizio materiale.
	*
	* @return the primary key of this servizio materiale
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _servizioMateriale.getPrimaryKey();
	}

	@Override
	public java.lang.String toString() {
		return _servizioMateriale.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _servizioMateriale.toXmlString();
	}

	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale toEscapedModel() {
		return new ServizioMaterialeWrapper(_servizioMateriale.toEscapedModel());
	}

	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale toUnescapedModel() {
		return new ServizioMaterialeWrapper(_servizioMateriale.toUnescapedModel());
	}

	@Override
	public void persist() {
		_servizioMateriale.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_servizioMateriale.setCachedModel(cachedModel);
	}

	/**
	* Sets the categoria of this servizio materiale.
	*
	* @param categoria the categoria of this servizio materiale
	*/
	@Override
	public void setCategoria(java.lang.String categoria) {
		_servizioMateriale.setCategoria(categoria);
	}

	/**
	* Sets the descrizione of this servizio materiale.
	*
	* @param descrizione the descrizione of this servizio materiale
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_servizioMateriale.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_servizioMateriale.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_servizioMateriale.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_servizioMateriale.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gruppo of this servizio materiale.
	*
	* @param gruppo the gruppo of this servizio materiale
	*/
	@Override
	public void setGruppo(java.lang.String gruppo) {
		_servizioMateriale.setGruppo(gruppo);
	}

	@Override
	public void setNew(boolean n) {
		_servizioMateriale.setNew(n);
	}

	/**
	* Sets the primary key of this servizio materiale.
	*
	* @param primaryKey the primary key of this servizio materiale
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_servizioMateriale.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_servizioMateriale.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServizioMaterialeWrapper)) {
			return false;
		}

		ServizioMaterialeWrapper servizioMaterialeWrapper = (ServizioMaterialeWrapper)obj;

		if (Objects.equals(_servizioMateriale,
					servizioMaterialeWrapper._servizioMateriale)) {
			return true;
		}

		return false;
	}

	@Override
	public ServizioMateriale getWrappedModel() {
		return _servizioMateriale;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _servizioMateriale.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _servizioMateriale.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_servizioMateriale.resetOriginalValues();
	}

	private final ServizioMateriale _servizioMateriale;
}