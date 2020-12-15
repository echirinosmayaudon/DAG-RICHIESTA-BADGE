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

package servizio.richieste.badge.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import servizio.richieste.badge.mef.model.RichiestaBadge;

import java.util.List;

/**
 * Provides the remote service interface for RichiestaBadge. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgeServiceUtil
 * @see servizio.richieste.badge.mef.service.base.RichiestaBadgeServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.impl.RichiestaBadgeServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=mbadge", "json.web.service.context.path=RichiestaBadge"}, service = RichiestaBadgeService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RichiestaBadgeService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaBadgeServiceUtil} to access the richiesta badge remote service. Add custom service methods to {@link servizio.richieste.badge.mef.service.impl.RichiestaBadgeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public JSONArray findSuggestionsBySurname(java.lang.String cognome,
		java.lang.String idOrgChart, java.lang.Long userId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public List<RichiestaBadge> findRichiestaByDipartimentoStato(
		java.lang.String dipartimento, List<java.lang.Long> lista_IdStato);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBadge> getRichiestaBadgeByFilters(
		java.lang.String cogn_intest, java.lang.String nome_intest,
		java.lang.String cf_intest, java.lang.String societa,
		java.lang.String ref_societa, java.lang.String motivazione_rich,
		java.lang.String progetto, java.lang.String screenName,
		List<java.lang.Long> lista_IdUffici, boolean is_last,
		List<java.lang.Long> lista_sedi, java.lang.String is_internal,
		List<java.lang.Long> lista_stati);
}