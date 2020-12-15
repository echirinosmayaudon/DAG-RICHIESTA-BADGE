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

package com.intranet.mef.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the InvitatiRiunione service. Represents a row in the &quot;MEF_InvitatiRiunione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunioneModel
 * @see com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneImpl
 * @see com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneImpl")
@ProviderType
public interface InvitatiRiunione extends InvitatiRiunioneModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<InvitatiRiunione, Long> ID_SEGRETERIA_ACCESSOR = new Accessor<InvitatiRiunione, Long>() {
			@Override
			public Long get(InvitatiRiunione invitatiRiunione) {
				return invitatiRiunione.getId_segreteria();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<InvitatiRiunione> getTypeClass() {
				return InvitatiRiunione.class;
			}
		};

	public static final Accessor<InvitatiRiunione, Long> ID_RIUNIONE_ACCESSOR = new Accessor<InvitatiRiunione, Long>() {
			@Override
			public Long get(InvitatiRiunione invitatiRiunione) {
				return invitatiRiunione.getId_riunione();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<InvitatiRiunione> getTypeClass() {
				return InvitatiRiunione.class;
			}
		};
}