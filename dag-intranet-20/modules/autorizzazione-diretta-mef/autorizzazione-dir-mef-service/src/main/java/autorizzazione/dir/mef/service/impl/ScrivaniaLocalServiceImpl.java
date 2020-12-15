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

package autorizzazione.dir.mef.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import autorizzazione.dir.mef.exception.NoSuchScrivaniaException;
import autorizzazione.dir.mef.model.Scrivania;
import autorizzazione.dir.mef.service.base.ScrivaniaLocalServiceBaseImpl;
import autorizzazione.dir.mef.service.persistence.ScrivaniaPK;

/**
 * The implementation of the scrivania local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link autorizzazione.dir.mef.service.ScrivaniaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaLocalServiceBaseImpl
 * @see autorizzazione.dir.mef.service.ScrivaniaLocalServiceUtil
 */
public class ScrivaniaLocalServiceImpl extends ScrivaniaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link autorizzazione.dir.mef.service.ScrivaniaLocalServiceUtil} to access the scrivania local service.
	 */
	
	final Log _log = LogFactoryUtil.getLog(ScrivaniaLocalServiceImpl.class);
	
	
	
	//restituisce true se l'app viene aggiuntata alla home/profilo altrimenti restituisce false (non ci sono slot disponibili per aggiungerla)
	private boolean addApp(long userId, long applicationId, boolean home, boolean profile) {
		
		_log.debug("##################### START addApp #####################");
		
		_log.debug("userId: " + userId);
		_log.debug("applicationId: " + applicationId);
		if(home) _log.debug("add app to home");
		if(profile) _log.debug("add app to profile");
		
		//numero di slot totali nella home/profilo
		/*int maxNumApp = 0;
		if(home) maxNumApp = 8;
		if(profile) maxNumApp = 17;
		_log.debug("maxNumApp: " + maxNumApp);*/
		
		//conta gli slot attualmente occupati dall'utente sulla home/profile
		/*
		DynamicQuery dynamicQuery = ScrivaniaLocalServiceUtil.dynamicQuery();
		Property pUserId = PropertyFactoryUtil.forName("primaryKey.userId");
		dynamicQuery.add(pUserId.eq(userId));
		Property pFlag = null;
		if(home) pFlag = PropertyFactoryUtil.forName("homeFlag");
		if(profile) pFlag = PropertyFactoryUtil.forName("profileFlag");
		dynamicQuery.add(pFlag.eq(true));
		List<Scrivania> listApp = ScrivaniaLocalServiceUtil.dynamicQuery(dynamicQuery);
		*/
		//List<Scrivania> listApp = scrivaniaPersistence.findByU_H_P(userId, home, profile);
		/*List<Scrivania> listApp = new ArrayList<Scrivania>();
		if(home && profile){
			_log.debug("add app to home and profile");
			listApp = scrivaniaPersistence.findByU_H_P(userId, home, profile);
		}else if(home){
			_log.debug("add app to from home");
			listApp = scrivaniaPersistence.findByU_H(userId, home);
		}else if(profile){
			_log.debug("add app to from profile");
			listApp = scrivaniaPersistence.findByU_P(userId, profile);
		}else{
			
		}
		
		int currentNumApp = listApp.size();
		if(home) _log.debug("currentNumApp: " + currentNumApp);
		
		//se non ci sono slot disponibili termina senza creare il record e restituisce false
		if(currentNumApp >= maxNumApp){
			_log.debug("non ci sono slot disponibili");
			return false;
		}
		
		
		//se ci sono slot disponibili procede con la creazione/update del record
		*/
		Scrivania app = null;
		ScrivaniaPK appPk = new ScrivaniaPK(userId, applicationId);
		try {
			//recupera record esistente per la coppia user/applicazione
			app = scrivaniaPersistence.findByPrimaryKey(appPk);
			_log.debug("update record");
			//se findByPrimaryKey non va in eccezione il record esiste e deve essere updatato
		} catch (NoSuchScrivaniaException e) {
			_log.debug("crezione record" + e);
			//se findByPrimaryKey non va in eccezione il record non esiste e deve essere creato con createDate = sysdate e rowId incrementato
			app = scrivaniaPersistence.create(appPk);
			app.setCreateDate(new Date());
			long rowId = CounterLocalServiceUtil.increment(Scrivania.class.getName());
			app.setRowId(rowId);
		}
		//fa update/insert del record impostando il flag a true
		if(home) app.setHomeFlag(true);
		if(profile) app.setProfileFlag(true);
		scrivaniaPersistence.update(app);
		
		_log.debug("##################### END addApp #####################");
		return true;
	}
	
	
	public boolean addAppToHome(long userId, long applicationId) {
		return addApp(userId, applicationId, true, false);
	}
	
	public boolean addAppToProfile(long userId, long applicationId) {
		return addApp(userId, applicationId, false, true);
	}
	
	
	
	
	
	private boolean removeApp(long userId, long applicationId, boolean home, boolean profile) throws NoSuchScrivaniaException {
		
		_log.debug("##################### START deleteApp #####################");
		
		_log.debug("userId: " + userId);
		_log.debug("applicationId: " + applicationId);
		if(home) _log.debug("remove app from home");
		if(profile) _log.debug("remove app from profile");
		
		ScrivaniaPK appPk = new ScrivaniaPK(userId, applicationId);
		//recupera record esistente per la coppia user/applicazione
		Scrivania app = scrivaniaPersistence.findByPrimaryKey(appPk);
		//app = ScrivaniaUtil.findByPrimaryKey(appPk);
		//fa update del record impostando il flag a false
		if(home) app.setHomeFlag(false);
		if(profile) app.setProfileFlag(false);
		
		scrivaniaPersistence.update(app);
		
		_log.debug("##################### END deleteApp #####################");
		return true;
	}
	
	public boolean removeAppFromHome(long userId, long applicationId) throws NoSuchScrivaniaException {
		return removeApp(userId, applicationId, true, false);
	}
	
	public boolean removeAppFromProfile(long userId, long applicationId) throws NoSuchScrivaniaException {
		return removeApp(userId, applicationId, false, true);
	}
	
	
	
	
	
	
	
	
	
	private String getApps(long userId, boolean home, boolean profile) {
		
		_log.debug("##################### START getApps #####################");
		
		_log.debug("userId: " + userId);
		

		/*
		DynamicQuery dynamicQuery = ScrivaniaLocalServiceUtil.dynamicQuery();
		Property pUserId = PropertyFactoryUtil.forName("primaryKey.userId");
		dynamicQuery.add(pUserId.eq(userId));
		
		Property pFlag = null;
		if(home) pFlag = PropertyFactoryUtil.forName("homeFlag");
		if(profile) pFlag = PropertyFactoryUtil.forName("profileFlag");
		dynamicQuery.add(pFlag.eq(true));

		List<Scrivania> listApp = ScrivaniaLocalServiceUtil.dynamicQuery(dynamicQuery);

		ArrayList<Long> listAppId = new ArrayList<>();
		for(Scrivania curApp : listApp){
			listAppId.add(curApp.getApplicationId());
		}
		
		String toRet = StringUtils.join(listAppId.toArray(), ";");
		*/
		List<Scrivania> listApp = new ArrayList<Scrivania>();
		if(home && profile){
			_log.debug("get app from home and profile");
			listApp = scrivaniaPersistence.findByU_H_P(userId, home, profile);
		}else if(home){
			_log.debug("get app from home");
			listApp = scrivaniaPersistence.findByU_H(userId, home);
		}else if(profile){
			_log.debug("get app from profile");
			listApp = scrivaniaPersistence.findByU_P(userId, profile);
		}else{
			
		}
		
		
		Long[] listAppId = ListUtil.toArray(listApp, Scrivania.APPLICATION_ID_ACCESSOR);
		
		String toRet = StringUtil.merge(listAppId, StringPool.SEMICOLON);

		_log.debug("return: " + toRet);
		
		_log.debug("##################### END getApps #####################");
		return toRet;
	}


	public String getHomeApps(long userId) {
		return getApps(userId, true, false);
	}
	
	public String getProfileApps(long userId) {
		return getApps(userId, false, true);
	}


	
	
	
	
}