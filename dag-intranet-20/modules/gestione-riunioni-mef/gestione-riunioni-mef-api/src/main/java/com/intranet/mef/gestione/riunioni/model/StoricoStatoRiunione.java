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
 * The extended model interface for the StoricoStatoRiunione service. Represents a row in the &quot;MEF_StoricoStatoRiunione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunioneModel
 * @see com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneImpl
 * @see com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneImpl")
@ProviderType
public interface StoricoStatoRiunione extends StoricoStatoRiunioneModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StoricoStatoRiunione, Long> ID_RIUNIONE_ACCESSOR =
		new Accessor<StoricoStatoRiunione, Long>() {
			@Override
			public Long get(StoricoStatoRiunione storicoStatoRiunione) {
				return storicoStatoRiunione.getId_riunione();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StoricoStatoRiunione> getTypeClass() {
				return StoricoStatoRiunione.class;
			}
		};

	public static final Accessor<StoricoStatoRiunione, Long> ID_STORICO_ACCESSOR =
		new Accessor<StoricoStatoRiunione, Long>() {
			@Override
			public Long get(StoricoStatoRiunione storicoStatoRiunione) {
				return storicoStatoRiunione.getId_storico();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StoricoStatoRiunione> getTypeClass() {
				return StoricoStatoRiunione.class;
			}
		};
}