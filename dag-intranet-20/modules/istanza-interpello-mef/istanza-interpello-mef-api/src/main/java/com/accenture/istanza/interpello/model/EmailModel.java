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

package com.accenture.istanza.interpello.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Email service. Represents a row in the &quot;MEFINTERPELLO_Email&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.accenture.istanza.interpello.model.impl.EmailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.accenture.istanza.interpello.model.impl.EmailImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Email
 * @see com.accenture.istanza.interpello.model.impl.EmailImpl
 * @see com.accenture.istanza.interpello.model.impl.EmailModelImpl
 * @generated
 */
@ProviderType
public interface EmailModel extends BaseModel<Email> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a email model instance should use the {@link Email} interface instead.
	 */

	/**
	 * Returns the primary key of this email.
	 *
	 * @return the primary key of this email
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this email.
	 *
	 * @param primaryKey the primary key of this email
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this email.
	 *
	 * @return the ID of this email
	 */
	public long getId();

	/**
	 * Sets the ID of this email.
	 *
	 * @param id the ID of this email
	 */
	public void setId(long id);

	/**
	 * Returns the id struttura of this email.
	 *
	 * @return the id struttura of this email
	 */
	public long getIdStruttura();

	/**
	 * Sets the id struttura of this email.
	 *
	 * @param idStruttura the id struttura of this email
	 */
	public void setIdStruttura(long idStruttura);

	/**
	 * Returns the mail cc of this email.
	 *
	 * @return the mail cc of this email
	 */
	@AutoEscape
	public String getMailCC();

	/**
	 * Sets the mail cc of this email.
	 *
	 * @param mailCC the mail cc of this email
	 */
	public void setMailCC(String mailCC);

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
	public int compareTo(Email email);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Email> toCacheModel();

	@Override
	public Email toEscapedModel();

	@Override
	public Email toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}