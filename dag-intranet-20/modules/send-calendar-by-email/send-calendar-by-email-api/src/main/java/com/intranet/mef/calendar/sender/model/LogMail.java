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

package com.intranet.mef.calendar.sender.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the LogMail service. Represents a row in the &quot;SENDCALENDAR_LogMail&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LogMailModel
 * @see com.intranet.mef.calendar.sender.model.impl.LogMailImpl
 * @see com.intranet.mef.calendar.sender.model.impl.LogMailModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.calendar.sender.model.impl.LogMailImpl")
@ProviderType
public interface LogMail extends LogMailModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.calendar.sender.model.impl.LogMailImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LogMail, Long> LOG_MAIL_ID_ACCESSOR = new Accessor<LogMail, Long>() {
			@Override
			public Long get(LogMail logMail) {
				return logMail.getLogMailId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LogMail> getTypeClass() {
				return LogMail.class;
			}
		};
}