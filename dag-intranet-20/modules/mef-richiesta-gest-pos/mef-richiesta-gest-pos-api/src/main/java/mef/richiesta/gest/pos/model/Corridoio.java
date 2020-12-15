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

package mef.richiesta.gest.pos.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Corridoio service. Represents a row in the &quot;BADGE_POS_Corridoio&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CorridoioModel
 * @generated
 */
@ImplementationClassName("mef.richiesta.gest.pos.model.impl.CorridoioImpl")
@ProviderType
public interface Corridoio extends CorridoioModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>mef.richiesta.gest.pos.model.impl.CorridoioImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Corridoio, Long> ID_PK_CORRIDOIO_ACCESSOR =
		new Accessor<Corridoio, Long>() {

			@Override
			public Long get(Corridoio corridoio) {
				return corridoio.getId_pk_corridoio();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Corridoio> getTypeClass() {
				return Corridoio.class;
			}

		};

}