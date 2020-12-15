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

package com.accenture.lavoro.agile.istanza.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the OpzioneRich service. Represents a row in the &quot;MEFISTAGILE_OpzioneRich&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRichModel
 * @see com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichImpl
 * @see com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichModelImpl
 * @generated
 */
@ImplementationClassName("com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichImpl")
@ProviderType
public interface OpzioneRich extends OpzioneRichModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<OpzioneRich, Long> ID_OPT_ACCESSOR = new Accessor<OpzioneRich, Long>() {
			@Override
			public Long get(OpzioneRich opzioneRich) {
				return opzioneRich.getId_opt();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<OpzioneRich> getTypeClass() {
				return OpzioneRich.class;
			}
		};
}