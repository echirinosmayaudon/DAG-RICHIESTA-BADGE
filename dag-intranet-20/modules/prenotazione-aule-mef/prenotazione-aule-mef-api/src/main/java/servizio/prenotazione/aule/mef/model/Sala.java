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

package servizio.prenotazione.aule.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Sala service. Represents a row in the &quot;MEFAULE_Sala&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SalaModel
 * @see servizio.prenotazione.aule.mef.model.impl.SalaImpl
 * @see servizio.prenotazione.aule.mef.model.impl.SalaModelImpl
 * @generated
 */
@ImplementationClassName("servizio.prenotazione.aule.mef.model.impl.SalaImpl")
@ProviderType
public interface Sala extends SalaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.prenotazione.aule.mef.model.impl.SalaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Sala, Long> ID_SALA_ACCESSOR = new Accessor<Sala, Long>() {
			@Override
			public Long get(Sala sala) {
				return sala.getId_sala();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Sala> getTypeClass() {
				return Sala.class;
			}
		};
}