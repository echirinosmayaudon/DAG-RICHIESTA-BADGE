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
 * The extended model interface for the PersonalAbsence service. Represents a row in the &quot;LF_ASS_PERSONALE&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsenceModel
 * @see com.intranet.mef.job.siap.model.impl.PersonalAbsenceImpl
 * @see com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.job.siap.model.impl.PersonalAbsenceImpl")
@ProviderType
public interface PersonalAbsence extends PersonalAbsenceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.job.siap.model.impl.PersonalAbsenceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PersonalAbsence, String> CUSTOM_KEY_ACCESSOR = new Accessor<PersonalAbsence, String>() {
			@Override
			public String get(PersonalAbsence personalAbsence) {
				return personalAbsence.getCustom_key();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<PersonalAbsence> getTypeClass() {
				return PersonalAbsence.class;
			}
		};
}