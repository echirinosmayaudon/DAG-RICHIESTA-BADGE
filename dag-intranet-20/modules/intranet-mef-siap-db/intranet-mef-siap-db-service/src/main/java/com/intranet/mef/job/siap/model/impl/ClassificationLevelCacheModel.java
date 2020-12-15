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

package com.intranet.mef.job.siap.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.model.ClassificationLevel;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ClassificationLevel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ClassificationLevel
 * @generated
 */
@ProviderType
public class ClassificationLevelCacheModel implements CacheModel<ClassificationLevel>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClassificationLevelCacheModel)) {
			return false;
		}

		ClassificationLevelCacheModel classificationLevelCacheModel = (ClassificationLevelCacheModel)obj;

		if (levelID == classificationLevelCacheModel.levelID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, levelID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{levelID=");
		sb.append(levelID);
		sb.append(", codLegalPos=");
		sb.append(codLegalPos);
		sb.append(", descLegalPos=");
		sb.append(descLegalPos);
		sb.append(", codEconomicPos=");
		sb.append(codEconomicPos);
		sb.append(", descEconomicPos=");
		sb.append(descEconomicPos);
		sb.append(", area=");
		sb.append(area);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClassificationLevel toEntityModel() {
		ClassificationLevelImpl classificationLevelImpl = new ClassificationLevelImpl();

		classificationLevelImpl.setLevelID(levelID);

		if (codLegalPos == null) {
			classificationLevelImpl.setCodLegalPos(StringPool.BLANK);
		}
		else {
			classificationLevelImpl.setCodLegalPos(codLegalPos);
		}

		if (descLegalPos == null) {
			classificationLevelImpl.setDescLegalPos(StringPool.BLANK);
		}
		else {
			classificationLevelImpl.setDescLegalPos(descLegalPos);
		}

		if (codEconomicPos == null) {
			classificationLevelImpl.setCodEconomicPos(StringPool.BLANK);
		}
		else {
			classificationLevelImpl.setCodEconomicPos(codEconomicPos);
		}

		if (descEconomicPos == null) {
			classificationLevelImpl.setDescEconomicPos(StringPool.BLANK);
		}
		else {
			classificationLevelImpl.setDescEconomicPos(descEconomicPos);
		}

		if (area == null) {
			classificationLevelImpl.setArea(StringPool.BLANK);
		}
		else {
			classificationLevelImpl.setArea(area);
		}

		classificationLevelImpl.resetOriginalValues();

		return classificationLevelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		levelID = objectInput.readLong();
		codLegalPos = objectInput.readUTF();
		descLegalPos = objectInput.readUTF();
		codEconomicPos = objectInput.readUTF();
		descEconomicPos = objectInput.readUTF();
		area = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(levelID);

		if (codLegalPos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codLegalPos);
		}

		if (descLegalPos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descLegalPos);
		}

		if (codEconomicPos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codEconomicPos);
		}

		if (descEconomicPos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descEconomicPos);
		}

		if (area == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(area);
		}
	}

	public long levelID;
	public String codLegalPos;
	public String descLegalPos;
	public String codEconomicPos;
	public String descEconomicPos;
	public String area;
}