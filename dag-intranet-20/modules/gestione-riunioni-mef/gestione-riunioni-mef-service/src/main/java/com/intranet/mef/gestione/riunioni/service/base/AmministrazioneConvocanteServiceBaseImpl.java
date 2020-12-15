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

package com.intranet.mef.gestione.riunioni.service.base;

import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteService;
import com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocanteFinder;
import com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocantePersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.LuogoFinder;
import com.intranet.mef.gestione.riunioni.service.persistence.LuogoPersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.RiunioneFinder;
import com.intranet.mef.gestione.riunioni.service.persistence.RiunionePersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.SegreteriaPersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.StatoInvitatoPersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.StatoRiunionePersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.TipoRiunionePersistence;

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

import javax.sql.DataSource;

/**
 * Provides the base implementation for the amministrazione convocante remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.intranet.mef.gestione.riunioni.service.impl.AmministrazioneConvocanteServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.impl.AmministrazioneConvocanteServiceImpl
 * @see com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteServiceUtil
 * @generated
 */
public abstract class AmministrazioneConvocanteServiceBaseImpl
	extends BaseServiceImpl implements AmministrazioneConvocanteService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteServiceUtil} to access the amministrazione convocante remote service.
	 */

	/**
	 * Returns the amministrazione convocante local service.
	 *
	 * @return the amministrazione convocante local service
	 */
	public com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalService getAmministrazioneConvocanteLocalService() {
		return amministrazioneConvocanteLocalService;
	}

	/**
	 * Sets the amministrazione convocante local service.
	 *
	 * @param amministrazioneConvocanteLocalService the amministrazione convocante local service
	 */
	public void setAmministrazioneConvocanteLocalService(
		com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalService amministrazioneConvocanteLocalService) {
		this.amministrazioneConvocanteLocalService = amministrazioneConvocanteLocalService;
	}

	/**
	 * Returns the amministrazione convocante remote service.
	 *
	 * @return the amministrazione convocante remote service
	 */
	public AmministrazioneConvocanteService getAmministrazioneConvocanteService() {
		return amministrazioneConvocanteService;
	}

	/**
	 * Sets the amministrazione convocante remote service.
	 *
	 * @param amministrazioneConvocanteService the amministrazione convocante remote service
	 */
	public void setAmministrazioneConvocanteService(
		AmministrazioneConvocanteService amministrazioneConvocanteService) {
		this.amministrazioneConvocanteService = amministrazioneConvocanteService;
	}

	/**
	 * Returns the amministrazione convocante persistence.
	 *
	 * @return the amministrazione convocante persistence
	 */
	public AmministrazioneConvocantePersistence getAmministrazioneConvocantePersistence() {
		return amministrazioneConvocantePersistence;
	}

	/**
	 * Sets the amministrazione convocante persistence.
	 *
	 * @param amministrazioneConvocantePersistence the amministrazione convocante persistence
	 */
	public void setAmministrazioneConvocantePersistence(
		AmministrazioneConvocantePersistence amministrazioneConvocantePersistence) {
		this.amministrazioneConvocantePersistence = amministrazioneConvocantePersistence;
	}

	/**
	 * Returns the amministrazione convocante finder.
	 *
	 * @return the amministrazione convocante finder
	 */
	public AmministrazioneConvocanteFinder getAmministrazioneConvocanteFinder() {
		return amministrazioneConvocanteFinder;
	}

	/**
	 * Sets the amministrazione convocante finder.
	 *
	 * @param amministrazioneConvocanteFinder the amministrazione convocante finder
	 */
	public void setAmministrazioneConvocanteFinder(
		AmministrazioneConvocanteFinder amministrazioneConvocanteFinder) {
		this.amministrazioneConvocanteFinder = amministrazioneConvocanteFinder;
	}

	/**
	 * Returns the invitati riunione local service.
	 *
	 * @return the invitati riunione local service
	 */
	public com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalService getInvitatiRiunioneLocalService() {
		return invitatiRiunioneLocalService;
	}

	/**
	 * Sets the invitati riunione local service.
	 *
	 * @param invitatiRiunioneLocalService the invitati riunione local service
	 */
	public void setInvitatiRiunioneLocalService(
		com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalService invitatiRiunioneLocalService) {
		this.invitatiRiunioneLocalService = invitatiRiunioneLocalService;
	}

	/**
	 * Returns the invitati riunione remote service.
	 *
	 * @return the invitati riunione remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneService getInvitatiRiunioneService() {
		return invitatiRiunioneService;
	}

	/**
	 * Sets the invitati riunione remote service.
	 *
	 * @param invitatiRiunioneService the invitati riunione remote service
	 */
	public void setInvitatiRiunioneService(
		com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneService invitatiRiunioneService) {
		this.invitatiRiunioneService = invitatiRiunioneService;
	}

	/**
	 * Returns the invitati riunione persistence.
	 *
	 * @return the invitati riunione persistence
	 */
	public InvitatiRiunionePersistence getInvitatiRiunionePersistence() {
		return invitatiRiunionePersistence;
	}

	/**
	 * Sets the invitati riunione persistence.
	 *
	 * @param invitatiRiunionePersistence the invitati riunione persistence
	 */
	public void setInvitatiRiunionePersistence(
		InvitatiRiunionePersistence invitatiRiunionePersistence) {
		this.invitatiRiunionePersistence = invitatiRiunionePersistence;
	}

	/**
	 * Returns the luogo local service.
	 *
	 * @return the luogo local service
	 */
	public com.intranet.mef.gestione.riunioni.service.LuogoLocalService getLuogoLocalService() {
		return luogoLocalService;
	}

	/**
	 * Sets the luogo local service.
	 *
	 * @param luogoLocalService the luogo local service
	 */
	public void setLuogoLocalService(
		com.intranet.mef.gestione.riunioni.service.LuogoLocalService luogoLocalService) {
		this.luogoLocalService = luogoLocalService;
	}

	/**
	 * Returns the luogo remote service.
	 *
	 * @return the luogo remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.LuogoService getLuogoService() {
		return luogoService;
	}

	/**
	 * Sets the luogo remote service.
	 *
	 * @param luogoService the luogo remote service
	 */
	public void setLuogoService(
		com.intranet.mef.gestione.riunioni.service.LuogoService luogoService) {
		this.luogoService = luogoService;
	}

	/**
	 * Returns the luogo persistence.
	 *
	 * @return the luogo persistence
	 */
	public LuogoPersistence getLuogoPersistence() {
		return luogoPersistence;
	}

	/**
	 * Sets the luogo persistence.
	 *
	 * @param luogoPersistence the luogo persistence
	 */
	public void setLuogoPersistence(LuogoPersistence luogoPersistence) {
		this.luogoPersistence = luogoPersistence;
	}

	/**
	 * Returns the luogo finder.
	 *
	 * @return the luogo finder
	 */
	public LuogoFinder getLuogoFinder() {
		return luogoFinder;
	}

	/**
	 * Sets the luogo finder.
	 *
	 * @param luogoFinder the luogo finder
	 */
	public void setLuogoFinder(LuogoFinder luogoFinder) {
		this.luogoFinder = luogoFinder;
	}

	/**
	 * Returns the riunione local service.
	 *
	 * @return the riunione local service
	 */
	public com.intranet.mef.gestione.riunioni.service.RiunioneLocalService getRiunioneLocalService() {
		return riunioneLocalService;
	}

	/**
	 * Sets the riunione local service.
	 *
	 * @param riunioneLocalService the riunione local service
	 */
	public void setRiunioneLocalService(
		com.intranet.mef.gestione.riunioni.service.RiunioneLocalService riunioneLocalService) {
		this.riunioneLocalService = riunioneLocalService;
	}

	/**
	 * Returns the riunione remote service.
	 *
	 * @return the riunione remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.RiunioneService getRiunioneService() {
		return riunioneService;
	}

	/**
	 * Sets the riunione remote service.
	 *
	 * @param riunioneService the riunione remote service
	 */
	public void setRiunioneService(
		com.intranet.mef.gestione.riunioni.service.RiunioneService riunioneService) {
		this.riunioneService = riunioneService;
	}

	/**
	 * Returns the riunione persistence.
	 *
	 * @return the riunione persistence
	 */
	public RiunionePersistence getRiunionePersistence() {
		return riunionePersistence;
	}

	/**
	 * Sets the riunione persistence.
	 *
	 * @param riunionePersistence the riunione persistence
	 */
	public void setRiunionePersistence(RiunionePersistence riunionePersistence) {
		this.riunionePersistence = riunionePersistence;
	}

	/**
	 * Returns the riunione finder.
	 *
	 * @return the riunione finder
	 */
	public RiunioneFinder getRiunioneFinder() {
		return riunioneFinder;
	}

	/**
	 * Sets the riunione finder.
	 *
	 * @param riunioneFinder the riunione finder
	 */
	public void setRiunioneFinder(RiunioneFinder riunioneFinder) {
		this.riunioneFinder = riunioneFinder;
	}

	/**
	 * Returns the segreteria local service.
	 *
	 * @return the segreteria local service
	 */
	public com.intranet.mef.gestione.riunioni.service.SegreteriaLocalService getSegreteriaLocalService() {
		return segreteriaLocalService;
	}

	/**
	 * Sets the segreteria local service.
	 *
	 * @param segreteriaLocalService the segreteria local service
	 */
	public void setSegreteriaLocalService(
		com.intranet.mef.gestione.riunioni.service.SegreteriaLocalService segreteriaLocalService) {
		this.segreteriaLocalService = segreteriaLocalService;
	}

	/**
	 * Returns the segreteria remote service.
	 *
	 * @return the segreteria remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.SegreteriaService getSegreteriaService() {
		return segreteriaService;
	}

	/**
	 * Sets the segreteria remote service.
	 *
	 * @param segreteriaService the segreteria remote service
	 */
	public void setSegreteriaService(
		com.intranet.mef.gestione.riunioni.service.SegreteriaService segreteriaService) {
		this.segreteriaService = segreteriaService;
	}

	/**
	 * Returns the segreteria persistence.
	 *
	 * @return the segreteria persistence
	 */
	public SegreteriaPersistence getSegreteriaPersistence() {
		return segreteriaPersistence;
	}

	/**
	 * Sets the segreteria persistence.
	 *
	 * @param segreteriaPersistence the segreteria persistence
	 */
	public void setSegreteriaPersistence(
		SegreteriaPersistence segreteriaPersistence) {
		this.segreteriaPersistence = segreteriaPersistence;
	}

	/**
	 * Returns the stato invitato local service.
	 *
	 * @return the stato invitato local service
	 */
	public com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalService getStatoInvitatoLocalService() {
		return statoInvitatoLocalService;
	}

	/**
	 * Sets the stato invitato local service.
	 *
	 * @param statoInvitatoLocalService the stato invitato local service
	 */
	public void setStatoInvitatoLocalService(
		com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalService statoInvitatoLocalService) {
		this.statoInvitatoLocalService = statoInvitatoLocalService;
	}

	/**
	 * Returns the stato invitato remote service.
	 *
	 * @return the stato invitato remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.StatoInvitatoService getStatoInvitatoService() {
		return statoInvitatoService;
	}

	/**
	 * Sets the stato invitato remote service.
	 *
	 * @param statoInvitatoService the stato invitato remote service
	 */
	public void setStatoInvitatoService(
		com.intranet.mef.gestione.riunioni.service.StatoInvitatoService statoInvitatoService) {
		this.statoInvitatoService = statoInvitatoService;
	}

	/**
	 * Returns the stato invitato persistence.
	 *
	 * @return the stato invitato persistence
	 */
	public StatoInvitatoPersistence getStatoInvitatoPersistence() {
		return statoInvitatoPersistence;
	}

	/**
	 * Sets the stato invitato persistence.
	 *
	 * @param statoInvitatoPersistence the stato invitato persistence
	 */
	public void setStatoInvitatoPersistence(
		StatoInvitatoPersistence statoInvitatoPersistence) {
		this.statoInvitatoPersistence = statoInvitatoPersistence;
	}

	/**
	 * Returns the stato riunione local service.
	 *
	 * @return the stato riunione local service
	 */
	public com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalService getStatoRiunioneLocalService() {
		return statoRiunioneLocalService;
	}

	/**
	 * Sets the stato riunione local service.
	 *
	 * @param statoRiunioneLocalService the stato riunione local service
	 */
	public void setStatoRiunioneLocalService(
		com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalService statoRiunioneLocalService) {
		this.statoRiunioneLocalService = statoRiunioneLocalService;
	}

	/**
	 * Returns the stato riunione remote service.
	 *
	 * @return the stato riunione remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.StatoRiunioneService getStatoRiunioneService() {
		return statoRiunioneService;
	}

	/**
	 * Sets the stato riunione remote service.
	 *
	 * @param statoRiunioneService the stato riunione remote service
	 */
	public void setStatoRiunioneService(
		com.intranet.mef.gestione.riunioni.service.StatoRiunioneService statoRiunioneService) {
		this.statoRiunioneService = statoRiunioneService;
	}

	/**
	 * Returns the stato riunione persistence.
	 *
	 * @return the stato riunione persistence
	 */
	public StatoRiunionePersistence getStatoRiunionePersistence() {
		return statoRiunionePersistence;
	}

	/**
	 * Sets the stato riunione persistence.
	 *
	 * @param statoRiunionePersistence the stato riunione persistence
	 */
	public void setStatoRiunionePersistence(
		StatoRiunionePersistence statoRiunionePersistence) {
		this.statoRiunionePersistence = statoRiunionePersistence;
	}

	/**
	 * Returns the storico stato riunione local service.
	 *
	 * @return the storico stato riunione local service
	 */
	public com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalService getStoricoStatoRiunioneLocalService() {
		return storicoStatoRiunioneLocalService;
	}

	/**
	 * Sets the storico stato riunione local service.
	 *
	 * @param storicoStatoRiunioneLocalService the storico stato riunione local service
	 */
	public void setStoricoStatoRiunioneLocalService(
		com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalService storicoStatoRiunioneLocalService) {
		this.storicoStatoRiunioneLocalService = storicoStatoRiunioneLocalService;
	}

	/**
	 * Returns the storico stato riunione remote service.
	 *
	 * @return the storico stato riunione remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneService getStoricoStatoRiunioneService() {
		return storicoStatoRiunioneService;
	}

	/**
	 * Sets the storico stato riunione remote service.
	 *
	 * @param storicoStatoRiunioneService the storico stato riunione remote service
	 */
	public void setStoricoStatoRiunioneService(
		com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneService storicoStatoRiunioneService) {
		this.storicoStatoRiunioneService = storicoStatoRiunioneService;
	}

	/**
	 * Returns the storico stato riunione persistence.
	 *
	 * @return the storico stato riunione persistence
	 */
	public StoricoStatoRiunionePersistence getStoricoStatoRiunionePersistence() {
		return storicoStatoRiunionePersistence;
	}

	/**
	 * Sets the storico stato riunione persistence.
	 *
	 * @param storicoStatoRiunionePersistence the storico stato riunione persistence
	 */
	public void setStoricoStatoRiunionePersistence(
		StoricoStatoRiunionePersistence storicoStatoRiunionePersistence) {
		this.storicoStatoRiunionePersistence = storicoStatoRiunionePersistence;
	}

	/**
	 * Returns the tipo riunione local service.
	 *
	 * @return the tipo riunione local service
	 */
	public com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalService getTipoRiunioneLocalService() {
		return tipoRiunioneLocalService;
	}

	/**
	 * Sets the tipo riunione local service.
	 *
	 * @param tipoRiunioneLocalService the tipo riunione local service
	 */
	public void setTipoRiunioneLocalService(
		com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalService tipoRiunioneLocalService) {
		this.tipoRiunioneLocalService = tipoRiunioneLocalService;
	}

	/**
	 * Returns the tipo riunione remote service.
	 *
	 * @return the tipo riunione remote service
	 */
	public com.intranet.mef.gestione.riunioni.service.TipoRiunioneService getTipoRiunioneService() {
		return tipoRiunioneService;
	}

	/**
	 * Sets the tipo riunione remote service.
	 *
	 * @param tipoRiunioneService the tipo riunione remote service
	 */
	public void setTipoRiunioneService(
		com.intranet.mef.gestione.riunioni.service.TipoRiunioneService tipoRiunioneService) {
		this.tipoRiunioneService = tipoRiunioneService;
	}

	/**
	 * Returns the tipo riunione persistence.
	 *
	 * @return the tipo riunione persistence
	 */
	public TipoRiunionePersistence getTipoRiunionePersistence() {
		return tipoRiunionePersistence;
	}

	/**
	 * Sets the tipo riunione persistence.
	 *
	 * @param tipoRiunionePersistence the tipo riunione persistence
	 */
	public void setTipoRiunionePersistence(
		TipoRiunionePersistence tipoRiunionePersistence) {
		this.tipoRiunionePersistence = tipoRiunionePersistence;
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
		return AmministrazioneConvocanteService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AmministrazioneConvocante.class;
	}

	protected String getModelClassName() {
		return AmministrazioneConvocante.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = amministrazioneConvocantePersistence.getDataSource();

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

	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalService amministrazioneConvocanteLocalService;
	@BeanReference(type = AmministrazioneConvocanteService.class)
	protected AmministrazioneConvocanteService amministrazioneConvocanteService;
	@BeanReference(type = AmministrazioneConvocantePersistence.class)
	protected AmministrazioneConvocantePersistence amministrazioneConvocantePersistence;
	@BeanReference(type = AmministrazioneConvocanteFinder.class)
	protected AmministrazioneConvocanteFinder amministrazioneConvocanteFinder;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalService invitatiRiunioneLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneService.class)
	protected com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneService invitatiRiunioneService;
	@BeanReference(type = InvitatiRiunionePersistence.class)
	protected InvitatiRiunionePersistence invitatiRiunionePersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.LuogoLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.LuogoLocalService luogoLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.LuogoService.class)
	protected com.intranet.mef.gestione.riunioni.service.LuogoService luogoService;
	@BeanReference(type = LuogoPersistence.class)
	protected LuogoPersistence luogoPersistence;
	@BeanReference(type = LuogoFinder.class)
	protected LuogoFinder luogoFinder;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.RiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.RiunioneLocalService riunioneLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.RiunioneService.class)
	protected com.intranet.mef.gestione.riunioni.service.RiunioneService riunioneService;
	@BeanReference(type = RiunionePersistence.class)
	protected RiunionePersistence riunionePersistence;
	@BeanReference(type = RiunioneFinder.class)
	protected RiunioneFinder riunioneFinder;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.SegreteriaLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.SegreteriaLocalService segreteriaLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.SegreteriaService.class)
	protected com.intranet.mef.gestione.riunioni.service.SegreteriaService segreteriaService;
	@BeanReference(type = SegreteriaPersistence.class)
	protected SegreteriaPersistence segreteriaPersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalService statoInvitatoLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StatoInvitatoService.class)
	protected com.intranet.mef.gestione.riunioni.service.StatoInvitatoService statoInvitatoService;
	@BeanReference(type = StatoInvitatoPersistence.class)
	protected StatoInvitatoPersistence statoInvitatoPersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalService statoRiunioneLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StatoRiunioneService.class)
	protected com.intranet.mef.gestione.riunioni.service.StatoRiunioneService statoRiunioneService;
	@BeanReference(type = StatoRiunionePersistence.class)
	protected StatoRiunionePersistence statoRiunionePersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalService storicoStatoRiunioneLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneService.class)
	protected com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneService storicoStatoRiunioneService;
	@BeanReference(type = StoricoStatoRiunionePersistence.class)
	protected StoricoStatoRiunionePersistence storicoStatoRiunionePersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalService tipoRiunioneLocalService;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.TipoRiunioneService.class)
	protected com.intranet.mef.gestione.riunioni.service.TipoRiunioneService tipoRiunioneService;
	@BeanReference(type = TipoRiunionePersistence.class)
	protected TipoRiunionePersistence tipoRiunionePersistence;
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