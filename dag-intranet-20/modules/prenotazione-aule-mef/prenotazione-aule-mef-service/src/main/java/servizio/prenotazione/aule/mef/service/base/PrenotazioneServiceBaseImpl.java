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

package servizio.prenotazione.aule.mef.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.prenotazione.aule.mef.model.Prenotazione;
import servizio.prenotazione.aule.mef.service.PrenotazioneService;
import servizio.prenotazione.aule.mef.service.persistence.ApprovatorePersistence;
import servizio.prenotazione.aule.mef.service.persistence.OrarioFinder;
import servizio.prenotazione.aule.mef.service.persistence.OrarioPersistence;
import servizio.prenotazione.aule.mef.service.persistence.PrenotazioneFinder;
import servizio.prenotazione.aule.mef.service.persistence.PrenotazionePersistence;
import servizio.prenotazione.aule.mef.service.persistence.SalaPersistence;
import servizio.prenotazione.aule.mef.service.persistence.SalaStrutturaPersistence;
import servizio.prenotazione.aule.mef.service.persistence.ServizioLogPersistence;
import servizio.prenotazione.aule.mef.service.persistence.StatoAulaPersistence;
import servizio.prenotazione.aule.mef.service.persistence.StrumentoEventoPersistence;
import servizio.prenotazione.aule.mef.service.persistence.StrumentoTecPersistence;
import servizio.prenotazione.aule.mef.service.persistence.TipoEventoPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the prenotazione remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link servizio.prenotazione.aule.mef.service.impl.PrenotazioneServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.impl.PrenotazioneServiceImpl
 * @see servizio.prenotazione.aule.mef.service.PrenotazioneServiceUtil
 * @generated
 */
public abstract class PrenotazioneServiceBaseImpl extends BaseServiceImpl
	implements PrenotazioneService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link servizio.prenotazione.aule.mef.service.PrenotazioneServiceUtil} to access the prenotazione remote service.
	 */

	/**
	 * Returns the approvatore local service.
	 *
	 * @return the approvatore local service
	 */
	public servizio.prenotazione.aule.mef.service.ApprovatoreLocalService getApprovatoreLocalService() {
		return approvatoreLocalService;
	}

	/**
	 * Sets the approvatore local service.
	 *
	 * @param approvatoreLocalService the approvatore local service
	 */
	public void setApprovatoreLocalService(
		servizio.prenotazione.aule.mef.service.ApprovatoreLocalService approvatoreLocalService) {
		this.approvatoreLocalService = approvatoreLocalService;
	}

	/**
	 * Returns the approvatore remote service.
	 *
	 * @return the approvatore remote service
	 */
	public servizio.prenotazione.aule.mef.service.ApprovatoreService getApprovatoreService() {
		return approvatoreService;
	}

	/**
	 * Sets the approvatore remote service.
	 *
	 * @param approvatoreService the approvatore remote service
	 */
	public void setApprovatoreService(
		servizio.prenotazione.aule.mef.service.ApprovatoreService approvatoreService) {
		this.approvatoreService = approvatoreService;
	}

	/**
	 * Returns the approvatore persistence.
	 *
	 * @return the approvatore persistence
	 */
	public ApprovatorePersistence getApprovatorePersistence() {
		return approvatorePersistence;
	}

	/**
	 * Sets the approvatore persistence.
	 *
	 * @param approvatorePersistence the approvatore persistence
	 */
	public void setApprovatorePersistence(
		ApprovatorePersistence approvatorePersistence) {
		this.approvatorePersistence = approvatorePersistence;
	}

	/**
	 * Returns the orario local service.
	 *
	 * @return the orario local service
	 */
	public servizio.prenotazione.aule.mef.service.OrarioLocalService getOrarioLocalService() {
		return orarioLocalService;
	}

	/**
	 * Sets the orario local service.
	 *
	 * @param orarioLocalService the orario local service
	 */
	public void setOrarioLocalService(
		servizio.prenotazione.aule.mef.service.OrarioLocalService orarioLocalService) {
		this.orarioLocalService = orarioLocalService;
	}

	/**
	 * Returns the orario remote service.
	 *
	 * @return the orario remote service
	 */
	public servizio.prenotazione.aule.mef.service.OrarioService getOrarioService() {
		return orarioService;
	}

	/**
	 * Sets the orario remote service.
	 *
	 * @param orarioService the orario remote service
	 */
	public void setOrarioService(
		servizio.prenotazione.aule.mef.service.OrarioService orarioService) {
		this.orarioService = orarioService;
	}

	/**
	 * Returns the orario persistence.
	 *
	 * @return the orario persistence
	 */
	public OrarioPersistence getOrarioPersistence() {
		return orarioPersistence;
	}

	/**
	 * Sets the orario persistence.
	 *
	 * @param orarioPersistence the orario persistence
	 */
	public void setOrarioPersistence(OrarioPersistence orarioPersistence) {
		this.orarioPersistence = orarioPersistence;
	}

	/**
	 * Returns the orario finder.
	 *
	 * @return the orario finder
	 */
	public OrarioFinder getOrarioFinder() {
		return orarioFinder;
	}

	/**
	 * Sets the orario finder.
	 *
	 * @param orarioFinder the orario finder
	 */
	public void setOrarioFinder(OrarioFinder orarioFinder) {
		this.orarioFinder = orarioFinder;
	}

	/**
	 * Returns the prenotazione local service.
	 *
	 * @return the prenotazione local service
	 */
	public servizio.prenotazione.aule.mef.service.PrenotazioneLocalService getPrenotazioneLocalService() {
		return prenotazioneLocalService;
	}

	/**
	 * Sets the prenotazione local service.
	 *
	 * @param prenotazioneLocalService the prenotazione local service
	 */
	public void setPrenotazioneLocalService(
		servizio.prenotazione.aule.mef.service.PrenotazioneLocalService prenotazioneLocalService) {
		this.prenotazioneLocalService = prenotazioneLocalService;
	}

	/**
	 * Returns the prenotazione remote service.
	 *
	 * @return the prenotazione remote service
	 */
	public PrenotazioneService getPrenotazioneService() {
		return prenotazioneService;
	}

	/**
	 * Sets the prenotazione remote service.
	 *
	 * @param prenotazioneService the prenotazione remote service
	 */
	public void setPrenotazioneService(PrenotazioneService prenotazioneService) {
		this.prenotazioneService = prenotazioneService;
	}

	/**
	 * Returns the prenotazione persistence.
	 *
	 * @return the prenotazione persistence
	 */
	public PrenotazionePersistence getPrenotazionePersistence() {
		return prenotazionePersistence;
	}

	/**
	 * Sets the prenotazione persistence.
	 *
	 * @param prenotazionePersistence the prenotazione persistence
	 */
	public void setPrenotazionePersistence(
		PrenotazionePersistence prenotazionePersistence) {
		this.prenotazionePersistence = prenotazionePersistence;
	}

	/**
	 * Returns the prenotazione finder.
	 *
	 * @return the prenotazione finder
	 */
	public PrenotazioneFinder getPrenotazioneFinder() {
		return prenotazioneFinder;
	}

	/**
	 * Sets the prenotazione finder.
	 *
	 * @param prenotazioneFinder the prenotazione finder
	 */
	public void setPrenotazioneFinder(PrenotazioneFinder prenotazioneFinder) {
		this.prenotazioneFinder = prenotazioneFinder;
	}

	/**
	 * Returns the sala local service.
	 *
	 * @return the sala local service
	 */
	public servizio.prenotazione.aule.mef.service.SalaLocalService getSalaLocalService() {
		return salaLocalService;
	}

	/**
	 * Sets the sala local service.
	 *
	 * @param salaLocalService the sala local service
	 */
	public void setSalaLocalService(
		servizio.prenotazione.aule.mef.service.SalaLocalService salaLocalService) {
		this.salaLocalService = salaLocalService;
	}

	/**
	 * Returns the sala remote service.
	 *
	 * @return the sala remote service
	 */
	public servizio.prenotazione.aule.mef.service.SalaService getSalaService() {
		return salaService;
	}

	/**
	 * Sets the sala remote service.
	 *
	 * @param salaService the sala remote service
	 */
	public void setSalaService(
		servizio.prenotazione.aule.mef.service.SalaService salaService) {
		this.salaService = salaService;
	}

	/**
	 * Returns the sala persistence.
	 *
	 * @return the sala persistence
	 */
	public SalaPersistence getSalaPersistence() {
		return salaPersistence;
	}

	/**
	 * Sets the sala persistence.
	 *
	 * @param salaPersistence the sala persistence
	 */
	public void setSalaPersistence(SalaPersistence salaPersistence) {
		this.salaPersistence = salaPersistence;
	}

	/**
	 * Returns the sala struttura local service.
	 *
	 * @return the sala struttura local service
	 */
	public servizio.prenotazione.aule.mef.service.SalaStrutturaLocalService getSalaStrutturaLocalService() {
		return salaStrutturaLocalService;
	}

	/**
	 * Sets the sala struttura local service.
	 *
	 * @param salaStrutturaLocalService the sala struttura local service
	 */
	public void setSalaStrutturaLocalService(
		servizio.prenotazione.aule.mef.service.SalaStrutturaLocalService salaStrutturaLocalService) {
		this.salaStrutturaLocalService = salaStrutturaLocalService;
	}

	/**
	 * Returns the sala struttura remote service.
	 *
	 * @return the sala struttura remote service
	 */
	public servizio.prenotazione.aule.mef.service.SalaStrutturaService getSalaStrutturaService() {
		return salaStrutturaService;
	}

	/**
	 * Sets the sala struttura remote service.
	 *
	 * @param salaStrutturaService the sala struttura remote service
	 */
	public void setSalaStrutturaService(
		servizio.prenotazione.aule.mef.service.SalaStrutturaService salaStrutturaService) {
		this.salaStrutturaService = salaStrutturaService;
	}

	/**
	 * Returns the sala struttura persistence.
	 *
	 * @return the sala struttura persistence
	 */
	public SalaStrutturaPersistence getSalaStrutturaPersistence() {
		return salaStrutturaPersistence;
	}

	/**
	 * Sets the sala struttura persistence.
	 *
	 * @param salaStrutturaPersistence the sala struttura persistence
	 */
	public void setSalaStrutturaPersistence(
		SalaStrutturaPersistence salaStrutturaPersistence) {
		this.salaStrutturaPersistence = salaStrutturaPersistence;
	}

	/**
	 * Returns the servizio log local service.
	 *
	 * @return the servizio log local service
	 */
	public servizio.prenotazione.aule.mef.service.ServizioLogLocalService getServizioLogLocalService() {
		return servizioLogLocalService;
	}

	/**
	 * Sets the servizio log local service.
	 *
	 * @param servizioLogLocalService the servizio log local service
	 */
	public void setServizioLogLocalService(
		servizio.prenotazione.aule.mef.service.ServizioLogLocalService servizioLogLocalService) {
		this.servizioLogLocalService = servizioLogLocalService;
	}

	/**
	 * Returns the servizio log remote service.
	 *
	 * @return the servizio log remote service
	 */
	public servizio.prenotazione.aule.mef.service.ServizioLogService getServizioLogService() {
		return servizioLogService;
	}

	/**
	 * Sets the servizio log remote service.
	 *
	 * @param servizioLogService the servizio log remote service
	 */
	public void setServizioLogService(
		servizio.prenotazione.aule.mef.service.ServizioLogService servizioLogService) {
		this.servizioLogService = servizioLogService;
	}

	/**
	 * Returns the servizio log persistence.
	 *
	 * @return the servizio log persistence
	 */
	public ServizioLogPersistence getServizioLogPersistence() {
		return servizioLogPersistence;
	}

	/**
	 * Sets the servizio log persistence.
	 *
	 * @param servizioLogPersistence the servizio log persistence
	 */
	public void setServizioLogPersistence(
		ServizioLogPersistence servizioLogPersistence) {
		this.servizioLogPersistence = servizioLogPersistence;
	}

	/**
	 * Returns the stato aula local service.
	 *
	 * @return the stato aula local service
	 */
	public servizio.prenotazione.aule.mef.service.StatoAulaLocalService getStatoAulaLocalService() {
		return statoAulaLocalService;
	}

	/**
	 * Sets the stato aula local service.
	 *
	 * @param statoAulaLocalService the stato aula local service
	 */
	public void setStatoAulaLocalService(
		servizio.prenotazione.aule.mef.service.StatoAulaLocalService statoAulaLocalService) {
		this.statoAulaLocalService = statoAulaLocalService;
	}

	/**
	 * Returns the stato aula remote service.
	 *
	 * @return the stato aula remote service
	 */
	public servizio.prenotazione.aule.mef.service.StatoAulaService getStatoAulaService() {
		return statoAulaService;
	}

	/**
	 * Sets the stato aula remote service.
	 *
	 * @param statoAulaService the stato aula remote service
	 */
	public void setStatoAulaService(
		servizio.prenotazione.aule.mef.service.StatoAulaService statoAulaService) {
		this.statoAulaService = statoAulaService;
	}

	/**
	 * Returns the stato aula persistence.
	 *
	 * @return the stato aula persistence
	 */
	public StatoAulaPersistence getStatoAulaPersistence() {
		return statoAulaPersistence;
	}

	/**
	 * Sets the stato aula persistence.
	 *
	 * @param statoAulaPersistence the stato aula persistence
	 */
	public void setStatoAulaPersistence(
		StatoAulaPersistence statoAulaPersistence) {
		this.statoAulaPersistence = statoAulaPersistence;
	}

	/**
	 * Returns the strumento evento local service.
	 *
	 * @return the strumento evento local service
	 */
	public servizio.prenotazione.aule.mef.service.StrumentoEventoLocalService getStrumentoEventoLocalService() {
		return strumentoEventoLocalService;
	}

	/**
	 * Sets the strumento evento local service.
	 *
	 * @param strumentoEventoLocalService the strumento evento local service
	 */
	public void setStrumentoEventoLocalService(
		servizio.prenotazione.aule.mef.service.StrumentoEventoLocalService strumentoEventoLocalService) {
		this.strumentoEventoLocalService = strumentoEventoLocalService;
	}

	/**
	 * Returns the strumento evento remote service.
	 *
	 * @return the strumento evento remote service
	 */
	public servizio.prenotazione.aule.mef.service.StrumentoEventoService getStrumentoEventoService() {
		return strumentoEventoService;
	}

	/**
	 * Sets the strumento evento remote service.
	 *
	 * @param strumentoEventoService the strumento evento remote service
	 */
	public void setStrumentoEventoService(
		servizio.prenotazione.aule.mef.service.StrumentoEventoService strumentoEventoService) {
		this.strumentoEventoService = strumentoEventoService;
	}

	/**
	 * Returns the strumento evento persistence.
	 *
	 * @return the strumento evento persistence
	 */
	public StrumentoEventoPersistence getStrumentoEventoPersistence() {
		return strumentoEventoPersistence;
	}

	/**
	 * Sets the strumento evento persistence.
	 *
	 * @param strumentoEventoPersistence the strumento evento persistence
	 */
	public void setStrumentoEventoPersistence(
		StrumentoEventoPersistence strumentoEventoPersistence) {
		this.strumentoEventoPersistence = strumentoEventoPersistence;
	}

	/**
	 * Returns the strumento tec local service.
	 *
	 * @return the strumento tec local service
	 */
	public servizio.prenotazione.aule.mef.service.StrumentoTecLocalService getStrumentoTecLocalService() {
		return strumentoTecLocalService;
	}

	/**
	 * Sets the strumento tec local service.
	 *
	 * @param strumentoTecLocalService the strumento tec local service
	 */
	public void setStrumentoTecLocalService(
		servizio.prenotazione.aule.mef.service.StrumentoTecLocalService strumentoTecLocalService) {
		this.strumentoTecLocalService = strumentoTecLocalService;
	}

	/**
	 * Returns the strumento tec remote service.
	 *
	 * @return the strumento tec remote service
	 */
	public servizio.prenotazione.aule.mef.service.StrumentoTecService getStrumentoTecService() {
		return strumentoTecService;
	}

	/**
	 * Sets the strumento tec remote service.
	 *
	 * @param strumentoTecService the strumento tec remote service
	 */
	public void setStrumentoTecService(
		servizio.prenotazione.aule.mef.service.StrumentoTecService strumentoTecService) {
		this.strumentoTecService = strumentoTecService;
	}

	/**
	 * Returns the strumento tec persistence.
	 *
	 * @return the strumento tec persistence
	 */
	public StrumentoTecPersistence getStrumentoTecPersistence() {
		return strumentoTecPersistence;
	}

	/**
	 * Sets the strumento tec persistence.
	 *
	 * @param strumentoTecPersistence the strumento tec persistence
	 */
	public void setStrumentoTecPersistence(
		StrumentoTecPersistence strumentoTecPersistence) {
		this.strumentoTecPersistence = strumentoTecPersistence;
	}

	/**
	 * Returns the tipo evento local service.
	 *
	 * @return the tipo evento local service
	 */
	public servizio.prenotazione.aule.mef.service.TipoEventoLocalService getTipoEventoLocalService() {
		return tipoEventoLocalService;
	}

	/**
	 * Sets the tipo evento local service.
	 *
	 * @param tipoEventoLocalService the tipo evento local service
	 */
	public void setTipoEventoLocalService(
		servizio.prenotazione.aule.mef.service.TipoEventoLocalService tipoEventoLocalService) {
		this.tipoEventoLocalService = tipoEventoLocalService;
	}

	/**
	 * Returns the tipo evento remote service.
	 *
	 * @return the tipo evento remote service
	 */
	public servizio.prenotazione.aule.mef.service.TipoEventoService getTipoEventoService() {
		return tipoEventoService;
	}

	/**
	 * Sets the tipo evento remote service.
	 *
	 * @param tipoEventoService the tipo evento remote service
	 */
	public void setTipoEventoService(
		servizio.prenotazione.aule.mef.service.TipoEventoService tipoEventoService) {
		this.tipoEventoService = tipoEventoService;
	}

	/**
	 * Returns the tipo evento persistence.
	 *
	 * @return the tipo evento persistence
	 */
	public TipoEventoPersistence getTipoEventoPersistence() {
		return tipoEventoPersistence;
	}

	/**
	 * Sets the tipo evento persistence.
	 *
	 * @param tipoEventoPersistence the tipo evento persistence
	 */
	public void setTipoEventoPersistence(
		TipoEventoPersistence tipoEventoPersistence) {
		this.tipoEventoPersistence = tipoEventoPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PrenotazioneService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Prenotazione.class;
	}

	protected String getModelClassName() {
		return Prenotazione.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = prenotazionePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = servizio.prenotazione.aule.mef.service.ApprovatoreLocalService.class)
	protected servizio.prenotazione.aule.mef.service.ApprovatoreLocalService approvatoreLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.ApprovatoreService.class)
	protected servizio.prenotazione.aule.mef.service.ApprovatoreService approvatoreService;
	@BeanReference(type = ApprovatorePersistence.class)
	protected ApprovatorePersistence approvatorePersistence;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.OrarioLocalService.class)
	protected servizio.prenotazione.aule.mef.service.OrarioLocalService orarioLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.OrarioService.class)
	protected servizio.prenotazione.aule.mef.service.OrarioService orarioService;
	@BeanReference(type = OrarioPersistence.class)
	protected OrarioPersistence orarioPersistence;
	@BeanReference(type = OrarioFinder.class)
	protected OrarioFinder orarioFinder;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.PrenotazioneLocalService.class)
	protected servizio.prenotazione.aule.mef.service.PrenotazioneLocalService prenotazioneLocalService;
	@BeanReference(type = PrenotazioneService.class)
	protected PrenotazioneService prenotazioneService;
	@BeanReference(type = PrenotazionePersistence.class)
	protected PrenotazionePersistence prenotazionePersistence;
	@BeanReference(type = PrenotazioneFinder.class)
	protected PrenotazioneFinder prenotazioneFinder;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.SalaLocalService.class)
	protected servizio.prenotazione.aule.mef.service.SalaLocalService salaLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.SalaService.class)
	protected servizio.prenotazione.aule.mef.service.SalaService salaService;
	@BeanReference(type = SalaPersistence.class)
	protected SalaPersistence salaPersistence;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.SalaStrutturaLocalService.class)
	protected servizio.prenotazione.aule.mef.service.SalaStrutturaLocalService salaStrutturaLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.SalaStrutturaService.class)
	protected servizio.prenotazione.aule.mef.service.SalaStrutturaService salaStrutturaService;
	@BeanReference(type = SalaStrutturaPersistence.class)
	protected SalaStrutturaPersistence salaStrutturaPersistence;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.ServizioLogLocalService.class)
	protected servizio.prenotazione.aule.mef.service.ServizioLogLocalService servizioLogLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.ServizioLogService.class)
	protected servizio.prenotazione.aule.mef.service.ServizioLogService servizioLogService;
	@BeanReference(type = ServizioLogPersistence.class)
	protected ServizioLogPersistence servizioLogPersistence;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.StatoAulaLocalService.class)
	protected servizio.prenotazione.aule.mef.service.StatoAulaLocalService statoAulaLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.StatoAulaService.class)
	protected servizio.prenotazione.aule.mef.service.StatoAulaService statoAulaService;
	@BeanReference(type = StatoAulaPersistence.class)
	protected StatoAulaPersistence statoAulaPersistence;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.StrumentoEventoLocalService.class)
	protected servizio.prenotazione.aule.mef.service.StrumentoEventoLocalService strumentoEventoLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.StrumentoEventoService.class)
	protected servizio.prenotazione.aule.mef.service.StrumentoEventoService strumentoEventoService;
	@BeanReference(type = StrumentoEventoPersistence.class)
	protected StrumentoEventoPersistence strumentoEventoPersistence;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.StrumentoTecLocalService.class)
	protected servizio.prenotazione.aule.mef.service.StrumentoTecLocalService strumentoTecLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.StrumentoTecService.class)
	protected servizio.prenotazione.aule.mef.service.StrumentoTecService strumentoTecService;
	@BeanReference(type = StrumentoTecPersistence.class)
	protected StrumentoTecPersistence strumentoTecPersistence;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.TipoEventoLocalService.class)
	protected servizio.prenotazione.aule.mef.service.TipoEventoLocalService tipoEventoLocalService;
	@BeanReference(type = servizio.prenotazione.aule.mef.service.TipoEventoService.class)
	protected servizio.prenotazione.aule.mef.service.TipoEventoService tipoEventoService;
	@BeanReference(type = TipoEventoPersistence.class)
	protected TipoEventoPersistence tipoEventoPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}