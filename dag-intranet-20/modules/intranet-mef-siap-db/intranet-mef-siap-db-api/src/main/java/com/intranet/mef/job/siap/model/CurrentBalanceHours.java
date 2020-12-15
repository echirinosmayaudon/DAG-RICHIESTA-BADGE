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
 * The extended model interface for the CurrentBalanceHours service. Represents a row in the &quot;LF_VIEW_SALDO_ORE_COR&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CurrentBalanceHoursModel
 * @see com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursImpl
 * @see com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursImpl")
@ProviderType
public interface CurrentBalanceHours extends CurrentBalanceHoursModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CurrentBalanceHours, Long> PERSON_ID_ACCESSOR = new Accessor<CurrentBalanceHours, Long>() {
			@Override
			public Long get(CurrentBalanceHours currentBalanceHours) {
				return currentBalanceHours.getPersonId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CurrentBalanceHours> getTypeClass() {
				return CurrentBalanceHours.class;
			}
		};
}