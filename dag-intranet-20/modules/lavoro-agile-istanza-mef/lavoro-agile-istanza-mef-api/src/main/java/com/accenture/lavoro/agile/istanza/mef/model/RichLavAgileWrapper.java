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

package com.accenture.lavoro.agile.istanza.mef.model;

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
 * This class is a wrapper for {@link RichLavAgile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichLavAgile
 * @generated
 */
@ProviderType
public class RichLavAgileWrapper implements RichLavAgile,
	ModelWrapper<RichLavAgile> {
	public RichLavAgileWrapper(RichLavAgile richLavAgile) {
		_richLavAgile = richLavAgile;
	}

	@Override
	public Class<?> getModelClass() {
		return RichLavAgile.class;
	}

	@Override
	public String getModelClassName() {
		return RichLavAgile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("cognome", getCognome());
		attributes.put("nome", getNome());
		attributes.put("dipartimento", getDipartimento());
		attributes.put("direzione", getDirezione());
		attributes.put("ufficio", getUfficio());
		attributes.put("screename", getScreename());
		attributes.put("json_richiedente", getJson_richiedente());
		attributes.put("json_richiesta", getJson_richiesta());
		attributes.put("peso_tot", getPeso_tot());
		attributes.put("peso_plus", getPeso_plus());
		attributes.put("bando", getBando());
		attributes.put("data_richiesta", getData_richiesta());
		attributes.put("allegato", getAllegato());
		attributes.put("pdf", getPdf());

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

		String cognome = (String)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
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

		String screename = (String)attributes.get("screename");

		if (screename != null) {
			setScreename(screename);
		}

		String json_richiedente = (String)attributes.get("json_richiedente");

		if (json_richiedente != null) {
			setJson_richiedente(json_richiedente);
		}

		String json_richiesta = (String)attributes.get("json_richiesta");

		if (json_richiesta != null) {
			setJson_richiesta(json_richiesta);
		}

		Integer peso_tot = (Integer)attributes.get("peso_tot");

		if (peso_tot != null) {
			setPeso_tot(peso_tot);
		}

		String peso_plus = (String)attributes.get("peso_plus");

		if (peso_plus != null) {
			setPeso_plus(peso_plus);
		}

		String bando = (String)attributes.get("bando");

		if (bando != null) {
			setBando(bando);
		}

		Date data_richiesta = (Date)attributes.get("data_richiesta");

		if (data_richiesta != null) {
			setData_richiesta(data_richiesta);
		}

		String allegato = (String)attributes.get("allegato");

		if (allegato != null) {
			setAllegato(allegato);
		}

		String pdf = (String)attributes.get("pdf");

		if (pdf != null) {
			setPdf(pdf);
		}
	}

	@Override
	public RichLavAgile toEscapedModel() {
		return new RichLavAgileWrapper(_richLavAgile.toEscapedModel());
	}

	@Override
	public RichLavAgile toUnescapedModel() {
		return new RichLavAgileWrapper(_richLavAgile.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _richLavAgile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richLavAgile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richLavAgile.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richLavAgile.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<RichLavAgile> toCacheModel() {
		return _richLavAgile.toCacheModel();
	}

	@Override
	public int compareTo(RichLavAgile richLavAgile) {
		return _richLavAgile.compareTo(richLavAgile);
	}

	/**
	* Returns the peso_tot of this rich lav agile.
	*
	* @return the peso_tot of this rich lav agile
	*/
	@Override
	public int getPeso_tot() {
		return _richLavAgile.getPeso_tot();
	}

	@Override
	public int hashCode() {
		return _richLavAgile.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richLavAgile.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichLavAgileWrapper((RichLavAgile)_richLavAgile.clone());
	}

	/**
	* Returns the allegato of this rich lav agile.
	*
	* @return the allegato of this rich lav agile
	*/
	@Override
	public java.lang.String getAllegato() {
		return _richLavAgile.getAllegato();
	}

	/**
	* Returns the bando of this rich lav agile.
	*
	* @return the bando of this rich lav agile
	*/
	@Override
	public java.lang.String getBando() {
		return _richLavAgile.getBando();
	}

	/**
	* Returns the cognome of this rich lav agile.
	*
	* @return the cognome of this rich lav agile
	*/
	@Override
	public java.lang.String getCognome() {
		return _richLavAgile.getCognome();
	}

	/**
	* Returns the json_richiedente of this rich lav agile.
	*
	* @return the json_richiedente of this rich lav agile
	*/
	@Override
	public java.lang.String getJson_richiedente() {
		return _richLavAgile.getJson_richiedente();
	}

	/**
	* Returns the json_richiesta of this rich lav agile.
	*
	* @return the json_richiesta of this rich lav agile
	*/
	@Override
	public java.lang.String getJson_richiesta() {
		return _richLavAgile.getJson_richiesta();
	}

	/**
	* Returns the nome of this rich lav agile.
	*
	* @return the nome of this rich lav agile
	*/
	@Override
	public java.lang.String getNome() {
		return _richLavAgile.getNome();
	}

	/**
	* Returns the pdf of this rich lav agile.
	*
	* @return the pdf of this rich lav agile
	*/
	@Override
	public java.lang.String getPdf() {
		return _richLavAgile.getPdf();
	}

	/**
	* Returns the peso_plus of this rich lav agile.
	*
	* @return the peso_plus of this rich lav agile
	*/
	@Override
	public java.lang.String getPeso_plus() {
		return _richLavAgile.getPeso_plus();
	}

	/**
	* Returns the screename of this rich lav agile.
	*
	* @return the screename of this rich lav agile
	*/
	@Override
	public java.lang.String getScreename() {
		return _richLavAgile.getScreename();
	}

	@Override
	public java.lang.String toString() {
		return _richLavAgile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richLavAgile.toXmlString();
	}

	/**
	* Returns the data_richiesta of this rich lav agile.
	*
	* @return the data_richiesta of this rich lav agile
	*/
	@Override
	public Date getData_richiesta() {
		return _richLavAgile.getData_richiesta();
	}

	/**
	* Returns the dipartimento of this rich lav agile.
	*
	* @return the dipartimento of this rich lav agile
	*/
	@Override
	public long getDipartimento() {
		return _richLavAgile.getDipartimento();
	}

	/**
	* Returns the direzione of this rich lav agile.
	*
	* @return the direzione of this rich lav agile
	*/
	@Override
	public long getDirezione() {
		return _richLavAgile.getDirezione();
	}

	/**
	* Returns the ID of this rich lav agile.
	*
	* @return the ID of this rich lav agile
	*/
	@Override
	public long getId() {
		return _richLavAgile.getId();
	}

	/**
	* Returns the id_richiesta of this rich lav agile.
	*
	* @return the id_richiesta of this rich lav agile
	*/
	@Override
	public long getId_richiesta() {
		return _richLavAgile.getId_richiesta();
	}

	/**
	* Returns the primary key of this rich lav agile.
	*
	* @return the primary key of this rich lav agile
	*/
	@Override
	public long getPrimaryKey() {
		return _richLavAgile.getPrimaryKey();
	}

	/**
	* Returns the ufficio of this rich lav agile.
	*
	* @return the ufficio of this rich lav agile
	*/
	@Override
	public long getUfficio() {
		return _richLavAgile.getUfficio();
	}

	@Override
	public void persist() {
		_richLavAgile.persist();
	}

	/**
	* Sets the allegato of this rich lav agile.
	*
	* @param allegato the allegato of this rich lav agile
	*/
	@Override
	public void setAllegato(java.lang.String allegato) {
		_richLavAgile.setAllegato(allegato);
	}

	/**
	* Sets the bando of this rich lav agile.
	*
	* @param bando the bando of this rich lav agile
	*/
	@Override
	public void setBando(java.lang.String bando) {
		_richLavAgile.setBando(bando);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richLavAgile.setCachedModel(cachedModel);
	}

	/**
	* Sets the cognome of this rich lav agile.
	*
	* @param cognome the cognome of this rich lav agile
	*/
	@Override
	public void setCognome(java.lang.String cognome) {
		_richLavAgile.setCognome(cognome);
	}

	/**
	* Sets the data_richiesta of this rich lav agile.
	*
	* @param data_richiesta the data_richiesta of this rich lav agile
	*/
	@Override
	public void setData_richiesta(Date data_richiesta) {
		_richLavAgile.setData_richiesta(data_richiesta);
	}

	/**
	* Sets the dipartimento of this rich lav agile.
	*
	* @param dipartimento the dipartimento of this rich lav agile
	*/
	@Override
	public void setDipartimento(long dipartimento) {
		_richLavAgile.setDipartimento(dipartimento);
	}

	/**
	* Sets the direzione of this rich lav agile.
	*
	* @param direzione the direzione of this rich lav agile
	*/
	@Override
	public void setDirezione(long direzione) {
		_richLavAgile.setDirezione(direzione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richLavAgile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richLavAgile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richLavAgile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this rich lav agile.
	*
	* @param id the ID of this rich lav agile
	*/
	@Override
	public void setId(long id) {
		_richLavAgile.setId(id);
	}

	/**
	* Sets the id_richiesta of this rich lav agile.
	*
	* @param id_richiesta the id_richiesta of this rich lav agile
	*/
	@Override
	public void setId_richiesta(long id_richiesta) {
		_richLavAgile.setId_richiesta(id_richiesta);
	}

	/**
	* Sets the json_richiedente of this rich lav agile.
	*
	* @param json_richiedente the json_richiedente of this rich lav agile
	*/
	@Override
	public void setJson_richiedente(java.lang.String json_richiedente) {
		_richLavAgile.setJson_richiedente(json_richiedente);
	}

	/**
	* Sets the json_richiesta of this rich lav agile.
	*
	* @param json_richiesta the json_richiesta of this rich lav agile
	*/
	@Override
	public void setJson_richiesta(java.lang.String json_richiesta) {
		_richLavAgile.setJson_richiesta(json_richiesta);
	}

	@Override
	public void setNew(boolean n) {
		_richLavAgile.setNew(n);
	}

	/**
	* Sets the nome of this rich lav agile.
	*
	* @param nome the nome of this rich lav agile
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_richLavAgile.setNome(nome);
	}

	/**
	* Sets the pdf of this rich lav agile.
	*
	* @param pdf the pdf of this rich lav agile
	*/
	@Override
	public void setPdf(java.lang.String pdf) {
		_richLavAgile.setPdf(pdf);
	}

	/**
	* Sets the peso_plus of this rich lav agile.
	*
	* @param peso_plus the peso_plus of this rich lav agile
	*/
	@Override
	public void setPeso_plus(java.lang.String peso_plus) {
		_richLavAgile.setPeso_plus(peso_plus);
	}

	/**
	* Sets the peso_tot of this rich lav agile.
	*
	* @param peso_tot the peso_tot of this rich lav agile
	*/
	@Override
	public void setPeso_tot(int peso_tot) {
		_richLavAgile.setPeso_tot(peso_tot);
	}

	/**
	* Sets the primary key of this rich lav agile.
	*
	* @param primaryKey the primary key of this rich lav agile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richLavAgile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richLavAgile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the screename of this rich lav agile.
	*
	* @param screename the screename of this rich lav agile
	*/
	@Override
	public void setScreename(java.lang.String screename) {
		_richLavAgile.setScreename(screename);
	}

	/**
	* Sets the ufficio of this rich lav agile.
	*
	* @param ufficio the ufficio of this rich lav agile
	*/
	@Override
	public void setUfficio(long ufficio) {
		_richLavAgile.setUfficio(ufficio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichLavAgileWrapper)) {
			return false;
		}

		RichLavAgileWrapper richLavAgileWrapper = (RichLavAgileWrapper)obj;

		if (Objects.equals(_richLavAgile, richLavAgileWrapper._richLavAgile)) {
			return true;
		}

		return false;
	}

	@Override
	public RichLavAgile getWrappedModel() {
		return _richLavAgile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richLavAgile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richLavAgile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richLavAgile.resetOriginalValues();
	}

	private final RichLavAgile _richLavAgile;
}