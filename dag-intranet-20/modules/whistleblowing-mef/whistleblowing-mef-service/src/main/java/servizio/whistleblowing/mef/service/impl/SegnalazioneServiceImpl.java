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

package servizio.whistleblowing.mef.service.impl;

import aQute.bnd.annotation.ProviderType;

import servizio.whistleblowing.mef.service.base.SegnalazioneServiceBaseImpl;

/**
 * The implementation of the segnalazione remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.whistleblowing.mef.service.SegnalazioneService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneServiceBaseImpl
 * @see servizio.whistleblowing.mef.service.SegnalazioneServiceUtil
 */
@ProviderType
public class SegnalazioneServiceImpl extends SegnalazioneServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.whistleblowing.mef.service.SegnalazioneServiceUtil} to access the segnalazione remote service.
	 */
}