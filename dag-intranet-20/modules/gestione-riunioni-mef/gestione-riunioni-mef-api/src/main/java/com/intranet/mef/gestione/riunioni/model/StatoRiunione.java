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
 * The extended model interface for the StatoRiunione service. Represents a row in the &quot;MEF_StatoRiunione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StatoRiunioneModel
 * @see com.intranet.mef.gestione.riunioni.model.impl.StatoRiunioneImpl
 * @see com.intranet.mef.gestione.riunioni.model.impl.StatoRiunioneModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.gestione.riunioni.model.impl.StatoRiunioneImpl")
@ProviderType
public interface StatoRiunione extends StatoRiunioneModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.gestione.riunioni.model.impl.StatoRiunioneImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StatoRiunione, Long> ID_STATO_RIUNIONE_ACCESSOR =
		new Accessor<StatoRiunione, Long>() {
			@Override
			public Long get(StatoRiunione statoRiunione) {
				return statoRiunione.getId_stato_riunione();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StatoRiunione> getTypeClass() {
				return StatoRiunione.class;
			}
		};
}