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
 * This class is a wrapper for {@link RichiesteSequence}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequence
 * @generated
 */
@ProviderType
public class RichiesteSequenceWrapper implements RichiesteSequence,
	ModelWrapper<RichiesteSequence> {
	public RichiesteSequenceWrapper(RichiesteSequence richiesteSequence) {
		_richiesteSequence = richiesteSequence;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiesteSequence.class;
	}

	@Override
	public String getModelClassName() {
		return RichiesteSequence.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idSeq", getIdSeq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idSeq = (Long)attributes.get("idSeq");

		if (idSeq != null) {
			setIdSeq(idSeq);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _richiesteSequence.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiesteSequence.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiesteSequence.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiesteSequence.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<external.bfc.intranet.mef.model.RichiesteSequence> toCacheModel() {
		return _richiesteSequence.toCacheModel();
	}

	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence toEscapedModel() {
		return new RichiesteSequenceWrapper(_richiesteSequence.toEscapedModel());
	}

	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence toUnescapedModel() {
		return new RichiesteSequenceWrapper(_richiesteSequence.toUnescapedModel());
	}

	@Override
	public int compareTo(
		external.bfc.intranet.mef.model.RichiesteSequence richiesteSequence) {
		return _richiesteSequence.compareTo(richiesteSequence);
	}

	@Override
	public int hashCode() {
		return _richiesteSequence.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiesteSequence.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiesteSequenceWrapper((RichiesteSequence)_richiesteSequence.clone());
	}

	@Override
	public java.lang.String toString() {
		return _richiesteSequence.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiesteSequence.toXmlString();
	}

	/**
	* Returns the id seq of this richieste sequence.
	*
	* @return the id seq of this richieste sequence
	*/
	@Override
	public long getIdSeq() {
		return _richiesteSequence.getIdSeq();
	}

	/**
	* Returns the primary key of this richieste sequence.
	*
	* @return the primary key of this richieste sequence
	*/
	@Override
	public long getPrimaryKey() {
		return _richiesteSequence.getPrimaryKey();
	}

	@Override
	public void persist() {
		_richiesteSequence.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiesteSequence.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiesteSequence.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiesteSequence.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiesteSequence.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id seq of this richieste sequence.
	*
	* @param idSeq the id seq of this richieste sequence
	*/
	@Override
	public void setIdSeq(long idSeq) {
		_richiesteSequence.setIdSeq(idSeq);
	}

	@Override
	public void setNew(boolean n) {
		_richiesteSequence.setNew(n);
	}

	/**
	* Sets the primary key of this richieste sequence.
	*
	* @param primaryKey the primary key of this richieste sequence
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiesteSequence.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiesteSequence.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteSequenceWrapper)) {
			return false;
		}

		RichiesteSequenceWrapper richiesteSequenceWrapper = (RichiesteSequenceWrapper)obj;

		if (Objects.equals(_richiesteSequence,
					richiesteSequenceWrapper._richiesteSequence)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiesteSequence getWrappedModel() {
		return _richiesteSequence;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiesteSequence.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiesteSequence.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiesteSequence.resetOriginalValues();
	}

	private final RichiesteSequence _richiesteSequence;
}