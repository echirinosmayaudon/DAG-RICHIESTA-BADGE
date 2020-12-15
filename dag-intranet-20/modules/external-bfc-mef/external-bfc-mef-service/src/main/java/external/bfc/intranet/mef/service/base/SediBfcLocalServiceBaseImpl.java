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

package external.bfc.intranet.mef.service.base;

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

import external.bfc.intranet.mef.model.SediBfc;
import external.bfc.intranet.mef.service.SediBfcLocalService;
import external.bfc.intranet.mef.service.persistence.RichiesteFinder;
import external.bfc.intranet.mef.service.persistence.RichiesteInfoFinder;
import external.bfc.intranet.mef.service.persistence.RichiesteInfoPersistence;
import external.bfc.intranet.mef.service.persistence.RichiestePersistence;
import external.bfc.intranet.mef.service.persistence.RichiesteSequencePersistence;
import external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPersistence;
import external.bfc.intranet.mef.service.persistence.RigheRichiestePersistence;
import external.bfc.intranet.mef.service.persistence.SediBfcFinder;
import external.bfc.intranet.mef.service.persistence.SediBfcPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the sedi bfc local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link external.bfc.intranet.mef.service.impl.SediBfcLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.impl.SediBfcLocalServiceImpl
 * @see external.bfc.intranet.mef.service.SediBfcLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class SediBfcLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements SediBfcLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link external.bfc.intranet.mef.service.SediBfcLocalServiceUtil} to access the sedi bfc local service.
	 */

	/**
	 * Adds the sedi bfc to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sediBfc the sedi bfc
	 * @return the sedi bfc that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SediBfc addSediBfc(SediBfc sediBfc) {
		sediBfc.setNew(true);

		return sediBfcPersistence.update(sediBfc);
	}

	/**
	 * Creates a new sedi bfc with the primary key. Does not add the sedi bfc to the database.
	 *
	 * @param id the primary key for the new sedi bfc
	 * @return the new sedi bfc
	 */
	@Override
	public SediBfc createSediBfc(long id) {
		return sediBfcPersistence.create(id);
	}

	/**
	 * Deletes the sedi bfc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sedi bfc
	 * @return the sedi bfc that was removed
	 * @throws PortalException if a sedi bfc with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SediBfc deleteSediBfc(long id) throws PortalException {
		return sediBfcPersistence.remove(id);
	}

	/**
	 * Deletes the sedi bfc from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sediBfc the sedi bfc
	 * @return the sedi bfc that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SediBfc deleteSediBfc(SediBfc sediBfc) {
		return sediBfcPersistence.remove(sediBfc);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SediBfc.class,
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
		return sediBfcPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return sediBfcPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return sediBfcPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return sediBfcPersistence.countWithDynamicQuery(dynamicQuery);
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
		return sediBfcPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public SediBfc fetchSediBfc(long id) {
		return sediBfcPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the sedi bfc with the primary key.
	 *
	 * @param id the primary key of the sedi bfc
	 * @return the sedi bfc
	 * @throws PortalException if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc getSediBfc(long id) throws PortalException {
		return sediBfcPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(sediBfcLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SediBfc.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(sediBfcLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(SediBfc.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(sediBfcLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SediBfc.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return sediBfcLocalService.deleteSediBfc((SediBfc)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return sediBfcPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the sedi bfcs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @return the range of sedi bfcs
	 */
	@Override
	public List<SediBfc> getSediBfcs(int start, int end) {
		return sediBfcPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sedi bfcs.
	 *
	 * @return the number of sedi bfcs
	 */
	@Override
	public int getSediBfcsCount() {
		return sediBfcPersistence.countAll();
	}

	/**
	 * Updates the sedi bfc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sediBfc the sedi bfc
	 * @return the sedi bfc that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SediBfc updateSediBfc(SediBfc sediBfc) {
		return sediBfcPersistence.update(sediBfc);
	}

	/**
	 * Returns the richieste local service.
	 *
	 * @return the richieste local service
	 */
	public external.bfc.intranet.mef.service.RichiesteLocalService getRichiesteLocalService() {
		return richiesteLocalService;
	}

	/**
	 * Sets the richieste local service.
	 *
	 * @param richiesteLocalService the richieste local service
	 */
	public void setRichiesteLocalService(
		external.bfc.intranet.mef.service.RichiesteLocalService richiesteLocalService) {
		this.richiesteLocalService = richiesteLocalService;
	}

	/**
	 * Returns the richieste persistence.
	 *
	 * @return the richieste persistence
	 */
	public RichiestePersistence getRichiestePersistence() {
		return richiestePersistence;
	}

	/**
	 * Sets the richieste persistence.
	 *
	 * @param richiestePersistence the richieste persistence
	 */
	public void setRichiestePersistence(
		RichiestePersistence richiestePersistence) {
		this.richiestePersistence = richiestePersistence;
	}

	/**
	 * Returns the richieste finder.
	 *
	 * @return the richieste finder
	 */
	public RichiesteFinder getRichiesteFinder() {
		return richiesteFinder;
	}

	/**
	 * Sets the richieste finder.
	 *
	 * @param richiesteFinder the richieste finder
	 */
	public void setRichiesteFinder(RichiesteFinder richiesteFinder) {
		this.richiesteFinder = richiesteFinder;
	}

	/**
	 * Returns the richieste info local service.
	 *
	 * @return the richieste info local service
	 */
	public external.bfc.intranet.mef.service.RichiesteInfoLocalService getRichiesteInfoLocalService() {
		return richiesteInfoLocalService;
	}

	/**
	 * Sets the richieste info local service.
	 *
	 * @param richiesteInfoLocalService the richieste info local service
	 */
	public void setRichiesteInfoLocalService(
		external.bfc.intranet.mef.service.RichiesteInfoLocalService richiesteInfoLocalService) {
		this.richiesteInfoLocalService = richiesteInfoLocalService;
	}

	/**
	 * Returns the richieste info persistence.
	 *
	 * @return the richieste info persistence
	 */
	public RichiesteInfoPersistence getRichiesteInfoPersistence() {
		return richiesteInfoPersistence;
	}

	/**
	 * Sets the richieste info persistence.
	 *
	 * @param richiesteInfoPersistence the richieste info persistence
	 */
	public void setRichiesteInfoPersistence(
		RichiesteInfoPersistence richiesteInfoPersistence) {
		this.richiesteInfoPersistence = richiesteInfoPersistence;
	}

	/**
	 * Returns the richieste info finder.
	 *
	 * @return the richieste info finder
	 */
	public RichiesteInfoFinder getRichiesteInfoFinder() {
		return richiesteInfoFinder;
	}

	/**
	 * Sets the richieste info finder.
	 *
	 * @param richiesteInfoFinder the richieste info finder
	 */
	public void setRichiesteInfoFinder(RichiesteInfoFinder richiesteInfoFinder) {
		this.richiesteInfoFinder = richiesteInfoFinder;
	}

	/**
	 * Returns the richieste sequence local service.
	 *
	 * @return the richieste sequence local service
	 */
	public external.bfc.intranet.mef.service.RichiesteSequenceLocalService getRichiesteSequenceLocalService() {
		return richiesteSequenceLocalService;
	}

	/**
	 * Sets the richieste sequence local service.
	 *
	 * @param richiesteSequenceLocalService the richieste sequence local service
	 */
	public void setRichiesteSequenceLocalService(
		external.bfc.intranet.mef.service.RichiesteSequenceLocalService richiesteSequenceLocalService) {
		this.richiesteSequenceLocalService = richiesteSequenceLocalService;
	}

	/**
	 * Returns the richieste sequence persistence.
	 *
	 * @return the richieste sequence persistence
	 */
	public RichiesteSequencePersistence getRichiesteSequencePersistence() {
		return richiesteSequencePersistence;
	}

	/**
	 * Sets the richieste sequence persistence.
	 *
	 * @param richiesteSequencePersistence the richieste sequence persistence
	 */
	public void setRichiesteSequencePersistence(
		RichiesteSequencePersistence richiesteSequencePersistence) {
		this.richiesteSequencePersistence = richiesteSequencePersistence;
	}

	/**
	 * Returns the righe richieste local service.
	 *
	 * @return the righe richieste local service
	 */
	public external.bfc.intranet.mef.service.RigheRichiesteLocalService getRigheRichiesteLocalService() {
		return righeRichiesteLocalService;
	}

	/**
	 * Sets the righe richieste local service.
	 *
	 * @param righeRichiesteLocalService the righe richieste local service
	 */
	public void setRigheRichiesteLocalService(
		external.bfc.intranet.mef.service.RigheRichiesteLocalService righeRichiesteLocalService) {
		this.righeRichiesteLocalService = righeRichiesteLocalService;
	}

	/**
	 * Returns the righe richieste persistence.
	 *
	 * @return the righe richieste persistence
	 */
	public RigheRichiestePersistence getRigheRichiestePersistence() {
		return righeRichiestePersistence;
	}

	/**
	 * Sets the righe richieste persistence.
	 *
	 * @param righeRichiestePersistence the righe richieste persistence
	 */
	public void setRigheRichiestePersistence(
		RigheRichiestePersistence righeRichiestePersistence) {
		this.righeRichiestePersistence = righeRichiestePersistence;
	}

	/**
	 * Returns the righe richieste info local service.
	 *
	 * @return the righe richieste info local service
	 */
	public external.bfc.intranet.mef.service.RigheRichiesteInfoLocalService getRigheRichiesteInfoLocalService() {
		return righeRichiesteInfoLocalService;
	}

	/**
	 * Sets the righe richieste info local service.
	 *
	 * @param righeRichiesteInfoLocalService the righe richieste info local service
	 */
	public void setRigheRichiesteInfoLocalService(
		external.bfc.intranet.mef.service.RigheRichiesteInfoLocalService righeRichiesteInfoLocalService) {
		this.righeRichiesteInfoLocalService = righeRichiesteInfoLocalService;
	}

	/**
	 * Returns the righe richieste info persistence.
	 *
	 * @return the righe richieste info persistence
	 */
	public RigheRichiesteInfoPersistence getRigheRichiesteInfoPersistence() {
		return righeRichiesteInfoPersistence;
	}

	/**
	 * Sets the righe richieste info persistence.
	 *
	 * @param righeRichiesteInfoPersistence the righe richieste info persistence
	 */
	public void setRigheRichiesteInfoPersistence(
		RigheRichiesteInfoPersistence righeRichiesteInfoPersistence) {
		this.righeRichiesteInfoPersistence = righeRichiesteInfoPersistence;
	}

	/**
	 * Returns the sedi bfc local service.
	 *
	 * @return the sedi bfc local service
	 */
	public SediBfcLocalService getSediBfcLocalService() {
		return sediBfcLocalService;
	}

	/**
	 * Sets the sedi bfc local service.
	 *
	 * @param sediBfcLocalService the sedi bfc local service
	 */
	public void setSediBfcLocalService(SediBfcLocalService sediBfcLocalService) {
		this.sediBfcLocalService = sediBfcLocalService;
	}

	/**
	 * Returns the sedi bfc persistence.
	 *
	 * @return the sedi bfc persistence
	 */
	public SediBfcPersistence getSediBfcPersistence() {
		return sediBfcPersistence;
	}

	/**
	 * Sets the sedi bfc persistence.
	 *
	 * @param sediBfcPersistence the sedi bfc persistence
	 */
	public void setSediBfcPersistence(SediBfcPersistence sediBfcPersistence) {
		this.sediBfcPersistence = sediBfcPersistence;
	}

	/**
	 * Returns the sedi bfc finder.
	 *
	 * @return the sedi bfc finder
	 */
	public SediBfcFinder getSediBfcFinder() {
		return sediBfcFinder;
	}

	/**
	 * Sets the sedi bfc finder.
	 *
	 * @param sediBfcFinder the sedi bfc finder
	 */
	public void setSediBfcFinder(SediBfcFinder sediBfcFinder) {
		this.sediBfcFinder = sediBfcFinder;
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
		persistedModelLocalServiceRegistry.register("external.bfc.intranet.mef.model.SediBfc",
			sediBfcLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"external.bfc.intranet.mef.model.SediBfc");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SediBfcLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SediBfc.class;
	}

	protected String getModelClassName() {
		return SediBfc.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = sediBfcPersistence.getDataSource();

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

	@BeanReference(type = external.bfc.intranet.mef.service.RichiesteLocalService.class)
	protected external.bfc.intranet.mef.service.RichiesteLocalService richiesteLocalService;
	@BeanReference(type = RichiestePersistence.class)
	protected RichiestePersistence richiestePersistence;
	@BeanReference(type = RichiesteFinder.class)
	protected RichiesteFinder richiesteFinder;
	@BeanReference(type = external.bfc.intranet.mef.service.RichiesteInfoLocalService.class)
	protected external.bfc.intranet.mef.service.RichiesteInfoLocalService richiesteInfoLocalService;
	@BeanReference(type = RichiesteInfoPersistence.class)
	protected RichiesteInfoPersistence richiesteInfoPersistence;
	@BeanReference(type = RichiesteInfoFinder.class)
	protected RichiesteInfoFinder richiesteInfoFinder;
	@BeanReference(type = external.bfc.intranet.mef.service.RichiesteSequenceLocalService.class)
	protected external.bfc.intranet.mef.service.RichiesteSequenceLocalService richiesteSequenceLocalService;
	@BeanReference(type = RichiesteSequencePersistence.class)
	protected RichiesteSequencePersistence richiesteSequencePersistence;
	@BeanReference(type = external.bfc.intranet.mef.service.RigheRichiesteLocalService.class)
	protected external.bfc.intranet.mef.service.RigheRichiesteLocalService righeRichiesteLocalService;
	@BeanReference(type = RigheRichiestePersistence.class)
	protected RigheRichiestePersistence righeRichiestePersistence;
	@BeanReference(type = external.bfc.intranet.mef.service.RigheRichiesteInfoLocalService.class)
	protected external.bfc.intranet.mef.service.RigheRichiesteInfoLocalService righeRichiesteInfoLocalService;
	@BeanReference(type = RigheRichiesteInfoPersistence.class)
	protected RigheRichiesteInfoPersistence righeRichiesteInfoPersistence;
	@BeanReference(type = SediBfcLocalService.class)
	protected SediBfcLocalService sediBfcLocalService;
	@BeanReference(type = SediBfcPersistence.class)
	protected SediBfcPersistence sediBfcPersistence;
	@BeanReference(type = SediBfcFinder.class)
	protected SediBfcFinder sediBfcFinder;
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