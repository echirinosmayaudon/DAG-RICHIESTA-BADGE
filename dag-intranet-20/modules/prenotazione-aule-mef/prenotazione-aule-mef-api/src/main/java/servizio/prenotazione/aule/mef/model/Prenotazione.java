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
 * The extended model interface for the Prenotazione service. Represents a row in the &quot;MEFAULE_Prenotazione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneModel
 * @see servizio.prenotazione.aule.mef.model.impl.PrenotazioneImpl
 * @see servizio.prenotazione.aule.mef.model.impl.PrenotazioneModelImpl
 * @generated
 */
@ImplementationClassName("servizio.prenotazione.aule.mef.model.impl.PrenotazioneImpl")
@ProviderType
public interface Prenotazione extends PrenotazioneModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.prenotazione.aule.mef.model.impl.PrenotazioneImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Prenotazione, Long> ID_PRENOTA_ACCESSOR = new Accessor<Prenotazione, Long>() {
			@Override
			public Long get(Prenotazione prenotazione) {
				return prenotazione.getId_prenota();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Prenotazione> getTypeClass() {
				return Prenotazione.class;
			}
		};
}