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

package mef.webcontent.config.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the WebContentConfig service. Represents a row in the &quot;MEFWCONT_WebContentConfig&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WebContentConfigModel
 * @see mef.webcontent.config.model.impl.WebContentConfigImpl
 * @see mef.webcontent.config.model.impl.WebContentConfigModelImpl
 * @generated
 */
@ImplementationClassName("mef.webcontent.config.model.impl.WebContentConfigImpl")
@ProviderType
public interface WebContentConfig extends WebContentConfigModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link mef.webcontent.config.model.impl.WebContentConfigImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WebContentConfig, Long> CONTENTID_ACCESSOR = new Accessor<WebContentConfig, Long>() {
			@Override
			public Long get(WebContentConfig webContentConfig) {
				return webContentConfig.getContentid();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<WebContentConfig> getTypeClass() {
				return WebContentConfig.class;
			}
		};
}