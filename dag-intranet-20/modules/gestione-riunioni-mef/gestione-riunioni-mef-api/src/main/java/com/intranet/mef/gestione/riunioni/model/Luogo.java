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

package com.intranet.mef.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Luogo service. Represents a row in the &quot;MEF_Luogo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LuogoModel
 * @see com.intranet.mef.gestione.riunioni.model.impl.LuogoImpl
 * @see com.intranet.mef.gestione.riunioni.model.impl.LuogoModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.gestione.riunioni.model.impl.LuogoImpl")
@ProviderType
public interface Luogo extends LuogoModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.gestione.riunioni.model.impl.LuogoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Luogo, Long> ID_LUOGO_ACCESSOR = new Accessor<Luogo, Long>() {
			@Override
			public Long get(Luogo luogo) {
				return luogo.getId_luogo();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Luogo> getTypeClass() {
				return Luogo.class;
			}
		};
}