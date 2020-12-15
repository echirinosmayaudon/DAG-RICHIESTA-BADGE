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
 * The extended model interface for the ServLog service. Represents a row in the &quot;MEFAULESERV_ServLog&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ServLogModel
 * @see servizio.prenotazione.aule.servizi.mef.model.impl.ServLogImpl
 * @see servizio.prenotazione.aule.servizi.mef.model.impl.ServLogModelImpl
 * @generated
 */
@ImplementationClassName("servizio.prenotazione.aule.servizi.mef.model.impl.ServLogImpl")
@ProviderType
public interface ServLog extends ServLogModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.prenotazione.aule.servizi.mef.model.impl.ServLogImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ServLog, Long> ID_SERV_ACCESSOR = new Accessor<ServLog, Long>() {
			@Override
			public Long get(ServLog servLog) {
				return servLog.getId_serv();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ServLog> getTypeClass() {
				return ServLog.class;
			}
		};

	public static final Accessor<ServLog, Long> ID_SALA_ACCESSOR = new Accessor<ServLog, Long>() {
			@Override
			public Long get(ServLog servLog) {
				return servLog.getId_sala();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ServLog> getTypeClass() {
				return ServLog.class;
			}
		};
}