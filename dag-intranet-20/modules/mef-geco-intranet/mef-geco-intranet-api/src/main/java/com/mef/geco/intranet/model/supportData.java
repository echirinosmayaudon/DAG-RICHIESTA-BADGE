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

package com.mef.geco.intranet.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the supportData service. Represents a row in the &quot;MEFGECO_supportData&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see supportDataModel
 * @see com.mef.geco.intranet.model.impl.supportDataImpl
 * @see com.mef.geco.intranet.model.impl.supportDataModelImpl
 * @generated
 */
@ImplementationClassName("com.mef.geco.intranet.model.impl.supportDataImpl")
@ProviderType
public interface supportData extends supportDataModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.mef.geco.intranet.model.impl.supportDataImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<supportData, Long> ID_ACCESSOR = new Accessor<supportData, Long>() {
			@Override
			public Long get(supportData supportData) {
				return supportData.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<supportData> getTypeClass() {
				return supportData.class;
			}
		};
}