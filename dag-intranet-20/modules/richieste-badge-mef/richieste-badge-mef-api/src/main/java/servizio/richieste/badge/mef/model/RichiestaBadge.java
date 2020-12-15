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

package servizio.richieste.badge.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the RichiestaBadge service. Represents a row in the &quot;MBADGE_RichiestaBadge&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgeModel
 * @see servizio.richieste.badge.mef.model.impl.RichiestaBadgeImpl
 * @see servizio.richieste.badge.mef.model.impl.RichiestaBadgeModelImpl
 * @generated
 */
@ImplementationClassName("servizio.richieste.badge.mef.model.impl.RichiestaBadgeImpl")
@ProviderType
public interface RichiestaBadge extends RichiestaBadgeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.richieste.badge.mef.model.impl.RichiestaBadgeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RichiestaBadge, Long> ID_PK_ACCESSOR = new Accessor<RichiestaBadge, Long>() {
			@Override
			public Long get(RichiestaBadge richiestaBadge) {
				return richiestaBadge.getId_pk();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RichiestaBadge> getTypeClass() {
				return RichiestaBadge.class;
			}
		};
}