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
 * The extended model interface for the StatoAula service. Represents a row in the &quot;MEFAULE_StatoAula&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StatoAulaModel
 * @see servizio.prenotazione.aule.mef.model.impl.StatoAulaImpl
 * @see servizio.prenotazione.aule.mef.model.impl.StatoAulaModelImpl
 * @generated
 */
@ImplementationClassName("servizio.prenotazione.aule.mef.model.impl.StatoAulaImpl")
@ProviderType
public interface StatoAula extends StatoAulaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.prenotazione.aule.mef.model.impl.StatoAulaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StatoAula, Long> ID_STATO_AULA_ACCESSOR = new Accessor<StatoAula, Long>() {
			@Override
			public Long get(StatoAula statoAula) {
				return statoAula.getId_stato_aula();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StatoAula> getTypeClass() {
				return StatoAula.class;
			}
		};
}