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

package service.intranet.mef.model;

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
 * This class is a wrapper for {@link PeriodicitaRichPubblic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PeriodicitaRichPubblic
 * @generated
 */
@ProviderType
public class PeriodicitaRichPubblicWrapper implements PeriodicitaRichPubblic,
	ModelWrapper<PeriodicitaRichPubblic> {
	public PeriodicitaRichPubblicWrapper(
		PeriodicitaRichPubblic periodicitaRichPubblic) {
		_periodicitaRichPubblic = periodicitaRichPubblic;
	}

	@Override
	public Class<?> getModelClass() {
		return PeriodicitaRichPubblic.class;
	}

	@Override
	public String getModelClassName() {
		return PeriodicitaRichPubblic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("periodicita", getPeriodicita());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String periodicita = (String)attributes.get("periodicita");

		if (periodicita != null) {
			setPeriodicita(periodicita);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _periodicitaRichPubblic.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _periodicitaRichPubblic.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _periodicitaRichPubblic.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _periodicitaRichPubblic.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.PeriodicitaRichPubblic> toCacheModel() {
		return _periodicitaRichPubblic.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.PeriodicitaRichPubblic periodicitaRichPubblic) {
		return _periodicitaRichPubblic.compareTo(periodicitaRichPubblic);
	}

	@Override
	public int hashCode() {
		return _periodicitaRichPubblic.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _periodicitaRichPubblic.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PeriodicitaRichPubblicWrapper((PeriodicitaRichPubblic)_periodicitaRichPubblic.clone());
	}

	/**
	* Returns the periodicita of this periodicita rich pubblic.
	*
	* @return the periodicita of this periodicita rich pubblic
	*/
	@Override
	public java.lang.String getPeriodicita() {
		return _periodicitaRichPubblic.getPeriodicita();
	}

	@Override
	public java.lang.String toString() {
		return _periodicitaRichPubblic.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _periodicitaRichPubblic.toXmlString();
	}

	/**
	* Returns the ID of this periodicita rich pubblic.
	*
	* @return the ID of this periodicita rich pubblic
	*/
	@Override
	public long getId() {
		return _periodicitaRichPubblic.getId();
	}

	/**
	* Returns the primary key of this periodicita rich pubblic.
	*
	* @return the primary key of this periodicita rich pubblic
	*/
	@Override
	public long getPrimaryKey() {
		return _periodicitaRichPubblic.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.PeriodicitaRichPubblic toEscapedModel() {
		return new PeriodicitaRichPubblicWrapper(_periodicitaRichPubblic.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.PeriodicitaRichPubblic toUnescapedModel() {
		return new PeriodicitaRichPubblicWrapper(_periodicitaRichPubblic.toUnescapedModel());
	}

	@Override
	public void persist() {
		_periodicitaRichPubblic.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_periodicitaRichPubblic.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_periodicitaRichPubblic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_periodicitaRichPubblic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_periodicitaRichPubblic.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this periodicita rich pubblic.
	*
	* @param id the ID of this periodicita rich pubblic
	*/
	@Override
	public void setId(long id) {
		_periodicitaRichPubblic.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_periodicitaRichPubblic.setNew(n);
	}

	/**
	* Sets the periodicita of this periodicita rich pubblic.
	*
	* @param periodicita the periodicita of this periodicita rich pubblic
	*/
	@Override
	public void setPeriodicita(java.lang.String periodicita) {
		_periodicitaRichPubblic.setPeriodicita(periodicita);
	}

	/**
	* Sets the primary key of this periodicita rich pubblic.
	*
	* @param primaryKey the primary key of this periodicita rich pubblic
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_periodicitaRichPubblic.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_periodicitaRichPubblic.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PeriodicitaRichPubblicWrapper)) {
			return false;
		}

		PeriodicitaRichPubblicWrapper periodicitaRichPubblicWrapper = (PeriodicitaRichPubblicWrapper)obj;

		if (Objects.equals(_periodicitaRichPubblic,
					periodicitaRichPubblicWrapper._periodicitaRichPubblic)) {
			return true;
		}

		return false;
	}

	@Override
	public PeriodicitaRichPubblic getWrappedModel() {
		return _periodicitaRichPubblic;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _periodicitaRichPubblic.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _periodicitaRichPubblic.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_periodicitaRichPubblic.resetOriginalValues();
	}

	private final PeriodicitaRichPubblic _periodicitaRichPubblic;
}