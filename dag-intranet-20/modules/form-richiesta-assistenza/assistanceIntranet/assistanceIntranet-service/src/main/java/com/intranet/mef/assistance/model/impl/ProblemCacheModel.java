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

import com.intranet.mef.assistance.model.Problem;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Problem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Problem
 * @generated
 */
@ProviderType
public class ProblemCacheModel implements CacheModel<Problem>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProblemCacheModel)) {
			return false;
		}

		ProblemCacheModel problemCacheModel = (ProblemCacheModel)obj;

		if (problemId.equals(problemCacheModel.problemId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, problemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", problemId=");
		sb.append(problemId);
		sb.append(", problemName=");
		sb.append(problemName);
		sb.append(", topicId=");
		sb.append(topicId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Problem toEntityModel() {
		ProblemImpl problemImpl = new ProblemImpl();

		if (uuid == null) {
			problemImpl.setUuid(StringPool.BLANK);
		}
		else {
			problemImpl.setUuid(uuid);
		}

		if (problemId == null) {
			problemImpl.setProblemId(StringPool.BLANK);
		}
		else {
			problemImpl.setProblemId(problemId);
		}

		if (problemName == null) {
			problemImpl.setProblemName(StringPool.BLANK);
		}
		else {
			problemImpl.setProblemName(problemName);
		}

		if (topicId == null) {
			problemImpl.setTopicId(StringPool.BLANK);
		}
		else {
			problemImpl.setTopicId(topicId);
		}

		problemImpl.resetOriginalValues();

		return problemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		problemId = objectInput.readUTF();
		problemName = objectInput.readUTF();
		topicId = objectInput.readUTF();
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

		if (problemId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(problemId);
		}

		if (problemName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(problemName);
		}

		if (topicId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topicId);
		}
	}

	public String uuid;
	public String problemId;
	public String problemName;
	public String topicId;
}