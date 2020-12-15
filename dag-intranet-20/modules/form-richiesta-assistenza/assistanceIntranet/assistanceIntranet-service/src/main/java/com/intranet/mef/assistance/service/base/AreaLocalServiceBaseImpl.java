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

package com.intranet.mef.assistance.service.base;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Area;
import com.intranet.mef.assistance.service.AreaLocalService;
import com.intranet.mef.assistance.service.persistence.AmbitoPersistence;
import com.intranet.mef.assistance.service.persistence.AreaPersistence;
import com.intranet.mef.assistance.service.persistence.FaqPersistence;
import com.intranet.mef.assistance.service.persistence.ProblemPersistence;
import com.intranet.mef.assistance.service.persistence.ServizioPersistence;
import com.intranet.mef.assistance.service.persistence.TopicPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
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
 * Provides the base implementation for the area local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.intranet.mef.assistance.service.impl.AreaLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.assistance.service.impl.AreaLocalServiceImpl
 * @see com.intranet.mef.assistance.service.AreaLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AreaLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements AreaLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.intranet.mef.assistance.service.AreaLocalServiceUtil} to access the area local service.
	 */

	/**
	 * Adds the area to the database. Also notifies the appropriate model listeners.
	 *
	 * @param area the area
	 * @return the area that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Area addArea(Area area) {
		area.setNew(true);

		return areaPersistence.update(area);
	}

	/**
	 * Creates a new area with the primary key. Does not add the area to the database.
	 *
	 * @param areaId the primary key for the new area
	 * @return the new area
	 */
	@Override
	public Area createArea(String areaId) {
		return areaPersistence.create(areaId);
	}

	/**
	 * Deletes the area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param areaId the primary key of the area
	 * @return the area that was removed
	 * @throws PortalException if a area with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Area deleteArea(String areaId) throws PortalException {
		return areaPersistence.remove(areaId);
	}

	/**
	 * Deletes the area from the database. Also notifies the appropriate model listeners.
	 *
	 * @param area the area
	 * @return the area that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Area deleteArea(Area area) {
		return areaPersistence.remove(area);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Area.class,
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
		return areaPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return areaPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return areaPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return areaPersistence.countWithDynamicQuery(dynamicQuery);
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
		return areaPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Area fetchArea(String areaId) {
		return areaPersistence.fetchByPrimaryKey(areaId);
	}

	/**
	 * Returns the area with the primary key.
	 *
	 * @param areaId the primary key of the area
	 * @return the area
	 * @throws PortalException if a area with the primary key could not be found
	 */
	@Override
	public Area getArea(String areaId) throws PortalException {
		return areaPersistence.findByPrimaryKey(areaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return areaLocalService.deleteArea((Area)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return areaPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of areas
	 */
	@Override
	public List<Area> getAreas(int start, int end) {
		return areaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of areas.
	 *
	 * @return the number of areas
	 */
	@Override
	public int getAreasCount() {
		return areaPersistence.countAll();
	}

	/**
	 * Updates the area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param area the area
	 * @return the area that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Area updateArea(Area area) {
		return areaPersistence.update(area);
	}

	/**
	 * Returns the ambito local service.
	 *
	 * @return the ambito local service
	 */
	public com.intranet.mef.assistance.service.AmbitoLocalService getAmbitoLocalService() {
		return ambitoLocalService;
	}

	/**
	 * Sets the ambito local service.
	 *
	 * @param ambitoLocalService the ambito local service
	 */
	public void setAmbitoLocalService(
		com.intranet.mef.assistance.service.AmbitoLocalService ambitoLocalService) {
		this.ambitoLocalService = ambitoLocalService;
	}

	/**
	 * Returns the ambito persistence.
	 *
	 * @return the ambito persistence
	 */
	public AmbitoPersistence getAmbitoPersistence() {
		return ambitoPersistence;
	}

	/**
	 * Sets the ambito persistence.
	 *
	 * @param ambitoPersistence the ambito persistence
	 */
	public void setAmbitoPersistence(AmbitoPersistence ambitoPersistence) {
		this.ambitoPersistence = ambitoPersistence;
	}

	/**
	 * Returns the area local service.
	 *
	 * @return the area local service
	 */
	public AreaLocalService getAreaLocalService() {
		return areaLocalService;
	}

	/**
	 * Sets the area local service.
	 *
	 * @param areaLocalService the area local service
	 */
	public void setAreaLocalService(AreaLocalService areaLocalService) {
		this.areaLocalService = areaLocalService;
	}

	/**
	 * Returns the area persistence.
	 *
	 * @return the area persistence
	 */
	public AreaPersistence getAreaPersistence() {
		return areaPersistence;
	}

	/**
	 * Sets the area persistence.
	 *
	 * @param areaPersistence the area persistence
	 */
	public void setAreaPersistence(AreaPersistence areaPersistence) {
		this.areaPersistence = areaPersistence;
	}

	/**
	 * Returns the assistance helper local service.
	 *
	 * @return the assistance helper local service
	 */
	public com.intranet.mef.assistance.service.AssistanceHelperLocalService getAssistanceHelperLocalService() {
		return assistanceHelperLocalService;
	}

	/**
	 * Sets the assistance helper local service.
	 *
	 * @param assistanceHelperLocalService the assistance helper local service
	 */
	public void setAssistanceHelperLocalService(
		com.intranet.mef.assistance.service.AssistanceHelperLocalService assistanceHelperLocalService) {
		this.assistanceHelperLocalService = assistanceHelperLocalService;
	}

	/**
	 * Returns the faq local service.
	 *
	 * @return the faq local service
	 */
	public com.intranet.mef.assistance.service.FaqLocalService getFaqLocalService() {
		return faqLocalService;
	}

	/**
	 * Sets the faq local service.
	 *
	 * @param faqLocalService the faq local service
	 */
	public void setFaqLocalService(
		com.intranet.mef.assistance.service.FaqLocalService faqLocalService) {
		this.faqLocalService = faqLocalService;
	}

	/**
	 * Returns the faq persistence.
	 *
	 * @return the faq persistence
	 */
	public FaqPersistence getFaqPersistence() {
		return faqPersistence;
	}

	/**
	 * Sets the faq persistence.
	 *
	 * @param faqPersistence the faq persistence
	 */
	public void setFaqPersistence(FaqPersistence faqPersistence) {
		this.faqPersistence = faqPersistence;
	}

	/**
	 * Returns the problem local service.
	 *
	 * @return the problem local service
	 */
	public com.intranet.mef.assistance.service.ProblemLocalService getProblemLocalService() {
		return problemLocalService;
	}

	/**
	 * Sets the problem local service.
	 *
	 * @param problemLocalService the problem local service
	 */
	public void setProblemLocalService(
		com.intranet.mef.assistance.service.ProblemLocalService problemLocalService) {
		this.problemLocalService = problemLocalService;
	}

	/**
	 * Returns the problem persistence.
	 *
	 * @return the problem persistence
	 */
	public ProblemPersistence getProblemPersistence() {
		return problemPersistence;
	}

	/**
	 * Sets the problem persistence.
	 *
	 * @param problemPersistence the problem persistence
	 */
	public void setProblemPersistence(ProblemPersistence problemPersistence) {
		this.problemPersistence = problemPersistence;
	}

	/**
	 * Returns the servizio local service.
	 *
	 * @return the servizio local service
	 */
	public com.intranet.mef.assistance.service.ServizioLocalService getServizioLocalService() {
		return servizioLocalService;
	}

	/**
	 * Sets the servizio local service.
	 *
	 * @param servizioLocalService the servizio local service
	 */
	public void setServizioLocalService(
		com.intranet.mef.assistance.service.ServizioLocalService servizioLocalService) {
		this.servizioLocalService = servizioLocalService;
	}

	/**
	 * Returns the servizio persistence.
	 *
	 * @return the servizio persistence
	 */
	public ServizioPersistence getServizioPersistence() {
		return servizioPersistence;
	}

	/**
	 * Sets the servizio persistence.
	 *
	 * @param servizioPersistence the servizio persistence
	 */
	public void setServizioPersistence(ServizioPersistence servizioPersistence) {
		this.servizioPersistence = servizioPersistence;
	}

	/**
	 * Returns the topic local service.
	 *
	 * @return the topic local service
	 */
	public com.intranet.mef.assistance.service.TopicLocalService getTopicLocalService() {
		return topicLocalService;
	}

	/**
	 * Sets the topic local service.
	 *
	 * @param topicLocalService the topic local service
	 */
	public void setTopicLocalService(
		com.intranet.mef.assistance.service.TopicLocalService topicLocalService) {
		this.topicLocalService = topicLocalService;
	}

	/**
	 * Returns the topic persistence.
	 *
	 * @return the topic persistence
	 */
	public TopicPersistence getTopicPersistence() {
		return topicPersistence;
	}

	/**
	 * Sets the topic persistence.
	 *
	 * @param topicPersistence the topic persistence
	 */
	public void setTopicPersistence(TopicPersistence topicPersistence) {
		this.topicPersistence = topicPersistence;
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
		persistedModelLocalServiceRegistry.register("com.intranet.mef.assistance.model.Area",
			areaLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.intranet.mef.assistance.model.Area");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AreaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Area.class;
	}

	protected String getModelClassName() {
		return Area.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = areaPersistence.getDataSource();

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

	@BeanReference(type = com.intranet.mef.assistance.service.AmbitoLocalService.class)
	protected com.intranet.mef.assistance.service.AmbitoLocalService ambitoLocalService;
	@BeanReference(type = AmbitoPersistence.class)
	protected AmbitoPersistence ambitoPersistence;
	@BeanReference(type = AreaLocalService.class)
	protected AreaLocalService areaLocalService;
	@BeanReference(type = AreaPersistence.class)
	protected AreaPersistence areaPersistence;
	@BeanReference(type = com.intranet.mef.assistance.service.AssistanceHelperLocalService.class)
	protected com.intranet.mef.assistance.service.AssistanceHelperLocalService assistanceHelperLocalService;
	@BeanReference(type = com.intranet.mef.assistance.service.FaqLocalService.class)
	protected com.intranet.mef.assistance.service.FaqLocalService faqLocalService;
	@BeanReference(type = FaqPersistence.class)
	protected FaqPersistence faqPersistence;
	@BeanReference(type = com.intranet.mef.assistance.service.ProblemLocalService.class)
	protected com.intranet.mef.assistance.service.ProblemLocalService problemLocalService;
	@BeanReference(type = ProblemPersistence.class)
	protected ProblemPersistence problemPersistence;
	@BeanReference(type = com.intranet.mef.assistance.service.ServizioLocalService.class)
	protected com.intranet.mef.assistance.service.ServizioLocalService servizioLocalService;
	@BeanReference(type = ServizioPersistence.class)
	protected ServizioPersistence servizioPersistence;
	@BeanReference(type = com.intranet.mef.assistance.service.TopicLocalService.class)
	protected com.intranet.mef.assistance.service.TopicLocalService topicLocalService;
	@BeanReference(type = TopicPersistence.class)
	protected TopicPersistence topicPersistence;
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