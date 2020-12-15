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

package com.intranet.mef.assistance.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Topic;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Topic in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Topic
 * @generated
 */
@ProviderType
public class TopicCacheModel implements CacheModel<Topic>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicCacheModel)) {
			return false;
		}

		TopicCacheModel topicCacheModel = (TopicCacheModel)obj;

		if (topicId.equals(topicCacheModel.topicId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, topicId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", topicId=");
		sb.append(topicId);
		sb.append(", topicName=");
		sb.append(topicName);
		sb.append(", areaId=");
		sb.append(areaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Topic toEntityModel() {
		TopicImpl topicImpl = new TopicImpl();

		if (uuid == null) {
			topicImpl.setUuid(StringPool.BLANK);
		}
		else {
			topicImpl.setUuid(uuid);
		}

		if (topicId == null) {
			topicImpl.setTopicId(StringPool.BLANK);
		}
		else {
			topicImpl.setTopicId(topicId);
		}

		if (topicName == null) {
			topicImpl.setTopicName(StringPool.BLANK);
		}
		else {
			topicImpl.setTopicName(topicName);
		}

		if (areaId == null) {
			topicImpl.setAreaId(StringPool.BLANK);
		}
		else {
			topicImpl.setAreaId(areaId);
		}

		topicImpl.resetOriginalValues();

		return topicImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		topicId = objectInput.readUTF();
		topicName = objectInput.readUTF();
		areaId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (topicId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topicId);
		}

		if (topicName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topicName);
		}

		if (areaId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaId);
		}
	}

	public String uuid;
	public String topicId;
	public String topicName;
	public String areaId;
}