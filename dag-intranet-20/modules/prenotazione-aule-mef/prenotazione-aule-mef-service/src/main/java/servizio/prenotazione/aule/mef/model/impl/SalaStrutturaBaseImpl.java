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

package servizio.prenotazione.aule.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import servizio.prenotazione.aule.mef.model.SalaStruttura;
import servizio.prenotazione.aule.mef.service.SalaStrutturaLocalServiceUtil;

/**
 * The extended model base implementation for the SalaStruttura service. Represents a row in the &quot;MEFAULE_SalaStruttura&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SalaStrutturaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaStrutturaImpl
 * @see SalaStruttura
 * @generated
 */
@ProviderType
public abstract class SalaStrutturaBaseImpl extends SalaStrutturaModelImpl
	implements SalaStruttura {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sala struttura model instance should use the {@link SalaStruttura} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			SalaStrutturaLocalServiceUtil.addSalaStruttura(this);
		}
		else {
			SalaStrutturaLocalServiceUtil.updateSalaStruttura(this);
		}
	}
}