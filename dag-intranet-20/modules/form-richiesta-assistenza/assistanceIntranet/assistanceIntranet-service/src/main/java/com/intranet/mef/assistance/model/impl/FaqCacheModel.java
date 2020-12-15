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

import com.intranet.mef.assistance.model.Faq;
import com.intranet.mef.assistance.service.persistence.FaqPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Faq in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Faq
 * @generated
 */
@ProviderType
public class FaqCacheModel implements CacheModel<Faq>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FaqCacheModel)) {
			return false;
		}

		FaqCacheModel faqCacheModel = (FaqCacheModel)obj;

		if (faqPK.equals(faqCacheModel.faqPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, faqPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", faqId=");
		sb.append(faqId);
		sb.append(", siebelId=");
		sb.append(siebelId);
		sb.append(", questions=");
		sb.append(questions);
		sb.append(", response=");
		sb.append(response);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Faq toEntityModel() {
		FaqImpl faqImpl = new FaqImpl();

		if (uuid == null) {
			faqImpl.setUuid(StringPool.BLANK);
		}
		else {
			faqImpl.setUuid(uuid);
		}

		if (faqId == null) {
			faqImpl.setFaqId(StringPool.BLANK);
		}
		else {
			faqImpl.setFaqId(faqId);
		}

		if (siebelId == null) {
			faqImpl.setSiebelId(StringPool.BLANK);
		}
		else {
			faqImpl.setSiebelId(siebelId);
		}

		if (questions == null) {
			faqImpl.setQuestions(StringPool.BLANK);
		}
		else {
			faqImpl.setQuestions(questions);
		}

		if (response == null) {
			faqImpl.setResponse(StringPool.BLANK);
		}
		else {
			faqImpl.setResponse(response);
		}

		faqImpl.resetOriginalValues();

		return faqImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		faqId = objectInput.readUTF();
		siebelId = objectInput.readUTF();
		questions = objectInput.readUTF();
		response = objectInput.readUTF();

		faqPK = new FaqPK(faqId, siebelId);
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

		if (faqId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(faqId);
		}

		if (siebelId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(siebelId);
		}

		if (questions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(questions);
		}

		if (response == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(response);
		}
	}

	public String uuid;
	public String faqId;
	public String siebelId;
	public String questions;
	public String response;
	public transient FaqPK faqPK;
}