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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import autorizzazione.dir.mef.model.UtilizzoApplicazioni;
import autorizzazione.dir.mef.service.base.UtilizzoApplicazioniLocalServiceBaseImpl;
import autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK;


/**
 * The implementation of the utilizzo applicazioni local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link autorizzazione.dir.mef.service.UtilizzoApplicazioniLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioniLocalServiceBaseImpl
 * @see autorizzazione.dir.mef.service.UtilizzoApplicazioniLocalServiceUtil
 */
public class UtilizzoApplicazioniLocalServiceImpl
	extends UtilizzoApplicazioniLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link autorizzazione.dir.mef.service.UtilizzoApplicazioniLocalServiceUtil} to access the utilizzo applicazioni local service.
	 */

	final Log _log = LogFactoryUtil.getLog(UtilizzoApplicazioniLocalServiceImpl.class);

	public UtilizzoApplicazioni addNewHit(long userId, long applicationId) {

		_log.debug("##################### START addNewHit #####################");

		_log.debug("userId: " + userId);
		_log.debug("applicationId: " + applicationId);

		UtilizzoApplicazioni app = null;
		UtilizzoApplicazioniPK uaPk = new UtilizzoApplicazioniPK(userId, applicationId);
		int count;

		try {
			//recupera record esistente per la coppia user/applicazione
			app = utilizzoApplicazioniPersistence.findByPrimaryKey(uaPk);
			//app = UtilizzoApplicazioniUtil.fetchByPrimaryKey(uaPk);
			//se findByPrimaryKey non va in eccezione il record esiste e il count deve essere incrementato
			count = app.getHitsCount()+1;
			_log.debug("update record");
		} catch (Exception e) {
			_log.debug("crezione record" + e);
			//se findByPrimaryKey va in eccezione il record non esiste e deve essere creato con createDate = sysdate, count = 1 e rowId incrementato
			app = utilizzoApplicazioniPersistence.create(uaPk);
			//app = UtilizzoApplicazioniLocalServiceUtil.createUtilizzoApplicazioni(uaPk);
			app.setCreateDate(new Date());
			count = 1;
			long rowId = CounterLocalServiceUtil.increment(UtilizzoApplicazioni.class.getName());
			app.setRowId(rowId);
		}
		//fa update/insert del record - nel caso di update aggiorna solo hitsCount e lastUseDate
		app.setHitsCount(count);
		app.setLastUseDate(new Date());

		utilizzoApplicazioniPersistence.update(app);
		//UtilizzoApplicazioniLocalServiceUtil.updateUtilizzoApplicazioni(app);
		_log.debug("return: " + app);
		_log.debug("##################### END addNewHit #####################");

		return app;
	}

	public String fetchLastHitsByUserId(long userId) {

		_log.debug("##################### UTILIZZO_APPLICAZIONI  #####################");

		_log.debug("Recupero le applicazioni per l'utente con userId: " + userId);

		List<UtilizzoApplicazioni> entries = utilizzoApplicazioniPersistence.findByUserId(userId);

		Date now = new Date();

		List<UtilizzoApplicazioni> listUA  = new ArrayList<UtilizzoApplicazioni>();

		for (UtilizzoApplicazioni entry : entries) {
			if (DateUtil.getDaysBetween(entry.getLastUseDate(), now) <= 15) {
				listUA.add(entry);
			}
		}
		_log.debug("Estratte solo le applicazioni recenti (ultimi 15 dd)");
		//_log.debug("listSize: " + listUA.size());



		Long[] uaIds = ListUtil.toArray(listUA, UtilizzoApplicazioni.APPLICATION_ID_ACCESSOR);

		/*
		//Il box che si aprirà visualizzerà i primi 12 link di accesso alle applicazioni ordinati in base a quelli più utilizzati dall'utente
		OrderByComparator<UtilizzoApplicazioni> comparator = OrderByComparatorFactoryUtil.create("mefservice_utilizzoapplicazioni", "hitsCount", false); // false = desc; true = asc

		DynamicQuery query = UtilizzoApplicazioniLocalServiceUtil.dynamicQuery();


//		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UtilizzoApplicazioni.class, getClassLoader());
//		Property pUserId = PropertyFactoryUtil.forName("primaryKey.userId");
//		dynamicQuery.add(pUserId.eq(userId));

		query.add(PropertyFactoryUtil.forName("primaryKey.userId").eq(userId));

		//L'ordinamento dovrà tenere conto solo delle statistiche degli ultimi 15 giorni
//		Property pLastUseData = PropertyFactoryUtil.forName("lastUseDate");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -15);
//		dynamicQuery.add(pLastUseData.ge(c.getTime()));
		query.add(PropertyFactoryUtil.forName("lastUseDate").ge(c.getTime()));
		_log.debug("oggi -15gg: " + c.getTime());


//		List<UtilizzoApplicazioni> listUA = utilizzoApplicazioniPersistence.findWithDynamicQuery(dynamicQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS, comparator);

		List<UtilizzoApplicazioni> listUA  = UtilizzoApplicazioniLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS, comparator);


		ArrayList<Long> hitsList = new ArrayList<>();
		int listSize = listUA.size();
		_log.debug("listSize: " + listSize);
		//Nel caso in cui il numero di applicazioni utilizzate risulti inferiori rispetto al totale delle posizioni disponibili nel box, L'ordinamento sarà effettuato in ordine alfabetico
		//Se l'utente ha utilizzato meno di 12 applicazioni, il FE interpreta lista.size() < 12 => Mostra le prime (lista.size() + (12-lista.size())) occorrenze in ordine alfabetico
		for(int i=0; i<listSize; i++){
			UtilizzoApplicazioni curUA = listUA.get(i);
			hitsList.add(curUA.getApplicationId());
		}
		String toRet = StringUtils.join(hitsList.toArray(), ";");
		 */

		String toRet = StringUtil.merge(uaIds, StringPool.SEMICOLON);

		_log.debug("Lista di applicazioni più utilizzate ordinata dalle più cliccate a alle meno cliccate: " + toRet);

		_log.debug("##################### END UTILIZZO_APPLICAZIONI #####################");

		return toRet;
	}



	private final long userIdMedia = -1;

	public UtilizzoApplicazioni addNewMediaHit(long applicationId) {
		return addNewHit(this.userIdMedia, applicationId);
	}

	public List<UtilizzoApplicazioni> fetchLastMediaHits() {



		//OrderByComparator<UtilizzoApplicazioni> comparator = OrderByComparatorFactoryUtil.create("mefservice_utilizzoapplicazioni", "hitsCount", false); // false = desc; true = asc

		List<UtilizzoApplicazioni> listUA  = utilizzoApplicazioniPersistence.findByUserId(
			this.userIdMedia);

		/*
		DynamicQuery query = UtilizzoApplicazioniLocalServiceUtil.dynamicQuery();

//		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UtilizzoApplicazioni.class, getClassLoader());
//		Property pUserId = PropertyFactoryUtil.forName("primaryKey.userId");
//		dynamicQuery.add(pUserId.eq(this.userIdMedia));

		query.add(PropertyFactoryUtil.forName("primaryKey.userId").eq(this.userIdMedia));

//		List<UtilizzoApplicazioni> listUA = utilizzoApplicazioniPersistence.findWithDynamicQuery(dynamicQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS, comparator);

		List<UtilizzoApplicazioni> listUA  = UtilizzoApplicazioniLocalServiceUtil.dynamicQuery(query,QueryUtil.ALL_POS, QueryUtil.ALL_POS, comparator);
		*/



		return listUA;
	}

}