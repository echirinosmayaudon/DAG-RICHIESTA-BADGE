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

package servizio.local.bfc.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the LocalRich service. Represents a row in the &quot;LOCBFC_LocalRich&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichModel
 * @see servizio.local.bfc.model.impl.LocalRichImpl
 * @see servizio.local.bfc.model.impl.LocalRichModelImpl
 * @generated
 */
@ImplementationClassName("servizio.local.bfc.model.impl.LocalRichImpl")
@ProviderType
public interface LocalRich extends LocalRichModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link servizio.local.bfc.model.impl.LocalRichImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LocalRich, Long> ID_ACCESSOR = new Accessor<LocalRich, Long>() {
			@Override
			public Long get(LocalRich localRich) {
				return localRich.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LocalRich> getTypeClass() {
				return LocalRich.class;
			}
		};
}