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

package mef.email.configurator.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the EmailApp service. Represents a row in the &quot;MEFEMAILC_EmailApp&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmailAppModel
 * @see mef.email.configurator.model.impl.EmailAppImpl
 * @see mef.email.configurator.model.impl.EmailAppModelImpl
 * @generated
 */
@ImplementationClassName("mef.email.configurator.model.impl.EmailAppImpl")
@ProviderType
public interface EmailApp extends EmailAppModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link mef.email.configurator.model.impl.EmailAppImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmailApp, Long> ID_ACCESSOR = new Accessor<EmailApp, Long>() {
			@Override
			public Long get(EmailApp emailApp) {
				return emailApp.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmailApp> getTypeClass() {
				return EmailApp.class;
			}
		};
}