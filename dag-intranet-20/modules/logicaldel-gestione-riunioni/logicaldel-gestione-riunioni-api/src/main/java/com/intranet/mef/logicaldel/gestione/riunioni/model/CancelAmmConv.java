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

package com.intranet.mef.logicaldel.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the CancelAmmConv service. Represents a row in the &quot;LOGICALGR_CancelAmmConv&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConvModel
 * @see com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvImpl
 * @see com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvImpl")
@ProviderType
public interface CancelAmmConv extends CancelAmmConvModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CancelAmmConv, Long> ID_AMMINISTRAZIONE_CONVOCANTE_ACCESSOR =
		new Accessor<CancelAmmConv, Long>() {
			@Override
			public Long get(CancelAmmConv cancelAmmConv) {
				return cancelAmmConv.getId_amministrazione_convocante();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CancelAmmConv> getTypeClass() {
				return CancelAmmConv.class;
			}
		};
}