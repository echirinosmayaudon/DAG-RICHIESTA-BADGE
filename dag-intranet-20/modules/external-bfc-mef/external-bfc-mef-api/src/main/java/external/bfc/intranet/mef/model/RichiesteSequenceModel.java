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

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the RichiesteSequence service. Represents a row in the &quot;LF_SEQ_BFC_READ&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link external.bfc.intranet.mef.model.impl.RichiesteSequenceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link external.bfc.intranet.mef.model.impl.RichiesteSequenceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequence
 * @see external.bfc.intranet.mef.model.impl.RichiesteSequenceImpl
 * @see external.bfc.intranet.mef.model.impl.RichiesteSequenceModelImpl
 * @generated
 */
@ProviderType
public interface RichiesteSequenceModel extends BaseModel<RichiesteSequence> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a richieste sequence model instance should use the {@link RichiesteSequence} interface instead.
	 */

	/**
	 * Returns the primary key of this richieste sequence.
	 *
	 * @return the primary key of this richieste sequence
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this richieste sequence.
	 *
	 * @param primaryKey the primary key of this richieste sequence
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id seq of this richieste sequence.
	 *
	 * @return the id seq of this richieste sequence
	 */
	public long getIdSeq();

	/**
	 * Sets the id seq of this richieste sequence.
	 *
	 * @param idSeq the id seq of this richieste sequence
	 */
	public void setIdSeq(long idSeq);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		external.bfc.intranet.mef.model.RichiesteSequence richiesteSequence);

	@Override
	public int hashCode();

	@Override
	public CacheModel<external.bfc.intranet.mef.model.RichiesteSequence> toCacheModel();

	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence toEscapedModel();

	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}