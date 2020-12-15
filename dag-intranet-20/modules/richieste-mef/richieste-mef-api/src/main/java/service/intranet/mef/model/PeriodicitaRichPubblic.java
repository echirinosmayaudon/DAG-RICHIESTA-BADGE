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

package service.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the PeriodicitaRichPubblic service. Represents a row in the &quot;MFORM_PeriodicitaRichPubblic&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PeriodicitaRichPubblicModel
 * @see service.intranet.mef.model.impl.PeriodicitaRichPubblicImpl
 * @see service.intranet.mef.model.impl.PeriodicitaRichPubblicModelImpl
 * @generated
 */
@ImplementationClassName("service.intranet.mef.model.impl.PeriodicitaRichPubblicImpl")
@ProviderType
public interface PeriodicitaRichPubblic extends PeriodicitaRichPubblicModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link service.intranet.mef.model.impl.PeriodicitaRichPubblicImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PeriodicitaRichPubblic, Long> ID_ACCESSOR = new Accessor<PeriodicitaRichPubblic, Long>() {
			@Override
			public Long get(PeriodicitaRichPubblic periodicitaRichPubblic) {
				return periodicitaRichPubblic.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PeriodicitaRichPubblic> getTypeClass() {
				return PeriodicitaRichPubblic.class;
			}
		};
}