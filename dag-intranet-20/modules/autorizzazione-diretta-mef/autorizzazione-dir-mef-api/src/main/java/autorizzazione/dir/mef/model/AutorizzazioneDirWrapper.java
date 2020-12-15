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

package autorizzazione.dir.mef.model;

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
 * This class is a wrapper for {@link AutorizzazioneDir}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutorizzazioneDir
 * @generated
 */
@ProviderType
public class AutorizzazioneDirWrapper implements AutorizzazioneDir,
	ModelWrapper<AutorizzazioneDir> {
	public AutorizzazioneDirWrapper(AutorizzazioneDir autorizzazioneDir) {
		_autorizzazioneDir = autorizzazioneDir;
	}

	@Override
	public Class<?> getModelClass() {
		return AutorizzazioneDir.class;
	}

	@Override
	public String getModelClassName() {
		return AutorizzazioneDir.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_autorizzazione", getId_autorizzazione());
		attributes.put("id_applicazione", getId_applicazione());
		attributes.put("mef", getMef());
		attributes.put("dipartimento", getDipartimento());
		attributes.put("direzione", getDirezione());
		attributes.put("ufficio", getUfficio());
		attributes.put("codice_fiscale", getCodice_fiscale());
		attributes.put("nega", getNega());
		attributes.put("tag", getTag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_autorizzazione = (Long)attributes.get("id_autorizzazione");

		if (id_autorizzazione != null) {
			setId_autorizzazione(id_autorizzazione);
		}

		Long id_applicazione = (Long)attributes.get("id_applicazione");

		if (id_applicazione != null) {
			setId_applicazione(id_applicazione);
		}

		Long mef = (Long)attributes.get("mef");

		if (mef != null) {
			setMef(mef);
		}

		Long dipartimento = (Long)attributes.get("dipartimento");

		if (dipartimento != null) {
			setDipartimento(dipartimento);
		}

		Long direzione = (Long)attributes.get("direzione");

		if (direzione != null) {
			setDirezione(direzione);
		}

		Long ufficio = (Long)attributes.get("ufficio");

		if (ufficio != null) {
			setUfficio(ufficio);
		}

		String codice_fiscale = (String)attributes.get("codice_fiscale");

		if (codice_fiscale != null) {
			setCodice_fiscale(codice_fiscale);
		}

		Boolean nega = (Boolean)attributes.get("nega");

		if (nega != null) {
			setNega(nega);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}
	}

	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir toEscapedModel() {
		return new AutorizzazioneDirWrapper(_autorizzazioneDir.toEscapedModel());
	}

	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir toUnescapedModel() {
		return new AutorizzazioneDirWrapper(_autorizzazioneDir.toUnescapedModel());
	}

	/**
	* Returns the nega of this autorizzazione dir.
	*
	* @return the nega of this autorizzazione dir
	*/
	@Override
	public boolean getNega() {
		return _autorizzazioneDir.getNega();
	}

	@Override
	public boolean isCachedModel() {
		return _autorizzazioneDir.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _autorizzazioneDir.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this autorizzazione dir is nega.
	*
	* @return <code>true</code> if this autorizzazione dir is nega; <code>false</code> otherwise
	*/
	@Override
	public boolean isNega() {
		return _autorizzazioneDir.isNega();
	}

	@Override
	public boolean isNew() {
		return _autorizzazioneDir.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _autorizzazioneDir.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<autorizzazione.dir.mef.model.AutorizzazioneDir> toCacheModel() {
		return _autorizzazioneDir.toCacheModel();
	}

	@Override
	public int compareTo(
		autorizzazione.dir.mef.model.AutorizzazioneDir autorizzazioneDir) {
		return _autorizzazioneDir.compareTo(autorizzazioneDir);
	}

	@Override
	public int hashCode() {
		return _autorizzazioneDir.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _autorizzazioneDir.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AutorizzazioneDirWrapper((AutorizzazioneDir)_autorizzazioneDir.clone());
	}

	/**
	* Returns the codice_fiscale of this autorizzazione dir.
	*
	* @return the codice_fiscale of this autorizzazione dir
	*/
	@Override
	public java.lang.String getCodice_fiscale() {
		return _autorizzazioneDir.getCodice_fiscale();
	}

	/**
	* Returns the tag of this autorizzazione dir.
	*
	* @return the tag of this autorizzazione dir
	*/
	@Override
	public java.lang.String getTag() {
		return _autorizzazioneDir.getTag();
	}

	@Override
	public java.lang.String toString() {
		return _autorizzazioneDir.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _autorizzazioneDir.toXmlString();
	}

	/**
	* Returns the dipartimento of this autorizzazione dir.
	*
	* @return the dipartimento of this autorizzazione dir
	*/
	@Override
	public long getDipartimento() {
		return _autorizzazioneDir.getDipartimento();
	}

	/**
	* Returns the direzione of this autorizzazione dir.
	*
	* @return the direzione of this autorizzazione dir
	*/
	@Override
	public long getDirezione() {
		return _autorizzazioneDir.getDirezione();
	}

	/**
	* Returns the id_applicazione of this autorizzazione dir.
	*
	* @return the id_applicazione of this autorizzazione dir
	*/
	@Override
	public long getId_applicazione() {
		return _autorizzazioneDir.getId_applicazione();
	}

	/**
	* Returns the id_autorizzazione of this autorizzazione dir.
	*
	* @return the id_autorizzazione of this autorizzazione dir
	*/
	@Override
	public long getId_autorizzazione() {
		return _autorizzazioneDir.getId_autorizzazione();
	}

	/**
	* Returns the mef of this autorizzazione dir.
	*
	* @return the mef of this autorizzazione dir
	*/
	@Override
	public long getMef() {
		return _autorizzazioneDir.getMef();
	}

	/**
	* Returns the primary key of this autorizzazione dir.
	*
	* @return the primary key of this autorizzazione dir
	*/
	@Override
	public long getPrimaryKey() {
		return _autorizzazioneDir.getPrimaryKey();
	}

	/**
	* Returns the ufficio of this autorizzazione dir.
	*
	* @return the ufficio of this autorizzazione dir
	*/
	@Override
	public long getUfficio() {
		return _autorizzazioneDir.getUfficio();
	}

	@Override
	public void persist() {
		_autorizzazioneDir.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_autorizzazioneDir.setCachedModel(cachedModel);
	}

	/**
	* Sets the codice_fiscale of this autorizzazione dir.
	*
	* @param codice_fiscale the codice_fiscale of this autorizzazione dir
	*/
	@Override
	public void setCodice_fiscale(java.lang.String codice_fiscale) {
		_autorizzazioneDir.setCodice_fiscale(codice_fiscale);
	}

	/**
	* Sets the dipartimento of this autorizzazione dir.
	*
	* @param dipartimento the dipartimento of this autorizzazione dir
	*/
	@Override
	public void setDipartimento(long dipartimento) {
		_autorizzazioneDir.setDipartimento(dipartimento);
	}

	/**
	* Sets the direzione of this autorizzazione dir.
	*
	* @param direzione the direzione of this autorizzazione dir
	*/
	@Override
	public void setDirezione(long direzione) {
		_autorizzazioneDir.setDirezione(direzione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_autorizzazioneDir.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_autorizzazioneDir.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_autorizzazioneDir.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_applicazione of this autorizzazione dir.
	*
	* @param id_applicazione the id_applicazione of this autorizzazione dir
	*/
	@Override
	public void setId_applicazione(long id_applicazione) {
		_autorizzazioneDir.setId_applicazione(id_applicazione);
	}

	/**
	* Sets the id_autorizzazione of this autorizzazione dir.
	*
	* @param id_autorizzazione the id_autorizzazione of this autorizzazione dir
	*/
	@Override
	public void setId_autorizzazione(long id_autorizzazione) {
		_autorizzazioneDir.setId_autorizzazione(id_autorizzazione);
	}

	/**
	* Sets the mef of this autorizzazione dir.
	*
	* @param mef the mef of this autorizzazione dir
	*/
	@Override
	public void setMef(long mef) {
		_autorizzazioneDir.setMef(mef);
	}

	/**
	* Sets whether this autorizzazione dir is nega.
	*
	* @param nega the nega of this autorizzazione dir
	*/
	@Override
	public void setNega(boolean nega) {
		_autorizzazioneDir.setNega(nega);
	}

	@Override
	public void setNew(boolean n) {
		_autorizzazioneDir.setNew(n);
	}

	/**
	* Sets the primary key of this autorizzazione dir.
	*
	* @param primaryKey the primary key of this autorizzazione dir
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_autorizzazioneDir.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_autorizzazioneDir.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tag of this autorizzazione dir.
	*
	* @param tag the tag of this autorizzazione dir
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_autorizzazioneDir.setTag(tag);
	}

	/**
	* Sets the ufficio of this autorizzazione dir.
	*
	* @param ufficio the ufficio of this autorizzazione dir
	*/
	@Override
	public void setUfficio(long ufficio) {
		_autorizzazioneDir.setUfficio(ufficio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AutorizzazioneDirWrapper)) {
			return false;
		}

		AutorizzazioneDirWrapper autorizzazioneDirWrapper = (AutorizzazioneDirWrapper)obj;

		if (Objects.equals(_autorizzazioneDir,
					autorizzazioneDirWrapper._autorizzazioneDir)) {
			return true;
		}

		return false;
	}

	@Override
	public AutorizzazioneDir getWrappedModel() {
		return _autorizzazioneDir;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _autorizzazioneDir.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _autorizzazioneDir.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_autorizzazioneDir.resetOriginalValues();
	}

	private final AutorizzazioneDir _autorizzazioneDir;
}