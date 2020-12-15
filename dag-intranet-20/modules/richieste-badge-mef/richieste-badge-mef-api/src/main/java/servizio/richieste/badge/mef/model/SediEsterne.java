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

package servizio.richieste.badge.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SediEsterne service. Represents a row in the &quot;MBADGE_SediEsterne&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SediEsterneModel
 * @see servizio.richieste.badge.mef.model.impl.SediEsterneImpl
 * @see servizio.richieste.badge.mef.model.impl.SediEsterneModelImpl
 * @generated
 */
@ImplementationClassName("servizio.richieste.badge.mef.model.impl.SediEsterneImpl")
@ProviderType
public interface SediEsterne extends SediEsterneModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.richieste.badge.mef.model.impl.SediEsterneImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SediEsterne, Long> ID_SEDE_ESTERNA_ACCESSOR = new Accessor<SediEsterne, Long>() {
			@Override
			public Long get(SediEsterne sediEsterne) {
				return sediEsterne.getId_sede_esterna();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SediEsterne> getTypeClass() {
				return SediEsterne.class;
			}
		};
}