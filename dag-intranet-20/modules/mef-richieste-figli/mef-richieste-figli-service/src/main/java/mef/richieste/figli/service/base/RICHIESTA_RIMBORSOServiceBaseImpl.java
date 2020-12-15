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

package mef.richieste.figli.service.base;

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

import mef.richieste.figli.model.RICHIESTA_RIMBORSO;
import mef.richieste.figli.service.RICHIESTA_RIMBORSOService;
import mef.richieste.figli.service.persistence.RICHIESTA_RIMBORSOPersistence;

/**
 * Provides the base implementation for the richiesta_rimborso remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link mef.richieste.figli.service.impl.RICHIESTA_RIMBORSOServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see mef.richieste.figli.service.impl.RICHIESTA_RIMBORSOServiceImpl
 * @generated
 */
public abstract class RICHIESTA_RIMBORSOServiceBaseImpl
	extends BaseServiceImpl
	implements RICHIESTA_RIMBORSOService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>RICHIESTA_RIMBORSOService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>mef.richieste.figli.service.RICHIESTA_RIMBORSOServiceUtil</code>.
	 */

	/**
	 * Returns the richiesta_rimborso local service.
	 *
	 * @return the richiesta_rimborso local service
	 */
	public mef.richieste.figli.service.RICHIESTA_RIMBORSOLocalService
		getRICHIESTA_RIMBORSOLocalService() {

		return richiesta_rimborsoLocalService;
	}

	/**
	 * Sets the richiesta_rimborso local service.
	 *
	 * @param richiesta_rimborsoLocalService the richiesta_rimborso local service
	 */
	public void setRICHIESTA_RIMBORSOLocalService(
		mef.richieste.figli.service.RICHIESTA_RIMBORSOLocalService
			richiesta_rimborsoLocalService) {

		this.richiesta_rimborsoLocalService = richiesta_rimborsoLocalService;
	}

	/**
	 * Returns the richiesta_rimborso remote service.
	 *
	 * @return the richiesta_rimborso remote service
	 */
	public RICHIESTA_RIMBORSOService getRICHIESTA_RIMBORSOService() {
		return richiesta_rimborsoService;
	}

	/**
	 * Sets the richiesta_rimborso remote service.
	 *
	 * @param richiesta_rimborsoService the richiesta_rimborso remote service
	 */
	public void setRICHIESTA_RIMBORSOService(
		RICHIESTA_RIMBORSOService richiesta_rimborsoService) {

		this.richiesta_rimborsoService = richiesta_rimborsoService;
	}

	/**
	 * Returns the richiesta_rimborso persistence.
	 *
	 * @return the richiesta_rimborso persistence
	 */
	public RICHIESTA_RIMBORSOPersistence getRICHIESTA_RIMBORSOPersistence() {
		return richiesta_rimborsoPersistence;
	}

	/**
	 * Sets the richiesta_rimborso persistence.
	 *
	 * @param richiesta_rimborsoPersistence the richiesta_rimborso persistence
	 */
	public void setRICHIESTA_RIMBORSOPersistence(
		RICHIESTA_RIMBORSOPersistence richiesta_rimborsoPersistence) {

		this.richiesta_rimborsoPersistence = richiesta_rimborsoPersistence;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

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
		return RICHIESTA_RIMBORSOService.class.getName();
	}

	protected Class<?> getModelClass() {
		return RICHIESTA_RIMBORSO.class;
	}

	protected String getModelClassName() {
		return RICHIESTA_RIMBORSO.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				richiesta_rimborsoPersistence.getDataSource();

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
		type = mef.richieste.figli.service.RICHIESTA_RIMBORSOLocalService.class
	)
	protected mef.richieste.figli.service.RICHIESTA_RIMBORSOLocalService
		richiesta_rimborsoLocalService;

	@BeanReference(type = RICHIESTA_RIMBORSOService.class)
	protected RICHIESTA_RIMBORSOService richiesta_rimborsoService;

	@BeanReference(type = RICHIESTA_RIMBORSOPersistence.class)
	protected RICHIESTA_RIMBORSOPersistence richiesta_rimborsoPersistence;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

}