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

package com.intranet.mef.calendar.sender.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.calendar.sender.model.LogMail;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LogMail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LogMail
 * @generated
 */
@ProviderType
public class LogMailCacheModel implements CacheModel<LogMail>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogMailCacheModel)) {
			return false;
		}

		LogMailCacheModel logMailCacheModel = (LogMailCacheModel)obj;

		if (logMailId == logMailCacheModel.logMailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, logMailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", logMailId=");
		sb.append(logMailId);
		sb.append(", mailTo=");
		sb.append(mailTo);
		sb.append(", eventTitle=");
		sb.append(eventTitle);
		sb.append(", eventDescription=");
		sb.append(eventDescription);
		sb.append(", dateStart=");
		sb.append(dateStart);
		sb.append(", dateFinish=");
		sb.append(dateFinish);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LogMail toEntityModel() {
		LogMailImpl logMailImpl = new LogMailImpl();

		if (uuid == null) {
			logMailImpl.setUuid(StringPool.BLANK);
		}
		else {
			logMailImpl.setUuid(uuid);
		}

		logMailImpl.setLogMailId(logMailId);

		if (mailTo == null) {
			logMailImpl.setMailTo(StringPool.BLANK);
		}
		else {
			logMailImpl.setMailTo(mailTo);
		}

		if (eventTitle == null) {
			logMailImpl.setEventTitle(StringPool.BLANK);
		}
		else {
			logMailImpl.setEventTitle(eventTitle);
		}

		if (eventDescription == null) {
			logMailImpl.setEventDescription(StringPool.BLANK);
		}
		else {
			logMailImpl.setEventDescription(eventDescription);
		}

		if (dateStart == Long.MIN_VALUE) {
			logMailImpl.setDateStart(null);
		}
		else {
			logMailImpl.setDateStart(new Date(dateStart));
		}

		if (dateFinish == Long.MIN_VALUE) {
			logMailImpl.setDateFinish(null);
		}
		else {
			logMailImpl.setDateFinish(new Date(dateFinish));
		}

		logMailImpl.resetOriginalValues();

		return logMailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		logMailId = objectInput.readLong();
		mailTo = objectInput.readUTF();
		eventTitle = objectInput.readUTF();
		eventDescription = objectInput.readUTF();
		dateStart = objectInput.readLong();
		dateFinish = objectInput.readLong();
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

		objectOutput.writeLong(logMailId);

		if (mailTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mailTo);
		}

		if (eventTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventTitle);
		}

		if (eventDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDescription);
		}

		objectOutput.writeLong(dateStart);
		objectOutput.writeLong(dateFinish);
	}

	public String uuid;
	public long logMailId;
	public String mailTo;
	public String eventTitle;
	public String eventDescription;
	public long dateStart;
	public long dateFinish;
}