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

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalService;
import com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocanteFinder;
import com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocantePersistence;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;
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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the invitati riunione local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.intranet.mef.gestione.riunioni.service.impl.InvitatiRiunioneLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.impl.InvitatiRiunioneLocalServiceImpl
 * @see com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class InvitatiRiunioneLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements InvitatiRiunioneLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil} to access the invitati riunione local service.
	 */

	/**
	 * Adds the invitati riunione to the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitatiRiunione the invitati riunione
	 * @return the invitati riunione that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InvitatiRiunione addInvitatiRiunione(
		InvitatiRiunione invitatiRiunione) {
		invitatiRiunione.setNew(true);

		return invitatiRiunionePersistence.update(invitatiRiunione);
	}

	/**
	 * Creates a new invitati riunione with the primary key. Does not add the invitati riunione to the database.
	 *
	 * @param invitatiRiunionePK the primary key for the new invitati riunione
	 * @return the new invitati riunione
	 */
	@Override
	public InvitatiRiunione createInvitatiRiunione(
		InvitatiRiunionePK invitatiRiunionePK) {
		return invitatiRiunionePersistence.create(invitatiRiunionePK);
	}

	/**
	 * Deletes the invitati riunione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitatiRiunionePK the primary key of the invitati riunione
	 * @return the invitati riunione that was removed
	 * @throws PortalException if a invitati riunione with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InvitatiRiunione deleteInvitatiRiunione(
		InvitatiRiunionePK invitatiRiunionePK) throws PortalException {
		return invitatiRiunionePersistence.remove(invitatiRiunionePK);
	}

	/**
	 * Deletes the invitati riunione from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitatiRiunione the invitati riunione
	 * @return the invitati riunione that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InvitatiRiunione deleteInvitatiRiunione(
		InvitatiRiunione invitatiRiunione) {
		return invitatiRiunionePersistence.remove(invitatiRiunione);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(InvitatiRiunione.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return invitatiRiunionePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return invitatiRiunionePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return invitatiRiunionePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return invitatiRiunionePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return invitatiRiunionePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public InvitatiRiunione fetchInvitatiRiunione(
		InvitatiRiunionePK invitatiRiunionePK) {
		return invitatiRiunionePersistence.fetchByPrimaryKey(invitatiRiunionePK);
	}

	/**
	 * Returns the invitati riunione with the primary key.
	 *
	 * @param invitatiRiunionePK the primary key of the invitati riunione
	 * @return the invitati riunione
	 * @throws PortalException if a invitati riunione with the primary key could not be found
	 */
	@Override
	public InvitatiRiunione getInvitatiRiunione(
		InvitatiRiunionePK invitatiRiunionePK) throws PortalException {
		return invitatiRiunionePersistence.findByPrimaryKey(invitatiRiunionePK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(invitatiRiunioneLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InvitatiRiunione.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.id_segreteria");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(invitatiRiunioneLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(InvitatiRiunione.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.id_segreteria");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(invitatiRiunioneLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InvitatiRiunione.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.id_segreteria");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return invitatiRiunioneLocalService.deleteInvitatiRiunione((InvitatiRiunione)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return invitatiRiunionePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the invitati riuniones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.InvitatiRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitati riuniones
	 * @param end the upper bound of the range of invitati riuniones (not inclusive)
	 * @return the range of invitati riuniones
	 */
	@Override
	public List<InvitatiRiunione> getInvitatiRiuniones(int start, int end) {
		return invitatiRiunionePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of invitati riuniones.
	 *
	 * @return the number of invitati riuniones
	 */
	@Override
	public int getInvitatiRiunionesCount() {
		return invitatiRiunionePersistence.countAll();
	}

	/**
	 * Updates the invitati riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param invitatiRiunione the invitati riunione
	 * @return the invitati riunione that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InvitatiRiunione updateInvitatiRiunione(
		InvitatiRiunione invitatiRiunione) {
		return invitatiRiunionePersistence.update(invitatiRiunione);
	}

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
	public InvitatiRiunioneLocalService getInvitatiRiunioneLocalService() {
		return invitatiRiunioneLocalService;
	}

	/**
	 * Sets the invitati riunione local service.
	 *
	 * @param invitatiRiunioneLocalService the invitati riunione local service
	 */
	public void setInvitatiRiunioneLocalService(
		InvitatiRiunioneLocalService invitatiRiunioneLocalService) {
		this.invitatiRiunioneLocalService = invitatiRiunioneLocalService;
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
		persistedModelLocalServiceRegistry.register("com.intranet.mef.gestione.riunioni.model.InvitatiRiunione",
			invitatiRiunioneLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.intranet.mef.gestione.riunioni.model.InvitatiRiunione");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return InvitatiRiunioneLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return InvitatiRiunione.class;
	}

	protected String getModelClassName() {
		return InvitatiRiunione.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = invitatiRiunionePersistence.getDataSource();

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
	@BeanReference(type = AmministrazioneConvocantePersistence.class)
	protected AmministrazioneConvocantePersistence amministrazioneConvocantePersistence;
	@BeanReference(type = AmministrazioneConvocanteFinder.class)
	protected AmministrazioneConvocanteFinder amministrazioneConvocanteFinder;
	@BeanReference(type = InvitatiRiunioneLocalService.class)
	protected InvitatiRiunioneLocalService invitatiRiunioneLocalService;
	@BeanReference(type = InvitatiRiunionePersistence.class)
	protected InvitatiRiunionePersistence invitatiRiunionePersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.LuogoLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.LuogoLocalService luogoLocalService;
	@BeanReference(type = LuogoPersistence.class)
	protected LuogoPersistence luogoPersistence;
	@BeanReference(type = LuogoFinder.class)
	protected LuogoFinder luogoFinder;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.RiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.RiunioneLocalService riunioneLocalService;
	@BeanReference(type = RiunionePersistence.class)
	protected RiunionePersistence riunionePersistence;
	@BeanReference(type = RiunioneFinder.class)
	protected RiunioneFinder riunioneFinder;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.SegreteriaLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.SegreteriaLocalService segreteriaLocalService;
	@BeanReference(type = SegreteriaPersistence.class)
	protected SegreteriaPersistence segreteriaPersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalService statoInvitatoLocalService;
	@BeanReference(type = StatoInvitatoPersistence.class)
	protected StatoInvitatoPersistence statoInvitatoPersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalService statoRiunioneLocalService;
	@BeanReference(type = StatoRiunionePersistence.class)
	protected StatoRiunionePersistence statoRiunionePersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalService storicoStatoRiunioneLocalService;
	@BeanReference(type = StoricoStatoRiunionePersistence.class)
	protected StoricoStatoRiunionePersistence storicoStatoRiunionePersistence;
	@BeanReference(type = com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalService.class)
	protected com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalService tipoRiunioneLocalService;
	@BeanReference(type = TipoRiunionePersistence.class)
	protected TipoRiunionePersistence tipoRiunionePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}