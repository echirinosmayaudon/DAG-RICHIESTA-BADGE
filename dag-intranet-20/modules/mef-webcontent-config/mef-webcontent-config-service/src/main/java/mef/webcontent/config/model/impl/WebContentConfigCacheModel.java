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

package mef.webcontent.config.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import mef.webcontent.config.model.WebContentConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WebContentConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WebContentConfig
 * @generated
 */
@ProviderType
public class WebContentConfigCacheModel implements CacheModel<WebContentConfig>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WebContentConfigCacheModel)) {
			return false;
		}

		WebContentConfigCacheModel webContentConfigCacheModel = (WebContentConfigCacheModel)obj;

		if (contentid == webContentConfigCacheModel.contentid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contentid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contentid=");
		sb.append(contentid);
		sb.append(", html=");
		sb.append(html);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WebContentConfig toEntityModel() {
		WebContentConfigImpl webContentConfigImpl = new WebContentConfigImpl();

		webContentConfigImpl.setContentid(contentid);

		if (html == null) {
			webContentConfigImpl.setHtml(StringPool.BLANK);
		}
		else {
			webContentConfigImpl.setHtml(html);
		}

		webContentConfigImpl.resetOriginalValues();

		return webContentConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contentid = objectInput.readLong();
		html = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contentid);

		if (html == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(html);
		}
	}

	public long contentid;
	public String html;
}