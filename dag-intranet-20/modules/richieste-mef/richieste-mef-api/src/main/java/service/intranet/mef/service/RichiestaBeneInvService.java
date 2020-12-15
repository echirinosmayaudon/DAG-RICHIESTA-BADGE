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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import service.intranet.mef.model.RichiestaBeneInv;

import java.util.Date;
import java.util.List;

/**
 * Provides the remote service interface for RichiestaBeneInv. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvServiceUtil
 * @see service.intranet.mef.service.base.RichiestaBeneInvServiceBaseImpl
 * @see service.intranet.mef.service.impl.RichiestaBeneInvServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=mform", "json.web.service.context.path=RichiestaBeneInv"}, service = RichiestaBeneInvService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RichiestaBeneInvService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaBeneInvServiceUtil} to access the richiesta bene inv remote service. Add custom service methods to {@link service.intranet.mef.service.impl.RichiestaBeneInvServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteBeniInvByFilters(
		long id_richiesta, java.lang.String nome_rich,
		java.lang.String cogn_rich, Date data, java.lang.String dip_dir,
		List<java.lang.Long> list_id_stato, java.lang.String tipologia,
		boolean in_elenco);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(
		long id_richiesta, java.lang.String screenName, Date data,
		List<java.lang.Long> list_id_stato, java.lang.String tipologia,
		boolean in_elenco);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteByDipartimento(
		java.lang.String dipartimento);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteByDipartimentoAndStato(
		List<java.lang.String> dip_dir, long id_stato);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteByUtente(java.lang.String utente);
}