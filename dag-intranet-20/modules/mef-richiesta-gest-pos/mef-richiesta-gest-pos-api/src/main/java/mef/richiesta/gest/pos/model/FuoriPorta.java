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

package mef.richiesta.gest.pos.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the FuoriPorta service. Represents a row in the &quot;BADGE_POS_FuoriPorta&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FuoriPortaModel
 * @generated
 */
@ImplementationClassName("mef.richiesta.gest.pos.model.impl.FuoriPortaImpl")
@ProviderType
public interface FuoriPorta extends FuoriPortaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>mef.richiesta.gest.pos.model.impl.FuoriPortaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FuoriPorta, Long> ID_PK_FUORI_PORTA_ACCESSOR =
		new Accessor<FuoriPorta, Long>() {

			@Override
			public Long get(FuoriPorta fuoriPorta) {
				return fuoriPorta.getId_pk_fuoriPorta();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FuoriPorta> getTypeClass() {
				return FuoriPorta.class;
			}

		};

}