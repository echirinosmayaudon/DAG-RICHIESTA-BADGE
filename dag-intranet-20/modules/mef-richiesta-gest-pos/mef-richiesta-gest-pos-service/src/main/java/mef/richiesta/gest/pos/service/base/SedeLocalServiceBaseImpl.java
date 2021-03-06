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

package mef.richiesta.gest.pos.service.base;

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
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import mef.richiesta.gest.pos.model.Sede;
import mef.richiesta.gest.pos.service.SedeLocalService;
import mef.richiesta.gest.pos.service.persistence.CorridoioPersistence;
import mef.richiesta.gest.pos.service.persistence.FuoriPortaPersistence;
import mef.richiesta.gest.pos.service.persistence.PianoPersistence;
import mef.richiesta.gest.pos.service.persistence.SedePersistence;

/**
 * Provides the base implementation for the sede local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link mef.richiesta.gest.pos.service.impl.SedeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see mef.richiesta.gest.pos.service.impl.SedeLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class SedeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements SedeLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SedeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>mef.richiesta.gest.pos.service.SedeLocalServiceUtil</code>.
	 */

	/**
	 * Adds the sede to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sede the sede
	 * @return the sede that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Sede addSede(Sede sede) {
		sede.setNew(true);

		return sedePersistence.update(sede);
	}

	/**
	 * Creates a new sede with the primary key. Does not add the sede to the database.
	 *
	 * @param id_pk_sede the primary key for the new sede
	 * @return the new sede
	 */
	@Override
	@Transactional(enabled = false)
	public Sede createSede(long id_pk_sede) {
		return sedePersistence.create(id_pk_sede);
	}

	/**
	 * Deletes the sede with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_sede the primary key of the sede
	 * @return the sede that was removed
	 * @throws PortalException if a sede with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Sede deleteSede(long id_pk_sede) throws PortalException {
		return sedePersistence.remove(id_pk_sede);
	}

	/**
	 * Deletes the sede from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sede the sede
	 * @return the sede that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Sede deleteSede(Sede sede) {
		return sedePersistence.remove(sede);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Sede.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return sedePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return sedePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return sedePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return sedePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return sedePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Sede fetchSede(long id_pk_sede) {
		return sedePersistence.fetchByPrimaryKey(id_pk_sede);
	}

	/**
	 * Returns the sede with the primary key.
	 *
	 * @param id_pk_sede the primary key of the sede
	 * @return the sede
	 * @throws PortalException if a sede with the primary key could not be found
	 */
	@Override
	public Sede getSede(long id_pk_sede) throws PortalException {
		return sedePersistence.findByPrimaryKey(id_pk_sede);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(sedeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Sede.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id_pk_sede");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(sedeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Sede.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id_pk_sede");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(sedeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Sede.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id_pk_sede");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return sedeLocalService.deleteSede((Sede)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return sedePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the sedes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedes
	 * @param end the upper bound of the range of sedes (not inclusive)
	 * @return the range of sedes
	 */
	@Override
	public List<Sede> getSedes(int start, int end) {
		return sedePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sedes.
	 *
	 * @return the number of sedes
	 */
	@Override
	public int getSedesCount() {
		return sedePersistence.countAll();
	}

	/**
	 * Updates the sede in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sede the sede
	 * @return the sede that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Sede updateSede(Sede sede) {
		return sedePersistence.update(sede);
	}

	/**
	 * Returns the corridoio local service.
	 *
	 * @return the corridoio local service
	 */
	public mef.richiesta.gest.pos.service.CorridoioLocalService
		getCorridoioLocalService() {

		return corridoioLocalService;
	}

	/**
	 * Sets the corridoio local service.
	 *
	 * @param corridoioLocalService the corridoio local service
	 */
	public void setCorridoioLocalService(
		mef.richiesta.gest.pos.service.CorridoioLocalService
			corridoioLocalService) {

		this.corridoioLocalService = corridoioLocalService;
	}

	/**
	 * Returns the corridoio persistence.
	 *
	 * @return the corridoio persistence
	 */
	public CorridoioPersistence getCorridoioPersistence() {
		return corridoioPersistence;
	}

	/**
	 * Sets the corridoio persistence.
	 *
	 * @param corridoioPersistence the corridoio persistence
	 */
	public void setCorridoioPersistence(
		CorridoioPersistence corridoioPersistence) {

		this.corridoioPersistence = corridoioPersistence;
	}

	/**
	 * Returns the fuori porta local service.
	 *
	 * @return the fuori porta local service
	 */
	public mef.richiesta.gest.pos.service.FuoriPortaLocalService
		getFuoriPortaLocalService() {

		return fuoriPortaLocalService;
	}

	/**
	 * Sets the fuori porta local service.
	 *
	 * @param fuoriPortaLocalService the fuori porta local service
	 */
	public void setFuoriPortaLocalService(
		mef.richiesta.gest.pos.service.FuoriPortaLocalService
			fuoriPortaLocalService) {

		this.fuoriPortaLocalService = fuoriPortaLocalService;
	}

	/**
	 * Returns the fuori porta persistence.
	 *
	 * @return the fuori porta persistence
	 */
	public FuoriPortaPersistence getFuoriPortaPersistence() {
		return fuoriPortaPersistence;
	}

	/**
	 * Sets the fuori porta persistence.
	 *
	 * @param fuoriPortaPersistence the fuori porta persistence
	 */
	public void setFuoriPortaPersistence(
		FuoriPortaPersistence fuoriPortaPersistence) {

		this.fuoriPortaPersistence = fuoriPortaPersistence;
	}

	/**
	 * Returns the piano local service.
	 *
	 * @return the piano local service
	 */
	public mef.richiesta.gest.pos.service.PianoLocalService
		getPianoLocalService() {

		return pianoLocalService;
	}

	/**
	 * Sets the piano local service.
	 *
	 * @param pianoLocalService the piano local service
	 */
	public void setPianoLocalService(
		mef.richiesta.gest.pos.service.PianoLocalService pianoLocalService) {

		this.pianoLocalService = pianoLocalService;
	}

	/**
	 * Returns the piano persistence.
	 *
	 * @return the piano persistence
	 */
	public PianoPersistence getPianoPersistence() {
		return pianoPersistence;
	}

	/**
	 * Sets the piano persistence.
	 *
	 * @param pianoPersistence the piano persistence
	 */
	public void setPianoPersistence(PianoPersistence pianoPersistence) {
		this.pianoPersistence = pianoPersistence;
	}

	/**
	 * Returns the sede local service.
	 *
	 * @return the sede local service
	 */
	public SedeLocalService getSedeLocalService() {
		return sedeLocalService;
	}

	/**
	 * Sets the sede local service.
	 *
	 * @param sedeLocalService the sede local service
	 */
	public void setSedeLocalService(SedeLocalService sedeLocalService) {
		this.sedeLocalService = sedeLocalService;
	}

	/**
	 * Returns the sede persistence.
	 *
	 * @return the sede persistence
	 */
	public SedePersistence getSedePersistence() {
		return sedePersistence;
	}

	/**
	 * Sets the sede persistence.
	 *
	 * @param sedePersistence the sede persistence
	 */
	public void setSedePersistence(SedePersistence sedePersistence) {
		this.sedePersistence = sedePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

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
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

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
		persistedModelLocalServiceRegistry.register(
			"mef.richiesta.gest.pos.model.Sede", sedeLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"mef.richiesta.gest.pos.model.Sede");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SedeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Sede.class;
	}

	protected String getModelClassName() {
		return Sede.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = sedePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(
		type = mef.richiesta.gest.pos.service.CorridoioLocalService.class
	)
	protected mef.richiesta.gest.pos.service.CorridoioLocalService
		corridoioLocalService;

	@BeanReference(type = CorridoioPersistence.class)
	protected CorridoioPersistence corridoioPersistence;

	@BeanReference(
		type = mef.richiesta.gest.pos.service.FuoriPortaLocalService.class
	)
	protected mef.richiesta.gest.pos.service.FuoriPortaLocalService
		fuoriPortaLocalService;

	@BeanReference(type = FuoriPortaPersistence.class)
	protected FuoriPortaPersistence fuoriPortaPersistence;

	@BeanReference(
		type = mef.richiesta.gest.pos.service.PianoLocalService.class
	)
	protected mef.richiesta.gest.pos.service.PianoLocalService
		pianoLocalService;

	@BeanReference(type = PianoPersistence.class)
	protected PianoPersistence pianoPersistence;

	@BeanReference(type = SedeLocalService.class)
	protected SedeLocalService sedeLocalService;

	@BeanReference(type = SedePersistence.class)
	protected SedePersistence sedePersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}