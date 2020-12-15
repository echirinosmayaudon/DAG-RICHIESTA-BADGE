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

package external.bfc.intranet.mef.model;

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
 * This class is a wrapper for {@link SediBfc}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediBfc
 * @generated
 */
@ProviderType
public class SediBfcWrapper implements SediBfc, ModelWrapper<SediBfc> {
	public SediBfcWrapper(SediBfc sediBfc) {
		_sediBfc = sediBfc;
	}

	@Override
	public Class<?> getModelClass() {
		return SediBfc.class;
	}

	@Override
	public String getModelClassName() {
		return SediBfc.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("codice_geco", getCodice_geco());
		attributes.put("id_sede_geco", getId_sede_geco());
		attributes.put("id_sede_siap", getId_sede_siap());
		attributes.put("id_org_liv2", getId_org_liv2());
		attributes.put("id_org_liv3", getId_org_liv3());
		attributes.put("nomeLoc", getNomeLoc());
		attributes.put("flag_app", getFlag_app());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String codice_geco = (String)attributes.get("codice_geco");

		if (codice_geco != null) {
			setCodice_geco(codice_geco);
		}

		String id_sede_geco = (String)attributes.get("id_sede_geco");

		if (id_sede_geco != null) {
			setId_sede_geco(id_sede_geco);
		}

		Long id_sede_siap = (Long)attributes.get("id_sede_siap");

		if (id_sede_siap != null) {
			setId_sede_siap(id_sede_siap);
		}

		Long id_org_liv2 = (Long)attributes.get("id_org_liv2");

		if (id_org_liv2 != null) {
			setId_org_liv2(id_org_liv2);
		}

		Long id_org_liv3 = (Long)attributes.get("id_org_liv3");

		if (id_org_liv3 != null) {
			setId_org_liv3(id_org_liv3);
		}

		String nomeLoc = (String)attributes.get("nomeLoc");

		if (nomeLoc != null) {
			setNomeLoc(nomeLoc);
		}

		Boolean flag_app = (Boolean)attributes.get("flag_app");

		if (flag_app != null) {
			setFlag_app(flag_app);
		}
	}

	/**
	* Returns the flag_app of this sedi bfc.
	*
	* @return the flag_app of this sedi bfc
	*/
	@Override
	public boolean getFlag_app() {
		return _sediBfc.getFlag_app();
	}

	@Override
	public boolean isCachedModel() {
		return _sediBfc.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _sediBfc.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this sedi bfc is flag_app.
	*
	* @return <code>true</code> if this sedi bfc is flag_app; <code>false</code> otherwise
	*/
	@Override
	public boolean isFlag_app() {
		return _sediBfc.isFlag_app();
	}

	@Override
	public boolean isNew() {
		return _sediBfc.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sediBfc.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<external.bfc.intranet.mef.model.SediBfc> toCacheModel() {
		return _sediBfc.toCacheModel();
	}

	@Override
	public external.bfc.intranet.mef.model.SediBfc toEscapedModel() {
		return new SediBfcWrapper(_sediBfc.toEscapedModel());
	}

	@Override
	public external.bfc.intranet.mef.model.SediBfc toUnescapedModel() {
		return new SediBfcWrapper(_sediBfc.toUnescapedModel());
	}

	@Override
	public int compareTo(external.bfc.intranet.mef.model.SediBfc sediBfc) {
		return _sediBfc.compareTo(sediBfc);
	}

	@Override
	public int hashCode() {
		return _sediBfc.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sediBfc.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SediBfcWrapper((SediBfc)_sediBfc.clone());
	}

	/**
	* Returns the codice_geco of this sedi bfc.
	*
	* @return the codice_geco of this sedi bfc
	*/
	@Override
	public java.lang.String getCodice_geco() {
		return _sediBfc.getCodice_geco();
	}

	/**
	* Returns the id_sede_geco of this sedi bfc.
	*
	* @return the id_sede_geco of this sedi bfc
	*/
	@Override
	public java.lang.String getId_sede_geco() {
		return _sediBfc.getId_sede_geco();
	}

	/**
	* Returns the nome loc of this sedi bfc.
	*
	* @return the nome loc of this sedi bfc
	*/
	@Override
	public java.lang.String getNomeLoc() {
		return _sediBfc.getNomeLoc();
	}

	@Override
	public java.lang.String toString() {
		return _sediBfc.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sediBfc.toXmlString();
	}

	/**
	* Returns the ID of this sedi bfc.
	*
	* @return the ID of this sedi bfc
	*/
	@Override
	public long getId() {
		return _sediBfc.getId();
	}

	/**
	* Returns the id_org_liv2 of this sedi bfc.
	*
	* @return the id_org_liv2 of this sedi bfc
	*/
	@Override
	public long getId_org_liv2() {
		return _sediBfc.getId_org_liv2();
	}

	/**
	* Returns the id_org_liv3 of this sedi bfc.
	*
	* @return the id_org_liv3 of this sedi bfc
	*/
	@Override
	public long getId_org_liv3() {
		return _sediBfc.getId_org_liv3();
	}

	/**
	* Returns the id_sede_siap of this sedi bfc.
	*
	* @return the id_sede_siap of this sedi bfc
	*/
	@Override
	public long getId_sede_siap() {
		return _sediBfc.getId_sede_siap();
	}

	/**
	* Returns the primary key of this sedi bfc.
	*
	* @return the primary key of this sedi bfc
	*/
	@Override
	public long getPrimaryKey() {
		return _sediBfc.getPrimaryKey();
	}

	@Override
	public void persist() {
		_sediBfc.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sediBfc.setCachedModel(cachedModel);
	}

	/**
	* Sets the codice_geco of this sedi bfc.
	*
	* @param codice_geco the codice_geco of this sedi bfc
	*/
	@Override
	public void setCodice_geco(java.lang.String codice_geco) {
		_sediBfc.setCodice_geco(codice_geco);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sediBfc.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_sediBfc.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sediBfc.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this sedi bfc is flag_app.
	*
	* @param flag_app the flag_app of this sedi bfc
	*/
	@Override
	public void setFlag_app(boolean flag_app) {
		_sediBfc.setFlag_app(flag_app);
	}

	/**
	* Sets the ID of this sedi bfc.
	*
	* @param id the ID of this sedi bfc
	*/
	@Override
	public void setId(long id) {
		_sediBfc.setId(id);
	}

	/**
	* Sets the id_org_liv2 of this sedi bfc.
	*
	* @param id_org_liv2 the id_org_liv2 of this sedi bfc
	*/
	@Override
	public void setId_org_liv2(long id_org_liv2) {
		_sediBfc.setId_org_liv2(id_org_liv2);
	}

	/**
	* Sets the id_org_liv3 of this sedi bfc.
	*
	* @param id_org_liv3 the id_org_liv3 of this sedi bfc
	*/
	@Override
	public void setId_org_liv3(long id_org_liv3) {
		_sediBfc.setId_org_liv3(id_org_liv3);
	}

	/**
	* Sets the id_sede_geco of this sedi bfc.
	*
	* @param id_sede_geco the id_sede_geco of this sedi bfc
	*/
	@Override
	public void setId_sede_geco(java.lang.String id_sede_geco) {
		_sediBfc.setId_sede_geco(id_sede_geco);
	}

	/**
	* Sets the id_sede_siap of this sedi bfc.
	*
	* @param id_sede_siap the id_sede_siap of this sedi bfc
	*/
	@Override
	public void setId_sede_siap(long id_sede_siap) {
		_sediBfc.setId_sede_siap(id_sede_siap);
	}

	@Override
	public void setNew(boolean n) {
		_sediBfc.setNew(n);
	}

	/**
	* Sets the nome loc of this sedi bfc.
	*
	* @param nomeLoc the nome loc of this sedi bfc
	*/
	@Override
	public void setNomeLoc(java.lang.String nomeLoc) {
		_sediBfc.setNomeLoc(nomeLoc);
	}

	/**
	* Sets the primary key of this sedi bfc.
	*
	* @param primaryKey the primary key of this sedi bfc
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sediBfc.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sediBfc.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SediBfcWrapper)) {
			return false;
		}

		SediBfcWrapper sediBfcWrapper = (SediBfcWrapper)obj;

		if (Objects.equals(_sediBfc, sediBfcWrapper._sediBfc)) {
			return true;
		}

		return false;
	}

	@Override
	public SediBfc getWrappedModel() {
		return _sediBfc;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sediBfc.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sediBfc.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sediBfc.resetOriginalValues();
	}

	private final SediBfc _sediBfc;
}