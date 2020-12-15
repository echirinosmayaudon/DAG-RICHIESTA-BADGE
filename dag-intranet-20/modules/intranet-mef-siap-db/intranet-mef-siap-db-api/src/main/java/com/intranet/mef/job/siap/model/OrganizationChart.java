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
 * The extended model interface for the OrganizationChart service. Represents a row in the &quot;LF_ORGANIGRAMMA&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChartModel
 * @see com.intranet.mef.job.siap.model.impl.OrganizationChartImpl
 * @see com.intranet.mef.job.siap.model.impl.OrganizationChartModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.job.siap.model.impl.OrganizationChartImpl")
@ProviderType
public interface OrganizationChart extends OrganizationChartModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.job.siap.model.impl.OrganizationChartImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<OrganizationChart, Long> ID_ORG_CHART_ACCESSOR = new Accessor<OrganizationChart, Long>() {
			@Override
			public Long get(OrganizationChart organizationChart) {
				return organizationChart.getIdOrgChart();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<OrganizationChart> getTypeClass() {
				return OrganizationChart.class;
			}
		};
}