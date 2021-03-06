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

package mef.webcontent.config.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the WebContentConfig service. Represents a row in the &quot;MEFWCONT_WebContentConfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link mef.webcontent.config.model.impl.WebContentConfigModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link mef.webcontent.config.model.impl.WebContentConfigImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebContentConfig
 * @see mef.webcontent.config.model.impl.WebContentConfigImpl
 * @see mef.webcontent.config.model.impl.WebContentConfigModelImpl
 * @generated
 */
@ProviderType
public interface WebContentConfigModel extends BaseModel<WebContentConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a web content config model instance should use the {@link WebContentConfig} interface instead.
	 */

	/**
	 * Returns the primary key of this web content config.
	 *
	 * @return the primary key of this web content config
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this web content config.
	 *
	 * @param primaryKey the primary key of this web content config
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the contentid of this web content config.
	 *
	 * @return the contentid of this web content config
	 */
	public long getContentid();

	/**
	 * Sets the contentid of this web content config.
	 *
	 * @param contentid the contentid of this web content config
	 */
	public void setContentid(long contentid);

	/**
	 * Returns the html of this web content config.
	 *
	 * @return the html of this web content config
	 */
	@AutoEscape
	public String getHtml();

	/**
	 * Sets the html of this web content config.
	 *
	 * @param html the html of this web content config
	 */
	public void setHtml(String html);

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
		mef.webcontent.config.model.WebContentConfig webContentConfig);

	@Override
	public int hashCode();

	@Override
	public CacheModel<mef.webcontent.config.model.WebContentConfig> toCacheModel();

	@Override
	public mef.webcontent.config.model.WebContentConfig toEscapedModel();

	@Override
	public mef.webcontent.config.model.WebContentConfig toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}