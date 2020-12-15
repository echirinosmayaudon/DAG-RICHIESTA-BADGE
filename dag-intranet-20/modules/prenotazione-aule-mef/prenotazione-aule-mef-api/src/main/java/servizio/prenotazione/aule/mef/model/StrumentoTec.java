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
 * The extended model interface for the StrumentoTec service. Represents a row in the &quot;MEFAULE_StrumentoTec&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTecModel
 * @see servizio.prenotazione.aule.mef.model.impl.StrumentoTecImpl
 * @see servizio.prenotazione.aule.mef.model.impl.StrumentoTecModelImpl
 * @generated
 */
@ImplementationClassName("servizio.prenotazione.aule.mef.model.impl.StrumentoTecImpl")
@ProviderType
public interface StrumentoTec extends StrumentoTecModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.prenotazione.aule.mef.model.impl.StrumentoTecImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StrumentoTec, Long> ID_STRUMENTO_ACCESSOR = new Accessor<StrumentoTec, Long>() {
			@Override
			public Long get(StrumentoTec strumentoTec) {
				return strumentoTec.getId_strumento();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StrumentoTec> getTypeClass() {
				return StrumentoTec.class;
			}
		};
}