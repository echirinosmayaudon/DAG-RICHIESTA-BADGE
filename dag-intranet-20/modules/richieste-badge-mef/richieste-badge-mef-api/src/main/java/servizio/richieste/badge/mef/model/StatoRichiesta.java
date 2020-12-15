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
 * The extended model interface for the StatoRichiesta service. Represents a row in the &quot;MBADGE_StatoRichiesta&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichiestaModel
 * @see servizio.richieste.badge.mef.model.impl.StatoRichiestaImpl
 * @see servizio.richieste.badge.mef.model.impl.StatoRichiestaModelImpl
 * @generated
 */
@ImplementationClassName("servizio.richieste.badge.mef.model.impl.StatoRichiestaImpl")
@ProviderType
public interface StatoRichiesta extends StatoRichiestaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.richieste.badge.mef.model.impl.StatoRichiestaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StatoRichiesta, Long> ID_STATO_ACCESSOR = new Accessor<StatoRichiesta, Long>() {
			@Override
			public Long get(StatoRichiesta statoRichiesta) {
				return statoRichiesta.getId_stato();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StatoRichiesta> getTypeClass() {
				return StatoRichiesta.class;
			}
		};
}