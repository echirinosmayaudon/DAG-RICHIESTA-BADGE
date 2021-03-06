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

import aQute.bnd.annotation.ProviderType;

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

import servizio.beni.facile.consumo.model.RigheRichiestaBFC;
import servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalService;
import servizio.beni.facile.consumo.service.persistence.CambioStatoDirigentePersistence;
import servizio.beni.facile.consumo.service.persistence.GestioneUtentiPersistence;
import servizio.beni.facile.consumo.service.persistence.PeriodicitaPersistence;
import servizio.beni.facile.consumo.service.persistence.RigheRichiestaBFCPersistence;
import servizio.beni.facile.consumo.service.persistence.ServizioMaterialePersistence;
import servizio.beni.facile.consumo.service.persistence.StatoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the righe richiesta b f c local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link servizio.beni.facile.consumo.service.impl.RigheRichiestaBFCLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.impl.RigheRichiestaBFCLocalServiceImpl
 * @see servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class RigheRichiestaBFCLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements RigheRichiestaBFCLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link servizio.beni.facile.consumo.service.RigheRichiestaBFCLocalServiceUtil} to access the righe richiesta b f c local service.
	 */

	/**
	 * Adds the righe richiesta b f c to the database. Also notifies the appropriate model listeners.
	 *
	 * @param righeRichiestaBFC the righe richiesta b f c
	 * @return the righe richiesta b f c that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RigheRichiestaBFC addRigheRichiestaBFC(
		RigheRichiestaBFC righeRichiestaBFC) {
		righeRichiestaBFC.setNew(true);

		return righeRichiestaBFCPersistence.update(righeRichiestaBFC);
	}

	/**
	 * Creates a new righe richiesta b f c with the primary key. Does not add the righe richiesta b f c to the database.
	 *
	 * @param id the primary key for the new righe richiesta b f c
	 * @return the new righe richiesta b f c
	 */
	@Override
	public RigheRichiestaBFC createRigheRichiestaBFC(long id) {
		return righeRichiestaBFCPersistence.create(id);
	}

	/**
	 * Deletes the righe richiesta b f c with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the righe richiesta b f c
	 * @return the righe richiesta b f c that was removed
	 * @throws PortalException if a righe richiesta b f c with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RigheRichiestaBFC deleteRigheRichiestaBFC(long id)
		throws PortalException {
		return righeRichiestaBFCPersistence.remove(id);
	}

	/**
	 * Deletes the righe richiesta b f c from the database. Also notifies the appropriate model listeners.
	 *
	 * @param righeRichiestaBFC the righe richiesta b f c
	 * @return the righe richiesta b f c that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RigheRichiestaBFC deleteRigheRichiestaBFC(
		RigheRichiestaBFC righeRichiestaBFC) {
		return righeRichiestaBFCPersistence.remove(righeRichiestaBFC);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(RigheRichiestaBFC.class,
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
		return righeRichiestaBFCPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return righeRichiestaBFCPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return righeRichiestaBFCPersistence.findWithDynamicQuery(dynamicQuery,
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
		return righeRichiestaBFCPersistence.countWithDynamicQuery(dynamicQuery);
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
		return righeRichiestaBFCPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public RigheRichiestaBFC fetchRigheRichiestaBFC(long id) {
		return righeRichiestaBFCPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the righe richiesta b f c with the primary key.
	 *
	 * @param id the primary key of the righe richiesta b f c
	 * @return the righe richiesta b f c
	 * @throws PortalException if a righe richiesta b f c with the primary key could not be found
	 */
	@Override
	public RigheRichiestaBFC getRigheRichiestaBFC(long id)
		throws PortalException {
		return righeRichiestaBFCPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(righeRichiestaBFCLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RigheRichiestaBFC.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(righeRichiestaBFCLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(RigheRichiestaBFC.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(righeRichiestaBFCLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RigheRichiestaBFC.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return righeRichiestaBFCLocalService.deleteRigheRichiestaBFC((RigheRichiestaBFC)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return righeRichiestaBFCPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the righe richiesta b f cs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe richiesta b f cs
	 * @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	 * @return the range of righe richiesta b f cs
	 */
	@Override
	public List<RigheRichiestaBFC> getRigheRichiestaBFCs(int start, int end) {
		return righeRichiestaBFCPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of righe richiesta b f cs.
	 *
	 * @return the number of righe richiesta b f cs
	 */
	@Override
	public int getRigheRichiestaBFCsCount() {
		return righeRichiestaBFCPersistence.countAll();
	}

	/**
	 * Updates the righe richiesta b f c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param righeRichiestaBFC the righe richiesta b f c
	 * @return the righe richiesta b f c that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RigheRichiestaBFC updateRigheRichiestaBFC(
		RigheRichiestaBFC righeRichiestaBFC) {
		return righeRichiestaBFCPersistence.update(righeRichiestaBFC);
	}

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
	public RigheRichiestaBFCLocalService getRigheRichiestaBFCLocalService() {
		return righeRichiestaBFCLocalService;
	}

	/**
	 * Sets the righe richiesta b f c local service.
	 *
	 * @param righeRichiestaBFCLocalService the righe richiesta b f c local service
	 */
	public void setRigheRichiestaBFCLocalService(
		RigheRichiestaBFCLocalService righeRichiestaBFCLocalService) {
		this.righeRichiestaBFCLocalService = righeRichiestaBFCLocalService;
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
		persistedModelLocalServiceRegistry.register("servizio.beni.facile.consumo.model.RigheRichiestaBFC",
			righeRichiestaBFCLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"servizio.beni.facile.consumo.model.RigheRichiestaBFC");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return RigheRichiestaBFCLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return RigheRichiestaBFC.class;
	}

	protected String getModelClassName() {
		return RigheRichiestaBFC.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = righeRichiestaBFCPersistence.getDataSource();

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
	@BeanReference(type = CambioStatoDirigentePersistence.class)
	protected CambioStatoDirigentePersistence cambioStatoDirigentePersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.GestioneUtentiLocalService.class)
	protected servizio.beni.facile.consumo.service.GestioneUtentiLocalService gestioneUtentiLocalService;
	@BeanReference(type = GestioneUtentiPersistence.class)
	protected GestioneUtentiPersistence gestioneUtentiPersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.PeriodicitaLocalService.class)
	protected servizio.beni.facile.consumo.service.PeriodicitaLocalService periodicitaLocalService;
	@BeanReference(type = PeriodicitaPersistence.class)
	protected PeriodicitaPersistence periodicitaPersistence;
	@BeanReference(type = RigheRichiestaBFCLocalService.class)
	protected RigheRichiestaBFCLocalService righeRichiestaBFCLocalService;
	@BeanReference(type = RigheRichiestaBFCPersistence.class)
	protected RigheRichiestaBFCPersistence righeRichiestaBFCPersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.ServizioMaterialeLocalService.class)
	protected servizio.beni.facile.consumo.service.ServizioMaterialeLocalService servizioMaterialeLocalService;
	@BeanReference(type = ServizioMaterialePersistence.class)
	protected ServizioMaterialePersistence servizioMaterialePersistence;
	@BeanReference(type = servizio.beni.facile.consumo.service.StatoLocalService.class)
	protected servizio.beni.facile.consumo.service.StatoLocalService statoLocalService;
	@BeanReference(type = StatoPersistence.class)
	protected StatoPersistence statoPersistence;
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