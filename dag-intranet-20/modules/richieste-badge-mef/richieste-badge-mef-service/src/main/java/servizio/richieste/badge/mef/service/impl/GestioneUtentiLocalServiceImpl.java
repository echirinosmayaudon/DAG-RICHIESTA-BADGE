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

package servizio.richieste.badge.mef.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.Date;

import aQute.bnd.annotation.ProviderType;
import servizio.richieste.badge.mef.model.GestioneUtenti;
import servizio.richieste.badge.mef.service.base.GestioneUtentiLocalServiceBaseImpl;

/**
 * The implementation of the gestione utenti local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.richieste.badge.mef.service.GestioneUtentiLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtentiLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.GestioneUtentiLocalServiceUtil
 */
@ProviderType
public class GestioneUtentiLocalServiceImpl
	extends GestioneUtentiLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.richieste.badge.mef.service.GestioneUtentiLocalServiceUtil} to access the gestione utenti local service.
	 */
	
	final Log _log = LogFactoryUtil.getLog(GestioneUtentiLocalServiceImpl.class);
	
	@Override
	public boolean insertGestioneUtenti(Date data, String screename_dirigente, String screename_utente, long id_ufficio, String btnAction, User utente, long companyId) {
		
		GestioneUtenti gestioneUtenti = gestioneUtentiPersistence.create(-1);
		try{
			
			gestioneUtenti.setData(data);
			gestioneUtenti.setScreename_dirigente(screename_dirigente);
			gestioneUtenti.setScreename_utente(screename_utente);
			
			if (id_ufficio != 0) {
				gestioneUtenti.setId_ufficio(id_ufficio);
			}
			
			Role abilitatoBadgeRole = RoleLocalServiceUtil.fetchRole(companyId, "abilitatoBadge");
			Role delegatoBadgeRole = RoleLocalServiceUtil.fetchRole(companyId, "delegatoBadge");
			
			if (utente != null) {
				
				if (btnAction.contains("abilita")) {
					RoleLocalServiceUtil.addUserRole(utente.getUserId(), abilitatoBadgeRole.getRoleId());
					gestioneUtenti.setAbilitazione(true);
					gestioneUtenti.setDelega(false);
				}
				
				if (btnAction.contains("revoca")) {
					RoleLocalServiceUtil.deleteUserRole(utente.getUserId(), delegatoBadgeRole.getRoleId());
					gestioneUtenti.setAbilitazione(true);
					gestioneUtenti.setDelega(false);
				}
				
				if (btnAction.contains("delega")) {
					RoleLocalServiceUtil.addUserRole(utente.getUserId(), delegatoBadgeRole.getRoleId());
					gestioneUtenti.setAbilitazione(true);
					gestioneUtenti.setDelega(true);
				}
				
				if (btnAction.contains("eliminautente")) {

					RoleLocalServiceUtil.deleteUserRole(utente.getUserId(), abilitatoBadgeRole.getRoleId());
					RoleLocalServiceUtil.deleteUserRole(utente.getUserId(), delegatoBadgeRole.getRoleId());
					gestioneUtenti.setAbilitazione(false);
					gestioneUtenti.setDelega(false);
				}
				
				UserLocalServiceUtil.updateUser(utente);
				
			}
				
			gestioneUtentiPersistence.updateImpl(gestioneUtenti);
			return true;
			
		} catch(Exception e) {
			
			_log.error(e);
			return false;
			
		}
		
	}
	
}