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

package servizio.richiesta.trasporti.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Mobilita service. Represents a row in the &quot;LF_MOBILITA&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MobilitaModel
 * @see servizio.richiesta.trasporti.model.impl.MobilitaImpl
 * @see servizio.richiesta.trasporti.model.impl.MobilitaModelImpl
 * @generated
 */
@ImplementationClassName("servizio.richiesta.trasporti.model.impl.MobilitaImpl")
@ProviderType
public interface Mobilita extends MobilitaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.richiesta.trasporti.model.impl.MobilitaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Mobilita, String> CUSTOM_KEY_ACCESSOR = new Accessor<Mobilita, String>() {
			@Override
			public String get(Mobilita mobilita) {
				return mobilita.getCustom_key();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Mobilita> getTypeClass() {
				return Mobilita.class;
			}
		};
}