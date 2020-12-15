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
 * The extended model interface for the ManagerOfficesBind service. Represents a row in the &quot;LF_DIRIGENTI&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ManagerOfficesBindModel
 * @see com.intranet.mef.job.siap.model.impl.ManagerOfficesBindImpl
 * @see com.intranet.mef.job.siap.model.impl.ManagerOfficesBindModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.job.siap.model.impl.ManagerOfficesBindImpl")
@ProviderType
public interface ManagerOfficesBind extends ManagerOfficesBindModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.job.siap.model.impl.ManagerOfficesBindImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ManagerOfficesBind, Long> PERSONAL_ID_ACCESSOR = new Accessor<ManagerOfficesBind, Long>() {
			@Override
			public Long get(ManagerOfficesBind managerOfficesBind) {
				return managerOfficesBind.getPersonalId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ManagerOfficesBind> getTypeClass() {
				return ManagerOfficesBind.class;
			}
		};

	public static final Accessor<ManagerOfficesBind, Long> ID_ORG_CHART_ACCESSOR =
		new Accessor<ManagerOfficesBind, Long>() {
			@Override
			public Long get(ManagerOfficesBind managerOfficesBind) {
				return managerOfficesBind.getIdOrgChart();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ManagerOfficesBind> getTypeClass() {
				return ManagerOfficesBind.class;
			}
		};
}