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

package autorizzazione.dir.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Scrivania service. Represents a row in the &quot;MEFSERV_Scrivania&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaModel
 * @see autorizzazione.dir.mef.model.impl.ScrivaniaImpl
 * @see autorizzazione.dir.mef.model.impl.ScrivaniaModelImpl
 * @generated
 */
@ImplementationClassName("autorizzazione.dir.mef.model.impl.ScrivaniaImpl")
@ProviderType
public interface Scrivania extends ScrivaniaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link autorizzazione.dir.mef.model.impl.ScrivaniaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Scrivania, Long> USER_ID_ACCESSOR = new Accessor<Scrivania, Long>() {
			@Override
			public Long get(Scrivania scrivania) {
				return scrivania.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Scrivania> getTypeClass() {
				return Scrivania.class;
			}
		};

	public static final Accessor<Scrivania, Long> APPLICATION_ID_ACCESSOR = new Accessor<Scrivania, Long>() {
			@Override
			public Long get(Scrivania scrivania) {
				return scrivania.getApplicationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Scrivania> getTypeClass() {
				return Scrivania.class;
			}
		};
}