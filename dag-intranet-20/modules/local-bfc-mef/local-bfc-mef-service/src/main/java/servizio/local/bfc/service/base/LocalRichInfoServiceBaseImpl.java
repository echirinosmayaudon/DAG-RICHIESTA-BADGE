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

package servizio.local.bfc.service.base;

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

import servizio.local.bfc.model.LocalRichInfo;
import servizio.local.bfc.service.LocalRichInfoService;
import servizio.local.bfc.service.persistence.LocalRichFinder;
import servizio.local.bfc.service.persistence.LocalRichInfoFinder;
import servizio.local.bfc.service.persistence.LocalRichInfoPersistence;
import servizio.local.bfc.service.persistence.LocalRichPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the local rich info remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link servizio.local.bfc.service.impl.LocalRichInfoServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.local.bfc.service.impl.LocalRichInfoServiceImpl
 * @see servizio.local.bfc.service.LocalRichInfoServiceUtil
 * @generated
 */
public abstract class LocalRichInfoServiceBaseImpl extends BaseServiceImpl
	implements LocalRichInfoService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link servizio.local.bfc.service.LocalRichInfoServiceUtil} to access the local rich info remote service.
	 */

	/**
	 * Returns the local rich local service.
	 *
	 * @return the local rich local service
	 */
	public servizio.local.bfc.service.LocalRichLocalService getLocalRichLocalService() {
		return localRichLocalService;
	}

	/**
	 * Sets the local rich local service.
	 *
	 * @param localRichLocalService the local rich local service
	 */
	public void setLocalRichLocalService(
		servizio.local.bfc.service.LocalRichLocalService localRichLocalService) {
		this.localRichLocalService = localRichLocalService;
	}

	/**
	 * Returns the local rich remote service.
	 *
	 * @return the local rich remote service
	 */
	public servizio.local.bfc.service.LocalRichService getLocalRichService() {
		return localRichService;
	}

	/**
	 * Sets the local rich remote service.
	 *
	 * @param localRichService the local rich remote service
	 */
	public void setLocalRichService(
		servizio.local.bfc.service.LocalRichService localRichService) {
		this.localRichService = localRichService;
	}

	/**
	 * Returns the local rich persistence.
	 *
	 * @return the local rich persistence
	 */
	public LocalRichPersistence getLocalRichPersistence() {
		return localRichPersistence;
	}

	/**
	 * Sets the local rich persistence.
	 *
	 * @param localRichPersistence the local rich persistence
	 */
	public void setLocalRichPersistence(
		LocalRichPersistence localRichPersistence) {
		this.localRichPersistence = localRichPersistence;
	}

	/**
	 * Returns the local rich finder.
	 *
	 * @return the local rich finder
	 */
	public LocalRichFinder getLocalRichFinder() {
		return localRichFinder;
	}

	/**
	 * Sets the local rich finder.
	 *
	 * @param localRichFinder the local rich finder
	 */
	public void setLocalRichFinder(LocalRichFinder localRichFinder) {
		this.localRichFinder = localRichFinder;
	}

	/**
	 * Returns the local rich info local service.
	 *
	 * @return the local rich info local service
	 */
	public servizio.local.bfc.service.LocalRichInfoLocalService getLocalRichInfoLocalService() {
		return localRichInfoLocalService;
	}

	/**
	 * Sets the local rich info local service.
	 *
	 * @param localRichInfoLocalService the local rich info local service
	 */
	public void setLocalRichInfoLocalService(
		servizio.local.bfc.service.LocalRichInfoLocalService localRichInfoLocalService) {
		this.localRichInfoLocalService = localRichInfoLocalService;
	}

	/**
	 * Returns the local rich info remote service.
	 *
	 * @return the local rich info remote service
	 */
	public LocalRichInfoService getLocalRichInfoService() {
		return localRichInfoService;
	}

	/**
	 * Sets the local rich info remote service.
	 *
	 * @param localRichInfoService the local rich info remote service
	 */
	public void setLocalRichInfoService(
		LocalRichInfoService localRichInfoService) {
		this.localRichInfoService = localRichInfoService;
	}

	/**
	 * Returns the local rich info persistence.
	 *
	 * @return the local rich info persistence
	 */
	public LocalRichInfoPersistence getLocalRichInfoPersistence() {
		return localRichInfoPersistence;
	}

	/**
	 * Sets the local rich info persistence.
	 *
	 * @param localRichInfoPersistence the local rich info persistence
	 */
	public void setLocalRichInfoPersistence(
		LocalRichInfoPersistence localRichInfoPersistence) {
		this.localRichInfoPersistence = localRichInfoPersistence;
	}

	/**
	 * Returns the local rich info finder.
	 *
	 * @return the local rich info finder
	 */
	public LocalRichInfoFinder getLocalRichInfoFinder() {
		return localRichInfoFinder;
	}

	/**
	 * Sets the local rich info finder.
	 *
	 * @param localRichInfoFinder the local rich info finder
	 */
	public void setLocalRichInfoFinder(LocalRichInfoFinder localRichInfoFinder) {
		this.localRichInfoFinder = localRichInfoFinder;
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
		return LocalRichInfoService.class.getName();
	}

	protected Class<?> getModelClass() {
		return LocalRichInfo.class;
	}

	protected String getModelClassName() {
		return LocalRichInfo.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = localRichInfoPersistence.getDataSource();

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

	@BeanReference(type = servizio.local.bfc.service.LocalRichLocalService.class)
	protected servizio.local.bfc.service.LocalRichLocalService localRichLocalService;
	@BeanReference(type = servizio.local.bfc.service.LocalRichService.class)
	protected servizio.local.bfc.service.LocalRichService localRichService;
	@BeanReference(type = LocalRichPersistence.class)
	protected LocalRichPersistence localRichPersistence;
	@BeanReference(type = LocalRichFinder.class)
	protected LocalRichFinder localRichFinder;
	@BeanReference(type = servizio.local.bfc.service.LocalRichInfoLocalService.class)
	protected servizio.local.bfc.service.LocalRichInfoLocalService localRichInfoLocalService;
	@BeanReference(type = LocalRichInfoService.class)
	protected LocalRichInfoService localRichInfoService;
	@BeanReference(type = LocalRichInfoPersistence.class)
	protected LocalRichInfoPersistence localRichInfoPersistence;
	@BeanReference(type = LocalRichInfoFinder.class)
	protected LocalRichInfoFinder localRichInfoFinder;
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