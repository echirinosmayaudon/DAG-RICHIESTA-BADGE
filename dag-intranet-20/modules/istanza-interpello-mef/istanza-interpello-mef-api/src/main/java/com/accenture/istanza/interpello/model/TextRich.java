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

package com.accenture.istanza.interpello.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TextRich service. Represents a row in the &quot;MEFINTERPELLO_TextRich&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TextRichModel
 * @see com.accenture.istanza.interpello.model.impl.TextRichImpl
 * @see com.accenture.istanza.interpello.model.impl.TextRichModelImpl
 * @generated
 */
@ImplementationClassName("com.accenture.istanza.interpello.model.impl.TextRichImpl")
@ProviderType
public interface TextRich extends TextRichModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.accenture.istanza.interpello.model.impl.TextRichImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TextRich, Long> ID_TEXT_ACCESSOR = new Accessor<TextRich, Long>() {
			@Override
			public Long get(TextRich textRich) {
				return textRich.getId_text();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TextRich> getTypeClass() {
				return TextRich.class;
			}
		};
}