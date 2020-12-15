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
 * The extended model interface for the AutorizzazioneDir service. Represents a row in the &quot;MEFSERV_AutorizzazioneDir&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AutorizzazioneDirModel
 * @see autorizzazione.dir.mef.model.impl.AutorizzazioneDirImpl
 * @see autorizzazione.dir.mef.model.impl.AutorizzazioneDirModelImpl
 * @generated
 */
@ImplementationClassName("autorizzazione.dir.mef.model.impl.AutorizzazioneDirImpl")
@ProviderType
public interface AutorizzazioneDir extends AutorizzazioneDirModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link autorizzazione.dir.mef.model.impl.AutorizzazioneDirImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AutorizzazioneDir, Long> ID_AUTORIZZAZIONE_ACCESSOR =
		new Accessor<AutorizzazioneDir, Long>() {
			@Override
			public Long get(AutorizzazioneDir autorizzazioneDir) {
				return autorizzazioneDir.getId_autorizzazione();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AutorizzazioneDir> getTypeClass() {
				return AutorizzazioneDir.class;
			}
		};
}