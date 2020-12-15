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

package servizio.beni.facile.consumo.model.impl;

import aQute.bnd.annotation.ProviderType;

import servizio.beni.facile.consumo.model.RigheRichiestaBFC;
import servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalServiceUtil;

/**
 * The extended model base implementation for the RigheRichiestaBFC service. Represents a row in the &quot;MEFBFC_RigheRichiestaBFC&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RigheRichiestaBFCImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCImpl
 * @see RigheRichiestaBFC
 * @generated
 */
@ProviderType
public abstract class RigheRichiestaBFCBaseImpl
	extends RigheRichiestaBFCModelImpl implements RigheRichiestaBFC {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a righe richiesta b f c model instance should use the {@link RigheRichiestaBFC} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			RigheRichiestaBFCLocalServiceUtil.addRigheRichiestaBFC(this);
		}
		else {
			RigheRichiestaBFCLocalServiceUtil.updateRigheRichiestaBFC(this);
		}
	}
}