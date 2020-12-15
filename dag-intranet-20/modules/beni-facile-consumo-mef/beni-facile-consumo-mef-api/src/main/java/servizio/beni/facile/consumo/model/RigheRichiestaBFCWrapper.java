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
 * This class is a wrapper for {@link RigheRichiestaBFC}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFC
 * @generated
 */
@ProviderType
public class RigheRichiestaBFCWrapper implements RigheRichiestaBFC,
	ModelWrapper<RigheRichiestaBFC> {
	public RigheRichiestaBFCWrapper(RigheRichiestaBFC righeRichiestaBFC) {
		_righeRichiestaBFC = righeRichiestaBFC;
	}

	@Override
	public Class<?> getModelClass() {
		return RigheRichiestaBFC.class;
	}

	@Override
	public String getModelClassName() {
		return RigheRichiestaBFC.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("dipartimento", getDipartimento());
		attributes.put("dati", getDati());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long id_richiesta = (Long)attributes.get("id_richiesta");

		if (id_richiesta != null) {
			setId_richiesta(id_richiesta);
		}

		String dipartimento = (String)attributes.get("dipartimento");

		if (dipartimento != null) {
			setDipartimento(dipartimento);
		}

		String dati = (String)attributes.get("dati");

		if (dati != null) {
			setDati(dati);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _righeRichiestaBFC.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _righeRichiestaBFC.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _righeRichiestaBFC.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _righeRichiestaBFC.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.beni.facile.consumo.model.RigheRichiestaBFC> toCacheModel() {
		return _righeRichiestaBFC.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.beni.facile.consumo.model.RigheRichiestaBFC righeRichiestaBFC) {
		return _righeRichiestaBFC.compareTo(righeRichiestaBFC);
	}

	@Override
	public int hashCode() {
		return _righeRichiestaBFC.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _righeRichiestaBFC.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RigheRichiestaBFCWrapper((RigheRichiestaBFC)_righeRichiestaBFC.clone());
	}

	/**
	* Returns the dati of this righe richiesta b f c.
	*
	* @return the dati of this righe richiesta b f c
	*/
	@Override
	public java.lang.String getDati() {
		return _righeRichiestaBFC.getDati();
	}

	/**
	* Returns the dipartimento of this righe richiesta b f c.
	*
	* @return the dipartimento of this righe richiesta b f c
	*/
	@Override
	public java.lang.String getDipartimento() {
		return _righeRichiestaBFC.getDipartimento();
	}

	@Override
	public java.lang.String toString() {
		return _righeRichiestaBFC.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _righeRichiestaBFC.toXmlString();
	}

	/**
	* Returns the ID of this righe richiesta b f c.
	*
	* @return the ID of this righe richiesta b f c
	*/
	@Override
	public long getId() {
		return _righeRichiestaBFC.getId();
	}

	/**
	* Returns the id_richiesta of this righe richiesta b f c.
	*
	* @return the id_richiesta of this righe richiesta b f c
	*/
	@Override
	public long getId_richiesta() {
		return _righeRichiestaBFC.getId_richiesta();
	}

	/**
	* Returns the primary key of this righe richiesta b f c.
	*
	* @return the primary key of this righe richiesta b f c
	*/
	@Override
	public long getPrimaryKey() {
		return _righeRichiestaBFC.getPrimaryKey();
	}

	@Override
	public servizio.beni.facile.consumo.model.RigheRichiestaBFC toEscapedModel() {
		return new RigheRichiestaBFCWrapper(_righeRichiestaBFC.toEscapedModel());
	}

	@Override
	public servizio.beni.facile.consumo.model.RigheRichiestaBFC toUnescapedModel() {
		return new RigheRichiestaBFCWrapper(_righeRichiestaBFC.toUnescapedModel());
	}

	@Override
	public void persist() {
		_righeRichiestaBFC.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_righeRichiestaBFC.setCachedModel(cachedModel);
	}

	/**
	* Sets the dati of this righe richiesta b f c.
	*
	* @param dati the dati of this righe richiesta b f c
	*/
	@Override
	public void setDati(java.lang.String dati) {
		_righeRichiestaBFC.setDati(dati);
	}

	/**
	* Sets the dipartimento of this righe richiesta b f c.
	*
	* @param dipartimento the dipartimento of this righe richiesta b f c
	*/
	@Override
	public void setDipartimento(java.lang.String dipartimento) {
		_righeRichiestaBFC.setDipartimento(dipartimento);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_righeRichiestaBFC.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_righeRichiestaBFC.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_righeRichiestaBFC.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this righe richiesta b f c.
	*
	* @param id the ID of this righe richiesta b f c
	*/
	@Override
	public void setId(long id) {
		_righeRichiestaBFC.setId(id);
	}

	/**
	* Sets the id_richiesta of this righe richiesta b f c.
	*
	* @param id_richiesta the id_richiesta of this righe richiesta b f c
	*/
	@Override
	public void setId_richiesta(long id_richiesta) {
		_righeRichiestaBFC.setId_richiesta(id_richiesta);
	}

	@Override
	public void setNew(boolean n) {
		_righeRichiestaBFC.setNew(n);
	}

	/**
	* Sets the primary key of this righe richiesta b f c.
	*
	* @param primaryKey the primary key of this righe richiesta b f c
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_righeRichiestaBFC.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_righeRichiestaBFC.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichiestaBFCWrapper)) {
			return false;
		}

		RigheRichiestaBFCWrapper righeRichiestaBFCWrapper = (RigheRichiestaBFCWrapper)obj;

		if (Objects.equals(_righeRichiestaBFC,
					righeRichiestaBFCWrapper._righeRichiestaBFC)) {
			return true;
		}

		return false;
	}

	@Override
	public RigheRichiestaBFC getWrappedModel() {
		return _righeRichiestaBFC;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _righeRichiestaBFC.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _righeRichiestaBFC.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_righeRichiestaBFC.resetOriginalValues();
	}

	private final RigheRichiestaBFC _righeRichiestaBFC;
}