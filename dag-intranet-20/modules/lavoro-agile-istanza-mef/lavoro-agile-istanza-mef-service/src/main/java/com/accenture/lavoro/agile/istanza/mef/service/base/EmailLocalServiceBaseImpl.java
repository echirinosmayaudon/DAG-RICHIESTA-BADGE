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

package com.accenture.lavoro.agile.istanza.mef.service.base;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.model.Email;
import com.accenture.lavoro.agile.istanza.mef.service.EmailLocalService;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.EmailPersistence;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.OpzioneRichPersistence;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.RichLavAgileFinder;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.RichLavAgilePersistence;

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

/**
 * Provides the base implementation for the email local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.accenture.lavoro.agile.istanza.mef.service.impl.EmailLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.lavoro.agile.istanza.mef.service.impl.EmailLocalServiceImpl
 * @see com.accenture.lavoro.agile.istanza.mef.service.EmailLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class EmailLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements EmailLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.accenture.lavoro.agile.istanza.mef.service.EmailLocalServiceUtil} to access the email local service.
	 */

	/**
	 * Adds the email to the database. Also notifies the appropriate model listeners.
	 *
	 * @param email the email
	 * @return the email that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Email addEmail(Email email) {
		email.setNew(true);

		return emailPersistence.update(email);
	}

	/**
	 * Creates a new email with the primary key. Does not add the email to the database.
	 *
	 * @param id the primary key for the new email
	 * @return the new email
	 */
	@Override
	@Transactional(enabled = false)
	public Email createEmail(long id) {
		return emailPersistence.create(id);
	}

	/**
	 * Deletes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email
	 * @return the email that was removed
	 * @throws PortalException if a email with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Email deleteEmail(long id) throws PortalException {
		return emailPersistence.remove(id);
	}

	/**
	 * Deletes the email from the database. Also notifies the appropriate model listeners.
	 *
	 * @param email the email
	 * @return the email that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Email deleteEmail(Email email) {
		return emailPersistence.remove(email);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Email.class,
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
		return emailPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return emailPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return emailPersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
		return emailPersistence.countWithDynamicQuery(dynamicQuery);
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
		return emailPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Email fetchEmail(long id) {
		return emailPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the email with the primary key.
	 *
	 * @param id the primary key of the email
	 * @return the email
	 * @throws PortalException if a email with the primary key could not be found
	 */
	@Override
	public Email getEmail(long id) throws PortalException {
		return emailPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(emailLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Email.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(emailLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Email.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(emailLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Email.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return emailLocalService.deleteEmail((Email)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return emailPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of emails
	 */
	@Override
	public List<Email> getEmails(int start, int end) {
		return emailPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of emails.
	 *
	 * @return the number of emails
	 */
	@Override
	public int getEmailsCount() {
		return emailPersistence.countAll();
	}

	/**
	 * Updates the email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param email the email
	 * @return the email that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Email updateEmail(Email email) {
		return emailPersistence.update(email);
	}

	/**
	 * Returns the email local service.
	 *
	 * @return the email local service
	 */
	public EmailLocalService getEmailLocalService() {
		return emailLocalService;
	}

	/**
	 * Sets the email local service.
	 *
	 * @param emailLocalService the email local service
	 */
	public void setEmailLocalService(EmailLocalService emailLocalService) {
		this.emailLocalService = emailLocalService;
	}

	/**
	 * Returns the email persistence.
	 *
	 * @return the email persistence
	 */
	public EmailPersistence getEmailPersistence() {
		return emailPersistence;
	}

	/**
	 * Sets the email persistence.
	 *
	 * @param emailPersistence the email persistence
	 */
	public void setEmailPersistence(EmailPersistence emailPersistence) {
		this.emailPersistence = emailPersistence;
	}

	/**
	 * Returns the opzione rich local service.
	 *
	 * @return the opzione rich local service
	 */
	public com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalService getOpzioneRichLocalService() {
		return opzioneRichLocalService;
	}

	/**
	 * Sets the opzione rich local service.
	 *
	 * @param opzioneRichLocalService the opzione rich local service
	 */
	public void setOpzioneRichLocalService(
		com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalService opzioneRichLocalService) {
		this.opzioneRichLocalService = opzioneRichLocalService;
	}

	/**
	 * Returns the opzione rich persistence.
	 *
	 * @return the opzione rich persistence
	 */
	public OpzioneRichPersistence getOpzioneRichPersistence() {
		return opzioneRichPersistence;
	}

	/**
	 * Sets the opzione rich persistence.
	 *
	 * @param opzioneRichPersistence the opzione rich persistence
	 */
	public void setOpzioneRichPersistence(
		OpzioneRichPersistence opzioneRichPersistence) {
		this.opzioneRichPersistence = opzioneRichPersistence;
	}

	/**
	 * Returns the rich lav agile local service.
	 *
	 * @return the rich lav agile local service
	 */
	public com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalService getRichLavAgileLocalService() {
		return richLavAgileLocalService;
	}

	/**
	 * Sets the rich lav agile local service.
	 *
	 * @param richLavAgileLocalService the rich lav agile local service
	 */
	public void setRichLavAgileLocalService(
		com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalService richLavAgileLocalService) {
		this.richLavAgileLocalService = richLavAgileLocalService;
	}

	/**
	 * Returns the rich lav agile persistence.
	 *
	 * @return the rich lav agile persistence
	 */
	public RichLavAgilePersistence getRichLavAgilePersistence() {
		return richLavAgilePersistence;
	}

	/**
	 * Sets the rich lav agile persistence.
	 *
	 * @param richLavAgilePersistence the rich lav agile persistence
	 */
	public void setRichLavAgilePersistence(
		RichLavAgilePersistence richLavAgilePersistence) {
		this.richLavAgilePersistence = richLavAgilePersistence;
	}

	/**
	 * Returns the rich lav agile finder.
	 *
	 * @return the rich lav agile finder
	 */
	public RichLavAgileFinder getRichLavAgileFinder() {
		return richLavAgileFinder;
	}

	/**
	 * Sets the rich lav agile finder.
	 *
	 * @param richLavAgileFinder the rich lav agile finder
	 */
	public void setRichLavAgileFinder(RichLavAgileFinder richLavAgileFinder) {
		this.richLavAgileFinder = richLavAgileFinder;
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
		persistedModelLocalServiceRegistry.register("com.accenture.lavoro.agile.istanza.mef.model.Email",
			emailLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.accenture.lavoro.agile.istanza.mef.model.Email");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmailLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Email.class;
	}

	protected String getModelClassName() {
		return Email.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = emailPersistence.getDataSource();

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

	@BeanReference(type = EmailLocalService.class)
	protected EmailLocalService emailLocalService;
	@BeanReference(type = EmailPersistence.class)
	protected EmailPersistence emailPersistence;
	@BeanReference(type = com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalService.class)
	protected com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalService opzioneRichLocalService;
	@BeanReference(type = OpzioneRichPersistence.class)
	protected OpzioneRichPersistence opzioneRichPersistence;
	@BeanReference(type = com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalService.class)
	protected com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalService richLavAgileLocalService;
	@BeanReference(type = RichLavAgilePersistence.class)
	protected RichLavAgilePersistence richLavAgilePersistence;
	@BeanReference(type = RichLavAgileFinder.class)
	protected RichLavAgileFinder richLavAgileFinder;
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