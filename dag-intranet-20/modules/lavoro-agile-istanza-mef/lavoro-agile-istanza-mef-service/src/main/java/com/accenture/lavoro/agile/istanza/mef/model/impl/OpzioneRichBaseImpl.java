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

package com.accenture.lavoro.agile.istanza.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;
import com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalServiceUtil;

/**
 * The extended model base implementation for the OpzioneRich service. Represents a row in the &quot;MEFISTAGILE_OpzioneRich&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OpzioneRichImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRichImpl
 * @see OpzioneRich
 * @generated
 */
@ProviderType
public abstract class OpzioneRichBaseImpl extends OpzioneRichModelImpl
	implements OpzioneRich {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a opzione rich model instance should use the {@link OpzioneRich} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			OpzioneRichLocalServiceUtil.addOpzioneRich(this);
		}
		else {
			OpzioneRichLocalServiceUtil.updateOpzioneRich(this);
		}
	}
}