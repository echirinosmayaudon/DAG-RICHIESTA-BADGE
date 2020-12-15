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

package servizio.beni.facile.consumo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the GestioneUtenti service. Represents a row in the &quot;MEFBFC_GestioneUtenti&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtentiModel
 * @see servizio.beni.facile.consumo.model.impl.GestioneUtentiImpl
 * @see servizio.beni.facile.consumo.model.impl.GestioneUtentiModelImpl
 * @generated
 */
@ImplementationClassName("servizio.beni.facile.consumo.model.impl.GestioneUtentiImpl")
@ProviderType
public interface GestioneUtenti extends GestioneUtentiModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.beni.facile.consumo.model.impl.GestioneUtentiImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GestioneUtenti, Long> ID_ACCESSOR = new Accessor<GestioneUtenti, Long>() {
			@Override
			public Long get(GestioneUtenti gestioneUtenti) {
				return gestioneUtenti.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GestioneUtenti> getTypeClass() {
				return GestioneUtenti.class;
			}
		};
}