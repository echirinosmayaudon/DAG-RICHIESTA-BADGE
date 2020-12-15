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

package service.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the RichiestaPubblicSiti service. Represents a row in the &quot;MFORM_RichiestaPubblicSiti&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPubblicSitiModel
 * @see service.intranet.mef.model.impl.RichiestaPubblicSitiImpl
 * @see service.intranet.mef.model.impl.RichiestaPubblicSitiModelImpl
 * @generated
 */
@ImplementationClassName("service.intranet.mef.model.impl.RichiestaPubblicSitiImpl")
@ProviderType
public interface RichiestaPubblicSiti extends RichiestaPubblicSitiModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link service.intranet.mef.model.impl.RichiestaPubblicSitiImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RichiestaPubblicSiti, Long> ID_RICH_PUBBLIC_ACCESSOR =
		new Accessor<RichiestaPubblicSiti, Long>() {
			@Override
			public Long get(RichiestaPubblicSiti richiestaPubblicSiti) {
				return richiestaPubblicSiti.getId_rich_pubblic();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RichiestaPubblicSiti> getTypeClass() {
				return RichiestaPubblicSiti.class;
			}
		};
}