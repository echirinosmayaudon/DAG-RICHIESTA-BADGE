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

package servizio.beni.facile.consumo.service.base;

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

import servizio.beni.facile.consumo.model.GestioneUtenti;
import servizio.beni.facile.consumo.service.GestioneUtentiService;
import servizio.beni.facile.consumo.service.persistence.CambioStatoDirigentePersistence;
import servizio.beni.facile.consumo.service.persistence.GestioneUtentiPersistence;
import servizio.beni.facile.consumo.service.persistence.PeriodicitaPersistence;
import servizio.beni.facile.consumo.service.persistence.RigheRichiestaBFCPersistence;
import servizio.beni.facile.consumo.service.persistence.ServizioMaterialePersistence;
import servizio.beni.facile.consumo.service.persistence.StatoPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the gestione utenti remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link servizio.beni.facile.consumo.service.impl.GestioneUtentiServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.impl.GestioneUtentiServiceImpl
 * @see servizio.beni.facile.consumo.service.GestioneUtentiServiceUtil
 * @generated
 */
public abstract class GestioneUtentiServiceBaseImpl extends BaseServiceImpl
	implements GestioneUtentiService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link servizio.beni.facile.consumo.service.GestioneUtentiServiceUtil} to access the gestione utenti remote service.
	 */

	/**
	 * Returns the cambio stato dirigente local service.
	 *
	 * @return the cambio stato dirigente local service
	 */
	public servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalService getCambioStatoDirigenteLocalService() {
		return cambioStatoDirigenteLocalService;
	}

	/**
	 * Sets the cambio stato dirigente local service.
	 *
	 * @param cambioStatoDirigenteLocalService the cambio stato dirigente local service
	 */
	public void setCambioStatoDirigenteLocalService(
		servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalService cambioStatoDirigenteLocalService) {
		this.cambioStatoDirigenteLocalService = cambioStatoDirigenteLocalService;
	}

	/**
	 * Returns the cambio stato dirigente remote service.
	 *
	 * @return the cambio stato dirigente remote service
	 */
	public servizio.beni.facile.consumo.service.CambioStatoDirigenteService getCambioStatoDirigenteService() {
		return cambioStatoDirigenteService;
	}

	/**
	 * Sets the cambio stato dirigente remote service.
	 *
	 * @param cambioStatoDirigenteService the cambio stato dirigente remote service
	 */
	public void setCambioStatoDirigenteService(
		servizio.beni.facile.consumo.service.CambioStatoDirigenteService cambioStatoDirigenteService) {
		this.cambioStatoDirigenteService = cambioStatoDirigenteService;
	}

	/**
	 * Returns the cambio stato dirigente persistence.
	 *
	 * @return the cambio stato dirigente persistence
	 */
	public CambioStatoDirigentePersistence getCambioStatoDirigentePersistence() {
		return cambioStatoDirigentePersistence;
	}

	/**
	 * Sets the cambio stato dirigente persistence.
	 *
	 * @param cambioStatoDirigentePersistence the cambio stato dirigente persistence
	 */
	public void setCambioStatoDirigentePersistence(
		CambioStatoDirigentePersistence cambioStatoDirigentePersistence) {
		this.cambioStatoDirigentePersistence = cambioStatoDirigentePersistence;
	}

	/**
	 * Returns the gestione utenti local service.
	 *
	 * @return the gestione utenti local service
	 */
	public servizio.beni.facile.consumo.service.GestioneUtentiLocalService getGestioneUtentiLocalService() {
		return gestioneUtentiLocalService;
	}

	/**
	 * Sets the gestione utenti local service.
	 *
	 * @param gestioneUtentiLocalService the gestione utenti local service
	 */
	public void setGestioneUtentiLocalService(
		servizio.beni.facile.consumo.service.GestioneUtentiLocalService gestioneUtentiLocalService) {
		this.gestioneUtentiLocalService = gestioneUtentiLocalService;
	}

	/**
	 * Returns the gestione utenti remote service.
	 *
	 * @return the gestione utenti remote service
	 */
	public GestioneUtentiService getGestioneUtentiService() {
		return gestioneUtentiService;
	}

	/**
	 * Sets the gestione utenti remote service.
	 *
	 * @param gestioneUtentiService the gestione utenti remote service
	 */
	public void setGestioneUtentiService(
		GestioneUtentiService gestioneUtentiService) {
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
	 * Returns the periodicita local service.
	 *
	 * @return the periodicita local service
	 */
	public servizio.beni.facile.consumo.service.PeriodicitaLocalService getPeriodicitaLocalService() {
		return periodicitaLocalService;
	}

	/**
	 * Sets the periodicita local service.
	 *
	 * @param periodicitaLocalService the periodicita local service
	 */
	public void setPeriodicitaLocalService(
		servizio.beni.facile.consumo.service.PeriodicitaLocalService periodicitaLocalService) {
		this.periodicitaLocalService = periodicitaLocalService;
	}

	/**
	 * Returns the periodicita remote service.
	 *
	 * @return the periodicita remote service
	 */
	public servizio.beni.facile.consumo.service.PeriodicitaService getPeriodicitaService() {
		return periodicitaService;
	}

	/**
	 * Sets the periodicita remote service.
	 *
	 * @param periodicitaService the periodicita remote service
	 */
	public void setPeriodicitaService(
		servizio.beni.facile.consumo.service.PeriodicitaService periodicitaService) {
		this.periodicitaService = periodicitaService;
	}

	/**
	 * Returns the periodicita persistence.
	 *
	 * @return the periodicita persistence
	 */
	public PeriodicitaPersistence getPeriodicitaPersistence() {
		return periodicitaPersistence;
	}

	/**
	 * Sets the periodicita persistence.
	 *
	 * @param periodicitaPersistence the periodicita persistence
	 */
	public void setPeriodicitaPersistence(
		PeriodicitaPersistence periodicitaPersistence) {
		this.periodicitaPersistence = periodicitaPersistence;
	}

	/**
	 * Returns the righe richiesta b f c local service.
	 *
	 * @return the righe richiesta b f c local service
	 */
	public servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalService getRigheRichiestaBFCLocalService() {
		return righeRichiestaBFCLocalService;
	}

	/**
	 * Sets the righe richiesta b f c local service.
	 *
	 * @param righeRichiestaBFCLocalService the righe richiesta b f c local service
	 */
	public void setRigheRichiestaBFCLocalService(
		servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalService righeRichiestaBFCLocalService) {
		this.righeRichiestaBFCLocalService = righeRichiestaBFCLocalService;
	}

	/**
	 * Returns the righe richiesta b f c remote service.
	 *
	 * @return the righe richiesta b f c remote service
	 */
	public servizio.beni.facile.consumo.service.RigheRichiestaBFCService getRigheRichiestaBFCService() {
		return righeRichiestaBFCService;
	}

	/**
	 * Sets the righe richiesta b f c remote service.
	 *
	 * @param righeRichiestaBFCService the righe richiesta b f c remote service
	 */
	public void setRigheRichiestaBFCService(
		servizio.beni.facile.consumo.service.RigheRichiestaBFCService righeRichiestaBFCService) {
		this.righeRichiestaBFCService = righeRichiestaBFCService;
	}

	/**
	 * Returns the righe richiesta b f c persistence.
	 *
	 * @return the righe richiesta b f c persistence
	 */
	public RigheRichiestaBFCPersistence getRigheRichiestaBFCPersistence() {
		return righeRichiestaBFCPersistence;
	}

	/**
	 * Sets the righe richiesta b f c persistence.
	 *
	 * @param righeRichiestaBFCPersistence the righe richiesta b f c persistence
	 */
	public void setRigheRichiestaBFCPersistence(
		RigheRichiestaBFCPersistence righeRichiestaBFCPersistence) {
		this.righeRichiestaBFCPersistence = righeRichiestaBFCPersistence;
	}

	/**
	 * Returns the servizio materiale local service.
	 *
	 * @return the servizio materiale local service
	 */
	public servizio.beni.facile.consumo.service.ServizioMaterialeLocalService getServizioMaterialeLocalService() {
		return servizioMaterialeLocalService;
	}

	/**
	 * Sets the servizio materiale local service.
	 *
	 * @param servizioMaterialeLocalService the servizio materiale local service
	 */
	public void setServizioMaterialeLocalService(
		servizio.beni.facile.consumo.service.ServizioMaterialeLocalService servizioMaterialeLocalService) {
		this.servizioMaterialeLocalService = servizioMaterialeLocalService;
	}

	/**
	 * Returns the servizio materiale remote service.
	 *
	 * @return the servizio materiale remote service
	 */
	public servizio.beni.facile.consumo.service.ServizioMaterialeService getServizioMaterialeService() {
		return servizioMaterialeService;
	}

	/**
	 * Sets the servizio materiale remote service.
	 *
	 * @param servizioMaterialeService the servizio materiale remote service
	 */
	public void setServizioMaterialeService(
		servizio.beni.facile.consumo.service.ServizioMaterialeService servizioMaterialeService) {
		this.servizioMaterialeService = servizioMaterialeService;
	}

	/**
	 * Returns the servizio materiale persistence.
	 *
	 * @return the servizio materiale persistence
	 */
	public ServizioMaterialePersistence getServizioMaterialePersistence() {
		return servizioMaterialePersistence;
	}

	/**
	 * Sets the servizio materiale persistence.
	 *
	 * @param servizioMaterialePersistence the servizio materiale persistence
	 */
	public void setServizioMaterialePersistence(
		ServizioMaterialePersistence servizioMaterialePersistence) {
		this.servizioMaterialePersistence = servizioMaterialePersistence;
	}

	/**
	 * Returns the stato local service.
	 *
	 * @return the stato local service
	 */
	public servizio.beni.facile.consumo.service.StatoLocalService getStatoLocalService() {
		return statoLocalService;
	}

	/**
	 * Sets the stato local service.
	 *
	 * @param statoLocalService the stato local service
	 */
	public void setStatoLocalService(
		servizio.beni.facile.consumo.service.StatoLocalService statoLocalService) {
		this.statoLocalService = statoLocalService;
	}

	/**
	 * Returns the stato remote service.
	 *
	 * @return the stato remote service
	 */
	public servizio.beni.facile.consumo.service.StatoService getStatoService() {
		return statoService;
	}

	/**
	 * Sets the stato remote service.
	 *
	 * @param statoService the stato remote service
	 */
	public void setStatoService(
		servizio.beni.facile.consumo.service.StatoService statoService) {
		this.statoService = statoService;
	}

	/**
	 * Returns the stato persistence.
	 *
	 * @return the stato persistence
	 */
	public StatoPersistence getStatoPersistence() {
		return statoPersistence;
	}

	/**
	 * Sets the stato persistence.
	 *
	 * @param statoPersistence the stato persistence
	 */
	public void setStatoPersistence(StatoPersistence statoPersistence) {
		this.statoPersistence = statoPersistence;
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
		return GestioneUtentiService.class.getName();
	}

	protected Class<?> getModelClass() {
		return GestioneUtenti.class;
	}

	protected String getModelClassName() {
		return GestioneUtenti.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = gestioneUtentiPersistence.getDataSource();

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

	@BeanReference(type = servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalService.class)
	protected servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalService cambioStatoDirigenteLocalService;
	@BeanReference(type = servizio.beni.facile.consumo.service.CambioStatoDirigenteService.class)
	protected servizio.beni.facile.consumo.service.CambioStatoDirigenteService cambioStatoDirigenteService;
	@BeanReference(type = CambioStatoDirigentePersistence.class)
	protected CambioStatoDirigentePersistence cambioStatoDirigentePersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.GestioneUtentiLocalService.class)
	protected servizio.beni.facile.consumo.service.GestioneUtentiLocalService gestioneUtentiLocalService;
	@BeanReference(type = GestioneUtentiService.class)
	protected GestioneUtentiService gestioneUtentiService;
	@BeanReference(type = GestioneUtentiPersistence.class)
	protected GestioneUtentiPersistence gestioneUtentiPersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.PeriodicitaLocalService.class)
	protected servizio.beni.facile.consumo.service.PeriodicitaLocalService periodicitaLocalService;
	@BeanReference(type = servizio.beni.facile.consumo.service.PeriodicitaService.class)
	protected servizio.beni.facile.consumo.service.PeriodicitaService periodicitaService;
	@BeanReference(type = PeriodicitaPersistence.class)
	protected PeriodicitaPersistence periodicitaPersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalService.class)
	protected servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalService righeRichiestaBFCLocalService;
	@BeanReference(type = servizio.beni.facile.consumo.service.RigheRichiestaBFCService.class)
	protected servizio.beni.facile.consumo.service.RigheRichiestaBFCService righeRichiestaBFCService;
	@BeanReference(type = RigheRichiestaBFCPersistence.class)
	protected RigheRichiestaBFCPersistence righeRichiestaBFCPersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.ServizioMaterialeLocalService.class)
	protected servizio.beni.facile.consumo.service.ServizioMaterialeLocalService servizioMaterialeLocalService;
	@BeanReference(type = servizio.beni.facile.consumo.service.ServizioMaterialeService.class)
	protected servizio.beni.facile.consumo.service.ServizioMaterialeService servizioMaterialeService;
	@BeanReference(type = ServizioMaterialePersistence.class)
	protected ServizioMaterialePersistence servizioMaterialePersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.StatoLocalService.class)
	protected servizio.beni.facile.consumo.service.StatoLocalService statoLocalService;
	@BeanReference(type = servizio.beni.facile.consumo.service.StatoService.class)
	protected servizio.beni.facile.consumo.service.StatoService statoService;
	@BeanReference(type = StatoPersistence.class)
	protected StatoPersistence statoPersistence;
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