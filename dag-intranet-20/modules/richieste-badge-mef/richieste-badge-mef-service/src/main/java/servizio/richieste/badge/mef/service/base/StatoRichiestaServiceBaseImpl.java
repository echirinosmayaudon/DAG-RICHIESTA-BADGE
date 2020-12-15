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

package servizio.richieste.badge.mef.service.base;

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

import servizio.richieste.badge.mef.model.StatoRichiesta;
import servizio.richieste.badge.mef.service.StatoRichiestaService;
import servizio.richieste.badge.mef.service.persistence.AnaDipExtPersistence;
import servizio.richieste.badge.mef.service.persistence.GestioneUtentiPersistence;
import servizio.richieste.badge.mef.service.persistence.OggettoRichiestaPersistence;
import servizio.richieste.badge.mef.service.persistence.RichiestaBadgeFinder;
import servizio.richieste.badge.mef.service.persistence.RichiestaBadgePersistence;
import servizio.richieste.badge.mef.service.persistence.SediEsternePersistence;
import servizio.richieste.badge.mef.service.persistence.StatoRichiestaPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the stato richiesta remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link servizio.richieste.badge.mef.service.impl.StatoRichiestaServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.impl.StatoRichiestaServiceImpl
 * @see servizio.richieste.badge.mef.service.StatoRichiestaServiceUtil
 * @generated
 */
public abstract class StatoRichiestaServiceBaseImpl extends BaseServiceImpl
	implements StatoRichiestaService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link servizio.richieste.badge.mef.service.StatoRichiestaServiceUtil} to access the stato richiesta remote service.
	 */

	/**
	 * Returns the ana dip ext local service.
	 *
	 * @return the ana dip ext local service
	 */
	public servizio.richieste.badge.mef.service.AnaDipExtLocalService getAnaDipExtLocalService() {
		return anaDipExtLocalService;
	}

	/**
	 * Sets the ana dip ext local service.
	 *
	 * @param anaDipExtLocalService the ana dip ext local service
	 */
	public void setAnaDipExtLocalService(
		servizio.richieste.badge.mef.service.AnaDipExtLocalService anaDipExtLocalService) {
		this.anaDipExtLocalService = anaDipExtLocalService;
	}

	/**
	 * Returns the ana dip ext remote service.
	 *
	 * @return the ana dip ext remote service
	 */
	public servizio.richieste.badge.mef.service.AnaDipExtService getAnaDipExtService() {
		return anaDipExtService;
	}

	/**
	 * Sets the ana dip ext remote service.
	 *
	 * @param anaDipExtService the ana dip ext remote service
	 */
	public void setAnaDipExtService(
		servizio.richieste.badge.mef.service.AnaDipExtService anaDipExtService) {
		this.anaDipExtService = anaDipExtService;
	}

	/**
	 * Returns the ana dip ext persistence.
	 *
	 * @return the ana dip ext persistence
	 */
	public AnaDipExtPersistence getAnaDipExtPersistence() {
		return anaDipExtPersistence;
	}

	/**
	 * Sets the ana dip ext persistence.
	 *
	 * @param anaDipExtPersistence the ana dip ext persistence
	 */
	public void setAnaDipExtPersistence(
		AnaDipExtPersistence anaDipExtPersistence) {
		this.anaDipExtPersistence = anaDipExtPersistence;
	}

	/**
	 * Returns the gestione utenti local service.
	 *
	 * @return the gestione utenti local service
	 */
	public servizio.richieste.badge.mef.service.GestioneUtentiLocalService getGestioneUtentiLocalService() {
		return gestioneUtentiLocalService;
	}

	/**
	 * Sets the gestione utenti local service.
	 *
	 * @param gestioneUtentiLocalService the gestione utenti local service
	 */
	public void setGestioneUtentiLocalService(
		servizio.richieste.badge.mef.service.GestioneUtentiLocalService gestioneUtentiLocalService) {
		this.gestioneUtentiLocalService = gestioneUtentiLocalService;
	}

	/**
	 * Returns the gestione utenti remote service.
	 *
	 * @return the gestione utenti remote service
	 */
	public servizio.richieste.badge.mef.service.GestioneUtentiService getGestioneUtentiService() {
		return gestioneUtentiService;
	}

	/**
	 * Sets the gestione utenti remote service.
	 *
	 * @param gestioneUtentiService the gestione utenti remote service
	 */
	public void setGestioneUtentiService(
		servizio.richieste.badge.mef.service.GestioneUtentiService gestioneUtentiService) {
		this.gestioneUtentiService = gestioneUtentiService;
	}

	/**
	 * Returns the gestione utenti persistence.
	 *
	 * @return the gestione utenti persistence
	 */
	public GestioneUtentiPersistence getGestioneUtentiPersistence() {
		return gestioneUtentiPersistence;
	}

	/**
	 * Sets the gestione utenti persistence.
	 *
	 * @param gestioneUtentiPersistence the gestione utenti persistence
	 */
	public void setGestioneUtentiPersistence(
		GestioneUtentiPersistence gestioneUtentiPersistence) {
		this.gestioneUtentiPersistence = gestioneUtentiPersistence;
	}

	/**
	 * Returns the oggetto richiesta local service.
	 *
	 * @return the oggetto richiesta local service
	 */
	public servizio.richieste.badge.mef.service.OggettoRichiestaLocalService getOggettoRichiestaLocalService() {
		return oggettoRichiestaLocalService;
	}

	/**
	 * Sets the oggetto richiesta local service.
	 *
	 * @param oggettoRichiestaLocalService the oggetto richiesta local service
	 */
	public void setOggettoRichiestaLocalService(
		servizio.richieste.badge.mef.service.OggettoRichiestaLocalService oggettoRichiestaLocalService) {
		this.oggettoRichiestaLocalService = oggettoRichiestaLocalService;
	}

	/**
	 * Returns the oggetto richiesta remote service.
	 *
	 * @return the oggetto richiesta remote service
	 */
	public servizio.richieste.badge.mef.service.OggettoRichiestaService getOggettoRichiestaService() {
		return oggettoRichiestaService;
	}

	/**
	 * Sets the oggetto richiesta remote service.
	 *
	 * @param oggettoRichiestaService the oggetto richiesta remote service
	 */
	public void setOggettoRichiestaService(
		servizio.richieste.badge.mef.service.OggettoRichiestaService oggettoRichiestaService) {
		this.oggettoRichiestaService = oggettoRichiestaService;
	}

	/**
	 * Returns the oggetto richiesta persistence.
	 *
	 * @return the oggetto richiesta persistence
	 */
	public OggettoRichiestaPersistence getOggettoRichiestaPersistence() {
		return oggettoRichiestaPersistence;
	}

	/**
	 * Sets the oggetto richiesta persistence.
	 *
	 * @param oggettoRichiestaPersistence the oggetto richiesta persistence
	 */
	public void setOggettoRichiestaPersistence(
		OggettoRichiestaPersistence oggettoRichiestaPersistence) {
		this.oggettoRichiestaPersistence = oggettoRichiestaPersistence;
	}

	/**
	 * Returns the richiesta badge local service.
	 *
	 * @return the richiesta badge local service
	 */
	public servizio.richieste.badge.mef.service.RichiestaBadgeLocalService getRichiestaBadgeLocalService() {
		return richiestaBadgeLocalService;
	}

	/**
	 * Sets the richiesta badge local service.
	 *
	 * @param richiestaBadgeLocalService the richiesta badge local service
	 */
	public void setRichiestaBadgeLocalService(
		servizio.richieste.badge.mef.service.RichiestaBadgeLocalService richiestaBadgeLocalService) {
		this.richiestaBadgeLocalService = richiestaBadgeLocalService;
	}

	/**
	 * Returns the richiesta badge remote service.
	 *
	 * @return the richiesta badge remote service
	 */
	public servizio.richieste.badge.mef.service.RichiestaBadgeService getRichiestaBadgeService() {
		return richiestaBadgeService;
	}

	/**
	 * Sets the richiesta badge remote service.
	 *
	 * @param richiestaBadgeService the richiesta badge remote service
	 */
	public void setRichiestaBadgeService(
		servizio.richieste.badge.mef.service.RichiestaBadgeService richiestaBadgeService) {
		this.richiestaBadgeService = richiestaBadgeService;
	}

	/**
	 * Returns the richiesta badge persistence.
	 *
	 * @return the richiesta badge persistence
	 */
	public RichiestaBadgePersistence getRichiestaBadgePersistence() {
		return richiestaBadgePersistence;
	}

	/**
	 * Sets the richiesta badge persistence.
	 *
	 * @param richiestaBadgePersistence the richiesta badge persistence
	 */
	public void setRichiestaBadgePersistence(
		RichiestaBadgePersistence richiestaBadgePersistence) {
		this.richiestaBadgePersistence = richiestaBadgePersistence;
	}

	/**
	 * Returns the richiesta badge finder.
	 *
	 * @return the richiesta badge finder
	 */
	public RichiestaBadgeFinder getRichiestaBadgeFinder() {
		return richiestaBadgeFinder;
	}

	/**
	 * Sets the richiesta badge finder.
	 *
	 * @param richiestaBadgeFinder the richiesta badge finder
	 */
	public void setRichiestaBadgeFinder(
		RichiestaBadgeFinder richiestaBadgeFinder) {
		this.richiestaBadgeFinder = richiestaBadgeFinder;
	}

	/**
	 * Returns the sedi esterne local service.
	 *
	 * @return the sedi esterne local service
	 */
	public servizio.richieste.badge.mef.service.SediEsterneLocalService getSediEsterneLocalService() {
		return sediEsterneLocalService;
	}

	/**
	 * Sets the sedi esterne local service.
	 *
	 * @param sediEsterneLocalService the sedi esterne local service
	 */
	public void setSediEsterneLocalService(
		servizio.richieste.badge.mef.service.SediEsterneLocalService sediEsterneLocalService) {
		this.sediEsterneLocalService = sediEsterneLocalService;
	}

	/**
	 * Returns the sedi esterne remote service.
	 *
	 * @return the sedi esterne remote service
	 */
	public servizio.richieste.badge.mef.service.SediEsterneService getSediEsterneService() {
		return sediEsterneService;
	}

	/**
	 * Sets the sedi esterne remote service.
	 *
	 * @param sediEsterneService the sedi esterne remote service
	 */
	public void setSediEsterneService(
		servizio.richieste.badge.mef.service.SediEsterneService sediEsterneService) {
		this.sediEsterneService = sediEsterneService;
	}

	/**
	 * Returns the sedi esterne persistence.
	 *
	 * @return the sedi esterne persistence
	 */
	public SediEsternePersistence getSediEsternePersistence() {
		return sediEsternePersistence;
	}

	/**
	 * Sets the sedi esterne persistence.
	 *
	 * @param sediEsternePersistence the sedi esterne persistence
	 */
	public void setSediEsternePersistence(
		SediEsternePersistence sediEsternePersistence) {
		this.sediEsternePersistence = sediEsternePersistence;
	}

	/**
	 * Returns the stato richiesta local service.
	 *
	 * @return the stato richiesta local service
	 */
	public servizio.richieste.badge.mef.service.StatoRichiestaLocalService getStatoRichiestaLocalService() {
		return statoRichiestaLocalService;
	}

	/**
	 * Sets the stato richiesta local service.
	 *
	 * @param statoRichiestaLocalService the stato richiesta local service
	 */
	public void setStatoRichiestaLocalService(
		servizio.richieste.badge.mef.service.StatoRichiestaLocalService statoRichiestaLocalService) {
		this.statoRichiestaLocalService = statoRichiestaLocalService;
	}

	/**
	 * Returns the stato richiesta remote service.
	 *
	 * @return the stato richiesta remote service
	 */
	public StatoRichiestaService getStatoRichiestaService() {
		return statoRichiestaService;
	}

	/**
	 * Sets the stato richiesta remote service.
	 *
	 * @param statoRichiestaService the stato richiesta remote service
	 */
	public void setStatoRichiestaService(
		StatoRichiestaService statoRichiestaService) {
		this.statoRichiestaService = statoRichiestaService;
	}

	/**
	 * Returns the stato richiesta persistence.
	 *
	 * @return the stato richiesta persistence
	 */
	public StatoRichiestaPersistence getStatoRichiestaPersistence() {
		return statoRichiestaPersistence;
	}

	/**
	 * Sets the stato richiesta persistence.
	 *
	 * @param statoRichiestaPersistence the stato richiesta persistence
	 */
	public void setStatoRichiestaPersistence(
		StatoRichiestaPersistence statoRichiestaPersistence) {
		this.statoRichiestaPersistence = statoRichiestaPersistence;
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
		return StatoRichiestaService.class.getName();
	}

	protected Class<?> getModelClass() {
		return StatoRichiesta.class;
	}

	protected String getModelClassName() {
		return StatoRichiesta.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = statoRichiestaPersistence.getDataSource();

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

	@BeanReference(type = servizio.richieste.badge.mef.service.AnaDipExtLocalService.class)
	protected servizio.richieste.badge.mef.service.AnaDipExtLocalService anaDipExtLocalService;
	@BeanReference(type = servizio.richieste.badge.mef.service.AnaDipExtService.class)
	protected servizio.richieste.badge.mef.service.AnaDipExtService anaDipExtService;
	@BeanReference(type = AnaDipExtPersistence.class)
	protected AnaDipExtPersistence anaDipExtPersistence;
	@BeanReference(type = servizio.richieste.badge.mef.service.GestioneUtentiLocalService.class)
	protected servizio.richieste.badge.mef.service.GestioneUtentiLocalService gestioneUtentiLocalService;
	@BeanReference(type = servizio.richieste.badge.mef.service.GestioneUtentiService.class)
	protected servizio.richieste.badge.mef.service.GestioneUtentiService gestioneUtentiService;
	@BeanReference(type = GestioneUtentiPersistence.class)
	protected GestioneUtentiPersistence gestioneUtentiPersistence;
	@BeanReference(type = servizio.richieste.badge.mef.service.OggettoRichiestaLocalService.class)
	protected servizio.richieste.badge.mef.service.OggettoRichiestaLocalService oggettoRichiestaLocalService;
	@BeanReference(type = servizio.richieste.badge.mef.service.OggettoRichiestaService.class)
	protected servizio.richieste.badge.mef.service.OggettoRichiestaService oggettoRichiestaService;
	@BeanReference(type = OggettoRichiestaPersistence.class)
	protected OggettoRichiestaPersistence oggettoRichiestaPersistence;
	@BeanReference(type = servizio.richieste.badge.mef.service.RichiestaBadgeLocalService.class)
	protected servizio.richieste.badge.mef.service.RichiestaBadgeLocalService richiestaBadgeLocalService;
	@BeanReference(type = servizio.richieste.badge.mef.service.RichiestaBadgeService.class)
	protected servizio.richieste.badge.mef.service.RichiestaBadgeService richiestaBadgeService;
	@BeanReference(type = RichiestaBadgePersistence.class)
	protected RichiestaBadgePersistence richiestaBadgePersistence;
	@BeanReference(type = RichiestaBadgeFinder.class)
	protected RichiestaBadgeFinder richiestaBadgeFinder;
	@BeanReference(type = servizio.richieste.badge.mef.service.SediEsterneLocalService.class)
	protected servizio.richieste.badge.mef.service.SediEsterneLocalService sediEsterneLocalService;
	@BeanReference(type = servizio.richieste.badge.mef.service.SediEsterneService.class)
	protected servizio.richieste.badge.mef.service.SediEsterneService sediEsterneService;
	@BeanReference(type = SediEsternePersistence.class)
	protected SediEsternePersistence sediEsternePersistence;
	@BeanReference(type = servizio.richieste.badge.mef.service.StatoRichiestaLocalService.class)
	protected servizio.richieste.badge.mef.service.StatoRichiestaLocalService statoRichiestaLocalService;
	@BeanReference(type = StatoRichiestaService.class)
	protected StatoRichiestaService statoRichiestaService;
	@BeanReference(type = StatoRichiestaPersistence.class)
	protected StatoRichiestaPersistence statoRichiestaPersistence;
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