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

package external.bfc.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SediBfc service. Represents a row in the &quot;LF_SEDI_BFC&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SediBfcModel
 * @see external.bfc.intranet.mef.model.impl.SediBfcImpl
 * @see external.bfc.intranet.mef.model.impl.SediBfcModelImpl
 * @generated
 */
@ImplementationClassName("external.bfc.intranet.mef.model.impl.SediBfcImpl")
@ProviderType
public interface SediBfc extends SediBfcModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link external.bfc.intranet.mef.model.impl.SediBfcImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SediBfc, Long> ID_ACCESSOR = new Accessor<SediBfc, Long>() {
			@Override
			public Long get(SediBfc sediBfc) {
				return sediBfc.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SediBfc> getTypeClass() {
				return SediBfc.class;
			}
		};
}