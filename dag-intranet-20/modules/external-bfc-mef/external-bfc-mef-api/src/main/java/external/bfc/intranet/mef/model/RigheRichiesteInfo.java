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
 * The extended model interface for the RigheRichiesteInfo service. Represents a row in the &quot;NEW_RIGHE_RICHIESTA_BFC_INFO&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiesteInfoModel
 * @see external.bfc.intranet.mef.model.impl.RigheRichiesteInfoImpl
 * @see external.bfc.intranet.mef.model.impl.RigheRichiesteInfoModelImpl
 * @generated
 */
@ImplementationClassName("external.bfc.intranet.mef.model.impl.RigheRichiesteInfoImpl")
@ProviderType
public interface RigheRichiesteInfo extends RigheRichiesteInfoModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link external.bfc.intranet.mef.model.impl.RigheRichiesteInfoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RigheRichiesteInfo, Long> ID_ACCESSOR = new Accessor<RigheRichiesteInfo, Long>() {
			@Override
			public Long get(RigheRichiesteInfo righeRichiesteInfo) {
				return righeRichiesteInfo.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RigheRichiesteInfo> getTypeClass() {
				return RigheRichiesteInfo.class;
			}
		};

	public static final Accessor<RigheRichiesteInfo, Long> ID_MATERIALE_ACCESSOR =
		new Accessor<RigheRichiesteInfo, Long>() {
			@Override
			public Long get(RigheRichiesteInfo righeRichiesteInfo) {
				return righeRichiesteInfo.getIdMateriale();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RigheRichiesteInfo> getTypeClass() {
				return RigheRichiesteInfo.class;
			}
		};

	public static final Accessor<RigheRichiesteInfo, String> SOTTOGRUPPO_ACCESSOR =
		new Accessor<RigheRichiesteInfo, String>() {
			@Override
			public String get(RigheRichiesteInfo righeRichiesteInfo) {
				return righeRichiesteInfo.getSottogruppo();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<RigheRichiesteInfo> getTypeClass() {
				return RigheRichiesteInfo.class;
			}
		};

	public static final Accessor<RigheRichiesteInfo, String> GRUPPO_ACCESSOR = new Accessor<RigheRichiesteInfo, String>() {
			@Override
			public String get(RigheRichiesteInfo righeRichiesteInfo) {
				return righeRichiesteInfo.getGruppo();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<RigheRichiesteInfo> getTypeClass() {
				return RigheRichiesteInfo.class;
			}
		};
}