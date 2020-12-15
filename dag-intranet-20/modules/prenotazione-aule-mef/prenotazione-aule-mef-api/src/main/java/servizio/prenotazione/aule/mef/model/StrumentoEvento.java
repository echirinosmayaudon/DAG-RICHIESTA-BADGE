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
 * The extended model interface for the StrumentoEvento service. Represents a row in the &quot;MEFAULE_StrumentoEvento&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoEventoModel
 * @see servizio.prenotazione.aule.mef.model.impl.StrumentoEventoImpl
 * @see servizio.prenotazione.aule.mef.model.impl.StrumentoEventoModelImpl
 * @generated
 */
@ImplementationClassName("servizio.prenotazione.aule.mef.model.impl.StrumentoEventoImpl")
@ProviderType
public interface StrumentoEvento extends StrumentoEventoModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.prenotazione.aule.mef.model.impl.StrumentoEventoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StrumentoEvento, Long> ID_STRUMENTO_ACCESSOR = new Accessor<StrumentoEvento, Long>() {
			@Override
			public Long get(StrumentoEvento strumentoEvento) {
				return strumentoEvento.getId_strumento();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StrumentoEvento> getTypeClass() {
				return StrumentoEvento.class;
			}
		};
}