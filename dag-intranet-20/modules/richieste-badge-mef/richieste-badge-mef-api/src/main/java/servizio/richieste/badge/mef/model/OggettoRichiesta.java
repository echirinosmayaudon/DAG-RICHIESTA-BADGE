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
 * The extended model interface for the OggettoRichiesta service. Represents a row in the &quot;MBADGE_OggettoRichiesta&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OggettoRichiestaModel
 * @see servizio.richieste.badge.mef.model.impl.OggettoRichiestaImpl
 * @see servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl
 * @generated
 */
@ImplementationClassName("servizio.richieste.badge.mef.model.impl.OggettoRichiestaImpl")
@ProviderType
public interface OggettoRichiesta extends OggettoRichiestaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.richieste.badge.mef.model.impl.OggettoRichiestaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<OggettoRichiesta, Long> ID_OGGETTO_ACCESSOR = new Accessor<OggettoRichiesta, Long>() {
			@Override
			public Long get(OggettoRichiesta oggettoRichiesta) {
				return oggettoRichiesta.getId_oggetto();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<OggettoRichiesta> getTypeClass() {
				return OggettoRichiesta.class;
			}
		};
}