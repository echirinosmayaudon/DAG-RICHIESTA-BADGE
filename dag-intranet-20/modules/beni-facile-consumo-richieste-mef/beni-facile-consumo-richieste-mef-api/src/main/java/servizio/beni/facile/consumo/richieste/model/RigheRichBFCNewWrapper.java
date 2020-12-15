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

package servizio.beni.facile.consumo.richieste.model;

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
 * This class is a wrapper for {@link RigheRichBFCNew}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichBFCNew
 * @generated
 */
@ProviderType
public class RigheRichBFCNewWrapper implements RigheRichBFCNew,
	ModelWrapper<RigheRichBFCNew> {
	public RigheRichBFCNewWrapper(RigheRichBFCNew righeRichBFCNew) {
		_righeRichBFCNew = righeRichBFCNew;
	}

	@Override
	public Class<?> getModelClass() {
		return RigheRichBFCNew.class;
	}

	@Override
	public String getModelClassName() {
		return RigheRichBFCNew.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("id_rich", getId_rich());
		attributes.put("dipartimento", getDipartimento());
		attributes.put("dati1", getDati1());
		attributes.put("dati2", getDati2());
		attributes.put("dati3", getDati3());
		attributes.put("dati4", getDati4());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long id_rich = (Long)attributes.get("id_rich");

		if (id_rich != null) {
			setId_rich(id_rich);
		}

		String dipartimento = (String)attributes.get("dipartimento");

		if (dipartimento != null) {
			setDipartimento(dipartimento);
		}

		String dati1 = (String)attributes.get("dati1");

		if (dati1 != null) {
			setDati1(dati1);
		}

		String dati2 = (String)attributes.get("dati2");

		if (dati2 != null) {
			setDati2(dati2);
		}

		String dati3 = (String)attributes.get("dati3");

		if (dati3 != null) {
			setDati3(dati3);
		}

		String dati4 = (String)attributes.get("dati4");

		if (dati4 != null) {
			setDati4(dati4);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _righeRichBFCNew.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _righeRichBFCNew.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _righeRichBFCNew.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _righeRichBFCNew.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew> toCacheModel() {
		return _righeRichBFCNew.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew righeRichBFCNew) {
		return _righeRichBFCNew.compareTo(righeRichBFCNew);
	}

	@Override
	public int hashCode() {
		return _righeRichBFCNew.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _righeRichBFCNew.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RigheRichBFCNewWrapper((RigheRichBFCNew)_righeRichBFCNew.clone());
	}

	/**
	* Returns the dati1 of this righe rich b f c new.
	*
	* @return the dati1 of this righe rich b f c new
	*/
	@Override
	public java.lang.String getDati1() {
		return _righeRichBFCNew.getDati1();
	}

	/**
	* Returns the dati2 of this righe rich b f c new.
	*
	* @return the dati2 of this righe rich b f c new
	*/
	@Override
	public java.lang.String getDati2() {
		return _righeRichBFCNew.getDati2();
	}

	/**
	* Returns the dati3 of this righe rich b f c new.
	*
	* @return the dati3 of this righe rich b f c new
	*/
	@Override
	public java.lang.String getDati3() {
		return _righeRichBFCNew.getDati3();
	}

	/**
	* Returns the dati4 of this righe rich b f c new.
	*
	* @return the dati4 of this righe rich b f c new
	*/
	@Override
	public java.lang.String getDati4() {
		return _righeRichBFCNew.getDati4();
	}

	/**
	* Returns the dipartimento of this righe rich b f c new.
	*
	* @return the dipartimento of this righe rich b f c new
	*/
	@Override
	public java.lang.String getDipartimento() {
		return _righeRichBFCNew.getDipartimento();
	}

	@Override
	public java.lang.String toString() {
		return _righeRichBFCNew.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _righeRichBFCNew.toXmlString();
	}

	/**
	* Returns the ID of this righe rich b f c new.
	*
	* @return the ID of this righe rich b f c new
	*/
	@Override
	public long getId() {
		return _righeRichBFCNew.getId();
	}

	/**
	* Returns the id_rich of this righe rich b f c new.
	*
	* @return the id_rich of this righe rich b f c new
	*/
	@Override
	public long getId_rich() {
		return _righeRichBFCNew.getId_rich();
	}

	/**
	* Returns the primary key of this righe rich b f c new.
	*
	* @return the primary key of this righe rich b f c new
	*/
	@Override
	public long getPrimaryKey() {
		return _righeRichBFCNew.getPrimaryKey();
	}

	@Override
	public servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew toEscapedModel() {
		return new RigheRichBFCNewWrapper(_righeRichBFCNew.toEscapedModel());
	}

	@Override
	public servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew toUnescapedModel() {
		return new RigheRichBFCNewWrapper(_righeRichBFCNew.toUnescapedModel());
	}

	@Override
	public void persist() {
		_righeRichBFCNew.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_righeRichBFCNew.setCachedModel(cachedModel);
	}

	/**
	* Sets the dati1 of this righe rich b f c new.
	*
	* @param dati1 the dati1 of this righe rich b f c new
	*/
	@Override
	public void setDati1(java.lang.String dati1) {
		_righeRichBFCNew.setDati1(dati1);
	}

	/**
	* Sets the dati2 of this righe rich b f c new.
	*
	* @param dati2 the dati2 of this righe rich b f c new
	*/
	@Override
	public void setDati2(java.lang.String dati2) {
		_righeRichBFCNew.setDati2(dati2);
	}

	/**
	* Sets the dati3 of this righe rich b f c new.
	*
	* @param dati3 the dati3 of this righe rich b f c new
	*/
	@Override
	public void setDati3(java.lang.String dati3) {
		_righeRichBFCNew.setDati3(dati3);
	}

	/**
	* Sets the dati4 of this righe rich b f c new.
	*
	* @param dati4 the dati4 of this righe rich b f c new
	*/
	@Override
	public void setDati4(java.lang.String dati4) {
		_righeRichBFCNew.setDati4(dati4);
	}

	/**
	* Sets the dipartimento of this righe rich b f c new.
	*
	* @param dipartimento the dipartimento of this righe rich b f c new
	*/
	@Override
	public void setDipartimento(java.lang.String dipartimento) {
		_righeRichBFCNew.setDipartimento(dipartimento);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_righeRichBFCNew.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_righeRichBFCNew.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_righeRichBFCNew.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this righe rich b f c new.
	*
	* @param id the ID of this righe rich b f c new
	*/
	@Override
	public void setId(long id) {
		_righeRichBFCNew.setId(id);
	}

	/**
	* Sets the id_rich of this righe rich b f c new.
	*
	* @param id_rich the id_rich of this righe rich b f c new
	*/
	@Override
	public void setId_rich(long id_rich) {
		_righeRichBFCNew.setId_rich(id_rich);
	}

	@Override
	public void setNew(boolean n) {
		_righeRichBFCNew.setNew(n);
	}

	/**
	* Sets the primary key of this righe rich b f c new.
	*
	* @param primaryKey the primary key of this righe rich b f c new
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_righeRichBFCNew.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_righeRichBFCNew.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichBFCNewWrapper)) {
			return false;
		}

		RigheRichBFCNewWrapper righeRichBFCNewWrapper = (RigheRichBFCNewWrapper)obj;

		if (Objects.equals(_righeRichBFCNew,
					righeRichBFCNewWrapper._righeRichBFCNew)) {
			return true;
		}

		return false;
	}

	@Override
	public RigheRichBFCNew getWrappedModel() {
		return _righeRichBFCNew;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _righeRichBFCNew.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _righeRichBFCNew.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_righeRichBFCNew.resetOriginalValues();
	}

	private final RigheRichBFCNew _righeRichBFCNew;
}