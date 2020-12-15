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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the TipoBeneInv service. Represents a row in the &quot;MFORM_TipoBeneInv&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link service.intranet.mef.model.impl.TipoBeneInvModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link service.intranet.mef.model.impl.TipoBeneInvImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoBeneInv
 * @see service.intranet.mef.model.impl.TipoBeneInvImpl
 * @see service.intranet.mef.model.impl.TipoBeneInvModelImpl
 * @generated
 */
@ProviderType
public interface TipoBeneInvModel extends BaseModel<TipoBeneInv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tipo bene inv model instance should use the {@link TipoBeneInv} interface instead.
	 */

	/**
	 * Returns the primary key of this tipo bene inv.
	 *
	 * @return the primary key of this tipo bene inv
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tipo bene inv.
	 *
	 * @param primaryKey the primary key of this tipo bene inv
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this tipo bene inv.
	 *
	 * @return the ID of this tipo bene inv
	 */
	public long getId();

	/**
	 * Sets the ID of this tipo bene inv.
	 *
	 * @param id the ID of this tipo bene inv
	 */
	public void setId(long id);

	/**
	 * Returns the tipo of this tipo bene inv.
	 *
	 * @return the tipo of this tipo bene inv
	 */
	@AutoEscape
	public String getTipo();

	/**
	 * Sets the tipo of this tipo bene inv.
	 *
	 * @param tipo the tipo of this tipo bene inv
	 */
	public void setTipo(String tipo);

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
	public int compareTo(service.intranet.mef.model.TipoBeneInv tipoBeneInv);

	@Override
	public int hashCode();

	@Override
	public CacheModel<service.intranet.mef.model.TipoBeneInv> toCacheModel();

	@Override
	public service.intranet.mef.model.TipoBeneInv toEscapedModel();

	@Override
	public service.intranet.mef.model.TipoBeneInv toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}