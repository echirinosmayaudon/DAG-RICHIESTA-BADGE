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
 * The extended model interface for the RichiesteSequence service. Represents a row in the &quot;LF_SEQ_BFC_READ&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequenceModel
 * @see external.bfc.intranet.mef.model.impl.RichiesteSequenceImpl
 * @see external.bfc.intranet.mef.model.impl.RichiesteSequenceModelImpl
 * @generated
 */
@ImplementationClassName("external.bfc.intranet.mef.model.impl.RichiesteSequenceImpl")
@ProviderType
public interface RichiesteSequence extends RichiesteSequenceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link external.bfc.intranet.mef.model.impl.RichiesteSequenceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RichiesteSequence, Long> ID_SEQ_ACCESSOR = new Accessor<RichiesteSequence, Long>() {
			@Override
			public Long get(RichiesteSequence richiesteSequence) {
				return richiesteSequence.getIdSeq();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RichiesteSequence> getTypeClass() {
				return RichiesteSequence.class;
			}
		};
}