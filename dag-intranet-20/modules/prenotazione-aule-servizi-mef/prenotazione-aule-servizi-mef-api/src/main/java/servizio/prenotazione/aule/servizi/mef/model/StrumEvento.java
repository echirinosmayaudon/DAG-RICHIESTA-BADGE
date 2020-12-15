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

package servizio.prenotazione.aule.servizi.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the StrumEvento service. Represents a row in the &quot;MEFAULESERV_StrumEvento&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StrumEventoModel
 * @see servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoImpl
 * @see servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoModelImpl
 * @generated
 */
@ImplementationClassName("servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoImpl")
@ProviderType
public interface StrumEvento extends StrumEventoModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StrumEvento, Long> ID_STRUM_ACCESSOR = new Accessor<StrumEvento, Long>() {
			@Override
			public Long get(StrumEvento strumEvento) {
				return strumEvento.getId_strum();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StrumEvento> getTypeClass() {
				return StrumEvento.class;
			}
		};

	public static final Accessor<StrumEvento, Long> ID_SALA_ACCESSOR = new Accessor<StrumEvento, Long>() {
			@Override
			public Long get(StrumEvento strumEvento) {
				return strumEvento.getId_sala();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StrumEvento> getTypeClass() {
				return StrumEvento.class;
			}
		};
}