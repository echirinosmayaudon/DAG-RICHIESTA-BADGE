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

package mef.richieste.figli.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the RICHIESTA_RIMBORSO service. Represents a row in the &quot;MFORM_RICHIESTA_RIMBORSO&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RICHIESTA_RIMBORSOModel
 * @generated
 */
@ImplementationClassName(
	"mef.richieste.figli.model.impl.RICHIESTA_RIMBORSOImpl"
)
@ProviderType
public interface RICHIESTA_RIMBORSO
	extends PersistedModel, RICHIESTA_RIMBORSOModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>mef.richieste.figli.model.impl.RICHIESTA_RIMBORSOImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RICHIESTA_RIMBORSO, Long> ID_ACCESSOR =
		new Accessor<RICHIESTA_RIMBORSO, Long>() {

			@Override
			public Long get(RICHIESTA_RIMBORSO richiesta_rimborso) {
				return richiesta_rimborso.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RICHIESTA_RIMBORSO> getTypeClass() {
				return RICHIESTA_RIMBORSO.class;
			}

		};

}