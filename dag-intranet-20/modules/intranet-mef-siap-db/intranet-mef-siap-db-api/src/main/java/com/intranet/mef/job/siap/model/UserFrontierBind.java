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

package com.intranet.mef.job.siap.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UserFrontierBind service. Represents a row in the &quot;LF_FRONTIERA&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserFrontierBindModel
 * @see com.intranet.mef.job.siap.model.impl.UserFrontierBindImpl
 * @see com.intranet.mef.job.siap.model.impl.UserFrontierBindModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.job.siap.model.impl.UserFrontierBindImpl")
@ProviderType
public interface UserFrontierBind extends UserFrontierBindModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.job.siap.model.impl.UserFrontierBindImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserFrontierBind, Long> PERSONAL_ID_ACCESSOR = new Accessor<UserFrontierBind, Long>() {
			@Override
			public Long get(UserFrontierBind userFrontierBind) {
				return userFrontierBind.getPersonalId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserFrontierBind> getTypeClass() {
				return UserFrontierBind.class;
			}
		};

	public static final Accessor<UserFrontierBind, String> SCREEN_NAME_ACCESSOR = new Accessor<UserFrontierBind, String>() {
			@Override
			public String get(UserFrontierBind userFrontierBind) {
				return userFrontierBind.getScreenName();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<UserFrontierBind> getTypeClass() {
				return UserFrontierBind.class;
			}
		};
}