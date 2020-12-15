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

package com.intranet.mef.assistance.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Faq service. Represents a row in the &quot;Assistance_Faq&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FaqModel
 * @see com.intranet.mef.assistance.model.impl.FaqImpl
 * @see com.intranet.mef.assistance.model.impl.FaqModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.assistance.model.impl.FaqImpl")
@ProviderType
public interface Faq extends FaqModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.assistance.model.impl.FaqImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Faq, String> FAQ_ID_ACCESSOR = new Accessor<Faq, String>() {
			@Override
			public String get(Faq faq) {
				return faq.getFaqId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Faq> getTypeClass() {
				return Faq.class;
			}
		};

	public static final Accessor<Faq, String> SIEBEL_ID_ACCESSOR = new Accessor<Faq, String>() {
			@Override
			public String get(Faq faq) {
				return faq.getSiebelId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Faq> getTypeClass() {
				return Faq.class;
			}
		};
}